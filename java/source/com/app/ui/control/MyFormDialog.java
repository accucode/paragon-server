package com.app.ui.control;

import com.kodemore.servlet.control.ScFormDialog;

import com.app.dao.base.MyDaoAccess;
import com.app.property.MyProperties;
import com.app.utility.MyGlobals;

public class MyFormDialog
    extends ScFormDialog
{
    //##################################################
    //# convenience
    //##################################################

    protected MyGlobals getGlobals()
    {
        return MyGlobals.instance;
    }

    protected MyDaoAccess getAccess()
    {
        return getGlobals().getAccess();
    }

    protected MyProperties getProperties()
    {
        return MyGlobals.getProperties();
    }
}
