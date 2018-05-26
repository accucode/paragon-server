//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import java.util.*;

import com.kodemore.collection.*;
import com.kodemore.domain.*;
import com.kodemore.exception.*;
import com.kodemore.servlet.encoder.*;
import com.kodemore.servlet.utility.*;
import com.kodemore.time.*;
import com.kodemore.types.*;
import com.kodemore.utility.*;

import com.app.finder.*;
import com.app.model.*;
import com.app.model.core.*;
import com.app.model.meta.*;
import com.app.model.support.*;
import com.app.ui.dashboard.core.*;
import com.app.utility.*;

@SuppressWarnings("all")
public abstract class MyProjectBase
    extends MyAbstractDaoDomain<MyProject>
    implements KmUidDomainIF
    ,MyBasicTimestampsIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaProject Meta = MyMetaProject.instance;
    public static final MyProjectTools Tools = MyProjectTools.instance;
    public static final MyProjectValidator Validator = MyProjectValidator.instance;
    public static final MyProjectFinder Finder = MyProjectFinder.instance;

    //##################################################
    //# variables
    //##################################################

    private Boolean autoSiteNumberEnabled;
    private Integer autoSiteNumberPadding;
    private String autoSiteNumberPrefix;
    private KmDayFrequency businessDays;
    private KmTime businessEndTime;
    private KmTime businessStartTime;
    private String code;
    private String companyName;
    private KmTimestamp createdUtcTs;
    private String description;
    private Boolean enabled;
    private String name;
    private Integer nextAutoSiteNumber;
    private String sendEmailFrom;
    private String timeZoneCode;
    private String uid;
    private KmTimestamp updatedUtcTs;
    private Integer lockVersion;
    private MyUser createdBy;
    private MyPriority defaultPriority;
    private MyUser supervisor;
    private MyProjectContact supportContact;
    private MyTenant tenant;
    private MyUser updatedBy;
    private List<MyBlurb> blurbs;
    private List<MyProjectContact> contacts;
    private List<MyCustomer> customers;
    private List<MyEmailTemplate> emailTemplates;
    private List<MyHoliday> holidays;
    private List<MyMember> members;
    private List<MyVendor> vendors;

    //##################################################
    //# constructor
    //##################################################

    public MyProjectBase()
    {
        super();
        setAutoSiteNumberEnabled(false);
        setAutoSiteNumberPadding(3);
        setAutoSiteNumberPrefix("S");
        setCreatedUtcTs(nowUtc());
        setEnabled(true);
        setNextAutoSiteNumber(1);
        setUid(newUid());
        setUpdatedUtcTs(nowUtc());
        setLockVersion(0);
        setCreatedBy(MyGlobals.getCurrentUser());
        setUpdatedBy(MyGlobals.getCurrentUser());
        blurbs = new ArrayList<>();
        contacts = new ArrayList<>();
        customers = new ArrayList<>();
        emailTemplates = new ArrayList<>();
        holidays = new ArrayList<>();
        members = new ArrayList<>();
        vendors = new ArrayList<>();
    }

    //##################################################
    //# field (auditLogTitle)
    //##################################################

    public abstract String getAuditLogTitle();

    public boolean hasAuditLogTitle()
    {
        return Kmu.hasValue(getAuditLogTitle());
    }

    public boolean hasAuditLogTitle(String e)
    {
        return Kmu.isEqualIgnoreCase(getAuditLogTitle(), e);
    }

    //##################################################
    //# field (autoSiteNumberEnabled)
    //##################################################

    public Boolean getAutoSiteNumberEnabled()
    {
        return autoSiteNumberEnabled;
    }

    public void setAutoSiteNumberEnabled(Boolean e)
    {
        e = Validator.getAutoSiteNumberEnabledValidator().convert(e);
        autoSiteNumberEnabled = e;
    }

    public void clearAutoSiteNumberEnabled()
    {
        setAutoSiteNumberEnabled(null);
    }

    public boolean hasAutoSiteNumberEnabled()
    {
        return getAutoSiteNumberEnabled() != null;
    }

    public boolean hasAutoSiteNumberEnabled(Boolean e)
    {
        return Kmu.isEqual(getAutoSiteNumberEnabled(), e);
    }

    public boolean isAutoSiteNumberEnabled()
    {
        if ( getAutoSiteNumberEnabled() == null )
            return false;
        return getAutoSiteNumberEnabled();
    }

    public boolean isAutoSiteNumberEnabled(Boolean b)
    {
        return Kmu.isEqual(getAutoSiteNumberEnabled(), b);
    }

    public void toggleAutoSiteNumberEnabled()
    {
        setAutoSiteNumberEnabled(!getAutoSiteNumberEnabled());
    }

    //##################################################
    //# field (autoSiteNumberPadding)
    //##################################################

    public Integer getAutoSiteNumberPadding()
    {
        return autoSiteNumberPadding;
    }

    public void setAutoSiteNumberPadding(Integer e)
    {
        e = Validator.getAutoSiteNumberPaddingValidator().convert(e);
        autoSiteNumberPadding = e;
    }

    public void clearAutoSiteNumberPadding()
    {
        setAutoSiteNumberPadding(null);
    }

    public boolean hasAutoSiteNumberPadding()
    {
        return getAutoSiteNumberPadding() != null;
    }

    public boolean hasAutoSiteNumberPadding(Integer e)
    {
        return Kmu.isEqual(getAutoSiteNumberPadding(), e);
    }

    //##################################################
    //# field (autoSiteNumberPrefix)
    //##################################################

    public String getAutoSiteNumberPrefix()
    {
        return autoSiteNumberPrefix;
    }

    public void setAutoSiteNumberPrefix(String e)
    {
        e = Validator.getAutoSiteNumberPrefixValidator().convert(e);
        autoSiteNumberPrefix = e;
    }

    public void clearAutoSiteNumberPrefix()
    {
        setAutoSiteNumberPrefix(null);
    }

    public boolean hasAutoSiteNumberPrefix()
    {
        return Kmu.hasValue(getAutoSiteNumberPrefix());
    }

    public boolean hasAutoSiteNumberPrefix(String e)
    {
        return Kmu.isEqualIgnoreCase(getAutoSiteNumberPrefix(), e);
    }

    public void truncateAutoSiteNumberPrefix()
    {
        truncateAutoSiteNumberPrefix(false);
    }

    public void truncateAutoSiteNumberPrefix(boolean ellipses)
    {
        autoSiteNumberPrefix = Kmu.truncate(autoSiteNumberPrefix, 5, ellipses);
    }

    //##################################################
    //# field (businessDays)
    //##################################################

    public KmDayFrequency getBusinessDays()
    {
        return businessDays;
    }

    public void setBusinessDays(KmDayFrequency e)
    {
        e = Validator.getBusinessDaysValidator().convert(e);
        businessDays = e;
    }

    public void clearBusinessDays()
    {
        setBusinessDays(null);
    }

    public boolean hasBusinessDays()
    {
        return getBusinessDays() != null;
    }

    public boolean hasBusinessDays(KmDayFrequency e)
    {
        return Kmu.isEqual(getBusinessDays(), e);
    }

    //##################################################
    //# field (businessEndTime)
    //##################################################

    public KmTime getBusinessEndTime()
    {
        return businessEndTime;
    }

    public void setBusinessEndTime(KmTime e)
    {
        e = Validator.getBusinessEndTimeValidator().convert(e);
        businessEndTime = e;
    }

    public void clearBusinessEndTime()
    {
        setBusinessEndTime(null);
    }

    public boolean hasBusinessEndTime()
    {
        return getBusinessEndTime() != null;
    }

    public boolean hasBusinessEndTime(KmTime e)
    {
        return Kmu.isEqual(getBusinessEndTime(), e);
    }

    //##################################################
    //# field (businessStartTime)
    //##################################################

    public KmTime getBusinessStartTime()
    {
        return businessStartTime;
    }

    public void setBusinessStartTime(KmTime e)
    {
        e = Validator.getBusinessStartTimeValidator().convert(e);
        businessStartTime = e;
    }

    public void clearBusinessStartTime()
    {
        setBusinessStartTime(null);
    }

    public boolean hasBusinessStartTime()
    {
        return getBusinessStartTime() != null;
    }

    public boolean hasBusinessStartTime(KmTime e)
    {
        return Kmu.isEqual(getBusinessStartTime(), e);
    }

    //##################################################
    //# field (code)
    //##################################################

    public String getCode()
    {
        return code;
    }

    public void setCode(String e)
    {
        e = Validator.getCodeValidator().convert(e);
        code = e;
    }

    public void clearCode()
    {
        setCode(null);
    }

    public boolean hasCode()
    {
        return Kmu.hasValue(getCode());
    }

    public boolean hasCode(String e)
    {
        return Kmu.isEqualIgnoreCase(getCode(), e);
    }

    public void truncateCode()
    {
        truncateCode(false);
    }

    public void truncateCode(boolean ellipses)
    {
        code = Kmu.truncate(code, 5, ellipses);
    }

    //##################################################
    //# field (companyName)
    //##################################################

    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String e)
    {
        e = Validator.getCompanyNameValidator().convert(e);
        companyName = e;
    }

    public void clearCompanyName()
    {
        setCompanyName(null);
    }

    public boolean hasCompanyName()
    {
        return Kmu.hasValue(getCompanyName());
    }

    public boolean hasCompanyName(String e)
    {
        return Kmu.isEqualIgnoreCase(getCompanyName(), e);
    }

    public void truncateCompanyName()
    {
        truncateCompanyName(false);
    }

    public void truncateCompanyName(boolean ellipses)
    {
        companyName = Kmu.truncate(companyName, 50, ellipses);
    }

    //##################################################
    //# field (createdUtcTs)
    //##################################################

    public KmTimestamp getCreatedUtcTs()
    {
        return createdUtcTs;
    }

    public void setCreatedUtcTs(KmTimestamp e)
    {
        e = Validator.getCreatedUtcTsValidator().convert(e);
        createdUtcTs = e;
    }

    public void clearCreatedUtcTs()
    {
        setCreatedUtcTs(null);
    }

    public boolean hasCreatedUtcTs()
    {
        return getCreatedUtcTs() != null;
    }

    public boolean hasCreatedUtcTs(KmTimestamp e)
    {
        return Kmu.isEqual(getCreatedUtcTs(), e);
    }

    //##################################################
    //# field (description)
    //##################################################

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String e)
    {
        e = Validator.getDescriptionValidator().convert(e);
        description = e;
    }

    public void clearDescription()
    {
        setDescription(null);
    }

    public boolean hasDescription()
    {
        return Kmu.hasValue(getDescription());
    }

    public boolean hasDescription(String e)
    {
        return Kmu.isEqualIgnoreCase(getDescription(), e);
    }

    public void truncateDescription()
    {
        truncateDescription(false);
    }

    public void truncateDescription(boolean ellipses)
    {
        description = Kmu.truncate(description, 1000, ellipses);
    }

    //##################################################
    //# field (domainSubtitle)
    //##################################################

    public abstract String getDomainSubtitle();

    public boolean hasDomainSubtitle()
    {
        return Kmu.hasValue(getDomainSubtitle());
    }

    public boolean hasDomainSubtitle(String e)
    {
        return Kmu.isEqualIgnoreCase(getDomainSubtitle(), e);
    }

    //##################################################
    //# field (domainTitle)
    //##################################################

    public abstract String getDomainTitle();

    public boolean hasDomainTitle()
    {
        return Kmu.hasValue(getDomainTitle());
    }

    public boolean hasDomainTitle(String e)
    {
        return Kmu.isEqualIgnoreCase(getDomainTitle(), e);
    }

    //##################################################
    //# field (enabled)
    //##################################################

    public Boolean getEnabled()
    {
        return enabled;
    }

    public void setEnabled(Boolean e)
    {
        e = Validator.getEnabledValidator().convert(e);
        enabled = e;
    }

    public void clearEnabled()
    {
        setEnabled(null);
    }

    public boolean hasEnabled()
    {
        return getEnabled() != null;
    }

    public boolean hasEnabled(Boolean e)
    {
        return Kmu.isEqual(getEnabled(), e);
    }

    public boolean isEnabled()
    {
        if ( getEnabled() == null )
            return false;
        return getEnabled();
    }

    public boolean isEnabled(Boolean b)
    {
        return Kmu.isEqual(getEnabled(), b);
    }

    public void toggleEnabled()
    {
        setEnabled(!getEnabled());
    }

    //##################################################
    //# field (enabledStatus)
    //##################################################

    public abstract String getEnabledStatus();

    public boolean hasEnabledStatus()
    {
        return Kmu.hasValue(getEnabledStatus());
    }

    public boolean hasEnabledStatus(String e)
    {
        return Kmu.isEqualIgnoreCase(getEnabledStatus(), e);
    }

    //##################################################
    //# field (name)
    //##################################################

    public String getName()
    {
        return name;
    }

    public void setName(String e)
    {
        e = Validator.getNameValidator().convert(e);
        name = e;
    }

    public void clearName()
    {
        setName(null);
    }

    public boolean hasName()
    {
        return Kmu.hasValue(getName());
    }

    public boolean hasName(String e)
    {
        return Kmu.isEqualIgnoreCase(getName(), e);
    }

    public void truncateName()
    {
        truncateName(false);
    }

    public void truncateName(boolean ellipses)
    {
        name = Kmu.truncate(name, 50, ellipses);
    }

    //##################################################
    //# field (nextAutoSiteNumber)
    //##################################################

    public Integer getNextAutoSiteNumber()
    {
        return nextAutoSiteNumber;
    }

    public void setNextAutoSiteNumber(Integer e)
    {
        e = Validator.getNextAutoSiteNumberValidator().convert(e);
        nextAutoSiteNumber = e;
    }

    public void clearNextAutoSiteNumber()
    {
        setNextAutoSiteNumber(null);
    }

    public boolean hasNextAutoSiteNumber()
    {
        return getNextAutoSiteNumber() != null;
    }

    public boolean hasNextAutoSiteNumber(Integer e)
    {
        return Kmu.isEqual(getNextAutoSiteNumber(), e);
    }

    //##################################################
    //# field (sendEmailFrom)
    //##################################################

    public String getSendEmailFrom()
    {
        return sendEmailFrom;
    }

    public void setSendEmailFrom(String e)
    {
        e = Validator.getSendEmailFromValidator().convert(e);
        sendEmailFrom = e;
    }

    public void clearSendEmailFrom()
    {
        setSendEmailFrom(null);
    }

    public boolean hasSendEmailFrom()
    {
        return Kmu.hasValue(getSendEmailFrom());
    }

    public boolean hasSendEmailFrom(String e)
    {
        return Kmu.isEqualIgnoreCase(getSendEmailFrom(), e);
    }

    public void truncateSendEmailFrom()
    {
        truncateSendEmailFrom(false);
    }

    public void truncateSendEmailFrom(boolean ellipses)
    {
        sendEmailFrom = Kmu.truncate(sendEmailFrom, 50, ellipses);
    }

    //##################################################
    //# field (timeZoneCode)
    //##################################################

    public String getTimeZoneCode()
    {
        return timeZoneCode;
    }

    public void setTimeZoneCode(String e)
    {
        e = Validator.getTimeZoneCodeValidator().convert(e);
        timeZoneCode = e;
    }

    public void clearTimeZoneCode()
    {
        setTimeZoneCode(null);
    }

    public boolean hasTimeZoneCode()
    {
        return Kmu.hasValue(getTimeZoneCode());
    }

    public boolean hasTimeZoneCode(String e)
    {
        return Kmu.isEqualIgnoreCase(getTimeZoneCode(), e);
    }

    public void truncateTimeZoneCode()
    {
        truncateTimeZoneCode(false);
    }

    public void truncateTimeZoneCode(boolean ellipses)
    {
        timeZoneCode = Kmu.truncate(timeZoneCode, 40, ellipses);
    }

    //##################################################
    //# field (timeZoneName)
    //##################################################

    public abstract String getTimeZoneName();

    public boolean hasTimeZoneName()
    {
        return Kmu.hasValue(getTimeZoneName());
    }

    public boolean hasTimeZoneName(String e)
    {
        return Kmu.isEqualIgnoreCase(getTimeZoneName(), e);
    }

    //##################################################
    //# field (uid)
    //##################################################

    public String getUid()
    {
        return uid;
    }

    public void setUid(String e)
    {
        e = Validator.getUidValidator().convert(e);
        uid = e;
    }

    public void clearUid()
    {
        setUid(null);
    }

    public boolean hasUid()
    {
        return Kmu.hasValue(getUid());
    }

    public boolean hasUid(String e)
    {
        return Kmu.isEqualIgnoreCase(getUid(), e);
    }

    public void truncateUid()
    {
        truncateUid(false);
    }

    public void truncateUid(boolean ellipses)
    {
        uid = Kmu.truncate(uid, 30, ellipses);
    }

    //##################################################
    //# field (updatedUtcTs)
    //##################################################

    public KmTimestamp getUpdatedUtcTs()
    {
        return updatedUtcTs;
    }

    public void setUpdatedUtcTs(KmTimestamp e)
    {
        e = Validator.getUpdatedUtcTsValidator().convert(e);
        updatedUtcTs = e;
    }

    public void clearUpdatedUtcTs()
    {
        setUpdatedUtcTs(null);
    }

    public boolean hasUpdatedUtcTs()
    {
        return getUpdatedUtcTs() != null;
    }

    public boolean hasUpdatedUtcTs(KmTimestamp e)
    {
        return Kmu.isEqual(getUpdatedUtcTs(), e);
    }

    //##################################################
    //# field (lockVersion)
    //##################################################

    public Integer getLockVersion()
    {
        return lockVersion;
    }

    public void setLockVersion(Integer e)
    {
        e = Validator.getLockVersionValidator().convert(e);
        lockVersion = e;
    }

    public void clearLockVersion()
    {
        setLockVersion(null);
    }

    public boolean hasLockVersion()
    {
        return getLockVersion() != null;
    }

    public boolean hasLockVersion(Integer e)
    {
        return Kmu.isEqual(getLockVersion(), e);
    }

    //##################################################
    //# field (createdLocalTs)
    //##################################################

    public final KmTimestamp getCreatedLocalTs()
    {
        return KmTimestampUtility.toLocal(getCreatedUtcTs());
    }

    public boolean hasCreatedLocalTs()
    {
        return getCreatedLocalTs() != null;
    }

    public boolean hasCreatedLocalTs(KmTimestamp e)
    {
        return Kmu.isEqual(getCreatedLocalTs(), e);
    }

    //##################################################
    //# field (createdLocalTsMessage)
    //##################################################

    public final String getCreatedLocalTsMessage()
    {
        return KmTimestampUtility.formatLocalMessage(getCreatedUtcTs());
    }

    public boolean hasCreatedLocalTsMessage()
    {
        return Kmu.hasValue(getCreatedLocalTsMessage());
    }

    public boolean hasCreatedLocalTsMessage(String e)
    {
        return Kmu.isEqualIgnoreCase(getCreatedLocalTsMessage(), e);
    }

    //##################################################
    //# field (createdLocalDate)
    //##################################################

    public final KmDate getCreatedLocalDate()
    {
        return KmTimestampUtility.getDate(getCreatedLocalTs());
    }

    public boolean hasCreatedLocalDate()
    {
        return getCreatedLocalDate() != null;
    }

    public boolean hasCreatedLocalDate(KmDate e)
    {
        return Kmu.isEqual(getCreatedLocalDate(), e);
    }

    //##################################################
    //# field (createdLocalTime)
    //##################################################

    public final KmTime getCreatedLocalTime()
    {
        return KmTimestampUtility.getTime(getCreatedLocalTs());
    }

    public boolean hasCreatedLocalTime()
    {
        return getCreatedLocalTime() != null;
    }

    public boolean hasCreatedLocalTime(KmTime e)
    {
        return Kmu.isEqual(getCreatedLocalTime(), e);
    }

    //##################################################
    //# field (updatedLocalTs)
    //##################################################

    public final KmTimestamp getUpdatedLocalTs()
    {
        return KmTimestampUtility.toLocal(getUpdatedUtcTs());
    }

    public boolean hasUpdatedLocalTs()
    {
        return getUpdatedLocalTs() != null;
    }

    public boolean hasUpdatedLocalTs(KmTimestamp e)
    {
        return Kmu.isEqual(getUpdatedLocalTs(), e);
    }

    //##################################################
    //# field (updatedLocalTsMessage)
    //##################################################

    public final String getUpdatedLocalTsMessage()
    {
        return KmTimestampUtility.formatLocalMessage(getUpdatedUtcTs());
    }

    public boolean hasUpdatedLocalTsMessage()
    {
        return Kmu.hasValue(getUpdatedLocalTsMessage());
    }

    public boolean hasUpdatedLocalTsMessage(String e)
    {
        return Kmu.isEqualIgnoreCase(getUpdatedLocalTsMessage(), e);
    }

    //##################################################
    //# field (updatedLocalDate)
    //##################################################

    public final KmDate getUpdatedLocalDate()
    {
        return KmTimestampUtility.getDate(getUpdatedLocalTs());
    }

    public boolean hasUpdatedLocalDate()
    {
        return getUpdatedLocalDate() != null;
    }

    public boolean hasUpdatedLocalDate(KmDate e)
    {
        return Kmu.isEqual(getUpdatedLocalDate(), e);
    }

    //##################################################
    //# field (updatedLocalTime)
    //##################################################

    public final KmTime getUpdatedLocalTime()
    {
        return KmTimestampUtility.getTime(getUpdatedLocalTs());
    }

    public boolean hasUpdatedLocalTime()
    {
        return getUpdatedLocalTime() != null;
    }

    public boolean hasUpdatedLocalTime(KmTime e)
    {
        return Kmu.isEqual(getUpdatedLocalTime(), e);
    }

    //##################################################
    //# createdBy
    //##################################################

    public MyUser getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy(MyUser e)
    {
        createdBy = e;
    }

    public void _setCreatedBy(MyUser e)
    {
        createdBy = e;
    }

    public void clearCreatedBy()
    {
        setCreatedBy(null);
    }

    public boolean hasCreatedBy()
    {
        return getCreatedBy() != null;
    }

    public boolean hasCreatedBy(MyUser e)
    {
        return Kmu.isEqual(getCreatedBy(), e);
    }

    public String getCreatedByFullName()
    {
        if ( hasCreatedBy() )
            return getCreatedBy().getFullName();
        return null;
    }

    public void setCreatedByFullName(String e)
    {
        getCreatedBy().setFullName(e);
    }

    public boolean hasCreatedByFullName()
    {
        return hasCreatedBy() && getCreatedBy().hasFullName();
    }

    public boolean hasCreatedByFullName(String e)
    {
        return hasCreatedBy() && getCreatedBy().hasFullName(e);
    }

    //##################################################
    //# defaultPriority
    //##################################################

    public MyPriority getDefaultPriority()
    {
        return defaultPriority;
    }

    public void setDefaultPriority(MyPriority e)
    {
        defaultPriority = e;
    }

    public void _setDefaultPriority(MyPriority e)
    {
        defaultPriority = e;
    }

    public void clearDefaultPriority()
    {
        setDefaultPriority(null);
    }

    public boolean hasDefaultPriority()
    {
        return getDefaultPriority() != null;
    }

    public boolean hasDefaultPriority(MyPriority e)
    {
        return Kmu.isEqual(getDefaultPriority(), e);
    }

    public String getDefaultPriorityName()
    {
        if ( hasDefaultPriority() )
            return getDefaultPriority().getName();
        return null;
    }

    public void setDefaultPriorityName(String e)
    {
        getDefaultPriority().setName(e);
    }

    public boolean hasDefaultPriorityName()
    {
        return hasDefaultPriority() && getDefaultPriority().hasName();
    }

    public boolean hasDefaultPriorityName(String e)
    {
        return hasDefaultPriority() && getDefaultPriority().hasName(e);
    }

    //##################################################
    //# supervisor
    //##################################################

    public MyUser getSupervisor()
    {
        return supervisor;
    }

    public void setSupervisor(MyUser e)
    {
        supervisor = e;
    }

    public void _setSupervisor(MyUser e)
    {
        supervisor = e;
    }

    public void clearSupervisor()
    {
        setSupervisor(null);
    }

    public boolean hasSupervisor()
    {
        return getSupervisor() != null;
    }

    public boolean hasSupervisor(MyUser e)
    {
        return Kmu.isEqual(getSupervisor(), e);
    }

    public String getSupervisorFullName()
    {
        if ( hasSupervisor() )
            return getSupervisor().getFullName();
        return null;
    }

    public void setSupervisorFullName(String e)
    {
        getSupervisor().setFullName(e);
    }

    public boolean hasSupervisorFullName()
    {
        return hasSupervisor() && getSupervisor().hasFullName();
    }

    public boolean hasSupervisorFullName(String e)
    {
        return hasSupervisor() && getSupervisor().hasFullName(e);
    }

    //##################################################
    //# supportContact
    //##################################################

    public MyProjectContact getSupportContact()
    {
        return supportContact;
    }

    public void setSupportContact(MyProjectContact e)
    {
        supportContact = e;
    }

    public void _setSupportContact(MyProjectContact e)
    {
        supportContact = e;
    }

    public void clearSupportContact()
    {
        setSupportContact(null);
    }

    public boolean hasSupportContact()
    {
        return getSupportContact() != null;
    }

    public boolean hasSupportContact(MyProjectContact e)
    {
        return Kmu.isEqual(getSupportContact(), e);
    }

    public String getSupportContactFullName()
    {
        if ( hasSupportContact() )
            return getSupportContact().getFullName();
        return null;
    }

    public void setSupportContactFullName(String e)
    {
        getSupportContact().setFullName(e);
    }

    public boolean hasSupportContactFullName()
    {
        return hasSupportContact() && getSupportContact().hasFullName();
    }

    public boolean hasSupportContactFullName(String e)
    {
        return hasSupportContact() && getSupportContact().hasFullName(e);
    }

    public String getSupportContactEmail()
    {
        if ( hasSupportContact() )
            return getSupportContact().getEmail();
        return null;
    }

    public void setSupportContactEmail(String e)
    {
        getSupportContact().setEmail(e);
    }

    public boolean hasSupportContactEmail()
    {
        return hasSupportContact() && getSupportContact().hasEmail();
    }

    public boolean hasSupportContactEmail(String e)
    {
        return hasSupportContact() && getSupportContact().hasEmail(e);
    }

    public String getSupportContactPhone()
    {
        if ( hasSupportContact() )
            return getSupportContact().getPhone();
        return null;
    }

    public void setSupportContactPhone(String e)
    {
        getSupportContact().setPhone(e);
    }

    public boolean hasSupportContactPhone()
    {
        return hasSupportContact() && getSupportContact().hasPhone();
    }

    public boolean hasSupportContactPhone(String e)
    {
        return hasSupportContact() && getSupportContact().hasPhone(e);
    }

    //##################################################
    //# tenant
    //##################################################

    public MyTenant getTenant()
    {
        return tenant;
    }

    public void setTenant(MyTenant e)
    {
        tenant = e;
    }

    public void _setTenant(MyTenant e)
    {
        tenant = e;
    }

    public void clearTenant()
    {
        setTenant(null);
    }

    public boolean hasTenant()
    {
        return getTenant() != null;
    }

    public boolean hasTenant(MyTenant e)
    {
        return Kmu.isEqual(getTenant(), e);
    }

    public String getTenantName()
    {
        if ( hasTenant() )
            return getTenant().getName();
        return null;
    }

    public void setTenantName(String e)
    {
        getTenant().setName(e);
    }

    public boolean hasTenantName()
    {
        return hasTenant() && getTenant().hasName();
    }

    public boolean hasTenantName(String e)
    {
        return hasTenant() && getTenant().hasName(e);
    }

    //##################################################
    //# updatedBy
    //##################################################

    public MyUser getUpdatedBy()
    {
        return updatedBy;
    }

    public void setUpdatedBy(MyUser e)
    {
        updatedBy = e;
    }

    public void _setUpdatedBy(MyUser e)
    {
        updatedBy = e;
    }

    public void clearUpdatedBy()
    {
        setUpdatedBy(null);
    }

    public boolean hasUpdatedBy()
    {
        return getUpdatedBy() != null;
    }

    public boolean hasUpdatedBy(MyUser e)
    {
        return Kmu.isEqual(getUpdatedBy(), e);
    }

    public String getUpdatedByFullName()
    {
        if ( hasUpdatedBy() )
            return getUpdatedBy().getFullName();
        return null;
    }

    public void setUpdatedByFullName(String e)
    {
        getUpdatedBy().setFullName(e);
    }

    public boolean hasUpdatedByFullName()
    {
        return hasUpdatedBy() && getUpdatedBy().hasFullName();
    }

    public boolean hasUpdatedByFullName(String e)
    {
        return hasUpdatedBy() && getUpdatedBy().hasFullName(e);
    }


    //##################################################
    //# Blurbs (collection)
    //##################################################

    public KmCollection<MyBlurb> getBlurbs()
    {
        return new KmHibernateCollection<>(
            getBaseBlurbs(),
            (MyProject)this,
            MyBlurb.Meta.Project);
    }

    public boolean hasBlurbs()
    {
        return !getBaseBlurbs().isEmpty();
    }

    public int getBlurbCount()
    {
        return getBaseBlurbs().size();
    }

    public List<MyBlurb> getBaseBlurbs()
    {
        return blurbs;
    }

    public MyBlurb addBlurb()
    {
        MyBlurb e;
        e = new MyBlurb();
        getBlurbs().add(e);
        return e;
    }

    public void addBlurb(MyBlurb e)
    {
        getBlurbs().add(e);
    }

    public boolean removeBlurb(MyBlurb e)
    {
        return getBlurbs().remove(e);
    }

    public boolean removeBlurbUid(String myUid)
    {
        MyBlurb e = findBlurbUid(myUid);
        if ( e == null )
            return false;

        return removeBlurb(e);
    }

    public MyBlurb findBlurbUid(String myUid)
    {
        for ( MyBlurb e : getBaseBlurbs() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearBlurbs()
    {
        getBlurbs().clear();
    }

    //##################################################
    //# Contacts (collection)
    //##################################################

    public KmCollection<MyProjectContact> getContacts()
    {
        return new KmHibernateCollection<>(
            getBaseContacts(),
            (MyProject)this,
            MyProjectContact.Meta.Project);
    }

    public boolean hasContacts()
    {
        return !getBaseContacts().isEmpty();
    }

    public int getContactCount()
    {
        return getBaseContacts().size();
    }

    public List<MyProjectContact> getBaseContacts()
    {
        return contacts;
    }

    public MyProjectContact addContact()
    {
        MyProjectContact e;
        e = new MyProjectContact();
        getContacts().add(e);
        return e;
    }

    public void addContact(MyProjectContact e)
    {
        getContacts().add(e);
    }

    public boolean removeContact(MyProjectContact e)
    {
        return getContacts().remove(e);
    }

    public boolean removeContactUid(String myUid)
    {
        MyProjectContact e = findContactUid(myUid);
        if ( e == null )
            return false;

        return removeContact(e);
    }

    public MyProjectContact findContactUid(String myUid)
    {
        for ( MyProjectContact e : getBaseContacts() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearContacts()
    {
        getContacts().clear();
    }

    //##################################################
    //# Customers (collection)
    //##################################################

    public KmCollection<MyCustomer> getCustomers()
    {
        return new KmHibernateCollection<>(
            getBaseCustomers(),
            (MyProject)this,
            MyCustomer.Meta.Project);
    }

    public boolean hasCustomers()
    {
        return !getBaseCustomers().isEmpty();
    }

    public int getCustomerCount()
    {
        return getBaseCustomers().size();
    }

    public List<MyCustomer> getBaseCustomers()
    {
        return customers;
    }

    public MyCustomer addCustomer()
    {
        MyCustomer e;
        e = new MyCustomer();
        getCustomers().add(e);
        return e;
    }

    public void addCustomer(MyCustomer e)
    {
        getCustomers().add(e);
    }

    public boolean removeCustomer(MyCustomer e)
    {
        return getCustomers().remove(e);
    }

    public boolean removeCustomerUid(String myUid)
    {
        MyCustomer e = findCustomerUid(myUid);
        if ( e == null )
            return false;

        return removeCustomer(e);
    }

    public MyCustomer findCustomerUid(String myUid)
    {
        for ( MyCustomer e : getBaseCustomers() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearCustomers()
    {
        getCustomers().clear();
    }

    //##################################################
    //# EmailTemplates (collection)
    //##################################################

    public KmCollection<MyEmailTemplate> getEmailTemplates()
    {
        return new KmHibernateCollection<>(
            getBaseEmailTemplates(),
            (MyProject)this,
            MyEmailTemplate.Meta.Project);
    }

    public boolean hasEmailTemplates()
    {
        return !getBaseEmailTemplates().isEmpty();
    }

    public int getEmailTemplateCount()
    {
        return getBaseEmailTemplates().size();
    }

    public List<MyEmailTemplate> getBaseEmailTemplates()
    {
        return emailTemplates;
    }

    public MyEmailTemplate addEmailTemplate()
    {
        MyEmailTemplate e;
        e = new MyEmailTemplate();
        getEmailTemplates().add(e);
        return e;
    }

    public void addEmailTemplate(MyEmailTemplate e)
    {
        getEmailTemplates().add(e);
    }

    public boolean removeEmailTemplate(MyEmailTemplate e)
    {
        return getEmailTemplates().remove(e);
    }

    public boolean removeEmailTemplateUid(String myUid)
    {
        MyEmailTemplate e = findEmailTemplateUid(myUid);
        if ( e == null )
            return false;

        return removeEmailTemplate(e);
    }

    public MyEmailTemplate findEmailTemplateUid(String myUid)
    {
        for ( MyEmailTemplate e : getBaseEmailTemplates() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearEmailTemplates()
    {
        getEmailTemplates().clear();
    }

    //##################################################
    //# Holidays (collection)
    //##################################################

    public KmCollection<MyHoliday> getHolidays()
    {
        return new KmHibernateCollection<>(
            getBaseHolidays(),
            (MyProject)this,
            MyHoliday.Meta.Project);
    }

    public boolean hasHolidays()
    {
        return !getBaseHolidays().isEmpty();
    }

    public int getHolidayCount()
    {
        return getBaseHolidays().size();
    }

    public List<MyHoliday> getBaseHolidays()
    {
        return holidays;
    }

    public MyHoliday addHoliday()
    {
        MyHoliday e;
        e = new MyHoliday();
        getHolidays().add(e);
        return e;
    }

    public void addHoliday(MyHoliday e)
    {
        getHolidays().add(e);
    }

    public boolean removeHoliday(MyHoliday e)
    {
        return getHolidays().remove(e);
    }

    public boolean removeHolidayUid(String myUid)
    {
        MyHoliday e = findHolidayUid(myUid);
        if ( e == null )
            return false;

        return removeHoliday(e);
    }

    public MyHoliday findHolidayUid(String myUid)
    {
        for ( MyHoliday e : getBaseHolidays() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearHolidays()
    {
        getHolidays().clear();
    }

    //##################################################
    //# Members (collection)
    //##################################################

    public KmCollection<MyMember> getMembers()
    {
        return new KmHibernateCollection<>(
            getBaseMembers(),
            (MyProject)this,
            MyMember.Meta.Project);
    }

    public boolean hasMembers()
    {
        return !getBaseMembers().isEmpty();
    }

    public int getMemberCount()
    {
        return getBaseMembers().size();
    }

    public List<MyMember> getBaseMembers()
    {
        return members;
    }

    public MyMember addMember()
    {
        MyMember e;
        e = new MyMember();
        getMembers().add(e);
        return e;
    }

    public void addMember(MyMember e)
    {
        getMembers().add(e);
    }

    public boolean removeMember(MyMember e)
    {
        return getMembers().remove(e);
    }

    public boolean removeMemberUid(String myUid)
    {
        MyMember e = findMemberUid(myUid);
        if ( e == null )
            return false;

        return removeMember(e);
    }

    public MyMember findMemberUid(String myUid)
    {
        for ( MyMember e : getBaseMembers() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearMembers()
    {
        getMembers().clear();
    }

    //##################################################
    //# Vendors (collection)
    //##################################################

    public KmCollection<MyVendor> getVendors()
    {
        return new KmHibernateCollection<>(
            getBaseVendors(),
            (MyProject)this,
            MyVendor.Meta.Project);
    }

    public boolean hasVendors()
    {
        return !getBaseVendors().isEmpty();
    }

    public int getVendorCount()
    {
        return getBaseVendors().size();
    }

    public List<MyVendor> getBaseVendors()
    {
        return vendors;
    }

    public MyVendor addVendor()
    {
        MyVendor e;
        e = new MyVendor();
        getVendors().add(e);
        return e;
    }

    public void addVendor(MyVendor e)
    {
        getVendors().add(e);
    }

    public boolean removeVendor(MyVendor e)
    {
        return getVendors().remove(e);
    }

    public boolean removeVendorUid(String myUid)
    {
        MyVendor e = findVendorUid(myUid);
        if ( e == null )
            return false;

        return removeVendor(e);
    }

    public MyVendor findVendorUid(String myUid)
    {
        for ( MyVendor e : getBaseVendors() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearVendors()
    {
        getVendors().clear();
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    protected final MyProjectValidator getValidator()
    {
        return Validator;
    }

    @Override
    protected final MyProject asSubclass()
    {
        return (MyProject)this;
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyProject getCopy()
    {
        return (MyProject)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = newUid();
        tenant = null;

        List<MyBlurb> old_blurbs = blurbs;
        blurbs = new ArrayList<>();
        for ( MyBlurb e : old_blurbs )
            addBlurb(copy(e));

        List<MyProjectContact> old_contacts = contacts;
        contacts = new ArrayList<>();
        for ( MyProjectContact e : old_contacts )
            addContact(copy(e));

        List<MyCustomer> old_customers = customers;
        customers = new ArrayList<>();
        for ( MyCustomer e : old_customers )
            addCustomer(copy(e));

        List<MyEmailTemplate> old_emailTemplates = emailTemplates;
        emailTemplates = new ArrayList<>();
        for ( MyEmailTemplate e : old_emailTemplates )
            addEmailTemplate(copy(e));

        List<MyHoliday> old_holidays = holidays;
        holidays = new ArrayList<>();
        for ( MyHoliday e : old_holidays )
            addHoliday(copy(e));

        List<MyMember> old_members = members;
        members = new ArrayList<>();
        for ( MyMember e : old_members )
            addMember(copy(e));

        List<MyVendor> old_vendors = vendors;
        vendors = new ArrayList<>();
        for ( MyVendor e : old_vendors )
            addVendor(copy(e));
    }

    /**
     * Get a copy of this model without any associations or collections.
     * The primary key and lock version are not copied.
     * The basic timestamps are reset.
     */
    public final MyProject getBasicCopy()
    {
        MyProject e;
        e = new MyProject();
        applyEditableFieldsTo(e);
        resetBasicTimestamps();
        return e;
    }

    /**
     * Apply the editable fields TO another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsTo(MyProject e)
    {
        e.setAutoSiteNumberEnabled(getAutoSiteNumberEnabled());
        e.setAutoSiteNumberPadding(getAutoSiteNumberPadding());
        e.setAutoSiteNumberPrefix(getAutoSiteNumberPrefix());
        e.setBusinessDays(getBusinessDays());
        e.setBusinessEndTime(getBusinessEndTime());
        e.setBusinessStartTime(getBusinessStartTime());
        e.setCode(getCode());
        e.setCompanyName(getCompanyName());
        e.setCreatedUtcTs(getCreatedUtcTs());
        e.setDescription(getDescription());
        e.setEnabled(getEnabled());
        e.setName(getName());
        e.setNextAutoSiteNumber(getNextAutoSiteNumber());
        e.setSendEmailFrom(getSendEmailFrom());
        e.setTimeZoneCode(getTimeZoneCode());
        e.setUpdatedUtcTs(getUpdatedUtcTs());
    }

    /**
     * Apply the editable fields FROM another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsFrom(MyProject e)
    {
        setAutoSiteNumberEnabled(e.getAutoSiteNumberEnabled());
        setAutoSiteNumberPadding(e.getAutoSiteNumberPadding());
        setAutoSiteNumberPrefix(e.getAutoSiteNumberPrefix());
        setBusinessDays(e.getBusinessDays());
        setBusinessEndTime(e.getBusinessEndTime());
        setBusinessStartTime(e.getBusinessStartTime());
        setCode(e.getCode());
        setCompanyName(e.getCompanyName());
        setCreatedUtcTs(e.getCreatedUtcTs());
        setDescription(e.getDescription());
        setEnabled(e.getEnabled());
        setName(e.getName());
        setNextAutoSiteNumber(e.getNextAutoSiteNumber());
        setSendEmailFrom(e.getSendEmailFrom());
        setTimeZoneCode(e.getTimeZoneCode());
        setUpdatedUtcTs(e.getUpdatedUtcTs());
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyProjectBase) )
            return false;

        MyProjectBase e = (MyProjectBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyProject e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyProject e)
    {
        if ( !Kmu.isEqual(getAuditLogTitle(), e.getAuditLogTitle()) ) return false;
        if ( !Kmu.isEqual(getAutoSiteNumberEnabled(), e.getAutoSiteNumberEnabled()) ) return false;
        if ( !Kmu.isEqual(getAutoSiteNumberPadding(), e.getAutoSiteNumberPadding()) ) return false;
        if ( !Kmu.isEqual(getAutoSiteNumberPrefix(), e.getAutoSiteNumberPrefix()) ) return false;
        if ( !Kmu.isEqual(getBusinessDays(), e.getBusinessDays()) ) return false;
        if ( !Kmu.isEqual(getBusinessEndTime(), e.getBusinessEndTime()) ) return false;
        if ( !Kmu.isEqual(getBusinessStartTime(), e.getBusinessStartTime()) ) return false;
        if ( !Kmu.isEqual(getCode(), e.getCode()) ) return false;
        if ( !Kmu.isEqual(getCompanyName(), e.getCompanyName()) ) return false;
        if ( !Kmu.isEqual(getCreatedUtcTs(), e.getCreatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getDescription(), e.getDescription()) ) return false;
        if ( !Kmu.isEqual(getDomainSubtitle(), e.getDomainSubtitle()) ) return false;
        if ( !Kmu.isEqual(getDomainTitle(), e.getDomainTitle()) ) return false;
        if ( !Kmu.isEqual(getEnabled(), e.getEnabled()) ) return false;
        if ( !Kmu.isEqual(getEnabledStatus(), e.getEnabledStatus()) ) return false;
        if ( !Kmu.isEqual(getName(), e.getName()) ) return false;
        if ( !Kmu.isEqual(getNextAutoSiteNumber(), e.getNextAutoSiteNumber()) ) return false;
        if ( !Kmu.isEqual(getSendEmailFrom(), e.getSendEmailFrom()) ) return false;
        if ( !Kmu.isEqual(getTimeZoneCode(), e.getTimeZoneCode()) ) return false;
        if ( !Kmu.isEqual(getTimeZoneName(), e.getTimeZoneName()) ) return false;
        if ( !Kmu.isEqual(getUpdatedUtcTs(), e.getUpdatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTs(), e.getCreatedLocalTs()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTsMessage(), e.getCreatedLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalDate(), e.getCreatedLocalDate()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTime(), e.getCreatedLocalTime()) ) return false;
        if ( !Kmu.isEqual(getUpdatedLocalTs(), e.getUpdatedLocalTs()) ) return false;
        if ( !Kmu.isEqual(getUpdatedLocalTsMessage(), e.getUpdatedLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getUpdatedLocalDate(), e.getUpdatedLocalDate()) ) return false;
        if ( !Kmu.isEqual(getUpdatedLocalTime(), e.getUpdatedLocalTime()) ) return false;
        return true;
    }

    public boolean isDifferent(MyProject e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyProject e)
    {
        return !isSameIgnoringKey(e);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        StringBuilder out;
        out = new StringBuilder();
        out.append("MyProject");
        out.append("(");
        out.append("Uid=");
        out.append(uid);
        out.append(")");
        return out.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    AutoSiteNumberEnabled = " + autoSiteNumberEnabled);
        System.out.println("    AutoSiteNumberPadding = " + autoSiteNumberPadding);
        System.out.println("    AutoSiteNumberPrefix = " + autoSiteNumberPrefix);
        System.out.println("    BusinessDays = " + businessDays);
        System.out.println("    BusinessEndTime = " + businessEndTime);
        System.out.println("    BusinessStartTime = " + businessStartTime);
        System.out.println("    Code = " + code);
        System.out.println("    CompanyName = " + companyName);
        System.out.println("    CreatedUtcTs = " + createdUtcTs);
        System.out.println("    Description = " + description);
        System.out.println("    Enabled = " + enabled);
        System.out.println("    Name = " + name);
        System.out.println("    NextAutoSiteNumber = " + nextAutoSiteNumber);
        System.out.println("    SendEmailFrom = " + sendEmailFrom);
        System.out.println("    TimeZoneCode = " + timeZoneCode);
        System.out.println("    Uid = " + uid);
        System.out.println("    UpdatedUtcTs = " + updatedUtcTs);
        System.out.println("    LockVersion = " + lockVersion);
    }

    /**
     * Format the primary key fields in a comma separated list.  The format
     * is intended to be suitable for display to users.
     */
    @Override
    public String formatPrimaryKey()
    {
        return uid;
    }


    //##################################################
    //# convenience
    //##################################################

    @Override
    public String getMetaName()
    {
        return Meta.getName();
    }

    public void daoTouch()
    {
        setLockVersion(getLockVersion() + 1);
    }

}
