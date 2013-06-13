package com.kodemore.authnet.request;

import com.kodemore.xml.utility.KmXmlBuilder;

public class AuthnetGetCustomerProfileRequest
    extends AuthnetAbstractRequest
{
    //##################################################
    //# variables
    //##################################################

    private Integer _customerProfileId;

    //##################################################
    //# constructor
    //##################################################

    public AuthnetGetCustomerProfileRequest()
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
        return "getCustomerProfileRequest";
    }

    @Override
    protected void printXmlChildrenOn(KmXmlBuilder out)
    {
        out.value("customerProfileId", getCustomerProfileId());
    }

    //##################################################
    //# post request
    //##################################################

    @Override
    public AuthnetGetCustomerProfileResponse post()
    {
        return post(new AuthnetGetCustomerProfileResponse());
    }

}
