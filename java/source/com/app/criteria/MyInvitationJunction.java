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

public class MyInvitationJunction
    extends KmModelJunction
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

    public KmStringCriteria whereTypeCode()
    {
        return new KmStringCriteria(context(), fullName(TYPE_CODE));
    }

    public KmStringCriteria whereStatusCode()
    {
        return new KmStringCriteria(context(), fullName(STATUS_CODE));
    }

    public KmPropertyCriteria<KmTimestamp> whereCreatedUtcTs()
    {
        return new KmPropertyCriteria<>(context(), fullName(CREATED_UTC_TS));
    }

    public KmPropertyCriteria<KmTimestamp> whereClosedUtcTs()
    {
        return new KmPropertyCriteria<>(context(), fullName(CLOSED_UTC_TS));
    }

    public KmStringCriteria whereToEmail()
    {
        return new KmStringCriteria(context(), fullName(TO_EMAIL));
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

    public MyUserCriteria joinToFromUser()
    {
        return join(new MyUserCriteria(root().joinTo(FROM_USER)));
    }

    public MyUserCriteria leftJoinToFromUser()
    {
        return join(new MyUserCriteria(root().leftJoinTo(FROM_USER)));
    }

    public KmStringCriteria whereFromUserUid()
    {
        return new KmStringCriteria(context(), fullName(FROM_USER_UID));
    }

    public MyProjectCriteria joinToProject()
    {
        return join(new MyProjectCriteria(root().joinTo(PROJECT)));
    }

    public MyProjectCriteria leftJoinToProject()
    {
        return join(new MyProjectCriteria(root().leftJoinTo(PROJECT)));
    }

    public KmStringCriteria whereProjectUid()
    {
        return new KmStringCriteria(context(), fullName(PROJECT_UID));
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
