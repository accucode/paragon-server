package com.app.ui.page.manage.user;

import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;

import com.app.model.MyUser;
import com.app.model.meta.MyMetaUser;
import com.app.ui.page.login.MyProxyPage;
import com.app.ui.page.manage.crud.MyCrudLayout;
import com.app.ui.page.manage.crud.MyCrudViewCard;
import com.app.utility.MyGlobals;

public class MyUserViewCard
    extends MyCrudViewCard<MyUser>
{
    //##################################################
    //# variables
    //##################################################

    private ScActionButton _clearPasswordButton;
    private ScActionButton _proxyButton;

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
    protected MyCrudLayout getDetailLayout()
    {
        return MyCrudLayout.scroll;
    }

    @Override
    protected void installDetailsOn(ScDiv root)
    {
        root.css().columnSpacer20();

        installNameOn(root);
        installContactOn(root);
        installRoleOn(root);
    }

    protected void installNameOn(ScDiv root)
    {
        MyMetaUser x = MyUser.Meta;

        ScFieldset set;
        set = root.addFieldset("Name");

        ScDiv row;
        row = set.addFlexRow();
        row.css().flexAlignSpaced();

        ScFieldTable fields;
        fields = row.addFieldTable();
        fields.disableFullWidth();
        fields.addFieldText(x.LongName);

        ScDiv buttons;
        buttons = row.addButtonBox5();
        installClearPasswordButtonOn(buttons);
        installProxyButtonOn(buttons);
    }

    private void installClearPasswordButtonOn(ScDiv row)
    {
        ScActionButton e;
        e = row.addButton("Clear Password", this::handleClearPassword);
        e.setConfirmationMessageText("Clear this user's password?");
        e.hide();
        _clearPasswordButton = e;
    }

    private void installProxyButtonOn(ScDiv row)
    {
        ScActionButton e;
        e = row.addButton("Proxy", this::handleProxy);
        e.setConfirmationMessageText("Log in as this user?");
        e.hide();
        _proxyButton = e;
    }

    protected void installContactOn(ScDiv root)
    {
        MyMetaUser x = MyUser.Meta;

        ScFieldset set;
        set = root.addFieldset("Contact");

        ScFieldTable fields;
        fields = set.addFieldTable();
        fields.addFieldText(x.Email);
        fields.addFieldText(x.Phone);
    }

    private void installRoleOn(ScDiv root)
    {
        MyMetaUser x = MyUser.Meta;

        ScFieldset set;
        set = root.addFieldset("Role");

        ScFieldTable fields;
        fields = set.addFieldTable();
        fields.addFieldText(x.RoleName);
        fields.addFieldText(x.Active);
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

        if ( allowsProxy() )
            _proxyButton.show();
    }

    //##################################################
    //# handle
    //##################################################

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

    private void handleProxy()
    {
        if ( !allowsProxy() )
        {
            ajaxToast("Proxy not allowed.");
            return;
        }

        MyUser user = getDomainChild();
        String url = MyProxyPage.getInstance().formatEntryUrl(user);

        getRootScript().openWindowUrl(url);
    }

    //##################################################
    //# support
    //##################################################

    private boolean allowsClearPassword()
    {
        return MyGlobals.getCurrentUser().allowsClearPassword();
    }

    private boolean allowsProxy()
    {
        return MyGlobals.getCurrentUser().allowsProxy();
    }

}
