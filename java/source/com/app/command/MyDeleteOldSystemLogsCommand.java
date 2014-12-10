package com.app.command;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDaoCommand;
import com.kodemore.time.KmTimestamp;

import com.app.filter.MySystemLogFilter;
import com.app.model.MySystemLog;

public class MyDeleteOldSystemLogsCommand
    extends KmDaoCommand
{
    //##################################################
    //# variables
    //##################################################

    private boolean _hasMore;

    //##################################################
    //# contstructor
    //##################################################
    public MyDeleteOldSystemLogsCommand()
    {
        setIgnoreStaleExceptions(true);
    }

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

        MySystemLogFilter f;
        f = new MySystemLogFilter();
        f.setMaximumCreatedUtcTs(latest);
        f.sortOnCreatedUtcTs();

        KmList<MySystemLog> v = f.findFirst(limit);
        for ( MySystemLog e : v )
            e.deleteDao();

        _hasMore = v.size() >= limit;
    }

}
