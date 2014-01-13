package com.kodemore.authnet.request;

import com.kodemore.xml.utility.KmXmlBuilder;

public class KmAuthnetGetPaymentProfileRequest
    extends KmAuthnetAbstractRequest
{
    //##################################################
    //# variables
    //##################################################

    private Integer _customerProfileId;
    private Integer _paymentProfileId;

    //##################################################
    //# constructor
    //##################################################

    public KmAuthnetGetPaymentProfileRequest()
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

    public void setCustomerProfileId(Integer customerProfileId)
    {
        _customerProfileId = customerProfileId;
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

    public void setPaymentProfileId(Integer customerPaymentProfileId)
    {
        _paymentProfileId = customerPaymentProfileId;
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

        return true;
    }

    //##################################################
    //# request based xml
    //##################################################

    @Override
    protected String getXmlTag()
    {
        return "getCustomerPaymentProfileRequest";
    }

    @Override
    protected void printXmlChildrenOn(KmXmlBuilder out)
    {
        out.value("customerProfileId", getCustomerProfileId());
        out.value("customerPaymentProfileId", getPaymentProfileId());
    }

    //##################################################
    //# post request
    //##################################################

    @Override
    public KmAuthnetGetPaymentProfileResponse post()
    {
        return post(new KmAuthnetGetPaymentProfileResponse());
    }

}
