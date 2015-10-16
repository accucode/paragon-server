package com.app.model;

import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.Kmu;

import com.app.model.base.MyThreadTopicBase;

public class MyThreadTopic
    extends MyThreadTopicBase
{
    //##################################################
    //# constants
    //##################################################

    /**
     * The unique uid for this JVM.
     *
     * Note that this is unique to the particular JVM, not the machine.
     * Multiple JVMs will each be assigned a different UID on the same machine.
     */
    public static final String OWNER_UID = Kmu.newUid();

    /**
     * The length of time that a particular JVM retains ownership,
     * or a particular topic.  To preserve ownership for longer
     * periods of time, the owner must periodically 'touch'
     * the topic before it expires.
     */
    private static final int KEEP_OWNERSHIP_MINUTES = 10;

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
        setLastStartUtcTs(getNowUtc());
        clearLastEndUtcTs();
    }

    public void end()
    {
        setLastEndUtcTs(getNowUtc());
    }

    public void touch()
    {
        setLastTouchUtcTs(getNowUtc());
    }

    /**
     * Return true if I have been recently touched.
     * This generally indicates that the current owner is still active
     * and that ownership should NOT be transferred.
     */
    public boolean hasRecentTouch()
    {
        KmTimestamp now = getNowUtc();
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
