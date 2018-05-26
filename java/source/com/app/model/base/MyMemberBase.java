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
public abstract class MyMemberBase
    extends MyAbstractDaoDomain<MyMember>
    implements KmUidDomainIF
    ,MyBasicTimestampsIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaMember Meta = MyMetaMember.instance;
    public static final MyMemberTools Tools = MyMemberTools.instance;
    public static final MyMemberValidator Validator = MyMemberValidator.instance;
    public static final MyMemberFinder Finder = MyMemberFinder.instance;

    //##################################################
    //# variables
    //##################################################

    private KmTimestamp createdUtcTs;
    private Integer dashboardLineCount1;
    private Integer dashboardLineCount2;
    private String dashboardOrientationTypeCode;
    private String dashboardPanelCodeA;
    private String dashboardPanelCodeB;
    private String dashboardPanelCodeC;
    private String dashboardPanelCodeD;
    private String dashboardPanelCodeE;
    private String dashboardPanelCodeF;
    private String dashboardPanelCodeG;
    private Integer dashboardRefreshMinutes;
    private Boolean enabled;
    private String roleCode;
    private String uid;
    private KmTimestamp updatedUtcTs;
    private Integer lockVersion;
    private MyUser createdBy;
    private MyProject project;
    private MyUser updatedBy;
    private MyUser user;

    //##################################################
    //# constructor
    //##################################################

    public MyMemberBase()
    {
        super();
        setCreatedUtcTs(nowUtc());
        setDashboardLineCount1(1);
        setDashboardLineCount2(0);
        setDashboardOrientationTypeCode(MyDashboardOrientationType.Auto.getCode());
        setDashboardPanelCodeA(MyDashboardPanelType.Welcome.getCode());
        setDashboardRefreshMinutes(5);
        setEnabled(true);
        setRoleCode(MyMemberRole.Worker.getCode());
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
    //# field (dashboardLineCount1)
    //##################################################

    public Integer getDashboardLineCount1()
    {
        return dashboardLineCount1;
    }

    public void setDashboardLineCount1(Integer e)
    {
        e = Validator.getDashboardLineCount1Validator().convert(e);
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
        e = Validator.getDashboardLineCount2Validator().convert(e);
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
    //# field (dashboardOrientationTypeCode)
    //##################################################

    public String getDashboardOrientationTypeCode()
    {
        return dashboardOrientationTypeCode;
    }

    public void setDashboardOrientationTypeCode(String e)
    {
        e = Validator.getDashboardOrientationTypeCodeValidator().convert(e);
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
    //# field (dashboardPanelCodeA)
    //##################################################

    public String getDashboardPanelCodeA()
    {
        return dashboardPanelCodeA;
    }

    public void setDashboardPanelCodeA(String e)
    {
        e = Validator.getDashboardPanelCodeAValidator().convert(e);
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
        e = Validator.getDashboardPanelCodeBValidator().convert(e);
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
        e = Validator.getDashboardPanelCodeCValidator().convert(e);
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
        e = Validator.getDashboardPanelCodeDValidator().convert(e);
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
        e = Validator.getDashboardPanelCodeEValidator().convert(e);
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
        e = Validator.getDashboardPanelCodeFValidator().convert(e);
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
        e = Validator.getDashboardPanelCodeGValidator().convert(e);
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
    //# field (dashboardRefreshMinutes)
    //##################################################

    public Integer getDashboardRefreshMinutes()
    {
        return dashboardRefreshMinutes;
    }

    public void setDashboardRefreshMinutes(Integer e)
    {
        e = Validator.getDashboardRefreshMinutesValidator().convert(e);
        dashboardRefreshMinutes = e;
    }

    public void clearDashboardRefreshMinutes()
    {
        setDashboardRefreshMinutes(null);
    }

    public boolean hasDashboardRefreshMinutes()
    {
        return getDashboardRefreshMinutes() != null;
    }

    public boolean hasDashboardRefreshMinutes(Integer e)
    {
        return Kmu.isEqual(getDashboardRefreshMinutes(), e);
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

    public MyMemberRole getRole()
    {
        return MyMemberRole.findCode(getRoleCode());
    }

    public void setRole(MyMemberRole e)
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

    public boolean hasRole(MyMemberRole e)
    {
        return getRole() == e;
    }

    public void setRoleManager()
    {
        setRole(MyMemberRole.Manager);
    }

    public boolean isRoleManager()
    {
        return hasRole(MyMemberRole.Manager);
    }

    public void setRoleWorker()
    {
        setRole(MyMemberRole.Worker);
    }

    public boolean isRoleWorker()
    {
        return hasRole(MyMemberRole.Worker);
    }

    //##################################################
    //# field (roleDescription)
    //##################################################

    public abstract String getRoleDescription();

    public boolean hasRoleDescription()
    {
        return Kmu.hasValue(getRoleDescription());
    }

    public boolean hasRoleDescription(String e)
    {
        return Kmu.isEqualIgnoreCase(getRoleDescription(), e);
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

    public String getProjectName()
    {
        if ( hasProject() )
            return getProject().getName();
        return null;
    }

    public void setProjectName(String e)
    {
        getProject().setName(e);
    }

    public boolean hasProjectName()
    {
        return hasProject() && getProject().hasName();
    }

    public boolean hasProjectName(String e)
    {
        return hasProject() && getProject().hasName(e);
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
    //# user
    //##################################################

    public MyUser getUser()
    {
        return user;
    }

    public void setUser(MyUser e)
    {
        user = e;
    }

    public void _setUser(MyUser e)
    {
        user = e;
    }

    public void clearUser()
    {
        setUser(null);
    }

    public boolean hasUser()
    {
        return getUser() != null;
    }

    public boolean hasUser(MyUser e)
    {
        return Kmu.isEqual(getUser(), e);
    }

    public String getUserFullName()
    {
        if ( hasUser() )
            return getUser().getFullName();
        return null;
    }

    public void setUserFullName(String e)
    {
        getUser().setFullName(e);
    }

    public boolean hasUserFullName()
    {
        return hasUser() && getUser().hasFullName();
    }

    public boolean hasUserFullName(String e)
    {
        return hasUser() && getUser().hasFullName(e);
    }

    public String getUserEmail()
    {
        if ( hasUser() )
            return getUser().getEmail();
        return null;
    }

    public void setUserEmail(String e)
    {
        getUser().setEmail(e);
    }

    public boolean hasUserEmail()
    {
        return hasUser() && getUser().hasEmail();
    }

    public boolean hasUserEmail(String e)
    {
        return hasUser() && getUser().hasEmail(e);
    }

    public String getUserTimeZoneCode()
    {
        if ( hasUser() )
            return getUser().getTimeZoneCode();
        return null;
    }

    public void setUserTimeZoneCode(String e)
    {
        getUser().setTimeZoneCode(e);
    }

    public boolean hasUserTimeZoneCode()
    {
        return hasUser() && getUser().hasTimeZoneCode();
    }

    public boolean hasUserTimeZoneCode(String e)
    {
        return hasUser() && getUser().hasTimeZoneCode(e);
    }


    //##################################################
    //# validate
    //##################################################

    @Override
    protected final MyMemberValidator getValidator()
    {
        return Validator;
    }

    @Override
    protected final MyMember asSubclass()
    {
        return (MyMember)this;
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyMember getCopy()
    {
        return (MyMember)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = newUid();
        project = null;
    }

    /**
     * Get a copy of this model without any associations or collections.
     * The primary key and lock version are not copied.
     * The basic timestamps are reset.
     */
    public final MyMember getBasicCopy()
    {
        MyMember e;
        e = new MyMember();
        applyEditableFieldsTo(e);
        resetBasicTimestamps();
        return e;
    }

    /**
     * Apply the editable fields TO another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsTo(MyMember e)
    {
        e.setCreatedUtcTs(getCreatedUtcTs());
        e.setDashboardLineCount1(getDashboardLineCount1());
        e.setDashboardLineCount2(getDashboardLineCount2());
        e.setDashboardOrientationTypeCode(getDashboardOrientationTypeCode());
        e.setDashboardPanelCodeA(getDashboardPanelCodeA());
        e.setDashboardPanelCodeB(getDashboardPanelCodeB());
        e.setDashboardPanelCodeC(getDashboardPanelCodeC());
        e.setDashboardPanelCodeD(getDashboardPanelCodeD());
        e.setDashboardPanelCodeE(getDashboardPanelCodeE());
        e.setDashboardPanelCodeF(getDashboardPanelCodeF());
        e.setDashboardPanelCodeG(getDashboardPanelCodeG());
        e.setDashboardRefreshMinutes(getDashboardRefreshMinutes());
        e.setEnabled(getEnabled());
        e.setRoleCode(getRoleCode());
        e.setUpdatedUtcTs(getUpdatedUtcTs());
    }

    /**
     * Apply the editable fields FROM another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsFrom(MyMember e)
    {
        setCreatedUtcTs(e.getCreatedUtcTs());
        setDashboardLineCount1(e.getDashboardLineCount1());
        setDashboardLineCount2(e.getDashboardLineCount2());
        setDashboardOrientationTypeCode(e.getDashboardOrientationTypeCode());
        setDashboardPanelCodeA(e.getDashboardPanelCodeA());
        setDashboardPanelCodeB(e.getDashboardPanelCodeB());
        setDashboardPanelCodeC(e.getDashboardPanelCodeC());
        setDashboardPanelCodeD(e.getDashboardPanelCodeD());
        setDashboardPanelCodeE(e.getDashboardPanelCodeE());
        setDashboardPanelCodeF(e.getDashboardPanelCodeF());
        setDashboardPanelCodeG(e.getDashboardPanelCodeG());
        setDashboardRefreshMinutes(e.getDashboardRefreshMinutes());
        setEnabled(e.getEnabled());
        setRoleCode(e.getRoleCode());
        setUpdatedUtcTs(e.getUpdatedUtcTs());
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyMemberBase) )
            return false;

        MyMemberBase e = (MyMemberBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyMember e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyMember e)
    {
        if ( !Kmu.isEqual(getAuditLogTitle(), e.getAuditLogTitle()) ) return false;
        if ( !Kmu.isEqual(getCreatedUtcTs(), e.getCreatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getDashboardLineCount1(), e.getDashboardLineCount1()) ) return false;
        if ( !Kmu.isEqual(getDashboardLineCount2(), e.getDashboardLineCount2()) ) return false;
        if ( !Kmu.isEqual(getDashboardOrientationTypeCode(), e.getDashboardOrientationTypeCode()) ) return false;
        if ( !Kmu.isEqual(getDashboardPanelCodeA(), e.getDashboardPanelCodeA()) ) return false;
        if ( !Kmu.isEqual(getDashboardPanelCodeB(), e.getDashboardPanelCodeB()) ) return false;
        if ( !Kmu.isEqual(getDashboardPanelCodeC(), e.getDashboardPanelCodeC()) ) return false;
        if ( !Kmu.isEqual(getDashboardPanelCodeD(), e.getDashboardPanelCodeD()) ) return false;
        if ( !Kmu.isEqual(getDashboardPanelCodeE(), e.getDashboardPanelCodeE()) ) return false;
        if ( !Kmu.isEqual(getDashboardPanelCodeF(), e.getDashboardPanelCodeF()) ) return false;
        if ( !Kmu.isEqual(getDashboardPanelCodeG(), e.getDashboardPanelCodeG()) ) return false;
        if ( !Kmu.isEqual(getDashboardRefreshMinutes(), e.getDashboardRefreshMinutes()) ) return false;
        if ( !Kmu.isEqual(getDomainSubtitle(), e.getDomainSubtitle()) ) return false;
        if ( !Kmu.isEqual(getDomainTitle(), e.getDomainTitle()) ) return false;
        if ( !Kmu.isEqual(getEnabled(), e.getEnabled()) ) return false;
        if ( !Kmu.isEqual(getEnabledStatus(), e.getEnabledStatus()) ) return false;
        if ( !Kmu.isEqual(getRoleCode(), e.getRoleCode()) ) return false;
        if ( !Kmu.isEqual(getRoleDescription(), e.getRoleDescription()) ) return false;
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

    public boolean isDifferent(MyMember e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyMember e)
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
        out.append("MyMember");
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
        System.out.println("    DashboardLineCount1 = " + dashboardLineCount1);
        System.out.println("    DashboardLineCount2 = " + dashboardLineCount2);
        System.out.println("    DashboardOrientationTypeCode = " + dashboardOrientationTypeCode);
        System.out.println("    DashboardPanelCodeA = " + dashboardPanelCodeA);
        System.out.println("    DashboardPanelCodeB = " + dashboardPanelCodeB);
        System.out.println("    DashboardPanelCodeC = " + dashboardPanelCodeC);
        System.out.println("    DashboardPanelCodeD = " + dashboardPanelCodeD);
        System.out.println("    DashboardPanelCodeE = " + dashboardPanelCodeE);
        System.out.println("    DashboardPanelCodeF = " + dashboardPanelCodeF);
        System.out.println("    DashboardPanelCodeG = " + dashboardPanelCodeG);
        System.out.println("    DashboardRefreshMinutes = " + dashboardRefreshMinutes);
        System.out.println("    Enabled = " + enabled);
        System.out.println("    RoleCode = " + roleCode);
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
