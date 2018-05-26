package com.app.chore.system;

import com.app.chore.MyChore;
import com.app.property.MyPropertyManager;

public class MyOverridesReloaderChore
    extends MyChore
{
    //##################################################
    //# settings
    //##################################################

    @Override
    protected boolean isEnabled()
    {
        return getProperties().getOverridesReloaderChoreEnabled();
    }

    @Override
    protected int getActiveMs()
    {
        Integer seconds = getProperties().getOverridesReloaderChoreActiveSeconds();
        return secondsToMs(seconds);
    }

    @Override
    protected int getIdleMs()
    {
        Integer seconds = getProperties().getOverridesReloaderChoreIdleSeconds();
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
        return MyPropertyManager.reloadOverrides();
    }
}
