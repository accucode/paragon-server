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

public class MySystemLogTraceJunction
    extends KmModelJunction<MySystemLogTrace>
    implements MySystemLogTraceDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MySystemLogTraceJunction(KmJunction context)
    {
        super(context);
    }

    public MySystemLogTraceJunction(KmJunction context, KmAbstractCriteria parent)
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

    public MySystemLogCriteria joinToLog()
    {
        return join(new MySystemLogCriteria(root().joinTo(LOG)));
    }

    public MySystemLogCriteria leftJoinToLog()
    {
        return join(new MySystemLogCriteria(root().leftJoinTo(LOG)));
    }

    public KmIntegerCriteria whereLogId()
    {
        return new KmIntegerCriteria(context(), fullName(LOG_ID));
    }

    //##################################################
    //# junction
    //##################################################

    public MySystemLogTraceJunction addAnd()
    {
        return new MySystemLogTraceJunction(context().addAnd(), parent());
    }

    public MySystemLogTraceJunction addOr()
    {
        return new MySystemLogTraceJunction(context().addOr(), parent());
    }

}
