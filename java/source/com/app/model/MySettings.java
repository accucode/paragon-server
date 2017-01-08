package com.app.model;

import com.app.model.base.MySettingsBase;
import com.app.model.core.MySystemDomainIF;

public class MySettings
    extends MySettingsBase
    implements MySystemDomainIF
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
