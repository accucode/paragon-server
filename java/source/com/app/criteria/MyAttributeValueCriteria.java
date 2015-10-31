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

    public KmhStringCondition whereTextValue()
    {
        return new KmhStringCondition(context(), fullName(TEXT_VALUE));
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

    public void sortOnTextValue()
    {
        parent().sortAscending(TEXT_VALUE);
    }

    public void sortOnTextValueDescending()
    {
        parent().sortDescending(TEXT_VALUE);
    }

    public void sortOnTextValue(boolean asc)
    {
        if ( asc )
            sortOnTextValue();
        else
            sortOnTextValueDescending();
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
    //# projections (textValue)
    //##################################################

    public void selectTextValue()
    {
        select(TEXT_VALUE);
    }

    public void selectDistinctTextValue()
    {
        selectDistinct(TEXT_VALUE);
    }

    public void selectCountDistinctTextValue()
    {
        selectCountDistinct(TEXT_VALUE);
    }

    public void selectMinimumTextValue()
    {
        selectMinimum(TEXT_VALUE);
    }

    public void selectMaximumTextValue()
    {
        selectMaximum(TEXT_VALUE);
    }

    public void selectAverageTextValue()
    {
        selectAverage(TEXT_VALUE);
    }

    public void selectSumTextValue()
    {
        selectSum(TEXT_VALUE);
    }

    public void groupByTextValue()
    {
        groupBy(TEXT_VALUE);
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
    //# association (CustomerSite)
    //##################################################

    public void selectCustomerSiteUid()
    {
        select(CUSTOMER_SITE_UID);
    }

    public void selectMinimumCustomerSiteUid()
    {
        selectMinimum(CUSTOMER_SITE_UID);
    }

    public void selectMaximumCustomerSiteUid()
    {
        selectMaximum(CUSTOMER_SITE_UID);
    }

    public void groupByCustomerSiteUid()
    {
        groupBy(CUSTOMER_SITE);
    }

    public MyCustomerSiteCriteria joinToCustomerSite()
    {
        return new MyCustomerSiteCriteria(joinTo(CUSTOMER_SITE));
    }

    public MyCustomerSiteCriteria leftJoinToCustomerSite()
    {
        return new MyCustomerSiteCriteria(leftJoinTo(CUSTOMER_SITE));
    }

    public KmhStringCondition whereCustomerSiteUid()
    {
        return new KmhStringCondition(parent(), fullName(CUSTOMER_SITE_UID));
    }

    public void whereCustomerSiteIs(MyCustomerSite e)
    {
        if ( e == null )
            whereCustomerSiteUid().isNull();
        else
            whereCustomerSiteUid().is(e.getUid());
    }

    //##################################################
    //# association (SalesOrderLine)
    //##################################################

    public void selectSalesOrderLineUid()
    {
        select(SALES_ORDER_LINE_UID);
    }

    public void selectMinimumSalesOrderLineUid()
    {
        selectMinimum(SALES_ORDER_LINE_UID);
    }

    public void selectMaximumSalesOrderLineUid()
    {
        selectMaximum(SALES_ORDER_LINE_UID);
    }

    public void groupBySalesOrderLineUid()
    {
        groupBy(SALES_ORDER_LINE);
    }

    public MySalesOrderLineCriteria joinToSalesOrderLine()
    {
        return new MySalesOrderLineCriteria(joinTo(SALES_ORDER_LINE));
    }

    public MySalesOrderLineCriteria leftJoinToSalesOrderLine()
    {
        return new MySalesOrderLineCriteria(leftJoinTo(SALES_ORDER_LINE));
    }

    public KmhStringCondition whereSalesOrderLineUid()
    {
        return new KmhStringCondition(parent(), fullName(SALES_ORDER_LINE_UID));
    }

    public void whereSalesOrderLineIs(MySalesOrderLine e)
    {
        if ( e == null )
            whereSalesOrderLineUid().isNull();
        else
            whereSalesOrderLineUid().is(e.getUid());
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
