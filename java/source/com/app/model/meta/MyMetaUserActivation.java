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

public class MyMetaUserActivation
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaUserActivation instance = new MyMetaUserActivation();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaUserActivation()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "userActivation";
    }

    public MyUserActivationValidator getValidator()
    {
        return MyUserActivationValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "A request to activate a new user account via email.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaUserActivation_AuditLogTitle AuditLogTitle = new MyMetaUserActivation_AuditLogTitle();
    public final MyMetaUserActivation_CreatedUtcTs CreatedUtcTs = new MyMetaUserActivation_CreatedUtcTs();
    public final MyMetaUserActivation_DomainSubtitle DomainSubtitle = new MyMetaUserActivation_DomainSubtitle();
    public final MyMetaUserActivation_DomainTitle DomainTitle = new MyMetaUserActivation_DomainTitle();
    public final MyMetaUserActivation_Email Email = new MyMetaUserActivation_Email();
    public final MyMetaUserActivation_ExpirationUtcTs ExpirationUtcTs = new MyMetaUserActivation_ExpirationUtcTs();
    public final MyMetaUserActivation_Token Token = new MyMetaUserActivation_Token();
    public final MyMetaUserActivation_Uid Uid = new MyMetaUserActivation_Uid();
    public final MyMetaUserActivation_UpdatedUtcTs UpdatedUtcTs = new MyMetaUserActivation_UpdatedUtcTs();
    public final MyMetaUserActivation_LockVersion LockVersion = new MyMetaUserActivation_LockVersion();
    public final MyMetaUserActivation_CreatedLocalTs CreatedLocalTs = new MyMetaUserActivation_CreatedLocalTs();
    public final MyMetaUserActivation_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaUserActivation_CreatedLocalTsMessage();
    public final MyMetaUserActivation_CreatedLocalDate CreatedLocalDate = new MyMetaUserActivation_CreatedLocalDate();
    public final MyMetaUserActivation_CreatedLocalTime CreatedLocalTime = new MyMetaUserActivation_CreatedLocalTime();
    public final MyMetaUserActivation_ExpirationLocalTs ExpirationLocalTs = new MyMetaUserActivation_ExpirationLocalTs();
    public final MyMetaUserActivation_ExpirationLocalTsMessage ExpirationLocalTsMessage = new MyMetaUserActivation_ExpirationLocalTsMessage();
    public final MyMetaUserActivation_ExpirationLocalDate ExpirationLocalDate = new MyMetaUserActivation_ExpirationLocalDate();
    public final MyMetaUserActivation_ExpirationLocalTime ExpirationLocalTime = new MyMetaUserActivation_ExpirationLocalTime();
    public final MyMetaUserActivation_UpdatedLocalTs UpdatedLocalTs = new MyMetaUserActivation_UpdatedLocalTs();
    public final MyMetaUserActivation_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaUserActivation_UpdatedLocalTsMessage();
    public final MyMetaUserActivation_UpdatedLocalDate UpdatedLocalDate = new MyMetaUserActivation_UpdatedLocalDate();
    public final MyMetaUserActivation_UpdatedLocalTime UpdatedLocalTime = new MyMetaUserActivation_UpdatedLocalTime();
    public final MyMetaUserActivation_CreatedByFullName CreatedByFullName = new MyMetaUserActivation_CreatedByFullName();
    public final MyMetaUserActivation_UpdatedByFullName UpdatedByFullName = new MyMetaUserActivation_UpdatedByFullName();

    //##################################################
    //# associations
    //##################################################

    public final MyMetaUserActivation_CreatedBy CreatedBy = new MyMetaUserActivation_CreatedBy();
    public final MyMetaUserActivation_Tenant Tenant = new MyMetaUserActivation_Tenant();
    public final MyMetaUserActivation_UpdatedBy UpdatedBy = new MyMetaUserActivation_UpdatedBy();

    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaUserActivation_AuditLogTitle
        extends KmMetaStringProperty<MyUserActivation>
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
        public String getValueFor(MyUserActivation model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyUserActivation model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaUserActivation_CreatedUtcTs
        extends KmMetaTimestampProperty<MyUserActivation>
        implements KmMetaDaoPropertyIF<MyUserActivation,KmTimestamp>
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
            return MyUserActivationValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MyUserActivationDao getDao()
        {
            return getAccess().getUserActivationDao();
        }

        @Override
        public KmTimestamp getValueFor(MyUserActivation model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MyUserActivation model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyUserActivation model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaUserActivation_DomainSubtitle
        extends KmMetaStringProperty<MyUserActivation>
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
        public String getValueFor(MyUserActivation model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyUserActivation model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaUserActivation_DomainTitle
        extends KmMetaStringProperty<MyUserActivation>
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
        public String getValueFor(MyUserActivation model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyUserActivation model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# Email
    //##################################################

    public class MyMetaUserActivation_Email
        extends KmMetaStringProperty<MyUserActivation>
        implements KmMetaDaoPropertyIF<MyUserActivation,String>
    {
        @Override
        public String getName()
        {
            return "email";
        }

        @Override
        public String getLabel()
        {
            return "Email";
        }

        @Override
        public String getHelp()
        {
            return "The email to be activated.";
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
            return MyUserActivationValidator.instance.getEmailValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "email";
        }

        @Override
        public MyUserActivationDao getDao()
        {
            return getAccess().getUserActivationDao();
        }

        @Override
        public String getValueFor(MyUserActivation model)
        {
            return model.getEmail();
        }

        @Override
        public void setValueFor(MyUserActivation model, String value)
        {
            model.setEmail(value);
        }

        @Override
        public boolean hasValueFor(MyUserActivation model, String value)
        {
            return model.hasEmail(value);
        }
    }

    //##################################################
    //# ExpirationUtcTs
    //##################################################

    public class MyMetaUserActivation_ExpirationUtcTs
        extends KmMetaTimestampProperty<MyUserActivation>
        implements KmMetaDaoPropertyIF<MyUserActivation,KmTimestamp>
    {
        @Override
        public String getName()
        {
            return "expirationUtcTs";
        }

        @Override
        public String getLabel()
        {
            return "Expiration Utc Ts";
        }

        @Override
        public String getHelp()
        {
            return "The date and time when this activation expires.";
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
            return MyUserActivationValidator.instance.getExpirationUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "expirationUtcTs";
        }

        @Override
        public MyUserActivationDao getDao()
        {
            return getAccess().getUserActivationDao();
        }

        @Override
        public KmTimestamp getValueFor(MyUserActivation model)
        {
            return model.getExpirationUtcTs();
        }

        @Override
        public void setValueFor(MyUserActivation model, KmTimestamp value)
        {
            model.setExpirationUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyUserActivation model, KmTimestamp value)
        {
            return model.hasExpirationUtcTs(value);
        }
    }

    //##################################################
    //# Token
    //##################################################

    public class MyMetaUserActivation_Token
        extends KmMetaStringProperty<MyUserActivation>
        implements KmMetaDaoPropertyIF<MyUserActivation,String>
    {
        @Override
        public String getName()
        {
            return "token";
        }

        @Override
        public String getLabel()
        {
            return "Token";
        }

        @Override
        public String getHelp()
        {
            return "A long unique code that allows access without a password.";
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
            return MyUserActivationValidator.instance.getTokenValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "token";
        }

        @Override
        public MyUserActivationDao getDao()
        {
            return getAccess().getUserActivationDao();
        }

        @Override
        public String getValueFor(MyUserActivation model)
        {
            return model.getToken();
        }

        @Override
        public void setValueFor(MyUserActivation model, String value)
        {
            model.setToken(value);
        }

        @Override
        public boolean hasValueFor(MyUserActivation model, String value)
        {
            return model.hasToken(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaUserActivation_Uid
        extends KmMetaStringProperty<MyUserActivation>
        implements KmMetaDaoPropertyIF<MyUserActivation,String>
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
            return MyUserActivationValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyUserActivationDao getDao()
        {
            return getAccess().getUserActivationDao();
        }

        public KmDaoStringKeyCursor<MyUserActivation> createCursor()
        {
            KmDaoStringKeyCursor<MyUserActivation> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyUserActivation model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyUserActivation model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyUserActivation model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# UpdatedUtcTs
    //##################################################

    public class MyMetaUserActivation_UpdatedUtcTs
        extends KmMetaTimestampProperty<MyUserActivation>
        implements KmMetaDaoPropertyIF<MyUserActivation,KmTimestamp>
    {
        @Override
        public String getName()
        {
            return "updatedUtcTs";
        }

        @Override
        public String getLabel()
        {
            return "Updated Utc Ts";
        }

        @Override
        public String getHelp()
        {
            return "The time this record was last updated.";
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
            return MyUserActivationValidator.instance.getUpdatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "updatedUtcTs";
        }

        @Override
        public MyUserActivationDao getDao()
        {
            return getAccess().getUserActivationDao();
        }

        @Override
        public KmTimestamp getValueFor(MyUserActivation model)
        {
            return model.getUpdatedUtcTs();
        }

        @Override
        public void setValueFor(MyUserActivation model, KmTimestamp value)
        {
            model.setUpdatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyUserActivation model, KmTimestamp value)
        {
            return model.hasUpdatedUtcTs(value);
        }
    }

    //##################################################
    //# LockVersion
    //##################################################

    public class MyMetaUserActivation_LockVersion
        extends KmMetaIntegerProperty<MyUserActivation>
        implements KmMetaDaoPropertyIF<MyUserActivation,Integer>
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
            return MyUserActivationValidator.instance.getLockVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lockVersion";
        }

        @Override
        public MyUserActivationDao getDao()
        {
            return getAccess().getUserActivationDao();
        }

        @Override
        public Integer getValueFor(MyUserActivation model)
        {
            return model.getLockVersion();
        }

        @Override
        public void setValueFor(MyUserActivation model, Integer value)
        {
            model.setLockVersion(value);
        }

        @Override
        public boolean hasValueFor(MyUserActivation model, Integer value)
        {
            return model.hasLockVersion(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaUserActivation_CreatedLocalTs
        extends KmMetaTimestampProperty<MyUserActivation>
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
        public KmTimestamp getValueFor(MyUserActivation model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyUserActivation model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaUserActivation_CreatedLocalTsMessage
        extends KmMetaStringProperty<MyUserActivation>
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
        public String getValueFor(MyUserActivation model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyUserActivation model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaUserActivation_CreatedLocalDate
        extends KmMetaDateProperty<MyUserActivation>
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
        public KmDate getValueFor(MyUserActivation model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyUserActivation model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaUserActivation_CreatedLocalTime
        extends KmMetaTimeProperty<MyUserActivation>
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
        public KmTime getValueFor(MyUserActivation model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyUserActivation model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }

    //##################################################
    //# ExpirationLocalTs
    //##################################################

    public class MyMetaUserActivation_ExpirationLocalTs
        extends KmMetaTimestampProperty<MyUserActivation>
    {
        @Override
        public String getName()
        {
            return "expirationLocalTs";
        }

        @Override
        public String getLabel()
        {
            return "Expiration";
        }

        @Override
        public String getHelp()
        {
            return "The expiration timestamp converted to the user's local timezone.";
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
        public KmTimestamp getValueFor(MyUserActivation model)
        {
            return model.getExpirationLocalTs();
        }

        @Override
        public boolean hasValueFor(MyUserActivation model, KmTimestamp value)
        {
            return model.hasExpirationLocalTs(value);
        }
    }

    //##################################################
    //# ExpirationLocalTsMessage
    //##################################################

    public class MyMetaUserActivation_ExpirationLocalTsMessage
        extends KmMetaStringProperty<MyUserActivation>
    {
        @Override
        public String getName()
        {
            return "expirationLocalTsMessage";
        }

        @Override
        public String getLabel()
        {
            return "Expiration";
        }

        @Override
        public String getHelp()
        {
            return "The expiration timestamp converted to the user's local timezone, and formatted as a string that includes the timezone code.";
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
        public String getValueFor(MyUserActivation model)
        {
            return model.getExpirationLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyUserActivation model, String value)
        {
            return model.hasExpirationLocalTsMessage(value);
        }
    }

    //##################################################
    //# ExpirationLocalDate
    //##################################################

    public class MyMetaUserActivation_ExpirationLocalDate
        extends KmMetaDateProperty<MyUserActivation>
    {
        @Override
        public String getName()
        {
            return "expirationLocalDate";
        }

        @Override
        public String getLabel()
        {
            return "Expiration";
        }

        @Override
        public String getHelp()
        {
            return "The expiration date based on the user's local timezone.";
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
        public KmDate getValueFor(MyUserActivation model)
        {
            return model.getExpirationLocalDate();
        }

        @Override
        public boolean hasValueFor(MyUserActivation model, KmDate value)
        {
            return model.hasExpirationLocalDate(value);
        }
    }

    //##################################################
    //# ExpirationLocalTime
    //##################################################

    public class MyMetaUserActivation_ExpirationLocalTime
        extends KmMetaTimeProperty<MyUserActivation>
    {
        @Override
        public String getName()
        {
            return "expirationLocalTime";
        }

        @Override
        public String getLabel()
        {
            return "Expiration";
        }

        @Override
        public String getHelp()
        {
            return "The expiration time of day based on the user's local timezone.";
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
        public KmTime getValueFor(MyUserActivation model)
        {
            return model.getExpirationLocalTime();
        }

        @Override
        public boolean hasValueFor(MyUserActivation model, KmTime value)
        {
            return model.hasExpirationLocalTime(value);
        }
    }

    //##################################################
    //# UpdatedLocalTs
    //##################################################

    public class MyMetaUserActivation_UpdatedLocalTs
        extends KmMetaTimestampProperty<MyUserActivation>
    {
        @Override
        public String getName()
        {
            return "updatedLocalTs";
        }

        @Override
        public String getLabel()
        {
            return "Updated";
        }

        @Override
        public String getHelp()
        {
            return "The updated timestamp converted to the user's local timezone.";
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
        public KmTimestamp getValueFor(MyUserActivation model)
        {
            return model.getUpdatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyUserActivation model, KmTimestamp value)
        {
            return model.hasUpdatedLocalTs(value);
        }
    }

    //##################################################
    //# UpdatedLocalTsMessage
    //##################################################

    public class MyMetaUserActivation_UpdatedLocalTsMessage
        extends KmMetaStringProperty<MyUserActivation>
    {
        @Override
        public String getName()
        {
            return "updatedLocalTsMessage";
        }

        @Override
        public String getLabel()
        {
            return "Updated";
        }

        @Override
        public String getHelp()
        {
            return "The updated timestamp converted to the user's local timezone, and formatted as a string that includes the timezone code.";
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
        public String getValueFor(MyUserActivation model)
        {
            return model.getUpdatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyUserActivation model, String value)
        {
            return model.hasUpdatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# UpdatedLocalDate
    //##################################################

    public class MyMetaUserActivation_UpdatedLocalDate
        extends KmMetaDateProperty<MyUserActivation>
    {
        @Override
        public String getName()
        {
            return "updatedLocalDate";
        }

        @Override
        public String getLabel()
        {
            return "Updated";
        }

        @Override
        public String getHelp()
        {
            return "The updated date based on the user's local timezone.";
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
        public KmDate getValueFor(MyUserActivation model)
        {
            return model.getUpdatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyUserActivation model, KmDate value)
        {
            return model.hasUpdatedLocalDate(value);
        }
    }

    //##################################################
    //# UpdatedLocalTime
    //##################################################

    public class MyMetaUserActivation_UpdatedLocalTime
        extends KmMetaTimeProperty<MyUserActivation>
    {
        @Override
        public String getName()
        {
            return "updatedLocalTime";
        }

        @Override
        public String getLabel()
        {
            return "Updated";
        }

        @Override
        public String getHelp()
        {
            return "The updated time of day based on the user's local timezone.";
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
        public KmTime getValueFor(MyUserActivation model)
        {
            return model.getUpdatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyUserActivation model, KmTime value)
        {
            return model.hasUpdatedLocalTime(value);
        }
    }

    //##################################################
    //# CreatedByFullName
    //##################################################

    public class MyMetaUserActivation_CreatedByFullName
        extends KmMetaStringProperty<MyUserActivation>
    {
        @Override
        public String getName()
        {
            return "createdByFullName";
        }

        @Override
        public String getLabel()
        {
            return "Created By";
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
        public String getValueFor(MyUserActivation model)
        {
            return model.getCreatedByFullName();
        }

        @Override
        public void setValueFor(MyUserActivation model, String value)
        {
            model.setCreatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyUserActivation model, String value)
        {
            return model.hasCreatedByFullName(value);
        }
    }

    //##################################################
    //# UpdatedByFullName
    //##################################################

    public class MyMetaUserActivation_UpdatedByFullName
        extends KmMetaStringProperty<MyUserActivation>
    {
        @Override
        public String getName()
        {
            return "updatedByFullName";
        }

        @Override
        public String getLabel()
        {
            return "Updated By";
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
        public String getValueFor(MyUserActivation model)
        {
            return model.getUpdatedByFullName();
        }

        @Override
        public void setValueFor(MyUserActivation model, String value)
        {
            model.setUpdatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyUserActivation model, String value)
        {
            return model.hasUpdatedByFullName(value);
        }
    }


    //##################################################
    //# CreatedBy
    //##################################################

    public class MyMetaUserActivation_CreatedBy
        extends KmMetaDaoAssociation<MyUserActivation,MyUser>
    {
        @Override
        public String getName()
        {
            return "createdBy";
        }

        @Override
        public String getLabel()
        {
            return "Created By";
        }

        @Override
        public String getHelp()
        {
            return "The user that originally created this record, if known.";
        }

        @Override
        public boolean isRequired()
        {
            return false;
        }

        @Override
        public MyUser getValueFor(MyUserActivation model)
        {
            return model.getCreatedBy();
        }

        @Override
        public void setValueFor(MyUserActivation model, MyUser value)
        {
            model.setCreatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyUserActivation model, MyUser value)
        {
            return model.hasCreatedBy(value);
        }
    }

    //##################################################
    //# Tenant
    //##################################################

    public class MyMetaUserActivation_Tenant
        extends KmMetaDaoAssociation<MyUserActivation,MyTenant>
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
        public MyTenant getValueFor(MyUserActivation model)
        {
            return model.getTenant();
        }

        @Override
        public void setValueFor(MyUserActivation model, MyTenant value)
        {
            model.setTenant(value);
        }

        @Override
        public boolean hasValueFor(MyUserActivation model, MyTenant value)
        {
            return model.hasTenant(value);
        }
    }

    //##################################################
    //# UpdatedBy
    //##################################################

    public class MyMetaUserActivation_UpdatedBy
        extends KmMetaDaoAssociation<MyUserActivation,MyUser>
    {
        @Override
        public String getName()
        {
            return "updatedBy";
        }

        @Override
        public String getLabel()
        {
            return "Updated By";
        }

        @Override
        public String getHelp()
        {
            return "The user that last updated this record, if known.";
        }

        @Override
        public boolean isRequired()
        {
            return false;
        }

        @Override
        public MyUser getValueFor(MyUserActivation model)
        {
            return model.getUpdatedBy();
        }

        @Override
        public void setValueFor(MyUserActivation model, MyUser value)
        {
            model.setUpdatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyUserActivation model, MyUser value)
        {
            return model.hasUpdatedBy(value);
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
