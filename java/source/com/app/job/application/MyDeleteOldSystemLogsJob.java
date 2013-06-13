package com.app.job.application;

import com.app.command.MyDeleteOldSystemLogsCommand;
import com.app.job.MyJob;

public class MyDeleteOldSystemLogsJob
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
    protected boolean run()
    {
        MyDeleteOldSystemLogsCommand cmd;
        cmd = new MyDeleteOldSystemLogsCommand();
        cmd.setWarningThresholdMs(5000);
        cmd.run();
        return cmd.hasMore();
    }
}
