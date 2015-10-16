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
import com.app.model.meta.*;

public class MyAttributeValueCriteria
    extends MyAbstractCriteria<MyAttributeValue>
    implements MyAttributeValueDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyAttributeValueCriteria(KmhCriteria parent)
    {
        super(parent);
    }

    //##################################################
    //# properties
    //##################################################

    public KmhStringCondition whereUid()
    {
        return new KmhStringCondition(context(), fullName(UID));
    }

    public KmhStringCondition whereData()
    {
        return new KmhStringCondition(context(), fullName(DATA));
    }

    public KmhIntegerCondition whereLockVersion()
    {
        return new KmhIntegerCondition(context(), fullName(LOCK_VERSION));
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
    //# association (Field)
    //##################################################

    public void selectFieldUid()
    {
        select(FIELD_UID);
    }

    public void selectMinimumFieldUid()
    {
        selectMinimum(FIELD_UID);
    }

    public void selectMaximumFieldUid()
    {
        selectMaximum(FIELD_UID);
    }

    public void groupByFieldUid()
    {
        groupBy(FIELD);
    }

    public MyAttributeFieldCriteria joinToField()
    {
        return new MyAttributeFieldCriteria(joinTo(FIELD));
    }

    public MyAttributeFieldCriteria leftJoinToField()
    {
        return new MyAttributeFieldCriteria(leftJoinTo(FIELD));
    }

    public KmhStringCondition whereFieldUid()
    {
        return new KmhStringCondition(parent(), fullName(FIELD_UID));
    }

    public void whereFieldIs(MyAttributeField e)
    {
        if ( e == null )
            whereFieldUid().isNull();
        else
            whereFieldUid().is(e.getUid());
    }

    //##################################################
    //# association (Product)
    //##################################################

    public void selectProductUid()
    {
        select(PRODUCT_UID);
    }

    public void selectMinimumProductUid()
    {
        selectMinimum(PRODUCT_UID);
    }

    public void selectMaximumProductUid()
    {
        selectMaximum(PRODUCT_UID);
    }

    public void groupByProductUid()
    {
        groupBy(PRODUCT);
    }

    public MyProductCriteria joinToProduct()
    {
        return new MyProductCriteria(joinTo(PRODUCT));
    }

    public MyProductCriteria leftJoinToProduct()
    {
        return new MyProductCriteria(leftJoinTo(PRODUCT));
    }

    public KmhStringCondition whereProductUid()
    {
        return new KmhStringCondition(parent(), fullName(PRODUCT_UID));
    }

    public void whereProductIs(MyProduct e)
    {
        if ( e == null )
            whereProductUid().isNull();
        else
            whereProductUid().is(e.getUid());
    }

    //##################################################
    //# junction
    //##################################################

    public MyAttributeValueJunction addAnd()
    {
        return new MyAttributeValueJunction(parent().addAnd());
    }

    public MyAttributeValueJunction addOr()
    {
        return new MyAttributeValueJunction(parent().addOr());
    }
}
