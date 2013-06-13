package com.app.job.system;

import com.app.job.MyJob;
import com.app.property.MyPropertyManager;

public class MyOverridesReloaderJob
    extends MyJob
{
    //##################################################
    //# settings
    //##################################################

    @Override
    protected boolean isEnabled()
    {
        return getProperties().getOverridesReloaderJobEnabled();
    }

    @Override
    protected int getActiveMs()
    {
        Integer seconds = getProperties().getOverridesReloaderJobActiveSeconds();
        return secondsToMs(seconds);
    }

    @Override
    protected int getIdleMs()
    {
        Integer seconds = getProperties().getOverridesReloaderJobIdleSeconds();
        return secondsToMs(seconds);
    }

    //##################################################
    //# run
    //##################################################

    @Override
    protected boolean run()
    {
        return MyPropertyManager.reloadOverrides();
    }
}
