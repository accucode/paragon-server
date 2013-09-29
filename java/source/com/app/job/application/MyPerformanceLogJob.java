package com.app.job.application;

import com.app.job.MyJob;
import com.app.model.MyPerformanceLog;
import com.app.model.MyPerformanceLogRegistry;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDaoCommand;

public class MyPerformanceLogJob
    extends MyJob
{
    //##################################################
    //# settings
    //##################################################

    @Override
    protected boolean isEnabled()
    {
        return getProperties().getPerformanceLogJobEnabled();
    }

    @Override
    protected int getActiveMs()
    {
        Integer seconds = getProperties().getPerformanceLogJobActiveSeconds();
        return secondsToMs(seconds);
    }

    @Override
    protected int getIdleMs()
    {
        Integer seconds = getProperties().getPerformanceLogJobIdleSeconds();
        return secondsToMs(seconds);
    }

    //##################################################
    //# run
    //##################################################

    @Override
    protected boolean run()
    {
        KmList<MyPerformanceLog> v = MyPerformanceLogRegistry.pop();
        if ( v.isEmpty() )
            return false;

        newCommand(v).run();
        return true;
    }

    private KmDaoCommand newCommand(final KmList<MyPerformanceLog> v)
    {
        return new KmDaoCommand()
        {
            @Override
            protected void handle()
            {
                for ( MyPerformanceLog e : v )
                    e.saveDao();
            }
        };
    }
}
