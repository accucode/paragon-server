package com.app.ui.activity.test;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScFilterBox;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.string.KmStringBuilder;

public class MyEqualizeTestPage
    extends MyAbstractTestPage
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

    private ScBox _root;
    private ScBox _groups;

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScPageRoot installRoot()
    {
        ScPageRoot root;
        root = newPageRoot();
        root.css().padSpaced10();

        ScGroup info;
        info = root.addGroup("Equalize Test");
        info.addPad().addText(infoMessage());
        info.addDivider();

        ScBox buttons;
        buttons = info.addButtonBox();
        buttons.addButton("Equalize Groups", newEqualizeAction());
        buttons.addButton("Click here to equalize all the buttons.", newEqualizeButtonsAction());

        _groups = root.addBox();

        ScContainer groups;
        groups = _groups.addRow();

        ScBox links;

        ScFilterBox filter;
        filter = groups.addFilterBox("Filter Box Test");
        filter.addText("This is a test filter box...");

        ScGroup group;
        group = groups.addGroup("Group 1");
        links = group.addLinkBox();
        links.addLink(MyBlankTestPage.instance);
        links.addLink(MyFormTestPage.instance);
        links.addLink(MyPlaceholderTestPage.instance);
        links.addLink(MyGroupTestPage.instance);
        links.addLink(MyGroupIconHeaderTestPage.instance);
        links.addLink(MyNotebookTestPage.instance);

        group = groups.addGroup("Group 2");
        links = group.addLinkBox();
        group.style().height(300);
        links.addLink(MyFieldTestPage.instance);
        links.addLink(MyLocalValueTestPage.instance);
        links.addLink(MyDateFieldTestPage.instance);
        links.addLink(MyColorFieldTestPage.instance);
        links.addLink(MyAutoCompleteTestPage.instance);
        links.addLink(MyGoogleChartTestPage.instance);
        links.addLink(MyGridTestPage.instance);
        links.addLink(MyDropzoneTestPage.instance);

        group = groups.addGroup("Group 3");
        links = group.addLinkBox();
        group.style().width(300);
        links.addLink(MyBlockTestPage.instance);
        links.addLink(MySlowTestPage.instance);
        links.addLink(MyToastTestPage.instance);
        links.addLink(MyAnimationTestPage.instance);
        links.addLink(MyHideErrorsTestPage.instance);
        links.addLink(MyOpenWindowTestPage.instance);
        links.addLink(MyDownloadTestPage.instance);
        links.addLink(MyShowDialogTestPage.instance);
        links.addLink(MyBarcodeTestPage.instance);

        // fixme_aaron: 
        //        group = groups.addGroup("Group 4");
        //        links = group.addLinkBox();
        //        links.addLink(MyScriptTestPage.instance);
        //        links.addLink(MyMemoryLeakTestPage.instance);
        //        links.addLink(MyGmailTestPage.instance);
        //        links.addLink(MyStaticIncludeTestPage.instance);
        //        links.addLink(MyQuickTestPage.instance);

        group = root.addGroup("Here's more content");

        buttons = group.addButtonBox();
        buttons.addButton("Button");
        buttons.addButton("One more button with lots of text");

        _root = root;
        return root;
    }

    private String infoMessage()
    {
        KmStringBuilder out;
        out = new KmStringBuilder();

        out.println("'Equalize Groups' will make all of the below groups the same size.");

        return out.toString();
    }

    //##################################################
    //# action
    //##################################################

    private ScActionIF newEqualizeAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handleEqualize();
            }
        };
    }

    private ScActionIF newEqualizeButtonsAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handleEqualizeButtons();
            }
        };
    }

    //##################################################
    //# handle
    //##################################################

    private void handleEqualize()
    {
        _groups.ajax().equalizeDecendentGroups();
    }

    private void handleEqualizeButtons()
    {
        _root.ajax().equalizeDecendentClass("button");
    }
}
