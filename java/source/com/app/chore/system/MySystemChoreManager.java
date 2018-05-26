package com.app.chore.system;

import com.kodemore.chore.KmSimpleChoreManager;

import com.app.chore.MyMonitorChore;

public class MySystemChoreManager
    extends KmSimpleChoreManager
{
    public MySystemChoreManager()
    {
        add(new MyMonitorChore(getClass()));
        add(new MyOverridesReloaderChore());
        add(new MyLog4jReloaderChore());
    }

}
