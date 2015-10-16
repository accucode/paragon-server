package com.app.utility;

import com.kodemore.command.KmDao;

import com.app.dao.MyThreadTopicDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyThreadTopic;

/**
 * I provide convenient access to thread topics, and am intended
 * to be used outside of a transaction.
 */
public class MyThreadTopicClient
{
    //##################################################
    //# variables
    //##################################################

    private String _code;

    //##################################################
    //# constructor
    //##################################################

    public MyThreadTopicClient(String code)
    {
        _code = code;
    }

    //##################################################
    //# accessing
    //##################################################

    public String getCode()
    {
        return _code;
    }

    //##################################################
    //# public
    //##################################################

    /**
     * Return the thread owner.
     * This may return null.
     */
    public MyThreadTopic getThreadTopic()
    {
        return KmDao.fetch(this::getThreadTopicDao);
    }

    /**
     * Attempt to touch the thread owner.
     * I am called once at the beginning of a task and update the start time.
     * Lazy create the record if it does not exist.
     * This will fail if someone else is the owner.
     */
    public boolean touchStart()
    {
        return KmDao.fetch(this::touchStartDao);
    }

    /**
     * Attempt to touch the thread owner.
     * I am called once at the end of a task and update the end time.
     * Lazy create the record if it does not exist.
     * This will fail if someone else is the owner.
     */
    public boolean touchEnd()
    {
        return KmDao.fetch(this::touchEndDao);
    }

    /**
     * Attempt to touch the thread owner.
     * I may be called multiple times within a long running task in
     * order to prevent the ownership from timing out.
     */
    public boolean touch()
    {
        return KmDao.fetch(this::touchDao);
    }

    //##################################################
    //# private
    //##################################################

    private MyThreadTopic getThreadTopicDao()
    {
        return getAccess().findThreadTopicCode(getCode());
    }

    private boolean touchStartDao()
    {
        return getDao().touchStart(getCode());
    }

    private boolean touchEndDao()
    {
        return getDao().touchEnd(getCode());
    }

    private boolean touchDao()
    {
        return getDao().touch(getCode());
    }

    //##################################################
    //# support
    //##################################################

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }

    private MyThreadTopicDao getDao()
    {
        return getAccess().getThreadTopicDao();
    }

}
