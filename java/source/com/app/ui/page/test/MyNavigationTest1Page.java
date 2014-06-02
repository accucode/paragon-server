package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScTextField;

public class MyNavigationTest1Page
    extends MyAbstractTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyNavigationTest1Page instance = new MyNavigationTest1Page();

    private MyNavigationTest1Page()
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

    public void push(String value)
    {
        _textField.setValue(value);
        _push();
    }

    @Override
    public ScParameterList composeQueryParameters()
    {
        ScParameterList v;
        v = new ScParameterList();
        v.setValue("value", _textField.getValue());
        return v;
    }

    @Override
    public void applyQueryParameters(ScParameterList v)
    {
        _textField.setValue(v.getValue("value"));
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        _textField = new ScTextField();
        _textField.setLabel("Test");

        root.css().gap();

        ScForm form;
        form = root.addForm();

        ScGroup group;
        group = form.addGroup();
        group.setTitle("Navigation Test (Page 1)");
        group.css().width400();

        ScBox body;
        body = group.addPad();
        body.addFields().add(_textField);

        group.addDivider();

        ScBox footer;
        footer = group.addButtonBoxLeft();
        footer.addButton("Update", newUpdateHistoryAction());
        footer.addButton("Navigate", newNavigateAction());
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();
    }

    //##################################################
    //# action
    //##################################################

    private ScActionIF newNavigateAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleNavigate();
            }
        };
    }

    private ScActionIF newUpdateHistoryAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleUpdateHistory();
            }
        };
    }

    //##################################################
    //# handle
    //##################################################

    private void handleNavigate()
    {
        String value = _textField.getValue();
        MyNavigationTest2Page.instance.push(value);
    }

    private void handleUpdateHistory()
    {
        ajax().replaceHistory(this);
    }
}