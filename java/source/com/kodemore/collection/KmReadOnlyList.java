package com.kodemore.collection;

import java.util.Collection;
import java.util.List;

import com.kodemore.utility.KmReadOnlyException;
import com.kodemore.utility.KmReadOnlyIF;

public class KmReadOnlyList<T>
    extends KmListWrapper<T>
    implements KmReadOnlyIF
{
    //##################################################
    //# variables
    //##################################################

    private boolean _readOnly;

    //##################################################
    //# constructor
    //##################################################

    public KmReadOnlyList()
    {
        super();
    }

    public KmReadOnlyList(int i)
    {
        super(i);
    }

    protected KmReadOnlyList(List<T> e)
    {
        super(e);
    }

    //##################################################
    //# read only
    //##################################################

    @Override
    public boolean isReadOnly()
    {
        return _readOnly;
    }

    public void setReadOnly()
    {
        setReadOnly(true);
    }

    @Override
    public void setReadOnly(boolean b)
    {
        _readOnly = b;
        for ( T e : this )
            if ( e instanceof KmReadOnlyIF )
                ((KmReadOnlyIF)e).setReadOnly(b);
    }

    private void checkReadOnly()
    {
        if ( _readOnly )
            throw new KmReadOnlyException(this);
    }

    //##################################################
    //# add
    //##################################################

    @Override
    public boolean add(T o)
    {
        checkReadOnly();
        return super.add(o);
    }

    @Override
    public void add(int index, T element)
    {
        checkReadOnly();
        super.add(index, element);
    }

    @Override
    public boolean addAll(Collection<? extends T> c)
    {
        checkReadOnly();
        return super.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c)
    {
        checkReadOnly();
        return super.addAll(index, c);
    }

    //##################################################
    //# remove
    //##################################################

    @Override
    public T remove(int index)
    {
        checkReadOnly();
        return super.remove(index);
    }

    @Override
    public boolean remove(Object o)
    {
        checkReadOnly();
        return super.remove(o);
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        checkReadOnly();
        return super.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        checkReadOnly();
        return super.retainAll(c);
    }

    @Override
    public void clear()
    {
        checkReadOnly();
        super.clear();
    }

    //##################################################
    //# update
    //##################################################

    @Override
    public T set(int index, T element)
    {
        checkReadOnly();
        return super.set(index, element);
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object e)
    {
        return super.equals(e);
    }

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }

}
