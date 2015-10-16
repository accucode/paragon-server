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

public class MyInvitationJunction
    extends KmhModelJunction
    implements MyInvitationDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyInvitationJunction(KmhJunction context)
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

    public KmhStringCondition whereTypeCode()
    {
        return new KmhStringCondition(context(), fullName(TYPE_CODE));
    }

    public KmhStringCondition whereStatusCode()
    {
        return new KmhStringCondition(context(), fullName(STATUS_CODE));
    }

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), fullName(CREATED_UTC_TS));
    }

    public KmhTimestampCondition whereClosedUtcTs()
    {
        return new KmhTimestampCondition(context(), fullName(CLOSED_UTC_TS));
    }

    public KmhStringCondition whereToEmail()
    {
        return new KmhStringCondition(context(), fullName(TO_EMAIL));
    }

    public KmhStringCondition whereRoleCode()
    {
        return new KmhStringCondition(context(), fullName(ROLE_CODE));
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

    public MyInvitationJunction addAnd()
    {
        return new MyInvitationJunction(context().addAnd());
    }

    public MyInvitationJunction addOr()
    {
        return new MyInvitationJunction(context().addOr());
    }

}
