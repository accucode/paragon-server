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

public class MyProductJunction
    extends KmhModelJunction
    implements MyProductDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyProductJunction(KmhJunction context)
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

    public KmhStringCondition whereStatusCode()
    {
        return new KmhStringCondition(context(), fullName(STATUS_CODE));
    }

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), fullName(NAME));
    }

    public KmhStringCondition whereDescription()
    {
        return new KmhStringCondition(context(), fullName(DESCRIPTION));
    }

    public KmhPropertyCondition<KmMoney> whereListPrice()
    {
        return new KmhPropertyCondition<>(context(), fullName(LIST_PRICE));
    }

    public KmhBooleanCondition whereDiscountable()
    {
        return new KmhBooleanCondition(context(), fullName(DISCOUNTABLE));
    }

    public KmhBooleanCondition whereTaxable()
    {
        return new KmhBooleanCondition(context(), fullName(TAXABLE));
    }

    public KmhPropertyCondition<KmMoney> whereCost()
    {
        return new KmhPropertyCondition<>(context(), fullName(COST));
    }

    public KmhBooleanCondition whereRequiresShip()
    {
        return new KmhBooleanCondition(context(), fullName(REQUIRES_SHIP));
    }

    public KmhStringCondition whereShipInstruction()
    {
        return new KmhStringCondition(context(), fullName(SHIP_INSTRUCTION));
    }

    public KmhStringCondition wherePickInstruction()
    {
        return new KmhStringCondition(context(), fullName(PICK_INSTRUCTION));
    }

    public KmhIntegerCondition whereNetworkPortsProduced()
    {
        return new KmhIntegerCondition(context(), fullName(NETWORK_PORTS_PRODUCED));
    }

    public KmhIntegerCondition whereNetworkPortsConsumed()
    {
        return new KmhIntegerCondition(context(), fullName(NETWORK_PORTS_CONSUMED));
    }

    public KmhIntegerCondition wherePoePortsProduced()
    {
        return new KmhIntegerCondition(context(), fullName(POE_PORTS_PRODUCED));
    }

    public KmhIntegerCondition wherePoePortsConsumed()
    {
        return new KmhIntegerCondition(context(), fullName(POE_PORTS_CONSUMED));
    }

    public KmhIntegerCondition whereVendorPartNumber()
    {
        return new KmhIntegerCondition(context(), fullName(VENDOR_PART_NUMBER));
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

    public MyProductJunction addAnd()
    {
        return new MyProductJunction(context().addAnd());
    }

    public MyProductJunction addOr()
    {
        return new MyProductJunction(context().addOr());
    }

}
