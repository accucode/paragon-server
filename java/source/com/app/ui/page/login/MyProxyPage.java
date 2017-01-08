package com.app.ui.page.login;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScHiddenField;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.KmResult;
import com.kodemore.utility.Kmu;

import com.app.model.MyAutoLogin;
import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.model.meta.MyMetaAutoLogin;
import com.app.ui.layout.MyPageLayoutType;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;
import com.app.utility.MyUrls;

public final class MyProxyPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyProxyPage _instance;

    public static void installInstance()
    {
        _instance = new MyProxyPage();
    }

    public static MyProxyPage getInstance()
    {
        return _instance;
    }

    private MyProxyPage()
    {
        // singleton
    }

    //##################################################
    //# constants
    //##################################################

    private static final String   PARAM_AUTO_LOGIN_UID = "uid";

    //##################################################
    //# variables
    //##################################################

    private ScLocalString         _autoLoginUid;

    private ScForm                _proxyForm;
    private ScHiddenField<String> _autoLoginUidField;

    private ScGroup               _errorGroup;

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.none;
    }

    @Override
    public MyPageLayoutType getLayoutType()
    {
        return MyPageLayoutType.basic;
    }

    //##################################################
    //# bookmark
    //##################################################

    public final String formatEntryUrl(MyUser user)
    {
        MyAutoLogin e;
        e = new MyAutoLogin();
        e.setUser(user);
        e.daoAttach();

        _autoLoginUid.setValue(e.getUid());

        MyTenant tenant = user.getTenant();
        ScParameterList params = composeBookmark(true);

        return MyUrls.getEntryUrl(tenant, params);
    }

    @Override
    public void composeBookmarkOn(ScParameterList v)
    {
        if ( _autoLoginUid.hasValue() )
            v.setValue(PARAM_AUTO_LOGIN_UID, _autoLoginUid.getValue());
    }

    @Override
    public void applyBookmark(ScParameterList params)
    {
        String query = params.getValue(PARAM_AUTO_LOGIN_UID);
        if ( Kmu.hasValue(query) )
            _autoLoginUid.setValue(query);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        _autoLoginUid = new ScLocalString();

        root.css().pad20();

        installProxyFormOn(root);
        installErrorGroupOn(root);
    }

    private void installProxyFormOn(ScContainer root)
    {
        MyMetaAutoLogin x = MyAutoLogin.Meta;

        ScForm form;
        form = root.addForm();
        form.add(createUidField());
        form.setSubmitAction(this::handleContinue);
        form.hide();
        _proxyForm = form;

        ScGroup group;
        group = form.addGroup("Proxy");
        group.css().width400();

        ScDiv body;
        body = group.getBody();
        body.css().pad20();

        ScFieldTable fields;
        fields = body.addFieldTable();
        fields.addFieldText(x.TenantName);
        fields.addFieldText(x.UserFullName);

        ScDiv footer;
        footer = group.showFooter();
        footer.css().buttonBox();
        footer.addSubmitButton("Continue");
        footer.addCancelButton("Logout", this::handleLogout);
    }

    private void installErrorGroupOn(ScContainer root)
    {
        ScGroup group;
        group = root.addGroup("Invalid Proxy Request");
        group.setFlavorAlert();
        group.css().width400();
        group.hide();
        _errorGroup = group;

        ScDiv body;
        body = group.getBody();
        body.css().pad20();
        body.addText("The proxy request is invalid or stale.");
    }

    //==================================================
    //= install :: fields
    //==================================================

    private ScHiddenField<String> createUidField()
    {
        MyMetaAutoLogin x = MyAutoLogin.Meta;

        ScHiddenField<String> e;
        e = new ScHiddenField<>();
        e.setValueAdaptor(x.Uid);
        _autoLoginUidField = e;
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    public void preRender()
    {
        KmResult<MyAutoLogin> result = findAutoLogin(_autoLoginUid.getValue());
        if ( result.hasError() )
        {
            _errorGroup.show();
            return;
        }

        _proxyForm.show();
        _proxyForm.applyFromModel(result.getValue());
    }

    //##################################################
    //# handle
    //##################################################

    private void handleContinue()
    {
        String uid = _autoLoginUidField.getValue();
        KmResult<MyAutoLogin> result = findAutoLogin(uid);

        if ( result.hasError() )
        {
            ajaxToast(result.getError()).error();
            return;
        }

        MyAutoLogin login = result.getValue();
        MyLoginUtility.logIn(login);
        String url = MyUrls.getEntryUrl();
        ajax().gotoUrl(url);
    }

    private void handleLogout()
    {
        MyLoginUtility.ajaxLogOut();
    }

    //##################################################
    //# support
    //##################################################

    private KmResult<MyAutoLogin> findAutoLogin(String uid)
    {
        if ( Kmu.isEmpty(uid) )
            return KmResult.createError("No uid");

        MyAutoLogin login = getAccess().getAutoLoginDao().findUid(uid);
        if ( login == null )
            return KmResult.createError("Invalid proxy.");

        if ( login.isStale() )
            return KmResult.createError("Stale proxy.");

        MyTenant tenant = getCurrentTenant();
        if ( !login.getUser().hasTenant(tenant) )
            return KmResult.createError("Invalid tenant.");

        return KmResult.createValue(login);
    }

}
