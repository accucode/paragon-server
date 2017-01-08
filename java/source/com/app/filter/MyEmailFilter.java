package com.app.filter;

import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.KmEnumIF;

import com.app.criteria.MyEmailCriteria;
import com.app.filter.base.MyEmailFilterBase;
import com.app.model.base.MyEmailStatus;

public class MyEmailFilter
    extends MyEmailFilterBase
{
    //##################################################
    //# sort (enum)
    //##################################################

    public static enum Sort
        implements KmEnumIF
    {
        Uid,
        CreatedUtcTs;
    }

    //##################################################
    //# variables
    //##################################################

    private Sort    _sort;
    private boolean _ascending;

    private KmDate  _createdStartDate;
    private boolean _usesCreatedStartDate;

    private KmDate  _createdEndDate;
    private boolean _usesCreatedEndDate;

    private String  _statusCode;
    private boolean _usesStatusCode;

    //##################################################
    //# constructor
    //##################################################

    public MyEmailFilter()
    {
        sortOnUid();
        sortAscending();
    }

    //##################################################
    //# sort
    //##################################################

    public void sortOnUid()
    {
        setSort(Sort.Uid);
    }

    public void sortOnCreatedUtcTs()
    {
        setSort(Sort.CreatedUtcTs);
    }

    //==================================================
    //= sort :: accessing
    //==================================================

    public Sort getSort()
    {
        return _sort;
    }

    public void setSort(Sort e)
    {
        _sort = e;
    }

    public void sortOn(int i)
    {
        setSort(Sort.values()[i]);
    }

    public boolean usesSort()
    {
        return _sort != null;
    }

    //==================================================
    //= sort :: ascending
    //==================================================

    public boolean getAscending()
    {
        return _ascending;
    }

    public void setAscending(boolean e)
    {
        _ascending = e;
    }

    public void sortAscending()
    {
        setAscending(true);
    }

    public void sortDescending()
    {
        setAscending(false);
    }

    //##################################################
    //# createdStartDate
    //##################################################

    public KmDate getCreatedStartDate()
    {
        return _createdStartDate;
    }

    public void setCreatedStartDate(KmDate e)
    {
        _createdStartDate = e;
        _usesCreatedStartDate = true;
    }

    public boolean usesCreatedStartDate()
    {
        return _usesCreatedStartDate;
    }

    //##################################################
    //# createdEndDate
    //##################################################

    public KmDate getCreatedEndDate()
    {
        return _createdEndDate;
    }

    public void setCreatedEndDate(KmDate e)
    {
        _createdEndDate = e;
        _usesCreatedEndDate = true;
    }

    public boolean usesCreatedEndDate()
    {
        return _usesCreatedEndDate;
    }

    //##################################################
    //# statusCode
    //##################################################

    public String getStatusCode()
    {
        return _statusCode;
    }

    public void setStatusCode(String e)
    {
        _statusCode = e;
        _usesStatusCode = true;
    }

    public void setStatusCode(MyEmailStatus e)
    {
        setStatusCode(KmEnumIF.getCodeFor(e));
    }

    public boolean usesStatusCode()
    {
        return _usesStatusCode;
    }

    //##################################################
    //# apply
    //##################################################

    @Override
    public void applyConditionsTo(MyEmailCriteria c)
    {
        if ( usesCreatedStartDate() )
        {
            KmTimestamp start = getCreatedStartDate().toTimestamp();
            c.whereCreatedUtcTs().isGreaterThanOrEqualTo(start);
        }

        if ( usesCreatedEndDate() )
        {
            KmTimestamp end = getCreatedEndDate().addDay().toTimestamp();
            c.whereCreatedUtcTs().isLessThan(end);
        }

        if ( usesStatusCode() )
            c.whereStatusCode().is(getStatusCode());
    }

    @Override
    public void applySortsTo(MyEmailCriteria c)
    {
        if ( !usesSort() )
            return;

        Sort sort = getSort();
        boolean asc = getAscending();

        switch ( sort )
        {
            case Uid:
                c.sortOnUid(asc);
                break;

            case CreatedUtcTs:
                c.sortOnCreatedUtcTs(asc);
                break;
        }
    }

}
