package com.kodemore.collection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * I WRAP a Collection, which allows subclasses to easily extend
 * the collection interface without needing to copy the contents
 * to a new list.  This can be especially useful when working with
 * either large lists, or lists are backed by some other functionality
 * such as hibernate.
 *
 * In general, my only methods should be those that are required to
 * implement the Collection interface by delegating all methods to
 * the backing store.
 */
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
        _collection = new ArrayList<>();
    }

    public KmCollectionWrapper(int i)
    {
        _collection = new ArrayList<>(i);
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
