//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.criteria;

import com.kodemore.hibernate.criteria.KmAbstractCriteria;
import com.kodemore.hibernate.criteria.KmIntegerCriteria;
import com.kodemore.hibernate.criteria.KmJunction;
import com.kodemore.hibernate.criteria.KmModelJunction;
import com.kodemore.hibernate.criteria.KmPropertyCriteria;
import com.kodemore.hibernate.criteria.KmStringCriteria;
import com.kodemore.time.KmTimestamp;

import com.app.dao.base.MyPerformanceLogDaoConstantsIF;
import com.app.model.MyPerformanceLog;

public class MyPerformanceLogJunction
    extends KmModelJunction<MyPerformanceLog>
    implements MyPerformanceLogDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyPerformanceLogJunction(KmJunction context)
    {
        super(context);
    }

    public MyPerformanceLogJunction(KmJunction context, KmAbstractCriteria parent)
    {
        super(context, parent);
    }

    //##################################################
    //# properties
    //##################################################

    public KmIntegerCriteria whereId()
    {
        return new KmIntegerCriteria(context(), fullName(ID));
    }

    public KmStringCriteria whereName()
    {
        return new KmStringCriteria(context(), fullName(NAME));
    }

    public KmPropertyCriteria<KmTimestamp> whereCreatedUtcTs()
    {
        return new KmPropertyCriteria<KmTimestamp>(context(), fullName(CREATED_UTC_TS));
    }

    public KmIntegerCriteria whereDurationMs()
    {
        return new KmIntegerCriteria(context(), fullName(DURATION_MS));
    }

    //##################################################
    //# associations
    //##################################################

    //##################################################
    //# junction
    //##################################################

    public MyPerformanceLogJunction addAnd()
    {
        return new MyPerformanceLogJunction(context().addAnd(), parent());
    }

    public MyPerformanceLogJunction addOr()
    {
        return new MyPerformanceLogJunction(context().addOr(), parent());
    }

}
