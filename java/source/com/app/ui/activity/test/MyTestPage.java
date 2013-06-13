package com.app.ui.activity.test;

import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScGroupArray;

public class MyTestPage
    extends MyAbstractTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyTestPage instance = new MyTestPage();

    private MyTestPage()
    {
        // singleton
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScControl installRoot()
    {
        ScBox root;
        root = new ScBox();
        root.css().padSpaced();

        ScGroupArray groups;
        groups = root.addGroupArray();
        groups.style().floatLeft().width(150).height(300);

        ScGroup group;
        ScBox links;

        group = groups.addGroup("Layout");
        links = group.addLinkBox();
        links.addLink(MyBlankTestPage.instance);
        links.addLink(MyFormTestPage.instance);
        links.addLink(MyGroupTestPage.instance);
        links.addLink(MyNotebookTestPage.instance);

        group = groups.addGroup("Fields");
        links = group.addLinkBox();
        links.addLink(MyFieldTestPage.instance);
        links.addLink(MyLocalValueTestPage.instance);
        links.addLink(MyDateFieldTestPage.instance);
        links.addLink(MyColorFieldTestPage.instance);
        links.addLink(MyAutoCompleteTestPage.instance);
        links.addLink(MyGridTestPage.instance);
        links.addLink(MyGoogleChartTestPage.instance);

        group = groups.addGroup("Misc");
        links = group.addLinkBox();
        links.addLink(MyBlockTestPage.instance);
        links.addLink(MySlowTestPage.instance);
        links.addLink(MyToastTestPage.instance);
        links.addLink(MyAnimationTestPage.instance);
        links.addLink(MyHideErrorsTestPage.instance);
        links.addLink(MyOpenWindowTestPage.instance);
        links.addLink(MyDownloadTestPage.instance);

        group = groups.addGroup("Tools");
        links = group.addLinkBox();
        links.addLink(MyScriptTestPage.instance);
        links.addLink(MyMemoryLeakTestPage.instance);
        links.addLink(MyGmailTestPage.instance);
        links.addLink(MyStaticIncludeTestPage.instance);

        return root;
    }
}
