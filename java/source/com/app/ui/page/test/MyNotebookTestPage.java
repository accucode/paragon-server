package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScArray;
import com.kodemore.servlet.control.ScNotebook;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScText;

public class MyNotebookTestPage
    extends MyTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyNotebookTestPage instance = new MyNotebookTestPage();

    private MyNotebookTestPage()
    {
        // singleton
    }

    //##################################################
    //# start
    //##################################################

    @Override
    public void applyParametersToUrl(ScParameterList v)
    {
        // none
    }

    @Override
    public void applyParametersFromUrl(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().pad();

        ScNotebook book;
        book = root.addNotebook();
        book.setTabChangedAction(newTabChangeAction());

        ScText tab1;
        tab1 = book.addText();
        tab1.setLabel("One");
        tab1.setValue("One aaa bbb ccc.");

        ScArray tab2;
        tab2 = book.addColumn();
        tab2.setLabel("Two");
        tab2.addText("Two nnn ooo ppp.");
        tab2.addButton("Test", newTestAction());

        ScActionButton tab3;
        tab3 = book.addButton("Test", newTestAction());
        tab3.setLabel("Three");
    }

    //##################################################
    //# actions 
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

    private ScActionIF newTabChangeAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleTabChange();
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

    private void handleTabChange()
    {
        ajax().toast("Tab Changed");
    }
}
