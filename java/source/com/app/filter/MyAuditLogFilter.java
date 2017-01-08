package com.app.filter;

import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.KmEnumIF;

import com.app.criteria.MyAuditLogCriteria;
import com.app.filter.base.MyAuditLogFilterBase;
import com.app.model.MyUser;

public class MyAuditLogFilter
    extends MyAuditLogFilterBase
{
    //##################################################
    //# sort (enum)
    //##################################################

    public static enum Sort
        implements KmEnumIF
    {
        Uid;
    }

    //##################################################
    //# variables
    //##################################################

    private Sort        _sort;
    private boolean     _ascending;

    private String      _typeCode;
    private boolean     _usesTypeCode;

    private String      _domainType;
    private boolean     _usesDomainType;

    private MyUser      _user;
    private boolean     _usesUser;

    private KmTimestamp _minimumCreatedUtcTs;
    private boolean     _usesMinimumCreatedUtcTs;

    private KmTimestamp _maximumCreatedUtcTs;
    private boolean     _usesMaximumCreatedUtcTs;

    //##################################################
    //# constructor
    //##################################################

    public MyAuditLogFilter()
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
    //# type
    //##################################################

    public String getTypeCode()
    {
        return _typeCode;
    }

    public void setTypeCode(String e)
    {
        _typeCode = e;
        _usesTypeCode = true;
    }

    public boolean usesTypeCode()
    {
        return _usesTypeCode;
    }

    //##################################################
    //# domain name
    //##################################################

    public String getDomainType()
    {
        return _domainType;
    }

    public void setDomainType(String e)
    {
        _domainType = e;
        _usesDomainType = true;
    }

    public boolean usesDomainType()
    {
        return _usesDomainType;
    }

    //##################################################
    //# user name
    //##################################################

    public MyUser getUser()
    {
        return _user;
    }

    public void setUser(MyUser e)
    {
        _user = e;
        _usesUser = true;
    }

    public boolean usesUser()
    {
        return _usesUser;
    }

    //##################################################
    //# minimum created utc ts
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
    //# maximum created utc ts
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
    protected void applyConditionsTo(MyAuditLogCriteria c)
    {
        if ( usesTypeCode() )
            c.whereTypeCode().is(getTypeCode());

        if ( usesDomainType() )
            c.whereDomainType().is(getDomainType());

        if ( usesUser() )
            c.whereUserIs(getUser());

        if ( usesMinimumCreatedUtcTs() )
            c.whereCreatedUtcTs().isGreaterThanOrEqualTo(getMinimumCreatedUtcTs());

        if ( usesMaximumCreatedUtcTs() )
            c.whereCreatedUtcTs().isLessThanOrEqualTo(getMaximumCreatedUtcTs());
    }

    @Override
    protected void applySortsTo(MyAuditLogCriteria c)
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
        }
    }

}
