package com.app.job.application;

import com.kodemore.job.KmSimpleJobManager;

public class MyApplicationJobManager
    extends KmSimpleJobManager
{
    public MyApplicationJobManager()
    {
        add(new MyMonitorJob(getClass()));
        add(new MySendEmailJob());
        add(new MyPerformanceLogFlusherJob());
        add(new MyApplicationLogFlusherJob());
        add(new MyMaintenanceJob());
    }
}
