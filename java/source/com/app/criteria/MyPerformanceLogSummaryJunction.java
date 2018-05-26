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

public class MyPerformanceLogSummaryJunction
    extends KmhModelJunction
    implements MyPerformanceLogSummaryDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyPerformanceLogSummaryJunction(KmhJunction context)
    {
        super(context);
    }

    //##################################################
    //# properties
    //##################################################

    public KmhIntegerCondition whereAverageMs()
    {
        return new KmhIntegerCondition(context(), alias(), AVERAGE_MS);
    }

    public KmhIntegerCondition whereCount()
    {
        return new KmhIntegerCondition(context(), alias(), COUNT);
    }

    public KmhIntegerCondition whereMaximumMs()
    {
        return new KmhIntegerCondition(context(), alias(), MAXIMUM_MS);
    }

    public KmhIntegerCondition whereMinimumMs()
    {
        return new KmhIntegerCondition(context(), alias(), MINIMUM_MS);
    }

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), alias(), NAME);
    }

    public KmhIntegerCondition whereTotalMs()
    {
        return new KmhIntegerCondition(context(), alias(), TOTAL_MS);
    }

    public KmhStringCondition whereUid()
    {
        return new KmhStringCondition(context(), alias(), UID);
    }

    public KmhDateCondition whereUtcDate()
    {
        return new KmhDateCondition(context(), alias(), UTC_DATE);
    }

    //##################################################
    //# associations
    //##################################################

    //##################################################
    //# junction
    //##################################################

    public MyPerformanceLogSummaryJunction addAnd()
    {
        return new MyPerformanceLogSummaryJunction(context().addAnd());
    }

    public MyPerformanceLogSummaryJunction addOr()
    {
        return new MyPerformanceLogSummaryJunction(context().addOr());
    }

}
