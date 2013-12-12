//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.criteria;

import com.kodemore.hibernate.criteria.KmAbstractCriteria;
import com.kodemore.hibernate.criteria.KmIntegerCriteria;
import com.kodemore.hibernate.criteria.KmJunction;
import com.kodemore.hibernate.criteria.KmModelJunction;
import com.kodemore.hibernate.criteria.KmStringCriteria;

import com.app.dao.base.MyEmailRecipientDaoConstantsIF;
import com.app.model.MyEmailRecipient;

public class MyEmailRecipientJunction
    extends KmModelJunction<MyEmailRecipient>
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
