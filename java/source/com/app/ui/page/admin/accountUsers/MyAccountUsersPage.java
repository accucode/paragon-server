package com.app.ui.page.admin.accountUsers;

import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.page.admin.MyAbstractAdminPage;
import com.app.ui.page.admin.accountSettings.MyAccountSettingsFrame;

public class MyAccountUsersPage
    extends MyAbstractAdminPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyAccountUsersPage instance = new MyAccountUsersPage();

    private MyAccountUsersPage()
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
