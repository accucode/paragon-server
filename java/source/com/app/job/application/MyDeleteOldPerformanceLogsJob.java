package com.app.job.application;

import com.app.command.MyDeleteOldPerformanceLogsCommand;
import com.app.job.MyJob;

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
    protected boolean run()
    {
        MyDeleteOldPerformanceLogsCommand cmd;
        cmd = new MyDeleteOldPerformanceLogsCommand();
        cmd.run();
        return cmd.hasMore();
    }
}
