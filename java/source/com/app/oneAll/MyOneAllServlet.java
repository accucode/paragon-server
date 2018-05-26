package com.app.oneAll;

import com.kodemore.collection.KmList;
import com.kodemore.command.KmDao;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoAccess;
import com.app.model.MyAutoLogin;
import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.ui.core.MyServletData;
import com.app.ui.page.login.MyLoginBookmark;
import com.app.ui.page.login.MyLoginPage;
import com.app.ui.page.login.MyLoginUtility;
import com.app.ui.servlet.MyServlet;
import com.app.utility.MyGlobals;
import com.app.utility.MyUrls;

/**
 * This provides the social login callback for the OneAll
 * social login. This allows users to login using their
 * Google credentials. Note that the users must already
 * be defined.
 */
public class MyOneAllServlet
    extends MyServlet
{
    //##################################################
    //# get / post
    //##################################################

    @Override
    protected void doGet()
    {
        handle();
    }

    @Override
    protected void doPost()
    {
        handle();
    }

    //##################################################
    //# process
    //##################################################

    private void handle()
    {
        try
        {
            KmDao.run(this::handleTry);
        }
        catch ( Throwable ex )
        {
            printMessage(ex.getMessage());
        }
    }

    private void handleTry()
    {
        checkEnabled();

        String connectionToken = getConnectionToken();

        MyOneAllConnectionRequest req;
        req = new MyOneAllConnectionRequest();
        req.setConnectionToken(connectionToken);

        MyOneAllConnectionResponse res;
        res = req.submit();

        if ( !res.isOk() )
            throw Kmu.newError(
                "Authentication failed (%s); %s.",
                res.getStatusCode(),
                res.getStatusMessage());

        handleOk(res);
    }

    private void checkEnabled()
    {
        boolean enabled = getProperties().getOneAllEnabled();
        if ( !enabled )
            throw Kmu.newError("OneAll is not enabled, login with your email and password.");
    }

    private void handleOk(MyOneAllConnectionResponse res)
    {
        MyTenant tenant = getData().getTenant();
        String email = getEmailFor(res);

        MyUser user = getAccess().getUserDao().findEmail(tenant, email);
        if ( user == null )
            throw Kmu.newError(
                "Authentication failed (%s); self sign up is currently not allowed.",
                email);

        login(user);
    }

    private void login(MyUser user)
    {
        MyLoginUtility.ajaxLogIn(user);

        MyAutoLogin auto;
        auto = new MyAutoLogin();
        auto.setUser(user);
        auto.touch();
        auto.daoAttach();

        MyServletData data;
        data = getData();
        data.clearCookie(MyLoginUtility.COOKIE_EMAIL);
        data.setCookie(MyLoginUtility.COOKIE_AUTO_LOGIN, auto.getUid());
        data.redirectWithPost(MyUrls.formatEntryUrl());
    }

    private MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    //##################################################
    //# print
    //##################################################

    private void printMessage(String msg, Object... args)
    {
        KmStringBuilder out;
        out = new KmStringBuilder();
        out.println("OneAll Authentication Failed.");
        out.println();
        out.printfln(msg, args);

        String s = out.toString();

        MyLoginBookmark b;
        b = MyLoginPage.getInstance().newBookmark();
        b.setError(s);

        getData().redirectTo(b);
    }

    //##################################################
    //# support
    //##################################################

    private String getConnectionToken()
    {
        final String tokenKey = "connection_token";

        MyServletData data = getData();
        if ( !data.hasParameter(tokenKey) )
            throw Kmu.newError("OneAll connection token; parameter is missing.");

        String token = data.getParameter(tokenKey);
        if ( Kmu.isEmpty(token) )
            throw Kmu.newError("OneAll connection token; parameter is empty.");

        return token;
    }

    @SuppressWarnings("unused")
    private String getNameFor(MyOneAllConnectionResponse res)
    {
        String s = res.getUserName();

        if ( Kmu.isEmpty(s) )
            throw Kmu.newError("OneAll authentication failed; missing user name.");

        return s;
    }

    @SuppressWarnings("unused")
    private String getTokenFor(MyOneAllConnectionResponse res)
    {
        String s = res.getUserToken();

        if ( Kmu.isEmpty(s) )
            throw Kmu.newError("OneAll authentication failed; missing user token.");

        return s;
    }

    private String getEmailFor(MyOneAllConnectionResponse res)
    {
        KmList<String> v = res.getVerifiedEmails();

        if ( v.isEmpty() )
            throw Kmu.newError("OneAll authentication failed; missing email.");

        if ( v.isMultiple() )
            throw Kmu.newError("OneAll authentication failed; multiple emails.");

        return v.getFirst();
    }
}
