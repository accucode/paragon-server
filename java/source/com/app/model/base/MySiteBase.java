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
public abstract class MySiteBase
    extends MyAbstractDaoDomain<MySite>
    implements KmUidDomainIF
    ,MyBasicTimestampsIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaSite Meta = MyMetaSite.instance;
    public static final MySiteTools Tools = MySiteTools.instance;
    public static final MySiteValidator Validator = MySiteValidator.instance;
    public static final MySiteFinder Finder = MySiteFinder.instance;

    //##################################################
    //# variables
    //##################################################

    private String addressAttention;
    private String addressCity;
    private String addressCountry;
    private String addressPhone;
    private String addressPostalCode;
    private String addressRegion;
    private String addressStreet1;
    private String addressStreet2;
    private KmTimestamp createdUtcTs;
    private Boolean enabled;
    private String fullName;
    private String name;
    private String number;
    private String timeZoneCode;
    private String uid;
    private KmTimestamp updatedUtcTs;
    private Integer lockVersion;
    private MyUser createdBy;
    private MyCustomer customer;
    private MySiteContact installContact;
    private MySiteContact mainContact;
    private MyPriority priority;
    private MySiteContact requesterContact;
    private MySiteContact salesContact;
    private MySiteContact schedulingContact;
    private MySiteContact technicalContact;
    private MyChoice type;
    private MyUser updatedBy;
    private List<MySiteContact> contacts;

    //##################################################
    //# constructor
    //##################################################

    public MySiteBase()
    {
        super();
        setCreatedUtcTs(nowUtc());
        setEnabled(true);
        setUid(newUid());
        setUpdatedUtcTs(nowUtc());
        setLockVersion(0);
        setCreatedBy(MyGlobals.getCurrentUser());
        setUpdatedBy(MyGlobals.getCurrentUser());
        contacts = new ArrayList<>();
    }

    //##################################################
    //# field (addressAttention)
    //##################################################

    public String getAddressAttention()
    {
        return addressAttention;
    }

    public void setAddressAttention(String e)
    {
        e = Validator.getAddressAttentionValidator().convert(e);
        addressAttention = e;
    }

    public void clearAddressAttention()
    {
        setAddressAttention(null);
    }

    public boolean hasAddressAttention()
    {
        return Kmu.hasValue(getAddressAttention());
    }

    public boolean hasAddressAttention(String e)
    {
        return Kmu.isEqualIgnoreCase(getAddressAttention(), e);
    }

    public void truncateAddressAttention()
    {
        truncateAddressAttention(false);
    }

    public void truncateAddressAttention(boolean ellipses)
    {
        addressAttention = Kmu.truncate(addressAttention, 50, ellipses);
    }

    //##################################################
    //# field (addressCity)
    //##################################################

    public String getAddressCity()
    {
        return addressCity;
    }

    public void setAddressCity(String e)
    {
        e = Validator.getAddressCityValidator().convert(e);
        addressCity = e;
    }

    public void clearAddressCity()
    {
        setAddressCity(null);
    }

    public boolean hasAddressCity()
    {
        return Kmu.hasValue(getAddressCity());
    }

    public boolean hasAddressCity(String e)
    {
        return Kmu.isEqualIgnoreCase(getAddressCity(), e);
    }

    public void truncateAddressCity()
    {
        truncateAddressCity(false);
    }

    public void truncateAddressCity(boolean ellipses)
    {
        addressCity = Kmu.truncate(addressCity, 50, ellipses);
    }

    //##################################################
    //# field (addressCountry)
    //##################################################

    public String getAddressCountry()
    {
        return addressCountry;
    }

    public void setAddressCountry(String e)
    {
        e = Validator.getAddressCountryValidator().convert(e);
        addressCountry = e;
    }

    public void clearAddressCountry()
    {
        setAddressCountry(null);
    }

    public boolean hasAddressCountry()
    {
        return Kmu.hasValue(getAddressCountry());
    }

    public boolean hasAddressCountry(String e)
    {
        return Kmu.isEqualIgnoreCase(getAddressCountry(), e);
    }

    public void truncateAddressCountry()
    {
        truncateAddressCountry(false);
    }

    public void truncateAddressCountry(boolean ellipses)
    {
        addressCountry = Kmu.truncate(addressCountry, 50, ellipses);
    }

    //##################################################
    //# field (addressLongLine)
    //##################################################

    public abstract String getAddressLongLine();

    public boolean hasAddressLongLine()
    {
        return Kmu.hasValue(getAddressLongLine());
    }

    public boolean hasAddressLongLine(String e)
    {
        return Kmu.isEqualIgnoreCase(getAddressLongLine(), e);
    }

    //##################################################
    //# field (addressMultiLine)
    //##################################################

    public abstract String getAddressMultiLine();

    public boolean hasAddressMultiLine()
    {
        return Kmu.hasValue(getAddressMultiLine());
    }

    public boolean hasAddressMultiLine(String e)
    {
        return Kmu.isEqualIgnoreCase(getAddressMultiLine(), e);
    }

    //##################################################
    //# field (addressPhone)
    //##################################################

    public String getAddressPhone()
    {
        return addressPhone;
    }

    public void setAddressPhone(String e)
    {
        e = Validator.getAddressPhoneValidator().convert(e);
        addressPhone = e;
    }

    public void clearAddressPhone()
    {
        setAddressPhone(null);
    }

    public boolean hasAddressPhone()
    {
        return Kmu.hasValue(getAddressPhone());
    }

    public boolean hasAddressPhone(String e)
    {
        return Kmu.isEqualIgnoreCase(getAddressPhone(), e);
    }

    public void truncateAddressPhone()
    {
        truncateAddressPhone(false);
    }

    public void truncateAddressPhone(boolean ellipses)
    {
        addressPhone = Kmu.truncate(addressPhone, 30, ellipses);
    }

    //##################################################
    //# field (addressPostalCode)
    //##################################################

    public String getAddressPostalCode()
    {
        return addressPostalCode;
    }

    public void setAddressPostalCode(String e)
    {
        e = Validator.getAddressPostalCodeValidator().convert(e);
        addressPostalCode = e;
    }

    public void clearAddressPostalCode()
    {
        setAddressPostalCode(null);
    }

    public boolean hasAddressPostalCode()
    {
        return Kmu.hasValue(getAddressPostalCode());
    }

    public boolean hasAddressPostalCode(String e)
    {
        return Kmu.isEqualIgnoreCase(getAddressPostalCode(), e);
    }

    public void truncateAddressPostalCode()
    {
        truncateAddressPostalCode(false);
    }

    public void truncateAddressPostalCode(boolean ellipses)
    {
        addressPostalCode = Kmu.truncate(addressPostalCode, 20, ellipses);
    }

    //##################################################
    //# field (addressRegion)
    //##################################################

    public String getAddressRegion()
    {
        return addressRegion;
    }

    public void setAddressRegion(String e)
    {
        e = Validator.getAddressRegionValidator().convert(e);
        addressRegion = e;
    }

    public void clearAddressRegion()
    {
        setAddressRegion(null);
    }

    public boolean hasAddressRegion()
    {
        return Kmu.hasValue(getAddressRegion());
    }

    public boolean hasAddressRegion(String e)
    {
        return Kmu.isEqualIgnoreCase(getAddressRegion(), e);
    }

    public void truncateAddressRegion()
    {
        truncateAddressRegion(false);
    }

    public void truncateAddressRegion(boolean ellipses)
    {
        addressRegion = Kmu.truncate(addressRegion, 50, ellipses);
    }

    //##################################################
    //# field (addressShortLine)
    //##################################################

    public abstract String getAddressShortLine();

    public boolean hasAddressShortLine()
    {
        return Kmu.hasValue(getAddressShortLine());
    }

    public boolean hasAddressShortLine(String e)
    {
        return Kmu.isEqualIgnoreCase(getAddressShortLine(), e);
    }

    //##################################################
    //# field (addressStreet1)
    //##################################################

    public String getAddressStreet1()
    {
        return addressStreet1;
    }

    public void setAddressStreet1(String e)
    {
        e = Validator.getAddressStreet1Validator().convert(e);
        addressStreet1 = e;
    }

    public void clearAddressStreet1()
    {
        setAddressStreet1(null);
    }

    public boolean hasAddressStreet1()
    {
        return Kmu.hasValue(getAddressStreet1());
    }

    public boolean hasAddressStreet1(String e)
    {
        return Kmu.isEqualIgnoreCase(getAddressStreet1(), e);
    }

    public void truncateAddressStreet1()
    {
        truncateAddressStreet1(false);
    }

    public void truncateAddressStreet1(boolean ellipses)
    {
        addressStreet1 = Kmu.truncate(addressStreet1, 100, ellipses);
    }

    //##################################################
    //# field (addressStreet2)
    //##################################################

    public String getAddressStreet2()
    {
        return addressStreet2;
    }

    public void setAddressStreet2(String e)
    {
        e = Validator.getAddressStreet2Validator().convert(e);
        addressStreet2 = e;
    }

    public void clearAddressStreet2()
    {
        setAddressStreet2(null);
    }

    public boolean hasAddressStreet2()
    {
        return Kmu.hasValue(getAddressStreet2());
    }

    public boolean hasAddressStreet2(String e)
    {
        return Kmu.isEqualIgnoreCase(getAddressStreet2(), e);
    }

    public void truncateAddressStreet2()
    {
        truncateAddressStreet2(false);
    }

    public void truncateAddressStreet2(boolean ellipses)
    {
        addressStreet2 = Kmu.truncate(addressStreet2, 100, ellipses);
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
    //# field (fullName)
    //##################################################

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String e)
    {
        e = Validator.getFullNameValidator().convert(e);
        fullName = e;
    }

    public void clearFullName()
    {
        setFullName(null);
    }

    public boolean hasFullName()
    {
        return Kmu.hasValue(getFullName());
    }

    public boolean hasFullName(String e)
    {
        return Kmu.isEqualIgnoreCase(getFullName(), e);
    }

    public void truncateFullName()
    {
        truncateFullName(false);
    }

    public void truncateFullName(boolean ellipses)
    {
        fullName = Kmu.truncate(fullName, 100, ellipses);
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
        String oldValue = name;
        name = e;
        if ( Kmu.isNotEqual(e, oldValue) )
        {
            updateFullName();
        }
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
    //# field (number)
    //##################################################

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String e)
    {
        e = Validator.getNumberValidator().convert(e);
        String oldValue = number;
        number = e;
        if ( Kmu.isNotEqual(e, oldValue) )
        {
            updateFullName();
        }
    }

    public void clearNumber()
    {
        setNumber(null);
    }

    public boolean hasNumber()
    {
        return Kmu.hasValue(getNumber());
    }

    public boolean hasNumber(String e)
    {
        return Kmu.isEqualIgnoreCase(getNumber(), e);
    }

    public void truncateNumber()
    {
        truncateNumber(false);
    }

    public void truncateNumber(boolean ellipses)
    {
        number = Kmu.truncate(number, 50, ellipses);
    }

    //##################################################
    //# field (priorityName)
    //##################################################

    public abstract String getPriorityName();

    public boolean hasPriorityName()
    {
        return Kmu.hasValue(getPriorityName());
    }

    public boolean hasPriorityName(String e)
    {
        return Kmu.isEqualIgnoreCase(getPriorityName(), e);
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
    //# customer
    //##################################################

    public MyCustomer getCustomer()
    {
        return customer;
    }

    public void setCustomer(MyCustomer e)
    {
        customer = e;
    }

    public void _setCustomer(MyCustomer e)
    {
        customer = e;
    }

    public void clearCustomer()
    {
        setCustomer(null);
    }

    public boolean hasCustomer()
    {
        return getCustomer() != null;
    }

    public boolean hasCustomer(MyCustomer e)
    {
        return Kmu.isEqual(getCustomer(), e);
    }

    public String getCustomerName()
    {
        if ( hasCustomer() )
            return getCustomer().getName();
        return null;
    }

    public void setCustomerName(String e)
    {
        getCustomer().setName(e);
    }

    public boolean hasCustomerName()
    {
        return hasCustomer() && getCustomer().hasName();
    }

    public boolean hasCustomerName(String e)
    {
        return hasCustomer() && getCustomer().hasName(e);
    }

    //##################################################
    //# effectiveInstallContact
    //##################################################

    public abstract MySiteContact getEffectiveInstallContact();

    public boolean hasEffectiveInstallContact()
    {
        return getEffectiveInstallContact() != null;
    }

    public boolean hasEffectiveInstallContact(MySiteContact e)
    {
        return Kmu.isEqual(getEffectiveInstallContact(), e);
    }

    public String getEffectiveInstallContactFullName()
    {
        if ( hasEffectiveInstallContact() )
            return getEffectiveInstallContact().getFullName();
        return null;
    }

    public void setEffectiveInstallContactFullName(String e)
    {
        getEffectiveInstallContact().setFullName(e);
    }

    public boolean hasEffectiveInstallContactFullName()
    {
        return hasEffectiveInstallContact() && getEffectiveInstallContact().hasFullName();
    }

    public boolean hasEffectiveInstallContactFullName(String e)
    {
        return hasEffectiveInstallContact() && getEffectiveInstallContact().hasFullName(e);
    }

    public String getEffectiveInstallContactShortName()
    {
        if ( hasEffectiveInstallContact() )
            return getEffectiveInstallContact().getShortName();
        return null;
    }

    public boolean hasEffectiveInstallContactShortName()
    {
        return hasEffectiveInstallContact() && getEffectiveInstallContact().hasShortName();
    }

    public boolean hasEffectiveInstallContactShortName(String e)
    {
        return hasEffectiveInstallContact() && getEffectiveInstallContact().hasShortName(e);
    }

    public String getEffectiveInstallContactSummaryMultiline()
    {
        if ( hasEffectiveInstallContact() )
            return getEffectiveInstallContact().getSummaryMultiline();
        return null;
    }

    public boolean hasEffectiveInstallContactSummaryMultiline()
    {
        return hasEffectiveInstallContact() && getEffectiveInstallContact().hasSummaryMultiline();
    }

    public boolean hasEffectiveInstallContactSummaryMultiline(String e)
    {
        return hasEffectiveInstallContact() && getEffectiveInstallContact().hasSummaryMultiline(e);
    }

    public String getEffectiveInstallContactEmail()
    {
        if ( hasEffectiveInstallContact() )
            return getEffectiveInstallContact().getEmail();
        return null;
    }

    public void setEffectiveInstallContactEmail(String e)
    {
        getEffectiveInstallContact().setEmail(e);
    }

    public boolean hasEffectiveInstallContactEmail()
    {
        return hasEffectiveInstallContact() && getEffectiveInstallContact().hasEmail();
    }

    public boolean hasEffectiveInstallContactEmail(String e)
    {
        return hasEffectiveInstallContact() && getEffectiveInstallContact().hasEmail(e);
    }

    public String getEffectiveInstallContactPhone()
    {
        if ( hasEffectiveInstallContact() )
            return getEffectiveInstallContact().getPhone();
        return null;
    }

    public void setEffectiveInstallContactPhone(String e)
    {
        getEffectiveInstallContact().setPhone(e);
    }

    public boolean hasEffectiveInstallContactPhone()
    {
        return hasEffectiveInstallContact() && getEffectiveInstallContact().hasPhone();
    }

    public boolean hasEffectiveInstallContactPhone(String e)
    {
        return hasEffectiveInstallContact() && getEffectiveInstallContact().hasPhone(e);
    }

    //##################################################
    //# effectiveRequesterContact
    //##################################################

    public abstract MySiteContact getEffectiveRequesterContact();

    public boolean hasEffectiveRequesterContact()
    {
        return getEffectiveRequesterContact() != null;
    }

    public boolean hasEffectiveRequesterContact(MySiteContact e)
    {
        return Kmu.isEqual(getEffectiveRequesterContact(), e);
    }

    public String getEffectiveRequesterContactFullName()
    {
        if ( hasEffectiveRequesterContact() )
            return getEffectiveRequesterContact().getFullName();
        return null;
    }

    public void setEffectiveRequesterContactFullName(String e)
    {
        getEffectiveRequesterContact().setFullName(e);
    }

    public boolean hasEffectiveRequesterContactFullName()
    {
        return hasEffectiveRequesterContact() && getEffectiveRequesterContact().hasFullName();
    }

    public boolean hasEffectiveRequesterContactFullName(String e)
    {
        return hasEffectiveRequesterContact() && getEffectiveRequesterContact().hasFullName(e);
    }

    public String getEffectiveRequesterContactShortName()
    {
        if ( hasEffectiveRequesterContact() )
            return getEffectiveRequesterContact().getShortName();
        return null;
    }

    public boolean hasEffectiveRequesterContactShortName()
    {
        return hasEffectiveRequesterContact() && getEffectiveRequesterContact().hasShortName();
    }

    public boolean hasEffectiveRequesterContactShortName(String e)
    {
        return hasEffectiveRequesterContact() && getEffectiveRequesterContact().hasShortName(e);
    }

    public String getEffectiveRequesterContactSummaryMultiline()
    {
        if ( hasEffectiveRequesterContact() )
            return getEffectiveRequesterContact().getSummaryMultiline();
        return null;
    }

    public boolean hasEffectiveRequesterContactSummaryMultiline()
    {
        return hasEffectiveRequesterContact() && getEffectiveRequesterContact().hasSummaryMultiline();
    }

    public boolean hasEffectiveRequesterContactSummaryMultiline(String e)
    {
        return hasEffectiveRequesterContact() && getEffectiveRequesterContact().hasSummaryMultiline(e);
    }

    public String getEffectiveRequesterContactEmail()
    {
        if ( hasEffectiveRequesterContact() )
            return getEffectiveRequesterContact().getEmail();
        return null;
    }

    public void setEffectiveRequesterContactEmail(String e)
    {
        getEffectiveRequesterContact().setEmail(e);
    }

    public boolean hasEffectiveRequesterContactEmail()
    {
        return hasEffectiveRequesterContact() && getEffectiveRequesterContact().hasEmail();
    }

    public boolean hasEffectiveRequesterContactEmail(String e)
    {
        return hasEffectiveRequesterContact() && getEffectiveRequesterContact().hasEmail(e);
    }

    public String getEffectiveRequesterContactPhone()
    {
        if ( hasEffectiveRequesterContact() )
            return getEffectiveRequesterContact().getPhone();
        return null;
    }

    public void setEffectiveRequesterContactPhone(String e)
    {
        getEffectiveRequesterContact().setPhone(e);
    }

    public boolean hasEffectiveRequesterContactPhone()
    {
        return hasEffectiveRequesterContact() && getEffectiveRequesterContact().hasPhone();
    }

    public boolean hasEffectiveRequesterContactPhone(String e)
    {
        return hasEffectiveRequesterContact() && getEffectiveRequesterContact().hasPhone(e);
    }

    //##################################################
    //# effectiveSalesContact
    //##################################################

    public abstract MySiteContact getEffectiveSalesContact();

    public boolean hasEffectiveSalesContact()
    {
        return getEffectiveSalesContact() != null;
    }

    public boolean hasEffectiveSalesContact(MySiteContact e)
    {
        return Kmu.isEqual(getEffectiveSalesContact(), e);
    }

    public String getEffectiveSalesContactFullName()
    {
        if ( hasEffectiveSalesContact() )
            return getEffectiveSalesContact().getFullName();
        return null;
    }

    public void setEffectiveSalesContactFullName(String e)
    {
        getEffectiveSalesContact().setFullName(e);
    }

    public boolean hasEffectiveSalesContactFullName()
    {
        return hasEffectiveSalesContact() && getEffectiveSalesContact().hasFullName();
    }

    public boolean hasEffectiveSalesContactFullName(String e)
    {
        return hasEffectiveSalesContact() && getEffectiveSalesContact().hasFullName(e);
    }

    public String getEffectiveSalesContactShortName()
    {
        if ( hasEffectiveSalesContact() )
            return getEffectiveSalesContact().getShortName();
        return null;
    }

    public boolean hasEffectiveSalesContactShortName()
    {
        return hasEffectiveSalesContact() && getEffectiveSalesContact().hasShortName();
    }

    public boolean hasEffectiveSalesContactShortName(String e)
    {
        return hasEffectiveSalesContact() && getEffectiveSalesContact().hasShortName(e);
    }

    public String getEffectiveSalesContactSummaryMultiline()
    {
        if ( hasEffectiveSalesContact() )
            return getEffectiveSalesContact().getSummaryMultiline();
        return null;
    }

    public boolean hasEffectiveSalesContactSummaryMultiline()
    {
        return hasEffectiveSalesContact() && getEffectiveSalesContact().hasSummaryMultiline();
    }

    public boolean hasEffectiveSalesContactSummaryMultiline(String e)
    {
        return hasEffectiveSalesContact() && getEffectiveSalesContact().hasSummaryMultiline(e);
    }

    public String getEffectiveSalesContactEmail()
    {
        if ( hasEffectiveSalesContact() )
            return getEffectiveSalesContact().getEmail();
        return null;
    }

    public void setEffectiveSalesContactEmail(String e)
    {
        getEffectiveSalesContact().setEmail(e);
    }

    public boolean hasEffectiveSalesContactEmail()
    {
        return hasEffectiveSalesContact() && getEffectiveSalesContact().hasEmail();
    }

    public boolean hasEffectiveSalesContactEmail(String e)
    {
        return hasEffectiveSalesContact() && getEffectiveSalesContact().hasEmail(e);
    }

    public String getEffectiveSalesContactPhone()
    {
        if ( hasEffectiveSalesContact() )
            return getEffectiveSalesContact().getPhone();
        return null;
    }

    public void setEffectiveSalesContactPhone(String e)
    {
        getEffectiveSalesContact().setPhone(e);
    }

    public boolean hasEffectiveSalesContactPhone()
    {
        return hasEffectiveSalesContact() && getEffectiveSalesContact().hasPhone();
    }

    public boolean hasEffectiveSalesContactPhone(String e)
    {
        return hasEffectiveSalesContact() && getEffectiveSalesContact().hasPhone(e);
    }

    //##################################################
    //# effectiveSchedulingContact
    //##################################################

    public abstract MySiteContact getEffectiveSchedulingContact();

    public boolean hasEffectiveSchedulingContact()
    {
        return getEffectiveSchedulingContact() != null;
    }

    public boolean hasEffectiveSchedulingContact(MySiteContact e)
    {
        return Kmu.isEqual(getEffectiveSchedulingContact(), e);
    }

    public String getEffectiveSchedulingContactFullName()
    {
        if ( hasEffectiveSchedulingContact() )
            return getEffectiveSchedulingContact().getFullName();
        return null;
    }

    public void setEffectiveSchedulingContactFullName(String e)
    {
        getEffectiveSchedulingContact().setFullName(e);
    }

    public boolean hasEffectiveSchedulingContactFullName()
    {
        return hasEffectiveSchedulingContact() && getEffectiveSchedulingContact().hasFullName();
    }

    public boolean hasEffectiveSchedulingContactFullName(String e)
    {
        return hasEffectiveSchedulingContact() && getEffectiveSchedulingContact().hasFullName(e);
    }

    public String getEffectiveSchedulingContactShortName()
    {
        if ( hasEffectiveSchedulingContact() )
            return getEffectiveSchedulingContact().getShortName();
        return null;
    }

    public boolean hasEffectiveSchedulingContactShortName()
    {
        return hasEffectiveSchedulingContact() && getEffectiveSchedulingContact().hasShortName();
    }

    public boolean hasEffectiveSchedulingContactShortName(String e)
    {
        return hasEffectiveSchedulingContact() && getEffectiveSchedulingContact().hasShortName(e);
    }

    public String getEffectiveSchedulingContactSummaryMultiline()
    {
        if ( hasEffectiveSchedulingContact() )
            return getEffectiveSchedulingContact().getSummaryMultiline();
        return null;
    }

    public boolean hasEffectiveSchedulingContactSummaryMultiline()
    {
        return hasEffectiveSchedulingContact() && getEffectiveSchedulingContact().hasSummaryMultiline();
    }

    public boolean hasEffectiveSchedulingContactSummaryMultiline(String e)
    {
        return hasEffectiveSchedulingContact() && getEffectiveSchedulingContact().hasSummaryMultiline(e);
    }

    public String getEffectiveSchedulingContactEmail()
    {
        if ( hasEffectiveSchedulingContact() )
            return getEffectiveSchedulingContact().getEmail();
        return null;
    }

    public void setEffectiveSchedulingContactEmail(String e)
    {
        getEffectiveSchedulingContact().setEmail(e);
    }

    public boolean hasEffectiveSchedulingContactEmail()
    {
        return hasEffectiveSchedulingContact() && getEffectiveSchedulingContact().hasEmail();
    }

    public boolean hasEffectiveSchedulingContactEmail(String e)
    {
        return hasEffectiveSchedulingContact() && getEffectiveSchedulingContact().hasEmail(e);
    }

    public String getEffectiveSchedulingContactPhone()
    {
        if ( hasEffectiveSchedulingContact() )
            return getEffectiveSchedulingContact().getPhone();
        return null;
    }

    public void setEffectiveSchedulingContactPhone(String e)
    {
        getEffectiveSchedulingContact().setPhone(e);
    }

    public boolean hasEffectiveSchedulingContactPhone()
    {
        return hasEffectiveSchedulingContact() && getEffectiveSchedulingContact().hasPhone();
    }

    public boolean hasEffectiveSchedulingContactPhone(String e)
    {
        return hasEffectiveSchedulingContact() && getEffectiveSchedulingContact().hasPhone(e);
    }

    //##################################################
    //# effectiveTechnicalContact
    //##################################################

    public abstract MySiteContact getEffectiveTechnicalContact();

    public boolean hasEffectiveTechnicalContact()
    {
        return getEffectiveTechnicalContact() != null;
    }

    public boolean hasEffectiveTechnicalContact(MySiteContact e)
    {
        return Kmu.isEqual(getEffectiveTechnicalContact(), e);
    }

    public String getEffectiveTechnicalContactFullName()
    {
        if ( hasEffectiveTechnicalContact() )
            return getEffectiveTechnicalContact().getFullName();
        return null;
    }

    public void setEffectiveTechnicalContactFullName(String e)
    {
        getEffectiveTechnicalContact().setFullName(e);
    }

    public boolean hasEffectiveTechnicalContactFullName()
    {
        return hasEffectiveTechnicalContact() && getEffectiveTechnicalContact().hasFullName();
    }

    public boolean hasEffectiveTechnicalContactFullName(String e)
    {
        return hasEffectiveTechnicalContact() && getEffectiveTechnicalContact().hasFullName(e);
    }

    public String getEffectiveTechnicalContactShortName()
    {
        if ( hasEffectiveTechnicalContact() )
            return getEffectiveTechnicalContact().getShortName();
        return null;
    }

    public boolean hasEffectiveTechnicalContactShortName()
    {
        return hasEffectiveTechnicalContact() && getEffectiveTechnicalContact().hasShortName();
    }

    public boolean hasEffectiveTechnicalContactShortName(String e)
    {
        return hasEffectiveTechnicalContact() && getEffectiveTechnicalContact().hasShortName(e);
    }

    public String getEffectiveTechnicalContactSummaryMultiline()
    {
        if ( hasEffectiveTechnicalContact() )
            return getEffectiveTechnicalContact().getSummaryMultiline();
        return null;
    }

    public boolean hasEffectiveTechnicalContactSummaryMultiline()
    {
        return hasEffectiveTechnicalContact() && getEffectiveTechnicalContact().hasSummaryMultiline();
    }

    public boolean hasEffectiveTechnicalContactSummaryMultiline(String e)
    {
        return hasEffectiveTechnicalContact() && getEffectiveTechnicalContact().hasSummaryMultiline(e);
    }

    public String getEffectiveTechnicalContactEmail()
    {
        if ( hasEffectiveTechnicalContact() )
            return getEffectiveTechnicalContact().getEmail();
        return null;
    }

    public void setEffectiveTechnicalContactEmail(String e)
    {
        getEffectiveTechnicalContact().setEmail(e);
    }

    public boolean hasEffectiveTechnicalContactEmail()
    {
        return hasEffectiveTechnicalContact() && getEffectiveTechnicalContact().hasEmail();
    }

    public boolean hasEffectiveTechnicalContactEmail(String e)
    {
        return hasEffectiveTechnicalContact() && getEffectiveTechnicalContact().hasEmail(e);
    }

    public String getEffectiveTechnicalContactPhone()
    {
        if ( hasEffectiveTechnicalContact() )
            return getEffectiveTechnicalContact().getPhone();
        return null;
    }

    public void setEffectiveTechnicalContactPhone(String e)
    {
        getEffectiveTechnicalContact().setPhone(e);
    }

    public boolean hasEffectiveTechnicalContactPhone()
    {
        return hasEffectiveTechnicalContact() && getEffectiveTechnicalContact().hasPhone();
    }

    public boolean hasEffectiveTechnicalContactPhone(String e)
    {
        return hasEffectiveTechnicalContact() && getEffectiveTechnicalContact().hasPhone(e);
    }

    //##################################################
    //# installContact
    //##################################################

    public MySiteContact getInstallContact()
    {
        return installContact;
    }

    public void setInstallContact(MySiteContact e)
    {
        installContact = e;
    }

    public void _setInstallContact(MySiteContact e)
    {
        installContact = e;
    }

    public void clearInstallContact()
    {
        setInstallContact(null);
    }

    public boolean hasInstallContact()
    {
        return getInstallContact() != null;
    }

    public boolean hasInstallContact(MySiteContact e)
    {
        return Kmu.isEqual(getInstallContact(), e);
    }

    public String getInstallContactFullName()
    {
        if ( hasInstallContact() )
            return getInstallContact().getFullName();
        return null;
    }

    public void setInstallContactFullName(String e)
    {
        getInstallContact().setFullName(e);
    }

    public boolean hasInstallContactFullName()
    {
        return hasInstallContact() && getInstallContact().hasFullName();
    }

    public boolean hasInstallContactFullName(String e)
    {
        return hasInstallContact() && getInstallContact().hasFullName(e);
    }

    public String getInstallContactShortName()
    {
        if ( hasInstallContact() )
            return getInstallContact().getShortName();
        return null;
    }

    public boolean hasInstallContactShortName()
    {
        return hasInstallContact() && getInstallContact().hasShortName();
    }

    public boolean hasInstallContactShortName(String e)
    {
        return hasInstallContact() && getInstallContact().hasShortName(e);
    }

    public String getInstallContactSummaryMultiline()
    {
        if ( hasInstallContact() )
            return getInstallContact().getSummaryMultiline();
        return null;
    }

    public boolean hasInstallContactSummaryMultiline()
    {
        return hasInstallContact() && getInstallContact().hasSummaryMultiline();
    }

    public boolean hasInstallContactSummaryMultiline(String e)
    {
        return hasInstallContact() && getInstallContact().hasSummaryMultiline(e);
    }

    public String getInstallContactEmail()
    {
        if ( hasInstallContact() )
            return getInstallContact().getEmail();
        return null;
    }

    public void setInstallContactEmail(String e)
    {
        getInstallContact().setEmail(e);
    }

    public boolean hasInstallContactEmail()
    {
        return hasInstallContact() && getInstallContact().hasEmail();
    }

    public boolean hasInstallContactEmail(String e)
    {
        return hasInstallContact() && getInstallContact().hasEmail(e);
    }

    public String getInstallContactPhone()
    {
        if ( hasInstallContact() )
            return getInstallContact().getPhone();
        return null;
    }

    public void setInstallContactPhone(String e)
    {
        getInstallContact().setPhone(e);
    }

    public boolean hasInstallContactPhone()
    {
        return hasInstallContact() && getInstallContact().hasPhone();
    }

    public boolean hasInstallContactPhone(String e)
    {
        return hasInstallContact() && getInstallContact().hasPhone(e);
    }

    //##################################################
    //# mainContact
    //##################################################

    public MySiteContact getMainContact()
    {
        return mainContact;
    }

    public void setMainContact(MySiteContact e)
    {
        mainContact = e;
    }

    public void _setMainContact(MySiteContact e)
    {
        mainContact = e;
    }

    public void clearMainContact()
    {
        setMainContact(null);
    }

    public boolean hasMainContact()
    {
        return getMainContact() != null;
    }

    public boolean hasMainContact(MySiteContact e)
    {
        return Kmu.isEqual(getMainContact(), e);
    }

    public String getMainContactFullName()
    {
        if ( hasMainContact() )
            return getMainContact().getFullName();
        return null;
    }

    public void setMainContactFullName(String e)
    {
        getMainContact().setFullName(e);
    }

    public boolean hasMainContactFullName()
    {
        return hasMainContact() && getMainContact().hasFullName();
    }

    public boolean hasMainContactFullName(String e)
    {
        return hasMainContact() && getMainContact().hasFullName(e);
    }

    public String getMainContactShortName()
    {
        if ( hasMainContact() )
            return getMainContact().getShortName();
        return null;
    }

    public boolean hasMainContactShortName()
    {
        return hasMainContact() && getMainContact().hasShortName();
    }

    public boolean hasMainContactShortName(String e)
    {
        return hasMainContact() && getMainContact().hasShortName(e);
    }

    public String getMainContactSummaryMultiline()
    {
        if ( hasMainContact() )
            return getMainContact().getSummaryMultiline();
        return null;
    }

    public boolean hasMainContactSummaryMultiline()
    {
        return hasMainContact() && getMainContact().hasSummaryMultiline();
    }

    public boolean hasMainContactSummaryMultiline(String e)
    {
        return hasMainContact() && getMainContact().hasSummaryMultiline(e);
    }

    public String getMainContactEmail()
    {
        if ( hasMainContact() )
            return getMainContact().getEmail();
        return null;
    }

    public void setMainContactEmail(String e)
    {
        getMainContact().setEmail(e);
    }

    public boolean hasMainContactEmail()
    {
        return hasMainContact() && getMainContact().hasEmail();
    }

    public boolean hasMainContactEmail(String e)
    {
        return hasMainContact() && getMainContact().hasEmail(e);
    }

    public String getMainContactPhone()
    {
        if ( hasMainContact() )
            return getMainContact().getPhone();
        return null;
    }

    public void setMainContactPhone(String e)
    {
        getMainContact().setPhone(e);
    }

    public boolean hasMainContactPhone()
    {
        return hasMainContact() && getMainContact().hasPhone();
    }

    public boolean hasMainContactPhone(String e)
    {
        return hasMainContact() && getMainContact().hasPhone(e);
    }

    //##################################################
    //# priority
    //##################################################

    public MyPriority getPriority()
    {
        return priority;
    }

    public void setPriority(MyPriority e)
    {
        priority = e;
    }

    public void _setPriority(MyPriority e)
    {
        priority = e;
    }

    public void clearPriority()
    {
        setPriority(null);
    }

    public boolean hasPriority()
    {
        return getPriority() != null;
    }

    public boolean hasPriority(MyPriority e)
    {
        return Kmu.isEqual(getPriority(), e);
    }

    //##################################################
    //# requesterContact
    //##################################################

    public MySiteContact getRequesterContact()
    {
        return requesterContact;
    }

    public void setRequesterContact(MySiteContact e)
    {
        requesterContact = e;
    }

    public void _setRequesterContact(MySiteContact e)
    {
        requesterContact = e;
    }

    public void clearRequesterContact()
    {
        setRequesterContact(null);
    }

    public boolean hasRequesterContact()
    {
        return getRequesterContact() != null;
    }

    public boolean hasRequesterContact(MySiteContact e)
    {
        return Kmu.isEqual(getRequesterContact(), e);
    }

    public String getRequesterContactFullName()
    {
        if ( hasRequesterContact() )
            return getRequesterContact().getFullName();
        return null;
    }

    public void setRequesterContactFullName(String e)
    {
        getRequesterContact().setFullName(e);
    }

    public boolean hasRequesterContactFullName()
    {
        return hasRequesterContact() && getRequesterContact().hasFullName();
    }

    public boolean hasRequesterContactFullName(String e)
    {
        return hasRequesterContact() && getRequesterContact().hasFullName(e);
    }

    public String getRequesterContactShortName()
    {
        if ( hasRequesterContact() )
            return getRequesterContact().getShortName();
        return null;
    }

    public boolean hasRequesterContactShortName()
    {
        return hasRequesterContact() && getRequesterContact().hasShortName();
    }

    public boolean hasRequesterContactShortName(String e)
    {
        return hasRequesterContact() && getRequesterContact().hasShortName(e);
    }

    public String getRequesterContactSummaryMultiline()
    {
        if ( hasRequesterContact() )
            return getRequesterContact().getSummaryMultiline();
        return null;
    }

    public boolean hasRequesterContactSummaryMultiline()
    {
        return hasRequesterContact() && getRequesterContact().hasSummaryMultiline();
    }

    public boolean hasRequesterContactSummaryMultiline(String e)
    {
        return hasRequesterContact() && getRequesterContact().hasSummaryMultiline(e);
    }

    public String getRequesterContactEmail()
    {
        if ( hasRequesterContact() )
            return getRequesterContact().getEmail();
        return null;
    }

    public void setRequesterContactEmail(String e)
    {
        getRequesterContact().setEmail(e);
    }

    public boolean hasRequesterContactEmail()
    {
        return hasRequesterContact() && getRequesterContact().hasEmail();
    }

    public boolean hasRequesterContactEmail(String e)
    {
        return hasRequesterContact() && getRequesterContact().hasEmail(e);
    }

    public String getRequesterContactPhone()
    {
        if ( hasRequesterContact() )
            return getRequesterContact().getPhone();
        return null;
    }

    public void setRequesterContactPhone(String e)
    {
        getRequesterContact().setPhone(e);
    }

    public boolean hasRequesterContactPhone()
    {
        return hasRequesterContact() && getRequesterContact().hasPhone();
    }

    public boolean hasRequesterContactPhone(String e)
    {
        return hasRequesterContact() && getRequesterContact().hasPhone(e);
    }

    //##################################################
    //# salesContact
    //##################################################

    public MySiteContact getSalesContact()
    {
        return salesContact;
    }

    public void setSalesContact(MySiteContact e)
    {
        salesContact = e;
    }

    public void _setSalesContact(MySiteContact e)
    {
        salesContact = e;
    }

    public void clearSalesContact()
    {
        setSalesContact(null);
    }

    public boolean hasSalesContact()
    {
        return getSalesContact() != null;
    }

    public boolean hasSalesContact(MySiteContact e)
    {
        return Kmu.isEqual(getSalesContact(), e);
    }

    public String getSalesContactFullName()
    {
        if ( hasSalesContact() )
            return getSalesContact().getFullName();
        return null;
    }

    public void setSalesContactFullName(String e)
    {
        getSalesContact().setFullName(e);
    }

    public boolean hasSalesContactFullName()
    {
        return hasSalesContact() && getSalesContact().hasFullName();
    }

    public boolean hasSalesContactFullName(String e)
    {
        return hasSalesContact() && getSalesContact().hasFullName(e);
    }

    public String getSalesContactShortName()
    {
        if ( hasSalesContact() )
            return getSalesContact().getShortName();
        return null;
    }

    public boolean hasSalesContactShortName()
    {
        return hasSalesContact() && getSalesContact().hasShortName();
    }

    public boolean hasSalesContactShortName(String e)
    {
        return hasSalesContact() && getSalesContact().hasShortName(e);
    }

    public String getSalesContactSummaryMultiline()
    {
        if ( hasSalesContact() )
            return getSalesContact().getSummaryMultiline();
        return null;
    }

    public boolean hasSalesContactSummaryMultiline()
    {
        return hasSalesContact() && getSalesContact().hasSummaryMultiline();
    }

    public boolean hasSalesContactSummaryMultiline(String e)
    {
        return hasSalesContact() && getSalesContact().hasSummaryMultiline(e);
    }

    public String getSalesContactEmail()
    {
        if ( hasSalesContact() )
            return getSalesContact().getEmail();
        return null;
    }

    public void setSalesContactEmail(String e)
    {
        getSalesContact().setEmail(e);
    }

    public boolean hasSalesContactEmail()
    {
        return hasSalesContact() && getSalesContact().hasEmail();
    }

    public boolean hasSalesContactEmail(String e)
    {
        return hasSalesContact() && getSalesContact().hasEmail(e);
    }

    public String getSalesContactPhone()
    {
        if ( hasSalesContact() )
            return getSalesContact().getPhone();
        return null;
    }

    public void setSalesContactPhone(String e)
    {
        getSalesContact().setPhone(e);
    }

    public boolean hasSalesContactPhone()
    {
        return hasSalesContact() && getSalesContact().hasPhone();
    }

    public boolean hasSalesContactPhone(String e)
    {
        return hasSalesContact() && getSalesContact().hasPhone(e);
    }

    //##################################################
    //# schedulingContact
    //##################################################

    public MySiteContact getSchedulingContact()
    {
        return schedulingContact;
    }

    public void setSchedulingContact(MySiteContact e)
    {
        schedulingContact = e;
    }

    public void _setSchedulingContact(MySiteContact e)
    {
        schedulingContact = e;
    }

    public void clearSchedulingContact()
    {
        setSchedulingContact(null);
    }

    public boolean hasSchedulingContact()
    {
        return getSchedulingContact() != null;
    }

    public boolean hasSchedulingContact(MySiteContact e)
    {
        return Kmu.isEqual(getSchedulingContact(), e);
    }

    public String getSchedulingContactFullName()
    {
        if ( hasSchedulingContact() )
            return getSchedulingContact().getFullName();
        return null;
    }

    public void setSchedulingContactFullName(String e)
    {
        getSchedulingContact().setFullName(e);
    }

    public boolean hasSchedulingContactFullName()
    {
        return hasSchedulingContact() && getSchedulingContact().hasFullName();
    }

    public boolean hasSchedulingContactFullName(String e)
    {
        return hasSchedulingContact() && getSchedulingContact().hasFullName(e);
    }

    public String getSchedulingContactShortName()
    {
        if ( hasSchedulingContact() )
            return getSchedulingContact().getShortName();
        return null;
    }

    public boolean hasSchedulingContactShortName()
    {
        return hasSchedulingContact() && getSchedulingContact().hasShortName();
    }

    public boolean hasSchedulingContactShortName(String e)
    {
        return hasSchedulingContact() && getSchedulingContact().hasShortName(e);
    }

    public String getSchedulingContactSummaryMultiline()
    {
        if ( hasSchedulingContact() )
            return getSchedulingContact().getSummaryMultiline();
        return null;
    }

    public boolean hasSchedulingContactSummaryMultiline()
    {
        return hasSchedulingContact() && getSchedulingContact().hasSummaryMultiline();
    }

    public boolean hasSchedulingContactSummaryMultiline(String e)
    {
        return hasSchedulingContact() && getSchedulingContact().hasSummaryMultiline(e);
    }

    public String getSchedulingContactEmail()
    {
        if ( hasSchedulingContact() )
            return getSchedulingContact().getEmail();
        return null;
    }

    public void setSchedulingContactEmail(String e)
    {
        getSchedulingContact().setEmail(e);
    }

    public boolean hasSchedulingContactEmail()
    {
        return hasSchedulingContact() && getSchedulingContact().hasEmail();
    }

    public boolean hasSchedulingContactEmail(String e)
    {
        return hasSchedulingContact() && getSchedulingContact().hasEmail(e);
    }

    public String getSchedulingContactPhone()
    {
        if ( hasSchedulingContact() )
            return getSchedulingContact().getPhone();
        return null;
    }

    public void setSchedulingContactPhone(String e)
    {
        getSchedulingContact().setPhone(e);
    }

    public boolean hasSchedulingContactPhone()
    {
        return hasSchedulingContact() && getSchedulingContact().hasPhone();
    }

    public boolean hasSchedulingContactPhone(String e)
    {
        return hasSchedulingContact() && getSchedulingContact().hasPhone(e);
    }

    //##################################################
    //# technicalContact
    //##################################################

    public MySiteContact getTechnicalContact()
    {
        return technicalContact;
    }

    public void setTechnicalContact(MySiteContact e)
    {
        technicalContact = e;
    }

    public void _setTechnicalContact(MySiteContact e)
    {
        technicalContact = e;
    }

    public void clearTechnicalContact()
    {
        setTechnicalContact(null);
    }

    public boolean hasTechnicalContact()
    {
        return getTechnicalContact() != null;
    }

    public boolean hasTechnicalContact(MySiteContact e)
    {
        return Kmu.isEqual(getTechnicalContact(), e);
    }

    public String getTechnicalContactFullName()
    {
        if ( hasTechnicalContact() )
            return getTechnicalContact().getFullName();
        return null;
    }

    public void setTechnicalContactFullName(String e)
    {
        getTechnicalContact().setFullName(e);
    }

    public boolean hasTechnicalContactFullName()
    {
        return hasTechnicalContact() && getTechnicalContact().hasFullName();
    }

    public boolean hasTechnicalContactFullName(String e)
    {
        return hasTechnicalContact() && getTechnicalContact().hasFullName(e);
    }

    public String getTechnicalContactShortName()
    {
        if ( hasTechnicalContact() )
            return getTechnicalContact().getShortName();
        return null;
    }

    public boolean hasTechnicalContactShortName()
    {
        return hasTechnicalContact() && getTechnicalContact().hasShortName();
    }

    public boolean hasTechnicalContactShortName(String e)
    {
        return hasTechnicalContact() && getTechnicalContact().hasShortName(e);
    }

    public String getTechnicalContactSummaryMultiline()
    {
        if ( hasTechnicalContact() )
            return getTechnicalContact().getSummaryMultiline();
        return null;
    }

    public boolean hasTechnicalContactSummaryMultiline()
    {
        return hasTechnicalContact() && getTechnicalContact().hasSummaryMultiline();
    }

    public boolean hasTechnicalContactSummaryMultiline(String e)
    {
        return hasTechnicalContact() && getTechnicalContact().hasSummaryMultiline(e);
    }

    public String getTechnicalContactEmail()
    {
        if ( hasTechnicalContact() )
            return getTechnicalContact().getEmail();
        return null;
    }

    public void setTechnicalContactEmail(String e)
    {
        getTechnicalContact().setEmail(e);
    }

    public boolean hasTechnicalContactEmail()
    {
        return hasTechnicalContact() && getTechnicalContact().hasEmail();
    }

    public boolean hasTechnicalContactEmail(String e)
    {
        return hasTechnicalContact() && getTechnicalContact().hasEmail(e);
    }

    public String getTechnicalContactPhone()
    {
        if ( hasTechnicalContact() )
            return getTechnicalContact().getPhone();
        return null;
    }

    public void setTechnicalContactPhone(String e)
    {
        getTechnicalContact().setPhone(e);
    }

    public boolean hasTechnicalContactPhone()
    {
        return hasTechnicalContact() && getTechnicalContact().hasPhone();
    }

    public boolean hasTechnicalContactPhone(String e)
    {
        return hasTechnicalContact() && getTechnicalContact().hasPhone(e);
    }

    //##################################################
    //# type
    //##################################################

    public MyChoice getType()
    {
        return type;
    }

    public void setType(MyChoice e)
    {
        type = e;
    }

    public void _setType(MyChoice e)
    {
        type = e;
    }

    public void clearType()
    {
        setType(null);
    }

    public boolean hasType()
    {
        return getType() != null;
    }

    public boolean hasType(MyChoice e)
    {
        return Kmu.isEqual(getType(), e);
    }

    public String getTypeName()
    {
        if ( hasType() )
            return getType().getName();
        return null;
    }

    public void setTypeName(String e)
    {
        getType().setName(e);
    }

    public boolean hasTypeName()
    {
        return hasType() && getType().hasName();
    }

    public boolean hasTypeName(String e)
    {
        return hasType() && getType().hasName(e);
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
    //# Contacts (collection)
    //##################################################

    public KmCollection<MySiteContact> getContacts()
    {
        return new KmHibernateCollection<>(
            getBaseContacts(),
            (MySite)this,
            MySiteContact.Meta.Site);
    }

    public boolean hasContacts()
    {
        return !getBaseContacts().isEmpty();
    }

    public int getContactCount()
    {
        return getBaseContacts().size();
    }

    public List<MySiteContact> getBaseContacts()
    {
        return contacts;
    }

    public MySiteContact addContact()
    {
        MySiteContact e;
        e = new MySiteContact();
        getContacts().add(e);
        return e;
    }

    public void addContact(MySiteContact e)
    {
        getContacts().add(e);
    }

    public boolean removeContact(MySiteContact e)
    {
        return getContacts().remove(e);
    }

    public boolean removeContactUid(String myUid)
    {
        MySiteContact e = findContactUid(myUid);
        if ( e == null )
            return false;

        return removeContact(e);
    }

    public MySiteContact findContactUid(String myUid)
    {
        for ( MySiteContact e : getBaseContacts() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearContacts()
    {
        getContacts().clear();
    }

    //##################################################
    //# on change
    //##################################################

    protected abstract void updateFullName();

    //##################################################
    //# validate
    //##################################################

    @Override
    protected final MySiteValidator getValidator()
    {
        return Validator;
    }

    @Override
    protected final MySite asSubclass()
    {
        return (MySite)this;
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MySite getCopy()
    {
        return (MySite)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = newUid();

        List<MySiteContact> old_contacts = contacts;
        contacts = new ArrayList<>();
        for ( MySiteContact e : old_contacts )
            addContact(copy(e));
    }

    /**
     * Get a copy of this model without any associations or collections.
     * The primary key and lock version are not copied.
     * The basic timestamps are reset.
     */
    public final MySite getBasicCopy()
    {
        MySite e;
        e = new MySite();
        applyEditableFieldsTo(e);
        resetBasicTimestamps();
        return e;
    }

    /**
     * Apply the editable fields TO another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsTo(MySite e)
    {
        e.setAddressAttention(getAddressAttention());
        e.setAddressCity(getAddressCity());
        e.setAddressCountry(getAddressCountry());
        e.setAddressPhone(getAddressPhone());
        e.setAddressPostalCode(getAddressPostalCode());
        e.setAddressRegion(getAddressRegion());
        e.setAddressStreet1(getAddressStreet1());
        e.setAddressStreet2(getAddressStreet2());
        e.setCreatedUtcTs(getCreatedUtcTs());
        e.setEnabled(getEnabled());
        e.setFullName(getFullName());
        e.setName(getName());
        e.setNumber(getNumber());
        e.setTimeZoneCode(getTimeZoneCode());
        e.setUpdatedUtcTs(getUpdatedUtcTs());
    }

    /**
     * Apply the editable fields FROM another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsFrom(MySite e)
    {
        setAddressAttention(e.getAddressAttention());
        setAddressCity(e.getAddressCity());
        setAddressCountry(e.getAddressCountry());
        setAddressPhone(e.getAddressPhone());
        setAddressPostalCode(e.getAddressPostalCode());
        setAddressRegion(e.getAddressRegion());
        setAddressStreet1(e.getAddressStreet1());
        setAddressStreet2(e.getAddressStreet2());
        setCreatedUtcTs(e.getCreatedUtcTs());
        setEnabled(e.getEnabled());
        setFullName(e.getFullName());
        setName(e.getName());
        setNumber(e.getNumber());
        setTimeZoneCode(e.getTimeZoneCode());
        setUpdatedUtcTs(e.getUpdatedUtcTs());
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MySiteBase) )
            return false;

        MySiteBase e = (MySiteBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MySite e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MySite e)
    {
        if ( !Kmu.isEqual(getAddressAttention(), e.getAddressAttention()) ) return false;
        if ( !Kmu.isEqual(getAddressCity(), e.getAddressCity()) ) return false;
        if ( !Kmu.isEqual(getAddressCountry(), e.getAddressCountry()) ) return false;
        if ( !Kmu.isEqual(getAddressLongLine(), e.getAddressLongLine()) ) return false;
        if ( !Kmu.isEqual(getAddressMultiLine(), e.getAddressMultiLine()) ) return false;
        if ( !Kmu.isEqual(getAddressPhone(), e.getAddressPhone()) ) return false;
        if ( !Kmu.isEqual(getAddressPostalCode(), e.getAddressPostalCode()) ) return false;
        if ( !Kmu.isEqual(getAddressRegion(), e.getAddressRegion()) ) return false;
        if ( !Kmu.isEqual(getAddressShortLine(), e.getAddressShortLine()) ) return false;
        if ( !Kmu.isEqual(getAddressStreet1(), e.getAddressStreet1()) ) return false;
        if ( !Kmu.isEqual(getAddressStreet2(), e.getAddressStreet2()) ) return false;
        if ( !Kmu.isEqual(getAuditLogTitle(), e.getAuditLogTitle()) ) return false;
        if ( !Kmu.isEqual(getCreatedUtcTs(), e.getCreatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getDomainSubtitle(), e.getDomainSubtitle()) ) return false;
        if ( !Kmu.isEqual(getDomainTitle(), e.getDomainTitle()) ) return false;
        if ( !Kmu.isEqual(getEnabled(), e.getEnabled()) ) return false;
        if ( !Kmu.isEqual(getEnabledStatus(), e.getEnabledStatus()) ) return false;
        if ( !Kmu.isEqual(getFullName(), e.getFullName()) ) return false;
        if ( !Kmu.isEqual(getName(), e.getName()) ) return false;
        if ( !Kmu.isEqual(getNumber(), e.getNumber()) ) return false;
        if ( !Kmu.isEqual(getPriorityName(), e.getPriorityName()) ) return false;
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

    public boolean isDifferent(MySite e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MySite e)
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
        out.append("MySite");
        out.append("(");
        out.append("Uid=");
        out.append(uid);
        out.append(")");
        return out.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    AddressAttention = " + addressAttention);
        System.out.println("    AddressCity = " + addressCity);
        System.out.println("    AddressCountry = " + addressCountry);
        System.out.println("    AddressPhone = " + addressPhone);
        System.out.println("    AddressPostalCode = " + addressPostalCode);
        System.out.println("    AddressRegion = " + addressRegion);
        System.out.println("    AddressStreet1 = " + addressStreet1);
        System.out.println("    AddressStreet2 = " + addressStreet2);
        System.out.println("    CreatedUtcTs = " + createdUtcTs);
        System.out.println("    Enabled = " + enabled);
        System.out.println("    FullName = " + fullName);
        System.out.println("    Name = " + name);
        System.out.println("    Number = " + number);
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
