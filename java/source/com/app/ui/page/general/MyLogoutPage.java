package com.app.ui.page.general;

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
import com.app.ui.page.login.MyLoginPage;
import com.app.ui.page.login.MyLoginUtility;
import com.app.utility.MyConstantsIF;

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

    @Override
    public boolean allowsJumpTo()
    {
        return false;
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
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        MyLoginUtility.logout();

        String query = MyLoginPage.getInstance().formatQueryString();
        _signInLink.setHref(query);
    }

}
