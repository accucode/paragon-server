package com.app.job.application;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDao;
import com.kodemore.time.KmTimestamp;

import com.app.filter.MyServerSessionFilter;
import com.app.job.MyJob;
import com.app.model.MyServerSession;

/**
 * I delete any sessions older than a day.
 * This job intentionally ignores the last touch time.
 * Sessions will be forcibly expired (deleted) after a day
 * even if they are being constantly used.
 */
public class MyDeleteOldServerSessionsJob
    extends MyJob
{
    //##################################################
    //# settings
    //##################################################

    @Override
    protected boolean isEnabled()
    {
        return getProperties().getDeleteOldServerSessionsJobEnabled();
    }

    @Override
    protected int getActiveMs()
    {
        Integer seconds = getProperties().getDeleteOldServerSessionsJobActiveSeconds();
        return secondsToMs(seconds);
    }

    @Override
    protected int getIdleMs()
    {
        Integer seconds = getProperties().getDeleteOldServerSessionsJobIdleSeconds();
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

        MyServerSessionFilter f;
        f = new MyServerSessionFilter();
        f.setMaxCreatedUtcTs(latest);
        f.sortOnCreatedUtcTs();

        KmList<MyServerSession> v = f.findFirst(limit);
        if ( v.isEmpty() )
            return false;

        for ( MyServerSession e : v )
            e.deleteDao();

        return true;
    }
}
