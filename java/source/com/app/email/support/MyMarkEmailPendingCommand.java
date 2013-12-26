package com.app.email.support;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDaoCommand;

import com.app.command.core.MyCommandLocksIF;
import com.app.filter.MyEmailFilter;
import com.app.model.MyEmail;
import com.app.model.MyEmailStatus;

public class MyMarkEmailPendingCommand
    extends KmDaoCommand
{
    //##################################################
    //# variables
    //##################################################

    private Integer         _maximumCount;
    private KmList<MyEmail> _emails;

    //##################################################
    //# constructor
    //##################################################

    public MyMarkEmailPendingCommand()
    {
        _maximumCount = null;
        _emails = null;
    }

    //##################################################
    //# accessing (input)
    //##################################################

    public void setMaximumCount(Integer e)
    {
        _maximumCount = e;
    }

    public KmList<MyEmail> getEmails()
    {
        return _emails;
    }

    //##################################################
    //# run
    //##################################################

    @Override
    public void handle()
    {
        MyEmailFilter f;
        f = new MyEmailFilter();
        f.setStatusCode(MyEmailStatus.Ready);
        f.sortOnCreatedUtcTs();

        if ( _maximumCount == null )
            _emails = f.findAll();
        else
            _emails = f.findFirst(_maximumCount);

        for ( MyEmail e : _emails )
        {
            e.markPending();
            fetch(e.getBaseRecipients());
            fetch(e.getBaseParts());
        }
    }

    //##################################################
    //# locks
    //##################################################

    @Override
    public String getLockKey()
    {
        // todo_wyatt: Pessimistic Lock
        return MyCommandLocksIF.LOCK_EMAIL;
    }

}
