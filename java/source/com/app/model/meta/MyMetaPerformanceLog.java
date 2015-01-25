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

public class MyMetaPerformanceLog
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaPerformanceLog instance = new MyMetaPerformanceLog();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaPerformanceLog()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "performanceLog";
    }

    public static MyPerformanceLogValidator getValidator()
    {
        return MyPerformanceLogValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "A log for performance metrics.  We track a number of performance metrics on the active\nsystem.  This is primarily used as a tool in production to identify hotspots that may\nrequire tuning and optimization.  Some care needs to be taken to avoid enabling so many\nmetrics that they the performance logging itself becomes a bottleneck.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaPerformanceLog_Id Id = new MyMetaPerformanceLog_Id();
    public static final MyMetaPerformanceLog_Name Name = new MyMetaPerformanceLog_Name();
    public static final MyMetaPerformanceLog_CreatedUtcTs CreatedUtcTs = new MyMetaPerformanceLog_CreatedUtcTs();
    public static final MyMetaPerformanceLog_DurationMs DurationMs = new MyMetaPerformanceLog_DurationMs();
    public static final MyMetaPerformanceLog_CreatedLocalTs CreatedLocalTs = new MyMetaPerformanceLog_CreatedLocalTs();
    public static final MyMetaPerformanceLog_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaPerformanceLog_CreatedLocalTsMessage();
    public static final MyMetaPerformanceLog_CreatedLocalDate CreatedLocalDate = new MyMetaPerformanceLog_CreatedLocalDate();
    public static final MyMetaPerformanceLog_CreatedLocalTime CreatedLocalTime = new MyMetaPerformanceLog_CreatedLocalTime();

    //##################################################
    //# associations
    //##################################################

}
