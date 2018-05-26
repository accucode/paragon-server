package com.kodemore.filter;

import com.kodemore.collection.KmList;
import com.kodemore.filter.KmFilter;
import com.kodemore.hibernate.KmhModelCriteria;

/**
 * I am a filter on an externally predefined criteria.
 *
 * NOTE - I directly modify the criteria's firstRecordIndex
 * and maximumResultCount in order to efficiently handle
 * batches. Clients should NOT set these directly.
 */
public class KmCriteriaFilter<T>
    extends KmFilter<T>
{
    //##################################################
    //# variables
    //##################################################

    private KmhModelCriteria<T> _criteria;

    //##################################################
    //# constructor
    //##################################################

    public KmCriteriaFilter(KmhModelCriteria<T> e)
    {
        _criteria = e;
    }

    //##################################################
    //# accessing
    //##################################################

    public KmhModelCriteria<T> getCriteria()
    {
        return _criteria;
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public KmList<T> findAll()
    {
        _criteria.clearFirstResult();
        _criteria.clearMaxResults();
        return _criteria.findAll();
    }

    @Override
    public KmList<T> findBatch(int index, int count)
    {
        _criteria.setFirstResult(index);
        _criteria.setMaxResults(count);
        return _criteria.findAll();
    }

    @Override
    public int getCount()
    {
        return _criteria.findRowCount();
    }

}
