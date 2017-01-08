package com.app.ui.layout;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.field.ScPasswordField;
import com.kodemore.utility.Kmu;

import com.app.model.MyUser;
import com.app.model.meta.MyMetaUser;
import com.app.ui.control.MyDialog;

public class MyChangePasswordDialog
    extends MyDialog
{
    //##################################################
    //# variables
    //##################################################

    private ScPasswordField _oldPasswordField;
    private ScPasswordField _newPasswordField;
    private ScPasswordField _retypePasswordField;

    //##################################################
    //# constructor
    //##################################################

    public MyChangePasswordDialog()
    {
        install();
    }

    //##################################################
    //# install
    //##################################################

    private void install()
    {
        setLabel("Change Password");
        getForm().setSubmitAction(this::handleSave);

        installHeader();
        installBody();
        installFooter();
    }

    private void installHeader()
    {
        MyMetaUser x = MyUser.Meta;

        ScDiv header;
        header = showHeader();
        header.css().pad20();

        ScFieldTable fields;
        fields = header.addFieldTable();
        fields.addFieldText(x.FullName);
        fields.addFieldText(x.Email);
    }

    private void installBody()
    {
        ScDiv body;
        body = getBody();
        body.css().pad20();

        ScFieldTable fields;
        fields = body.addFieldTable();
        fields.add(createOldPasswordField());
        fields.addSpace();
        fields.add(createNewPasswordField());
        fields.add(createRetypePasswordField());
    }

    private void installFooter()
    {
        ScDiv footer;
        footer = showFooter().addButtonBox();
        footer.addSaveButton();
        footer.addCancelButton(this::ajaxClose);
    }

    //==================================================
    //= install :: fields
    //==================================================

    private ScPasswordField createOldPasswordField()
    {
        ScPasswordField e;
        e = new ScPasswordField();
        e.setLabel("Old Password");
        _oldPasswordField = e;
        return e;
    }

    private ScPasswordField createNewPasswordField()
    {
        ScPasswordField e;
        e = new ScPasswordField();
        e.setLabel("New Password");
        e.setRequired();
        _newPasswordField = e;
        return e;
    }

    private ScPasswordField createRetypePasswordField()
    {
        ScPasswordField e;
        e = new ScPasswordField();
        e.setLabel("Retype Password");
        e.setRequired();
        _retypePasswordField = e;
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        MyUser u = getGlobals().getCurrentUser();
        applyFromModel(u);
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSave()
    {
        ajaxHideAllErrors();
        validate();

        String old = _oldPasswordField.getValue();
        String new1 = _newPasswordField.getValue();
        String new2 = _retypePasswordField.getValue();

        MyUser u = getGlobals().getCurrentUser();
        if ( !u.hasPassword(old) )
        {
            _oldPasswordField.ajaxFocus();
            _oldPasswordField.error("Invalid.");
        }

        if ( Kmu.isNotEqual(new1, new2) )
        {
            _retypePasswordField.ajaxClearFieldValue();
            _retypePasswordField.ajaxFocus();
            _retypePasswordField.error("Passwords did not match.");
        }

        u.setPassword(new1);
        daoFlush();
        ajaxClose();
    }
}
