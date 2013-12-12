//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.criteria;

import com.kodemore.hibernate.criteria.KmAbstractCriteria;
import com.kodemore.hibernate.criteria.KmBooleanCriteria;
import com.kodemore.hibernate.criteria.KmIntegerCriteria;
import com.kodemore.hibernate.criteria.KmJunction;
import com.kodemore.hibernate.criteria.KmModelJunction;
import com.kodemore.hibernate.criteria.KmStringCriteria;

import com.app.dao.base.MyUserDaoConstantsIF;
import com.app.model.MyUser;

public class MyUserJunction
    extends KmModelJunction<MyUser>
    implements MyUserDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyUserJunction(KmJunction context)
    {
        super(context);
    }

    public MyUserJunction(KmJunction context, KmAbstractCriteria parent)
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

    public KmStringCriteria whereName()
    {
        return new KmStringCriteria(context(), fullName(NAME));
    }

    public KmStringCriteria whereEmail()
    {
        return new KmStringCriteria(context(), fullName(EMAIL));
    }

    public KmBooleanCriteria whereVerified()
    {
        return new KmBooleanCriteria(context(), fullName(VERIFIED));
    }

    public KmStringCriteria wherePasswordSalt()
    {
        return new KmStringCriteria(context(), fullName(PASSWORD_SALT));
    }

    public KmStringCriteria wherePasswordHash()
    {
        return new KmStringCriteria(context(), fullName(PASSWORD_HASH));
    }

    public KmStringCriteria whereTimeZoneCode()
    {
        return new KmStringCriteria(context(), fullName(TIME_ZONE_CODE));
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

    //##################################################
    //# junction
    //##################################################

    public MyUserJunction addAnd()
    {
        return new MyUserJunction(context().addAnd(), parent());
    }

    public MyUserJunction addOr()
    {
        return new MyUserJunction(context().addOr(), parent());
    }

}
