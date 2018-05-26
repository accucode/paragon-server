package com.app.chore.application;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDao;

import com.app.chore.MyChore;
import com.app.model.MyPerformanceLogBuffer;
import com.app.model.MyPerformanceLogDetail;

/**
 * Flush the in-memory collection of performance logs to the database.
 * See also MyPerformanceLogRegistry.
 */
public class MyPerformanceLogFlusherChore
    extends MyChore
{
    //##################################################
    //# settings
    //##################################################

    @Override
    protected boolean isEnabled()
    {
        return getProperties().getPerformanceLogFlusherChoreEnabled();
    }

    @Override
    protected int getActiveMs()
    {
        Integer seconds = getProperties().getPerformanceLogFlusherChoreActiveSeconds();
        return secondsToMs(seconds);
    }

    @Override
    protected int getIdleMs()
    {
        Integer seconds = getProperties().getPerformanceLogFlusherChoreIdleSeconds();
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
