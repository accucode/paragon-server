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
import com.kodemore.hibernate.criteria.*;
import com.kodemore.time.*;
import com.kodemore.types.*;

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.meta.*;

public class MyPerformanceLogJunction
    extends KmModelJunction
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
        return new KmPropertyCriteria<>(context(), fullName(CREATED_UTC_TS));
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
