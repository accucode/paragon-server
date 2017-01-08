package com.app.ui.page.test;

import com.kodemore.http.KmHttpGet;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyFacebookTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyFacebookTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyFacebookTestPage();
    }

    public static MyFacebookTestPage getInstance()
    {
        return _instance;
    }

    private MyFacebookTestPage()
    {
        // singleton
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    public final MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.developer;
    }

    //##################################################
    //# bookmark
    //##################################################

    @Override
    public void composeBookmarkOn(ScParameterList v)
    {
        // none
    }

    @Override
    public void applyBookmark(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().fill().auto();
        root.addButton("Request Token", this::handleRequest);
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        // none
    }

    //##################################################
    //# handle
    //##################################################

    private void handleRequest()
    {
        KmHttpGet e;
        e = new KmHttpGet();
        e.setHost("graph.facebook.com");
        e.setPath("oauth/access_token");
        // fixme : add in client_id from dashboard
        //        e.setParameter("client_id", "");
        e.setParameter("redirect_uri", "https://www.facebook.com/connect/login_success.html");
        e.setContentType("text/html");
        e.submit();
        System.out.println("------------------------------------------------------------");
        if ( e.hasException() )
        {
            System.out.println("url:   " + e.getUrl());
            System.out.println("error: " + e.getException());
            return;
        }
        System.out.println("url:              " + e.getUrl());
        System.out.println("response code:    " + e.getResponseCode());
        System.out.println("response message: " + e.getResponseMessage());
        System.out.println(e.getResponseString());

    }
}
