package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScFilterBox;
import com.kodemore.servlet.control.ScFlexbox;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.string.KmStringBuilder;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyEqualizeTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyEqualizeTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyEqualizeTestPage();
    }

    public static MyEqualizeTestPage getInstance()
    {
        return _instance;
    }

    private MyEqualizeTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScBox _groups;

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
        root.css().gap();

        ScGroup info;
        info = root.addGroup("Equalize Test");
        info.getBody().addPad().addText(infoMessage());
        info.addBodyDivider();

        ScBox buttons;
        buttons = info.getBody().addButtonBox();
        buttons.addButton("Equalize Groups", this::handleEqualize);
        buttons.addButton("Click here to equalize all the buttons.", this::handleEqualizeButtons);

        _groups = root.addBox();

        ScFlexbox groups;
        groups = _groups.addRow();
        groups.crossAlignStart();

        ScBox links;

        ScFilterBox filter;
        filter = groups.addFilterBox("Filter Box Test");
        filter.addText("This is a test filter box...");

        ScGroup group;
        group = groups.addGroup("A group");
        links = group.getBody().addLinkBox();
        links.addLink(MyBlankTestPage.getInstance());
        links.addLink(MyFormTestPage.getInstance());
        links.addLink(MyPlaceholderTestPage.getInstance());
        links.addLink(MyGroupTestPage.getInstance());
        links.addLink(MyGroupIconHeaderTestPage.getInstance());
        links.addLink(MyNotebookTestPage.getInstance());

        group = groups.addGroup("Another group");
        links = group.getBody().addLinkBox();
        group.style().height(300);
        links.addLink(MyFieldTestPage.getInstance());
        links.addLink(MyLocalValueTestPage.getInstance());
        links.addLink(MyDateFieldTestPage.getInstance());
        links.addLink(MyColorFieldTestPage.getInstance());
        links.addLink(MyAutoCompleteTestPage.getInstance());
        links.addLink(MyGoogleChartTestPage.getInstance());
        links.addLink(MyGridTestPage.getInstance());
        links.addLink(MyDropzoneTestPage.getInstance());

        group = groups.addGroup("And another");
        links = group.getBody().addLinkBox();
        group.style().width(300);
        links.addLink(MyBlockTestPage.getInstance());
        links.addLink(MySlowTestPage.getInstance());
        links.addLink(MyToastTestPage.getInstance());
        links.addLink(MyAnimationTestPage.getInstance());
        links.addLink(MyHideErrorsTestPage.getInstance());
        links.addLink(MyOpenWindowTestPage.getInstance());
        links.addLink(MyDownloadTestPage.getInstance());
        links.addLink(MyDialogTestPage.getInstance());
        links.addLink(MyBarcodeTestPage.getInstance());

        group = root.addGroup("One more at down below");

        buttons = group.getBody().addButtonBox();
        buttons.addButton("Button");
        buttons.addButton("One more button with lots of text");
    }

    private String infoMessage()
    {
        KmStringBuilder out;
        out = new KmStringBuilder();

        out.println(
            ""
                + "'Equalize Groups' will make all of the below groups the same size. This uses "
                + "client-side javascript to equalize the width and/or height of multiple "
                + "elements.  This is now largely OBSOLETE; in most cases, a flexbox layout "
                + "will achieve the same effect and with far fewer problems and complications.");

        return out.toString();
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        // none
    }

    //##################################################
    //# handle
    //##################################################

    private void handleEqualize()
    {
        _groups.ajax().equalizeGroups();
    }

    private void handleEqualizeButtons()
    {
        getRoot().ajax().equalizeClasses("button");
    }
}
