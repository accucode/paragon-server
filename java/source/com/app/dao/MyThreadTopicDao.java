package com.app.dao;

import com.kodemore.utility.Kmu;

import com.app.dao.base.MyThreadTopicDaoBase;
import com.app.model.MyThreadTopic;

public class MyThreadTopicDao
    extends MyThreadTopicDaoBase
{
    //##################################################
    //# touch
    //##################################################

    /**
     * Attempt to touch the topic, and record the start of a new process.
     *
     * This only returns true if this JVM is the current owner,
     * or becomes the owner upon this request.
     */
    public boolean touchStart(String code)
    {
        if ( !touch(code) )
            return false;

        findCode(code).start();
        return true;
    }

    /**
     * Attempt to touch the topic, and record the end of a running process.
     *
     * This only returns true if this JVM is the current owner,
     * or becomes the owner upon this request.
     */
    public boolean touchEnd(String code)
    {
        if ( !touch(code) )
            return false;

        findCode(code).end();
        return true;
    }

    /**
     * Attempt to touch the topic.
     *
     * If no one owns this topic, attempt to become the new owner.
     * If someone else owns this topic, check if the current owner is still active.
     *
     * Return true if this JVM is the current owner.
     */
    public boolean touch(String code)
    {
        MyThreadTopic e = findCode(code);

        if ( e == null )
            e = _create(code);

        if ( e == null )
            return false;

        if ( e.hasOwnerUid(getMyOwnerUid()) )
            return _keepOwnership(code);

        if ( e.hasRecentTouch() )
            return false;

        return _takeOwnership(code);
    }

    //==================================================
    //= touch :: private
    //==================================================

    private MyThreadTopic _create(String code)
    {
        MyThreadTopic e;
        e = new MyThreadTopic();
        e.setCode(code);
        e.attachDao();

        if ( !tryFlush() )
            return null;

        return e;
    }

    private boolean _keepOwnership(String code)
    {
        findCode(code).touch();
        return tryFlush();
    }

    private boolean _takeOwnership(String code)
    {
        MyThreadTopic e;
        e = findCode(code);
        e.setOwnerUid(getMyOwnerUid());
        e.setHostName(getHostName());
        e.setHostAddress(getHostAddress());
        e.touch();
        return tryFlush();
    }

    //##################################################
    //# support
    //##################################################

    private String getHostName()
    {
        return Kmu.getLocalHostName();
    }

    private String getHostAddress()
    {
        return Kmu.getLocalHostAddress();
    }

    private String getMyOwnerUid()
    {
        return MyThreadTopic.OWNER_UID;
    }

    private boolean tryFlush()
    {
        return getAccess().tryFlush();
    }

}
