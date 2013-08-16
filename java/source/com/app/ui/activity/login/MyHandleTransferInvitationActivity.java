package com.app.ui.activity.login;

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
import com.kodemore.utility.Kmu;

import com.app.dao.MyAccountUserDao;
import com.app.model.MyAccount;
import com.app.model.MyAccountUser;
import com.app.model.MyInvitation;
import com.app.model.MyUser;
import com.app.ui.activity.MyActivity;
import com.app.utility.MyUrls;

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

    private boolean         _newUser;

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

        _newUser = false;

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
        // remove_steve
        //        form.setDefaultAction(newTestAction());
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

    // remove_steve testing
    private ScActionIF newTestAction()
    {
        return new ScAction(this)
        {
            @Override
            protected void handle()
            {
                // remove_steve: print
                System.out.println("MyHandleTransferInvitationActivity.newTestAction().new ScAction() {...}.handle");
                System.out.print("_(&^$%(@*#&$^(@#*&^#(*&@#^$(*@#&^(%*&^@#($*&^#@$(*&@#^$(*&");
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

        MyInvitation inv;
        inv = getAccess().getInvitationDao().findAccessKey(key);

        String email;
        email = inv.getEmail();

        MyUser u = getAccess().getUserDao().findEmail(email);

        if ( u == null )
        {
            _newUser = true;

            _password1Field.show();
            _password2Field.show();
            _chooseLabel.show();
            _reEnterLabel.show();
            _password1ErrorBox.show();
            _password2ErrorBox.show();
        }

        MyAccount a;
        a = inv.getAccount();

        _emailText.setValue(inv.getEmail());
        _accountText.setValue(a.getName());

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

        /**
         * review_wyatt (steve)
         * the 
         */
        if ( _newUser )
            _form.validate();

        // remove_steve: print
        System.out.println("    XFER ownership!!!:::::::::::::::::::::::::::::: ");

        String key = getAccessKey();

        MyInvitation inv;
        inv = getAccess().getInvitationDao().findAccessKey(key);
        inv.setStatusAccepted();
        inv.setClosedUtcTs(getNowUtc());

        String email;
        email = inv.getEmail();

        MyUser user = getAccess().getUserDao().findEmail(email);

        MyAccount a;
        a = inv.getAccount();

        if ( user == null )
            user = createUser(email, a);

        MyAccountUserDao auDao;
        auDao = getAccess().getAccountUserDao();

        MyAccountUser newOwner;
        newOwner = auDao.findAccountUserFor(user, a);

        // this check is here incase you xfer to someone who is not on the account but does is a user
        if ( newOwner == null )
        {
            newOwner = new MyAccountUser();
            newOwner.setUser(user);
            newOwner.setAccount(a);
            newOwner.saveDao();
        }

        MyAccountUser oldOwner;
        oldOwner = auDao.findCurrentOwner(a);
        // remove_steve
        System.out.println("    ########### newOwner: " + newOwner);
        System.out.println("    ########### oldOwner: " + oldOwner);
        /**
         * (valerie) use of transfer ownership
         * 
         * review_valerie (wyatt) discuss
         */
        auDao.transferOwnership(oldOwner, newOwner);

        _form.ajax().hide();
        _messageBox.ajax().show().slide();
    }

    private MyUser createUser(String email, MyAccount a)
    {
        _password1Field.ajax().clearValue();
        _password2Field.ajax().clearValue();

        String p1 = _password1Field.getValue();
        String p2 = _password2Field.getValue();

        if ( Kmu.isNotEqual(p1, p2) )
            _password1Field.error("Passwords did not match.");

        MyUser u;
        u = getAccess().getUserDao().createNewUserWithAccount(email, p1, a);

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
