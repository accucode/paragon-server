package com.app.chore;

import com.kodemore.chore.KmSimpleChoreManager;

public class MyMasterChoreManager
    extends KmSimpleChoreManager
{
    //##################################################
    //# install / shutdown
    //##################################################

    private static MyMasterChoreManager _instance;

    public static void install()
    {
        _instance = new MyMasterChoreManager();
        _instance.add(new MyMasterChore());
        _instance.start();
    }

    public static MyMasterChoreManager getInstance()
    {
        return _instance;
    }
}
