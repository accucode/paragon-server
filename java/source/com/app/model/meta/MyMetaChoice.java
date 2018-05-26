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

public class MyMetaChoice
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaChoice instance = new MyMetaChoice();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaChoice()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "choice";
    }

    public MyChoiceValidator getValidator()
    {
        return MyChoiceValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "A list of choices, organized by type. These choices are used to facilitate consistency while simulaneously allowing users to easily enter ad hoc values.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaChoice_AuditLogTitle AuditLogTitle = new MyMetaChoice_AuditLogTitle();
    public final MyMetaChoice_CreatedUtcTs CreatedUtcTs = new MyMetaChoice_CreatedUtcTs();
    public final MyMetaChoice_DefaultValue DefaultValue = new MyMetaChoice_DefaultValue();
    public final MyMetaChoice_DomainSubtitle DomainSubtitle = new MyMetaChoice_DomainSubtitle();
    public final MyMetaChoice_DomainTitle DomainTitle = new MyMetaChoice_DomainTitle();
    public final MyMetaChoice_Enabled Enabled = new MyMetaChoice_Enabled();
    public final MyMetaChoice_EnabledStatus EnabledStatus = new MyMetaChoice_EnabledStatus();
    public final MyMetaChoice_Name Name = new MyMetaChoice_Name();
    public final MyMetaChoice_TypeCode TypeCode = new MyMetaChoice_TypeCode();
    public final MyMetaChoice_Uid Uid = new MyMetaChoice_Uid();
    public final MyMetaChoice_UpdatedUtcTs UpdatedUtcTs = new MyMetaChoice_UpdatedUtcTs();
    public final MyMetaChoice_LockVersion LockVersion = new MyMetaChoice_LockVersion();
    public final MyMetaChoice_TypeName TypeName = new MyMetaChoice_TypeName();
    public final MyMetaChoice_CreatedLocalTs CreatedLocalTs = new MyMetaChoice_CreatedLocalTs();
    public final MyMetaChoice_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaChoice_CreatedLocalTsMessage();
    public final MyMetaChoice_CreatedLocalDate CreatedLocalDate = new MyMetaChoice_CreatedLocalDate();
    public final MyMetaChoice_CreatedLocalTime CreatedLocalTime = new MyMetaChoice_CreatedLocalTime();
    public final MyMetaChoice_UpdatedLocalTs UpdatedLocalTs = new MyMetaChoice_UpdatedLocalTs();
    public final MyMetaChoice_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaChoice_UpdatedLocalTsMessage();
    public final MyMetaChoice_UpdatedLocalDate UpdatedLocalDate = new MyMetaChoice_UpdatedLocalDate();
    public final MyMetaChoice_UpdatedLocalTime UpdatedLocalTime = new MyMetaChoice_UpdatedLocalTime();
    public final MyMetaChoice_CreatedByFullName CreatedByFullName = new MyMetaChoice_CreatedByFullName();
    public final MyMetaChoice_ProjectName ProjectName = new MyMetaChoice_ProjectName();
    public final MyMetaChoice_UpdatedByFullName UpdatedByFullName = new MyMetaChoice_UpdatedByFullName();

    //##################################################
    //# associations
    //##################################################

    public final MyMetaChoice_CreatedBy CreatedBy = new MyMetaChoice_CreatedBy();
    public final MyMetaChoice_Project Project = new MyMetaChoice_Project();
    public final MyMetaChoice_UpdatedBy UpdatedBy = new MyMetaChoice_UpdatedBy();

    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaChoice_AuditLogTitle
        extends KmMetaStringProperty<MyChoice>
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
        public String getValueFor(MyChoice model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyChoice model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaChoice_CreatedUtcTs
        extends KmMetaTimestampProperty<MyChoice>
        implements KmMetaDaoPropertyIF<MyChoice,KmTimestamp>
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
            return MyChoiceValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MyChoiceDao getDao()
        {
            return getAccess().getChoiceDao();
        }

        @Override
        public KmTimestamp getValueFor(MyChoice model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MyChoice model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyChoice model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# DefaultValue
    //##################################################

    public class MyMetaChoice_DefaultValue
        extends KmMetaBooleanProperty<MyChoice>
        implements KmMetaDaoPropertyIF<MyChoice,Boolean>
    {
        @Override
        public String getName()
        {
            return "defaultValue";
        }

        @Override
        public String getLabel()
        {
            return "Default";
        }

        @Override
        public String getHelp()
        {
            return "Indicates if this choice should be used as a default. Topics are not required to have a default, but they should not have multiple defaults.";
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
            return MyChoiceValidator.instance.getDefaultValueValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "defaultValue";
        }

        @Override
        public MyChoiceDao getDao()
        {
            return getAccess().getChoiceDao();
        }

        @Override
        public Boolean getValueFor(MyChoice model)
        {
            return model.getDefaultValue();
        }

        @Override
        public void setValueFor(MyChoice model, Boolean value)
        {
            model.setDefaultValue(value);
        }

        @Override
        public boolean hasValueFor(MyChoice model, Boolean value)
        {
            return model.hasDefaultValue(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaChoice_DomainSubtitle
        extends KmMetaStringProperty<MyChoice>
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
        public String getValueFor(MyChoice model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyChoice model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaChoice_DomainTitle
        extends KmMetaStringProperty<MyChoice>
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
        public String getValueFor(MyChoice model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyChoice model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# Enabled
    //##################################################

    public class MyMetaChoice_Enabled
        extends KmMetaBooleanProperty<MyChoice>
        implements KmMetaDaoPropertyIF<MyChoice,Boolean>
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
            return MyChoiceValidator.instance.getEnabledValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "enabled";
        }

        @Override
        public MyChoiceDao getDao()
        {
            return getAccess().getChoiceDao();
        }

        @Override
        public Boolean getValueFor(MyChoice model)
        {
            return model.getEnabled();
        }

        @Override
        public void setValueFor(MyChoice model, Boolean value)
        {
            model.setEnabled(value);
        }

        @Override
        public boolean hasValueFor(MyChoice model, Boolean value)
        {
            return model.hasEnabled(value);
        }
    }

    //##################################################
    //# EnabledStatus
    //##################################################

    public class MyMetaChoice_EnabledStatus
        extends KmMetaStringProperty<MyChoice>
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
        public String getValueFor(MyChoice model)
        {
            return model.getEnabledStatus();
        }

        @Override
        public boolean hasValueFor(MyChoice model, String value)
        {
            return model.hasEnabledStatus(value);
        }
    }

    //##################################################
    //# Name
    //##################################################

    public class MyMetaChoice_Name
        extends KmMetaStringProperty<MyChoice>
        implements KmMetaDaoPropertyIF<MyChoice,String>
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
            return "The display name of the choice.";
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
            return MyChoiceValidator.instance.getNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "name";
        }

        @Override
        public MyChoiceDao getDao()
        {
            return getAccess().getChoiceDao();
        }

        @Override
        public String getValueFor(MyChoice model)
        {
            return model.getName();
        }

        @Override
        public void setValueFor(MyChoice model, String value)
        {
            model.setName(value);
        }

        @Override
        public boolean hasValueFor(MyChoice model, String value)
        {
            return model.hasName(value);
        }
    }

    //##################################################
    //# TypeCode
    //##################################################

    public class MyMetaChoice_TypeCode
        extends KmMetaStringProperty<MyChoice>
        implements KmMetaDaoPropertyIF<MyChoice,String>
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
            return "The type of choice.";
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
            return MyChoiceValidator.instance.getTypeCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "typeCode";
        }

        @Override
        public MyChoiceDao getDao()
        {
            return getAccess().getChoiceDao();
        }

        public ScDynamicEnumDropdownField newDropdown()
        {
            ScDynamicEnumDropdownField e;
            e = new ScDynamicEnumDropdownField();
            e.setMeta(this);
            e.setEnumArraySupplier(MyChoiceType::values);
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
        public String getValueFor(MyChoice model)
        {
            return model.getTypeCode();
        }

        @Override
        public void setValueFor(MyChoice model, String value)
        {
            model.setTypeCode(value);
        }

        @Override
        public boolean hasValueFor(MyChoice model, String value)
        {
            return model.hasTypeCode(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaChoice_Uid
        extends KmMetaStringProperty<MyChoice>
        implements KmMetaDaoPropertyIF<MyChoice,String>
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
            return MyChoiceValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyChoiceDao getDao()
        {
            return getAccess().getChoiceDao();
        }

        public KmDaoStringKeyCursor<MyChoice> createCursor()
        {
            KmDaoStringKeyCursor<MyChoice> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyChoice model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyChoice model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyChoice model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# UpdatedUtcTs
    //##################################################

    public class MyMetaChoice_UpdatedUtcTs
        extends KmMetaTimestampProperty<MyChoice>
        implements KmMetaDaoPropertyIF<MyChoice,KmTimestamp>
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
            return MyChoiceValidator.instance.getUpdatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "updatedUtcTs";
        }

        @Override
        public MyChoiceDao getDao()
        {
            return getAccess().getChoiceDao();
        }

        @Override
        public KmTimestamp getValueFor(MyChoice model)
        {
            return model.getUpdatedUtcTs();
        }

        @Override
        public void setValueFor(MyChoice model, KmTimestamp value)
        {
            model.setUpdatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyChoice model, KmTimestamp value)
        {
            return model.hasUpdatedUtcTs(value);
        }
    }

    //##################################################
    //# LockVersion
    //##################################################

    public class MyMetaChoice_LockVersion
        extends KmMetaIntegerProperty<MyChoice>
        implements KmMetaDaoPropertyIF<MyChoice,Integer>
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
            return MyChoiceValidator.instance.getLockVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lockVersion";
        }

        @Override
        public MyChoiceDao getDao()
        {
            return getAccess().getChoiceDao();
        }

        @Override
        public Integer getValueFor(MyChoice model)
        {
            return model.getLockVersion();
        }

        @Override
        public void setValueFor(MyChoice model, Integer value)
        {
            model.setLockVersion(value);
        }

        @Override
        public boolean hasValueFor(MyChoice model, Integer value)
        {
            return model.hasLockVersion(value);
        }
    }

    //##################################################
    //# TypeName
    //##################################################

    public class MyMetaChoice_TypeName
        extends KmMetaStringProperty<MyChoice>
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
            return "The type of choice.";
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
        public String getValueFor(MyChoice model)
        {
            return model.getTypeName();
        }

        @Override
        public boolean hasValueFor(MyChoice model, String value)
        {
            return model.hasTypeName(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaChoice_CreatedLocalTs
        extends KmMetaTimestampProperty<MyChoice>
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
        public KmTimestamp getValueFor(MyChoice model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyChoice model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaChoice_CreatedLocalTsMessage
        extends KmMetaStringProperty<MyChoice>
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
        public String getValueFor(MyChoice model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyChoice model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaChoice_CreatedLocalDate
        extends KmMetaDateProperty<MyChoice>
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
        public KmDate getValueFor(MyChoice model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyChoice model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaChoice_CreatedLocalTime
        extends KmMetaTimeProperty<MyChoice>
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
        public KmTime getValueFor(MyChoice model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyChoice model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }

    //##################################################
    //# UpdatedLocalTs
    //##################################################

    public class MyMetaChoice_UpdatedLocalTs
        extends KmMetaTimestampProperty<MyChoice>
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
        public KmTimestamp getValueFor(MyChoice model)
        {
            return model.getUpdatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyChoice model, KmTimestamp value)
        {
            return model.hasUpdatedLocalTs(value);
        }
    }

    //##################################################
    //# UpdatedLocalTsMessage
    //##################################################

    public class MyMetaChoice_UpdatedLocalTsMessage
        extends KmMetaStringProperty<MyChoice>
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
        public String getValueFor(MyChoice model)
        {
            return model.getUpdatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyChoice model, String value)
        {
            return model.hasUpdatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# UpdatedLocalDate
    //##################################################

    public class MyMetaChoice_UpdatedLocalDate
        extends KmMetaDateProperty<MyChoice>
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
        public KmDate getValueFor(MyChoice model)
        {
            return model.getUpdatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyChoice model, KmDate value)
        {
            return model.hasUpdatedLocalDate(value);
        }
    }

    //##################################################
    //# UpdatedLocalTime
    //##################################################

    public class MyMetaChoice_UpdatedLocalTime
        extends KmMetaTimeProperty<MyChoice>
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
        public KmTime getValueFor(MyChoice model)
        {
            return model.getUpdatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyChoice model, KmTime value)
        {
            return model.hasUpdatedLocalTime(value);
        }
    }

    //##################################################
    //# CreatedByFullName
    //##################################################

    public class MyMetaChoice_CreatedByFullName
        extends KmMetaStringProperty<MyChoice>
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
        public String getValueFor(MyChoice model)
        {
            return model.getCreatedByFullName();
        }

        @Override
        public void setValueFor(MyChoice model, String value)
        {
            model.setCreatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyChoice model, String value)
        {
            return model.hasCreatedByFullName(value);
        }
    }

    //##################################################
    //# ProjectName
    //##################################################

    public class MyMetaChoice_ProjectName
        extends KmMetaStringProperty<MyChoice>
    {
        @Override
        public String getName()
        {
            return "projectName";
        }

        @Override
        public String getLabel()
        {
            return "Project Name";
        }

        @Override
        public String getHelp()
        {
            return "The display name.";
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
        public String getValueFor(MyChoice model)
        {
            return model.getProjectName();
        }

        @Override
        public void setValueFor(MyChoice model, String value)
        {
            model.setProjectName(value);
        }

        @Override
        public boolean hasValueFor(MyChoice model, String value)
        {
            return model.hasProjectName(value);
        }
    }

    //##################################################
    //# UpdatedByFullName
    //##################################################

    public class MyMetaChoice_UpdatedByFullName
        extends KmMetaStringProperty<MyChoice>
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
        public String getValueFor(MyChoice model)
        {
            return model.getUpdatedByFullName();
        }

        @Override
        public void setValueFor(MyChoice model, String value)
        {
            model.setUpdatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyChoice model, String value)
        {
            return model.hasUpdatedByFullName(value);
        }
    }


    //##################################################
    //# CreatedBy
    //##################################################

    public class MyMetaChoice_CreatedBy
        extends KmMetaDaoAssociation<MyChoice,MyUser>
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
        public MyUser getValueFor(MyChoice model)
        {
            return model.getCreatedBy();
        }

        @Override
        public void setValueFor(MyChoice model, MyUser value)
        {
            model.setCreatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyChoice model, MyUser value)
        {
            return model.hasCreatedBy(value);
        }
    }

    //##################################################
    //# Project
    //##################################################

    public class MyMetaChoice_Project
        extends KmMetaDaoAssociation<MyChoice,MyProject>
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
            return "The project that defines this choice.";
        }

        @Override
        public boolean isRequired()
        {
            return true;
        }

        @Override
        public MyProject getValueFor(MyChoice model)
        {
            return model.getProject();
        }

        @Override
        public void setValueFor(MyChoice model, MyProject value)
        {
            model.setProject(value);
        }

        @Override
        public boolean hasValueFor(MyChoice model, MyProject value)
        {
            return model.hasProject(value);
        }
    }

    //##################################################
    //# UpdatedBy
    //##################################################

    public class MyMetaChoice_UpdatedBy
        extends KmMetaDaoAssociation<MyChoice,MyUser>
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
        public MyUser getValueFor(MyChoice model)
        {
            return model.getUpdatedBy();
        }

        @Override
        public void setValueFor(MyChoice model, MyUser value)
        {
            model.setUpdatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyChoice model, MyUser value)
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
