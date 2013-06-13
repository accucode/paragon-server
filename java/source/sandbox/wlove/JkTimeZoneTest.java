package sandbox.wlove;

import com.kodemore.time.KmTimestamp;

import com.app.model.MyTimeZone;
import com.app.utility.MyInstaller;

public class JkTimeZoneTest
{
    public static void main(String[] args)
    {
        new JkTimeZoneTest().run();
    }

    private void run()
    {
        MyInstaller.installCore();

        MyTimeZone mst = MyTimeZone.MSTD;
        KmTimestamp utc = KmTimestamp.createNowUtc();

        System.out.println("utc:        " + utc);
        System.out.println();
        System.out.println("local:      " + utc.toLocal());
        System.out.println("local:      " + utc.formatLocalMessage());
        System.out.println();
        System.out.println("local(mst): " + utc.toLocal(mst));
        System.out.println("local(mst): " + utc.formatLocalMessage(mst));

    }

}
