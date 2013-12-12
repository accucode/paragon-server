package com.app.command.core;

import com.kodemore.command.KmDaoCommand;

import com.app.model.core.MyAbstractDomain;

public class MyDeleteDaoCommand<T extends MyAbstractDomain>
    extends KmDaoCommand
{
    //##################################################
    //# variables (input)
    //##################################################

    private T _value;

    //##################################################
    //# constructor
    //##################################################

    public MyDeleteDaoCommand(T e)
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
        getValue().deleteDao();
    }

}
