package com.app.email;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDao;
import com.kodemore.email.KmEmail;
import com.kodemore.email.KmEmailIF;
import com.kodemore.email.KmEmailPart;
import com.kodemore.email.KmEmailResult;
import com.kodemore.email.method.KmEmailMethod;
import com.kodemore.email.method.KmEmailNoopMethod;
import com.kodemore.email.method.KmEmailPrintMethod;
import com.kodemore.hibernate.lock.KmhDaoLockException;
import com.kodemore.utility.Kmu;

import com.app.dao.core.MyDaoSession;
import com.app.filter.MyEmailFilter;
import com.app.finder.MyEmailFinder;
import com.app.model.MyEmail;
import com.app.model.MyEmailPart;
import com.app.model.MyEmailPartType;
import com.app.model.MyEmailStatus;
import com.app.property.MyPropertyRegistry;
import com.app.utility.MyGlobals;

/**
 * I send the email messages that are already queued in the
 * database email table.
 *
 * I should NOT be run inside an existing database transaction.
 * Although I do require database access, I manage this access
 * internally in order to "safely" coordinate transactions with
 * the external (non-transactional) smtp server.
 */
public class MyEmailSender
{
    //##################################################
    //# static
    //##################################################

    public static KmList<KmEmailResult> staticRunBatch()
    {
        MyEmailSender e;
        e = new MyEmailSender();
        e.runBatch();
        return e.getResults();
    }

    //##################################################
    //# variables
    //##################################################

    private KmList<MyEmail>       _emails;
    private KmList<KmEmailResult> _results;

    //##################################################
    //# constructor
    //##################################################

    public MyEmailSender()
    {
        _emails = new KmList<>();
        _results = new KmList<>();
    }

    //##################################################
    //# run
    //##################################################

    public void runBatch()
    {
        if ( !enabled() )
            return;

        if ( !prepareBatch() )
            return;

        send();
        updateResults();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmList<MyEmail> getEmails()
    {
        return _emails;
    }

    public KmList<KmEmailResult> getResults()
    {
        return _results;
    }

    //##################################################
    //# prepare
    //##################################################

    private boolean prepareBatch()
    {
        try
        {
            return KmDao.fetch(this::prepareBatchDao);
        }
        catch ( KmhDaoLockException ex )
        {
            return false;
        }
    }

    private boolean prepareBatchDao()
    {
        int count = getProperties().getSendEmailBatch();

        MyEmailFilter f;
        f = new MyEmailFilter();
        f.setStatusCode(MyEmailStatus.Ready);
        f.sortOnCreatedUtcTs();

        _emails = f.findFirst(count);

        for ( MyEmail e : _emails )
        {
            e.markPending();

            MyDaoSession session;
            session = MyGlobals.getDaoSession();
            session.fetch(e.getBaseRecipients());
            session.fetch(e.getBaseParts());
        }

        return _emails.isNotEmpty();
    }

    //##################################################
    //# send
    //##################################################

    private void send()
    {
        KmList<KmEmailIF> v = composeEmails();
        _results = getMethod().send(v);
    }

    private KmList<KmEmailIF> composeEmails()
    {
        KmList<KmEmailIF> v;
        v = new KmList<>();

        for ( MyEmail e : _emails )
            v.add(wrap(e));

        return v;
    }

    private KmEmailIF wrap(MyEmail myEmail)
    {
        KmEmail e;
        e = new KmEmail();
        e.setKey(myEmail.getUid());
        e.setSubject(myEmail.getSubject());
        e.setFrom(myEmail.getFromAddress());

        String overrideTo = getProperties().getSendEmailOverrideTo();
        if ( Kmu.hasValue(overrideTo) )
            e.addTo(overrideTo);
        else
        {
            e.addTos(myEmail.getToAddresses());
            e.addCcs(myEmail.getCcAddresses());
        }

        KmList<MyEmailPart> parts = myEmail.getSortedParts();
        for ( MyEmailPart myPart : parts )
        {
            KmEmailPart p = e.addPart();

            String name = myPart.getAttachmentName();
            byte[] value = myPart.getData().getValue();

            MyEmailPartType myType = myPart.getType();
            switch ( myType )
            {
                case Text:
                    p.setText(value);
                    break;

                case Html:
                    p.setHtml(value);
                    break;

                case Attachment:
                    p.setAttachment(name, value);
                    break;
            }
        }

        return e;
    }

    private KmEmailMethod getMethod()
    {
        String m = getProperties().getSendEmailMethod();
        if ( m == null )
            throw Kmu.newFatal("Property sendEmailMethod is null.");

        if ( m.equals("smtp") )
            return new MyEmailSmtpMethod();

        if ( m.equals("gmail") )
            return new MyEmailGmailMethod();

        if ( m.equals("print") )
            return new KmEmailPrintMethod();

        if ( m.equals("noop") )
            return new KmEmailNoopMethod();

        throw Kmu.newFatal("Property sendEmailMethod is unknown: %s.", m);
    }

    //##################################################
    //# results
    //##################################################

    private void updateResults()
    {
        KmDao.run(this::updateResultsDao);
    }

    private void updateResultsDao()
    {
        for ( KmEmailResult r : _results )
        {
            String uid = (String)r.getEmailKey();
            MyEmail email = MyEmailFinder.staticFind(uid);

            if ( r.isOk() )
                email.markSent();
            else
                email.markError(r.getErrorMessage());
        }
    }

    //##################################################
    //# support
    //##################################################

    private boolean enabled()
    {
        return getProperties().getSendEmailEnabled();
    }

    private MyPropertyRegistry getProperties()
    {
        return MyGlobals.getProperties();
    }

}
