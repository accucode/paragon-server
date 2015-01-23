package com.app.ui.page.userProfile;

import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.field.ScPasswordField;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.Kmu;

import com.app.model.MyUser;
import com.app.ui.control.MyCard;

public class MyUserProfileChangePasswordCard
    extends MyCard
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField     _nameField;
    private ScTextField     _emailField;
    private ScTextField     _roleField;

    private ScPasswordField _oldPasswordField;
    private ScPasswordField _newPasswordField;
    private ScPasswordField _retypePasswordField;

    //##################################################
    //# constructor
    //##################################################

    @Override
    public void install()
    {
        super.install();

        createFields();
        installLayout();
    }

    private void createFields()
    {
        _nameField = new ScTextField();
        _nameField.setLabel("Name");
        _nameField.css().padLeft5();
        _nameField.setReadOnly();

        _emailField = new ScTextField();
        _emailField.setLabel("Email");
        _emailField.css().padLeft5();
        _emailField.setReadOnly();

        _roleField = new ScTextField();
        _roleField.setLabel("Role");
        _roleField.css().padLeft5();
        _roleField.setReadOnly();

        _oldPasswordField = new ScPasswordField();
        _oldPasswordField.setLabel("Old Password");
        _oldPasswordField.setWidthFull();
        _oldPasswordField.css().padLeft5();

        _newPasswordField = new ScPasswordField();
        _newPasswordField.setLabel("New Password");
        _newPasswordField.setWidthFull();
        _newPasswordField.css().padLeft5();

        _retypePasswordField = new ScPasswordField();
        _retypePasswordField.setLabel("Retype Password");
        _retypePasswordField.setWidthFull();
        _retypePasswordField.css().padLeft5();
    }

    private void installLayout()
    {
        ScForm form;
        form = addForm();
        form.css().gap();
        form.setSubmitAction(this::handleSave);

        ScGroup group;
        group = form.addGroup("Change Password");

        installFields(group);
        installFooter(group);
    }

    private void installFields(ScGroup group)
    {
        ScFieldTable fields;
        fields = group.getBody().addPad().addFieldTable();
        fields.add(_nameField);
        fields.add(_emailField);
        fields.add(_roleField);

        group.addBodyDivider();

        fields = group.getBody().addPad().addFieldTable();
        fields.add(_oldPasswordField);
        fields.add(_newPasswordField);
        fields.add(_retypePasswordField);
    }

    private void installFooter(ScGroup group)
    {
        ScDiv footer;
        footer = group.getFooter();
        footer.show();

        ScBox buttons;
        buttons = footer.addButtonBox();
        buttons.addSubmitButton("Save");
        buttons.addCancelButton(this::ajaxClose);
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public MyUserProfileFrame getFrame()
    {
        return (MyUserProfileFrame)super.getFrame();
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void preRender()
    {
        refreshFields();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSave()
    {
        ajax().hideAllErrors();
        validate();

        String oldPassword = _oldPasswordField.getValue();
        String newPassword = _newPasswordField.getValue();
        String retypePassword = _retypePasswordField.getValue();

        if ( !getCurrentUser().hasPassword(oldPassword) )
        {
            _oldPasswordField.ajax().focus();
            _oldPasswordField.addError("Invalid.");
            throw newRollback();
        }

        if ( newPassword == null )
        {
            _newPasswordField.ajax().focus();
            _newPasswordField.addError("Required.");
            throw newRollback();
        }

        if ( Kmu.isNotEqual(newPassword, retypePassword) )
        {
            _retypePasswordField.ajax().clearValue();
            _retypePasswordField.ajax().focus();
            _retypePasswordField.addError("Passwords did not match.");
            throw newRollback();
        }

        getCurrentUser().setPassword(newPassword);
        ajax().toast("Password Changed.").success();
        ajaxClose();
    }

    //##################################################
    //# support
    //##################################################

    private void refreshFields()
    {
        MyUser u = getCurrentUser();

        _nameField.setValue(u.getName());
        _nameField.ajax().replace();

        _emailField.setValue(u.getEmail());
        _emailField.ajax().replace();

        _roleField.setValue(u.getRoleName());
        _roleField.ajax().replace();

        _oldPasswordField.clearText();
        _oldPasswordField.ajax().replace();

        _newPasswordField.clearText();
        _newPasswordField.ajax().replace();

        _retypePasswordField.clearText();
        _retypePasswordField.ajax().replace();
    }

}
