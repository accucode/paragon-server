package com.kodemore.authnet.model;

import com.kodemore.xml.utility.KmXmlBuilder;

public class KmAuthnetMerchantAuthentication
{
    //##################################################
    //# variables
    //##################################################

    private String _apiLogin;
    private String _transactionKey;

    //##################################################
    //# api login
    //##################################################

    public String getApiLogin()
    {
        return _apiLogin;
    }

    public void setApiLogin(String apiLogin)
    {
        _apiLogin = apiLogin;
    }

    public boolean hasApiLogin()
    {
        return _apiLogin != null;
    }

    //##################################################
    //# transaction key
    //##################################################

    public String getTransactionKey()
    {
        return _transactionKey;
    }

    public void setTransactionKey(String transactionKey)
    {
        _transactionKey = transactionKey;
    }

    public boolean hasTransactionKey()
    {
        return _transactionKey != null;
    }

    //##################################################
    //# validation - taken from the authnet xml guide
    //##################################################

    public boolean isValid()
    {
        if ( !hasApiLogin() )
            return false;

        if ( !hasTransactionKey() )
            return false;

        return true;
    }

    //##################################################
    //# print xml
    //##################################################

    public void printXmlOn(KmXmlBuilder out)
    {
        out.begin("merchantAuthentication");

        out.value("name", getApiLogin());
        out.value("transactionKey", getTransactionKey());

        out.end();
    }

}
