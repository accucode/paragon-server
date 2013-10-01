package com.app.job;

import com.app.job.application.MyApplicationJobManager;
import com.app.job.system.MySystemJobManager;

import com.kodemore.job.KmJobManager;
import com.kodemore.job.KmSimpleJobManager;

public class MyMasterJob
    extends MyJob
{
    //##################################################
    //# install / shutdown
    //##################################################

    private static MyMasterJob  _instance;
    private static KmJobManager _manager;

    public static void install()
    {
        _instance = new MyMasterJob();

        KmSimpleJobManager e;
        e = new KmSimpleJobManager();
        e.setName("Master");
        e.add(_instance);
        e.startDelayedSeconds(5);
        _manager = e;
    }

    public static void shutdown()
    {
        _instance._shutdown();
        _manager.stop();
    }

    //##################################################
    //# variables
    //##################################################

    private boolean                 _shutdown;
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
    //# accessing
    //##################################################

    @Override
    public boolean isEnabled()
    {
        return !isShutdown();
    }

    @Override
    public int getActiveMs()
    {
        return 1000;
    }

    @Override
    public synchronized boolean run()
    {
        if ( _shutdown )
            return false;

        boolean active = false;

        if ( !_systemJobManager.isRunning() )
        {
            _systemJobManager.start();
            active = true;
        }

        if ( !_applicationJobManager.isRunning() )
        {
            _applicationJobManager.start();
            active = true;
        }

        return active;
    }

    public synchronized boolean isShutdown()
    {
        return _shutdown;
    }

    private synchronized void _shutdown()
    {
        _shutdown = true;
        _systemJobManager.stop();
        _applicationJobManager.stop();
    }

}
