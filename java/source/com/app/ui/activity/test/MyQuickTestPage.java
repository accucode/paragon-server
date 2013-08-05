package com.app.ui.activity.test;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScArray;
import com.kodemore.servlet.control.ScPageRoot;

public class MyQuickTestPage
    extends MyAbstractTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyQuickTestPage instance = new MyQuickTestPage();

    private MyQuickTestPage()
    {
        // singleton
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScPageRoot installRoot()
    {
        ScPageRoot root;
        root = newPageRoot();
        root.css().pad();

        ScArray col;
        col = root.addColumn();
        col.addBox().addText("Hello World");
        col.addButton("Test", newTestAction());

        return root;
    }

    //##################################################
    //# action
    //##################################################

    private ScActionIF newTestAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
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
        ajax().toast("Test");
    }

}
