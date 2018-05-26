package com.app.ui.page.crud.user;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.field.ScHiddenField;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.Kmu;

import com.app.model.MyUser;
import com.app.ui.control.MyFormDialog;
import com.app.utility.MyGlobals;

public class MySetUserPasswordDialog
    extends MyFormDialog
{
    //##################################################
    //# variables
    //##################################################

    private ScHiddenField<String> _userUidField;
    private ScTextField           _passwordField;

    //##################################################
    //# constructor
    //##################################################

    public MySetUserPasswordDialog()
    {
        install();
    }

    //##################################################
    //# install
    //##################################################

    private void install()
    {
        installForm();
        installBody();
        installFooter();
    }

    private void installForm()
    {
        setLabel("Set Password");
        setFlavorAlert();
        onSubmit(newUncheckedAction(this::handleSave));
    }

    private void installBody()
    {
        ScDiv root;
        root = getBody();
        root.css().pad20();
        root.add(createUserUidField());

        ScFieldTable fields;
        fields = root.addFieldTable();
        fields.add(createPasswordField());
    }

    private void installFooter()
    {
        ScDiv footer;
        footer = showFooter();
        footer.css().buttonBox();
        footer.addSaveButton();
        footer.addCancelButton(newUncheckedAction(this::ajaxClose));
    }

    //==================================================
    //= install :: fields
    //==================================================

    private ScControl createUserUidField()
    {
        ScHiddenField<String> e;
        e = new ScHiddenField<>();
        _userUidField = e;
        return e;
    }

    private ScControl createPasswordField()
    {
        ScTextField e;
        e = new ScTextField();
        e.setLabel("New Password");
        _passwordField = e;
        return e;
    }

    //##################################################
    //# ajax
    //##################################################

    public void ajaxOpen(MyUser user)
    {
        _userUidField.setValue(user.getUid());
        ajaxOpen();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSave()
    {
        checkDeveloper();

        String uid = _userUidField.getValue();
        MyUser user = getAccess().findUserUid(uid);
        if ( user == null )
            throw Kmu.newError("Cannot set password, no user selected.");

        String password = _passwordField.getValue();
        user.setPassword(password);
        getAccess().flush();

        ajaxClose();
        ajaxToast("Password updated.");
    }

    private void checkDeveloper()
    {
        MyUser user = MyGlobals.getCurrentUser();
        if ( !user.allowsSetPassword() )
            throw Kmu.newError("Cannot set password, invalid permissions.");
    }

}
