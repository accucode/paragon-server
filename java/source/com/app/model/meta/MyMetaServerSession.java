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

public class MyMetaServerSession
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaServerSession instance = new MyMetaServerSession();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaServerSession()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "serverSession";
    }

    public MyServerSessionValidator getValidator()
    {
        return MyServerSessionValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "Server sessions are used in place of the Virtual Http Session. This allow for a user session to be served by multiple web server machines. The session is created as early as possible, even before the user actually logs in.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaServerSession_Active Active = new MyMetaServerSession_Active();
    public final MyMetaServerSession_AuditLogTitle AuditLogTitle = new MyMetaServerSession_AuditLogTitle();
    public final MyMetaServerSession_ClosedUtcTs ClosedUtcTs = new MyMetaServerSession_ClosedUtcTs();
    public final MyMetaServerSession_CreatedUtcTs CreatedUtcTs = new MyMetaServerSession_CreatedUtcTs();
    public final MyMetaServerSession_DomainSubtitle DomainSubtitle = new MyMetaServerSession_DomainSubtitle();
    public final MyMetaServerSession_DomainTitle DomainTitle = new MyMetaServerSession_DomainTitle();
    public final MyMetaServerSession_LastTouchedUtcTs LastTouchedUtcTs = new MyMetaServerSession_LastTouchedUtcTs();
    public final MyMetaServerSession_Uid Uid = new MyMetaServerSession_Uid();
    public final MyMetaServerSession_Version Version = new MyMetaServerSession_Version();
    public final MyMetaServerSession_LockVersion LockVersion = new MyMetaServerSession_LockVersion();
    public final MyMetaServerSession_ClosedLocalTs ClosedLocalTs = new MyMetaServerSession_ClosedLocalTs();
    public final MyMetaServerSession_ClosedLocalTsMessage ClosedLocalTsMessage = new MyMetaServerSession_ClosedLocalTsMessage();
    public final MyMetaServerSession_ClosedLocalDate ClosedLocalDate = new MyMetaServerSession_ClosedLocalDate();
    public final MyMetaServerSession_ClosedLocalTime ClosedLocalTime = new MyMetaServerSession_ClosedLocalTime();
    public final MyMetaServerSession_CreatedLocalTs CreatedLocalTs = new MyMetaServerSession_CreatedLocalTs();
    public final MyMetaServerSession_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaServerSession_CreatedLocalTsMessage();
    public final MyMetaServerSession_CreatedLocalDate CreatedLocalDate = new MyMetaServerSession_CreatedLocalDate();
    public final MyMetaServerSession_CreatedLocalTime CreatedLocalTime = new MyMetaServerSession_CreatedLocalTime();
    public final MyMetaServerSession_LastTouchedLocalTs LastTouchedLocalTs = new MyMetaServerSession_LastTouchedLocalTs();
    public final MyMetaServerSession_LastTouchedLocalTsMessage LastTouchedLocalTsMessage = new MyMetaServerSession_LastTouchedLocalTsMessage();
    public final MyMetaServerSession_LastTouchedLocalDate LastTouchedLocalDate = new MyMetaServerSession_LastTouchedLocalDate();
    public final MyMetaServerSession_LastTouchedLocalTime LastTouchedLocalTime = new MyMetaServerSession_LastTouchedLocalTime();

    //##################################################
    //# associations
    //##################################################

    public final MyMetaServerSession_AutoLogin AutoLogin = new MyMetaServerSession_AutoLogin();
    public final MyMetaServerSession_Tenant Tenant = new MyMetaServerSession_Tenant();
    public final MyMetaServerSession_User User = new MyMetaServerSession_User();

    //##################################################
    //# Active
    //##################################################

    public class MyMetaServerSession_Active
        extends KmMetaBooleanProperty<MyServerSession>
        implements KmMetaDaoPropertyIF<MyServerSession,Boolean>
    {
        @Override
        public String getName()
        {
            return "active";
        }

        @Override
        public String getLabel()
        {
            return "Active";
        }

        @Override
        public String getHelp()
        {
            return "This indicates if the session is currently active, or if it has expired.";
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
        public KmBooleanValidator getValidator()
        {
            return MyServerSessionValidator.instance.getActiveValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "active";
        }

        @Override
        public MyServerSessionDao getDao()
        {
            return getAccess().getServerSessionDao();
        }

        @Override
        public Boolean getValueFor(MyServerSession model)
        {
            return model.getActive();
        }

        @Override
        public void setValueFor(MyServerSession model, Boolean value)
        {
            model.setActive(value);
        }

        @Override
        public boolean hasValueFor(MyServerSession model, Boolean value)
        {
            return model.hasActive(value);
        }
    }

    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaServerSession_AuditLogTitle
        extends KmMetaStringProperty<MyServerSession>
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
        public String getValueFor(MyServerSession model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyServerSession model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# ClosedUtcTs
    //##################################################

    public class MyMetaServerSession_ClosedUtcTs
        extends KmMetaTimestampProperty<MyServerSession>
        implements KmMetaDaoPropertyIF<MyServerSession,KmTimestamp>
    {
        @Override
        public String getName()
        {
            return "closedUtcTs";
        }

        @Override
        public String getLabel()
        {
            return "Closed Utc Ts";
        }

        @Override
        public String getHelp()
        {
            return "The date and time when the session was closed.";
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
            return MyServerSessionValidator.instance.getClosedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "closedUtcTs";
        }

        @Override
        public MyServerSessionDao getDao()
        {
            return getAccess().getServerSessionDao();
        }

        @Override
        public KmTimestamp getValueFor(MyServerSession model)
        {
            return model.getClosedUtcTs();
        }

        @Override
        public void setValueFor(MyServerSession model, KmTimestamp value)
        {
            model.setClosedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyServerSession model, KmTimestamp value)
        {
            return model.hasClosedUtcTs(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaServerSession_CreatedUtcTs
        extends KmMetaTimestampProperty<MyServerSession>
        implements KmMetaDaoPropertyIF<MyServerSession,KmTimestamp>
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
            return "The date and time when the session was created.";
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
            return MyServerSessionValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MyServerSessionDao getDao()
        {
            return getAccess().getServerSessionDao();
        }

        @Override
        public KmTimestamp getValueFor(MyServerSession model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MyServerSession model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyServerSession model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaServerSession_DomainSubtitle
        extends KmMetaStringProperty<MyServerSession>
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
        public String getValueFor(MyServerSession model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyServerSession model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaServerSession_DomainTitle
        extends KmMetaStringProperty<MyServerSession>
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
        public String getValueFor(MyServerSession model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyServerSession model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# LastTouchedUtcTs
    //##################################################

    public class MyMetaServerSession_LastTouchedUtcTs
        extends KmMetaTimestampProperty<MyServerSession>
        implements KmMetaDaoPropertyIF<MyServerSession,KmTimestamp>
    {
        @Override
        public String getName()
        {
            return "lastTouchedUtcTs";
        }

        @Override
        public String getLabel()
        {
            return "Last Touched Utc Ts";
        }

        @Override
        public String getHelp()
        {
            return "The time when the session was last touched. Used to support automatic timeouts.";
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
            return MyServerSessionValidator.instance.getLastTouchedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lastTouchedUtcTs";
        }

        @Override
        public MyServerSessionDao getDao()
        {
            return getAccess().getServerSessionDao();
        }

        @Override
        public KmTimestamp getValueFor(MyServerSession model)
        {
            return model.getLastTouchedUtcTs();
        }

        @Override
        public void setValueFor(MyServerSession model, KmTimestamp value)
        {
            model.setLastTouchedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyServerSession model, KmTimestamp value)
        {
            return model.hasLastTouchedUtcTs(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaServerSession_Uid
        extends KmMetaStringProperty<MyServerSession>
        implements KmMetaDaoPropertyIF<MyServerSession,String>
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
            return MyServerSessionValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyServerSessionDao getDao()
        {
            return getAccess().getServerSessionDao();
        }

        public KmDaoStringKeyCursor<MyServerSession> createCursor()
        {
            KmDaoStringKeyCursor<MyServerSession> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyServerSession model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyServerSession model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyServerSession model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# Version
    //##################################################

    public class MyMetaServerSession_Version
        extends KmMetaStringProperty<MyServerSession>
        implements KmMetaDaoPropertyIF<MyServerSession,String>
    {
        @Override
        public String getName()
        {
            return "version";
        }

        @Override
        public String getLabel()
        {
            return "Version";
        }

        @Override
        public String getHelp()
        {
            return "The application version. The server session is only valid if its version matches the application's current version. This is used to catch stale sessions when the application is upgraded.";
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
            return MyServerSessionValidator.instance.getVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "version";
        }

        @Override
        public MyServerSessionDao getDao()
        {
            return getAccess().getServerSessionDao();
        }

        @Override
        public String getValueFor(MyServerSession model)
        {
            return model.getVersion();
        }

        @Override
        public void setValueFor(MyServerSession model, String value)
        {
            model.setVersion(value);
        }

        @Override
        public boolean hasValueFor(MyServerSession model, String value)
        {
            return model.hasVersion(value);
        }
    }

    //##################################################
    //# LockVersion
    //##################################################

    public class MyMetaServerSession_LockVersion
        extends KmMetaIntegerProperty<MyServerSession>
        implements KmMetaDaoPropertyIF<MyServerSession,Integer>
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
            return MyServerSessionValidator.instance.getLockVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lockVersion";
        }

        @Override
        public MyServerSessionDao getDao()
        {
            return getAccess().getServerSessionDao();
        }

        @Override
        public Integer getValueFor(MyServerSession model)
        {
            return model.getLockVersion();
        }

        @Override
        public void setValueFor(MyServerSession model, Integer value)
        {
            model.setLockVersion(value);
        }

        @Override
        public boolean hasValueFor(MyServerSession model, Integer value)
        {
            return model.hasLockVersion(value);
        }
    }

    //##################################################
    //# ClosedLocalTs
    //##################################################

    public class MyMetaServerSession_ClosedLocalTs
        extends KmMetaTimestampProperty<MyServerSession>
    {
        @Override
        public String getName()
        {
            return "closedLocalTs";
        }

        @Override
        public String getLabel()
        {
            return "Closed";
        }

        @Override
        public String getHelp()
        {
            return "The closed timestamp converted to the user's local timezone.";
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
        public KmTimestamp getValueFor(MyServerSession model)
        {
            return model.getClosedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyServerSession model, KmTimestamp value)
        {
            return model.hasClosedLocalTs(value);
        }
    }

    //##################################################
    //# ClosedLocalTsMessage
    //##################################################

    public class MyMetaServerSession_ClosedLocalTsMessage
        extends KmMetaStringProperty<MyServerSession>
    {
        @Override
        public String getName()
        {
            return "closedLocalTsMessage";
        }

        @Override
        public String getLabel()
        {
            return "Closed";
        }

        @Override
        public String getHelp()
        {
            return "The closed timestamp converted to the user's local timezone, and formatted as a string that includes the timezone code.";
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
        public String getValueFor(MyServerSession model)
        {
            return model.getClosedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyServerSession model, String value)
        {
            return model.hasClosedLocalTsMessage(value);
        }
    }

    //##################################################
    //# ClosedLocalDate
    //##################################################

    public class MyMetaServerSession_ClosedLocalDate
        extends KmMetaDateProperty<MyServerSession>
    {
        @Override
        public String getName()
        {
            return "closedLocalDate";
        }

        @Override
        public String getLabel()
        {
            return "Closed";
        }

        @Override
        public String getHelp()
        {
            return "The closed date based on the user's local timezone.";
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
        public KmDate getValueFor(MyServerSession model)
        {
            return model.getClosedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyServerSession model, KmDate value)
        {
            return model.hasClosedLocalDate(value);
        }
    }

    //##################################################
    //# ClosedLocalTime
    //##################################################

    public class MyMetaServerSession_ClosedLocalTime
        extends KmMetaTimeProperty<MyServerSession>
    {
        @Override
        public String getName()
        {
            return "closedLocalTime";
        }

        @Override
        public String getLabel()
        {
            return "Closed";
        }

        @Override
        public String getHelp()
        {
            return "The closed time of day based on the user's local timezone.";
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
        public KmTime getValueFor(MyServerSession model)
        {
            return model.getClosedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyServerSession model, KmTime value)
        {
            return model.hasClosedLocalTime(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaServerSession_CreatedLocalTs
        extends KmMetaTimestampProperty<MyServerSession>
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
        public KmTimestamp getValueFor(MyServerSession model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyServerSession model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaServerSession_CreatedLocalTsMessage
        extends KmMetaStringProperty<MyServerSession>
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
        public String getValueFor(MyServerSession model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyServerSession model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaServerSession_CreatedLocalDate
        extends KmMetaDateProperty<MyServerSession>
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
        public KmDate getValueFor(MyServerSession model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyServerSession model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaServerSession_CreatedLocalTime
        extends KmMetaTimeProperty<MyServerSession>
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
        public KmTime getValueFor(MyServerSession model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyServerSession model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }

    //##################################################
    //# LastTouchedLocalTs
    //##################################################

    public class MyMetaServerSession_LastTouchedLocalTs
        extends KmMetaTimestampProperty<MyServerSession>
    {
        @Override
        public String getName()
        {
            return "lastTouchedLocalTs";
        }

        @Override
        public String getLabel()
        {
            return "Last Touched";
        }

        @Override
        public String getHelp()
        {
            return "The last touched timestamp converted to the user's local timezone.";
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
        public KmTimestamp getValueFor(MyServerSession model)
        {
            return model.getLastTouchedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyServerSession model, KmTimestamp value)
        {
            return model.hasLastTouchedLocalTs(value);
        }
    }

    //##################################################
    //# LastTouchedLocalTsMessage
    //##################################################

    public class MyMetaServerSession_LastTouchedLocalTsMessage
        extends KmMetaStringProperty<MyServerSession>
    {
        @Override
        public String getName()
        {
            return "lastTouchedLocalTsMessage";
        }

        @Override
        public String getLabel()
        {
            return "Last Touched";
        }

        @Override
        public String getHelp()
        {
            return "The last touched timestamp converted to the user's local timezone, and formatted as a string that includes the timezone code.";
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
        public String getValueFor(MyServerSession model)
        {
            return model.getLastTouchedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyServerSession model, String value)
        {
            return model.hasLastTouchedLocalTsMessage(value);
        }
    }

    //##################################################
    //# LastTouchedLocalDate
    //##################################################

    public class MyMetaServerSession_LastTouchedLocalDate
        extends KmMetaDateProperty<MyServerSession>
    {
        @Override
        public String getName()
        {
            return "lastTouchedLocalDate";
        }

        @Override
        public String getLabel()
        {
            return "Last Touched";
        }

        @Override
        public String getHelp()
        {
            return "The last touched date based on the user's local timezone.";
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
        public KmDate getValueFor(MyServerSession model)
        {
            return model.getLastTouchedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyServerSession model, KmDate value)
        {
            return model.hasLastTouchedLocalDate(value);
        }
    }

    //##################################################
    //# LastTouchedLocalTime
    //##################################################

    public class MyMetaServerSession_LastTouchedLocalTime
        extends KmMetaTimeProperty<MyServerSession>
    {
        @Override
        public String getName()
        {
            return "lastTouchedLocalTime";
        }

        @Override
        public String getLabel()
        {
            return "Last Touched";
        }

        @Override
        public String getHelp()
        {
            return "The last touched time of day based on the user's local timezone.";
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
        public KmTime getValueFor(MyServerSession model)
        {
            return model.getLastTouchedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyServerSession model, KmTime value)
        {
            return model.hasLastTouchedLocalTime(value);
        }
    }


    //##################################################
    //# AutoLogin
    //##################################################

    public class MyMetaServerSession_AutoLogin
        extends KmMetaDaoAssociation<MyServerSession,MyAutoLogin>
    {
        @Override
        public String getName()
        {
            return "autoLogin";
        }

        @Override
        public String getLabel()
        {
            return "Auto Login";
        }

        @Override
        public String getHelp()
        {
            return "The token, if any, that was used to automatically login.";
        }

        @Override
        public boolean isRequired()
        {
            return false;
        }

        @Override
        public MyAutoLogin getValueFor(MyServerSession model)
        {
            return model.getAutoLogin();
        }

        @Override
        public void setValueFor(MyServerSession model, MyAutoLogin value)
        {
            model.setAutoLogin(value);
        }

        @Override
        public boolean hasValueFor(MyServerSession model, MyAutoLogin value)
        {
            return model.hasAutoLogin(value);
        }
    }

    //##################################################
    //# Tenant
    //##################################################

    public class MyMetaServerSession_Tenant
        extends KmMetaDaoAssociation<MyServerSession,MyTenant>
    {
        @Override
        public String getName()
        {
            return "tenant";
        }

        @Override
        public String getLabel()
        {
            return "Tenant";
        }

        @Override
        public String getHelp()
        {
            return "The tenant.";
        }

        @Override
        public boolean isRequired()
        {
            return true;
        }

        @Override
        public MyTenant getValueFor(MyServerSession model)
        {
            return model.getTenant();
        }

        @Override
        public void setValueFor(MyServerSession model, MyTenant value)
        {
            model.setTenant(value);
        }

        @Override
        public boolean hasValueFor(MyServerSession model, MyTenant value)
        {
            return model.hasTenant(value);
        }
    }

    //##################################################
    //# User
    //##################################################

    public class MyMetaServerSession_User
        extends KmMetaDaoAssociation<MyServerSession,MyUser>
    {
        @Override
        public String getName()
        {
            return "user";
        }

        @Override
        public String getLabel()
        {
            return "User";
        }

        @Override
        public String getHelp()
        {
            return "The user associated with this session.";
        }

        @Override
        public boolean isRequired()
        {
            return false;
        }

        @Override
        public MyUser getValueFor(MyServerSession model)
        {
            return model.getUser();
        }

        @Override
        public void setValueFor(MyServerSession model, MyUser value)
        {
            model.setUser(value);
        }

        @Override
        public boolean hasValueFor(MyServerSession model, MyUser value)
        {
            return model.hasUser(value);
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
