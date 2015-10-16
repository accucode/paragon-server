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

public class MyCustomerJunction
    extends KmhModelJunction
    implements MyCustomerDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyCustomerJunction(KmhJunction context)
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

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), fullName(NAME));
    }

    public KmhPropertyCondition<Double> whereDiscountRate()
    {
        return new KmhPropertyCondition<>(context(), fullName(DISCOUNT_RATE));
    }

    public KmhStringCondition whereAddressStreet1()
    {
        return new KmhStringCondition(context(), fullName(ADDRESS_STREET_1));
    }

    public KmhStringCondition whereAddressStreet2()
    {
        return new KmhStringCondition(context(), fullName(ADDRESS_STREET_2));
    }

    public KmhStringCondition whereAddressCity()
    {
        return new KmhStringCondition(context(), fullName(ADDRESS_CITY));
    }

    public KmhStringCondition whereAddressRegion()
    {
        return new KmhStringCondition(context(), fullName(ADDRESS_REGION));
    }

    public KmhStringCondition whereAddressPostalCode()
    {
        return new KmhStringCondition(context(), fullName(ADDRESS_POSTAL_CODE));
    }

    public KmhStringCondition whereAddressCountry()
    {
        return new KmhStringCondition(context(), fullName(ADDRESS_COUNTRY));
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

    public MyCustomerJunction addAnd()
    {
        return new MyCustomerJunction(context().addAnd());
    }

    public MyCustomerJunction addOr()
    {
        return new MyCustomerJunction(context().addOr());
    }

}
