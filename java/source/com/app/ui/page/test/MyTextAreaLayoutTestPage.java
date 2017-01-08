package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScTextArea;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyTextAreaLayoutTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyTextAreaLayoutTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyTextAreaLayoutTestPage();
    }

    public static MyTextAreaLayoutTestPage getInstance()
    {
        return _instance;
    }

    private MyTextAreaLayoutTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScTextArea _field;

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
        root.css().fill().auto();

        ScForm form;
        form = root.addForm();
        form.css().columnSpacer10();

        installDefaultOn(form);
        installFixedOn(form);
        installBlockOn(form);
        installFlexFillerOn(form);
    }

    private void installDefaultOn(ScForm form)
    {
        ScTextArea field;
        field = new ScTextArea();
        field.setHelp("A help message");
        _field = field;

        ScDiv div;
        div = form.addDiv();
        div.css().boxGray().pad();
        div.addParagraph("Normal");
        div.add(field);
        div.addBreak();
        div.addLink("toast", newUncheckedAction(this::handleToastValue));
        div.addSpace();
        div.addLink("set 5.1", newUncheckedAction(this::handleSetValue));
    }

    private void installFixedOn(ScForm form)
    {
        ScTextArea field;
        field = new ScTextArea();
        field.setHelp("A help message");
        field.layoutInline(400, 100);

        ScDiv div;
        div = form.addDiv();
        div.css().boxGray().pad();
        div.addParagraph("Fixed");
        div.add(field);
    }

    private void installBlockOn(ScForm form)
    {
        ScTextArea field;
        field = new ScTextArea();
        field.setHelp("A help message");
        field.layoutBlock(100);

        ScDiv div;
        div = form.addDiv();
        div.css().boxGray().pad();
        div.addParagraph("Block");
        div.add(field);
    }

    private void installFlexFillerOn(ScForm form)
    {
        ScTextArea field;
        field = new ScTextArea();
        field.setHelp("A help message");
        field.layoutFlexFiller(null, 100);
        field.cssMargin().left();

        ScDiv div;
        div = form.addDiv();
        div.css().boxGray().pad();
        div.addParagraph("Flex Filler");

        ScDiv row;
        row = div.addFlexRow();
        row.addButton("before");
        row.add(field);
        row.addButton("after");
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        // none
    }

    //##################################################
    //# handle
    //##################################################

    private void handleToastValue()
    {
        ajax().toast(_field.getValue());
    }

    private void handleSetValue()
    {
        _field.ajaxSetFieldValue("a\nb\nc");
    }

}
