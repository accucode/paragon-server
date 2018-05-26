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

public class MyEmailPartJunction
    extends KmhModelJunction
    implements MyEmailPartDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyEmailPartJunction(KmhJunction context)
    {
        super(context);
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
    //# association (Email)
    //##################################################

//    public MyEmailCriteria joinToEmail()
//    {
//        return new MyEmailCriteria(joinTo(EMAIL));
//    }
//
//    public MyEmailCriteria leftJoinToEmail()
//    {
//        return new MyEmailCriteria(leftJoinTo(EMAIL));
//    }

    public KmhStringCondition whereEmailUid()
    {
        return new KmhStringCondition(context(), alias(), EMAIL_UID);
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

    public MyEmailPartJunction addAnd()
    {
        return new MyEmailPartJunction(context().addAnd());
    }

    public MyEmailPartJunction addOr()
    {
        return new MyEmailPartJunction(context().addOr());
    }

}
