package com.app.job.application;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDao;

import com.app.job.MyJob;
import com.app.model.MyApplicationLog;
import com.app.model.MyApplicationLogBuffer;
import com.app.utility.MyLog4jDaoAppender;

/**
 * Flush the in-memory collection of logs to the database.
 *
 * @see MyLog4jDaoAppender
 * @see MyApplicationLogBuffer
 */
public class MyApplicationLogFlusherJob
    extends MyJob
{
    //##################################################
    //# settings
    //##################################################

    @Override
    protected boolean isEnabled()
    {
        return getProperties().getApplicationLogFlusherJobEnabled();
    }

    @Override
    protected int getActiveMs()
    {
        Integer seconds = getProperties().getApplicationLogFlusherJobActiveSeconds();
        return secondsToMs(seconds);
    }

    @Override
    protected int getIdleMs()
    {
        Integer seconds = getProperties().getApplicationLogFlusherJobIdleSeconds();
        return secondsToMs(seconds);
    }

    @Override
    protected boolean logsPerformance()
    {
        return false;
    }

    //##################################################
    //# run
    //##################################################

    @Override
    protected boolean handle()
    {
        KmList<MyApplicationLog> v = MyApplicationLogBuffer.pop();
        if ( v.isEmpty() )
            return false;

        KmDao.run(this::saveAllDao, v);
        return true;
    }

    private void saveAllDao(KmList<MyApplicationLog> v)
    {
        for ( MyApplicationLog e : v )
            e.daoAttach();
    }
}
