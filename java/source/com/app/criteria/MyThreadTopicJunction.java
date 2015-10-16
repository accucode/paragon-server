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
        return new KmhStringCondition(context(), fullName(CODE));
    }

    public KmhStringCondition whereOwnerUid()
    {
        return new KmhStringCondition(context(), fullName(OWNER_UID));
    }

    public KmhStringCondition whereHostName()
    {
        return new KmhStringCondition(context(), fullName(HOST_NAME));
    }

    public KmhStringCondition whereHostAddress()
    {
        return new KmhStringCondition(context(), fullName(HOST_ADDRESS));
    }

    public KmhTimestampCondition whereLastStartUtcTs()
    {
        return new KmhTimestampCondition(context(), fullName(LAST_START_UTC_TS));
    }

    public KmhTimestampCondition whereLastEndUtcTs()
    {
        return new KmhTimestampCondition(context(), fullName(LAST_END_UTC_TS));
    }

    public KmhTimestampCondition whereLastTouchUtcTs()
    {
        return new KmhTimestampCondition(context(), fullName(LAST_TOUCH_UTC_TS));
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

    public MyThreadTopicJunction addAnd()
    {
        return new MyThreadTopicJunction(context().addAnd());
    }

    public MyThreadTopicJunction addOr()
    {
        return new MyThreadTopicJunction(context().addOr());
    }

}
