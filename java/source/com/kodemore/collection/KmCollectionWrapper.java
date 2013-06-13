package com.kodemore.collection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class KmCollectionWrapper<T>
    implements Collection<T>, Serializable
{
    //##################################################
    //# variables
    //##################################################

    private Collection<T> _collection;

    //##################################################
    //# constructor
    //##################################################

    public KmCollectionWrapper()
    {
        _collection = new ArrayList<T>();
    }

    public KmCollectionWrapper(int i)
    {
        _collection = new ArrayList<T>(i);
    }

    protected KmCollectionWrapper(Collection<T> e)
    {
        _collection = e;
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public Iterator<T> iterator()
    {
        return _collection.iterator();
    }

    @Override
    public int size()
    {
        return _collection.size();
    }

    //##################################################
    //# testing
    //##################################################

    @Override
    public boolean contains(Object o)
    {
        return _collection.contains(o);
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        return _collection.containsAll(c);
    }

    @Override
    public boolean isEmpty()
    {
        return _collection.isEmpty();
    }

    //##################################################
    //# add
    //##################################################

    @Override
    public boolean add(T e)
    {
        return _collection.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends T> c)
    {
        return _collection.addAll(c);
    }

    //##################################################
    //# remove
    //##################################################

    @Override
    public boolean remove(Object e)
    {
        return _collection.remove(e);
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        return _collection.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        return _collection.retainAll(c);
    }

    @Override
    public void clear()
    {
        _collection.clear();
    }

    //##################################################
    //# equals
    //##################################################

    @Override
    public boolean equals(Object e)
    {
        return _collection.equals(e);
    }

    @Override
    public int hashCode()
    {
        return _collection.hashCode();
    }

    //##################################################
    //# conversion
    //##################################################

    @Override
    public Object[] toArray()
    {
        return _collection.toArray();
    }

    @Override
    public <E> E[] toArray(E[] a)
    {
        return _collection.toArray(a);
    }

}
