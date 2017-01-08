package com.app.ui.page.manage.crud;

import java.util.function.Supplier;

/**
 * I provide a simple wrapper for a lazy initialized value.
 * The value may be explicitly set, rather than being lazily loaded.
 *
 * The value may only be set/loaded once.  In other words, once the
 * value has been initialized, any attempt to modify it will throw
 * an exception.
 */
public class MyCrudLazyValue<T>
{
    //##################################################
    //# variables
    //##################################################

    private Supplier<T> _supplier;
    private boolean     _initialized;
    private T           _value;

    //##################################################
    //# constructor
    //##################################################

    public MyCrudLazyValue(Supplier<T> e)
    {
        _supplier = e;
    }

    //##################################################
    //# accessing
    //##################################################

    public synchronized T getValue()
    {
        if ( _initialized )
            return _value;

        setValue(_supplier.get());
        return _value;
    }

    public synchronized void setValue(T e)
    {
        if ( _initialized )
            throw new RuntimeException("Cannot modify, already initialized.");

        _initialized = true;
        _value = e;
    }
}
