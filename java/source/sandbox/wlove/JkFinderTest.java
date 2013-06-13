package sandbox.wlove;

import com.kodemore.monitor.KmDefaultMonitor;

import com.app.finder.MyServerSessionFinder;
import com.app.utility.MyInstaller;

public class JkFinderTest
{
    public static void main(String[] args)
    {
        KmDefaultMonitor.enable();
        KmDefaultMonitor.reset();
        run();
        KmDefaultMonitor.print();
        System.exit(0);
    }

    private static void run()
    {
        try
        {
            KmDefaultMonitor.enter("JkFinderTest.run");
            MyInstaller.install();
            init();
            loop("one");
        }
        finally
        {
            KmDefaultMonitor.exit();
        }
    }

    private static void init()
    {
        try
        {
            KmDefaultMonitor.enter("JkFinderTest.init");
            findServerSession("aaa");
        }
        finally
        {
            KmDefaultMonitor.exit();
        }
    }

    private static void loop(String name)
    {
        try
        {
            KmDefaultMonitor.enter("JkFinderTest.loop:" + name);
            loop();
        }
        finally
        {
            KmDefaultMonitor.exit();
        }
    }

    private static void loop()
    {
        int n = 100;
        for ( int i = 0; i < n; i++ )
            findServerSession("aaa");
    }

    private static void findServerSession(String uid)
    {
        try
        {
            KmDefaultMonitor.enter("JkFinderTest.findServerSession");
            new MyServerSessionFinder().findDao(uid);
        }
        finally
        {
            KmDefaultMonitor.exit();
        }
    }
}
