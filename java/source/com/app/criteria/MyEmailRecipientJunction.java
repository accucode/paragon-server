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

public class MyEmailRecipientJunction
    extends KmModelJunction
    implements MyEmailRecipientDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyEmailRecipientJunction(KmJunction context)
    {
        super(context);
    }

    public MyEmailRecipientJunction(KmJunction context, KmAbstractCriteria parent)
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

    public KmStringCriteria whereAddress()
    {
        return new KmStringCriteria(context(), fullName(ADDRESS));
    }

    public KmStringCriteria whereTypeCode()
    {
        return new KmStringCriteria(context(), fullName(TYPE_CODE));
    }

    public KmIntegerCriteria whereLockVersion()
    {
        return new KmIntegerCriteria(context(), fullName(LOCK_VERSION));
    }

    //##################################################
    //# associations
    //##################################################

    public MyEmailCriteria joinToEmail()
    {
        return join(new MyEmailCriteria(root().joinTo(EMAIL)));
    }

    public MyEmailCriteria leftJoinToEmail()
    {
        return join(new MyEmailCriteria(root().leftJoinTo(EMAIL)));
    }

    public KmStringCriteria whereEmailUid()
    {
        return new KmStringCriteria(context(), fullName(EMAIL_UID));
    }

    //##################################################
    //# junction
    //##################################################

    public MyEmailRecipientJunction addAnd()
    {
        return new MyEmailRecipientJunction(context().addAnd(), parent());
    }

    public MyEmailRecipientJunction addOr()
    {
        return new MyEmailRecipientJunction(context().addOr(), parent());
    }

}
