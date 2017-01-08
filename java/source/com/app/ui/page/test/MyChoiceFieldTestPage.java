package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScChoiceField;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyChoiceFieldTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyChoiceFieldTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyChoiceFieldTestPage();
    }

    public static MyChoiceFieldTestPage getInstance()
    {
        return _instance;
    }

    private MyChoiceFieldTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScChoiceField<String> _choiceField;

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
        form.setSubmitAction(this::handleSubmit);

        ScGroup group;
        group = form.addGroup("Choice Field");

        ScDiv body;
        body = group.getBody().addPad();
        body.add(createChoiceField());

        ScDiv buttons;
        buttons = group.showFooter().addButtonBox();
        buttons.addSubmitButton();
        buttons.addButton("Select Blue", this::handleSelectBlue);
        buttons.addButton("Hide Green", this::handleHideGreen);
        buttons.addButton("Show Green", this::handleShowGreen);
        buttons.addButton("Disable Blue", this::handleDisableBlue);
        buttons.addButton("Enable Blue", this::handleEnableBlue);
    }

    private ScChoiceField<String> createChoiceField()
    {
        ScChoiceField<String> e;
        e = new ScChoiceField<>();
        e.onChange(newUncheckedAction(this::handleChange));
        e.disableChangeTracking();
        e.setRequired();
        e.setHelp("A help message x.");

        e.addOption(null, "Null");
        e.addOption("R", "Red");
        e.addOption("G", "Green");
        e.addOption("B", "Blue");
        e.addOption("1", "One");
        e.addOption("2", "Two");
        e.addOption("3", "Three");

        _choiceField = e;
        return e;
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void preRender()
    {
        // none
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSubmit()
    {
        ajax().hideAllErrors();

        _choiceField.validate();
        _choiceField.ajaxUpdateFieldValues();

        ajax().toast(_choiceField.getValue());
    }

    private void handleSelectBlue()
    {
        _choiceField.setValue("B");
        _choiceField.ajaxUpdateFieldValues();
    }

    private void handleHideGreen()
    {
        _choiceField.ajaxHideOption("G");
    }

    private void handleShowGreen()
    {
        _choiceField.ajaxShowOption("G");
    }

    private void handleDisableBlue()
    {
        _choiceField.ajaxDisableOption("B");
    }

    private void handleEnableBlue()
    {
        _choiceField.ajaxEnableOption("B");
    }

    private void handleChange()
    {
        String value = _choiceField.getValue();

        ajax().toast("Selected: %s", value);
    }
}
