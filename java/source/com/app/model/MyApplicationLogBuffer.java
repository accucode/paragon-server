package com.app.model;

import com.kodemore.collection.KmList;

import com.app.job.application.MyApplicationLogFlusherJob;
import com.app.utility.MyLog4jDaoAppender;

/**
 * I coordinate an in-memory cache of the application logs which
 * are used to echo log4j messages to the database.
 *
 * @see MyLog4jDaoAppender
 * @see MyApplicationLogFlusherJob
 */
public class MyApplicationLogBuffer
{
    //##################################################
    //# variables
    //##################################################

    private static final KmList<MyApplicationLog> _list = new KmList<>();

    //##################################################
    //# accessing
    //##################################################

    public static synchronized void push(MyApplicationLog e)
    {
        _list.add(e);
    }

    public static synchronized KmList<MyApplicationLog> pop()
    {
        KmList<MyApplicationLog> v = _list.getShallowCopy();
        _list.clear();
        return v;
    }

}
