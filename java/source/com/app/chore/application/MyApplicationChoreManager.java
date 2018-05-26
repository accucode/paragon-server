package com.app.chore.application;

import com.kodemore.chore.KmSimpleChoreManager;

import com.app.chore.MyMonitorChore;

public class MyApplicationChoreManager
    extends KmSimpleChoreManager
{
    public MyApplicationChoreManager()
    {
        add(new MyApplicationLogFlusherChore());
        add(new MyClearThemeCacheChore());
        add(new MyMaintenanceChore());
        add(new MyMonitorChore(getClass()));
        add(new MyPerformanceLogFlusherChore());
        add(new MySendEmailChore());
    }
}
