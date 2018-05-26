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

public class MyDefaultRecipientCriteria
    extends MyAbstractCriteria<MyDefaultRecipient>
    implements MyDefaultRecipientDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyDefaultRecipientCriteria(KmhCriteria parent)
    {
        super(parent);
    }

    //##################################################
    //# primary key
    //##################################################

    public void whereUidIs(MyDefaultRecipient e)
    {
        whereUid().is(e.getUid());
    }

    public void whereUidIsNot(MyDefaultRecipient e)
    {
        whereUid().isNot(e.getUid());
    }

    //##################################################
    //# properties
    //##################################################

    public KmhStringCondition whereContactTypeCode()
    {
        return new KmhStringCondition(context(), alias(), CONTACT_TYPE_CODE);
    }

    public void whereContactTypeIs(MyDefaultRecipientContactType e)
    {
        if ( e == null )
            whereContactTypeCode().isNull();
        else
            whereContactTypeCode().is(e.getCode());
    }

    public void whereContactTypeIsNot(MyDefaultRecipientContactType e)
    {
        if ( e == null )
            whereContactTypeCode().isNull();
        else
            whereContactTypeCode().isNot(e.getCode());
    }

    public void whereContactTypeIsProjectSupport()
    {
        whereContactTypeIs(MyDefaultRecipientContactType.ProjectSupport);
    }

    public void whereContactTypeIsNotProjectSupport()
    {
        whereContactTypeIsNot(MyDefaultRecipientContactType.ProjectSupport);
    }

    public void whereContactTypeIsProjectSupport(boolean e)
    {
        if ( e )
            whereContactTypeIsProjectSupport();
        else
            whereContactTypeIsNotProjectSupport();
    }

    public void whereContactTypeIsMain()
    {
        whereContactTypeIs(MyDefaultRecipientContactType.Main);
    }

    public void whereContactTypeIsNotMain()
    {
        whereContactTypeIsNot(MyDefaultRecipientContactType.Main);
    }

    public void whereContactTypeIsMain(boolean e)
    {
        if ( e )
            whereContactTypeIsMain();
        else
            whereContactTypeIsNotMain();
    }

    public void whereContactTypeIsInstall()
    {
        whereContactTypeIs(MyDefaultRecipientContactType.Install);
    }

    public void whereContactTypeIsNotInstall()
    {
        whereContactTypeIsNot(MyDefaultRecipientContactType.Install);
    }

    public void whereContactTypeIsInstall(boolean e)
    {
        if ( e )
            whereContactTypeIsInstall();
        else
            whereContactTypeIsNotInstall();
    }

    public void whereContactTypeIsTechnical()
    {
        whereContactTypeIs(MyDefaultRecipientContactType.Technical);
    }

    public void whereContactTypeIsNotTechnical()
    {
        whereContactTypeIsNot(MyDefaultRecipientContactType.Technical);
    }

    public void whereContactTypeIsTechnical(boolean e)
    {
        if ( e )
            whereContactTypeIsTechnical();
        else
            whereContactTypeIsNotTechnical();
    }

    public void whereContactTypeIsScheduling()
    {
        whereContactTypeIs(MyDefaultRecipientContactType.Scheduling);
    }

    public void whereContactTypeIsNotScheduling()
    {
        whereContactTypeIsNot(MyDefaultRecipientContactType.Scheduling);
    }

    public void whereContactTypeIsScheduling(boolean e)
    {
        if ( e )
            whereContactTypeIsScheduling();
        else
            whereContactTypeIsNotScheduling();
    }

    public void whereContactTypeIsSales()
    {
        whereContactTypeIs(MyDefaultRecipientContactType.Sales);
    }

    public void whereContactTypeIsNotSales()
    {
        whereContactTypeIsNot(MyDefaultRecipientContactType.Sales);
    }

    public void whereContactTypeIsSales(boolean e)
    {
        if ( e )
            whereContactTypeIsSales();
        else
            whereContactTypeIsNotSales();
    }

    public void whereContactTypeIsRequester()
    {
        whereContactTypeIs(MyDefaultRecipientContactType.Requester);
    }

    public void whereContactTypeIsNotRequester()
    {
        whereContactTypeIsNot(MyDefaultRecipientContactType.Requester);
    }

    public void whereContactTypeIsRequester(boolean e)
    {
        if ( e )
            whereContactTypeIsRequester();
        else
            whereContactTypeIsNotRequester();
    }

    public void whereContactTypeIsCustomerApproval()
    {
        whereContactTypeIs(MyDefaultRecipientContactType.CustomerApproval);
    }

    public void whereContactTypeIsNotCustomerApproval()
    {
        whereContactTypeIsNot(MyDefaultRecipientContactType.CustomerApproval);
    }

    public void whereContactTypeIsCustomerApproval(boolean e)
    {
        if ( e )
            whereContactTypeIsCustomerApproval();
        else
            whereContactTypeIsNotCustomerApproval();
    }

    public void whereContactTypeIsCustomerBilling()
    {
        whereContactTypeIs(MyDefaultRecipientContactType.CustomerBilling);
    }

    public void whereContactTypeIsNotCustomerBilling()
    {
        whereContactTypeIsNot(MyDefaultRecipientContactType.CustomerBilling);
    }

    public void whereContactTypeIsCustomerBilling(boolean e)
    {
        if ( e )
            whereContactTypeIsCustomerBilling();
        else
            whereContactTypeIsNotCustomerBilling();
    }

    public void whereContactTypeIsProjectNotifications()
    {
        whereContactTypeIs(MyDefaultRecipientContactType.ProjectNotifications);
    }

    public void whereContactTypeIsNotProjectNotifications()
    {
        whereContactTypeIsNot(MyDefaultRecipientContactType.ProjectNotifications);
    }

    public void whereContactTypeIsProjectNotifications(boolean e)
    {
        if ( e )
            whereContactTypeIsProjectNotifications();
        else
            whereContactTypeIsNotProjectNotifications();
    }

    public void whereContactTypeIsJobNotifications()
    {
        whereContactTypeIs(MyDefaultRecipientContactType.JobNotifications);
    }

    public void whereContactTypeIsNotJobNotifications()
    {
        whereContactTypeIsNot(MyDefaultRecipientContactType.JobNotifications);
    }

    public void whereContactTypeIsJobNotifications(boolean e)
    {
        if ( e )
            whereContactTypeIsJobNotifications();
        else
            whereContactTypeIsNotJobNotifications();
    }

    public void whereContactTypeIsCustomerNotifications()
    {
        whereContactTypeIs(MyDefaultRecipientContactType.CustomerNotifications);
    }

    public void whereContactTypeIsNotCustomerNotifications()
    {
        whereContactTypeIsNot(MyDefaultRecipientContactType.CustomerNotifications);
    }

    public void whereContactTypeIsCustomerNotifications(boolean e)
    {
        if ( e )
            whereContactTypeIsCustomerNotifications();
        else
            whereContactTypeIsNotCustomerNotifications();
    }

    public void whereContactTypeIsCustom()
    {
        whereContactTypeIs(MyDefaultRecipientContactType.Custom);
    }

    public void whereContactTypeIsNotCustom()
    {
        whereContactTypeIsNot(MyDefaultRecipientContactType.Custom);
    }

    public void whereContactTypeIsCustom(boolean e)
    {
        if ( e )
            whereContactTypeIsCustom();
        else
            whereContactTypeIsNotCustom();
    }

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), CREATED_UTC_TS);
    }

    public KmhStringCondition whereCustomEmail()
    {
        return new KmhStringCondition(context(), alias(), CUSTOM_EMAIL);
    }

    public KmhStringCondition whereTypeCode()
    {
        return new KmhStringCondition(context(), alias(), TYPE_CODE);
    }

    public void whereTypeIs(MyDefaultRecipientType e)
    {
        if ( e == null )
            whereTypeCode().isNull();
        else
            whereTypeCode().is(e.getCode());
    }

    public void whereTypeIsNot(MyDefaultRecipientType e)
    {
        if ( e == null )
            whereTypeCode().isNull();
        else
            whereTypeCode().isNot(e.getCode());
    }

    public void whereTypeIsTo()
    {
        whereTypeIs(MyDefaultRecipientType.To);
    }

    public void whereTypeIsNotTo()
    {
        whereTypeIsNot(MyDefaultRecipientType.To);
    }

    public void whereTypeIsTo(boolean e)
    {
        if ( e )
            whereTypeIsTo();
        else
            whereTypeIsNotTo();
    }

    public void whereTypeIsCc()
    {
        whereTypeIs(MyDefaultRecipientType.Cc);
    }

    public void whereTypeIsNotCc()
    {
        whereTypeIsNot(MyDefaultRecipientType.Cc);
    }

    public void whereTypeIsCc(boolean e)
    {
        if ( e )
            whereTypeIsCc();
        else
            whereTypeIsNotCc();
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

    public void sortOnContactTypeCode()
    {
        parent().sortAscending(CONTACT_TYPE_CODE);
    }

    public void sortOnContactTypeCodeDescending()
    {
        parent().sortDescending(CONTACT_TYPE_CODE);
    }

    public void sortOnContactTypeCode(boolean asc)
    {
        if ( asc )
            sortOnContactTypeCode();
        else
            sortOnContactTypeCodeDescending();
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

    public void sortOnCustomEmail()
    {
        parent().sortAscending(CUSTOM_EMAIL);
    }

    public void sortOnCustomEmailDescending()
    {
        parent().sortDescending(CUSTOM_EMAIL);
    }

    public void sortOnCustomEmail(boolean asc)
    {
        if ( asc )
            sortOnCustomEmail();
        else
            sortOnCustomEmailDescending();
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
    //# projections (contactTypeCode)
    //##################################################

    public void selectContactTypeCode()
    {
        select(CONTACT_TYPE_CODE);
    }

    public void selectDistinctContactTypeCode()
    {
        selectDistinct(CONTACT_TYPE_CODE);
    }

    public void selectCountDistinctContactTypeCode()
    {
        selectCountDistinct(CONTACT_TYPE_CODE);
    }

    public void selectMinimumContactTypeCode()
    {
        selectMinimum(CONTACT_TYPE_CODE);
    }

    public void selectMaximumContactTypeCode()
    {
        selectMaximum(CONTACT_TYPE_CODE);
    }

    public void selectAverageContactTypeCode()
    {
        selectAverage(CONTACT_TYPE_CODE);
    }

    public void selectSumContactTypeCode()
    {
        selectSum(CONTACT_TYPE_CODE);
    }

    public void groupByContactTypeCode()
    {
        groupBy(CONTACT_TYPE_CODE);
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
    //# projections (customEmail)
    //##################################################

    public void selectCustomEmail()
    {
        select(CUSTOM_EMAIL);
    }

    public void selectDistinctCustomEmail()
    {
        selectDistinct(CUSTOM_EMAIL);
    }

    public void selectCountDistinctCustomEmail()
    {
        selectCountDistinct(CUSTOM_EMAIL);
    }

    public void selectMinimumCustomEmail()
    {
        selectMinimum(CUSTOM_EMAIL);
    }

    public void selectMaximumCustomEmail()
    {
        selectMaximum(CUSTOM_EMAIL);
    }

    public void selectAverageCustomEmail()
    {
        selectAverage(CUSTOM_EMAIL);
    }

    public void selectSumCustomEmail()
    {
        selectSum(CUSTOM_EMAIL);
    }

    public void groupByCustomEmail()
    {
        groupBy(CUSTOM_EMAIL);
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
    //# association (EmailTemplate)
    //##################################################

    public void selectEmailTemplateUid()
    {
        select(EMAIL_TEMPLATE_UID);
    }

    public void selectCountDistinctEmailTemplateUid()
    {
        selectCountDistinct(EMAIL_TEMPLATE_UID);
    }
    
    public void selectDistinctEmailTemplateUid()
    {
        selectDistinct(EMAIL_TEMPLATE_UID);
    }

    public void selectMinimumEmailTemplateUid()
    {
        selectMinimum(EMAIL_TEMPLATE_UID);
    }

    public void selectMaximumEmailTemplateUid()
    {
        selectMaximum(EMAIL_TEMPLATE_UID);
    }

    public void groupByEmailTemplateUid()
    {
        groupBy(EMAIL_TEMPLATE_UID);
    }

    public MyEmailTemplateCriteria joinToEmailTemplate()
    {
        return new MyEmailTemplateCriteria(joinTo(EMAIL_TEMPLATE));
    }

    public MyEmailTemplateCriteria leftJoinToEmailTemplate()
    {
        return new MyEmailTemplateCriteria(leftJoinTo(EMAIL_TEMPLATE));
    }

    public KmhStringCondition whereEmailTemplateUid()
    {
        return new KmhStringCondition(parent(), alias(), EMAIL_TEMPLATE_UID);
    }

    public void whereEmailTemplateIs(MyEmailTemplate e)
    {
        if ( e == null )
            whereEmailTemplateUid().isNull();
        else
            whereEmailTemplateUid().is(e.getUid());
    }

    public void whereEmailTemplateIsNot(MyEmailTemplate e)
    {
        if ( e == null )
            whereEmailTemplateUid().isNotNull();
        else
            whereEmailTemplateUid().isNot(e.getUid());
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

    public MyDefaultRecipientJunction all()
    {
        return addAnd();
    }

    public MyDefaultRecipientJunction any()
    {
        return addOr();
    }

    public MyDefaultRecipientJunction none()
    {
        return addNotOr();
    }

    //##################################################
    //# junction :: basic
    //##################################################

    public MyDefaultRecipientJunction addNotAnd()
    {
        return new MyDefaultRecipientJunction(parent().addNotAnd());
    }

    public MyDefaultRecipientJunction addNotOr()
    {
        return new MyDefaultRecipientJunction(parent().addNotOr());
    }

    public MyDefaultRecipientJunction addAnd()
    {
        return new MyDefaultRecipientJunction(parent().addAnd());
    }

    public MyDefaultRecipientJunction addOr()
    {
        return new MyDefaultRecipientJunction(parent().addOr());
    }
}
