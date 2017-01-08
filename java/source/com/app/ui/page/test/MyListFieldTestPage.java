package com.app.ui.page.test;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScListField;
import com.kodemore.servlet.field.ScOption;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyListFieldTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyListFieldTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyListFieldTestPage();
    }

    public static MyListFieldTestPage getInstance()
    {
        return _instance;
    }

    private MyListFieldTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScListField<Integer> _field;

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
        root.css().fill().auto().columnSpacer10();

        installFormOn(root);
        installInlineOn(root);
        installBlockOn(root);
        installFlexFillerOn(root);
    }

    private void installFormOn(ScPageRoot root)
    {
        _field = newListField("Form");
        _field.onChange(newUncheckedAction(this::handleOnChange));

        ScForm form;
        form = root.addForm();
        form.setSubmitAction(this::handleSubmit);

        ScGroup group;
        group = form.addGroup("Form");

        ScFieldTable fields;
        fields = group.getBody().addPad().addFieldTable();
        fields.add(_field);

        ScDiv footer;
        footer = group.showFooter();
        footer.css().flexRow().flexAlignSpaced();

        ScDiv left;
        left = footer.addButtonBox();
        left.addSubmitButton();
        left.addResetButton();

        ScDiv right;
        right = footer.addButtonBox();
        right.addButton("Set 5", newUncheckedAction(this::handleSetTo5));
        right.addButton("Add 11", newUncheckedAction(this::handleAddOption11));
        right.addButton("Options 246", newUncheckedAction(this::handleSetOptions246));
    }

    private void installInlineOn(ScPageRoot root)
    {
        ScListField<Integer> list;
        list = newListField("Inline");
        list.layoutInline();

        ScGroup group;
        group = root.addGroup(list.getLabel());

        ScFieldTable fields;
        fields = group.getBody().addPad().addFieldTable();
        fields.add(list);
    }

    private void installBlockOn(ScPageRoot root)
    {
        ScListField<Integer> list;
        list = newListField("Block");
        list.layoutBlock();

        ScGroup group;
        group = root.addGroup(list.getLabel());

        ScFieldTable fields;
        fields = group.getBody().addPad().addFieldTable();
        fields.add(list);
    }

    private void installFlexFillerOn(ScPageRoot root)
    {
        ScListField<Integer> list;
        list = newListField("Flex Filler");
        list.layoutFlexFiller();

        ScGroup group;
        group = root.addGroup(list.getLabel());

        ScDiv row;
        row = group.getBody().addFlexRow();
        row.css().gap();
        row.addButton("before");
        row.add(list);
        row.addButton("after");
    }

    private ScListField<Integer> newListField(String label)
    {
        ScListField<Integer> e;
        e = new ScListField<>();
        e.setLabel(label);
        e.setHelp("A list of integers");
        e.addOption(null, "<select>");
        e.addOption(1, "one");
        e.addOption(2, "two");
        e.addOption(3, "three");
        e.addOption(4, "four");
        e.addOption(5, "five");
        e.addOption(6, "six");
        e.addOption(7, "seven");
        e.addOption(8, "eight");
        e.addOption(9, "nine");
        e.addOption(10, "ten");
        return e;
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

    private void handleOnChange()
    {
        ajax().toast("on change %s.", _field.getValue());
    }

    private void handleSubmit()
    {
        ajax().hideAllErrors();
        validate();

        getRoot().ajaxUpdateFieldValues();
        ajax().toast("Number = %s.", _field.getValue());
    }

    private void handleSetTo5()
    {
        _field.ajaxSetFieldValue(5);
    }

    private void handleAddOption11()
    {
        _field.ajaxAddOption(11, "eleven");
    }

    private void handleSetOptions246()
    {
        KmList<ScOption<Integer>> v;
        v = new KmList<>();
        v.add(ScOption.create(2, "two"));
        v.add(ScOption.create(4, "four"));
        v.add(ScOption.create(6, "six"));

        _field.ajaxSetOptions(v);
    }

}
