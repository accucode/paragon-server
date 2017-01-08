package com.app.model;

import com.kodemore.utility.Kmu;

/**
 * Convenience tools for working with Ship Carriers and formatting tracking urls.
 *
 * The tracking url templates were found at http://eshipguy.com/tracking/
 */
public class MyTrackingNumberUtility
{
    //##################################################
    //# carriers
    //##################################################

    public enum Carrier
    {
        FEDEX,
        UPS;
    }

    //##################################################
    //# constants
    //##################################################

    private static final String FEDEX_URL_TEMPLATE = "http://www.fedex.com/Tracking?tracknumbers=%s";
    private static final String UPS_URL_TEMPLATE   = "http://wwwapps.ups.com/WebTracking/track?track=yes&trackNums=%s";

    //##################################################
    //# variables
    //##################################################

    private Carrier             _carrier;
    private String              _trackingNumber;

    //##################################################
    //# accessing
    //##################################################

    public Carrier getCarrier()
    {
        return _carrier;
    }

    public void setCarrier(Carrier e)
    {
        _carrier = e;
    }

    public void setCarrierFedex()
    {
        setCarrier(Carrier.FEDEX);
    }

    public void setCarrierUps()
    {
        setCarrier(Carrier.UPS);
    }

    //##################################################
    //# tracking number
    //##################################################

    public String getTrackingNumber()
    {
        return _trackingNumber;
    }

    public void setTrackingNumber(String e)
    {
        _trackingNumber = e;
    }

    //##################################################
    //# url template
    //##################################################

    private String getUrlTemplate()
    {
        Carrier carrier = getCarrier();

        if ( carrier == null )
            return null;

        switch ( carrier )
        {
            case FEDEX:
                return FEDEX_URL_TEMPLATE;

            case UPS:
                return UPS_URL_TEMPLATE;
        }

        throw Kmu.newFatal("Unhandled Carrier: %s", carrier);
    }

    //##################################################
    //# format
    //##################################################

    public String formatTrackingUrl()
    {
        String tn = getTrackingNumber();
        if ( Kmu.isEmpty(tn) )
            return null;

        String template = getUrlTemplate();
        if ( template == null )
            return null;

        return Kmu.format(template, tn);
    }

    //##################################################
    //# tracking url
    //##################################################

    public static String formatTrackingUrlFor(String trackingNumber)
    {
        String s = trackingNumber;

        if ( Kmu.isEmpty(s) )
            return null;

        s = s.trim();
        if ( s.length() == 0 )
            return null;

        if ( isLikelyUpsTracking(s) )
            return formatUpsTrackingUrlFor(s);

        if ( isLikelyFedExTracking(s) )
            return formatFedexTrackingUrlFor(s);

        return null;
    }

    public static String formatFedexTrackingUrlFor(String trackingNumber)
    {
        MyTrackingNumberUtility u;
        u = new MyTrackingNumberUtility();
        u.setCarrierFedex();
        u.setTrackingNumber(trackingNumber);
        return u.formatTrackingUrl();
    }

    public static String formatUpsTrackingUrlFor(String trackingNumber)
    {
        MyTrackingNumberUtility u;
        u = new MyTrackingNumberUtility();
        u.setCarrierUps();
        u.setTrackingNumber(trackingNumber);
        return u.formatTrackingUrl();
    }

    //##################################################
    //# utility
    //##################################################

    /**
     * Determine if the string is likely a UPS tracking number.
     * This is not guaranteed, but it is a helpful indicator for
     * the more common formats.
     * http://www.trackingex.com/ups-tracking/
     */
    public static boolean isLikelyUpsTracking(String s)
    {
        if ( s == null )
            return false;

        if ( s.length() != 18 )
            return false;

        if ( !Kmu.isAllAlphaNumeric(s) )
            return false;

        return s.toUpperCase().startsWith("1Z");
    }

    /**
     * Determine if the string is likely a UPS tracking number.
     * This is not guaranteed, but it is a helpful indicator for
     * the more common formats.
     * http://www.trackingex.com/fedex-tracking/
     */
    public static boolean isLikelyFedExTracking(String s)
    {
        if ( s == null )
            return false;

        int n = s.length();
        boolean allDigits = Kmu.isAllDigits(s);

        if ( n == 12 && allDigits )
            return true;

        if ( n == 15 && allDigits )
            return true;

        if ( n >= 30 && allDigits )
            return true;

        return false;
    }
}
