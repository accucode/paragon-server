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

public class MyThreadTopicJunction
    extends KmhModelJunction
    implements MyThreadTopicDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyThreadTopicJunction(KmhJunction context)
    {
        super(context);
    }

    //##################################################
    //# properties
    //##################################################

    public KmhStringCondition whereCode()
    {
        return new KmhStringCondition(context(), alias(), CODE);
    }

    public KmhStringCondition whereHostAddress()
    {
        return new KmhStringCondition(context(), alias(), HOST_ADDRESS);
    }

    public KmhStringCondition whereHostName()
    {
        return new KmhStringCondition(context(), alias(), HOST_NAME);
    }

    public KmhTimestampCondition whereLastEndUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), LAST_END_UTC_TS);
    }

    public KmhTimestampCondition whereLastStartUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), LAST_START_UTC_TS);
    }

    public KmhTimestampCondition whereLastTouchUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), LAST_TOUCH_UTC_TS);
    }

    public KmhStringCondition whereOwnerUid()
    {
        return new KmhStringCondition(context(), alias(), OWNER_UID);
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

    public MyThreadTopicJunction addAnd()
    {
        return new MyThreadTopicJunction(context().addAnd());
    }

    public MyThreadTopicJunction addOr()
    {
        return new MyThreadTopicJunction(context().addOr());
    }

}
