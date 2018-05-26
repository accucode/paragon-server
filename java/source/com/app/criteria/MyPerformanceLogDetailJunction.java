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

public class MyPerformanceLogDetailJunction
    extends KmhModelJunction
    implements MyPerformanceLogDetailDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyPerformanceLogDetailJunction(KmhJunction context)
    {
        super(context);
    }

    //##################################################
    //# properties
    //##################################################

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), CREATED_UTC_TS);
    }

    public KmhIntegerCondition whereDurationMs()
    {
        return new KmhIntegerCondition(context(), alias(), DURATION_MS);
    }

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), alias(), NAME);
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

    public MyPerformanceLogDetailJunction addAnd()
    {
        return new MyPerformanceLogDetailJunction(context().addAnd());
    }

    public MyPerformanceLogDetailJunction addOr()
    {
        return new MyPerformanceLogDetailJunction(context().addOr());
    }

}
