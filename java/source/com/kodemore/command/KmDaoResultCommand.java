package com.kodemore.command;

public abstract class KmDaoResultCommand<T>
    extends KmDaoCommand
{
    //##################################################
    //# variables
    //##################################################

    private T _result;

    //##################################################
    //# run
    //##################################################

    public T runResult()
    {
        run();
        return _result;
    }

    @Override
    protected void handle()
    {
        _result = handleResult();
    }

    abstract protected T handleResult();
}
