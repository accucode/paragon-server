package sandbox.wlove;

import com.kodemore.command.KmDaoResultCommand;
import com.kodemore.utility.KmRandom;

import com.app.dao.base.MyDaoRegistry;
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
        String uid = newSaveCommand(msg1).runResult();
        String msg2 = newFindCommand(uid).runResult();

        System.out.println(msg2);

        System.out.println("\n\n");
        System.out.println(msg1.equals(msg2));
    }

    private KmDaoResultCommand<String> newSaveCommand(final String msg)
    {
        return new KmDaoResultCommand<String>()
        {
            @Override
            protected String handleResult()
            {
                MyEmail email;
                email = new MyEmail();
                email.addToRecipient("to@there.com");
                email.setFromAddress("from@here.com");
                email.setSubject("subject");
                email.addTextPart(msg);
                email.markReady();
                email.attachDao();

                return email.getUid();
            }
        };
    }

    private KmDaoResultCommand<String> newFindCommand(final String uid)
    {
        return new KmDaoResultCommand<String>()
        {
            @Override
            protected String handleResult()
            {
                MyEmail email = getAccess().findEmailUid(uid);
                return email.getParts().getFirst().getData().formatString();
            }
        };
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
}
