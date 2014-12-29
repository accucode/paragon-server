package sandbox.wlove;

import com.kodemore.command.KmDaoCommand;
import com.kodemore.hibernate.lock.KmDaoLockException;
import com.kodemore.thread.KmThread;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyUser;
import com.app.utility.MyGlobals;
import com.app.utility.MyInstaller;

public class JkLockTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        MyInstaller.installDatabase();
        new JkLockTest().run();
    }

    //##################################################
    //# run
    //##################################################

    private void run()
    {
        int n = 10;
        for ( int i = 0; i < n; i++ )
            start(i + "");
    }

    private void start(String name)
    {
        System.out.println("Starting: " + name);
        newThread(name).startLater();
    }

    private KmThread newThread(final String name)
    {
        return new KmThread()
        {
            @Override
            public void run()
            {
                while ( true )
                    try
                    {
                        newCommand(name).run();
                        yield();
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
                printfln("%s: handle...", name);

                MyUser u;
                u = getAccess().getUserDao().findEmail("root");
                u.toggleVerified();

                getSessionManager().flush();

                printfln("%s: version = %s", name, u.getLockVersion());
                printfln("%s: end.", name);
                printfln("");
            }

            @Override
            public String getLockKey()
            {
                return "test";
            }
        };
    }

    //##################################################
    //# support
    //##################################################

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }

    private void printfln(String msg, Object... args)
    {
        System.out.println(Kmu.format(msg, args));
    }

}
