package com.app.job.application;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDao;
import com.kodemore.time.KmTimestamp;

import com.app.filter.MyPerformanceLogFilter;
import com.app.job.MyJob;
import com.app.model.MyPerformanceLog;

public class MyDeleteOldPerformanceLogsJob
    extends MyJob
{
    //##################################################
    //# settings
    //##################################################

    @Override
    protected boolean isEnabled()
    {
        return getProperties().getDeleteOldPerformanceLogsJobEnabled();
    }

    @Override
    protected int getActiveMs()
    {
        Integer seconds = getProperties().getDeleteOldPerformanceLogsJobActiveSeconds();
        return secondsToMs(seconds);
    }

    @Override
    protected int getIdleMs()
    {
        Integer seconds = getProperties().getDeleteOldPerformanceLogsJobIdleSeconds();
        return secondsToMs(seconds);
    }

    @Override
    protected boolean isMaintenanceJob()
    {
        return true;
    }

    //##################################################
    //# run
    //##################################################

    @Override
    protected boolean handle()
    {
        return KmDao.fetch(this::deleteBatchDao);
    }

    private boolean deleteBatchDao()
    {
        int limit = 100;
        KmTimestamp latest = getNowUtc().subtractDay();

        MyPerformanceLogFilter f;
        f = new MyPerformanceLogFilter();
        f.setMaximumCreatedUtcTs(latest);
        f.sortOnCreatedUtcTs();

        KmList<MyPerformanceLog> v = f.findFirst(limit);
        if ( v.isEmpty() )
            return false;

        for ( MyPerformanceLog e : v )
            e.deleteDao();

        return true;
    }
}
