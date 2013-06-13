package com.app.finder.core;

import com.kodemore.command.KmDaoCommand;

public abstract class MyAbstractFinder<T>
{
    //##################################################
    //# variables
    //##################################################

    private T _value;

    //##################################################
    //# public
    //##################################################

    public T find()
    {
        newCommand().run();
        return _value;
    }

    //##################################################
    //# support
    //##################################################

    private KmDaoCommand newCommand()
    {
        return new KmDaoCommand()
        {
            @Override
            public void handle()
            {
                _value = _find();
            }
        };
    }

    public abstract T _find();
}
