package com.app.ui.servlet;

import com.kodemore.command.KmDao;
import com.kodemore.log.KmLog;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoAccess;
import com.app.model.MyAttachment;
import com.app.model.MyServerSession;
import com.app.model.MyUser;
import com.app.model.base.MyAttachmentType;
import com.app.ui.core.MyServletData;
import com.app.utility.MyGlobals;

/**
 * I am used to fetch attachments from the database and return
 * then to the client.  This is useful when doing things like
 * embedding attached images or pdfs into the html page.
 */
public class MyAttachmentServlet
    extends MyServlet
{
    //##################################################
    //# get / post
    //##################################################

    @Override
    protected void doGet()
    {
        handle();
    }

    @Override
    protected void doPost()
    {
        handle();
    }

    //##################################################
    //# handle
    //##################################################

    private void handle()
    {
        try
        {
            KmDao.run(this::handleDao);
        }
        catch ( RuntimeException ex )
        {
            KmLog.fatal(ex);
        }
    }

    private void handleDao()
    {
        MyServletData data = getData();

        MyServerSession ss = MyGlobals.getServerSession();
        if ( ss == null )
        {
            print("No session.");
            return;
        }

        MyUser user = ss.getUser();
        if ( user == null )
        {
            print("No User.");
            return;
        }

        String uid = data.getExtraPath();
        if ( Kmu.isEmpty(uid) )
        {
            print("No Uid.");
            return;
        }

        MyDaoAccess access = MyGlobals.getAccess();
        MyAttachment attachment = access.findAttachmentUid(uid);
        if ( attachment == null )
        {
            print("Unknown Uid %s.", uid);
            return;
        }

        MyAttachmentType type = attachment.getType();
        switch ( type )
        {
            case Text:
                data.setTextResult(attachment.getContentString());
                break;

            case Pdf:
                data.setPdfResult(attachment.getContentBytes());
                break;

            case Image:
            case Other:
                data.setOctetResult(attachment.getContentBytes());
                break;
        }
    }

    //##################################################
    //# support
    //##################################################

    private void print(String msg, Object... args)
    {
        KmLog.printfln(msg, args);
    }
}
