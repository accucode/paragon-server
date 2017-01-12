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
public abstract class MyInvitationBase
    extends MyAbstractDaoDomain
    implements MyUidDomainIF
    ,MyBasicTimestampsIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaInvitation Meta = MyMetaInvitation.instance;
    public static final MyInvitationTools Tools = MyInvitationTools.instance;
    public static final MyInvitationValidator Validator = MyInvitationValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private KmTimestamp createdUtcTs;
    private KmTimestamp updatedUtcTs;
    private String typeCode;
    private String statusCode;
    private KmTimestamp closedUtcTs;
    private String toEmail;
    private String roleCode;
    private Integer lockVersion;
    private MyUser createdBy;
    private MyUser updatedBy;
    private MyUser fromUser;
    private MyProject project;

    //##################################################
    //# constructor
    //##################################################

    public MyInvitationBase()
    {
        super();
        setUid(newUid());
        setCreatedUtcTs(nowUtc());
        setUpdatedUtcTs(nowUtc());
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
    //# field (typeCode)
    //##################################################

    public String getTypeCode()
    {
        return typeCode;
    }

    public void setTypeCode(String e)
    {
        e = Validator.getTypeCodeValidator().convertOnly(e);
        typeCode = e;
    }

    public void clearTypeCode()
    {
        setTypeCode(null);
    }

    public boolean hasTypeCode()
    {
        return Kmu.hasValue(getTypeCode());
    }

    public boolean hasTypeCode(String e)
    {
        return Kmu.isEqualIgnoreCase(getTypeCode(), e);
    }

    public void truncateTypeCode()
    {
        truncateTypeCode(false);
    }

    public void truncateTypeCode(boolean ellipses)
    {
        typeCode = Kmu.truncate(typeCode, 30, ellipses);
    }

    public MyInvitationType getType()
    {
        return MyInvitationType.findCode(getTypeCode());
    }

    public void setType(MyInvitationType e)
    {
        if ( e == null )
            setTypeCode(null);
        else
            setTypeCode(e.getCode());
    }

    public boolean hasType()
    {
        return getType() != null;
    }

    public boolean hasType(MyInvitationType e)
    {
        return getType() == e;
    }

    public void setTypeJoinAccount()
    {
        setType(MyInvitationType.JoinAccount);
    }

    public boolean isTypeJoinAccount()
    {
        return hasType(MyInvitationType.JoinAccount);
    }

    public boolean isNotTypeJoinAccount()
    {
        return !isTypeJoinAccount();
    }

    //##################################################
    //# field (statusCode)
    //##################################################

    public String getStatusCode()
    {
        return statusCode;
    }

    public void setStatusCode(String e)
    {
        e = Validator.getStatusCodeValidator().convertOnly(e);
        statusCode = e;
    }

    public void clearStatusCode()
    {
        setStatusCode(null);
    }

    public boolean hasStatusCode()
    {
        return Kmu.hasValue(getStatusCode());
    }

    public boolean hasStatusCode(String e)
    {
        return Kmu.isEqualIgnoreCase(getStatusCode(), e);
    }

    public void truncateStatusCode()
    {
        truncateStatusCode(false);
    }

    public void truncateStatusCode(boolean ellipses)
    {
        statusCode = Kmu.truncate(statusCode, 30, ellipses);
    }

    public MyInvitationStatus getStatus()
    {
        return MyInvitationStatus.findCode(getStatusCode());
    }

    public void setStatus(MyInvitationStatus e)
    {
        if ( e == null )
            setStatusCode(null);
        else
            setStatusCode(e.getCode());
    }

    public boolean hasStatus()
    {
        return getStatus() != null;
    }

    public boolean hasStatus(MyInvitationStatus e)
    {
        return getStatus() == e;
    }

    public void setStatusPending()
    {
        setStatus(MyInvitationStatus.Pending);
    }

    public boolean isStatusPending()
    {
        return hasStatus(MyInvitationStatus.Pending);
    }

    public boolean isNotStatusPending()
    {
        return !isStatusPending();
    }

    public void setStatusAccepted()
    {
        setStatus(MyInvitationStatus.Accepted);
    }

    public boolean isStatusAccepted()
    {
        return hasStatus(MyInvitationStatus.Accepted);
    }

    public boolean isNotStatusAccepted()
    {
        return !isStatusAccepted();
    }

    public void setStatusRejected()
    {
        setStatus(MyInvitationStatus.Rejected);
    }

    public boolean isStatusRejected()
    {
        return hasStatus(MyInvitationStatus.Rejected);
    }

    public boolean isNotStatusRejected()
    {
        return !isStatusRejected();
    }

    public void setStatusExpired()
    {
        setStatus(MyInvitationStatus.Expired);
    }

    public boolean isStatusExpired()
    {
        return hasStatus(MyInvitationStatus.Expired);
    }

    public boolean isNotStatusExpired()
    {
        return !isStatusExpired();
    }

    public void setStatusCancelled()
    {
        setStatus(MyInvitationStatus.Cancelled);
    }

    public boolean isStatusCancelled()
    {
        return hasStatus(MyInvitationStatus.Cancelled);
    }

    public boolean isNotStatusCancelled()
    {
        return !isStatusCancelled();
    }

    //##################################################
    //# field (closedUtcTs)
    //##################################################

    public KmTimestamp getClosedUtcTs()
    {
        return closedUtcTs;
    }

    public void setClosedUtcTs(KmTimestamp e)
    {
        e = Validator.getClosedUtcTsValidator().convertOnly(e);
        closedUtcTs = e;
    }

    public void clearClosedUtcTs()
    {
        setClosedUtcTs(null);
    }

    public boolean hasClosedUtcTs()
    {
        return getClosedUtcTs() != null;
    }

    public boolean hasClosedUtcTs(KmTimestamp e)
    {
        return Kmu.isEqual(getClosedUtcTs(), e);
    }

    //##################################################
    //# field (toEmail)
    //##################################################

    public String getToEmail()
    {
        return toEmail;
    }

    public void setToEmail(String e)
    {
        e = Validator.getToEmailValidator().convertOnly(e);
        toEmail = e;
    }

    public void clearToEmail()
    {
        setToEmail(null);
    }

    public boolean hasToEmail()
    {
        return Kmu.hasValue(getToEmail());
    }

    public boolean hasToEmail(String e)
    {
        return Kmu.isEqualIgnoreCase(getToEmail(), e);
    }

    public void truncateToEmail()
    {
        truncateToEmail(false);
    }

    public void truncateToEmail(boolean ellipses)
    {
        toEmail = Kmu.truncate(toEmail, 50, ellipses);
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
        roleCode = Kmu.truncate(roleCode, 1, ellipses);
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
    //# field (typeName)
    //##################################################

    public final String getTypeName()
    {
        return KmEnumIF.getLabelFor(getType());
    }

    public boolean hasTypeName()
    {
        return Kmu.hasValue(getTypeName());
    }

    public boolean hasTypeName(String e)
    {
        return Kmu.isEqualIgnoreCase(getTypeName(), e);
    }

    //##################################################
    //# field (statusName)
    //##################################################

    public final String getStatusName()
    {
        return KmEnumIF.getLabelFor(getStatus());
    }

    public boolean hasStatusName()
    {
        return Kmu.hasValue(getStatusName());
    }

    public boolean hasStatusName(String e)
    {
        return Kmu.isEqualIgnoreCase(getStatusName(), e);
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
    //# field (closedLocalTs)
    //##################################################

    public final KmTimestamp getClosedLocalTs()
    {
        return KmTimestampUtility.toLocal(getClosedUtcTs());
    }

    public boolean hasClosedLocalTs()
    {
        return getClosedLocalTs() != null;
    }

    public boolean hasClosedLocalTs(KmTimestamp e)
    {
        return Kmu.isEqual(getClosedLocalTs(), e);
    }

    //##################################################
    //# field (closedLocalTsMessage)
    //##################################################

    public final String getClosedLocalTsMessage()
    {
        return KmTimestampUtility.formatLocalMessage(getClosedUtcTs());
    }

    public boolean hasClosedLocalTsMessage()
    {
        return Kmu.hasValue(getClosedLocalTsMessage());
    }

    public boolean hasClosedLocalTsMessage(String e)
    {
        return Kmu.isEqualIgnoreCase(getClosedLocalTsMessage(), e);
    }

    //##################################################
    //# field (closedLocalDate)
    //##################################################

    public final KmDate getClosedLocalDate()
    {
        return KmTimestampUtility.getDate(getClosedLocalTs());
    }

    public boolean hasClosedLocalDate()
    {
        return getClosedLocalDate() != null;
    }

    public boolean hasClosedLocalDate(KmDate e)
    {
        return Kmu.isEqual(getClosedLocalDate(), e);
    }

    //##################################################
    //# field (closedLocalTime)
    //##################################################

    public final KmTime getClosedLocalTime()
    {
        return KmTimestampUtility.getTime(getClosedLocalTs());
    }

    public boolean hasClosedLocalTime()
    {
        return getClosedLocalTime() != null;
    }

    public boolean hasClosedLocalTime(KmTime e)
    {
        return Kmu.isEqual(getClosedLocalTime(), e);
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
    //# fromUser
    //##################################################

    public MyUser getFromUser()
    {
        return fromUser;
    }

    public void setFromUser(MyUser e)
    {
        fromUser = e;
    }

    public void _setFromUser(MyUser e)
    {
        fromUser = e;
    }

    public void clearFromUser()
    {
        setFromUser(null);
    }

    public boolean hasFromUser()
    {
        return getFromUser() != null;
    }

    public boolean hasFromUser(MyUser e)
    {
        return Kmu.isEqual(getFromUser(), e);
    }

    public String getFromUserFullName()
    {
        if ( hasFromUser() )
            return getFromUser().getFullName();
        return null;
    }

    public boolean hasFromUserFullName()
    {
        return hasFromUser() && getFromUser().hasFullName();
    }

    public boolean hasFromUserFullName(String e)
    {
        return hasFromUser() && getFromUser().hasFullName(e);
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
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyInvitation)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyInvitation)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyInvitation)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyInvitation getCopy()
    {
        return (MyInvitation)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = newUid();
    }

    /**
     * Get a copy of this model without any associations or collections.
     * The primary key and lock version are not copied.
     * The basic timestamps are reset.
     */
    public final MyInvitation getBasicCopy()
    {
        MyInvitation e;
        e = new MyInvitation();
        e.setCreatedUtcTs(getCreatedUtcTs());
        e.setUpdatedUtcTs(getUpdatedUtcTs());
        e.setTypeCode(getTypeCode());
        e.setStatusCode(getStatusCode());
        e.setClosedUtcTs(getClosedUtcTs());
        e.setToEmail(getToEmail());
        e.setRoleCode(getRoleCode());
        resetBasicTimestamps();
        return e;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyInvitationBase) )
            return false;

        MyInvitationBase e = (MyInvitationBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyInvitation e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyInvitation e)
    {
        if ( !Kmu.isEqual(getCreatedUtcTs(), e.getCreatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getUpdatedUtcTs(), e.getUpdatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getTypeCode(), e.getTypeCode()) ) return false;
        if ( !Kmu.isEqual(getStatusCode(), e.getStatusCode()) ) return false;
        if ( !Kmu.isEqual(getClosedUtcTs(), e.getClosedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getToEmail(), e.getToEmail()) ) return false;
        if ( !Kmu.isEqual(getRoleCode(), e.getRoleCode()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( !Kmu.isEqual(getDisplayString(), e.getDisplayString()) ) return false;
        if ( !Kmu.isEqual(getTypeName(), e.getTypeName()) ) return false;
        if ( !Kmu.isEqual(getStatusName(), e.getStatusName()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTs(), e.getCreatedLocalTs()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTsMessage(), e.getCreatedLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalDate(), e.getCreatedLocalDate()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTime(), e.getCreatedLocalTime()) ) return false;
        if ( !Kmu.isEqual(getUpdatedLocalTs(), e.getUpdatedLocalTs()) ) return false;
        if ( !Kmu.isEqual(getUpdatedLocalTsMessage(), e.getUpdatedLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getUpdatedLocalDate(), e.getUpdatedLocalDate()) ) return false;
        if ( !Kmu.isEqual(getUpdatedLocalTime(), e.getUpdatedLocalTime()) ) return false;
        if ( !Kmu.isEqual(getClosedLocalTs(), e.getClosedLocalTs()) ) return false;
        if ( !Kmu.isEqual(getClosedLocalTsMessage(), e.getClosedLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getClosedLocalDate(), e.getClosedLocalDate()) ) return false;
        if ( !Kmu.isEqual(getClosedLocalTime(), e.getClosedLocalTime()) ) return false;
        return true;
    }

    public boolean isDifferent(MyInvitation e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyInvitation e)
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
        out.append("MyInvitation");
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
        System.out.println("    TypeCode = " + typeCode);
        System.out.println("    StatusCode = " + statusCode);
        System.out.println("    ClosedUtcTs = " + closedUtcTs);
        System.out.println("    ToEmail = " + toEmail);
        System.out.println("    RoleCode = " + roleCode);
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
