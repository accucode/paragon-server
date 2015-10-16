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

public class MyUserActivationJunction
    extends KmhModelJunction
    implements MyUserActivationDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyUserActivationJunction(KmhJunction context)
    {
        super(context);
    }

    //##################################################
    //# properties
    //##################################################

    public KmhStringCondition whereUid()
    {
        return new KmhStringCondition(context(), fullName(UID));
    }

    public KmhStringCondition whereEmail()
    {
        return new KmhStringCondition(context(), fullName(EMAIL));
    }

    public KmhStringCondition whereToken()
    {
        return new KmhStringCondition(context(), fullName(TOKEN));
    }

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), fullName(CREATED_UTC_TS));
    }

    public KmhTimestampCondition whereExpirationUtcTs()
    {
        return new KmhTimestampCondition(context(), fullName(EXPIRATION_UTC_TS));
    }

    public KmhIntegerCondition whereLockVersion()
    {
        return new KmhIntegerCondition(context(), fullName(LOCK_VERSION));
    }

    //##################################################
    //# associations
    //##################################################

    //##################################################
    //# junction
    //##################################################

    public MyUserActivationJunction addAnd()
    {
        return new MyUserActivationJunction(context().addAnd());
    }

    public MyUserActivationJunction addOr()
    {
        return new MyUserActivationJunction(context().addOr());
    }

}
