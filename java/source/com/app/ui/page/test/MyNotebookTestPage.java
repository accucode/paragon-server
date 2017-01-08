package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScNotebook;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScText;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyNotebookTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyNotebookTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyNotebookTestPage();
    }

    public static MyNotebookTestPage getInstance()
    {
        return _instance;
    }

    private MyNotebookTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScNotebook _notebook;

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
        root.css().fill().auto().boxGray().gap();

        ScNotebook book;
        book = root.addNotebook();
        book.setTabChangedAction(this::handleTabChange);
        book.flexFill();
        _notebook = book;

        ScText tab1;
        tab1 = book.addText();
        tab1.setLabel("One");
        tab1.setValue("One aaa bbb ccc.");

        ScDiv tab2;
        tab2 = book.addDiv();
        tab2.setLabel("Two");
        tab2.addTextParagraph("Two nnn ooo ppp.");
        tab2.addButton("Test", this::handleTest);

        ScActionButton tab3;
        tab3 = book.addButton("Test", this::handleTest);
        tab3.setLabel("Three");

        ScDiv tab4;
        tab4 = book.addDiv();
        tab4.setLabel("Four");
        tab4.css().boxBlue().flexChildFiller();
        tab4.addTextParagraph("Content has 'flexFiller' css style");

        ScDiv tab5;
        tab5 = book.addDiv();
        tab5.setLabel("Five");
        tab5.css().boxGreen().fill();
        tab5.addTextParagraph("Content has 'fill' css style");
        tab5.addButton("Button", newUncheckedAction(this::handleButtonClick));
    }

    private void handleButtonClick()
    {
        Integer i = _notebook.getSelectedTabIndex();
        ajaxToast("Tab Index: " + i);
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

    private void handleTest()
    {
        ajax().toast("Test");
    }

    private void handleTabChange()
    {
        ajax().toast("Tab Changed: " + _notebook.getSelectedTabIndex());
    }
}
