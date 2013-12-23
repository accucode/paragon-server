package com.app.command;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDaoCommand;
import com.kodemore.time.KmTimestamp;

import com.app.filter.MyPerformanceLogFilter;
import com.app.model.MyPerformanceLog;

public class MyDeleteOldPerformanceLogsCommand
    extends KmDaoCommand
{
    //##################################################
    //# variables
    //##################################################

    private boolean _hasMore;

    //##################################################
    //# accessing
    //##################################################

    public boolean hasMore()
    {
        return _hasMore;
    }

    //##################################################
    //# run
    //##################################################

    @Override
    protected void handle()
    {
        int limit = 100;
        KmTimestamp latest = getNowUtc().subtractDay();

        MyPerformanceLogFilter f;
        f = new MyPerformanceLogFilter();
        f.setMaximumCreatedUtcTs(latest);
        f.sortOnCreatedUtcTs();

        KmList<MyPerformanceLog> v = f.findFirst(limit);
        for ( MyPerformanceLog e : v )
            e.deleteDao();

        _hasMore = v.size() >= limit;
    }
}
