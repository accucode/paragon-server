package com.app.dao;

import com.kodemore.collection.KmList;
import com.kodemore.hibernate.KmhProjectionRow;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimestamp;

import com.app.criteria.MyPerformanceLogDetailCriteria;
import com.app.dao.base.MyPerformanceLogDetailDaoBase;
import com.app.filter.MyPerformanceLogDetailFilter;
import com.app.model.MyPerformanceLogDetail;
import com.app.model.MyPerformanceLogSummary;

public class MyPerformanceLogDetailDao
    extends MyPerformanceLogDetailDaoBase
{
    /**
     * Consolidate the logs by date and name.
     * The date and name are both required.
     */
    public MyPerformanceLogSummary consolidate(KmDate date, String name)
    {
        MyPerformanceLogDetailCriteria c;
        c = createCriteria();
        c.selectMinimumDurationMs();
        c.selectMaximumDurationMs();
        c.selectAverageDurationMs();
        c.selectSumDurationMs();
        c.selectRowCount();
        c.whereCreatedUtcTs().isOn(date);
        c.whereName().is(name);

        KmhProjectionRow row = c.findResults().getFirstRow();

        Integer min = row.nextInteger();
        Integer max = row.nextInteger();
        Double avgD = row.nextDouble();

        Integer avg = avgD == null
            ? null
            : avgD.intValue();

        Integer total = row.nextInteger();
        Integer count = row.nextInteger();

        MyPerformanceLogSummary e;
        e = new MyPerformanceLogSummary();
        e.setUtcDate(date);
        e.setName(name);
        e.setMinimumMs(min);
        e.setMaximumMs(max);
        e.setAverageMs(avg);
        e.setTotalMs(total);
        e.setCount(count);
        return e;
    }

    /**
     * Find the distinct list of names logged on a particular date.
     */
    public KmList<String> findNamesOn(KmDate date)
    {
        MyPerformanceLogDetailCriteria c;
        c = createCriteria();
        c.selectDistinctName();
        c.whereCreatedUtcTs().isOn(date);
        return c.findStrings();
    }

    /**
     * Delete a small batch of logs older than a ~week.
     *
     * Return true if logs were deleted and/or there may be more logs to be deleted.
     * Return false if no logs were deleted and/or there are no more logs to be deleted.
     */
    public boolean deleteOldLogs()
    {
        int limit = 500;
        KmTimestamp latest = getNowUtc().subtractWeek().getStartOfDay();

        MyPerformanceLogDetailFilter f;
        f = new MyPerformanceLogDetailFilter();
        f.setMaximumCreatedUtcTs(latest);
        f.sortOnCreatedUtcTs();

        KmList<MyPerformanceLogDetail> v = f.findFirst(limit);
        if ( v.isEmpty() )
            return false;

        for ( MyPerformanceLogDetail e : v )
            e.daoDelete();

        return true;
    }

    public KmDate getFirstDateUtc()
    {
        MyPerformanceLogDetailCriteria c;
        c = createCriteria();
        c.selectMinimumCreatedUtcTs();

        KmTimestamp ts = c.findTimestamp();
        return ts == null
            ? null
            : ts.getDate();
    }

}
