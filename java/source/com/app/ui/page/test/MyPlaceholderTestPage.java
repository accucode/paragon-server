package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScTextField;

public class MyPlaceholderTestPage
    extends MyAbstractTestPage
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
        form.setSubmitAction(newSubmitAction());
        form.css().gap();

        ScGroup group;
        group = form.addGroup("Placeholder Test");

        ScBox box;
        box = group.addPadSpaced();
        box.addBox().addText(
            "The following field should show a 'placeholder' hint inside the field...");
        box.addFields().add(_textField);
        group.addDivider();
        group.addButtonBox().addSubmitButton();
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newSubmitAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handleOk();
            }
        };
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
