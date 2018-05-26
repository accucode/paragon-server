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

public class MyMetaProject
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaProject instance = new MyMetaProject();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaProject()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "project";
    }

    public MyProjectValidator getValidator()
    {
        return MyProjectValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "Almost everything is managed within the context of a project. For example, each project manages its own list of customers and sites.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaProject_AuditLogTitle AuditLogTitle = new MyMetaProject_AuditLogTitle();
    public final MyMetaProject_AutoSiteNumberEnabled AutoSiteNumberEnabled = new MyMetaProject_AutoSiteNumberEnabled();
    public final MyMetaProject_AutoSiteNumberPadding AutoSiteNumberPadding = new MyMetaProject_AutoSiteNumberPadding();
    public final MyMetaProject_AutoSiteNumberPrefix AutoSiteNumberPrefix = new MyMetaProject_AutoSiteNumberPrefix();
    public final MyMetaProject_BusinessDays BusinessDays = new MyMetaProject_BusinessDays();
    public final MyMetaProject_BusinessEndTime BusinessEndTime = new MyMetaProject_BusinessEndTime();
    public final MyMetaProject_BusinessStartTime BusinessStartTime = new MyMetaProject_BusinessStartTime();
    public final MyMetaProject_Code Code = new MyMetaProject_Code();
    public final MyMetaProject_CompanyName CompanyName = new MyMetaProject_CompanyName();
    public final MyMetaProject_CreatedUtcTs CreatedUtcTs = new MyMetaProject_CreatedUtcTs();
    public final MyMetaProject_Description Description = new MyMetaProject_Description();
    public final MyMetaProject_DomainSubtitle DomainSubtitle = new MyMetaProject_DomainSubtitle();
    public final MyMetaProject_DomainTitle DomainTitle = new MyMetaProject_DomainTitle();
    public final MyMetaProject_Enabled Enabled = new MyMetaProject_Enabled();
    public final MyMetaProject_EnabledStatus EnabledStatus = new MyMetaProject_EnabledStatus();
    public final MyMetaProject_Name Name = new MyMetaProject_Name();
    public final MyMetaProject_NextAutoSiteNumber NextAutoSiteNumber = new MyMetaProject_NextAutoSiteNumber();
    public final MyMetaProject_SendEmailFrom SendEmailFrom = new MyMetaProject_SendEmailFrom();
    public final MyMetaProject_TimeZoneCode TimeZoneCode = new MyMetaProject_TimeZoneCode();
    public final MyMetaProject_TimeZoneName TimeZoneName = new MyMetaProject_TimeZoneName();
    public final MyMetaProject_Uid Uid = new MyMetaProject_Uid();
    public final MyMetaProject_UpdatedUtcTs UpdatedUtcTs = new MyMetaProject_UpdatedUtcTs();
    public final MyMetaProject_LockVersion LockVersion = new MyMetaProject_LockVersion();
    public final MyMetaProject_CreatedLocalTs CreatedLocalTs = new MyMetaProject_CreatedLocalTs();
    public final MyMetaProject_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaProject_CreatedLocalTsMessage();
    public final MyMetaProject_CreatedLocalDate CreatedLocalDate = new MyMetaProject_CreatedLocalDate();
    public final MyMetaProject_CreatedLocalTime CreatedLocalTime = new MyMetaProject_CreatedLocalTime();
    public final MyMetaProject_UpdatedLocalTs UpdatedLocalTs = new MyMetaProject_UpdatedLocalTs();
    public final MyMetaProject_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaProject_UpdatedLocalTsMessage();
    public final MyMetaProject_UpdatedLocalDate UpdatedLocalDate = new MyMetaProject_UpdatedLocalDate();
    public final MyMetaProject_UpdatedLocalTime UpdatedLocalTime = new MyMetaProject_UpdatedLocalTime();
    public final MyMetaProject_CreatedByFullName CreatedByFullName = new MyMetaProject_CreatedByFullName();
    public final MyMetaProject_DefaultPriorityName DefaultPriorityName = new MyMetaProject_DefaultPriorityName();
    public final MyMetaProject_SupervisorFullName SupervisorFullName = new MyMetaProject_SupervisorFullName();
    public final MyMetaProject_SupportContactFullName SupportContactFullName = new MyMetaProject_SupportContactFullName();
    public final MyMetaProject_SupportContactEmail SupportContactEmail = new MyMetaProject_SupportContactEmail();
    public final MyMetaProject_SupportContactPhone SupportContactPhone = new MyMetaProject_SupportContactPhone();
    public final MyMetaProject_TenantName TenantName = new MyMetaProject_TenantName();
    public final MyMetaProject_UpdatedByFullName UpdatedByFullName = new MyMetaProject_UpdatedByFullName();

    //##################################################
    //# associations
    //##################################################

    public final MyMetaProject_CreatedBy CreatedBy = new MyMetaProject_CreatedBy();
    public final MyMetaProject_DefaultPriority DefaultPriority = new MyMetaProject_DefaultPriority();
    public final MyMetaProject_Supervisor Supervisor = new MyMetaProject_Supervisor();
    public final MyMetaProject_SupportContact SupportContact = new MyMetaProject_SupportContact();
    public final MyMetaProject_Tenant Tenant = new MyMetaProject_Tenant();
    public final MyMetaProject_UpdatedBy UpdatedBy = new MyMetaProject_UpdatedBy();

    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaProject_AuditLogTitle
        extends KmMetaStringProperty<MyProject>
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
        public String getValueFor(MyProject model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyProject model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# AutoSiteNumberEnabled
    //##################################################

    public class MyMetaProject_AutoSiteNumberEnabled
        extends KmMetaBooleanProperty<MyProject>
        implements KmMetaDaoPropertyIF<MyProject,Boolean>
    {
        @Override
        public String getName()
        {
            return "autoSiteNumberEnabled";
        }

        @Override
        public String getLabel()
        {
            return "Auto Site Number Enabled";
        }

        @Override
        public String getHelp()
        {
            return "Determine if site numbers should be automatically generated. Site numbers are generated by combining the site number prefix with a padded numeric value. Although the generated numbers will generally start at 1 and increment, the number are not guaranteed to be contiguous. In other words, there may be gaps. E.g.: S001, S002, S004 (S003 was skipped).";
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
            return MyProjectValidator.instance.getAutoSiteNumberEnabledValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "autoSiteNumberEnabled";
        }

        @Override
        public MyProjectDao getDao()
        {
            return getAccess().getProjectDao();
        }

        @Override
        public Boolean getValueFor(MyProject model)
        {
            return model.getAutoSiteNumberEnabled();
        }

        @Override
        public void setValueFor(MyProject model, Boolean value)
        {
            model.setAutoSiteNumberEnabled(value);
        }

        @Override
        public boolean hasValueFor(MyProject model, Boolean value)
        {
            return model.hasAutoSiteNumberEnabled(value);
        }
    }

    //##################################################
    //# AutoSiteNumberPadding
    //##################################################

    public class MyMetaProject_AutoSiteNumberPadding
        extends KmMetaIntegerProperty<MyProject>
        implements KmMetaDaoPropertyIF<MyProject,Integer>
    {
        @Override
        public String getName()
        {
            return "autoSiteNumberPadding";
        }

        @Override
        public String getLabel()
        {
            return "Auto Site Number Padding";
        }

        @Override
        public String getHelp()
        {
            return "The number of digits to pad each number. For example, a value of 3 will generate numbers like 001, 002, 003.";
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
            return MyProjectValidator.instance.getAutoSiteNumberPaddingValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "autoSiteNumberPadding";
        }

        @Override
        public MyProjectDao getDao()
        {
            return getAccess().getProjectDao();
        }

        @Override
        public Integer getValueFor(MyProject model)
        {
            return model.getAutoSiteNumberPadding();
        }

        @Override
        public void setValueFor(MyProject model, Integer value)
        {
            model.setAutoSiteNumberPadding(value);
        }

        @Override
        public boolean hasValueFor(MyProject model, Integer value)
        {
            return model.hasAutoSiteNumberPadding(value);
        }
    }

    //##################################################
    //# AutoSiteNumberPrefix
    //##################################################

    public class MyMetaProject_AutoSiteNumberPrefix
        extends KmMetaStringProperty<MyProject>
        implements KmMetaDaoPropertyIF<MyProject,String>
    {
        @Override
        public String getName()
        {
            return "autoSiteNumberPrefix";
        }

        @Override
        public String getLabel()
        {
            return "Auto Site Number Prefix";
        }

        @Override
        public String getHelp()
        {
            return "The prefix to add at the beginning of auto-generated site numbers. Although not required, it is recommend to include a non-numeric prefix such as \"S\" in order to improve compatibility with external tools such as spreadsheets.";
        }

        @Override
        public int getColumnWidth()
        {
            return 5;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyProjectValidator.instance.getAutoSiteNumberPrefixValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "autoSiteNumberPrefix";
        }

        @Override
        public MyProjectDao getDao()
        {
            return getAccess().getProjectDao();
        }

        @Override
        public String getValueFor(MyProject model)
        {
            return model.getAutoSiteNumberPrefix();
        }

        @Override
        public void setValueFor(MyProject model, String value)
        {
            model.setAutoSiteNumberPrefix(value);
        }

        @Override
        public boolean hasValueFor(MyProject model, String value)
        {
            return model.hasAutoSiteNumberPrefix(value);
        }
    }

    //##################################################
    //# BusinessDays
    //##################################################

    public class MyMetaProject_BusinessDays
        extends KmMetaDayFrequencyProperty<MyProject>
        implements KmMetaDaoPropertyIF<MyProject,KmDayFrequency>
    {
        @Override
        public String getName()
        {
            return "businessDays";
        }

        @Override
        public String getLabel()
        {
            return "Business Days";
        }

        @Override
        public String getHelp()
        {
            return "The nominal business days (e.g.: Monday through Friday). This may be displayed to customers.";
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
        public KmDayFrequencyValidator getValidator()
        {
            return MyProjectValidator.instance.getBusinessDaysValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "businessDays";
        }

        @Override
        public MyProjectDao getDao()
        {
            return getAccess().getProjectDao();
        }

        @Override
        public KmDayFrequency getValueFor(MyProject model)
        {
            return model.getBusinessDays();
        }

        @Override
        public void setValueFor(MyProject model, KmDayFrequency value)
        {
            model.setBusinessDays(value);
        }

        @Override
        public boolean hasValueFor(MyProject model, KmDayFrequency value)
        {
            return model.hasBusinessDays(value);
        }
    }

    //##################################################
    //# BusinessEndTime
    //##################################################

    public class MyMetaProject_BusinessEndTime
        extends KmMetaTimeProperty<MyProject>
        implements KmMetaDaoPropertyIF<MyProject,KmTime>
    {
        @Override
        public String getName()
        {
            return "businessEndTime";
        }

        @Override
        public String getLabel()
        {
            return "Business End Time";
        }

        @Override
        public String getHelp()
        {
            return "The nominal end of business hours. This may be displayed to customers.";
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
        public KmTimeValidator getValidator()
        {
            return MyProjectValidator.instance.getBusinessEndTimeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "businessEndTime";
        }

        @Override
        public MyProjectDao getDao()
        {
            return getAccess().getProjectDao();
        }

        @Override
        public KmTime getValueFor(MyProject model)
        {
            return model.getBusinessEndTime();
        }

        @Override
        public void setValueFor(MyProject model, KmTime value)
        {
            model.setBusinessEndTime(value);
        }

        @Override
        public boolean hasValueFor(MyProject model, KmTime value)
        {
            return model.hasBusinessEndTime(value);
        }
    }

    //##################################################
    //# BusinessStartTime
    //##################################################

    public class MyMetaProject_BusinessStartTime
        extends KmMetaTimeProperty<MyProject>
        implements KmMetaDaoPropertyIF<MyProject,KmTime>
    {
        @Override
        public String getName()
        {
            return "businessStartTime";
        }

        @Override
        public String getLabel()
        {
            return "Business Start Time";
        }

        @Override
        public String getHelp()
        {
            return "The nominal start of business hours. This may be displayed to customers.";
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
        public KmTimeValidator getValidator()
        {
            return MyProjectValidator.instance.getBusinessStartTimeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "businessStartTime";
        }

        @Override
        public MyProjectDao getDao()
        {
            return getAccess().getProjectDao();
        }

        @Override
        public KmTime getValueFor(MyProject model)
        {
            return model.getBusinessStartTime();
        }

        @Override
        public void setValueFor(MyProject model, KmTime value)
        {
            model.setBusinessStartTime(value);
        }

        @Override
        public boolean hasValueFor(MyProject model, KmTime value)
        {
            return model.hasBusinessStartTime(value);
        }
    }

    //##################################################
    //# Code
    //##################################################

    public class MyMetaProject_Code
        extends KmMetaStringProperty<MyProject>
        implements KmMetaDaoPropertyIF<MyProject,String>
    {
        @Override
        public String getName()
        {
            return "code";
        }

        @Override
        public String getLabel()
        {
            return "Code";
        }

        @Override
        public String getHelp()
        {
            return "The unique code that identifies this project.";
        }

        @Override
        public int getColumnWidth()
        {
            return 5;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyProjectValidator.instance.getCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "code";
        }

        @Override
        public MyProjectDao getDao()
        {
            return getAccess().getProjectDao();
        }

        @Override
        public String getValueFor(MyProject model)
        {
            return model.getCode();
        }

        @Override
        public void setValueFor(MyProject model, String value)
        {
            model.setCode(value);
        }

        @Override
        public boolean hasValueFor(MyProject model, String value)
        {
            return model.hasCode(value);
        }
    }

    //##################################################
    //# CompanyName
    //##################################################

    public class MyMetaProject_CompanyName
        extends KmMetaStringProperty<MyProject>
        implements KmMetaDaoPropertyIF<MyProject,String>
    {
        @Override
        public String getName()
        {
            return "companyName";
        }

        @Override
        public String getLabel()
        {
            return "Company";
        }

        @Override
        public String getHelp()
        {
            return "The name of the company responsible for this project. This may be used on various documents such as emails and pick lists.";
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
            return MyProjectValidator.instance.getCompanyNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "companyName";
        }

        @Override
        public MyProjectDao getDao()
        {
            return getAccess().getProjectDao();
        }

        @Override
        public String getValueFor(MyProject model)
        {
            return model.getCompanyName();
        }

        @Override
        public void setValueFor(MyProject model, String value)
        {
            model.setCompanyName(value);
        }

        @Override
        public boolean hasValueFor(MyProject model, String value)
        {
            return model.hasCompanyName(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaProject_CreatedUtcTs
        extends KmMetaTimestampProperty<MyProject>
        implements KmMetaDaoPropertyIF<MyProject,KmTimestamp>
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
            return MyProjectValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MyProjectDao getDao()
        {
            return getAccess().getProjectDao();
        }

        @Override
        public KmTimestamp getValueFor(MyProject model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MyProject model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyProject model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# Description
    //##################################################

    public class MyMetaProject_Description
        extends KmMetaStringProperty<MyProject>
        implements KmMetaDaoPropertyIF<MyProject,String>
    {
        @Override
        public String getName()
        {
            return "description";
        }

        @Override
        public String getLabel()
        {
            return "Description";
        }

        @Override
        public String getHelp()
        {
            return "A short description of this project.";
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
            return MyProjectValidator.instance.getDescriptionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "description";
        }

        @Override
        public MyProjectDao getDao()
        {
            return getAccess().getProjectDao();
        }

        @Override
        public String getValueFor(MyProject model)
        {
            return model.getDescription();
        }

        @Override
        public void setValueFor(MyProject model, String value)
        {
            model.setDescription(value);
        }

        @Override
        public boolean hasValueFor(MyProject model, String value)
        {
            return model.hasDescription(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaProject_DomainSubtitle
        extends KmMetaStringProperty<MyProject>
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
        public String getValueFor(MyProject model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyProject model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaProject_DomainTitle
        extends KmMetaStringProperty<MyProject>
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
        public String getValueFor(MyProject model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyProject model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# Enabled
    //##################################################

    public class MyMetaProject_Enabled
        extends KmMetaBooleanProperty<MyProject>
        implements KmMetaDaoPropertyIF<MyProject,Boolean>
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
            return MyProjectValidator.instance.getEnabledValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "enabled";
        }

        @Override
        public MyProjectDao getDao()
        {
            return getAccess().getProjectDao();
        }

        @Override
        public Boolean getValueFor(MyProject model)
        {
            return model.getEnabled();
        }

        @Override
        public void setValueFor(MyProject model, Boolean value)
        {
            model.setEnabled(value);
        }

        @Override
        public boolean hasValueFor(MyProject model, Boolean value)
        {
            return model.hasEnabled(value);
        }
    }

    //##################################################
    //# EnabledStatus
    //##################################################

    public class MyMetaProject_EnabledStatus
        extends KmMetaStringProperty<MyProject>
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
        public String getValueFor(MyProject model)
        {
            return model.getEnabledStatus();
        }

        @Override
        public boolean hasValueFor(MyProject model, String value)
        {
            return model.hasEnabledStatus(value);
        }
    }

    //##################################################
    //# Name
    //##################################################

    public class MyMetaProject_Name
        extends KmMetaStringProperty<MyProject>
        implements KmMetaDaoPropertyIF<MyProject,String>
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
        public KmStringValidator getValidator()
        {
            return MyProjectValidator.instance.getNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "name";
        }

        @Override
        public MyProjectDao getDao()
        {
            return getAccess().getProjectDao();
        }

        @Override
        public String getValueFor(MyProject model)
        {
            return model.getName();
        }

        @Override
        public void setValueFor(MyProject model, String value)
        {
            model.setName(value);
        }

        @Override
        public boolean hasValueFor(MyProject model, String value)
        {
            return model.hasName(value);
        }
    }

    //##################################################
    //# NextAutoSiteNumber
    //##################################################

    public class MyMetaProject_NextAutoSiteNumber
        extends KmMetaIntegerProperty<MyProject>
        implements KmMetaDaoPropertyIF<MyProject,Integer>
    {
        @Override
        public String getName()
        {
            return "nextAutoSiteNumber";
        }

        @Override
        public String getLabel()
        {
            return "Next Auto Site Number";
        }

        @Override
        public String getHelp()
        {
            return "The next automatic site number to be assigned. The current prefix is added dynamically as needed.";
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
            return MyProjectValidator.instance.getNextAutoSiteNumberValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "nextAutoSiteNumber";
        }

        @Override
        public MyProjectDao getDao()
        {
            return getAccess().getProjectDao();
        }

        @Override
        public Integer getValueFor(MyProject model)
        {
            return model.getNextAutoSiteNumber();
        }

        @Override
        public void setValueFor(MyProject model, Integer value)
        {
            model.setNextAutoSiteNumber(value);
        }

        @Override
        public boolean hasValueFor(MyProject model, Integer value)
        {
            return model.hasNextAutoSiteNumber(value);
        }
    }

    //##################################################
    //# SendEmailFrom
    //##################################################

    public class MyMetaProject_SendEmailFrom
        extends KmMetaStringProperty<MyProject>
        implements KmMetaDaoPropertyIF<MyProject,String>
    {
        @Override
        public String getName()
        {
            return "sendEmailFrom";
        }

        @Override
        public String getLabel()
        {
            return "Send Email From";
        }

        @Override
        public String getHelp()
        {
            return "The email address that all project emails will be sent FROM.";
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
            return MyProjectValidator.instance.getSendEmailFromValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "sendEmailFrom";
        }

        @Override
        public MyProjectDao getDao()
        {
            return getAccess().getProjectDao();
        }

        @Override
        public String getValueFor(MyProject model)
        {
            return model.getSendEmailFrom();
        }

        @Override
        public void setValueFor(MyProject model, String value)
        {
            model.setSendEmailFrom(value);
        }

        @Override
        public boolean hasValueFor(MyProject model, String value)
        {
            return model.hasSendEmailFrom(value);
        }
    }

    //##################################################
    //# TimeZoneCode
    //##################################################

    public class MyMetaProject_TimeZoneCode
        extends KmMetaStringProperty<MyProject>
        implements KmMetaDaoPropertyIF<MyProject,String>
    {
        @Override
        public String getName()
        {
            return "timeZoneCode";
        }

        @Override
        public String getLabel()
        {
            return "Time Zone";
        }

        @Override
        public String getHelp()
        {
            return "The primary time zone associated with this project.";
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
            return MyProjectValidator.instance.getTimeZoneCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "timeZoneCode";
        }

        @Override
        public MyProjectDao getDao()
        {
            return getAccess().getProjectDao();
        }

        @Override
        public String getValueFor(MyProject model)
        {
            return model.getTimeZoneCode();
        }

        @Override
        public void setValueFor(MyProject model, String value)
        {
            model.setTimeZoneCode(value);
        }

        @Override
        public boolean hasValueFor(MyProject model, String value)
        {
            return model.hasTimeZoneCode(value);
        }
    }

    //##################################################
    //# TimeZoneName
    //##################################################

    public class MyMetaProject_TimeZoneName
        extends KmMetaStringProperty<MyProject>
    {
        @Override
        public String getName()
        {
            return "timeZoneName";
        }

        @Override
        public String getLabel()
        {
            return "Time Zone";
        }

        @Override
        public String getHelp()
        {
            return "The time zone associated with the depot's location.";
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
        public String getValueFor(MyProject model)
        {
            return model.getTimeZoneName();
        }

        @Override
        public boolean hasValueFor(MyProject model, String value)
        {
            return model.hasTimeZoneName(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaProject_Uid
        extends KmMetaStringProperty<MyProject>
        implements KmMetaDaoPropertyIF<MyProject,String>
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
            return MyProjectValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyProjectDao getDao()
        {
            return getAccess().getProjectDao();
        }

        public KmDaoStringKeyCursor<MyProject> createCursor()
        {
            KmDaoStringKeyCursor<MyProject> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyProject model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyProject model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyProject model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# UpdatedUtcTs
    //##################################################

    public class MyMetaProject_UpdatedUtcTs
        extends KmMetaTimestampProperty<MyProject>
        implements KmMetaDaoPropertyIF<MyProject,KmTimestamp>
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
            return MyProjectValidator.instance.getUpdatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "updatedUtcTs";
        }

        @Override
        public MyProjectDao getDao()
        {
            return getAccess().getProjectDao();
        }

        @Override
        public KmTimestamp getValueFor(MyProject model)
        {
            return model.getUpdatedUtcTs();
        }

        @Override
        public void setValueFor(MyProject model, KmTimestamp value)
        {
            model.setUpdatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyProject model, KmTimestamp value)
        {
            return model.hasUpdatedUtcTs(value);
        }
    }

    //##################################################
    //# LockVersion
    //##################################################

    public class MyMetaProject_LockVersion
        extends KmMetaIntegerProperty<MyProject>
        implements KmMetaDaoPropertyIF<MyProject,Integer>
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
            return MyProjectValidator.instance.getLockVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lockVersion";
        }

        @Override
        public MyProjectDao getDao()
        {
            return getAccess().getProjectDao();
        }

        @Override
        public Integer getValueFor(MyProject model)
        {
            return model.getLockVersion();
        }

        @Override
        public void setValueFor(MyProject model, Integer value)
        {
            model.setLockVersion(value);
        }

        @Override
        public boolean hasValueFor(MyProject model, Integer value)
        {
            return model.hasLockVersion(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaProject_CreatedLocalTs
        extends KmMetaTimestampProperty<MyProject>
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
        public KmTimestamp getValueFor(MyProject model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyProject model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaProject_CreatedLocalTsMessage
        extends KmMetaStringProperty<MyProject>
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
        public String getValueFor(MyProject model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyProject model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaProject_CreatedLocalDate
        extends KmMetaDateProperty<MyProject>
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
        public KmDate getValueFor(MyProject model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyProject model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaProject_CreatedLocalTime
        extends KmMetaTimeProperty<MyProject>
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
        public KmTime getValueFor(MyProject model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyProject model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }

    //##################################################
    //# UpdatedLocalTs
    //##################################################

    public class MyMetaProject_UpdatedLocalTs
        extends KmMetaTimestampProperty<MyProject>
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
        public KmTimestamp getValueFor(MyProject model)
        {
            return model.getUpdatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyProject model, KmTimestamp value)
        {
            return model.hasUpdatedLocalTs(value);
        }
    }

    //##################################################
    //# UpdatedLocalTsMessage
    //##################################################

    public class MyMetaProject_UpdatedLocalTsMessage
        extends KmMetaStringProperty<MyProject>
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
        public String getValueFor(MyProject model)
        {
            return model.getUpdatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyProject model, String value)
        {
            return model.hasUpdatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# UpdatedLocalDate
    //##################################################

    public class MyMetaProject_UpdatedLocalDate
        extends KmMetaDateProperty<MyProject>
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
        public KmDate getValueFor(MyProject model)
        {
            return model.getUpdatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyProject model, KmDate value)
        {
            return model.hasUpdatedLocalDate(value);
        }
    }

    //##################################################
    //# UpdatedLocalTime
    //##################################################

    public class MyMetaProject_UpdatedLocalTime
        extends KmMetaTimeProperty<MyProject>
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
        public KmTime getValueFor(MyProject model)
        {
            return model.getUpdatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyProject model, KmTime value)
        {
            return model.hasUpdatedLocalTime(value);
        }
    }

    //##################################################
    //# CreatedByFullName
    //##################################################

    public class MyMetaProject_CreatedByFullName
        extends KmMetaStringProperty<MyProject>
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
        public String getValueFor(MyProject model)
        {
            return model.getCreatedByFullName();
        }

        @Override
        public void setValueFor(MyProject model, String value)
        {
            model.setCreatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyProject model, String value)
        {
            return model.hasCreatedByFullName(value);
        }
    }

    //##################################################
    //# DefaultPriorityName
    //##################################################

    public class MyMetaProject_DefaultPriorityName
        extends KmMetaStringProperty<MyProject>
    {
        @Override
        public String getName()
        {
            return "defaultPriorityName";
        }

        @Override
        public String getLabel()
        {
            return "Default Priority Name";
        }

        @Override
        public String getHelp()
        {
            return "The name";
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
        public String getValueFor(MyProject model)
        {
            return model.getDefaultPriorityName();
        }

        @Override
        public void setValueFor(MyProject model, String value)
        {
            model.setDefaultPriorityName(value);
        }

        @Override
        public boolean hasValueFor(MyProject model, String value)
        {
            return model.hasDefaultPriorityName(value);
        }
    }

    //##################################################
    //# SupervisorFullName
    //##################################################

    public class MyMetaProject_SupervisorFullName
        extends KmMetaStringProperty<MyProject>
    {
        @Override
        public String getName()
        {
            return "supervisorFullName";
        }

        @Override
        public String getLabel()
        {
            return "Supervisor";
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
        public String getValueFor(MyProject model)
        {
            return model.getSupervisorFullName();
        }

        @Override
        public void setValueFor(MyProject model, String value)
        {
            model.setSupervisorFullName(value);
        }

        @Override
        public boolean hasValueFor(MyProject model, String value)
        {
            return model.hasSupervisorFullName(value);
        }
    }

    //##################################################
    //# SupportContactFullName
    //##################################################

    public class MyMetaProject_SupportContactFullName
        extends KmMetaStringProperty<MyProject>
    {
        @Override
        public String getName()
        {
            return "supportContactFullName";
        }

        @Override
        public String getLabel()
        {
            return "Support Contact";
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
        public String getValueFor(MyProject model)
        {
            return model.getSupportContactFullName();
        }

        @Override
        public void setValueFor(MyProject model, String value)
        {
            model.setSupportContactFullName(value);
        }

        @Override
        public boolean hasValueFor(MyProject model, String value)
        {
            return model.hasSupportContactFullName(value);
        }
    }

    //##################################################
    //# SupportContactEmail
    //##################################################

    public class MyMetaProject_SupportContactEmail
        extends KmMetaStringProperty<MyProject>
    {
        @Override
        public String getName()
        {
            return "supportContactEmail";
        }

        @Override
        public String getLabel()
        {
            return "Support Contact Email";
        }

        @Override
        public String getHelp()
        {
            return "The person's email address.  E.g.: john.doe@example.net.";
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
        public String getValueFor(MyProject model)
        {
            return model.getSupportContactEmail();
        }

        @Override
        public void setValueFor(MyProject model, String value)
        {
            model.setSupportContactEmail(value);
        }

        @Override
        public boolean hasValueFor(MyProject model, String value)
        {
            return model.hasSupportContactEmail(value);
        }
    }

    //##################################################
    //# SupportContactPhone
    //##################################################

    public class MyMetaProject_SupportContactPhone
        extends KmMetaStringProperty<MyProject>
    {
        @Override
        public String getName()
        {
            return "supportContactPhone";
        }

        @Override
        public String getLabel()
        {
            return "Support Contact Phone";
        }

        @Override
        public String getHelp()
        {
            return "The person's phone number.  E.g.: 303.555.1234.";
        }

        @Override
        public int getColumnWidth()
        {
            return 12;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public String getValueFor(MyProject model)
        {
            return model.getSupportContactPhone();
        }

        @Override
        public void setValueFor(MyProject model, String value)
        {
            model.setSupportContactPhone(value);
        }

        @Override
        public boolean hasValueFor(MyProject model, String value)
        {
            return model.hasSupportContactPhone(value);
        }
    }

    //##################################################
    //# TenantName
    //##################################################

    public class MyMetaProject_TenantName
        extends KmMetaStringProperty<MyProject>
    {
        @Override
        public String getName()
        {
            return "tenantName";
        }

        @Override
        public String getLabel()
        {
            return "Tenant Name";
        }

        @Override
        public String getHelp()
        {
            return "The short display name of this tenant.";
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
        public String getValueFor(MyProject model)
        {
            return model.getTenantName();
        }

        @Override
        public void setValueFor(MyProject model, String value)
        {
            model.setTenantName(value);
        }

        @Override
        public boolean hasValueFor(MyProject model, String value)
        {
            return model.hasTenantName(value);
        }
    }

    //##################################################
    //# UpdatedByFullName
    //##################################################

    public class MyMetaProject_UpdatedByFullName
        extends KmMetaStringProperty<MyProject>
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
        public String getValueFor(MyProject model)
        {
            return model.getUpdatedByFullName();
        }

        @Override
        public void setValueFor(MyProject model, String value)
        {
            model.setUpdatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyProject model, String value)
        {
            return model.hasUpdatedByFullName(value);
        }
    }


    //##################################################
    //# CreatedBy
    //##################################################

    public class MyMetaProject_CreatedBy
        extends KmMetaDaoAssociation<MyProject,MyUser>
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
        public MyUser getValueFor(MyProject model)
        {
            return model.getCreatedBy();
        }

        @Override
        public void setValueFor(MyProject model, MyUser value)
        {
            model.setCreatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyProject model, MyUser value)
        {
            return model.hasCreatedBy(value);
        }
    }

    //##################################################
    //# DefaultPriority
    //##################################################

    public class MyMetaProject_DefaultPriority
        extends KmMetaDaoAssociation<MyProject,MyPriority>
    {
        @Override
        public String getName()
        {
            return "defaultPriority";
        }

        @Override
        public String getLabel()
        {
            return "Default Priority";
        }

        @Override
        public String getHelp()
        {
            return "This is default priority for the project.";
        }

        @Override
        public boolean isRequired()
        {
            return true;
        }

        @Override
        public MyPriority getValueFor(MyProject model)
        {
            return model.getDefaultPriority();
        }

        @Override
        public void setValueFor(MyProject model, MyPriority value)
        {
            model.setDefaultPriority(value);
        }

        @Override
        public boolean hasValueFor(MyProject model, MyPriority value)
        {
            return model.hasDefaultPriority(value);
        }
    }

    //##################################################
    //# Supervisor
    //##################################################

    public class MyMetaProject_Supervisor
        extends KmMetaDaoAssociation<MyProject,MyUser>
    {
        @Override
        public String getName()
        {
            return "supervisor";
        }

        @Override
        public String getLabel()
        {
            return "Supervisor";
        }

        @Override
        public String getHelp()
        {
            return "The project's primary supervisor.";
        }

        @Override
        public boolean isRequired()
        {
            return true;
        }

        @Override
        public MyUser getValueFor(MyProject model)
        {
            return model.getSupervisor();
        }

        @Override
        public void setValueFor(MyProject model, MyUser value)
        {
            model.setSupervisor(value);
        }

        @Override
        public boolean hasValueFor(MyProject model, MyUser value)
        {
            return model.hasSupervisor(value);
        }
    }

    //##################################################
    //# SupportContact
    //##################################################

    public class MyMetaProject_SupportContact
        extends KmMetaDaoAssociation<MyProject,MyProjectContact>
    {
        @Override
        public String getName()
        {
            return "supportContact";
        }

        @Override
        public String getLabel()
        {
            return "Support Contact";
        }

        @Override
        public String getHelp()
        {
            return "The contact to be used for support notifications and as a general mailingl list.";
        }

        @Override
        public boolean isRequired()
        {
            return false;
        }

        @Override
        public MyProjectContact getValueFor(MyProject model)
        {
            return model.getSupportContact();
        }

        @Override
        public void setValueFor(MyProject model, MyProjectContact value)
        {
            model.setSupportContact(value);
        }

        @Override
        public boolean hasValueFor(MyProject model, MyProjectContact value)
        {
            return model.hasSupportContact(value);
        }
    }

    //##################################################
    //# Tenant
    //##################################################

    public class MyMetaProject_Tenant
        extends KmMetaDaoAssociation<MyProject,MyTenant>
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
            return "The tenant that owns this project.";
        }

        @Override
        public boolean isRequired()
        {
            return true;
        }

        @Override
        public MyTenant getValueFor(MyProject model)
        {
            return model.getTenant();
        }

        @Override
        public void setValueFor(MyProject model, MyTenant value)
        {
            model.setTenant(value);
        }

        @Override
        public boolean hasValueFor(MyProject model, MyTenant value)
        {
            return model.hasTenant(value);
        }
    }

    //##################################################
    //# UpdatedBy
    //##################################################

    public class MyMetaProject_UpdatedBy
        extends KmMetaDaoAssociation<MyProject,MyUser>
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
        public MyUser getValueFor(MyProject model)
        {
            return model.getUpdatedBy();
        }

        @Override
        public void setValueFor(MyProject model, MyUser value)
        {
            model.setUpdatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyProject model, MyUser value)
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
