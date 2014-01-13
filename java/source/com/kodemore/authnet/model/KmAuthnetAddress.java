package com.kodemore.authnet.model;

import java.io.PrintWriter;

import com.kodemore.xml.utility.KmXmlBuilder;

/**
 * I encapsulate all the address information used in the authnet xml interface.
 * all my fields are optional.
 */
public abstract class KmAuthnetAddress
{
    //##################################################
    //# variables
    //##################################################

    private String _firstName;
    private String _lastName;
    private String _company;
    private String _street;
    private String _city;
    private String _state;
    private String _zip;
    private String _country;
    private String _phoneNumber;
    private String _faxNumber;

    //##################################################
    //# first name
    //##################################################

    public String getFirstName()
    {
        return _firstName;
    }

    public void setFirstName(String e)
    {
        _firstName = e;
    }

    public boolean hasFirstName()
    {
        return _firstName != null;
    }

    //##################################################
    //# last name
    //##################################################

    public String getLastName()
    {
        return _lastName;
    }

    public void setLastName(String e)
    {
        _lastName = e;
    }

    public boolean hasLastName()
    {
        return _lastName != null;
    }

    //##################################################
    //# company
    //##################################################

    public String getCompany()
    {
        return _company;
    }

    public void setCompany(String e)
    {
        _company = e;
    }

    public boolean hasCompany()
    {
        return _company != null;
    }

    //##################################################
    //# address
    //##################################################

    public String getStreet()
    {
        return _street;
    }

    public void setStreet(String e)
    {
        _street = e;
    }

    public boolean hasStreet()
    {
        return _street != null;
    }

    //##################################################
    //# city
    //##################################################

    public String getCity()
    {
        return _city;
    }

    public void setCity(String e)
    {
        _city = e;
    }

    public boolean hasCity()
    {
        return _city != null;
    }

    //##################################################
    //# state
    //##################################################

    public String getState()
    {
        return _state;
    }

    public void setState(String e)
    {
        _state = e;
    }

    public boolean hasState()
    {
        return _state != null;
    }

    //##################################################
    //# zip
    //##################################################

    public String getZip()
    {
        return _zip;
    }

    public void setZip(String e)
    {
        _zip = e;
    }

    public boolean hasZip()
    {
        return _zip != null;
    }

    //##################################################
    //# country
    //##################################################

    public String getCountry()
    {
        return _country;
    }

    public void setCountry(String e)
    {
        _country = e;
    }

    public boolean hasCountry()
    {
        return _country != null;
    }

    //##################################################
    //# phone number
    //##################################################

    public String getPhoneNumber()
    {
        return _phoneNumber;
    }

    public void setPhoneNumber(String e)
    {
        _phoneNumber = e;
    }

    public boolean hasPhoneNumber()
    {
        return _phoneNumber != null;
    }

    //##################################################
    //# fax number
    //##################################################

    public String getFaxNumber()
    {
        return _faxNumber;
    }

    public void setFaxNumber(String e)
    {
        _faxNumber = e;
    }

    public boolean hasFaxNumber()
    {
        return _faxNumber != null;
    }

    //##################################################
    //# validation - take from the authnet xml guide
    //##################################################

    public boolean isValid()
    {
        return true;
    }

    //##################################################
    //# print
    //##################################################

    public void printXmlOn(KmXmlBuilder out)
    {
        printXmlGroupOn(out);

        if ( hasFirstName() )
            out.value("firstName", getFirstName());

        if ( hasLastName() )
            out.value("lastName", getLastName());

        if ( hasCompany() )
            out.value("company", getCompany());

        if ( hasStreet() )
            out.value("address", getStreet());

        if ( hasCity() )
            out.value("city", getCity());

        if ( hasState() )
            out.value("state", getState());

        if ( hasZip() )
            out.value("zip", getZip());

        if ( hasCountry() )
            out.value("country", getCountry());

        if ( hasPhoneNumber() )
            out.value("phoneNumber", getPhoneNumber());

        if ( hasFaxNumber() )
            out.value("faxNumber", getFaxNumber());

        out.end();
    }

    public void printFieldsOn(PrintWriter out)
    {
        out.println("firstName:   " + getFirstName());
        out.println("lastName:    " + getLastName());
        out.println("company:     " + getCompany());
        out.println("address:     " + getStreet());
        out.println("city:        " + getCity());
        out.println("state:       " + getState());
        out.println("zip:         " + getZip());
        out.println("country:     " + getCountry());
        out.println("phoneNumber: " + getPhoneNumber());
        out.println("faxNumber:   " + getFaxNumber());
    }

    //##################################################
    //# abstract
    //##################################################

    protected abstract void printXmlGroupOn(KmXmlBuilder out);

}
