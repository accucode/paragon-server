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

public class MyFilterTemplateCriteria
    extends MyAbstractCriteria<MyFilterTemplate>
    implements MyFilterTemplateDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyFilterTemplateCriteria(KmhCriteria parent)
    {
        super(parent);
    }

    //##################################################
    //# primary key
    //##################################################

    public void whereUidIs(MyFilterTemplate e)
    {
        whereUid().is(e.getUid());
    }

    public void whereUidIsNot(MyFilterTemplate e)
    {
        whereUid().isNot(e.getUid());
    }

    //##################################################
    //# properties
    //##################################################

    public KmhStringCondition whereContextTypeCode()
    {
        return new KmhStringCondition(context(), alias(), CONTEXT_TYPE_CODE);
    }

    public void whereContextTypeIs(MyFilterTemplateContextType e)
    {
        if ( e == null )
            whereContextTypeCode().isNull();
        else
            whereContextTypeCode().is(e.getCode());
    }

    public void whereContextTypeIsNot(MyFilterTemplateContextType e)
    {
        if ( e == null )
            whereContextTypeCode().isNull();
        else
            whereContextTypeCode().isNot(e.getCode());
    }

    public void whereContextTypeIsSite()
    {
        whereContextTypeIs(MyFilterTemplateContextType.Site);
    }

    public void whereContextTypeIsNotSite()
    {
        whereContextTypeIsNot(MyFilterTemplateContextType.Site);
    }

    public void whereContextTypeIsSite(boolean e)
    {
        if ( e )
            whereContextTypeIsSite();
        else
            whereContextTypeIsNotSite();
    }

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), CREATED_UTC_TS);
    }

    public KmhBooleanCondition whereDeleted()
    {
        return new KmhBooleanCondition(context(), alias(), DELETED);
    }

    public KmhBooleanCondition whereModified()
    {
        return new KmhBooleanCondition(context(), alias(), MODIFIED);
    }

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), alias(), NAME);
    }

    public KmhBooleanCondition wherePreferred()
    {
        return new KmhBooleanCondition(context(), alias(), PREFERRED);
    }

    public KmhStringCondition whereTypeCode()
    {
        return new KmhStringCondition(context(), alias(), TYPE_CODE);
    }

    public void whereTypeIs(MyFilterTemplateType e)
    {
        if ( e == null )
            whereTypeCode().isNull();
        else
            whereTypeCode().is(e.getCode());
    }

    public void whereTypeIsNot(MyFilterTemplateType e)
    {
        if ( e == null )
            whereTypeCode().isNull();
        else
            whereTypeCode().isNot(e.getCode());
    }

    public void whereTypeIsPredefined()
    {
        whereTypeIs(MyFilterTemplateType.Predefined);
    }

    public void whereTypeIsNotPredefined()
    {
        whereTypeIsNot(MyFilterTemplateType.Predefined);
    }

    public void whereTypeIsPredefined(boolean e)
    {
        if ( e )
            whereTypeIsPredefined();
        else
            whereTypeIsNotPredefined();
    }

    public void whereTypeIsShared()
    {
        whereTypeIs(MyFilterTemplateType.Shared);
    }

    public void whereTypeIsNotShared()
    {
        whereTypeIsNot(MyFilterTemplateType.Shared);
    }

    public void whereTypeIsShared(boolean e)
    {
        if ( e )
            whereTypeIsShared();
        else
            whereTypeIsNotShared();
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

    public void sortOnContextTypeCode()
    {
        parent().sortAscending(CONTEXT_TYPE_CODE);
    }

    public void sortOnContextTypeCodeDescending()
    {
        parent().sortDescending(CONTEXT_TYPE_CODE);
    }

    public void sortOnContextTypeCode(boolean asc)
    {
        if ( asc )
            sortOnContextTypeCode();
        else
            sortOnContextTypeCodeDescending();
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

    public void sortOnDeleted()
    {
        parent().sortAscending(DELETED);
    }

    public void sortOnDeletedDescending()
    {
        parent().sortDescending(DELETED);
    }

    public void sortOnDeleted(boolean asc)
    {
        if ( asc )
            sortOnDeleted();
        else
            sortOnDeletedDescending();
    }

    public void sortOnModified()
    {
        parent().sortAscending(MODIFIED);
    }

    public void sortOnModifiedDescending()
    {
        parent().sortDescending(MODIFIED);
    }

    public void sortOnModified(boolean asc)
    {
        if ( asc )
            sortOnModified();
        else
            sortOnModifiedDescending();
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

    public void sortOnPreferred()
    {
        parent().sortAscending(PREFERRED);
    }

    public void sortOnPreferredDescending()
    {
        parent().sortDescending(PREFERRED);
    }

    public void sortOnPreferred(boolean asc)
    {
        if ( asc )
            sortOnPreferred();
        else
            sortOnPreferredDescending();
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
    //# projections (contextTypeCode)
    //##################################################

    public void selectContextTypeCode()
    {
        select(CONTEXT_TYPE_CODE);
    }

    public void selectDistinctContextTypeCode()
    {
        selectDistinct(CONTEXT_TYPE_CODE);
    }

    public void selectCountDistinctContextTypeCode()
    {
        selectCountDistinct(CONTEXT_TYPE_CODE);
    }

    public void selectMinimumContextTypeCode()
    {
        selectMinimum(CONTEXT_TYPE_CODE);
    }

    public void selectMaximumContextTypeCode()
    {
        selectMaximum(CONTEXT_TYPE_CODE);
    }

    public void selectAverageContextTypeCode()
    {
        selectAverage(CONTEXT_TYPE_CODE);
    }

    public void selectSumContextTypeCode()
    {
        selectSum(CONTEXT_TYPE_CODE);
    }

    public void groupByContextTypeCode()
    {
        groupBy(CONTEXT_TYPE_CODE);
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
    //# projections (deleted)
    //##################################################

    public void selectDeleted()
    {
        select(DELETED);
    }

    public void selectDistinctDeleted()
    {
        selectDistinct(DELETED);
    }

    public void selectCountDistinctDeleted()
    {
        selectCountDistinct(DELETED);
    }

    public void selectMinimumDeleted()
    {
        selectMinimum(DELETED);
    }

    public void selectMaximumDeleted()
    {
        selectMaximum(DELETED);
    }

    public void selectAverageDeleted()
    {
        selectAverage(DELETED);
    }

    public void selectSumDeleted()
    {
        selectSum(DELETED);
    }

    public void groupByDeleted()
    {
        groupBy(DELETED);
    }

    //##################################################
    //# projections (modified)
    //##################################################

    public void selectModified()
    {
        select(MODIFIED);
    }

    public void selectDistinctModified()
    {
        selectDistinct(MODIFIED);
    }

    public void selectCountDistinctModified()
    {
        selectCountDistinct(MODIFIED);
    }

    public void selectMinimumModified()
    {
        selectMinimum(MODIFIED);
    }

    public void selectMaximumModified()
    {
        selectMaximum(MODIFIED);
    }

    public void selectAverageModified()
    {
        selectAverage(MODIFIED);
    }

    public void selectSumModified()
    {
        selectSum(MODIFIED);
    }

    public void groupByModified()
    {
        groupBy(MODIFIED);
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
    //# projections (preferred)
    //##################################################

    public void selectPreferred()
    {
        select(PREFERRED);
    }

    public void selectDistinctPreferred()
    {
        selectDistinct(PREFERRED);
    }

    public void selectCountDistinctPreferred()
    {
        selectCountDistinct(PREFERRED);
    }

    public void selectMinimumPreferred()
    {
        selectMinimum(PREFERRED);
    }

    public void selectMaximumPreferred()
    {
        selectMaximum(PREFERRED);
    }

    public void selectAveragePreferred()
    {
        selectAverage(PREFERRED);
    }

    public void selectSumPreferred()
    {
        selectSum(PREFERRED);
    }

    public void groupByPreferred()
    {
        groupBy(PREFERRED);
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
    //# collection (Items)
    //##################################################

    public MyFilterTemplateItemCriteria joinToItems()
    {
        return new MyFilterTemplateItemCriteria(joinTo(ITEMS));
    }

    public MyFilterTemplateItemCriteria leftJoinToItems()
    {
        return new MyFilterTemplateItemCriteria(leftJoinTo(ITEMS));
    }

    //##################################################
    //# junction :: alias
    //##################################################

    public MyFilterTemplateJunction all()
    {
        return addAnd();
    }

    public MyFilterTemplateJunction any()
    {
        return addOr();
    }

    public MyFilterTemplateJunction none()
    {
        return addNotOr();
    }

    //##################################################
    //# junction :: basic
    //##################################################

    public MyFilterTemplateJunction addNotAnd()
    {
        return new MyFilterTemplateJunction(parent().addNotAnd());
    }

    public MyFilterTemplateJunction addNotOr()
    {
        return new MyFilterTemplateJunction(parent().addNotOr());
    }

    public MyFilterTemplateJunction addAnd()
    {
        return new MyFilterTemplateJunction(parent().addAnd());
    }

    public MyFilterTemplateJunction addOr()
    {
        return new MyFilterTemplateJunction(parent().addOr());
    }
}
