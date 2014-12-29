package com.app.job.application;

import com.app.command.MyDeleteOldServerSessionsCommand;
import com.app.job.MyJob;

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
        MyDeleteOldServerSessionsCommand cmd;
        cmd = new MyDeleteOldServerSessionsCommand();
        cmd.run();
        return cmd.hasMore();
    }
}
