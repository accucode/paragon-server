package com.app.chore.system;

import com.app.chore.MyChore;
import com.app.utility.MyLog4jManager;

public class MyLog4jReloaderChore
    extends MyChore
{
    //##################################################
    //# settings
    //##################################################

    @Override
    protected boolean isEnabled()
    {
        return getProperties().getLog4jReloaderChoreEnabled();
    }

    @Override
    protected int getActiveMs()
    {
        Integer seconds = getProperties().getLog4jReloaderChoreActiveSeconds();
        return secondsToMs(seconds);
    }

    @Override
    protected int getIdleMs()
    {
        Integer seconds = getProperties().getLog4jReloaderChoreIdleSeconds();
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
        return MyLog4jManager.reload();
    }
}
