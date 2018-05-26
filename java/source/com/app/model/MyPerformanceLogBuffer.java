package com.app.model;

import com.kodemore.collection.KmList;
import com.kodemore.log.KmLog;
import com.kodemore.utility.KmTimer;

import com.app.property.MyProperties;
import com.app.utility.MyGlobals;

/**
 * I coordinate an in-memory cache of performance logs.
 *
 * To minimize the impact on user-facing application performance,
 * performance logs are cached in memory, then subsequently flushed
 * to the database.  This avoids impacting the user transaction, and
 * also allows us to consolidate details in memory, then bulk insert
 * the initial records with improves efficiency.
 *
 * In some cases, the in-memory cache may be lost.  This is most likely
 * occurs when the application is shut down for maintenance, or when
 * the hosting environment scales down the number of active JVMs.  Since
 * the performance logs are only intended to provide general trending,
 * this imperfect logging is considered acceptable.
 */
public class MyPerformanceLogBuffer
{
    //##################################################
    //# variables
    //##################################################

    private static KmList<MyPerformanceLogDetail> _list = new KmList<>();

    //##################################################
    //# accessing
    //##################################################

    public static void push(String name, KmTimer t)
    {
        push(name, (int)t.getMilliseconds());
    }

    public static void push(String name, int ms)
    {
        MyProperties p = MyGlobals.getProperties();

        boolean enabled = p.getPerformanceLogFlusherChoreEnabled();
        if ( !enabled )
            return;

        MyPerformanceLogDetail e;
        e = new MyPerformanceLogDetail();
        e.setName(name);
        e.truncateName();
        e.setDurationMs(ms);

        boolean show = p.getPrintPerformanceLog();
        if ( show )
            KmLog.printfln("Performance %s, %s ms", e.getName(), e.getDurationMs());

        push(e);
    }

    private static synchronized void push(MyPerformanceLogDetail e)
    {
        _list.add(e);
    }

    public static synchronized KmList<MyPerformanceLogDetail> pop()
    {
        KmList<MyPerformanceLogDetail> v = _list;
        _list = new KmList<>();
        return v;
    }

}
