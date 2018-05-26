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

public class MyServerSessionJunction
    extends KmhModelJunction
    implements MyServerSessionDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyServerSessionJunction(KmhJunction context)
    {
        super(context);
    }

    //##################################################
    //# properties
    //##################################################

    public KmhBooleanCondition whereActive()
    {
        return new KmhBooleanCondition(context(), alias(), ACTIVE);
    }

    public KmhTimestampCondition whereClosedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), CLOSED_UTC_TS);
    }

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), CREATED_UTC_TS);
    }

    public KmhTimestampCondition whereLastTouchedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), LAST_TOUCHED_UTC_TS);
    }

    public KmhStringCondition whereUid()
    {
        return new KmhStringCondition(context(), alias(), UID);
    }

    public KmhStringCondition whereVersion()
    {
        return new KmhStringCondition(context(), alias(), VERSION);
    }

    public KmhIntegerCondition whereLockVersion()
    {
        return new KmhIntegerCondition(context(), alias(), LOCK_VERSION);
    }

    //##################################################
    //# associations
    //##################################################
    //##################################################
    //# association (AutoLogin)
    //##################################################

//    public MyAutoLoginCriteria joinToAutoLogin()
//    {
//        return new MyAutoLoginCriteria(joinTo(AUTO_LOGIN));
//    }
//
//    public MyAutoLoginCriteria leftJoinToAutoLogin()
//    {
//        return new MyAutoLoginCriteria(leftJoinTo(AUTO_LOGIN));
//    }

    public KmhStringCondition whereAutoLoginUid()
    {
        return new KmhStringCondition(context(), alias(), AUTO_LOGIN_UID);
    }

    public void whereAutoLoginIs(MyAutoLogin e)
    {
        if ( e == null )
            whereAutoLoginUid().isNull();
        else
            whereAutoLoginUid().is(e.getUid());
    }

    public void whereAutoLoginIsNot(MyAutoLogin e)
    {
        if ( e == null )
            whereAutoLoginUid().isNotNull();
        else
            whereAutoLoginUid().isNot(e.getUid());
    }

    //##################################################
    //# association (Tenant)
    //##################################################

//    public MyTenantCriteria joinToTenant()
//    {
//        return new MyTenantCriteria(joinTo(TENANT));
//    }
//
//    public MyTenantCriteria leftJoinToTenant()
//    {
//        return new MyTenantCriteria(leftJoinTo(TENANT));
//    }

    public KmhStringCondition whereTenantUid()
    {
        return new KmhStringCondition(context(), alias(), TENANT_UID);
    }

    public void whereTenantIs(MyTenant e)
    {
        if ( e == null )
            whereTenantUid().isNull();
        else
            whereTenantUid().is(e.getUid());
    }

    public void whereTenantIsNot(MyTenant e)
    {
        if ( e == null )
            whereTenantUid().isNotNull();
        else
            whereTenantUid().isNot(e.getUid());
    }

    //##################################################
    //# association (User)
    //##################################################

//    public MyUserCriteria joinToUser()
//    {
//        return new MyUserCriteria(joinTo(USER));
//    }
//
//    public MyUserCriteria leftJoinToUser()
//    {
//        return new MyUserCriteria(leftJoinTo(USER));
//    }

    public KmhStringCondition whereUserUid()
    {
        return new KmhStringCondition(context(), alias(), USER_UID);
    }

    public void whereUserIs(MyUser e)
    {
        if ( e == null )
            whereUserUid().isNull();
        else
            whereUserUid().is(e.getUid());
    }

    public void whereUserIsNot(MyUser e)
    {
        if ( e == null )
            whereUserUid().isNotNull();
        else
            whereUserUid().isNot(e.getUid());
    }


    //##################################################
    //# junction
    //##################################################

    public MyServerSessionJunction addAnd()
    {
        return new MyServerSessionJunction(context().addAnd());
    }

    public MyServerSessionJunction addOr()
    {
        return new MyServerSessionJunction(context().addOr());
    }

}
