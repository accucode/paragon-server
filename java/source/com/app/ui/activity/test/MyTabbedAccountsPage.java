package com.app.ui.activity.test;

import com.kodemore.servlet.control.ScNotebook;
import com.kodemore.servlet.control.ScPageRoot;

public class MyTabbedAccountsPage
    extends MyAbstractTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyTabbedAccountsPage instance = new MyTabbedAccountsPage();

    private MyTabbedAccountsPage()
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
