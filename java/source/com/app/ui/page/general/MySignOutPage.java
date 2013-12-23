package com.app.ui.page.general;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScText;
import com.kodemore.utility.Kmu;

import com.app.ui.page.MyPage;
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

    private ScText _titleText;
    private ScText _messageText;

    //##################################################
    //# setup
    //##################################################

    @Override
    public boolean requiresUser()
    {
        return false;
    }

    @Override
    protected boolean showsLeftMenu()
    {
        return false;
    }

    //##################################################
    //# start
    //##################################################

    @Override
    public void applyParametersToUrl(ScParameterList v)
    {
        // none
    }

    @Override
    public void applyParametersFromUrl(ScParameterList v)
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

        _messageText = group.addPad().addText(getDefaultMessage());

        group.addBreak();
        group.addBreak();
        group.addPad().addUrlLink("Sign In", MyUrls.getEntryUrl());
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
        return Kmu.format("You have successfully signed out of %s.", MyConstantsIF.APPLICATION_NAME);
    }
}
