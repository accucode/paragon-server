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
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScStyledText;
import com.kodemore.servlet.control.ScSubmitButton;
import com.kodemore.servlet.control.ScText;
import com.kodemore.servlet.control.ScUrlLink;
import com.kodemore.servlet.field.ScPasswordField;
import com.kodemore.servlet.variable.ScLocalString;

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

    private String          _submitButtonText;

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
        form.addErrorBox().add(_password1Field);

        _reEnterLabel = form.addLabel("Re-enter Password");
        _reEnterLabel.css().padTop();
        _reEnterLabel.hide();
        form.addErrorBox().add(_password2Field);

        ScBox buttons;
        buttons = form.addButtonBoxRight();

        ScSubmitButton button;
        setSubmitButtonText("Accept Ownership");
        button = buttons.addSubmitButton(_submitButtonText);
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

        MyUser user;
        user = i.getUser();

        MyAccount account;
        account = i.getAccount();

        _emailText.setValue(user.getEmail());
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

        MyUser user;
        user = i.getUser();

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

        /**
         * review_wyatt (valerie) use of transfer ownership
         */
        accountUserDao.transferOwnership(oldOwner, newOwner);

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

    //##################################################
    //# convenience
    //##################################################

    // fixme_valerie: remove warning
    @SuppressWarnings("unused")
    private String getSubmitButtonText()
    {
        return _submitButtonText;
    }

    private void setSubmitButtonText(String submitButtonText)
    {
        _submitButtonText = submitButtonText;
    }

}
