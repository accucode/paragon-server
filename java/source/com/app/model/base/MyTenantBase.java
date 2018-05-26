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
public abstract class MyTenantBase
    extends MyAbstractDaoDomain<MyTenant>
    implements KmUidDomainIF
    ,MyBasicTimestampsIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaTenant Meta = MyMetaTenant.instance;
    public static final MyTenantTools Tools = MyTenantTools.instance;
    public static final MyTenantValidator Validator = MyTenantValidator.instance;
    public static final MyTenantFinder Finder = MyTenantFinder.instance;

    //##################################################
    //# variables
    //##################################################

    private KmDayFrequency businessDays;
    private KmTime businessEndTime;
    private KmTime businessStartTime;
    private KmTimestamp createdUtcTs;
    private String hostname;
    private String memo;
    private String name;
    private String themeCode;
    private String timeZoneCode;
    private String uid;
    private KmTimestamp updatedUtcTs;
    private Integer lockVersion;
    private MyUser createdBy;
    private MyUser updatedBy;
    private List<MyProject> projects;
    private List<MyUser> users;

    //##################################################
    //# constructor
    //##################################################

    public MyTenantBase()
    {
        super();
        setBusinessDays(MyTenant.DEFAULT_BUSINESS_DAYS);
        setBusinessEndTime(MyTenant.DEFAULT_BUSINESS_END);
        setBusinessStartTime(MyTenant.DEFAULT_BUSINESS_START);
        setCreatedUtcTs(nowUtc());
        setThemeCode(MyTheme.Default.getCode());
        setTimeZoneCode(MyTenant.DEFAULT_TIME_ZONE.getCode());
        setUid(newUid());
        setUpdatedUtcTs(nowUtc());
        setLockVersion(0);
        setCreatedBy(MyGlobals.getCurrentUser());
        setUpdatedBy(MyGlobals.getCurrentUser());
        projects = new ArrayList<>();
        users = new ArrayList<>();
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
    //# field (hostname)
    //##################################################

    public String getHostname()
    {
        return hostname;
    }

    public void setHostname(String e)
    {
        e = Validator.getHostnameValidator().convert(e);
        hostname = e;
    }

    public void clearHostname()
    {
        setHostname(null);
    }

    public boolean hasHostname()
    {
        return Kmu.hasValue(getHostname());
    }

    public boolean hasHostname(String e)
    {
        return Kmu.isEqualIgnoreCase(getHostname(), e);
    }

    public void truncateHostname()
    {
        truncateHostname(false);
    }

    public void truncateHostname(boolean ellipses)
    {
        hostname = Kmu.truncate(hostname, 50, ellipses);
    }

    //##################################################
    //# field (memo)
    //##################################################

    public String getMemo()
    {
        return memo;
    }

    public void setMemo(String e)
    {
        e = Validator.getMemoValidator().convert(e);
        memo = e;
    }

    public void clearMemo()
    {
        setMemo(null);
    }

    public boolean hasMemo()
    {
        return Kmu.hasValue(getMemo());
    }

    public boolean hasMemo(String e)
    {
        return Kmu.isEqualIgnoreCase(getMemo(), e);
    }

    public void truncateMemo()
    {
        truncateMemo(false);
    }

    public void truncateMemo(boolean ellipses)
    {
        memo = Kmu.truncate(memo, 1000, ellipses);
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
    //# field (themeCode)
    //##################################################

    public String getThemeCode()
    {
        return themeCode;
    }

    public void setThemeCode(String e)
    {
        e = Validator.getThemeCodeValidator().convert(e);
        themeCode = e;
    }

    public void clearThemeCode()
    {
        setThemeCode(null);
    }

    public boolean hasThemeCode()
    {
        return Kmu.hasValue(getThemeCode());
    }

    public boolean hasThemeCode(String e)
    {
        return Kmu.isEqualIgnoreCase(getThemeCode(), e);
    }

    public void truncateThemeCode()
    {
        truncateThemeCode(false);
    }

    public void truncateThemeCode(boolean ellipses)
    {
        themeCode = Kmu.truncate(themeCode, 50, ellipses);
    }

    //##################################################
    //# field (themeName)
    //##################################################

    public abstract String getThemeName();

    public boolean hasThemeName()
    {
        return Kmu.hasValue(getThemeName());
    }

    public boolean hasThemeName(String e)
    {
        return Kmu.isEqualIgnoreCase(getThemeName(), e);
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
    //# Projects (collection)
    //##################################################

    public KmCollection<MyProject> getProjects()
    {
        return new KmHibernateCollection<>(
            getBaseProjects(),
            (MyTenant)this,
            MyProject.Meta.Tenant);
    }

    public boolean hasProjects()
    {
        return !getBaseProjects().isEmpty();
    }

    public int getProjectCount()
    {
        return getBaseProjects().size();
    }

    public List<MyProject> getBaseProjects()
    {
        return projects;
    }

    public MyProject addProject()
    {
        MyProject e;
        e = new MyProject();
        getProjects().add(e);
        return e;
    }

    public void addProject(MyProject e)
    {
        getProjects().add(e);
    }

    public boolean removeProject(MyProject e)
    {
        return getProjects().remove(e);
    }

    public boolean removeProjectUid(String myUid)
    {
        MyProject e = findProjectUid(myUid);
        if ( e == null )
            return false;

        return removeProject(e);
    }

    public MyProject findProjectUid(String myUid)
    {
        for ( MyProject e : getBaseProjects() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearProjects()
    {
        getProjects().clear();
    }

    //##################################################
    //# Users (collection)
    //##################################################

    public KmCollection<MyUser> getUsers()
    {
        return new KmHibernateCollection<>(
            getBaseUsers(),
            (MyTenant)this,
            MyUser.Meta.Tenant);
    }

    public boolean hasUsers()
    {
        return !getBaseUsers().isEmpty();
    }

    public int getUserCount()
    {
        return getBaseUsers().size();
    }

    public List<MyUser> getBaseUsers()
    {
        return users;
    }

    public MyUser addUser()
    {
        MyUser e;
        e = new MyUser();
        getUsers().add(e);
        return e;
    }

    public void addUser(MyUser e)
    {
        getUsers().add(e);
    }

    public boolean removeUser(MyUser e)
    {
        return getUsers().remove(e);
    }

    public boolean removeUserUid(String myUid)
    {
        MyUser e = findUserUid(myUid);
        if ( e == null )
            return false;

        return removeUser(e);
    }

    public MyUser findUserUid(String myUid)
    {
        for ( MyUser e : getBaseUsers() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearUsers()
    {
        getUsers().clear();
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    protected final MyTenantValidator getValidator()
    {
        return Validator;
    }

    @Override
    protected final MyTenant asSubclass()
    {
        return (MyTenant)this;
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyTenant getCopy()
    {
        return (MyTenant)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = newUid();

        List<MyProject> old_projects = projects;
        projects = new ArrayList<>();
        for ( MyProject e : old_projects )
            addProject(copy(e));

        List<MyUser> old_users = users;
        users = new ArrayList<>();
        for ( MyUser e : old_users )
            addUser(copy(e));
    }

    /**
     * Get a copy of this model without any associations or collections.
     * The primary key and lock version are not copied.
     * The basic timestamps are reset.
     */
    public final MyTenant getBasicCopy()
    {
        MyTenant e;
        e = new MyTenant();
        applyEditableFieldsTo(e);
        resetBasicTimestamps();
        return e;
    }

    /**
     * Apply the editable fields TO another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsTo(MyTenant e)
    {
        e.setBusinessDays(getBusinessDays());
        e.setBusinessEndTime(getBusinessEndTime());
        e.setBusinessStartTime(getBusinessStartTime());
        e.setCreatedUtcTs(getCreatedUtcTs());
        e.setHostname(getHostname());
        e.setMemo(getMemo());
        e.setName(getName());
        e.setThemeCode(getThemeCode());
        e.setTimeZoneCode(getTimeZoneCode());
        e.setUpdatedUtcTs(getUpdatedUtcTs());
    }

    /**
     * Apply the editable fields FROM another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsFrom(MyTenant e)
    {
        setBusinessDays(e.getBusinessDays());
        setBusinessEndTime(e.getBusinessEndTime());
        setBusinessStartTime(e.getBusinessStartTime());
        setCreatedUtcTs(e.getCreatedUtcTs());
        setHostname(e.getHostname());
        setMemo(e.getMemo());
        setName(e.getName());
        setThemeCode(e.getThemeCode());
        setTimeZoneCode(e.getTimeZoneCode());
        setUpdatedUtcTs(e.getUpdatedUtcTs());
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyTenantBase) )
            return false;

        MyTenantBase e = (MyTenantBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyTenant e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyTenant e)
    {
        if ( !Kmu.isEqual(getAuditLogTitle(), e.getAuditLogTitle()) ) return false;
        if ( !Kmu.isEqual(getBusinessDays(), e.getBusinessDays()) ) return false;
        if ( !Kmu.isEqual(getBusinessEndTime(), e.getBusinessEndTime()) ) return false;
        if ( !Kmu.isEqual(getBusinessStartTime(), e.getBusinessStartTime()) ) return false;
        if ( !Kmu.isEqual(getCreatedUtcTs(), e.getCreatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getDomainSubtitle(), e.getDomainSubtitle()) ) return false;
        if ( !Kmu.isEqual(getDomainTitle(), e.getDomainTitle()) ) return false;
        if ( !Kmu.isEqual(getHostname(), e.getHostname()) ) return false;
        if ( !Kmu.isEqual(getMemo(), e.getMemo()) ) return false;
        if ( !Kmu.isEqual(getName(), e.getName()) ) return false;
        if ( !Kmu.isEqual(getThemeCode(), e.getThemeCode()) ) return false;
        if ( !Kmu.isEqual(getThemeName(), e.getThemeName()) ) return false;
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

    public boolean isDifferent(MyTenant e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyTenant e)
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
        out.append("MyTenant");
        out.append("(");
        out.append("Uid=");
        out.append(uid);
        out.append(")");
        return out.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    BusinessDays = " + businessDays);
        System.out.println("    BusinessEndTime = " + businessEndTime);
        System.out.println("    BusinessStartTime = " + businessStartTime);
        System.out.println("    CreatedUtcTs = " + createdUtcTs);
        System.out.println("    Hostname = " + hostname);
        System.out.println("    Memo = " + memo);
        System.out.println("    Name = " + name);
        System.out.println("    ThemeCode = " + themeCode);
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
