package com.app.dao;

import com.app.dao.base.MySettingsDaoBase;
import com.app.model.MySettings;

public class MySettingsDao
    extends MySettingsDaoBase
{
    //##################################################
    //# constants
    //##################################################

    public static final int UNIQUE_CODE = 1;

    //##################################################
    //# accessing
    //##################################################

    public MySettings getSettings()
    {
        return findCode(UNIQUE_CODE);
    }

    //##################################################
    //# bootstrap
    //##################################################
    /**
     * This should only be called once, when the system is bootstrapped.
     */
    public void installSettings()
    {
        MySettings e;
        e = new MySettings();
        e.setCode(UNIQUE_CODE);
        e.saveDao();
    }
}
