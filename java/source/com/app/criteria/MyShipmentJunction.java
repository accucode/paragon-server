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

public class MyShipmentJunction
    extends KmhModelJunction
    implements MyShipmentDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyShipmentJunction(KmhJunction context)
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

    public KmhStringCondition whereTrackingNumber()
    {
        return new KmhStringCondition(context(), fullName(TRACKING_NUMBER));
    }

    public KmhPropertyCondition<Double> whereWeight()
    {
        return new KmhPropertyCondition<>(context(), fullName(WEIGHT));
    }

    public KmhPropertyCondition<KmMoney> whereCost()
    {
        return new KmhPropertyCondition<>(context(), fullName(COST));
    }

    public KmhBooleanCondition whereInvoiceCustomer()
    {
        return new KmhBooleanCondition(context(), fullName(INVOICE_CUSTOMER));
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

    public MyShipmentJunction addAnd()
    {
        return new MyShipmentJunction(context().addAnd());
    }

    public MyShipmentJunction addOr()
    {
        return new MyShipmentJunction(context().addOr());
    }

}
