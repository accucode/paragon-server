package com.app.property;

import com.app.property.base.MyPropertyRegistryBase;

public class MyPropertyRegistry
    extends MyPropertyRegistryBase
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
