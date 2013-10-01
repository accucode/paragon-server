package com.app.filter;

import com.app.criteria.MyEmailCriteria;
import com.app.filter.base.MyEmailFilterBase;
import com.app.model.MyEmailStatus;

import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.KmNamedEnumIF;
import com.kodemore.utility.Kmu;

public class MyEmailFilter
    extends MyEmailFilterBase
{
    //##################################################
    //# sort (enum)
    //##################################################

    public static enum Sort
        implements KmNamedEnumIF
    {
        Uid("Uid"),
        CreatedUtcTs("CreatedUtcTs");

        private String _name;

        private Sort(String name)
        {
            _name = name;
        }

        @Override
        public String getName()
        {
            return _name;
        }
    }

    //##################################################
    //# variables
    //##################################################

    private KmDate  _createdStartDate;
    private boolean _usesCreatedStartDate;

    private KmDate  _createdEndDate;
    private boolean _usesCreatedEndDate;

    private String  _statusCode;
    private boolean _usesStatusCode;

    private Sort    _sort;
    private boolean _sortAscending;

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
        setStatusCode(Kmu.getCode(e));
    }

    public boolean usesStatusCode()
    {
        return _usesStatusCode;
    }

    //##################################################
    //# sort
    //##################################################

    public void sortOnId()
    {
        sortOn(Sort.Uid);
    }

    public void sortOnCreatedUtcTs()
    {
        sortOn(Sort.CreatedUtcTs);
    }

    //##################################################
    //# sort (support)
    //##################################################

    public void sortOn(int i)
    {
        sortOn(Sort.values()[i]);
    }

    public void sortOn(Sort e)
    {
        _sort = e;
    }

    public boolean usesSort()
    {
        return _sort != null;
    }

    //##################################################
    //# sort order
    //##################################################

    public void sortAscending()
    {
        sortAscending(true);
    }

    public void sortAscending(boolean e)
    {
        _sortAscending = e;
    }

    public void sortDescending()
    {
        sortAscending(false);
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

        boolean asc = _sortAscending;

        switch ( _sort )
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
