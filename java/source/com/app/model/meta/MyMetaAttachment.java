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

public class MyMetaAttachment
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaAttachment instance = new MyMetaAttachment();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaAttachment()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "attachment";
    }

    public MyAttachmentValidator getValidator()
    {
        return MyAttachmentValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "I represent a binary file attached to a project, site, etc. I currently store the content in the database, though this may be changed to an external datastore such as S3 at a later time.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaAttachment_AuditLogTitle AuditLogTitle = new MyMetaAttachment_AuditLogTitle();
    public final MyMetaAttachment_Content Content = new MyMetaAttachment_Content();
    public final MyMetaAttachment_CreatedUtcTs CreatedUtcTs = new MyMetaAttachment_CreatedUtcTs();
    public final MyMetaAttachment_DomainSubtitle DomainSubtitle = new MyMetaAttachment_DomainSubtitle();
    public final MyMetaAttachment_DomainTitle DomainTitle = new MyMetaAttachment_DomainTitle();
    public final MyMetaAttachment_Enabled Enabled = new MyMetaAttachment_Enabled();
    public final MyMetaAttachment_EnabledStatus EnabledStatus = new MyMetaAttachment_EnabledStatus();
    public final MyMetaAttachment_Name Name = new MyMetaAttachment_Name();
    public final MyMetaAttachment_OwnerTypeCode OwnerTypeCode = new MyMetaAttachment_OwnerTypeCode();
    public final MyMetaAttachment_TypeCode TypeCode = new MyMetaAttachment_TypeCode();
    public final MyMetaAttachment_Uid Uid = new MyMetaAttachment_Uid();
    public final MyMetaAttachment_UpdatedUtcTs UpdatedUtcTs = new MyMetaAttachment_UpdatedUtcTs();
    public final MyMetaAttachment_LockVersion LockVersion = new MyMetaAttachment_LockVersion();
    public final MyMetaAttachment_OwnerTypeName OwnerTypeName = new MyMetaAttachment_OwnerTypeName();
    public final MyMetaAttachment_TypeName TypeName = new MyMetaAttachment_TypeName();
    public final MyMetaAttachment_CreatedLocalTs CreatedLocalTs = new MyMetaAttachment_CreatedLocalTs();
    public final MyMetaAttachment_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaAttachment_CreatedLocalTsMessage();
    public final MyMetaAttachment_CreatedLocalDate CreatedLocalDate = new MyMetaAttachment_CreatedLocalDate();
    public final MyMetaAttachment_CreatedLocalTime CreatedLocalTime = new MyMetaAttachment_CreatedLocalTime();
    public final MyMetaAttachment_UpdatedLocalTs UpdatedLocalTs = new MyMetaAttachment_UpdatedLocalTs();
    public final MyMetaAttachment_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaAttachment_UpdatedLocalTsMessage();
    public final MyMetaAttachment_UpdatedLocalDate UpdatedLocalDate = new MyMetaAttachment_UpdatedLocalDate();
    public final MyMetaAttachment_UpdatedLocalTime UpdatedLocalTime = new MyMetaAttachment_UpdatedLocalTime();
    public final MyMetaAttachment_CreatedByFullName CreatedByFullName = new MyMetaAttachment_CreatedByFullName();
    public final MyMetaAttachment_UpdatedByFullName UpdatedByFullName = new MyMetaAttachment_UpdatedByFullName();

    //##################################################
    //# associations
    //##################################################

    public final MyMetaAttachment_CreatedBy CreatedBy = new MyMetaAttachment_CreatedBy();
    public final MyMetaAttachment_Customer Customer = new MyMetaAttachment_Customer();
    public final MyMetaAttachment_Project Project = new MyMetaAttachment_Project();
    public final MyMetaAttachment_Site Site = new MyMetaAttachment_Site();
    public final MyMetaAttachment_Tenant Tenant = new MyMetaAttachment_Tenant();
    public final MyMetaAttachment_UpdatedBy UpdatedBy = new MyMetaAttachment_UpdatedBy();

    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaAttachment_AuditLogTitle
        extends KmMetaStringProperty<MyAttachment>
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
        public String getValueFor(MyAttachment model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyAttachment model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# Content
    //##################################################

    public class MyMetaAttachment_Content
        extends KmMetaBlobProperty<MyAttachment>
        implements KmMetaDaoPropertyIF<MyAttachment,KmBlob>
    {
        @Override
        public String getName()
        {
            return "content";
        }

        @Override
        public String getLabel()
        {
            return "Content";
        }

        @Override
        public String getHelp()
        {
            return "The binary content of the file.";
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
            return MyAttachmentValidator.instance.getContentValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "content";
        }

        @Override
        public MyAttachmentDao getDao()
        {
            return getAccess().getAttachmentDao();
        }

        @Override
        public KmBlob getValueFor(MyAttachment model)
        {
            return model.getContent();
        }

        @Override
        public void setValueFor(MyAttachment model, KmBlob value)
        {
            model.setContent(value);
        }

        @Override
        public boolean hasValueFor(MyAttachment model, KmBlob value)
        {
            return model.hasContent(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaAttachment_CreatedUtcTs
        extends KmMetaTimestampProperty<MyAttachment>
        implements KmMetaDaoPropertyIF<MyAttachment,KmTimestamp>
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
            return MyAttachmentValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MyAttachmentDao getDao()
        {
            return getAccess().getAttachmentDao();
        }

        @Override
        public KmTimestamp getValueFor(MyAttachment model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MyAttachment model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyAttachment model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaAttachment_DomainSubtitle
        extends KmMetaStringProperty<MyAttachment>
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
        public String getValueFor(MyAttachment model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyAttachment model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaAttachment_DomainTitle
        extends KmMetaStringProperty<MyAttachment>
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
        public String getValueFor(MyAttachment model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyAttachment model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# Enabled
    //##################################################

    public class MyMetaAttachment_Enabled
        extends KmMetaBooleanProperty<MyAttachment>
        implements KmMetaDaoPropertyIF<MyAttachment,Boolean>
    {
        @Override
        public String getName()
        {
            return "enabled";
        }

        @Override
        public String getLabel()
        {
            return "Enabled";
        }

        @Override
        public String getHelp()
        {
            return "Disable to hide this on various screens.";
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
            return MyAttachmentValidator.instance.getEnabledValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "enabled";
        }

        @Override
        public MyAttachmentDao getDao()
        {
            return getAccess().getAttachmentDao();
        }

        @Override
        public Boolean getValueFor(MyAttachment model)
        {
            return model.getEnabled();
        }

        @Override
        public void setValueFor(MyAttachment model, Boolean value)
        {
            model.setEnabled(value);
        }

        @Override
        public boolean hasValueFor(MyAttachment model, Boolean value)
        {
            return model.hasEnabled(value);
        }
    }

    //##################################################
    //# EnabledStatus
    //##################################################

    public class MyMetaAttachment_EnabledStatus
        extends KmMetaStringProperty<MyAttachment>
    {
        @Override
        public String getName()
        {
            return "enabledStatus";
        }

        @Override
        public String getLabel()
        {
            return "Enabled";
        }

        @Override
        public String getHelp()
        {
            return "Disable to hide this on various screens.";
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
        public String getValueFor(MyAttachment model)
        {
            return model.getEnabledStatus();
        }

        @Override
        public boolean hasValueFor(MyAttachment model, String value)
        {
            return model.hasEnabledStatus(value);
        }
    }

    //##################################################
    //# Name
    //##################################################

    public class MyMetaAttachment_Name
        extends KmMetaStringProperty<MyAttachment>
        implements KmMetaDaoPropertyIF<MyAttachment,String>
    {
        @Override
        public String getName()
        {
            return "name";
        }

        @Override
        public String getLabel()
        {
            return "Name";
        }

        @Override
        public String getHelp()
        {
            return "The human-readable name that identifies this attachment. This is also the name used when the file is downloaded to a remote client.";
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
            return MyAttachmentValidator.instance.getNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "name";
        }

        @Override
        public MyAttachmentDao getDao()
        {
            return getAccess().getAttachmentDao();
        }

        @Override
        public String getValueFor(MyAttachment model)
        {
            return model.getName();
        }

        @Override
        public void setValueFor(MyAttachment model, String value)
        {
            model.setName(value);
        }

        @Override
        public boolean hasValueFor(MyAttachment model, String value)
        {
            return model.hasName(value);
        }
    }

    //##################################################
    //# OwnerTypeCode
    //##################################################

    public class MyMetaAttachment_OwnerTypeCode
        extends KmMetaStringProperty<MyAttachment>
        implements KmMetaDaoPropertyIF<MyAttachment,String>
    {
        @Override
        public String getName()
        {
            return "ownerTypeCode";
        }

        @Override
        public String getLabel()
        {
            return "Owner Type Code";
        }

        @Override
        public String getHelp()
        {
            return "The type of element that owns this note.";
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
            return MyAttachmentValidator.instance.getOwnerTypeCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "ownerTypeCode";
        }

        @Override
        public MyAttachmentDao getDao()
        {
            return getAccess().getAttachmentDao();
        }

        public ScDynamicEnumDropdownField newDropdown()
        {
            ScDynamicEnumDropdownField e;
            e = new ScDynamicEnumDropdownField();
            e.setMeta(this);
            e.setEnumArraySupplier(MyAttachmentOwnerType::values);
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
        public String getValueFor(MyAttachment model)
        {
            return model.getOwnerTypeCode();
        }

        @Override
        public void setValueFor(MyAttachment model, String value)
        {
            model.setOwnerTypeCode(value);
        }

        @Override
        public boolean hasValueFor(MyAttachment model, String value)
        {
            return model.hasOwnerTypeCode(value);
        }
    }

    //##################################################
    //# TypeCode
    //##################################################

    public class MyMetaAttachment_TypeCode
        extends KmMetaStringProperty<MyAttachment>
        implements KmMetaDaoPropertyIF<MyAttachment,String>
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
            return "This indicates the general type of data being stored. Depending on the data type, we try to display the attachment directly within the application rather than requiring the user to download it.";
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
            return MyAttachmentValidator.instance.getTypeCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "typeCode";
        }

        @Override
        public MyAttachmentDao getDao()
        {
            return getAccess().getAttachmentDao();
        }

        public ScDynamicEnumDropdownField newDropdown()
        {
            ScDynamicEnumDropdownField e;
            e = new ScDynamicEnumDropdownField();
            e.setMeta(this);
            e.setEnumArraySupplier(MyAttachmentType::values);
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
        public String getValueFor(MyAttachment model)
        {
            return model.getTypeCode();
        }

        @Override
        public void setValueFor(MyAttachment model, String value)
        {
            model.setTypeCode(value);
        }

        @Override
        public boolean hasValueFor(MyAttachment model, String value)
        {
            return model.hasTypeCode(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaAttachment_Uid
        extends KmMetaStringProperty<MyAttachment>
        implements KmMetaDaoPropertyIF<MyAttachment,String>
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
            return MyAttachmentValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyAttachmentDao getDao()
        {
            return getAccess().getAttachmentDao();
        }

        public KmDaoStringKeyCursor<MyAttachment> createCursor()
        {
            KmDaoStringKeyCursor<MyAttachment> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyAttachment model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyAttachment model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyAttachment model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# UpdatedUtcTs
    //##################################################

    public class MyMetaAttachment_UpdatedUtcTs
        extends KmMetaTimestampProperty<MyAttachment>
        implements KmMetaDaoPropertyIF<MyAttachment,KmTimestamp>
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
            return MyAttachmentValidator.instance.getUpdatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "updatedUtcTs";
        }

        @Override
        public MyAttachmentDao getDao()
        {
            return getAccess().getAttachmentDao();
        }

        @Override
        public KmTimestamp getValueFor(MyAttachment model)
        {
            return model.getUpdatedUtcTs();
        }

        @Override
        public void setValueFor(MyAttachment model, KmTimestamp value)
        {
            model.setUpdatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyAttachment model, KmTimestamp value)
        {
            return model.hasUpdatedUtcTs(value);
        }
    }

    //##################################################
    //# LockVersion
    //##################################################

    public class MyMetaAttachment_LockVersion
        extends KmMetaIntegerProperty<MyAttachment>
        implements KmMetaDaoPropertyIF<MyAttachment,Integer>
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
            return MyAttachmentValidator.instance.getLockVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lockVersion";
        }

        @Override
        public MyAttachmentDao getDao()
        {
            return getAccess().getAttachmentDao();
        }

        @Override
        public Integer getValueFor(MyAttachment model)
        {
            return model.getLockVersion();
        }

        @Override
        public void setValueFor(MyAttachment model, Integer value)
        {
            model.setLockVersion(value);
        }

        @Override
        public boolean hasValueFor(MyAttachment model, Integer value)
        {
            return model.hasLockVersion(value);
        }
    }

    //##################################################
    //# OwnerTypeName
    //##################################################

    public class MyMetaAttachment_OwnerTypeName
        extends KmMetaStringProperty<MyAttachment>
    {
        @Override
        public String getName()
        {
            return "ownerTypeName";
        }

        @Override
        public String getLabel()
        {
            return "Owner Type";
        }

        @Override
        public String getHelp()
        {
            return "The type of element that owns this note.";
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
        public String getValueFor(MyAttachment model)
        {
            return model.getOwnerTypeName();
        }

        @Override
        public boolean hasValueFor(MyAttachment model, String value)
        {
            return model.hasOwnerTypeName(value);
        }
    }

    //##################################################
    //# TypeName
    //##################################################

    public class MyMetaAttachment_TypeName
        extends KmMetaStringProperty<MyAttachment>
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
            return "This indicates the general type of data being stored. Depending on the data type, we try to display the attachment directly within the application rather than requiring the user to download it.";
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
        public String getValueFor(MyAttachment model)
        {
            return model.getTypeName();
        }

        @Override
        public boolean hasValueFor(MyAttachment model, String value)
        {
            return model.hasTypeName(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaAttachment_CreatedLocalTs
        extends KmMetaTimestampProperty<MyAttachment>
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
        public KmTimestamp getValueFor(MyAttachment model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyAttachment model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaAttachment_CreatedLocalTsMessage
        extends KmMetaStringProperty<MyAttachment>
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
        public String getValueFor(MyAttachment model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyAttachment model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaAttachment_CreatedLocalDate
        extends KmMetaDateProperty<MyAttachment>
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
        public KmDate getValueFor(MyAttachment model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyAttachment model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaAttachment_CreatedLocalTime
        extends KmMetaTimeProperty<MyAttachment>
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
        public KmTime getValueFor(MyAttachment model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyAttachment model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }

    //##################################################
    //# UpdatedLocalTs
    //##################################################

    public class MyMetaAttachment_UpdatedLocalTs
        extends KmMetaTimestampProperty<MyAttachment>
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
        public KmTimestamp getValueFor(MyAttachment model)
        {
            return model.getUpdatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyAttachment model, KmTimestamp value)
        {
            return model.hasUpdatedLocalTs(value);
        }
    }

    //##################################################
    //# UpdatedLocalTsMessage
    //##################################################

    public class MyMetaAttachment_UpdatedLocalTsMessage
        extends KmMetaStringProperty<MyAttachment>
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
        public String getValueFor(MyAttachment model)
        {
            return model.getUpdatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyAttachment model, String value)
        {
            return model.hasUpdatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# UpdatedLocalDate
    //##################################################

    public class MyMetaAttachment_UpdatedLocalDate
        extends KmMetaDateProperty<MyAttachment>
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
        public KmDate getValueFor(MyAttachment model)
        {
            return model.getUpdatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyAttachment model, KmDate value)
        {
            return model.hasUpdatedLocalDate(value);
        }
    }

    //##################################################
    //# UpdatedLocalTime
    //##################################################

    public class MyMetaAttachment_UpdatedLocalTime
        extends KmMetaTimeProperty<MyAttachment>
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
        public KmTime getValueFor(MyAttachment model)
        {
            return model.getUpdatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyAttachment model, KmTime value)
        {
            return model.hasUpdatedLocalTime(value);
        }
    }

    //##################################################
    //# CreatedByFullName
    //##################################################

    public class MyMetaAttachment_CreatedByFullName
        extends KmMetaStringProperty<MyAttachment>
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
        public String getValueFor(MyAttachment model)
        {
            return model.getCreatedByFullName();
        }

        @Override
        public void setValueFor(MyAttachment model, String value)
        {
            model.setCreatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyAttachment model, String value)
        {
            return model.hasCreatedByFullName(value);
        }
    }

    //##################################################
    //# UpdatedByFullName
    //##################################################

    public class MyMetaAttachment_UpdatedByFullName
        extends KmMetaStringProperty<MyAttachment>
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
        public String getValueFor(MyAttachment model)
        {
            return model.getUpdatedByFullName();
        }

        @Override
        public void setValueFor(MyAttachment model, String value)
        {
            model.setUpdatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyAttachment model, String value)
        {
            return model.hasUpdatedByFullName(value);
        }
    }


    //##################################################
    //# CreatedBy
    //##################################################

    public class MyMetaAttachment_CreatedBy
        extends KmMetaDaoAssociation<MyAttachment,MyUser>
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
        public MyUser getValueFor(MyAttachment model)
        {
            return model.getCreatedBy();
        }

        @Override
        public void setValueFor(MyAttachment model, MyUser value)
        {
            model.setCreatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyAttachment model, MyUser value)
        {
            return model.hasCreatedBy(value);
        }
    }

    //##################################################
    //# Customer
    //##################################################

    public class MyMetaAttachment_Customer
        extends KmMetaDaoAssociation<MyAttachment,MyCustomer>
    {
        @Override
        public String getName()
        {
            return "customer";
        }

        @Override
        public String getLabel()
        {
            return "Customer";
        }

        @Override
        public String getHelp()
        {
            return "The customer that owns this note.";
        }

        @Override
        public boolean isRequired()
        {
            return false;
        }

        @Override
        public MyCustomer getValueFor(MyAttachment model)
        {
            return model.getCustomer();
        }

        @Override
        public void setValueFor(MyAttachment model, MyCustomer value)
        {
            model.setCustomer(value);
        }

        @Override
        public boolean hasValueFor(MyAttachment model, MyCustomer value)
        {
            return model.hasCustomer(value);
        }
    }

    //##################################################
    //# Project
    //##################################################

    public class MyMetaAttachment_Project
        extends KmMetaDaoAssociation<MyAttachment,MyProject>
    {
        @Override
        public String getName()
        {
            return "project";
        }

        @Override
        public String getLabel()
        {
            return "Project";
        }

        @Override
        public String getHelp()
        {
            return "The project that contains this decoration.";
        }

        @Override
        public boolean isRequired()
        {
            return true;
        }

        @Override
        public MyProject getValueFor(MyAttachment model)
        {
            return model.getProject();
        }

        @Override
        public void setValueFor(MyAttachment model, MyProject value)
        {
            model.setProject(value);
        }

        @Override
        public boolean hasValueFor(MyAttachment model, MyProject value)
        {
            return model.hasProject(value);
        }
    }

    //##################################################
    //# Site
    //##################################################

    public class MyMetaAttachment_Site
        extends KmMetaDaoAssociation<MyAttachment,MySite>
    {
        @Override
        public String getName()
        {
            return "site";
        }

        @Override
        public String getLabel()
        {
            return "Site";
        }

        @Override
        public String getHelp()
        {
            return "The site that owns this note.";
        }

        @Override
        public boolean isRequired()
        {
            return false;
        }

        @Override
        public MySite getValueFor(MyAttachment model)
        {
            return model.getSite();
        }

        @Override
        public void setValueFor(MyAttachment model, MySite value)
        {
            model.setSite(value);
        }

        @Override
        public boolean hasValueFor(MyAttachment model, MySite value)
        {
            return model.hasSite(value);
        }
    }

    //##################################################
    //# Tenant
    //##################################################

    public class MyMetaAttachment_Tenant
        extends KmMetaDaoAssociation<MyAttachment,MyTenant>
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
            return "The tenant that contains this decoration.";
        }

        @Override
        public boolean isRequired()
        {
            return true;
        }

        @Override
        public MyTenant getValueFor(MyAttachment model)
        {
            return model.getTenant();
        }

        @Override
        public void setValueFor(MyAttachment model, MyTenant value)
        {
            model.setTenant(value);
        }

        @Override
        public boolean hasValueFor(MyAttachment model, MyTenant value)
        {
            return model.hasTenant(value);
        }
    }

    //##################################################
    //# UpdatedBy
    //##################################################

    public class MyMetaAttachment_UpdatedBy
        extends KmMetaDaoAssociation<MyAttachment,MyUser>
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
        public MyUser getValueFor(MyAttachment model)
        {
            return model.getUpdatedBy();
        }

        @Override
        public void setValueFor(MyAttachment model, MyUser value)
        {
            model.setUpdatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyAttachment model, MyUser value)
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
