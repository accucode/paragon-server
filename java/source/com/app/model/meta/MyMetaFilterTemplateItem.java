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

public class MyMetaFilterTemplateItem
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaFilterTemplateItem instance = new MyMetaFilterTemplateItem();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaFilterTemplateItem()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "filterTemplateItem";
    }

    public MyFilterTemplateItemValidator getValidator()
    {
        return MyFilterTemplateItemValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "A single item within a filter template. For example city=Denver.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaFilterTemplateItem_AttributeCode AttributeCode = new MyMetaFilterTemplateItem_AttributeCode();
    public final MyMetaFilterTemplateItem_AuditLogTitle AuditLogTitle = new MyMetaFilterTemplateItem_AuditLogTitle();
    public final MyMetaFilterTemplateItem_CreatedUtcTs CreatedUtcTs = new MyMetaFilterTemplateItem_CreatedUtcTs();
    public final MyMetaFilterTemplateItem_DomainSubtitle DomainSubtitle = new MyMetaFilterTemplateItem_DomainSubtitle();
    public final MyMetaFilterTemplateItem_DomainTitle DomainTitle = new MyMetaFilterTemplateItem_DomainTitle();
    public final MyMetaFilterTemplateItem_Uid Uid = new MyMetaFilterTemplateItem_Uid();
    public final MyMetaFilterTemplateItem_UpdatedUtcTs UpdatedUtcTs = new MyMetaFilterTemplateItem_UpdatedUtcTs();
    public final MyMetaFilterTemplateItem_Used Used = new MyMetaFilterTemplateItem_Used();
    public final MyMetaFilterTemplateItem_Value Value = new MyMetaFilterTemplateItem_Value();
    public final MyMetaFilterTemplateItem_LockVersion LockVersion = new MyMetaFilterTemplateItem_LockVersion();
    public final MyMetaFilterTemplateItem_CreatedLocalTs CreatedLocalTs = new MyMetaFilterTemplateItem_CreatedLocalTs();
    public final MyMetaFilterTemplateItem_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaFilterTemplateItem_CreatedLocalTsMessage();
    public final MyMetaFilterTemplateItem_CreatedLocalDate CreatedLocalDate = new MyMetaFilterTemplateItem_CreatedLocalDate();
    public final MyMetaFilterTemplateItem_CreatedLocalTime CreatedLocalTime = new MyMetaFilterTemplateItem_CreatedLocalTime();
    public final MyMetaFilterTemplateItem_UpdatedLocalTs UpdatedLocalTs = new MyMetaFilterTemplateItem_UpdatedLocalTs();
    public final MyMetaFilterTemplateItem_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaFilterTemplateItem_UpdatedLocalTsMessage();
    public final MyMetaFilterTemplateItem_UpdatedLocalDate UpdatedLocalDate = new MyMetaFilterTemplateItem_UpdatedLocalDate();
    public final MyMetaFilterTemplateItem_UpdatedLocalTime UpdatedLocalTime = new MyMetaFilterTemplateItem_UpdatedLocalTime();
    public final MyMetaFilterTemplateItem_CreatedByFullName CreatedByFullName = new MyMetaFilterTemplateItem_CreatedByFullName();
    public final MyMetaFilterTemplateItem_UpdatedByFullName UpdatedByFullName = new MyMetaFilterTemplateItem_UpdatedByFullName();

    //##################################################
    //# associations
    //##################################################

    public final MyMetaFilterTemplateItem_CreatedBy CreatedBy = new MyMetaFilterTemplateItem_CreatedBy();
    public final MyMetaFilterTemplateItem_Template Template = new MyMetaFilterTemplateItem_Template();
    public final MyMetaFilterTemplateItem_UpdatedBy UpdatedBy = new MyMetaFilterTemplateItem_UpdatedBy();

    //##################################################
    //# AttributeCode
    //##################################################

    public class MyMetaFilterTemplateItem_AttributeCode
        extends KmMetaStringProperty<MyFilterTemplateItem>
        implements KmMetaDaoPropertyIF<MyFilterTemplateItem,String>
    {
        @Override
        public String getName()
        {
            return "attributeCode";
        }

        @Override
        public String getLabel()
        {
            return "Attribute Code";
        }

        @Override
        public String getHelp()
        {
            return "Identify a specific attribute within the template.";
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
            return MyFilterTemplateItemValidator.instance.getAttributeCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "attributeCode";
        }

        @Override
        public MyFilterTemplateItemDao getDao()
        {
            return getAccess().getFilterTemplateItemDao();
        }

        @Override
        public String getValueFor(MyFilterTemplateItem model)
        {
            return model.getAttributeCode();
        }

        @Override
        public void setValueFor(MyFilterTemplateItem model, String value)
        {
            model.setAttributeCode(value);
        }

        @Override
        public boolean hasValueFor(MyFilterTemplateItem model, String value)
        {
            return model.hasAttributeCode(value);
        }
    }

    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaFilterTemplateItem_AuditLogTitle
        extends KmMetaStringProperty<MyFilterTemplateItem>
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
        public String getValueFor(MyFilterTemplateItem model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyFilterTemplateItem model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaFilterTemplateItem_CreatedUtcTs
        extends KmMetaTimestampProperty<MyFilterTemplateItem>
        implements KmMetaDaoPropertyIF<MyFilterTemplateItem,KmTimestamp>
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
            return MyFilterTemplateItemValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MyFilterTemplateItemDao getDao()
        {
            return getAccess().getFilterTemplateItemDao();
        }

        @Override
        public KmTimestamp getValueFor(MyFilterTemplateItem model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MyFilterTemplateItem model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyFilterTemplateItem model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaFilterTemplateItem_DomainSubtitle
        extends KmMetaStringProperty<MyFilterTemplateItem>
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
        public String getValueFor(MyFilterTemplateItem model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyFilterTemplateItem model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaFilterTemplateItem_DomainTitle
        extends KmMetaStringProperty<MyFilterTemplateItem>
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
        public String getValueFor(MyFilterTemplateItem model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyFilterTemplateItem model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaFilterTemplateItem_Uid
        extends KmMetaStringProperty<MyFilterTemplateItem>
        implements KmMetaDaoPropertyIF<MyFilterTemplateItem,String>
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
            return MyFilterTemplateItemValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyFilterTemplateItemDao getDao()
        {
            return getAccess().getFilterTemplateItemDao();
        }

        public KmDaoStringKeyCursor<MyFilterTemplateItem> createCursor()
        {
            KmDaoStringKeyCursor<MyFilterTemplateItem> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyFilterTemplateItem model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyFilterTemplateItem model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyFilterTemplateItem model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# UpdatedUtcTs
    //##################################################

    public class MyMetaFilterTemplateItem_UpdatedUtcTs
        extends KmMetaTimestampProperty<MyFilterTemplateItem>
        implements KmMetaDaoPropertyIF<MyFilterTemplateItem,KmTimestamp>
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
            return MyFilterTemplateItemValidator.instance.getUpdatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "updatedUtcTs";
        }

        @Override
        public MyFilterTemplateItemDao getDao()
        {
            return getAccess().getFilterTemplateItemDao();
        }

        @Override
        public KmTimestamp getValueFor(MyFilterTemplateItem model)
        {
            return model.getUpdatedUtcTs();
        }

        @Override
        public void setValueFor(MyFilterTemplateItem model, KmTimestamp value)
        {
            model.setUpdatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyFilterTemplateItem model, KmTimestamp value)
        {
            return model.hasUpdatedUtcTs(value);
        }
    }

    //##################################################
    //# Used
    //##################################################

    public class MyMetaFilterTemplateItem_Used
        extends KmMetaBooleanProperty<MyFilterTemplateItem>
        implements KmMetaDaoPropertyIF<MyFilterTemplateItem,Boolean>
    {
        @Override
        public String getName()
        {
            return "used";
        }

        @Override
        public String getLabel()
        {
            return "Used";
        }

        @Override
        public String getHelp()
        {
            return "Indicates if this item is used in the filter. Setting this to true/false is simpler than inserting/deleting the entire record.";
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
            return MyFilterTemplateItemValidator.instance.getUsedValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "used";
        }

        @Override
        public MyFilterTemplateItemDao getDao()
        {
            return getAccess().getFilterTemplateItemDao();
        }

        @Override
        public Boolean getValueFor(MyFilterTemplateItem model)
        {
            return model.getUsed();
        }

        @Override
        public void setValueFor(MyFilterTemplateItem model, Boolean value)
        {
            model.setUsed(value);
        }

        @Override
        public boolean hasValueFor(MyFilterTemplateItem model, Boolean value)
        {
            return model.hasUsed(value);
        }
    }

    //##################################################
    //# Value
    //##################################################

    public class MyMetaFilterTemplateItem_Value
        extends KmMetaStringProperty<MyFilterTemplateItem>
        implements KmMetaDaoPropertyIF<MyFilterTemplateItem,String>
    {
        @Override
        public String getName()
        {
            return "value";
        }

        @Override
        public String getLabel()
        {
            return "Value";
        }

        @Override
        public String getHelp()
        {
            return "The encoded value for this item. The value is always stored as a string, and the format will vary depending on the type of value being stored.";
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
            return MyFilterTemplateItemValidator.instance.getValueValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "value";
        }

        @Override
        public MyFilterTemplateItemDao getDao()
        {
            return getAccess().getFilterTemplateItemDao();
        }

        @Override
        public String getValueFor(MyFilterTemplateItem model)
        {
            return model.getValue();
        }

        @Override
        public void setValueFor(MyFilterTemplateItem model, String value)
        {
            model.setValue(value);
        }

        @Override
        public boolean hasValueFor(MyFilterTemplateItem model, String value)
        {
            return model.hasValue(value);
        }
    }

    //##################################################
    //# LockVersion
    //##################################################

    public class MyMetaFilterTemplateItem_LockVersion
        extends KmMetaIntegerProperty<MyFilterTemplateItem>
        implements KmMetaDaoPropertyIF<MyFilterTemplateItem,Integer>
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
            return MyFilterTemplateItemValidator.instance.getLockVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lockVersion";
        }

        @Override
        public MyFilterTemplateItemDao getDao()
        {
            return getAccess().getFilterTemplateItemDao();
        }

        @Override
        public Integer getValueFor(MyFilterTemplateItem model)
        {
            return model.getLockVersion();
        }

        @Override
        public void setValueFor(MyFilterTemplateItem model, Integer value)
        {
            model.setLockVersion(value);
        }

        @Override
        public boolean hasValueFor(MyFilterTemplateItem model, Integer value)
        {
            return model.hasLockVersion(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaFilterTemplateItem_CreatedLocalTs
        extends KmMetaTimestampProperty<MyFilterTemplateItem>
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
        public KmTimestamp getValueFor(MyFilterTemplateItem model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyFilterTemplateItem model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaFilterTemplateItem_CreatedLocalTsMessage
        extends KmMetaStringProperty<MyFilterTemplateItem>
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
        public String getValueFor(MyFilterTemplateItem model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyFilterTemplateItem model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaFilterTemplateItem_CreatedLocalDate
        extends KmMetaDateProperty<MyFilterTemplateItem>
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
        public KmDate getValueFor(MyFilterTemplateItem model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyFilterTemplateItem model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaFilterTemplateItem_CreatedLocalTime
        extends KmMetaTimeProperty<MyFilterTemplateItem>
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
        public KmTime getValueFor(MyFilterTemplateItem model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyFilterTemplateItem model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }

    //##################################################
    //# UpdatedLocalTs
    //##################################################

    public class MyMetaFilterTemplateItem_UpdatedLocalTs
        extends KmMetaTimestampProperty<MyFilterTemplateItem>
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
        public KmTimestamp getValueFor(MyFilterTemplateItem model)
        {
            return model.getUpdatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyFilterTemplateItem model, KmTimestamp value)
        {
            return model.hasUpdatedLocalTs(value);
        }
    }

    //##################################################
    //# UpdatedLocalTsMessage
    //##################################################

    public class MyMetaFilterTemplateItem_UpdatedLocalTsMessage
        extends KmMetaStringProperty<MyFilterTemplateItem>
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
        public String getValueFor(MyFilterTemplateItem model)
        {
            return model.getUpdatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyFilterTemplateItem model, String value)
        {
            return model.hasUpdatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# UpdatedLocalDate
    //##################################################

    public class MyMetaFilterTemplateItem_UpdatedLocalDate
        extends KmMetaDateProperty<MyFilterTemplateItem>
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
        public KmDate getValueFor(MyFilterTemplateItem model)
        {
            return model.getUpdatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyFilterTemplateItem model, KmDate value)
        {
            return model.hasUpdatedLocalDate(value);
        }
    }

    //##################################################
    //# UpdatedLocalTime
    //##################################################

    public class MyMetaFilterTemplateItem_UpdatedLocalTime
        extends KmMetaTimeProperty<MyFilterTemplateItem>
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
        public KmTime getValueFor(MyFilterTemplateItem model)
        {
            return model.getUpdatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyFilterTemplateItem model, KmTime value)
        {
            return model.hasUpdatedLocalTime(value);
        }
    }

    //##################################################
    //# CreatedByFullName
    //##################################################

    public class MyMetaFilterTemplateItem_CreatedByFullName
        extends KmMetaStringProperty<MyFilterTemplateItem>
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
        public String getValueFor(MyFilterTemplateItem model)
        {
            return model.getCreatedByFullName();
        }

        @Override
        public void setValueFor(MyFilterTemplateItem model, String value)
        {
            model.setCreatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyFilterTemplateItem model, String value)
        {
            return model.hasCreatedByFullName(value);
        }
    }

    //##################################################
    //# UpdatedByFullName
    //##################################################

    public class MyMetaFilterTemplateItem_UpdatedByFullName
        extends KmMetaStringProperty<MyFilterTemplateItem>
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
        public String getValueFor(MyFilterTemplateItem model)
        {
            return model.getUpdatedByFullName();
        }

        @Override
        public void setValueFor(MyFilterTemplateItem model, String value)
        {
            model.setUpdatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyFilterTemplateItem model, String value)
        {
            return model.hasUpdatedByFullName(value);
        }
    }


    //##################################################
    //# CreatedBy
    //##################################################

    public class MyMetaFilterTemplateItem_CreatedBy
        extends KmMetaDaoAssociation<MyFilterTemplateItem,MyUser>
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
        public MyUser getValueFor(MyFilterTemplateItem model)
        {
            return model.getCreatedBy();
        }

        @Override
        public void setValueFor(MyFilterTemplateItem model, MyUser value)
        {
            model.setCreatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyFilterTemplateItem model, MyUser value)
        {
            return model.hasCreatedBy(value);
        }
    }

    //##################################################
    //# Template
    //##################################################

    public class MyMetaFilterTemplateItem_Template
        extends KmMetaDaoAssociation<MyFilterTemplateItem,MyFilterTemplate>
    {
        @Override
        public String getName()
        {
            return "template";
        }

        @Override
        public String getLabel()
        {
            return "Template";
        }

        @Override
        public String getHelp()
        {
            return "The template that contains this item.";
        }

        @Override
        public boolean isRequired()
        {
            return true;
        }

        @Override
        public MyFilterTemplate getValueFor(MyFilterTemplateItem model)
        {
            return model.getTemplate();
        }

        @Override
        public void setValueFor(MyFilterTemplateItem model, MyFilterTemplate value)
        {
            model.setTemplate(value);
        }

        @Override
        public boolean hasValueFor(MyFilterTemplateItem model, MyFilterTemplate value)
        {
            return model.hasTemplate(value);
        }
    }

    //##################################################
    //# UpdatedBy
    //##################################################

    public class MyMetaFilterTemplateItem_UpdatedBy
        extends KmMetaDaoAssociation<MyFilterTemplateItem,MyUser>
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
        public MyUser getValueFor(MyFilterTemplateItem model)
        {
            return model.getUpdatedBy();
        }

        @Override
        public void setValueFor(MyFilterTemplateItem model, MyUser value)
        {
            model.setUpdatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyFilterTemplateItem model, MyUser value)
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
