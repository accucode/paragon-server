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

public class MyPriorityCriteria
    extends MyAbstractCriteria<MyPriority>
    implements MyPriorityDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyPriorityCriteria(KmhCriteria parent)
    {
        super(parent);
    }

    //##################################################
    //# primary key
    //##################################################

    public void whereUidIs(MyPriority e)
    {
        whereUid().is(e.getUid());
    }

    public void whereUidIsNot(MyPriority e)
    {
        whereUid().isNot(e.getUid());
    }

    //##################################################
    //# properties
    //##################################################

    public KmhStringCondition whereCategoryCode()
    {
        return new KmhStringCondition(context(), alias(), CATEGORY_CODE);
    }

    public void whereCategoryIs(MyPriorityCategory e)
    {
        if ( e == null )
            whereCategoryCode().isNull();
        else
            whereCategoryCode().is(e.getCode());
    }

    public void whereCategoryIsNot(MyPriorityCategory e)
    {
        if ( e == null )
            whereCategoryCode().isNull();
        else
            whereCategoryCode().isNot(e.getCode());
    }

    public void whereCategoryIsLow()
    {
        whereCategoryIs(MyPriorityCategory.Low);
    }

    public void whereCategoryIsNotLow()
    {
        whereCategoryIsNot(MyPriorityCategory.Low);
    }

    public void whereCategoryIsLow(boolean e)
    {
        if ( e )
            whereCategoryIsLow();
        else
            whereCategoryIsNotLow();
    }

    public void whereCategoryIsNormal()
    {
        whereCategoryIs(MyPriorityCategory.Normal);
    }

    public void whereCategoryIsNotNormal()
    {
        whereCategoryIsNot(MyPriorityCategory.Normal);
    }

    public void whereCategoryIsNormal(boolean e)
    {
        if ( e )
            whereCategoryIsNormal();
        else
            whereCategoryIsNotNormal();
    }

    public void whereCategoryIsHigh()
    {
        whereCategoryIs(MyPriorityCategory.High);
    }

    public void whereCategoryIsNotHigh()
    {
        whereCategoryIsNot(MyPriorityCategory.High);
    }

    public void whereCategoryIsHigh(boolean e)
    {
        if ( e )
            whereCategoryIsHigh();
        else
            whereCategoryIsNotHigh();
    }

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), CREATED_UTC_TS);
    }

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), alias(), NAME);
    }

    public KmhStringCondition whereSequenceCode()
    {
        return new KmhStringCondition(context(), alias(), SEQUENCE_CODE);
    }

    public KmhStringCondition whereUid()
    {
        return new KmhStringCondition(context(), alias(), UID);
    }

    public KmhTimestampCondition whereUpdatedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), UPDATED_UTC_TS);
    }

    //##################################################
    //# sorts
    //##################################################

    public void sortOnCategoryCode()
    {
        parent().sortAscending(CATEGORY_CODE);
    }

    public void sortOnCategoryCodeDescending()
    {
        parent().sortDescending(CATEGORY_CODE);
    }

    public void sortOnCategoryCode(boolean asc)
    {
        if ( asc )
            sortOnCategoryCode();
        else
            sortOnCategoryCodeDescending();
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

    public void sortOnSequenceCode()
    {
        parent().sortAscending(SEQUENCE_CODE);
    }

    public void sortOnSequenceCodeDescending()
    {
        parent().sortDescending(SEQUENCE_CODE);
    }

    public void sortOnSequenceCode(boolean asc)
    {
        if ( asc )
            sortOnSequenceCode();
        else
            sortOnSequenceCodeDescending();
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

    //##################################################
    //# projections (categoryCode)
    //##################################################

    public void selectCategoryCode()
    {
        select(CATEGORY_CODE);
    }

    public void selectDistinctCategoryCode()
    {
        selectDistinct(CATEGORY_CODE);
    }

    public void selectCountDistinctCategoryCode()
    {
        selectCountDistinct(CATEGORY_CODE);
    }

    public void selectMinimumCategoryCode()
    {
        selectMinimum(CATEGORY_CODE);
    }

    public void selectMaximumCategoryCode()
    {
        selectMaximum(CATEGORY_CODE);
    }

    public void selectAverageCategoryCode()
    {
        selectAverage(CATEGORY_CODE);
    }

    public void selectSumCategoryCode()
    {
        selectSum(CATEGORY_CODE);
    }

    public void groupByCategoryCode()
    {
        groupBy(CATEGORY_CODE);
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
    //# projections (sequenceCode)
    //##################################################

    public void selectSequenceCode()
    {
        select(SEQUENCE_CODE);
    }

    public void selectDistinctSequenceCode()
    {
        selectDistinct(SEQUENCE_CODE);
    }

    public void selectCountDistinctSequenceCode()
    {
        selectCountDistinct(SEQUENCE_CODE);
    }

    public void selectMinimumSequenceCode()
    {
        selectMinimum(SEQUENCE_CODE);
    }

    public void selectMaximumSequenceCode()
    {
        selectMaximum(SEQUENCE_CODE);
    }

    public void selectAverageSequenceCode()
    {
        selectAverage(SEQUENCE_CODE);
    }

    public void selectSumSequenceCode()
    {
        selectSum(SEQUENCE_CODE);
    }

    public void groupBySequenceCode()
    {
        groupBy(SEQUENCE_CODE);
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
    //# junction :: alias
    //##################################################

    public MyPriorityJunction all()
    {
        return addAnd();
    }

    public MyPriorityJunction any()
    {
        return addOr();
    }

    public MyPriorityJunction none()
    {
        return addNotOr();
    }

    //##################################################
    //# junction :: basic
    //##################################################

    public MyPriorityJunction addNotAnd()
    {
        return new MyPriorityJunction(parent().addNotAnd());
    }

    public MyPriorityJunction addNotOr()
    {
        return new MyPriorityJunction(parent().addNotOr());
    }

    public MyPriorityJunction addAnd()
    {
        return new MyPriorityJunction(parent().addAnd());
    }

    public MyPriorityJunction addOr()
    {
        return new MyPriorityJunction(parent().addOr());
    }
}
