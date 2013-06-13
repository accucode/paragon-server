package com.kodemore.authnet.request;

import com.kodemore.authnet.model.AuthnetCustomerProfile;
import com.kodemore.xml.utility.KmXmlBuilder;

public class AuthnetUpdateCustomerProfileRequest
    extends AuthnetAbstractRequest
{
    //##################################################
    //# variables
    //##################################################

    private AuthnetCustomerProfile _profile;

    //##################################################
    //# constructor
    //##################################################

    public AuthnetUpdateCustomerProfileRequest()
    {
        super();
    }

    //##################################################
    //# customer profile id
    //##################################################

    public AuthnetCustomerProfile getProfile()
    {
        return _profile;
    }

    public void setCustomerProfile(AuthnetCustomerProfile profile)
    {
        _profile = profile;
    }

    public boolean hasProfile()
    {
        return _profile != null;
    }

    public AuthnetCustomerProfile addProfile()
    {
        _profile = new AuthnetCustomerProfile();

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
    public AuthnetUpdateCustomerProfileResponse post()
    {
        return post(new AuthnetUpdateCustomerProfileResponse());
    }

}
