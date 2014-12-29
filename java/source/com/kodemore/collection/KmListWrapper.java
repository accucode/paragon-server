package com.kodemore.collection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class KmListWrapper<T>
    implements List<T>, Serializable
{
    //##################################################
    //# variables
    //##################################################

    private List<T> _list;

    //##################################################
    //# constructor
    //##################################################

    public KmListWrapper()
    {
        _list = new ArrayList<>();
    }

    public KmListWrapper(int i)
    {
        _list = new ArrayList<>(i);
    }

    protected KmListWrapper(List<T> e)
    {
        _list = e;
    }

    //##################################################
    //# add
    //##################################################

    @Override
    public void add(int index, T element)
    {
        _list.add(index, element);
    }

    @Override
    public boolean add(T o)
    {
        return _list.add(o);
    }

    @Override
    public boolean addAll(Collection<? extends T> c)
    {
        return _list.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c)
    {
        return _list.addAll(index, c);
    }

    //##################################################
    //# remove
    //##################################################

    @Override
    public T remove(int index)
    {
        return _list.remove(index);
    }

    @Override
    public boolean remove(Object o)
    {
        return _list.remove(o);
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        return _list.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        return _list.retainAll(c);
    }

    @Override
    public void clear()
    {
        _list.clear();
    }

    //##################################################
    //# update
    //##################################################

    @Override
    public T set(int index, T element)
    {
        return _list.set(index, element);
    }

    //##################################################
    //# equals
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        return _list.equals(o);
    }

    @Override
    public int hashCode()
    {
        return _list.hashCode();
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public T get(int index)
    {
        return _list.get(index);
    }

    @Override
    public int indexOf(Object o)
    {
        return _list.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o)
    {
        return _list.lastIndexOf(o);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex)
    {
        return _list.subList(fromIndex, toIndex);
    }

    @Override
    public int size()
    {
        return _list.size();
    }

    //##################################################
    //# testing
    //##################################################

    @Override
    public boolean isEmpty()
    {
        return _list.isEmpty();
    }

    @Override
    public boolean contains(Object o)
    {
        return _list.contains(o);
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        return _list.containsAll(c);
    }

    //##################################################
    //# iterators
    //##################################################

    @Override
    public Iterator<T> iterator()
    {
        return _list.iterator();
    }

    @Override
    public ListIterator<T> listIterator()
    {
        return _list.listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index)
    {
        return _list.listIterator(index);
    }

    //##################################################
    //# convert
    //##################################################

    @Override
    public Object[] toArray()
    {
        return _list.toArray();
    }

    @Override
    public <E> E[] toArray(E[] a)
    {
        return _list.toArray(a);
    }

}
