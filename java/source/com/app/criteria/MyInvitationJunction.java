//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.criteria;

import com.app.dao.base.MyInvitationDaoConstantsIF;
import com.app.model.MyInvitation;

import com.kodemore.hibernate.criteria.KmAbstractCriteria;
import com.kodemore.hibernate.criteria.KmIntegerCriteria;
import com.kodemore.hibernate.criteria.KmJunction;
import com.kodemore.hibernate.criteria.KmModelJunction;
import com.kodemore.hibernate.criteria.KmPropertyCriteria;
import com.kodemore.hibernate.criteria.KmStringCriteria;
import com.kodemore.time.KmTimestamp;

public class MyInvitationJunction
    extends KmModelJunction<MyInvitation>
    implements MyInvitationDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyInvitationJunction(KmJunction context)
    {
        super(context);
    }

    public MyInvitationJunction(KmJunction context, KmAbstractCriteria parent)
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

    public KmStringCriteria whereTypeCode()
    {
        return new KmStringCriteria(context(), fullName(TYPE_CODE));
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

    public KmStringCriteria whereEmail()
    {
        return new KmStringCriteria(context(), fullName(EMAIL));
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

    public MyInvitationJunction addAnd()
    {
        return new MyInvitationJunction(context().addAnd(), parent());
    }

    public MyInvitationJunction addOr()
    {
        return new MyInvitationJunction(context().addOr(), parent());
    }

}
