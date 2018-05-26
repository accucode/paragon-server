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
import com.kodemore.dao.*;
import com.kodemore.exception.*;
import com.kodemore.meta.*;
import com.kodemore.servlet.encoder.*;
import com.kodemore.servlet.field.*;
import com.kodemore.time.*;
import com.kodemore.types.*;
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.finder.*;
import com.app.model.*;
import com.app.model.base.*;
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

    public MyApplicationLogValidator getValidator()
    {
        return MyApplicationLogValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "Used to persist log4j events with a custom appender. In general, everything that would normally be logged with log4j is echoed here.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaApplicationLog_AuditLogTitle AuditLogTitle = new MyMetaApplicationLog_AuditLogTitle();
    public final MyMetaApplicationLog_Context Context = new MyMetaApplicationLog_Context();
    public final MyMetaApplicationLog_CreatedUtcTs CreatedUtcTs = new MyMetaApplicationLog_CreatedUtcTs();
    public final MyMetaApplicationLog_DomainSubtitle DomainSubtitle = new MyMetaApplicationLog_DomainSubtitle();
    public final MyMetaApplicationLog_DomainTitle DomainTitle = new MyMetaApplicationLog_DomainTitle();
    public final MyMetaApplicationLog_LevelCode LevelCode = new MyMetaApplicationLog_LevelCode();
    public final MyMetaApplicationLog_LevelName LevelName = new MyMetaApplicationLog_LevelName();
    public final MyMetaApplicationLog_LoggerName LoggerName = new MyMetaApplicationLog_LoggerName();
    public final MyMetaApplicationLog_Message Message = new MyMetaApplicationLog_Message();
    public final MyMetaApplicationLog_ThreadName ThreadName = new MyMetaApplicationLog_ThreadName();
    public final MyMetaApplicationLog_Trace Trace = new MyMetaApplicationLog_Trace();
    public final MyMetaApplicationLog_Uid Uid = new MyMetaApplicationLog_Uid();
    public final MyMetaApplicationLog_CreatedLocalTs CreatedLocalTs = new MyMetaApplicationLog_CreatedLocalTs();
    public final MyMetaApplicationLog_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaApplicationLog_CreatedLocalTsMessage();
    public final MyMetaApplicationLog_CreatedLocalDate CreatedLocalDate = new MyMetaApplicationLog_CreatedLocalDate();
    public final MyMetaApplicationLog_CreatedLocalTime CreatedLocalTime = new MyMetaApplicationLog_CreatedLocalTime();

    //##################################################
    //# associations
    //##################################################


    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaApplicationLog_AuditLogTitle
        extends KmMetaStringProperty<MyApplicationLog>
    {
        @Override
        public String getName()
        {
            return "auditLogTitle";
        }

        @Override
        public String getLabel()
        {
            return "Audit Log Title";
        }

        @Override
        public String getHelp()
        {
            return "This is used a the title in auditLogs. This should NEVER be null.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public String getValueFor(MyApplicationLog model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyApplicationLog model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# Context
    //##################################################

    public class MyMetaApplicationLog_Context
        extends KmMetaStringProperty<MyApplicationLog>
        implements KmMetaDaoPropertyIF<MyApplicationLog,String>
    {
        @Override
        public String getName()
        {
            return "context";
        }

        @Override
        public String getLabel()
        {
            return "Context";
        }

        @Override
        public String getHelp()
        {
            return "The nested diagnostic context; used to distinguish threads.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyApplicationLogValidator.instance.getContextValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "context";
        }

        @Override
        public MyApplicationLogDao getDao()
        {
            return getAccess().getApplicationLogDao();
        }

        @Override
        public String getValueFor(MyApplicationLog model)
        {
            return model.getContext();
        }

        @Override
        public void setValueFor(MyApplicationLog model, String value)
        {
            model.setContext(value);
        }

        @Override
        public boolean hasValueFor(MyApplicationLog model, String value)
        {
            return model.hasContext(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaApplicationLog_CreatedUtcTs
        extends KmMetaTimestampProperty<MyApplicationLog>
        implements KmMetaDaoPropertyIF<MyApplicationLog,KmTimestamp>
    {
        @Override
        public String getName()
        {
            return "createdUtcTs";
        }

        @Override
        public String getLabel()
        {
            return "Created Utc Ts";
        }

        @Override
        public String getHelp()
        {
            return "The time this record was originally created.";
        }

        @Override
        public int getColumnWidth()
        {
            return 16;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmTimestampValidator getValidator()
        {
            return MyApplicationLogValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MyApplicationLogDao getDao()
        {
            return getAccess().getApplicationLogDao();
        }

        @Override
        public KmTimestamp getValueFor(MyApplicationLog model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MyApplicationLog model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyApplicationLog model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaApplicationLog_DomainSubtitle
        extends KmMetaStringProperty<MyApplicationLog>
    {
        @Override
        public String getName()
        {
            return "domainSubtitle";
        }

        @Override
        public String getLabel()
        {
            return "Domain Subtitle";
        }

        @Override
        public String getHelp()
        {
            return "The subtitle commonly used for rows in a list. This MAY be null, if there is not subtitle.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public String getValueFor(MyApplicationLog model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyApplicationLog model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaApplicationLog_DomainTitle
        extends KmMetaStringProperty<MyApplicationLog>
    {
        @Override
        public String getName()
        {
            return "domainTitle";
        }

        @Override
        public String getLabel()
        {
            return "Domain Title";
        }

        @Override
        public String getHelp()
        {
            return "The title commonly used for rows in a list or dropdown field. This should NEVER be null.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public String getValueFor(MyApplicationLog model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyApplicationLog model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# LevelCode
    //##################################################

    public class MyMetaApplicationLog_LevelCode
        extends KmMetaIntegerProperty<MyApplicationLog>
        implements KmMetaDaoPropertyIF<MyApplicationLog,Integer>
    {
        @Override
        public String getName()
        {
            return "levelCode";
        }

        @Override
        public String getLabel()
        {
            return "Level Code";
        }

        @Override
        public String getHelp()
        {
            return "The severity level code. This can be used to find all events that are high or lower than some level.";
        }

        @Override
        public int getColumnWidth()
        {
            return 10;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmIntegerValidator getValidator()
        {
            return MyApplicationLogValidator.instance.getLevelCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "levelCode";
        }

        @Override
        public MyApplicationLogDao getDao()
        {
            return getAccess().getApplicationLogDao();
        }

        @Override
        public Integer getValueFor(MyApplicationLog model)
        {
            return model.getLevelCode();
        }

        @Override
        public void setValueFor(MyApplicationLog model, Integer value)
        {
            model.setLevelCode(value);
        }

        @Override
        public boolean hasValueFor(MyApplicationLog model, Integer value)
        {
            return model.hasLevelCode(value);
        }
    }

    //##################################################
    //# LevelName
    //##################################################

    public class MyMetaApplicationLog_LevelName
        extends KmMetaStringProperty<MyApplicationLog>
        implements KmMetaDaoPropertyIF<MyApplicationLog,String>
    {
        @Override
        public String getName()
        {
            return "levelName";
        }

        @Override
        public String getLabel()
        {
            return "Level Name";
        }

        @Override
        public String getHelp()
        {
            return "The display name for the severity level. E.g.: info, warn, error.";
        }

        @Override
        public int getColumnWidth()
        {
            return 5;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyApplicationLogValidator.instance.getLevelNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "levelName";
        }

        @Override
        public MyApplicationLogDao getDao()
        {
            return getAccess().getApplicationLogDao();
        }

        @Override
        public String getValueFor(MyApplicationLog model)
        {
            return model.getLevelName();
        }

        @Override
        public void setValueFor(MyApplicationLog model, String value)
        {
            model.setLevelName(value);
        }

        @Override
        public boolean hasValueFor(MyApplicationLog model, String value)
        {
            return model.hasLevelName(value);
        }
    }

    //##################################################
    //# LoggerName
    //##################################################

    public class MyMetaApplicationLog_LoggerName
        extends KmMetaStringProperty<MyApplicationLog>
        implements KmMetaDaoPropertyIF<MyApplicationLog,String>
    {
        @Override
        public String getName()
        {
            return "loggerName";
        }

        @Override
        public String getLabel()
        {
            return "Logger Name";
        }

        @Override
        public String getHelp()
        {
            return "The logger name, typically similar to a fully qualified class name.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyApplicationLogValidator.instance.getLoggerNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "loggerName";
        }

        @Override
        public MyApplicationLogDao getDao()
        {
            return getAccess().getApplicationLogDao();
        }

        @Override
        public String getValueFor(MyApplicationLog model)
        {
            return model.getLoggerName();
        }

        @Override
        public void setValueFor(MyApplicationLog model, String value)
        {
            model.setLoggerName(value);
        }

        @Override
        public boolean hasValueFor(MyApplicationLog model, String value)
        {
            return model.hasLoggerName(value);
        }
    }

    //##################################################
    //# Message
    //##################################################

    public class MyMetaApplicationLog_Message
        extends KmMetaStringProperty<MyApplicationLog>
        implements KmMetaDaoPropertyIF<MyApplicationLog,String>
    {
        @Override
        public String getName()
        {
            return "message";
        }

        @Override
        public String getLabel()
        {
            return "Message";
        }

        @Override
        public String getHelp()
        {
            return "The plain text message describing the log event.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyApplicationLogValidator.instance.getMessageValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "message";
        }

        @Override
        public MyApplicationLogDao getDao()
        {
            return getAccess().getApplicationLogDao();
        }

        @Override
        public String getValueFor(MyApplicationLog model)
        {
            return model.getMessage();
        }

        @Override
        public void setValueFor(MyApplicationLog model, String value)
        {
            model.setMessage(value);
        }

        @Override
        public boolean hasValueFor(MyApplicationLog model, String value)
        {
            return model.hasMessage(value);
        }
    }

    //##################################################
    //# ThreadName
    //##################################################

    public class MyMetaApplicationLog_ThreadName
        extends KmMetaStringProperty<MyApplicationLog>
        implements KmMetaDaoPropertyIF<MyApplicationLog,String>
    {
        @Override
        public String getName()
        {
            return "threadName";
        }

        @Override
        public String getLabel()
        {
            return "Thread Name";
        }

        @Override
        public String getHelp()
        {
            return "The java thread name. This is not directly useful except to determine which logs are generated from the same JVM thread.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyApplicationLogValidator.instance.getThreadNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "threadName";
        }

        @Override
        public MyApplicationLogDao getDao()
        {
            return getAccess().getApplicationLogDao();
        }

        @Override
        public String getValueFor(MyApplicationLog model)
        {
            return model.getThreadName();
        }

        @Override
        public void setValueFor(MyApplicationLog model, String value)
        {
            model.setThreadName(value);
        }

        @Override
        public boolean hasValueFor(MyApplicationLog model, String value)
        {
            return model.hasThreadName(value);
        }
    }

    //##################################################
    //# Trace
    //##################################################

    public class MyMetaApplicationLog_Trace
        extends KmMetaStringProperty<MyApplicationLog>
        implements KmMetaDaoPropertyIF<MyApplicationLog,String>
    {
        @Override
        public String getName()
        {
            return "trace";
        }

        @Override
        public String getLabel()
        {
            return "Trace";
        }

        @Override
        public String getHelp()
        {
            return "The full text of the exception trace.  This can be quite long.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyApplicationLogValidator.instance.getTraceValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "trace";
        }

        @Override
        public MyApplicationLogDao getDao()
        {
            return getAccess().getApplicationLogDao();
        }

        @Override
        public String getValueFor(MyApplicationLog model)
        {
            return model.getTrace();
        }

        @Override
        public void setValueFor(MyApplicationLog model, String value)
        {
            model.setTrace(value);
        }

        @Override
        public boolean hasValueFor(MyApplicationLog model, String value)
        {
            return model.hasTrace(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaApplicationLog_Uid
        extends KmMetaStringProperty<MyApplicationLog>
        implements KmMetaDaoPropertyIF<MyApplicationLog,String>
    {
        @Override
        public String getName()
        {
            return "uid";
        }

        @Override
        public String getLabel()
        {
            return "Uid";
        }

        @Override
        public String getHelp()
        {
            return "The global unique key.  This is a large hex-encoded number, and is usually not displayed to users.  This is currently NOT a standard format, but is instead a format that we use internally.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyApplicationLogValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyApplicationLogDao getDao()
        {
            return getAccess().getApplicationLogDao();
        }

        public KmDaoStringKeyCursor<MyApplicationLog> createCursor()
        {
            KmDaoStringKeyCursor<MyApplicationLog> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyApplicationLog model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyApplicationLog model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyApplicationLog model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaApplicationLog_CreatedLocalTs
        extends KmMetaTimestampProperty<MyApplicationLog>
    {
        @Override
        public String getName()
        {
            return "createdLocalTs";
        }

        @Override
        public String getLabel()
        {
            return "Created";
        }

        @Override
        public String getHelp()
        {
            return "The created timestamp converted to the user's local timezone.";
        }

        @Override
        public int getColumnWidth()
        {
            return 16;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public KmTimestamp getValueFor(MyApplicationLog model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyApplicationLog model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaApplicationLog_CreatedLocalTsMessage
        extends KmMetaStringProperty<MyApplicationLog>
    {
        @Override
        public String getName()
        {
            return "createdLocalTsMessage";
        }

        @Override
        public String getLabel()
        {
            return "Created";
        }

        @Override
        public String getHelp()
        {
            return "The created timestamp converted to the user's local timezone, and formatted as a string that includes the timezone code.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public String getValueFor(MyApplicationLog model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyApplicationLog model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaApplicationLog_CreatedLocalDate
        extends KmMetaDateProperty<MyApplicationLog>
    {
        @Override
        public String getName()
        {
            return "createdLocalDate";
        }

        @Override
        public String getLabel()
        {
            return "Created";
        }

        @Override
        public String getHelp()
        {
            return "The created date based on the user's local timezone.";
        }

        @Override
        public int getColumnWidth()
        {
            return 10;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public KmDate getValueFor(MyApplicationLog model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyApplicationLog model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaApplicationLog_CreatedLocalTime
        extends KmMetaTimeProperty<MyApplicationLog>
    {
        @Override
        public String getName()
        {
            return "createdLocalTime";
        }

        @Override
        public String getLabel()
        {
            return "Created";
        }

        @Override
        public String getHelp()
        {
            return "The created time of day based on the user's local timezone.";
        }

        @Override
        public int getColumnWidth()
        {
            return 10;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public KmTime getValueFor(MyApplicationLog model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyApplicationLog model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }


    //##################################################
    //# support
    //##################################################

    protected MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

}
