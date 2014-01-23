package com.app.ui.page.test;

import com.kodemore.email.KmEmail;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScOldGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScTextArea;
import com.kodemore.servlet.field.ScTextField;

import com.app.email.MyEmailSmtpMethod;

public class MySmtpTestPage
    extends MyAbstractTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MySmtpTestPage instance = new MySmtpTestPage();

    private MySmtpTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScTextField _toField;
    private ScTextField _fromField;
    private ScTextField _subjectField;
    private ScTextArea  _messageField;

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
        _toField = new ScTextField();
        _toField.setLabel("To");
        _toField.setRequired();

        _fromField = new ScTextField();
        _fromField.setLabel("From");
        _fromField.setRequired();

        _subjectField = new ScTextField();
        _subjectField.setLabel("Subject");
        _subjectField.setRequired();

        _messageField = new ScTextArea();
        _messageField.setLabel("Message");
        _messageField.setRequired();

        ScForm form;
        form = root.addForm();
        form.css().pad();
        form.setSubmitAction(newSendAction());

        ScOldGroup group;
        group = form.addOldGroup("Send Email via SMTP");

        ScBox body;
        body = group.addGap();
        body.addText("Send an email using SMTP.");
        body.addBreak();

        ScFieldTable fields;
        fields = body.addFields();
        fields.add(_toField);
        fields.add(_fromField);
        fields.add(_subjectField);
        fields.add(_messageField);

        group.addDivider();
        group.addButtonBox().addSubmitButton("Send");
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newSendAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handleSend();
            }
        };
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSend()
    {
        validate();

        KmEmail e;
        e = new KmEmail();
        e.addTo(_toField.getValue());
        e.setFrom(_fromField.getValue());
        e.setSubject(_subjectField.getValue());
        e.addTextPart(_messageField.getValue());

        MyEmailSmtpMethod m;
        m = new MyEmailSmtpMethod();
        m.send(e);
        Object[] args = {};

        ajax().toast("Your email has been sent.", args);
    }
}
