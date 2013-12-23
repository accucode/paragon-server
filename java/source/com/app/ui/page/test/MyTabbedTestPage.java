package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
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
        book.add(new MyFirstTab());
        book.add(new MySecondTab());
    }
}
