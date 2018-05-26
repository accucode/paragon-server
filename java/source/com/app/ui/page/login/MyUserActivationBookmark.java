package com.app.ui.page.login;

import com.kodemore.servlet.ScParameterList;

import com.app.ui.page.MyBookmark;

public class MyUserActivationBookmark
    extends MyBookmark
{
    //##################################################
    //# constants
    //##################################################

    private static final String PARAM_TOKEN = "token";

    //##################################################
    //# variables
    //##################################################

    private String _token;

    //##################################################
    //# constructor
    //##################################################

    public MyUserActivationBookmark(MyUserActivationPage e)
    {
        super(e);
    }

    //##################################################
    //# token
    //##################################################

    public String getToken()
    {
        return _token;
    }

    public void setToken(String e)
    {
        _token = e;
    }

    //##################################################
    //# parameters
    //##################################################

    @Override
    public void readFrom(ScParameterList params)
    {
        super.readFrom(params);

        setToken(params.getString(PARAM_TOKEN));
    }

    @Override
    public void writeTo(ScParameterList params)
    {
        super.writeTo(params);

        params.setString(PARAM_TOKEN, getToken());
    }

}
