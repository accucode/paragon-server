package com.app.ui.activity.test;

import com.app.email.*;
import com.app.ui.activity.*;
import com.kodemore.email.*;
import com.kodemore.servlet.action.*;
import com.kodemore.servlet.control.*;
import com.kodemore.servlet.field.*;

public class MySmtpTestPage
    extends MyTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyActivity instance = new MySmtpTestPage();

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
        form.setDefaultAction(newSendAction());

        ScGroup group;
        group = form.addGroup("Send Email via SMTP");

        ScBox body;
        body = group.addPadSpaced();
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
