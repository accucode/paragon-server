package com.app.ui.control;

import com.kodemore.servlet.control.ScDialog;

import com.app.dao.base.MyDaoAccess;
import com.app.property.MyProperties;
import com.app.utility.MyGlobals;

public class MyDialog
    extends ScDialog
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

    protected void daoFlush()
    {
        MyGlobals.getDaoSession().flush();
    }
}
