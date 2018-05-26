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

public class MyMetaEmailPart
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaEmailPart instance = new MyMetaEmailPart();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaEmailPart()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "emailPart";
    }

    public MyEmailPartValidator getValidator()
    {
        return MyEmailPartValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "Each email is composed of at least one part, the body. In some cases the body may be composed of multiple parts. For example, to supply both plaintext and html; or to provide attachments.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaEmailPart_AttachmentName AttachmentName = new MyMetaEmailPart_AttachmentName();
    public final MyMetaEmailPart_AuditLogTitle AuditLogTitle = new MyMetaEmailPart_AuditLogTitle();
    public final MyMetaEmailPart_CreatedUtcTs CreatedUtcTs = new MyMetaEmailPart_CreatedUtcTs();
    public final MyMetaEmailPart_Data Data = new MyMetaEmailPart_Data();
    public final MyMetaEmailPart_DomainSubtitle DomainSubtitle = new MyMetaEmailPart_DomainSubtitle();
    public final MyMetaEmailPart_DomainTitle DomainTitle = new MyMetaEmailPart_DomainTitle();
    public final MyMetaEmailPart_Sequence Sequence = new MyMetaEmailPart_Sequence();
    public final MyMetaEmailPart_TypeCode TypeCode = new MyMetaEmailPart_TypeCode();
    public final MyMetaEmailPart_Uid Uid = new MyMetaEmailPart_Uid();
    public final MyMetaEmailPart_UpdatedUtcTs UpdatedUtcTs = new MyMetaEmailPart_UpdatedUtcTs();
    public final MyMetaEmailPart_LockVersion LockVersion = new MyMetaEmailPart_LockVersion();
    public final MyMetaEmailPart_TypeName TypeName = new MyMetaEmailPart_TypeName();
    public final MyMetaEmailPart_CreatedLocalTs CreatedLocalTs = new MyMetaEmailPart_CreatedLocalTs();
    public final MyMetaEmailPart_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaEmailPart_CreatedLocalTsMessage();
    public final MyMetaEmailPart_CreatedLocalDate CreatedLocalDate = new MyMetaEmailPart_CreatedLocalDate();
    public final MyMetaEmailPart_CreatedLocalTime CreatedLocalTime = new MyMetaEmailPart_CreatedLocalTime();
    public final MyMetaEmailPart_UpdatedLocalTs UpdatedLocalTs = new MyMetaEmailPart_UpdatedLocalTs();
    public final MyMetaEmailPart_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaEmailPart_UpdatedLocalTsMessage();
    public final MyMetaEmailPart_UpdatedLocalDate UpdatedLocalDate = new MyMetaEmailPart_UpdatedLocalDate();
    public final MyMetaEmailPart_UpdatedLocalTime UpdatedLocalTime = new MyMetaEmailPart_UpdatedLocalTime();
    public final MyMetaEmailPart_CreatedByFullName CreatedByFullName = new MyMetaEmailPart_CreatedByFullName();
    public final MyMetaEmailPart_UpdatedByFullName UpdatedByFullName = new MyMetaEmailPart_UpdatedByFullName();

    //##################################################
    //# associations
    //##################################################

    public final MyMetaEmailPart_CreatedBy CreatedBy = new MyMetaEmailPart_CreatedBy();
    public final MyMetaEmailPart_Email Email = new MyMetaEmailPart_Email();
    public final MyMetaEmailPart_UpdatedBy UpdatedBy = new MyMetaEmailPart_UpdatedBy();

    //##################################################
    //# AttachmentName
    //##################################################

    public class MyMetaEmailPart_AttachmentName
        extends KmMetaStringProperty<MyEmailPart>
        implements KmMetaDaoPropertyIF<MyEmailPart,String>
    {
        @Override
        public String getName()
        {
            return "attachmentName";
        }

        @Override
        public String getLabel()
        {
            return "Attachment Name";
        }

        @Override
        public String getHelp()
        {
            return null;
        }

        @Override
        public int getColumnWidth()
        {
            return 25;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyEmailPartValidator.instance.getAttachmentNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "attachmentName";
        }

        @Override
        public MyEmailPartDao getDao()
        {
            return getAccess().getEmailPartDao();
        }

        @Override
        public String getValueFor(MyEmailPart model)
        {
            return model.getAttachmentName();
        }

        @Override
        public void setValueFor(MyEmailPart model, String value)
        {
            model.setAttachmentName(value);
        }

        @Override
        public boolean hasValueFor(MyEmailPart model, String value)
        {
            return model.hasAttachmentName(value);
        }
    }

    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaEmailPart_AuditLogTitle
        extends KmMetaStringProperty<MyEmailPart>
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
        public String getValueFor(MyEmailPart model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyEmailPart model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaEmailPart_CreatedUtcTs
        extends KmMetaTimestampProperty<MyEmailPart>
        implements KmMetaDaoPropertyIF<MyEmailPart,KmTimestamp>
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
            return MyEmailPartValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MyEmailPartDao getDao()
        {
            return getAccess().getEmailPartDao();
        }

        @Override
        public KmTimestamp getValueFor(MyEmailPart model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MyEmailPart model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyEmailPart model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# Data
    //##################################################

    public class MyMetaEmailPart_Data
        extends KmMetaBlobProperty<MyEmailPart>
        implements KmMetaDaoPropertyIF<MyEmailPart,KmBlob>
    {
        @Override
        public String getName()
        {
            return "data";
        }

        @Override
        public String getLabel()
        {
            return "Data";
        }

        @Override
        public String getHelp()
        {
            return null;
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
        public KmBlobValidator getValidator()
        {
            return MyEmailPartValidator.instance.getDataValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "data";
        }

        @Override
        public MyEmailPartDao getDao()
        {
            return getAccess().getEmailPartDao();
        }

        @Override
        public KmBlob getValueFor(MyEmailPart model)
        {
            return model.getData();
        }

        @Override
        public void setValueFor(MyEmailPart model, KmBlob value)
        {
            model.setData(value);
        }

        @Override
        public boolean hasValueFor(MyEmailPart model, KmBlob value)
        {
            return model.hasData(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaEmailPart_DomainSubtitle
        extends KmMetaStringProperty<MyEmailPart>
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
        public String getValueFor(MyEmailPart model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyEmailPart model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaEmailPart_DomainTitle
        extends KmMetaStringProperty<MyEmailPart>
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
        public String getValueFor(MyEmailPart model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyEmailPart model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# Sequence
    //##################################################

    public class MyMetaEmailPart_Sequence
        extends KmMetaIntegerProperty<MyEmailPart>
        implements KmMetaDaoPropertyIF<MyEmailPart,Integer>
    {
        @Override
        public String getName()
        {
            return "sequence";
        }

        @Override
        public String getLabel()
        {
            return "Sequence";
        }

        @Override
        public String getHelp()
        {
            return null;
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
            return MyEmailPartValidator.instance.getSequenceValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "sequence";
        }

        @Override
        public MyEmailPartDao getDao()
        {
            return getAccess().getEmailPartDao();
        }

        @Override
        public Integer getValueFor(MyEmailPart model)
        {
            return model.getSequence();
        }

        @Override
        public void setValueFor(MyEmailPart model, Integer value)
        {
            model.setSequence(value);
        }

        @Override
        public boolean hasValueFor(MyEmailPart model, Integer value)
        {
            return model.hasSequence(value);
        }
    }

    //##################################################
    //# TypeCode
    //##################################################

    public class MyMetaEmailPart_TypeCode
        extends KmMetaStringProperty<MyEmailPart>
        implements KmMetaDaoPropertyIF<MyEmailPart,String>
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
            return MyEmailPartValidator.instance.getTypeCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "typeCode";
        }

        @Override
        public MyEmailPartDao getDao()
        {
            return getAccess().getEmailPartDao();
        }

        public ScDynamicEnumDropdownField newDropdown()
        {
            ScDynamicEnumDropdownField e;
            e = new ScDynamicEnumDropdownField();
            e.setMeta(this);
            e.setEnumArraySupplier(MyEmailPartType::values);
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
        public String getValueFor(MyEmailPart model)
        {
            return model.getTypeCode();
        }

        @Override
        public void setValueFor(MyEmailPart model, String value)
        {
            model.setTypeCode(value);
        }

        @Override
        public boolean hasValueFor(MyEmailPart model, String value)
        {
            return model.hasTypeCode(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaEmailPart_Uid
        extends KmMetaStringProperty<MyEmailPart>
        implements KmMetaDaoPropertyIF<MyEmailPart,String>
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
            return MyEmailPartValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyEmailPartDao getDao()
        {
            return getAccess().getEmailPartDao();
        }

        public KmDaoStringKeyCursor<MyEmailPart> createCursor()
        {
            KmDaoStringKeyCursor<MyEmailPart> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyEmailPart model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyEmailPart model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyEmailPart model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# UpdatedUtcTs
    //##################################################

    public class MyMetaEmailPart_UpdatedUtcTs
        extends KmMetaTimestampProperty<MyEmailPart>
        implements KmMetaDaoPropertyIF<MyEmailPart,KmTimestamp>
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
            return MyEmailPartValidator.instance.getUpdatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "updatedUtcTs";
        }

        @Override
        public MyEmailPartDao getDao()
        {
            return getAccess().getEmailPartDao();
        }

        @Override
        public KmTimestamp getValueFor(MyEmailPart model)
        {
            return model.getUpdatedUtcTs();
        }

        @Override
        public void setValueFor(MyEmailPart model, KmTimestamp value)
        {
            model.setUpdatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyEmailPart model, KmTimestamp value)
        {
            return model.hasUpdatedUtcTs(value);
        }
    }

    //##################################################
    //# LockVersion
    //##################################################

    public class MyMetaEmailPart_LockVersion
        extends KmMetaIntegerProperty<MyEmailPart>
        implements KmMetaDaoPropertyIF<MyEmailPart,Integer>
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
            return MyEmailPartValidator.instance.getLockVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lockVersion";
        }

        @Override
        public MyEmailPartDao getDao()
        {
            return getAccess().getEmailPartDao();
        }

        @Override
        public Integer getValueFor(MyEmailPart model)
        {
            return model.getLockVersion();
        }

        @Override
        public void setValueFor(MyEmailPart model, Integer value)
        {
            model.setLockVersion(value);
        }

        @Override
        public boolean hasValueFor(MyEmailPart model, Integer value)
        {
            return model.hasLockVersion(value);
        }
    }

    //##################################################
    //# TypeName
    //##################################################

    public class MyMetaEmailPart_TypeName
        extends KmMetaStringProperty<MyEmailPart>
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
        public String getValueFor(MyEmailPart model)
        {
            return model.getTypeName();
        }

        @Override
        public boolean hasValueFor(MyEmailPart model, String value)
        {
            return model.hasTypeName(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaEmailPart_CreatedLocalTs
        extends KmMetaTimestampProperty<MyEmailPart>
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
        public KmTimestamp getValueFor(MyEmailPart model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyEmailPart model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaEmailPart_CreatedLocalTsMessage
        extends KmMetaStringProperty<MyEmailPart>
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
        public String getValueFor(MyEmailPart model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyEmailPart model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaEmailPart_CreatedLocalDate
        extends KmMetaDateProperty<MyEmailPart>
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
        public KmDate getValueFor(MyEmailPart model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyEmailPart model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaEmailPart_CreatedLocalTime
        extends KmMetaTimeProperty<MyEmailPart>
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
        public KmTime getValueFor(MyEmailPart model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyEmailPart model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }

    //##################################################
    //# UpdatedLocalTs
    //##################################################

    public class MyMetaEmailPart_UpdatedLocalTs
        extends KmMetaTimestampProperty<MyEmailPart>
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
        public KmTimestamp getValueFor(MyEmailPart model)
        {
            return model.getUpdatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyEmailPart model, KmTimestamp value)
        {
            return model.hasUpdatedLocalTs(value);
        }
    }

    //##################################################
    //# UpdatedLocalTsMessage
    //##################################################

    public class MyMetaEmailPart_UpdatedLocalTsMessage
        extends KmMetaStringProperty<MyEmailPart>
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
        public String getValueFor(MyEmailPart model)
        {
            return model.getUpdatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyEmailPart model, String value)
        {
            return model.hasUpdatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# UpdatedLocalDate
    //##################################################

    public class MyMetaEmailPart_UpdatedLocalDate
        extends KmMetaDateProperty<MyEmailPart>
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
        public KmDate getValueFor(MyEmailPart model)
        {
            return model.getUpdatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyEmailPart model, KmDate value)
        {
            return model.hasUpdatedLocalDate(value);
        }
    }

    //##################################################
    //# UpdatedLocalTime
    //##################################################

    public class MyMetaEmailPart_UpdatedLocalTime
        extends KmMetaTimeProperty<MyEmailPart>
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
        public KmTime getValueFor(MyEmailPart model)
        {
            return model.getUpdatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyEmailPart model, KmTime value)
        {
            return model.hasUpdatedLocalTime(value);
        }
    }

    //##################################################
    //# CreatedByFullName
    //##################################################

    public class MyMetaEmailPart_CreatedByFullName
        extends KmMetaStringProperty<MyEmailPart>
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
        public String getValueFor(MyEmailPart model)
        {
            return model.getCreatedByFullName();
        }

        @Override
        public void setValueFor(MyEmailPart model, String value)
        {
            model.setCreatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyEmailPart model, String value)
        {
            return model.hasCreatedByFullName(value);
        }
    }

    //##################################################
    //# UpdatedByFullName
    //##################################################

    public class MyMetaEmailPart_UpdatedByFullName
        extends KmMetaStringProperty<MyEmailPart>
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
        public String getValueFor(MyEmailPart model)
        {
            return model.getUpdatedByFullName();
        }

        @Override
        public void setValueFor(MyEmailPart model, String value)
        {
            model.setUpdatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyEmailPart model, String value)
        {
            return model.hasUpdatedByFullName(value);
        }
    }


    //##################################################
    //# CreatedBy
    //##################################################

    public class MyMetaEmailPart_CreatedBy
        extends KmMetaDaoAssociation<MyEmailPart,MyUser>
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
        public MyUser getValueFor(MyEmailPart model)
        {
            return model.getCreatedBy();
        }

        @Override
        public void setValueFor(MyEmailPart model, MyUser value)
        {
            model.setCreatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyEmailPart model, MyUser value)
        {
            return model.hasCreatedBy(value);
        }
    }

    //##################################################
    //# Email
    //##################################################

    public class MyMetaEmailPart_Email
        extends KmMetaDaoAssociation<MyEmailPart,MyEmail>
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
        public MyEmail getValueFor(MyEmailPart model)
        {
            return model.getEmail();
        }

        @Override
        public void setValueFor(MyEmailPart model, MyEmail value)
        {
            model.setEmail(value);
        }

        @Override
        public boolean hasValueFor(MyEmailPart model, MyEmail value)
        {
            return model.hasEmail(value);
        }
    }

    //##################################################
    //# UpdatedBy
    //##################################################

    public class MyMetaEmailPart_UpdatedBy
        extends KmMetaDaoAssociation<MyEmailPart,MyUser>
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
        public MyUser getValueFor(MyEmailPart model)
        {
            return model.getUpdatedBy();
        }

        @Override
        public void setValueFor(MyEmailPart model, MyUser value)
        {
            model.setUpdatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyEmailPart model, MyUser value)
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
