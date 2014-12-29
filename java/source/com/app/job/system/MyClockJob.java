package com.app.job.system;

import com.app.job.MyJob;
import com.app.utility.MyClock;

public class MyClockJob
    extends MyJob
{
    //##################################################
    //# settings
    //##################################################

    @Override
    protected boolean isEnabled()
    {
        return true;
    }

    @Override
    protected int getActiveMs()
    {
        return 500;
    }

    //##################################################
    //# run
    //##################################################

    @Override
    protected boolean handle()
    {
        MyClock.update();
        return true;
    }
}
