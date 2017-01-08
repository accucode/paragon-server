package com.app.ui.page.general;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScText;
import com.kodemore.servlet.control.ScTextSpan;
import com.kodemore.servlet.control.ScUrlLink;
import com.kodemore.utility.Kmu;

import com.app.ui.layout.MyPageLayoutType;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;
import com.app.utility.MyConstantsIF;
import com.app.utility.MyUrls;

public final class MyLogoutPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyLogoutPage _instance;

    public static void installInstance()
    {
        _instance = new MyLogoutPage();
    }

    public static MyLogoutPage getInstance()
    {
        return _instance;
    }

    private MyLogoutPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScTextSpan _titleText;
    private ScText     _messageText;
    private ScUrlLink  _signInLink;

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.none;
    }

    @Override
    public MyPageLayoutType getLayoutType()
    {
        return MyPageLayoutType.basic;
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
        ScGroup group;
        group = root.addGroup();
        group.style().width(300).marginTop(100).marginCenter();

        _titleText = group.setTitle(getDefaultTitle());

        ScDiv body;
        body = group.getBody();
        body.css().pad();
        _messageText = body.addText(getDefaultMessage());

        body.addBreak();
        body.addBreak();

        ScUrlLink link;
        link = body.addUrlLink();
        link.setText("Sign In");
        _signInLink = link;
    }

    //##################################################
    //# title
    //##################################################

    public void setTitle(String e)
    {
        _titleText.setValue(e);
    }

    public String getDefaultTitle()
    {
        return "Sign Out";
    }

    //##################################################
    //# message
    //##################################################

    public void setMessage(String e)
    {
        _messageText.setValue(e);
    }

    private String getDefaultMessage()
    {
        return Kmu.format(
            "You have successfully signed out of %s.",
            MyConstantsIF.APPLICATION_NAME);
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        _signInLink.setHref(MyUrls.getEntryUrl());
    }

}
