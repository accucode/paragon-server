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

public class MyMetaTenant
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaTenant instance = new MyMetaTenant();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaTenant()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "tenant";
    }

    public MyTenantValidator getValidator()
    {
        return MyTenantValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "Each tenant identifies a segregated unit of business within the application. Each tenant has their own set of projects, customers, depots, etc. No information is shared between separate tenants.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaTenant_AuditLogTitle AuditLogTitle = new MyMetaTenant_AuditLogTitle();
    public final MyMetaTenant_BusinessDays BusinessDays = new MyMetaTenant_BusinessDays();
    public final MyMetaTenant_BusinessEndTime BusinessEndTime = new MyMetaTenant_BusinessEndTime();
    public final MyMetaTenant_BusinessStartTime BusinessStartTime = new MyMetaTenant_BusinessStartTime();
    public final MyMetaTenant_CreatedUtcTs CreatedUtcTs = new MyMetaTenant_CreatedUtcTs();
    public final MyMetaTenant_DomainSubtitle DomainSubtitle = new MyMetaTenant_DomainSubtitle();
    public final MyMetaTenant_DomainTitle DomainTitle = new MyMetaTenant_DomainTitle();
    public final MyMetaTenant_Hostname Hostname = new MyMetaTenant_Hostname();
    public final MyMetaTenant_Memo Memo = new MyMetaTenant_Memo();
    public final MyMetaTenant_Name Name = new MyMetaTenant_Name();
    public final MyMetaTenant_ThemeCode ThemeCode = new MyMetaTenant_ThemeCode();
    public final MyMetaTenant_ThemeName ThemeName = new MyMetaTenant_ThemeName();
    public final MyMetaTenant_TimeZoneCode TimeZoneCode = new MyMetaTenant_TimeZoneCode();
    public final MyMetaTenant_TimeZoneName TimeZoneName = new MyMetaTenant_TimeZoneName();
    public final MyMetaTenant_Uid Uid = new MyMetaTenant_Uid();
    public final MyMetaTenant_UpdatedUtcTs UpdatedUtcTs = new MyMetaTenant_UpdatedUtcTs();
    public final MyMetaTenant_LockVersion LockVersion = new MyMetaTenant_LockVersion();
    public final MyMetaTenant_CreatedLocalTs CreatedLocalTs = new MyMetaTenant_CreatedLocalTs();
    public final MyMetaTenant_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaTenant_CreatedLocalTsMessage();
    public final MyMetaTenant_CreatedLocalDate CreatedLocalDate = new MyMetaTenant_CreatedLocalDate();
    public final MyMetaTenant_CreatedLocalTime CreatedLocalTime = new MyMetaTenant_CreatedLocalTime();
    public final MyMetaTenant_UpdatedLocalTs UpdatedLocalTs = new MyMetaTenant_UpdatedLocalTs();
    public final MyMetaTenant_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaTenant_UpdatedLocalTsMessage();
    public final MyMetaTenant_UpdatedLocalDate UpdatedLocalDate = new MyMetaTenant_UpdatedLocalDate();
    public final MyMetaTenant_UpdatedLocalTime UpdatedLocalTime = new MyMetaTenant_UpdatedLocalTime();
    public final MyMetaTenant_CreatedByFullName CreatedByFullName = new MyMetaTenant_CreatedByFullName();
    public final MyMetaTenant_UpdatedByFullName UpdatedByFullName = new MyMetaTenant_UpdatedByFullName();

    //##################################################
    //# associations
    //##################################################

    public final MyMetaTenant_CreatedBy CreatedBy = new MyMetaTenant_CreatedBy();
    public final MyMetaTenant_UpdatedBy UpdatedBy = new MyMetaTenant_UpdatedBy();

    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaTenant_AuditLogTitle
        extends KmMetaStringProperty<MyTenant>
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
        public String getValueFor(MyTenant model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyTenant model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# BusinessDays
    //##################################################

    public class MyMetaTenant_BusinessDays
        extends KmMetaDayFrequencyProperty<MyTenant>
        implements KmMetaDaoPropertyIF<MyTenant,KmDayFrequency>
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
            return "The nominal business days (e.g.: Monday through Friday). This may be displayed to customers. This is the default for new projects and depots.";
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
            return MyTenantValidator.instance.getBusinessDaysValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "businessDays";
        }

        @Override
        public MyTenantDao getDao()
        {
            return getAccess().getTenantDao();
        }

        @Override
        public KmDayFrequency getValueFor(MyTenant model)
        {
            return model.getBusinessDays();
        }

        @Override
        public void setValueFor(MyTenant model, KmDayFrequency value)
        {
            model.setBusinessDays(value);
        }

        @Override
        public boolean hasValueFor(MyTenant model, KmDayFrequency value)
        {
            return model.hasBusinessDays(value);
        }
    }

    //##################################################
    //# BusinessEndTime
    //##################################################

    public class MyMetaTenant_BusinessEndTime
        extends KmMetaTimeProperty<MyTenant>
        implements KmMetaDaoPropertyIF<MyTenant,KmTime>
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
            return MyTenantValidator.instance.getBusinessEndTimeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "businessEndTime";
        }

        @Override
        public MyTenantDao getDao()
        {
            return getAccess().getTenantDao();
        }

        @Override
        public KmTime getValueFor(MyTenant model)
        {
            return model.getBusinessEndTime();
        }

        @Override
        public void setValueFor(MyTenant model, KmTime value)
        {
            model.setBusinessEndTime(value);
        }

        @Override
        public boolean hasValueFor(MyTenant model, KmTime value)
        {
            return model.hasBusinessEndTime(value);
        }
    }

    //##################################################
    //# BusinessStartTime
    //##################################################

    public class MyMetaTenant_BusinessStartTime
        extends KmMetaTimeProperty<MyTenant>
        implements KmMetaDaoPropertyIF<MyTenant,KmTime>
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
            return MyTenantValidator.instance.getBusinessStartTimeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "businessStartTime";
        }

        @Override
        public MyTenantDao getDao()
        {
            return getAccess().getTenantDao();
        }

        @Override
        public KmTime getValueFor(MyTenant model)
        {
            return model.getBusinessStartTime();
        }

        @Override
        public void setValueFor(MyTenant model, KmTime value)
        {
            model.setBusinessStartTime(value);
        }

        @Override
        public boolean hasValueFor(MyTenant model, KmTime value)
        {
            return model.hasBusinessStartTime(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaTenant_CreatedUtcTs
        extends KmMetaTimestampProperty<MyTenant>
        implements KmMetaDaoPropertyIF<MyTenant,KmTimestamp>
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
            return MyTenantValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MyTenantDao getDao()
        {
            return getAccess().getTenantDao();
        }

        @Override
        public KmTimestamp getValueFor(MyTenant model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MyTenant model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyTenant model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaTenant_DomainSubtitle
        extends KmMetaStringProperty<MyTenant>
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
        public String getValueFor(MyTenant model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyTenant model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaTenant_DomainTitle
        extends KmMetaStringProperty<MyTenant>
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
        public String getValueFor(MyTenant model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyTenant model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# Hostname
    //##################################################

    public class MyMetaTenant_Hostname
        extends KmMetaStringProperty<MyTenant>
        implements KmMetaDaoPropertyIF<MyTenant,String>
    {
        @Override
        public String getName()
        {
            return "hostname";
        }

        @Override
        public String getLabel()
        {
            return "Hostname";
        }

        @Override
        public String getHelp()
        {
            return "The url hostname used to identify the tenant.";
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
            return MyTenantValidator.instance.getHostnameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "hostname";
        }

        @Override
        public MyTenantDao getDao()
        {
            return getAccess().getTenantDao();
        }

        @Override
        public String getValueFor(MyTenant model)
        {
            return model.getHostname();
        }

        @Override
        public void setValueFor(MyTenant model, String value)
        {
            model.setHostname(value);
        }

        @Override
        public boolean hasValueFor(MyTenant model, String value)
        {
            return model.hasHostname(value);
        }
    }

    //##################################################
    //# Memo
    //##################################################

    public class MyMetaTenant_Memo
        extends KmMetaStringProperty<MyTenant>
        implements KmMetaDaoPropertyIF<MyTenant,String>
    {
        @Override
        public String getName()
        {
            return "memo";
        }

        @Override
        public String getLabel()
        {
            return "Memo";
        }

        @Override
        public String getHelp()
        {
            return "Any brief, free-form notes, about this tenant.";
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
            return MyTenantValidator.instance.getMemoValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "memo";
        }

        @Override
        public MyTenantDao getDao()
        {
            return getAccess().getTenantDao();
        }

        @Override
        public String getValueFor(MyTenant model)
        {
            return model.getMemo();
        }

        @Override
        public void setValueFor(MyTenant model, String value)
        {
            model.setMemo(value);
        }

        @Override
        public boolean hasValueFor(MyTenant model, String value)
        {
            return model.hasMemo(value);
        }
    }

    //##################################################
    //# Name
    //##################################################

    public class MyMetaTenant_Name
        extends KmMetaStringProperty<MyTenant>
        implements KmMetaDaoPropertyIF<MyTenant,String>
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
        public KmStringValidator getValidator()
        {
            return MyTenantValidator.instance.getNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "name";
        }

        @Override
        public MyTenantDao getDao()
        {
            return getAccess().getTenantDao();
        }

        @Override
        public String getValueFor(MyTenant model)
        {
            return model.getName();
        }

        @Override
        public void setValueFor(MyTenant model, String value)
        {
            model.setName(value);
        }

        @Override
        public boolean hasValueFor(MyTenant model, String value)
        {
            return model.hasName(value);
        }
    }

    //##################################################
    //# ThemeCode
    //##################################################

    public class MyMetaTenant_ThemeCode
        extends KmMetaStringProperty<MyTenant>
        implements KmMetaDaoPropertyIF<MyTenant,String>
    {
        @Override
        public String getName()
        {
            return "themeCode";
        }

        @Override
        public String getLabel()
        {
            return "Theme Code";
        }

        @Override
        public String getHelp()
        {
            return "Identify the theme.";
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
            return MyTenantValidator.instance.getThemeCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "themeCode";
        }

        @Override
        public MyTenantDao getDao()
        {
            return getAccess().getTenantDao();
        }

        @Override
        public String getValueFor(MyTenant model)
        {
            return model.getThemeCode();
        }

        @Override
        public void setValueFor(MyTenant model, String value)
        {
            model.setThemeCode(value);
        }

        @Override
        public boolean hasValueFor(MyTenant model, String value)
        {
            return model.hasThemeCode(value);
        }
    }

    //##################################################
    //# ThemeName
    //##################################################

    public class MyMetaTenant_ThemeName
        extends KmMetaStringProperty<MyTenant>
    {
        @Override
        public String getName()
        {
            return "themeName";
        }

        @Override
        public String getLabel()
        {
            return "Theme";
        }

        @Override
        public String getHelp()
        {
            return "The display name of the current theme.";
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
        public String getValueFor(MyTenant model)
        {
            return model.getThemeName();
        }

        @Override
        public boolean hasValueFor(MyTenant model, String value)
        {
            return model.hasThemeName(value);
        }
    }

    //##################################################
    //# TimeZoneCode
    //##################################################

    public class MyMetaTenant_TimeZoneCode
        extends KmMetaStringProperty<MyTenant>
        implements KmMetaDaoPropertyIF<MyTenant,String>
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
            return "The time zone is used in conjuction with the business hours and other configuration options. This is the default used for new projects and depots.";
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
            return MyTenantValidator.instance.getTimeZoneCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "timeZoneCode";
        }

        @Override
        public MyTenantDao getDao()
        {
            return getAccess().getTenantDao();
        }

        @Override
        public String getValueFor(MyTenant model)
        {
            return model.getTimeZoneCode();
        }

        @Override
        public void setValueFor(MyTenant model, String value)
        {
            model.setTimeZoneCode(value);
        }

        @Override
        public boolean hasValueFor(MyTenant model, String value)
        {
            return model.hasTimeZoneCode(value);
        }
    }

    //##################################################
    //# TimeZoneName
    //##################################################

    public class MyMetaTenant_TimeZoneName
        extends KmMetaStringProperty<MyTenant>
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
            return "The default used for new projects and depots.";
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
        public String getValueFor(MyTenant model)
        {
            return model.getTimeZoneName();
        }

        @Override
        public boolean hasValueFor(MyTenant model, String value)
        {
            return model.hasTimeZoneName(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaTenant_Uid
        extends KmMetaStringProperty<MyTenant>
        implements KmMetaDaoPropertyIF<MyTenant,String>
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
            return MyTenantValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyTenantDao getDao()
        {
            return getAccess().getTenantDao();
        }

        public KmDaoStringKeyCursor<MyTenant> createCursor()
        {
            KmDaoStringKeyCursor<MyTenant> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyTenant model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyTenant model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyTenant model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# UpdatedUtcTs
    //##################################################

    public class MyMetaTenant_UpdatedUtcTs
        extends KmMetaTimestampProperty<MyTenant>
        implements KmMetaDaoPropertyIF<MyTenant,KmTimestamp>
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
            return MyTenantValidator.instance.getUpdatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "updatedUtcTs";
        }

        @Override
        public MyTenantDao getDao()
        {
            return getAccess().getTenantDao();
        }

        @Override
        public KmTimestamp getValueFor(MyTenant model)
        {
            return model.getUpdatedUtcTs();
        }

        @Override
        public void setValueFor(MyTenant model, KmTimestamp value)
        {
            model.setUpdatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyTenant model, KmTimestamp value)
        {
            return model.hasUpdatedUtcTs(value);
        }
    }

    //##################################################
    //# LockVersion
    //##################################################

    public class MyMetaTenant_LockVersion
        extends KmMetaIntegerProperty<MyTenant>
        implements KmMetaDaoPropertyIF<MyTenant,Integer>
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
            return MyTenantValidator.instance.getLockVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lockVersion";
        }

        @Override
        public MyTenantDao getDao()
        {
            return getAccess().getTenantDao();
        }

        @Override
        public Integer getValueFor(MyTenant model)
        {
            return model.getLockVersion();
        }

        @Override
        public void setValueFor(MyTenant model, Integer value)
        {
            model.setLockVersion(value);
        }

        @Override
        public boolean hasValueFor(MyTenant model, Integer value)
        {
            return model.hasLockVersion(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaTenant_CreatedLocalTs
        extends KmMetaTimestampProperty<MyTenant>
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
        public KmTimestamp getValueFor(MyTenant model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyTenant model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaTenant_CreatedLocalTsMessage
        extends KmMetaStringProperty<MyTenant>
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
        public String getValueFor(MyTenant model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyTenant model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaTenant_CreatedLocalDate
        extends KmMetaDateProperty<MyTenant>
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
        public KmDate getValueFor(MyTenant model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyTenant model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaTenant_CreatedLocalTime
        extends KmMetaTimeProperty<MyTenant>
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
        public KmTime getValueFor(MyTenant model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyTenant model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }

    //##################################################
    //# UpdatedLocalTs
    //##################################################

    public class MyMetaTenant_UpdatedLocalTs
        extends KmMetaTimestampProperty<MyTenant>
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
        public KmTimestamp getValueFor(MyTenant model)
        {
            return model.getUpdatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyTenant model, KmTimestamp value)
        {
            return model.hasUpdatedLocalTs(value);
        }
    }

    //##################################################
    //# UpdatedLocalTsMessage
    //##################################################

    public class MyMetaTenant_UpdatedLocalTsMessage
        extends KmMetaStringProperty<MyTenant>
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
        public String getValueFor(MyTenant model)
        {
            return model.getUpdatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyTenant model, String value)
        {
            return model.hasUpdatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# UpdatedLocalDate
    //##################################################

    public class MyMetaTenant_UpdatedLocalDate
        extends KmMetaDateProperty<MyTenant>
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
        public KmDate getValueFor(MyTenant model)
        {
            return model.getUpdatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyTenant model, KmDate value)
        {
            return model.hasUpdatedLocalDate(value);
        }
    }

    //##################################################
    //# UpdatedLocalTime
    //##################################################

    public class MyMetaTenant_UpdatedLocalTime
        extends KmMetaTimeProperty<MyTenant>
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
        public KmTime getValueFor(MyTenant model)
        {
            return model.getUpdatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyTenant model, KmTime value)
        {
            return model.hasUpdatedLocalTime(value);
        }
    }

    //##################################################
    //# CreatedByFullName
    //##################################################

    public class MyMetaTenant_CreatedByFullName
        extends KmMetaStringProperty<MyTenant>
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
        public String getValueFor(MyTenant model)
        {
            return model.getCreatedByFullName();
        }

        @Override
        public void setValueFor(MyTenant model, String value)
        {
            model.setCreatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyTenant model, String value)
        {
            return model.hasCreatedByFullName(value);
        }
    }

    //##################################################
    //# UpdatedByFullName
    //##################################################

    public class MyMetaTenant_UpdatedByFullName
        extends KmMetaStringProperty<MyTenant>
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
        public String getValueFor(MyTenant model)
        {
            return model.getUpdatedByFullName();
        }

        @Override
        public void setValueFor(MyTenant model, String value)
        {
            model.setUpdatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyTenant model, String value)
        {
            return model.hasUpdatedByFullName(value);
        }
    }


    //##################################################
    //# CreatedBy
    //##################################################

    public class MyMetaTenant_CreatedBy
        extends KmMetaDaoAssociation<MyTenant,MyUser>
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
        public MyUser getValueFor(MyTenant model)
        {
            return model.getCreatedBy();
        }

        @Override
        public void setValueFor(MyTenant model, MyUser value)
        {
            model.setCreatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyTenant model, MyUser value)
        {
            return model.hasCreatedBy(value);
        }
    }

    //##################################################
    //# UpdatedBy
    //##################################################

    public class MyMetaTenant_UpdatedBy
        extends KmMetaDaoAssociation<MyTenant,MyUser>
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
        public MyUser getValueFor(MyTenant model)
        {
            return model.getUpdatedBy();
        }

        @Override
        public void setValueFor(MyTenant model, MyUser value)
        {
            model.setUpdatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyTenant model, MyUser value)
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
