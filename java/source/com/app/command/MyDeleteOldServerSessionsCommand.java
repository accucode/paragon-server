package com.app.command;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDaoCommand;
import com.kodemore.time.KmTimestamp;

import com.app.filter.MyServerSessionFilter;
import com.app.model.MyServerSession;

public class MyDeleteOldServerSessionsCommand
    extends KmDaoCommand
{
    //##################################################
    //# variables
    //##################################################

    private boolean _hasMore;

    //##################################################
    //# constructor
    //##################################################//
    public MyDeleteOldServerSessionsCommand()
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

        MyServerSessionFilter f;
        f = new MyServerSessionFilter();
        f.setMaxCreatedUtcTs(latest);
        f.sortOnCreatedUtcTs();

        KmList<MyServerSession> v = f.findFirst(limit);
        for ( MyServerSession e : v )
            e.deleteDao();

        _hasMore = v.size() >= limit;
    }
}
