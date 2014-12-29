//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.criteria;

import com.kodemore.collection.*;
import com.kodemore.hibernate.*;
import com.kodemore.hibernate.criteria.*;
import com.kodemore.time.*;
import com.kodemore.types.*;

import com.app.criteria.core.*;
import com.app.dao.*;
import com.app.dao.base.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.meta.*;

public class MyHibernateCacheTestCriteria
    extends MyAbstractCriteria<MyHibernateCacheTest>
    implements MyHibernateCacheTestDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyHibernateCacheTestCriteria(KmCriteria parent)
    {
        super(parent);
    }

    public MyHibernateCacheTestCriteria(KmCriteria parent, KmAbstractCriteria context)
    {
        super(parent, context);
    }

    //##################################################
    //# properties
    //##################################################

    public KmStringCriteria whereUid()
    {
        return new KmStringCriteria(context(), fullName(UID));
    }

    public KmStringCriteria whereData()
    {
        return new KmStringCriteria(context(), fullName(DATA));
    }

    public KmIntegerCriteria whereLockVersion()
    {
        return new KmIntegerCriteria(context(), fullName(LOCK_VERSION));
    }

    //##################################################
    //# sorts
    //##################################################

    public void sortOnUid()
    {
        parent().sortAscending(UID);
    }

    public void sortOnUidDescending()
    {
        parent().sortDescending(UID);
    }

    public void sortOnUid(boolean asc)
    {
        if ( asc )
            sortOnUid();
        else
            sortOnUidDescending();
    }

    public void sortOnData()
    {
        parent().sortAscending(DATA);
    }

    public void sortOnDataDescending()
    {
        parent().sortDescending(DATA);
    }

    public void sortOnData(boolean asc)
    {
        if ( asc )
            sortOnData();
        else
            sortOnDataDescending();
    }

    public void sortOnLockVersion()
    {
        parent().sortAscending(LOCK_VERSION);
    }

    public void sortOnLockVersionDescending()
    {
        parent().sortDescending(LOCK_VERSION);
    }

    public void sortOnLockVersion(boolean asc)
    {
        if ( asc )
            sortOnLockVersion();
        else
            sortOnLockVersionDescending();
    }

    //##################################################
    //# projections (uid)
    //##################################################

    public void selectUid()
    {
        select(UID);
    }

    public void selectDistinctUid()
    {
        selectDistinct(UID);
    }

    public void selectCountDistinctUid()
    {
        selectCountDistinct(UID);
    }

    public void selectMinimumUid()
    {
        selectMinimum(UID);
    }

    public void selectMaximumUid()
    {
        selectMaximum(UID);
    }

    public void selectAverageUid()
    {
        selectAverage(UID);
    }

    public void selectSumUid()
    {
        selectSum(UID);
    }

    public void groupByUid()
    {
        groupBy(UID);
    }

    //##################################################
    //# projections (data)
    //##################################################

    public void selectData()
    {
        select(DATA);
    }

    public void selectDistinctData()
    {
        selectDistinct(DATA);
    }

    public void selectCountDistinctData()
    {
        selectCountDistinct(DATA);
    }

    public void selectMinimumData()
    {
        selectMinimum(DATA);
    }

    public void selectMaximumData()
    {
        selectMaximum(DATA);
    }

    public void selectAverageData()
    {
        selectAverage(DATA);
    }

    public void selectSumData()
    {
        selectSum(DATA);
    }

    public void groupByData()
    {
        groupBy(DATA);
    }

    //##################################################
    //# projections (lockVersion)
    //##################################################

    public void selectLockVersion()
    {
        select(LOCK_VERSION);
    }

    public void selectDistinctLockVersion()
    {
        selectDistinct(LOCK_VERSION);
    }

    public void selectCountDistinctLockVersion()
    {
        selectCountDistinct(LOCK_VERSION);
    }

    public void selectMinimumLockVersion()
    {
        selectMinimum(LOCK_VERSION);
    }

    public void selectMaximumLockVersion()
    {
        selectMaximum(LOCK_VERSION);
    }

    public void selectAverageLockVersion()
    {
        selectAverage(LOCK_VERSION);
    }

    public void selectSumLockVersion()
    {
        selectSum(LOCK_VERSION);
    }

    public void groupByLockVersion()
    {
        groupBy(LOCK_VERSION);
    }

    //##################################################
    //# junction
    //##################################################

    public MyHibernateCacheTestJunction addAnd()
    {
        return new MyHibernateCacheTestJunction(parent().addAnd());
    }

    public MyHibernateCacheTestJunction addOr()
    {
        return new MyHibernateCacheTestJunction(parent().addOr());
    }

    //##################################################
    //# support
    //##################################################

    @Override
    public MyHibernateCacheTestCriteria createOn(KmModelJunction junction)
    {
        return new MyHibernateCacheTestCriteria(parent(), junction.context());
    }

}
