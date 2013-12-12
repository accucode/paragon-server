package com.app.dao;

import com.kodemore.collection.KmList;
import com.kodemore.hibernate.criteria.KmProjectionResult;
import com.kodemore.hibernate.criteria.KmProjectionRow;
import com.kodemore.time.KmDate;

import com.app.criteria.MyPerformanceLogCriteria;
import com.app.dao.base.MyPerformanceLogDaoBase;
import com.app.model.MyPerformanceLogSummaryVo;

public class MyPerformanceLogDao
    extends MyPerformanceLogDaoBase
{
    public KmList<MyPerformanceLogSummaryVo> findSummaries(KmDate start, KmDate end)
    {
        MyPerformanceLogCriteria c;
        c = createCriteria();
        c.selectName();
        c.selectMinimumDurationMs();
        c.selectMaximumDurationMs();
        c.selectAverageDurationMs();
        c.selectSumDurationMs();
        c.selectRowCount();
        c.groupByName();

        // timezone_wyatt: local > utc

        if ( start != null )
            c.whereCreatedUtcTs().isGreaterThanOrEqualTo(start.getStartOfDay());

        if ( end != null )
            c.whereCreatedUtcTs().isLessThanOrEqualTo(end.getEndOfDay());

        KmList<MyPerformanceLogSummaryVo> v = new KmList<MyPerformanceLogSummaryVo>();

        KmProjectionResult results = c.findResults();
        for ( KmProjectionRow row : results )
        {
            String name = row.nextString();
            Integer min = row.nextInteger();
            Integer max = row.nextInteger();
            Double avgD = row.nextDouble();

            Integer avg = avgD == null
                ? null
                : avgD.intValue();

            Integer total = row.nextInteger();
            Integer count = row.nextInteger();

            MyPerformanceLogSummaryVo e;
            e = new MyPerformanceLogSummaryVo();
            e.setName(name);
            e.setMinimumMs(min);
            e.setMaximumMs(max);
            e.setAverageMs(avg);
            e.setTotalMs(total);
            e.setCount(count);
            v.add(e);
        }
        return v;
    }
}
