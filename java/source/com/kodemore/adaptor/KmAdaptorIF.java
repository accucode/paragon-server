package com.kodemore.adaptor;

import java.util.function.Function;

public interface KmAdaptorIF<T, V>
    extends Function<T,V>
{
    //##################################################
    //# interface
    //##################################################

    V getValue(T model);

    void setValue(T model, V value);

    //##################################################
    //# default
    //##################################################

    @Override
    default V apply(T m)
    {
        return getValue(m);
    }

}
