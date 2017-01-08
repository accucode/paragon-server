package com.app.model.address;

/**
 * I define an Address value object.  This allows aggregation and manipulation
 * of address information that is detached from the domain model and hibernate.
 */
public class MyAddressVo
    implements MyAddressIF
{
    //##################################################
    //# variables
    //##################################################

    private String _street1;
    private String _street2;
    private String _city;
    private String _region;
    private String _postalCode;
    private String _country;
    private String _attention;
    private String _phone;

    //##################################################
    //# constructor
    //##################################################

    public MyAddressVo()
    {
        // none
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getStreet1()
    {
        return _street1;
    }

    @Override
    public void setStreet1(String e)
    {
        _street1 = e;
    }

    @Override
    public String getStreet2()
    {
        return _street2;
    }

    @Override
    public void setStreet2(String e)
    {
        _street2 = e;
    }

    @Override
    public String getCity()
    {
        return _city;
    }

    @Override
    public void setCity(String e)
    {
        _city = e;
    }

    @Override
    public String getRegion()
    {
        return _region;
    }

    @Override
    public void setRegion(String e)
    {
        _region = e;
    }

    @Override
    public String getPostalCode()
    {
        return _postalCode;
    }

    @Override
    public void setPostalCode(String e)
    {
        _postalCode = e;
    }

    @Override
    public String getCountry()
    {
        return _country;
    }

    @Override
    public void setCountry(String e)
    {
        _country = e;
    }

    @Override
    public String getAttention()
    {
        return _attention;
    }

    @Override
    public void setAttention(String e)
    {
        _attention = e;
    }

    @Override
    public String getPhone()
    {
        return _phone;
    }

    @Override
    public void setPhone(String phone)
    {
        _phone = phone;
    }
}
