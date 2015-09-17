package com.app.job.application;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDao;

import com.app.job.MyJob;
import com.app.model.MyPerformanceLog;
import com.app.model.MyPerformanceLogRegistry;

public class MyPerformanceLogJob
    extends MyJob
{
    //##################################################
    //# settings
    //##################################################

    @Override
    protected boolean isEnabled()
    {
        return getProperties().getPerformanceLogJobEnabled();
    }

    @Override
    protected int getActiveMs()
    {
        Integer seconds = getProperties().getPerformanceLogJobActiveSeconds();
        return secondsToMs(seconds);
    }

    @Override
    protected int getIdleMs()
    {
        Integer seconds = getProperties().getPerformanceLogJobIdleSeconds();
        return secondsToMs(seconds);
    }

    //##################################################
    //# run
    //##################################################

    @Override
    protected boolean handle()
    {
        KmList<MyPerformanceLog> v = MyPerformanceLogRegistry.pop();
        if ( v.isEmpty() )
            return false;

        KmDao.run(this::saveAllDao, v);
        return true;
    }

    private void saveAllDao(KmList<MyPerformanceLog> v)
    {
        for ( MyPerformanceLog e : v )
            e.attachDao();
    }
}
