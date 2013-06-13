package com.kodemore.adaptor;

public class KmAbstractAdaptor<M, V>
    implements KmAdaptorIF<M,V>
{
    @Override
    public V getValue(M model)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setValue(M model, V value)
    {
        throw new UnsupportedOperationException();
    }
}
