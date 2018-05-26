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
public abstract class MyCustomerBase
    extends MyAbstractDaoDomain<MyCustomer>
    implements KmUidDomainIF
    ,MyBasicTimestampsIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaCustomer Meta = MyMetaCustomer.instance;
    public static final MyCustomerTools Tools = MyCustomerTools.instance;
    public static final MyCustomerValidator Validator = MyCustomerValidator.instance;
    public static final MyCustomerFinder Finder = MyCustomerFinder.instance;

    //##################################################
    //# variables
    //##################################################

    private String billingAttention;
    private String billingCity;
    private String billingCountry;
    private String billingPhone;
    private String billingPostalCode;
    private String billingRegion;
    private String billingStreet1;
    private String billingStreet2;
    private KmTimestamp createdUtcTs;
    private Boolean enabled;
    private String name;
    private String uid;
    private KmTimestamp updatedUtcTs;
    private Integer lockVersion;
    private MyCustomerContact approvalContact;
    private MyCustomerContact billingContact;
    private MyUser createdBy;
    private MyProject project;
    private MyUser updatedBy;
    private List<MyCustomerContact> contacts;

    //##################################################
    //# constructor
    //##################################################

    public MyCustomerBase()
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
    //# field (billingAddressLongLine)
    //##################################################

    public abstract String getBillingAddressLongLine();

    public boolean hasBillingAddressLongLine()
    {
        return Kmu.hasValue(getBillingAddressLongLine());
    }

    public boolean hasBillingAddressLongLine(String e)
    {
        return Kmu.isEqualIgnoreCase(getBillingAddressLongLine(), e);
    }

    //##################################################
    //# field (billingAddressMultiLine)
    //##################################################

    public abstract String getBillingAddressMultiLine();

    public boolean hasBillingAddressMultiLine()
    {
        return Kmu.hasValue(getBillingAddressMultiLine());
    }

    public boolean hasBillingAddressMultiLine(String e)
    {
        return Kmu.isEqualIgnoreCase(getBillingAddressMultiLine(), e);
    }

    //##################################################
    //# field (billingAddressMultiLineHtml)
    //##################################################

    public abstract String getBillingAddressMultiLineHtml();

    public boolean hasBillingAddressMultiLineHtml()
    {
        return Kmu.hasValue(getBillingAddressMultiLineHtml());
    }

    public boolean hasBillingAddressMultiLineHtml(String e)
    {
        return Kmu.isEqualIgnoreCase(getBillingAddressMultiLineHtml(), e);
    }

    //##################################################
    //# field (billingAddressShortLine)
    //##################################################

    public abstract String getBillingAddressShortLine();

    public boolean hasBillingAddressShortLine()
    {
        return Kmu.hasValue(getBillingAddressShortLine());
    }

    public boolean hasBillingAddressShortLine(String e)
    {
        return Kmu.isEqualIgnoreCase(getBillingAddressShortLine(), e);
    }

    //##################################################
    //# field (billingAttention)
    //##################################################

    public String getBillingAttention()
    {
        return billingAttention;
    }

    public void setBillingAttention(String e)
    {
        e = Validator.getBillingAttentionValidator().convert(e);
        billingAttention = e;
    }

    public void clearBillingAttention()
    {
        setBillingAttention(null);
    }

    public boolean hasBillingAttention()
    {
        return Kmu.hasValue(getBillingAttention());
    }

    public boolean hasBillingAttention(String e)
    {
        return Kmu.isEqualIgnoreCase(getBillingAttention(), e);
    }

    public void truncateBillingAttention()
    {
        truncateBillingAttention(false);
    }

    public void truncateBillingAttention(boolean ellipses)
    {
        billingAttention = Kmu.truncate(billingAttention, 50, ellipses);
    }

    //##################################################
    //# field (billingCity)
    //##################################################

    public String getBillingCity()
    {
        return billingCity;
    }

    public void setBillingCity(String e)
    {
        e = Validator.getBillingCityValidator().convert(e);
        billingCity = e;
    }

    public void clearBillingCity()
    {
        setBillingCity(null);
    }

    public boolean hasBillingCity()
    {
        return Kmu.hasValue(getBillingCity());
    }

    public boolean hasBillingCity(String e)
    {
        return Kmu.isEqualIgnoreCase(getBillingCity(), e);
    }

    public void truncateBillingCity()
    {
        truncateBillingCity(false);
    }

    public void truncateBillingCity(boolean ellipses)
    {
        billingCity = Kmu.truncate(billingCity, 50, ellipses);
    }

    //##################################################
    //# field (billingCountry)
    //##################################################

    public String getBillingCountry()
    {
        return billingCountry;
    }

    public void setBillingCountry(String e)
    {
        e = Validator.getBillingCountryValidator().convert(e);
        billingCountry = e;
    }

    public void clearBillingCountry()
    {
        setBillingCountry(null);
    }

    public boolean hasBillingCountry()
    {
        return Kmu.hasValue(getBillingCountry());
    }

    public boolean hasBillingCountry(String e)
    {
        return Kmu.isEqualIgnoreCase(getBillingCountry(), e);
    }

    public void truncateBillingCountry()
    {
        truncateBillingCountry(false);
    }

    public void truncateBillingCountry(boolean ellipses)
    {
        billingCountry = Kmu.truncate(billingCountry, 50, ellipses);
    }

    //##################################################
    //# field (billingPhone)
    //##################################################

    public String getBillingPhone()
    {
        return billingPhone;
    }

    public void setBillingPhone(String e)
    {
        e = Validator.getBillingPhoneValidator().convert(e);
        billingPhone = e;
    }

    public void clearBillingPhone()
    {
        setBillingPhone(null);
    }

    public boolean hasBillingPhone()
    {
        return Kmu.hasValue(getBillingPhone());
    }

    public boolean hasBillingPhone(String e)
    {
        return Kmu.isEqualIgnoreCase(getBillingPhone(), e);
    }

    public void truncateBillingPhone()
    {
        truncateBillingPhone(false);
    }

    public void truncateBillingPhone(boolean ellipses)
    {
        billingPhone = Kmu.truncate(billingPhone, 30, ellipses);
    }

    //##################################################
    //# field (billingPostalCode)
    //##################################################

    public String getBillingPostalCode()
    {
        return billingPostalCode;
    }

    public void setBillingPostalCode(String e)
    {
        e = Validator.getBillingPostalCodeValidator().convert(e);
        billingPostalCode = e;
    }

    public void clearBillingPostalCode()
    {
        setBillingPostalCode(null);
    }

    public boolean hasBillingPostalCode()
    {
        return Kmu.hasValue(getBillingPostalCode());
    }

    public boolean hasBillingPostalCode(String e)
    {
        return Kmu.isEqualIgnoreCase(getBillingPostalCode(), e);
    }

    public void truncateBillingPostalCode()
    {
        truncateBillingPostalCode(false);
    }

    public void truncateBillingPostalCode(boolean ellipses)
    {
        billingPostalCode = Kmu.truncate(billingPostalCode, 20, ellipses);
    }

    //##################################################
    //# field (billingRegion)
    //##################################################

    public String getBillingRegion()
    {
        return billingRegion;
    }

    public void setBillingRegion(String e)
    {
        e = Validator.getBillingRegionValidator().convert(e);
        billingRegion = e;
    }

    public void clearBillingRegion()
    {
        setBillingRegion(null);
    }

    public boolean hasBillingRegion()
    {
        return Kmu.hasValue(getBillingRegion());
    }

    public boolean hasBillingRegion(String e)
    {
        return Kmu.isEqualIgnoreCase(getBillingRegion(), e);
    }

    public void truncateBillingRegion()
    {
        truncateBillingRegion(false);
    }

    public void truncateBillingRegion(boolean ellipses)
    {
        billingRegion = Kmu.truncate(billingRegion, 50, ellipses);
    }

    //##################################################
    //# field (billingStreet1)
    //##################################################

    public String getBillingStreet1()
    {
        return billingStreet1;
    }

    public void setBillingStreet1(String e)
    {
        e = Validator.getBillingStreet1Validator().convert(e);
        billingStreet1 = e;
    }

    public void clearBillingStreet1()
    {
        setBillingStreet1(null);
    }

    public boolean hasBillingStreet1()
    {
        return Kmu.hasValue(getBillingStreet1());
    }

    public boolean hasBillingStreet1(String e)
    {
        return Kmu.isEqualIgnoreCase(getBillingStreet1(), e);
    }

    public void truncateBillingStreet1()
    {
        truncateBillingStreet1(false);
    }

    public void truncateBillingStreet1(boolean ellipses)
    {
        billingStreet1 = Kmu.truncate(billingStreet1, 100, ellipses);
    }

    //##################################################
    //# field (billingStreet2)
    //##################################################

    public String getBillingStreet2()
    {
        return billingStreet2;
    }

    public void setBillingStreet2(String e)
    {
        e = Validator.getBillingStreet2Validator().convert(e);
        billingStreet2 = e;
    }

    public void clearBillingStreet2()
    {
        setBillingStreet2(null);
    }

    public boolean hasBillingStreet2()
    {
        return Kmu.hasValue(getBillingStreet2());
    }

    public boolean hasBillingStreet2(String e)
    {
        return Kmu.isEqualIgnoreCase(getBillingStreet2(), e);
    }

    public void truncateBillingStreet2()
    {
        truncateBillingStreet2(false);
    }

    public void truncateBillingStreet2(boolean ellipses)
    {
        billingStreet2 = Kmu.truncate(billingStreet2, 100, ellipses);
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
    //# approvalContact
    //##################################################

    public MyCustomerContact getApprovalContact()
    {
        return approvalContact;
    }

    public void setApprovalContact(MyCustomerContact e)
    {
        approvalContact = e;
    }

    public void _setApprovalContact(MyCustomerContact e)
    {
        approvalContact = e;
    }

    public void clearApprovalContact()
    {
        setApprovalContact(null);
    }

    public boolean hasApprovalContact()
    {
        return getApprovalContact() != null;
    }

    public boolean hasApprovalContact(MyCustomerContact e)
    {
        return Kmu.isEqual(getApprovalContact(), e);
    }

    public String getApprovalContactFullName()
    {
        if ( hasApprovalContact() )
            return getApprovalContact().getFullName();
        return null;
    }

    public void setApprovalContactFullName(String e)
    {
        getApprovalContact().setFullName(e);
    }

    public boolean hasApprovalContactFullName()
    {
        return hasApprovalContact() && getApprovalContact().hasFullName();
    }

    public boolean hasApprovalContactFullName(String e)
    {
        return hasApprovalContact() && getApprovalContact().hasFullName(e);
    }

    public String getApprovalContactShortName()
    {
        if ( hasApprovalContact() )
            return getApprovalContact().getShortName();
        return null;
    }

    public boolean hasApprovalContactShortName()
    {
        return hasApprovalContact() && getApprovalContact().hasShortName();
    }

    public boolean hasApprovalContactShortName(String e)
    {
        return hasApprovalContact() && getApprovalContact().hasShortName(e);
    }

    public String getApprovalContactSummaryMultiline()
    {
        if ( hasApprovalContact() )
            return getApprovalContact().getSummaryMultiline();
        return null;
    }

    public boolean hasApprovalContactSummaryMultiline()
    {
        return hasApprovalContact() && getApprovalContact().hasSummaryMultiline();
    }

    public boolean hasApprovalContactSummaryMultiline(String e)
    {
        return hasApprovalContact() && getApprovalContact().hasSummaryMultiline(e);
    }

    public String getApprovalContactEmail()
    {
        if ( hasApprovalContact() )
            return getApprovalContact().getEmail();
        return null;
    }

    public void setApprovalContactEmail(String e)
    {
        getApprovalContact().setEmail(e);
    }

    public boolean hasApprovalContactEmail()
    {
        return hasApprovalContact() && getApprovalContact().hasEmail();
    }

    public boolean hasApprovalContactEmail(String e)
    {
        return hasApprovalContact() && getApprovalContact().hasEmail(e);
    }

    public String getApprovalContactPhone()
    {
        if ( hasApprovalContact() )
            return getApprovalContact().getPhone();
        return null;
    }

    public void setApprovalContactPhone(String e)
    {
        getApprovalContact().setPhone(e);
    }

    public boolean hasApprovalContactPhone()
    {
        return hasApprovalContact() && getApprovalContact().hasPhone();
    }

    public boolean hasApprovalContactPhone(String e)
    {
        return hasApprovalContact() && getApprovalContact().hasPhone(e);
    }

    //##################################################
    //# billingContact
    //##################################################

    public MyCustomerContact getBillingContact()
    {
        return billingContact;
    }

    public void setBillingContact(MyCustomerContact e)
    {
        billingContact = e;
    }

    public void _setBillingContact(MyCustomerContact e)
    {
        billingContact = e;
    }

    public void clearBillingContact()
    {
        setBillingContact(null);
    }

    public boolean hasBillingContact()
    {
        return getBillingContact() != null;
    }

    public boolean hasBillingContact(MyCustomerContact e)
    {
        return Kmu.isEqual(getBillingContact(), e);
    }

    public String getBillingContactFullName()
    {
        if ( hasBillingContact() )
            return getBillingContact().getFullName();
        return null;
    }

    public void setBillingContactFullName(String e)
    {
        getBillingContact().setFullName(e);
    }

    public boolean hasBillingContactFullName()
    {
        return hasBillingContact() && getBillingContact().hasFullName();
    }

    public boolean hasBillingContactFullName(String e)
    {
        return hasBillingContact() && getBillingContact().hasFullName(e);
    }

    public String getBillingContactShortName()
    {
        if ( hasBillingContact() )
            return getBillingContact().getShortName();
        return null;
    }

    public boolean hasBillingContactShortName()
    {
        return hasBillingContact() && getBillingContact().hasShortName();
    }

    public boolean hasBillingContactShortName(String e)
    {
        return hasBillingContact() && getBillingContact().hasShortName(e);
    }

    public String getBillingContactSummaryMultiline()
    {
        if ( hasBillingContact() )
            return getBillingContact().getSummaryMultiline();
        return null;
    }

    public boolean hasBillingContactSummaryMultiline()
    {
        return hasBillingContact() && getBillingContact().hasSummaryMultiline();
    }

    public boolean hasBillingContactSummaryMultiline(String e)
    {
        return hasBillingContact() && getBillingContact().hasSummaryMultiline(e);
    }

    public String getBillingContactEmail()
    {
        if ( hasBillingContact() )
            return getBillingContact().getEmail();
        return null;
    }

    public void setBillingContactEmail(String e)
    {
        getBillingContact().setEmail(e);
    }

    public boolean hasBillingContactEmail()
    {
        return hasBillingContact() && getBillingContact().hasEmail();
    }

    public boolean hasBillingContactEmail(String e)
    {
        return hasBillingContact() && getBillingContact().hasEmail(e);
    }

    public String getBillingContactPhone()
    {
        if ( hasBillingContact() )
            return getBillingContact().getPhone();
        return null;
    }

    public void setBillingContactPhone(String e)
    {
        getBillingContact().setPhone(e);
    }

    public boolean hasBillingContactPhone()
    {
        return hasBillingContact() && getBillingContact().hasPhone();
    }

    public boolean hasBillingContactPhone(String e)
    {
        return hasBillingContact() && getBillingContact().hasPhone(e);
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
    //# project
    //##################################################

    public MyProject getProject()
    {
        return project;
    }

    public void setProject(MyProject e)
    {
        project = e;
    }

    public void _setProject(MyProject e)
    {
        project = e;
    }

    public void clearProject()
    {
        setProject(null);
    }

    public boolean hasProject()
    {
        return getProject() != null;
    }

    public boolean hasProject(MyProject e)
    {
        return Kmu.isEqual(getProject(), e);
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

    public KmCollection<MyCustomerContact> getContacts()
    {
        return new KmHibernateCollection<>(
            getBaseContacts(),
            (MyCustomer)this,
            MyCustomerContact.Meta.Customer);
    }

    public boolean hasContacts()
    {
        return !getBaseContacts().isEmpty();
    }

    public int getContactCount()
    {
        return getBaseContacts().size();
    }

    public List<MyCustomerContact> getBaseContacts()
    {
        return contacts;
    }

    public MyCustomerContact addContact()
    {
        MyCustomerContact e;
        e = new MyCustomerContact();
        getContacts().add(e);
        return e;
    }

    public void addContact(MyCustomerContact e)
    {
        getContacts().add(e);
    }

    public boolean removeContact(MyCustomerContact e)
    {
        return getContacts().remove(e);
    }

    public boolean removeContactUid(String myUid)
    {
        MyCustomerContact e = findContactUid(myUid);
        if ( e == null )
            return false;

        return removeContact(e);
    }

    public MyCustomerContact findContactUid(String myUid)
    {
        for ( MyCustomerContact e : getBaseContacts() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearContacts()
    {
        getContacts().clear();
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    protected final MyCustomerValidator getValidator()
    {
        return Validator;
    }

    @Override
    protected final MyCustomer asSubclass()
    {
        return (MyCustomer)this;
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyCustomer getCopy()
    {
        return (MyCustomer)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = newUid();
        project = null;

        List<MyCustomerContact> old_contacts = contacts;
        contacts = new ArrayList<>();
        for ( MyCustomerContact e : old_contacts )
            addContact(copy(e));
    }

    /**
     * Get a copy of this model without any associations or collections.
     * The primary key and lock version are not copied.
     * The basic timestamps are reset.
     */
    public final MyCustomer getBasicCopy()
    {
        MyCustomer e;
        e = new MyCustomer();
        applyEditableFieldsTo(e);
        resetBasicTimestamps();
        return e;
    }

    /**
     * Apply the editable fields TO another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsTo(MyCustomer e)
    {
        e.setBillingAttention(getBillingAttention());
        e.setBillingCity(getBillingCity());
        e.setBillingCountry(getBillingCountry());
        e.setBillingPhone(getBillingPhone());
        e.setBillingPostalCode(getBillingPostalCode());
        e.setBillingRegion(getBillingRegion());
        e.setBillingStreet1(getBillingStreet1());
        e.setBillingStreet2(getBillingStreet2());
        e.setCreatedUtcTs(getCreatedUtcTs());
        e.setEnabled(getEnabled());
        e.setName(getName());
        e.setUpdatedUtcTs(getUpdatedUtcTs());
    }

    /**
     * Apply the editable fields FROM another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsFrom(MyCustomer e)
    {
        setBillingAttention(e.getBillingAttention());
        setBillingCity(e.getBillingCity());
        setBillingCountry(e.getBillingCountry());
        setBillingPhone(e.getBillingPhone());
        setBillingPostalCode(e.getBillingPostalCode());
        setBillingRegion(e.getBillingRegion());
        setBillingStreet1(e.getBillingStreet1());
        setBillingStreet2(e.getBillingStreet2());
        setCreatedUtcTs(e.getCreatedUtcTs());
        setEnabled(e.getEnabled());
        setName(e.getName());
        setUpdatedUtcTs(e.getUpdatedUtcTs());
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyCustomerBase) )
            return false;

        MyCustomerBase e = (MyCustomerBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyCustomer e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyCustomer e)
    {
        if ( !Kmu.isEqual(getAuditLogTitle(), e.getAuditLogTitle()) ) return false;
        if ( !Kmu.isEqual(getBillingAddressLongLine(), e.getBillingAddressLongLine()) ) return false;
        if ( !Kmu.isEqual(getBillingAddressMultiLine(), e.getBillingAddressMultiLine()) ) return false;
        if ( !Kmu.isEqual(getBillingAddressMultiLineHtml(), e.getBillingAddressMultiLineHtml()) ) return false;
        if ( !Kmu.isEqual(getBillingAddressShortLine(), e.getBillingAddressShortLine()) ) return false;
        if ( !Kmu.isEqual(getBillingAttention(), e.getBillingAttention()) ) return false;
        if ( !Kmu.isEqual(getBillingCity(), e.getBillingCity()) ) return false;
        if ( !Kmu.isEqual(getBillingCountry(), e.getBillingCountry()) ) return false;
        if ( !Kmu.isEqual(getBillingPhone(), e.getBillingPhone()) ) return false;
        if ( !Kmu.isEqual(getBillingPostalCode(), e.getBillingPostalCode()) ) return false;
        if ( !Kmu.isEqual(getBillingRegion(), e.getBillingRegion()) ) return false;
        if ( !Kmu.isEqual(getBillingStreet1(), e.getBillingStreet1()) ) return false;
        if ( !Kmu.isEqual(getBillingStreet2(), e.getBillingStreet2()) ) return false;
        if ( !Kmu.isEqual(getCreatedUtcTs(), e.getCreatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getDomainSubtitle(), e.getDomainSubtitle()) ) return false;
        if ( !Kmu.isEqual(getDomainTitle(), e.getDomainTitle()) ) return false;
        if ( !Kmu.isEqual(getEnabled(), e.getEnabled()) ) return false;
        if ( !Kmu.isEqual(getEnabledStatus(), e.getEnabledStatus()) ) return false;
        if ( !Kmu.isEqual(getName(), e.getName()) ) return false;
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

    public boolean isDifferent(MyCustomer e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyCustomer e)
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
        out.append("MyCustomer");
        out.append("(");
        out.append("Uid=");
        out.append(uid);
        out.append(")");
        return out.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    BillingAttention = " + billingAttention);
        System.out.println("    BillingCity = " + billingCity);
        System.out.println("    BillingCountry = " + billingCountry);
        System.out.println("    BillingPhone = " + billingPhone);
        System.out.println("    BillingPostalCode = " + billingPostalCode);
        System.out.println("    BillingRegion = " + billingRegion);
        System.out.println("    BillingStreet1 = " + billingStreet1);
        System.out.println("    BillingStreet2 = " + billingStreet2);
        System.out.println("    CreatedUtcTs = " + createdUtcTs);
        System.out.println("    Enabled = " + enabled);
        System.out.println("    Name = " + name);
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
