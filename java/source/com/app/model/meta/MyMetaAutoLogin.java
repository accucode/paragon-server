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

public class MyMetaAutoLogin
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaAutoLogin instance = new MyMetaAutoLogin();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaAutoLogin()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "autoLogin";
    }

    public MyAutoLoginValidator getValidator()
    {
        return MyAutoLoginValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "Track the tokens that authorize a person/browser to automatically log in.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaAutoLogin_AuditLogTitle AuditLogTitle = new MyMetaAutoLogin_AuditLogTitle();
    public final MyMetaAutoLogin_CreatedUtcTs CreatedUtcTs = new MyMetaAutoLogin_CreatedUtcTs();
    public final MyMetaAutoLogin_DomainSubtitle DomainSubtitle = new MyMetaAutoLogin_DomainSubtitle();
    public final MyMetaAutoLogin_DomainTitle DomainTitle = new MyMetaAutoLogin_DomainTitle();
    public final MyMetaAutoLogin_LastTouchedUtcTs LastTouchedUtcTs = new MyMetaAutoLogin_LastTouchedUtcTs();
    public final MyMetaAutoLogin_Uid Uid = new MyMetaAutoLogin_Uid();
    public final MyMetaAutoLogin_LockVersion LockVersion = new MyMetaAutoLogin_LockVersion();
    public final MyMetaAutoLogin_CreatedLocalTs CreatedLocalTs = new MyMetaAutoLogin_CreatedLocalTs();
    public final MyMetaAutoLogin_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaAutoLogin_CreatedLocalTsMessage();
    public final MyMetaAutoLogin_CreatedLocalDate CreatedLocalDate = new MyMetaAutoLogin_CreatedLocalDate();
    public final MyMetaAutoLogin_CreatedLocalTime CreatedLocalTime = new MyMetaAutoLogin_CreatedLocalTime();
    public final MyMetaAutoLogin_LastTouchedLocalTs LastTouchedLocalTs = new MyMetaAutoLogin_LastTouchedLocalTs();
    public final MyMetaAutoLogin_LastTouchedLocalTsMessage LastTouchedLocalTsMessage = new MyMetaAutoLogin_LastTouchedLocalTsMessage();
    public final MyMetaAutoLogin_LastTouchedLocalDate LastTouchedLocalDate = new MyMetaAutoLogin_LastTouchedLocalDate();
    public final MyMetaAutoLogin_LastTouchedLocalTime LastTouchedLocalTime = new MyMetaAutoLogin_LastTouchedLocalTime();
    public final MyMetaAutoLogin_UserFullName UserFullName = new MyMetaAutoLogin_UserFullName();
    public final MyMetaAutoLogin_TenantName TenantName = new MyMetaAutoLogin_TenantName();

    //##################################################
    //# associations
    //##################################################

    public final MyMetaAutoLogin_User User = new MyMetaAutoLogin_User();

    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaAutoLogin_AuditLogTitle
        extends KmMetaStringProperty<MyAutoLogin>
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
        public String getValueFor(MyAutoLogin model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyAutoLogin model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaAutoLogin_CreatedUtcTs
        extends KmMetaTimestampProperty<MyAutoLogin>
        implements KmMetaDaoPropertyIF<MyAutoLogin,KmTimestamp>
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
            return "This date and time when the user initially logged in manually.";
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
            return MyAutoLoginValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MyAutoLoginDao getDao()
        {
            return getAccess().getAutoLoginDao();
        }

        @Override
        public KmTimestamp getValueFor(MyAutoLogin model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MyAutoLogin model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyAutoLogin model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaAutoLogin_DomainSubtitle
        extends KmMetaStringProperty<MyAutoLogin>
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
        public String getValueFor(MyAutoLogin model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyAutoLogin model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaAutoLogin_DomainTitle
        extends KmMetaStringProperty<MyAutoLogin>
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
        public String getValueFor(MyAutoLogin model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyAutoLogin model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# LastTouchedUtcTs
    //##################################################

    public class MyMetaAutoLogin_LastTouchedUtcTs
        extends KmMetaTimestampProperty<MyAutoLogin>
        implements KmMetaDaoPropertyIF<MyAutoLogin,KmTimestamp>
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
            return "The date and time the user logged in. This is generally updated each time the user logs in either manaully or automatically.";
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
            return MyAutoLoginValidator.instance.getLastTouchedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lastTouchedUtcTs";
        }

        @Override
        public MyAutoLoginDao getDao()
        {
            return getAccess().getAutoLoginDao();
        }

        @Override
        public KmTimestamp getValueFor(MyAutoLogin model)
        {
            return model.getLastTouchedUtcTs();
        }

        @Override
        public void setValueFor(MyAutoLogin model, KmTimestamp value)
        {
            model.setLastTouchedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyAutoLogin model, KmTimestamp value)
        {
            return model.hasLastTouchedUtcTs(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaAutoLogin_Uid
        extends KmMetaStringProperty<MyAutoLogin>
        implements KmMetaDaoPropertyIF<MyAutoLogin,String>
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
            return MyAutoLoginValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyAutoLoginDao getDao()
        {
            return getAccess().getAutoLoginDao();
        }

        public KmDaoStringKeyCursor<MyAutoLogin> createCursor()
        {
            KmDaoStringKeyCursor<MyAutoLogin> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyAutoLogin model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyAutoLogin model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyAutoLogin model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# LockVersion
    //##################################################

    public class MyMetaAutoLogin_LockVersion
        extends KmMetaIntegerProperty<MyAutoLogin>
        implements KmMetaDaoPropertyIF<MyAutoLogin,Integer>
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
            return MyAutoLoginValidator.instance.getLockVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lockVersion";
        }

        @Override
        public MyAutoLoginDao getDao()
        {
            return getAccess().getAutoLoginDao();
        }

        @Override
        public Integer getValueFor(MyAutoLogin model)
        {
            return model.getLockVersion();
        }

        @Override
        public void setValueFor(MyAutoLogin model, Integer value)
        {
            model.setLockVersion(value);
        }

        @Override
        public boolean hasValueFor(MyAutoLogin model, Integer value)
        {
            return model.hasLockVersion(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaAutoLogin_CreatedLocalTs
        extends KmMetaTimestampProperty<MyAutoLogin>
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
        public KmTimestamp getValueFor(MyAutoLogin model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyAutoLogin model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaAutoLogin_CreatedLocalTsMessage
        extends KmMetaStringProperty<MyAutoLogin>
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
        public String getValueFor(MyAutoLogin model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyAutoLogin model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaAutoLogin_CreatedLocalDate
        extends KmMetaDateProperty<MyAutoLogin>
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
        public KmDate getValueFor(MyAutoLogin model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyAutoLogin model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaAutoLogin_CreatedLocalTime
        extends KmMetaTimeProperty<MyAutoLogin>
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
        public KmTime getValueFor(MyAutoLogin model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyAutoLogin model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }

    //##################################################
    //# LastTouchedLocalTs
    //##################################################

    public class MyMetaAutoLogin_LastTouchedLocalTs
        extends KmMetaTimestampProperty<MyAutoLogin>
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
        public KmTimestamp getValueFor(MyAutoLogin model)
        {
            return model.getLastTouchedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyAutoLogin model, KmTimestamp value)
        {
            return model.hasLastTouchedLocalTs(value);
        }
    }

    //##################################################
    //# LastTouchedLocalTsMessage
    //##################################################

    public class MyMetaAutoLogin_LastTouchedLocalTsMessage
        extends KmMetaStringProperty<MyAutoLogin>
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
        public String getValueFor(MyAutoLogin model)
        {
            return model.getLastTouchedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyAutoLogin model, String value)
        {
            return model.hasLastTouchedLocalTsMessage(value);
        }
    }

    //##################################################
    //# LastTouchedLocalDate
    //##################################################

    public class MyMetaAutoLogin_LastTouchedLocalDate
        extends KmMetaDateProperty<MyAutoLogin>
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
        public KmDate getValueFor(MyAutoLogin model)
        {
            return model.getLastTouchedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyAutoLogin model, KmDate value)
        {
            return model.hasLastTouchedLocalDate(value);
        }
    }

    //##################################################
    //# LastTouchedLocalTime
    //##################################################

    public class MyMetaAutoLogin_LastTouchedLocalTime
        extends KmMetaTimeProperty<MyAutoLogin>
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
        public KmTime getValueFor(MyAutoLogin model)
        {
            return model.getLastTouchedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyAutoLogin model, KmTime value)
        {
            return model.hasLastTouchedLocalTime(value);
        }
    }

    //##################################################
    //# UserFullName
    //##################################################

    public class MyMetaAutoLogin_UserFullName
        extends KmMetaStringProperty<MyAutoLogin>
    {
        @Override
        public String getName()
        {
            return "userFullName";
        }

        @Override
        public String getLabel()
        {
            return "User";
        }

        @Override
        public String getHelp()
        {
            return "The first and last name together; e.g.: John Smith. Use the nickname if the first and last names are both empty. This should never be blank.";
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
        public String getValueFor(MyAutoLogin model)
        {
            return model.getUserFullName();
        }

        @Override
        public void setValueFor(MyAutoLogin model, String value)
        {
            model.setUserFullName(value);
        }

        @Override
        public boolean hasValueFor(MyAutoLogin model, String value)
        {
            return model.hasUserFullName(value);
        }
    }

    //##################################################
    //# TenantName
    //##################################################

    public class MyMetaAutoLogin_TenantName
        extends KmMetaStringProperty<MyAutoLogin>
    {
        @Override
        public String getName()
        {
            return "tenantName";
        }

        @Override
        public String getLabel()
        {
            return "Tenant";
        }

        @Override
        public String getHelp()
        {
            return "The short display name of this tenant.";
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
        public String getValueFor(MyAutoLogin model)
        {
            return model.getTenantName();
        }

        @Override
        public void setValueFor(MyAutoLogin model, String value)
        {
            model.setTenantName(value);
        }

        @Override
        public boolean hasValueFor(MyAutoLogin model, String value)
        {
            return model.hasTenantName(value);
        }
    }


    //##################################################
    //# User
    //##################################################

    public class MyMetaAutoLogin_User
        extends KmMetaDaoAssociation<MyAutoLogin,MyUser>
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
            return "The user associated with this login.";
        }

        @Override
        public boolean isRequired()
        {
            return true;
        }

        @Override
        public MyUser getValueFor(MyAutoLogin model)
        {
            return model.getUser();
        }

        @Override
        public void setValueFor(MyAutoLogin model, MyUser value)
        {
            model.setUser(value);
        }

        @Override
        public boolean hasValueFor(MyAutoLogin model, MyUser value)
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
