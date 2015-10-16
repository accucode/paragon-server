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

public class MySalesOrderLineCriteria
    extends MyAbstractCriteria<MySalesOrderLine>
    implements MySalesOrderLineDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MySalesOrderLineCriteria(KmhCriteria parent)
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

    public KmhPropertyCondition<KmMoney> whereListPrice()
    {
        return new KmhPropertyCondition<>(context(), fullName(LIST_PRICE));
    }

    public KmhPropertyCondition<KmMoney> whereUnitPrice()
    {
        return new KmhPropertyCondition<>(context(), fullName(UNIT_PRICE));
    }

    public KmhIntegerCondition whereOrderedQuantity()
    {
        return new KmhIntegerCondition(context(), fullName(ORDERED_QUANTITY));
    }

    public KmhIntegerCondition whereFulfilledQuantity()
    {
        return new KmhIntegerCondition(context(), fullName(FULFILLED_QUANTITY));
    }

    public KmhPropertyCondition<KmMoney> whereExtendedPrice()
    {
        return new KmhPropertyCondition<>(context(), fullName(EXTENDED_PRICE));
    }

    public KmhPropertyCondition<KmMoney> wherePriceAdjustment()
    {
        return new KmhPropertyCondition<>(context(), fullName(PRICE_ADJUSTMENT));
    }

    public KmhPropertyCondition<KmMoney> whereAdjustedPrice()
    {
        return new KmhPropertyCondition<>(context(), fullName(ADJUSTED_PRICE));
    }

    public KmhPropertyCondition<KmMoney> whereTax()
    {
        return new KmhPropertyCondition<>(context(), fullName(TAX));
    }

    public KmhPropertyCondition<KmMoney> whereTotalPrice()
    {
        return new KmhPropertyCondition<>(context(), fullName(TOTAL_PRICE));
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

    public void sortOnListPrice()
    {
        parent().sortAscending(LIST_PRICE);
    }

    public void sortOnListPriceDescending()
    {
        parent().sortDescending(LIST_PRICE);
    }

    public void sortOnListPrice(boolean asc)
    {
        if ( asc )
            sortOnListPrice();
        else
            sortOnListPriceDescending();
    }

    public void sortOnUnitPrice()
    {
        parent().sortAscending(UNIT_PRICE);
    }

    public void sortOnUnitPriceDescending()
    {
        parent().sortDescending(UNIT_PRICE);
    }

    public void sortOnUnitPrice(boolean asc)
    {
        if ( asc )
            sortOnUnitPrice();
        else
            sortOnUnitPriceDescending();
    }

    public void sortOnOrderedQuantity()
    {
        parent().sortAscending(ORDERED_QUANTITY);
    }

    public void sortOnOrderedQuantityDescending()
    {
        parent().sortDescending(ORDERED_QUANTITY);
    }

    public void sortOnOrderedQuantity(boolean asc)
    {
        if ( asc )
            sortOnOrderedQuantity();
        else
            sortOnOrderedQuantityDescending();
    }

    public void sortOnFulfilledQuantity()
    {
        parent().sortAscending(FULFILLED_QUANTITY);
    }

    public void sortOnFulfilledQuantityDescending()
    {
        parent().sortDescending(FULFILLED_QUANTITY);
    }

    public void sortOnFulfilledQuantity(boolean asc)
    {
        if ( asc )
            sortOnFulfilledQuantity();
        else
            sortOnFulfilledQuantityDescending();
    }

    public void sortOnExtendedPrice()
    {
        parent().sortAscending(EXTENDED_PRICE);
    }

    public void sortOnExtendedPriceDescending()
    {
        parent().sortDescending(EXTENDED_PRICE);
    }

    public void sortOnExtendedPrice(boolean asc)
    {
        if ( asc )
            sortOnExtendedPrice();
        else
            sortOnExtendedPriceDescending();
    }

    public void sortOnPriceAdjustment()
    {
        parent().sortAscending(PRICE_ADJUSTMENT);
    }

    public void sortOnPriceAdjustmentDescending()
    {
        parent().sortDescending(PRICE_ADJUSTMENT);
    }

    public void sortOnPriceAdjustment(boolean asc)
    {
        if ( asc )
            sortOnPriceAdjustment();
        else
            sortOnPriceAdjustmentDescending();
    }

    public void sortOnAdjustedPrice()
    {
        parent().sortAscending(ADJUSTED_PRICE);
    }

    public void sortOnAdjustedPriceDescending()
    {
        parent().sortDescending(ADJUSTED_PRICE);
    }

    public void sortOnAdjustedPrice(boolean asc)
    {
        if ( asc )
            sortOnAdjustedPrice();
        else
            sortOnAdjustedPriceDescending();
    }

    public void sortOnTax()
    {
        parent().sortAscending(TAX);
    }

    public void sortOnTaxDescending()
    {
        parent().sortDescending(TAX);
    }

    public void sortOnTax(boolean asc)
    {
        if ( asc )
            sortOnTax();
        else
            sortOnTaxDescending();
    }

    public void sortOnTotalPrice()
    {
        parent().sortAscending(TOTAL_PRICE);
    }

    public void sortOnTotalPriceDescending()
    {
        parent().sortDescending(TOTAL_PRICE);
    }

    public void sortOnTotalPrice(boolean asc)
    {
        if ( asc )
            sortOnTotalPrice();
        else
            sortOnTotalPriceDescending();
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
    //# projections (listPrice)
    //##################################################

    public void selectListPrice()
    {
        select(LIST_PRICE);
    }

    public void selectDistinctListPrice()
    {
        selectDistinct(LIST_PRICE);
    }

    public void selectCountDistinctListPrice()
    {
        selectCountDistinct(LIST_PRICE);
    }

    public void selectMinimumListPrice()
    {
        selectMinimum(LIST_PRICE);
    }

    public void selectMaximumListPrice()
    {
        selectMaximum(LIST_PRICE);
    }

    public void selectAverageListPrice()
    {
        selectAverage(LIST_PRICE);
    }

    public void selectSumListPrice()
    {
        selectSum(LIST_PRICE);
    }

    public void groupByListPrice()
    {
        groupBy(LIST_PRICE);
    }

    //##################################################
    //# projections (unitPrice)
    //##################################################

    public void selectUnitPrice()
    {
        select(UNIT_PRICE);
    }

    public void selectDistinctUnitPrice()
    {
        selectDistinct(UNIT_PRICE);
    }

    public void selectCountDistinctUnitPrice()
    {
        selectCountDistinct(UNIT_PRICE);
    }

    public void selectMinimumUnitPrice()
    {
        selectMinimum(UNIT_PRICE);
    }

    public void selectMaximumUnitPrice()
    {
        selectMaximum(UNIT_PRICE);
    }

    public void selectAverageUnitPrice()
    {
        selectAverage(UNIT_PRICE);
    }

    public void selectSumUnitPrice()
    {
        selectSum(UNIT_PRICE);
    }

    public void groupByUnitPrice()
    {
        groupBy(UNIT_PRICE);
    }

    //##################################################
    //# projections (orderedQuantity)
    //##################################################

    public void selectOrderedQuantity()
    {
        select(ORDERED_QUANTITY);
    }

    public void selectDistinctOrderedQuantity()
    {
        selectDistinct(ORDERED_QUANTITY);
    }

    public void selectCountDistinctOrderedQuantity()
    {
        selectCountDistinct(ORDERED_QUANTITY);
    }

    public void selectMinimumOrderedQuantity()
    {
        selectMinimum(ORDERED_QUANTITY);
    }

    public void selectMaximumOrderedQuantity()
    {
        selectMaximum(ORDERED_QUANTITY);
    }

    public void selectAverageOrderedQuantity()
    {
        selectAverage(ORDERED_QUANTITY);
    }

    public void selectSumOrderedQuantity()
    {
        selectSum(ORDERED_QUANTITY);
    }

    public void groupByOrderedQuantity()
    {
        groupBy(ORDERED_QUANTITY);
    }

    //##################################################
    //# projections (fulfilledQuantity)
    //##################################################

    public void selectFulfilledQuantity()
    {
        select(FULFILLED_QUANTITY);
    }

    public void selectDistinctFulfilledQuantity()
    {
        selectDistinct(FULFILLED_QUANTITY);
    }

    public void selectCountDistinctFulfilledQuantity()
    {
        selectCountDistinct(FULFILLED_QUANTITY);
    }

    public void selectMinimumFulfilledQuantity()
    {
        selectMinimum(FULFILLED_QUANTITY);
    }

    public void selectMaximumFulfilledQuantity()
    {
        selectMaximum(FULFILLED_QUANTITY);
    }

    public void selectAverageFulfilledQuantity()
    {
        selectAverage(FULFILLED_QUANTITY);
    }

    public void selectSumFulfilledQuantity()
    {
        selectSum(FULFILLED_QUANTITY);
    }

    public void groupByFulfilledQuantity()
    {
        groupBy(FULFILLED_QUANTITY);
    }

    //##################################################
    //# projections (extendedPrice)
    //##################################################

    public void selectExtendedPrice()
    {
        select(EXTENDED_PRICE);
    }

    public void selectDistinctExtendedPrice()
    {
        selectDistinct(EXTENDED_PRICE);
    }

    public void selectCountDistinctExtendedPrice()
    {
        selectCountDistinct(EXTENDED_PRICE);
    }

    public void selectMinimumExtendedPrice()
    {
        selectMinimum(EXTENDED_PRICE);
    }

    public void selectMaximumExtendedPrice()
    {
        selectMaximum(EXTENDED_PRICE);
    }

    public void selectAverageExtendedPrice()
    {
        selectAverage(EXTENDED_PRICE);
    }

    public void selectSumExtendedPrice()
    {
        selectSum(EXTENDED_PRICE);
    }

    public void groupByExtendedPrice()
    {
        groupBy(EXTENDED_PRICE);
    }

    //##################################################
    //# projections (priceAdjustment)
    //##################################################

    public void selectPriceAdjustment()
    {
        select(PRICE_ADJUSTMENT);
    }

    public void selectDistinctPriceAdjustment()
    {
        selectDistinct(PRICE_ADJUSTMENT);
    }

    public void selectCountDistinctPriceAdjustment()
    {
        selectCountDistinct(PRICE_ADJUSTMENT);
    }

    public void selectMinimumPriceAdjustment()
    {
        selectMinimum(PRICE_ADJUSTMENT);
    }

    public void selectMaximumPriceAdjustment()
    {
        selectMaximum(PRICE_ADJUSTMENT);
    }

    public void selectAveragePriceAdjustment()
    {
        selectAverage(PRICE_ADJUSTMENT);
    }

    public void selectSumPriceAdjustment()
    {
        selectSum(PRICE_ADJUSTMENT);
    }

    public void groupByPriceAdjustment()
    {
        groupBy(PRICE_ADJUSTMENT);
    }

    //##################################################
    //# projections (adjustedPrice)
    //##################################################

    public void selectAdjustedPrice()
    {
        select(ADJUSTED_PRICE);
    }

    public void selectDistinctAdjustedPrice()
    {
        selectDistinct(ADJUSTED_PRICE);
    }

    public void selectCountDistinctAdjustedPrice()
    {
        selectCountDistinct(ADJUSTED_PRICE);
    }

    public void selectMinimumAdjustedPrice()
    {
        selectMinimum(ADJUSTED_PRICE);
    }

    public void selectMaximumAdjustedPrice()
    {
        selectMaximum(ADJUSTED_PRICE);
    }

    public void selectAverageAdjustedPrice()
    {
        selectAverage(ADJUSTED_PRICE);
    }

    public void selectSumAdjustedPrice()
    {
        selectSum(ADJUSTED_PRICE);
    }

    public void groupByAdjustedPrice()
    {
        groupBy(ADJUSTED_PRICE);
    }

    //##################################################
    //# projections (tax)
    //##################################################

    public void selectTax()
    {
        select(TAX);
    }

    public void selectDistinctTax()
    {
        selectDistinct(TAX);
    }

    public void selectCountDistinctTax()
    {
        selectCountDistinct(TAX);
    }

    public void selectMinimumTax()
    {
        selectMinimum(TAX);
    }

    public void selectMaximumTax()
    {
        selectMaximum(TAX);
    }

    public void selectAverageTax()
    {
        selectAverage(TAX);
    }

    public void selectSumTax()
    {
        selectSum(TAX);
    }

    public void groupByTax()
    {
        groupBy(TAX);
    }

    //##################################################
    //# projections (totalPrice)
    //##################################################

    public void selectTotalPrice()
    {
        select(TOTAL_PRICE);
    }

    public void selectDistinctTotalPrice()
    {
        selectDistinct(TOTAL_PRICE);
    }

    public void selectCountDistinctTotalPrice()
    {
        selectCountDistinct(TOTAL_PRICE);
    }

    public void selectMinimumTotalPrice()
    {
        selectMinimum(TOTAL_PRICE);
    }

    public void selectMaximumTotalPrice()
    {
        selectMaximum(TOTAL_PRICE);
    }

    public void selectAverageTotalPrice()
    {
        selectAverage(TOTAL_PRICE);
    }

    public void selectSumTotalPrice()
    {
        selectSum(TOTAL_PRICE);
    }

    public void groupByTotalPrice()
    {
        groupBy(TOTAL_PRICE);
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

    public MySalesOrderLineJunction addAnd()
    {
        return new MySalesOrderLineJunction(parent().addAnd());
    }

    public MySalesOrderLineJunction addOr()
    {
        return new MySalesOrderLineJunction(parent().addOr());
    }
}
