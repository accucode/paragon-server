package com.kodemore.authnet.request;

import com.kodemore.authnet.model.KmAuthnetCustomerProfile;
import com.kodemore.xml.utility.KmXmlBuilder;

public class KmAuthnetCreateCustomerProfileRequest
    extends KmAuthnetAbstractRequest
{
    //##################################################
    //# variables
    //##################################################

    private KmAuthnetCustomerProfile _profile;

    //##################################################
    //# profile
    //##################################################

    public KmAuthnetCustomerProfile addProfile()
    {
        _profile = new KmAuthnetCustomerProfile();
        return _profile;
    }

    public KmAuthnetCustomerProfile getProfile()
    {
        return _profile;
    }

    public void setProfile(KmAuthnetCustomerProfile profile)
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
    public KmAuthnetCreateCustomerProfileResponse post()
    {
        return post(new KmAuthnetCreateCustomerProfileResponse());
    }

}
