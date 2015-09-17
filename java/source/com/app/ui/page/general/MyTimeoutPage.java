package com.app.ui.page.general;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGeneralButton;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;

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
        String href = MyUrls.getEntryUrl();

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
        buttons = body.addFloatRight();

        ScGeneralButton button;
        button = buttons.addGeneralButton();
        button.setText("Login >>");
        button.setHref(href);
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        // none
    }

}
