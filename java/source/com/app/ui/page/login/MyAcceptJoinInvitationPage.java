package com.app.ui.page.login;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScErrorBox;
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

import com.app.model.MyAccount;
import com.app.model.MyAccountUserRole;
import com.app.model.MyInvitation;
import com.app.model.MyPasswordReset;
import com.app.model.MyUser;
import com.app.ui.page.MyPage;
import com.app.utility.MyUrls;

public class MyAcceptJoinInvitationPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyAcceptJoinInvitationPage instance = new MyAcceptJoinInvitationPage();

    private MyAcceptJoinInvitationPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScLocalString   _accessKey;

    private ScText          _emailText;
    private ScText          _accountText;

    private ScForm          _form;

    private ScPasswordField _password1Field;
    private ScPasswordField _password2Field;

    private ScBox           _messageBox;
    private ScBox           _chooseLabel;
    private ScBox           _reenterLabel;
    private ScBox           _joinedMessageBox;

    private ScErrorBox      _password1ErrorBox;
    private ScErrorBox      _password2ErrorBox;

    //##################################################
    //# setup
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
        group.setTitle("Join Account");
        group.style().width(300).marginTop(100).marginCenter();

        ScContainer body;
        body = group.getBody();

        installForm(body);
        installMessageBox(body);
        installJoinedMessageBox(body);
    }

    private void installForm(ScContainer root)
    {
        _password1Field = new ScPasswordField();
        _password1Field.style().width(270);
        _password1Field.setRequired();
        _password1Field.hide();

        _password2Field = new ScPasswordField();
        _password2Field.style().width(270);
        _password2Field.setRequired();
        _password2Field.hide();

        ScForm form;
        form = root.addForm();
        form.setDefaultAction(newAcceptAction());
        form.css().pad10();
        _form = form;

        form.addLabel("Email");

        ScBox emailBox;
        emailBox = form.addBox();
        emailBox.css().fieldValue();

        _emailText = emailBox.addText();

        form.addSpace();
        form.addLabel("Account");

        ScBox accountBox;
        accountBox = form.addBox();
        accountBox.css().fieldValue();

        _accountText = accountBox.addText();

        _chooseLabel = form.addLabel("Choose a Password");
        _chooseLabel.css().padTop();
        _chooseLabel.hide();

        _password1ErrorBox = form.addErrorBox();
        _password1ErrorBox.add(_password1Field);
        _password1ErrorBox.hide();

        _reenterLabel = form.addLabel("Re-enter Password");
        _reenterLabel.css().padTop();
        _reenterLabel.hide();

        _password2ErrorBox = form.addErrorBox();
        _password2ErrorBox.add(_password2Field);
        _password2ErrorBox.hide();

        ScBox buttons;
        buttons = form.addButtonBoxRight();

        ScSubmitButton button;
        button = buttons.addSubmitButton("Join");
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
            + "Congratulations, you are now part of this account! "
            + "You may now return to the Sign In page and log in.");

        box.addBreaks(2);

        String url = MyUrls.getEntryUrl();

        ScUrlLink link;
        link = box.addUrlLink("Sign In", url);
        link.css().link();
    }

    private void installJoinedMessageBox(ScContainer root)
    {
        ScBox box = root.addBox();
        box.hide();
        box.css().pad10();
        _joinedMessageBox = box;
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
    //# navigation
    //##################################################

    // todo_wyatt: start
    public void push(String accessKey)
    {
        setAccessKey(accessKey);
        push();
    }

    @Override
    public void initUrlFromSession(ScParameterList params)
    {
        params.setValue("accessKey", getAccessKey());
    }

    @Override
    public void initSessionFromUrl(ScParameterList params)
    {
        setAccessKey(params.getValue("accessKey"));
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void preRender()
    {
        super.preRender();

        String key;
        key = getAccessKey();

        if ( Kmu.isEmpty(key) )
            fatal("Access Key Required");

        MyInvitation inv;
        inv = getAccess().getInvitationDao().findAccessKey(key);

        String email;
        email = inv.getEmail();

        MyUser u;
        u = getAccess().getUserDao().findEmail(email);

        MyAccount a;
        a = inv.getAccount();

        if ( a.hasMember(u) )
        {
            displayMemberMessage(email, u, a);
            return;
        }

        if ( u == null )
        {
            promptForPassword(inv, a);
            return;
        }

        displayAcceptInvitation(inv, u, a);
    }

    private void displayMemberMessage(String email, MyUser u, MyAccount a)
    {
        MyPasswordReset r;
        r = new MyPasswordReset();
        r.setUser(u);
        r.saveDao();

        ScStyledText text;
        text = _joinedMessageBox.addStyledText();
        text.style().bold().italic().size(16);
        text.setValue("A request was made to join the email "
            + email
            + " to the account "
            + a.getName()
            + "."
            + "  However, this email is already joined to the account. "
            + "If you are having difficulty accessing your account, you may use "
            + "the link below to reset your password.");

        _joinedMessageBox.addBreaks(2);

        ScUrlLink link;
        link = _joinedMessageBox.addUrlLink("Reset My Password", MyUrls.getPasswordResetUrl(r));
        link.css().link();

        _form.hide();
        _joinedMessageBox.show();
    }

    private void promptForPassword(MyInvitation inv, MyAccount a)
    {
        _password1Field.show();
        _password1ErrorBox.show();

        _password2Field.show();
        _password2ErrorBox.show();

        _chooseLabel.show();
        _reenterLabel.show();

        _emailText.setValue(inv.getEmail());
        _accountText.setValue(a.getName());
    }

    private void displayAcceptInvitation(MyInvitation inv, MyUser u, MyAccount a)
    {
        getPageSession().setUser(u);

        _emailText.setValue(inv.getEmail());
        _accountText.setValue(a.getName());
    }

    //##################################################
    //# handle
    //##################################################

    private void handleAccept()
    {
        ajax().hideAllErrors();
        ajax().focus();

        String key = getAccessKey();

        MyInvitation inv;
        inv = getAccess().getInvitationDao().findAccessKey(key);
        inv.setStatusAccepted();
        inv.setClosedUtcTs(getNowUtc());

        String email;
        email = inv.getEmail();

        MyUser u;
        u = getPageSession().getUser();

        MyAccount a;
        a = inv.getAccount();

        MyAccountUserRole role;
        role = inv.getRole();

        if ( u == null )
        {
            _form.validate();
            u = createUser(email, a, role);
        }
        else
            u.joinAccount(a, role);

        _form.ajax().hide();
        _messageBox.ajax().show().slide();
    }

    private MyUser createUser(String email, MyAccount a, MyAccountUserRole role)
    {
        _password1Field.ajax().clearValue();
        _password2Field.ajax().clearValue();

        String p1 = _password1Field.getValue();
        String p2 = _password2Field.getValue();

        if ( Kmu.isNotEqual(p1, p2) )
            _password2Field.error("Passwords did not match.");

        KmEmailParser p;
        p = new KmEmailParser();
        p.setEmail(email);

        String name;
        name = p.getName();

        MyUser u;
        u = getAccess().getUserDao().createUser(name, email);
        u.setPassword(p1);
        u.joinAccount(a, role);

        return u;
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
