package com.app.ui.page.general;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScScriptButton;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;
import com.app.utility.MyUrls;

public final class MyTimeoutPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyTimeoutPage _instance;

    public static void installInstance()
    {
        _instance = new MyTimeoutPage();
    }

    public static MyTimeoutPage getInstance()
    {
        return _instance;
    }

    private MyTimeoutPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScScriptButton _loginButton;

    //##################################################
    //# setup
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.none;
    }

    //##################################################
    //# bookmark
    //##################################################

    @Override
    public void composeBookmarkOn(ScParameterList v)
    {
        // none
    }

    @Override
    public void applyBookmark(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        ScForm form;
        form = root.addForm();

        ScGroup group;
        group = form.addGroup();

        ScDiv body;
        body = group.getBody();
        body.addText("For security reasons, your session has expired.");
        body.addSpace();
        body.addText("Please log back in.");

        ScDiv buttons;
        buttons = body.addFlexRow();
        buttons.css().flexAlignEnd();

        ScScriptButton button;
        button = buttons.addScriptButton();
        button.setText("Login >>");
        _loginButton = button;
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        String url = MyUrls.getEntryUrl();
        _loginButton.setScriptHref(url);
    }

}
