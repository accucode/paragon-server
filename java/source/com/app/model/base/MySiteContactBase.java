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
public abstract class MySiteContactBase
    extends MyAbstractDaoDomain<MySiteContact>
    implements KmUidDomainIF
    ,MyBasicTimestampsIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaSiteContact Meta = MyMetaSiteContact.instance;
    public static final MySiteContactTools Tools = MySiteContactTools.instance;
    public static final MySiteContactValidator Validator = MySiteContactValidator.instance;
    public static final MySiteContactFinder Finder = MySiteContactFinder.instance;

    //##################################################
    //# variables
    //##################################################

    private KmTimestamp createdUtcTs;
    private String email;
    private Boolean enabled;
    private String firstName;
    private String fullName;
    private String lastName;
    private String nickname;
    private String phone;
    private String title;
    private String uid;
    private KmTimestamp updatedUtcTs;
    private Integer lockVersion;
    private MyUser createdBy;
    private MySite site;
    private MyUser updatedBy;

    //##################################################
    //# constructor
    //##################################################

    public MySiteContactBase()
    {
        super();
        setCreatedUtcTs(nowUtc());
        setEnabled(true);
        setUid(newUid());
        setUpdatedUtcTs(nowUtc());
        setLockVersion(0);
        setCreatedBy(MyGlobals.getCurrentUser());
        setUpdatedBy(MyGlobals.getCurrentUser());
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
    //# field (effectiveInstallContact)
    //##################################################

    public abstract Boolean getEffectiveInstallContact();

    public boolean hasEffectiveInstallContact()
    {
        return getEffectiveInstallContact() != null;
    }

    public boolean hasEffectiveInstallContact(Boolean e)
    {
        return Kmu.isEqual(getEffectiveInstallContact(), e);
    }

    public boolean isEffectiveInstallContact()
    {
        if ( getEffectiveInstallContact() == null )
            return false;
        return getEffectiveInstallContact();
    }

    public boolean isEffectiveInstallContact(Boolean b)
    {
        return Kmu.isEqual(getEffectiveInstallContact(), b);
    }

    //##################################################
    //# field (effectiveRequesterContact)
    //##################################################

    public abstract Boolean getEffectiveRequesterContact();

    public boolean hasEffectiveRequesterContact()
    {
        return getEffectiveRequesterContact() != null;
    }

    public boolean hasEffectiveRequesterContact(Boolean e)
    {
        return Kmu.isEqual(getEffectiveRequesterContact(), e);
    }

    public boolean isEffectiveRequesterContact()
    {
        if ( getEffectiveRequesterContact() == null )
            return false;
        return getEffectiveRequesterContact();
    }

    public boolean isEffectiveRequesterContact(Boolean b)
    {
        return Kmu.isEqual(getEffectiveRequesterContact(), b);
    }

    //##################################################
    //# field (effectiveSalesContact)
    //##################################################

    public abstract Boolean getEffectiveSalesContact();

    public boolean hasEffectiveSalesContact()
    {
        return getEffectiveSalesContact() != null;
    }

    public boolean hasEffectiveSalesContact(Boolean e)
    {
        return Kmu.isEqual(getEffectiveSalesContact(), e);
    }

    public boolean isEffectiveSalesContact()
    {
        if ( getEffectiveSalesContact() == null )
            return false;
        return getEffectiveSalesContact();
    }

    public boolean isEffectiveSalesContact(Boolean b)
    {
        return Kmu.isEqual(getEffectiveSalesContact(), b);
    }

    //##################################################
    //# field (effectiveSchedulingContact)
    //##################################################

    public abstract Boolean getEffectiveSchedulingContact();

    public boolean hasEffectiveSchedulingContact()
    {
        return getEffectiveSchedulingContact() != null;
    }

    public boolean hasEffectiveSchedulingContact(Boolean e)
    {
        return Kmu.isEqual(getEffectiveSchedulingContact(), e);
    }

    public boolean isEffectiveSchedulingContact()
    {
        if ( getEffectiveSchedulingContact() == null )
            return false;
        return getEffectiveSchedulingContact();
    }

    public boolean isEffectiveSchedulingContact(Boolean b)
    {
        return Kmu.isEqual(getEffectiveSchedulingContact(), b);
    }

    //##################################################
    //# field (effectiveTechnicalContact)
    //##################################################

    public abstract Boolean getEffectiveTechnicalContact();

    public boolean hasEffectiveTechnicalContact()
    {
        return getEffectiveTechnicalContact() != null;
    }

    public boolean hasEffectiveTechnicalContact(Boolean e)
    {
        return Kmu.isEqual(getEffectiveTechnicalContact(), e);
    }

    public boolean isEffectiveTechnicalContact()
    {
        if ( getEffectiveTechnicalContact() == null )
            return false;
        return getEffectiveTechnicalContact();
    }

    public boolean isEffectiveTechnicalContact(Boolean b)
    {
        return Kmu.isEqual(getEffectiveTechnicalContact(), b);
    }

    //##################################################
    //# field (email)
    //##################################################

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String e)
    {
        e = Validator.getEmailValidator().convert(e);
        email = e;
    }

    public void clearEmail()
    {
        setEmail(null);
    }

    public boolean hasEmail()
    {
        return Kmu.hasValue(getEmail());
    }

    public boolean hasEmail(String e)
    {
        return Kmu.isEqualIgnoreCase(getEmail(), e);
    }

    public void truncateEmail()
    {
        truncateEmail(false);
    }

    public void truncateEmail(boolean ellipses)
    {
        email = Kmu.truncate(email, 50, ellipses);
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
    //# field (firstName)
    //##################################################

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String e)
    {
        e = Validator.getFirstNameValidator().convert(e);
        String oldValue = firstName;
        firstName = e;
        if ( Kmu.isNotEqual(e, oldValue) )
        {
            updateFullName();
        }
    }

    public void clearFirstName()
    {
        setFirstName(null);
    }

    public boolean hasFirstName()
    {
        return Kmu.hasValue(getFirstName());
    }

    public boolean hasFirstName(String e)
    {
        return Kmu.isEqualIgnoreCase(getFirstName(), e);
    }

    public void truncateFirstName()
    {
        truncateFirstName(false);
    }

    public void truncateFirstName(boolean ellipses)
    {
        firstName = Kmu.truncate(firstName, 50, ellipses);
    }

    //##################################################
    //# field (formalName)
    //##################################################

    public abstract String getFormalName();

    public boolean hasFormalName()
    {
        return Kmu.hasValue(getFormalName());
    }

    public boolean hasFormalName(String e)
    {
        return Kmu.isEqualIgnoreCase(getFormalName(), e);
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
        fullName = Kmu.truncate(fullName, 50, ellipses);
    }

    //##################################################
    //# field (installContact)
    //##################################################

    public abstract Boolean getInstallContact();

    public boolean hasInstallContact()
    {
        return getInstallContact() != null;
    }

    public boolean hasInstallContact(Boolean e)
    {
        return Kmu.isEqual(getInstallContact(), e);
    }

    public boolean isInstallContact()
    {
        if ( getInstallContact() == null )
            return false;
        return getInstallContact();
    }

    public boolean isInstallContact(Boolean b)
    {
        return Kmu.isEqual(getInstallContact(), b);
    }

    //##################################################
    //# field (lastName)
    //##################################################

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String e)
    {
        e = Validator.getLastNameValidator().convert(e);
        String oldValue = lastName;
        lastName = e;
        if ( Kmu.isNotEqual(e, oldValue) )
        {
            updateFullName();
        }
    }

    public void clearLastName()
    {
        setLastName(null);
    }

    public boolean hasLastName()
    {
        return Kmu.hasValue(getLastName());
    }

    public boolean hasLastName(String e)
    {
        return Kmu.isEqualIgnoreCase(getLastName(), e);
    }

    public void truncateLastName()
    {
        truncateLastName(false);
    }

    public void truncateLastName(boolean ellipses)
    {
        lastName = Kmu.truncate(lastName, 50, ellipses);
    }

    //##################################################
    //# field (longName)
    //##################################################

    public abstract String getLongName();

    public boolean hasLongName()
    {
        return Kmu.hasValue(getLongName());
    }

    public boolean hasLongName(String e)
    {
        return Kmu.isEqualIgnoreCase(getLongName(), e);
    }

    //##################################################
    //# field (mainContact)
    //##################################################

    public abstract Boolean getMainContact();

    public boolean hasMainContact()
    {
        return getMainContact() != null;
    }

    public boolean hasMainContact(Boolean e)
    {
        return Kmu.isEqual(getMainContact(), e);
    }

    public boolean isMainContact()
    {
        if ( getMainContact() == null )
            return false;
        return getMainContact();
    }

    public boolean isMainContact(Boolean b)
    {
        return Kmu.isEqual(getMainContact(), b);
    }

    //##################################################
    //# field (nickname)
    //##################################################

    public String getNickname()
    {
        return nickname;
    }

    public void setNickname(String e)
    {
        e = Validator.getNicknameValidator().convert(e);
        String oldValue = nickname;
        nickname = e;
        if ( Kmu.isNotEqual(e, oldValue) )
        {
            updateFullName();
        }
    }

    public void clearNickname()
    {
        setNickname(null);
    }

    public boolean hasNickname()
    {
        return Kmu.hasValue(getNickname());
    }

    public boolean hasNickname(String e)
    {
        return Kmu.isEqualIgnoreCase(getNickname(), e);
    }

    public void truncateNickname()
    {
        truncateNickname(false);
    }

    public void truncateNickname(boolean ellipses)
    {
        nickname = Kmu.truncate(nickname, 50, ellipses);
    }

    //##################################################
    //# field (phone)
    //##################################################

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String e)
    {
        e = Validator.getPhoneValidator().convert(e);
        phone = e;
    }

    public void clearPhone()
    {
        setPhone(null);
    }

    public boolean hasPhone()
    {
        return Kmu.hasValue(getPhone());
    }

    public boolean hasPhone(String e)
    {
        return Kmu.isEqualIgnoreCase(getPhone(), e);
    }

    public void truncatePhone()
    {
        truncatePhone(false);
    }

    public void truncatePhone(boolean ellipses)
    {
        phone = Kmu.truncate(phone, 30, ellipses);
    }

    //##################################################
    //# field (requesterContact)
    //##################################################

    public abstract Boolean getRequesterContact();

    public boolean hasRequesterContact()
    {
        return getRequesterContact() != null;
    }

    public boolean hasRequesterContact(Boolean e)
    {
        return Kmu.isEqual(getRequesterContact(), e);
    }

    public boolean isRequesterContact()
    {
        if ( getRequesterContact() == null )
            return false;
        return getRequesterContact();
    }

    public boolean isRequesterContact(Boolean b)
    {
        return Kmu.isEqual(getRequesterContact(), b);
    }

    //##################################################
    //# field (salesContact)
    //##################################################

    public abstract Boolean getSalesContact();

    public boolean hasSalesContact()
    {
        return getSalesContact() != null;
    }

    public boolean hasSalesContact(Boolean e)
    {
        return Kmu.isEqual(getSalesContact(), e);
    }

    public boolean isSalesContact()
    {
        if ( getSalesContact() == null )
            return false;
        return getSalesContact();
    }

    public boolean isSalesContact(Boolean b)
    {
        return Kmu.isEqual(getSalesContact(), b);
    }

    //##################################################
    //# field (schedulingContact)
    //##################################################

    public abstract Boolean getSchedulingContact();

    public boolean hasSchedulingContact()
    {
        return getSchedulingContact() != null;
    }

    public boolean hasSchedulingContact(Boolean e)
    {
        return Kmu.isEqual(getSchedulingContact(), e);
    }

    public boolean isSchedulingContact()
    {
        if ( getSchedulingContact() == null )
            return false;
        return getSchedulingContact();
    }

    public boolean isSchedulingContact(Boolean b)
    {
        return Kmu.isEqual(getSchedulingContact(), b);
    }

    //##################################################
    //# field (shortName)
    //##################################################

    public abstract String getShortName();

    public boolean hasShortName()
    {
        return Kmu.hasValue(getShortName());
    }

    public boolean hasShortName(String e)
    {
        return Kmu.isEqualIgnoreCase(getShortName(), e);
    }

    //##################################################
    //# field (summaryMultiline)
    //##################################################

    public abstract String getSummaryMultiline();

    public boolean hasSummaryMultiline()
    {
        return Kmu.hasValue(getSummaryMultiline());
    }

    public boolean hasSummaryMultiline(String e)
    {
        return Kmu.isEqualIgnoreCase(getSummaryMultiline(), e);
    }

    //##################################################
    //# field (technicalContact)
    //##################################################

    public abstract Boolean getTechnicalContact();

    public boolean hasTechnicalContact()
    {
        return getTechnicalContact() != null;
    }

    public boolean hasTechnicalContact(Boolean e)
    {
        return Kmu.isEqual(getTechnicalContact(), e);
    }

    public boolean isTechnicalContact()
    {
        if ( getTechnicalContact() == null )
            return false;
        return getTechnicalContact();
    }

    public boolean isTechnicalContact(Boolean b)
    {
        return Kmu.isEqual(getTechnicalContact(), b);
    }

    //##################################################
    //# field (title)
    //##################################################

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String e)
    {
        e = Validator.getTitleValidator().convert(e);
        title = e;
    }

    public void clearTitle()
    {
        setTitle(null);
    }

    public boolean hasTitle()
    {
        return Kmu.hasValue(getTitle());
    }

    public boolean hasTitle(String e)
    {
        return Kmu.isEqualIgnoreCase(getTitle(), e);
    }

    public void truncateTitle()
    {
        truncateTitle(false);
    }

    public void truncateTitle(boolean ellipses)
    {
        title = Kmu.truncate(title, 50, ellipses);
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
    //# site
    //##################################################

    public MySite getSite()
    {
        return site;
    }

    public void setSite(MySite e)
    {
        site = e;
    }

    public void _setSite(MySite e)
    {
        site = e;
    }

    public void clearSite()
    {
        setSite(null);
    }

    public boolean hasSite()
    {
        return getSite() != null;
    }

    public boolean hasSite(MySite e)
    {
        return Kmu.isEqual(getSite(), e);
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
    //# on change
    //##################################################

    protected abstract void updateFullName();

    //##################################################
    //# validate
    //##################################################

    @Override
    protected final MySiteContactValidator getValidator()
    {
        return Validator;
    }

    @Override
    protected final MySiteContact asSubclass()
    {
        return (MySiteContact)this;
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MySiteContact getCopy()
    {
        return (MySiteContact)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = newUid();
        site = null;
    }

    /**
     * Get a copy of this model without any associations or collections.
     * The primary key and lock version are not copied.
     * The basic timestamps are reset.
     */
    public final MySiteContact getBasicCopy()
    {
        MySiteContact e;
        e = new MySiteContact();
        applyEditableFieldsTo(e);
        resetBasicTimestamps();
        return e;
    }

    /**
     * Apply the editable fields TO another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsTo(MySiteContact e)
    {
        e.setCreatedUtcTs(getCreatedUtcTs());
        e.setEmail(getEmail());
        e.setEnabled(getEnabled());
        e.setFirstName(getFirstName());
        e.setFullName(getFullName());
        e.setLastName(getLastName());
        e.setNickname(getNickname());
        e.setPhone(getPhone());
        e.setTitle(getTitle());
        e.setUpdatedUtcTs(getUpdatedUtcTs());
    }

    /**
     * Apply the editable fields FROM another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsFrom(MySiteContact e)
    {
        setCreatedUtcTs(e.getCreatedUtcTs());
        setEmail(e.getEmail());
        setEnabled(e.getEnabled());
        setFirstName(e.getFirstName());
        setFullName(e.getFullName());
        setLastName(e.getLastName());
        setNickname(e.getNickname());
        setPhone(e.getPhone());
        setTitle(e.getTitle());
        setUpdatedUtcTs(e.getUpdatedUtcTs());
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MySiteContactBase) )
            return false;

        MySiteContactBase e = (MySiteContactBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MySiteContact e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MySiteContact e)
    {
        if ( !Kmu.isEqual(getAuditLogTitle(), e.getAuditLogTitle()) ) return false;
        if ( !Kmu.isEqual(getCreatedUtcTs(), e.getCreatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getDomainSubtitle(), e.getDomainSubtitle()) ) return false;
        if ( !Kmu.isEqual(getDomainTitle(), e.getDomainTitle()) ) return false;
        if ( !Kmu.isEqual(getEffectiveInstallContact(), e.getEffectiveInstallContact()) ) return false;
        if ( !Kmu.isEqual(getEffectiveRequesterContact(), e.getEffectiveRequesterContact()) ) return false;
        if ( !Kmu.isEqual(getEffectiveSalesContact(), e.getEffectiveSalesContact()) ) return false;
        if ( !Kmu.isEqual(getEffectiveSchedulingContact(), e.getEffectiveSchedulingContact()) ) return false;
        if ( !Kmu.isEqual(getEffectiveTechnicalContact(), e.getEffectiveTechnicalContact()) ) return false;
        if ( !Kmu.isEqual(getEmail(), e.getEmail()) ) return false;
        if ( !Kmu.isEqual(getEnabled(), e.getEnabled()) ) return false;
        if ( !Kmu.isEqual(getEnabledStatus(), e.getEnabledStatus()) ) return false;
        if ( !Kmu.isEqual(getFirstName(), e.getFirstName()) ) return false;
        if ( !Kmu.isEqual(getFormalName(), e.getFormalName()) ) return false;
        if ( !Kmu.isEqual(getFullName(), e.getFullName()) ) return false;
        if ( !Kmu.isEqual(getInstallContact(), e.getInstallContact()) ) return false;
        if ( !Kmu.isEqual(getLastName(), e.getLastName()) ) return false;
        if ( !Kmu.isEqual(getLongName(), e.getLongName()) ) return false;
        if ( !Kmu.isEqual(getMainContact(), e.getMainContact()) ) return false;
        if ( !Kmu.isEqual(getNickname(), e.getNickname()) ) return false;
        if ( !Kmu.isEqual(getPhone(), e.getPhone()) ) return false;
        if ( !Kmu.isEqual(getRequesterContact(), e.getRequesterContact()) ) return false;
        if ( !Kmu.isEqual(getSalesContact(), e.getSalesContact()) ) return false;
        if ( !Kmu.isEqual(getSchedulingContact(), e.getSchedulingContact()) ) return false;
        if ( !Kmu.isEqual(getShortName(), e.getShortName()) ) return false;
        if ( !Kmu.isEqual(getSummaryMultiline(), e.getSummaryMultiline()) ) return false;
        if ( !Kmu.isEqual(getTechnicalContact(), e.getTechnicalContact()) ) return false;
        if ( !Kmu.isEqual(getTitle(), e.getTitle()) ) return false;
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

    public boolean isDifferent(MySiteContact e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MySiteContact e)
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
        out.append("MySiteContact");
        out.append("(");
        out.append("Uid=");
        out.append(uid);
        out.append(")");
        return out.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    CreatedUtcTs = " + createdUtcTs);
        System.out.println("    Email = " + email);
        System.out.println("    Enabled = " + enabled);
        System.out.println("    FirstName = " + firstName);
        System.out.println("    FullName = " + fullName);
        System.out.println("    LastName = " + lastName);
        System.out.println("    Nickname = " + nickname);
        System.out.println("    Phone = " + phone);
        System.out.println("    Title = " + title);
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
