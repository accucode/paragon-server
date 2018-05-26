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
public abstract class MyUserBase
    extends MyAbstractDaoDomain<MyUser>
    implements KmUidDomainIF
    ,MyBasicTimestampsIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaUser Meta = MyMetaUser.instance;
    public static final MyUserTools Tools = MyUserTools.instance;
    public static final MyUserValidator Validator = MyUserValidator.instance;
    public static final MyUserFinder Finder = MyUserFinder.instance;

    //##################################################
    //# variables
    //##################################################

    private KmTimestamp createdUtcTs;
    private String email;
    private Boolean enabled;
    private String firstName;
    private String fullName;
    private String lastName;
    private String memo;
    private String nickname;
    private String passwordHash;
    private String passwordSalt;
    private String phone;
    private String roleCode;
    private String timeZoneCode;
    private String uid;
    private KmTimestamp updatedUtcTs;
    private Integer lockVersion;
    private MyUser createdBy;
    private MyTenant tenant;
    private MyUser updatedBy;

    //##################################################
    //# constructor
    //##################################################

    public MyUserBase()
    {
        super();
        setCreatedUtcTs(nowUtc());
        setEnabled(true);
        setPasswordSalt(newUid());
        setRoleCode(MyUserRole.ProjectMember.getCode());
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
    //# field (passwordHash)
    //##################################################

    public String getPasswordHash()
    {
        return passwordHash;
    }

    public void setPasswordHash(String e)
    {
        e = Validator.getPasswordHashValidator().convert(e);
        passwordHash = e;
    }

    public void clearPasswordHash()
    {
        setPasswordHash(null);
    }

    public boolean hasPasswordHash()
    {
        return Kmu.hasValue(getPasswordHash());
    }

    public boolean hasPasswordHash(String e)
    {
        return Kmu.isEqualIgnoreCase(getPasswordHash(), e);
    }

    public void truncatePasswordHash()
    {
        truncatePasswordHash(false);
    }

    public void truncatePasswordHash(boolean ellipses)
    {
        passwordHash = Kmu.truncate(passwordHash, 40, ellipses);
    }

    //##################################################
    //# field (passwordSalt)
    //##################################################

    public String getPasswordSalt()
    {
        return passwordSalt;
    }

    public void setPasswordSalt(String e)
    {
        e = Validator.getPasswordSaltValidator().convert(e);
        passwordSalt = e;
    }

    public void clearPasswordSalt()
    {
        setPasswordSalt(null);
    }

    public boolean hasPasswordSalt()
    {
        return Kmu.hasValue(getPasswordSalt());
    }

    public boolean hasPasswordSalt(String e)
    {
        return Kmu.isEqualIgnoreCase(getPasswordSalt(), e);
    }

    public void truncatePasswordSalt()
    {
        truncatePasswordSalt(false);
    }

    public void truncatePasswordSalt(boolean ellipses)
    {
        passwordSalt = Kmu.truncate(passwordSalt, 30, ellipses);
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
    //# field (roleCode)
    //##################################################

    public String getRoleCode()
    {
        return roleCode;
    }

    public void setRoleCode(String e)
    {
        e = Validator.getRoleCodeValidator().convert(e);
        roleCode = e;
    }

    public void clearRoleCode()
    {
        setRoleCode(null);
    }

    public boolean hasRoleCode()
    {
        return Kmu.hasValue(getRoleCode());
    }

    public boolean hasRoleCode(String e)
    {
        return Kmu.isEqualIgnoreCase(getRoleCode(), e);
    }

    public void truncateRoleCode()
    {
        truncateRoleCode(false);
    }

    public void truncateRoleCode(boolean ellipses)
    {
        roleCode = Kmu.truncate(roleCode, 30, ellipses);
    }

    public MyUserRole getRole()
    {
        return MyUserRole.findCode(getRoleCode());
    }

    public void setRole(MyUserRole e)
    {
        if ( e == null )
            setRoleCode(null);
        else
            setRoleCode(e.getCode());
    }

    public boolean hasRole()
    {
        return getRole() != null;
    }

    public boolean hasRole(MyUserRole e)
    {
        return getRole() == e;
    }

    public void setRoleDeveloper()
    {
        setRole(MyUserRole.Developer);
    }

    public boolean isRoleDeveloper()
    {
        return hasRole(MyUserRole.Developer);
    }

    public void setRoleTenantAdmin()
    {
        setRole(MyUserRole.TenantAdmin);
    }

    public boolean isRoleTenantAdmin()
    {
        return hasRole(MyUserRole.TenantAdmin);
    }

    public void setRoleProjectMember()
    {
        setRole(MyUserRole.ProjectMember);
    }

    public boolean isRoleProjectMember()
    {
        return hasRole(MyUserRole.ProjectMember);
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
    //# field (roleName)
    //##################################################

    public final String getRoleName()
    {
        return KmEnumIF.getLabelFor(getRole());
    }

    public boolean hasRoleName()
    {
        return Kmu.hasValue(getRoleName());
    }

    public boolean hasRoleName(String e)
    {
        return Kmu.isEqualIgnoreCase(getRoleName(), e);
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
    //# lastProject
    //##################################################

    public abstract MyProject getLastProject();

    public boolean hasLastProject()
    {
        return getLastProject() != null;
    }

    public boolean hasLastProject(MyProject e)
    {
        return Kmu.isEqual(getLastProject(), e);
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
    //# on change
    //##################################################

    protected abstract void updateFullName();

    //##################################################
    //# validate
    //##################################################

    @Override
    protected final MyUserValidator getValidator()
    {
        return Validator;
    }

    @Override
    protected final MyUser asSubclass()
    {
        return (MyUser)this;
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyUser getCopy()
    {
        return (MyUser)super.getCopy();
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
    public final MyUser getBasicCopy()
    {
        MyUser e;
        e = new MyUser();
        applyEditableFieldsTo(e);
        resetBasicTimestamps();
        return e;
    }

    /**
     * Apply the editable fields TO another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsTo(MyUser e)
    {
        e.setCreatedUtcTs(getCreatedUtcTs());
        e.setEmail(getEmail());
        e.setEnabled(getEnabled());
        e.setFirstName(getFirstName());
        e.setFullName(getFullName());
        e.setLastName(getLastName());
        e.setMemo(getMemo());
        e.setNickname(getNickname());
        e.setPasswordHash(getPasswordHash());
        e.setPasswordSalt(getPasswordSalt());
        e.setPhone(getPhone());
        e.setRoleCode(getRoleCode());
        e.setTimeZoneCode(getTimeZoneCode());
        e.setUpdatedUtcTs(getUpdatedUtcTs());
    }

    /**
     * Apply the editable fields FROM another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsFrom(MyUser e)
    {
        setCreatedUtcTs(e.getCreatedUtcTs());
        setEmail(e.getEmail());
        setEnabled(e.getEnabled());
        setFirstName(e.getFirstName());
        setFullName(e.getFullName());
        setLastName(e.getLastName());
        setMemo(e.getMemo());
        setNickname(e.getNickname());
        setPasswordHash(e.getPasswordHash());
        setPasswordSalt(e.getPasswordSalt());
        setPhone(e.getPhone());
        setRoleCode(e.getRoleCode());
        setTimeZoneCode(e.getTimeZoneCode());
        setUpdatedUtcTs(e.getUpdatedUtcTs());
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyUserBase) )
            return false;

        MyUserBase e = (MyUserBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyUser e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyUser e)
    {
        if ( !Kmu.isEqual(getAuditLogTitle(), e.getAuditLogTitle()) ) return false;
        if ( !Kmu.isEqual(getCreatedUtcTs(), e.getCreatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getDomainSubtitle(), e.getDomainSubtitle()) ) return false;
        if ( !Kmu.isEqual(getDomainTitle(), e.getDomainTitle()) ) return false;
        if ( !Kmu.isEqual(getEmail(), e.getEmail()) ) return false;
        if ( !Kmu.isEqual(getEnabled(), e.getEnabled()) ) return false;
        if ( !Kmu.isEqual(getEnabledStatus(), e.getEnabledStatus()) ) return false;
        if ( !Kmu.isEqual(getFirstName(), e.getFirstName()) ) return false;
        if ( !Kmu.isEqual(getFormalName(), e.getFormalName()) ) return false;
        if ( !Kmu.isEqual(getFullName(), e.getFullName()) ) return false;
        if ( !Kmu.isEqual(getLastName(), e.getLastName()) ) return false;
        if ( !Kmu.isEqual(getLongName(), e.getLongName()) ) return false;
        if ( !Kmu.isEqual(getMemo(), e.getMemo()) ) return false;
        if ( !Kmu.isEqual(getNickname(), e.getNickname()) ) return false;
        if ( !Kmu.isEqual(getPasswordHash(), e.getPasswordHash()) ) return false;
        if ( !Kmu.isEqual(getPasswordSalt(), e.getPasswordSalt()) ) return false;
        if ( !Kmu.isEqual(getPhone(), e.getPhone()) ) return false;
        if ( !Kmu.isEqual(getRoleCode(), e.getRoleCode()) ) return false;
        if ( !Kmu.isEqual(getShortName(), e.getShortName()) ) return false;
        if ( !Kmu.isEqual(getTimeZoneCode(), e.getTimeZoneCode()) ) return false;
        if ( !Kmu.isEqual(getUpdatedUtcTs(), e.getUpdatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( !Kmu.isEqual(getRoleName(), e.getRoleName()) ) return false;
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

    public boolean isDifferent(MyUser e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyUser e)
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
        out.append("MyUser");
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
        System.out.println("    Memo = " + memo);
        System.out.println("    Nickname = " + nickname);
        System.out.println("    PasswordHash = " + passwordHash);
        System.out.println("    PasswordSalt = " + passwordSalt);
        System.out.println("    Phone = " + phone);
        System.out.println("    RoleCode = " + roleCode);
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
