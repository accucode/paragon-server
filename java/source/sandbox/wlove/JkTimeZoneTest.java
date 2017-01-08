package sandbox.wlove;

import java.util.TimeZone;

import com.kodemore.collection.KmList;

public class JkTimeZoneTest
{
    public static void main(String[] args)
    {
        new JkTimeZoneTest().run();
    }

    private void run()
    {
        newTest();
    }

    private void newTest()
    {
        KmList<String> ids;
        ids = KmList.createWith(TimeZone.getAvailableIDs());
        ids.sort();

        KmList<TimeZone> zones;
        zones = ids.collect(id -> TimeZone.getTimeZone(id));
        zones.retainIf(e -> e.getID().startsWith("America"));

        KmList<String> names;
        names = zones.collect(e -> e.getDisplayName(false, TimeZone.LONG));
        names.sort();

        //        System.out.println();
        //        System.out.println("all...");
        //        System.out.println("-------------");
        //        KmList.createWith(TimeZone.getAvailableIDs()).printLines();

        System.out.println();
        System.out.println("distincts...");
        System.out.println("-------------");
        names.toDistinctList().printLines();

        System.out.println();
        System.out.println("duplicates...");
        System.out.println("-------------");
        names.getDuplicates().printLines();

        System.out.println();
        System.out.println("default...");
        System.out.println("-------------");
        System.out.println(TimeZone.getDefault().getID());

        System.out.println();
        System.out.println("utc...");
        System.out.println("-------------");
        System.out.println(TimeZone.getTimeZone("UTC").getDisplayName());

        System.out.println();
        System.out.println("denver...");
        System.out.println("-------------");
        System.out.println(TimeZone.getTimeZone("America/Denver").getDisplayName());

        int maxLength = 0;
        for ( String id : ids )
            maxLength = Math.max(maxLength, id.length());
        System.out.println();
        System.out.println("max length...");
        System.out.println("-------------");
        System.out.println(maxLength);
    }
}
