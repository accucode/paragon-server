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

public class MyAttributeFieldJunction
    extends KmhModelJunction
    implements MyAttributeFieldDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyAttributeFieldJunction(KmhJunction context)
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

    public KmhStringCondition whereCategoryCode()
    {
        return new KmhStringCondition(context(), fullName(CATEGORY_CODE));
    }

    public KmhStringCondition whereName()
    {
        return new KmhStringCondition(context(), fullName(NAME));
    }

    public KmhBooleanCondition whereActive()
    {
        return new KmhBooleanCondition(context(), fullName(ACTIVE));
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

    public MyAttributeFieldJunction addAnd()
    {
        return new MyAttributeFieldJunction(context().addAnd());
    }

    public MyAttributeFieldJunction addOr()
    {
        return new MyAttributeFieldJunction(context().addOr());
    }

}
