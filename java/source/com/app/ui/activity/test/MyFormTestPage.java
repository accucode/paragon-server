package com.app.ui.activity.test;

import com.app.ui.activity.MyActivity;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScTextField;

public class MyFormTestPage
    extends MyTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyActivity instance = new MyFormTestPage();

    private MyFormTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScTextField _textField;

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        _textField = new ScTextField();
        _textField.setLabel("Field");
        _textField.css().padLeft5();

        ScForm form;
        form = root.addForm();
        form.setDefaultAction(newSubmitAction());
        form.css().gap();

        ScGroup group;
        group = form.addGroup("Form Test");
        group.addPad().addFields().add(_textField);
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
