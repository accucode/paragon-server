package com.kodemore.authnet.request;

import com.kodemore.authnet.model.AuthnetMerchantAuthentication;
import com.kodemore.authnet.support.AuthnetPost;
import com.kodemore.xml.utility.KmXmlBuilder;

public abstract class AuthnetAbstractRequest
{
    //##################################################
    //# variables
    //##################################################

    private KmXmlBuilder                  _request;
    private AuthnetMerchantAuthentication _authentication;
    private String                        _refId;

    //##################################################
    //# constructor
    //##################################################

    public AuthnetAbstractRequest()
    {
        _request = new KmXmlBuilder();
        _request.addXmlDefinition();
    }

    public AuthnetAbstractRequest(String apiLogin, String transactionKey)
    {
        this();
        _authentication = new AuthnetMerchantAuthentication();
        _authentication.setApiLogin(apiLogin);
        _authentication.setTransactionKey(transactionKey);
    }

    //##################################################
    //# post
    //##################################################

    protected <E extends AuthnetAbstractResponse> E post(E response)
    {
        AuthnetPost p;
        p = new AuthnetPost();
        p.setRequest(this);
        p.setResponse(response);
        p.post();
        return response;
    }

    //##################################################
    //# validation - override
    //##################################################

    public boolean isValid()
    {
        return hasAuthorization();
    }

    //##################################################
    //# authorization
    //##################################################

    public AuthnetMerchantAuthentication getAuthorization()
    {
        return _authentication;
    }

    public void setAuthorization(AuthnetMerchantAuthentication auth)
    {
        _authentication = auth;
    }

    public void setAuthorization(String apiLogin, String transactionKey)
    {
        AuthnetMerchantAuthentication auth;
        auth = new AuthnetMerchantAuthentication();
        auth.setApiLogin(apiLogin);
        auth.setTransactionKey(transactionKey);
        _authentication = auth;
    }

    public boolean hasAuthorization()
    {
        return _authentication != null;
    }

    //##################################################
    //# ref id
    //##################################################

    public String getRefId()
    {
        return _refId;
    }

    public void setRefId(String refId)
    {
        _refId = refId;
    }

    public boolean hasRefId()
    {
        return _refId != null;
    }

    //##################################################
    //# xml
    //##################################################

    public void dumpXml()
    {
        KmXmlBuilder out;
        out = new KmXmlBuilder();
        printXmlOn(out);
        System.out.println(out.toString());
    }

    public void printXmlOn(KmXmlBuilder out)
    {
        out.open(getXmlTag());
        out.printAttribute("xmlns", "AnetApi/xml/v1/schema/AnetApiSchema.xsd");
        out.close();

        _authentication.printXmlOn(out);

        if ( hasRefId() )
            out.value("refId", getRefId());

        printXmlChildrenOn(out);

        out.end();
    }

    protected abstract String getXmlTag();

    protected abstract void printXmlChildrenOn(KmXmlBuilder out);

    //##################################################
    //# post
    //##################################################

    protected abstract AuthnetAbstractResponse post();

}
