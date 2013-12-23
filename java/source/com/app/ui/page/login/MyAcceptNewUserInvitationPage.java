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
import com.kodemore.servlet.control.ScText;
import com.kodemore.servlet.control.ScUrlLink;
import com.kodemore.servlet.field.ScPasswordField;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.KmEmailParser;
import com.kodemore.utility.Kmu;

import com.app.model.MyInvitation;
import com.app.model.MyPasswordReset;
import com.app.model.MyUser;
import com.app.ui.page.MyPage;
import com.app.utility.MyUrls;

public class MyAcceptNewUserInvitationPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyAcceptNewUserInvitationPage instance = new MyAcceptNewUserInvitationPage();

    private MyAcceptNewUserInvitationPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScLocalString   _accessKey;

    private ScText          _emailText;

    private ScForm          _form;
    private ScPasswordField _password1Field;
    private ScPasswordField _password2Field;

    private ScBox           _messageBox;
    private ScBox           _registeredMessageBox;
    private ScBox           _box;

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

        group.setTitle("Activate User");
        group.style().width(300).marginTop(100).marginCenter();

        ScContainer body = group.getBody();

        installForm(body);
        installMessageBox(body);
        installRegisteredMessageBox(body);
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
        _form = form;

        form.addLabel("Email");

        ScBox box;
        box = form.addBox();
        box.css().fieldValue();

        _emailText = box.addText();

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
        button = buttons.addSubmitButton("Activate User");
        button.style().marginTop(10);
    }

    private void installMessageBox(ScContainer root)
    {
        ScBox box;
        box = root.addBox();
        box.hide();
        box.css().pad10();
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

    private void installRegisteredMessageBox(ScContainer root)
    {
        _box = root.addBox();
        _box.hide();
        _box.css().pad10();
        _registeredMessageBox = _box;

        ScStyledText text;
        text = _box.addStyledText();
        text.style().bold().italic().size(16);
        text.setValue("A request was made to create a new user for this email."
            + "  However, this email is already registered with our system. "
            + "If you did not initiate this request, please ignore this message.  "
            + "If you are having difficulty accessing your account, you may use "
            + "the link below to reset your password.");

        _box.addBreaks(2);
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

    // todo_wyatt: start
    public void start(String accessKey)
    {
        setAccessKey(accessKey);
        start();
    }

    @Override
    public void applyParametersToUrl(ScParameterList params)
    {
        // none
    }

    @Override
    public void applyParametersFromUrl(ScParameterList params)
    {
        // none
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        String key;
        key = getAccessKey();

        if ( Kmu.isEmpty(key) )
            fatal("Access Key is Required");

        MyInvitation inv;
        inv = getAccess().getInvitationDao().findAccessKey(key);

        _emailText.setValue(inv.getEmail());

        String email;
        email = inv.getEmail();

        MyUser u;
        u = getAccess().getUserDao().findEmail(email);

        if ( u != null )
        {
            MyPasswordReset r;
            r = new MyPasswordReset();
            r.setUser(u);
            r.saveDao();

            ScUrlLink link;
            link = _box.addUrlLink("Reset My Password", MyUrls.getPasswordResetUrl(r));
            link.css().link();

            _form.hide();
            _registeredMessageBox.show();
        }
    }

    //##################################################
    //# handle
    //##################################################

    private void handleAccept()
    {
        ajax().hideAllErrors();
        ajax().focus();

        _form.validate();

        String key = getAccessKey();

        MyInvitation inv;
        inv = getAccess().getInvitationDao().findAccessKey(key);
        inv.setStatusAccepted();
        inv.setClosedUtcTs(getNowUtc());

        String email;
        email = inv.getEmail();

        createUser(email);

        _form.ajax().hide();
        _messageBox.ajax().show().slide();
    }

    private void createUser(String email)
    {
        _password1Field.ajax().clearValue();
        _password2Field.ajax().clearValue();

        String pw1 = _password1Field.getValue();
        String pw2 = _password2Field.getValue();

        if ( Kmu.isNotEqual(pw1, pw2) )
            _password1Field.error("Passwords did not match.");

        KmEmailParser p;
        p = new KmEmailParser();
        p.setEmail(email);

        String name;
        name = p.getName();

        MyUser u;
        u = getAccess().getUserDao().createUser(name, email);
        u.setPassword(pw1);
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
