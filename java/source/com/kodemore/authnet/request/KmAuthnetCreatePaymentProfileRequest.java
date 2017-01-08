package com.kodemore.authnet.request;

import com.kodemore.authnet.model.KmAuthnetPaymentProfile;
import com.kodemore.xml.utility.KmXmlBuilder;

public class KmAuthnetCreatePaymentProfileRequest
    extends KmAuthnetAbstractRequest
{
    //##################################################
    //# constants
    //##################################################

    public static final String      VALIDATION_MODE_NONE = "none";
    public static final String      VALIDATION_MODE_TEST = "testMode";
    public static final String      VALIDATION_MODE_LIVE = "liveMode";

    //##################################################
    //# variables
    //##################################################

    private Integer                 _customerProfileId;
    private KmAuthnetPaymentProfile _paymentProfile;
    private String                  _validationMode;

    //##################################################
    //# constructor
    //##################################################

    public KmAuthnetCreatePaymentProfileRequest()
    {
        setValidationMode(VALIDATION_MODE_NONE);
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
    //# validation
    //##################################################

    public String getValidationMode()
    {
        return _validationMode;
    }

    public void setValidationMode(String validationMode)
    {
        _validationMode = validationMode;
    }

    public boolean hasValidationMode()
    {
        return _validationMode != null;
    }

    //##################################################
    //# payment profile
    //##################################################

    public KmAuthnetPaymentProfile addPaymentProfile()
    {
        _paymentProfile = new KmAuthnetPaymentProfile();
        _paymentProfile.setSingular();
        return _paymentProfile;
    }

    public KmAuthnetPaymentProfile getPaymentProfile()
    {
        return _paymentProfile;
    }

    public boolean hasPaymentProfile()
    {
        return _paymentProfile != null;
    }

    //##################################################
    //# validation
    //##################################################

    @Override
    public boolean isValid()
    {
        if ( !super.isValid() )
            return false;

        if ( !hasCustomerProfileId() )
            return false;

        if ( !hasPaymentProfile() )
            return false;

        return _paymentProfile.isValid();
    }

    //##################################################
    //# xml
    //##################################################

    @Override
    public String getXmlTag()
    {
        return "createCustomerPaymentProfileRequest";
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
    public KmAuthnetCreatePaymentProfileResponse post()
    {
        return post(new KmAuthnetCreatePaymentProfileResponse());
    }

}
