package com.app.job.application;

import com.app.email.MyEmailSender;
import com.app.job.MyJob;

public class MySendEmailJob
    extends MyJob
{
    //##################################################
    //# settings
    //##################################################

    @Override
    protected boolean isEnabled()
    {
        return getProperties().getSendEmailJobEnabled();
    }

    @Override
    protected int getActiveMs()
    {
        Integer seconds = getProperties().getSendEmailJobActiveSeconds();
        return secondsToMs(seconds);
    }

    @Override
    protected int getIdleMs()
    {
        Integer seconds = getProperties().getSendEmailJobIdleSeconds();
        return secondsToMs(seconds);
    }

    @Override
    protected boolean logsPerformance()
    {
        return false;
    }

    //##################################################
    //# run
    //##################################################

    @Override
    protected boolean handle()
    {
        return MyEmailSender.staticRunBatch().isNotEmpty();
    }

}
