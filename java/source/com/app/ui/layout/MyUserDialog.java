package com.app.ui.layout;

import com.kodemore.servlet.control.ScDiv;

import com.app.ui.control.MyDialog;
import com.app.ui.page.login.MyLoginUtility;

public class MyUserDialog
    extends MyDialog
{
    //##################################################
    //# variables
    //##################################################

    private Runnable _changePasswordListener;

    //##################################################
    //# constructor
    //##################################################

    public MyUserDialog()
    {
        install();
        setHeight(300);
        setWidth(400);
    }

    //##################################################
    //# install
    //##################################################

    private void install()
    {
        setLabel("User Actions");

        installBody();
        installFooter();
    }

    private void installBody()
    {
        ScDiv body;
        body = getBody().addDiv();
        body.css().pad20().flexColumn().columnSpacer10();

        body.addLink("Change Password", this::handleChangePassword);
        body.addLink("Log Out", this::handleLogout);
    }

    private void installFooter()
    {
        ScDiv footer;
        footer = showFooter().addButtonBox();
        footer.addCancelButton(this::ajaxClose);
    }

    //##################################################
    //# on change password
    //##################################################

    public void onChangePassword(Runnable e)
    {
        _changePasswordListener = e;
    }

    private void fireChangePasswordListener()
    {
        fire(_changePasswordListener);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleChangePassword()
    {
        fireChangePasswordListener();
        ajaxClose();
    }

    private void handleLogout()
    {
        MyLoginUtility.ajaxLogOut();
        ajaxClose();
    }
}
