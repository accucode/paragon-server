package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScColorField;

public class MyColorFieldTestPage
    extends MyAbstractTestEntryPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyColorFieldTestPage instance = new MyColorFieldTestPage();

    private MyColorFieldTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScColorField _colorField;

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
        _colorField = new ScColorField();
        _colorField.setLabel("Color");

        ScForm form;
        form = root.addForm();
        form.setSubmitAction(this::handleSubmit);
        form.css().pad();

        ScGroup group;
        group = form.addGroup("Color Field");

        ScFieldTable fields;
        fields = group.getBody().addPad().addFieldTable();
        fields.add(_colorField);

        group.addBodyDivider();
        group.getBody().addButtonBox().addSubmitButton();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSubmit()
    {
        ajax().hideAllErrors();

        validate();

        ajax().toast("Color = %s", _colorField.getValue());
    }

}
