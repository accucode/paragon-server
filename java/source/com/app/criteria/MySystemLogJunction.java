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

public class MySystemLogJunction
    extends KmModelJunction<MySystemLog>
    implements MySystemLogDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MySystemLogJunction(KmJunction context)
    {
        super(context);
    }

    public MySystemLogJunction(KmJunction context, KmAbstractCriteria parent)
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

    public KmPropertyCriteria<KmTimestamp> whereCreatedUtcTs()
    {
        return new KmPropertyCriteria<KmTimestamp>(context(), fullName(CREATED_UTC_TS));
    }

    public KmStringCriteria whereLoggerName()
    {
        return new KmStringCriteria(context(), fullName(LOGGER_NAME));
    }

    public KmStringCriteria whereContext()
    {
        return new KmStringCriteria(context(), fullName(CONTEXT));
    }

    public KmStringCriteria whereMessage()
    {
        return new KmStringCriteria(context(), fullName(MESSAGE));
    }

    public KmStringCriteria whereLevelName()
    {
        return new KmStringCriteria(context(), fullName(LEVEL_NAME));
    }

    public KmIntegerCriteria whereLevelCode()
    {
        return new KmIntegerCriteria(context(), fullName(LEVEL_CODE));
    }

    public KmStringCriteria whereThreadName()
    {
        return new KmStringCriteria(context(), fullName(THREAD_NAME));
    }

    public KmStringCriteria whereExceptionText()
    {
        return new KmStringCriteria(context(), fullName(EXCEPTION_TEXT));
    }

    //##################################################
    //# associations
    //##################################################

    //##################################################
    //# junction
    //##################################################

    public MySystemLogJunction addAnd()
    {
        return new MySystemLogJunction(context().addAnd(), parent());
    }

    public MySystemLogJunction addOr()
    {
        return new MySystemLogJunction(context().addOr(), parent());
    }

}
