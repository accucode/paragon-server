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

public class MySiteContactJunction
    extends KmhModelJunction
    implements MySiteContactDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MySiteContactJunction(KmhJunction context)
    {
        super(context);
    }

    //##################################################
    //# properties
    //##################################################

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), CREATED_UTC_TS);
    }

    public KmhStringCondition whereEmail()
    {
        return new KmhStringCondition(context(), alias(), EMAIL);
    }

    public KmhBooleanCondition whereEnabled()
    {
        return new KmhBooleanCondition(context(), alias(), ENABLED);
    }

    public KmhStringCondition whereFirstName()
    {
        return new KmhStringCondition(context(), alias(), FIRST_NAME);
    }

    public KmhStringCondition whereFullName()
    {
        return new KmhStringCondition(context(), alias(), FULL_NAME);
    }

    public KmhStringCondition whereLastName()
    {
        return new KmhStringCondition(context(), alias(), LAST_NAME);
    }

    public KmhStringCondition whereNickname()
    {
        return new KmhStringCondition(context(), alias(), NICKNAME);
    }

    public KmhStringCondition wherePhone()
    {
        return new KmhStringCondition(context(), alias(), PHONE);
    }

    public KmhStringCondition whereTitle()
    {
        return new KmhStringCondition(context(), alias(), TITLE);
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
    //# association (Site)
    //##################################################

//    public MySiteCriteria joinToSite()
//    {
//        return new MySiteCriteria(joinTo(SITE));
//    }
//
//    public MySiteCriteria leftJoinToSite()
//    {
//        return new MySiteCriteria(leftJoinTo(SITE));
//    }

    public KmhStringCondition whereSiteUid()
    {
        return new KmhStringCondition(context(), alias(), SITE_UID);
    }

    public void whereSiteIs(MySite e)
    {
        if ( e == null )
            whereSiteUid().isNull();
        else
            whereSiteUid().is(e.getUid());
    }

    public void whereSiteIsNot(MySite e)
    {
        if ( e == null )
            whereSiteUid().isNotNull();
        else
            whereSiteUid().isNot(e.getUid());
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

    public MySiteContactJunction addAnd()
    {
        return new MySiteContactJunction(context().addAnd());
    }

    public MySiteContactJunction addOr()
    {
        return new MySiteContactJunction(context().addOr());
    }

}
