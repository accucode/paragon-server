package com.kodemore.authnet;

public class KmAuthnetConfiguration
{
    //##################################################
    //# constants
    //##################################################

    private static final String SCHEME = "https://";
    private static final String PATH   = "/xml/v1/request.api";

    private static final String TEST_DOMAIN       = "apitest.authorize.net";
    private static final String PRODUCTION_DOMAIN = "api.authorize.net";

    private static final String TEST_URL       = SCHEME + TEST_DOMAIN + PATH;
    private static final String PRODUCTION_URL = SCHEME + PRODUCTION_DOMAIN + PATH;

    //##################################################
    //# variables
    //##################################################

    private static boolean _usesProductionUrl = false;

    //##################################################
    //# accessing
    //##################################################

    public static void useProductionUrl()
    {
        useProductionUrl(true);
    }

    public static void useTestUrl()
    {
        useProductionUrl(false);
    }

    public static void useProductionUrl(boolean e)
    {
        _usesProductionUrl = e;
    }

    //##################################################
    //# url
    //##################################################

    public static String getUrl()
    {
        return _usesProductionUrl
            ? PRODUCTION_URL
            : TEST_URL;
    }

    public static String getDomain()
    {
        return _usesProductionUrl
            ? PRODUCTION_DOMAIN
            : TEST_DOMAIN;
    }

}
