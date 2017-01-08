package com.app.job.application;

import com.app.job.MyJob;
import com.app.ui.servlet.MyServletFilter;

/**
 * Periodically clear the theme uri cache.
 */
public class MyClearThemeCacheJob
    extends MyJob
{
    //##################################################
    //# settings
    //##################################################

    @Override
    protected boolean isEnabled()
    {
        return getProperties().getClearThemeCacheJobEnabled();
    }

    @Override
    protected int getActiveMs()
    {
        Integer seconds = getProperties().getClearThemeCacheJobActiveSeconds();
        return secondsToMs(seconds);
    }

    @Override
    protected int getIdleMs()
    {
        Integer seconds = getProperties().getClearThemeCacheJobIdleSeconds();
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
        MyServletFilter.clearCachedThemeUris();
        return false;
    }

}
