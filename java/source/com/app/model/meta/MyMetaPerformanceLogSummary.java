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

public class MyMetaPerformanceLogSummary
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaPerformanceLogSummary instance = new MyMetaPerformanceLogSummary();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaPerformanceLogSummary()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "performanceLogSummary";
    }

    public MyPerformanceLogSummaryValidator getValidator()
    {
        return MyPerformanceLogSummaryValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "A daily summary of the performance logs.  The logs for each day are grouped by name stored with various aggregates such as the min, max, and average durations.  Although the individual performance logs are automatically deleted (after a ~week), these daily summary logs are kept indefinitely for long term reporting.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaPerformanceLogSummary_Uid Uid = new MyMetaPerformanceLogSummary_Uid();
    public static final MyMetaPerformanceLogSummary_UtcDate UtcDate = new MyMetaPerformanceLogSummary_UtcDate();
    public static final MyMetaPerformanceLogSummary_Name Name = new MyMetaPerformanceLogSummary_Name();
    public static final MyMetaPerformanceLogSummary_Count Count = new MyMetaPerformanceLogSummary_Count();
    public static final MyMetaPerformanceLogSummary_MinimumMs MinimumMs = new MyMetaPerformanceLogSummary_MinimumMs();
    public static final MyMetaPerformanceLogSummary_MaximumMs MaximumMs = new MyMetaPerformanceLogSummary_MaximumMs();
    public static final MyMetaPerformanceLogSummary_AverageMs AverageMs = new MyMetaPerformanceLogSummary_AverageMs();
    public static final MyMetaPerformanceLogSummary_TotalMs TotalMs = new MyMetaPerformanceLogSummary_TotalMs();
    public static final MyMetaPerformanceLogSummary_DisplayString DisplayString = new MyMetaPerformanceLogSummary_DisplayString();

    //##################################################
    //# associations
    //##################################################

}
