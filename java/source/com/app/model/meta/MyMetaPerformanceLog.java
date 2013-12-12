//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.kodemore.meta.KmMetaModel;

import com.app.model.MyPerformanceLogValidator;

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
