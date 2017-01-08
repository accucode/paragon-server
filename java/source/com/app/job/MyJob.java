package com.app.job;

import com.kodemore.job.KmJob;
import com.kodemore.time.KmClock;
import com.kodemore.time.KmTimestamp;

import com.app.dao.base.MyDaoAccess;
import com.app.model.MyPerformanceLogBuffer;
import com.app.property.MyProperties;
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
        boolean enabled = getProperties().getJobPerformanceLogEnabled();
        if ( enabled )
            MyPerformanceLogBuffer.push("job... " + getName(), ms);
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

    protected MyProperties getProperties()
    {
        return MyGlobals.getProperties();
    }

    protected KmTimestamp getNowUtc()
    {
        return KmClock.getUtcTimestamp();
    }

    protected MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }
}
