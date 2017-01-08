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
public abstract class MyUserBase
    extends MyAbstractDomain
    implements MyUidDomainIF
    ,MyBasicTimestampsIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaUser Meta = MyMetaUser.instance;
    public static final MyUserTools Tools = MyUserTools.instance;
    public static final MyUserValidator Validator = MyUserValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private KmTimestamp createdUtcTs;
    private KmTimestamp updatedUtcTs;
    private String firstName;
    private String lastName;
    private String nickname;
    private String email;
    private String passwordSalt;
    private String passwordHash;
    private String phone;
    private Boolean active;
    private String timeZoneCode;
    private String roleCode;
    private String dashboardOrientationTypeCode;
    private Integer dashboardLineCount1;
    private Integer dashboardLineCount2;
    private String dashboardPanelCodeA;
    private String dashboardPanelCodeB;
    private String dashboardPanelCodeC;
    private String dashboardPanelCodeD;
    private String dashboardPanelCodeE;
    private String dashboardPanelCodeF;
    private String dashboardPanelCodeG;
    private Integer lockVersion;
    private MyUser createdBy;
    private MyUser updatedBy;
    private MyTenant tenant;
    private MyProject lastProject;

    //##################################################
    //# constructor
    //##################################################

    public MyUserBase()
    {
        super();
        setUid(newUid());
        setCreatedUtcTs(nowUtc());
        setUpdatedUtcTs(nowUtc());
        setPasswordSalt(newUid());
        setActive(true);
        setRoleCode(MyUserRole.Other.getCode());
        setDashboardOrientationTypeCode(MyDashboardOrientationType.Auto.getCode());
        setDashboardLineCount1(1);
        setDashboardLineCount2(0);
        setDashboardPanelCodeA(MyDashboardPanelType.Welcome.getCode());
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
    //# field (firstName)
    //##################################################

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String e)
    {
        e = Validator.getFirstNameValidator().convertOnly(e);
        firstName = e;
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
    //# field (lastName)
    //##################################################

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String e)
    {
        e = Validator.getLastNameValidator().convertOnly(e);
        lastName = e;
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
    //# field (nickname)
    //##################################################

    public String getNickname()
    {
        return nickname;
    }

    public void setNickname(String e)
    {
        e = Validator.getNicknameValidator().convertOnly(e);
        nickname = e;
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
    //# field (email)
    //##################################################

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String e)
    {
        e = Validator.getEmailValidator().convertOnly(e);
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
    //# field (passwordSalt)
    //##################################################

    public String getPasswordSalt()
    {
        return passwordSalt;
    }

    public void setPasswordSalt(String e)
    {
        e = Validator.getPasswordSaltValidator().convertOnly(e);
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
    //# field (passwordHash)
    //##################################################

    public String getPasswordHash()
    {
        return passwordHash;
    }

    public void setPasswordHash(String e)
    {
        e = Validator.getPasswordHashValidator().convertOnly(e);
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
    //# field (phone)
    //##################################################

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String e)
    {
        e = Validator.getPhoneValidator().convertOnly(e);
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
    //# field (timeZoneCode)
    //##################################################

    public String getTimeZoneCode()
    {
        return timeZoneCode;
    }

    public void setTimeZoneCode(String e)
    {
        e = Validator.getTimeZoneCodeValidator().convertOnly(e);
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
    //# field (roleCode)
    //##################################################

    public String getRoleCode()
    {
        return roleCode;
    }

    public void setRoleCode(String e)
    {
        e = Validator.getRoleCodeValidator().convertOnly(e);
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

    public boolean isNotRoleDeveloper()
    {
        return !isRoleDeveloper();
    }

    public void setRoleAdmin()
    {
        setRole(MyUserRole.Admin);
    }

    public boolean isRoleAdmin()
    {
        return hasRole(MyUserRole.Admin);
    }

    public boolean isNotRoleAdmin()
    {
        return !isRoleAdmin();
    }

    public void setRoleOther()
    {
        setRole(MyUserRole.Other);
    }

    public boolean isRoleOther()
    {
        return hasRole(MyUserRole.Other);
    }

    public boolean isNotRoleOther()
    {
        return !isRoleOther();
    }

    //##################################################
    //# field (dashboardOrientationTypeCode)
    //##################################################

    public String getDashboardOrientationTypeCode()
    {
        return dashboardOrientationTypeCode;
    }

    public void setDashboardOrientationTypeCode(String e)
    {
        e = Validator.getDashboardOrientationTypeCodeValidator().convertOnly(e);
        dashboardOrientationTypeCode = e;
    }

    public void clearDashboardOrientationTypeCode()
    {
        setDashboardOrientationTypeCode(null);
    }

    public boolean hasDashboardOrientationTypeCode()
    {
        return Kmu.hasValue(getDashboardOrientationTypeCode());
    }

    public boolean hasDashboardOrientationTypeCode(String e)
    {
        return Kmu.isEqualIgnoreCase(getDashboardOrientationTypeCode(), e);
    }

    public void truncateDashboardOrientationTypeCode()
    {
        truncateDashboardOrientationTypeCode(false);
    }

    public void truncateDashboardOrientationTypeCode(boolean ellipses)
    {
        dashboardOrientationTypeCode = Kmu.truncate(dashboardOrientationTypeCode, 30, ellipses);
    }

    //##################################################
    //# field (dashboardLineCount1)
    //##################################################

    public Integer getDashboardLineCount1()
    {
        return dashboardLineCount1;
    }

    public void setDashboardLineCount1(Integer e)
    {
        e = Validator.getDashboardLineCount1Validator().convertOnly(e);
        dashboardLineCount1 = e;
    }

    public void clearDashboardLineCount1()
    {
        setDashboardLineCount1(null);
    }

    public boolean hasDashboardLineCount1()
    {
        return getDashboardLineCount1() != null;
    }

    public boolean hasDashboardLineCount1(Integer e)
    {
        return Kmu.isEqual(getDashboardLineCount1(), e);
    }

    //##################################################
    //# field (dashboardLineCount2)
    //##################################################

    public Integer getDashboardLineCount2()
    {
        return dashboardLineCount2;
    }

    public void setDashboardLineCount2(Integer e)
    {
        e = Validator.getDashboardLineCount2Validator().convertOnly(e);
        dashboardLineCount2 = e;
    }

    public void clearDashboardLineCount2()
    {
        setDashboardLineCount2(null);
    }

    public boolean hasDashboardLineCount2()
    {
        return getDashboardLineCount2() != null;
    }

    public boolean hasDashboardLineCount2(Integer e)
    {
        return Kmu.isEqual(getDashboardLineCount2(), e);
    }

    //##################################################
    //# field (dashboardPanelCodeA)
    //##################################################

    public String getDashboardPanelCodeA()
    {
        return dashboardPanelCodeA;
    }

    public void setDashboardPanelCodeA(String e)
    {
        e = Validator.getDashboardPanelCodeAValidator().convertOnly(e);
        dashboardPanelCodeA = e;
    }

    public void clearDashboardPanelCodeA()
    {
        setDashboardPanelCodeA(null);
    }

    public boolean hasDashboardPanelCodeA()
    {
        return Kmu.hasValue(getDashboardPanelCodeA());
    }

    public boolean hasDashboardPanelCodeA(String e)
    {
        return Kmu.isEqualIgnoreCase(getDashboardPanelCodeA(), e);
    }

    public void truncateDashboardPanelCodeA()
    {
        truncateDashboardPanelCodeA(false);
    }

    public void truncateDashboardPanelCodeA(boolean ellipses)
    {
        dashboardPanelCodeA = Kmu.truncate(dashboardPanelCodeA, 30, ellipses);
    }

    //##################################################
    //# field (dashboardPanelCodeB)
    //##################################################

    public String getDashboardPanelCodeB()
    {
        return dashboardPanelCodeB;
    }

    public void setDashboardPanelCodeB(String e)
    {
        e = Validator.getDashboardPanelCodeBValidator().convertOnly(e);
        dashboardPanelCodeB = e;
    }

    public void clearDashboardPanelCodeB()
    {
        setDashboardPanelCodeB(null);
    }

    public boolean hasDashboardPanelCodeB()
    {
        return Kmu.hasValue(getDashboardPanelCodeB());
    }

    public boolean hasDashboardPanelCodeB(String e)
    {
        return Kmu.isEqualIgnoreCase(getDashboardPanelCodeB(), e);
    }

    public void truncateDashboardPanelCodeB()
    {
        truncateDashboardPanelCodeB(false);
    }

    public void truncateDashboardPanelCodeB(boolean ellipses)
    {
        dashboardPanelCodeB = Kmu.truncate(dashboardPanelCodeB, 30, ellipses);
    }

    //##################################################
    //# field (dashboardPanelCodeC)
    //##################################################

    public String getDashboardPanelCodeC()
    {
        return dashboardPanelCodeC;
    }

    public void setDashboardPanelCodeC(String e)
    {
        e = Validator.getDashboardPanelCodeCValidator().convertOnly(e);
        dashboardPanelCodeC = e;
    }

    public void clearDashboardPanelCodeC()
    {
        setDashboardPanelCodeC(null);
    }

    public boolean hasDashboardPanelCodeC()
    {
        return Kmu.hasValue(getDashboardPanelCodeC());
    }

    public boolean hasDashboardPanelCodeC(String e)
    {
        return Kmu.isEqualIgnoreCase(getDashboardPanelCodeC(), e);
    }

    public void truncateDashboardPanelCodeC()
    {
        truncateDashboardPanelCodeC(false);
    }

    public void truncateDashboardPanelCodeC(boolean ellipses)
    {
        dashboardPanelCodeC = Kmu.truncate(dashboardPanelCodeC, 30, ellipses);
    }

    //##################################################
    //# field (dashboardPanelCodeD)
    //##################################################

    public String getDashboardPanelCodeD()
    {
        return dashboardPanelCodeD;
    }

    public void setDashboardPanelCodeD(String e)
    {
        e = Validator.getDashboardPanelCodeDValidator().convertOnly(e);
        dashboardPanelCodeD = e;
    }

    public void clearDashboardPanelCodeD()
    {
        setDashboardPanelCodeD(null);
    }

    public boolean hasDashboardPanelCodeD()
    {
        return Kmu.hasValue(getDashboardPanelCodeD());
    }

    public boolean hasDashboardPanelCodeD(String e)
    {
        return Kmu.isEqualIgnoreCase(getDashboardPanelCodeD(), e);
    }

    public void truncateDashboardPanelCodeD()
    {
        truncateDashboardPanelCodeD(false);
    }

    public void truncateDashboardPanelCodeD(boolean ellipses)
    {
        dashboardPanelCodeD = Kmu.truncate(dashboardPanelCodeD, 30, ellipses);
    }

    //##################################################
    //# field (dashboardPanelCodeE)
    //##################################################

    public String getDashboardPanelCodeE()
    {
        return dashboardPanelCodeE;
    }

    public void setDashboardPanelCodeE(String e)
    {
        e = Validator.getDashboardPanelCodeEValidator().convertOnly(e);
        dashboardPanelCodeE = e;
    }

    public void clearDashboardPanelCodeE()
    {
        setDashboardPanelCodeE(null);
    }

    public boolean hasDashboardPanelCodeE()
    {
        return Kmu.hasValue(getDashboardPanelCodeE());
    }

    public boolean hasDashboardPanelCodeE(String e)
    {
        return Kmu.isEqualIgnoreCase(getDashboardPanelCodeE(), e);
    }

    public void truncateDashboardPanelCodeE()
    {
        truncateDashboardPanelCodeE(false);
    }

    public void truncateDashboardPanelCodeE(boolean ellipses)
    {
        dashboardPanelCodeE = Kmu.truncate(dashboardPanelCodeE, 30, ellipses);
    }

    //##################################################
    //# field (dashboardPanelCodeF)
    //##################################################

    public String getDashboardPanelCodeF()
    {
        return dashboardPanelCodeF;
    }

    public void setDashboardPanelCodeF(String e)
    {
        e = Validator.getDashboardPanelCodeFValidator().convertOnly(e);
        dashboardPanelCodeF = e;
    }

    public void clearDashboardPanelCodeF()
    {
        setDashboardPanelCodeF(null);
    }

    public boolean hasDashboardPanelCodeF()
    {
        return Kmu.hasValue(getDashboardPanelCodeF());
    }

    public boolean hasDashboardPanelCodeF(String e)
    {
        return Kmu.isEqualIgnoreCase(getDashboardPanelCodeF(), e);
    }

    public void truncateDashboardPanelCodeF()
    {
        truncateDashboardPanelCodeF(false);
    }

    public void truncateDashboardPanelCodeF(boolean ellipses)
    {
        dashboardPanelCodeF = Kmu.truncate(dashboardPanelCodeF, 30, ellipses);
    }

    //##################################################
    //# field (dashboardPanelCodeG)
    //##################################################

    public String getDashboardPanelCodeG()
    {
        return dashboardPanelCodeG;
    }

    public void setDashboardPanelCodeG(String e)
    {
        e = Validator.getDashboardPanelCodeGValidator().convertOnly(e);
        dashboardPanelCodeG = e;
    }

    public void clearDashboardPanelCodeG()
    {
        setDashboardPanelCodeG(null);
    }

    public boolean hasDashboardPanelCodeG()
    {
        return Kmu.hasValue(getDashboardPanelCodeG());
    }

    public boolean hasDashboardPanelCodeG(String e)
    {
        return Kmu.isEqualIgnoreCase(getDashboardPanelCodeG(), e);
    }

    public void truncateDashboardPanelCodeG()
    {
        truncateDashboardPanelCodeG(false);
    }

    public void truncateDashboardPanelCodeG(boolean ellipses)
    {
        dashboardPanelCodeG = Kmu.truncate(dashboardPanelCodeG, 30, ellipses);
    }

    //##################################################
    //# field (fullName)
    //##################################################

    public abstract String getFullName();

    public boolean hasFullName()
    {
        return Kmu.hasValue(getFullName());
    }

    public boolean hasFullName(String e)
    {
        return Kmu.isEqualIgnoreCase(getFullName(), e);
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
    //# lastProject
    //##################################################

    public MyProject getLastProject()
    {
        return lastProject;
    }

    public void setLastProject(MyProject e)
    {
        lastProject = e;
    }

    public void _setLastProject(MyProject e)
    {
        lastProject = e;
    }

    public void clearLastProject()
    {
        setLastProject(null);
    }

    public boolean hasLastProject()
    {
        return getLastProject() != null;
    }

    public boolean hasLastProject(MyProject e)
    {
        return Kmu.isEqual(getLastProject(), e);
    }


    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyUser)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyUser)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyUser)this);
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
        e.setCreatedUtcTs(getCreatedUtcTs());
        e.setUpdatedUtcTs(getUpdatedUtcTs());
        e.setFirstName(getFirstName());
        e.setLastName(getLastName());
        e.setNickname(getNickname());
        e.setEmail(getEmail());
        e.setPasswordSalt(getPasswordSalt());
        e.setPasswordHash(getPasswordHash());
        e.setPhone(getPhone());
        e.setActive(getActive());
        e.setTimeZoneCode(getTimeZoneCode());
        e.setRoleCode(getRoleCode());
        e.setDashboardOrientationTypeCode(getDashboardOrientationTypeCode());
        e.setDashboardLineCount1(getDashboardLineCount1());
        e.setDashboardLineCount2(getDashboardLineCount2());
        e.setDashboardPanelCodeA(getDashboardPanelCodeA());
        e.setDashboardPanelCodeB(getDashboardPanelCodeB());
        e.setDashboardPanelCodeC(getDashboardPanelCodeC());
        e.setDashboardPanelCodeD(getDashboardPanelCodeD());
        e.setDashboardPanelCodeE(getDashboardPanelCodeE());
        e.setDashboardPanelCodeF(getDashboardPanelCodeF());
        e.setDashboardPanelCodeG(getDashboardPanelCodeG());
        resetBasicTimestamps();
        return e;
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
        if ( !Kmu.isEqual(getCreatedUtcTs(), e.getCreatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getUpdatedUtcTs(), e.getUpdatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getFirstName(), e.getFirstName()) ) return false;
        if ( !Kmu.isEqual(getLastName(), e.getLastName()) ) return false;
        if ( !Kmu.isEqual(getNickname(), e.getNickname()) ) return false;
        if ( !Kmu.isEqual(getEmail(), e.getEmail()) ) return false;
        if ( !Kmu.isEqual(getPasswordSalt(), e.getPasswordSalt()) ) return false;
        if ( !Kmu.isEqual(getPasswordHash(), e.getPasswordHash()) ) return false;
        if ( !Kmu.isEqual(getPhone(), e.getPhone()) ) return false;
        if ( !Kmu.isEqual(getActive(), e.getActive()) ) return false;
        if ( !Kmu.isEqual(getTimeZoneCode(), e.getTimeZoneCode()) ) return false;
        if ( !Kmu.isEqual(getRoleCode(), e.getRoleCode()) ) return false;
        if ( !Kmu.isEqual(getDashboardOrientationTypeCode(), e.getDashboardOrientationTypeCode()) ) return false;
        if ( !Kmu.isEqual(getDashboardLineCount1(), e.getDashboardLineCount1()) ) return false;
        if ( !Kmu.isEqual(getDashboardLineCount2(), e.getDashboardLineCount2()) ) return false;
        if ( !Kmu.isEqual(getDashboardPanelCodeA(), e.getDashboardPanelCodeA()) ) return false;
        if ( !Kmu.isEqual(getDashboardPanelCodeB(), e.getDashboardPanelCodeB()) ) return false;
        if ( !Kmu.isEqual(getDashboardPanelCodeC(), e.getDashboardPanelCodeC()) ) return false;
        if ( !Kmu.isEqual(getDashboardPanelCodeD(), e.getDashboardPanelCodeD()) ) return false;
        if ( !Kmu.isEqual(getDashboardPanelCodeE(), e.getDashboardPanelCodeE()) ) return false;
        if ( !Kmu.isEqual(getDashboardPanelCodeF(), e.getDashboardPanelCodeF()) ) return false;
        if ( !Kmu.isEqual(getDashboardPanelCodeG(), e.getDashboardPanelCodeG()) ) return false;
        if ( !Kmu.isEqual(getFullName(), e.getFullName()) ) return false;
        if ( !Kmu.isEqual(getFormalName(), e.getFormalName()) ) return false;
        if ( !Kmu.isEqual(getShortName(), e.getShortName()) ) return false;
        if ( !Kmu.isEqual(getLongName(), e.getLongName()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( !Kmu.isEqual(getDisplayString(), e.getDisplayString()) ) return false;
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
        System.out.println("    Uid = " + uid);
        System.out.println("    CreatedUtcTs = " + createdUtcTs);
        System.out.println("    UpdatedUtcTs = " + updatedUtcTs);
        System.out.println("    FirstName = " + firstName);
        System.out.println("    LastName = " + lastName);
        System.out.println("    Nickname = " + nickname);
        System.out.println("    Email = " + email);
        System.out.println("    PasswordSalt = " + passwordSalt);
        System.out.println("    PasswordHash = " + passwordHash);
        System.out.println("    Phone = " + phone);
        System.out.println("    Active = " + active);
        System.out.println("    TimeZoneCode = " + timeZoneCode);
        System.out.println("    RoleCode = " + roleCode);
        System.out.println("    DashboardOrientationTypeCode = " + dashboardOrientationTypeCode);
        System.out.println("    DashboardLineCount1 = " + dashboardLineCount1);
        System.out.println("    DashboardLineCount2 = " + dashboardLineCount2);
        System.out.println("    DashboardPanelCodeA = " + dashboardPanelCodeA);
        System.out.println("    DashboardPanelCodeB = " + dashboardPanelCodeB);
        System.out.println("    DashboardPanelCodeC = " + dashboardPanelCodeC);
        System.out.println("    DashboardPanelCodeD = " + dashboardPanelCodeD);
        System.out.println("    DashboardPanelCodeE = " + dashboardPanelCodeE);
        System.out.println("    DashboardPanelCodeF = " + dashboardPanelCodeF);
        System.out.println("    DashboardPanelCodeG = " + dashboardPanelCodeG);
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
