package com.kodemore.adaptor;

import java.util.function.Function;

public interface KmAdaptorIF<M, V>
{
    //##################################################
    //# interface
    //##################################################

    V getValue(M model);

    void setValue(M model, V value);

    //##################################################
    //# default
    //##################################################

    default Function<M,V> toFunction()
    {
        return this::getValue;
    }

}
