package sandbox.wlove;

import com.kodemore.command.KmDaoCommand;
import com.kodemore.utility.KmTimer;

import com.app.dao.base.MyDaoRegistry;
import com.app.utility.MyGlobals;
import com.app.utility.MyInstaller;

public class JkDatabaseTest
    extends KmDaoCommand
{
    public static void main(String[] args)
    {
        KmTimer timer = KmTimer.run();
        MyInstaller.installDatabase();
        System.out.println("----------------------------------------");
        new JkDatabaseTest().run();
        System.out.println("----------------------------------------");
        timer.print();
        System.exit(0);
    }

    @Override
    protected void handle()
    {
        // none
    }

    protected MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }

}
