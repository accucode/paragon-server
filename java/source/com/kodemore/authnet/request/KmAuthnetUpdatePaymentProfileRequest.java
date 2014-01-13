package com.kodemore.authnet.request;

import com.kodemore.authnet.model.KmAuthnetPaymentProfile;
import com.kodemore.xml.utility.KmXmlBuilder;

public class KmAuthnetUpdatePaymentProfileRequest
    extends KmAuthnetAbstractRequest
{
    //##################################################
    //# variables
    //##################################################

    private Integer                 _customerProfileId;
    private KmAuthnetPaymentProfile _paymentProfile;

    //##################################################
    //# constructor
    //##################################################

    public KmAuthnetUpdatePaymentProfileRequest()
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

    public KmAuthnetPaymentProfile getPaymentProfile()
    {
        return _paymentProfile;
    }

    public void setCustomerPaymentProfile(KmAuthnetPaymentProfile paymentProfile)
    {
        _paymentProfile = paymentProfile;
        _paymentProfile.setSingular();
    }

    public boolean hasCustomerPaymentProfile()
    {
        return _paymentProfile != null;
    }

    public KmAuthnetPaymentProfile addPaymentProfile()
    {
        _paymentProfile = new KmAuthnetPaymentProfile();
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
    public KmAuthnetUpdatePaymentProfileResponse post()
    {
        return post(new KmAuthnetUpdatePaymentProfileResponse());
    }

}
