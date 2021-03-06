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

public class MyEmailPartCriteria
    extends MyAbstractCriteria<MyEmailPart>
    implements MyEmailPartDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyEmailPartCriteria(KmhCriteria parent)
    {
        super(parent);
    }

    //##################################################
    //# primary key
    //##################################################

    public void whereUidIs(MyEmailPart e)
    {
        whereUid().is(e.getUid());
    }

    public void whereUidIsNot(MyEmailPart e)
    {
        whereUid().isNot(e.getUid());
    }

    //##################################################
    //# properties
    //##################################################

    public KmhStringCondition whereAttachmentName()
    {
        return new KmhStringCondition(context(), alias(), ATTACHMENT_NAME);
    }

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), CREATED_UTC_TS);
    }

    public KmhPropertyCondition<KmBlob> whereData()
    {
        return new KmhPropertyCondition<>(context(), alias(), DATA);
    }

    public KmhIntegerCondition whereSequence()
    {
        return new KmhIntegerCondition(context(), alias(), SEQUENCE);
    }

    public KmhStringCondition whereTypeCode()
    {
        return new KmhStringCondition(context(), alias(), TYPE_CODE);
    }

    public void whereTypeIs(MyEmailPartType e)
    {
        if ( e == null )
            whereTypeCode().isNull();
        else
            whereTypeCode().is(e.getCode());
    }

    public void whereTypeIsNot(MyEmailPartType e)
    {
        if ( e == null )
            whereTypeCode().isNull();
        else
            whereTypeCode().isNot(e.getCode());
    }

    public void whereTypeIsText()
    {
        whereTypeIs(MyEmailPartType.Text);
    }

    public void whereTypeIsNotText()
    {
        whereTypeIsNot(MyEmailPartType.Text);
    }

    public void whereTypeIsText(boolean e)
    {
        if ( e )
            whereTypeIsText();
        else
            whereTypeIsNotText();
    }

    public void whereTypeIsHtml()
    {
        whereTypeIs(MyEmailPartType.Html);
    }

    public void whereTypeIsNotHtml()
    {
        whereTypeIsNot(MyEmailPartType.Html);
    }

    public void whereTypeIsHtml(boolean e)
    {
        if ( e )
            whereTypeIsHtml();
        else
            whereTypeIsNotHtml();
    }

    public void whereTypeIsAttachment()
    {
        whereTypeIs(MyEmailPartType.Attachment);
    }

    public void whereTypeIsNotAttachment()
    {
        whereTypeIsNot(MyEmailPartType.Attachment);
    }

    public void whereTypeIsAttachment(boolean e)
    {
        if ( e )
            whereTypeIsAttachment();
        else
            whereTypeIsNotAttachment();
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

    public void sortOnAttachmentName()
    {
        parent().sortAscending(ATTACHMENT_NAME);
    }

    public void sortOnAttachmentNameDescending()
    {
        parent().sortDescending(ATTACHMENT_NAME);
    }

    public void sortOnAttachmentName(boolean asc)
    {
        if ( asc )
            sortOnAttachmentName();
        else
            sortOnAttachmentNameDescending();
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

    public void sortOnData()
    {
        parent().sortAscending(DATA);
    }

    public void sortOnDataDescending()
    {
        parent().sortDescending(DATA);
    }

    public void sortOnData(boolean asc)
    {
        if ( asc )
            sortOnData();
        else
            sortOnDataDescending();
    }

    public void sortOnSequence()
    {
        parent().sortAscending(SEQUENCE);
    }

    public void sortOnSequenceDescending()
    {
        parent().sortDescending(SEQUENCE);
    }

    public void sortOnSequence(boolean asc)
    {
        if ( asc )
            sortOnSequence();
        else
            sortOnSequenceDescending();
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
    //# projections (attachmentName)
    //##################################################

    public void selectAttachmentName()
    {
        select(ATTACHMENT_NAME);
    }

    public void selectDistinctAttachmentName()
    {
        selectDistinct(ATTACHMENT_NAME);
    }

    public void selectCountDistinctAttachmentName()
    {
        selectCountDistinct(ATTACHMENT_NAME);
    }

    public void selectMinimumAttachmentName()
    {
        selectMinimum(ATTACHMENT_NAME);
    }

    public void selectMaximumAttachmentName()
    {
        selectMaximum(ATTACHMENT_NAME);
    }

    public void selectAverageAttachmentName()
    {
        selectAverage(ATTACHMENT_NAME);
    }

    public void selectSumAttachmentName()
    {
        selectSum(ATTACHMENT_NAME);
    }

    public void groupByAttachmentName()
    {
        groupBy(ATTACHMENT_NAME);
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
    //# projections (data)
    //##################################################

    public void selectData()
    {
        select(DATA);
    }

    public void selectDistinctData()
    {
        selectDistinct(DATA);
    }

    public void selectCountDistinctData()
    {
        selectCountDistinct(DATA);
    }

    public void selectMinimumData()
    {
        selectMinimum(DATA);
    }

    public void selectMaximumData()
    {
        selectMaximum(DATA);
    }

    public void selectAverageData()
    {
        selectAverage(DATA);
    }

    public void selectSumData()
    {
        selectSum(DATA);
    }

    public void groupByData()
    {
        groupBy(DATA);
    }

    //##################################################
    //# projections (sequence)
    //##################################################

    public void selectSequence()
    {
        select(SEQUENCE);
    }

    public void selectDistinctSequence()
    {
        selectDistinct(SEQUENCE);
    }

    public void selectCountDistinctSequence()
    {
        selectCountDistinct(SEQUENCE);
    }

    public void selectMinimumSequence()
    {
        selectMinimum(SEQUENCE);
    }

    public void selectMaximumSequence()
    {
        selectMaximum(SEQUENCE);
    }

    public void selectAverageSequence()
    {
        selectAverage(SEQUENCE);
    }

    public void selectSumSequence()
    {
        selectSum(SEQUENCE);
    }

    public void groupBySequence()
    {
        groupBy(SEQUENCE);
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
    //# association (Email)
    //##################################################

    public void selectEmailUid()
    {
        select(EMAIL_UID);
    }

    public void selectCountDistinctEmailUid()
    {
        selectCountDistinct(EMAIL_UID);
    }
    
    public void selectDistinctEmailUid()
    {
        selectDistinct(EMAIL_UID);
    }

    public void selectMinimumEmailUid()
    {
        selectMinimum(EMAIL_UID);
    }

    public void selectMaximumEmailUid()
    {
        selectMaximum(EMAIL_UID);
    }

    public void groupByEmailUid()
    {
        groupBy(EMAIL_UID);
    }

    public MyEmailCriteria joinToEmail()
    {
        return new MyEmailCriteria(joinTo(EMAIL));
    }

    public MyEmailCriteria leftJoinToEmail()
    {
        return new MyEmailCriteria(leftJoinTo(EMAIL));
    }

    public KmhStringCondition whereEmailUid()
    {
        return new KmhStringCondition(parent(), alias(), EMAIL_UID);
    }

    public void whereEmailIs(MyEmail e)
    {
        if ( e == null )
            whereEmailUid().isNull();
        else
            whereEmailUid().is(e.getUid());
    }

    public void whereEmailIsNot(MyEmail e)
    {
        if ( e == null )
            whereEmailUid().isNotNull();
        else
            whereEmailUid().isNot(e.getUid());
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

    public MyEmailPartJunction all()
    {
        return addAnd();
    }

    public MyEmailPartJunction any()
    {
        return addOr();
    }

    public MyEmailPartJunction none()
    {
        return addNotOr();
    }

    //##################################################
    //# junction :: basic
    //##################################################

    public MyEmailPartJunction addNotAnd()
    {
        return new MyEmailPartJunction(parent().addNotAnd());
    }

    public MyEmailPartJunction addNotOr()
    {
        return new MyEmailPartJunction(parent().addNotOr());
    }

    public MyEmailPartJunction addAnd()
    {
        return new MyEmailPartJunction(parent().addAnd());
    }

    public MyEmailPartJunction addOr()
    {
        return new MyEmailPartJunction(parent().addOr());
    }
}
