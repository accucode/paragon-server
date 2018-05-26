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

public class MyMetaFilterTemplate
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaFilterTemplate instance = new MyMetaFilterTemplate();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaFilterTemplate()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "filterTemplate";
    }

    public MyFilterTemplateValidator getValidator()
    {
        return MyFilterTemplateValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "The list of attributes associated with a particular filter. This is used to store a specific configuration of a filter so that it can be easily reused.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaFilterTemplate_AuditLogTitle AuditLogTitle = new MyMetaFilterTemplate_AuditLogTitle();
    public final MyMetaFilterTemplate_ContextTypeCode ContextTypeCode = new MyMetaFilterTemplate_ContextTypeCode();
    public final MyMetaFilterTemplate_CreatedUtcTs CreatedUtcTs = new MyMetaFilterTemplate_CreatedUtcTs();
    public final MyMetaFilterTemplate_Deleted Deleted = new MyMetaFilterTemplate_Deleted();
    public final MyMetaFilterTemplate_DomainSubtitle DomainSubtitle = new MyMetaFilterTemplate_DomainSubtitle();
    public final MyMetaFilterTemplate_DomainTitle DomainTitle = new MyMetaFilterTemplate_DomainTitle();
    public final MyMetaFilterTemplate_Modified Modified = new MyMetaFilterTemplate_Modified();
    public final MyMetaFilterTemplate_Name Name = new MyMetaFilterTemplate_Name();
    public final MyMetaFilterTemplate_Preferred Preferred = new MyMetaFilterTemplate_Preferred();
    public final MyMetaFilterTemplate_TypeCode TypeCode = new MyMetaFilterTemplate_TypeCode();
    public final MyMetaFilterTemplate_Uid Uid = new MyMetaFilterTemplate_Uid();
    public final MyMetaFilterTemplate_UpdatedUtcTs UpdatedUtcTs = new MyMetaFilterTemplate_UpdatedUtcTs();
    public final MyMetaFilterTemplate_LockVersion LockVersion = new MyMetaFilterTemplate_LockVersion();
    public final MyMetaFilterTemplate_ContextTypeName ContextTypeName = new MyMetaFilterTemplate_ContextTypeName();
    public final MyMetaFilterTemplate_TypeName TypeName = new MyMetaFilterTemplate_TypeName();
    public final MyMetaFilterTemplate_CreatedLocalTs CreatedLocalTs = new MyMetaFilterTemplate_CreatedLocalTs();
    public final MyMetaFilterTemplate_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaFilterTemplate_CreatedLocalTsMessage();
    public final MyMetaFilterTemplate_CreatedLocalDate CreatedLocalDate = new MyMetaFilterTemplate_CreatedLocalDate();
    public final MyMetaFilterTemplate_CreatedLocalTime CreatedLocalTime = new MyMetaFilterTemplate_CreatedLocalTime();
    public final MyMetaFilterTemplate_UpdatedLocalTs UpdatedLocalTs = new MyMetaFilterTemplate_UpdatedLocalTs();
    public final MyMetaFilterTemplate_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaFilterTemplate_UpdatedLocalTsMessage();
    public final MyMetaFilterTemplate_UpdatedLocalDate UpdatedLocalDate = new MyMetaFilterTemplate_UpdatedLocalDate();
    public final MyMetaFilterTemplate_UpdatedLocalTime UpdatedLocalTime = new MyMetaFilterTemplate_UpdatedLocalTime();
    public final MyMetaFilterTemplate_CreatedByFullName CreatedByFullName = new MyMetaFilterTemplate_CreatedByFullName();
    public final MyMetaFilterTemplate_ProjectName ProjectName = new MyMetaFilterTemplate_ProjectName();
    public final MyMetaFilterTemplate_UpdatedByFullName UpdatedByFullName = new MyMetaFilterTemplate_UpdatedByFullName();

    //##################################################
    //# associations
    //##################################################

    public final MyMetaFilterTemplate_CreatedBy CreatedBy = new MyMetaFilterTemplate_CreatedBy();
    public final MyMetaFilterTemplate_Project Project = new MyMetaFilterTemplate_Project();
    public final MyMetaFilterTemplate_UpdatedBy UpdatedBy = new MyMetaFilterTemplate_UpdatedBy();

    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaFilterTemplate_AuditLogTitle
        extends KmMetaStringProperty<MyFilterTemplate>
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
        public String getValueFor(MyFilterTemplate model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyFilterTemplate model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# ContextTypeCode
    //##################################################

    public class MyMetaFilterTemplate_ContextTypeCode
        extends KmMetaStringProperty<MyFilterTemplate>
        implements KmMetaDaoPropertyIF<MyFilterTemplate,String>
    {
        @Override
        public String getName()
        {
            return "contextTypeCode";
        }

        @Override
        public String getLabel()
        {
            return "Type";
        }

        @Override
        public String getHelp()
        {
            return "The type of list that this template is used for.";
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
            return MyFilterTemplateValidator.instance.getContextTypeCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "contextTypeCode";
        }

        @Override
        public MyFilterTemplateDao getDao()
        {
            return getAccess().getFilterTemplateDao();
        }

        public ScDynamicEnumDropdownField newDropdown()
        {
            ScDynamicEnumDropdownField e;
            e = new ScDynamicEnumDropdownField();
            e.setMeta(this);
            e.setEnumArraySupplier(MyFilterTemplateContextType::values);
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
        public String getValueFor(MyFilterTemplate model)
        {
            return model.getContextTypeCode();
        }

        @Override
        public void setValueFor(MyFilterTemplate model, String value)
        {
            model.setContextTypeCode(value);
        }

        @Override
        public boolean hasValueFor(MyFilterTemplate model, String value)
        {
            return model.hasContextTypeCode(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaFilterTemplate_CreatedUtcTs
        extends KmMetaTimestampProperty<MyFilterTemplate>
        implements KmMetaDaoPropertyIF<MyFilterTemplate,KmTimestamp>
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
            return MyFilterTemplateValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MyFilterTemplateDao getDao()
        {
            return getAccess().getFilterTemplateDao();
        }

        @Override
        public KmTimestamp getValueFor(MyFilterTemplate model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MyFilterTemplate model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyFilterTemplate model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# Deleted
    //##################################################

    public class MyMetaFilterTemplate_Deleted
        extends KmMetaBooleanProperty<MyFilterTemplate>
        implements KmMetaDaoPropertyIF<MyFilterTemplate,Boolean>
    {
        @Override
        public String getName()
        {
            return "deleted";
        }

        @Override
        public String getLabel()
        {
            return "Deleted";
        }

        @Override
        public String getHelp()
        {
            return "Indicates which a template that has been marked for deletion.";
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
            return MyFilterTemplateValidator.instance.getDeletedValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "deleted";
        }

        @Override
        public MyFilterTemplateDao getDao()
        {
            return getAccess().getFilterTemplateDao();
        }

        @Override
        public Boolean getValueFor(MyFilterTemplate model)
        {
            return model.getDeleted();
        }

        @Override
        public void setValueFor(MyFilterTemplate model, Boolean value)
        {
            model.setDeleted(value);
        }

        @Override
        public boolean hasValueFor(MyFilterTemplate model, Boolean value)
        {
            return model.hasDeleted(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaFilterTemplate_DomainSubtitle
        extends KmMetaStringProperty<MyFilterTemplate>
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
        public String getValueFor(MyFilterTemplate model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyFilterTemplate model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaFilterTemplate_DomainTitle
        extends KmMetaStringProperty<MyFilterTemplate>
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
        public String getValueFor(MyFilterTemplate model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyFilterTemplate model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# Modified
    //##################################################

    public class MyMetaFilterTemplate_Modified
        extends KmMetaBooleanProperty<MyFilterTemplate>
        implements KmMetaDaoPropertyIF<MyFilterTemplate,Boolean>
    {
        @Override
        public String getName()
        {
            return "modified";
        }

        @Override
        public String getLabel()
        {
            return "Modified";
        }

        @Override
        public String getHelp()
        {
            return "Indicates that this template is currently in a modified status.";
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
            return MyFilterTemplateValidator.instance.getModifiedValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "modified";
        }

        @Override
        public MyFilterTemplateDao getDao()
        {
            return getAccess().getFilterTemplateDao();
        }

        @Override
        public Boolean getValueFor(MyFilterTemplate model)
        {
            return model.getModified();
        }

        @Override
        public void setValueFor(MyFilterTemplate model, Boolean value)
        {
            model.setModified(value);
        }

        @Override
        public boolean hasValueFor(MyFilterTemplate model, Boolean value)
        {
            return model.hasModified(value);
        }
    }

    //##################################################
    //# Name
    //##################################################

    public class MyMetaFilterTemplate_Name
        extends KmMetaStringProperty<MyFilterTemplate>
        implements KmMetaDaoPropertyIF<MyFilterTemplate,String>
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
            return "The display name of this specific definition.";
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
            return MyFilterTemplateValidator.instance.getNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "name";
        }

        @Override
        public MyFilterTemplateDao getDao()
        {
            return getAccess().getFilterTemplateDao();
        }

        @Override
        public String getValueFor(MyFilterTemplate model)
        {
            return model.getName();
        }

        @Override
        public void setValueFor(MyFilterTemplate model, String value)
        {
            model.setName(value);
        }

        @Override
        public boolean hasValueFor(MyFilterTemplate model, String value)
        {
            return model.hasName(value);
        }
    }

    //##################################################
    //# Preferred
    //##################################################

    public class MyMetaFilterTemplate_Preferred
        extends KmMetaBooleanProperty<MyFilterTemplate>
        implements KmMetaDaoPropertyIF<MyFilterTemplate,Boolean>
    {
        @Override
        public String getName()
        {
            return "preferred";
        }

        @Override
        public String getLabel()
        {
            return "Preferred";
        }

        @Override
        public String getHelp()
        {
            return "Indicates which template should be used as the default.";
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
            return MyFilterTemplateValidator.instance.getPreferredValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "preferred";
        }

        @Override
        public MyFilterTemplateDao getDao()
        {
            return getAccess().getFilterTemplateDao();
        }

        @Override
        public Boolean getValueFor(MyFilterTemplate model)
        {
            return model.getPreferred();
        }

        @Override
        public void setValueFor(MyFilterTemplate model, Boolean value)
        {
            model.setPreferred(value);
        }

        @Override
        public boolean hasValueFor(MyFilterTemplate model, Boolean value)
        {
            return model.hasPreferred(value);
        }
    }

    //##################################################
    //# TypeCode
    //##################################################

    public class MyMetaFilterTemplate_TypeCode
        extends KmMetaStringProperty<MyFilterTemplate>
        implements KmMetaDaoPropertyIF<MyFilterTemplate,String>
    {
        @Override
        public String getName()
        {
            return "typeCode";
        }

        @Override
        public String getLabel()
        {
            return "Type";
        }

        @Override
        public String getHelp()
        {
            return "The type of template.\n\n predefined: The template is predefined by the application and cannot be changed.\n\n shared: A user-defined template that is shared with the entire project.";
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
            return MyFilterTemplateValidator.instance.getTypeCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "typeCode";
        }

        @Override
        public MyFilterTemplateDao getDao()
        {
            return getAccess().getFilterTemplateDao();
        }

        public ScDynamicEnumDropdownField newDropdown()
        {
            ScDynamicEnumDropdownField e;
            e = new ScDynamicEnumDropdownField();
            e.setMeta(this);
            e.setEnumArraySupplier(MyFilterTemplateType::values);
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
        public String getValueFor(MyFilterTemplate model)
        {
            return model.getTypeCode();
        }

        @Override
        public void setValueFor(MyFilterTemplate model, String value)
        {
            model.setTypeCode(value);
        }

        @Override
        public boolean hasValueFor(MyFilterTemplate model, String value)
        {
            return model.hasTypeCode(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaFilterTemplate_Uid
        extends KmMetaStringProperty<MyFilterTemplate>
        implements KmMetaDaoPropertyIF<MyFilterTemplate,String>
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
            return MyFilterTemplateValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyFilterTemplateDao getDao()
        {
            return getAccess().getFilterTemplateDao();
        }

        public KmDaoStringKeyCursor<MyFilterTemplate> createCursor()
        {
            KmDaoStringKeyCursor<MyFilterTemplate> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyFilterTemplate model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyFilterTemplate model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyFilterTemplate model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# UpdatedUtcTs
    //##################################################

    public class MyMetaFilterTemplate_UpdatedUtcTs
        extends KmMetaTimestampProperty<MyFilterTemplate>
        implements KmMetaDaoPropertyIF<MyFilterTemplate,KmTimestamp>
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
            return MyFilterTemplateValidator.instance.getUpdatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "updatedUtcTs";
        }

        @Override
        public MyFilterTemplateDao getDao()
        {
            return getAccess().getFilterTemplateDao();
        }

        @Override
        public KmTimestamp getValueFor(MyFilterTemplate model)
        {
            return model.getUpdatedUtcTs();
        }

        @Override
        public void setValueFor(MyFilterTemplate model, KmTimestamp value)
        {
            model.setUpdatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyFilterTemplate model, KmTimestamp value)
        {
            return model.hasUpdatedUtcTs(value);
        }
    }

    //##################################################
    //# LockVersion
    //##################################################

    public class MyMetaFilterTemplate_LockVersion
        extends KmMetaIntegerProperty<MyFilterTemplate>
        implements KmMetaDaoPropertyIF<MyFilterTemplate,Integer>
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
            return MyFilterTemplateValidator.instance.getLockVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lockVersion";
        }

        @Override
        public MyFilterTemplateDao getDao()
        {
            return getAccess().getFilterTemplateDao();
        }

        @Override
        public Integer getValueFor(MyFilterTemplate model)
        {
            return model.getLockVersion();
        }

        @Override
        public void setValueFor(MyFilterTemplate model, Integer value)
        {
            model.setLockVersion(value);
        }

        @Override
        public boolean hasValueFor(MyFilterTemplate model, Integer value)
        {
            return model.hasLockVersion(value);
        }
    }

    //##################################################
    //# ContextTypeName
    //##################################################

    public class MyMetaFilterTemplate_ContextTypeName
        extends KmMetaStringProperty<MyFilterTemplate>
    {
        @Override
        public String getName()
        {
            return "contextTypeName";
        }

        @Override
        public String getLabel()
        {
            return "Type";
        }

        @Override
        public String getHelp()
        {
            return "The type of list that this template is used for.";
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
        public String getValueFor(MyFilterTemplate model)
        {
            return model.getContextTypeName();
        }

        @Override
        public boolean hasValueFor(MyFilterTemplate model, String value)
        {
            return model.hasContextTypeName(value);
        }
    }

    //##################################################
    //# TypeName
    //##################################################

    public class MyMetaFilterTemplate_TypeName
        extends KmMetaStringProperty<MyFilterTemplate>
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
            return "The type of template.\n\n predefined: The template is predefined by the application and cannot be changed.\n\n shared: A user-defined template that is shared with the entire project.";
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
        public String getValueFor(MyFilterTemplate model)
        {
            return model.getTypeName();
        }

        @Override
        public boolean hasValueFor(MyFilterTemplate model, String value)
        {
            return model.hasTypeName(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaFilterTemplate_CreatedLocalTs
        extends KmMetaTimestampProperty<MyFilterTemplate>
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
        public KmTimestamp getValueFor(MyFilterTemplate model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyFilterTemplate model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaFilterTemplate_CreatedLocalTsMessage
        extends KmMetaStringProperty<MyFilterTemplate>
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
        public String getValueFor(MyFilterTemplate model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyFilterTemplate model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaFilterTemplate_CreatedLocalDate
        extends KmMetaDateProperty<MyFilterTemplate>
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
        public KmDate getValueFor(MyFilterTemplate model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyFilterTemplate model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaFilterTemplate_CreatedLocalTime
        extends KmMetaTimeProperty<MyFilterTemplate>
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
        public KmTime getValueFor(MyFilterTemplate model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyFilterTemplate model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }

    //##################################################
    //# UpdatedLocalTs
    //##################################################

    public class MyMetaFilterTemplate_UpdatedLocalTs
        extends KmMetaTimestampProperty<MyFilterTemplate>
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
        public KmTimestamp getValueFor(MyFilterTemplate model)
        {
            return model.getUpdatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyFilterTemplate model, KmTimestamp value)
        {
            return model.hasUpdatedLocalTs(value);
        }
    }

    //##################################################
    //# UpdatedLocalTsMessage
    //##################################################

    public class MyMetaFilterTemplate_UpdatedLocalTsMessage
        extends KmMetaStringProperty<MyFilterTemplate>
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
        public String getValueFor(MyFilterTemplate model)
        {
            return model.getUpdatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyFilterTemplate model, String value)
        {
            return model.hasUpdatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# UpdatedLocalDate
    //##################################################

    public class MyMetaFilterTemplate_UpdatedLocalDate
        extends KmMetaDateProperty<MyFilterTemplate>
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
        public KmDate getValueFor(MyFilterTemplate model)
        {
            return model.getUpdatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyFilterTemplate model, KmDate value)
        {
            return model.hasUpdatedLocalDate(value);
        }
    }

    //##################################################
    //# UpdatedLocalTime
    //##################################################

    public class MyMetaFilterTemplate_UpdatedLocalTime
        extends KmMetaTimeProperty<MyFilterTemplate>
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
        public KmTime getValueFor(MyFilterTemplate model)
        {
            return model.getUpdatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyFilterTemplate model, KmTime value)
        {
            return model.hasUpdatedLocalTime(value);
        }
    }

    //##################################################
    //# CreatedByFullName
    //##################################################

    public class MyMetaFilterTemplate_CreatedByFullName
        extends KmMetaStringProperty<MyFilterTemplate>
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
        public String getValueFor(MyFilterTemplate model)
        {
            return model.getCreatedByFullName();
        }

        @Override
        public void setValueFor(MyFilterTemplate model, String value)
        {
            model.setCreatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyFilterTemplate model, String value)
        {
            return model.hasCreatedByFullName(value);
        }
    }

    //##################################################
    //# ProjectName
    //##################################################

    public class MyMetaFilterTemplate_ProjectName
        extends KmMetaStringProperty<MyFilterTemplate>
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
        public String getValueFor(MyFilterTemplate model)
        {
            return model.getProjectName();
        }

        @Override
        public void setValueFor(MyFilterTemplate model, String value)
        {
            model.setProjectName(value);
        }

        @Override
        public boolean hasValueFor(MyFilterTemplate model, String value)
        {
            return model.hasProjectName(value);
        }
    }

    //##################################################
    //# UpdatedByFullName
    //##################################################

    public class MyMetaFilterTemplate_UpdatedByFullName
        extends KmMetaStringProperty<MyFilterTemplate>
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
        public String getValueFor(MyFilterTemplate model)
        {
            return model.getUpdatedByFullName();
        }

        @Override
        public void setValueFor(MyFilterTemplate model, String value)
        {
            model.setUpdatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyFilterTemplate model, String value)
        {
            return model.hasUpdatedByFullName(value);
        }
    }


    //##################################################
    //# CreatedBy
    //##################################################

    public class MyMetaFilterTemplate_CreatedBy
        extends KmMetaDaoAssociation<MyFilterTemplate,MyUser>
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
        public MyUser getValueFor(MyFilterTemplate model)
        {
            return model.getCreatedBy();
        }

        @Override
        public void setValueFor(MyFilterTemplate model, MyUser value)
        {
            model.setCreatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyFilterTemplate model, MyUser value)
        {
            return model.hasCreatedBy(value);
        }
    }

    //##################################################
    //# Project
    //##################################################

    public class MyMetaFilterTemplate_Project
        extends KmMetaDaoAssociation<MyFilterTemplate,MyProject>
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
            return "The project that defines this filter.";
        }

        @Override
        public boolean isRequired()
        {
            return true;
        }

        @Override
        public MyProject getValueFor(MyFilterTemplate model)
        {
            return model.getProject();
        }

        @Override
        public void setValueFor(MyFilterTemplate model, MyProject value)
        {
            model.setProject(value);
        }

        @Override
        public boolean hasValueFor(MyFilterTemplate model, MyProject value)
        {
            return model.hasProject(value);
        }
    }

    //##################################################
    //# UpdatedBy
    //##################################################

    public class MyMetaFilterTemplate_UpdatedBy
        extends KmMetaDaoAssociation<MyFilterTemplate,MyUser>
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
        public MyUser getValueFor(MyFilterTemplate model)
        {
            return model.getUpdatedBy();
        }

        @Override
        public void setValueFor(MyFilterTemplate model, MyUser value)
        {
            model.setUpdatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyFilterTemplate model, MyUser value)
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
