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

public class MyAutoLoginJunction
    extends KmhModelJunction
    implements MyAutoLoginDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyAutoLoginJunction(KmhJunction context)
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

    public KmhTimestampCondition whereLastTouchedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), LAST_TOUCHED_UTC_TS);
    }

    public KmhStringCondition whereUid()
    {
        return new KmhStringCondition(context(), alias(), UID);
    }

    public KmhIntegerCondition whereLockVersion()
    {
        return new KmhIntegerCondition(context(), alias(), LOCK_VERSION);
    }

    //##################################################
    //# associations
    //##################################################
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

    public MyAutoLoginJunction addAnd()
    {
        return new MyAutoLoginJunction(context().addAnd());
    }

    public MyAutoLoginJunction addOr()
    {
        return new MyAutoLoginJunction(context().addOr());
    }

}
