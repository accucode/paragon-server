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

public class MySalesOrderCriteria
    extends MyAbstractCriteria<MySalesOrder>
    implements MySalesOrderDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MySalesOrderCriteria(KmhCriteria parent)
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

    public KmhStringCondition whereNumber()
    {
        return new KmhStringCondition(context(), fullName(NUMBER));
    }

    public KmhStringCondition whereStatusCode()
    {
        return new KmhStringCondition(context(), fullName(STATUS_CODE));
    }

    public void whereStatusIs(MySalesOrderStatus e)
    {
        if ( e == null )
            whereStatusCode().isNull();
        else
            whereStatusCode().is(e.getCode());
    }

    public void whereStatusIsNot(MySalesOrderStatus e)
    {
        if ( e == null )
            whereStatusCode().isNull();
        else
            whereStatusCode().isNot(e.getCode());
    }

    public void whereStatusIsNew()
    {
        whereStatusIs(MySalesOrderStatus.New);
    }

    public void whereStatusIsNotNew()
    {
        whereStatusIsNot(MySalesOrderStatus.New);
    }

    public void whereStatusIsNew(boolean e)
    {
        if ( e )
            whereStatusIsNew();
        else
            whereStatusIsNotNew();
    }

    public void whereStatusIsIn()
    {
        whereStatusIs(MySalesOrderStatus.In);
    }

    public void whereStatusIsNotIn()
    {
        whereStatusIsNot(MySalesOrderStatus.In);
    }

    public void whereStatusIsIn(boolean e)
    {
        if ( e )
            whereStatusIsIn();
        else
            whereStatusIsNotIn();
    }

    public void whereStatusIsClosed()
    {
        whereStatusIs(MySalesOrderStatus.Closed);
    }

    public void whereStatusIsNotClosed()
    {
        whereStatusIsNot(MySalesOrderStatus.Closed);
    }

    public void whereStatusIsClosed(boolean e)
    {
        if ( e )
            whereStatusIsClosed();
        else
            whereStatusIsNotClosed();
    }

    public KmhTimestampCondition whereHoldUntilUtcTs()
    {
        return new KmhTimestampCondition(context(), fullName(HOLD_UNTIL_UTC_TS));
    }

    public KmhBooleanCondition whereExpedite()
    {
        return new KmhBooleanCondition(context(), fullName(EXPEDITE));
    }

    public KmhBooleanCondition whereTaxExempt()
    {
        return new KmhBooleanCondition(context(), fullName(TAX_EXEMPT));
    }

    public KmhPropertyCondition<Double> whereTaxRate()
    {
        return new KmhPropertyCondition<>(context(), fullName(TAX_RATE));
    }

    public KmhPropertyCondition<Double> whereDiscountRate()
    {
        return new KmhPropertyCondition<>(context(), fullName(DISCOUNT_RATE));
    }

    public KmhPropertyCondition<KmMoney> whereTotalPrice()
    {
        return new KmhPropertyCondition<>(context(), fullName(TOTAL_PRICE));
    }

    public KmhPropertyCondition<KmMoney> whereTotalTax()
    {
        return new KmhPropertyCondition<>(context(), fullName(TOTAL_TAX));
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

    public void sortOnNumber()
    {
        parent().sortAscending(NUMBER);
    }

    public void sortOnNumberDescending()
    {
        parent().sortDescending(NUMBER);
    }

    public void sortOnNumber(boolean asc)
    {
        if ( asc )
            sortOnNumber();
        else
            sortOnNumberDescending();
    }

    public void sortOnStatusCode()
    {
        parent().sortAscending(STATUS_CODE);
    }

    public void sortOnStatusCodeDescending()
    {
        parent().sortDescending(STATUS_CODE);
    }

    public void sortOnStatusCode(boolean asc)
    {
        if ( asc )
            sortOnStatusCode();
        else
            sortOnStatusCodeDescending();
    }

    public void sortOnHoldUntilUtcTs()
    {
        parent().sortAscending(HOLD_UNTIL_UTC_TS);
    }

    public void sortOnHoldUntilUtcTsDescending()
    {
        parent().sortDescending(HOLD_UNTIL_UTC_TS);
    }

    public void sortOnHoldUntilUtcTs(boolean asc)
    {
        if ( asc )
            sortOnHoldUntilUtcTs();
        else
            sortOnHoldUntilUtcTsDescending();
    }

    public void sortOnExpedite()
    {
        parent().sortAscending(EXPEDITE);
    }

    public void sortOnExpediteDescending()
    {
        parent().sortDescending(EXPEDITE);
    }

    public void sortOnExpedite(boolean asc)
    {
        if ( asc )
            sortOnExpedite();
        else
            sortOnExpediteDescending();
    }

    public void sortOnTaxExempt()
    {
        parent().sortAscending(TAX_EXEMPT);
    }

    public void sortOnTaxExemptDescending()
    {
        parent().sortDescending(TAX_EXEMPT);
    }

    public void sortOnTaxExempt(boolean asc)
    {
        if ( asc )
            sortOnTaxExempt();
        else
            sortOnTaxExemptDescending();
    }

    public void sortOnTaxRate()
    {
        parent().sortAscending(TAX_RATE);
    }

    public void sortOnTaxRateDescending()
    {
        parent().sortDescending(TAX_RATE);
    }

    public void sortOnTaxRate(boolean asc)
    {
        if ( asc )
            sortOnTaxRate();
        else
            sortOnTaxRateDescending();
    }

    public void sortOnDiscountRate()
    {
        parent().sortAscending(DISCOUNT_RATE);
    }

    public void sortOnDiscountRateDescending()
    {
        parent().sortDescending(DISCOUNT_RATE);
    }

    public void sortOnDiscountRate(boolean asc)
    {
        if ( asc )
            sortOnDiscountRate();
        else
            sortOnDiscountRateDescending();
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

    public void sortOnTotalTax()
    {
        parent().sortAscending(TOTAL_TAX);
    }

    public void sortOnTotalTaxDescending()
    {
        parent().sortDescending(TOTAL_TAX);
    }

    public void sortOnTotalTax(boolean asc)
    {
        if ( asc )
            sortOnTotalTax();
        else
            sortOnTotalTaxDescending();
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
    //# projections (number)
    //##################################################

    public void selectNumber()
    {
        select(NUMBER);
    }

    public void selectDistinctNumber()
    {
        selectDistinct(NUMBER);
    }

    public void selectCountDistinctNumber()
    {
        selectCountDistinct(NUMBER);
    }

    public void selectMinimumNumber()
    {
        selectMinimum(NUMBER);
    }

    public void selectMaximumNumber()
    {
        selectMaximum(NUMBER);
    }

    public void selectAverageNumber()
    {
        selectAverage(NUMBER);
    }

    public void selectSumNumber()
    {
        selectSum(NUMBER);
    }

    public void groupByNumber()
    {
        groupBy(NUMBER);
    }

    //##################################################
    //# projections (statusCode)
    //##################################################

    public void selectStatusCode()
    {
        select(STATUS_CODE);
    }

    public void selectDistinctStatusCode()
    {
        selectDistinct(STATUS_CODE);
    }

    public void selectCountDistinctStatusCode()
    {
        selectCountDistinct(STATUS_CODE);
    }

    public void selectMinimumStatusCode()
    {
        selectMinimum(STATUS_CODE);
    }

    public void selectMaximumStatusCode()
    {
        selectMaximum(STATUS_CODE);
    }

    public void selectAverageStatusCode()
    {
        selectAverage(STATUS_CODE);
    }

    public void selectSumStatusCode()
    {
        selectSum(STATUS_CODE);
    }

    public void groupByStatusCode()
    {
        groupBy(STATUS_CODE);
    }

    //##################################################
    //# projections (holdUntilUtcTs)
    //##################################################

    public void selectHoldUntilUtcTs()
    {
        select(HOLD_UNTIL_UTC_TS);
    }

    public void selectDistinctHoldUntilUtcTs()
    {
        selectDistinct(HOLD_UNTIL_UTC_TS);
    }

    public void selectCountDistinctHoldUntilUtcTs()
    {
        selectCountDistinct(HOLD_UNTIL_UTC_TS);
    }

    public void selectMinimumHoldUntilUtcTs()
    {
        selectMinimum(HOLD_UNTIL_UTC_TS);
    }

    public void selectMaximumHoldUntilUtcTs()
    {
        selectMaximum(HOLD_UNTIL_UTC_TS);
    }

    public void selectAverageHoldUntilUtcTs()
    {
        selectAverage(HOLD_UNTIL_UTC_TS);
    }

    public void selectSumHoldUntilUtcTs()
    {
        selectSum(HOLD_UNTIL_UTC_TS);
    }

    public void groupByHoldUntilUtcTs()
    {
        groupBy(HOLD_UNTIL_UTC_TS);
    }

    //##################################################
    //# projections (expedite)
    //##################################################

    public void selectExpedite()
    {
        select(EXPEDITE);
    }

    public void selectDistinctExpedite()
    {
        selectDistinct(EXPEDITE);
    }

    public void selectCountDistinctExpedite()
    {
        selectCountDistinct(EXPEDITE);
    }

    public void selectMinimumExpedite()
    {
        selectMinimum(EXPEDITE);
    }

    public void selectMaximumExpedite()
    {
        selectMaximum(EXPEDITE);
    }

    public void selectAverageExpedite()
    {
        selectAverage(EXPEDITE);
    }

    public void selectSumExpedite()
    {
        selectSum(EXPEDITE);
    }

    public void groupByExpedite()
    {
        groupBy(EXPEDITE);
    }

    //##################################################
    //# projections (taxExempt)
    //##################################################

    public void selectTaxExempt()
    {
        select(TAX_EXEMPT);
    }

    public void selectDistinctTaxExempt()
    {
        selectDistinct(TAX_EXEMPT);
    }

    public void selectCountDistinctTaxExempt()
    {
        selectCountDistinct(TAX_EXEMPT);
    }

    public void selectMinimumTaxExempt()
    {
        selectMinimum(TAX_EXEMPT);
    }

    public void selectMaximumTaxExempt()
    {
        selectMaximum(TAX_EXEMPT);
    }

    public void selectAverageTaxExempt()
    {
        selectAverage(TAX_EXEMPT);
    }

    public void selectSumTaxExempt()
    {
        selectSum(TAX_EXEMPT);
    }

    public void groupByTaxExempt()
    {
        groupBy(TAX_EXEMPT);
    }

    //##################################################
    //# projections (taxRate)
    //##################################################

    public void selectTaxRate()
    {
        select(TAX_RATE);
    }

    public void selectDistinctTaxRate()
    {
        selectDistinct(TAX_RATE);
    }

    public void selectCountDistinctTaxRate()
    {
        selectCountDistinct(TAX_RATE);
    }

    public void selectMinimumTaxRate()
    {
        selectMinimum(TAX_RATE);
    }

    public void selectMaximumTaxRate()
    {
        selectMaximum(TAX_RATE);
    }

    public void selectAverageTaxRate()
    {
        selectAverage(TAX_RATE);
    }

    public void selectSumTaxRate()
    {
        selectSum(TAX_RATE);
    }

    public void groupByTaxRate()
    {
        groupBy(TAX_RATE);
    }

    //##################################################
    //# projections (discountRate)
    //##################################################

    public void selectDiscountRate()
    {
        select(DISCOUNT_RATE);
    }

    public void selectDistinctDiscountRate()
    {
        selectDistinct(DISCOUNT_RATE);
    }

    public void selectCountDistinctDiscountRate()
    {
        selectCountDistinct(DISCOUNT_RATE);
    }

    public void selectMinimumDiscountRate()
    {
        selectMinimum(DISCOUNT_RATE);
    }

    public void selectMaximumDiscountRate()
    {
        selectMaximum(DISCOUNT_RATE);
    }

    public void selectAverageDiscountRate()
    {
        selectAverage(DISCOUNT_RATE);
    }

    public void selectSumDiscountRate()
    {
        selectSum(DISCOUNT_RATE);
    }

    public void groupByDiscountRate()
    {
        groupBy(DISCOUNT_RATE);
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
    //# projections (totalTax)
    //##################################################

    public void selectTotalTax()
    {
        select(TOTAL_TAX);
    }

    public void selectDistinctTotalTax()
    {
        selectDistinct(TOTAL_TAX);
    }

    public void selectCountDistinctTotalTax()
    {
        selectCountDistinct(TOTAL_TAX);
    }

    public void selectMinimumTotalTax()
    {
        selectMinimum(TOTAL_TAX);
    }

    public void selectMaximumTotalTax()
    {
        selectMaximum(TOTAL_TAX);
    }

    public void selectAverageTotalTax()
    {
        selectAverage(TOTAL_TAX);
    }

    public void selectSumTotalTax()
    {
        selectSum(TOTAL_TAX);
    }

    public void groupByTotalTax()
    {
        groupBy(TOTAL_TAX);
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
    //# association (Project)
    //##################################################

    public void selectProjectUid()
    {
        select(PROJECT_UID);
    }

    public void selectMinimumProjectUid()
    {
        selectMinimum(PROJECT_UID);
    }

    public void selectMaximumProjectUid()
    {
        selectMaximum(PROJECT_UID);
    }

    public void groupByProjectUid()
    {
        groupBy(PROJECT);
    }

    public MyProjectCriteria joinToProject()
    {
        return new MyProjectCriteria(joinTo(PROJECT));
    }

    public MyProjectCriteria leftJoinToProject()
    {
        return new MyProjectCriteria(leftJoinTo(PROJECT));
    }

    public KmhStringCondition whereProjectUid()
    {
        return new KmhStringCondition(parent(), fullName(PROJECT_UID));
    }

    public void whereProjectIs(MyProject e)
    {
        if ( e == null )
            whereProjectUid().isNull();
        else
            whereProjectUid().is(e.getUid());
    }

    //##################################################
    //# association (Customer)
    //##################################################

    public void selectCustomerUid()
    {
        select(CUSTOMER_UID);
    }

    public void selectMinimumCustomerUid()
    {
        selectMinimum(CUSTOMER_UID);
    }

    public void selectMaximumCustomerUid()
    {
        selectMaximum(CUSTOMER_UID);
    }

    public void groupByCustomerUid()
    {
        groupBy(CUSTOMER);
    }

    public MyCustomerCriteria joinToCustomer()
    {
        return new MyCustomerCriteria(joinTo(CUSTOMER));
    }

    public MyCustomerCriteria leftJoinToCustomer()
    {
        return new MyCustomerCriteria(leftJoinTo(CUSTOMER));
    }

    public KmhStringCondition whereCustomerUid()
    {
        return new KmhStringCondition(parent(), fullName(CUSTOMER_UID));
    }

    public void whereCustomerIs(MyCustomer e)
    {
        if ( e == null )
            whereCustomerUid().isNull();
        else
            whereCustomerUid().is(e.getUid());
    }

    //##################################################
    //# association (Region)
    //##################################################

    public void selectRegionUid()
    {
        select(REGION_UID);
    }

    public void selectMinimumRegionUid()
    {
        selectMinimum(REGION_UID);
    }

    public void selectMaximumRegionUid()
    {
        selectMaximum(REGION_UID);
    }

    public void groupByRegionUid()
    {
        groupBy(REGION);
    }

    public MyRegionCriteria joinToRegion()
    {
        return new MyRegionCriteria(joinTo(REGION));
    }

    public MyRegionCriteria leftJoinToRegion()
    {
        return new MyRegionCriteria(leftJoinTo(REGION));
    }

    public KmhStringCondition whereRegionUid()
    {
        return new KmhStringCondition(parent(), fullName(REGION_UID));
    }

    public void whereRegionIs(MyRegion e)
    {
        if ( e == null )
            whereRegionUid().isNull();
        else
            whereRegionUid().is(e.getUid());
    }

    //##################################################
    //# association (AttentionTo)
    //##################################################

    public void selectAttentionToUid()
    {
        select(ATTENTION_TO_UID);
    }

    public void selectMinimumAttentionToUid()
    {
        selectMinimum(ATTENTION_TO_UID);
    }

    public void selectMaximumAttentionToUid()
    {
        selectMaximum(ATTENTION_TO_UID);
    }

    public void groupByAttentionToUid()
    {
        groupBy(ATTENTION_TO);
    }

    public MyAttentionGroupCriteria joinToAttentionTo()
    {
        return new MyAttentionGroupCriteria(joinTo(ATTENTION_TO));
    }

    public MyAttentionGroupCriteria leftJoinToAttentionTo()
    {
        return new MyAttentionGroupCriteria(leftJoinTo(ATTENTION_TO));
    }

    public KmhStringCondition whereAttentionToUid()
    {
        return new KmhStringCondition(parent(), fullName(ATTENTION_TO_UID));
    }

    public void whereAttentionToIs(MyAttentionGroup e)
    {
        if ( e == null )
            whereAttentionToUid().isNull();
        else
            whereAttentionToUid().is(e.getUid());
    }

    //##################################################
    //# association (PowerType)
    //##################################################

    public void selectPowerTypeUid()
    {
        select(POWER_TYPE_UID);
    }

    public void selectMinimumPowerTypeUid()
    {
        selectMinimum(POWER_TYPE_UID);
    }

    public void selectMaximumPowerTypeUid()
    {
        selectMaximum(POWER_TYPE_UID);
    }

    public void groupByPowerTypeUid()
    {
        groupBy(POWER_TYPE);
    }

    public MyPowerTypeCriteria joinToPowerType()
    {
        return new MyPowerTypeCriteria(joinTo(POWER_TYPE));
    }

    public MyPowerTypeCriteria leftJoinToPowerType()
    {
        return new MyPowerTypeCriteria(leftJoinTo(POWER_TYPE));
    }

    public KmhStringCondition wherePowerTypeUid()
    {
        return new KmhStringCondition(parent(), fullName(POWER_TYPE_UID));
    }

    public void wherePowerTypeIs(MyPowerType e)
    {
        if ( e == null )
            wherePowerTypeUid().isNull();
        else
            wherePowerTypeUid().is(e.getUid());
    }

    //##################################################
    //# collection (Contacts)
    //##################################################

    public MySalesOrderContactCriteria joinToContacts()
    {
        return new MySalesOrderContactCriteria(joinTo(CONTACTS));
    }

    public MySalesOrderContactCriteria leftJoinToContacts()
    {
        return new MySalesOrderContactCriteria(leftJoinTo(CONTACTS));
    }

    //##################################################
    //# collection (Lines)
    //##################################################

    public MySalesOrderLineCriteria joinToLines()
    {
        return new MySalesOrderLineCriteria(joinTo(LINES));
    }

    public MySalesOrderLineCriteria leftJoinToLines()
    {
        return new MySalesOrderLineCriteria(leftJoinTo(LINES));
    }

    //##################################################
    //# collection (Shipments)
    //##################################################

    public MyShipmentCriteria joinToShipments()
    {
        return new MyShipmentCriteria(joinTo(SHIPMENTS));
    }

    public MyShipmentCriteria leftJoinToShipments()
    {
        return new MyShipmentCriteria(leftJoinTo(SHIPMENTS));
    }

    //##################################################
    //# junction
    //##################################################

    public MySalesOrderJunction addAnd()
    {
        return new MySalesOrderJunction(parent().addAnd());
    }

    public MySalesOrderJunction addOr()
    {
        return new MySalesOrderJunction(parent().addOr());
    }
}
