package com.app.chore.application;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDao;
import com.kodemore.log.KmLog;
import com.kodemore.time.KmClock;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmDateRange;

import com.app.dao.MyPerformanceLogDetailDao;
import com.app.dao.base.MyDaoAccess;
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
        KmDateRange di = KmDao.fetch(this::getDateRange);
        for ( KmDate date : di )
            consolidate(date);
    }

    //##################################################
    //# date range
    //##################################################

    private KmDateRange getDateRange()
    {
        // If summaries have already been created,  start at the last
        // known summary date in case it was incomplete.
        KmDate lastSummaryDate = getAccess().getPerformanceLogSummaryDao().getLastDateUtc();
        KmDate start = lastSummaryDate;

        // If there are no summaries yet, start from the first log.
        if ( start == null )
        {
            KmDate firstLogDate = getAccess().getPerformanceLogDetailDao().getFirstDateUtc();
            start = firstLogDate;
        }

        // If there are not details, start at yesterday.
        if ( start == null )
            start = getYesterdayUtc();

        // Stop at yesterday since today is likely incomplete.
        KmDate end = getYesterdayUtc();

        return KmDateRange.create(start, end);
    }

    private KmDate getYesterdayUtc()
    {
        return KmClock.getUtcTimestamp().getDate().getPrevious();
    }

    //##################################################
    //# consolidate
    //##################################################

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
        e.daoAttach();
    }

    //##################################################
    //# support
    //##################################################

    private MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
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
