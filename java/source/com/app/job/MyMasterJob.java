package com.app.job;

import com.app.job.application.MyApplicationJobManager;
import com.app.job.system.MySystemJobManager;

public class MyMasterJob
    extends MyJob
{
    //##################################################
    //# variables
    //##################################################

    private MySystemJobManager      _systemJobManager;
    private MyApplicationJobManager _applicationJobManager;

    //##################################################
    //# constructor
    //##################################################

    public MyMasterJob()
    {
        _systemJobManager = new MySystemJobManager();
        _applicationJobManager = new MyApplicationJobManager();
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
