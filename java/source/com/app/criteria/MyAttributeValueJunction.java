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

public class MyAttributeValueJunction
    extends KmhModelJunction
    implements MyAttributeValueDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyAttributeValueJunction(KmhJunction context)
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

    public KmhStringCondition whereTextValue()
    {
        return new KmhStringCondition(context(), fullName(TEXT_VALUE));
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

    public MyAttributeValueJunction addAnd()
    {
        return new MyAttributeValueJunction(context().addAnd());
    }

    public MyAttributeValueJunction addOr()
    {
        return new MyAttributeValueJunction(context().addOr());
    }

}
