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

public class MyMetaPerformanceLogDetail
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaPerformanceLogDetail instance = new MyMetaPerformanceLogDetail();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaPerformanceLogDetail()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "performanceLogDetail";
    }

    public static MyPerformanceLogDetailValidator getValidator()
    {
        return MyPerformanceLogDetailValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "A log for performance metrics.  We track a number of performance metrics on the active system.  This is primarily used as a tool in production to identify hotspots that may require tuning and optimization.  Some care needs to be taken to avoid enabling so many metrics that the performance logging itself becomes a bottleneck.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaPerformanceLogDetail_Uid Uid = new MyMetaPerformanceLogDetail_Uid();
    public static final MyMetaPerformanceLogDetail_Name Name = new MyMetaPerformanceLogDetail_Name();
    public static final MyMetaPerformanceLogDetail_CreatedUtcTs CreatedUtcTs = new MyMetaPerformanceLogDetail_CreatedUtcTs();
    public static final MyMetaPerformanceLogDetail_DurationMs DurationMs = new MyMetaPerformanceLogDetail_DurationMs();
    public static final MyMetaPerformanceLogDetail_CreatedLocalTs CreatedLocalTs = new MyMetaPerformanceLogDetail_CreatedLocalTs();
    public static final MyMetaPerformanceLogDetail_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaPerformanceLogDetail_CreatedLocalTsMessage();
    public static final MyMetaPerformanceLogDetail_CreatedLocalDate CreatedLocalDate = new MyMetaPerformanceLogDetail_CreatedLocalDate();
    public static final MyMetaPerformanceLogDetail_CreatedLocalTime CreatedLocalTime = new MyMetaPerformanceLogDetail_CreatedLocalTime();

    //##################################################
    //# associations
    //##################################################

}
