package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScButton;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScTextArea;
import com.kodemore.servlet.field.ScTextField;

import com.app.model.MyUser;

public class MyScriptTestPage
    extends MyAbstractTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyScriptTestPage instance = new MyScriptTestPage();

    private MyScriptTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScTextArea _scriptField;

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
        ScForm form;
        form = root.addForm();
        form.setSubmitAction(newRunAction());
        form.css().gap();

        installScript(form);
        installSamples(form);
    }

    private void installScript(ScForm root)
    {
        ScGroup group;
        group = root.addGroup();

        ScTextArea field;
        field = group.addPad().addTextArea();
        field.setWidthFull();
        field.style().height(100);

        group.addDivider();
        group.addButtonBox().addSubmitButton();

        _scriptField = field;
    }

    private void installSamples(ScContainer root)
    {
        ScGroup group;
        group = root.addGroup();

        ScBox buttons;
        buttons = group.addButtonBox();

        ScButton b;
        b = buttons.addButton();
        b.setText(b.getHtmlId());

        buttons = group.addButtonBox();
        b = buttons.addButton();
        b.setText(b.getHtmlId());

        b = buttons.addButton();
        b.setText(b.getHtmlId());

        b = buttons.addButton();
        b.setText(b.getHtmlId());

        ScFieldTable fields;
        fields = group.addPad().addFields();

        ScTextField textField;
        textField = fields.addTextField();
        textField.setLabel(textField.getHtmlId());

        textField = fields.addTextField();
        textField.setLabel(textField.getHtmlId());
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newRunAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleRun();
            }
        };
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void preRender()
    {
        super.preRender();

        MyUser u;
        u = getAccess().getUserDao().findAll().getFirst();
        u.applyTo(this);
    }

    //##################################################
    //# handle
    //##################################################

    private void handleRun()
    {
        String s = _scriptField.getValue();

        if ( s == null )
            ajax().alert("No script");
        else
            ajax().run(s);
    }

}
