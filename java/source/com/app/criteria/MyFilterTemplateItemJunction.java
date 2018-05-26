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

public class MyFilterTemplateItemJunction
    extends KmhModelJunction
    implements MyFilterTemplateItemDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyFilterTemplateItemJunction(KmhJunction context)
    {
        super(context);
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
    //# association (Template)
    //##################################################

//    public MyFilterTemplateCriteria joinToTemplate()
//    {
//        return new MyFilterTemplateCriteria(joinTo(TEMPLATE));
//    }
//
//    public MyFilterTemplateCriteria leftJoinToTemplate()
//    {
//        return new MyFilterTemplateCriteria(leftJoinTo(TEMPLATE));
//    }

    public KmhStringCondition whereTemplateUid()
    {
        return new KmhStringCondition(context(), alias(), TEMPLATE_UID);
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

    public MyFilterTemplateItemJunction addAnd()
    {
        return new MyFilterTemplateItemJunction(context().addAnd());
    }

    public MyFilterTemplateItemJunction addOr()
    {
        return new MyFilterTemplateItemJunction(context().addOr());
    }

}
