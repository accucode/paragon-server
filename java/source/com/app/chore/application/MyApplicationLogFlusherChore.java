package com.app.chore.application;

import com.app.chore.MyChore;
import com.app.model.MyApplicationLogBuffer;
import com.app.utility.MyLog4jDaoAppender;

/**
 * Flush the in-memory collection of logs to the database.
 *
 * @see MyLog4jDaoAppender
 * @see MyApplicationLogBuffer
 */
public class MyApplicationLogFlusherChore
    extends MyChore
{
    //##################################################
    //# settings
    //##################################################

    @Override
    protected boolean isEnabled()
    {
        return getProperties().getApplicationLogFlusherChoreEnabled();
    }

    @Override
    protected int getActiveMs()
    {
        Integer seconds = getProperties().getApplicationLogFlusherChoreActiveSeconds();
        return secondsToMs(seconds);
    }

    @Override
    protected int getIdleMs()
    {
        Integer seconds = getProperties().getApplicationLogFlusherChoreIdleSeconds();
        return secondsToMs(seconds);
    }

    @Override
    protected boolean logsPerformance()
    {
        return true;
    }

    //##################################################
    //# run
    //##################################################

    @Override
    protected boolean handle()
    {
        return MyApplicationLogBuffer.flush();
    }
}
