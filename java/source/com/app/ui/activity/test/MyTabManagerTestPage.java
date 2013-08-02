package com.app.ui.activity.test;

import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScNotebook;

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
    protected ScControl installRoot()
    {
        ScBox root;
        root = new ScBox();
        root.css().pad();

        ScNotebook book;
        book = root.addNotebook();

        book.install(new MyAccountOverviewTabManager(this));

        return root;
    }
}
