package com.kodemore.filter;

import java.util.Iterator;

import com.kodemore.collection.KmList;
import com.kodemore.dao.KmDaoSessionManager;
import com.kodemore.time.KmClock;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimestamp;

/**
 * I provide a simple implementation of KmFilterIF.
 * Non-optimized subclasses need only implement the
 * findAll() method.
 */
public abstract class KmFilter<T>
    implements KmFilterIF<T>, Iterable<T>
{
    //##################################################
    //# static
    //##################################################

    public static <E> KmFilter<E> createEmpty()
    {
        return new KmFilter<E>()
        {
            @Override
            public KmList<E> findAll()
            {
                return new KmList<>();
            }
        };
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public abstract KmList<T> findAll();

    @Override
    public KmList<T> findBatch(int index, int count)
    {
        return findAll().getBatchSafe(index, count);
    }

    @Override
    public final KmList<T> findFirst(int count)
    {
        return findBatch(0, count);
    }

    @Override
    public final T findFirst()
    {
        return findFirst(1).getFirstSafe();
    }

    @Override
    public final Iterable<T> getCursor()
    {
        return findAll();
    }

    @Override
    public final Iterator<T> iterator()
    {
        return getCursor().iterator();
    }

    //##################################################
    //# count
    //##################################################

    @Override
    public int getCount()
    {
        return findAll().size();
    }

    @Override
    public boolean exists()
    {
        return findFirst() != null;
    }

    //##################################################
    //# delete
    //##################################################

    @Override
    public void deleteAll()
    {
        KmList<T> v = findAll();
        for ( T e : v )
            delete(e);
    }

    @Override
    public void deleteFirst()
    {
        deleteFirst(1);
    }

    @Override
    public void deleteFirst(int count)
    {
        KmList<T> v = findFirst(count);
        for ( T e : v )
            delete(e);
    }

    protected void delete(T e)
    {
        KmDaoSessionManager.getInstance().getDaoSession().delete(e);
    }

    //##################################################
    //# dao
    //##################################################

    public KmFilterIF<T> toDaoFilter()
    {
        return new KmDaoFilter<>(this);
    }

    /**
     * Return a factory that wraps this filter.   This is useful for interfaced that
     * require a factory, but for which you currently just need a static filter.
     * Note that the 'this' instance is used (not a copy), so subsequent changes to
     * the filter will effect the factory.
     */
    public KmFilterFactoryIF<T> toFactory()
    {
        return new KmFilterFactoryIF<T>()
        {
            @Override
            public KmFilterIF<T> createFilter()
            {
                return KmFilter.this;
            }
        };
    }

    //##################################################
    //# support
    //##################################################

    protected KmTimestamp getNowUtc()
    {
        return KmClock.getUtcTimestamp();
    }

    protected KmDate getTodayUtc()
    {
        return KmClock.getUtcTimestamp().getDate();
    }

    @SuppressWarnings("unchecked")
    protected T cast(Object o)
    {
        return (T)o;
    }

    @SuppressWarnings("unchecked")
    protected KmList<T> castList(KmList<?> o)
    {
        return (KmList<T>)o;
    }

}
