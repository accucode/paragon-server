package com.app.job;

import com.kodemore.job.KmJob;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.KmClock;

import com.app.model.MyPerformanceLogRegistry;
import com.app.property.MyPropertyRegistry;
import com.app.utility.MyGlobals;
import com.app.utility.MyUtility;

public abstract class MyJob
    extends KmJob
{
    //##################################################
    //# logging
    //##################################################

    @Override
    protected void logPerformance(int ms)
    {
        MyPerformanceLogRegistry.push(getName(), ms);
    }

    //##################################################
    //# runnable
    //##################################################

    @Override
    protected boolean isRunnable()
    {
        if ( !super.isRunnable() )
            return false;

        if ( isMaintenanceJob() && !isMaintenancePeriod() )
            return false;

        return true;
    }

    /**
     * Determines is this is a "maintenance" job.  That is, a job
     * that should be performed periodically during maintenance
     * periods.  This is used to schedule potentially slow jobs
     * during periods when the system is otherwise inactive so
     * that we can avoid impacting production during business hours.
     */
    protected boolean isMaintenanceJob()
    {
        return false;
    }

    /**
     * Determines when maintenance jobs should run.  Typically
     * returns from for something like 1am-4am, daily.  Or
     * once a week on Sunday night.
     */
    protected boolean isMaintenancePeriod()
    {
        return MyUtility.isMaintenancePeriod();
    }

    //##################################################
    //# convenience
    //##################################################

    protected MyPropertyRegistry getProperties()
    {
        return MyGlobals.getProperties();
    }

    protected KmTimestamp getNowUtc()
    {
        return KmClock.getNowUtc();
    }

    protected KmDate getTodayUtc()
    {
        return KmClock.getTodayUtc();
    }

}
