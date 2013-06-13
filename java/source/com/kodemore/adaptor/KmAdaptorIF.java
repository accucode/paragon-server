package com.kodemore.adaptor;

public interface KmAdaptorIF<M, V>
{
    V getValue(M model);

    void setValue(M model, V value);
}
