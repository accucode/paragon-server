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

public class MyEmailJunction
    extends KmhModelJunction
    implements MyEmailDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyEmailJunction(KmhJunction context)
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

    public KmhTimestampCondition whereUpdatedUtcTs()
    {
        return new KmhTimestampCondition(context(), fullName(UPDATED_UTC_TS));
    }

    public KmhTimestampCondition whereSentUtcTs()
    {
        return new KmhTimestampCondition(context(), fullName(SENT_UTC_TS));
    }

    public KmhStringCondition whereSubject()
    {
        return new KmhStringCondition(context(), fullName(SUBJECT));
    }

    public KmhStringCondition whereFromAddress()
    {
        return new KmhStringCondition(context(), fullName(FROM_ADDRESS));
    }

    public KmhStringCondition whereStatusCode()
    {
        return new KmhStringCondition(context(), fullName(STATUS_CODE));
    }

    public KmhStringCondition whereErrorNotes()
    {
        return new KmhStringCondition(context(), fullName(ERROR_NOTES));
    }

    public KmhIntegerCondition whereLockVersion()
    {
        return new KmhIntegerCondition(context(), fullName(LOCK_VERSION));
    }

    //##################################################
    //# associations
    //##################################################

    //##################################################
    //# junction
    //##################################################

    public MyEmailJunction addAnd()
    {
        return new MyEmailJunction(context().addAnd());
    }

    public MyEmailJunction addOr()
    {
        return new MyEmailJunction(context().addOr());
    }

}
