//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import java.util.*;

import com.kodemore.collection.*;
import com.kodemore.exception.*;
import com.kodemore.meta.*;
import com.kodemore.servlet.encoder.*;
import com.kodemore.servlet.field.*;
import com.kodemore.time.*;
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.model.*;
import com.app.model.core.*;
import com.app.utility.*;

public class MyMetaTimeZoneVo
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaTimeZoneVo instance = new MyMetaTimeZoneVo();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaTimeZoneVo()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "timeZoneVo";
    }

    public static MyTimeZoneVoValidator getValidator()
    {
        return MyTimeZoneVoValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "The time zones supported by this application. Ideally, this should be replaced by a more modern and dynamic time zone mechanism.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaTimeZoneVo_Code Code = new MyMetaTimeZoneVo_Code();
    public static final MyMetaTimeZoneVo_Name Name = new MyMetaTimeZoneVo_Name();
    public static final MyMetaTimeZoneVo_UtcOffsetMinutes UtcOffsetMinutes = new MyMetaTimeZoneVo_UtcOffsetMinutes();
    public static final MyMetaTimeZoneVo_DstCode DstCode = new MyMetaTimeZoneVo_DstCode();
    public static final MyMetaTimeZoneVo_DstOffsetMinutes DstOffsetMinutes = new MyMetaTimeZoneVo_DstOffsetMinutes();
    public static final MyMetaTimeZoneVo_DstStartMonth DstStartMonth = new MyMetaTimeZoneVo_DstStartMonth();
    public static final MyMetaTimeZoneVo_DstStartDay DstStartDay = new MyMetaTimeZoneVo_DstStartDay();
    public static final MyMetaTimeZoneVo_DstEndMonth DstEndMonth = new MyMetaTimeZoneVo_DstEndMonth();
    public static final MyMetaTimeZoneVo_DstEndDay DstEndDay = new MyMetaTimeZoneVo_DstEndDay();

    //##################################################
    //# associations
    //##################################################

}
