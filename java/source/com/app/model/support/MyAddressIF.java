package com.app.model.support;

/**
 * I define common methods for a street address.  This project
 * generally embeds the address fields directly into the containing model.
 * In other words, there is no table called "Address" but instead the Site
 * table contains fields for street, city, etc.
 *
 * However, there are many circumstances where it is convenience for the
 * application to work with an address object and this interface helps to
 * support that.
 */
public interface MyAddressIF
{
    String getStreet1();

    void setStreet1(String e);

    String getStreet2();

    void setStreet2(String e);

    String getCity();

    void setCity(String e);

    String getRegion();

    void setRegion(String e);

    String getPostalCode();

    void setPostalCode(String e);

    String getCountry();

    void setCountry(String e);
}
