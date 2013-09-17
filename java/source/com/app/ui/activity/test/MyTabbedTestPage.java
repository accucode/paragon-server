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
    protected void installRoot(ScPageRoot root)
    {
        root.css().pad();

        ScNotebook book;
        book = root.addNotebook();
        book.add(new MyFirstTab());
        book.add(new MySecondTab());
    }
}
