package com.app.ui.activity.test;

import com.kodemore.servlet.control.ScNotebook;
import com.kodemore.servlet.control.ScPageRoot;

public class MyManageAccountsPage
    extends MyAbstractTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyManageAccountsPage instance = new MyManageAccountsPage();

    private MyManageAccountsPage()
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
        book.add(new MyGeneralAccountTab());
        book.add(new MyAccountDetailsTab());

        return root;
    }
}
