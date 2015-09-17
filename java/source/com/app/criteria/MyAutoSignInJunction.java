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

public class MyAutoSignInJunction
    extends KmhModelJunction
    implements MyAutoSignInDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyAutoSignInJunction(KmhJunction context)
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

    public KmhPropertyCondition<KmTimestamp> whereCreatedUtcTs()
    {
        return new KmhPropertyCondition<>(context(), fullName(CREATED_UTC_TS));
    }

    public KmhPropertyCondition<KmTimestamp> whereLastTouchedUtcTs()
    {
        return new KmhPropertyCondition<>(context(), fullName(LAST_TOUCHED_UTC_TS));
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

    public MyAutoSignInJunction addAnd()
    {
        return new MyAutoSignInJunction(context().addAnd());
    }

    public MyAutoSignInJunction addOr()
    {
        return new MyAutoSignInJunction(context().addOr());
    }

}
