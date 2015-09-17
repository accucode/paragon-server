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

public class MyMetaPerformanceLogSummaryVo
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaPerformanceLogSummaryVo instance = new MyMetaPerformanceLogSummaryVo();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaPerformanceLogSummaryVo()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "performanceLogSummaryVo";
    }

    public static MyPerformanceLogSummaryVoValidator getValidator()
    {
        return MyPerformanceLogSummaryVoValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "Used to present summary information about performance logs.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaPerformanceLogSummaryVo_Name Name = new MyMetaPerformanceLogSummaryVo_Name();
    public static final MyMetaPerformanceLogSummaryVo_Count Count = new MyMetaPerformanceLogSummaryVo_Count();
    public static final MyMetaPerformanceLogSummaryVo_MinimumMs MinimumMs = new MyMetaPerformanceLogSummaryVo_MinimumMs();
    public static final MyMetaPerformanceLogSummaryVo_MaximumMs MaximumMs = new MyMetaPerformanceLogSummaryVo_MaximumMs();
    public static final MyMetaPerformanceLogSummaryVo_AverageMs AverageMs = new MyMetaPerformanceLogSummaryVo_AverageMs();
    public static final MyMetaPerformanceLogSummaryVo_TotalMs TotalMs = new MyMetaPerformanceLogSummaryVo_TotalMs();

    //##################################################
    //# associations
    //##################################################

}
