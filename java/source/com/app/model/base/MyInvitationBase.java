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
import com.app.utility.*;

public abstract class MyInvitationBase
    extends MyAbstractDomain
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
    private String typeCode;
    private String statusCode;
    private KmTimestamp createdUtcTs;
    private KmTimestamp closedUtcTs;
    private String toEmail;
    private String roleCode;
    private Integer lockVersion;
    private MyUser fromUser;
    private MyAccount account;

    //##################################################
    //# constructor
    //##################################################

    public MyInvitationBase()
    {
        super();
        setUid(newUid());
        setCreatedUtcTs(getNowUtc());
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
        checkReadOnly();
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
    //# field (typeCode)
    //##################################################

    public String getTypeCode()
    {
        return typeCode;
    }

    public void setTypeCode(String e)
    {
        checkReadOnly();
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
        typeCode = Kmu.truncate(typeCode, 1, ellipses);
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

    public void setTypeTransferAccount()
    {
        setType(MyInvitationType.TransferAccount);
    }

    public boolean isTypeTransferAccount()
    {
        return hasType(MyInvitationType.TransferAccount);
    }

    public boolean isNotTypeTransferAccount()
    {
        return !isTypeTransferAccount();
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
        checkReadOnly();
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
        statusCode = Kmu.truncate(statusCode, 1, ellipses);
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
    //# field (createdUtcTs)
    //##################################################

    public KmTimestamp getCreatedUtcTs()
    {
        return createdUtcTs;
    }

    public void setCreatedUtcTs(KmTimestamp e)
    {
        checkReadOnly();
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
    //# field (closedUtcTs)
    //##################################################

    public KmTimestamp getClosedUtcTs()
    {
        return closedUtcTs;
    }

    public void setClosedUtcTs(KmTimestamp e)
    {
        checkReadOnly();
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
        checkReadOnly();
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
        checkReadOnly();
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
        checkReadOnly();
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
    //# field (typeName)
    //##################################################

    public final String getTypeName()
    {
        return Kmu.getName(getType());
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
        return Kmu.getName(getStatus());
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
    //# fromUser
    //##################################################

    public MyUser getFromUser()
    {
        return fromUser;
    }

    public void setFromUser(MyUser e)
    {
        checkReadOnly();
        fromUser = e;
    }

    public void _setFromUser(MyUser e)
    {
        checkReadOnly();
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

    public String getFromUserName()
    {
        if ( hasFromUser() )
            return getFromUser().getName();
        return null;
    }

    public void setFromUserName(String e)
    {
        getFromUser().setName(e);
    }

    public boolean hasFromUserName()
    {
        return hasFromUser() && getFromUser().hasName();
    }

    public boolean hasFromUserName(String e)
    {
        return hasFromUser() && getFromUser().hasName(e);
    }

    //##################################################
    //# account
    //##################################################

    public MyAccount getAccount()
    {
        return account;
    }

    public void setAccount(MyAccount e)
    {
        checkReadOnly();
        account = e;
    }

    public void _setAccount(MyAccount e)
    {
        checkReadOnly();
        account = e;
    }

    public void clearAccount()
    {
        setAccount(null);
    }

    public boolean hasAccount()
    {
        return getAccount() != null;
    }

    public boolean hasAccount(MyAccount e)
    {
        return Kmu.isEqual(getAccount(), e);
    }

    public String getAccountName()
    {
        if ( hasAccount() )
            return getAccount().getName();
        return null;
    }

    public void setAccountName(String e)
    {
        getAccount().setName(e);
    }

    public boolean hasAccountName()
    {
        return hasAccount() && getAccount().hasName();
    }

    public boolean hasAccountName(String e)
    {
        return hasAccount() && getAccount().hasName(e);
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
        uid = null;
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
        if ( !Kmu.isEqual(getTypeCode(), e.getTypeCode()) ) return false;
        if ( !Kmu.isEqual(getStatusCode(), e.getStatusCode()) ) return false;
        if ( !Kmu.isEqual(getCreatedUtcTs(), e.getCreatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getClosedUtcTs(), e.getClosedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getToEmail(), e.getToEmail()) ) return false;
        if ( !Kmu.isEqual(getRoleCode(), e.getRoleCode()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( !Kmu.isEqual(getTypeName(), e.getTypeName()) ) return false;
        if ( !Kmu.isEqual(getStatusName(), e.getStatusName()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTs(), e.getCreatedLocalTs()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTsMessage(), e.getCreatedLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalDate(), e.getCreatedLocalDate()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTime(), e.getCreatedLocalTime()) ) return false;
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
    //# property
    //##################################################

    public void importPropertyMap(KmMap<String,String> map)
    {
        KmProperties p;
        p = new KmProperties();
        p.setMap(map);

        if ( p.hasKey("uid") )
            setUid(p.getString("uid"));

        if ( p.hasKey("typeCode") )
            setTypeCode(p.getString("typeCode"));

        if ( p.hasKey("statusCode") )
            setStatusCode(p.getString("statusCode"));

        if ( p.hasKey("toEmail") )
            setToEmail(p.getString("toEmail"));

        if ( p.hasKey("roleCode") )
            setRoleCode(p.getString("roleCode"));

        if ( p.hasKey("lockVersion") )
            setLockVersion(p.getInteger("lockVersion"));
    }

    public KmMap<String,String> exportPropertyMap()
    {
        KmProperties p;
        p = new KmProperties();

        if ( hasUid() )
            p.setString("uid", getUid());

        if ( hasTypeCode() )
            p.setString("typeCode", getTypeCode());

        if ( hasStatusCode() )
            p.setString("statusCode", getStatusCode());

        if ( hasToEmail() )
            p.setString("toEmail", getToEmail());

        if ( hasRoleCode() )
            p.setString("roleCode", getRoleCode());

        if ( hasLockVersion() )
            p.setInteger("lockVersion", getLockVersion());

        return p.getMap();
    }


    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MyInvitation");
        sb.append("(");
        sb.append("Uid=");
        sb.append(uid);
        sb.append(")");
        return sb.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    Uid = " + uid);
        System.out.println("    TypeCode = " + typeCode);
        System.out.println("    StatusCode = " + statusCode);
        System.out.println("    CreatedUtcTs = " + createdUtcTs);
        System.out.println("    ClosedUtcTs = " + closedUtcTs);
        System.out.println("    ToEmail = " + toEmail);
        System.out.println("    RoleCode = " + roleCode);
        System.out.println("    LockVersion = " + lockVersion);
    }

    /**
     * Format the primary key fields in a comma separated list.  The format
     * is intended to be suitable for display to users.
     */
    public String formatPrimaryKey()
    {
        StringBuilder sb = new StringBuilder();
        ScFormatter f = getFormatter();
        sb.append(f.formatAny(uid));
        return sb.toString();
    }

}
