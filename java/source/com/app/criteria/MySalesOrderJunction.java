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

public class MySalesOrderJunction
    extends KmhModelJunction
    implements MySalesOrderDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MySalesOrderJunction(KmhJunction context)
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

    public KmhStringCondition whereNumber()
    {
        return new KmhStringCondition(context(), fullName(NUMBER));
    }

    public KmhStringCondition whereStatusCode()
    {
        return new KmhStringCondition(context(), fullName(STATUS_CODE));
    }

    public KmhTimestampCondition whereHoldUntilUtcTs()
    {
        return new KmhTimestampCondition(context(), fullName(HOLD_UNTIL_UTC_TS));
    }

    public KmhBooleanCondition whereExpedite()
    {
        return new KmhBooleanCondition(context(), fullName(EXPEDITE));
    }

    public KmhBooleanCondition whereTaxExempt()
    {
        return new KmhBooleanCondition(context(), fullName(TAX_EXEMPT));
    }

    public KmhPropertyCondition<Double> whereTaxRate()
    {
        return new KmhPropertyCondition<>(context(), fullName(TAX_RATE));
    }

    public KmhPropertyCondition<Double> whereDiscountRate()
    {
        return new KmhPropertyCondition<>(context(), fullName(DISCOUNT_RATE));
    }

    public KmhPropertyCondition<KmMoney> whereTotalPrice()
    {
        return new KmhPropertyCondition<>(context(), fullName(TOTAL_PRICE));
    }

    public KmhPropertyCondition<KmMoney> whereTotalTax()
    {
        return new KmhPropertyCondition<>(context(), fullName(TOTAL_TAX));
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

    public MySalesOrderJunction addAnd()
    {
        return new MySalesOrderJunction(context().addAnd());
    }

    public MySalesOrderJunction addOr()
    {
        return new MySalesOrderJunction(context().addOr());
    }

}
