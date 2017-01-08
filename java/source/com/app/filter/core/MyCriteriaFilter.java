package com.app.filter.core;

import com.kodemore.collection.KmList;
import com.kodemore.filter.KmFilter;

import com.app.criteria.core.MyAbstractCriteria;

/**
 * I am a filter on an externally predefined criteria.
 *
 * NOTE - I directly modify the criteria's firstRecordIndex
 * and maximumResultCount in order to efficiently handle
 * batches. Clients should NOT set these directly.
 */
public class MyCriteriaFilter<T>
    extends KmFilter<T>
{
    //##################################################
    //# variables
    //##################################################

    private MyAbstractCriteria<T> _criteria;

    //##################################################
    //# constructor
    //##################################################

    public MyCriteriaFilter(MyAbstractCriteria<T> e)
    {
        _criteria = e;
    }

    //##################################################
    //# accessing
    //##################################################

    public MyAbstractCriteria<T> getCriteria()
    {
        return _criteria;
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public KmList<T> findAll()
    {
        MyAbstractCriteria<T> c;
        c = _criteria;
        c.clearFirstResult();
        c.clearMaxResults();
        return c.findAll();
    }

    @Override
    public KmList<T> findBatch(int index, int count)
    {
        MyAbstractCriteria<T> c;
        c = _criteria;
        c.setFirstResult(index);
        c.setMaxResults(count);
        return c.findAll();
    }

}
