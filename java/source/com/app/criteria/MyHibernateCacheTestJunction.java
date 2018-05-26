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

public class MyHibernateCacheTestJunction
    extends KmhModelJunction
    implements MyHibernateCacheTestDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyHibernateCacheTestJunction(KmhJunction context)
    {
        super(context);
    }

    //##################################################
    //# properties
    //##################################################

    public KmhStringCondition whereData()
    {
        return new KmhStringCondition(context(), alias(), DATA);
    }

    public KmhStringCondition whereUid()
    {
        return new KmhStringCondition(context(), alias(), UID);
    }

    public KmhIntegerCondition whereLockVersion()
    {
        return new KmhIntegerCondition(context(), alias(), LOCK_VERSION);
    }

    //##################################################
    //# associations
    //##################################################

    //##################################################
    //# junction
    //##################################################

    public MyHibernateCacheTestJunction addAnd()
    {
        return new MyHibernateCacheTestJunction(context().addAnd());
    }

    public MyHibernateCacheTestJunction addOr()
    {
        return new MyHibernateCacheTestJunction(context().addOr());
    }

}
