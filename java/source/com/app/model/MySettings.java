package com.app.model;

import com.app.model.base.MySettingsBase;

public class MySettings
    extends MySettingsBase
{
    //##################################################
    //# constructor
    //##################################################

    public MySettings()
    {
        super();
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getDisplayString()
    {
        return "settings";
    }

}
