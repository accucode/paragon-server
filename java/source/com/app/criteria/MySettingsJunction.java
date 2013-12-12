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

public class MySettingsJunction
    extends KmModelJunction<MySettings>
    implements MySettingsDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MySettingsJunction(KmJunction context)
    {
        super(context);
    }

    public MySettingsJunction(KmJunction context, KmAbstractCriteria parent)
    {
        super(context, parent);
    }

    //##################################################
    //# properties
    //##################################################

    public KmIntegerCriteria whereCode()
    {
        return new KmIntegerCriteria(context(), fullName(CODE));
    }

    public KmStringCriteria whereSomeMessage()
    {
        return new KmStringCriteria(context(), fullName(SOME_MESSAGE));
    }

    public KmIntegerCriteria whereLockVersion()
    {
        return new KmIntegerCriteria(context(), fullName(LOCK_VERSION));
    }

    //##################################################
    //# associations
    //##################################################

    //##################################################
    //# junction
    //##################################################

    public MySettingsJunction addAnd()
    {
        return new MySettingsJunction(context().addAnd(), parent());
    }

    public MySettingsJunction addOr()
    {
        return new MySettingsJunction(context().addOr(), parent());
    }

}
