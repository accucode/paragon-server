package com.kodemore.property.type;

import com.kodemore.collection.KmMap;

public class KmPropertyTypes
{
    //##################################################
    //# constants
    //##################################################

    public static final KmPropertyTypeIF TYPE_BOOLEAN                  = new KmPropertyTypeBoolean();
    public static final KmPropertyTypeIF TYPE_DOUBLE                   = new KmPropertyTypeDouble();
    public static final KmPropertyTypeIF TYPE_INTEGER                  = new KmPropertyTypeInteger();
    public static final KmPropertyTypeIF TYPE_INTEGER_0_100            = new KmPropertyTypeInteger0to100();
    public static final KmPropertyTypeIF TYPE_INTEGER_0_1000           = new KmPropertyTypeInteger0to1000();
    public static final KmPropertyTypeIF TYPE_INTEGER_1_100            = new KmPropertyTypeInteger1to100();
    public static final KmPropertyTypeIF TYPE_POSITIVE_INTEGER         = new KmPropertyTypePositiveInteger();
    public static final KmPropertyTypeIF TYPE_REQUIRED_STRING          = new KmPropertyTypeRequiredString();
    public static final KmPropertyTypeIF TYPE_STRING                   = new KmPropertyTypeString();
    public static final KmPropertyTypeIF TYPE_STRING_LIST              = new KmPropertyTypeStringList();
    public static final KmPropertyTypeIF TYPE_TIME_24_HHMM             = new KmPropertyTypeTime24hhmm();
    public static final KmPropertyTypeIF TYPE_TIME_ZONE_OFFSET_MINUTES = new KmPropertyTypeTimeZoneOffsetMinutes();

    //##################################################
    //# accessing
    //##################################################

    public static KmPropertyTypeIF getType(String key)
    {
        if ( _types == null )
            install();
        return _types.get(key);
    }

    //##################################################
    //# private
    //##################################################

    private static KmMap<String,KmPropertyTypeIF> _types;

    private synchronized static void install()
    {
        if ( _types != null )
            return;

        _types = new KmMap<>();
        add(TYPE_BOOLEAN);
        add(TYPE_DOUBLE);
        add(TYPE_INTEGER);
        add(TYPE_INTEGER_0_100);
        add(TYPE_INTEGER_0_1000);
        add(TYPE_INTEGER_1_100);
        add(TYPE_POSITIVE_INTEGER);
        add(TYPE_REQUIRED_STRING);
        add(TYPE_STRING_LIST);
        add(TYPE_STRING);
        add(TYPE_TIME_24_HHMM);
        add(TYPE_TIME_ZONE_OFFSET_MINUTES);
    }

    private static void add(KmPropertyTypeIF e)
    {
        _types.put(e.getName(), e);
    }

}
