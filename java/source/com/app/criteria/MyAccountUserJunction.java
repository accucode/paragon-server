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
