package sandbox.wlove;

import com.kodemore.collection.KmList;
import com.kodemore.utility.KmRandom;
import com.kodemore.utility.Kmu;

import com.app.utility.MyInstaller;

/**
 * Test if uids are created in sequence.
 */
public class JkUidSequenceTest
{
    public static void main(String[] args)
    {
        new JkUidSequenceTest().run();
    }

    private boolean installApp = true;

    private void run()
    {
        if ( installApp )
        {
            MyInstaller.install();
            System.out.println("sleep for 5 seconds...");
            Kmu.sleepSeconds(5);
            System.out.println("-----------------------------------------");
        }

        testUids();

        if ( installApp )
        {
            System.out.println("-----------------------------------------");
            System.out.println("sleep for 5 seconds...");
            Kmu.sleepSeconds(5);
            MyInstaller.shutdown();
        }
    }

    private void testUids()
    {
        KmList<Data> v = new KmList<>();

        int n = 1000;
        for ( int i = 0; i < n; i++ )
            addLineTo(v);

        v.sortOn(e -> e.uid);

        int diffs = 0;
        for ( int i = 0; i < n; i++ )
            if ( v.get(i).index != i )
                diffs++;

        // System.out.println(v.joinLines());

        if ( diffs == 0 )
            System.out.println("OK, all uids are in sequence.");
        else
            System.out.println("OOPS, uids are NOT in sequence. " + diffs);
    }

    private void addLineTo(KmList<Data> v)
    {
        Data e;
        e = new Data();
        e.uid = Kmu.newUid();
        e.index = v.size();
        v.add(e);

        int ms = KmRandom.getInstance().getInteger(10);
        Kmu.sleepMs(ms);
    }

    private class Data
    {
        private String uid;
        private int    index;

        @Override
        public String toString()
        {
            int indent = index % 30 * 3;
            String stars = Kmu.repeat(" ", indent) + "****";

            return Kmu.format("%6d %s %s", index, uid, stars);
        }
    }

}
