package com.app.filter;

import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.KmEnumIF;

import com.app.criteria.MyAuditBundleCriteria;
import com.app.filter.base.MyAuditBundleFilterBase;
import com.app.model.MyUser;
import com.app.model.base.MyAuditBundleChangeType;

public class MyAuditBundleFilter
    extends MyAuditBundleFilterBase
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

    private Sort    _sort;
    private boolean _ascending;

    private MyUser  _user;
    private boolean _usesUser;

    private KmTimestamp _minimumCreatedUtcTs;
    private boolean     _usesMinimumCreatedUtcTs;

    private KmTimestamp _maximumCreatedUtcTs;
    private boolean     _usesMaximumCreatedUtcTs;

    private String  _domainType;
    private boolean _usesDomainType;

    private MyAuditBundleChangeType _changeType;
    private boolean                 _usesChangeType;

    //##################################################
    //# constructor
    //##################################################

    public MyAuditBundleFilter()
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
    //# domain type
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
    //# change type
    //##################################################

    public MyAuditBundleChangeType getChangeType()
    {
        return _changeType;
    }

    public void setChangeType(MyAuditBundleChangeType e)
    {
        _changeType = e;
        _usesChangeType = true;
    }

    public boolean usesChangeType()
    {
        return _usesChangeType;
    }

    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(MyAuditBundleCriteria c)
    {
        if ( usesUser() )
            c.whereUserIs(getUser());

        if ( usesMinimumCreatedUtcTs() )
            c.whereCreatedUtcTs().isGreaterThanOrEqualTo(getMinimumCreatedUtcTs());

        if ( usesMaximumCreatedUtcTs() )
            c.whereCreatedUtcTs().isLessThanOrEqualTo(getMaximumCreatedUtcTs());

        if ( usesDomainType() )
            c.whereDomainType().is(getDomainType());

        if ( usesChangeType() )
            c.whereChangeTypeCode().is(getChangeType());
    }

    @Override
    protected void applySortsTo(MyAuditBundleCriteria c)
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
