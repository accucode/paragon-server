package com.kodemore.authnet.request;

import com.kodemore.authnet.model.AuthnetCustomerProfile;
import com.kodemore.xml.utility.KmXmlBuilder;

public class AuthnetCreateCustomerProfileRequest
    extends AuthnetAbstractRequest
{
    //##################################################
    //# variables
    //##################################################

    private AuthnetCustomerProfile _profile;

    //##################################################
    //# profile
    //##################################################

    public AuthnetCustomerProfile addProfile()
    {
        _profile = new AuthnetCustomerProfile();
        return _profile;
    }

    public AuthnetCustomerProfile getProfile()
    {
        return _profile;
    }

    public void setProfile(AuthnetCustomerProfile profile)
    {
        _profile = profile;
    }

    public boolean hasProfile()
    {
        return _profile != null;
    }

    //##################################################
    //# validation
    //##################################################

    @Override
    public boolean isValid()
    {
        if ( !super.isValid() )
            return false;

        if ( !hasProfile() )
            return false;

        return _profile.isValid();
    }

    //##################################################
    //# xml
    //##################################################

    @Override
    protected String getXmlTag()
    {
        return "createCustomerProfileRequest";
    }

    @Override
    protected void printXmlChildrenOn(KmXmlBuilder out)
    {
        _profile.printXmlOn(out);
    }

    //##################################################
    //# post
    //##################################################

    @Override
    public AuthnetCreateCustomerProfileResponse post()
    {
        return post(new AuthnetCreateCustomerProfileResponse());
    }

}
