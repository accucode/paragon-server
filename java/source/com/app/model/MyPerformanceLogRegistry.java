package com.app.model;

import com.kodemore.collection.KmList;

import com.app.utility.MyGlobals;

public class MyPerformanceLogRegistry
{
    //##################################################
    //# variables
    //##################################################

    private static final KmList<MyPerformanceLog> _list = new KmList<>();

    //##################################################
    //# accessing
    //##################################################

    public static synchronized void push(String name, int ms)
    {
        if ( !MyGlobals.getProperties().getPerformanceLogJobEnabled() )
            return;

        MyPerformanceLog e;
        e = new MyPerformanceLog();
        e.setName(name);
        e.truncateName();
        e.setDurationMs(ms);

        _list.add(e);
    }

    public static synchronized KmList<MyPerformanceLog> pop()
    {
        KmList<MyPerformanceLog> v = _list.getShallowCopy();
        _list.clear();
        return v;
    }

}
