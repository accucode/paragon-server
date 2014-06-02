package com.app.ui.page.admin.accountSettings;

import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.page.admin.MyAbstractAdminEntryPage;

public class MyAccountSettingsPage
    extends MyAbstractAdminEntryPage
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
