package sandbox.wlove;

import com.kodemore.utility.KmTimer;
import com.kodemore.utility.Kmu;

public class JkUidTest
{
    public static void main(String[] args)
    {
        new JkUidTest().run();
    }

    private void run()
    {
        printOne();
        speedTest();
    }

    protected void printOne()
    {
        System.out.println(Kmu.newUid());
    }

    protected void speedTest()
    {
        int n = 1000000;
        for ( int i = 0; i < n; i++ )
            Kmu.newUid();

        KmTimer t = KmTimer.run();
        for ( int i = 0; i < n; i++ )
            Kmu.newUid();
        t.stop();

        int iPerMs = (int)(n / t.getMilliseconds());
        System.out.println(iPerMs + " / ms");
    }
}
