package com.app.bridge;

import com.kodemore.command.KmDaoBridge;

import com.app.property.MyPropertyRegistry;
import com.app.ui.core.MyServletData;
import com.app.utility.MyGlobals;

public class MyDaoBridge
    extends KmDaoBridge
{
    //##################################################
    //# install
    //##################################################

    public static void install()
    {
        install(new MyDaoBridge());
    }

    //##################################################
    //# constructor
    //##################################################

    protected MyDaoBridge()
    {
        // protected
    }

    //##################################################
    //# warning
    //##################################################

    @Override
    public int getWarningThresholdMs()
    {
        return getProperties().getDaoCommandWarningThresholdMs();
    }

    //##################################################
    //# lock retry
    //##################################################

    @Override
    public int getLockRetryCount()
    {
        return 0;
    }

    @Override
    public int getLockRetryDelayMs()
    {
        return 0;
    }

    @Override
    public int getLockTimeoutSeconds()
    {
        return 0;
    }

    //##################################################
    //# stale object
    //##################################################

    @Override
    protected int getStaleObjectRetryCount()
    {
        return 10;
    }

    @Override
    protected int getStaleObjectRetryDelayMs()
    {
        return 10;
    }

    @Override
    protected void onStaleObjectRetry()
    {
        MyServletData data = MyServletData.getLocal();
        if ( data != null )
            data.reset();
    }

    //##################################################
    //# support
    //##################################################

    private MyPropertyRegistry getProperties()
    {
        return MyGlobals.getProperties();
    }

}
