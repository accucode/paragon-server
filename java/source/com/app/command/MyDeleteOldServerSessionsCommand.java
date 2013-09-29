package com.app.command;

import com.app.filter.MyServerSessionFilter;
import com.app.model.MyServerSession;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDaoCommand;
import com.kodemore.time.KmTimestamp;

public class MyDeleteOldServerSessionsCommand
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
