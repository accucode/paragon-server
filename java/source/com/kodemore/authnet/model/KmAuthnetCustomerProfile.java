package com.kodemore.authnet.model;

import java.io.PrintWriter;

import com.kodemore.collection.KmList;
import com.kodemore.xml.utility.KmXmlBuilder;

public class KmAuthnetCustomerProfile
{
    //##################################################
    //# variables
    //##################################################

    private Integer                       _customerProfileId;
    private String                        _merchantCustomerId;
    private String                        _description;
    private String                        _email;
    private KmList<KmAuthnetPaymentProfile> _paymentProfiles;
    private KmList<KmAuthnetShipToAddress>  _shipToList;

    //##################################################
    //# constructor
    //##################################################

    public KmAuthnetCustomerProfile()
    {
        _paymentProfiles = new KmList<KmAuthnetPaymentProfile>();
        _shipToList = new KmList<KmAuthnetShipToAddress>();
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

    public KmList<KmAuthnetPaymentProfile> getPaymentProfiles()
    {
        return _paymentProfiles;
    }

    public void setPaymentProfiles(KmList<KmAuthnetPaymentProfile> v)
    {
        _paymentProfiles = v;
    }

    public boolean hasPaymentProfiles()
    {
        if ( _paymentProfiles == null )
            return false;

        return _paymentProfiles.isNotEmpty();
    }

    public KmAuthnetPaymentProfile addPaymentProfile()
    {
        KmAuthnetPaymentProfile profile;
        profile = new KmAuthnetPaymentProfile();
        _paymentProfiles.add(profile);
        return profile;
    }

    //##################################################
    //# ship to list
    //##################################################

    public KmList<KmAuthnetShipToAddress> getShipToList()
    {
        return _shipToList;
    }

    public void setShipToList(KmList<KmAuthnetShipToAddress> v)
    {
        _shipToList = v;
    }

    public boolean hasShipToList()
    {
        if ( _shipToList == null )
            return false;

        return _shipToList.isNotEmpty();
    }

    public KmAuthnetShipToAddress addShipTo()
    {
        KmAuthnetShipToAddress a;
        a = new KmAuthnetShipToAddress();
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
            for ( KmAuthnetPaymentProfile p : _paymentProfiles )
                p.printXmlOn(out);

        if ( hasShipToList() )
            for ( KmAuthnetShipToAddress a : _shipToList )
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

        for ( KmAuthnetPaymentProfile p : getPaymentProfiles() )
            p.printFieldsOn(out);

        for ( KmAuthnetShipToAddress a : getShipToList() )
            a.printFieldsOn(out);
    }

}
