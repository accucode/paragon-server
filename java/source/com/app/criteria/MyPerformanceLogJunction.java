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

public class MyPerformanceLogJunction
    extends KmhModelJunction
    implements MyPerformanceLogDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyPerformanceLogJunction(KmhJunction context)
    {
        super(context);
    }

    //##################################################
    //# properties
    //##################################################

    public KmhIntegerCondition whereId()
    {
        return new KmhIntegerCondition(context(), fullName(ID));
    }

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), fullName(NAME));
    }

    public KmhPropertyCondition<KmTimestamp> whereCreatedUtcTs()
    {
        return new KmhPropertyCondition<>(context(), fullName(CREATED_UTC_TS));
    }

    public KmhIntegerCondition whereDurationMs()
    {
        return new KmhIntegerCondition(context(), fullName(DURATION_MS));
    }

    //##################################################
    //# associations
    //##################################################

    //##################################################
    //# junction
    //##################################################

    public MyPerformanceLogJunction addAnd()
    {
        return new MyPerformanceLogJunction(context().addAnd());
    }

    public MyPerformanceLogJunction addOr()
    {
        return new MyPerformanceLogJunction(context().addOr());
    }

}
