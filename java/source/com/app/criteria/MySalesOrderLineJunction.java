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

public class MySalesOrderLineJunction
    extends KmhModelJunction
    implements MySalesOrderLineDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MySalesOrderLineJunction(KmhJunction context)
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

    public KmhPropertyCondition<KmMoney> whereListPrice()
    {
        return new KmhPropertyCondition<>(context(), fullName(LIST_PRICE));
    }

    public KmhPropertyCondition<KmMoney> whereUnitPrice()
    {
        return new KmhPropertyCondition<>(context(), fullName(UNIT_PRICE));
    }

    public KmhIntegerCondition whereOrderedQuantity()
    {
        return new KmhIntegerCondition(context(), fullName(ORDERED_QUANTITY));
    }

    public KmhIntegerCondition whereFulfilledQuantity()
    {
        return new KmhIntegerCondition(context(), fullName(FULFILLED_QUANTITY));
    }

    public KmhPropertyCondition<KmMoney> whereExtendedPrice()
    {
        return new KmhPropertyCondition<>(context(), fullName(EXTENDED_PRICE));
    }

    public KmhPropertyCondition<KmMoney> wherePriceAdjustment()
    {
        return new KmhPropertyCondition<>(context(), fullName(PRICE_ADJUSTMENT));
    }

    public KmhPropertyCondition<KmMoney> whereAdjustedPrice()
    {
        return new KmhPropertyCondition<>(context(), fullName(ADJUSTED_PRICE));
    }

    public KmhPropertyCondition<KmMoney> whereTax()
    {
        return new KmhPropertyCondition<>(context(), fullName(TAX));
    }

    public KmhPropertyCondition<KmMoney> whereTotalPrice()
    {
        return new KmhPropertyCondition<>(context(), fullName(TOTAL_PRICE));
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

    public MySalesOrderLineJunction addAnd()
    {
        return new MySalesOrderLineJunction(context().addAnd());
    }

    public MySalesOrderLineJunction addOr()
    {
        return new MySalesOrderLineJunction(context().addOr());
    }

}
