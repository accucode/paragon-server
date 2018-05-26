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

public class MyTenantCriteria
    extends MyAbstractCriteria<MyTenant>
    implements MyTenantDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyTenantCriteria(KmhCriteria parent)
    {
        super(parent);
    }

    //##################################################
    //# primary key
    //##################################################

    public void whereUidIs(MyTenant e)
    {
        whereUid().is(e.getUid());
    }

    public void whereUidIsNot(MyTenant e)
    {
        whereUid().isNot(e.getUid());
    }

    //##################################################
    //# properties
    //##################################################

    public KmhPropertyCondition<KmDayFrequency> whereBusinessDays()
    {
        return new KmhPropertyCondition<>(context(), alias(), BUSINESS_DAYS);
    }

    public KmhTimeCondition whereBusinessEndTime()
    {
        return new KmhTimeCondition(context(), alias(), BUSINESS_END_TIME);
    }

    public KmhTimeCondition whereBusinessStartTime()
    {
        return new KmhTimeCondition(context(), alias(), BUSINESS_START_TIME);
    }

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), CREATED_UTC_TS);
    }

    public KmhStringCondition whereHostname()
    {
        return new KmhStringCondition(context(), alias(), HOSTNAME);
    }

    public KmhStringCondition whereMemo()
    {
        return new KmhStringCondition(context(), alias(), MEMO);
    }

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), alias(), NAME);
    }

    public KmhStringCondition whereThemeCode()
    {
        return new KmhStringCondition(context(), alias(), THEME_CODE);
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

    public void sortOnHostname()
    {
        parent().sortAscending(HOSTNAME);
    }

    public void sortOnHostnameDescending()
    {
        parent().sortDescending(HOSTNAME);
    }

    public void sortOnHostname(boolean asc)
    {
        if ( asc )
            sortOnHostname();
        else
            sortOnHostnameDescending();
    }

    public void sortOnMemo()
    {
        parent().sortAscending(MEMO);
    }

    public void sortOnMemoDescending()
    {
        parent().sortDescending(MEMO);
    }

    public void sortOnMemo(boolean asc)
    {
        if ( asc )
            sortOnMemo();
        else
            sortOnMemoDescending();
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

    public void sortOnThemeCode()
    {
        parent().sortAscending(THEME_CODE);
    }

    public void sortOnThemeCodeDescending()
    {
        parent().sortDescending(THEME_CODE);
    }

    public void sortOnThemeCode(boolean asc)
    {
        if ( asc )
            sortOnThemeCode();
        else
            sortOnThemeCodeDescending();
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
    //# projections (hostname)
    //##################################################

    public void selectHostname()
    {
        select(HOSTNAME);
    }

    public void selectDistinctHostname()
    {
        selectDistinct(HOSTNAME);
    }

    public void selectCountDistinctHostname()
    {
        selectCountDistinct(HOSTNAME);
    }

    public void selectMinimumHostname()
    {
        selectMinimum(HOSTNAME);
    }

    public void selectMaximumHostname()
    {
        selectMaximum(HOSTNAME);
    }

    public void selectAverageHostname()
    {
        selectAverage(HOSTNAME);
    }

    public void selectSumHostname()
    {
        selectSum(HOSTNAME);
    }

    public void groupByHostname()
    {
        groupBy(HOSTNAME);
    }

    //##################################################
    //# projections (memo)
    //##################################################

    public void selectMemo()
    {
        select(MEMO);
    }

    public void selectDistinctMemo()
    {
        selectDistinct(MEMO);
    }

    public void selectCountDistinctMemo()
    {
        selectCountDistinct(MEMO);
    }

    public void selectMinimumMemo()
    {
        selectMinimum(MEMO);
    }

    public void selectMaximumMemo()
    {
        selectMaximum(MEMO);
    }

    public void selectAverageMemo()
    {
        selectAverage(MEMO);
    }

    public void selectSumMemo()
    {
        selectSum(MEMO);
    }

    public void groupByMemo()
    {
        groupBy(MEMO);
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
    //# projections (themeCode)
    //##################################################

    public void selectThemeCode()
    {
        select(THEME_CODE);
    }

    public void selectDistinctThemeCode()
    {
        selectDistinct(THEME_CODE);
    }

    public void selectCountDistinctThemeCode()
    {
        selectCountDistinct(THEME_CODE);
    }

    public void selectMinimumThemeCode()
    {
        selectMinimum(THEME_CODE);
    }

    public void selectMaximumThemeCode()
    {
        selectMaximum(THEME_CODE);
    }

    public void selectAverageThemeCode()
    {
        selectAverage(THEME_CODE);
    }

    public void selectSumThemeCode()
    {
        selectSum(THEME_CODE);
    }

    public void groupByThemeCode()
    {
        groupBy(THEME_CODE);
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
    //# collection (Projects)
    //##################################################

    public MyProjectCriteria joinToProjects()
    {
        return new MyProjectCriteria(joinTo(PROJECTS));
    }

    public MyProjectCriteria leftJoinToProjects()
    {
        return new MyProjectCriteria(leftJoinTo(PROJECTS));
    }

    //##################################################
    //# collection (Users)
    //##################################################

    public MyUserCriteria joinToUsers()
    {
        return new MyUserCriteria(joinTo(USERS));
    }

    public MyUserCriteria leftJoinToUsers()
    {
        return new MyUserCriteria(leftJoinTo(USERS));
    }

    //##################################################
    //# junction :: alias
    //##################################################

    public MyTenantJunction all()
    {
        return addAnd();
    }

    public MyTenantJunction any()
    {
        return addOr();
    }

    public MyTenantJunction none()
    {
        return addNotOr();
    }

    //##################################################
    //# junction :: basic
    //##################################################

    public MyTenantJunction addNotAnd()
    {
        return new MyTenantJunction(parent().addNotAnd());
    }

    public MyTenantJunction addNotOr()
    {
        return new MyTenantJunction(parent().addNotOr());
    }

    public MyTenantJunction addAnd()
    {
        return new MyTenantJunction(parent().addAnd());
    }

    public MyTenantJunction addOr()
    {
        return new MyTenantJunction(parent().addOr());
    }
}
