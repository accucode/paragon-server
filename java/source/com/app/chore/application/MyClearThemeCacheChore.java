package com.app.chore.application;

import com.app.chore.MyChore;
import com.app.ui.servlet.MyServletFilter;

/**
 * Periodically clear the theme uri cache.
 */
public class MyClearThemeCacheChore
    extends MyChore
{
    //##################################################
    //# settings
    //##################################################

    @Override
    protected boolean isEnabled()
    {
        return getProperties().getClearThemeCacheChoreEnabled();
    }

    @Override
    protected int getActiveMs()
    {
        Integer seconds = getProperties().getClearThemeCacheChoreActiveSeconds();
        return secondsToMs(seconds);
    }

    @Override
    protected int getIdleMs()
    {
        Integer seconds = getProperties().getClearThemeCacheChoreIdleSeconds();
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
