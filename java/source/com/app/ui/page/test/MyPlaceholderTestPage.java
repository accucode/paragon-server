package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScTextField;

public class MyPlaceholderTestPage
    extends MyAbstractTestEntryPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyPlaceholderTestPage instance = new MyPlaceholderTestPage();

    private MyPlaceholderTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScTextField _textField;

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
        _textField = new ScTextField();
        _textField.setLabel("Field");
        _textField.setPlaceholder("Enter a name");
        _textField.css().padLeft5();

        ScForm form;
        form = root.addForm();
        form.setSubmitAction(this::handleOk);
        form.css().gap();

        ScGroup group;
        group = form.addGroup("Placeholder Test");

        ScBox box;
        box = group.getBody().addGap();
        box.addBox().addText(
            "The following field should show a 'placeholder' hint inside the field...");
        box.addFieldTable().add(_textField);
        group.addBodyDivider();
        group.getBody().addButtonBox().addSubmitButton();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleOk()
    {
        String s = _textField.getValue();
        if ( s == null )
            s = "<null>";

        ajax().toast(s);
    }

}
