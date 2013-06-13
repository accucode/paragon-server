package com.kodemore.adaptor;

public class KmThisAdaptor<T>
    extends KmAbstractAdaptor<T,T>
{
    @Override
    public T getValue(T e)
    {
        return e;
    }

}
