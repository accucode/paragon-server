package com.kodemore.collection;

import java.util.Collection;
import java.util.Iterator;

import com.kodemore.adaptor.KmAdaptorIF;

public class KmHibernateCollection<T, P>
    extends KmCollection<T>
{
    //##################################################
    //# instance creation
    //##################################################

    public static <T, P> KmHibernateCollection<T,P> wrap(
        Collection<T> collection,
        P parent,
        KmAdaptorIF<T,P> adaptor)
    {
        return new KmHibernateCollection<>(collection, parent, adaptor);
    }

    //##################################################
    //# variables
    //##################################################

    private P                _parent;
    private KmAdaptorIF<T,P> _adaptor;

    //##################################################
    //# constructor
    //##################################################

    public KmHibernateCollection(Collection<T> e, P parent, KmAdaptorIF<T,P> adaptor)
    {
        super(e);
        _parent = parent;
        _adaptor = adaptor;
    }

    //##################################################
    //# add
    //##################################################

    @Override
    public boolean add(T e)
    {
        handleAdd(e);
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends T> c)
    {
        for ( T e : c )
            handleAdd(e);

        return super.addAll(c);
    }

    //##################################################
    //# remove
    //##################################################

    @SuppressWarnings("unchecked")
    @Override
    public boolean remove(Object e)
    {
        handleRemove((T)e);
        return super.remove(e);
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean removeAll(Collection<?> c)
    {
        for ( Object e : c )
            handleRemove((T)e);

        return super.removeAll(c);
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean retainAll(Collection<?> c)
    {
        for ( Object e : c )
            if ( !contains(e) )
                handleRemove((T)e);

        return super.retainAll(c);
    }

    @Override
    public void clear()
    {
        for ( T e : this )
            handleRemove(e);

        super.clear();
    }

    //##################################################
    //# iterator
    //##################################################

    @Override
    public Iterator<T> iterator()
    {
        return new Itr(super.iterator());
    }

    private class Itr
        implements Iterator<T>
    {
        private Iterator<T> _inner;
        private T           _next;

        private Itr(Iterator<T> i)
        {
            _inner = i;
        }

        @Override
        public boolean hasNext()
        {
            return _inner.hasNext();
        }

        @Override
        public T next()
        {
            _next = _inner.next();
            return _next;
        }

        @Override
        public void remove()
        {
            _inner.remove();
            handleRemove(_next);
        }
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

    //##################################################
    //# private
    //##################################################

    private void handleAdd(T e)
    {
        if ( _adaptor.getValue(e) == null )
            _adaptor.setValue(e, _parent);
        else
            throw new RuntimeException("Child already has parent.");
    }

    private void handleRemove(T e)
    {
        _adaptor.setValue(e, null);
    }

}
