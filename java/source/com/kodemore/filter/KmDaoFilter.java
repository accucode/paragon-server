package com.kodemore.filter;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDaoCommand;
import com.kodemore.command.KmDaoResultCommand;

/**
 * I wrap another filter and ensure that all data is
 * accessed through the dao layer.
 */
public class KmDaoFilter<T>
    implements KmFilterIF<T>
{
    //##################################################
    //# variables
    //##################################################

    private KmFilterIF<T> _delegate;

    //##################################################
    //# constructor
    //##################################################

    public KmDaoFilter(KmFilterIF<T> e)
    {
        _delegate = e;
    }

    //##################################################
    //# accessing
    //##################################################

    public KmFilterIF<T> getDelegate()
    {
        return _delegate;
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public KmList<T> findAll()
    {
        return new KmDaoResultCommand<KmList<T>>()
        {
            @Override
            protected KmList<T> handleResult()
            {
                return getDelegate().findAll();
            }
        }.runResult();
    }

    @Override
    public KmList<T> findBatch(final int index, final int count)
    {
        return new KmDaoResultCommand<KmList<T>>()
        {
            @Override
            protected KmList<T> handleResult()
            {
                return getDelegate().findBatch(index, count);
            }
        }.runResult();
    }

    @Override
    public KmList<T> findFirst(int count)
    {
        return findBatch(0, count);
    }

    @Override
    public T findFirst()
    {
        return findFirst(1).getFirstSafe();
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
        return new KmDaoResultCommand<Integer>()
        {
            @Override
            protected Integer handleResult()
            {
                return getDelegate().getCount();
            }
        }.runResult();
    }

    @Override
    public boolean exists()
    {
        return new KmDaoResultCommand<Boolean>()
        {
            @Override
            protected Boolean handleResult()
            {
                return getDelegate().exists();
            }
        }.runResult();
    }

    //##################################################
    //# delete
    //##################################################

    @Override
    public void deleteAll()
    {
        new KmDaoCommand()
        {
            @Override
            protected void handle()
            {
                getDelegate().deleteAll();
            }
        }.run();
    }

    @Override
    public void deleteFirst()
    {
        new KmDaoCommand()
        {
            @Override
            protected void handle()
            {
                getDelegate().deleteFirst();
            }
        }.run();
    }

    @Override
    public void deleteFirst(final int count)
    {
        new KmDaoCommand()
        {
            @Override
            protected void handle()
            {
                getDelegate().deleteFirst(count);
            }
        }.run();
    }
}
