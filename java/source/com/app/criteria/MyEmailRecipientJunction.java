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

public class MyEmailRecipientJunction
    extends KmhModelJunction
    implements MyEmailRecipientDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyEmailRecipientJunction(KmhJunction context)
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

    public KmhStringCondition whereAddress()
    {
        return new KmhStringCondition(context(), fullName(ADDRESS));
    }

    public KmhStringCondition whereTypeCode()
    {
        return new KmhStringCondition(context(), fullName(TYPE_CODE));
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

    public MyEmailRecipientJunction addAnd()
    {
        return new MyEmailRecipientJunction(context().addAnd());
    }

    public MyEmailRecipientJunction addOr()
    {
        return new MyEmailRecipientJunction(context().addOr());
    }

}
