package sandbox.wlove;

import com.kodemore.command.KmDao;
import com.kodemore.log.KmLog;
import com.kodemore.utility.KmTimer;
import com.kodemore.utility.Kmu;

import com.app.utility.MyInstaller;

public class JkTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        System.out.println("--------------------");
        new JkTest().run();
        System.out.println("--------------------");
        System.out.println("ok.");
    }

    private void run()
    {
        MyInstaller.install();
        System.out.println();

        test();

        Kmu.sleepSeconds(10);
        MyInstaller.shutdown();
    }

    private void test()
    {
        KmLog.println("------------------");
        KmTimer t = KmTimer.run();
        int n = 10;
        for ( int i = 0; i < n; i++ )
        {
            KmDao.run(this::log);
            t.lap();
        }
        t.printAverage();
    }

    private void log()
    {
        KmLog.println("hello");
    }
}
