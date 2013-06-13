package com.kodemore.authnet.request;

import com.kodemore.authnet.model.AuthnetPaymentProfile;
import com.kodemore.xml.utility.KmXmlBuilder;

public class AuthnetUpdatePaymentProfileRequest
    extends AuthnetAbstractRequest
{
    //##################################################
    //# variables
    //##################################################

    private Integer               _customerProfileId;
    private AuthnetPaymentProfile _paymentProfile;

    //##################################################
    //# constructor
    //##################################################

    public AuthnetUpdatePaymentProfileRequest()
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
    //# customer profile id
    //##################################################

    public AuthnetPaymentProfile getPaymentProfile()
    {
        return _paymentProfile;
    }

    public void setCustomerPaymentProfile(AuthnetPaymentProfile paymentProfile)
    {
        _paymentProfile = paymentProfile;
        _paymentProfile.setSingular();
    }

    public boolean hasCustomerPaymentProfile()
    {
        return _paymentProfile != null;
    }

    public AuthnetPaymentProfile addPaymentProfile()
    {
        _paymentProfile = new AuthnetPaymentProfile();
        _paymentProfile.setSingular();

        return _paymentProfile;
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

        if ( !hasCustomerPaymentProfile() )
            return false;

        return true;
    }

    //##################################################
    //# request based xml
    //##################################################

    @Override
    protected String getXmlTag()
    {
        return "updateCustomerPaymentProfileRequest";
    }

    @Override
    protected void printXmlChildrenOn(KmXmlBuilder out)
    {
        out.value("customerProfileId", getCustomerProfileId());
        _paymentProfile.printXmlOn(out);
    }

    //##################################################
    //# post
    //##################################################

    @Override
    public AuthnetUpdatePaymentProfileResponse post()
    {
        return post(new AuthnetUpdatePaymentProfileResponse());
    }

}
