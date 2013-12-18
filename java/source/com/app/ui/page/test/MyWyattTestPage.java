package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScDropdownMenu;

public class MyWyattTestPage
    extends MyAbstractTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyWyattTestPage instance = new MyWyattTestPage();

    private MyWyattTestPage()
    {
        // singleton
    }

    //##################################################
    //# navigation
    //##################################################

    @Override
    public ScParameterList composeQueryParameters()
    {
        return null;
    }

    @Override
    public void applyQueryParameters(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        ScActionIF action = newTestAction();

        ScBox box = root.addPad();

        ScDropdownMenu menu;
        menu = box.addDropdownMenu();
        menu.addItem("One", action, 1);
        menu.addItem("Two", action, 2);
        menu.addItem("Three", action, 3);
    }

    //##################################################
    //# action
    //##################################################

    private ScActionIF newTestAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleTest();
            }
        };
    }

    //##################################################
    //# handle
    //##################################################

    private void handleTest()
    {
        ajax().toast("clicked %s.", getArgument());
    }
}
