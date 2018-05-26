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

public class MyMetaPasswordReset
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaPasswordReset instance = new MyMetaPasswordReset();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaPasswordReset()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "passwordReset";
    }

    public MyPasswordResetValidator getValidator()
    {
        return MyPasswordResetValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "A request to reset a user's password.  When a user requests to reset a password, we confirm the request by sending an email. When the user responds to the email, the response is checked against this record to authenticate the request.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaPasswordReset_AuditLogTitle AuditLogTitle = new MyMetaPasswordReset_AuditLogTitle();
    public final MyMetaPasswordReset_CreatedUtcTs CreatedUtcTs = new MyMetaPasswordReset_CreatedUtcTs();
    public final MyMetaPasswordReset_DomainSubtitle DomainSubtitle = new MyMetaPasswordReset_DomainSubtitle();
    public final MyMetaPasswordReset_DomainTitle DomainTitle = new MyMetaPasswordReset_DomainTitle();
    public final MyMetaPasswordReset_Email Email = new MyMetaPasswordReset_Email();
    public final MyMetaPasswordReset_ExpirationUtcTs ExpirationUtcTs = new MyMetaPasswordReset_ExpirationUtcTs();
    public final MyMetaPasswordReset_Token Token = new MyMetaPasswordReset_Token();
    public final MyMetaPasswordReset_Uid Uid = new MyMetaPasswordReset_Uid();
    public final MyMetaPasswordReset_UpdatedUtcTs UpdatedUtcTs = new MyMetaPasswordReset_UpdatedUtcTs();
    public final MyMetaPasswordReset_LockVersion LockVersion = new MyMetaPasswordReset_LockVersion();
    public final MyMetaPasswordReset_CreatedLocalTs CreatedLocalTs = new MyMetaPasswordReset_CreatedLocalTs();
    public final MyMetaPasswordReset_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaPasswordReset_CreatedLocalTsMessage();
    public final MyMetaPasswordReset_CreatedLocalDate CreatedLocalDate = new MyMetaPasswordReset_CreatedLocalDate();
    public final MyMetaPasswordReset_CreatedLocalTime CreatedLocalTime = new MyMetaPasswordReset_CreatedLocalTime();
    public final MyMetaPasswordReset_ExpirationLocalTs ExpirationLocalTs = new MyMetaPasswordReset_ExpirationLocalTs();
    public final MyMetaPasswordReset_ExpirationLocalTsMessage ExpirationLocalTsMessage = new MyMetaPasswordReset_ExpirationLocalTsMessage();
    public final MyMetaPasswordReset_ExpirationLocalDate ExpirationLocalDate = new MyMetaPasswordReset_ExpirationLocalDate();
    public final MyMetaPasswordReset_ExpirationLocalTime ExpirationLocalTime = new MyMetaPasswordReset_ExpirationLocalTime();
    public final MyMetaPasswordReset_UpdatedLocalTs UpdatedLocalTs = new MyMetaPasswordReset_UpdatedLocalTs();
    public final MyMetaPasswordReset_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaPasswordReset_UpdatedLocalTsMessage();
    public final MyMetaPasswordReset_UpdatedLocalDate UpdatedLocalDate = new MyMetaPasswordReset_UpdatedLocalDate();
    public final MyMetaPasswordReset_UpdatedLocalTime UpdatedLocalTime = new MyMetaPasswordReset_UpdatedLocalTime();
    public final MyMetaPasswordReset_CreatedByFullName CreatedByFullName = new MyMetaPasswordReset_CreatedByFullName();
    public final MyMetaPasswordReset_UpdatedByFullName UpdatedByFullName = new MyMetaPasswordReset_UpdatedByFullName();

    //##################################################
    //# associations
    //##################################################

    public final MyMetaPasswordReset_CreatedBy CreatedBy = new MyMetaPasswordReset_CreatedBy();
    public final MyMetaPasswordReset_Tenant Tenant = new MyMetaPasswordReset_Tenant();
    public final MyMetaPasswordReset_UpdatedBy UpdatedBy = new MyMetaPasswordReset_UpdatedBy();

    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaPasswordReset_AuditLogTitle
        extends KmMetaStringProperty<MyPasswordReset>
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
        public String getValueFor(MyPasswordReset model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyPasswordReset model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaPasswordReset_CreatedUtcTs
        extends KmMetaTimestampProperty<MyPasswordReset>
        implements KmMetaDaoPropertyIF<MyPasswordReset,KmTimestamp>
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
            return MyPasswordResetValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MyPasswordResetDao getDao()
        {
            return getAccess().getPasswordResetDao();
        }

        @Override
        public KmTimestamp getValueFor(MyPasswordReset model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MyPasswordReset model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyPasswordReset model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaPasswordReset_DomainSubtitle
        extends KmMetaStringProperty<MyPasswordReset>
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
        public String getValueFor(MyPasswordReset model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyPasswordReset model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaPasswordReset_DomainTitle
        extends KmMetaStringProperty<MyPasswordReset>
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
        public String getValueFor(MyPasswordReset model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyPasswordReset model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# Email
    //##################################################

    public class MyMetaPasswordReset_Email
        extends KmMetaStringProperty<MyPasswordReset>
        implements KmMetaDaoPropertyIF<MyPasswordReset,String>
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
            return "The email to be reset.";
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
            return MyPasswordResetValidator.instance.getEmailValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "email";
        }

        @Override
        public MyPasswordResetDao getDao()
        {
            return getAccess().getPasswordResetDao();
        }

        @Override
        public String getValueFor(MyPasswordReset model)
        {
            return model.getEmail();
        }

        @Override
        public void setValueFor(MyPasswordReset model, String value)
        {
            model.setEmail(value);
        }

        @Override
        public boolean hasValueFor(MyPasswordReset model, String value)
        {
            return model.hasEmail(value);
        }
    }

    //##################################################
    //# ExpirationUtcTs
    //##################################################

    public class MyMetaPasswordReset_ExpirationUtcTs
        extends KmMetaTimestampProperty<MyPasswordReset>
        implements KmMetaDaoPropertyIF<MyPasswordReset,KmTimestamp>
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
            return "The date and time when this request expires.";
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
            return MyPasswordResetValidator.instance.getExpirationUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "expirationUtcTs";
        }

        @Override
        public MyPasswordResetDao getDao()
        {
            return getAccess().getPasswordResetDao();
        }

        @Override
        public KmTimestamp getValueFor(MyPasswordReset model)
        {
            return model.getExpirationUtcTs();
        }

        @Override
        public void setValueFor(MyPasswordReset model, KmTimestamp value)
        {
            model.setExpirationUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyPasswordReset model, KmTimestamp value)
        {
            return model.hasExpirationUtcTs(value);
        }
    }

    //##################################################
    //# Token
    //##################################################

    public class MyMetaPasswordReset_Token
        extends KmMetaStringProperty<MyPasswordReset>
        implements KmMetaDaoPropertyIF<MyPasswordReset,String>
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
            return "A long unique code that allows temporary access without a password.";
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
            return MyPasswordResetValidator.instance.getTokenValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "token";
        }

        @Override
        public MyPasswordResetDao getDao()
        {
            return getAccess().getPasswordResetDao();
        }

        @Override
        public String getValueFor(MyPasswordReset model)
        {
            return model.getToken();
        }

        @Override
        public void setValueFor(MyPasswordReset model, String value)
        {
            model.setToken(value);
        }

        @Override
        public boolean hasValueFor(MyPasswordReset model, String value)
        {
            return model.hasToken(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaPasswordReset_Uid
        extends KmMetaStringProperty<MyPasswordReset>
        implements KmMetaDaoPropertyIF<MyPasswordReset,String>
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
            return MyPasswordResetValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyPasswordResetDao getDao()
        {
            return getAccess().getPasswordResetDao();
        }

        public KmDaoStringKeyCursor<MyPasswordReset> createCursor()
        {
            KmDaoStringKeyCursor<MyPasswordReset> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyPasswordReset model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyPasswordReset model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyPasswordReset model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# UpdatedUtcTs
    //##################################################

    public class MyMetaPasswordReset_UpdatedUtcTs
        extends KmMetaTimestampProperty<MyPasswordReset>
        implements KmMetaDaoPropertyIF<MyPasswordReset,KmTimestamp>
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
            return MyPasswordResetValidator.instance.getUpdatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "updatedUtcTs";
        }

        @Override
        public MyPasswordResetDao getDao()
        {
            return getAccess().getPasswordResetDao();
        }

        @Override
        public KmTimestamp getValueFor(MyPasswordReset model)
        {
            return model.getUpdatedUtcTs();
        }

        @Override
        public void setValueFor(MyPasswordReset model, KmTimestamp value)
        {
            model.setUpdatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyPasswordReset model, KmTimestamp value)
        {
            return model.hasUpdatedUtcTs(value);
        }
    }

    //##################################################
    //# LockVersion
    //##################################################

    public class MyMetaPasswordReset_LockVersion
        extends KmMetaIntegerProperty<MyPasswordReset>
        implements KmMetaDaoPropertyIF<MyPasswordReset,Integer>
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
            return MyPasswordResetValidator.instance.getLockVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lockVersion";
        }

        @Override
        public MyPasswordResetDao getDao()
        {
            return getAccess().getPasswordResetDao();
        }

        @Override
        public Integer getValueFor(MyPasswordReset model)
        {
            return model.getLockVersion();
        }

        @Override
        public void setValueFor(MyPasswordReset model, Integer value)
        {
            model.setLockVersion(value);
        }

        @Override
        public boolean hasValueFor(MyPasswordReset model, Integer value)
        {
            return model.hasLockVersion(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaPasswordReset_CreatedLocalTs
        extends KmMetaTimestampProperty<MyPasswordReset>
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
        public KmTimestamp getValueFor(MyPasswordReset model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyPasswordReset model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaPasswordReset_CreatedLocalTsMessage
        extends KmMetaStringProperty<MyPasswordReset>
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
        public String getValueFor(MyPasswordReset model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyPasswordReset model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaPasswordReset_CreatedLocalDate
        extends KmMetaDateProperty<MyPasswordReset>
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
        public KmDate getValueFor(MyPasswordReset model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyPasswordReset model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaPasswordReset_CreatedLocalTime
        extends KmMetaTimeProperty<MyPasswordReset>
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
        public KmTime getValueFor(MyPasswordReset model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyPasswordReset model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }

    //##################################################
    //# ExpirationLocalTs
    //##################################################

    public class MyMetaPasswordReset_ExpirationLocalTs
        extends KmMetaTimestampProperty<MyPasswordReset>
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
        public KmTimestamp getValueFor(MyPasswordReset model)
        {
            return model.getExpirationLocalTs();
        }

        @Override
        public boolean hasValueFor(MyPasswordReset model, KmTimestamp value)
        {
            return model.hasExpirationLocalTs(value);
        }
    }

    //##################################################
    //# ExpirationLocalTsMessage
    //##################################################

    public class MyMetaPasswordReset_ExpirationLocalTsMessage
        extends KmMetaStringProperty<MyPasswordReset>
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
        public String getValueFor(MyPasswordReset model)
        {
            return model.getExpirationLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyPasswordReset model, String value)
        {
            return model.hasExpirationLocalTsMessage(value);
        }
    }

    //##################################################
    //# ExpirationLocalDate
    //##################################################

    public class MyMetaPasswordReset_ExpirationLocalDate
        extends KmMetaDateProperty<MyPasswordReset>
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
        public KmDate getValueFor(MyPasswordReset model)
        {
            return model.getExpirationLocalDate();
        }

        @Override
        public boolean hasValueFor(MyPasswordReset model, KmDate value)
        {
            return model.hasExpirationLocalDate(value);
        }
    }

    //##################################################
    //# ExpirationLocalTime
    //##################################################

    public class MyMetaPasswordReset_ExpirationLocalTime
        extends KmMetaTimeProperty<MyPasswordReset>
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
        public KmTime getValueFor(MyPasswordReset model)
        {
            return model.getExpirationLocalTime();
        }

        @Override
        public boolean hasValueFor(MyPasswordReset model, KmTime value)
        {
            return model.hasExpirationLocalTime(value);
        }
    }

    //##################################################
    //# UpdatedLocalTs
    //##################################################

    public class MyMetaPasswordReset_UpdatedLocalTs
        extends KmMetaTimestampProperty<MyPasswordReset>
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
        public KmTimestamp getValueFor(MyPasswordReset model)
        {
            return model.getUpdatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyPasswordReset model, KmTimestamp value)
        {
            return model.hasUpdatedLocalTs(value);
        }
    }

    //##################################################
    //# UpdatedLocalTsMessage
    //##################################################

    public class MyMetaPasswordReset_UpdatedLocalTsMessage
        extends KmMetaStringProperty<MyPasswordReset>
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
        public String getValueFor(MyPasswordReset model)
        {
            return model.getUpdatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyPasswordReset model, String value)
        {
            return model.hasUpdatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# UpdatedLocalDate
    //##################################################

    public class MyMetaPasswordReset_UpdatedLocalDate
        extends KmMetaDateProperty<MyPasswordReset>
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
        public KmDate getValueFor(MyPasswordReset model)
        {
            return model.getUpdatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyPasswordReset model, KmDate value)
        {
            return model.hasUpdatedLocalDate(value);
        }
    }

    //##################################################
    //# UpdatedLocalTime
    //##################################################

    public class MyMetaPasswordReset_UpdatedLocalTime
        extends KmMetaTimeProperty<MyPasswordReset>
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
        public KmTime getValueFor(MyPasswordReset model)
        {
            return model.getUpdatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyPasswordReset model, KmTime value)
        {
            return model.hasUpdatedLocalTime(value);
        }
    }

    //##################################################
    //# CreatedByFullName
    //##################################################

    public class MyMetaPasswordReset_CreatedByFullName
        extends KmMetaStringProperty<MyPasswordReset>
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
        public String getValueFor(MyPasswordReset model)
        {
            return model.getCreatedByFullName();
        }

        @Override
        public void setValueFor(MyPasswordReset model, String value)
        {
            model.setCreatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyPasswordReset model, String value)
        {
            return model.hasCreatedByFullName(value);
        }
    }

    //##################################################
    //# UpdatedByFullName
    //##################################################

    public class MyMetaPasswordReset_UpdatedByFullName
        extends KmMetaStringProperty<MyPasswordReset>
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
        public String getValueFor(MyPasswordReset model)
        {
            return model.getUpdatedByFullName();
        }

        @Override
        public void setValueFor(MyPasswordReset model, String value)
        {
            model.setUpdatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyPasswordReset model, String value)
        {
            return model.hasUpdatedByFullName(value);
        }
    }


    //##################################################
    //# CreatedBy
    //##################################################

    public class MyMetaPasswordReset_CreatedBy
        extends KmMetaDaoAssociation<MyPasswordReset,MyUser>
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
        public MyUser getValueFor(MyPasswordReset model)
        {
            return model.getCreatedBy();
        }

        @Override
        public void setValueFor(MyPasswordReset model, MyUser value)
        {
            model.setCreatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyPasswordReset model, MyUser value)
        {
            return model.hasCreatedBy(value);
        }
    }

    //##################################################
    //# Tenant
    //##################################################

    public class MyMetaPasswordReset_Tenant
        extends KmMetaDaoAssociation<MyPasswordReset,MyTenant>
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
        public MyTenant getValueFor(MyPasswordReset model)
        {
            return model.getTenant();
        }

        @Override
        public void setValueFor(MyPasswordReset model, MyTenant value)
        {
            model.setTenant(value);
        }

        @Override
        public boolean hasValueFor(MyPasswordReset model, MyTenant value)
        {
            return model.hasTenant(value);
        }
    }

    //##################################################
    //# UpdatedBy
    //##################################################

    public class MyMetaPasswordReset_UpdatedBy
        extends KmMetaDaoAssociation<MyPasswordReset,MyUser>
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
        public MyUser getValueFor(MyPasswordReset model)
        {
            return model.getUpdatedBy();
        }

        @Override
        public void setValueFor(MyPasswordReset model, MyUser value)
        {
            model.setUpdatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyPasswordReset model, MyUser value)
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
