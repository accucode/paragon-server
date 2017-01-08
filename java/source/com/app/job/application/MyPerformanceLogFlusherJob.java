package com.app.job.application;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDao;

import com.app.job.MyJob;
import com.app.model.MyPerformanceLogBuffer;
import com.app.model.MyPerformanceLogDetail;

/**
 * Flush the in-memory collection of performance logs to the database.
 * See also MyPerformanceLogRegistry.
 */
public class MyPerformanceLogFlusherJob
    extends MyJob
{
    //##################################################
    //# settings
    //##################################################

    @Override
    protected boolean isEnabled()
    {
        return getProperties().getPerformanceLogFlusherJobEnabled();
    }

    @Override
    protected int getActiveMs()
    {
        Integer seconds = getProperties().getPerformanceLogFlusherJobActiveSeconds();
        return secondsToMs(seconds);
    }

    @Override
    protected int getIdleMs()
    {
        Integer seconds = getProperties().getPerformanceLogFlusherJobIdleSeconds();
        return secondsToMs(seconds);
    }

    //##################################################
    //# run
    //##################################################

    @Override
    protected boolean handle()
    {
        KmList<MyPerformanceLogDetail> v = MyPerformanceLogBuffer.pop();
        if ( v.isEmpty() )
            return false;

        KmDao.run(this::saveAllDao, v);
        return true;
    }

    private void saveAllDao(KmList<MyPerformanceLogDetail> v)
    {
        for ( MyPerformanceLogDetail e : v )
            e.daoAttach();
    }
}
