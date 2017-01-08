package com.app.ui.page.test;

import com.kodemore.servlet.control.ScContainer;

import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.tools.MyHibernateCacheTestPage;

/**
 * I act as a full page menu for various development tests.
 */
public final class MyTestMenuPage
    extends MyMenuPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyTestMenuPage _instance;

    public static void installInstance()
    {
        _instance = new MyTestMenuPage();
    }

    public static MyTestMenuPage getInstance()
    {
        return _instance;
    }

    private MyTestMenuPage()
    {
        // singleton
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.developer;
    }

    @Override
    public String getTitle()
    {
        return "Tests";
    }

    @Override
    protected Integer getGroupWidth()
    {
        return 200;
    }

    @Override
    protected Integer getGroupHeight()
    {
        return 300;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installMenus()
    {
        installCommon();
        installLayout();
        installBasicFields();
        installFancyFields();
        installMisc();
        installTools();
        installExternal();
    }

    private void installCommon()
    {
        ScContainer box;
        box = addMenu("Common");
        box.addLink(MyWyattTestPage.getInstance());
    }

    private void installLayout()
    {
        ScContainer box;
        box = addMenu("Layout");
        box.addLink(MyBlankTestPage.getInstance());
        box.addLink(MyFlexboxTestPage.getInstance());
        box.addLink(MyAbsoluteLayoutTestPage.getInstance());
        box.addLink(MyAccordionTestPage.getInstance());
        box.addLink(MyBorderTestPage.getInstance());
        box.addLink(MyFormTestPage.getInstance());
        box.addLink(MyGroupTestPage.getInstance());
        box.addLink(MyDetachedGroupTestPage.getInstance());
        box.addLink(MyNotebookTestPage.getInstance());
        box.addLink(MyPlaceholderTestPage.getInstance());
        box.addLink(MyBorderLayoutTestPage.getInstance());
        box.addLink(MySplitterTestPage.getInstance());
    }

    private void installBasicFields()
    {
        ScContainer box;
        box = addMenu("Basic Fields");
        box.addLink(MyFieldTestPage.getInstance());
        box.addLink(MyFieldsetTestPage.getInstance());
        box.addLink(MyLocalValueTestPage.getInstance());
        box.addLink(MyDateFieldTestPage.getInstance());
        box.addLink(MyCheckboxListTestPage.getInstance());
        box.addLink(MyRadioListTestPage.getInstance());
        box.addLink(MyTextFieldLayoutTestPage.getInstance());
        box.addLink(MyTextAreaLayoutTestPage.getInstance());
        box.addLink(MyHiddenFieldTestPage.getInstance());
        box.addLink(MyRadioFieldTestPage.getInstance());
        box.addLink(MyListFieldTestPage.getInstance());
        box.addLink(MyDropdownFieldTestPage.getInstance());
        box.addLink(MyDomainDropdownTestPage.getInstance());
    }

    private void installFancyFields()
    {
        ScContainer box;
        box = addMenu("Fancy Fields");
        box.addLink(MyAddressFieldTestPage.getInstance());
        box.addLink(MyDateIntervalFieldTestPage.getInstance());
        box.addLink(MyGridTestPage.getInstance());
        box.addLink(MyRichTextEditorTestPage.getInstance());
        box.addLink(MyMultiTupleViewTestPage.getInstance());
        box.addLink(MyListCalendarTestPage.getInstance());
        box.addLink(MyAjaxCalendarTestPage.getInstance());
        box.addLink(MyChoiceFieldTestPage.getInstance());
        box.addLink(MyDropzoneTestPage.getInstance());
        box.addLink(MyAutoCompleteTestPage.getInstance());
        box.addLink(MyColorFieldTestPage.getInstance());
        box.addLink(MyBarcodeFieldTestPage.getInstance());
    }

    private void installMisc()
    {
        ScContainer box;
        box = addMenu("Misc");
        box.addLink(MyBlockTestPage.getInstance());
        box.addLink(MySlowTestPage.getInstance());
        box.addLink(MyToastTestPage.getInstance());
        box.addLink(MyAnimationTestPage.getInstance());
        box.addLink(MyHideErrorsTestPage.getInstance());
        box.addLink(MyOpenWindowTestPage.getInstance());
        box.addLink(MyDownloadTestPage.getInstance());
        box.addLink(MyDialogTestPage.getInstance());
        box.addLink(MyBarcodeTestPage.getInstance());
        box.addLink(MyGradientTestPage.getInstance());
        box.addLink(MyCardFlipTestPage.getInstance());
        box.addLink(MyNvd3ChartTestPage.getInstance());
        box.addLink(MyTimeAgoTestPage.getInstance());
        box.addLink(MyFilterTableRowTestPage.getInstance());
        box.addLink(MyCookieTestPage.getInstance());
        box.addLink(MyOldValuesTestPage.getInstance());
    }

    private void installTools()
    {
        ScContainer box;
        box = addMenu("Tools");
        box.addLink(MyScriptTestPage.getInstance());
        box.addLink(MyMemoryLeakTestPage.getInstance());
        box.addLink("Email - Gmail", MyGmailTestPage.getInstance());
        box.addLink("Email - SMTP", MySmtpTestPage.getInstance());
        box.addLink(MyStaticIncludeTestPage.getInstance());
        box.addLink(MyHoverTestPage.getInstance());
        box.addLink(MyDragTestPage.getInstance());
        box.addLink(MyFacebookTestPage.getInstance());
        box.addLink(MySharedState1TestPage.getInstance());
        box.addLink(MyNavigation1TestPage.getInstance());
        box.addLink(MyHibernateCacheTestPage.getInstance());
    }

    private void installExternal()
    {
        ScContainer box;
        box = addMenu("External");
        box.addLink(MyIntacctTestPage.getInstance());
    }
}
