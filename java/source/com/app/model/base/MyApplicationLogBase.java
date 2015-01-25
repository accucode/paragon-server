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
import com.app.utility.*;

public abstract class MyApplicationLogBase
    extends MyAbstractDomain
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

    private Integer id;
    private KmTimestamp createdUtcTs;
    private String loggerName;
    private String context;
    private String message;
    private String levelName;
    private Integer levelCode;
    private String threadName;
    private String exceptionText;
    private List<MyApplicationLogTrace> traces;

    //##################################################
    //# constructor
    //##################################################

    public MyApplicationLogBase()
    {
        super();
        setCreatedUtcTs(getNowUtc());
        traces = new ArrayList<>();
    }

    //##################################################
    //# field (id)
    //##################################################

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer e)
    {
        checkReadOnly();
        e = Validator.getIdValidator().convertOnly(e);
        id = e;
    }

    public void clearId()
    {
        setId(null);
    }

    public boolean hasId()
    {
        return getId() != null;
    }

    public boolean hasId(Integer e)
    {
        return Kmu.isEqual(getId(), e);
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
        checkReadOnly();
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
        checkReadOnly();
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
        checkReadOnly();
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
        checkReadOnly();
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
        checkReadOnly();
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
        checkReadOnly();
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
        checkReadOnly();
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
    //# field (exceptionText)
    //##################################################

    public String getExceptionText()
    {
        return exceptionText;
    }

    public void setExceptionText(String e)
    {
        checkReadOnly();
        e = Validator.getExceptionTextValidator().convertOnly(e);
        exceptionText = e;
    }

    public void clearExceptionText()
    {
        setExceptionText(null);
    }

    public boolean hasExceptionText()
    {
        return Kmu.hasValue(getExceptionText());
    }

    public boolean hasExceptionText(String e)
    {
        return Kmu.isEqualIgnoreCase(getExceptionText(), e);
    }

    public void truncateExceptionText()
    {
        truncateExceptionText(false);
    }

    public void truncateExceptionText(boolean ellipses)
    {
        exceptionText = Kmu.truncate(exceptionText, 100, ellipses);
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
    //# field (fullTrace)
    //##################################################

    public abstract String getFullTrace();

    public boolean hasFullTrace()
    {
        return Kmu.hasValue(getFullTrace());
    }

    public boolean hasFullTrace(String e)
    {
        return Kmu.isEqualIgnoreCase(getFullTrace(), e);
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
    //# Traces (collection)
    //##################################################

    public KmCollection<MyApplicationLogTrace> getTraces()
    {
        return new KmHibernateCollection<>(
            getBaseTraces(),
            (MyApplicationLog)this,
            MyApplicationLogTrace.Meta.Log.getAdaptor());
    }

    public KmList<MyApplicationLogTrace> getSortedTraces()
    {
        KmList<MyApplicationLogTrace> v;
        v = getTraces().toList();
        v.sortOn(MyApplicationLogTrace.Meta.Sequence);
        return v;
    }

    public boolean hasTraces()
    {
        return !getBaseTraces().isEmpty();
    }

    public int getTraceCount()
    {
        return getBaseTraces().size();
    }

    public List<MyApplicationLogTrace> getBaseTraces()
    {
        return traces;
    }

    public MyApplicationLogTrace addTrace()
    {
        MyApplicationLogTrace e;
        e = new MyApplicationLogTrace();
        e.setSequence(getTraces().getNextSequence());
        getTraces().add(e);
        return e;
    }

    public void addTrace(MyApplicationLogTrace e)
    {
        getTraces().add(e);
    }

    public boolean removeTrace(MyApplicationLogTrace e)
    {
        return getTraces().remove(e);
    }

    public boolean removeTraceId(Integer myId)
    {
        MyApplicationLogTrace e = findTraceId(myId);
        if ( e == null )
            return false;

        return removeTrace(e);
    }

    public MyApplicationLogTrace findTraceId(Integer myId)
    {
        for ( MyApplicationLogTrace e : getBaseTraces() )
            if ( e.hasId(myId) )
                return e;
        return null;
    }

    public void clearTraces()
    {
        getTraces().clear();
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
        id = null;

        List<MyApplicationLogTrace> old_traces = traces;
        traces = new ArrayList<>();
        for ( MyApplicationLogTrace e : old_traces )
            addTrace(copy(e));
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
        return Kmu.isEqual(getId(), e.getId());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getId());
    }

    public boolean isSame(MyApplicationLog e)
    {
        if ( !Kmu.isEqual(getId(), e.getId()) ) return false;
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
        if ( !Kmu.isEqual(getExceptionText(), e.getExceptionText()) ) return false;
        if ( !Kmu.isEqual(getLevelCodeName(), e.getLevelCodeName()) ) return false;
        if ( !Kmu.isEqual(getFullTrace(), e.getFullTrace()) ) return false;
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
    //# property
    //##################################################

    public void importPropertyMap(KmMap<String,String> map)
    {
        KmProperties p;
        p = new KmProperties();
        p.setMap(map);

        if ( p.hasKey("id") )
            setId(p.getInteger("id"));

        if ( p.hasKey("loggerName") )
            setLoggerName(p.getString("loggerName"));

        if ( p.hasKey("context") )
            setContext(p.getString("context"));

        if ( p.hasKey("message") )
            setMessage(p.getString("message"));

        if ( p.hasKey("levelName") )
            setLevelName(p.getString("levelName"));

        if ( p.hasKey("levelCode") )
            setLevelCode(p.getInteger("levelCode"));

        if ( p.hasKey("threadName") )
            setThreadName(p.getString("threadName"));

        if ( p.hasKey("exceptionText") )
            setExceptionText(p.getString("exceptionText"));
    }

    public KmMap<String,String> exportPropertyMap()
    {
        KmProperties p;
        p = new KmProperties();

        if ( hasId() )
            p.setInteger("id", getId());

        if ( hasLoggerName() )
            p.setString("loggerName", getLoggerName());

        if ( hasContext() )
            p.setString("context", getContext());

        if ( hasMessage() )
            p.setString("message", getMessage());

        if ( hasLevelName() )
            p.setString("levelName", getLevelName());

        if ( hasLevelCode() )
            p.setInteger("levelCode", getLevelCode());

        if ( hasThreadName() )
            p.setString("threadName", getThreadName());

        if ( hasExceptionText() )
            p.setString("exceptionText", getExceptionText());

        return p.getMap();
    }


    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MyApplicationLog");
        sb.append("(");
        sb.append("Id=");
        sb.append(id);
        sb.append(")");
        return sb.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    Id = " + id);
        System.out.println("    CreatedUtcTs = " + createdUtcTs);
        System.out.println("    LoggerName = " + loggerName);
        System.out.println("    Context = " + context);
        System.out.println("    Message = " + message);
        System.out.println("    LevelName = " + levelName);
        System.out.println("    LevelCode = " + levelCode);
        System.out.println("    ThreadName = " + threadName);
        System.out.println("    ExceptionText = " + exceptionText);
    }

    /**
     * Format the primary key fields in a comma separated list.  The format
     * is intended to be suitable for display to users.
     */
    public String formatPrimaryKey()
    {
        StringBuilder sb = new StringBuilder();
        ScFormatter f = getFormatter();
        sb.append(f.formatAny(id));
        return sb.toString();
    }

}
