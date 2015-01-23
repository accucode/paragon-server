package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScFilterBox;
import com.kodemore.servlet.control.ScFlexbox;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.string.KmStringBuilder;

public class MyEqualizeTestPage
    extends MyAbstractTestEntryPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyEqualizeTestPage instance = new MyEqualizeTestPage();

    private MyEqualizeTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScBox _groups;

    //##################################################
    //# navigation
    //##################################################

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
        links.addLink(MyBlankTestPage.instance);
        links.addLink(MyFormTestPage.instance);
        links.addLink(MyPlaceholderTestPage.instance);
        links.addLink(MyGroupTestPage.instance);
        links.addLink(MyGroupIconHeaderTestPage.instance);
        links.addLink(MyNotebookTestPage.instance);

        group = groups.addGroup("Another group");
        links = group.getBody().addLinkBox();
        group.style().height(300);
        links.addLink(MyFieldTestPage.instance);
        links.addLink(MyLocalValueTestPage.instance);
        links.addLink(MyDateFieldTestPage.instance);
        links.addLink(MyColorFieldTestPage.instance);
        links.addLink(MyAutoCompleteTestPage.instance);
        links.addLink(MyGoogleChartTestPage.instance);
        links.addLink(MyGridTestPage.instance);
        links.addLink(MyDropzoneTestPage.instance);

        group = groups.addGroup("And another");
        links = group.getBody().addLinkBox();
        group.style().width(300);
        links.addLink(MyBlockTestPage.instance);
        links.addLink(MySlowTestPage.instance);
        links.addLink(MyToastTestPage.instance);
        links.addLink(MyAnimationTestPage.instance);
        links.addLink(MyHideErrorsTestPage.instance);
        links.addLink(MyOpenWindowTestPage.instance);
        links.addLink(MyDownloadTestPage.instance);
        links.addLink(MyDialogTestPage.instance);
        links.addLink(MyBarcodeTestPage.instance);

        group = root.addGroup("One more at down below");

        buttons = group.getBody().addButtonBox();
        buttons.addButton("Button");
        buttons.addButton("One more button with lots of text");
    }

    private String infoMessage()
    {
        KmStringBuilder out;
        out = new KmStringBuilder();

        out.println(""
            + "'Equalize Groups' will make all of the below groups the same size. This uses "
            + "client-side javascript to equalize the width and/or height of multiple "
            + "elements.  This is now largely OBSOLETE; in most cases, a flexbox layout "
            + "will achieve the same effect and with far fewer problems and complications.");

        return out.toString();
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
