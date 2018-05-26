package com.app.chore;

import com.kodemore.log.KmLogger;

public class MyMonitorChore
    extends MyChore
{
    //##################################################
    //# log
    //##################################################

    private static final KmLogger logger = KmLogger.create(MyMonitorChore.class);

    //##################################################
    //# variables
    //##################################################

    private String _name;

    //##################################################
    //# constructor
    //##################################################

    public MyMonitorChore(Class<?> clazz)
    {
        _name = clazz.getSimpleName();
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    protected boolean isEnabled()
    {
        return getProperties().getMonitorChoreEnabled();
    }

    @Override
    protected int getActiveMs()
    {
        Integer seconds = getProperties().getMonitorChoreActiveSeconds();
        return secondsToMs(seconds);
    }

    @Override
    protected int getIdleMs()
    {
        Integer seconds = getProperties().getMonitorChoreIdleSeconds();
        return secondsToMs(seconds);
    }

    @Override
    protected boolean logsPerformance()
    {
        return true;
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
