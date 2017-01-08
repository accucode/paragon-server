package sandbox.wlove;

import com.kodemore.command.KmDao;
import com.kodemore.utility.KmRandom;

import com.app.dao.base.MyDaoAccess;
import com.app.model.MyEmail;
import com.app.utility.MyGlobals;
import com.app.utility.MyInstaller;

public class JkBlobTest
{
    public static void main(String[] args)
    {
        MyInstaller.installDatabase();

        new JkBlobTest().run();
    }

    private void run()
    {
        String msg1 = KmRandom.getInstance().getPrintableString(50000);
        String uid = KmDao.fetchNoRetry(this::saveEmail, msg1);
        String msg2 = KmDao.fetchNoRetry(this::findFirstPartUid, uid);

        System.out.println(msg2);

        System.out.println("\n\n");
        System.out.println(msg1.equals(msg2));
    }

    /**
     * Create and save a new email, and return the new uid.
     */
    private String saveEmail(final String msg)
    {
        MyEmail e;
        e = new MyEmail();
        e.addToRecipient("to@there.com");
        e.setFromAddress("from@here.com");
        e.setSubject("subject");
        e.addTextPart(msg);
        e.markReady();
        e.daoAttach();
        return e.getUid();
    }

    private String findFirstPartUid(String emailUid)
    {
        MyEmail email = getAccess().findEmailUid(emailUid);
        return email.getParts().getAny().getData().formatString();
    }

    private MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }
}
