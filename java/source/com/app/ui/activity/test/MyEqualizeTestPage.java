package com.app.ui.activity.test;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScGroupArrayEqualized;
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

    private ScGroupArrayEqualized _groups;

    private ScGroup               _group1;
    private ScGroup               _group2;
    private ScGroup               _group3;
    private ScGroup               _group4;

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
        buttons.addButton("Toggle Group 1", newToggleGroup1Action());
        buttons.addButton("Toggle Group 2", newToggleGroup2Action());
        buttons.addButton("Toggle Group 3", newToggleGroup3Action());
        buttons.addButton("Toggle Group 4", newToggleGroup4Action());

        buttons = info.addButtonBox();
        buttons.addButton("Equalize", newEqualizeAction());
        buttons.addButton("Equalize - Reset", newEqualizeResetAction());

        _groups = new ScGroupArrayEqualized();
        _groups.style().floatLeft();

        root.add(_groups);

        ScBox links;

        _group1 = _groups.addGroup("Group 1");
        links = _group1.addLinkBox();
        links.addLink(MyBlankTestPage.instance);
        links.addLink(MyFormTestPage.instance);
        links.addLink(MyPlaceholderTestPage.instance);
        links.addLink(MyGroupTestPage.instance);
        links.addLink(MyGroupIconHeaderTestPage.instance);
        links.addLink(MyNotebookTestPage.instance);

        _group2 = _groups.addGroup("Group 2");
        links = _group2.addLinkBox();
        _group2.style().height(300);
        links.addLink(MyFieldTestPage.instance);
        links.addLink(MyLocalValueTestPage.instance);
        links.addLink(MyDateFieldTestPage.instance);
        links.addLink(MyColorFieldTestPage.instance);
        links.addLink(MyAutoCompleteTestPage.instance);
        links.addLink(MyGoogleChartTestPage.instance);
        links.addLink(MyGridTestPage.instance);
        links.addLink(MyDropzoneTestPage.instance);

        _group3 = _groups.addGroup("Group 3");
        links = _group3.addLinkBox();
        _group3.style().width(300);
        links.addLink(MyBlockTestPage.instance);
        links.addLink(MySlowTestPage.instance);
        links.addLink(MyToastTestPage.instance);
        links.addLink(MyAnimationTestPage.instance);
        links.addLink(MyHideErrorsTestPage.instance);
        links.addLink(MyOpenWindowTestPage.instance);
        links.addLink(MyDownloadTestPage.instance);
        links.addLink(MyShowDialogTestPage.instance);
        links.addLink(MyBarcodeTestPage.instance);

        _group4 = _groups.addGroup("Group 4");
        links = _group4.addLinkBox();
        links.addLink(MyScriptTestPage.instance);
        links.addLink(MyMemoryLeakTestPage.instance);
        links.addLink(MyGmailTestPage.instance);
        links.addLink(MyStaticIncludeTestPage.instance);
        links.addLink(MyQuickTestPage.instance);

        return root;
    }

    private String infoMessage()
    {
        KmStringBuilder out;
        out = new KmStringBuilder();

        out.println("'Equalize' will make all of the below groups the same size.");
        out.println("'Equalize - Reset' will reset the size of all groups, and then equalize their"
            + "sizes.");
        out.println();
        out.print("Groups that are hidden will still be considered in the equalization, so visible"
            + "groups will still match the size of hidden groups, vice versa");

        return out.toString();
    }

    //##################################################
    //# action
    //##################################################

    private ScActionIF newToggleGroup1Action()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handleToggleGroup1();
            }
        };
    }

    private ScActionIF newToggleGroup2Action()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handleToggleGroup2();
            }
        };
    }

    private ScActionIF newToggleGroup3Action()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handleToggleGroup3();
            }
        };
    }

    private ScActionIF newToggleGroup4Action()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handleToggleGroup4();
            }
        };
    }

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

    private ScActionIF newEqualizeResetAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handleEqualizeReset();
            }
        };
    }

    //##################################################
    //# hanlde
    //##################################################

    private void handleToggleGroup1()
    {
        _group1.ajax().toggle();
    }

    private void handleToggleGroup2()
    {
        _group2.ajax().toggle();
    }

    private void handleToggleGroup3()
    {
        _group3.ajax().toggle();
    }

    private void handleToggleGroup4()
    {
        _group4.ajax().toggle();
    }

    private void handleEqualize()
    {
        _groups.ajaxEqualize();
    }

    private void handleEqualizeReset()
    {
        _groups.ajaxEqualizeReset();
    }
}
