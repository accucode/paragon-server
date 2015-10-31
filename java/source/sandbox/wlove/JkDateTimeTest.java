package sandbox.wlove;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.kodemore.time.KmClock;
import com.kodemore.utility.KmTimer;

public class JkDateTimeTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        System.out.println("--------------------");
        new JkDateTimeTest().run();
        System.out.println("--------------------");
        System.out.println("ok.");
    }

    private void run()
    {
        // MyInstaller.install();
        test();
    }

    private void test()
    {
        //        TextStyle style = TextStyle.FULL;
        //        Locale locale = Locale.getDefault();

        ZoneId denZone = ZoneId.of("America/Denver");
        ZoneId utcZone = ZoneId.of("UTC");

        Clock utcClock = Clock.systemUTC();
        Instant utcInstant = utcClock.instant();

        ZonedDateTime utcTime = utcInstant.atZone(utcZone);
        ZonedDateTime denTime = utcInstant.atZone(denZone);

        DateTimeFormatter localFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
        DateTimeFormatter zoneFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a (z)");

        System.out.println("Zoned...");
        System.out.println("    utcTime: " + utcTime.format(zoneFormat));
        System.out.println("    denTime: " + denTime.format(zoneFormat));

        System.out.println();
        System.out.println("Local...");
        System.out.println("    utcTime: " + utcTime.toLocalDateTime().format(localFormat));
        System.out.println("    denTime: " + denTime.toLocalDateTime().format(localFormat));

        System.out.println();
        System.out.println("Hack...");
        String s = utcTime.toLocalDateTime().atZone(denZone).format(zoneFormat);
        System.out.println("    s: " + s);

        System.out.println();
        System.out.println("Den Local...");
        System.out.println("    denDate: " + denTime.toLocalDateTime().toString());
        System.out.println("    denDate: " + denTime.toLocalDate().toString());
        System.out.println("    denTime: " + denTime.toLocalTime().toString());

        long ms = System.currentTimeMillis();
        s = Instant.ofEpochMilli(ms).atZone(denZone).toLocalDateTime().format(localFormat);
        System.out.println();
        System.out.println(s);

        System.out.println();
        System.out.println("Epoch, pre-epoch...");
        LocalDateTime epoch = LocalDateTime.of(1970, 1, 1, 0, 0, 0);
        System.out.println("    epoch: " + epoch);
        System.out.println("    epoch-1: " + epoch.minusSeconds(1));
    }

    protected void testSpeed()
    {
        Clock utcClock = Clock.systemUTC();

        KmTimer t;
        int n = 1000000;

        t = KmTimer.run("KmClock");
        for ( int i = 0; i < n; i++ )
        {
            KmClock.getNowUtc();
            t.lap();
        }
        t.print();

        t = KmTimer.run("Instant");
        for ( int i = 0; i < n; i++ )
        {
            utcClock.instant();
            t.lap();
        }
        t.print();

        t = KmTimer.run("KmClock");
        for ( int i = 0; i < n; i++ )
        {
            KmClock.getNowUtc();
            t.lap();
        }
        t.print();

        t = KmTimer.run("Instant");
        for ( int i = 0; i < n; i++ )
        {
            utcClock.instant();
            t.lap();
        }
        t.print();

    }
}
