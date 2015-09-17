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

public class MyApplicationLogTraceJunction
    extends KmhModelJunction
    implements MyApplicationLogTraceDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyApplicationLogTraceJunction(KmhJunction context)
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

    public KmhIntegerCondition whereSequence()
    {
        return new KmhIntegerCondition(context(), fullName(SEQUENCE));
    }

    public KmhStringCondition whereValue()
    {
        return new KmhStringCondition(context(), fullName(VALUE));
    }

    //##################################################
    //# associations
    //##################################################

    //##################################################
    //# junction
    //##################################################

    public MyApplicationLogTraceJunction addAnd()
    {
        return new MyApplicationLogTraceJunction(context().addAnd());
    }

    public MyApplicationLogTraceJunction addOr()
    {
        return new MyApplicationLogTraceJunction(context().addOr());
    }

}
