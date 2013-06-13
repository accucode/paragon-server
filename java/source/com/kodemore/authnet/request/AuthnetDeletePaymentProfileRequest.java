package com.kodemore.authnet.request;

import com.kodemore.xml.utility.KmXmlBuilder;

public class AuthnetDeletePaymentProfileRequest
    extends AuthnetAbstractRequest
{
    //##################################################
    //# variables
    //##################################################

    private Integer _customerProfileId;
    private Integer _paymentProfileId;

    //##################################################
    //# constructor
    //##################################################

    public AuthnetDeletePaymentProfileRequest()
    {
        super();
    }

    //##################################################
    //# customer profile id
    //##################################################

    public Integer getCustomerProfileId()
    {
        return _customerProfileId;
    }

    public void setCustomerProfileId(Integer e)
    {
        _customerProfileId = e;
    }

    public boolean hasCustomerProfileId()
    {
        return _customerProfileId != null;
    }

    //##################################################
    //# payment profile id
    //##################################################

    public Integer getPaymentProfileId()
    {
        return _paymentProfileId;
    }

    public void setPaymentProfileId(Integer e)
    {
        _paymentProfileId = e;
    }

    public boolean hasPaymentProfileId()
    {
        return _paymentProfileId != null;
    }

    //##################################################
    //# validation - take from the authnet xml guide
    //##################################################

    @Override
    public boolean isValid()
    {
        if ( !super.isValid() )
            return false;

        if ( !hasCustomerProfileId() )
            return false;

        if ( !hasPaymentProfileId() )
            return false;

        return true;
    }

    //##################################################
    //# request based xml
    //##################################################

    @Override
    protected String getXmlTag()
    {
        return "deleteCustomerPaymentProfileRequest";
    }

    @Override
    protected void printXmlChildrenOn(KmXmlBuilder out)
    {
        out.value("customerProfileId", getCustomerProfileId());
        out.value("customerPaymentProfileId", getPaymentProfileId());
    }

    //##################################################
    //# post
    //##################################################

    @Override
    public AuthnetDeletePaymentProfileResponse post()
    {
        return post(new AuthnetDeletePaymentProfileResponse());
    }

}
