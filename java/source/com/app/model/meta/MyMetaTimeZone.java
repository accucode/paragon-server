//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.kodemore.meta.KmMetaModel;

import com.app.model.MyTimeZoneValidator;

public class MyMetaTimeZone
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaTimeZone instance = new MyMetaTimeZone();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaTimeZone()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "timeZone";
    }

    public static MyTimeZoneValidator getValidator()
    {
        return MyTimeZoneValidator.instance;
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaTimeZone_Code Code = new MyMetaTimeZone_Code();
    public static final MyMetaTimeZone_Name Name = new MyMetaTimeZone_Name();
    public static final MyMetaTimeZone_UtcOffsetMinutes UtcOffsetMinutes = new MyMetaTimeZone_UtcOffsetMinutes();
    public static final MyMetaTimeZone_DstCode DstCode = new MyMetaTimeZone_DstCode();
    public static final MyMetaTimeZone_DstOffsetMinutes DstOffsetMinutes = new MyMetaTimeZone_DstOffsetMinutes();
    public static final MyMetaTimeZone_DstStartMonth DstStartMonth = new MyMetaTimeZone_DstStartMonth();
    public static final MyMetaTimeZone_DstStartDay DstStartDay = new MyMetaTimeZone_DstStartDay();
    public static final MyMetaTimeZone_DstEndMonth DstEndMonth = new MyMetaTimeZone_DstEndMonth();
    public static final MyMetaTimeZone_DstEndDay DstEndDay = new MyMetaTimeZone_DstEndDay();

    //##################################################
    //# associations
    //##################################################

}
