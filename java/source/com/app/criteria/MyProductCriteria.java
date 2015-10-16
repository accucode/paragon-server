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

public class MyProductCriteria
    extends MyAbstractCriteria<MyProduct>
    implements MyProductDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyProductCriteria(KmhCriteria parent)
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

    public KmhStringCondition whereStatusCode()
    {
        return new KmhStringCondition(context(), fullName(STATUS_CODE));
    }

    public void whereStatusIs(MyProductStatus e)
    {
        if ( e == null )
            whereStatusCode().isNull();
        else
            whereStatusCode().is(e.getCode());
    }

    public void whereStatusIsNot(MyProductStatus e)
    {
        if ( e == null )
            whereStatusCode().isNull();
        else
            whereStatusCode().isNot(e.getCode());
    }

    public void whereStatusIsDraft()
    {
        whereStatusIs(MyProductStatus.Draft);
    }

    public void whereStatusIsNotDraft()
    {
        whereStatusIsNot(MyProductStatus.Draft);
    }

    public void whereStatusIsDraft(boolean e)
    {
        if ( e )
            whereStatusIsDraft();
        else
            whereStatusIsNotDraft();
    }

    public void whereStatusIsPublished()
    {
        whereStatusIs(MyProductStatus.Published);
    }

    public void whereStatusIsNotPublished()
    {
        whereStatusIsNot(MyProductStatus.Published);
    }

    public void whereStatusIsPublished(boolean e)
    {
        if ( e )
            whereStatusIsPublished();
        else
            whereStatusIsNotPublished();
    }

    public void whereStatusIsCancelled()
    {
        whereStatusIs(MyProductStatus.Cancelled);
    }

    public void whereStatusIsNotCancelled()
    {
        whereStatusIsNot(MyProductStatus.Cancelled);
    }

    public void whereStatusIsCancelled(boolean e)
    {
        if ( e )
            whereStatusIsCancelled();
        else
            whereStatusIsNotCancelled();
    }

    public void whereStatusIsArchived()
    {
        whereStatusIs(MyProductStatus.Archived);
    }

    public void whereStatusIsNotArchived()
    {
        whereStatusIsNot(MyProductStatus.Archived);
    }

    public void whereStatusIsArchived(boolean e)
    {
        if ( e )
            whereStatusIsArchived();
        else
            whereStatusIsNotArchived();
    }

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), fullName(NAME));
    }

    public KmhStringCondition whereDescription()
    {
        return new KmhStringCondition(context(), fullName(DESCRIPTION));
    }

    public KmhPropertyCondition<KmMoney> whereListPrice()
    {
        return new KmhPropertyCondition<>(context(), fullName(LIST_PRICE));
    }

    public KmhBooleanCondition whereDiscountable()
    {
        return new KmhBooleanCondition(context(), fullName(DISCOUNTABLE));
    }

    public KmhBooleanCondition whereTaxable()
    {
        return new KmhBooleanCondition(context(), fullName(TAXABLE));
    }

    public KmhPropertyCondition<KmMoney> whereCost()
    {
        return new KmhPropertyCondition<>(context(), fullName(COST));
    }

    public KmhBooleanCondition whereRequiresShip()
    {
        return new KmhBooleanCondition(context(), fullName(REQUIRES_SHIP));
    }

    public KmhStringCondition whereShipInstruction()
    {
        return new KmhStringCondition(context(), fullName(SHIP_INSTRUCTION));
    }

    public KmhStringCondition wherePickInstruction()
    {
        return new KmhStringCondition(context(), fullName(PICK_INSTRUCTION));
    }

    public KmhIntegerCondition whereNetworkPortsProduced()
    {
        return new KmhIntegerCondition(context(), fullName(NETWORK_PORTS_PRODUCED));
    }

    public KmhIntegerCondition whereNetworkPortsConsumed()
    {
        return new KmhIntegerCondition(context(), fullName(NETWORK_PORTS_CONSUMED));
    }

    public KmhIntegerCondition wherePoePortsProduced()
    {
        return new KmhIntegerCondition(context(), fullName(POE_PORTS_PRODUCED));
    }

    public KmhIntegerCondition wherePoePortsConsumed()
    {
        return new KmhIntegerCondition(context(), fullName(POE_PORTS_CONSUMED));
    }

    public KmhIntegerCondition whereVendorPartNumber()
    {
        return new KmhIntegerCondition(context(), fullName(VENDOR_PART_NUMBER));
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

    public void sortOnName()
    {
        parent().sortAscending(NAME);
    }

    public void sortOnNameDescending()
    {
        parent().sortDescending(NAME);
    }

    public void sortOnName(boolean asc)
    {
        if ( asc )
            sortOnName();
        else
            sortOnNameDescending();
    }

    public void sortOnDescription()
    {
        parent().sortAscending(DESCRIPTION);
    }

    public void sortOnDescriptionDescending()
    {
        parent().sortDescending(DESCRIPTION);
    }

    public void sortOnDescription(boolean asc)
    {
        if ( asc )
            sortOnDescription();
        else
            sortOnDescriptionDescending();
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

    public void sortOnDiscountable()
    {
        parent().sortAscending(DISCOUNTABLE);
    }

    public void sortOnDiscountableDescending()
    {
        parent().sortDescending(DISCOUNTABLE);
    }

    public void sortOnDiscountable(boolean asc)
    {
        if ( asc )
            sortOnDiscountable();
        else
            sortOnDiscountableDescending();
    }

    public void sortOnTaxable()
    {
        parent().sortAscending(TAXABLE);
    }

    public void sortOnTaxableDescending()
    {
        parent().sortDescending(TAXABLE);
    }

    public void sortOnTaxable(boolean asc)
    {
        if ( asc )
            sortOnTaxable();
        else
            sortOnTaxableDescending();
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

    public void sortOnRequiresShip()
    {
        parent().sortAscending(REQUIRES_SHIP);
    }

    public void sortOnRequiresShipDescending()
    {
        parent().sortDescending(REQUIRES_SHIP);
    }

    public void sortOnRequiresShip(boolean asc)
    {
        if ( asc )
            sortOnRequiresShip();
        else
            sortOnRequiresShipDescending();
    }

    public void sortOnShipInstruction()
    {
        parent().sortAscending(SHIP_INSTRUCTION);
    }

    public void sortOnShipInstructionDescending()
    {
        parent().sortDescending(SHIP_INSTRUCTION);
    }

    public void sortOnShipInstruction(boolean asc)
    {
        if ( asc )
            sortOnShipInstruction();
        else
            sortOnShipInstructionDescending();
    }

    public void sortOnPickInstruction()
    {
        parent().sortAscending(PICK_INSTRUCTION);
    }

    public void sortOnPickInstructionDescending()
    {
        parent().sortDescending(PICK_INSTRUCTION);
    }

    public void sortOnPickInstruction(boolean asc)
    {
        if ( asc )
            sortOnPickInstruction();
        else
            sortOnPickInstructionDescending();
    }

    public void sortOnNetworkPortsProduced()
    {
        parent().sortAscending(NETWORK_PORTS_PRODUCED);
    }

    public void sortOnNetworkPortsProducedDescending()
    {
        parent().sortDescending(NETWORK_PORTS_PRODUCED);
    }

    public void sortOnNetworkPortsProduced(boolean asc)
    {
        if ( asc )
            sortOnNetworkPortsProduced();
        else
            sortOnNetworkPortsProducedDescending();
    }

    public void sortOnNetworkPortsConsumed()
    {
        parent().sortAscending(NETWORK_PORTS_CONSUMED);
    }

    public void sortOnNetworkPortsConsumedDescending()
    {
        parent().sortDescending(NETWORK_PORTS_CONSUMED);
    }

    public void sortOnNetworkPortsConsumed(boolean asc)
    {
        if ( asc )
            sortOnNetworkPortsConsumed();
        else
            sortOnNetworkPortsConsumedDescending();
    }

    public void sortOnPoePortsProduced()
    {
        parent().sortAscending(POE_PORTS_PRODUCED);
    }

    public void sortOnPoePortsProducedDescending()
    {
        parent().sortDescending(POE_PORTS_PRODUCED);
    }

    public void sortOnPoePortsProduced(boolean asc)
    {
        if ( asc )
            sortOnPoePortsProduced();
        else
            sortOnPoePortsProducedDescending();
    }

    public void sortOnPoePortsConsumed()
    {
        parent().sortAscending(POE_PORTS_CONSUMED);
    }

    public void sortOnPoePortsConsumedDescending()
    {
        parent().sortDescending(POE_PORTS_CONSUMED);
    }

    public void sortOnPoePortsConsumed(boolean asc)
    {
        if ( asc )
            sortOnPoePortsConsumed();
        else
            sortOnPoePortsConsumedDescending();
    }

    public void sortOnVendorPartNumber()
    {
        parent().sortAscending(VENDOR_PART_NUMBER);
    }

    public void sortOnVendorPartNumberDescending()
    {
        parent().sortDescending(VENDOR_PART_NUMBER);
    }

    public void sortOnVendorPartNumber(boolean asc)
    {
        if ( asc )
            sortOnVendorPartNumber();
        else
            sortOnVendorPartNumberDescending();
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
    //# projections (name)
    //##################################################

    public void selectName()
    {
        select(NAME);
    }

    public void selectDistinctName()
    {
        selectDistinct(NAME);
    }

    public void selectCountDistinctName()
    {
        selectCountDistinct(NAME);
    }

    public void selectMinimumName()
    {
        selectMinimum(NAME);
    }

    public void selectMaximumName()
    {
        selectMaximum(NAME);
    }

    public void selectAverageName()
    {
        selectAverage(NAME);
    }

    public void selectSumName()
    {
        selectSum(NAME);
    }

    public void groupByName()
    {
        groupBy(NAME);
    }

    //##################################################
    //# projections (description)
    //##################################################

    public void selectDescription()
    {
        select(DESCRIPTION);
    }

    public void selectDistinctDescription()
    {
        selectDistinct(DESCRIPTION);
    }

    public void selectCountDistinctDescription()
    {
        selectCountDistinct(DESCRIPTION);
    }

    public void selectMinimumDescription()
    {
        selectMinimum(DESCRIPTION);
    }

    public void selectMaximumDescription()
    {
        selectMaximum(DESCRIPTION);
    }

    public void selectAverageDescription()
    {
        selectAverage(DESCRIPTION);
    }

    public void selectSumDescription()
    {
        selectSum(DESCRIPTION);
    }

    public void groupByDescription()
    {
        groupBy(DESCRIPTION);
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
    //# projections (discountable)
    //##################################################

    public void selectDiscountable()
    {
        select(DISCOUNTABLE);
    }

    public void selectDistinctDiscountable()
    {
        selectDistinct(DISCOUNTABLE);
    }

    public void selectCountDistinctDiscountable()
    {
        selectCountDistinct(DISCOUNTABLE);
    }

    public void selectMinimumDiscountable()
    {
        selectMinimum(DISCOUNTABLE);
    }

    public void selectMaximumDiscountable()
    {
        selectMaximum(DISCOUNTABLE);
    }

    public void selectAverageDiscountable()
    {
        selectAverage(DISCOUNTABLE);
    }

    public void selectSumDiscountable()
    {
        selectSum(DISCOUNTABLE);
    }

    public void groupByDiscountable()
    {
        groupBy(DISCOUNTABLE);
    }

    //##################################################
    //# projections (taxable)
    //##################################################

    public void selectTaxable()
    {
        select(TAXABLE);
    }

    public void selectDistinctTaxable()
    {
        selectDistinct(TAXABLE);
    }

    public void selectCountDistinctTaxable()
    {
        selectCountDistinct(TAXABLE);
    }

    public void selectMinimumTaxable()
    {
        selectMinimum(TAXABLE);
    }

    public void selectMaximumTaxable()
    {
        selectMaximum(TAXABLE);
    }

    public void selectAverageTaxable()
    {
        selectAverage(TAXABLE);
    }

    public void selectSumTaxable()
    {
        selectSum(TAXABLE);
    }

    public void groupByTaxable()
    {
        groupBy(TAXABLE);
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
    //# projections (requiresShip)
    //##################################################

    public void selectRequiresShip()
    {
        select(REQUIRES_SHIP);
    }

    public void selectDistinctRequiresShip()
    {
        selectDistinct(REQUIRES_SHIP);
    }

    public void selectCountDistinctRequiresShip()
    {
        selectCountDistinct(REQUIRES_SHIP);
    }

    public void selectMinimumRequiresShip()
    {
        selectMinimum(REQUIRES_SHIP);
    }

    public void selectMaximumRequiresShip()
    {
        selectMaximum(REQUIRES_SHIP);
    }

    public void selectAverageRequiresShip()
    {
        selectAverage(REQUIRES_SHIP);
    }

    public void selectSumRequiresShip()
    {
        selectSum(REQUIRES_SHIP);
    }

    public void groupByRequiresShip()
    {
        groupBy(REQUIRES_SHIP);
    }

    //##################################################
    //# projections (shipInstruction)
    //##################################################

    public void selectShipInstruction()
    {
        select(SHIP_INSTRUCTION);
    }

    public void selectDistinctShipInstruction()
    {
        selectDistinct(SHIP_INSTRUCTION);
    }

    public void selectCountDistinctShipInstruction()
    {
        selectCountDistinct(SHIP_INSTRUCTION);
    }

    public void selectMinimumShipInstruction()
    {
        selectMinimum(SHIP_INSTRUCTION);
    }

    public void selectMaximumShipInstruction()
    {
        selectMaximum(SHIP_INSTRUCTION);
    }

    public void selectAverageShipInstruction()
    {
        selectAverage(SHIP_INSTRUCTION);
    }

    public void selectSumShipInstruction()
    {
        selectSum(SHIP_INSTRUCTION);
    }

    public void groupByShipInstruction()
    {
        groupBy(SHIP_INSTRUCTION);
    }

    //##################################################
    //# projections (pickInstruction)
    //##################################################

    public void selectPickInstruction()
    {
        select(PICK_INSTRUCTION);
    }

    public void selectDistinctPickInstruction()
    {
        selectDistinct(PICK_INSTRUCTION);
    }

    public void selectCountDistinctPickInstruction()
    {
        selectCountDistinct(PICK_INSTRUCTION);
    }

    public void selectMinimumPickInstruction()
    {
        selectMinimum(PICK_INSTRUCTION);
    }

    public void selectMaximumPickInstruction()
    {
        selectMaximum(PICK_INSTRUCTION);
    }

    public void selectAveragePickInstruction()
    {
        selectAverage(PICK_INSTRUCTION);
    }

    public void selectSumPickInstruction()
    {
        selectSum(PICK_INSTRUCTION);
    }

    public void groupByPickInstruction()
    {
        groupBy(PICK_INSTRUCTION);
    }

    //##################################################
    //# projections (networkPortsProduced)
    //##################################################

    public void selectNetworkPortsProduced()
    {
        select(NETWORK_PORTS_PRODUCED);
    }

    public void selectDistinctNetworkPortsProduced()
    {
        selectDistinct(NETWORK_PORTS_PRODUCED);
    }

    public void selectCountDistinctNetworkPortsProduced()
    {
        selectCountDistinct(NETWORK_PORTS_PRODUCED);
    }

    public void selectMinimumNetworkPortsProduced()
    {
        selectMinimum(NETWORK_PORTS_PRODUCED);
    }

    public void selectMaximumNetworkPortsProduced()
    {
        selectMaximum(NETWORK_PORTS_PRODUCED);
    }

    public void selectAverageNetworkPortsProduced()
    {
        selectAverage(NETWORK_PORTS_PRODUCED);
    }

    public void selectSumNetworkPortsProduced()
    {
        selectSum(NETWORK_PORTS_PRODUCED);
    }

    public void groupByNetworkPortsProduced()
    {
        groupBy(NETWORK_PORTS_PRODUCED);
    }

    //##################################################
    //# projections (networkPortsConsumed)
    //##################################################

    public void selectNetworkPortsConsumed()
    {
        select(NETWORK_PORTS_CONSUMED);
    }

    public void selectDistinctNetworkPortsConsumed()
    {
        selectDistinct(NETWORK_PORTS_CONSUMED);
    }

    public void selectCountDistinctNetworkPortsConsumed()
    {
        selectCountDistinct(NETWORK_PORTS_CONSUMED);
    }

    public void selectMinimumNetworkPortsConsumed()
    {
        selectMinimum(NETWORK_PORTS_CONSUMED);
    }

    public void selectMaximumNetworkPortsConsumed()
    {
        selectMaximum(NETWORK_PORTS_CONSUMED);
    }

    public void selectAverageNetworkPortsConsumed()
    {
        selectAverage(NETWORK_PORTS_CONSUMED);
    }

    public void selectSumNetworkPortsConsumed()
    {
        selectSum(NETWORK_PORTS_CONSUMED);
    }

    public void groupByNetworkPortsConsumed()
    {
        groupBy(NETWORK_PORTS_CONSUMED);
    }

    //##################################################
    //# projections (poePortsProduced)
    //##################################################

    public void selectPoePortsProduced()
    {
        select(POE_PORTS_PRODUCED);
    }

    public void selectDistinctPoePortsProduced()
    {
        selectDistinct(POE_PORTS_PRODUCED);
    }

    public void selectCountDistinctPoePortsProduced()
    {
        selectCountDistinct(POE_PORTS_PRODUCED);
    }

    public void selectMinimumPoePortsProduced()
    {
        selectMinimum(POE_PORTS_PRODUCED);
    }

    public void selectMaximumPoePortsProduced()
    {
        selectMaximum(POE_PORTS_PRODUCED);
    }

    public void selectAveragePoePortsProduced()
    {
        selectAverage(POE_PORTS_PRODUCED);
    }

    public void selectSumPoePortsProduced()
    {
        selectSum(POE_PORTS_PRODUCED);
    }

    public void groupByPoePortsProduced()
    {
        groupBy(POE_PORTS_PRODUCED);
    }

    //##################################################
    //# projections (poePortsConsumed)
    //##################################################

    public void selectPoePortsConsumed()
    {
        select(POE_PORTS_CONSUMED);
    }

    public void selectDistinctPoePortsConsumed()
    {
        selectDistinct(POE_PORTS_CONSUMED);
    }

    public void selectCountDistinctPoePortsConsumed()
    {
        selectCountDistinct(POE_PORTS_CONSUMED);
    }

    public void selectMinimumPoePortsConsumed()
    {
        selectMinimum(POE_PORTS_CONSUMED);
    }

    public void selectMaximumPoePortsConsumed()
    {
        selectMaximum(POE_PORTS_CONSUMED);
    }

    public void selectAveragePoePortsConsumed()
    {
        selectAverage(POE_PORTS_CONSUMED);
    }

    public void selectSumPoePortsConsumed()
    {
        selectSum(POE_PORTS_CONSUMED);
    }

    public void groupByPoePortsConsumed()
    {
        groupBy(POE_PORTS_CONSUMED);
    }

    //##################################################
    //# projections (vendorPartNumber)
    //##################################################

    public void selectVendorPartNumber()
    {
        select(VENDOR_PART_NUMBER);
    }

    public void selectDistinctVendorPartNumber()
    {
        selectDistinct(VENDOR_PART_NUMBER);
    }

    public void selectCountDistinctVendorPartNumber()
    {
        selectCountDistinct(VENDOR_PART_NUMBER);
    }

    public void selectMinimumVendorPartNumber()
    {
        selectMinimum(VENDOR_PART_NUMBER);
    }

    public void selectMaximumVendorPartNumber()
    {
        selectMaximum(VENDOR_PART_NUMBER);
    }

    public void selectAverageVendorPartNumber()
    {
        selectAverage(VENDOR_PART_NUMBER);
    }

    public void selectSumVendorPartNumber()
    {
        selectSum(VENDOR_PART_NUMBER);
    }

    public void groupByVendorPartNumber()
    {
        groupBy(VENDOR_PART_NUMBER);
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
    //# association (Master)
    //##################################################

    public void selectMasterUid()
    {
        select(MASTER_UID);
    }

    public void selectMinimumMasterUid()
    {
        selectMinimum(MASTER_UID);
    }

    public void selectMaximumMasterUid()
    {
        selectMaximum(MASTER_UID);
    }

    public void groupByMasterUid()
    {
        groupBy(MASTER);
    }

    public MyMasterProductCriteria joinToMaster()
    {
        return new MyMasterProductCriteria(joinTo(MASTER));
    }

    public MyMasterProductCriteria leftJoinToMaster()
    {
        return new MyMasterProductCriteria(leftJoinTo(MASTER));
    }

    public KmhStringCondition whereMasterUid()
    {
        return new KmhStringCondition(parent(), fullName(MASTER_UID));
    }

    public void whereMasterIs(MyMasterProduct e)
    {
        if ( e == null )
            whereMasterUid().isNull();
        else
            whereMasterUid().is(e.getUid());
    }

    //##################################################
    //# association (Category)
    //##################################################

    public void selectCategoryUid()
    {
        select(CATEGORY_UID);
    }

    public void selectMinimumCategoryUid()
    {
        selectMinimum(CATEGORY_UID);
    }

    public void selectMaximumCategoryUid()
    {
        selectMaximum(CATEGORY_UID);
    }

    public void groupByCategoryUid()
    {
        groupBy(CATEGORY);
    }

    public MyProductCategoryCriteria joinToCategory()
    {
        return new MyProductCategoryCriteria(joinTo(CATEGORY));
    }

    public MyProductCategoryCriteria leftJoinToCategory()
    {
        return new MyProductCategoryCriteria(leftJoinTo(CATEGORY));
    }

    public KmhStringCondition whereCategoryUid()
    {
        return new KmhStringCondition(parent(), fullName(CATEGORY_UID));
    }

    public void whereCategoryIs(MyProductCategory e)
    {
        if ( e == null )
            whereCategoryUid().isNull();
        else
            whereCategoryUid().is(e.getUid());
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
    //# association (Vendor)
    //##################################################

    public void selectVendorUid()
    {
        select(VENDOR_UID);
    }

    public void selectMinimumVendorUid()
    {
        selectMinimum(VENDOR_UID);
    }

    public void selectMaximumVendorUid()
    {
        selectMaximum(VENDOR_UID);
    }

    public void groupByVendorUid()
    {
        groupBy(VENDOR);
    }

    public MyVendorCriteria joinToVendor()
    {
        return new MyVendorCriteria(joinTo(VENDOR));
    }

    public MyVendorCriteria leftJoinToVendor()
    {
        return new MyVendorCriteria(leftJoinTo(VENDOR));
    }

    public KmhStringCondition whereVendorUid()
    {
        return new KmhStringCondition(parent(), fullName(VENDOR_UID));
    }

    public void whereVendorIs(MyVendor e)
    {
        if ( e == null )
            whereVendorUid().isNull();
        else
            whereVendorUid().is(e.getUid());
    }

    //##################################################
    //# junction
    //##################################################

    public MyProductJunction addAnd()
    {
        return new MyProductJunction(parent().addAnd());
    }

    public MyProductJunction addOr()
    {
        return new MyProductJunction(parent().addOr());
    }
}
