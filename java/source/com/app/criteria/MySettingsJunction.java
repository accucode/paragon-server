//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.criteria;

import com.app.dao.base.MySettingsDaoConstantsIF;
import com.app.model.MySettings;

import com.kodemore.hibernate.criteria.KmAbstractCriteria;
import com.kodemore.hibernate.criteria.KmIntegerCriteria;
import com.kodemore.hibernate.criteria.KmJunction;
import com.kodemore.hibernate.criteria.KmModelJunction;
import com.kodemore.hibernate.criteria.KmStringCriteria;

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
