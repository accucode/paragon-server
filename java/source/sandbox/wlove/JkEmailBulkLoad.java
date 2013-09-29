package sandbox.wlove;

import com.app.model.MyEmail;
import com.app.utility.MyInstaller;

import com.kodemore.command.KmDaoCommand;

public class JkEmailBulkLoad
{
    public static void main(String[] args)
    {
        new JkEmailBulkLoad().run();
    }

    private void run()
    {
        MyInstaller.installDatabase();
        newCommand().run();
    }

    private KmDaoCommand newCommand()
    {
        return new KmDaoCommand()
        {
            @Override
            protected void handle()
            {
                int n = 10000;
                for ( int i = 0; i < n; i++ )
                {
                    MyEmail email;
                    email = new MyEmail();
                    email.setSubject("subject " + i);
                    email.addToRecipient("nobody@nowhere.com");
                    email.setFromAddress("nobody@here.com");
                    email.addTextPart("message");
                    email.saveDao();

                    System.out.println(i);
                }
            }
        };
    }
}
