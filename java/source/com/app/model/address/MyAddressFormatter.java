package com.app.model.address;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

/**
 * I define methods used to format addresses.
 */
public abstract class MyAddressFormatter
{
    //##################################################
    //# public
    //##################################################

    /**
     * Format the address as a single line of text.
     * Only the street, city, and region (state) are included.
     */
    public static final String formatShortLine(MyAddressIF e)
    {
        if ( e == null || e.isEmpty() )
            return "";

        return joinWith(", ", e.getStreet1(), e.getCity(), e.getRegion());
    }

    /**
     * Format the address as a single line of text.
     * ALL non-empty fields are included.
     */
    public static final String formatLongLine(MyAddressIF e)
    {
        if ( e == null || e.isEmpty() )
            return "";

        return joinWith(
            ", ",
            formatAttention(e),
            e.getStreet1(),
            e.getStreet2(),
            e.getCity(),
            e.getRegion(),
            e.getPostalCode(),
            e.getCountry(),
            e.getPhone());
    }

    /**
     * Format the address for geocoding.
     * This returns a single line, with only the pertinent fields on it.
     */
    public static final String formatGeocodeLine(MyAddressIF e)
    {
        if ( e == null || e.isEmpty() )
            return "";

        return joinWith(
            ", ",
            e.getStreet1(),
            e.getCity(),
            e.getRegion(),
            e.getPostalCode(),
            e.getCountry());
    }

    /**
     * Format the address using multiple lines of text.
     * ALL non-empty fields are included.
     */
    public static final String formatMultiLine(MyAddressIF e)
    {
        if ( e == null || e.isEmpty() )
            return "";

        String regionPostal = joinWith(" ", e.getRegion(), e.getPostalCode());
        String cityLine = joinWith(", ", e.getCity(), regionPostal);

        KmList<String> lines;
        lines = new KmList<>();
        lines.addNonNull(formatAttention(e));
        lines.addNonNull(e.getStreet1());
        lines.addNonNull(e.getStreet2());

        if ( Kmu.hasValue(cityLine) )
            lines.add(cityLine);

        lines.addNonNull(e.getCountry());
        lines.addNonNull(e.getPhone());
        return lines.joinLines();
    }

    /**
     * Format the address using multiple lines of text formatted for html.
     * ALL non-empty fields are included.
     */
    public static final String formatMultiLineHtml(MyAddressIF e)
    {
        if ( e == null || e.isEmpty() )
            return "";

        String regionPostal = joinWith(" ", e.getRegion(), e.getPostalCode());
        String cityLine = joinWith(", ", e.getCity(), regionPostal);

        KmList<String> lines;
        lines = new KmList<>();
        lines.addNonNull(formatAttention(e));
        lines.addNonNull(e.getStreet1());
        lines.addNonNull(e.getStreet2());

        if ( Kmu.hasValue(cityLine) )
            lines.add(cityLine);

        lines.addNonNull(e.getCountry());
        lines.addNonNull(e.getPhone());

        return lines.join("<br>");
    }

    //##################################################
    //# support
    //##################################################

    private static String formatAttention(MyAddressIF e)
    {
        return e.hasAttention()
            ? "Attn: " + e.getAttention()
            : null;
    }

    //##################################################
    //# private
    //##################################################

    private static final String joinWith(String delimiter, String... values)
    {
        return KmList.createWith(values).select(e -> Kmu.hasValue(e)).join(delimiter);
    }
}
