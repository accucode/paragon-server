package com.app.chore.application;

import com.app.chore.MyChore;
import com.app.email.MyEmailSender;

public class MySendEmailChore
    extends MyChore
{
    //##################################################
    //# settings
    //##################################################

    @Override
    protected boolean isEnabled()
    {
        return getProperties().getSendEmailChoreEnabled();
    }

    @Override
    protected int getActiveMs()
    {
        Integer seconds = getProperties().getSendEmailChoreActiveSeconds();
        return secondsToMs(seconds);
    }

    @Override
    protected int getIdleMs()
    {
        Integer seconds = getProperties().getSendEmailChoreIdleSeconds();
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
