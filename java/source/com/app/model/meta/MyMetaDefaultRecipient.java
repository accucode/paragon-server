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

public class MyMetaDefaultRecipient
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaDefaultRecipient instance = new MyMetaDefaultRecipient();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaDefaultRecipient()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "defaultRecipient";
    }

    public MyDefaultRecipientValidator getValidator()
    {
        return MyDefaultRecipientValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "Default recipients are simply pointers to contacts that should be the default recipients of emails generated from email templates.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaDefaultRecipient_AuditLogTitle AuditLogTitle = new MyMetaDefaultRecipient_AuditLogTitle();
    public final MyMetaDefaultRecipient_ContactTypeCode ContactTypeCode = new MyMetaDefaultRecipient_ContactTypeCode();
    public final MyMetaDefaultRecipient_CreatedUtcTs CreatedUtcTs = new MyMetaDefaultRecipient_CreatedUtcTs();
    public final MyMetaDefaultRecipient_CustomEmail CustomEmail = new MyMetaDefaultRecipient_CustomEmail();
    public final MyMetaDefaultRecipient_DomainSubtitle DomainSubtitle = new MyMetaDefaultRecipient_DomainSubtitle();
    public final MyMetaDefaultRecipient_DomainTitle DomainTitle = new MyMetaDefaultRecipient_DomainTitle();
    public final MyMetaDefaultRecipient_TypeCode TypeCode = new MyMetaDefaultRecipient_TypeCode();
    public final MyMetaDefaultRecipient_Uid Uid = new MyMetaDefaultRecipient_Uid();
    public final MyMetaDefaultRecipient_UpdatedUtcTs UpdatedUtcTs = new MyMetaDefaultRecipient_UpdatedUtcTs();
    public final MyMetaDefaultRecipient_LockVersion LockVersion = new MyMetaDefaultRecipient_LockVersion();
    public final MyMetaDefaultRecipient_ContactTypeName ContactTypeName = new MyMetaDefaultRecipient_ContactTypeName();
    public final MyMetaDefaultRecipient_TypeName TypeName = new MyMetaDefaultRecipient_TypeName();
    public final MyMetaDefaultRecipient_CreatedLocalTs CreatedLocalTs = new MyMetaDefaultRecipient_CreatedLocalTs();
    public final MyMetaDefaultRecipient_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaDefaultRecipient_CreatedLocalTsMessage();
    public final MyMetaDefaultRecipient_CreatedLocalDate CreatedLocalDate = new MyMetaDefaultRecipient_CreatedLocalDate();
    public final MyMetaDefaultRecipient_CreatedLocalTime CreatedLocalTime = new MyMetaDefaultRecipient_CreatedLocalTime();
    public final MyMetaDefaultRecipient_UpdatedLocalTs UpdatedLocalTs = new MyMetaDefaultRecipient_UpdatedLocalTs();
    public final MyMetaDefaultRecipient_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaDefaultRecipient_UpdatedLocalTsMessage();
    public final MyMetaDefaultRecipient_UpdatedLocalDate UpdatedLocalDate = new MyMetaDefaultRecipient_UpdatedLocalDate();
    public final MyMetaDefaultRecipient_UpdatedLocalTime UpdatedLocalTime = new MyMetaDefaultRecipient_UpdatedLocalTime();
    public final MyMetaDefaultRecipient_CreatedByFullName CreatedByFullName = new MyMetaDefaultRecipient_CreatedByFullName();
    public final MyMetaDefaultRecipient_UpdatedByFullName UpdatedByFullName = new MyMetaDefaultRecipient_UpdatedByFullName();

    //##################################################
    //# associations
    //##################################################

    public final MyMetaDefaultRecipient_CreatedBy CreatedBy = new MyMetaDefaultRecipient_CreatedBy();
    public final MyMetaDefaultRecipient_EmailTemplate EmailTemplate = new MyMetaDefaultRecipient_EmailTemplate();
    public final MyMetaDefaultRecipient_UpdatedBy UpdatedBy = new MyMetaDefaultRecipient_UpdatedBy();

    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaDefaultRecipient_AuditLogTitle
        extends KmMetaStringProperty<MyDefaultRecipient>
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
        public String getValueFor(MyDefaultRecipient model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyDefaultRecipient model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# ContactTypeCode
    //##################################################

    public class MyMetaDefaultRecipient_ContactTypeCode
        extends KmMetaStringProperty<MyDefaultRecipient>
        implements KmMetaDaoPropertyIF<MyDefaultRecipient,String>
    {
        @Override
        public String getName()
        {
            return "contactTypeCode";
        }

        @Override
        public String getLabel()
        {
            return "Contact Type Code";
        }

        @Override
        public String getHelp()
        {
            return "The contact type for this recipient (e.g. Main, Install, etc.).";
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
            return MyDefaultRecipientValidator.instance.getContactTypeCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "contactTypeCode";
        }

        @Override
        public MyDefaultRecipientDao getDao()
        {
            return getAccess().getDefaultRecipientDao();
        }

        public ScDynamicEnumDropdownField newDropdown()
        {
            ScDynamicEnumDropdownField e;
            e = new ScDynamicEnumDropdownField();
            e.setMeta(this);
            e.setEnumArraySupplier(MyDefaultRecipientContactType::values);
            return e;
        }

        public ScDynamicEnumDropdownField newDropdown(String label)
        {
            ScDynamicEnumDropdownField e;
            e = newDropdown();
            e.setLabel(label);
            return e;
        }

        @Override
        public String getValueFor(MyDefaultRecipient model)
        {
            return model.getContactTypeCode();
        }

        @Override
        public void setValueFor(MyDefaultRecipient model, String value)
        {
            model.setContactTypeCode(value);
        }

        @Override
        public boolean hasValueFor(MyDefaultRecipient model, String value)
        {
            return model.hasContactTypeCode(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaDefaultRecipient_CreatedUtcTs
        extends KmMetaTimestampProperty<MyDefaultRecipient>
        implements KmMetaDaoPropertyIF<MyDefaultRecipient,KmTimestamp>
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
            return MyDefaultRecipientValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MyDefaultRecipientDao getDao()
        {
            return getAccess().getDefaultRecipientDao();
        }

        @Override
        public KmTimestamp getValueFor(MyDefaultRecipient model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MyDefaultRecipient model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyDefaultRecipient model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# CustomEmail
    //##################################################

    public class MyMetaDefaultRecipient_CustomEmail
        extends KmMetaStringProperty<MyDefaultRecipient>
        implements KmMetaDaoPropertyIF<MyDefaultRecipient,String>
    {
        @Override
        public String getName()
        {
            return "customEmail";
        }

        @Override
        public String getLabel()
        {
            return "Custom Email";
        }

        @Override
        public String getHelp()
        {
            return "The email address to be used if the contact type is Custom.";
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
            return MyDefaultRecipientValidator.instance.getCustomEmailValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "customEmail";
        }

        @Override
        public MyDefaultRecipientDao getDao()
        {
            return getAccess().getDefaultRecipientDao();
        }

        @Override
        public String getValueFor(MyDefaultRecipient model)
        {
            return model.getCustomEmail();
        }

        @Override
        public void setValueFor(MyDefaultRecipient model, String value)
        {
            model.setCustomEmail(value);
        }

        @Override
        public boolean hasValueFor(MyDefaultRecipient model, String value)
        {
            return model.hasCustomEmail(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaDefaultRecipient_DomainSubtitle
        extends KmMetaStringProperty<MyDefaultRecipient>
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
        public String getValueFor(MyDefaultRecipient model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyDefaultRecipient model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaDefaultRecipient_DomainTitle
        extends KmMetaStringProperty<MyDefaultRecipient>
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
        public String getValueFor(MyDefaultRecipient model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyDefaultRecipient model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# TypeCode
    //##################################################

    public class MyMetaDefaultRecipient_TypeCode
        extends KmMetaStringProperty<MyDefaultRecipient>
        implements KmMetaDaoPropertyIF<MyDefaultRecipient,String>
    {
        @Override
        public String getName()
        {
            return "typeCode";
        }

        @Override
        public String getLabel()
        {
            return "Type Code";
        }

        @Override
        public String getHelp()
        {
            return "The recipient type (e.g. To, Cc).";
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
            return MyDefaultRecipientValidator.instance.getTypeCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "typeCode";
        }

        @Override
        public MyDefaultRecipientDao getDao()
        {
            return getAccess().getDefaultRecipientDao();
        }

        public ScDynamicEnumDropdownField newDropdown()
        {
            ScDynamicEnumDropdownField e;
            e = new ScDynamicEnumDropdownField();
            e.setMeta(this);
            e.setEnumArraySupplier(MyDefaultRecipientType::values);
            return e;
        }

        public ScDynamicEnumDropdownField newDropdown(String label)
        {
            ScDynamicEnumDropdownField e;
            e = newDropdown();
            e.setLabel(label);
            return e;
        }

        @Override
        public String getValueFor(MyDefaultRecipient model)
        {
            return model.getTypeCode();
        }

        @Override
        public void setValueFor(MyDefaultRecipient model, String value)
        {
            model.setTypeCode(value);
        }

        @Override
        public boolean hasValueFor(MyDefaultRecipient model, String value)
        {
            return model.hasTypeCode(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaDefaultRecipient_Uid
        extends KmMetaStringProperty<MyDefaultRecipient>
        implements KmMetaDaoPropertyIF<MyDefaultRecipient,String>
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
            return MyDefaultRecipientValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyDefaultRecipientDao getDao()
        {
            return getAccess().getDefaultRecipientDao();
        }

        public KmDaoStringKeyCursor<MyDefaultRecipient> createCursor()
        {
            KmDaoStringKeyCursor<MyDefaultRecipient> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyDefaultRecipient model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyDefaultRecipient model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyDefaultRecipient model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# UpdatedUtcTs
    //##################################################

    public class MyMetaDefaultRecipient_UpdatedUtcTs
        extends KmMetaTimestampProperty<MyDefaultRecipient>
        implements KmMetaDaoPropertyIF<MyDefaultRecipient,KmTimestamp>
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
            return MyDefaultRecipientValidator.instance.getUpdatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "updatedUtcTs";
        }

        @Override
        public MyDefaultRecipientDao getDao()
        {
            return getAccess().getDefaultRecipientDao();
        }

        @Override
        public KmTimestamp getValueFor(MyDefaultRecipient model)
        {
            return model.getUpdatedUtcTs();
        }

        @Override
        public void setValueFor(MyDefaultRecipient model, KmTimestamp value)
        {
            model.setUpdatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyDefaultRecipient model, KmTimestamp value)
        {
            return model.hasUpdatedUtcTs(value);
        }
    }

    //##################################################
    //# LockVersion
    //##################################################

    public class MyMetaDefaultRecipient_LockVersion
        extends KmMetaIntegerProperty<MyDefaultRecipient>
        implements KmMetaDaoPropertyIF<MyDefaultRecipient,Integer>
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
            return MyDefaultRecipientValidator.instance.getLockVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lockVersion";
        }

        @Override
        public MyDefaultRecipientDao getDao()
        {
            return getAccess().getDefaultRecipientDao();
        }

        @Override
        public Integer getValueFor(MyDefaultRecipient model)
        {
            return model.getLockVersion();
        }

        @Override
        public void setValueFor(MyDefaultRecipient model, Integer value)
        {
            model.setLockVersion(value);
        }

        @Override
        public boolean hasValueFor(MyDefaultRecipient model, Integer value)
        {
            return model.hasLockVersion(value);
        }
    }

    //##################################################
    //# ContactTypeName
    //##################################################

    public class MyMetaDefaultRecipient_ContactTypeName
        extends KmMetaStringProperty<MyDefaultRecipient>
    {
        @Override
        public String getName()
        {
            return "contactTypeName";
        }

        @Override
        public String getLabel()
        {
            return "Contact Type";
        }

        @Override
        public String getHelp()
        {
            return "The contact type for this recipient (e.g. Main, Install, etc.).";
        }

        @Override
        public int getColumnWidth()
        {
            return 15;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public String getValueFor(MyDefaultRecipient model)
        {
            return model.getContactTypeName();
        }

        @Override
        public boolean hasValueFor(MyDefaultRecipient model, String value)
        {
            return model.hasContactTypeName(value);
        }
    }

    //##################################################
    //# TypeName
    //##################################################

    public class MyMetaDefaultRecipient_TypeName
        extends KmMetaStringProperty<MyDefaultRecipient>
    {
        @Override
        public String getName()
        {
            return "typeName";
        }

        @Override
        public String getLabel()
        {
            return "Type";
        }

        @Override
        public String getHelp()
        {
            return "The recipient type (e.g. To, Cc).";
        }

        @Override
        public int getColumnWidth()
        {
            return 15;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public String getValueFor(MyDefaultRecipient model)
        {
            return model.getTypeName();
        }

        @Override
        public boolean hasValueFor(MyDefaultRecipient model, String value)
        {
            return model.hasTypeName(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaDefaultRecipient_CreatedLocalTs
        extends KmMetaTimestampProperty<MyDefaultRecipient>
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
        public KmTimestamp getValueFor(MyDefaultRecipient model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyDefaultRecipient model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaDefaultRecipient_CreatedLocalTsMessage
        extends KmMetaStringProperty<MyDefaultRecipient>
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
        public String getValueFor(MyDefaultRecipient model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyDefaultRecipient model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaDefaultRecipient_CreatedLocalDate
        extends KmMetaDateProperty<MyDefaultRecipient>
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
        public KmDate getValueFor(MyDefaultRecipient model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyDefaultRecipient model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaDefaultRecipient_CreatedLocalTime
        extends KmMetaTimeProperty<MyDefaultRecipient>
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
        public KmTime getValueFor(MyDefaultRecipient model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyDefaultRecipient model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }

    //##################################################
    //# UpdatedLocalTs
    //##################################################

    public class MyMetaDefaultRecipient_UpdatedLocalTs
        extends KmMetaTimestampProperty<MyDefaultRecipient>
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
        public KmTimestamp getValueFor(MyDefaultRecipient model)
        {
            return model.getUpdatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyDefaultRecipient model, KmTimestamp value)
        {
            return model.hasUpdatedLocalTs(value);
        }
    }

    //##################################################
    //# UpdatedLocalTsMessage
    //##################################################

    public class MyMetaDefaultRecipient_UpdatedLocalTsMessage
        extends KmMetaStringProperty<MyDefaultRecipient>
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
        public String getValueFor(MyDefaultRecipient model)
        {
            return model.getUpdatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyDefaultRecipient model, String value)
        {
            return model.hasUpdatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# UpdatedLocalDate
    //##################################################

    public class MyMetaDefaultRecipient_UpdatedLocalDate
        extends KmMetaDateProperty<MyDefaultRecipient>
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
        public KmDate getValueFor(MyDefaultRecipient model)
        {
            return model.getUpdatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyDefaultRecipient model, KmDate value)
        {
            return model.hasUpdatedLocalDate(value);
        }
    }

    //##################################################
    //# UpdatedLocalTime
    //##################################################

    public class MyMetaDefaultRecipient_UpdatedLocalTime
        extends KmMetaTimeProperty<MyDefaultRecipient>
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
        public KmTime getValueFor(MyDefaultRecipient model)
        {
            return model.getUpdatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyDefaultRecipient model, KmTime value)
        {
            return model.hasUpdatedLocalTime(value);
        }
    }

    //##################################################
    //# CreatedByFullName
    //##################################################

    public class MyMetaDefaultRecipient_CreatedByFullName
        extends KmMetaStringProperty<MyDefaultRecipient>
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
        public String getValueFor(MyDefaultRecipient model)
        {
            return model.getCreatedByFullName();
        }

        @Override
        public void setValueFor(MyDefaultRecipient model, String value)
        {
            model.setCreatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyDefaultRecipient model, String value)
        {
            return model.hasCreatedByFullName(value);
        }
    }

    //##################################################
    //# UpdatedByFullName
    //##################################################

    public class MyMetaDefaultRecipient_UpdatedByFullName
        extends KmMetaStringProperty<MyDefaultRecipient>
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
        public String getValueFor(MyDefaultRecipient model)
        {
            return model.getUpdatedByFullName();
        }

        @Override
        public void setValueFor(MyDefaultRecipient model, String value)
        {
            model.setUpdatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyDefaultRecipient model, String value)
        {
            return model.hasUpdatedByFullName(value);
        }
    }


    //##################################################
    //# CreatedBy
    //##################################################

    public class MyMetaDefaultRecipient_CreatedBy
        extends KmMetaDaoAssociation<MyDefaultRecipient,MyUser>
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
        public MyUser getValueFor(MyDefaultRecipient model)
        {
            return model.getCreatedBy();
        }

        @Override
        public void setValueFor(MyDefaultRecipient model, MyUser value)
        {
            model.setCreatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyDefaultRecipient model, MyUser value)
        {
            return model.hasCreatedBy(value);
        }
    }

    //##################################################
    //# EmailTemplate
    //##################################################

    public class MyMetaDefaultRecipient_EmailTemplate
        extends KmMetaDaoAssociation<MyDefaultRecipient,MyEmailTemplate>
    {
        @Override
        public String getName()
        {
            return "emailTemplate";
        }

        @Override
        public String getLabel()
        {
            return "Email Template";
        }

        @Override
        public String getHelp()
        {
            return "The email template that this default recipient belongs to.";
        }

        @Override
        public boolean isRequired()
        {
            return true;
        }

        @Override
        public MyEmailTemplate getValueFor(MyDefaultRecipient model)
        {
            return model.getEmailTemplate();
        }

        @Override
        public void setValueFor(MyDefaultRecipient model, MyEmailTemplate value)
        {
            model.setEmailTemplate(value);
        }

        @Override
        public boolean hasValueFor(MyDefaultRecipient model, MyEmailTemplate value)
        {
            return model.hasEmailTemplate(value);
        }
    }

    //##################################################
    //# UpdatedBy
    //##################################################

    public class MyMetaDefaultRecipient_UpdatedBy
        extends KmMetaDaoAssociation<MyDefaultRecipient,MyUser>
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
        public MyUser getValueFor(MyDefaultRecipient model)
        {
            return model.getUpdatedBy();
        }

        @Override
        public void setValueFor(MyDefaultRecipient model, MyUser value)
        {
            model.setUpdatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyDefaultRecipient model, MyUser value)
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
