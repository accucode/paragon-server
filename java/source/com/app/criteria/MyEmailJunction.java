//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.criteria;

import com.app.dao.base.MyEmailDaoConstantsIF;
import com.app.model.MyEmail;

import com.kodemore.hibernate.criteria.KmAbstractCriteria;
import com.kodemore.hibernate.criteria.KmIntegerCriteria;
import com.kodemore.hibernate.criteria.KmJunction;
import com.kodemore.hibernate.criteria.KmModelJunction;
import com.kodemore.hibernate.criteria.KmPropertyCriteria;
import com.kodemore.hibernate.criteria.KmStringCriteria;
import com.kodemore.time.KmTimestamp;

public class MyEmailJunction
    extends KmModelJunction<MyEmail>
    implements MyEmailDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyEmailJunction(KmJunction context)
    {
        super(context);
    }

    public MyEmailJunction(KmJunction context, KmAbstractCriteria parent)
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

    public KmPropertyCriteria<KmTimestamp> whereCreatedUtcTs()
    {
        return new KmPropertyCriteria<KmTimestamp>(context(), fullName(CREATED_UTC_TS));
    }

    public KmPropertyCriteria<KmTimestamp> whereSentUtcTs()
    {
        return new KmPropertyCriteria<KmTimestamp>(context(), fullName(SENT_UTC_TS));
    }

    public KmStringCriteria whereSubject()
    {
        return new KmStringCriteria(context(), fullName(SUBJECT));
    }

    public KmStringCriteria whereFromAddress()
    {
        return new KmStringCriteria(context(), fullName(FROM_ADDRESS));
    }

    public KmStringCriteria whereStatusCode()
    {
        return new KmStringCriteria(context(), fullName(STATUS_CODE));
    }

    public KmStringCriteria whereErrorNotes()
    {
        return new KmStringCriteria(context(), fullName(ERROR_NOTES));
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

    public MyEmailJunction addAnd()
    {
        return new MyEmailJunction(context().addAnd(), parent());
    }

    public MyEmailJunction addOr()
    {
        return new MyEmailJunction(context().addOr(), parent());
    }

}
