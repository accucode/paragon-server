package com.app.filter;

import com.app.criteria.MySystemLogCriteria;
import com.app.filter.base.MySystemLogFilterBase;

import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.KmNamedEnumIF;

public class MySystemLogFilter
    extends MySystemLogFilterBase
{
    //##################################################
    //# sort (enum)
    //##################################################

    public static enum Sort
        implements KmNamedEnumIF
    {
        Id("Id"),
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

    private Integer     _levelCode;
    private boolean     _usesLevelCode;

    private String      _loggerName;
    private boolean     _usesLoggerName;

    private String      _loggerNamePrefix;
    private boolean     _usesLoggerNamePrefix;

    private String      _context;
    private boolean     _usesContext;

    private KmDate      _minimumCreatedUtcDate;
    private boolean     _usesCreatedMinimumUtcDate;

    private KmDate      _maximumCreatedUtcDate;
    private boolean     _usesMaximumCreatedUtcDate;

    private KmTimestamp _minimumCreatedUtcTs;
    private boolean     _usesMinimumCreatedUtcTs;

    private KmTimestamp _maximumCreatedUtcTs;
    private boolean     _usesMaximumCreatedUtcTs;

    private Sort        _sort;
    private boolean     _sortAscending;

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
    //# sort
    //##################################################

    public void sortOnId()
    {
        sortOn(Sort.Id);
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
    public void applyConditionsTo(MySystemLogCriteria c)
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
    public void applySortsTo(MySystemLogCriteria c)
    {
        if ( !usesSort() )
            return;

        boolean asc = _sortAscending;

        switch ( _sort )
        {
            case Id:
                c.sortOnId(asc);
                break;

            case CreatedUtcTs:
                c.sortOnCreatedUtcTs(asc);
                break;
        }
    }
}
