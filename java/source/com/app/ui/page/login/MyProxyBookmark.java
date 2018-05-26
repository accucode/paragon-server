package com.app.ui.page.login;

import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.servlet.ScParameterList;

import com.app.model.MyAutoLogin;
import com.app.model.MyUser;
import com.app.ui.page.MyBookmark;
import com.app.ui.page.MyPage;

public class MyProxyBookmark
    extends MyBookmark
{
    //##################################################
    //# constants
    //##################################################

    private static final String PARAM_AUTO_LOGIN_UID = "uid";

    //##################################################
    //# variables
    //##################################################

    private String _autoLoginUid;

    //##################################################
    //# constructor
    //##################################################

    public MyProxyBookmark(MyPage e)
    {
        super(e);
    }

    //##################################################
    //# auto login
    //##################################################

    public String getAutoLoginUid()
    {
        return _autoLoginUid;
    }

    public MyAutoLogin getAutoLogin()
    {
        return getAccess().findAutoLoginUid(getAutoLoginUid());
    }

    public void setAutoLoginUid(String e)
    {
        _autoLoginUid = e;
    }

    public void setAutoLogin(MyAutoLogin e)
    {
        setAutoLoginUid(KmUidDomainIF.getUidFor(e));
    }

    public void setAutoLoginFor(MyUser user)
    {
        MyAutoLogin e;
        e = new MyAutoLogin();
        e.setUser(user);
        e.daoAttach();

        setAutoLogin(e);
    }

    //##################################################
    //# params
    //##################################################

    @Override
    public void readFrom(ScParameterList params)
    {
        super.readFrom(params);

        setAutoLoginUid(params.getString(PARAM_AUTO_LOGIN_UID));
    }

    @Override
    public void writeTo(ScParameterList params)
    {
        super.writeTo(params);

        params.setString(PARAM_AUTO_LOGIN_UID, getAutoLoginUid());
    }

}
