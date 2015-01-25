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

public class MyApplicationLogTraceJunction
    extends KmModelJunction
    implements MyApplicationLogTraceDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyApplicationLogTraceJunction(KmJunction context)
    {
        super(context);
    }

    public MyApplicationLogTraceJunction(KmJunction context, KmAbstractCriteria parent)
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

    public KmIntegerCriteria whereSequence()
    {
        return new KmIntegerCriteria(context(), fullName(SEQUENCE));
    }

    public KmStringCriteria whereValue()
    {
        return new KmStringCriteria(context(), fullName(VALUE));
    }

    //##################################################
    //# associations
    //##################################################

    public MyApplicationLogCriteria joinToLog()
    {
        return join(new MyApplicationLogCriteria(root().joinTo(LOG)));
    }

    public MyApplicationLogCriteria leftJoinToLog()
    {
        return join(new MyApplicationLogCriteria(root().leftJoinTo(LOG)));
    }

    public KmIntegerCriteria whereLogId()
    {
        return new KmIntegerCriteria(context(), fullName(LOG_ID));
    }

    //##################################################
    //# junction
    //##################################################

    public MyApplicationLogTraceJunction addAnd()
    {
        return new MyApplicationLogTraceJunction(context().addAnd(), parent());
    }

    public MyApplicationLogTraceJunction addOr()
    {
        return new MyApplicationLogTraceJunction(context().addOr(), parent());
    }

}
