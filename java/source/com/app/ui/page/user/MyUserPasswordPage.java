package com.app.ui.page.user;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScArray;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScPasswordField;
import com.kodemore.utility.Kmu;

import com.app.model.MyUser;
import com.app.ui.page.MySubPage;

public class MyUserPasswordPage
    extends MySubPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyUserPasswordPage instance = new MyUserPasswordPage();

    private MyUserPasswordPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScPasswordField _oldPasswordField;
    private ScPasswordField _newPasswordField;
    private ScPasswordField _confirmPasswordField;

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        ScArray arr;
        arr = root.addArray();

        installPasswordGroup(arr);
    }

    private void installPasswordGroup(ScContainer root)
    {
        _oldPasswordField = new ScPasswordField();
        _oldPasswordField.setLabel("Old Password");

        _newPasswordField = new ScPasswordField();
        _newPasswordField.setLabel("New Password");

        _confirmPasswordField = new ScPasswordField();
        _confirmPasswordField.setLabel("Confirm");

        ScForm form;
        form = root.addForm();
        form.setDefaultAction(newSaveAction());

        ScGroup group;
        group = form.addGroup("Change Password");

        ScFieldTable fields;
        fields = group.addFields();
        fields.add(_oldPasswordField);
        fields.addSpace();
        fields.add(_newPasswordField);
        fields.add(_confirmPasswordField);

        group.addDivider();
        group.addButtonBox().addSubmitButton("Save");
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newSaveAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleSave();
            }
        };
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSave()
    {
        MyUser user = getCurrentUser();

        String old = _oldPasswordField.getValue();
        if ( !user.hasPassword(old) )
        {
            resetPasswordFields();
            _oldPasswordField.error("Incorrect password");
        }

        Integer min = getProperties().getMinimumPasswordLength();

        String a = _newPasswordField.getValue();

        if ( min > 0 )
        {
            if ( a == null )
            {
                resetPasswordFields();
                _newPasswordField.error("Minimum length is %s.", min);
            }

            if ( a.length() < min )
            {
                resetPasswordFields();
                _newPasswordField.error("Minimum length is %s.", min);
            }
        }

        String b = _confirmPasswordField.getValue();
        if ( Kmu.isDifferent(a, b) )
        {
            resetPasswordFields();
            _newPasswordField.error("Password did not match.");
        }

        user.setPassword(a);

        resetPasswordFields();
        Object[] args = {};
        ajax().toast("Password Changed.", args);
    }

    //##################################################
    //# support
    //##################################################

    private void resetPasswordFields()
    {
        _oldPasswordField.resetValue();
        _newPasswordField.resetValue();
        _confirmPasswordField.resetValue();
    }

}
