package com.app.ui.activity.test;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.field.ScColorField;

public class MyColorFieldTestPage
    extends MyAbstractTestPage
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
    //# install
    //##################################################

    @Override
    protected ScControl installRoot()
    {
        _colorField = new ScColorField();
        _colorField.setLabel("Color");

        ScForm root;
        root = new ScForm();
        root.setDefaultAction(newSubmitAction());
        root.css().pad();

        ScGroup group;
        group = root.addGroup("Color Field Test");

        ScFieldTable fields;
        fields = group.addPad().addFields();
        fields.add(_colorField);

        group.addDivider();
        group.addButtonBox().addSubmitButton();

        return root;
    }

    private ScActionIF newSubmitAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleSubmit();
            }
        };
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
