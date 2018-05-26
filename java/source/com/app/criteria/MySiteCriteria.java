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

public class MySiteCriteria
    extends MyAbstractCriteria<MySite>
    implements MySiteDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MySiteCriteria(KmhCriteria parent)
    {
        super(parent);
    }

    //##################################################
    //# primary key
    //##################################################

    public void whereUidIs(MySite e)
    {
        whereUid().is(e.getUid());
    }

    public void whereUidIsNot(MySite e)
    {
        whereUid().isNot(e.getUid());
    }

    //##################################################
    //# properties
    //##################################################

    public KmhStringCondition whereAddressAttention()
    {
        return new KmhStringCondition(context(), alias(), ADDRESS_ATTENTION);
    }

    public KmhStringCondition whereAddressCity()
    {
        return new KmhStringCondition(context(), alias(), ADDRESS_CITY);
    }

    public KmhStringCondition whereAddressCountry()
    {
        return new KmhStringCondition(context(), alias(), ADDRESS_COUNTRY);
    }

    public KmhStringCondition whereAddressPhone()
    {
        return new KmhStringCondition(context(), alias(), ADDRESS_PHONE);
    }

    public KmhStringCondition whereAddressPostalCode()
    {
        return new KmhStringCondition(context(), alias(), ADDRESS_POSTAL_CODE);
    }

    public KmhStringCondition whereAddressRegion()
    {
        return new KmhStringCondition(context(), alias(), ADDRESS_REGION);
    }

    public KmhStringCondition whereAddressStreet1()
    {
        return new KmhStringCondition(context(), alias(), ADDRESS_STREET_1);
    }

    public KmhStringCondition whereAddressStreet2()
    {
        return new KmhStringCondition(context(), alias(), ADDRESS_STREET_2);
    }

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), CREATED_UTC_TS);
    }

    public KmhBooleanCondition whereEnabled()
    {
        return new KmhBooleanCondition(context(), alias(), ENABLED);
    }

    public KmhStringCondition whereFullName()
    {
        return new KmhStringCondition(context(), alias(), FULL_NAME);
    }

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), alias(), NAME);
    }

    public KmhStringCondition whereNumber()
    {
        return new KmhStringCondition(context(), alias(), NUMBER);
    }

    public KmhStringCondition whereTimeZoneCode()
    {
        return new KmhStringCondition(context(), alias(), TIME_ZONE_CODE);
    }

    public KmhStringCondition whereUid()
    {
        return new KmhStringCondition(context(), alias(), UID);
    }

    public KmhTimestampCondition whereUpdatedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), UPDATED_UTC_TS);
    }

    public KmhIntegerCondition whereLockVersion()
    {
        return new KmhIntegerCondition(context(), alias(), LOCK_VERSION);
    }

    //##################################################
    //# sorts
    //##################################################

    public void sortOnAddressAttention()
    {
        parent().sortAscending(ADDRESS_ATTENTION);
    }

    public void sortOnAddressAttentionDescending()
    {
        parent().sortDescending(ADDRESS_ATTENTION);
    }

    public void sortOnAddressAttention(boolean asc)
    {
        if ( asc )
            sortOnAddressAttention();
        else
            sortOnAddressAttentionDescending();
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

    public void sortOnAddressPhone()
    {
        parent().sortAscending(ADDRESS_PHONE);
    }

    public void sortOnAddressPhoneDescending()
    {
        parent().sortDescending(ADDRESS_PHONE);
    }

    public void sortOnAddressPhone(boolean asc)
    {
        if ( asc )
            sortOnAddressPhone();
        else
            sortOnAddressPhoneDescending();
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

    public void sortOnCreatedUtcTs()
    {
        parent().sortAscending(CREATED_UTC_TS);
    }

    public void sortOnCreatedUtcTsDescending()
    {
        parent().sortDescending(CREATED_UTC_TS);
    }

    public void sortOnCreatedUtcTs(boolean asc)
    {
        if ( asc )
            sortOnCreatedUtcTs();
        else
            sortOnCreatedUtcTsDescending();
    }

    public void sortOnEnabled()
    {
        parent().sortAscending(ENABLED);
    }

    public void sortOnEnabledDescending()
    {
        parent().sortDescending(ENABLED);
    }

    public void sortOnEnabled(boolean asc)
    {
        if ( asc )
            sortOnEnabled();
        else
            sortOnEnabledDescending();
    }

    public void sortOnFullName()
    {
        parent().sortAscending(FULL_NAME);
    }

    public void sortOnFullNameDescending()
    {
        parent().sortDescending(FULL_NAME);
    }

    public void sortOnFullName(boolean asc)
    {
        if ( asc )
            sortOnFullName();
        else
            sortOnFullNameDescending();
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

    public void sortOnTimeZoneCode()
    {
        parent().sortAscending(TIME_ZONE_CODE);
    }

    public void sortOnTimeZoneCodeDescending()
    {
        parent().sortDescending(TIME_ZONE_CODE);
    }

    public void sortOnTimeZoneCode(boolean asc)
    {
        if ( asc )
            sortOnTimeZoneCode();
        else
            sortOnTimeZoneCodeDescending();
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

    public void sortOnUpdatedUtcTs()
    {
        parent().sortAscending(UPDATED_UTC_TS);
    }

    public void sortOnUpdatedUtcTsDescending()
    {
        parent().sortDescending(UPDATED_UTC_TS);
    }

    public void sortOnUpdatedUtcTs(boolean asc)
    {
        if ( asc )
            sortOnUpdatedUtcTs();
        else
            sortOnUpdatedUtcTsDescending();
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
    //# projections (addressAttention)
    //##################################################

    public void selectAddressAttention()
    {
        select(ADDRESS_ATTENTION);
    }

    public void selectDistinctAddressAttention()
    {
        selectDistinct(ADDRESS_ATTENTION);
    }

    public void selectCountDistinctAddressAttention()
    {
        selectCountDistinct(ADDRESS_ATTENTION);
    }

    public void selectMinimumAddressAttention()
    {
        selectMinimum(ADDRESS_ATTENTION);
    }

    public void selectMaximumAddressAttention()
    {
        selectMaximum(ADDRESS_ATTENTION);
    }

    public void selectAverageAddressAttention()
    {
        selectAverage(ADDRESS_ATTENTION);
    }

    public void selectSumAddressAttention()
    {
        selectSum(ADDRESS_ATTENTION);
    }

    public void groupByAddressAttention()
    {
        groupBy(ADDRESS_ATTENTION);
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
    //# projections (addressPhone)
    //##################################################

    public void selectAddressPhone()
    {
        select(ADDRESS_PHONE);
    }

    public void selectDistinctAddressPhone()
    {
        selectDistinct(ADDRESS_PHONE);
    }

    public void selectCountDistinctAddressPhone()
    {
        selectCountDistinct(ADDRESS_PHONE);
    }

    public void selectMinimumAddressPhone()
    {
        selectMinimum(ADDRESS_PHONE);
    }

    public void selectMaximumAddressPhone()
    {
        selectMaximum(ADDRESS_PHONE);
    }

    public void selectAverageAddressPhone()
    {
        selectAverage(ADDRESS_PHONE);
    }

    public void selectSumAddressPhone()
    {
        selectSum(ADDRESS_PHONE);
    }

    public void groupByAddressPhone()
    {
        groupBy(ADDRESS_PHONE);
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
    //# projections (createdUtcTs)
    //##################################################

    public void selectCreatedUtcTs()
    {
        select(CREATED_UTC_TS);
    }

    public void selectDistinctCreatedUtcTs()
    {
        selectDistinct(CREATED_UTC_TS);
    }

    public void selectCountDistinctCreatedUtcTs()
    {
        selectCountDistinct(CREATED_UTC_TS);
    }

    public void selectMinimumCreatedUtcTs()
    {
        selectMinimum(CREATED_UTC_TS);
    }

    public void selectMaximumCreatedUtcTs()
    {
        selectMaximum(CREATED_UTC_TS);
    }

    public void selectAverageCreatedUtcTs()
    {
        selectAverage(CREATED_UTC_TS);
    }

    public void selectSumCreatedUtcTs()
    {
        selectSum(CREATED_UTC_TS);
    }

    public void groupByCreatedUtcTs()
    {
        groupBy(CREATED_UTC_TS);
    }

    //##################################################
    //# projections (enabled)
    //##################################################

    public void selectEnabled()
    {
        select(ENABLED);
    }

    public void selectDistinctEnabled()
    {
        selectDistinct(ENABLED);
    }

    public void selectCountDistinctEnabled()
    {
        selectCountDistinct(ENABLED);
    }

    public void selectMinimumEnabled()
    {
        selectMinimum(ENABLED);
    }

    public void selectMaximumEnabled()
    {
        selectMaximum(ENABLED);
    }

    public void selectAverageEnabled()
    {
        selectAverage(ENABLED);
    }

    public void selectSumEnabled()
    {
        selectSum(ENABLED);
    }

    public void groupByEnabled()
    {
        groupBy(ENABLED);
    }

    //##################################################
    //# projections (fullName)
    //##################################################

    public void selectFullName()
    {
        select(FULL_NAME);
    }

    public void selectDistinctFullName()
    {
        selectDistinct(FULL_NAME);
    }

    public void selectCountDistinctFullName()
    {
        selectCountDistinct(FULL_NAME);
    }

    public void selectMinimumFullName()
    {
        selectMinimum(FULL_NAME);
    }

    public void selectMaximumFullName()
    {
        selectMaximum(FULL_NAME);
    }

    public void selectAverageFullName()
    {
        selectAverage(FULL_NAME);
    }

    public void selectSumFullName()
    {
        selectSum(FULL_NAME);
    }

    public void groupByFullName()
    {
        groupBy(FULL_NAME);
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
    //# projections (timeZoneCode)
    //##################################################

    public void selectTimeZoneCode()
    {
        select(TIME_ZONE_CODE);
    }

    public void selectDistinctTimeZoneCode()
    {
        selectDistinct(TIME_ZONE_CODE);
    }

    public void selectCountDistinctTimeZoneCode()
    {
        selectCountDistinct(TIME_ZONE_CODE);
    }

    public void selectMinimumTimeZoneCode()
    {
        selectMinimum(TIME_ZONE_CODE);
    }

    public void selectMaximumTimeZoneCode()
    {
        selectMaximum(TIME_ZONE_CODE);
    }

    public void selectAverageTimeZoneCode()
    {
        selectAverage(TIME_ZONE_CODE);
    }

    public void selectSumTimeZoneCode()
    {
        selectSum(TIME_ZONE_CODE);
    }

    public void groupByTimeZoneCode()
    {
        groupBy(TIME_ZONE_CODE);
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
    //# projections (updatedUtcTs)
    //##################################################

    public void selectUpdatedUtcTs()
    {
        select(UPDATED_UTC_TS);
    }

    public void selectDistinctUpdatedUtcTs()
    {
        selectDistinct(UPDATED_UTC_TS);
    }

    public void selectCountDistinctUpdatedUtcTs()
    {
        selectCountDistinct(UPDATED_UTC_TS);
    }

    public void selectMinimumUpdatedUtcTs()
    {
        selectMinimum(UPDATED_UTC_TS);
    }

    public void selectMaximumUpdatedUtcTs()
    {
        selectMaximum(UPDATED_UTC_TS);
    }

    public void selectAverageUpdatedUtcTs()
    {
        selectAverage(UPDATED_UTC_TS);
    }

    public void selectSumUpdatedUtcTs()
    {
        selectSum(UPDATED_UTC_TS);
    }

    public void groupByUpdatedUtcTs()
    {
        groupBy(UPDATED_UTC_TS);
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
    //# association (CreatedBy)
    //##################################################

    public void selectCreatedByUid()
    {
        select(CREATED_BY_UID);
    }

    public void selectCountDistinctCreatedByUid()
    {
        selectCountDistinct(CREATED_BY_UID);
    }
    
    public void selectDistinctCreatedByUid()
    {
        selectDistinct(CREATED_BY_UID);
    }

    public void selectMinimumCreatedByUid()
    {
        selectMinimum(CREATED_BY_UID);
    }

    public void selectMaximumCreatedByUid()
    {
        selectMaximum(CREATED_BY_UID);
    }

    public void groupByCreatedByUid()
    {
        groupBy(CREATED_BY_UID);
    }

    public MyUserCriteria joinToCreatedBy()
    {
        return new MyUserCriteria(joinTo(CREATED_BY));
    }

    public MyUserCriteria leftJoinToCreatedBy()
    {
        return new MyUserCriteria(leftJoinTo(CREATED_BY));
    }

    public KmhStringCondition whereCreatedByUid()
    {
        return new KmhStringCondition(parent(), alias(), CREATED_BY_UID);
    }

    public void whereCreatedByIs(MyUser e)
    {
        if ( e == null )
            whereCreatedByUid().isNull();
        else
            whereCreatedByUid().is(e.getUid());
    }

    public void whereCreatedByIsNot(MyUser e)
    {
        if ( e == null )
            whereCreatedByUid().isNotNull();
        else
            whereCreatedByUid().isNot(e.getUid());
    }

    //##################################################
    //# association (Customer)
    //##################################################

    public void selectCustomerUid()
    {
        select(CUSTOMER_UID);
    }

    public void selectCountDistinctCustomerUid()
    {
        selectCountDistinct(CUSTOMER_UID);
    }
    
    public void selectDistinctCustomerUid()
    {
        selectDistinct(CUSTOMER_UID);
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
        groupBy(CUSTOMER_UID);
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
        return new KmhStringCondition(parent(), alias(), CUSTOMER_UID);
    }

    public void whereCustomerIs(MyCustomer e)
    {
        if ( e == null )
            whereCustomerUid().isNull();
        else
            whereCustomerUid().is(e.getUid());
    }

    public void whereCustomerIsNot(MyCustomer e)
    {
        if ( e == null )
            whereCustomerUid().isNotNull();
        else
            whereCustomerUid().isNot(e.getUid());
    }

    //##################################################
    //# association (InstallContact)
    //##################################################

    public void selectInstallContactUid()
    {
        select(INSTALL_CONTACT_UID);
    }

    public void selectCountDistinctInstallContactUid()
    {
        selectCountDistinct(INSTALL_CONTACT_UID);
    }
    
    public void selectDistinctInstallContactUid()
    {
        selectDistinct(INSTALL_CONTACT_UID);
    }

    public void selectMinimumInstallContactUid()
    {
        selectMinimum(INSTALL_CONTACT_UID);
    }

    public void selectMaximumInstallContactUid()
    {
        selectMaximum(INSTALL_CONTACT_UID);
    }

    public void groupByInstallContactUid()
    {
        groupBy(INSTALL_CONTACT_UID);
    }

    public MySiteContactCriteria joinToInstallContact()
    {
        return new MySiteContactCriteria(joinTo(INSTALL_CONTACT));
    }

    public MySiteContactCriteria leftJoinToInstallContact()
    {
        return new MySiteContactCriteria(leftJoinTo(INSTALL_CONTACT));
    }

    public KmhStringCondition whereInstallContactUid()
    {
        return new KmhStringCondition(parent(), alias(), INSTALL_CONTACT_UID);
    }

    public void whereInstallContactIs(MySiteContact e)
    {
        if ( e == null )
            whereInstallContactUid().isNull();
        else
            whereInstallContactUid().is(e.getUid());
    }

    public void whereInstallContactIsNot(MySiteContact e)
    {
        if ( e == null )
            whereInstallContactUid().isNotNull();
        else
            whereInstallContactUid().isNot(e.getUid());
    }

    //##################################################
    //# association (MainContact)
    //##################################################

    public void selectMainContactUid()
    {
        select(MAIN_CONTACT_UID);
    }

    public void selectCountDistinctMainContactUid()
    {
        selectCountDistinct(MAIN_CONTACT_UID);
    }
    
    public void selectDistinctMainContactUid()
    {
        selectDistinct(MAIN_CONTACT_UID);
    }

    public void selectMinimumMainContactUid()
    {
        selectMinimum(MAIN_CONTACT_UID);
    }

    public void selectMaximumMainContactUid()
    {
        selectMaximum(MAIN_CONTACT_UID);
    }

    public void groupByMainContactUid()
    {
        groupBy(MAIN_CONTACT_UID);
    }

    public MySiteContactCriteria joinToMainContact()
    {
        return new MySiteContactCriteria(joinTo(MAIN_CONTACT));
    }

    public MySiteContactCriteria leftJoinToMainContact()
    {
        return new MySiteContactCriteria(leftJoinTo(MAIN_CONTACT));
    }

    public KmhStringCondition whereMainContactUid()
    {
        return new KmhStringCondition(parent(), alias(), MAIN_CONTACT_UID);
    }

    public void whereMainContactIs(MySiteContact e)
    {
        if ( e == null )
            whereMainContactUid().isNull();
        else
            whereMainContactUid().is(e.getUid());
    }

    public void whereMainContactIsNot(MySiteContact e)
    {
        if ( e == null )
            whereMainContactUid().isNotNull();
        else
            whereMainContactUid().isNot(e.getUid());
    }

    //##################################################
    //# association (Priority)
    //##################################################

    public void selectPriorityUid()
    {
        select(PRIORITY_UID);
    }

    public void selectCountDistinctPriorityUid()
    {
        selectCountDistinct(PRIORITY_UID);
    }
    
    public void selectDistinctPriorityUid()
    {
        selectDistinct(PRIORITY_UID);
    }

    public void selectMinimumPriorityUid()
    {
        selectMinimum(PRIORITY_UID);
    }

    public void selectMaximumPriorityUid()
    {
        selectMaximum(PRIORITY_UID);
    }

    public void groupByPriorityUid()
    {
        groupBy(PRIORITY_UID);
    }

    public MyPriorityCriteria joinToPriority()
    {
        return new MyPriorityCriteria(joinTo(PRIORITY));
    }

    public MyPriorityCriteria leftJoinToPriority()
    {
        return new MyPriorityCriteria(leftJoinTo(PRIORITY));
    }

    public KmhStringCondition wherePriorityUid()
    {
        return new KmhStringCondition(parent(), alias(), PRIORITY_UID);
    }

    public void wherePriorityIs(MyPriority e)
    {
        if ( e == null )
            wherePriorityUid().isNull();
        else
            wherePriorityUid().is(e.getUid());
    }

    public void wherePriorityIsNot(MyPriority e)
    {
        if ( e == null )
            wherePriorityUid().isNotNull();
        else
            wherePriorityUid().isNot(e.getUid());
    }

    //##################################################
    //# association (RequesterContact)
    //##################################################

    public void selectRequesterContactUid()
    {
        select(REQUESTER_CONTACT_UID);
    }

    public void selectCountDistinctRequesterContactUid()
    {
        selectCountDistinct(REQUESTER_CONTACT_UID);
    }
    
    public void selectDistinctRequesterContactUid()
    {
        selectDistinct(REQUESTER_CONTACT_UID);
    }

    public void selectMinimumRequesterContactUid()
    {
        selectMinimum(REQUESTER_CONTACT_UID);
    }

    public void selectMaximumRequesterContactUid()
    {
        selectMaximum(REQUESTER_CONTACT_UID);
    }

    public void groupByRequesterContactUid()
    {
        groupBy(REQUESTER_CONTACT_UID);
    }

    public MySiteContactCriteria joinToRequesterContact()
    {
        return new MySiteContactCriteria(joinTo(REQUESTER_CONTACT));
    }

    public MySiteContactCriteria leftJoinToRequesterContact()
    {
        return new MySiteContactCriteria(leftJoinTo(REQUESTER_CONTACT));
    }

    public KmhStringCondition whereRequesterContactUid()
    {
        return new KmhStringCondition(parent(), alias(), REQUESTER_CONTACT_UID);
    }

    public void whereRequesterContactIs(MySiteContact e)
    {
        if ( e == null )
            whereRequesterContactUid().isNull();
        else
            whereRequesterContactUid().is(e.getUid());
    }

    public void whereRequesterContactIsNot(MySiteContact e)
    {
        if ( e == null )
            whereRequesterContactUid().isNotNull();
        else
            whereRequesterContactUid().isNot(e.getUid());
    }

    //##################################################
    //# association (SalesContact)
    //##################################################

    public void selectSalesContactUid()
    {
        select(SALES_CONTACT_UID);
    }

    public void selectCountDistinctSalesContactUid()
    {
        selectCountDistinct(SALES_CONTACT_UID);
    }
    
    public void selectDistinctSalesContactUid()
    {
        selectDistinct(SALES_CONTACT_UID);
    }

    public void selectMinimumSalesContactUid()
    {
        selectMinimum(SALES_CONTACT_UID);
    }

    public void selectMaximumSalesContactUid()
    {
        selectMaximum(SALES_CONTACT_UID);
    }

    public void groupBySalesContactUid()
    {
        groupBy(SALES_CONTACT_UID);
    }

    public MySiteContactCriteria joinToSalesContact()
    {
        return new MySiteContactCriteria(joinTo(SALES_CONTACT));
    }

    public MySiteContactCriteria leftJoinToSalesContact()
    {
        return new MySiteContactCriteria(leftJoinTo(SALES_CONTACT));
    }

    public KmhStringCondition whereSalesContactUid()
    {
        return new KmhStringCondition(parent(), alias(), SALES_CONTACT_UID);
    }

    public void whereSalesContactIs(MySiteContact e)
    {
        if ( e == null )
            whereSalesContactUid().isNull();
        else
            whereSalesContactUid().is(e.getUid());
    }

    public void whereSalesContactIsNot(MySiteContact e)
    {
        if ( e == null )
            whereSalesContactUid().isNotNull();
        else
            whereSalesContactUid().isNot(e.getUid());
    }

    //##################################################
    //# association (SchedulingContact)
    //##################################################

    public void selectSchedulingContactUid()
    {
        select(SCHEDULING_CONTACT_UID);
    }

    public void selectCountDistinctSchedulingContactUid()
    {
        selectCountDistinct(SCHEDULING_CONTACT_UID);
    }
    
    public void selectDistinctSchedulingContactUid()
    {
        selectDistinct(SCHEDULING_CONTACT_UID);
    }

    public void selectMinimumSchedulingContactUid()
    {
        selectMinimum(SCHEDULING_CONTACT_UID);
    }

    public void selectMaximumSchedulingContactUid()
    {
        selectMaximum(SCHEDULING_CONTACT_UID);
    }

    public void groupBySchedulingContactUid()
    {
        groupBy(SCHEDULING_CONTACT_UID);
    }

    public MySiteContactCriteria joinToSchedulingContact()
    {
        return new MySiteContactCriteria(joinTo(SCHEDULING_CONTACT));
    }

    public MySiteContactCriteria leftJoinToSchedulingContact()
    {
        return new MySiteContactCriteria(leftJoinTo(SCHEDULING_CONTACT));
    }

    public KmhStringCondition whereSchedulingContactUid()
    {
        return new KmhStringCondition(parent(), alias(), SCHEDULING_CONTACT_UID);
    }

    public void whereSchedulingContactIs(MySiteContact e)
    {
        if ( e == null )
            whereSchedulingContactUid().isNull();
        else
            whereSchedulingContactUid().is(e.getUid());
    }

    public void whereSchedulingContactIsNot(MySiteContact e)
    {
        if ( e == null )
            whereSchedulingContactUid().isNotNull();
        else
            whereSchedulingContactUid().isNot(e.getUid());
    }

    //##################################################
    //# association (TechnicalContact)
    //##################################################

    public void selectTechnicalContactUid()
    {
        select(TECHNICAL_CONTACT_UID);
    }

    public void selectCountDistinctTechnicalContactUid()
    {
        selectCountDistinct(TECHNICAL_CONTACT_UID);
    }
    
    public void selectDistinctTechnicalContactUid()
    {
        selectDistinct(TECHNICAL_CONTACT_UID);
    }

    public void selectMinimumTechnicalContactUid()
    {
        selectMinimum(TECHNICAL_CONTACT_UID);
    }

    public void selectMaximumTechnicalContactUid()
    {
        selectMaximum(TECHNICAL_CONTACT_UID);
    }

    public void groupByTechnicalContactUid()
    {
        groupBy(TECHNICAL_CONTACT_UID);
    }

    public MySiteContactCriteria joinToTechnicalContact()
    {
        return new MySiteContactCriteria(joinTo(TECHNICAL_CONTACT));
    }

    public MySiteContactCriteria leftJoinToTechnicalContact()
    {
        return new MySiteContactCriteria(leftJoinTo(TECHNICAL_CONTACT));
    }

    public KmhStringCondition whereTechnicalContactUid()
    {
        return new KmhStringCondition(parent(), alias(), TECHNICAL_CONTACT_UID);
    }

    public void whereTechnicalContactIs(MySiteContact e)
    {
        if ( e == null )
            whereTechnicalContactUid().isNull();
        else
            whereTechnicalContactUid().is(e.getUid());
    }

    public void whereTechnicalContactIsNot(MySiteContact e)
    {
        if ( e == null )
            whereTechnicalContactUid().isNotNull();
        else
            whereTechnicalContactUid().isNot(e.getUid());
    }

    //##################################################
    //# association (Type)
    //##################################################

    public void selectTypeUid()
    {
        select(TYPE_UID);
    }

    public void selectCountDistinctTypeUid()
    {
        selectCountDistinct(TYPE_UID);
    }
    
    public void selectDistinctTypeUid()
    {
        selectDistinct(TYPE_UID);
    }

    public void selectMinimumTypeUid()
    {
        selectMinimum(TYPE_UID);
    }

    public void selectMaximumTypeUid()
    {
        selectMaximum(TYPE_UID);
    }

    public void groupByTypeUid()
    {
        groupBy(TYPE_UID);
    }

    public MyChoiceCriteria joinToType()
    {
        return new MyChoiceCriteria(joinTo(TYPE));
    }

    public MyChoiceCriteria leftJoinToType()
    {
        return new MyChoiceCriteria(leftJoinTo(TYPE));
    }

    public KmhStringCondition whereTypeUid()
    {
        return new KmhStringCondition(parent(), alias(), TYPE_UID);
    }

    public void whereTypeIs(MyChoice e)
    {
        if ( e == null )
            whereTypeUid().isNull();
        else
            whereTypeUid().is(e.getUid());
    }

    public void whereTypeIsNot(MyChoice e)
    {
        if ( e == null )
            whereTypeUid().isNotNull();
        else
            whereTypeUid().isNot(e.getUid());
    }

    //##################################################
    //# association (UpdatedBy)
    //##################################################

    public void selectUpdatedByUid()
    {
        select(UPDATED_BY_UID);
    }

    public void selectCountDistinctUpdatedByUid()
    {
        selectCountDistinct(UPDATED_BY_UID);
    }
    
    public void selectDistinctUpdatedByUid()
    {
        selectDistinct(UPDATED_BY_UID);
    }

    public void selectMinimumUpdatedByUid()
    {
        selectMinimum(UPDATED_BY_UID);
    }

    public void selectMaximumUpdatedByUid()
    {
        selectMaximum(UPDATED_BY_UID);
    }

    public void groupByUpdatedByUid()
    {
        groupBy(UPDATED_BY_UID);
    }

    public MyUserCriteria joinToUpdatedBy()
    {
        return new MyUserCriteria(joinTo(UPDATED_BY));
    }

    public MyUserCriteria leftJoinToUpdatedBy()
    {
        return new MyUserCriteria(leftJoinTo(UPDATED_BY));
    }

    public KmhStringCondition whereUpdatedByUid()
    {
        return new KmhStringCondition(parent(), alias(), UPDATED_BY_UID);
    }

    public void whereUpdatedByIs(MyUser e)
    {
        if ( e == null )
            whereUpdatedByUid().isNull();
        else
            whereUpdatedByUid().is(e.getUid());
    }

    public void whereUpdatedByIsNot(MyUser e)
    {
        if ( e == null )
            whereUpdatedByUid().isNotNull();
        else
            whereUpdatedByUid().isNot(e.getUid());
    }

    //##################################################
    //# collection (Contacts)
    //##################################################

    public MySiteContactCriteria joinToContacts()
    {
        return new MySiteContactCriteria(joinTo(CONTACTS));
    }

    public MySiteContactCriteria leftJoinToContacts()
    {
        return new MySiteContactCriteria(leftJoinTo(CONTACTS));
    }

    //##################################################
    //# junction :: alias
    //##################################################

    public MySiteJunction all()
    {
        return addAnd();
    }

    public MySiteJunction any()
    {
        return addOr();
    }

    public MySiteJunction none()
    {
        return addNotOr();
    }

    //##################################################
    //# junction :: basic
    //##################################################

    public MySiteJunction addNotAnd()
    {
        return new MySiteJunction(parent().addNotAnd());
    }

    public MySiteJunction addNotOr()
    {
        return new MySiteJunction(parent().addNotOr());
    }

    public MySiteJunction addAnd()
    {
        return new MySiteJunction(parent().addAnd());
    }

    public MySiteJunction addOr()
    {
        return new MySiteJunction(parent().addOr());
    }
}
