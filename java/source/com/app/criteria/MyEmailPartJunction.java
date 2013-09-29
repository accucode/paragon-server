//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.criteria;

import com.app.dao.base.MyEmailPartDaoConstantsIF;
import com.app.model.MyEmailPart;

import com.kodemore.collection.KmBlob;
import com.kodemore.hibernate.criteria.KmAbstractCriteria;
import com.kodemore.hibernate.criteria.KmIntegerCriteria;
import com.kodemore.hibernate.criteria.KmJunction;
import com.kodemore.hibernate.criteria.KmModelJunction;
import com.kodemore.hibernate.criteria.KmPropertyCriteria;
import com.kodemore.hibernate.criteria.KmStringCriteria;

public class MyEmailPartJunction
    extends KmModelJunction<MyEmailPart>
    implements MyEmailPartDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyEmailPartJunction(KmJunction context)
    {
        super(context);
    }

    public MyEmailPartJunction(KmJunction context, KmAbstractCriteria parent)
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

    public KmIntegerCriteria whereSequence()
    {
        return new KmIntegerCriteria(context(), fullName(SEQUENCE));
    }

    public KmStringCriteria whereTypeCode()
    {
        return new KmStringCriteria(context(), fullName(TYPE_CODE));
    }

    public KmStringCriteria whereAttachmentName()
    {
        return new KmStringCriteria(context(), fullName(ATTACHMENT_NAME));
    }

    public KmPropertyCriteria<KmBlob> whereData()
    {
        return new KmPropertyCriteria<KmBlob>(context(), fullName(DATA));
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

    public MyEmailPartJunction addAnd()
    {
        return new MyEmailPartJunction(context().addAnd(), parent());
    }

    public MyEmailPartJunction addOr()
    {
        return new MyEmailPartJunction(context().addOr(), parent());
    }

}
