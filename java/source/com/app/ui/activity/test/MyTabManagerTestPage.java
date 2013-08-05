package com.app.ui.activity.test;

import com.kodemore.servlet.control.ScNotebook;
import com.kodemore.servlet.control.ScPageRoot;

public class MyTabManagerTestPage
    extends MyAbstractTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyTabManagerTestPage instance = new MyTabManagerTestPage();

    private MyTabManagerTestPage()
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

        book.install(new MyAccountOverviewTabManager(this));
        book.install(new MyAccountTabManager(this));

        return root;
    }
}
