package com.app.job.application;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDao;
import com.kodemore.time.KmTimestamp;

import com.app.filter.MyApplicationLogFilter;
import com.app.job.MyJob;
import com.app.model.MyApplicationLog;

public class MyDeleteOldApplicationLogsJob
    extends MyJob
{
    //##################################################
    //# settings
    //##################################################

    @Override
    protected boolean isEnabled()
    {
        return getProperties().getDeleteOldSystemLogsJobEnabled();
    }

    @Override
    protected int getActiveMs()
    {
        Integer seconds = getProperties().getDeleteOldSystemLogsJobActiveSeconds();
        return secondsToMs(seconds);
    }

    @Override
    protected int getIdleMs()
    {
        Integer seconds = getProperties().getDeleteOldSystemLogsJobIdleSeconds();
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

        MyApplicationLogFilter f;
        f = new MyApplicationLogFilter();
        f.setMaximumCreatedUtcTs(latest);
        f.sortOnCreatedUtcTs();

        KmList<MyApplicationLog> v = f.findFirst(limit);
        if ( v.isEmpty() )
            return false;

        for ( MyApplicationLog e : v )
            e.deleteDao();

        return true;
    }

}
