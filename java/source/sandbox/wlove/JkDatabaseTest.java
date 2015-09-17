package sandbox.wlove;

import com.kodemore.command.KmDao;
import com.kodemore.utility.KmTimer;

import com.app.dao.base.MyDaoRegistry;
import com.app.utility.MyGlobals;
import com.app.utility.MyInstaller;

public class JkDatabaseTest
{
    public static void main(String[] args)
    {
        new JkDatabaseTest().run();
    }

    private void run()
    {
        KmTimer timer = KmTimer.run();
        MyInstaller.installDatabase();
        System.out.println("----------------------------------------");
        KmDao.run(this::handle);
        new JkDatabaseTest().run();
        System.out.println("----------------------------------------");
        timer.print();
        System.exit(0);
    }

    private void handle()
    {
        // none
    }

    protected MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }

}
