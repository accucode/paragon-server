package com.kodemore.authnet.request;

import com.kodemore.authnet.model.KmAuthnetMerchantAuthentication;
import com.kodemore.authnet.support.KmAuthnetPost;
import com.kodemore.xml.utility.KmXmlBuilder;

public abstract class KmAuthnetAbstractRequest
{
    //##################################################
    //# variables
    //##################################################

    private KmXmlBuilder                  _request;
    private KmAuthnetMerchantAuthentication _authentication;
    private String                        _refId;

    //##################################################
    //# constructor
    //##################################################

    public KmAuthnetAbstractRequest()
    {
        _request = new KmXmlBuilder();
        _request.addXmlDefinition();
    }

    public KmAuthnetAbstractRequest(String apiLogin, String transactionKey)
    {
        this();
        _authentication = new KmAuthnetMerchantAuthentication();
        _authentication.setApiLogin(apiLogin);
        _authentication.setTransactionKey(transactionKey);
    }

    //##################################################
    //# post
    //##################################################

    protected <E extends KmAuthnetAbstractResponse> E post(E response)
    {
        KmAuthnetPost p;
        p = new KmAuthnetPost();
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

    public KmAuthnetMerchantAuthentication getAuthorization()
    {
        return _authentication;
    }

    public void setAuthorization(KmAuthnetMerchantAuthentication auth)
    {
        _authentication = auth;
    }

    public void setAuthorization(String apiLogin, String transactionKey)
    {
        KmAuthnetMerchantAuthentication auth;
        auth = new KmAuthnetMerchantAuthentication();
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

    protected abstract KmAuthnetAbstractResponse post();

}
