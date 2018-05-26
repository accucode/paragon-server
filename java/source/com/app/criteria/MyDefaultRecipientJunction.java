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

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.meta.*;

public class MyDefaultRecipientJunction
    extends KmhModelJunction
    implements MyDefaultRecipientDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyDefaultRecipientJunction(KmhJunction context)
    {
        super(context);
    }

    //##################################################
    //# properties
    //##################################################

    public KmhStringCondition whereContactTypeCode()
    {
        return new KmhStringCondition(context(), alias(), CONTACT_TYPE_CODE);
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
    //# associations
    //##################################################
    //##################################################
    //# association (CreatedBy)
    //##################################################

//    public MyUserCriteria joinToCreatedBy()
//    {
//        return new MyUserCriteria(joinTo(CREATED_BY));
//    }
//
//    public MyUserCriteria leftJoinToCreatedBy()
//    {
//        return new MyUserCriteria(leftJoinTo(CREATED_BY));
//    }

    public KmhStringCondition whereCreatedByUid()
    {
        return new KmhStringCondition(context(), alias(), CREATED_BY_UID);
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

//    public MyEmailTemplateCriteria joinToEmailTemplate()
//    {
//        return new MyEmailTemplateCriteria(joinTo(EMAIL_TEMPLATE));
//    }
//
//    public MyEmailTemplateCriteria leftJoinToEmailTemplate()
//    {
//        return new MyEmailTemplateCriteria(leftJoinTo(EMAIL_TEMPLATE));
//    }

    public KmhStringCondition whereEmailTemplateUid()
    {
        return new KmhStringCondition(context(), alias(), EMAIL_TEMPLATE_UID);
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

//    public MyUserCriteria joinToUpdatedBy()
//    {
//        return new MyUserCriteria(joinTo(UPDATED_BY));
//    }
//
//    public MyUserCriteria leftJoinToUpdatedBy()
//    {
//        return new MyUserCriteria(leftJoinTo(UPDATED_BY));
//    }

    public KmhStringCondition whereUpdatedByUid()
    {
        return new KmhStringCondition(context(), alias(), UPDATED_BY_UID);
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
    //# junction
    //##################################################

    public MyDefaultRecipientJunction addAnd()
    {
        return new MyDefaultRecipientJunction(context().addAnd());
    }

    public MyDefaultRecipientJunction addOr()
    {
        return new MyDefaultRecipientJunction(context().addOr());
    }

}
