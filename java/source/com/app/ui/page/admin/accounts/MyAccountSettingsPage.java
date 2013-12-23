package com.app.ui.page.admin.accounts;

import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.page.admin.MyAbstractAdminPage;

public class MyAccountSettingsPage
    extends MyAbstractAdminPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyAccountSettingsPage instance = new MyAccountSettingsPage();

    private MyAccountSettingsPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private MyAccountSettingsFrame _frame;

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        _frame = new MyAccountSettingsFrame();
        _frame.getViewCard().beDefault();
        _frame.css().pad().centerMargins();
        _frame.style().width(300);

        root.add(_frame);
    }

    //##################################################
    //# actions
    //##################################################

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();
    }
}
