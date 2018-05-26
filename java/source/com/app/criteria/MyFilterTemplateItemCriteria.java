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

public class MyFilterTemplateItemCriteria
    extends MyAbstractCriteria<MyFilterTemplateItem>
    implements MyFilterTemplateItemDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyFilterTemplateItemCriteria(KmhCriteria parent)
    {
        super(parent);
    }

    //##################################################
    //# primary key
    //##################################################

    public void whereUidIs(MyFilterTemplateItem e)
    {
        whereUid().is(e.getUid());
    }

    public void whereUidIsNot(MyFilterTemplateItem e)
    {
        whereUid().isNot(e.getUid());
    }

    //##################################################
    //# properties
    //##################################################

    public KmhStringCondition whereAttributeCode()
    {
        return new KmhStringCondition(context(), alias(), ATTRIBUTE_CODE);
    }

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), CREATED_UTC_TS);
    }

    public KmhStringCondition whereUid()
    {
        return new KmhStringCondition(context(), alias(), UID);
    }

    public KmhTimestampCondition whereUpdatedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), UPDATED_UTC_TS);
    }

    public KmhBooleanCondition whereUsed()
    {
        return new KmhBooleanCondition(context(), alias(), USED);
    }

    public KmhStringCondition whereValue()
    {
        return new KmhStringCondition(context(), alias(), VALUE);
    }

    public KmhIntegerCondition whereLockVersion()
    {
        return new KmhIntegerCondition(context(), alias(), LOCK_VERSION);
    }

    //##################################################
    //# sorts
    //##################################################

    public void sortOnAttributeCode()
    {
        parent().sortAscending(ATTRIBUTE_CODE);
    }

    public void sortOnAttributeCodeDescending()
    {
        parent().sortDescending(ATTRIBUTE_CODE);
    }

    public void sortOnAttributeCode(boolean asc)
    {
        if ( asc )
            sortOnAttributeCode();
        else
            sortOnAttributeCodeDescending();
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

    public void sortOnUsed()
    {
        parent().sortAscending(USED);
    }

    public void sortOnUsedDescending()
    {
        parent().sortDescending(USED);
    }

    public void sortOnUsed(boolean asc)
    {
        if ( asc )
            sortOnUsed();
        else
            sortOnUsedDescending();
    }

    public void sortOnValue()
    {
        parent().sortAscending(VALUE);
    }

    public void sortOnValueDescending()
    {
        parent().sortDescending(VALUE);
    }

    public void sortOnValue(boolean asc)
    {
        if ( asc )
            sortOnValue();
        else
            sortOnValueDescending();
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
    //# projections (attributeCode)
    //##################################################

    public void selectAttributeCode()
    {
        select(ATTRIBUTE_CODE);
    }

    public void selectDistinctAttributeCode()
    {
        selectDistinct(ATTRIBUTE_CODE);
    }

    public void selectCountDistinctAttributeCode()
    {
        selectCountDistinct(ATTRIBUTE_CODE);
    }

    public void selectMinimumAttributeCode()
    {
        selectMinimum(ATTRIBUTE_CODE);
    }

    public void selectMaximumAttributeCode()
    {
        selectMaximum(ATTRIBUTE_CODE);
    }

    public void selectAverageAttributeCode()
    {
        selectAverage(ATTRIBUTE_CODE);
    }

    public void selectSumAttributeCode()
    {
        selectSum(ATTRIBUTE_CODE);
    }

    public void groupByAttributeCode()
    {
        groupBy(ATTRIBUTE_CODE);
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
    //# projections (used)
    //##################################################

    public void selectUsed()
    {
        select(USED);
    }

    public void selectDistinctUsed()
    {
        selectDistinct(USED);
    }

    public void selectCountDistinctUsed()
    {
        selectCountDistinct(USED);
    }

    public void selectMinimumUsed()
    {
        selectMinimum(USED);
    }

    public void selectMaximumUsed()
    {
        selectMaximum(USED);
    }

    public void selectAverageUsed()
    {
        selectAverage(USED);
    }

    public void selectSumUsed()
    {
        selectSum(USED);
    }

    public void groupByUsed()
    {
        groupBy(USED);
    }

    //##################################################
    //# projections (value)
    //##################################################

    public void selectValue()
    {
        select(VALUE);
    }

    public void selectDistinctValue()
    {
        selectDistinct(VALUE);
    }

    public void selectCountDistinctValue()
    {
        selectCountDistinct(VALUE);
    }

    public void selectMinimumValue()
    {
        selectMinimum(VALUE);
    }

    public void selectMaximumValue()
    {
        selectMaximum(VALUE);
    }

    public void selectAverageValue()
    {
        selectAverage(VALUE);
    }

    public void selectSumValue()
    {
        selectSum(VALUE);
    }

    public void groupByValue()
    {
        groupBy(VALUE);
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
    //# association (Template)
    //##################################################

    public void selectTemplateUid()
    {
        select(TEMPLATE_UID);
    }

    public void selectCountDistinctTemplateUid()
    {
        selectCountDistinct(TEMPLATE_UID);
    }
    
    public void selectDistinctTemplateUid()
    {
        selectDistinct(TEMPLATE_UID);
    }

    public void selectMinimumTemplateUid()
    {
        selectMinimum(TEMPLATE_UID);
    }

    public void selectMaximumTemplateUid()
    {
        selectMaximum(TEMPLATE_UID);
    }

    public void groupByTemplateUid()
    {
        groupBy(TEMPLATE_UID);
    }

    public MyFilterTemplateCriteria joinToTemplate()
    {
        return new MyFilterTemplateCriteria(joinTo(TEMPLATE));
    }

    public MyFilterTemplateCriteria leftJoinToTemplate()
    {
        return new MyFilterTemplateCriteria(leftJoinTo(TEMPLATE));
    }

    public KmhStringCondition whereTemplateUid()
    {
        return new KmhStringCondition(parent(), alias(), TEMPLATE_UID);
    }

    public void whereTemplateIs(MyFilterTemplate e)
    {
        if ( e == null )
            whereTemplateUid().isNull();
        else
            whereTemplateUid().is(e.getUid());
    }

    public void whereTemplateIsNot(MyFilterTemplate e)
    {
        if ( e == null )
            whereTemplateUid().isNotNull();
        else
            whereTemplateUid().isNot(e.getUid());
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

    public MyFilterTemplateItemJunction all()
    {
        return addAnd();
    }

    public MyFilterTemplateItemJunction any()
    {
        return addOr();
    }

    public MyFilterTemplateItemJunction none()
    {
        return addNotOr();
    }

    //##################################################
    //# junction :: basic
    //##################################################

    public MyFilterTemplateItemJunction addNotAnd()
    {
        return new MyFilterTemplateItemJunction(parent().addNotAnd());
    }

    public MyFilterTemplateItemJunction addNotOr()
    {
        return new MyFilterTemplateItemJunction(parent().addNotOr());
    }

    public MyFilterTemplateItemJunction addAnd()
    {
        return new MyFilterTemplateItemJunction(parent().addAnd());
    }

    public MyFilterTemplateItemJunction addOr()
    {
        return new MyFilterTemplateItemJunction(parent().addOr());
    }
}
