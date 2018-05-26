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

public class MyMetaEmailRecipient
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaEmailRecipient instance = new MyMetaEmailRecipient();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaEmailRecipient()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "emailRecipient";
    }

    public MyEmailRecipientValidator getValidator()
    {
        return MyEmailRecipientValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "I define the recipients for a given email.  The TOs and CCs. We do not support BCCs a this time.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaEmailRecipient_Address Address = new MyMetaEmailRecipient_Address();
    public final MyMetaEmailRecipient_AuditLogTitle AuditLogTitle = new MyMetaEmailRecipient_AuditLogTitle();
    public final MyMetaEmailRecipient_CreatedUtcTs CreatedUtcTs = new MyMetaEmailRecipient_CreatedUtcTs();
    public final MyMetaEmailRecipient_DomainSubtitle DomainSubtitle = new MyMetaEmailRecipient_DomainSubtitle();
    public final MyMetaEmailRecipient_DomainTitle DomainTitle = new MyMetaEmailRecipient_DomainTitle();
    public final MyMetaEmailRecipient_TypeCode TypeCode = new MyMetaEmailRecipient_TypeCode();
    public final MyMetaEmailRecipient_Uid Uid = new MyMetaEmailRecipient_Uid();
    public final MyMetaEmailRecipient_UpdatedUtcTs UpdatedUtcTs = new MyMetaEmailRecipient_UpdatedUtcTs();
    public final MyMetaEmailRecipient_LockVersion LockVersion = new MyMetaEmailRecipient_LockVersion();
    public final MyMetaEmailRecipient_TypeName TypeName = new MyMetaEmailRecipient_TypeName();
    public final MyMetaEmailRecipient_CreatedLocalTs CreatedLocalTs = new MyMetaEmailRecipient_CreatedLocalTs();
    public final MyMetaEmailRecipient_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaEmailRecipient_CreatedLocalTsMessage();
    public final MyMetaEmailRecipient_CreatedLocalDate CreatedLocalDate = new MyMetaEmailRecipient_CreatedLocalDate();
    public final MyMetaEmailRecipient_CreatedLocalTime CreatedLocalTime = new MyMetaEmailRecipient_CreatedLocalTime();
    public final MyMetaEmailRecipient_UpdatedLocalTs UpdatedLocalTs = new MyMetaEmailRecipient_UpdatedLocalTs();
    public final MyMetaEmailRecipient_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaEmailRecipient_UpdatedLocalTsMessage();
    public final MyMetaEmailRecipient_UpdatedLocalDate UpdatedLocalDate = new MyMetaEmailRecipient_UpdatedLocalDate();
    public final MyMetaEmailRecipient_UpdatedLocalTime UpdatedLocalTime = new MyMetaEmailRecipient_UpdatedLocalTime();
    public final MyMetaEmailRecipient_CreatedByFullName CreatedByFullName = new MyMetaEmailRecipient_CreatedByFullName();
    public final MyMetaEmailRecipient_UpdatedByFullName UpdatedByFullName = new MyMetaEmailRecipient_UpdatedByFullName();

    //##################################################
    //# associations
    //##################################################

    public final MyMetaEmailRecipient_CreatedBy CreatedBy = new MyMetaEmailRecipient_CreatedBy();
    public final MyMetaEmailRecipient_Email Email = new MyMetaEmailRecipient_Email();
    public final MyMetaEmailRecipient_UpdatedBy UpdatedBy = new MyMetaEmailRecipient_UpdatedBy();

    //##################################################
    //# Address
    //##################################################

    public class MyMetaEmailRecipient_Address
        extends KmMetaStringProperty<MyEmailRecipient>
        implements KmMetaDaoPropertyIF<MyEmailRecipient,String>
    {
        @Override
        public String getName()
        {
            return "address";
        }

        @Override
        public String getLabel()
        {
            return "Address";
        }

        @Override
        public String getHelp()
        {
            return null;
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
            return MyEmailRecipientValidator.instance.getAddressValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "address";
        }

        @Override
        public MyEmailRecipientDao getDao()
        {
            return getAccess().getEmailRecipientDao();
        }

        @Override
        public String getValueFor(MyEmailRecipient model)
        {
            return model.getAddress();
        }

        @Override
        public void setValueFor(MyEmailRecipient model, String value)
        {
            model.setAddress(value);
        }

        @Override
        public boolean hasValueFor(MyEmailRecipient model, String value)
        {
            return model.hasAddress(value);
        }
    }

    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaEmailRecipient_AuditLogTitle
        extends KmMetaStringProperty<MyEmailRecipient>
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
        public String getValueFor(MyEmailRecipient model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyEmailRecipient model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaEmailRecipient_CreatedUtcTs
        extends KmMetaTimestampProperty<MyEmailRecipient>
        implements KmMetaDaoPropertyIF<MyEmailRecipient,KmTimestamp>
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
            return MyEmailRecipientValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MyEmailRecipientDao getDao()
        {
            return getAccess().getEmailRecipientDao();
        }

        @Override
        public KmTimestamp getValueFor(MyEmailRecipient model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MyEmailRecipient model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyEmailRecipient model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaEmailRecipient_DomainSubtitle
        extends KmMetaStringProperty<MyEmailRecipient>
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
        public String getValueFor(MyEmailRecipient model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyEmailRecipient model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaEmailRecipient_DomainTitle
        extends KmMetaStringProperty<MyEmailRecipient>
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
        public String getValueFor(MyEmailRecipient model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyEmailRecipient model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# TypeCode
    //##################################################

    public class MyMetaEmailRecipient_TypeCode
        extends KmMetaStringProperty<MyEmailRecipient>
        implements KmMetaDaoPropertyIF<MyEmailRecipient,String>
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
            return null;
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
            return MyEmailRecipientValidator.instance.getTypeCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "typeCode";
        }

        @Override
        public MyEmailRecipientDao getDao()
        {
            return getAccess().getEmailRecipientDao();
        }

        public ScDynamicEnumDropdownField newDropdown()
        {
            ScDynamicEnumDropdownField e;
            e = new ScDynamicEnumDropdownField();
            e.setMeta(this);
            e.setEnumArraySupplier(MyEmailRecipientType::values);
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
        public String getValueFor(MyEmailRecipient model)
        {
            return model.getTypeCode();
        }

        @Override
        public void setValueFor(MyEmailRecipient model, String value)
        {
            model.setTypeCode(value);
        }

        @Override
        public boolean hasValueFor(MyEmailRecipient model, String value)
        {
            return model.hasTypeCode(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaEmailRecipient_Uid
        extends KmMetaStringProperty<MyEmailRecipient>
        implements KmMetaDaoPropertyIF<MyEmailRecipient,String>
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
            return MyEmailRecipientValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyEmailRecipientDao getDao()
        {
            return getAccess().getEmailRecipientDao();
        }

        public KmDaoStringKeyCursor<MyEmailRecipient> createCursor()
        {
            KmDaoStringKeyCursor<MyEmailRecipient> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyEmailRecipient model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyEmailRecipient model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyEmailRecipient model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# UpdatedUtcTs
    //##################################################

    public class MyMetaEmailRecipient_UpdatedUtcTs
        extends KmMetaTimestampProperty<MyEmailRecipient>
        implements KmMetaDaoPropertyIF<MyEmailRecipient,KmTimestamp>
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
            return MyEmailRecipientValidator.instance.getUpdatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "updatedUtcTs";
        }

        @Override
        public MyEmailRecipientDao getDao()
        {
            return getAccess().getEmailRecipientDao();
        }

        @Override
        public KmTimestamp getValueFor(MyEmailRecipient model)
        {
            return model.getUpdatedUtcTs();
        }

        @Override
        public void setValueFor(MyEmailRecipient model, KmTimestamp value)
        {
            model.setUpdatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyEmailRecipient model, KmTimestamp value)
        {
            return model.hasUpdatedUtcTs(value);
        }
    }

    //##################################################
    //# LockVersion
    //##################################################

    public class MyMetaEmailRecipient_LockVersion
        extends KmMetaIntegerProperty<MyEmailRecipient>
        implements KmMetaDaoPropertyIF<MyEmailRecipient,Integer>
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
            return MyEmailRecipientValidator.instance.getLockVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lockVersion";
        }

        @Override
        public MyEmailRecipientDao getDao()
        {
            return getAccess().getEmailRecipientDao();
        }

        @Override
        public Integer getValueFor(MyEmailRecipient model)
        {
            return model.getLockVersion();
        }

        @Override
        public void setValueFor(MyEmailRecipient model, Integer value)
        {
            model.setLockVersion(value);
        }

        @Override
        public boolean hasValueFor(MyEmailRecipient model, Integer value)
        {
            return model.hasLockVersion(value);
        }
    }

    //##################################################
    //# TypeName
    //##################################################

    public class MyMetaEmailRecipient_TypeName
        extends KmMetaStringProperty<MyEmailRecipient>
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
            return null;
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
        public String getValueFor(MyEmailRecipient model)
        {
            return model.getTypeName();
        }

        @Override
        public boolean hasValueFor(MyEmailRecipient model, String value)
        {
            return model.hasTypeName(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaEmailRecipient_CreatedLocalTs
        extends KmMetaTimestampProperty<MyEmailRecipient>
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
        public KmTimestamp getValueFor(MyEmailRecipient model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyEmailRecipient model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaEmailRecipient_CreatedLocalTsMessage
        extends KmMetaStringProperty<MyEmailRecipient>
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
        public String getValueFor(MyEmailRecipient model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyEmailRecipient model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaEmailRecipient_CreatedLocalDate
        extends KmMetaDateProperty<MyEmailRecipient>
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
        public KmDate getValueFor(MyEmailRecipient model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyEmailRecipient model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaEmailRecipient_CreatedLocalTime
        extends KmMetaTimeProperty<MyEmailRecipient>
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
        public KmTime getValueFor(MyEmailRecipient model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyEmailRecipient model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }

    //##################################################
    //# UpdatedLocalTs
    //##################################################

    public class MyMetaEmailRecipient_UpdatedLocalTs
        extends KmMetaTimestampProperty<MyEmailRecipient>
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
        public KmTimestamp getValueFor(MyEmailRecipient model)
        {
            return model.getUpdatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyEmailRecipient model, KmTimestamp value)
        {
            return model.hasUpdatedLocalTs(value);
        }
    }

    //##################################################
    //# UpdatedLocalTsMessage
    //##################################################

    public class MyMetaEmailRecipient_UpdatedLocalTsMessage
        extends KmMetaStringProperty<MyEmailRecipient>
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
        public String getValueFor(MyEmailRecipient model)
        {
            return model.getUpdatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyEmailRecipient model, String value)
        {
            return model.hasUpdatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# UpdatedLocalDate
    //##################################################

    public class MyMetaEmailRecipient_UpdatedLocalDate
        extends KmMetaDateProperty<MyEmailRecipient>
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
        public KmDate getValueFor(MyEmailRecipient model)
        {
            return model.getUpdatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyEmailRecipient model, KmDate value)
        {
            return model.hasUpdatedLocalDate(value);
        }
    }

    //##################################################
    //# UpdatedLocalTime
    //##################################################

    public class MyMetaEmailRecipient_UpdatedLocalTime
        extends KmMetaTimeProperty<MyEmailRecipient>
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
        public KmTime getValueFor(MyEmailRecipient model)
        {
            return model.getUpdatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyEmailRecipient model, KmTime value)
        {
            return model.hasUpdatedLocalTime(value);
        }
    }

    //##################################################
    //# CreatedByFullName
    //##################################################

    public class MyMetaEmailRecipient_CreatedByFullName
        extends KmMetaStringProperty<MyEmailRecipient>
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
        public String getValueFor(MyEmailRecipient model)
        {
            return model.getCreatedByFullName();
        }

        @Override
        public void setValueFor(MyEmailRecipient model, String value)
        {
            model.setCreatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyEmailRecipient model, String value)
        {
            return model.hasCreatedByFullName(value);
        }
    }

    //##################################################
    //# UpdatedByFullName
    //##################################################

    public class MyMetaEmailRecipient_UpdatedByFullName
        extends KmMetaStringProperty<MyEmailRecipient>
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
        public String getValueFor(MyEmailRecipient model)
        {
            return model.getUpdatedByFullName();
        }

        @Override
        public void setValueFor(MyEmailRecipient model, String value)
        {
            model.setUpdatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyEmailRecipient model, String value)
        {
            return model.hasUpdatedByFullName(value);
        }
    }


    //##################################################
    //# CreatedBy
    //##################################################

    public class MyMetaEmailRecipient_CreatedBy
        extends KmMetaDaoAssociation<MyEmailRecipient,MyUser>
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
        public MyUser getValueFor(MyEmailRecipient model)
        {
            return model.getCreatedBy();
        }

        @Override
        public void setValueFor(MyEmailRecipient model, MyUser value)
        {
            model.setCreatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyEmailRecipient model, MyUser value)
        {
            return model.hasCreatedBy(value);
        }
    }

    //##################################################
    //# Email
    //##################################################

    public class MyMetaEmailRecipient_Email
        extends KmMetaDaoAssociation<MyEmailRecipient,MyEmail>
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
            return null;
        }

        @Override
        public boolean isRequired()
        {
            return true;
        }

        @Override
        public MyEmail getValueFor(MyEmailRecipient model)
        {
            return model.getEmail();
        }

        @Override
        public void setValueFor(MyEmailRecipient model, MyEmail value)
        {
            model.setEmail(value);
        }

        @Override
        public boolean hasValueFor(MyEmailRecipient model, MyEmail value)
        {
            return model.hasEmail(value);
        }
    }

    //##################################################
    //# UpdatedBy
    //##################################################

    public class MyMetaEmailRecipient_UpdatedBy
        extends KmMetaDaoAssociation<MyEmailRecipient,MyUser>
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
        public MyUser getValueFor(MyEmailRecipient model)
        {
            return model.getUpdatedBy();
        }

        @Override
        public void setValueFor(MyEmailRecipient model, MyUser value)
        {
            model.setUpdatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyEmailRecipient model, MyUser value)
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
