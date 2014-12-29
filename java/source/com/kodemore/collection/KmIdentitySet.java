package com.kodemore.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.kodemore.utility.KmIdentityWrapper;

/**
 * I implement a hash set that compares elements based on
 * identity (==) rather than equals().
 */
public class KmIdentitySet<T>
    implements Set<T>
{
    //##################################################
    //# variables
    //##################################################

    private HashSet<KmIdentityWrapper<T>> _impl;

    //##################################################
    //# constructor
    //##################################################

    public KmIdentitySet()
    {
        _impl = new HashSet<>();
    }

    //##################################################
    //# delegates
    //##################################################

    @Override
    public boolean add(T o)
    {
        return _impl.add(wrapper(o));
    }

    @Override
    public boolean addAll(Collection<? extends T> c)
    {
        return _impl.addAll(wrapper(c));
    }

    @Override
    public void clear()
    {
        _impl.clear();
    }

    @Override
    public boolean contains(Object o)
    {
        return _impl.contains(wrapper(o));
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        return _impl.containsAll(wrapper(c));
    }

    @Override
    public boolean isEmpty()
    {
        return _impl.isEmpty();
    }

    @Override
    public Iterator<T> iterator()
    {
        return new Iterator<T>()
        {
            private Iterator<KmIdentityWrapper<T>> i = _impl.iterator();

            @Override
            public boolean hasNext()
            {
                return i.hasNext();
            }

            @Override
            public T next()
            {
                return i.next().getValue();
            }

            @Override
            public void remove()
            {
                i.remove();
            }
        };
    }

    @Override
    public boolean remove(Object o)
    {
        return _impl.remove(wrapper(o));
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        return _impl.removeAll(wrapper(c));
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        return _impl.retainAll(wrapper(c));
    }

    @Override
    public int size()
    {
        return _impl.size();
    }

    @Override
    public Object[] toArray()
    {
        int i = 0;
        Object[] arr = new Object[size()];

        for ( T e : this )
            arr[i++] = e;

        return arr;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E> E[] toArray(E[] arr)
    {
        int n = size();

        if ( arr.length < n )
        {
            Class<?> type = arr.getClass().getComponentType();
            arr = (E[])java.lang.reflect.Array.newInstance(type, n);
        }

        Iterator<T> i = iterator();
        for ( int j = 0; j < n; j++ )
            arr[j] = (E)i.next();

        for ( int j = n; j < arr.length; j++ )
            arr[j] = null;

        return arr;
    }

    //##################################################
    //# support
    //##################################################

    @SuppressWarnings(
    {
        "unchecked",
        "rawtypes"
    })
    private KmIdentityWrapper<T> wrapper(Object e)
    {
        return new KmIdentityWrapper(e);
    }

    @SuppressWarnings(
    {
        "unchecked",
        "rawtypes"
    })
    private Collection<KmIdentityWrapper<T>> wrapper(Collection c)
    {
        ArrayList<KmIdentityWrapper<T>> v;
        v = new ArrayList<>();

        for ( Object e : c )
            v.add(KmIdentityWrapper.create((T)e));

        return v;
    }

}
