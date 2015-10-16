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

public class MySalesOrderContactJunction
    extends KmhModelJunction
    implements MySalesOrderContactDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MySalesOrderContactJunction(KmhJunction context)
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

    public KmhStringCondition whereTitle()
    {
        return new KmhStringCondition(context(), fullName(TITLE));
    }

    public KmhStringCondition wherePhone()
    {
        return new KmhStringCondition(context(), fullName(PHONE));
    }

    public KmhStringCondition whereEmail()
    {
        return new KmhStringCondition(context(), fullName(EMAIL));
    }

    public KmhBooleanCondition whereOrderNotifications()
    {
        return new KmhBooleanCondition(context(), fullName(ORDER_NOTIFICATIONS));
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

    public MySalesOrderContactJunction addAnd()
    {
        return new MySalesOrderContactJunction(context().addAnd());
    }

    public MySalesOrderContactJunction addOr()
    {
        return new MySalesOrderContactJunction(context().addOr());
    }

}
