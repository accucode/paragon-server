package com.app.job;

import com.kodemore.job.KmSimpleJobManager;

public class MyMasterJobManager
    extends KmSimpleJobManager
{
    //##################################################
    //# install / shutdown
    //##################################################

    private static MyMasterJobManager _instance;

    public static void install()
    {
        _instance = new MyMasterJobManager();
        _instance.add(new MyMasterJob());
        _instance.start();
    }

    public static MyMasterJobManager getInstance()
    {
        return _instance;
    }
}
