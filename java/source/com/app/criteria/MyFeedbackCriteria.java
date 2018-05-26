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

public class MyFeedbackCriteria
    extends MyAbstractCriteria<MyFeedback>
    implements MyFeedbackDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyFeedbackCriteria(KmhCriteria parent)
    {
        super(parent);
    }

    //##################################################
    //# primary key
    //##################################################

    public void whereUidIs(MyFeedback e)
    {
        whereUid().is(e.getUid());
    }

    public void whereUidIsNot(MyFeedback e)
    {
        whereUid().isNot(e.getUid());
    }

    //##################################################
    //# properties
    //##################################################

    public KmhDateCondition whereClosedDate()
    {
        return new KmhDateCondition(context(), alias(), CLOSED_DATE);
    }

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), CREATED_UTC_TS);
    }

    public KmhStringCondition whereDescription()
    {
        return new KmhStringCondition(context(), alias(), DESCRIPTION);
    }

    public KmhStringCondition whereNotes()
    {
        return new KmhStringCondition(context(), alias(), NOTES);
    }

    public KmhBooleanCondition whereOpen()
    {
        return new KmhBooleanCondition(context(), alias(), OPEN);
    }

    public KmhStringCondition wherePageKey()
    {
        return new KmhStringCondition(context(), alias(), PAGE_KEY);
    }

    public KmhStringCondition whereQueryString()
    {
        return new KmhStringCondition(context(), alias(), QUERY_STRING);
    }

    public KmhStringCondition whereRequestUrl()
    {
        return new KmhStringCondition(context(), alias(), REQUEST_URL);
    }

    public KmhStringCondition whereStatusCode()
    {
        return new KmhStringCondition(context(), alias(), STATUS_CODE);
    }

    public void whereStatusIs(MyFeedbackStatus e)
    {
        if ( e == null )
            whereStatusCode().isNull();
        else
            whereStatusCode().is(e.getCode());
    }

    public void whereStatusIsNot(MyFeedbackStatus e)
    {
        if ( e == null )
            whereStatusCode().isNull();
        else
            whereStatusCode().isNot(e.getCode());
    }

    public void whereStatusIsPending()
    {
        whereStatusIs(MyFeedbackStatus.Pending);
    }

    public void whereStatusIsNotPending()
    {
        whereStatusIsNot(MyFeedbackStatus.Pending);
    }

    public void whereStatusIsPending(boolean e)
    {
        if ( e )
            whereStatusIsPending();
        else
            whereStatusIsNotPending();
    }

    public void whereStatusIsResolved()
    {
        whereStatusIs(MyFeedbackStatus.Resolved);
    }

    public void whereStatusIsNotResolved()
    {
        whereStatusIsNot(MyFeedbackStatus.Resolved);
    }

    public void whereStatusIsResolved(boolean e)
    {
        if ( e )
            whereStatusIsResolved();
        else
            whereStatusIsNotResolved();
    }

    public void whereStatusIsDropped()
    {
        whereStatusIs(MyFeedbackStatus.Dropped);
    }

    public void whereStatusIsNotDropped()
    {
        whereStatusIsNot(MyFeedbackStatus.Dropped);
    }

    public void whereStatusIsDropped(boolean e)
    {
        if ( e )
            whereStatusIsDropped();
        else
            whereStatusIsNotDropped();
    }

    public KmhStringCondition whereTypeCode()
    {
        return new KmhStringCondition(context(), alias(), TYPE_CODE);
    }

    public void whereTypeIs(MyFeedbackType e)
    {
        if ( e == null )
            whereTypeCode().isNull();
        else
            whereTypeCode().is(e.getCode());
    }

    public void whereTypeIsNot(MyFeedbackType e)
    {
        if ( e == null )
            whereTypeCode().isNull();
        else
            whereTypeCode().isNot(e.getCode());
    }

    public void whereTypeIsBug()
    {
        whereTypeIs(MyFeedbackType.Bug);
    }

    public void whereTypeIsNotBug()
    {
        whereTypeIsNot(MyFeedbackType.Bug);
    }

    public void whereTypeIsBug(boolean e)
    {
        if ( e )
            whereTypeIsBug();
        else
            whereTypeIsNotBug();
    }

    public void whereTypeIsCosmetic()
    {
        whereTypeIs(MyFeedbackType.Cosmetic);
    }

    public void whereTypeIsNotCosmetic()
    {
        whereTypeIsNot(MyFeedbackType.Cosmetic);
    }

    public void whereTypeIsCosmetic(boolean e)
    {
        if ( e )
            whereTypeIsCosmetic();
        else
            whereTypeIsNotCosmetic();
    }

    public void whereTypeIsEnhancement()
    {
        whereTypeIs(MyFeedbackType.Enhancement);
    }

    public void whereTypeIsNotEnhancement()
    {
        whereTypeIsNot(MyFeedbackType.Enhancement);
    }

    public void whereTypeIsEnhancement(boolean e)
    {
        if ( e )
            whereTypeIsEnhancement();
        else
            whereTypeIsNotEnhancement();
    }

    public void whereTypeIsDuplicate()
    {
        whereTypeIs(MyFeedbackType.Duplicate);
    }

    public void whereTypeIsNotDuplicate()
    {
        whereTypeIsNot(MyFeedbackType.Duplicate);
    }

    public void whereTypeIsDuplicate(boolean e)
    {
        if ( e )
            whereTypeIsDuplicate();
        else
            whereTypeIsNotDuplicate();
    }

    public KmhStringCondition whereUid()
    {
        return new KmhStringCondition(context(), alias(), UID);
    }

    public KmhTimestampCondition whereUpdatedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), UPDATED_UTC_TS);
    }

    public KmhStringCondition whereWindowLocation()
    {
        return new KmhStringCondition(context(), alias(), WINDOW_LOCATION);
    }

    //##################################################
    //# sorts
    //##################################################

    public void sortOnClosedDate()
    {
        parent().sortAscending(CLOSED_DATE);
    }

    public void sortOnClosedDateDescending()
    {
        parent().sortDescending(CLOSED_DATE);
    }

    public void sortOnClosedDate(boolean asc)
    {
        if ( asc )
            sortOnClosedDate();
        else
            sortOnClosedDateDescending();
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

    public void sortOnNotes()
    {
        parent().sortAscending(NOTES);
    }

    public void sortOnNotesDescending()
    {
        parent().sortDescending(NOTES);
    }

    public void sortOnNotes(boolean asc)
    {
        if ( asc )
            sortOnNotes();
        else
            sortOnNotesDescending();
    }

    public void sortOnOpen()
    {
        parent().sortAscending(OPEN);
    }

    public void sortOnOpenDescending()
    {
        parent().sortDescending(OPEN);
    }

    public void sortOnOpen(boolean asc)
    {
        if ( asc )
            sortOnOpen();
        else
            sortOnOpenDescending();
    }

    public void sortOnPageKey()
    {
        parent().sortAscending(PAGE_KEY);
    }

    public void sortOnPageKeyDescending()
    {
        parent().sortDescending(PAGE_KEY);
    }

    public void sortOnPageKey(boolean asc)
    {
        if ( asc )
            sortOnPageKey();
        else
            sortOnPageKeyDescending();
    }

    public void sortOnQueryString()
    {
        parent().sortAscending(QUERY_STRING);
    }

    public void sortOnQueryStringDescending()
    {
        parent().sortDescending(QUERY_STRING);
    }

    public void sortOnQueryString(boolean asc)
    {
        if ( asc )
            sortOnQueryString();
        else
            sortOnQueryStringDescending();
    }

    public void sortOnRequestUrl()
    {
        parent().sortAscending(REQUEST_URL);
    }

    public void sortOnRequestUrlDescending()
    {
        parent().sortDescending(REQUEST_URL);
    }

    public void sortOnRequestUrl(boolean asc)
    {
        if ( asc )
            sortOnRequestUrl();
        else
            sortOnRequestUrlDescending();
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

    public void sortOnTypeCode()
    {
        parent().sortAscending(TYPE_CODE);
    }

    public void sortOnTypeCodeDescending()
    {
        parent().sortDescending(TYPE_CODE);
    }

    public void sortOnTypeCode(boolean asc)
    {
        if ( asc )
            sortOnTypeCode();
        else
            sortOnTypeCodeDescending();
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

    public void sortOnWindowLocation()
    {
        parent().sortAscending(WINDOW_LOCATION);
    }

    public void sortOnWindowLocationDescending()
    {
        parent().sortDescending(WINDOW_LOCATION);
    }

    public void sortOnWindowLocation(boolean asc)
    {
        if ( asc )
            sortOnWindowLocation();
        else
            sortOnWindowLocationDescending();
    }

    //##################################################
    //# projections (closedDate)
    //##################################################

    public void selectClosedDate()
    {
        select(CLOSED_DATE);
    }

    public void selectDistinctClosedDate()
    {
        selectDistinct(CLOSED_DATE);
    }

    public void selectCountDistinctClosedDate()
    {
        selectCountDistinct(CLOSED_DATE);
    }

    public void selectMinimumClosedDate()
    {
        selectMinimum(CLOSED_DATE);
    }

    public void selectMaximumClosedDate()
    {
        selectMaximum(CLOSED_DATE);
    }

    public void selectAverageClosedDate()
    {
        selectAverage(CLOSED_DATE);
    }

    public void selectSumClosedDate()
    {
        selectSum(CLOSED_DATE);
    }

    public void groupByClosedDate()
    {
        groupBy(CLOSED_DATE);
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
    //# projections (notes)
    //##################################################

    public void selectNotes()
    {
        select(NOTES);
    }

    public void selectDistinctNotes()
    {
        selectDistinct(NOTES);
    }

    public void selectCountDistinctNotes()
    {
        selectCountDistinct(NOTES);
    }

    public void selectMinimumNotes()
    {
        selectMinimum(NOTES);
    }

    public void selectMaximumNotes()
    {
        selectMaximum(NOTES);
    }

    public void selectAverageNotes()
    {
        selectAverage(NOTES);
    }

    public void selectSumNotes()
    {
        selectSum(NOTES);
    }

    public void groupByNotes()
    {
        groupBy(NOTES);
    }

    //##################################################
    //# projections (open)
    //##################################################

    public void selectOpen()
    {
        select(OPEN);
    }

    public void selectDistinctOpen()
    {
        selectDistinct(OPEN);
    }

    public void selectCountDistinctOpen()
    {
        selectCountDistinct(OPEN);
    }

    public void selectMinimumOpen()
    {
        selectMinimum(OPEN);
    }

    public void selectMaximumOpen()
    {
        selectMaximum(OPEN);
    }

    public void selectAverageOpen()
    {
        selectAverage(OPEN);
    }

    public void selectSumOpen()
    {
        selectSum(OPEN);
    }

    public void groupByOpen()
    {
        groupBy(OPEN);
    }

    //##################################################
    //# projections (pageKey)
    //##################################################

    public void selectPageKey()
    {
        select(PAGE_KEY);
    }

    public void selectDistinctPageKey()
    {
        selectDistinct(PAGE_KEY);
    }

    public void selectCountDistinctPageKey()
    {
        selectCountDistinct(PAGE_KEY);
    }

    public void selectMinimumPageKey()
    {
        selectMinimum(PAGE_KEY);
    }

    public void selectMaximumPageKey()
    {
        selectMaximum(PAGE_KEY);
    }

    public void selectAveragePageKey()
    {
        selectAverage(PAGE_KEY);
    }

    public void selectSumPageKey()
    {
        selectSum(PAGE_KEY);
    }

    public void groupByPageKey()
    {
        groupBy(PAGE_KEY);
    }

    //##################################################
    //# projections (queryString)
    //##################################################

    public void selectQueryString()
    {
        select(QUERY_STRING);
    }

    public void selectDistinctQueryString()
    {
        selectDistinct(QUERY_STRING);
    }

    public void selectCountDistinctQueryString()
    {
        selectCountDistinct(QUERY_STRING);
    }

    public void selectMinimumQueryString()
    {
        selectMinimum(QUERY_STRING);
    }

    public void selectMaximumQueryString()
    {
        selectMaximum(QUERY_STRING);
    }

    public void selectAverageQueryString()
    {
        selectAverage(QUERY_STRING);
    }

    public void selectSumQueryString()
    {
        selectSum(QUERY_STRING);
    }

    public void groupByQueryString()
    {
        groupBy(QUERY_STRING);
    }

    //##################################################
    //# projections (requestUrl)
    //##################################################

    public void selectRequestUrl()
    {
        select(REQUEST_URL);
    }

    public void selectDistinctRequestUrl()
    {
        selectDistinct(REQUEST_URL);
    }

    public void selectCountDistinctRequestUrl()
    {
        selectCountDistinct(REQUEST_URL);
    }

    public void selectMinimumRequestUrl()
    {
        selectMinimum(REQUEST_URL);
    }

    public void selectMaximumRequestUrl()
    {
        selectMaximum(REQUEST_URL);
    }

    public void selectAverageRequestUrl()
    {
        selectAverage(REQUEST_URL);
    }

    public void selectSumRequestUrl()
    {
        selectSum(REQUEST_URL);
    }

    public void groupByRequestUrl()
    {
        groupBy(REQUEST_URL);
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
    //# projections (typeCode)
    //##################################################

    public void selectTypeCode()
    {
        select(TYPE_CODE);
    }

    public void selectDistinctTypeCode()
    {
        selectDistinct(TYPE_CODE);
    }

    public void selectCountDistinctTypeCode()
    {
        selectCountDistinct(TYPE_CODE);
    }

    public void selectMinimumTypeCode()
    {
        selectMinimum(TYPE_CODE);
    }

    public void selectMaximumTypeCode()
    {
        selectMaximum(TYPE_CODE);
    }

    public void selectAverageTypeCode()
    {
        selectAverage(TYPE_CODE);
    }

    public void selectSumTypeCode()
    {
        selectSum(TYPE_CODE);
    }

    public void groupByTypeCode()
    {
        groupBy(TYPE_CODE);
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
    //# projections (windowLocation)
    //##################################################

    public void selectWindowLocation()
    {
        select(WINDOW_LOCATION);
    }

    public void selectDistinctWindowLocation()
    {
        selectDistinct(WINDOW_LOCATION);
    }

    public void selectCountDistinctWindowLocation()
    {
        selectCountDistinct(WINDOW_LOCATION);
    }

    public void selectMinimumWindowLocation()
    {
        selectMinimum(WINDOW_LOCATION);
    }

    public void selectMaximumWindowLocation()
    {
        selectMaximum(WINDOW_LOCATION);
    }

    public void selectAverageWindowLocation()
    {
        selectAverage(WINDOW_LOCATION);
    }

    public void selectSumWindowLocation()
    {
        selectSum(WINDOW_LOCATION);
    }

    public void groupByWindowLocation()
    {
        groupBy(WINDOW_LOCATION);
    }

    //##################################################
    //# association (ClosedBy)
    //##################################################

    public void selectClosedByUid()
    {
        select(CLOSED_BY_UID);
    }

    public void selectCountDistinctClosedByUid()
    {
        selectCountDistinct(CLOSED_BY_UID);
    }
    
    public void selectDistinctClosedByUid()
    {
        selectDistinct(CLOSED_BY_UID);
    }

    public void selectMinimumClosedByUid()
    {
        selectMinimum(CLOSED_BY_UID);
    }

    public void selectMaximumClosedByUid()
    {
        selectMaximum(CLOSED_BY_UID);
    }

    public void groupByClosedByUid()
    {
        groupBy(CLOSED_BY_UID);
    }

    public MyUserCriteria joinToClosedBy()
    {
        return new MyUserCriteria(joinTo(CLOSED_BY));
    }

    public MyUserCriteria leftJoinToClosedBy()
    {
        return new MyUserCriteria(leftJoinTo(CLOSED_BY));
    }

    public KmhStringCondition whereClosedByUid()
    {
        return new KmhStringCondition(parent(), alias(), CLOSED_BY_UID);
    }

    public void whereClosedByIs(MyUser e)
    {
        if ( e == null )
            whereClosedByUid().isNull();
        else
            whereClosedByUid().is(e.getUid());
    }

    public void whereClosedByIsNot(MyUser e)
    {
        if ( e == null )
            whereClosedByUid().isNotNull();
        else
            whereClosedByUid().isNot(e.getUid());
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
    //# junction :: alias
    //##################################################

    public MyFeedbackJunction all()
    {
        return addAnd();
    }

    public MyFeedbackJunction any()
    {
        return addOr();
    }

    public MyFeedbackJunction none()
    {
        return addNotOr();
    }

    //##################################################
    //# junction :: basic
    //##################################################

    public MyFeedbackJunction addNotAnd()
    {
        return new MyFeedbackJunction(parent().addNotAnd());
    }

    public MyFeedbackJunction addNotOr()
    {
        return new MyFeedbackJunction(parent().addNotOr());
    }

    public MyFeedbackJunction addAnd()
    {
        return new MyFeedbackJunction(parent().addAnd());
    }

    public MyFeedbackJunction addOr()
    {
        return new MyFeedbackJunction(parent().addOr());
    }
}
