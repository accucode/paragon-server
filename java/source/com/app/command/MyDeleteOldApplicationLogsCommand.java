package com.app.command;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDaoCommand;
import com.kodemore.time.KmTimestamp;

import com.app.filter.MyApplicationLogFilter;
import com.app.model.MyApplicationLog;

public class MyDeleteOldApplicationLogsCommand
    extends KmDaoCommand
{
    //##################################################
    //# variables
    //##################################################

    private boolean _hasMore;

    //##################################################
    //# contstructor
    //##################################################
    public MyDeleteOldApplicationLogsCommand()
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

        MyApplicationLogFilter f;
        f = new MyApplicationLogFilter();
        f.setMaximumCreatedUtcTs(latest);
        f.sortOnCreatedUtcTs();

        KmList<MyApplicationLog> v = f.findFirst(limit);
        for ( MyApplicationLog e : v )
            e.deleteDao();

        _hasMore = v.size() >= limit;
    }

}
