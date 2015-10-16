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

public class MyOrderNumberJunction
    extends KmhModelJunction
    implements MyOrderNumberDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyOrderNumberJunction(KmhJunction context)
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

    public KmhDateCondition whereDate()
    {
        return new KmhDateCondition(context(), fullName(DATE));
    }

    public KmhIntegerCondition whereNextNumber()
    {
        return new KmhIntegerCondition(context(), fullName(NEXT_NUMBER));
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

    public MyOrderNumberJunction addAnd()
    {
        return new MyOrderNumberJunction(context().addAnd());
    }

    public MyOrderNumberJunction addOr()
    {
        return new MyOrderNumberJunction(context().addOr());
    }

}
