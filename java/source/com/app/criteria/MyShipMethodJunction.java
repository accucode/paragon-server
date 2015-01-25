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
import com.kodemore.hibernate.criteria.*;
import com.kodemore.time.*;
import com.kodemore.types.*;

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.meta.*;

public class MyShipMethodJunction
    extends KmModelJunction
    implements MyShipMethodDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyShipMethodJunction(KmJunction context)
    {
        super(context);
    }

    public MyShipMethodJunction(KmJunction context, KmAbstractCriteria parent)
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

    public KmIntegerCriteria whereLockVersion()
    {
        return new KmIntegerCriteria(context(), fullName(LOCK_VERSION));
    }

    //##################################################
    //# associations
    //##################################################

    public MyShipCarrierCriteria joinToCarrier()
    {
        return join(new MyShipCarrierCriteria(root().joinTo(CARRIER)));
    }

    public MyShipCarrierCriteria leftJoinToCarrier()
    {
        return join(new MyShipCarrierCriteria(root().leftJoinTo(CARRIER)));
    }

    public KmStringCriteria whereCarrierUid()
    {
        return new KmStringCriteria(context(), fullName(CARRIER_UID));
    }

    //##################################################
    //# junction
    //##################################################

    public MyShipMethodJunction addAnd()
    {
        return new MyShipMethodJunction(context().addAnd(), parent());
    }

    public MyShipMethodJunction addOr()
    {
        return new MyShipMethodJunction(context().addOr(), parent());
    }

}
