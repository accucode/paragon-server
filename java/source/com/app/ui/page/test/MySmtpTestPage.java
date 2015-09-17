package com.app.ui.page.test;

import com.kodemore.email.KmEmail;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScTextArea;
import com.kodemore.servlet.field.ScTextField;

import com.app.email.MyEmailSmtpMethod;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MySmtpTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MySmtpTestPage _instance;

    public static void installInstance()
    {
        _instance = new MySmtpTestPage();
    }

    public static MySmtpTestPage getInstance()
    {
        return _instance;
    }

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
    //# settings
    //##################################################

    @Override
    public final MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.developer;
    }

    //##################################################
    //# bookmark
    //##################################################

    @Override
    public void composeBookmarkOn(ScParameterList v)
    {
        // none
    }

    @Override
    public void applyBookmark(ScParameterList v)
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
        form.setSubmitAction(this::handleSend);

        ScGroup group;
        group = form.addGroup("Smtp Test");

        ScBox body;
        body = group.getBody().addGap();
        body.addText("Send an email using SMTP.");
        body.addBreak();

        ScFieldTable fields;
        fields = body.addFieldTable();
        fields.add(_toField);
        fields.add(_fromField);
        fields.add(_subjectField);
        fields.add(_messageField);

        group.addBodyDivider();
        group.getBody().addButtonBox().addSubmitButton("Send");
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        // none
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
