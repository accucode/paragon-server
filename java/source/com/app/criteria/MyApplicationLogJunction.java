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

public class MyApplicationLogJunction
    extends KmhModelJunction
    implements MyApplicationLogDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyApplicationLogJunction(KmhJunction context)
    {
        super(context);
    }

    //##################################################
    //# properties
    //##################################################

    public KmhStringCondition whereContext()
    {
        return new KmhStringCondition(context(), alias(), CONTEXT);
    }

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), CREATED_UTC_TS);
    }

    public KmhIntegerCondition whereLevelCode()
    {
        return new KmhIntegerCondition(context(), alias(), LEVEL_CODE);
    }

    public KmhStringCondition whereLevelName()
    {
        return new KmhStringCondition(context(), alias(), LEVEL_NAME);
    }

    public KmhStringCondition whereLoggerName()
    {
        return new KmhStringCondition(context(), alias(), LOGGER_NAME);
    }

    public KmhStringCondition whereMessage()
    {
        return new KmhStringCondition(context(), alias(), MESSAGE);
    }

    public KmhStringCondition whereThreadName()
    {
        return new KmhStringCondition(context(), alias(), THREAD_NAME);
    }

    public KmhStringCondition whereTrace()
    {
        return new KmhStringCondition(context(), alias(), TRACE);
    }

    public KmhStringCondition whereUid()
    {
        return new KmhStringCondition(context(), alias(), UID);
    }

    //##################################################
    //# associations
    //##################################################

    //##################################################
    //# junction
    //##################################################

    public MyApplicationLogJunction addAnd()
    {
        return new MyApplicationLogJunction(context().addAnd());
    }

    public MyApplicationLogJunction addOr()
    {
        return new MyApplicationLogJunction(context().addOr());
    }

}
