package com.app.job.application;

import com.kodemore.log.KmLogger;

import com.app.job.MyJob;

public class MyMonitorJob
    extends MyJob
{
    //##################################################
    //# log
    //##################################################

    private static final KmLogger logger = KmLogger.create(MyMonitorJob.class);

    //##################################################
    //# variables
    //##################################################

    private String                _name;

    //##################################################
    //# constructor
    //##################################################

    public MyMonitorJob(Class<?> clazz)
    {
        _name = clazz.getSimpleName();
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    protected boolean isEnabled()
    {
        return getProperties().getMonitorJobEnabled();
    }

    @Override
    protected int getActiveMs()
    {
        Integer seconds = getProperties().getMonitorJobActiveSeconds();
        return secondsToMs(seconds);
    }

    @Override
    protected int getIdleMs()
    {
        Integer seconds = getProperties().getMonitorJobIdleSeconds();
        return secondsToMs(seconds);
    }

    //##################################################
    //# run
    //##################################################

    @Override
    protected boolean handle()
    {
        logger.info(_name);
        return true;
    }
}
