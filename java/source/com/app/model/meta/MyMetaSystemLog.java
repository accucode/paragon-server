//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import com.app.model.MySystemLogValidator;

import com.kodemore.meta.KmMetaModel;

public class MyMetaSystemLog
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaSystemLog instance = new MyMetaSystemLog();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaSystemLog()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "systemLog";
    }

    public static MySystemLogValidator getValidator()
    {
        return MySystemLogValidator.instance;
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaSystemLog_Id Id = new MyMetaSystemLog_Id();
    public static final MyMetaSystemLog_CreatedUtcTs CreatedUtcTs = new MyMetaSystemLog_CreatedUtcTs();
    public static final MyMetaSystemLog_LoggerName LoggerName = new MyMetaSystemLog_LoggerName();
    public static final MyMetaSystemLog_Context Context = new MyMetaSystemLog_Context();
    public static final MyMetaSystemLog_Message Message = new MyMetaSystemLog_Message();
    public static final MyMetaSystemLog_LevelName LevelName = new MyMetaSystemLog_LevelName();
    public static final MyMetaSystemLog_LevelCode LevelCode = new MyMetaSystemLog_LevelCode();
    public static final MyMetaSystemLog_ThreadName ThreadName = new MyMetaSystemLog_ThreadName();
    public static final MyMetaSystemLog_ExceptionText ExceptionText = new MyMetaSystemLog_ExceptionText();
    public static final MyMetaSystemLog_FullTrace FullTrace = new MyMetaSystemLog_FullTrace();
    public static final MyMetaSystemLog_LevelCodeName LevelCodeName = new MyMetaSystemLog_LevelCodeName();
    public static final MyMetaSystemLog_CreatedLocalTs CreatedLocalTs = new MyMetaSystemLog_CreatedLocalTs();
    public static final MyMetaSystemLog_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaSystemLog_CreatedLocalTsMessage();
    public static final MyMetaSystemLog_CreatedLocalDate CreatedLocalDate = new MyMetaSystemLog_CreatedLocalDate();
    public static final MyMetaSystemLog_CreatedLocalTime CreatedLocalTime = new MyMetaSystemLog_CreatedLocalTime();

    //##################################################
    //# associations
    //##################################################

}
