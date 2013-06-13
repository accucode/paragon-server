package com.app.finder.core;

import com.kodemore.command.KmDaoCommand;
import com.kodemore.utility.KmKeyFinderIF;

public class MyDaoKeyFinder<T, K>
    extends KmDaoCommand
{
    //##################################################
    //# variables
    //##################################################

    private KmKeyFinderIF<T,K> _finder;
    private K                  _key;
    private T                  _value;

    //##################################################
    //# constructor
    //##################################################

    public MyDaoKeyFinder(KmKeyFinderIF<T,K> finder, K key)
    {
        _finder = finder;
        _key = key;
        _value = null;
    }

    //##################################################
    //# accessing
    //##################################################

    public T getValue()
    {
        return _value;
    }

    //##################################################
    //# run
    //##################################################

    @Override
    protected void handle()
    {
        _value = _finder.find(_key);
    }
}
