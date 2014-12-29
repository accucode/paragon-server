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
import com.kodemore.hibernate.criteria.*;
import com.kodemore.time.*;
import com.kodemore.types.*;

import com.app.criteria.core.*;
import com.app.dao.*;
import com.app.dao.base.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.meta.*;

public class MyEmailPartCriteria
    extends MyAbstractCriteria<MyEmailPart>
    implements MyEmailPartDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyEmailPartCriteria(KmCriteria parent)
    {
        super(parent);
    }

    public MyEmailPartCriteria(KmCriteria parent, KmAbstractCriteria context)
    {
        super(parent, context);
    }

    //##################################################
    //# properties
    //##################################################

    public KmStringCriteria whereUid()
    {
        return new KmStringCriteria(context(), fullName(UID));
    }

    public KmIntegerCriteria whereSequence()
    {
        return new KmIntegerCriteria(context(), fullName(SEQUENCE));
    }

    public KmStringCriteria whereTypeCode()
    {
        return new KmStringCriteria(context(), fullName(TYPE_CODE));
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

    public KmStringCriteria whereAttachmentName()
    {
        return new KmStringCriteria(context(), fullName(ATTACHMENT_NAME));
    }

    public KmPropertyCriteria<KmBlob> whereData()
    {
        return new KmPropertyCriteria<>(context(), fullName(DATA));
    }

    public KmIntegerCriteria whereLockVersion()
    {
        return new KmIntegerCriteria(context(), fullName(LOCK_VERSION));
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
    //# association (Email)
    //##################################################

    public void selectEmailUid()
    {
        select(EMAIL_UID);
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
        groupBy(EMAIL);
    }

    public MyEmailCriteria joinToEmail()
    {
        return new MyEmailCriteria(joinTo(EMAIL));
    }

    public MyEmailCriteria leftJoinToEmail()
    {
        return new MyEmailCriteria(leftJoinTo(EMAIL));
    }

    public KmStringCriteria whereEmailUid()
    {
        return new KmStringCriteria(parent(), fullName(EMAIL_UID));
    }

    public void whereEmailIs(MyEmail e)
    {
        if ( e == null )
            whereEmailUid().isNull();
        else
            whereEmailUid().is(e.getUid());
    }

    //##################################################
    //# junction
    //##################################################

    public MyEmailPartJunction addAnd()
    {
        return new MyEmailPartJunction(parent().addAnd());
    }

    public MyEmailPartJunction addOr()
    {
        return new MyEmailPartJunction(parent().addOr());
    }

    //##################################################
    //# support
    //##################################################

    @Override
    public MyEmailPartCriteria createOn(KmModelJunction junction)
    {
        return new MyEmailPartCriteria(parent(), junction.context());
    }

}
