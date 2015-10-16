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

public class MyCustomerTierJunction
    extends KmhModelJunction
    implements MyCustomerTierDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyCustomerTierJunction(KmhJunction context)
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

    public MyCustomerTierJunction addAnd()
    {
        return new MyCustomerTierJunction(context().addAnd());
    }

    public MyCustomerTierJunction addOr()
    {
        return new MyCustomerTierJunction(context().addOr());
    }

}
