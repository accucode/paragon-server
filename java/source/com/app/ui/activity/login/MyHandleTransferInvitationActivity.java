package com.app.ui.activity.login;

import com.app.dao.MyAccountUserDao;
import com.app.model.MyAccount;
import com.app.model.MyAccountUser;
import com.app.model.MyInvitation;
import com.app.model.MyUser;
import com.app.ui.activity.MyActivity;
import com.app.utility.MyUrls;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScErrorBox;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScStyledText;
import com.kodemore.servlet.control.ScSubmitButton;
import com.kodemore.servlet.control.ScText;
import com.kodemore.servlet.control.ScUrlLink;
import com.kodemore.servlet.field.ScPasswordField;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.KmEmailParser;
import com.kodemore.utility.Kmu;

public class MyHandleTransferInvitationActivity
    extends MyActivity
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyHandleTransferInvitationActivity instance = new MyHandleTransferInvitationActivity();

    private MyHandleTransferInvitationActivity()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScLocalString   _accessKey;

    private ScContainer     _root;

    private ScText          _emailText;
    private ScText          _accountText;

    private ScForm          _form;

    private ScPasswordField _password1Field;
    private ScPasswordField _password2Field;

    private ScBox           _messageBox;
    private ScBox           _chooseLabel;
    private ScBox           _reEnterLabel;

    private ScErrorBox      _password1ErrorBox;
    private ScErrorBox      _password2ErrorBox;

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

        ScGroup group;
        group = new ScGroup();

        group.setTitle("Transfer Account");
        group.style().width(300).marginTop(100).marginCenter();

        ScContainer body = group.getBody();

        installForm(body);
        installMessageBox(body);

        _root = group;
    }

    private void installForm(ScContainer root)
    {
        _password1Field = new ScPasswordField();
        _password1Field.style().width(270);
        _password1Field.setRequired();
        _password1Field.hide();

        _password2Field = new ScPasswordField();
        _password2Field.style().width(270);
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

        _reEnterLabel = form.addLabel("Re-enter Password");
        _reEnterLabel.css().padTop();
        _reEnterLabel.hide();

        _password2ErrorBox = form.addErrorBox();
        _password2ErrorBox.add(_password2Field);
        _password2ErrorBox.hide();

        ScBox buttons;
        buttons = form.addButtonBoxRight();

        ScSubmitButton button;
        button = buttons.addSubmitButton("Accept Ownership");
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
            + "Congratulations, you are now the owner! "
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

        MyInvitation i;
        i = getAccess().getInvitationDao().findAccessKey(key);

        String email;
        email = i.getEmail();

        MyUser user = getAccess().getUserDao().findEmail(email);

        if ( user == null )
        {
            _password1Field.show();
            _password2Field.show();
            _chooseLabel.show();
            _reEnterLabel.show();
            _password1ErrorBox.show();
            _password2ErrorBox.show();
        }

        MyAccount account;
        account = i.getAccount();

        _emailText.setValue(i.getEmail());
        _accountText.setValue(account.getName());

        ajax().printMain(_root);
        ajax().focus();
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

        MyInvitation i;
        i = getAccess().getInvitationDao().findAccessKey(key);
        i.setStatusAccepted();
        i.setClosedUtcTs(getNowUtc());

        String email;
        email = i.getEmail();

        MyUser user = getAccess().getUserDao().findEmail(email);

        if ( user == null )
            user = createUser(email);

        MyAccount account;
        account = i.getAccount();

        MyAccountUserDao accountUserDao;
        accountUserDao = getAccess().getAccountUserDao();

        MyAccountUser newOwner;
        newOwner = accountUserDao.findAccountUserFor(user, account);

        if ( newOwner == null )
        {
            newOwner = new MyAccountUser();
            newOwner.setUser(user);
            newOwner.setAccount(account);
        }

        newOwner.saveDao();

        MyAccountUser oldOwner;
        oldOwner = accountUserDao.findCurrentOwner(account);
        //remove_valerie: println
        System.out.println("    oldOwner: " + oldOwner);
        /**
         * review_wyatt (valerie) use of transfer ownership
         */
        accountUserDao.transferOwnership(oldOwner, newOwner);

        _form.ajax().hide();
        _messageBox.ajax().show().slide();
    }

    private MyUser createUser(String email)
    {
        _password1Field.ajax().clearValue();
        _password2Field.ajax().clearValue();

        String p1 = _password1Field.getValue();
        String p2 = _password2Field.getValue();

        if ( Kmu.isNotEqual(p1, p2) )
            _password1Field.error("Passwords did not match.");

        KmEmailParser p;
        p = new KmEmailParser();
        p.setEmail(email);

        String name;
        name = p.getName();

        MyUser u;
        u = new MyUser();
        u.setName(name);
        u.setEmail(email);
        u.setPassword(p1);
        u.setVerified(true);
        u.saveDao();

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
