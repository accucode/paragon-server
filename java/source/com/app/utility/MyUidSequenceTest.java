package com.app.utility;

import com.kodemore.collection.KmList;
import com.kodemore.utility.KmRandom;
import com.kodemore.utility.Kmu;

public class MyUidSequenceTest
{
    public static boolean test()
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

        return diffs == 0;
    }

    private static void addLineTo(KmList<Data> v)
    {
        Data e;
        e = new Data();
        e.uid = Kmu.newUid();
        e.index = v.size();
        v.add(e);

        int ms = KmRandom.getInstance().getInteger(10);
        Kmu.sleepMs(ms);
    }

    private static class Data
    {
        private String uid;
        private int    index;
    }
}
