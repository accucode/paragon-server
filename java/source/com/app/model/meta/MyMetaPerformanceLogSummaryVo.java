//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.model.MyPerformanceLogSummaryVoValidator;

import com.kodemore.meta.KmMetaModel;

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
