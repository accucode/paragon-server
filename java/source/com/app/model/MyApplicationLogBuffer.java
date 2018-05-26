package com.app.model;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDao;

import com.app.chore.application.MyApplicationLogFlusherChore;
import com.app.utility.MyLog4jDaoAppender;

/**
 * I coordinate an in-memory cache of the application logs which
 * are used to echo log4j messages to the database.
 *
 * @see MyLog4jDaoAppender
 * @see MyApplicationLogFlusherChore
 */
public class MyApplicationLogBuffer
{
    //##################################################
    //# variables
    //##################################################

    private static KmList<MyApplicationLog> _list = new KmList<>();

    //##################################################
    //# accessing
    //##################################################

    public static synchronized void push(MyApplicationLog e)
    {
        _list.add(e);
    }

    public static synchronized KmList<MyApplicationLog> pop()
    {
        KmList<MyApplicationLog> v = _list;
        _list = new KmList<>();
        return v;
    }

    public static synchronized int size()
    {
        return _list.size();
    }

    public static synchronized boolean isEmpty()
    {
        return _list.isEmpty();
    }

    //##################################################
    //# dao
    //##################################################

    /**
     * Flush any logs in the buffer to the database.
     * Return true if one or more logs were flushed.
     */
    public static boolean flush()
    {
        KmList<MyApplicationLog> v = pop();
        if ( v.isEmpty() )
            return false;

        KmDao.run(MyApplicationLogBuffer::saveAllDao, v);
        return true;
    }

    private static void saveAllDao(KmList<MyApplicationLog> v)
    {
        for ( MyApplicationLog e : v )
            e.daoAttach();
    }

}
