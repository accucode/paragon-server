//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.criteria;

import com.app.dao.base.MyServerSessionDaoConstantsIF;
import com.app.model.MyServerSession;

import com.kodemore.hibernate.criteria.KmAbstractCriteria;
import com.kodemore.hibernate.criteria.KmBooleanCriteria;
import com.kodemore.hibernate.criteria.KmIntegerCriteria;
import com.kodemore.hibernate.criteria.KmJunction;
import com.kodemore.hibernate.criteria.KmModelJunction;
import com.kodemore.hibernate.criteria.KmPropertyCriteria;
import com.kodemore.hibernate.criteria.KmStringCriteria;
import com.kodemore.time.KmTimestamp;

public class MyServerSessionJunction
    extends KmModelJunction<MyServerSession>
    implements MyServerSessionDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyServerSessionJunction(KmJunction context)
    {
        super(context);
    }

    public MyServerSessionJunction(KmJunction context, KmAbstractCriteria parent)
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

    public KmBooleanCriteria whereActive()
    {
        return new KmBooleanCriteria(context(), fullName(ACTIVE));
    }

    public KmPropertyCriteria<KmTimestamp> whereCreatedUtcTs()
    {
        return new KmPropertyCriteria<KmTimestamp>(context(), fullName(CREATED_UTC_TS));
    }

    public KmPropertyCriteria<KmTimestamp> whereClosedUtcTs()
    {
        return new KmPropertyCriteria<KmTimestamp>(context(), fullName(CLOSED_UTC_TS));
    }

    public KmPropertyCriteria<KmTimestamp> whereLastTouchedUtcTs()
    {
        return new KmPropertyCriteria<KmTimestamp>(context(), fullName(LAST_TOUCHED_UTC_TS));
    }

    public KmStringCriteria whereVersion()
    {
        return new KmStringCriteria(context(), fullName(VERSION));
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

    public MyAutoSignInCriteria joinToAutoSignIn()
    {
        return join(new MyAutoSignInCriteria(root().joinTo(AUTO_SIGN_IN)));
    }

    public MyAutoSignInCriteria leftJoinToAutoSignIn()
    {
        return join(new MyAutoSignInCriteria(root().leftJoinTo(AUTO_SIGN_IN)));
    }

    public KmStringCriteria whereAutoSignInUid()
    {
        return new KmStringCriteria(context(), fullName(AUTO_SIGN_IN_UID));
    }

    public MyAccountCriteria joinToAccount()
    {
        return join(new MyAccountCriteria(root().joinTo(ACCOUNT)));
    }

    public MyAccountCriteria leftJoinToAccount()
    {
        return join(new MyAccountCriteria(root().leftJoinTo(ACCOUNT)));
    }

    public KmStringCriteria whereAccountUid()
    {
        return new KmStringCriteria(context(), fullName(ACCOUNT_UID));
    }

    //##################################################
    //# junction
    //##################################################

    public MyServerSessionJunction addAnd()
    {
        return new MyServerSessionJunction(context().addAnd(), parent());
    }

    public MyServerSessionJunction addOr()
    {
        return new MyServerSessionJunction(context().addOr(), parent());
    }

}
