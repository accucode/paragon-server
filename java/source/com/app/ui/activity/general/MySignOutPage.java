package com.app.ui.activity.general;

import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScText;
import com.kodemore.utility.Kmu;

import com.app.ui.activity.MyPage;
import com.app.ui.core.MyServerSessionManager;
import com.app.ui.core.MyServletUtility;
import com.app.ui.layout.MyPageLayout;
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
    //# install
    //##################################################

    @Override
    public boolean requiresUser()
    {
        return false;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScPageRoot installRoot()
    {
        ScPageRoot root;
        root = newPageRoot();

        ScGroup group;
        group = root.addGroup();
        group.style().width(300).marginTop(100).marginCenter();

        _titleText = group.setTitle(getDefaultTitle());

        ScBox box;
        box = group.addBox();
        box.css().pad();

        _messageText = box.addText(getDefaultMessage());

        box.addBreak();
        box.addBreak();
        box.addUrlLink("Sign In", MyUrls.getEntryUrl());

        return root;
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

    //##################################################
    //# start
    //##################################################

    @Override
    public void start()
    {
        signOut();
        resetPage();
        print();
    }

    private void signOut()
    {
        MyServletUtility.ajaxClearAutoSignIn();
        MyServerSessionManager.beginSession();
        getData().clearPageSession();
    }

    private void resetPage()
    {
        MyPageLayout e;
        e = getPageLayout();
        e.ajaxHideLeft();
        e.ajaxHideRight();
        e.ajaxRefreshHeader();
        e.ajaxRefreshFooter();
        e.ajaxClearCenterCss();
    }
}
