package com.kodemore.authnet.request;

import com.kodemore.xml.utility.KmXmlBuilder;

public class AuthnetDeleteCustomerProfileRequest
    extends AuthnetAbstractRequest
{
    //##################################################
    //# variables
    //##################################################

    private Integer _customerProfileId;

    //##################################################
    //# constructor
    //##################################################

    public AuthnetDeleteCustomerProfileRequest()
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
        return "deleteCustomerProfileRequest";
    }

    @Override
    protected void printXmlChildrenOn(KmXmlBuilder out)
    {
        out.value("customerProfileId", getCustomerProfileId());
    }

    //##################################################
    //# post
    //##################################################

    @Override
    public AuthnetDeleteCustomerProfileResponse post()
    {
        return post(new AuthnetDeleteCustomerProfileResponse());
    }

}
