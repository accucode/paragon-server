package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScColorField;

public class MyColorFieldTestPage
    extends MyTestPage
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
    public void initUrlFromSession(ScParameterList v)
    {
        // none
    }

    @Override
    public void initSessionFromUrl(ScParameterList v)
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
        form.setDefaultAction(newSubmitAction());
        form.css().pad();

        ScGroup group;
        group = form.addGroup("Color Field Test");

        ScFieldTable fields;
        fields = group.addPad().addFields();
        fields.add(_colorField);

        group.addDivider();
        group.addButtonBox().addSubmitButton();
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
