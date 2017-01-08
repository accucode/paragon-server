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

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), fullName(CREATED_UTC_TS));
    }

    public KmhTimestampCondition whereUpdatedUtcTs()
    {
        return new KmhTimestampCondition(context(), fullName(UPDATED_UTC_TS));
    }

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), fullName(NAME));
    }

    public KmhStringCondition whereCode()
    {
        return new KmhStringCondition(context(), fullName(CODE));
    }

    public KmhStringCondition whereCompanyName()
    {
        return new KmhStringCondition(context(), fullName(COMPANY_NAME));
    }

    public KmhStringCondition whereSendEmailFrom()
    {
        return new KmhStringCondition(context(), fullName(SEND_EMAIL_FROM));
    }

    public KmhBooleanCondition whereActive()
    {
        return new KmhBooleanCondition(context(), fullName(ACTIVE));
    }

    public KmhIntegerCondition whereCatalogVersion()
    {
        return new KmhIntegerCondition(context(), fullName(CATALOG_VERSION));
    }

    public KmhPropertyCondition<KmDayFrequency> whereBusinessDays()
    {
        return new KmhPropertyCondition<>(context(), fullName(BUSINESS_DAYS));
    }

    public KmhTimeCondition whereBusinessStartTime()
    {
        return new KmhTimeCondition(context(), fullName(BUSINESS_START_TIME));
    }

    public KmhTimeCondition whereBusinessEndTime()
    {
        return new KmhTimeCondition(context(), fullName(BUSINESS_END_TIME));
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

    public void sortOnCode()
    {
        parent().sortAscending(CODE);
    }

    public void sortOnCodeDescending()
    {
        parent().sortDescending(CODE);
    }

    public void sortOnCode(boolean asc)
    {
        if ( asc )
            sortOnCode();
        else
            sortOnCodeDescending();
    }

    public void sortOnCompanyName()
    {
        parent().sortAscending(COMPANY_NAME);
    }

    public void sortOnCompanyNameDescending()
    {
        parent().sortDescending(COMPANY_NAME);
    }

    public void sortOnCompanyName(boolean asc)
    {
        if ( asc )
            sortOnCompanyName();
        else
            sortOnCompanyNameDescending();
    }

    public void sortOnSendEmailFrom()
    {
        parent().sortAscending(SEND_EMAIL_FROM);
    }

    public void sortOnSendEmailFromDescending()
    {
        parent().sortDescending(SEND_EMAIL_FROM);
    }

    public void sortOnSendEmailFrom(boolean asc)
    {
        if ( asc )
            sortOnSendEmailFrom();
        else
            sortOnSendEmailFromDescending();
    }

    public void sortOnActive()
    {
        parent().sortAscending(ACTIVE);
    }

    public void sortOnActiveDescending()
    {
        parent().sortDescending(ACTIVE);
    }

    public void sortOnActive(boolean asc)
    {
        if ( asc )
            sortOnActive();
        else
            sortOnActiveDescending();
    }

    public void sortOnCatalogVersion()
    {
        parent().sortAscending(CATALOG_VERSION);
    }

    public void sortOnCatalogVersionDescending()
    {
        parent().sortDescending(CATALOG_VERSION);
    }

    public void sortOnCatalogVersion(boolean asc)
    {
        if ( asc )
            sortOnCatalogVersion();
        else
            sortOnCatalogVersionDescending();
    }

    public void sortOnBusinessDays()
    {
        parent().sortAscending(BUSINESS_DAYS);
    }

    public void sortOnBusinessDaysDescending()
    {
        parent().sortDescending(BUSINESS_DAYS);
    }

    public void sortOnBusinessDays(boolean asc)
    {
        if ( asc )
            sortOnBusinessDays();
        else
            sortOnBusinessDaysDescending();
    }

    public void sortOnBusinessStartTime()
    {
        parent().sortAscending(BUSINESS_START_TIME);
    }

    public void sortOnBusinessStartTimeDescending()
    {
        parent().sortDescending(BUSINESS_START_TIME);
    }

    public void sortOnBusinessStartTime(boolean asc)
    {
        if ( asc )
            sortOnBusinessStartTime();
        else
            sortOnBusinessStartTimeDescending();
    }

    public void sortOnBusinessEndTime()
    {
        parent().sortAscending(BUSINESS_END_TIME);
    }

    public void sortOnBusinessEndTimeDescending()
    {
        parent().sortDescending(BUSINESS_END_TIME);
    }

    public void sortOnBusinessEndTime(boolean asc)
    {
        if ( asc )
            sortOnBusinessEndTime();
        else
            sortOnBusinessEndTimeDescending();
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
    //# projections (code)
    //##################################################

    public void selectCode()
    {
        select(CODE);
    }

    public void selectDistinctCode()
    {
        selectDistinct(CODE);
    }

    public void selectCountDistinctCode()
    {
        selectCountDistinct(CODE);
    }

    public void selectMinimumCode()
    {
        selectMinimum(CODE);
    }

    public void selectMaximumCode()
    {
        selectMaximum(CODE);
    }

    public void selectAverageCode()
    {
        selectAverage(CODE);
    }

    public void selectSumCode()
    {
        selectSum(CODE);
    }

    public void groupByCode()
    {
        groupBy(CODE);
    }

    //##################################################
    //# projections (companyName)
    //##################################################

    public void selectCompanyName()
    {
        select(COMPANY_NAME);
    }

    public void selectDistinctCompanyName()
    {
        selectDistinct(COMPANY_NAME);
    }

    public void selectCountDistinctCompanyName()
    {
        selectCountDistinct(COMPANY_NAME);
    }

    public void selectMinimumCompanyName()
    {
        selectMinimum(COMPANY_NAME);
    }

    public void selectMaximumCompanyName()
    {
        selectMaximum(COMPANY_NAME);
    }

    public void selectAverageCompanyName()
    {
        selectAverage(COMPANY_NAME);
    }

    public void selectSumCompanyName()
    {
        selectSum(COMPANY_NAME);
    }

    public void groupByCompanyName()
    {
        groupBy(COMPANY_NAME);
    }

    //##################################################
    //# projections (sendEmailFrom)
    //##################################################

    public void selectSendEmailFrom()
    {
        select(SEND_EMAIL_FROM);
    }

    public void selectDistinctSendEmailFrom()
    {
        selectDistinct(SEND_EMAIL_FROM);
    }

    public void selectCountDistinctSendEmailFrom()
    {
        selectCountDistinct(SEND_EMAIL_FROM);
    }

    public void selectMinimumSendEmailFrom()
    {
        selectMinimum(SEND_EMAIL_FROM);
    }

    public void selectMaximumSendEmailFrom()
    {
        selectMaximum(SEND_EMAIL_FROM);
    }

    public void selectAverageSendEmailFrom()
    {
        selectAverage(SEND_EMAIL_FROM);
    }

    public void selectSumSendEmailFrom()
    {
        selectSum(SEND_EMAIL_FROM);
    }

    public void groupBySendEmailFrom()
    {
        groupBy(SEND_EMAIL_FROM);
    }

    //##################################################
    //# projections (active)
    //##################################################

    public void selectActive()
    {
        select(ACTIVE);
    }

    public void selectDistinctActive()
    {
        selectDistinct(ACTIVE);
    }

    public void selectCountDistinctActive()
    {
        selectCountDistinct(ACTIVE);
    }

    public void selectMinimumActive()
    {
        selectMinimum(ACTIVE);
    }

    public void selectMaximumActive()
    {
        selectMaximum(ACTIVE);
    }

    public void selectAverageActive()
    {
        selectAverage(ACTIVE);
    }

    public void selectSumActive()
    {
        selectSum(ACTIVE);
    }

    public void groupByActive()
    {
        groupBy(ACTIVE);
    }

    //##################################################
    //# projections (catalogVersion)
    //##################################################

    public void selectCatalogVersion()
    {
        select(CATALOG_VERSION);
    }

    public void selectDistinctCatalogVersion()
    {
        selectDistinct(CATALOG_VERSION);
    }

    public void selectCountDistinctCatalogVersion()
    {
        selectCountDistinct(CATALOG_VERSION);
    }

    public void selectMinimumCatalogVersion()
    {
        selectMinimum(CATALOG_VERSION);
    }

    public void selectMaximumCatalogVersion()
    {
        selectMaximum(CATALOG_VERSION);
    }

    public void selectAverageCatalogVersion()
    {
        selectAverage(CATALOG_VERSION);
    }

    public void selectSumCatalogVersion()
    {
        selectSum(CATALOG_VERSION);
    }

    public void groupByCatalogVersion()
    {
        groupBy(CATALOG_VERSION);
    }

    //##################################################
    //# projections (businessDays)
    //##################################################

    public void selectBusinessDays()
    {
        select(BUSINESS_DAYS);
    }

    public void selectDistinctBusinessDays()
    {
        selectDistinct(BUSINESS_DAYS);
    }

    public void selectCountDistinctBusinessDays()
    {
        selectCountDistinct(BUSINESS_DAYS);
    }

    public void selectMinimumBusinessDays()
    {
        selectMinimum(BUSINESS_DAYS);
    }

    public void selectMaximumBusinessDays()
    {
        selectMaximum(BUSINESS_DAYS);
    }

    public void selectAverageBusinessDays()
    {
        selectAverage(BUSINESS_DAYS);
    }

    public void selectSumBusinessDays()
    {
        selectSum(BUSINESS_DAYS);
    }

    public void groupByBusinessDays()
    {
        groupBy(BUSINESS_DAYS);
    }

    //##################################################
    //# projections (businessStartTime)
    //##################################################

    public void selectBusinessStartTime()
    {
        select(BUSINESS_START_TIME);
    }

    public void selectDistinctBusinessStartTime()
    {
        selectDistinct(BUSINESS_START_TIME);
    }

    public void selectCountDistinctBusinessStartTime()
    {
        selectCountDistinct(BUSINESS_START_TIME);
    }

    public void selectMinimumBusinessStartTime()
    {
        selectMinimum(BUSINESS_START_TIME);
    }

    public void selectMaximumBusinessStartTime()
    {
        selectMaximum(BUSINESS_START_TIME);
    }

    public void selectAverageBusinessStartTime()
    {
        selectAverage(BUSINESS_START_TIME);
    }

    public void selectSumBusinessStartTime()
    {
        selectSum(BUSINESS_START_TIME);
    }

    public void groupByBusinessStartTime()
    {
        groupBy(BUSINESS_START_TIME);
    }

    //##################################################
    //# projections (businessEndTime)
    //##################################################

    public void selectBusinessEndTime()
    {
        select(BUSINESS_END_TIME);
    }

    public void selectDistinctBusinessEndTime()
    {
        selectDistinct(BUSINESS_END_TIME);
    }

    public void selectCountDistinctBusinessEndTime()
    {
        selectCountDistinct(BUSINESS_END_TIME);
    }

    public void selectMinimumBusinessEndTime()
    {
        selectMinimum(BUSINESS_END_TIME);
    }

    public void selectMaximumBusinessEndTime()
    {
        selectMaximum(BUSINESS_END_TIME);
    }

    public void selectAverageBusinessEndTime()
    {
        selectAverage(BUSINESS_END_TIME);
    }

    public void selectSumBusinessEndTime()
    {
        selectSum(BUSINESS_END_TIME);
    }

    public void groupByBusinessEndTime()
    {
        groupBy(BUSINESS_END_TIME);
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
        return new KmhStringCondition(parent(), fullName(CREATED_BY_UID));
    }

    public void whereCreatedByIs(MyUser e)
    {
        if ( e == null )
            whereCreatedByUid().isNull();
        else
            whereCreatedByUid().is(e.getUid());
    }

    //##################################################
    //# association (UpdatedBy)
    //##################################################

    public void selectUpdatedByUid()
    {
        select(UPDATED_BY_UID);
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
        return new KmhStringCondition(parent(), fullName(UPDATED_BY_UID));
    }

    public void whereUpdatedByIs(MyUser e)
    {
        if ( e == null )
            whereUpdatedByUid().isNull();
        else
            whereUpdatedByUid().is(e.getUid());
    }

    //##################################################
    //# association (Tenant)
    //##################################################

    public void selectTenantUid()
    {
        select(TENANT_UID);
    }

    public void selectMinimumTenantUid()
    {
        selectMinimum(TENANT_UID);
    }

    public void selectMaximumTenantUid()
    {
        selectMaximum(TENANT_UID);
    }

    public void groupByTenantUid()
    {
        groupBy(TENANT_UID);
    }

    public MyTenantCriteria joinToTenant()
    {
        return new MyTenantCriteria(joinTo(TENANT));
    }

    public MyTenantCriteria leftJoinToTenant()
    {
        return new MyTenantCriteria(leftJoinTo(TENANT));
    }

    public KmhStringCondition whereTenantUid()
    {
        return new KmhStringCondition(parent(), fullName(TENANT_UID));
    }

    public void whereTenantIs(MyTenant e)
    {
        if ( e == null )
            whereTenantUid().isNull();
        else
            whereTenantUid().is(e.getUid());
    }

    //##################################################
    //# junction :: alias
    //##################################################

    public MyProjectJunction all()
    {
        return addAnd();
    }

    public MyProjectJunction any()
    {
        return addOr();
    }

    public MyProjectJunction none()
    {
        return addNotOr();
    }

    //##################################################
    //# junction :: basic
    //##################################################

    public MyProjectJunction addNotAnd()
    {
        return new MyProjectJunction(parent().addNotAnd());
    }

    public MyProjectJunction addNotOr()
    {
        return new MyProjectJunction(parent().addNotOr());
    }

    public MyProjectJunction addAnd()
    {
        return new MyProjectJunction(parent().addAnd());
    }

    public MyProjectJunction addOr()
    {
        return new MyProjectJunction(parent().addOr());
    }
}
