//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.criteria;

import com.app.dao.base.MyAccountUserDaoConstantsIF;
import com.app.model.MyAccountUser;

import com.kodemore.hibernate.criteria.KmAbstractCriteria;
import com.kodemore.hibernate.criteria.KmIntegerCriteria;
import com.kodemore.hibernate.criteria.KmJunction;
import com.kodemore.hibernate.criteria.KmModelJunction;
import com.kodemore.hibernate.criteria.KmStringCriteria;

public class MyAccountUserJunction
    extends KmModelJunction<MyAccountUser>
    implements MyAccountUserDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyAccountUserJunction(KmJunction context)
    {
        super(context);
    }

    public MyAccountUserJunction(KmJunction context, KmAbstractCriteria parent)
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

    public KmStringCriteria whereRoleCode()
    {
        return new KmStringCriteria(context(), fullName(ROLE_CODE));
    }

    public KmIntegerCriteria whereLockVersion()
    {
        return new KmIntegerCriteria(context(), fullName(LOCK_VERSION));
    }

    //##################################################
    //# associations
    //##################################################

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

    public MyAccountUserJunction addAnd()
    {
        return new MyAccountUserJunction(context().addAnd(), parent());
    }

    public MyAccountUserJunction addOr()
    {
        return new MyAccountUserJunction(context().addOr(), parent());
    }

}
