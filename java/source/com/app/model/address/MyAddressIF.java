package com.app.model.address;

import com.kodemore.utility.Kmu;

/**
 * I define common methods for a street address.  This project
 * generally embeds the address fields directly into each model.
 * In other words, there is no table called "Address" but instead
 * the Site table contains fields for street, city, etc.
 *
 * However, there are many circumstances where it is convenient for the
 * application to work with an address object and this interface helps to
 * support that.
 */
public interface MyAddressIF
{
    //##################################################
    //# street 1
    //##################################################

    String getStreet1();

    void setStreet1(String e);

    default boolean hasStreet1()
    {
        return Kmu.hasValue(getStreet1());
    }

    //##################################################
    //# street 2
    //##################################################

    String getStreet2();

    void setStreet2(String e);

    default boolean hasStreet2()
    {
        return Kmu.hasValue(getStreet2());
    }

    //##################################################
    //# city
    //##################################################

    String getCity();

    void setCity(String e);

    default boolean hasCity()
    {
        return Kmu.hasValue(getCity());
    }

    //##################################################
    //# region
    //##################################################

    String getRegion();

    void setRegion(String e);

    default boolean hasRegion()
    {
        return Kmu.hasValue(getRegion());
    }

    //##################################################
    //# postal code
    //##################################################

    String getPostalCode();

    void setPostalCode(String e);

    default boolean hasPostalCode()
    {
        return Kmu.hasValue(getPostalCode());
    }

    //##################################################
    //# country
    //##################################################

    String getCountry();

    void setCountry(String e);

    default boolean hasCountry()
    {
        return Kmu.hasValue(getCountry());
    }

    //##################################################
    //# attention
    //##################################################

    String getAttention();

    void setAttention(String e);

    default boolean hasAttention()
    {
        return Kmu.hasValue(getAttention());
    }

    //##################################################
    //# phone
    //##################################################

    String getPhone();

    void setPhone(String e);

    default boolean hasPhone()
    {
        return Kmu.hasValue(getPhone());
    }

    //##################################################
    //# apply
    //##################################################

    default void applyFrom(MyAddressIF e)
    {
        if ( e == null )
        {
            setStreet1(null);
            setStreet2(null);
            setCity(null);
            setRegion(null);
            setPostalCode(null);
            setCountry(null);
            setAttention(null);
            setPhone(null);
            return;
        }

        setStreet1(e.getStreet1());
        setStreet2(e.getStreet2());
        setCity(e.getCity());
        setRegion(e.getRegion());
        setPostalCode(e.getPostalCode());
        setCountry(e.getCountry());
        setAttention(e.getAttention());
        setPhone(e.getPhone());
    }

    //##################################################
    //# testing
    //##################################################

    default boolean hasValue()
    {
        return hasStreet1()
            || hasStreet2()
            || hasCity()
            || hasRegion()
            || hasPostalCode()
            || hasCountry()
            || hasAttention()
            || hasPhone();
    }

    default boolean isEmpty()
    {
        return !hasValue();
    }

    //##################################################
    //# format
    //##################################################

    default String formatShortLine()
    {
        return MyAddressFormatter.formatShortLine(this);
    }

    default String formatLongLine()
    {
        return MyAddressFormatter.formatLongLine(this);
    }

    default String formatGeocodeLine()
    {
        return MyAddressFormatter.formatGeocodeLine(this);
    }

    default String formatMultiLine()
    {
        return MyAddressFormatter.formatMultiLine(this);
    }

    default String formatMultiLineHtml()
    {
        return MyAddressFormatter.formatMultiLineHtml(this);
    }

    //##################################################
    //# testing
    //##################################################

    default boolean matches(MyAddressIF e)
    {
        if ( e == null )
            return false;

        return Kmu.isEqual(getStreet1(), e.getStreet1())
            && Kmu.isEqual(getStreet2(), e.getStreet2())
            && Kmu.isEqual(getCity(), e.getCity())
            && Kmu.isEqual(getRegion(), e.getRegion())
            && Kmu.isEqual(getPostalCode(), e.getPostalCode())
            && Kmu.isEqual(getCountry(), e.getCountry())
            && Kmu.isEqual(getAttention(), e.getAttention())
            && Kmu.isEqual(getPhone(), e.getPhone());
    }
}
