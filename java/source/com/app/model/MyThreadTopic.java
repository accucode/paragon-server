package com.app.model;

import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.Kmu;

import com.app.job.MyThreadTopicJob;
import com.app.model.base.MyThreadTopicBase;
import com.app.model.core.MySystemDomainIF;

/**
 * I am used to coordinate a single-threaded process across multiple JVMs.
 * I am primarily used by MyThreadTopicJob for background processes that
 * should only be run by one JVM at a time.
 * @see MyThreadTopicJob
 */
public class MyThreadTopic
    extends MyThreadTopicBase
    implements MySystemDomainIF
{
    //##################################################
    //# constants
    //##################################################

    /**
     * The unique uid for this JVM.
     *
     * Note that this is unique to the particular JVM, not the machine.
     * Multiple JVMs will each be assigned a different UID on the same machine.
     * Also, if you restart the JVM, it will be assigned a new id.
     */
    public static final String OWNER_UID              = Kmu.newUid();

    /**
     * The length of time that a particular JVM retains ownership,
     * on a particular topic. To preserve ownership for longer
     * periods of time, the owner must periodically 'touch'
     * the topic before it expires.
     */
    private static final int   KEEP_OWNERSHIP_MINUTES = 10;

    //##################################################
    //# constructor
    //##################################################

    public MyThreadTopic()
    {
        super();
    }

    //##################################################
    //# convenience
    //##################################################

    public void start()
    {
        setLastStartUtcTs(nowUtc());
        clearLastEndUtcTs();
    }

    public void end()
    {
        setLastEndUtcTs(nowUtc());
    }

    public void touch()
    {
        setLastTouchUtcTs(nowUtc());
    }

    /**
     * Return true if I have been recently touched.
     * This generally indicates that the current owner is still active
     * and that ownership should NOT be transferred.
     */
    public boolean hasRecentTouch()
    {
        KmTimestamp now = nowUtc();
        KmTimestamp lastTouch = getLastTouchUtcTs();

        if ( lastTouch == null )
            return false;

        return now.getMinutesSince(lastTouch) < KEEP_OWNERSHIP_MINUTES;
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getDisplayString()
    {
        return getCode() + " " + getHostName();
    }

}
