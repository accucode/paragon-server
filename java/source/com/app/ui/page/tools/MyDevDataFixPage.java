package com.app.ui.page.tools;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScParagraph;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyDevDataFixPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyDevDataFixPage _instance;

    public static void installInstance()
    {
        _instance = new MyDevDataFixPage();
    }

    public static MyDevDataFixPage getInstance()
    {
        return _instance;
    }

    private MyDevDataFixPage()
    {
        // singleton
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    public final MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.developer;
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
        root.css().fill().auto();
        root.css().flexColumn().columnSpacer20();

        installWarningOn(root);
        installActionsOn(root);
    }

    private void installWarningOn(ScDiv root)
    {
        ScParagraph warning;
        warning = root.addParagraph(
            "WARNING, the tools on this page intended for"
                + " speciallized purposes and may cause significant changes to the"
                + " database. E.g.: these tools may be used to assist with complex"
                + " database migrations that cannot be completed easily with sql.");
        warning.css().boxRed().pad();
    }

    private void installActionsOn(ScDiv root)
    {
        installActionOn(
            root,
            "Sample",
            "This is just a sample, it does NOT make any changes.",
            this::handleSample);
    }

    private void installActionOn(ScDiv root, String title, String desc, Runnable action)
    {
        ScGroup group;
        group = root.addGroup(title);

        ScDiv body;
        body = group.getBody();
        body.css().pad();
        body.addText(desc);

        ScDiv footer;
        footer = group.showFooter();

        ScActionButton button;
        button = footer.addButtonBox().addButton(title, action);
        button.setConfirmationMessageText("Are you sure?");
    }

    //##################################################
    //# render
    //##################################################

    @Override
    public void preRender()
    {
        // none
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSample()
    {
        ajax().toast("done.");
    }
}
