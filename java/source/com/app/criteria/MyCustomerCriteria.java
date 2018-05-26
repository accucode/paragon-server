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
    //# primary key
    //##################################################

    public void whereUidIs(MyCustomer e)
    {
        whereUid().is(e.getUid());
    }

    public void whereUidIsNot(MyCustomer e)
    {
        whereUid().isNot(e.getUid());
    }

    //##################################################
    //# properties
    //##################################################

    public KmhStringCondition whereBillingAttention()
    {
        return new KmhStringCondition(context(), alias(), BILLING_ATTENTION);
    }

    public KmhStringCondition whereBillingCity()
    {
        return new KmhStringCondition(context(), alias(), BILLING_CITY);
    }

    public KmhStringCondition whereBillingCountry()
    {
        return new KmhStringCondition(context(), alias(), BILLING_COUNTRY);
    }

    public KmhStringCondition whereBillingPhone()
    {
        return new KmhStringCondition(context(), alias(), BILLING_PHONE);
    }

    public KmhStringCondition whereBillingPostalCode()
    {
        return new KmhStringCondition(context(), alias(), BILLING_POSTAL_CODE);
    }

    public KmhStringCondition whereBillingRegion()
    {
        return new KmhStringCondition(context(), alias(), BILLING_REGION);
    }

    public KmhStringCondition whereBillingStreet1()
    {
        return new KmhStringCondition(context(), alias(), BILLING_STREET_1);
    }

    public KmhStringCondition whereBillingStreet2()
    {
        return new KmhStringCondition(context(), alias(), BILLING_STREET_2);
    }

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), CREATED_UTC_TS);
    }

    public KmhBooleanCondition whereEnabled()
    {
        return new KmhBooleanCondition(context(), alias(), ENABLED);
    }

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), alias(), NAME);
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

    public void sortOnBillingAttention()
    {
        parent().sortAscending(BILLING_ATTENTION);
    }

    public void sortOnBillingAttentionDescending()
    {
        parent().sortDescending(BILLING_ATTENTION);
    }

    public void sortOnBillingAttention(boolean asc)
    {
        if ( asc )
            sortOnBillingAttention();
        else
            sortOnBillingAttentionDescending();
    }

    public void sortOnBillingCity()
    {
        parent().sortAscending(BILLING_CITY);
    }

    public void sortOnBillingCityDescending()
    {
        parent().sortDescending(BILLING_CITY);
    }

    public void sortOnBillingCity(boolean asc)
    {
        if ( asc )
            sortOnBillingCity();
        else
            sortOnBillingCityDescending();
    }

    public void sortOnBillingCountry()
    {
        parent().sortAscending(BILLING_COUNTRY);
    }

    public void sortOnBillingCountryDescending()
    {
        parent().sortDescending(BILLING_COUNTRY);
    }

    public void sortOnBillingCountry(boolean asc)
    {
        if ( asc )
            sortOnBillingCountry();
        else
            sortOnBillingCountryDescending();
    }

    public void sortOnBillingPhone()
    {
        parent().sortAscending(BILLING_PHONE);
    }

    public void sortOnBillingPhoneDescending()
    {
        parent().sortDescending(BILLING_PHONE);
    }

    public void sortOnBillingPhone(boolean asc)
    {
        if ( asc )
            sortOnBillingPhone();
        else
            sortOnBillingPhoneDescending();
    }

    public void sortOnBillingPostalCode()
    {
        parent().sortAscending(BILLING_POSTAL_CODE);
    }

    public void sortOnBillingPostalCodeDescending()
    {
        parent().sortDescending(BILLING_POSTAL_CODE);
    }

    public void sortOnBillingPostalCode(boolean asc)
    {
        if ( asc )
            sortOnBillingPostalCode();
        else
            sortOnBillingPostalCodeDescending();
    }

    public void sortOnBillingRegion()
    {
        parent().sortAscending(BILLING_REGION);
    }

    public void sortOnBillingRegionDescending()
    {
        parent().sortDescending(BILLING_REGION);
    }

    public void sortOnBillingRegion(boolean asc)
    {
        if ( asc )
            sortOnBillingRegion();
        else
            sortOnBillingRegionDescending();
    }

    public void sortOnBillingStreet1()
    {
        parent().sortAscending(BILLING_STREET_1);
    }

    public void sortOnBillingStreet1Descending()
    {
        parent().sortDescending(BILLING_STREET_1);
    }

    public void sortOnBillingStreet1(boolean asc)
    {
        if ( asc )
            sortOnBillingStreet1();
        else
            sortOnBillingStreet1Descending();
    }

    public void sortOnBillingStreet2()
    {
        parent().sortAscending(BILLING_STREET_2);
    }

    public void sortOnBillingStreet2Descending()
    {
        parent().sortDescending(BILLING_STREET_2);
    }

    public void sortOnBillingStreet2(boolean asc)
    {
        if ( asc )
            sortOnBillingStreet2();
        else
            sortOnBillingStreet2Descending();
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
    //# projections (billingAttention)
    //##################################################

    public void selectBillingAttention()
    {
        select(BILLING_ATTENTION);
    }

    public void selectDistinctBillingAttention()
    {
        selectDistinct(BILLING_ATTENTION);
    }

    public void selectCountDistinctBillingAttention()
    {
        selectCountDistinct(BILLING_ATTENTION);
    }

    public void selectMinimumBillingAttention()
    {
        selectMinimum(BILLING_ATTENTION);
    }

    public void selectMaximumBillingAttention()
    {
        selectMaximum(BILLING_ATTENTION);
    }

    public void selectAverageBillingAttention()
    {
        selectAverage(BILLING_ATTENTION);
    }

    public void selectSumBillingAttention()
    {
        selectSum(BILLING_ATTENTION);
    }

    public void groupByBillingAttention()
    {
        groupBy(BILLING_ATTENTION);
    }

    //##################################################
    //# projections (billingCity)
    //##################################################

    public void selectBillingCity()
    {
        select(BILLING_CITY);
    }

    public void selectDistinctBillingCity()
    {
        selectDistinct(BILLING_CITY);
    }

    public void selectCountDistinctBillingCity()
    {
        selectCountDistinct(BILLING_CITY);
    }

    public void selectMinimumBillingCity()
    {
        selectMinimum(BILLING_CITY);
    }

    public void selectMaximumBillingCity()
    {
        selectMaximum(BILLING_CITY);
    }

    public void selectAverageBillingCity()
    {
        selectAverage(BILLING_CITY);
    }

    public void selectSumBillingCity()
    {
        selectSum(BILLING_CITY);
    }

    public void groupByBillingCity()
    {
        groupBy(BILLING_CITY);
    }

    //##################################################
    //# projections (billingCountry)
    //##################################################

    public void selectBillingCountry()
    {
        select(BILLING_COUNTRY);
    }

    public void selectDistinctBillingCountry()
    {
        selectDistinct(BILLING_COUNTRY);
    }

    public void selectCountDistinctBillingCountry()
    {
        selectCountDistinct(BILLING_COUNTRY);
    }

    public void selectMinimumBillingCountry()
    {
        selectMinimum(BILLING_COUNTRY);
    }

    public void selectMaximumBillingCountry()
    {
        selectMaximum(BILLING_COUNTRY);
    }

    public void selectAverageBillingCountry()
    {
        selectAverage(BILLING_COUNTRY);
    }

    public void selectSumBillingCountry()
    {
        selectSum(BILLING_COUNTRY);
    }

    public void groupByBillingCountry()
    {
        groupBy(BILLING_COUNTRY);
    }

    //##################################################
    //# projections (billingPhone)
    //##################################################

    public void selectBillingPhone()
    {
        select(BILLING_PHONE);
    }

    public void selectDistinctBillingPhone()
    {
        selectDistinct(BILLING_PHONE);
    }

    public void selectCountDistinctBillingPhone()
    {
        selectCountDistinct(BILLING_PHONE);
    }

    public void selectMinimumBillingPhone()
    {
        selectMinimum(BILLING_PHONE);
    }

    public void selectMaximumBillingPhone()
    {
        selectMaximum(BILLING_PHONE);
    }

    public void selectAverageBillingPhone()
    {
        selectAverage(BILLING_PHONE);
    }

    public void selectSumBillingPhone()
    {
        selectSum(BILLING_PHONE);
    }

    public void groupByBillingPhone()
    {
        groupBy(BILLING_PHONE);
    }

    //##################################################
    //# projections (billingPostalCode)
    //##################################################

    public void selectBillingPostalCode()
    {
        select(BILLING_POSTAL_CODE);
    }

    public void selectDistinctBillingPostalCode()
    {
        selectDistinct(BILLING_POSTAL_CODE);
    }

    public void selectCountDistinctBillingPostalCode()
    {
        selectCountDistinct(BILLING_POSTAL_CODE);
    }

    public void selectMinimumBillingPostalCode()
    {
        selectMinimum(BILLING_POSTAL_CODE);
    }

    public void selectMaximumBillingPostalCode()
    {
        selectMaximum(BILLING_POSTAL_CODE);
    }

    public void selectAverageBillingPostalCode()
    {
        selectAverage(BILLING_POSTAL_CODE);
    }

    public void selectSumBillingPostalCode()
    {
        selectSum(BILLING_POSTAL_CODE);
    }

    public void groupByBillingPostalCode()
    {
        groupBy(BILLING_POSTAL_CODE);
    }

    //##################################################
    //# projections (billingRegion)
    //##################################################

    public void selectBillingRegion()
    {
        select(BILLING_REGION);
    }

    public void selectDistinctBillingRegion()
    {
        selectDistinct(BILLING_REGION);
    }

    public void selectCountDistinctBillingRegion()
    {
        selectCountDistinct(BILLING_REGION);
    }

    public void selectMinimumBillingRegion()
    {
        selectMinimum(BILLING_REGION);
    }

    public void selectMaximumBillingRegion()
    {
        selectMaximum(BILLING_REGION);
    }

    public void selectAverageBillingRegion()
    {
        selectAverage(BILLING_REGION);
    }

    public void selectSumBillingRegion()
    {
        selectSum(BILLING_REGION);
    }

    public void groupByBillingRegion()
    {
        groupBy(BILLING_REGION);
    }

    //##################################################
    //# projections (billingStreet1)
    //##################################################

    public void selectBillingStreet1()
    {
        select(BILLING_STREET_1);
    }

    public void selectDistinctBillingStreet1()
    {
        selectDistinct(BILLING_STREET_1);
    }

    public void selectCountDistinctBillingStreet1()
    {
        selectCountDistinct(BILLING_STREET_1);
    }

    public void selectMinimumBillingStreet1()
    {
        selectMinimum(BILLING_STREET_1);
    }

    public void selectMaximumBillingStreet1()
    {
        selectMaximum(BILLING_STREET_1);
    }

    public void selectAverageBillingStreet1()
    {
        selectAverage(BILLING_STREET_1);
    }

    public void selectSumBillingStreet1()
    {
        selectSum(BILLING_STREET_1);
    }

    public void groupByBillingStreet1()
    {
        groupBy(BILLING_STREET_1);
    }

    //##################################################
    //# projections (billingStreet2)
    //##################################################

    public void selectBillingStreet2()
    {
        select(BILLING_STREET_2);
    }

    public void selectDistinctBillingStreet2()
    {
        selectDistinct(BILLING_STREET_2);
    }

    public void selectCountDistinctBillingStreet2()
    {
        selectCountDistinct(BILLING_STREET_2);
    }

    public void selectMinimumBillingStreet2()
    {
        selectMinimum(BILLING_STREET_2);
    }

    public void selectMaximumBillingStreet2()
    {
        selectMaximum(BILLING_STREET_2);
    }

    public void selectAverageBillingStreet2()
    {
        selectAverage(BILLING_STREET_2);
    }

    public void selectSumBillingStreet2()
    {
        selectSum(BILLING_STREET_2);
    }

    public void groupByBillingStreet2()
    {
        groupBy(BILLING_STREET_2);
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
    //# association (ApprovalContact)
    //##################################################

    public void selectApprovalContactUid()
    {
        select(APPROVAL_CONTACT_UID);
    }

    public void selectCountDistinctApprovalContactUid()
    {
        selectCountDistinct(APPROVAL_CONTACT_UID);
    }
    
    public void selectDistinctApprovalContactUid()
    {
        selectDistinct(APPROVAL_CONTACT_UID);
    }

    public void selectMinimumApprovalContactUid()
    {
        selectMinimum(APPROVAL_CONTACT_UID);
    }

    public void selectMaximumApprovalContactUid()
    {
        selectMaximum(APPROVAL_CONTACT_UID);
    }

    public void groupByApprovalContactUid()
    {
        groupBy(APPROVAL_CONTACT_UID);
    }

    public MyCustomerContactCriteria joinToApprovalContact()
    {
        return new MyCustomerContactCriteria(joinTo(APPROVAL_CONTACT));
    }

    public MyCustomerContactCriteria leftJoinToApprovalContact()
    {
        return new MyCustomerContactCriteria(leftJoinTo(APPROVAL_CONTACT));
    }

    public KmhStringCondition whereApprovalContactUid()
    {
        return new KmhStringCondition(parent(), alias(), APPROVAL_CONTACT_UID);
    }

    public void whereApprovalContactIs(MyCustomerContact e)
    {
        if ( e == null )
            whereApprovalContactUid().isNull();
        else
            whereApprovalContactUid().is(e.getUid());
    }

    public void whereApprovalContactIsNot(MyCustomerContact e)
    {
        if ( e == null )
            whereApprovalContactUid().isNotNull();
        else
            whereApprovalContactUid().isNot(e.getUid());
    }

    //##################################################
    //# association (BillingContact)
    //##################################################

    public void selectBillingContactUid()
    {
        select(BILLING_CONTACT_UID);
    }

    public void selectCountDistinctBillingContactUid()
    {
        selectCountDistinct(BILLING_CONTACT_UID);
    }
    
    public void selectDistinctBillingContactUid()
    {
        selectDistinct(BILLING_CONTACT_UID);
    }

    public void selectMinimumBillingContactUid()
    {
        selectMinimum(BILLING_CONTACT_UID);
    }

    public void selectMaximumBillingContactUid()
    {
        selectMaximum(BILLING_CONTACT_UID);
    }

    public void groupByBillingContactUid()
    {
        groupBy(BILLING_CONTACT_UID);
    }

    public MyCustomerContactCriteria joinToBillingContact()
    {
        return new MyCustomerContactCriteria(joinTo(BILLING_CONTACT));
    }

    public MyCustomerContactCriteria leftJoinToBillingContact()
    {
        return new MyCustomerContactCriteria(leftJoinTo(BILLING_CONTACT));
    }

    public KmhStringCondition whereBillingContactUid()
    {
        return new KmhStringCondition(parent(), alias(), BILLING_CONTACT_UID);
    }

    public void whereBillingContactIs(MyCustomerContact e)
    {
        if ( e == null )
            whereBillingContactUid().isNull();
        else
            whereBillingContactUid().is(e.getUid());
    }

    public void whereBillingContactIsNot(MyCustomerContact e)
    {
        if ( e == null )
            whereBillingContactUid().isNotNull();
        else
            whereBillingContactUid().isNot(e.getUid());
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
    //# association (Project)
    //##################################################

    public void selectProjectUid()
    {
        select(PROJECT_UID);
    }

    public void selectCountDistinctProjectUid()
    {
        selectCountDistinct(PROJECT_UID);
    }
    
    public void selectDistinctProjectUid()
    {
        selectDistinct(PROJECT_UID);
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
        groupBy(PROJECT_UID);
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
        return new KmhStringCondition(parent(), alias(), PROJECT_UID);
    }

    public void whereProjectIs(MyProject e)
    {
        if ( e == null )
            whereProjectUid().isNull();
        else
            whereProjectUid().is(e.getUid());
    }

    public void whereProjectIsNot(MyProject e)
    {
        if ( e == null )
            whereProjectUid().isNotNull();
        else
            whereProjectUid().isNot(e.getUid());
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

    public MyCustomerContactCriteria joinToContacts()
    {
        return new MyCustomerContactCriteria(joinTo(CONTACTS));
    }

    public MyCustomerContactCriteria leftJoinToContacts()
    {
        return new MyCustomerContactCriteria(leftJoinTo(CONTACTS));
    }

    //##################################################
    //# junction :: alias
    //##################################################

    public MyCustomerJunction all()
    {
        return addAnd();
    }

    public MyCustomerJunction any()
    {
        return addOr();
    }

    public MyCustomerJunction none()
    {
        return addNotOr();
    }

    //##################################################
    //# junction :: basic
    //##################################################

    public MyCustomerJunction addNotAnd()
    {
        return new MyCustomerJunction(parent().addNotAnd());
    }

    public MyCustomerJunction addNotOr()
    {
        return new MyCustomerJunction(parent().addNotOr());
    }

    public MyCustomerJunction addAnd()
    {
        return new MyCustomerJunction(parent().addAnd());
    }

    public MyCustomerJunction addOr()
    {
        return new MyCustomerJunction(parent().addOr());
    }
}
