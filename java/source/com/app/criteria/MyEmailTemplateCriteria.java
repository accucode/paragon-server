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

public class MyEmailTemplateCriteria
    extends MyAbstractCriteria<MyEmailTemplate>
    implements MyEmailTemplateDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyEmailTemplateCriteria(KmhCriteria parent)
    {
        super(parent);
    }

    //##################################################
    //# primary key
    //##################################################

    public void whereUidIs(MyEmailTemplate e)
    {
        whereUid().is(e.getUid());
    }

    public void whereUidIsNot(MyEmailTemplate e)
    {
        whereUid().isNot(e.getUid());
    }

    //##################################################
    //# properties
    //##################################################

    public KmhStringCondition whereBodyHtml()
    {
        return new KmhStringCondition(context(), alias(), BODY_HTML);
    }

    public KmhStringCondition whereContextTypeCode()
    {
        return new KmhStringCondition(context(), alias(), CONTEXT_TYPE_CODE);
    }

    public void whereContextTypeIs(MyEmailTemplateContextType e)
    {
        if ( e == null )
            whereContextTypeCode().isNull();
        else
            whereContextTypeCode().is(e.getCode());
    }

    public void whereContextTypeIsNot(MyEmailTemplateContextType e)
    {
        if ( e == null )
            whereContextTypeCode().isNull();
        else
            whereContextTypeCode().isNot(e.getCode());
    }

    public void whereContextTypeIsProject()
    {
        whereContextTypeIs(MyEmailTemplateContextType.Project);
    }

    public void whereContextTypeIsNotProject()
    {
        whereContextTypeIsNot(MyEmailTemplateContextType.Project);
    }

    public void whereContextTypeIsProject(boolean e)
    {
        if ( e )
            whereContextTypeIsProject();
        else
            whereContextTypeIsNotProject();
    }

    public void whereContextTypeIsSite()
    {
        whereContextTypeIs(MyEmailTemplateContextType.Site);
    }

    public void whereContextTypeIsNotSite()
    {
        whereContextTypeIsNot(MyEmailTemplateContextType.Site);
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

    public KmhBooleanCondition whereEnabled()
    {
        return new KmhBooleanCondition(context(), alias(), ENABLED);
    }

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), alias(), NAME);
    }

    public KmhStringCondition whereSubjectText()
    {
        return new KmhStringCondition(context(), alias(), SUBJECT_TEXT);
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

    public void sortOnBodyHtml()
    {
        parent().sortAscending(BODY_HTML);
    }

    public void sortOnBodyHtmlDescending()
    {
        parent().sortDescending(BODY_HTML);
    }

    public void sortOnBodyHtml(boolean asc)
    {
        if ( asc )
            sortOnBodyHtml();
        else
            sortOnBodyHtmlDescending();
    }

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

    public void sortOnSubjectText()
    {
        parent().sortAscending(SUBJECT_TEXT);
    }

    public void sortOnSubjectTextDescending()
    {
        parent().sortDescending(SUBJECT_TEXT);
    }

    public void sortOnSubjectText(boolean asc)
    {
        if ( asc )
            sortOnSubjectText();
        else
            sortOnSubjectTextDescending();
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
    //# projections (bodyHtml)
    //##################################################

    public void selectBodyHtml()
    {
        select(BODY_HTML);
    }

    public void selectDistinctBodyHtml()
    {
        selectDistinct(BODY_HTML);
    }

    public void selectCountDistinctBodyHtml()
    {
        selectCountDistinct(BODY_HTML);
    }

    public void selectMinimumBodyHtml()
    {
        selectMinimum(BODY_HTML);
    }

    public void selectMaximumBodyHtml()
    {
        selectMaximum(BODY_HTML);
    }

    public void selectAverageBodyHtml()
    {
        selectAverage(BODY_HTML);
    }

    public void selectSumBodyHtml()
    {
        selectSum(BODY_HTML);
    }

    public void groupByBodyHtml()
    {
        groupBy(BODY_HTML);
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
    //# projections (subjectText)
    //##################################################

    public void selectSubjectText()
    {
        select(SUBJECT_TEXT);
    }

    public void selectDistinctSubjectText()
    {
        selectDistinct(SUBJECT_TEXT);
    }

    public void selectCountDistinctSubjectText()
    {
        selectCountDistinct(SUBJECT_TEXT);
    }

    public void selectMinimumSubjectText()
    {
        selectMinimum(SUBJECT_TEXT);
    }

    public void selectMaximumSubjectText()
    {
        selectMaximum(SUBJECT_TEXT);
    }

    public void selectAverageSubjectText()
    {
        selectAverage(SUBJECT_TEXT);
    }

    public void selectSumSubjectText()
    {
        selectSum(SUBJECT_TEXT);
    }

    public void groupBySubjectText()
    {
        groupBy(SUBJECT_TEXT);
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
    //# collection (DefaultRecipients)
    //##################################################

    public MyDefaultRecipientCriteria joinToDefaultRecipients()
    {
        return new MyDefaultRecipientCriteria(joinTo(DEFAULT_RECIPIENTS));
    }

    public MyDefaultRecipientCriteria leftJoinToDefaultRecipients()
    {
        return new MyDefaultRecipientCriteria(leftJoinTo(DEFAULT_RECIPIENTS));
    }

    //##################################################
    //# junction :: alias
    //##################################################

    public MyEmailTemplateJunction all()
    {
        return addAnd();
    }

    public MyEmailTemplateJunction any()
    {
        return addOr();
    }

    public MyEmailTemplateJunction none()
    {
        return addNotOr();
    }

    //##################################################
    //# junction :: basic
    //##################################################

    public MyEmailTemplateJunction addNotAnd()
    {
        return new MyEmailTemplateJunction(parent().addNotAnd());
    }

    public MyEmailTemplateJunction addNotOr()
    {
        return new MyEmailTemplateJunction(parent().addNotOr());
    }

    public MyEmailTemplateJunction addAnd()
    {
        return new MyEmailTemplateJunction(parent().addAnd());
    }

    public MyEmailTemplateJunction addOr()
    {
        return new MyEmailTemplateJunction(parent().addOr());
    }
}
