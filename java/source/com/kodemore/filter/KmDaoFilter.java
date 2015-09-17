package com.kodemore.filter;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDao;

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
        return KmDao.fetchOnce(getDelegate()::findAll);
    }

    @Override
    public KmList<T> findBatch(final int index, final int count)
    {
        return KmDao.fetchNoRetry(getDelegate()::findBatch, index, count);
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
        return KmDao.fetchOnce(getDelegate()::getCount);
    }

    @Override
    public boolean exists()
    {
        return KmDao.fetchOnce(getDelegate()::exists);
    }

    //##################################################
    //# delete
    //##################################################

    @Override
    public void deleteAll()
    {
        KmDao.run(getDelegate()::deleteAll);
    }

    @Override
    public void deleteFirst()
    {
        KmDao.run(getDelegate()::deleteFirst);
    }

    @Override
    public void deleteFirst(final int count)
    {
        KmDao.run(getDelegate()::deleteFirst, count);
    }
}
