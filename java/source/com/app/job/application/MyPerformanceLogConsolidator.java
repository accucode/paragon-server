package com.app.job.application;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDao;
import com.kodemore.log.KmLog;
import com.kodemore.time.KmClock;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmDateInterval;

import com.app.dao.MyPerformanceLogDetailDao;
import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyPerformanceLogSummary;
import com.app.utility.MyGlobals;

/**
 * Consolidate the individual performance logs into daily summaries.
 * This is typically run as part of nightly maintenance.
 * I am designed to manage my own transactions.
 */
public class MyPerformanceLogConsolidator
{
    //##################################################
    //# variables
    //##################################################

    /**
     * If set, this listener will be called after each day/name is updated.
     *
     * The callback is NOT wrapped in a transaction and should manage its
     * own hibernate session if one is needed.
     */
    private Runnable _stepListener;

    //##################################################
    //# accessing
    //##################################################

    public Runnable getStepListener()
    {
        return _stepListener;
    }

    public void setStepListener(Runnable e)
    {
        _stepListener = e;
    }

    public void fireStepListener()
    {
        if ( _stepListener != null )
            _stepListener.run();
    }

    //##################################################
    //# run
    //##################################################

    public void run()
    {
        // End at yesterday, since today is likely not finished yet.
        KmDate end = KmClock.getTodayUtc().getPrevious();

        // Start on the last day with existing daily logs in case it was only partially completed.
        KmDate start = KmDao.fetch(this::getLastSummaryDate);
        if ( start == null )
            start = end;

        KmDateInterval di = KmDateInterval.create(start, end);
        for ( KmDate date : di )
            consolidate(date);
    }

    /**
     * Consolidate all logs for this date.
     * Skip any names that have already been consolidated.
     */
    private void consolidate(KmDate date)
    {
        KmList<String> detailNames = KmDao.fetch(this::getDetailNamesOn, date);
        KmList<String> dailyNames = KmDao.fetch(this::getSummaryNamesOn, date);

        KmList<String> v;
        v = new KmList<>();
        v.addAll(detailNames);
        v.removeAll(dailyNames);
        v.sort();

        for ( String name : v )
        {
            KmDao.run(this::consolidate, date, name);
            log("Performance Log, consolidated %s %s.", date.format_mm_dd_yy(), name);
            fireStepListener();
        }
    }

    /**
     * Consolidate all logs for this date and name.
     *
     * Each date/name is consolidated as a separate transaction to keep
     * the tranasactions short.
     */
    private void consolidate(KmDate date, String name)
    {
        MyPerformanceLogDetailDao dao = getAccess().getPerformanceLogDetailDao();

        MyPerformanceLogSummary e;
        e = dao.consolidate(date, name);
        e.attachDao();
    }

    //##################################################
    //# support
    //##################################################

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }

    private KmDate getLastSummaryDate()
    {
        return getAccess().getPerformanceLogSummaryDao().getLastDay();
    }

    private KmList<String> getDetailNamesOn(KmDate date)
    {
        return getAccess().getPerformanceLogDetailDao().findNamesOn(date);
    }

    private KmList<String> getSummaryNamesOn(KmDate date)
    {
        return getAccess().getPerformanceLogSummaryDao().findNamesOn(date);
    }

    private void log(String msg, Object... args)
    {
        KmLog.printfln(msg, args);
    }

}
