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
import com.kodemore.servlet.variable.ScLocalString;

import com.app.model.MyAccount;
import com.app.model.MyInvitation;
import com.app.model.MyPasswordReset;
import com.app.model.MyUser;
import com.app.ui.page.MyPage;
import com.app.utility.MyUrls;

public class MyAcceptTransferInvitationPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyAcceptTransferInvitationPage instance = new MyAcceptTransferInvitationPage();

    private MyAcceptTransferInvitationPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScLocalString _token;

    private ScText        _emailText;
    private ScText        _accountText;

    private ScForm        _form;

    private ScBox         _messageBox;
    private ScBox         _ownerMessageBox;

    //##################################################
    //# setup
    //##################################################

    @Override
    public boolean requiresUser()
    {
        return false;
    }

    @Override
    protected boolean showsLeftMenu()
    {
        return false;
    }

    //##################################################
    //# navigation
    //##################################################

    public void push(MyInvitation e)
    {
        setToken(e.getToken());

        _push();
    }

    public String formatEntryUrl(MyInvitation e)
    {
        setToken(e.getToken());

        return _formatEntryUrl();
    }

    @Override
    public ScParameterList composeQueryParameters()
    {
        ScParameterList v;
        v = new ScParameterList();
        v.setValue("accessKey", getToken());
        return v;
    }

    @Override
    public void applyQueryParameters(ScParameterList v)
    {
        setToken(v.getValue("accessKey"));
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        _token = new ScLocalString();
        _token.setAutoSave();

        ScGroup group;
        group = root.addGroup();

        group.setTitle("Transfer Account");
        group.style().width(300).marginTop(100).marginCenter();

        ScContainer body = group.getBody();

        installForm(body);
        installMessageBox(body);
        installOwnerMessageBox(body);
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

    private void installOwnerMessageBox(ScContainer root)
    {
        ScBox box;
        box = root.addBox();
        box.hide();
        box.css().pad10();
        _ownerMessageBox = box;
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
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        MyInvitation inv;
        inv = getAccess().getInvitationDao().findToken(getToken());

        String email;
        email = inv.getEmail();

        MyUser u;
        u = getAccess().getUserDao().findEmail(email);

        MyAccount a;
        a = inv.getAccount();

        if ( a.hasOwner(u) )
        {
            displayOwnedMessage(email, u, a);
            return;
        }

        if ( u == null )
        {
            displayNewUserMessage(email, a);
            return;
        }

        displayAcceptInvitation(inv, u, a);
    }

    private void displayOwnedMessage(String email, MyUser u, MyAccount a)
    {
        MyPasswordReset r;
        r = new MyPasswordReset();
        r.setUser(u);
        r.saveDao();

        ScStyledText text;
        text = _ownerMessageBox.addStyledText();
        text.style().bold().italic().size(16);
        text.setValue("A request was made for "
            + email
            + " to take ownership of the account "
            + a.getName()
            + "."
            + "  However, this email already owns the account. "
            + "If you are having difficulty accessing your account, you may use "
            + "the link below to reset your password.");

        _ownerMessageBox.addBreaks(2);

        ScUrlLink link;
        link = _ownerMessageBox.addUrlLink("Reset My Password", MyUrls.getPasswordResetUrl(r));
        link.css().link();

        _form.hide();
        _ownerMessageBox.show();
    }

    private void displayNewUserMessage(String email, MyAccount a)
    {
        ScStyledText text;
        text = _ownerMessageBox.addStyledText();
        text.style().bold().italic().size(16);
        text.setValue("A request was made for "
            + email
            + " to take ownership of the account "
            + a.getName()
            + "."
            + "  However, this email is not a part of the account. "
            + "To join an account someone on the account must send you an "
            + "invitation. In the meantime, you can create an account by"
            + "clicking the link below to go to the Sign In page.");

        _ownerMessageBox.addBreaks(2);

        String url = MyUrls.getEntryUrl();

        ScUrlLink link;
        link = _ownerMessageBox.addUrlLink("Sign In", url);
        link.css().link();

        _form.hide();
        _ownerMessageBox.show();
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

        MyInvitation inv;
        inv = getAccess().getInvitationDao().findToken(getToken());
        inv.setStatusAccepted();
        inv.setClosedUtcTs(getNowUtc());

        MyAccount a;
        a = inv.getAccount();
        a.transferOwnerTo(getPageSession().getUser());

        _form.ajax().hide();
        _messageBox.ajax().show().slide();
    }

    //##################################################
    //# access key
    //##################################################

    private String getToken()
    {
        return _token.getValue();
    }

    private void setToken(String e)
    {
        _token.setValue(e);
    }
}
