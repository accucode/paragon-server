package com.app.job;

import com.app.model.MyThreadTopic;
import com.app.utility.MyThreadTopicClient;

/**
 * My subclassed jobs will only run on a single JVM at any given time.
 *
 * To ensure that long running job are not hijacked by another JVM,
 * subclasses must break any long running tasks into a series of muliple
 * database transactions.  Each transaction should call touch() to demonstate
 * continued activity and ownership.  Transactions should generally be limited
 * to no more than 60 seconds.
 *
 * If a single transaction takes too long, then another JVM may think that the
 * current owner died and attempt to take over.  See MyThreadTopic for the
 * pertinent constants.
 * @see MyThreadTopic
 */
public abstract class MyThreadTopicJob
    extends MyJob
{
    //##################################################
    //# run
    //##################################################

    @Override
    protected boolean preHandle()
    {
        if ( !super.preHandle() )
            return false;

        return getClient().touchStart();
    }

    @Override
    protected void postHandle()
    {
        super.postHandle();
        getClient().touchEnd();
    }

    //##################################################
    //# thread owner
    //##################################################

    private String getThreadTopicCode()
    {
        // assumes that no two jobs share the same SIMPLE class name.
        return getClass().getSimpleName();
    }

    private final MyThreadTopicClient getClient()
    {
        return new MyThreadTopicClient(getThreadTopicCode());
    }

    //##################################################
    //# touch
    //##################################################

    protected void touch()
    {
        getClient().touch();
    }

    protected MyThreadTopic getDetachedThreadTopic()
    {
        return getClient().getThreadTopic();
    }

}
