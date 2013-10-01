//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.criteria;

import com.app.dao.base.MyPasswordResetDaoConstantsIF;
import com.app.model.MyPasswordReset;

import com.kodemore.hibernate.criteria.KmAbstractCriteria;
import com.kodemore.hibernate.criteria.KmIntegerCriteria;
import com.kodemore.hibernate.criteria.KmJunction;
import com.kodemore.hibernate.criteria.KmModelJunction;
import com.kodemore.hibernate.criteria.KmPropertyCriteria;
import com.kodemore.hibernate.criteria.KmStringCriteria;
import com.kodemore.time.KmTimestamp;

public class MyPasswordResetJunction
    extends KmModelJunction<MyPasswordReset>
    implements MyPasswordResetDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyPasswordResetJunction(KmJunction context)
    {
        super(context);
    }

    public MyPasswordResetJunction(KmJunction context, KmAbstractCriteria parent)
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

    public KmStringCriteria whereStatusCode()
    {
        return new KmStringCriteria(context(), fullName(STATUS_CODE));
    }

    public KmStringCriteria whereAccessKey()
    {
        return new KmStringCriteria(context(), fullName(ACCESS_KEY));
    }

    public KmPropertyCriteria<KmTimestamp> whereCreatedUtcTs()
    {
        return new KmPropertyCriteria<KmTimestamp>(context(), fullName(CREATED_UTC_TS));
    }

    public KmPropertyCriteria<KmTimestamp> whereClosedUtcTs()
    {
        return new KmPropertyCriteria<KmTimestamp>(context(), fullName(CLOSED_UTC_TS));
    }

    public KmIntegerCriteria whereLockVersion()
    {
        return new KmIntegerCriteria(context(), fullName(LOCK_VERSION));
    }

    //##################################################
    //# associations
    //##################################################

    public MyUserCriteria joinToUser()
    {
        return join(new MyUserCriteria(root().joinTo(USER)));
    }

    public MyUserCriteria leftJoinToUser()
    {
        return join(new MyUserCriteria(root().leftJoinTo(USER)));
    }

    public KmStringCriteria whereUserUid()
    {
        return new KmStringCriteria(context(), fullName(USER_UID));
    }

    //##################################################
    //# junction
    //##################################################

    public MyPasswordResetJunction addAnd()
    {
        return new MyPasswordResetJunction(context().addAnd(), parent());
    }

    public MyPasswordResetJunction addOr()
    {
        return new MyPasswordResetJunction(context().addOr(), parent());
    }

}
