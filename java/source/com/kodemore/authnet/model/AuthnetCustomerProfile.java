package com.kodemore.authnet.model;

import java.io.PrintWriter;

import com.kodemore.collection.KmList;
import com.kodemore.xml.utility.KmXmlBuilder;

public class AuthnetCustomerProfile
{
    //##################################################
    //# variables
    //##################################################

    private Integer                       _customerProfileId;
    private String                        _merchantCustomerId;
    private String                        _description;
    private String                        _email;
    private KmList<AuthnetPaymentProfile> _paymentProfiles;
    private KmList<AuthnetShipToAddress>  _shipToList;

    //##################################################
    //# constructor
    //##################################################

    public AuthnetCustomerProfile()
    {
        _paymentProfiles = new KmList<AuthnetPaymentProfile>();
        _shipToList = new KmList<AuthnetShipToAddress>();
    }

    //##################################################
    //# customer profile id
    //##################################################

    public Integer getCustomerProfileId()
    {
        return _customerProfileId;
    }

    public void setCustomerProfileId(Integer e)
    {
        _customerProfileId = e;
    }

    public boolean hasCustomerProfileId()
    {
        return _customerProfileId != null;
    }

    //##################################################
    //# merchant customer id
    //##################################################

    public String getMerchantCustomerId()
    {
        return _merchantCustomerId;
    }

    public void setMerchantCustomerId(String e)
    {
        _merchantCustomerId = e;
    }

    public boolean hasMerchantCustomerId()
    {
        return _merchantCustomerId != null;
    }

    //##################################################
    //# description
    //##################################################

    public String getDescription()
    {
        return _description;
    }

    public void setDescription(String e)
    {
        _description = e;
    }

    public boolean hasDescription()
    {
        return _description != null;
    }

    //##################################################
    //# email
    //##################################################

    public String getEmail()
    {
        return _email;
    }

    public void setEmail(String e)
    {
        _email = e;
    }

    public boolean hasEmail()
    {
        return _email != null;
    }

    //##################################################
    //# payment profiles
    //##################################################

    public KmList<AuthnetPaymentProfile> getPaymentProfiles()
    {
        return _paymentProfiles;
    }

    public void setPaymentProfiles(KmList<AuthnetPaymentProfile> v)
    {
        _paymentProfiles = v;
    }

    public boolean hasPaymentProfiles()
    {
        if ( _paymentProfiles == null )
            return false;

        return _paymentProfiles.isNotEmpty();
    }

    public AuthnetPaymentProfile addPaymentProfile()
    {
        AuthnetPaymentProfile profile;
        profile = new AuthnetPaymentProfile();
        _paymentProfiles.add(profile);
        return profile;
    }

    //##################################################
    //# ship to list
    //##################################################

    public KmList<AuthnetShipToAddress> getShipToList()
    {
        return _shipToList;
    }

    public void setShipToList(KmList<AuthnetShipToAddress> v)
    {
        _shipToList = v;
    }

    public boolean hasShipToList()
    {
        if ( _shipToList == null )
            return false;

        return _shipToList.isNotEmpty();
    }

    public AuthnetShipToAddress addShipTo()
    {
        AuthnetShipToAddress a;
        a = new AuthnetShipToAddress();
        _shipToList.add(a);
        return a;
    }

    //##################################################
    //# validation - take from the authnet xml guide
    //##################################################

    public boolean isValid()
    {
        if ( !hasMerchantCustomerId() && !hasDescription() && !hasEmail() )
            return false;

        if ( hasMerchantCustomerId() && getMerchantCustomerId().length() > 20 )
            return false;

        if ( hasDescription() && getDescription().length() > 255 )
            return false;

        if ( hasEmail() && getEmail().length() > 255 )
            return false;

        return true;
    }

    //##################################################
    //# xml
    //##################################################

    public void printXmlOn(KmXmlBuilder out)
    {
        out.begin("profile");

        if ( hasMerchantCustomerId() )
            out.value("merchantCustomerId", getMerchantCustomerId());

        if ( hasDescription() )
            out.value("description", getDescription());

        if ( hasEmail() )
            out.value("email", getEmail());

        if ( hasCustomerProfileId() )
            out.value("customerProfileId", getCustomerProfileId());

        if ( hasPaymentProfiles() )
            for ( AuthnetPaymentProfile p : _paymentProfiles )
                p.printXmlOn(out);

        if ( hasShipToList() )
            for ( AuthnetShipToAddress a : _shipToList )
                a.printXmlOn(out);

        out.end();
    }

    //##################################################
    //# print
    //##################################################

    public void printFieldsOn(PrintWriter out)
    {
        out.println("======= Profile =======");
        out.println("customerProfileId:  " + getCustomerProfileId());
        out.println("merchantCustomerId: " + getMerchantCustomerId());
        out.println("description:        " + getDescription());
        out.println("email:              " + getEmail());

        for ( AuthnetPaymentProfile p : getPaymentProfiles() )
            p.printFieldsOn(out);

        for ( AuthnetShipToAddress a : getShipToList() )
            a.printFieldsOn(out);
    }

}
