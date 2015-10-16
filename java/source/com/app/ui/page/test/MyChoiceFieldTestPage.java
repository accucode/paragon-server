package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
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

    private ScChoiceField _choiceField;

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
        root.css().gap();

        ScForm form;
        form = root.addForm();
        form.setSubmitAction(this::handleGo);

        ScGroup group;
        group = form.addGroup("Choice Field");
        group.css().inlineBlock();

        ScBox body;
        body = group.getBody().addPad();

        body.addFieldLayout().add(createChoiceField());

        ScBox buttons;
        buttons = group.showFooter().addButtonBox();
        buttons.addSubmitButton();
        buttons.addButton("Hide Green", this::handleHideGreen);
        buttons.addButton("Show Green", this::handleShowGreen);
        buttons.addButton("Disable Blue", this::handleDisableBlue);
        buttons.addButton("Enable Blue", this::handleEnableBlue);
    }

    private ScChoiceField createChoiceField()
    {
        ScChoiceField cf;
        cf = new ScChoiceField();

        cf.addOption(null, "Null");
        cf.addOption("R", "Red");
        cf.addOption("G", "Green");
        cf.addOption("B", "Blue");
        cf.addOption("1", "One");
        cf.addOption("2", "Two");
        cf.addOption("3", "Three");

        cf.setOnChangeAction(this::handleChange);

        cf.setRequired();

        // review_aaron: Change tracking is broken for radios
        cf.disableChangeTracking();

        _choiceField = cf;

        return cf;
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

    private void handleGo()
    {
        ajax().hideAllErrors();

        _choiceField.validate();

        ajax().toast(_choiceField.getValue());
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
        String value = (String)_choiceField.getValue();

        ajax().toast("Selected: %s", value);
    }
}
