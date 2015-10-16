package com.app.model.support;

import com.kodemore.adaptor.KmAdaptorIF;

/**
 * I define an Address delegate that adapts a domain model. This allows
 * clients to work with an address, even though no such model exists
 * directly in the domain model.
 */
public class MyAddressDelegate<T>
    implements MyAddressIF
{
    //##################################################
    //# variables
    //##################################################

    private T _model;

    private KmAdaptorIF<T,String> _street1Adaptor;
    private KmAdaptorIF<T,String> _street2Adaptor;
    private KmAdaptorIF<T,String> _cityAdaptor;
    private KmAdaptorIF<T,String> _regionAdaptor;
    private KmAdaptorIF<T,String> _postalCodeAdaptor;
    private KmAdaptorIF<T,String> _countryAdaptor;

    //##################################################
    //# constructor
    //##################################################

    public MyAddressDelegate(
        T model,
        KmAdaptorIF<T,String> street1,
        KmAdaptorIF<T,String> street2,
        KmAdaptorIF<T,String> city,
        KmAdaptorIF<T,String> region,
        KmAdaptorIF<T,String> postalCode,
        KmAdaptorIF<T,String> country)
    {
        _model = model;
        _street1Adaptor = street1;
        _street2Adaptor = street2;
        _cityAdaptor = city;
        _regionAdaptor = region;
        _postalCodeAdaptor = postalCode;
        _countryAdaptor = country;
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getStreet1()
    {
        return _street1Adaptor.getValue(_model);
    }

    @Override
    public void setStreet1(String e)
    {
        _street1Adaptor.setValue(_model, e);
    }

    @Override
    public String getStreet2()
    {
        return _street2Adaptor.getValue(_model);
    }

    @Override
    public void setStreet2(String e)
    {
        _street2Adaptor.setValue(_model, e);
    }

    @Override
    public String getCity()
    {
        return _cityAdaptor.getValue(_model);
    }

    @Override
    public void setCity(String e)
    {
        _cityAdaptor.setValue(_model, e);
    }

    @Override
    public String getRegion()
    {
        return _regionAdaptor.getValue(_model);
    }

    @Override
    public void setRegion(String e)
    {
        _regionAdaptor.setValue(_model, e);
    }

    @Override
    public String getPostalCode()
    {
        return _postalCodeAdaptor.getValue(_model);
    }

    @Override
    public void setPostalCode(String e)
    {
        _postalCodeAdaptor.setValue(_model, e);
    }

    @Override
    public String getCountry()
    {
        return _countryAdaptor.getValue(_model);
    }

    @Override
    public void setCountry(String e)
    {
        _countryAdaptor.setValue(_model, e);
    }

}
