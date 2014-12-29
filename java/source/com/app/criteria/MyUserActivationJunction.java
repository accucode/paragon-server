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

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.meta.*;

public class MyUserActivationJunction
    extends KmModelJunction
    implements MyUserActivationDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyUserActivationJunction(KmJunction context)
    {
        super(context);
    }

    public MyUserActivationJunction(KmJunction context, KmAbstractCriteria parent)
    {
        super(context, parent);
    }

    //##################################################
    //# properties
    //##################################################

    public KmStringCriteria whereUid()
    {
        return new KmStringCriteria(context(), fullName(UID));
    }

    public KmStringCriteria whereEmail()
    {
        return new KmStringCriteria(context(), fullName(EMAIL));
    }

    public KmStringCriteria whereToken()
    {
        return new KmStringCriteria(context(), fullName(TOKEN));
    }

    public KmPropertyCriteria<KmTimestamp> whereCreatedUtcTs()
    {
        return new KmPropertyCriteria<>(context(), fullName(CREATED_UTC_TS));
    }

    public KmPropertyCriteria<KmTimestamp> whereExpirationUtcTs()
    {
        return new KmPropertyCriteria<>(context(), fullName(EXPIRATION_UTC_TS));
    }

    public KmIntegerCriteria whereLockVersion()
    {
        return new KmIntegerCriteria(context(), fullName(LOCK_VERSION));
    }

    //##################################################
    //# associations
    //##################################################

    //##################################################
    //# junction
    //##################################################

    public MyUserActivationJunction addAnd()
    {
        return new MyUserActivationJunction(context().addAnd(), parent());
    }

    public MyUserActivationJunction addOr()
    {
        return new MyUserActivationJunction(context().addOr(), parent());
    }

}
