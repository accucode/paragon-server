package com.app.chore.application;

import com.kodemore.command.KmDao;
import com.kodemore.log.KmLog;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimestamp;

import com.app.chore.MyThreadTopicChore;
import com.app.model.MyThreadTopic;
import com.app.utility.MyUtility;

/**
 * I consolidate various nighly maintenance activities.
 * I should only be run once a day, and only by a single JVM.
 */
public class MyMaintenanceChore
    extends MyThreadTopicChore
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The last date on which the maintenance job is known to have successfully
     * finished.  If the maintenance job has already run today, then there is no
     * need to run it again until tomorrow.
     */
    private KmDate _lastDate;

    //##################################################
    //# settings
    //##################################################

    @Override
    protected boolean isEnabled()
    {
        return getProperties().getMaintenanceChoreEnabled()
            && isMaintenancePeriod()
            && !alreadyRunToday();
    }

    @Override
    protected int getActiveMs()
    {
        Integer seconds = getProperties().getMaintenanceChoreActiveSeconds();
        return secondsToMs(seconds);
    }

    @Override
    protected int getIdleMs()
    {
        Integer seconds = getProperties().getMaintenanceChoreIdleSeconds();
        return secondsToMs(seconds);
    }

    @Override
    protected boolean logsPerformance()
    {
        return true;
    }

    //==================================================
    //= settings :: support
    //==================================================

    /**
     * Typically something like 1am-4am, daily.
     */
    protected boolean isMaintenancePeriod()
    {
        return MyUtility.isMaintenancePeriod();
    }

    /**
     * Return true if maintenance has already been run today.
     */
    private boolean alreadyRunToday()
    {
        KmDate today = getNowUtc().getDate();

        if ( _lastDate != null )
            if ( _lastDate.isOnOrAfter(today) )
                return true;

        MyThreadTopic e = getDetachedThreadTopic();
        if ( e == null )
            return false;

        KmTimestamp lastEnd = e.getLastEndUtcTs();
        if ( lastEnd == null )
            return false;

        _lastDate = lastEnd.getDate();
        return _lastDate.isOnOrAfter(today);
    }

    //##################################################
    //# run
    //##################################################

    @Override
    protected boolean handle()
    {
        log("start...");

        consolidatePerformanceLogs();
        deletePerformanceLogs();
        deleteApplicationLogs();
        deleteServerSessions();

        log("done.");

        return false;
    }

    //==================================================
    //= consolidate performance logs
    //==================================================

    private void consolidatePerformanceLogs()
    {
        log("consolidate performance logs...");
        touch();

        MyPerformanceLogConsolidator e;
        e = new MyPerformanceLogConsolidator();
        e.setStepListener(this::touch);
        e.run();
    }

    //==================================================
    //= delete performance logs
    //==================================================

    private void deletePerformanceLogs()
    {
        boolean hasMore = true;
        while ( hasMore )
        {
            log("delete performance logs...");
            touch();
            hasMore = KmDao.fetch(this::deletePerformanceLogsDao);
        }
    }

    private boolean deletePerformanceLogsDao()
    {
        return getAccess().getPerformanceLogDetailDao().deleteOldLogs();
    }

    //==================================================
    //= delete application logs
    //==================================================

    private void deleteApplicationLogs()
    {
        boolean hasMore = true;
        while ( hasMore )
        {
            log("delete application logs...");
            touch();
            hasMore = KmDao.fetch(this::deleteApplicationLogsDao);
        }
    }

    private boolean deleteApplicationLogsDao()
    {
        return getAccess().getApplicationLogDao().deleteOldLogs();
    }

    //==================================================
    //= server sessions
    //==================================================

    private void deleteServerSessions()
    {
        boolean hasMore = true;
        while ( hasMore )
        {
            log("delete server sessions...");
            touch();
            hasMore = KmDao.fetch(this::deleteServerSessionsDao);
        }
    }

    private boolean deleteServerSessionsDao()
    {
        return getAccess().getServerSessionDao().deleteOldSessions();
    }

    //##################################################
    //# support
    //##################################################

    private void log(String msg, Object... args)
    {
        KmLog.printfln("Maintenance Chore; " + msg, args);
    }

}
