package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScButton;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScImage;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScTextField;

public class MyHoverTestPage
    extends MyAbstractTestEntryPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyHoverTestPage instance = new MyHoverTestPage();

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
    //# handle
    //##################################################

    private void handleClear()
    {
        _nameField.clearText();
        _nameField.ajaxUpdateValue();
    }
}
