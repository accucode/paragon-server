package com.app.job.system;

import com.kodemore.job.KmSimpleJobManager;

import com.app.job.application.MyMonitorJob;

public class MySystemJobManager
    extends KmSimpleJobManager
{
    public MySystemJobManager()
    {
        add(new MyMonitorJob(getClass()));
        add(new MyClockJob());
        add(new MyOverridesReloaderJob());
        add(new MyLog4jReloaderJob());
    }

}
