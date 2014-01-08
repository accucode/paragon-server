package sandbox.wlove;

import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.KmClock;

public class JkTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        new JkTest().run();
    }

    //##################################################
    //# run
    //##################################################

    private void run()
    {
        KmTimestamp utc = KmClock.getNowUtc();
        System.out.println(utc.formatIsoUtc());
    }
}
