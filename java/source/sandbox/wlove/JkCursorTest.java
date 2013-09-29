package sandbox.wlove;

import com.app.model.MyUser;
import com.app.model.meta.MyMetaUser;
import com.app.utility.MyInstaller;

import com.kodemore.command.KmDaoCommand;
import com.kodemore.dao.KmDaoStringKeyCursor;

public class JkCursorTest
{
    public static void main(String[] args)
    {
        new JkCursorTest().run();
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
                MyMetaUser x = MyUser.Meta;

                KmDaoStringKeyCursor<MyUser> c;
                c = KmDaoStringKeyCursor.createOn(x.Uid);

                for ( MyUser e : c )
                    System.out.println(e.getUid());
            }
        };
    }
}
