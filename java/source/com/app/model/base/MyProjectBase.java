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
import com.kodemore.exception.*;
import com.kodemore.servlet.encoder.*;
import com.kodemore.servlet.utility.*;
import com.kodemore.time.*;
import com.kodemore.types.*;
import com.kodemore.utility.*;

import com.app.model.*;
import com.app.model.core.*;
import com.app.model.meta.*;
import com.app.model.support.*;
import com.app.ui.dashboard.core.*;
import com.app.utility.*;

@SuppressWarnings("all")
public abstract class MyProjectBase
    extends MyAbstractDaoDomain
    implements MyUidDomainIF
    ,MyBasicTimestampsIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaProject Meta = MyMetaProject.instance;
    public static final MyProjectTools Tools = MyProjectTools.instance;
    public static final MyProjectValidator Validator = MyProjectValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private KmTimestamp createdUtcTs;
    private KmTimestamp updatedUtcTs;
    private String name;
    private String code;
    private String companyName;
    private String sendEmailFrom;
    private Boolean active;
    private Integer catalogVersion;
    private KmDayFrequency businessDays;
    private KmTime businessStartTime;
    private KmTime businessEndTime;
    private Integer lockVersion;
    private MyUser createdBy;
    private MyUser updatedBy;
    private MyTenant tenant;

    //##################################################
    //# constructor
    //##################################################

    public MyProjectBase()
    {
        super();
        setUid(newUid());
        setCreatedUtcTs(nowUtc());
        setUpdatedUtcTs(nowUtc());
        setActive(true);
        setCatalogVersion(1);
        setBusinessDays(MyProject.DEFAULT_BUSINESS_DAYS);
        setBusinessStartTime(MyProject.DEFAULT_BUSINESS_START_TIME);
        setBusinessEndTime(MyProject.DEFAULT_BUSINESS_END_TIME);
        setLockVersion(0);
        setCreatedBy(MyGlobals.getCurrentUser());
        setUpdatedBy(MyGlobals.getCurrentUser());
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
        e = Validator.getUidValidator().convertOnly(e);
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
    //# field (createdUtcTs)
    //##################################################

    public KmTimestamp getCreatedUtcTs()
    {
        return createdUtcTs;
    }

    public void setCreatedUtcTs(KmTimestamp e)
    {
        e = Validator.getCreatedUtcTsValidator().convertOnly(e);
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
    //# field (updatedUtcTs)
    //##################################################

    public KmTimestamp getUpdatedUtcTs()
    {
        return updatedUtcTs;
    }

    public void setUpdatedUtcTs(KmTimestamp e)
    {
        e = Validator.getUpdatedUtcTsValidator().convertOnly(e);
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
    //# field (name)
    //##################################################

    public String getName()
    {
        return name;
    }

    public void setName(String e)
    {
        e = Validator.getNameValidator().convertOnly(e);
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
    //# field (code)
    //##################################################

    public String getCode()
    {
        return code;
    }

    public void setCode(String e)
    {
        e = Validator.getCodeValidator().convertOnly(e);
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
        e = Validator.getCompanyNameValidator().convertOnly(e);
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
    //# field (sendEmailFrom)
    //##################################################

    public String getSendEmailFrom()
    {
        return sendEmailFrom;
    }

    public void setSendEmailFrom(String e)
    {
        e = Validator.getSendEmailFromValidator().convertOnly(e);
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
    //# field (active)
    //##################################################

    public Boolean getActive()
    {
        return active;
    }

    public void setActive(Boolean e)
    {
        e = Validator.getActiveValidator().convertOnly(e);
        active = e;
    }

    public void clearActive()
    {
        setActive(null);
    }

    public boolean hasActive()
    {
        return getActive() != null;
    }

    public boolean hasActive(Boolean e)
    {
        return Kmu.isEqual(getActive(), e);
    }

    public boolean isActive()
    {
        if ( getActive() == null )
            return false;
        return getActive();
    }

    public boolean isNotActive()
    {
        return !isActive();
    }

    public boolean isActive(Boolean b)
    {
        return Kmu.isEqual(getActive(), b);
    }

    public void toggleActive()
    {
        setActive(!getActive());
    }

    //##################################################
    //# field (catalogVersion)
    //##################################################

    public Integer getCatalogVersion()
    {
        return catalogVersion;
    }

    public void setCatalogVersion(Integer e)
    {
        e = Validator.getCatalogVersionValidator().convertOnly(e);
        catalogVersion = e;
    }

    public void clearCatalogVersion()
    {
        setCatalogVersion(null);
    }

    public boolean hasCatalogVersion()
    {
        return getCatalogVersion() != null;
    }

    public boolean hasCatalogVersion(Integer e)
    {
        return Kmu.isEqual(getCatalogVersion(), e);
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
        e = Validator.getBusinessDaysValidator().convertOnly(e);
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
    //# field (businessStartTime)
    //##################################################

    public KmTime getBusinessStartTime()
    {
        return businessStartTime;
    }

    public void setBusinessStartTime(KmTime e)
    {
        e = Validator.getBusinessStartTimeValidator().convertOnly(e);
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
    //# field (businessEndTime)
    //##################################################

    public KmTime getBusinessEndTime()
    {
        return businessEndTime;
    }

    public void setBusinessEndTime(KmTime e)
    {
        e = Validator.getBusinessEndTimeValidator().convertOnly(e);
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
    //# field (lockVersion)
    //##################################################

    public Integer getLockVersion()
    {
        return lockVersion;
    }

    public void setLockVersion(Integer e)
    {
        e = Validator.getLockVersionValidator().convertOnly(e);
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
    //# field (displayString)
    //##################################################

    public abstract String getDisplayString();

    public boolean hasDisplayString()
    {
        return Kmu.hasValue(getDisplayString());
    }

    public boolean hasDisplayString(String e)
    {
        return Kmu.isEqualIgnoreCase(getDisplayString(), e);
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

    public boolean hasCreatedByFullName()
    {
        return hasCreatedBy() && getCreatedBy().hasFullName();
    }

    public boolean hasCreatedByFullName(String e)
    {
        return hasCreatedBy() && getCreatedBy().hasFullName(e);
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

    public boolean hasUpdatedByFullName()
    {
        return hasUpdatedBy() && getUpdatedBy().hasFullName();
    }

    public boolean hasUpdatedByFullName(String e)
    {
        return hasUpdatedBy() && getUpdatedBy().hasFullName(e);
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
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyProject)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyProject)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyProject)this);
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
        e.setCreatedUtcTs(getCreatedUtcTs());
        e.setUpdatedUtcTs(getUpdatedUtcTs());
        e.setName(getName());
        e.setCode(getCode());
        e.setCompanyName(getCompanyName());
        e.setSendEmailFrom(getSendEmailFrom());
        e.setActive(getActive());
        e.setCatalogVersion(getCatalogVersion());
        e.setBusinessDays(getBusinessDays());
        e.setBusinessStartTime(getBusinessStartTime());
        e.setBusinessEndTime(getBusinessEndTime());
        resetBasicTimestamps();
        return e;
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
        if ( !Kmu.isEqual(getCreatedUtcTs(), e.getCreatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getUpdatedUtcTs(), e.getUpdatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getName(), e.getName()) ) return false;
        if ( !Kmu.isEqual(getCode(), e.getCode()) ) return false;
        if ( !Kmu.isEqual(getCompanyName(), e.getCompanyName()) ) return false;
        if ( !Kmu.isEqual(getSendEmailFrom(), e.getSendEmailFrom()) ) return false;
        if ( !Kmu.isEqual(getActive(), e.getActive()) ) return false;
        if ( !Kmu.isEqual(getCatalogVersion(), e.getCatalogVersion()) ) return false;
        if ( !Kmu.isEqual(getBusinessDays(), e.getBusinessDays()) ) return false;
        if ( !Kmu.isEqual(getBusinessStartTime(), e.getBusinessStartTime()) ) return false;
        if ( !Kmu.isEqual(getBusinessEndTime(), e.getBusinessEndTime()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( !Kmu.isEqual(getDisplayString(), e.getDisplayString()) ) return false;
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
        System.out.println("    Uid = " + uid);
        System.out.println("    CreatedUtcTs = " + createdUtcTs);
        System.out.println("    UpdatedUtcTs = " + updatedUtcTs);
        System.out.println("    Name = " + name);
        System.out.println("    Code = " + code);
        System.out.println("    CompanyName = " + companyName);
        System.out.println("    SendEmailFrom = " + sendEmailFrom);
        System.out.println("    Active = " + active);
        System.out.println("    CatalogVersion = " + catalogVersion);
        System.out.println("    BusinessDays = " + businessDays);
        System.out.println("    BusinessStartTime = " + businessStartTime);
        System.out.println("    BusinessEndTime = " + businessEndTime);
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
