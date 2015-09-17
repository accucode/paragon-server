package sandbox.wlove;

import com.kodemore.command.KmDaoRunnableCommand;
import com.kodemore.hibernate.lock.KmhDaoLockException;
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
        new KmThread(this::testLoop, name).startLater();
    }

    private void testLoop(String name)
    {
        while ( true )
            testOnce(name);
    }

    private void testOnce(String name)
    {
        try
        {
            KmDaoRunnableCommand cmd;
            cmd = new KmDaoRunnableCommand();
            cmd.setLockKey("test");
            cmd.setRunnable(this::testDao, name);
            cmd.run();
        }
        catch ( KmhDaoLockException ex )
        {
            // ignore
        }
        finally
        {
            Kmu.sleepMs(1);
        }
    }

    private void testDao(String name)
    {
        printfln("%s: handle...", name);

        MyUser u;
        u = getAccess().getUserDao().findEmail("root");
        u.toggleVerified();

        MyGlobals.getDaoSessionManager().flush();

        printfln("%s: version = %s", name, u.getLockVersion());
        printfln("%s: end.", name);
        printfln("");
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
