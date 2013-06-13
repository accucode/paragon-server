package com.kodemore.collection;

import java.util.Iterator;

public class KmNoRemoveIterator<T>
    implements Iterator<T>
{
    //##################################################
    //# variables
    //##################################################

    private Iterator<T> _inner;

    //##################################################
    //# constructor
    //##################################################

    public KmNoRemoveIterator(Iterator<T> i)
    {
        _inner = i;
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public boolean hasNext()
    {
        return _inner.hasNext();
    }

    @Override
    public T next()
    {
        return _inner.next();
    }

    @Override
    public void remove()
    {
        throw new UnsupportedOperationException();
    }
}
