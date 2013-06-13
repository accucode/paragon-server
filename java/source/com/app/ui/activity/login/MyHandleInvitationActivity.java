package com.app.ui.activity.login;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScStyledText;
import com.kodemore.servlet.control.ScSubmitButton;
import com.kodemore.servlet.control.ScText;
import com.kodemore.servlet.control.ScUrlLink;
import com.kodemore.servlet.field.ScPasswordField;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.Kmu;

import com.app.model.MyInvitation;
import com.app.model.MyUser;
import com.app.ui.activity.MyActivity;
import com.app.utility.MyUrls;

public class MyHandleInvitationActivity
    extends MyActivity
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyHandleInvitationActivity instance = new MyHandleInvitationActivity();

    private MyHandleInvitationActivity()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScLocalString   _accessKey;

    private ScContainer     _root;

    private ScText          _emailText;

    private ScForm          _form;
    private ScPasswordField _password1Field;
    private ScPasswordField _password2Field;

    private ScBox           _messageBox;

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
    protected void install()
    {
        _accessKey = new ScLocalString();
        _accessKey.setAutoSave();

        ScGroup root;
        root = new ScGroup();
        root.setTitle("Activate User");

        ScContainer body = root.getBody();
        installForm(body);
        installMessageBox(body);

        _root = root;
    }

    private void installForm(ScContainer root)
    {
        _password1Field = new ScPasswordField();
        _password1Field.style().widthFull();
        _password1Field.setRequired();

        _password2Field = new ScPasswordField();
        _password2Field.style().widthFull();

        ScForm form;
        form = root.addForm();
        form.setDefaultAction(newAcceptAction());
        _form = form;

        form.addLabel("Email");

        ScBox box;
        box = form.addBox();
        box.css().fieldValue();

        _emailText = box.addText();

        form.addLabel("Choose a Password");
        form.addErrorBox().add(_password1Field);

        form.addLabel("Re-enter Password");
        form.addErrorBox().add(_password2Field);

        ScBox buttons;
        buttons = form.addButtonBoxRight();

        ScSubmitButton button;
        button = buttons.addSubmitButton("Activate User");
        button.style().marginTop(10);
    }

    private void installMessageBox(ScContainer root)
    {
        ScBox box;
        box = root.addBox();
        box.hide();
        _messageBox = box;

        ScStyledText text;
        text = box.addStyledText();
        text.style().bold().italic().size(16);
        text.setValue(""
            + "Congratulations! "
            + "You may now return to the Sign In page and log in.");

        box.addBreaks(2);

        String url = MyUrls.getEntryUrl();

        ScUrlLink link;
        link = box.addUrlLink("Sign In", url);
        link.css().link();
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

    public void start(String accessKey)
    {
        setAccessKey(accessKey);
        _start();
    }

    @Override
    public void start()
    {
        fatal("Access Key Required");
    }

    private void _start()
    {
        String key;
        key = getAccessKey();

        MyInvitation a;
        a = getAccess().getInvitationDao().findAccessKey(key);

        MyUser u;
        u = a.getUser();

        _emailText.setValue(u.getEmail());

        ajax().printMain(_root);
        ajax().focus();
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

        MyInvitation i;
        i = getAccess().getInvitationDao().findAccessKey(key);
        i.setStatusAccepted();
        i.setClosedUtcTs(getNowUtc());

        MyUser u;
        u = i.getUser();
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
