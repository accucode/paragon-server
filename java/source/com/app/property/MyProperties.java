package com.app.property;

import com.app.property.base.MyPropertiesBase;

public class MyProperties
    extends MyPropertiesBase
{
    //##################################################
    //# environment
    //##################################################

    public boolean isEnvironmentDevelopment()
    {
        return getEnvironment().equals("development");
    }

    public boolean isEnvironmentStage()
    {
        return getEnvironment().equals("stage");
    }

    public boolean isEnvironmentProduction()
    {
        return getEnvironment().equals("production");
    }
}
