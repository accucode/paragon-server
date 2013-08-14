package com.app.ui.activity.test;

import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScGroupArray;
import com.kodemore.servlet.control.ScPageRoot;

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
    //# variable
    //##################################################

    private ScBox _box;

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScPageRoot installRoot()
    {
        ScPageRoot root;
        root = newPageRoot();
        root.css().padSpaced10();

        // todo_wyatt: eq groups
        // root.getPostDomScript().equalizeGroups();

        _box = root.addBox();
        _box.css().padSpaced();

        ScGroupArray groups;
        groups = _box.addGroupArray();
        groups.style().floatLeft();

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
        links.addLink(MyTabbedTestPage.instance);
        links.addLink(MyEqualizeTestPage.instance);

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
        links.addLink(MyChosenTestPage.instance);

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
        links.addLink(MyGradientTestPage.instance);
        links.addLink(MyCardFlipTestPage.instance);

        group = groups.addGroup("Tools");
        links = group.addLinkBox();
        links.addLink(MyScriptTestPage.instance);
        links.addLink(MyMemoryLeakTestPage.instance);
        links.addLink(MyGmailTestPage.instance);
        links.addLink(MyStaticIncludeTestPage.instance);
        links.addLink(MyQuickTestPage.instance);

        // fixme_wyatt: remove
        group = groups.addGroup("Hack");
        links = group.addLinkBox();
        links.addLink(MyHackTestPage.instance);

        return root;
    }

    //##################################################
    //# start
    //##################################################

    @Override
    protected void postPrint()
    {
        super.postPrint();

        // todo_wyatt: move to postDomScript?
        getRoot().ajax().equalizeDecendentGroups();
    }
}
