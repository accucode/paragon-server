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

    public KmPropertyCriteria<KmHtmlColor> whereFavoriteColor()
    {
        return new KmPropertyCriteria<KmHtmlColor>(context(), fullName(FAVORITE_COLOR));
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
