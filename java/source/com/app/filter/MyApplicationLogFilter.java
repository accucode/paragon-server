package com.app.filter;

import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.KmEnumIF;

import com.app.criteria.MyApplicationLogCriteria;
import com.app.filter.base.MyApplicationLogFilterBase;

public class MyApplicationLogFilter
    extends MyApplicationLogFilterBase
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

    private Integer _levelCode;
    private boolean _usesLevelCode;

    private String  _loggerName;
    private boolean _usesLoggerName;

    private String  _loggerNamePrefix;
    private boolean _usesLoggerNamePrefix;

    private String  _context;
    private boolean _usesContext;

    private KmDate  _minimumCreatedUtcDate;
    private boolean _usesCreatedMinimumUtcDate;

    private KmDate  _maximumCreatedUtcDate;
    private boolean _usesMaximumCreatedUtcDate;

    private KmTimestamp _minimumCreatedUtcTs;
    private boolean     _usesMinimumCreatedUtcTs;

    private KmTimestamp _maximumCreatedUtcTs;
    private boolean     _usesMaximumCreatedUtcTs;

    //##################################################
    //# constructor
    //##################################################

    public MyApplicationLogFilter()
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
    //# level
    //##################################################

    public Integer getLevelCode()
    {
        return _levelCode;
    }

    public void setLevelCode(Integer e)
    {
        _levelCode = e;
        _usesLevelCode = true;
    }

    public boolean usesLevelCode()
    {
        return _usesLevelCode;
    }

    //##################################################
    //# logger name
    //##################################################

    public String getLoggerName()
    {
        return _loggerName;
    }

    public void setLoggerName(String e)
    {
        _loggerName = e;
        _usesLoggerName = true;
    }

    public boolean usesLoggerName()
    {
        return _usesLoggerName;
    }

    //##################################################
    //# logger name prefix
    //##################################################

    public String getLoggerNamePrefix()
    {
        return _loggerNamePrefix;
    }

    public void setLoggerNamePrefix(String e)
    {
        _loggerNamePrefix = e;
        _usesLoggerNamePrefix = true;
    }

    public boolean usesLoggerNamePrefix()
    {
        return _usesLoggerNamePrefix;
    }

    //##################################################
    //# context
    //##################################################

    public String getContext()
    {
        return _context;
    }

    public void setContext(String e)
    {
        _context = e;
        _usesContext = true;
    }

    public boolean usesContext()
    {
        return _usesContext;
    }

    //##################################################
    //# min date
    //##################################################

    public KmDate getMinimumCreatedUtcDate()
    {
        return _minimumCreatedUtcDate;
    }

    public void setMinimumCreatedUtcDate(KmDate e)
    {
        _minimumCreatedUtcDate = e;
        _usesCreatedMinimumUtcDate = true;
    }

    public boolean usesMinimumCreatedUtcDate()
    {
        return _usesCreatedMinimumUtcDate;
    }

    //##################################################
    //# max date
    //##################################################

    public KmDate getMaximumCreatedUtcDate()
    {
        return _maximumCreatedUtcDate;
    }

    public void setMaximumCreatedUtcDate(KmDate e)
    {
        _maximumCreatedUtcDate = e;
        _usesMaximumCreatedUtcDate = true;
    }

    public boolean usesMaximumCreatedUtcDate()
    {
        return _usesMaximumCreatedUtcDate;
    }

    //##################################################
    //# min ts
    //##################################################

    public KmTimestamp getMinimumCreatedUtcTs()
    {
        return _minimumCreatedUtcTs;
    }

    public void setMinimumCreatedUtcTs(KmTimestamp e)
    {
        _minimumCreatedUtcTs = e;
        _usesMinimumCreatedUtcTs = true;
    }

    public boolean usesMinimumCreatedUtcTs()
    {
        return _usesMinimumCreatedUtcTs;
    }

    //##################################################
    //# max ts
    //##################################################

    public KmTimestamp getMaximumCreatedUtcTs()
    {
        return _maximumCreatedUtcTs;
    }

    public void setMaximumCreatedUtcTs(KmTimestamp e)
    {
        _maximumCreatedUtcTs = e;
        _usesMaximumCreatedUtcTs = true;
    }

    public boolean usesMaximumCreatedUtcTs()
    {
        return _usesMaximumCreatedUtcTs;
    }

    //##################################################
    //# apply
    //##################################################

    @Override
    public void applyConditionsTo(MyApplicationLogCriteria c)
    {
        if ( usesLevelCode() )
            c.whereLevelCode().is(getLevelCode());

        if ( usesLoggerName() )
            c.whereLoggerName().is(getLoggerName());

        if ( usesLoggerNamePrefix() )
            c.whereLoggerName().hasPrefix(getLoggerNamePrefix());

        if ( usesContext() )
            c.whereContext().is(getContext());

        if ( usesMinimumCreatedUtcDate() )
            c.whereCreatedUtcTs().isGreaterThanOrEqualTo(getMinimumCreatedUtcDate().toTimestamp());

        if ( usesMaximumCreatedUtcDate() )
            c.whereCreatedUtcTs().isLessThan(getMaximumCreatedUtcDate().getNext().toTimestamp());

        if ( usesMinimumCreatedUtcTs() )
            c.whereCreatedUtcTs().isGreaterThanOrEqualTo(getMinimumCreatedUtcTs());

        if ( usesMaximumCreatedUtcTs() )
            c.whereCreatedUtcTs().isLessThanOrEqualTo(getMaximumCreatedUtcTs());
    }

    @Override
    public void applySortsTo(MyApplicationLogCriteria c)
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
