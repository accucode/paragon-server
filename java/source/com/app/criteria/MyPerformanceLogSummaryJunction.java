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

    public KmhStringCondition whereUid()
    {
        return new KmhStringCondition(context(), fullName(UID));
    }

    public KmhDateCondition whereUtcDate()
    {
        return new KmhDateCondition(context(), fullName(UTC_DATE));
    }

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), fullName(NAME));
    }

    public KmhIntegerCondition whereCount()
    {
        return new KmhIntegerCondition(context(), fullName(COUNT));
    }

    public KmhIntegerCondition whereMinimumMs()
    {
        return new KmhIntegerCondition(context(), fullName(MINIMUM_MS));
    }

    public KmhIntegerCondition whereMaximumMs()
    {
        return new KmhIntegerCondition(context(), fullName(MAXIMUM_MS));
    }

    public KmhIntegerCondition whereAverageMs()
    {
        return new KmhIntegerCondition(context(), fullName(AVERAGE_MS));
    }

    public KmhIntegerCondition whereTotalMs()
    {
        return new KmhIntegerCondition(context(), fullName(TOTAL_MS));
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
