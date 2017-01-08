//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import java.util.*;

import com.kodemore.collection.*;
import com.kodemore.exception.*;
import com.kodemore.servlet.encoder.*;
import com.kodemore.servlet.utility.*;
import com.kodemore.time.*;
import com.kodemore.types.*;
import com.kodemore.utility.*;

import com.app.model.*;
import com.app.model.core.*;
import com.app.model.meta.*;
import com.app.model.support.*;
import com.app.ui.dashboard.core.*;
import com.app.utility.*;

@SuppressWarnings("all")
public abstract class MyApplicationLogBase
    extends MyAbstractDomain
    implements MyUidDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaApplicationLog Meta = MyMetaApplicationLog.instance;
    public static final MyApplicationLogTools Tools = MyApplicationLogTools.instance;
    public static final MyApplicationLogValidator Validator = MyApplicationLogValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private KmTimestamp createdUtcTs;
    private String loggerName;
    private String context;
    private String message;
    private String levelName;
    private Integer levelCode;
    private String threadName;
    private String trace;

    //##################################################
    //# constructor
    //##################################################

    public MyApplicationLogBase()
    {
        super();
        setUid(newUid());
        setCreatedUtcTs(nowUtc());
    }

    //##################################################
    //# field (uid)
    //##################################################

    public String getUid()
    {
        return uid;
    }

    public void setUid(String e)
    {
        e = Validator.getUidValidator().convertOnly(e);
        uid = e;
    }

    public void clearUid()
    {
        setUid(null);
    }

    public boolean hasUid()
    {
        return Kmu.hasValue(getUid());
    }

    public boolean hasUid(String e)
    {
        return Kmu.isEqualIgnoreCase(getUid(), e);
    }

    public void truncateUid()
    {
        truncateUid(false);
    }

    public void truncateUid(boolean ellipses)
    {
        uid = Kmu.truncate(uid, 30, ellipses);
    }

    //##################################################
    //# field (createdUtcTs)
    //##################################################

    public KmTimestamp getCreatedUtcTs()
    {
        return createdUtcTs;
    }

    public void setCreatedUtcTs(KmTimestamp e)
    {
        e = Validator.getCreatedUtcTsValidator().convertOnly(e);
        createdUtcTs = e;
    }

    public void clearCreatedUtcTs()
    {
        setCreatedUtcTs(null);
    }

    public boolean hasCreatedUtcTs()
    {
        return getCreatedUtcTs() != null;
    }

    public boolean hasCreatedUtcTs(KmTimestamp e)
    {
        return Kmu.isEqual(getCreatedUtcTs(), e);
    }

    //##################################################
    //# field (loggerName)
    //##################################################

    public String getLoggerName()
    {
        return loggerName;
    }

    public void setLoggerName(String e)
    {
        e = Validator.getLoggerNameValidator().convertOnly(e);
        loggerName = e;
    }

    public void clearLoggerName()
    {
        setLoggerName(null);
    }

    public boolean hasLoggerName()
    {
        return Kmu.hasValue(getLoggerName());
    }

    public boolean hasLoggerName(String e)
    {
        return Kmu.isEqualIgnoreCase(getLoggerName(), e);
    }

    public void truncateLoggerName()
    {
        truncateLoggerName(false);
    }

    public void truncateLoggerName(boolean ellipses)
    {
        loggerName = Kmu.truncate(loggerName, 100, ellipses);
    }

    //##################################################
    //# field (context)
    //##################################################

    public String getContext()
    {
        return context;
    }

    public void setContext(String e)
    {
        e = Validator.getContextValidator().convertOnly(e);
        context = e;
    }

    public void clearContext()
    {
        setContext(null);
    }

    public boolean hasContext()
    {
        return Kmu.hasValue(getContext());
    }

    public boolean hasContext(String e)
    {
        return Kmu.isEqualIgnoreCase(getContext(), e);
    }

    public void truncateContext()
    {
        truncateContext(false);
    }

    public void truncateContext(boolean ellipses)
    {
        context = Kmu.truncate(context, 100, ellipses);
    }

    //##################################################
    //# field (message)
    //##################################################

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String e)
    {
        e = Validator.getMessageValidator().convertOnly(e);
        message = e;
    }

    public void clearMessage()
    {
        setMessage(null);
    }

    public boolean hasMessage()
    {
        return Kmu.hasValue(getMessage());
    }

    public boolean hasMessage(String e)
    {
        return Kmu.isEqualIgnoreCase(getMessage(), e);
    }

    public void truncateMessage()
    {
        truncateMessage(false);
    }

    public void truncateMessage(boolean ellipses)
    {
        message = Kmu.truncate(message, 100, ellipses);
    }

    //##################################################
    //# field (levelName)
    //##################################################

    public String getLevelName()
    {
        return levelName;
    }

    public void setLevelName(String e)
    {
        e = Validator.getLevelNameValidator().convertOnly(e);
        levelName = e;
    }

    public void clearLevelName()
    {
        setLevelName(null);
    }

    public boolean hasLevelName()
    {
        return Kmu.hasValue(getLevelName());
    }

    public boolean hasLevelName(String e)
    {
        return Kmu.isEqualIgnoreCase(getLevelName(), e);
    }

    public void truncateLevelName()
    {
        truncateLevelName(false);
    }

    public void truncateLevelName(boolean ellipses)
    {
        levelName = Kmu.truncate(levelName, 5, ellipses);
    }

    //##################################################
    //# field (levelCode)
    //##################################################

    public Integer getLevelCode()
    {
        return levelCode;
    }

    public void setLevelCode(Integer e)
    {
        e = Validator.getLevelCodeValidator().convertOnly(e);
        levelCode = e;
    }

    public void clearLevelCode()
    {
        setLevelCode(null);
    }

    public boolean hasLevelCode()
    {
        return getLevelCode() != null;
    }

    public boolean hasLevelCode(Integer e)
    {
        return Kmu.isEqual(getLevelCode(), e);
    }

    //##################################################
    //# field (threadName)
    //##################################################

    public String getThreadName()
    {
        return threadName;
    }

    public void setThreadName(String e)
    {
        e = Validator.getThreadNameValidator().convertOnly(e);
        threadName = e;
    }

    public void clearThreadName()
    {
        setThreadName(null);
    }

    public boolean hasThreadName()
    {
        return Kmu.hasValue(getThreadName());
    }

    public boolean hasThreadName(String e)
    {
        return Kmu.isEqualIgnoreCase(getThreadName(), e);
    }

    public void truncateThreadName()
    {
        truncateThreadName(false);
    }

    public void truncateThreadName(boolean ellipses)
    {
        threadName = Kmu.truncate(threadName, 100, ellipses);
    }

    //##################################################
    //# field (trace)
    //##################################################

    public String getTrace()
    {
        return trace;
    }

    public void setTrace(String e)
    {
        e = Validator.getTraceValidator().convertOnly(e);
        trace = e;
    }

    public void clearTrace()
    {
        setTrace(null);
    }

    public boolean hasTrace()
    {
        return Kmu.hasValue(getTrace());
    }

    public boolean hasTrace(String e)
    {
        return Kmu.isEqualIgnoreCase(getTrace(), e);
    }

    public void truncateTrace()
    {
        truncateTrace(false);
    }

    public void truncateTrace(boolean ellipses)
    {
        trace = Kmu.truncate(trace, 50000, ellipses);
    }

    //##################################################
    //# field (levelCodeName)
    //##################################################

    public abstract String getLevelCodeName();

    public boolean hasLevelCodeName()
    {
        return Kmu.hasValue(getLevelCodeName());
    }

    public boolean hasLevelCodeName(String e)
    {
        return Kmu.isEqualIgnoreCase(getLevelCodeName(), e);
    }

    //##################################################
    //# field (displayString)
    //##################################################

    public abstract String getDisplayString();

    public boolean hasDisplayString()
    {
        return Kmu.hasValue(getDisplayString());
    }

    public boolean hasDisplayString(String e)
    {
        return Kmu.isEqualIgnoreCase(getDisplayString(), e);
    }

    //##################################################
    //# field (createdLocalTs)
    //##################################################

    public final KmTimestamp getCreatedLocalTs()
    {
        return KmTimestampUtility.toLocal(getCreatedUtcTs());
    }

    public boolean hasCreatedLocalTs()
    {
        return getCreatedLocalTs() != null;
    }

    public boolean hasCreatedLocalTs(KmTimestamp e)
    {
        return Kmu.isEqual(getCreatedLocalTs(), e);
    }

    //##################################################
    //# field (createdLocalTsMessage)
    //##################################################

    public final String getCreatedLocalTsMessage()
    {
        return KmTimestampUtility.formatLocalMessage(getCreatedUtcTs());
    }

    public boolean hasCreatedLocalTsMessage()
    {
        return Kmu.hasValue(getCreatedLocalTsMessage());
    }

    public boolean hasCreatedLocalTsMessage(String e)
    {
        return Kmu.isEqualIgnoreCase(getCreatedLocalTsMessage(), e);
    }

    //##################################################
    //# field (createdLocalDate)
    //##################################################

    public final KmDate getCreatedLocalDate()
    {
        return KmTimestampUtility.getDate(getCreatedLocalTs());
    }

    public boolean hasCreatedLocalDate()
    {
        return getCreatedLocalDate() != null;
    }

    public boolean hasCreatedLocalDate(KmDate e)
    {
        return Kmu.isEqual(getCreatedLocalDate(), e);
    }

    //##################################################
    //# field (createdLocalTime)
    //##################################################

    public final KmTime getCreatedLocalTime()
    {
        return KmTimestampUtility.getTime(getCreatedLocalTs());
    }

    public boolean hasCreatedLocalTime()
    {
        return getCreatedLocalTime() != null;
    }

    public boolean hasCreatedLocalTime(KmTime e)
    {
        return Kmu.isEqual(getCreatedLocalTime(), e);
    }


    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyApplicationLog)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyApplicationLog)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyApplicationLog)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyApplicationLog getCopy()
    {
        return (MyApplicationLog)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = newUid();
    }

    /**
     * Get a copy of this model without any associations or collections.
     * The primary key and lock version are not copied.
     * The basic timestamps are reset.
     */
    public final MyApplicationLog getBasicCopy()
    {
        MyApplicationLog e;
        e = new MyApplicationLog();
        e.setCreatedUtcTs(getCreatedUtcTs());
        e.setLoggerName(getLoggerName());
        e.setContext(getContext());
        e.setMessage(getMessage());
        e.setLevelName(getLevelName());
        e.setLevelCode(getLevelCode());
        e.setThreadName(getThreadName());
        e.setTrace(getTrace());
        return e;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyApplicationLogBase) )
            return false;

        MyApplicationLogBase e = (MyApplicationLogBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyApplicationLog e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyApplicationLog e)
    {
        if ( !Kmu.isEqual(getCreatedUtcTs(), e.getCreatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getLoggerName(), e.getLoggerName()) ) return false;
        if ( !Kmu.isEqual(getContext(), e.getContext()) ) return false;
        if ( !Kmu.isEqual(getMessage(), e.getMessage()) ) return false;
        if ( !Kmu.isEqual(getLevelName(), e.getLevelName()) ) return false;
        if ( !Kmu.isEqual(getLevelCode(), e.getLevelCode()) ) return false;
        if ( !Kmu.isEqual(getThreadName(), e.getThreadName()) ) return false;
        if ( !Kmu.isEqual(getTrace(), e.getTrace()) ) return false;
        if ( !Kmu.isEqual(getLevelCodeName(), e.getLevelCodeName()) ) return false;
        if ( !Kmu.isEqual(getDisplayString(), e.getDisplayString()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTs(), e.getCreatedLocalTs()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTsMessage(), e.getCreatedLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalDate(), e.getCreatedLocalDate()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTime(), e.getCreatedLocalTime()) ) return false;
        return true;
    }

    public boolean isDifferent(MyApplicationLog e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyApplicationLog e)
    {
        return !isSameIgnoringKey(e);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        StringBuilder out;
        out = new StringBuilder();
        out.append("MyApplicationLog");
        out.append("(");
        out.append("Uid=");
        out.append(uid);
        out.append(")");
        return out.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    Uid = " + uid);
        System.out.println("    CreatedUtcTs = " + createdUtcTs);
        System.out.println("    LoggerName = " + loggerName);
        System.out.println("    Context = " + context);
        System.out.println("    Message = " + message);
        System.out.println("    LevelName = " + levelName);
        System.out.println("    LevelCode = " + levelCode);
        System.out.println("    ThreadName = " + threadName);
        System.out.println("    Trace = " + trace);
    }

    /**
     * Format the primary key fields in a comma separated list.  The format
     * is intended to be suitable for display to users.
     */
    @Override
    public String formatPrimaryKey()
    {
        return uid;
    }


    //##################################################
    //# convenience
    //##################################################

    @Override
    public String getMetaName()
    {
        return Meta.getName();
    }

}
