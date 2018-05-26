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

public class MyMetaThreadTopic
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaThreadTopic instance = new MyMetaThreadTopic();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaThreadTopic()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "threadTopic";
    }

    public MyThreadTopicValidator getValidator()
    {
        return MyThreadTopicValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "I help to ensure that only one thread runs a particular activity (topic), even across multiple JVMs.\n To correctly ensure that only one JVM is running a given task, every JVM must check this table before starting a particular activity. Additionally, once a particular JVM is assigned ownership, it must 'touch' the pertinent topic at least once a minute, updating the lastTouched time. Without this touch, a long running task will eventually be deemed hung/dead, and another JVM will be allowed to become the new owner.  This could result in multiple threads running the same task. To avoid this, break long running tasks into smaller database transactions, and ensure that the topic is 'touched' periodically.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaThreadTopic_AuditLogTitle AuditLogTitle = new MyMetaThreadTopic_AuditLogTitle();
    public final MyMetaThreadTopic_Code Code = new MyMetaThreadTopic_Code();
    public final MyMetaThreadTopic_DomainSubtitle DomainSubtitle = new MyMetaThreadTopic_DomainSubtitle();
    public final MyMetaThreadTopic_DomainTitle DomainTitle = new MyMetaThreadTopic_DomainTitle();
    public final MyMetaThreadTopic_HostAddress HostAddress = new MyMetaThreadTopic_HostAddress();
    public final MyMetaThreadTopic_HostName HostName = new MyMetaThreadTopic_HostName();
    public final MyMetaThreadTopic_LastEndUtcTs LastEndUtcTs = new MyMetaThreadTopic_LastEndUtcTs();
    public final MyMetaThreadTopic_LastStartUtcTs LastStartUtcTs = new MyMetaThreadTopic_LastStartUtcTs();
    public final MyMetaThreadTopic_LastTouchUtcTs LastTouchUtcTs = new MyMetaThreadTopic_LastTouchUtcTs();
    public final MyMetaThreadTopic_OwnerUid OwnerUid = new MyMetaThreadTopic_OwnerUid();
    public final MyMetaThreadTopic_LockVersion LockVersion = new MyMetaThreadTopic_LockVersion();
    public final MyMetaThreadTopic_LastEndLocalTs LastEndLocalTs = new MyMetaThreadTopic_LastEndLocalTs();
    public final MyMetaThreadTopic_LastEndLocalTsMessage LastEndLocalTsMessage = new MyMetaThreadTopic_LastEndLocalTsMessage();
    public final MyMetaThreadTopic_LastEndLocalDate LastEndLocalDate = new MyMetaThreadTopic_LastEndLocalDate();
    public final MyMetaThreadTopic_LastEndLocalTime LastEndLocalTime = new MyMetaThreadTopic_LastEndLocalTime();
    public final MyMetaThreadTopic_LastStartLocalTs LastStartLocalTs = new MyMetaThreadTopic_LastStartLocalTs();
    public final MyMetaThreadTopic_LastStartLocalTsMessage LastStartLocalTsMessage = new MyMetaThreadTopic_LastStartLocalTsMessage();
    public final MyMetaThreadTopic_LastStartLocalDate LastStartLocalDate = new MyMetaThreadTopic_LastStartLocalDate();
    public final MyMetaThreadTopic_LastStartLocalTime LastStartLocalTime = new MyMetaThreadTopic_LastStartLocalTime();
    public final MyMetaThreadTopic_LastTouchLocalTs LastTouchLocalTs = new MyMetaThreadTopic_LastTouchLocalTs();
    public final MyMetaThreadTopic_LastTouchLocalTsMessage LastTouchLocalTsMessage = new MyMetaThreadTopic_LastTouchLocalTsMessage();
    public final MyMetaThreadTopic_LastTouchLocalDate LastTouchLocalDate = new MyMetaThreadTopic_LastTouchLocalDate();
    public final MyMetaThreadTopic_LastTouchLocalTime LastTouchLocalTime = new MyMetaThreadTopic_LastTouchLocalTime();

    //##################################################
    //# associations
    //##################################################


    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaThreadTopic_AuditLogTitle
        extends KmMetaStringProperty<MyThreadTopic>
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
        public String getValueFor(MyThreadTopic model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyThreadTopic model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# Code
    //##################################################

    public class MyMetaThreadTopic_Code
        extends KmMetaStringProperty<MyThreadTopic>
        implements KmMetaDaoPropertyIF<MyThreadTopic,String>
    {
        @Override
        public String getName()
        {
            return "code";
        }

        @Override
        public String getLabel()
        {
            return "Code";
        }

        @Override
        public String getHelp()
        {
            return "The unique key. In practice, this is often the (simple) name of the java class that is being run.  The names generally do not matter, as long as they are consistent across all JVMs.";
        }

        @Override
        public int getColumnWidth()
        {
            return 15;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyThreadTopicValidator.instance.getCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "code";
        }

        @Override
        public MyThreadTopicDao getDao()
        {
            return getAccess().getThreadTopicDao();
        }

        public KmDaoStringKeyCursor<MyThreadTopic> createCursor()
        {
            KmDaoStringKeyCursor<MyThreadTopic> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyThreadTopic model)
        {
            return model.getCode();
        }

        @Override
        public void setValueFor(MyThreadTopic model, String value)
        {
            model.setCode(value);
        }

        @Override
        public boolean hasValueFor(MyThreadTopic model, String value)
        {
            return model.hasCode(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaThreadTopic_DomainSubtitle
        extends KmMetaStringProperty<MyThreadTopic>
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
        public String getValueFor(MyThreadTopic model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyThreadTopic model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaThreadTopic_DomainTitle
        extends KmMetaStringProperty<MyThreadTopic>
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
        public String getValueFor(MyThreadTopic model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyThreadTopic model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# HostAddress
    //##################################################

    public class MyMetaThreadTopic_HostAddress
        extends KmMetaStringProperty<MyThreadTopic>
        implements KmMetaDaoPropertyIF<MyThreadTopic,String>
    {
        @Override
        public String getName()
        {
            return "hostAddress";
        }

        @Override
        public String getLabel()
        {
            return "Host Address";
        }

        @Override
        public String getHelp()
        {
            return "The host machine on which the current owner is running. This is only used for auditing; not for coordinating ownership.";
        }

        @Override
        public int getColumnWidth()
        {
            return 15;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyThreadTopicValidator.instance.getHostAddressValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "hostAddress";
        }

        @Override
        public MyThreadTopicDao getDao()
        {
            return getAccess().getThreadTopicDao();
        }

        @Override
        public String getValueFor(MyThreadTopic model)
        {
            return model.getHostAddress();
        }

        @Override
        public void setValueFor(MyThreadTopic model, String value)
        {
            model.setHostAddress(value);
        }

        @Override
        public boolean hasValueFor(MyThreadTopic model, String value)
        {
            return model.hasHostAddress(value);
        }
    }

    //##################################################
    //# HostName
    //##################################################

    public class MyMetaThreadTopic_HostName
        extends KmMetaStringProperty<MyThreadTopic>
        implements KmMetaDaoPropertyIF<MyThreadTopic,String>
    {
        @Override
        public String getName()
        {
            return "hostName";
        }

        @Override
        public String getLabel()
        {
            return "Host Name";
        }

        @Override
        public String getHelp()
        {
            return "The host machine on which the current owner is running. This is only used for auditing; not for coordinating ownership.";
        }

        @Override
        public int getColumnWidth()
        {
            return 15;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyThreadTopicValidator.instance.getHostNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "hostName";
        }

        @Override
        public MyThreadTopicDao getDao()
        {
            return getAccess().getThreadTopicDao();
        }

        @Override
        public String getValueFor(MyThreadTopic model)
        {
            return model.getHostName();
        }

        @Override
        public void setValueFor(MyThreadTopic model, String value)
        {
            model.setHostName(value);
        }

        @Override
        public boolean hasValueFor(MyThreadTopic model, String value)
        {
            return model.hasHostName(value);
        }
    }

    //##################################################
    //# LastEndUtcTs
    //##################################################

    public class MyMetaThreadTopic_LastEndUtcTs
        extends KmMetaTimestampProperty<MyThreadTopic>
        implements KmMetaDaoPropertyIF<MyThreadTopic,KmTimestamp>
    {
        @Override
        public String getName()
        {
            return "lastEndUtcTs";
        }

        @Override
        public String getLabel()
        {
            return "Last End Utc Ts";
        }

        @Override
        public String getHelp()
        {
            return "The last time the owner ENDED this task. This is only used for auditing; not for coordinating ownership.";
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
            return MyThreadTopicValidator.instance.getLastEndUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lastEndUtcTs";
        }

        @Override
        public MyThreadTopicDao getDao()
        {
            return getAccess().getThreadTopicDao();
        }

        @Override
        public KmTimestamp getValueFor(MyThreadTopic model)
        {
            return model.getLastEndUtcTs();
        }

        @Override
        public void setValueFor(MyThreadTopic model, KmTimestamp value)
        {
            model.setLastEndUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyThreadTopic model, KmTimestamp value)
        {
            return model.hasLastEndUtcTs(value);
        }
    }

    //##################################################
    //# LastStartUtcTs
    //##################################################

    public class MyMetaThreadTopic_LastStartUtcTs
        extends KmMetaTimestampProperty<MyThreadTopic>
        implements KmMetaDaoPropertyIF<MyThreadTopic,KmTimestamp>
    {
        @Override
        public String getName()
        {
            return "lastStartUtcTs";
        }

        @Override
        public String getLabel()
        {
            return "Last Start Utc Ts";
        }

        @Override
        public String getHelp()
        {
            return "The last time the owner ENDED this task. This is only used for auditing; not for coordinating ownership.";
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
            return MyThreadTopicValidator.instance.getLastStartUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lastStartUtcTs";
        }

        @Override
        public MyThreadTopicDao getDao()
        {
            return getAccess().getThreadTopicDao();
        }

        @Override
        public KmTimestamp getValueFor(MyThreadTopic model)
        {
            return model.getLastStartUtcTs();
        }

        @Override
        public void setValueFor(MyThreadTopic model, KmTimestamp value)
        {
            model.setLastStartUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyThreadTopic model, KmTimestamp value)
        {
            return model.hasLastStartUtcTs(value);
        }
    }

    //##################################################
    //# LastTouchUtcTs
    //##################################################

    public class MyMetaThreadTopic_LastTouchUtcTs
        extends KmMetaTimestampProperty<MyThreadTopic>
        implements KmMetaDaoPropertyIF<MyThreadTopic,KmTimestamp>
    {
        @Override
        public String getName()
        {
            return "lastTouchUtcTs";
        }

        @Override
        public String getLabel()
        {
            return "Last Touch Utc Ts";
        }

        @Override
        public String getHelp()
        {
            return "The last time the owner TOUCHED this task. This is used to coordinate ownership. JVM may shutdown, get restarted, or simply hang completely. If the current owner has not touched the record in the last 10 minutes, then it is assumed that the owner has died and that someone else should be assigned as the owner.";
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
            return MyThreadTopicValidator.instance.getLastTouchUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lastTouchUtcTs";
        }

        @Override
        public MyThreadTopicDao getDao()
        {
            return getAccess().getThreadTopicDao();
        }

        @Override
        public KmTimestamp getValueFor(MyThreadTopic model)
        {
            return model.getLastTouchUtcTs();
        }

        @Override
        public void setValueFor(MyThreadTopic model, KmTimestamp value)
        {
            model.setLastTouchUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyThreadTopic model, KmTimestamp value)
        {
            return model.hasLastTouchUtcTs(value);
        }
    }

    //##################################################
    //# OwnerUid
    //##################################################

    public class MyMetaThreadTopic_OwnerUid
        extends KmMetaStringProperty<MyThreadTopic>
        implements KmMetaDaoPropertyIF<MyThreadTopic,String>
    {
        @Override
        public String getName()
        {
            return "ownerUid";
        }

        @Override
        public String getLabel()
        {
            return "Owner Uid";
        }

        @Override
        public String getHelp()
        {
            return "The unique id of a particular JVM. This is typically generated as a random UID within the JVM rather than trying to rely on an externally generated value. It is understood that restarting a JVM will likely change the ownerUid even if it is the only JVM on that machine.";
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
            return MyThreadTopicValidator.instance.getOwnerUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "ownerUid";
        }

        @Override
        public MyThreadTopicDao getDao()
        {
            return getAccess().getThreadTopicDao();
        }

        @Override
        public String getValueFor(MyThreadTopic model)
        {
            return model.getOwnerUid();
        }

        @Override
        public void setValueFor(MyThreadTopic model, String value)
        {
            model.setOwnerUid(value);
        }

        @Override
        public boolean hasValueFor(MyThreadTopic model, String value)
        {
            return model.hasOwnerUid(value);
        }
    }

    //##################################################
    //# LockVersion
    //##################################################

    public class MyMetaThreadTopic_LockVersion
        extends KmMetaIntegerProperty<MyThreadTopic>
        implements KmMetaDaoPropertyIF<MyThreadTopic,Integer>
    {
        @Override
        public String getName()
        {
            return "lockVersion";
        }

        @Override
        public String getLabel()
        {
            return "Lock Version";
        }

        @Override
        public String getHelp()
        {
            return "This is used to coordinate optimistic locking in the database. This is usually not displayed.";
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
            return MyThreadTopicValidator.instance.getLockVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lockVersion";
        }

        @Override
        public MyThreadTopicDao getDao()
        {
            return getAccess().getThreadTopicDao();
        }

        @Override
        public Integer getValueFor(MyThreadTopic model)
        {
            return model.getLockVersion();
        }

        @Override
        public void setValueFor(MyThreadTopic model, Integer value)
        {
            model.setLockVersion(value);
        }

        @Override
        public boolean hasValueFor(MyThreadTopic model, Integer value)
        {
            return model.hasLockVersion(value);
        }
    }

    //##################################################
    //# LastEndLocalTs
    //##################################################

    public class MyMetaThreadTopic_LastEndLocalTs
        extends KmMetaTimestampProperty<MyThreadTopic>
    {
        @Override
        public String getName()
        {
            return "lastEndLocalTs";
        }

        @Override
        public String getLabel()
        {
            return "Last End";
        }

        @Override
        public String getHelp()
        {
            return "The last end timestamp converted to the user's local timezone.";
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
        public KmTimestamp getValueFor(MyThreadTopic model)
        {
            return model.getLastEndLocalTs();
        }

        @Override
        public boolean hasValueFor(MyThreadTopic model, KmTimestamp value)
        {
            return model.hasLastEndLocalTs(value);
        }
    }

    //##################################################
    //# LastEndLocalTsMessage
    //##################################################

    public class MyMetaThreadTopic_LastEndLocalTsMessage
        extends KmMetaStringProperty<MyThreadTopic>
    {
        @Override
        public String getName()
        {
            return "lastEndLocalTsMessage";
        }

        @Override
        public String getLabel()
        {
            return "Last End";
        }

        @Override
        public String getHelp()
        {
            return "The last end timestamp converted to the user's local timezone, and formatted as a string that includes the timezone code.";
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
        public String getValueFor(MyThreadTopic model)
        {
            return model.getLastEndLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyThreadTopic model, String value)
        {
            return model.hasLastEndLocalTsMessage(value);
        }
    }

    //##################################################
    //# LastEndLocalDate
    //##################################################

    public class MyMetaThreadTopic_LastEndLocalDate
        extends KmMetaDateProperty<MyThreadTopic>
    {
        @Override
        public String getName()
        {
            return "lastEndLocalDate";
        }

        @Override
        public String getLabel()
        {
            return "Last End";
        }

        @Override
        public String getHelp()
        {
            return "The last end date based on the user's local timezone.";
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
        public KmDate getValueFor(MyThreadTopic model)
        {
            return model.getLastEndLocalDate();
        }

        @Override
        public boolean hasValueFor(MyThreadTopic model, KmDate value)
        {
            return model.hasLastEndLocalDate(value);
        }
    }

    //##################################################
    //# LastEndLocalTime
    //##################################################

    public class MyMetaThreadTopic_LastEndLocalTime
        extends KmMetaTimeProperty<MyThreadTopic>
    {
        @Override
        public String getName()
        {
            return "lastEndLocalTime";
        }

        @Override
        public String getLabel()
        {
            return "Last End";
        }

        @Override
        public String getHelp()
        {
            return "The last end time of day based on the user's local timezone.";
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
        public KmTime getValueFor(MyThreadTopic model)
        {
            return model.getLastEndLocalTime();
        }

        @Override
        public boolean hasValueFor(MyThreadTopic model, KmTime value)
        {
            return model.hasLastEndLocalTime(value);
        }
    }

    //##################################################
    //# LastStartLocalTs
    //##################################################

    public class MyMetaThreadTopic_LastStartLocalTs
        extends KmMetaTimestampProperty<MyThreadTopic>
    {
        @Override
        public String getName()
        {
            return "lastStartLocalTs";
        }

        @Override
        public String getLabel()
        {
            return "Last Start";
        }

        @Override
        public String getHelp()
        {
            return "The last start timestamp converted to the user's local timezone.";
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
        public KmTimestamp getValueFor(MyThreadTopic model)
        {
            return model.getLastStartLocalTs();
        }

        @Override
        public boolean hasValueFor(MyThreadTopic model, KmTimestamp value)
        {
            return model.hasLastStartLocalTs(value);
        }
    }

    //##################################################
    //# LastStartLocalTsMessage
    //##################################################

    public class MyMetaThreadTopic_LastStartLocalTsMessage
        extends KmMetaStringProperty<MyThreadTopic>
    {
        @Override
        public String getName()
        {
            return "lastStartLocalTsMessage";
        }

        @Override
        public String getLabel()
        {
            return "Last Start";
        }

        @Override
        public String getHelp()
        {
            return "The last start timestamp converted to the user's local timezone, and formatted as a string that includes the timezone code.";
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
        public String getValueFor(MyThreadTopic model)
        {
            return model.getLastStartLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyThreadTopic model, String value)
        {
            return model.hasLastStartLocalTsMessage(value);
        }
    }

    //##################################################
    //# LastStartLocalDate
    //##################################################

    public class MyMetaThreadTopic_LastStartLocalDate
        extends KmMetaDateProperty<MyThreadTopic>
    {
        @Override
        public String getName()
        {
            return "lastStartLocalDate";
        }

        @Override
        public String getLabel()
        {
            return "Last Start";
        }

        @Override
        public String getHelp()
        {
            return "The last start date based on the user's local timezone.";
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
        public KmDate getValueFor(MyThreadTopic model)
        {
            return model.getLastStartLocalDate();
        }

        @Override
        public boolean hasValueFor(MyThreadTopic model, KmDate value)
        {
            return model.hasLastStartLocalDate(value);
        }
    }

    //##################################################
    //# LastStartLocalTime
    //##################################################

    public class MyMetaThreadTopic_LastStartLocalTime
        extends KmMetaTimeProperty<MyThreadTopic>
    {
        @Override
        public String getName()
        {
            return "lastStartLocalTime";
        }

        @Override
        public String getLabel()
        {
            return "Last Start";
        }

        @Override
        public String getHelp()
        {
            return "The last start time of day based on the user's local timezone.";
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
        public KmTime getValueFor(MyThreadTopic model)
        {
            return model.getLastStartLocalTime();
        }

        @Override
        public boolean hasValueFor(MyThreadTopic model, KmTime value)
        {
            return model.hasLastStartLocalTime(value);
        }
    }

    //##################################################
    //# LastTouchLocalTs
    //##################################################

    public class MyMetaThreadTopic_LastTouchLocalTs
        extends KmMetaTimestampProperty<MyThreadTopic>
    {
        @Override
        public String getName()
        {
            return "lastTouchLocalTs";
        }

        @Override
        public String getLabel()
        {
            return "Last Touch";
        }

        @Override
        public String getHelp()
        {
            return "The last touch timestamp converted to the user's local timezone.";
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
        public KmTimestamp getValueFor(MyThreadTopic model)
        {
            return model.getLastTouchLocalTs();
        }

        @Override
        public boolean hasValueFor(MyThreadTopic model, KmTimestamp value)
        {
            return model.hasLastTouchLocalTs(value);
        }
    }

    //##################################################
    //# LastTouchLocalTsMessage
    //##################################################

    public class MyMetaThreadTopic_LastTouchLocalTsMessage
        extends KmMetaStringProperty<MyThreadTopic>
    {
        @Override
        public String getName()
        {
            return "lastTouchLocalTsMessage";
        }

        @Override
        public String getLabel()
        {
            return "Last Touch";
        }

        @Override
        public String getHelp()
        {
            return "The last touch timestamp converted to the user's local timezone, and formatted as a string that includes the timezone code.";
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
        public String getValueFor(MyThreadTopic model)
        {
            return model.getLastTouchLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyThreadTopic model, String value)
        {
            return model.hasLastTouchLocalTsMessage(value);
        }
    }

    //##################################################
    //# LastTouchLocalDate
    //##################################################

    public class MyMetaThreadTopic_LastTouchLocalDate
        extends KmMetaDateProperty<MyThreadTopic>
    {
        @Override
        public String getName()
        {
            return "lastTouchLocalDate";
        }

        @Override
        public String getLabel()
        {
            return "Last Touch";
        }

        @Override
        public String getHelp()
        {
            return "The last touch date based on the user's local timezone.";
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
        public KmDate getValueFor(MyThreadTopic model)
        {
            return model.getLastTouchLocalDate();
        }

        @Override
        public boolean hasValueFor(MyThreadTopic model, KmDate value)
        {
            return model.hasLastTouchLocalDate(value);
        }
    }

    //##################################################
    //# LastTouchLocalTime
    //##################################################

    public class MyMetaThreadTopic_LastTouchLocalTime
        extends KmMetaTimeProperty<MyThreadTopic>
    {
        @Override
        public String getName()
        {
            return "lastTouchLocalTime";
        }

        @Override
        public String getLabel()
        {
            return "Last Touch";
        }

        @Override
        public String getHelp()
        {
            return "The last touch time of day based on the user's local timezone.";
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
        public KmTime getValueFor(MyThreadTopic model)
        {
            return model.getLastTouchLocalTime();
        }

        @Override
        public boolean hasValueFor(MyThreadTopic model, KmTime value)
        {
            return model.hasLastTouchLocalTime(value);
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
