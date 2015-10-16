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

public class MyShipmentCriteria
    extends MyAbstractCriteria<MyShipment>
    implements MyShipmentDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyShipmentCriteria(KmhCriteria parent)
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

    public KmhStringCondition whereTrackingNumber()
    {
        return new KmhStringCondition(context(), fullName(TRACKING_NUMBER));
    }

    public KmhPropertyCondition<Double> whereWeight()
    {
        return new KmhPropertyCondition<>(context(), fullName(WEIGHT));
    }

    public KmhPropertyCondition<KmMoney> whereCost()
    {
        return new KmhPropertyCondition<>(context(), fullName(COST));
    }

    public KmhBooleanCondition whereInvoiceCustomer()
    {
        return new KmhBooleanCondition(context(), fullName(INVOICE_CUSTOMER));
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

    public void sortOnTrackingNumber()
    {
        parent().sortAscending(TRACKING_NUMBER);
    }

    public void sortOnTrackingNumberDescending()
    {
        parent().sortDescending(TRACKING_NUMBER);
    }

    public void sortOnTrackingNumber(boolean asc)
    {
        if ( asc )
            sortOnTrackingNumber();
        else
            sortOnTrackingNumberDescending();
    }

    public void sortOnWeight()
    {
        parent().sortAscending(WEIGHT);
    }

    public void sortOnWeightDescending()
    {
        parent().sortDescending(WEIGHT);
    }

    public void sortOnWeight(boolean asc)
    {
        if ( asc )
            sortOnWeight();
        else
            sortOnWeightDescending();
    }

    public void sortOnCost()
    {
        parent().sortAscending(COST);
    }

    public void sortOnCostDescending()
    {
        parent().sortDescending(COST);
    }

    public void sortOnCost(boolean asc)
    {
        if ( asc )
            sortOnCost();
        else
            sortOnCostDescending();
    }

    public void sortOnInvoiceCustomer()
    {
        parent().sortAscending(INVOICE_CUSTOMER);
    }

    public void sortOnInvoiceCustomerDescending()
    {
        parent().sortDescending(INVOICE_CUSTOMER);
    }

    public void sortOnInvoiceCustomer(boolean asc)
    {
        if ( asc )
            sortOnInvoiceCustomer();
        else
            sortOnInvoiceCustomerDescending();
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
    //# projections (trackingNumber)
    //##################################################

    public void selectTrackingNumber()
    {
        select(TRACKING_NUMBER);
    }

    public void selectDistinctTrackingNumber()
    {
        selectDistinct(TRACKING_NUMBER);
    }

    public void selectCountDistinctTrackingNumber()
    {
        selectCountDistinct(TRACKING_NUMBER);
    }

    public void selectMinimumTrackingNumber()
    {
        selectMinimum(TRACKING_NUMBER);
    }

    public void selectMaximumTrackingNumber()
    {
        selectMaximum(TRACKING_NUMBER);
    }

    public void selectAverageTrackingNumber()
    {
        selectAverage(TRACKING_NUMBER);
    }

    public void selectSumTrackingNumber()
    {
        selectSum(TRACKING_NUMBER);
    }

    public void groupByTrackingNumber()
    {
        groupBy(TRACKING_NUMBER);
    }

    //##################################################
    //# projections (weight)
    //##################################################

    public void selectWeight()
    {
        select(WEIGHT);
    }

    public void selectDistinctWeight()
    {
        selectDistinct(WEIGHT);
    }

    public void selectCountDistinctWeight()
    {
        selectCountDistinct(WEIGHT);
    }

    public void selectMinimumWeight()
    {
        selectMinimum(WEIGHT);
    }

    public void selectMaximumWeight()
    {
        selectMaximum(WEIGHT);
    }

    public void selectAverageWeight()
    {
        selectAverage(WEIGHT);
    }

    public void selectSumWeight()
    {
        selectSum(WEIGHT);
    }

    public void groupByWeight()
    {
        groupBy(WEIGHT);
    }

    //##################################################
    //# projections (cost)
    //##################################################

    public void selectCost()
    {
        select(COST);
    }

    public void selectDistinctCost()
    {
        selectDistinct(COST);
    }

    public void selectCountDistinctCost()
    {
        selectCountDistinct(COST);
    }

    public void selectMinimumCost()
    {
        selectMinimum(COST);
    }

    public void selectMaximumCost()
    {
        selectMaximum(COST);
    }

    public void selectAverageCost()
    {
        selectAverage(COST);
    }

    public void selectSumCost()
    {
        selectSum(COST);
    }

    public void groupByCost()
    {
        groupBy(COST);
    }

    //##################################################
    //# projections (invoiceCustomer)
    //##################################################

    public void selectInvoiceCustomer()
    {
        select(INVOICE_CUSTOMER);
    }

    public void selectDistinctInvoiceCustomer()
    {
        selectDistinct(INVOICE_CUSTOMER);
    }

    public void selectCountDistinctInvoiceCustomer()
    {
        selectCountDistinct(INVOICE_CUSTOMER);
    }

    public void selectMinimumInvoiceCustomer()
    {
        selectMinimum(INVOICE_CUSTOMER);
    }

    public void selectMaximumInvoiceCustomer()
    {
        selectMaximum(INVOICE_CUSTOMER);
    }

    public void selectAverageInvoiceCustomer()
    {
        selectAverage(INVOICE_CUSTOMER);
    }

    public void selectSumInvoiceCustomer()
    {
        selectSum(INVOICE_CUSTOMER);
    }

    public void groupByInvoiceCustomer()
    {
        groupBy(INVOICE_CUSTOMER);
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
    //# association (SalesOrder)
    //##################################################

    public void selectSalesOrderUid()
    {
        select(SALES_ORDER_UID);
    }

    public void selectMinimumSalesOrderUid()
    {
        selectMinimum(SALES_ORDER_UID);
    }

    public void selectMaximumSalesOrderUid()
    {
        selectMaximum(SALES_ORDER_UID);
    }

    public void groupBySalesOrderUid()
    {
        groupBy(SALES_ORDER);
    }

    public MySalesOrderCriteria joinToSalesOrder()
    {
        return new MySalesOrderCriteria(joinTo(SALES_ORDER));
    }

    public MySalesOrderCriteria leftJoinToSalesOrder()
    {
        return new MySalesOrderCriteria(leftJoinTo(SALES_ORDER));
    }

    public KmhStringCondition whereSalesOrderUid()
    {
        return new KmhStringCondition(parent(), fullName(SALES_ORDER_UID));
    }

    public void whereSalesOrderIs(MySalesOrder e)
    {
        if ( e == null )
            whereSalesOrderUid().isNull();
        else
            whereSalesOrderUid().is(e.getUid());
    }

    //##################################################
    //# association (Account)
    //##################################################

    public void selectAccountUid()
    {
        select(ACCOUNT_UID);
    }

    public void selectMinimumAccountUid()
    {
        selectMinimum(ACCOUNT_UID);
    }

    public void selectMaximumAccountUid()
    {
        selectMaximum(ACCOUNT_UID);
    }

    public void groupByAccountUid()
    {
        groupBy(ACCOUNT);
    }

    public MyShipAccountCriteria joinToAccount()
    {
        return new MyShipAccountCriteria(joinTo(ACCOUNT));
    }

    public MyShipAccountCriteria leftJoinToAccount()
    {
        return new MyShipAccountCriteria(leftJoinTo(ACCOUNT));
    }

    public KmhStringCondition whereAccountUid()
    {
        return new KmhStringCondition(parent(), fullName(ACCOUNT_UID));
    }

    public void whereAccountIs(MyShipAccount e)
    {
        if ( e == null )
            whereAccountUid().isNull();
        else
            whereAccountUid().is(e.getUid());
    }

    //##################################################
    //# association (Method)
    //##################################################

    public void selectMethodUid()
    {
        select(METHOD_UID);
    }

    public void selectMinimumMethodUid()
    {
        selectMinimum(METHOD_UID);
    }

    public void selectMaximumMethodUid()
    {
        selectMaximum(METHOD_UID);
    }

    public void groupByMethodUid()
    {
        groupBy(METHOD);
    }

    public MyShipMethodCriteria joinToMethod()
    {
        return new MyShipMethodCriteria(joinTo(METHOD));
    }

    public MyShipMethodCriteria leftJoinToMethod()
    {
        return new MyShipMethodCriteria(leftJoinTo(METHOD));
    }

    public KmhStringCondition whereMethodUid()
    {
        return new KmhStringCondition(parent(), fullName(METHOD_UID));
    }

    public void whereMethodIs(MyShipMethod e)
    {
        if ( e == null )
            whereMethodUid().isNull();
        else
            whereMethodUid().is(e.getUid());
    }

    //##################################################
    //# association (Depot)
    //##################################################

    public void selectDepotUid()
    {
        select(DEPOT_UID);
    }

    public void selectMinimumDepotUid()
    {
        selectMinimum(DEPOT_UID);
    }

    public void selectMaximumDepotUid()
    {
        selectMaximum(DEPOT_UID);
    }

    public void groupByDepotUid()
    {
        groupBy(DEPOT);
    }

    public MyDepotCriteria joinToDepot()
    {
        return new MyDepotCriteria(joinTo(DEPOT));
    }

    public MyDepotCriteria leftJoinToDepot()
    {
        return new MyDepotCriteria(leftJoinTo(DEPOT));
    }

    public KmhStringCondition whereDepotUid()
    {
        return new KmhStringCondition(parent(), fullName(DEPOT_UID));
    }

    public void whereDepotIs(MyDepot e)
    {
        if ( e == null )
            whereDepotUid().isNull();
        else
            whereDepotUid().is(e.getUid());
    }

    //##################################################
    //# junction
    //##################################################

    public MyShipmentJunction addAnd()
    {
        return new MyShipmentJunction(parent().addAnd());
    }

    public MyShipmentJunction addOr()
    {
        return new MyShipmentJunction(parent().addOr());
    }
}
