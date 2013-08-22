package com.app.ui.activity.test;

import com.kodemore.servlet.control.ScNotebook;
import com.kodemore.servlet.control.ScPageRoot;

public class MyTabbedTestPage
    extends MyTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyTabbedTestPage instance = new MyTabbedTestPage();

    private MyTabbedTestPage()
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
        book.add(new MyFirstTab());
        book.add(new MySecondTab());

        return root;
    }
}
