package com.app.filter;

import com.kodemore.collection.KmList;
import com.kodemore.hibernate.KmhProjectionRow;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.KmEnumIF;

import com.app.criteria.MyAuditLogCriteria;
import com.app.filter.core.MyComplexFilter;
import com.app.model.MyAuditLogBundleVo;
import com.app.model.MyUser;

public class MyAuditLogBundleFilter
    extends MyComplexFilter<MyAuditLogBundleVo>
{
    //##################################################
    //# sort (enum)
    //##################################################

    public static enum Sort
                    implements KmEnumIF
    {
        BundleDomainUid;
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

    public MyAuditLogBundleFilter()
    {
        sortOnBundleDomainUid();
        sortAscending();
    }

    //##################################################
    //# sort
    //##################################################

    public void sortOnBundleDomainUid()
    {
        setSort(Sort.BundleDomainUid);
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
    //# find
    //##################################################

    @Override
    public KmList<MyAuditLogBundleVo> findAll()
    {
        MyAuditLogCriteria c;
        c = getAccess().getAuditLogDao().createCriteria();

        selectColumnsOn(c);
        applyConditionsTo(c);
        applySortsTo(c);

        return composeResultsFor(c);
    }

    @Override
    public KmList<MyAuditLogBundleVo> findBatch(int index, int count)
    {
        MyAuditLogCriteria c;
        c = getAccess().getAuditLogDao().createCriteria();

        selectColumnsOn(c);
        applyConditionsTo(c);
        applyBatchTo(c, index, count);
        applySortsTo(c);

        return composeResultsFor(c);
    }

    @Override
    public int getCount()
    {
        MyAuditLogCriteria c;
        c = getAccess().getAuditLogDao().createCriteria();
        c.selectCountDistinctDomainBundleUid();
        applyConditionsTo(c);
        return c.findInteger();
    }

    //==================================================
    //= find :: apply
    //==================================================

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

    private void applyBatchTo(MyAuditLogCriteria c, int index, int count)
    {
        c.setFirstResult(index);
        c.setMaxResults(count);
    }

    protected void applySortsTo(MyAuditLogCriteria c)
    {
        if ( !usesSort() )
            return;

        Sort sort = getSort();
        boolean asc = getAscending();

        switch ( sort )
        {
            case BundleDomainUid:
                c.sortOnUid(asc);
                break;
        }
    }

    //==================================================
    //= find :: compose
    //==================================================

    private KmList<MyAuditLogBundleVo> composeResultsFor(MyAuditLogCriteria c)
    {
        KmList<MyAuditLogBundleVo> v = new KmList<>();

        for ( KmhProjectionRow row : c.findResults() )
            v.add(composeResultFor(row));

        return v;
    }

    private MyAuditLogBundleVo composeResultFor(KmhProjectionRow row)
    {
        // must match selectColumnsOn
        MyAuditLogBundleVo e;
        e = new MyAuditLogBundleVo();
        e.setTransactionUid(row.nextString());
        e.setUser(getAccess().findUserUid(row.nextString()));
        e.setUserName(row.nextString());
        e.setTypeCode(row.nextString());
        e.setLogUtcTs(row.nextTimestamp());
        e.setDomainType(row.nextString());
        e.setDomainName(row.nextString());
        e.setDomainBundleUid(row.nextString());
        return e;
    }

    private void selectColumnsOn(MyAuditLogCriteria c)
    {
        // must match composeResultFor
        c.selectTransactionUid();
        c.selectUserUid();
        c.selectUserName();
        c.selectTypeCode();
        c.selectCreatedUtcTs();
        c.selectDomainType();
        c.selectDomainName();
        c.selectDomainUid();
        c.groupByDomainBundleUid();
    }

}
