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
import com.kodemore.hibernate.basic.*;
import com.kodemore.time.*;
import com.kodemore.types.*;

import com.app.criteria.core.*;
import com.app.dao.*;
import com.app.dao.base.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.base.*;
import com.app.model.meta.*;

public class MyHibernateCacheTestCriteria
    extends MyAbstractCriteria<MyHibernateCacheTest>
    implements MyHibernateCacheTestDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyHibernateCacheTestCriteria(KmhCriteria parent)
    {
        super(parent);
    }

    //##################################################
    //# primary key
    //##################################################

    public void whereUidIs(MyHibernateCacheTest e)
    {
        whereUid().is(e.getUid());
    }

    public void whereUidIsNot(MyHibernateCacheTest e)
    {
        whereUid().isNot(e.getUid());
    }

    //##################################################
    //# properties
    //##################################################

    public KmhStringCondition whereData()
    {
        return new KmhStringCondition(context(), alias(), DATA);
    }

    public KmhStringCondition whereUid()
    {
        return new KmhStringCondition(context(), alias(), UID);
    }

    public KmhIntegerCondition whereLockVersion()
    {
        return new KmhIntegerCondition(context(), alias(), LOCK_VERSION);
    }

    //##################################################
    //# sorts
    //##################################################

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
    //# junction :: alias
    //##################################################

    public MyHibernateCacheTestJunction all()
    {
        return addAnd();
    }

    public MyHibernateCacheTestJunction any()
    {
        return addOr();
    }

    public MyHibernateCacheTestJunction none()
    {
        return addNotOr();
    }

    //##################################################
    //# junction :: basic
    //##################################################

    public MyHibernateCacheTestJunction addNotAnd()
    {
        return new MyHibernateCacheTestJunction(parent().addNotAnd());
    }

    public MyHibernateCacheTestJunction addNotOr()
    {
        return new MyHibernateCacheTestJunction(parent().addNotOr());
    }

    public MyHibernateCacheTestJunction addAnd()
    {
        return new MyHibernateCacheTestJunction(parent().addAnd());
    }

    public MyHibernateCacheTestJunction addOr()
    {
        return new MyHibernateCacheTestJunction(parent().addOr());
    }
}
