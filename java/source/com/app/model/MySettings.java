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
    public String getAuditLogTitle()
    {
        return "settings";
    }

    @Override
    public String getDomainTitle()
    {
        return "settings";
    }

    @Override
    public String getDomainSubtitle()
    {
        return null;
    }

}
