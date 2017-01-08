package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScDoubleField;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyTextFieldLayoutTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyTextFieldLayoutTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyTextFieldLayoutTestPage();
    }

    public static MyTextFieldLayoutTestPage getInstance()
    {
        return _instance;
    }

    private MyTextFieldLayoutTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScDoubleField _doubleField;

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
        form.css().flexColumn().columnSpacer10();

        installDefaultOn(form);
        installFixedOn(form);
        installBlockOn(form);
        installFlexFillerOn(form);
    }

    private void installDefaultOn(ScForm form)
    {
        ScDoubleField field;
        field = new ScDoubleField();
        field.setHelp("A help message");
        field.setRequired();

        _doubleField = field;

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
        ScDoubleField field;
        field = new ScDoubleField();
        field.setHelp("A help message");
        field.layoutInline(400);

        ScDiv div;
        div = form.addDiv();
        div.css().boxGray().pad();
        div.addParagraph("Fixed");
        div.add(field);
    }

    private void installBlockOn(ScForm form)
    {
        ScDoubleField field;
        field = new ScDoubleField();
        field.setHelp("A help message");
        field.layoutBlock();

        ScDiv div;
        div = form.addDiv();
        div.css().boxGray().pad();
        div.addParagraph("Block");
        div.add(field);
    }

    private void installFlexFillerOn(ScForm form)
    {
        ScDoubleField field;
        field = new ScDoubleField();
        field.setHelp("A help message");
        field.layoutFlexFiller();
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
        ajax().toast(_doubleField.getValue());
    }

    private void handleSetValue()
    {
        _doubleField.ajaxSetFieldValue(5.1);
    }

}
