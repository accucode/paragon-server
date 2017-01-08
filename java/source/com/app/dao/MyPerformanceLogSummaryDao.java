package com.app.dao;

import com.kodemore.collection.KmList;
import com.kodemore.time.KmDate;

import com.app.criteria.MyPerformanceLogSummaryCriteria;
import com.app.dao.base.MyPerformanceLogSummaryDaoBase;

public class MyPerformanceLogSummaryDao
    extends MyPerformanceLogSummaryDaoBase
{
    /**
     * Find the last day for which daily logs have been created.
     */
    public KmDate getLastDateUtc()
    {
        MyPerformanceLogSummaryCriteria c;
        c = createCriteria();
        c.selectMaximumUtcDate();
        return c.findDate();
    }

    /**
     * Find the distinct list of names logged on a particular date.
     */
    public KmList<String> findNamesOn(KmDate date)
    {
        MyPerformanceLogSummaryCriteria c;
        c = createCriteria();
        c.selectDistinctName();
        c.whereUtcDate().is(date);
        return c.findStrings();
    }
}
