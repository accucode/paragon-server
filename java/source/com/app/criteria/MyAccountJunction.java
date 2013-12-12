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

import com.app.dao.base.MyAccountDaoConstantsIF;
import com.app.model.MyAccount;

public class MyAccountJunction
    extends KmModelJunction<MyAccount>
    implements MyAccountDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyAccountJunction(KmJunction context)
    {
        super(context);
    }

    public MyAccountJunction(KmJunction context, KmAbstractCriteria parent)
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

    //##################################################
    //# junction
    //##################################################

    public MyAccountJunction addAnd()
    {
        return new MyAccountJunction(context().addAnd(), parent());
    }

    public MyAccountJunction addOr()
    {
        return new MyAccountJunction(context().addOr(), parent());
    }

}
