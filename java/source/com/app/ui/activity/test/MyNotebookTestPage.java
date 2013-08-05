package com.app.ui.activity.test;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScArray;
import com.kodemore.servlet.control.ScNotebook;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScText;

public class MyNotebookTestPage
    extends MyAbstractTestPage
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
    //# install
    //##################################################

    @Override
    protected ScPageRoot installRoot()
    {
        ScPageRoot root;
        root = newPageRoot();
        root.css().pad();

        ScNotebook book;
        book = root.addNotebook();

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

        return root;
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

    //##################################################
    //# handle
    //##################################################

    private void handleTest()
    {
        ajax().toast("Test");
    }
}
