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

public class MyCustomerCriteria
    extends MyAbstractCriteria<MyCustomer>
    implements MyCustomerDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyCustomerCriteria(KmhCriteria parent)
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

    public KmhPropertyCondition<Double> whereDiscountRate()
    {
        return new KmhPropertyCondition<>(context(), fullName(DISCOUNT_RATE));
    }

    public KmhStringCondition whereAddressStreet1()
    {
        return new KmhStringCondition(context(), fullName(ADDRESS_STREET_1));
    }

    public KmhStringCondition whereAddressStreet2()
    {
        return new KmhStringCondition(context(), fullName(ADDRESS_STREET_2));
    }

    public KmhStringCondition whereAddressCity()
    {
        return new KmhStringCondition(context(), fullName(ADDRESS_CITY));
    }

    public KmhStringCondition whereAddressRegion()
    {
        return new KmhStringCondition(context(), fullName(ADDRESS_REGION));
    }

    public KmhStringCondition whereAddressPostalCode()
    {
        return new KmhStringCondition(context(), fullName(ADDRESS_POSTAL_CODE));
    }

    public KmhStringCondition whereAddressCountry()
    {
        return new KmhStringCondition(context(), fullName(ADDRESS_COUNTRY));
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

    public void sortOnAddressStreet1()
    {
        parent().sortAscending(ADDRESS_STREET_1);
    }

    public void sortOnAddressStreet1Descending()
    {
        parent().sortDescending(ADDRESS_STREET_1);
    }

    public void sortOnAddressStreet1(boolean asc)
    {
        if ( asc )
            sortOnAddressStreet1();
        else
            sortOnAddressStreet1Descending();
    }

    public void sortOnAddressStreet2()
    {
        parent().sortAscending(ADDRESS_STREET_2);
    }

    public void sortOnAddressStreet2Descending()
    {
        parent().sortDescending(ADDRESS_STREET_2);
    }

    public void sortOnAddressStreet2(boolean asc)
    {
        if ( asc )
            sortOnAddressStreet2();
        else
            sortOnAddressStreet2Descending();
    }

    public void sortOnAddressCity()
    {
        parent().sortAscending(ADDRESS_CITY);
    }

    public void sortOnAddressCityDescending()
    {
        parent().sortDescending(ADDRESS_CITY);
    }

    public void sortOnAddressCity(boolean asc)
    {
        if ( asc )
            sortOnAddressCity();
        else
            sortOnAddressCityDescending();
    }

    public void sortOnAddressRegion()
    {
        parent().sortAscending(ADDRESS_REGION);
    }

    public void sortOnAddressRegionDescending()
    {
        parent().sortDescending(ADDRESS_REGION);
    }

    public void sortOnAddressRegion(boolean asc)
    {
        if ( asc )
            sortOnAddressRegion();
        else
            sortOnAddressRegionDescending();
    }

    public void sortOnAddressPostalCode()
    {
        parent().sortAscending(ADDRESS_POSTAL_CODE);
    }

    public void sortOnAddressPostalCodeDescending()
    {
        parent().sortDescending(ADDRESS_POSTAL_CODE);
    }

    public void sortOnAddressPostalCode(boolean asc)
    {
        if ( asc )
            sortOnAddressPostalCode();
        else
            sortOnAddressPostalCodeDescending();
    }

    public void sortOnAddressCountry()
    {
        parent().sortAscending(ADDRESS_COUNTRY);
    }

    public void sortOnAddressCountryDescending()
    {
        parent().sortDescending(ADDRESS_COUNTRY);
    }

    public void sortOnAddressCountry(boolean asc)
    {
        if ( asc )
            sortOnAddressCountry();
        else
            sortOnAddressCountryDescending();
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
    //# projections (addressStreet1)
    //##################################################

    public void selectAddressStreet1()
    {
        select(ADDRESS_STREET_1);
    }

    public void selectDistinctAddressStreet1()
    {
        selectDistinct(ADDRESS_STREET_1);
    }

    public void selectCountDistinctAddressStreet1()
    {
        selectCountDistinct(ADDRESS_STREET_1);
    }

    public void selectMinimumAddressStreet1()
    {
        selectMinimum(ADDRESS_STREET_1);
    }

    public void selectMaximumAddressStreet1()
    {
        selectMaximum(ADDRESS_STREET_1);
    }

    public void selectAverageAddressStreet1()
    {
        selectAverage(ADDRESS_STREET_1);
    }

    public void selectSumAddressStreet1()
    {
        selectSum(ADDRESS_STREET_1);
    }

    public void groupByAddressStreet1()
    {
        groupBy(ADDRESS_STREET_1);
    }

    //##################################################
    //# projections (addressStreet2)
    //##################################################

    public void selectAddressStreet2()
    {
        select(ADDRESS_STREET_2);
    }

    public void selectDistinctAddressStreet2()
    {
        selectDistinct(ADDRESS_STREET_2);
    }

    public void selectCountDistinctAddressStreet2()
    {
        selectCountDistinct(ADDRESS_STREET_2);
    }

    public void selectMinimumAddressStreet2()
    {
        selectMinimum(ADDRESS_STREET_2);
    }

    public void selectMaximumAddressStreet2()
    {
        selectMaximum(ADDRESS_STREET_2);
    }

    public void selectAverageAddressStreet2()
    {
        selectAverage(ADDRESS_STREET_2);
    }

    public void selectSumAddressStreet2()
    {
        selectSum(ADDRESS_STREET_2);
    }

    public void groupByAddressStreet2()
    {
        groupBy(ADDRESS_STREET_2);
    }

    //##################################################
    //# projections (addressCity)
    //##################################################

    public void selectAddressCity()
    {
        select(ADDRESS_CITY);
    }

    public void selectDistinctAddressCity()
    {
        selectDistinct(ADDRESS_CITY);
    }

    public void selectCountDistinctAddressCity()
    {
        selectCountDistinct(ADDRESS_CITY);
    }

    public void selectMinimumAddressCity()
    {
        selectMinimum(ADDRESS_CITY);
    }

    public void selectMaximumAddressCity()
    {
        selectMaximum(ADDRESS_CITY);
    }

    public void selectAverageAddressCity()
    {
        selectAverage(ADDRESS_CITY);
    }

    public void selectSumAddressCity()
    {
        selectSum(ADDRESS_CITY);
    }

    public void groupByAddressCity()
    {
        groupBy(ADDRESS_CITY);
    }

    //##################################################
    //# projections (addressRegion)
    //##################################################

    public void selectAddressRegion()
    {
        select(ADDRESS_REGION);
    }

    public void selectDistinctAddressRegion()
    {
        selectDistinct(ADDRESS_REGION);
    }

    public void selectCountDistinctAddressRegion()
    {
        selectCountDistinct(ADDRESS_REGION);
    }

    public void selectMinimumAddressRegion()
    {
        selectMinimum(ADDRESS_REGION);
    }

    public void selectMaximumAddressRegion()
    {
        selectMaximum(ADDRESS_REGION);
    }

    public void selectAverageAddressRegion()
    {
        selectAverage(ADDRESS_REGION);
    }

    public void selectSumAddressRegion()
    {
        selectSum(ADDRESS_REGION);
    }

    public void groupByAddressRegion()
    {
        groupBy(ADDRESS_REGION);
    }

    //##################################################
    //# projections (addressPostalCode)
    //##################################################

    public void selectAddressPostalCode()
    {
        select(ADDRESS_POSTAL_CODE);
    }

    public void selectDistinctAddressPostalCode()
    {
        selectDistinct(ADDRESS_POSTAL_CODE);
    }

    public void selectCountDistinctAddressPostalCode()
    {
        selectCountDistinct(ADDRESS_POSTAL_CODE);
    }

    public void selectMinimumAddressPostalCode()
    {
        selectMinimum(ADDRESS_POSTAL_CODE);
    }

    public void selectMaximumAddressPostalCode()
    {
        selectMaximum(ADDRESS_POSTAL_CODE);
    }

    public void selectAverageAddressPostalCode()
    {
        selectAverage(ADDRESS_POSTAL_CODE);
    }

    public void selectSumAddressPostalCode()
    {
        selectSum(ADDRESS_POSTAL_CODE);
    }

    public void groupByAddressPostalCode()
    {
        groupBy(ADDRESS_POSTAL_CODE);
    }

    //##################################################
    //# projections (addressCountry)
    //##################################################

    public void selectAddressCountry()
    {
        select(ADDRESS_COUNTRY);
    }

    public void selectDistinctAddressCountry()
    {
        selectDistinct(ADDRESS_COUNTRY);
    }

    public void selectCountDistinctAddressCountry()
    {
        selectCountDistinct(ADDRESS_COUNTRY);
    }

    public void selectMinimumAddressCountry()
    {
        selectMinimum(ADDRESS_COUNTRY);
    }

    public void selectMaximumAddressCountry()
    {
        selectMaximum(ADDRESS_COUNTRY);
    }

    public void selectAverageAddressCountry()
    {
        selectAverage(ADDRESS_COUNTRY);
    }

    public void selectSumAddressCountry()
    {
        selectSum(ADDRESS_COUNTRY);
    }

    public void groupByAddressCountry()
    {
        groupBy(ADDRESS_COUNTRY);
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
    //# association (Tier)
    //##################################################

    public void selectTierUid()
    {
        select(TIER_UID);
    }

    public void selectMinimumTierUid()
    {
        selectMinimum(TIER_UID);
    }

    public void selectMaximumTierUid()
    {
        selectMaximum(TIER_UID);
    }

    public void groupByTierUid()
    {
        groupBy(TIER);
    }

    public MyCustomerTierCriteria joinToTier()
    {
        return new MyCustomerTierCriteria(joinTo(TIER));
    }

    public MyCustomerTierCriteria leftJoinToTier()
    {
        return new MyCustomerTierCriteria(leftJoinTo(TIER));
    }

    public KmhStringCondition whereTierUid()
    {
        return new KmhStringCondition(parent(), fullName(TIER_UID));
    }

    public void whereTierIs(MyCustomerTier e)
    {
        if ( e == null )
            whereTierUid().isNull();
        else
            whereTierUid().is(e.getUid());
    }

    //##################################################
    //# collection (Contacts)
    //##################################################

    public MyCustomerContactCriteria joinToContacts()
    {
        return new MyCustomerContactCriteria(joinTo(CONTACTS));
    }

    public MyCustomerContactCriteria leftJoinToContacts()
    {
        return new MyCustomerContactCriteria(leftJoinTo(CONTACTS));
    }

    //##################################################
    //# collection (EndUsers)
    //##################################################

    public MyEndUserCriteria joinToEndUsers()
    {
        return new MyEndUserCriteria(joinTo(END_USERS));
    }

    public MyEndUserCriteria leftJoinToEndUsers()
    {
        return new MyEndUserCriteria(leftJoinTo(END_USERS));
    }

    //##################################################
    //# collection (Sites)
    //##################################################

    public MyCustomerSiteCriteria joinToSites()
    {
        return new MyCustomerSiteCriteria(joinTo(SITES));
    }

    public MyCustomerSiteCriteria leftJoinToSites()
    {
        return new MyCustomerSiteCriteria(leftJoinTo(SITES));
    }

    //##################################################
    //# junction
    //##################################################

    public MyCustomerJunction addAnd()
    {
        return new MyCustomerJunction(parent().addAnd());
    }

    public MyCustomerJunction addOr()
    {
        return new MyCustomerJunction(parent().addOr());
    }
}
