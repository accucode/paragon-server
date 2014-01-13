package com.kodemore.authnet.request;

import com.kodemore.authnet.model.KmAuthnetCustomerProfile;
import com.kodemore.xml.utility.KmXmlBuilder;

public class KmAuthnetUpdateCustomerProfileRequest
    extends KmAuthnetAbstractRequest
{
    //##################################################
    //# variables
    //##################################################

    private KmAuthnetCustomerProfile _profile;

    //##################################################
    //# constructor
    //##################################################

    public KmAuthnetUpdateCustomerProfileRequest()
    {
        super();
    }

    //##################################################
    //# customer profile id
    //##################################################

    public KmAuthnetCustomerProfile getProfile()
    {
        return _profile;
    }

    public void setCustomerProfile(KmAuthnetCustomerProfile profile)
    {
        _profile = profile;
    }

    public boolean hasProfile()
    {
        return _profile != null;
    }

    public KmAuthnetCustomerProfile addProfile()
    {
        _profile = new KmAuthnetCustomerProfile();

        return _profile;
    }

    //##################################################
    //# validation - take from the authnet xml guide
    //##################################################

    @Override
    public boolean isValid()
    {
        if ( !super.isValid() )
            return false;

        if ( !hasProfile() )
            return false;

        return true;
    }

    //##################################################
    //# request based xml
    //##################################################

    @Override
    protected String getXmlTag()
    {
        return "updateCustomerProfileRequest";
    }

    @Override
    protected void printXmlChildrenOn(KmXmlBuilder out)
    {
        _profile.printXmlOn(out);
    }

    //##################################################
    //# post request
    //##################################################

    @Override
    public KmAuthnetUpdateCustomerProfileResponse post()
    {
        return post(new KmAuthnetUpdateCustomerProfileResponse());
    }

}
