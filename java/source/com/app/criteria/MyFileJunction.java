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

public class MyFileJunction
    extends KmhModelJunction
    implements MyFileDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyFileJunction(KmhJunction context)
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

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), fullName(NAME));
    }

    public KmhStringCondition wherePath()
    {
        return new KmhStringCondition(context(), fullName(PATH));
    }

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), fullName(CREATED_UTC_TS));
    }

    public KmhStringCondition whereStatusCode()
    {
        return new KmhStringCondition(context(), fullName(STATUS_CODE));
    }

    public KmhIntegerCondition whereSize()
    {
        return new KmhIntegerCondition(context(), fullName(SIZE));
    }

    public KmhIntegerCondition wherePartialSize()
    {
        return new KmhIntegerCondition(context(), fullName(PARTIAL_SIZE));
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

    public MyFileJunction addAnd()
    {
        return new MyFileJunction(context().addAnd());
    }

    public MyFileJunction addOr()
    {
        return new MyFileJunction(context().addOr());
    }

}
