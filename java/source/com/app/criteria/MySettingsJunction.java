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

public class MySettingsJunction
    extends KmhModelJunction
    implements MySettingsDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MySettingsJunction(KmhJunction context)
    {
        super(context);
    }

    //##################################################
    //# properties
    //##################################################

    public KmhIntegerCondition whereCode()
    {
        return new KmhIntegerCondition(context(), fullName(CODE));
    }

    public KmhStringCondition whereSomeMessage()
    {
        return new KmhStringCondition(context(), fullName(SOME_MESSAGE));
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

    public MySettingsJunction addAnd()
    {
        return new MySettingsJunction(context().addAnd());
    }

    public MySettingsJunction addOr()
    {
        return new MySettingsJunction(context().addOr());
    }

}
