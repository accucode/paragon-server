package sandbox.wlove;

import com.kodemore.command.KmDaoCommand;
import com.kodemore.hibernate.lock.KmDaoLockException;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyUser;
import com.app.utility.MyGlobals;
import com.app.utility.MyInstaller;

public class JkLockTest
{
    public static void main(String[] args)
    {
        MyInstaller.installDatabase();
        new JkLockTest().run();
    }

    public void run()
    {
        int n = 10;
        for ( int i = 0; i < n; i++ )
            start(i + "");
    }

    private void start(String name)
    {
        System.out.println("Starting: " + name);
        new Thread(newRunnable(name)).start();
    }

    private Runnable newRunnable(final String name)
    {
        return new Runnable()
        {
            @Override
            public void run()
            {
                while ( true )
                    try
                    {
                        newCommand(name).run();
                        Kmu.yield();
                    }
                    catch ( KmDaoLockException ex )
                    {
                        // ignore
                    }
            }
        };
    }

    private KmDaoCommand newCommand(final String name)
    {
        return new KmDaoCommand()
        {
            @Override
            public void handle()
            {
                System.out.println(name + ": begin...");

                MyUser u;
                u = getAccess().getUserDao().findUid("root");
                u.toggleVerified();

                System.out.println(name + ": active = " + u.isVerified());
                System.out.println(name + ": end.");
                System.out.println();
            }

            @Override
            public String getLockKey()
            {
                return "test";
            }
        };
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }

}
