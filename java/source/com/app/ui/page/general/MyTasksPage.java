package com.app.ui.page.general;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScText;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyTasksPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyTasksPage _instance;

    public static void installInstance()
    {
        _instance = new MyTasksPage();
    }

    public static MyTasksPage getInstance()
    {
        return _instance;
    }

    private MyTasksPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScText _message;

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.member;
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
        ScGroup group = new ScGroup();

        root.css().pad();
        group = root.addGroup("Task Test");
        // remove_steve: added height500 for testing
        group.css().height500();
        // fixme_steve: move the theming into a convinience method
        group.getBanner().css().group_banner_primary();

        ScActionButton button = group.getFooter().addButton();
        button.css().button_element_positive();
        _message = group.getBody().addText("This page shows tasks for the current project.");

    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        if ( !hasCurrentProject() )
            _message.setValue("Please select a project.");
    }

}
