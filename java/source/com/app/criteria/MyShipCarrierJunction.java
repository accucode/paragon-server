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

public class MyShipCarrierJunction
    extends KmModelJunction
    implements MyShipCarrierDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyShipCarrierJunction(KmJunction context)
    {
        super(context);
    }

    public MyShipCarrierJunction(KmJunction context, KmAbstractCriteria parent)
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

    public MyProjectCriteria joinToProject()
    {
        return join(new MyProjectCriteria(root().joinTo(PROJECT)));
    }

    public MyProjectCriteria leftJoinToProject()
    {
        return join(new MyProjectCriteria(root().leftJoinTo(PROJECT)));
    }

    public KmStringCriteria whereProjectUid()
    {
        return new KmStringCriteria(context(), fullName(PROJECT_UID));
    }

    //##################################################
    //# junction
    //##################################################

    public MyShipCarrierJunction addAnd()
    {
        return new MyShipCarrierJunction(context().addAnd(), parent());
    }

    public MyShipCarrierJunction addOr()
    {
        return new MyShipCarrierJunction(context().addOr(), parent());
    }

}
