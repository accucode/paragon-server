package com.app.ui.activity.test;

import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScGroupArrayEqualized;
import com.kodemore.servlet.control.ScPageRoot;

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
        info.addPad().addText(
            "This is to test some javascript that will equalize the "
                + "height and width of elements within a group array.  All of the groups "
                + "below should be the same size.");

        ScGroupArrayEqualized groups;
        groups = new ScGroupArrayEqualized();
        groups.style().floatLeft();

        root.add(groups);

        ScGroup group;
        ScBox links;

        group = groups.addGroup("Layout");
        links = group.addLinkBox();
        links.addLink(MyBlankTestPage.instance);
        links.addLink(MyFormTestPage.instance);
        links.addLink(MyPlaceholderTestPage.instance);
        links.addLink(MyGroupTestPage.instance);
        links.addLink(MyGroupIconHeaderTestPage.instance);
        links.addLink(MyNotebookTestPage.instance);

        group = groups.addGroup("Fields");
        links = group.addLinkBox();
        links.addLink(MyFieldTestPage.instance);
        links.addLink(MyLocalValueTestPage.instance);
        links.addLink(MyDateFieldTestPage.instance);
        links.addLink(MyColorFieldTestPage.instance);
        links.addLink(MyAutoCompleteTestPage.instance);
        links.addLink(MyGoogleChartTestPage.instance);
        links.addLink(MyGridTestPage.instance);
        links.addLink(MyDropzoneTestPage.instance);

        group = groups.addGroup("Misc");
        links = group.addLinkBox();
        links.addLink(MyBlockTestPage.instance);
        links.addLink(MySlowTestPage.instance);
        links.addLink(MyToastTestPage.instance);
        links.addLink(MyAnimationTestPage.instance);
        links.addLink(MyHideErrorsTestPage.instance);
        links.addLink(MyOpenWindowTestPage.instance);
        links.addLink(MyDownloadTestPage.instance);
        links.addLink(MyShowDialogTestPage.instance);
        links.addLink(MyBarcodeTestPage.instance);

        group = groups.addGroup("Tools");
        links = group.addLinkBox();
        links.addLink(MyScriptTestPage.instance);
        links.addLink(MyMemoryLeakTestPage.instance);
        links.addLink(MyGmailTestPage.instance);
        links.addLink(MyStaticIncludeTestPage.instance);
        links.addLink(MyQuickTestPage.instance);

        return root;
    }
}
