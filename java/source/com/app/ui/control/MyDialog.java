package com.app.ui.control;

import com.kodemore.servlet.control.ScDialog;

import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyProject;
import com.app.property.MyPropertyRegistry;
import com.app.utility.MyGlobals;

public class MyDialog
    extends ScDialog
{
    //##################################################
    //# convenience
    //##################################################

    protected MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }

    protected MyPropertyRegistry getProperties()
    {
        return MyGlobals.getProperties();
    }

    protected void flushDao()
    {
        MyGlobals.getDaoSession().flush();
    }

    protected MyProject getCurrentProject()
    {
        return MyGlobals.getServerSession().getCurrentProject();
    }
}
