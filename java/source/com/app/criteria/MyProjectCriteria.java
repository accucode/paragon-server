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
    //# primary key
    //##################################################

    public void whereUidIs(MyProject e)
    {
        whereUid().is(e.getUid());
    }

    public void whereUidIsNot(MyProject e)
    {
        whereUid().isNot(e.getUid());
    }

    //##################################################
    //# properties
    //##################################################

    public KmhBooleanCondition whereAutoSiteNumberEnabled()
    {
        return new KmhBooleanCondition(context(), alias(), AUTO_SITE_NUMBER_ENABLED);
    }

    public KmhIntegerCondition whereAutoSiteNumberPadding()
    {
        return new KmhIntegerCondition(context(), alias(), AUTO_SITE_NUMBER_PADDING);
    }

    public KmhStringCondition whereAutoSiteNumberPrefix()
    {
        return new KmhStringCondition(context(), alias(), AUTO_SITE_NUMBER_PREFIX);
    }

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

    public KmhStringCondition whereCode()
    {
        return new KmhStringCondition(context(), alias(), CODE);
    }

    public KmhStringCondition whereCompanyName()
    {
        return new KmhStringCondition(context(), alias(), COMPANY_NAME);
    }

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), CREATED_UTC_TS);
    }

    public KmhStringCondition whereDescription()
    {
        return new KmhStringCondition(context(), alias(), DESCRIPTION);
    }

    public KmhBooleanCondition whereEnabled()
    {
        return new KmhBooleanCondition(context(), alias(), ENABLED);
    }

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), alias(), NAME);
    }

    public KmhIntegerCondition whereNextAutoSiteNumber()
    {
        return new KmhIntegerCondition(context(), alias(), NEXT_AUTO_SITE_NUMBER);
    }

    public KmhStringCondition whereSendEmailFrom()
    {
        return new KmhStringCondition(context(), alias(), SEND_EMAIL_FROM);
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

    public void sortOnAutoSiteNumberEnabled()
    {
        parent().sortAscending(AUTO_SITE_NUMBER_ENABLED);
    }

    public void sortOnAutoSiteNumberEnabledDescending()
    {
        parent().sortDescending(AUTO_SITE_NUMBER_ENABLED);
    }

    public void sortOnAutoSiteNumberEnabled(boolean asc)
    {
        if ( asc )
            sortOnAutoSiteNumberEnabled();
        else
            sortOnAutoSiteNumberEnabledDescending();
    }

    public void sortOnAutoSiteNumberPadding()
    {
        parent().sortAscending(AUTO_SITE_NUMBER_PADDING);
    }

    public void sortOnAutoSiteNumberPaddingDescending()
    {
        parent().sortDescending(AUTO_SITE_NUMBER_PADDING);
    }

    public void sortOnAutoSiteNumberPadding(boolean asc)
    {
        if ( asc )
            sortOnAutoSiteNumberPadding();
        else
            sortOnAutoSiteNumberPaddingDescending();
    }

    public void sortOnAutoSiteNumberPrefix()
    {
        parent().sortAscending(AUTO_SITE_NUMBER_PREFIX);
    }

    public void sortOnAutoSiteNumberPrefixDescending()
    {
        parent().sortDescending(AUTO_SITE_NUMBER_PREFIX);
    }

    public void sortOnAutoSiteNumberPrefix(boolean asc)
    {
        if ( asc )
            sortOnAutoSiteNumberPrefix();
        else
            sortOnAutoSiteNumberPrefixDescending();
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

    public void sortOnNextAutoSiteNumber()
    {
        parent().sortAscending(NEXT_AUTO_SITE_NUMBER);
    }

    public void sortOnNextAutoSiteNumberDescending()
    {
        parent().sortDescending(NEXT_AUTO_SITE_NUMBER);
    }

    public void sortOnNextAutoSiteNumber(boolean asc)
    {
        if ( asc )
            sortOnNextAutoSiteNumber();
        else
            sortOnNextAutoSiteNumberDescending();
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
    //# projections (autoSiteNumberEnabled)
    //##################################################

    public void selectAutoSiteNumberEnabled()
    {
        select(AUTO_SITE_NUMBER_ENABLED);
    }

    public void selectDistinctAutoSiteNumberEnabled()
    {
        selectDistinct(AUTO_SITE_NUMBER_ENABLED);
    }

    public void selectCountDistinctAutoSiteNumberEnabled()
    {
        selectCountDistinct(AUTO_SITE_NUMBER_ENABLED);
    }

    public void selectMinimumAutoSiteNumberEnabled()
    {
        selectMinimum(AUTO_SITE_NUMBER_ENABLED);
    }

    public void selectMaximumAutoSiteNumberEnabled()
    {
        selectMaximum(AUTO_SITE_NUMBER_ENABLED);
    }

    public void selectAverageAutoSiteNumberEnabled()
    {
        selectAverage(AUTO_SITE_NUMBER_ENABLED);
    }

    public void selectSumAutoSiteNumberEnabled()
    {
        selectSum(AUTO_SITE_NUMBER_ENABLED);
    }

    public void groupByAutoSiteNumberEnabled()
    {
        groupBy(AUTO_SITE_NUMBER_ENABLED);
    }

    //##################################################
    //# projections (autoSiteNumberPadding)
    //##################################################

    public void selectAutoSiteNumberPadding()
    {
        select(AUTO_SITE_NUMBER_PADDING);
    }

    public void selectDistinctAutoSiteNumberPadding()
    {
        selectDistinct(AUTO_SITE_NUMBER_PADDING);
    }

    public void selectCountDistinctAutoSiteNumberPadding()
    {
        selectCountDistinct(AUTO_SITE_NUMBER_PADDING);
    }

    public void selectMinimumAutoSiteNumberPadding()
    {
        selectMinimum(AUTO_SITE_NUMBER_PADDING);
    }

    public void selectMaximumAutoSiteNumberPadding()
    {
        selectMaximum(AUTO_SITE_NUMBER_PADDING);
    }

    public void selectAverageAutoSiteNumberPadding()
    {
        selectAverage(AUTO_SITE_NUMBER_PADDING);
    }

    public void selectSumAutoSiteNumberPadding()
    {
        selectSum(AUTO_SITE_NUMBER_PADDING);
    }

    public void groupByAutoSiteNumberPadding()
    {
        groupBy(AUTO_SITE_NUMBER_PADDING);
    }

    //##################################################
    //# projections (autoSiteNumberPrefix)
    //##################################################

    public void selectAutoSiteNumberPrefix()
    {
        select(AUTO_SITE_NUMBER_PREFIX);
    }

    public void selectDistinctAutoSiteNumberPrefix()
    {
        selectDistinct(AUTO_SITE_NUMBER_PREFIX);
    }

    public void selectCountDistinctAutoSiteNumberPrefix()
    {
        selectCountDistinct(AUTO_SITE_NUMBER_PREFIX);
    }

    public void selectMinimumAutoSiteNumberPrefix()
    {
        selectMinimum(AUTO_SITE_NUMBER_PREFIX);
    }

    public void selectMaximumAutoSiteNumberPrefix()
    {
        selectMaximum(AUTO_SITE_NUMBER_PREFIX);
    }

    public void selectAverageAutoSiteNumberPrefix()
    {
        selectAverage(AUTO_SITE_NUMBER_PREFIX);
    }

    public void selectSumAutoSiteNumberPrefix()
    {
        selectSum(AUTO_SITE_NUMBER_PREFIX);
    }

    public void groupByAutoSiteNumberPrefix()
    {
        groupBy(AUTO_SITE_NUMBER_PREFIX);
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
    //# projections (nextAutoSiteNumber)
    //##################################################

    public void selectNextAutoSiteNumber()
    {
        select(NEXT_AUTO_SITE_NUMBER);
    }

    public void selectDistinctNextAutoSiteNumber()
    {
        selectDistinct(NEXT_AUTO_SITE_NUMBER);
    }

    public void selectCountDistinctNextAutoSiteNumber()
    {
        selectCountDistinct(NEXT_AUTO_SITE_NUMBER);
    }

    public void selectMinimumNextAutoSiteNumber()
    {
        selectMinimum(NEXT_AUTO_SITE_NUMBER);
    }

    public void selectMaximumNextAutoSiteNumber()
    {
        selectMaximum(NEXT_AUTO_SITE_NUMBER);
    }

    public void selectAverageNextAutoSiteNumber()
    {
        selectAverage(NEXT_AUTO_SITE_NUMBER);
    }

    public void selectSumNextAutoSiteNumber()
    {
        selectSum(NEXT_AUTO_SITE_NUMBER);
    }

    public void groupByNextAutoSiteNumber()
    {
        groupBy(NEXT_AUTO_SITE_NUMBER);
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
    //# association (DefaultPriority)
    //##################################################

    public void selectDefaultPriorityUid()
    {
        select(DEFAULT_PRIORITY_UID);
    }

    public void selectCountDistinctDefaultPriorityUid()
    {
        selectCountDistinct(DEFAULT_PRIORITY_UID);
    }
    
    public void selectDistinctDefaultPriorityUid()
    {
        selectDistinct(DEFAULT_PRIORITY_UID);
    }

    public void selectMinimumDefaultPriorityUid()
    {
        selectMinimum(DEFAULT_PRIORITY_UID);
    }

    public void selectMaximumDefaultPriorityUid()
    {
        selectMaximum(DEFAULT_PRIORITY_UID);
    }

    public void groupByDefaultPriorityUid()
    {
        groupBy(DEFAULT_PRIORITY_UID);
    }

    public MyPriorityCriteria joinToDefaultPriority()
    {
        return new MyPriorityCriteria(joinTo(DEFAULT_PRIORITY));
    }

    public MyPriorityCriteria leftJoinToDefaultPriority()
    {
        return new MyPriorityCriteria(leftJoinTo(DEFAULT_PRIORITY));
    }

    public KmhStringCondition whereDefaultPriorityUid()
    {
        return new KmhStringCondition(parent(), alias(), DEFAULT_PRIORITY_UID);
    }

    public void whereDefaultPriorityIs(MyPriority e)
    {
        if ( e == null )
            whereDefaultPriorityUid().isNull();
        else
            whereDefaultPriorityUid().is(e.getUid());
    }

    public void whereDefaultPriorityIsNot(MyPriority e)
    {
        if ( e == null )
            whereDefaultPriorityUid().isNotNull();
        else
            whereDefaultPriorityUid().isNot(e.getUid());
    }

    //##################################################
    //# association (Supervisor)
    //##################################################

    public void selectSupervisorUid()
    {
        select(SUPERVISOR_UID);
    }

    public void selectCountDistinctSupervisorUid()
    {
        selectCountDistinct(SUPERVISOR_UID);
    }
    
    public void selectDistinctSupervisorUid()
    {
        selectDistinct(SUPERVISOR_UID);
    }

    public void selectMinimumSupervisorUid()
    {
        selectMinimum(SUPERVISOR_UID);
    }

    public void selectMaximumSupervisorUid()
    {
        selectMaximum(SUPERVISOR_UID);
    }

    public void groupBySupervisorUid()
    {
        groupBy(SUPERVISOR_UID);
    }

    public MyUserCriteria joinToSupervisor()
    {
        return new MyUserCriteria(joinTo(SUPERVISOR));
    }

    public MyUserCriteria leftJoinToSupervisor()
    {
        return new MyUserCriteria(leftJoinTo(SUPERVISOR));
    }

    public KmhStringCondition whereSupervisorUid()
    {
        return new KmhStringCondition(parent(), alias(), SUPERVISOR_UID);
    }

    public void whereSupervisorIs(MyUser e)
    {
        if ( e == null )
            whereSupervisorUid().isNull();
        else
            whereSupervisorUid().is(e.getUid());
    }

    public void whereSupervisorIsNot(MyUser e)
    {
        if ( e == null )
            whereSupervisorUid().isNotNull();
        else
            whereSupervisorUid().isNot(e.getUid());
    }

    //##################################################
    //# association (SupportContact)
    //##################################################

    public void selectSupportContactUid()
    {
        select(SUPPORT_CONTACT_UID);
    }

    public void selectCountDistinctSupportContactUid()
    {
        selectCountDistinct(SUPPORT_CONTACT_UID);
    }
    
    public void selectDistinctSupportContactUid()
    {
        selectDistinct(SUPPORT_CONTACT_UID);
    }

    public void selectMinimumSupportContactUid()
    {
        selectMinimum(SUPPORT_CONTACT_UID);
    }

    public void selectMaximumSupportContactUid()
    {
        selectMaximum(SUPPORT_CONTACT_UID);
    }

    public void groupBySupportContactUid()
    {
        groupBy(SUPPORT_CONTACT_UID);
    }

    public MyProjectContactCriteria joinToSupportContact()
    {
        return new MyProjectContactCriteria(joinTo(SUPPORT_CONTACT));
    }

    public MyProjectContactCriteria leftJoinToSupportContact()
    {
        return new MyProjectContactCriteria(leftJoinTo(SUPPORT_CONTACT));
    }

    public KmhStringCondition whereSupportContactUid()
    {
        return new KmhStringCondition(parent(), alias(), SUPPORT_CONTACT_UID);
    }

    public void whereSupportContactIs(MyProjectContact e)
    {
        if ( e == null )
            whereSupportContactUid().isNull();
        else
            whereSupportContactUid().is(e.getUid());
    }

    public void whereSupportContactIsNot(MyProjectContact e)
    {
        if ( e == null )
            whereSupportContactUid().isNotNull();
        else
            whereSupportContactUid().isNot(e.getUid());
    }

    //##################################################
    //# association (Tenant)
    //##################################################

    public void selectTenantUid()
    {
        select(TENANT_UID);
    }

    public void selectCountDistinctTenantUid()
    {
        selectCountDistinct(TENANT_UID);
    }
    
    public void selectDistinctTenantUid()
    {
        selectDistinct(TENANT_UID);
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
        return new KmhStringCondition(parent(), alias(), TENANT_UID);
    }

    public void whereTenantIs(MyTenant e)
    {
        if ( e == null )
            whereTenantUid().isNull();
        else
            whereTenantUid().is(e.getUid());
    }

    public void whereTenantIsNot(MyTenant e)
    {
        if ( e == null )
            whereTenantUid().isNotNull();
        else
            whereTenantUid().isNot(e.getUid());
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
    //# collection (Blurbs)
    //##################################################

    public MyBlurbCriteria joinToBlurbs()
    {
        return new MyBlurbCriteria(joinTo(BLURBS));
    }

    public MyBlurbCriteria leftJoinToBlurbs()
    {
        return new MyBlurbCriteria(leftJoinTo(BLURBS));
    }

    //##################################################
    //# collection (Contacts)
    //##################################################

    public MyProjectContactCriteria joinToContacts()
    {
        return new MyProjectContactCriteria(joinTo(CONTACTS));
    }

    public MyProjectContactCriteria leftJoinToContacts()
    {
        return new MyProjectContactCriteria(leftJoinTo(CONTACTS));
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
    //# collection (EmailTemplates)
    //##################################################

    public MyEmailTemplateCriteria joinToEmailTemplates()
    {
        return new MyEmailTemplateCriteria(joinTo(EMAIL_TEMPLATES));
    }

    public MyEmailTemplateCriteria leftJoinToEmailTemplates()
    {
        return new MyEmailTemplateCriteria(leftJoinTo(EMAIL_TEMPLATES));
    }

    //##################################################
    //# collection (Holidays)
    //##################################################

    public MyHolidayCriteria joinToHolidays()
    {
        return new MyHolidayCriteria(joinTo(HOLIDAYS));
    }

    public MyHolidayCriteria leftJoinToHolidays()
    {
        return new MyHolidayCriteria(leftJoinTo(HOLIDAYS));
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
