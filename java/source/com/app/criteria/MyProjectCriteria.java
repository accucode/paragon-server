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

public class MyProjectCriteria
    extends MyAbstractCriteria<MyProject>
    implements MyProjectDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyProjectCriteria(KmhCriteria parent)
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

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), fullName(NAME));
    }

    public KmhStringCondition whereOrderNumberPrefix()
    {
        return new KmhStringCondition(context(), fullName(ORDER_NUMBER_PREFIX));
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

    public void sortOnOrderNumberPrefix()
    {
        parent().sortAscending(ORDER_NUMBER_PREFIX);
    }

    public void sortOnOrderNumberPrefixDescending()
    {
        parent().sortDescending(ORDER_NUMBER_PREFIX);
    }

    public void sortOnOrderNumberPrefix(boolean asc)
    {
        if ( asc )
            sortOnOrderNumberPrefix();
        else
            sortOnOrderNumberPrefixDescending();
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
    //# projections (orderNumberPrefix)
    //##################################################

    public void selectOrderNumberPrefix()
    {
        select(ORDER_NUMBER_PREFIX);
    }

    public void selectDistinctOrderNumberPrefix()
    {
        selectDistinct(ORDER_NUMBER_PREFIX);
    }

    public void selectCountDistinctOrderNumberPrefix()
    {
        selectCountDistinct(ORDER_NUMBER_PREFIX);
    }

    public void selectMinimumOrderNumberPrefix()
    {
        selectMinimum(ORDER_NUMBER_PREFIX);
    }

    public void selectMaximumOrderNumberPrefix()
    {
        selectMaximum(ORDER_NUMBER_PREFIX);
    }

    public void selectAverageOrderNumberPrefix()
    {
        selectAverage(ORDER_NUMBER_PREFIX);
    }

    public void selectSumOrderNumberPrefix()
    {
        selectSum(ORDER_NUMBER_PREFIX);
    }

    public void groupByOrderNumberPrefix()
    {
        groupBy(ORDER_NUMBER_PREFIX);
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
    //# collection (Members)
    //##################################################

    public MyMemberCriteria joinToMembers()
    {
        return new MyMemberCriteria(joinTo(MEMBERS));
    }

    public MyMemberCriteria leftJoinToMembers()
    {
        return new MyMemberCriteria(leftJoinTo(MEMBERS));
    }

    //##################################################
    //# collection (Depots)
    //##################################################

    public MyDepotCriteria joinToDepots()
    {
        return new MyDepotCriteria(joinTo(DEPOTS));
    }

    public MyDepotCriteria leftJoinToDepots()
    {
        return new MyDepotCriteria(leftJoinTo(DEPOTS));
    }

    //##################################################
    //# collection (PowerTypes)
    //##################################################

    public MyPowerTypeCriteria joinToPowerTypes()
    {
        return new MyPowerTypeCriteria(joinTo(POWER_TYPES));
    }

    public MyPowerTypeCriteria leftJoinToPowerTypes()
    {
        return new MyPowerTypeCriteria(leftJoinTo(POWER_TYPES));
    }

    //##################################################
    //# collection (Regions)
    //##################################################

    public MyRegionCriteria joinToRegions()
    {
        return new MyRegionCriteria(joinTo(REGIONS));
    }

    public MyRegionCriteria leftJoinToRegions()
    {
        return new MyRegionCriteria(leftJoinTo(REGIONS));
    }

    //##################################################
    //# collection (Vendors)
    //##################################################

    public MyVendorCriteria joinToVendors()
    {
        return new MyVendorCriteria(joinTo(VENDORS));
    }

    public MyVendorCriteria leftJoinToVendors()
    {
        return new MyVendorCriteria(leftJoinTo(VENDORS));
    }

    //##################################################
    //# collection (Skills)
    //##################################################

    public MySkillCriteria joinToSkills()
    {
        return new MySkillCriteria(joinTo(SKILLS));
    }

    public MySkillCriteria leftJoinToSkills()
    {
        return new MySkillCriteria(leftJoinTo(SKILLS));
    }

    //##################################################
    //# collection (VisitTypes)
    //##################################################

    public MyVisitTypeCriteria joinToVisitTypes()
    {
        return new MyVisitTypeCriteria(joinTo(VISIT_TYPES));
    }

    public MyVisitTypeCriteria leftJoinToVisitTypes()
    {
        return new MyVisitTypeCriteria(leftJoinTo(VISIT_TYPES));
    }

    //##################################################
    //# collection (AttentionGroups)
    //##################################################

    public MyAttentionGroupCriteria joinToAttentionGroups()
    {
        return new MyAttentionGroupCriteria(joinTo(ATTENTION_GROUPS));
    }

    public MyAttentionGroupCriteria leftJoinToAttentionGroups()
    {
        return new MyAttentionGroupCriteria(leftJoinTo(ATTENTION_GROUPS));
    }

    //##################################################
    //# collection (MasterProducts)
    //##################################################

    public MyMasterProductCriteria joinToMasterProducts()
    {
        return new MyMasterProductCriteria(joinTo(MASTER_PRODUCTS));
    }

    public MyMasterProductCriteria leftJoinToMasterProducts()
    {
        return new MyMasterProductCriteria(leftJoinTo(MASTER_PRODUCTS));
    }

    //##################################################
    //# collection (ProductCategories)
    //##################################################

    public MyProductCategoryCriteria joinToProductCategories()
    {
        return new MyProductCategoryCriteria(joinTo(PRODUCT_CATEGORIES));
    }

    public MyProductCategoryCriteria leftJoinToProductCategories()
    {
        return new MyProductCategoryCriteria(leftJoinTo(PRODUCT_CATEGORIES));
    }

    //##################################################
    //# collection (ShipCarriers)
    //##################################################

    public MyShipCarrierCriteria joinToShipCarriers()
    {
        return new MyShipCarrierCriteria(joinTo(SHIP_CARRIERS));
    }

    public MyShipCarrierCriteria leftJoinToShipCarriers()
    {
        return new MyShipCarrierCriteria(leftJoinTo(SHIP_CARRIERS));
    }

    //##################################################
    //# collection (Customers)
    //##################################################

    public MyCustomerCriteria joinToCustomers()
    {
        return new MyCustomerCriteria(joinTo(CUSTOMERS));
    }

    public MyCustomerCriteria leftJoinToCustomers()
    {
        return new MyCustomerCriteria(leftJoinTo(CUSTOMERS));
    }

    //##################################################
    //# collection (CustomerTiers)
    //##################################################

    public MyCustomerTierCriteria joinToCustomerTiers()
    {
        return new MyCustomerTierCriteria(joinTo(CUSTOMER_TIERS));
    }

    public MyCustomerTierCriteria leftJoinToCustomerTiers()
    {
        return new MyCustomerTierCriteria(leftJoinTo(CUSTOMER_TIERS));
    }

    //##################################################
    //# collection (ShipAccounts)
    //##################################################

    public MyShipAccountCriteria joinToShipAccounts()
    {
        return new MyShipAccountCriteria(joinTo(SHIP_ACCOUNTS));
    }

    public MyShipAccountCriteria leftJoinToShipAccounts()
    {
        return new MyShipAccountCriteria(leftJoinTo(SHIP_ACCOUNTS));
    }

    //##################################################
    //# junction
    //##################################################

    public MyProjectJunction addAnd()
    {
        return new MyProjectJunction(parent().addAnd());
    }

    public MyProjectJunction addOr()
    {
        return new MyProjectJunction(parent().addOr());
    }
}
