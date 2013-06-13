package com.app.command.core;

import com.kodemore.command.KmDaoCommand;

import com.app.model.core.MyAbstractModel;

public class MyDeleteDaoCommand<T extends MyAbstractModel>
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
