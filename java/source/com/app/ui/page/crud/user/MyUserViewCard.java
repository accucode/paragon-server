package com.app.ui.page.crud.user;

import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScDomainNotebook;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldText;
import com.kodemore.servlet.control.layout.ScLayout;
import com.kodemore.utility.Kmu;

import com.app.model.MyUser;
import com.app.model.meta.MyMetaUser;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;
import com.app.ui.page.login.MyProxyBookmark;
import com.app.ui.page.login.MyProxyPage;
import com.app.utility.MyGlobals;

public class MyUserViewCard
    extends MyCrudViewCard<MyUser>
{
    //##################################################
    //# variables
    //##################################################

    private ScActionButton          _clearPasswordButton;
    private ScActionButton          _setPasswordButton;
    private ScActionButton          _proxyButton;
    private MySetUserPasswordDialog _passwordDialog;

    //##################################################
    //# constructor
    //##################################################

    public MyUserViewCard()
    {
        super(new MyUserBuilder());
    }

    public MyUserViewCard(MyUserBuilder e)
    {
        super(e);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installBodyOn(ScDiv body)
    {
        detachBody();
        body.add(createNotebook());

        _passwordDialog = new MySetUserPasswordDialog();
    }

    private ScControl createNotebook()
    {
        ScDomainNotebook<MyUser> e;
        e = new ScDomainNotebook<>();
        e.setFinder(MyUser.Finder);
        e.css().fill();
        e.add(createDetailTab());
        return e;
    }

    private ScControl createDetailTab()
    {
        ScLayout e;
        e = new ScLayout();
        e.setTypeFieldset();
        e.css().fill().auto();
        e.add(createNameSection());
        e.add(createContactSection());
        e.add(createRoleSection());
        e.add(createMemoSection());
        return e.inNotebookTab("User", "Details");
    }

    //==================================================
    //= install :: name
    //==================================================

    protected ScControl createNameSection()
    {
        ScDiv e;
        e = new ScDiv();
        e.setLabel("Name");
        e.css().flexRow().flexAlignSpaced();
        e.add(createNameLeft());
        e.add(createNameRight());
        return e;
    }

    private ScFieldTable createNameLeft()
    {
        MyMetaUser x = MyUser.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.addFieldText(x.LongName);
        return e;
    }

    private ScDiv createNameRight()
    {
        ScDiv e;
        e = new ScDiv();
        e.css().buttonBox5();
        e.add(createClearPasswordButton());
        e.add(createSetPasswordButton());
        e.add(createProxyButton());
        return e;
    }

    private ScControl createClearPasswordButton()
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setText("Clear Password");
        e.setAction(newCheckedAction(this::handleClearPassword));
        e.setConfirmationMessageText("Clear this user's password?");
        e.hide();
        _clearPasswordButton = e;
        return e;
    }

    private ScControl createSetPasswordButton()
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setText("Set Password");
        e.setAction(newCheckedAction(this::handleSetPassword));
        e.hide();
        _setPasswordButton = e;
        return e;
    }

    private ScControl createProxyButton()
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setText("Proxy");
        e.setAction(newCheckedAction(this::handleProxy));
        e.setConfirmationMessageText("Log in as this user?");
        e.hide();
        _proxyButton = e;
        return e;
    }

    //==================================================
    //= install :: contact
    //==================================================

    private ScControl createContactSection()
    {
        MyMetaUser x = MyUser.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("Contact");
        e.addFieldText(x.Email);
        e.addFieldText(x.Phone);
        return e;
    }

    //==================================================
    //= install :: role
    //==================================================

    private ScControl createRoleSection()
    {
        MyMetaUser x = MyUser.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("Role");
        e.addFieldText(x.RoleName);
        e.add(createEnabledRow());
        return e;
    }

    private ScControl createEnabledRow()
    {
        MyMetaUser x = MyUser.Meta;

        ScDiv row;
        row = new ScDiv();
        row.css().flexRow().rowSpacer5().flexCrossAlignCenter();
        row.setLabel("Enabled");
        row.addFieldText(x.EnabledStatus);
        row.addLink("toggle", newCheckedAction(this::handleToggleEnabled));
        return row;
    }

    //==================================================
    //= install :: memo
    //==================================================

    private ScControl createMemoSection()
    {
        MyMetaUser x = MyUser.Meta;

        ScFieldText e;
        e = x.Memo.newFieldText();
        e.setEmptyTextNone();
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRenderDetails(MyUser user)
    {
        super.preRenderDetails(user);

        preRenderProxyButton();
    }

    private void preRenderProxyButton()
    {
        if ( allowsClearPassword() )
            _clearPasswordButton.show();

        if ( allowsSetPassword() )
            _setPasswordButton.show();

        if ( allowsProxy() )
            _proxyButton.show();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleToggleEnabled()
    {
        MyUser e;
        e = getDomainChild();
        e.toggleEnabled();
        e.validateAndCheck();

        ajaxReplace();
        fireChildChanged();
    }

    private void handleClearPassword()
    {
        if ( !allowsClearPassword() )
        {
            ajaxToast("Clear password not allowed.");
            return;
        }

        MyUser user;
        user = getDomainChild();
        user.clearPasswordHash();

        ajaxToast("Password cleared.");
    }

    private void handleSetPassword()
    {
        if ( !allowsSetPassword() )
            throw Kmu.newError("Set password not allowed.");

        MyUser user = getDomainChild();
        _passwordDialog.ajaxOpen(user);
    }

    private void handleProxy()
    {
        if ( !allowsProxy() )
        {
            ajaxToast("Proxy not allowed.");
            return;
        }

        MyUser user = getDomainChild();

        MyProxyBookmark b;
        b = MyProxyPage.getInstance().newBookmark();
        b.setAutoLoginFor(user);

        getRootScript().openWindowUrl(b);
    }

    //##################################################
    //# support
    //##################################################

    private boolean allowsClearPassword()
    {
        return MyGlobals.getCurrentUser().allowsClearPassword();
    }

    private boolean allowsSetPassword()
    {
        return MyGlobals.getCurrentUser().allowsSetPassword();
    }

    private boolean allowsProxy()
    {
        return MyGlobals.getCurrentUser().allowsProxy();
    }
}
