package com.app.job.application;

import com.kodemore.job.KmSimpleJobManager;

public class MyApplicationJobManager
    extends KmSimpleJobManager
{
    public MyApplicationJobManager()
    {
        add(new MyMonitorJob("ApplicationJobManager"));
        add(new MySendEmailJob());
        add(new MyDeleteOldServerSessionsJob());
        add(new MyDeleteOldApplicationLogsJob());
        add(new MyDeleteOldPerformanceLogsJob());
        add(new MyPerformanceLogJob());
    }
}
