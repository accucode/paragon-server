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

public class MyMetaEmailTemplate
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaEmailTemplate instance = new MyMetaEmailTemplate();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaEmailTemplate()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "emailTemplate";
    }

    public MyEmailTemplateValidator getValidator()
    {
        return MyEmailTemplateValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "Email templates are used to automatically compose standard emails. Templates support basic formattings (e.g.: bold, italics) and allow for a number of predefined variables which are automatically substituted when the real email is subsequent created.\n Email templates can be defined for different domain subjects such as Job, or Visit; and the specific variables that are available vary depending on the subject.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaEmailTemplate_AuditLogTitle AuditLogTitle = new MyMetaEmailTemplate_AuditLogTitle();
    public final MyMetaEmailTemplate_BodyHtml BodyHtml = new MyMetaEmailTemplate_BodyHtml();
    public final MyMetaEmailTemplate_ContextTypeCode ContextTypeCode = new MyMetaEmailTemplate_ContextTypeCode();
    public final MyMetaEmailTemplate_CreatedUtcTs CreatedUtcTs = new MyMetaEmailTemplate_CreatedUtcTs();
    public final MyMetaEmailTemplate_DomainSubtitle DomainSubtitle = new MyMetaEmailTemplate_DomainSubtitle();
    public final MyMetaEmailTemplate_DomainTitle DomainTitle = new MyMetaEmailTemplate_DomainTitle();
    public final MyMetaEmailTemplate_Enabled Enabled = new MyMetaEmailTemplate_Enabled();
    public final MyMetaEmailTemplate_EnabledStatus EnabledStatus = new MyMetaEmailTemplate_EnabledStatus();
    public final MyMetaEmailTemplate_Name Name = new MyMetaEmailTemplate_Name();
    public final MyMetaEmailTemplate_SampleBodyHtml SampleBodyHtml = new MyMetaEmailTemplate_SampleBodyHtml();
    public final MyMetaEmailTemplate_SampleSubjectText SampleSubjectText = new MyMetaEmailTemplate_SampleSubjectText();
    public final MyMetaEmailTemplate_SubjectText SubjectText = new MyMetaEmailTemplate_SubjectText();
    public final MyMetaEmailTemplate_Uid Uid = new MyMetaEmailTemplate_Uid();
    public final MyMetaEmailTemplate_UpdatedUtcTs UpdatedUtcTs = new MyMetaEmailTemplate_UpdatedUtcTs();
    public final MyMetaEmailTemplate_LockVersion LockVersion = new MyMetaEmailTemplate_LockVersion();
    public final MyMetaEmailTemplate_ContextTypeName ContextTypeName = new MyMetaEmailTemplate_ContextTypeName();
    public final MyMetaEmailTemplate_CreatedLocalTs CreatedLocalTs = new MyMetaEmailTemplate_CreatedLocalTs();
    public final MyMetaEmailTemplate_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaEmailTemplate_CreatedLocalTsMessage();
    public final MyMetaEmailTemplate_CreatedLocalDate CreatedLocalDate = new MyMetaEmailTemplate_CreatedLocalDate();
    public final MyMetaEmailTemplate_CreatedLocalTime CreatedLocalTime = new MyMetaEmailTemplate_CreatedLocalTime();
    public final MyMetaEmailTemplate_UpdatedLocalTs UpdatedLocalTs = new MyMetaEmailTemplate_UpdatedLocalTs();
    public final MyMetaEmailTemplate_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaEmailTemplate_UpdatedLocalTsMessage();
    public final MyMetaEmailTemplate_UpdatedLocalDate UpdatedLocalDate = new MyMetaEmailTemplate_UpdatedLocalDate();
    public final MyMetaEmailTemplate_UpdatedLocalTime UpdatedLocalTime = new MyMetaEmailTemplate_UpdatedLocalTime();
    public final MyMetaEmailTemplate_CreatedByFullName CreatedByFullName = new MyMetaEmailTemplate_CreatedByFullName();
    public final MyMetaEmailTemplate_UpdatedByFullName UpdatedByFullName = new MyMetaEmailTemplate_UpdatedByFullName();

    //##################################################
    //# associations
    //##################################################

    public final MyMetaEmailTemplate_CreatedBy CreatedBy = new MyMetaEmailTemplate_CreatedBy();
    public final MyMetaEmailTemplate_Project Project = new MyMetaEmailTemplate_Project();
    public final MyMetaEmailTemplate_UpdatedBy UpdatedBy = new MyMetaEmailTemplate_UpdatedBy();

    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaEmailTemplate_AuditLogTitle
        extends KmMetaStringProperty<MyEmailTemplate>
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
        public String getValueFor(MyEmailTemplate model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyEmailTemplate model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# BodyHtml
    //##################################################

    public class MyMetaEmailTemplate_BodyHtml
        extends KmMetaStringProperty<MyEmailTemplate>
        implements KmMetaDaoPropertyIF<MyEmailTemplate,String>
    {
        @Override
        public String getName()
        {
            return "bodyHtml";
        }

        @Override
        public String getLabel()
        {
            return "Body";
        }

        @Override
        public String getHelp()
        {
            return "The html template for the body.  This supports basic html formattings such as bold and italics; and also supports a number of variable substitutions.";
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
            return MyEmailTemplateValidator.instance.getBodyHtmlValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "bodyHtml";
        }

        @Override
        public MyEmailTemplateDao getDao()
        {
            return getAccess().getEmailTemplateDao();
        }

        @Override
        public String getValueFor(MyEmailTemplate model)
        {
            return model.getBodyHtml();
        }

        @Override
        public void setValueFor(MyEmailTemplate model, String value)
        {
            model.setBodyHtml(value);
        }

        @Override
        public boolean hasValueFor(MyEmailTemplate model, String value)
        {
            return model.hasBodyHtml(value);
        }
    }

    //##################################################
    //# ContextTypeCode
    //##################################################

    public class MyMetaEmailTemplate_ContextTypeCode
        extends KmMetaStringProperty<MyEmailTemplate>
        implements KmMetaDaoPropertyIF<MyEmailTemplate,String>
    {
        @Override
        public String getName()
        {
            return "contextTypeCode";
        }

        @Override
        public String getLabel()
        {
            return "Context";
        }

        @Override
        public String getHelp()
        {
            return "The type of domain model used to generate emails from this template. E.g.: project or customer. The context type determines which macros are available.";
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
            return MyEmailTemplateValidator.instance.getContextTypeCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "contextTypeCode";
        }

        @Override
        public MyEmailTemplateDao getDao()
        {
            return getAccess().getEmailTemplateDao();
        }

        public ScDynamicEnumDropdownField newDropdown()
        {
            ScDynamicEnumDropdownField e;
            e = new ScDynamicEnumDropdownField();
            e.setMeta(this);
            e.setEnumArraySupplier(MyEmailTemplateContextType::values);
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
        public String getValueFor(MyEmailTemplate model)
        {
            return model.getContextTypeCode();
        }

        @Override
        public void setValueFor(MyEmailTemplate model, String value)
        {
            model.setContextTypeCode(value);
        }

        @Override
        public boolean hasValueFor(MyEmailTemplate model, String value)
        {
            return model.hasContextTypeCode(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaEmailTemplate_CreatedUtcTs
        extends KmMetaTimestampProperty<MyEmailTemplate>
        implements KmMetaDaoPropertyIF<MyEmailTemplate,KmTimestamp>
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
            return MyEmailTemplateValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MyEmailTemplateDao getDao()
        {
            return getAccess().getEmailTemplateDao();
        }

        @Override
        public KmTimestamp getValueFor(MyEmailTemplate model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MyEmailTemplate model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyEmailTemplate model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaEmailTemplate_DomainSubtitle
        extends KmMetaStringProperty<MyEmailTemplate>
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
        public String getValueFor(MyEmailTemplate model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyEmailTemplate model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaEmailTemplate_DomainTitle
        extends KmMetaStringProperty<MyEmailTemplate>
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
        public String getValueFor(MyEmailTemplate model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyEmailTemplate model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# Enabled
    //##################################################

    public class MyMetaEmailTemplate_Enabled
        extends KmMetaBooleanProperty<MyEmailTemplate>
        implements KmMetaDaoPropertyIF<MyEmailTemplate,Boolean>
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
            return MyEmailTemplateValidator.instance.getEnabledValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "enabled";
        }

        @Override
        public MyEmailTemplateDao getDao()
        {
            return getAccess().getEmailTemplateDao();
        }

        @Override
        public Boolean getValueFor(MyEmailTemplate model)
        {
            return model.getEnabled();
        }

        @Override
        public void setValueFor(MyEmailTemplate model, Boolean value)
        {
            model.setEnabled(value);
        }

        @Override
        public boolean hasValueFor(MyEmailTemplate model, Boolean value)
        {
            return model.hasEnabled(value);
        }
    }

    //##################################################
    //# EnabledStatus
    //##################################################

    public class MyMetaEmailTemplate_EnabledStatus
        extends KmMetaStringProperty<MyEmailTemplate>
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
        public String getValueFor(MyEmailTemplate model)
        {
            return model.getEnabledStatus();
        }

        @Override
        public boolean hasValueFor(MyEmailTemplate model, String value)
        {
            return model.hasEnabledStatus(value);
        }
    }

    //##################################################
    //# Name
    //##################################################

    public class MyMetaEmailTemplate_Name
        extends KmMetaStringProperty<MyEmailTemplate>
        implements KmMetaDaoPropertyIF<MyEmailTemplate,String>
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
            return "The display name used to identify this template within a project.";
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
            return MyEmailTemplateValidator.instance.getNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "name";
        }

        @Override
        public MyEmailTemplateDao getDao()
        {
            return getAccess().getEmailTemplateDao();
        }

        @Override
        public String getValueFor(MyEmailTemplate model)
        {
            return model.getName();
        }

        @Override
        public void setValueFor(MyEmailTemplate model, String value)
        {
            model.setName(value);
        }

        @Override
        public boolean hasValueFor(MyEmailTemplate model, String value)
        {
            return model.hasName(value);
        }
    }

    //##################################################
    //# SampleBodyHtml
    //##################################################

    public class MyMetaEmailTemplate_SampleBodyHtml
        extends KmMetaStringProperty<MyEmailTemplate>
    {
        @Override
        public String getName()
        {
            return "sampleBodyHtml";
        }

        @Override
        public String getLabel()
        {
            return "Sample Body";
        }

        @Override
        public String getHelp()
        {
            return "An example of the body html using default sample data.";
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
        public String getValueFor(MyEmailTemplate model)
        {
            return model.getSampleBodyHtml();
        }

        @Override
        public boolean hasValueFor(MyEmailTemplate model, String value)
        {
            return model.hasSampleBodyHtml(value);
        }
    }

    //##################################################
    //# SampleSubjectText
    //##################################################

    public class MyMetaEmailTemplate_SampleSubjectText
        extends KmMetaStringProperty<MyEmailTemplate>
    {
        @Override
        public String getName()
        {
            return "sampleSubjectText";
        }

        @Override
        public String getLabel()
        {
            return "Sample Subject";
        }

        @Override
        public String getHelp()
        {
            return "An example of the subject text using default sample data.";
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
        public String getValueFor(MyEmailTemplate model)
        {
            return model.getSampleSubjectText();
        }

        @Override
        public boolean hasValueFor(MyEmailTemplate model, String value)
        {
            return model.hasSampleSubjectText(value);
        }
    }

    //##################################################
    //# SubjectText
    //##################################################

    public class MyMetaEmailTemplate_SubjectText
        extends KmMetaStringProperty<MyEmailTemplate>
        implements KmMetaDaoPropertyIF<MyEmailTemplate,String>
    {
        @Override
        public String getName()
        {
            return "subjectText";
        }

        @Override
        public String getLabel()
        {
            return "Subject";
        }

        @Override
        public String getHelp()
        {
            return "The subject line of the email. This should be a short, single line of text. It supports same variables as the body, but does NOT allow formatting.";
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
            return MyEmailTemplateValidator.instance.getSubjectTextValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "subjectText";
        }

        @Override
        public MyEmailTemplateDao getDao()
        {
            return getAccess().getEmailTemplateDao();
        }

        @Override
        public String getValueFor(MyEmailTemplate model)
        {
            return model.getSubjectText();
        }

        @Override
        public void setValueFor(MyEmailTemplate model, String value)
        {
            model.setSubjectText(value);
        }

        @Override
        public boolean hasValueFor(MyEmailTemplate model, String value)
        {
            return model.hasSubjectText(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaEmailTemplate_Uid
        extends KmMetaStringProperty<MyEmailTemplate>
        implements KmMetaDaoPropertyIF<MyEmailTemplate,String>
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
            return MyEmailTemplateValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyEmailTemplateDao getDao()
        {
            return getAccess().getEmailTemplateDao();
        }

        public KmDaoStringKeyCursor<MyEmailTemplate> createCursor()
        {
            KmDaoStringKeyCursor<MyEmailTemplate> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyEmailTemplate model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyEmailTemplate model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyEmailTemplate model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# UpdatedUtcTs
    //##################################################

    public class MyMetaEmailTemplate_UpdatedUtcTs
        extends KmMetaTimestampProperty<MyEmailTemplate>
        implements KmMetaDaoPropertyIF<MyEmailTemplate,KmTimestamp>
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
            return MyEmailTemplateValidator.instance.getUpdatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "updatedUtcTs";
        }

        @Override
        public MyEmailTemplateDao getDao()
        {
            return getAccess().getEmailTemplateDao();
        }

        @Override
        public KmTimestamp getValueFor(MyEmailTemplate model)
        {
            return model.getUpdatedUtcTs();
        }

        @Override
        public void setValueFor(MyEmailTemplate model, KmTimestamp value)
        {
            model.setUpdatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyEmailTemplate model, KmTimestamp value)
        {
            return model.hasUpdatedUtcTs(value);
        }
    }

    //##################################################
    //# LockVersion
    //##################################################

    public class MyMetaEmailTemplate_LockVersion
        extends KmMetaIntegerProperty<MyEmailTemplate>
        implements KmMetaDaoPropertyIF<MyEmailTemplate,Integer>
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
            return MyEmailTemplateValidator.instance.getLockVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lockVersion";
        }

        @Override
        public MyEmailTemplateDao getDao()
        {
            return getAccess().getEmailTemplateDao();
        }

        @Override
        public Integer getValueFor(MyEmailTemplate model)
        {
            return model.getLockVersion();
        }

        @Override
        public void setValueFor(MyEmailTemplate model, Integer value)
        {
            model.setLockVersion(value);
        }

        @Override
        public boolean hasValueFor(MyEmailTemplate model, Integer value)
        {
            return model.hasLockVersion(value);
        }
    }

    //##################################################
    //# ContextTypeName
    //##################################################

    public class MyMetaEmailTemplate_ContextTypeName
        extends KmMetaStringProperty<MyEmailTemplate>
    {
        @Override
        public String getName()
        {
            return "contextTypeName";
        }

        @Override
        public String getLabel()
        {
            return "Context";
        }

        @Override
        public String getHelp()
        {
            return "The type of domain model used to generate emails from this template. E.g.: project or customer. The context type determines which macros are available.";
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
        public String getValueFor(MyEmailTemplate model)
        {
            return model.getContextTypeName();
        }

        @Override
        public boolean hasValueFor(MyEmailTemplate model, String value)
        {
            return model.hasContextTypeName(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaEmailTemplate_CreatedLocalTs
        extends KmMetaTimestampProperty<MyEmailTemplate>
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
        public KmTimestamp getValueFor(MyEmailTemplate model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyEmailTemplate model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaEmailTemplate_CreatedLocalTsMessage
        extends KmMetaStringProperty<MyEmailTemplate>
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
        public String getValueFor(MyEmailTemplate model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyEmailTemplate model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaEmailTemplate_CreatedLocalDate
        extends KmMetaDateProperty<MyEmailTemplate>
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
        public KmDate getValueFor(MyEmailTemplate model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyEmailTemplate model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaEmailTemplate_CreatedLocalTime
        extends KmMetaTimeProperty<MyEmailTemplate>
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
        public KmTime getValueFor(MyEmailTemplate model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyEmailTemplate model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }

    //##################################################
    //# UpdatedLocalTs
    //##################################################

    public class MyMetaEmailTemplate_UpdatedLocalTs
        extends KmMetaTimestampProperty<MyEmailTemplate>
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
        public KmTimestamp getValueFor(MyEmailTemplate model)
        {
            return model.getUpdatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyEmailTemplate model, KmTimestamp value)
        {
            return model.hasUpdatedLocalTs(value);
        }
    }

    //##################################################
    //# UpdatedLocalTsMessage
    //##################################################

    public class MyMetaEmailTemplate_UpdatedLocalTsMessage
        extends KmMetaStringProperty<MyEmailTemplate>
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
        public String getValueFor(MyEmailTemplate model)
        {
            return model.getUpdatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyEmailTemplate model, String value)
        {
            return model.hasUpdatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# UpdatedLocalDate
    //##################################################

    public class MyMetaEmailTemplate_UpdatedLocalDate
        extends KmMetaDateProperty<MyEmailTemplate>
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
        public KmDate getValueFor(MyEmailTemplate model)
        {
            return model.getUpdatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyEmailTemplate model, KmDate value)
        {
            return model.hasUpdatedLocalDate(value);
        }
    }

    //##################################################
    //# UpdatedLocalTime
    //##################################################

    public class MyMetaEmailTemplate_UpdatedLocalTime
        extends KmMetaTimeProperty<MyEmailTemplate>
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
        public KmTime getValueFor(MyEmailTemplate model)
        {
            return model.getUpdatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyEmailTemplate model, KmTime value)
        {
            return model.hasUpdatedLocalTime(value);
        }
    }

    //##################################################
    //# CreatedByFullName
    //##################################################

    public class MyMetaEmailTemplate_CreatedByFullName
        extends KmMetaStringProperty<MyEmailTemplate>
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
        public String getValueFor(MyEmailTemplate model)
        {
            return model.getCreatedByFullName();
        }

        @Override
        public void setValueFor(MyEmailTemplate model, String value)
        {
            model.setCreatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyEmailTemplate model, String value)
        {
            return model.hasCreatedByFullName(value);
        }
    }

    //##################################################
    //# UpdatedByFullName
    //##################################################

    public class MyMetaEmailTemplate_UpdatedByFullName
        extends KmMetaStringProperty<MyEmailTemplate>
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
        public String getValueFor(MyEmailTemplate model)
        {
            return model.getUpdatedByFullName();
        }

        @Override
        public void setValueFor(MyEmailTemplate model, String value)
        {
            model.setUpdatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyEmailTemplate model, String value)
        {
            return model.hasUpdatedByFullName(value);
        }
    }


    //##################################################
    //# CreatedBy
    //##################################################

    public class MyMetaEmailTemplate_CreatedBy
        extends KmMetaDaoAssociation<MyEmailTemplate,MyUser>
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
        public MyUser getValueFor(MyEmailTemplate model)
        {
            return model.getCreatedBy();
        }

        @Override
        public void setValueFor(MyEmailTemplate model, MyUser value)
        {
            model.setCreatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyEmailTemplate model, MyUser value)
        {
            return model.hasCreatedBy(value);
        }
    }

    //##################################################
    //# Project
    //##################################################

    public class MyMetaEmailTemplate_Project
        extends KmMetaDaoAssociation<MyEmailTemplate,MyProject>
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
            return "The project that contains this template.";
        }

        @Override
        public boolean isRequired()
        {
            return true;
        }

        @Override
        public MyProject getValueFor(MyEmailTemplate model)
        {
            return model.getProject();
        }

        @Override
        public void setValueFor(MyEmailTemplate model, MyProject value)
        {
            model.setProject(value);
        }

        @Override
        public boolean hasValueFor(MyEmailTemplate model, MyProject value)
        {
            return model.hasProject(value);
        }
    }

    //##################################################
    //# UpdatedBy
    //##################################################

    public class MyMetaEmailTemplate_UpdatedBy
        extends KmMetaDaoAssociation<MyEmailTemplate,MyUser>
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
        public MyUser getValueFor(MyEmailTemplate model)
        {
            return model.getUpdatedBy();
        }

        @Override
        public void setValueFor(MyEmailTemplate model, MyUser value)
        {
            model.setUpdatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyEmailTemplate model, MyUser value)
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
