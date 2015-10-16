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

    public KmhStringCondition whereUid()
    {
        return new KmhStringCondition(context(), fullName(UID));
    }

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), fullName(CREATED_UTC_TS));
    }

    public KmhStringCondition whereLoggerName()
    {
        return new KmhStringCondition(context(), fullName(LOGGER_NAME));
    }

    public KmhStringCondition whereContext()
    {
        return new KmhStringCondition(context(), fullName(CONTEXT));
    }

    public KmhStringCondition whereMessage()
    {
        return new KmhStringCondition(context(), fullName(MESSAGE));
    }

    public KmhStringCondition whereLevelName()
    {
        return new KmhStringCondition(context(), fullName(LEVEL_NAME));
    }

    public KmhIntegerCondition whereLevelCode()
    {
        return new KmhIntegerCondition(context(), fullName(LEVEL_CODE));
    }

    public KmhStringCondition whereThreadName()
    {
        return new KmhStringCondition(context(), fullName(THREAD_NAME));
    }

    public KmhStringCondition whereTrace()
    {
        return new KmhStringCondition(context(), fullName(TRACE));
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
