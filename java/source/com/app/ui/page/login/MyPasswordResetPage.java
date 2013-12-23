package com.app.ui.page.login;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScStyledText;
import com.kodemore.servlet.control.ScSubmitButton;
import com.kodemore.servlet.field.ScPasswordField;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.Kmu;

import com.app.model.MyPasswordReset;
import com.app.model.MyUser;
import com.app.ui.page.MyPage;
import com.app.utility.MyUrls;

public class MyPasswordResetPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyPasswordResetPage instance = new MyPasswordResetPage();

    private MyPasswordResetPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScLocalString   _accessKey;

    private ScBox           _emailBox;

    private ScForm          _form;
    private ScPasswordField _password1Field;
    private ScPasswordField _password2Field;

    private ScBox           _messageBox;
    private ScBox           _invalidKeyBox;

    //##################################################
    //# start
    //##################################################

    @Override
    public void applyParametersToUrl(ScParameterList v)
    {
        // none
    }

    @Override
    public void applyParametersFromUrl(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    public boolean requiresUser()
    {
        return false;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        _accessKey = new ScLocalString();
        _accessKey.setAutoSave();

        ScGroup group;
        group = root.addGroup();
        group.setTitle("Reset Password");
        group.style().width(300).marginTop(100).marginCenter();

        ScContainer body = group.getBody();

        installForm(body);
        installSuccessBox(body);
        installInvalidKeyBox(body);
    }

    private void installForm(ScContainer root)
    {
        _password1Field = new ScPasswordField();
        _password1Field.style().width(270);
        _password1Field.setRequired();

        _password2Field = new ScPasswordField();
        _password2Field.style().width(270);

        ScForm form;
        form = root.addForm();
        form.setDefaultAction(newAcceptAction());
        form.css().pad10();
        form.hide();
        _form = form;

        form.addLabel("Email");

        _emailBox = form.addBox();
        _emailBox.css().fieldValue();

        ScBox chooseLabel;
        chooseLabel = form.addLabel("Choose a Password");
        chooseLabel.css().padTop();
        form.addErrorBox().add(_password1Field);

        ScBox reEnterLabel;
        reEnterLabel = form.addLabel("Re-enter Password");
        reEnterLabel.css().padTop();
        form.addErrorBox().add(_password2Field);

        ScBox buttons;
        buttons = form.addButtonBoxRight();

        ScSubmitButton button;
        button = buttons.addSubmitButton("Save Password");
        button.style().marginTop(10);
    }

    private void installSuccessBox(ScContainer root)
    {
        ScBox box;
        box = root.addBox();
        box.hide();
        box.css().pad();
        _messageBox = box;

        ScStyledText text;
        text = box.addStyledText();
        text.style().bold().italic().size(16);
        text.setValue("" + "Congratulations! " + "Your password has been reset.");

        box.addBreaks(2);

        box.addUrlLink("Sign In", MyUrls.getEntryUrl());
    }

    private void installInvalidKeyBox(ScContainer root)
    {
        ScBox box;
        box = root.addBox();
        box.hide();
        box.css().pad();
        _invalidKeyBox = box;

        ScStyledText text;
        text = box.addStyledText();
        text.style().bold().italic().size(16);
        text.setValue(""
            + "This request is invalid or expired. If you still need "
            + "to reset your password, please return to the Sign In page and "
            + "request a new password reset.");

        box.addBreaks(2);
        box.addUrlLink("Sign In", MyUrls.getEntryUrl());
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newAcceptAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                handleAccept();
            }
        };
    }

    //##################################################
    //# start
    //##################################################

    public void start(String key)
    {
        setAccessKey(key);
        start();
    }

    @Override
    protected void preRender()
    {
        super.preRender();

        String key;
        key = getAccessKey();

        MyPasswordReset e;
        e = getAccess().getPasswordResetDao().findAccessKey(key);

        if ( e == null || e.isNotStatusNew() )
        {
            _invalidKeyBox.show();
            return;
        }

        _emailBox.ajaxSetText(e.getUser().getEmail());
    }

    //##################################################
    //# handle
    //##################################################

    private void handleAccept()
    {
        _password1Field.ajax().clearValue();
        _password2Field.ajax().clearValue();

        ajax().hideAllErrors();
        ajax().focus();

        _form.validate();

        String p1 = _password1Field.getValue();
        String p2 = _password2Field.getValue();

        if ( Kmu.isNotEqual(p1, p2) )
            _password1Field.error("Passwords did not match.");

        String key = getAccessKey();

        MyPasswordReset e;
        e = getAccess().getPasswordResetDao().findAccessKey(key);
        e.setStatusAccepted();
        e.setClosedUtcTs(getNowUtc());

        MyUser u;
        u = e.getUser();
        u.setPassword(p1);
        u.setVerified(true);

        _form.ajax().hide();
        _messageBox.ajax().show().slide();
    }

    //##################################################
    //# access key
    //##################################################

    private String getAccessKey()
    {
        return _accessKey.getValue();
    }

    private void setAccessKey(String e)
    {
        _accessKey.setValue(e);
    }

}
