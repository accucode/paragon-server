package com.app.ui.activity.login;

import com.app.model.MyAccount;
import com.app.model.MyAccountUser;
import com.app.model.MyAccountUserRole;
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

    private ScLocalString _accessKey;

    private ScContainer   _root;

    private ScText        _emailText;
    private ScText        _accountText;

    private ScForm        _form;

    private ScBox         _messageBox;

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

        MyAccountUser accountUser;
        accountUser = getAccess().getAccountUserDao().findAccountUserFor(user, account);

        if ( accountUser == null )
        {
            accountUser = new MyAccountUser();
            accountUser.setUser(user);
            accountUser.setAccount(account);
        }

        accountUser.setRole(MyAccountUserRole.Owner);
        accountUser.saveDao();

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
