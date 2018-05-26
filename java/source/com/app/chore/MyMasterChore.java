package com.app.chore;

import com.app.chore.application.MyApplicationChoreManager;
import com.app.chore.system.MySystemChoreManager;

public class MyMasterChore
    extends MyChore
{
    //##################################################
    //# variables
    //##################################################

    private MySystemChoreManager      _systemJobManager;
    private MyApplicationChoreManager _applicationJobManager;

    //##################################################
    //# constructor
    //##################################################

    public MyMasterChore()
    {
        _systemJobManager = new MySystemChoreManager();
        _applicationJobManager = new MyApplicationChoreManager();
    }

    //##################################################
    //# overrides
    //##################################################

    @Override
    protected boolean isEnabled()
    {
        return true;
    }

    @Override
    protected int getActiveMs()
    {
        return 1000;
    }

    @Override
    protected boolean logsPerformance()
    {
        return false;
    }

    //##################################################
    //# handle
    //##################################################

    @Override
    protected synchronized boolean handle()
    {
        if ( !_systemJobManager.isRunning() )
            _systemJobManager.start();

        if ( !_applicationJobManager.isRunning() )
            _applicationJobManager.start();

        return true;
    }

    @Override
    protected void handleStop()
    {
        _systemJobManager.stop();
        _applicationJobManager.stop();
    }
}
