package com.app.job.system;

import com.app.job.application.MyMonitorJob;

import com.kodemore.job.KmSimpleJobManager;

public class MySystemJobManager
    extends KmSimpleJobManager
{
    public MySystemJobManager()
    {
        add(new MyMonitorJob("SystemJobManager"));
        add(new MyClockJob());
        add(new MyOverridesReloaderJob());
        add(new MyLog4jReloaderJob());
    }

}
