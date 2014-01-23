package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScOldGroup;
import com.kodemore.servlet.control.ScOldGroupArray;
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
        root.getPostRenderScript().equalizeGroups();

        ScOldGroupArray groups;
        groups = root.addOldGroupArray();
        groups.style().floatLeft();

        ScOldGroup group;
        ScBox links;

        group = groups.addOldGroup("Personal");
        links = group.addLinkBox();
        links.addLink(MyWyattTestPage.instance);

        group = groups.addOldGroup("Layout");
        links = group.addLinkBox();
        links.addLink(MyAccordionTestPage.instance);
        links.addLink(MyBorderTestPage.instance);
        links.addLink(MyBlankTestPage.instance);
        links.addLink(MyEqualizeTestPage.instance);
        links.addLink(MyFormTestPage.instance);
        links.addLink(MyGroupIconHeaderTestPage.instance);
        links.addLink(MyGroupTestPage.instance);
        links.addLink(MyNotebookTestPage.instance);
        links.addLink(MyPaddingTestPage.instance);
        links.addLink(MyPlaceholderTestPage.instance);
        links.addLink(MyPopupMenuTestPage.instance);
        links.addLink(MyTabbedTestPage.instance);
        links.addLink(MyBorderLayoutTestPage.instance);
        links.addLink(MyTitlePanelTestPage.instance);

        group = groups.addOldGroup("Fields");
        links = group.addLinkBox();
        links.addLink(MyFieldTestPage.instance);
        links.addLink(MyLocalValueTestPage.instance);
        links.addLink(MyDateFieldTestPage.instance);
        links.addLink(MyColorFieldTestPage.instance);
        links.addLink(MyAutoCompleteTestPage.instance);
        links.addLink(MyGoogleChartTestPage.instance);
        links.addLink(MyGridTestPage.instance);
        links.addLink(MyDropzoneTestPage.instance);
        links.addLink(MyRadioButtonTestPage.instance);

        group = groups.addOldGroup("Misc");
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
        links.addLink(MyChartTestPage.instance);
        links.addLink(MyTimeAgoTestPage.instance);

        group = groups.addOldGroup("Tools");
        links = group.addLinkBox();
        links.addLink(MyScriptTestPage.instance);
        links.addLink(MyMemoryLeakTestPage.instance);
        links.addLink(MyGmailTestPage.instance);
        links.addLink(MySmtpTestPage.instance);
        links.addLink(MyStaticIncludeTestPage.instance);
        links.addLink(MyHandleSortTestPage.instance);
        links.addLink(MyHoverTestPage.instance);
        links.addLink(MyDragScrollToTestPage.instance);
        links.addLink(MyFacebookTestPage.instance);
        links.addLink(MyPageSessionTest1Page.instance);
    }
}
