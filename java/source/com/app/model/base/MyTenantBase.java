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
public abstract class MyTenantBase
    extends MyAbstractDaoDomain
    implements MyUidDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaTenant Meta = MyMetaTenant.instance;
    public static final MyTenantTools Tools = MyTenantTools.instance;
    public static final MyTenantValidator Validator = MyTenantValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private KmTimestamp createdUtcTs;
    private String name;
    private String hostname;
    private String themeCode;
    private String intacctCompanyId;
    private String intacctUserId;
    private String intacctUserPassword;
    private Integer lockVersion;
    private List<MyProject> projects;
    private List<MyUser> users;

    //##################################################
    //# constructor
    //##################################################

    public MyTenantBase()
    {
        super();
        setUid(newUid());
        setCreatedUtcTs(nowUtc());
        setThemeCode(MyTheme.Default.getCode());
        setLockVersion(0);
        projects = new ArrayList<>();
        users = new ArrayList<>();
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
    //# field (hostname)
    //##################################################

    public String getHostname()
    {
        return hostname;
    }

    public void setHostname(String e)
    {
        e = Validator.getHostnameValidator().convertOnly(e);
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
    //# field (themeCode)
    //##################################################

    public String getThemeCode()
    {
        return themeCode;
    }

    public void setThemeCode(String e)
    {
        e = Validator.getThemeCodeValidator().convertOnly(e);
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
    //# field (intacctCompanyId)
    //##################################################

    public String getIntacctCompanyId()
    {
        return intacctCompanyId;
    }

    public void setIntacctCompanyId(String e)
    {
        e = Validator.getIntacctCompanyIdValidator().convertOnly(e);
        intacctCompanyId = e;
    }

    public void clearIntacctCompanyId()
    {
        setIntacctCompanyId(null);
    }

    public boolean hasIntacctCompanyId()
    {
        return Kmu.hasValue(getIntacctCompanyId());
    }

    public boolean hasIntacctCompanyId(String e)
    {
        return Kmu.isEqualIgnoreCase(getIntacctCompanyId(), e);
    }

    public void truncateIntacctCompanyId()
    {
        truncateIntacctCompanyId(false);
    }

    public void truncateIntacctCompanyId(boolean ellipses)
    {
        intacctCompanyId = Kmu.truncate(intacctCompanyId, 50, ellipses);
    }

    //##################################################
    //# field (intacctUserId)
    //##################################################

    public String getIntacctUserId()
    {
        return intacctUserId;
    }

    public void setIntacctUserId(String e)
    {
        e = Validator.getIntacctUserIdValidator().convertOnly(e);
        intacctUserId = e;
    }

    public void clearIntacctUserId()
    {
        setIntacctUserId(null);
    }

    public boolean hasIntacctUserId()
    {
        return Kmu.hasValue(getIntacctUserId());
    }

    public boolean hasIntacctUserId(String e)
    {
        return Kmu.isEqualIgnoreCase(getIntacctUserId(), e);
    }

    public void truncateIntacctUserId()
    {
        truncateIntacctUserId(false);
    }

    public void truncateIntacctUserId(boolean ellipses)
    {
        intacctUserId = Kmu.truncate(intacctUserId, 50, ellipses);
    }

    //##################################################
    //# field (intacctUserPassword)
    //##################################################

    public String getIntacctUserPassword()
    {
        return intacctUserPassword;
    }

    public void setIntacctUserPassword(String e)
    {
        e = Validator.getIntacctUserPasswordValidator().convertOnly(e);
        intacctUserPassword = e;
    }

    public void clearIntacctUserPassword()
    {
        setIntacctUserPassword(null);
    }

    public boolean hasIntacctUserPassword()
    {
        return Kmu.hasValue(getIntacctUserPassword());
    }

    public boolean hasIntacctUserPassword(String e)
    {
        return Kmu.isEqualIgnoreCase(getIntacctUserPassword(), e);
    }

    public void truncateIntacctUserPassword()
    {
        truncateIntacctUserPassword(false);
    }

    public void truncateIntacctUserPassword(boolean ellipses)
    {
        intacctUserPassword = Kmu.truncate(intacctUserPassword, 50, ellipses);
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
    public void validate()
    {
        Validator.validate((MyTenant)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyTenant)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyTenant)this);
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
        e.setCreatedUtcTs(getCreatedUtcTs());
        e.setName(getName());
        e.setHostname(getHostname());
        e.setThemeCode(getThemeCode());
        e.setIntacctCompanyId(getIntacctCompanyId());
        e.setIntacctUserId(getIntacctUserId());
        e.setIntacctUserPassword(getIntacctUserPassword());
        return e;
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
        if ( !Kmu.isEqual(getCreatedUtcTs(), e.getCreatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getName(), e.getName()) ) return false;
        if ( !Kmu.isEqual(getHostname(), e.getHostname()) ) return false;
        if ( !Kmu.isEqual(getThemeCode(), e.getThemeCode()) ) return false;
        if ( !Kmu.isEqual(getIntacctCompanyId(), e.getIntacctCompanyId()) ) return false;
        if ( !Kmu.isEqual(getIntacctUserId(), e.getIntacctUserId()) ) return false;
        if ( !Kmu.isEqual(getIntacctUserPassword(), e.getIntacctUserPassword()) ) return false;
        if ( !Kmu.isEqual(getThemeName(), e.getThemeName()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( !Kmu.isEqual(getDisplayString(), e.getDisplayString()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTs(), e.getCreatedLocalTs()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTsMessage(), e.getCreatedLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalDate(), e.getCreatedLocalDate()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTime(), e.getCreatedLocalTime()) ) return false;
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
        System.out.println("    Uid = " + uid);
        System.out.println("    CreatedUtcTs = " + createdUtcTs);
        System.out.println("    Name = " + name);
        System.out.println("    Hostname = " + hostname);
        System.out.println("    ThemeCode = " + themeCode);
        System.out.println("    IntacctCompanyId = " + intacctCompanyId);
        System.out.println("    IntacctUserId = " + intacctUserId);
        System.out.println("    IntacctUserPassword = " + intacctUserPassword);
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
