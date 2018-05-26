package com.kodemore.filter;

import com.kodemore.collection.KmList;

/**
 * I convert a filter of one type into a filter of
 * another type.
 */
public abstract class KmDelegateFilter<T, D>
    implements KmFilterIF<T>
{
    //##################################################
    //# variables
    //##################################################

    private KmFilterIF<D> _delegate;

    //##################################################
    //# constructor
    //##################################################

    public KmDelegateFilter()
    {
        // none
    }

    public KmDelegateFilter(KmFilterIF<D> e)
    {
        _delegate = e;
    }

    //##################################################
    //# accessing
    //##################################################

    public KmFilterIF<D> getDelegate()
    {
        return _delegate;
    }

    public void setDelegate(KmFilterIF<D> e)
    {
        _delegate = e;
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public KmList<T> findAll()
    {
        KmList<D> v = getDelegate().findAll();

        return convertList(v);
    }

    @Override
    public KmList<T> findBatch(int index, int count)
    {
        KmList<D> v = getDelegate().findBatch(index, count);

        return convertList(v);
    }

    @Override
    public KmList<T> findFirst(int count)
    {
        KmList<D> v = getDelegate().findFirst(count);

        return convertList(v);
    }

    @Override
    public T findFirst()
    {
        D e = getDelegate().findFirst();

        return convert(e);
    }

    @Override
    public Iterable<T> getCursor()
    {
        return findAll();
    }

    //##################################################
    //# count
    //##################################################

    @Override
    public int getCount()
    {
        return getDelegate().getCount();
    }

    @Override
    public boolean exists()
    {
        return getDelegate().exists();
    }

    //##################################################
    //# delete
    //##################################################

    @Override
    public void deleteAll()
    {
        getDelegate().deleteAll();
    }

    @Override
    public void deleteFirst()
    {
        getDelegate().deleteFirst();
    }

    @Override
    public void deleteFirst(int count)
    {
        getDelegate().deleteFirst(count);
    }

    //##################################################
    //# convert
    //##################################################

    /**
     * Convert an instance from the delegate filter
     * into an instance of the target filter.
     */
    protected abstract T convert(D e);

    private KmList<T> convertList(KmList<D> all)
    {
        int n = all.size();
        KmList<T> v = new KmList<>(n);

        for ( D e : all )
            v.add(convert(e));

        return v;
    }

}
