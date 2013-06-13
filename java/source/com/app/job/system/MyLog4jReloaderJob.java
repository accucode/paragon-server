package com.app.job.system;

import com.app.job.MyJob;
import com.app.utility.MyLog4jManager;

public class MyLog4jReloaderJob
    extends MyJob
{
    //##################################################
    //# settings
    //##################################################

    @Override
    protected boolean isEnabled()
    {
        return getProperties().getLog4jReloaderJobEnabled();
    }

    @Override
    protected int getActiveMs()
    {
        Integer seconds = getProperties().getLog4jReloaderJobActiveSeconds();
        return secondsToMs(seconds);
    }

    @Override
    protected int getIdleMs()
    {
        Integer seconds = getProperties().getLog4jReloaderJobIdleSeconds();
        return secondsToMs(seconds);
    }

    //##################################################
    //# run
    //##################################################

    @Override
    protected boolean run()
    {
        return MyLog4jManager.reload();
    }
}
