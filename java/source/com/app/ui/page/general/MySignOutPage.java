package com.app.ui.page.general;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScText;
import com.kodemore.servlet.control.ScTextSpan;
import com.kodemore.utility.Kmu;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;
import com.app.utility.MyConstantsIF;
import com.app.utility.MyUrls;

public class MySignOutPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MySignOutPage instance = new MySignOutPage();

    private MySignOutPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScTextSpan _titleText;
    private ScText     _messageText;

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.any;
    }

    //##################################################
    //# navigation
    //##################################################

    public void ajaxPush()
    {
        _ajaxPush();
    }

    @Override
    public ScParameterList composeQueryParameters()
    {
        return null;
    }

    @Override
    public void applyQueryParameters(ScParameterList v)
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

        _messageText = group.getBody().addPad().addText(getDefaultMessage());

        group.getBody().addBreak();
        group.getBody().addBreak();
        group.getBody().addPad().addUrlLink("Sign In", MyUrls.getEntryUrl());
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
        return Kmu
            .format("You have successfully signed out of %s.", MyConstantsIF.APPLICATION_NAME);
    }
}
