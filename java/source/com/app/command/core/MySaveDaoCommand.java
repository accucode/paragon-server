package com.app.command.core;

import com.app.model.core.MyAbstractDomain;

import com.kodemore.command.KmDaoCommand;

public class MySaveDaoCommand<T extends MyAbstractDomain>
    extends KmDaoCommand
{
    //##################################################
    //# variables (input)
    //##################################################

    private T _value;

    //##################################################
    //# constructor
    //##################################################

    public MySaveDaoCommand(T e)
    {
        setValue(e);
    }

    //##################################################
    //# accessing
    //##################################################

    public T getValue()
    {
        return _value;
    }

    public void setValue(T e)
    {
        _value = e;
    }

    //##################################################
    //# run
    //##################################################

    @Override
    public void handle()
    {
        T e;
        e = getValue();
        e.validate();
        e.saveDao();
    }

}
