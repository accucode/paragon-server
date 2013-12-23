package com.app.ui.control;

import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.action.ScActions;
import com.kodemore.servlet.control.ScDialog;

import com.app.dao.base.MyDaoRegistry;
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

    protected ScActionIF getCloseDialogAction()
    {
        return ScActions.getInstance().getCloseDialogAction();
    }
}
