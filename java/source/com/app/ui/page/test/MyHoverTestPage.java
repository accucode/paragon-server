package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScButton;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScImage;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScTextField;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyHoverTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyHoverTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyHoverTestPage();
    }

    public static MyHoverTestPage getInstance()
    {
        return _instance;
    }

    private MyHoverTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScTextField _nameField;
    private ScForm      _form;

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
        _nameField = new ScTextField();
        _nameField.setLabel("Name");
        _nameField.setHoverText("Please enter a name here.");
        _nameField.css().padLeft5();

        _form = root.addForm();
        _form.css().gap();
        _form.setHoverText("This is text that shows when hovering over the entire form.");
        _form.getPostRenderScript().tooltip();

        ScGroup group;
        group = _form.addGroup();

        ScDiv left;
        left = group.getBanner().addFloatLeft();
        left.css().pad5();

        ScImage image;
        image = left.addImage();
        image.setSource(getCommonImageUrl("smiley.png"));
        image.setHoverText("Smile!");

        group.getBody().addPad().addText(
            "Show hover text over the icon, form, field, and button using the title attribute");
        group.getBody().addPad().addFieldTable().add(_nameField);
        group.addBodyDivider();

        ScButton button;
        button = group.getBody().addButtonBox().addButton("Clear", this::handleClear);
        button.setHoverText("This button is used for clearing the field.");
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

    private void handleClear()
    {
        _nameField.clearText();
        _nameField.ajaxUpdateValue();
    }
}
