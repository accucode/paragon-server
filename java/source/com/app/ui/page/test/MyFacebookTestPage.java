package com.app.ui.page.test;

import com.kodemore.http.KmHttpGet;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScPageRoot;

public class MyFacebookTestPage
    extends MyAbstractTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyFacebookTestPage instance = new MyFacebookTestPage();

    private MyFacebookTestPage()
    {
        // singleton
    }

    //##################################################
    //# navigation
    //##################################################

    @Override
    public ScParameterList composeQueryParameters()
    {
        return null;
    }

    @Override
    public void applyQueryParameters(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().gap();
        root.addButton("Request Token", newRequestAction());
    }

    //##################################################
    //# action
    //##################################################

    private ScActionIF newRequestAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleRequest();
            }
        };
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
        // fixme_steve: add in client_id from dashboard
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
