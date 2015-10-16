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

public class MyMetaApplicationLog
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaApplicationLog instance = new MyMetaApplicationLog();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaApplicationLog()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "applicationLog";
    }

    public static MyApplicationLogValidator getValidator()
    {
        return MyApplicationLogValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "Used to persist log4j events with a custom appender. In general, everything that would normally be logged with log4j is echoed here.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaApplicationLog_Uid Uid = new MyMetaApplicationLog_Uid();
    public static final MyMetaApplicationLog_CreatedUtcTs CreatedUtcTs = new MyMetaApplicationLog_CreatedUtcTs();
    public static final MyMetaApplicationLog_LoggerName LoggerName = new MyMetaApplicationLog_LoggerName();
    public static final MyMetaApplicationLog_Context Context = new MyMetaApplicationLog_Context();
    public static final MyMetaApplicationLog_Message Message = new MyMetaApplicationLog_Message();
    public static final MyMetaApplicationLog_LevelName LevelName = new MyMetaApplicationLog_LevelName();
    public static final MyMetaApplicationLog_LevelCode LevelCode = new MyMetaApplicationLog_LevelCode();
    public static final MyMetaApplicationLog_ThreadName ThreadName = new MyMetaApplicationLog_ThreadName();
    public static final MyMetaApplicationLog_Trace Trace = new MyMetaApplicationLog_Trace();
    public static final MyMetaApplicationLog_LevelCodeName LevelCodeName = new MyMetaApplicationLog_LevelCodeName();
    public static final MyMetaApplicationLog_CreatedLocalTs CreatedLocalTs = new MyMetaApplicationLog_CreatedLocalTs();
    public static final MyMetaApplicationLog_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaApplicationLog_CreatedLocalTsMessage();
    public static final MyMetaApplicationLog_CreatedLocalDate CreatedLocalDate = new MyMetaApplicationLog_CreatedLocalDate();
    public static final MyMetaApplicationLog_CreatedLocalTime CreatedLocalTime = new MyMetaApplicationLog_CreatedLocalTime();

    //##################################################
    //# associations
    //##################################################

}
