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
public abstract class MyPasswordResetBase
    extends MyAbstractDaoDomain<MyPasswordReset>
    implements KmUidDomainIF
    ,MyBasicTimestampsIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaPasswordReset Meta = MyMetaPasswordReset.instance;
    public static final MyPasswordResetTools Tools = MyPasswordResetTools.instance;
    public static final MyPasswordResetValidator Validator = MyPasswordResetValidator.instance;
    public static final MyPasswordResetFinder Finder = MyPasswordResetFinder.instance;

    //##################################################
    //# variables
    //##################################################

    private KmTimestamp createdUtcTs;
    private String email;
    private KmTimestamp expirationUtcTs;
    private String token;
    private String uid;
    private KmTimestamp updatedUtcTs;
    private Integer lockVersion;
    private MyUser createdBy;
    private MyTenant tenant;
    private MyUser updatedBy;

    //##################################################
    //# constructor
    //##################################################

    public MyPasswordResetBase()
    {
        super();
        setCreatedUtcTs(nowUtc());
        setToken(newUid());
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
    //# field (expirationUtcTs)
    //##################################################

    public KmTimestamp getExpirationUtcTs()
    {
        return expirationUtcTs;
    }

    public void setExpirationUtcTs(KmTimestamp e)
    {
        e = Validator.getExpirationUtcTsValidator().convert(e);
        expirationUtcTs = e;
    }

    public void clearExpirationUtcTs()
    {
        setExpirationUtcTs(null);
    }

    public boolean hasExpirationUtcTs()
    {
        return getExpirationUtcTs() != null;
    }

    public boolean hasExpirationUtcTs(KmTimestamp e)
    {
        return Kmu.isEqual(getExpirationUtcTs(), e);
    }

    //##################################################
    //# field (token)
    //##################################################

    public String getToken()
    {
        return token;
    }

    public void setToken(String e)
    {
        e = Validator.getTokenValidator().convert(e);
        token = e;
    }

    public void clearToken()
    {
        setToken(null);
    }

    public boolean hasToken()
    {
        return Kmu.hasValue(getToken());
    }

    public boolean hasToken(String e)
    {
        return Kmu.isEqualIgnoreCase(getToken(), e);
    }

    public void truncateToken()
    {
        truncateToken(false);
    }

    public void truncateToken(boolean ellipses)
    {
        token = Kmu.truncate(token, 30, ellipses);
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
    //# field (expirationLocalTs)
    //##################################################

    public final KmTimestamp getExpirationLocalTs()
    {
        return KmTimestampUtility.toLocal(getExpirationUtcTs());
    }

    public boolean hasExpirationLocalTs()
    {
        return getExpirationLocalTs() != null;
    }

    public boolean hasExpirationLocalTs(KmTimestamp e)
    {
        return Kmu.isEqual(getExpirationLocalTs(), e);
    }

    //##################################################
    //# field (expirationLocalTsMessage)
    //##################################################

    public final String getExpirationLocalTsMessage()
    {
        return KmTimestampUtility.formatLocalMessage(getExpirationUtcTs());
    }

    public boolean hasExpirationLocalTsMessage()
    {
        return Kmu.hasValue(getExpirationLocalTsMessage());
    }

    public boolean hasExpirationLocalTsMessage(String e)
    {
        return Kmu.isEqualIgnoreCase(getExpirationLocalTsMessage(), e);
    }

    //##################################################
    //# field (expirationLocalDate)
    //##################################################

    public final KmDate getExpirationLocalDate()
    {
        return KmTimestampUtility.getDate(getExpirationLocalTs());
    }

    public boolean hasExpirationLocalDate()
    {
        return getExpirationLocalDate() != null;
    }

    public boolean hasExpirationLocalDate(KmDate e)
    {
        return Kmu.isEqual(getExpirationLocalDate(), e);
    }

    //##################################################
    //# field (expirationLocalTime)
    //##################################################

    public final KmTime getExpirationLocalTime()
    {
        return KmTimestampUtility.getTime(getExpirationLocalTs());
    }

    public boolean hasExpirationLocalTime()
    {
        return getExpirationLocalTime() != null;
    }

    public boolean hasExpirationLocalTime(KmTime e)
    {
        return Kmu.isEqual(getExpirationLocalTime(), e);
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
    //# validate
    //##################################################

    @Override
    protected final MyPasswordResetValidator getValidator()
    {
        return Validator;
    }

    @Override
    protected final MyPasswordReset asSubclass()
    {
        return (MyPasswordReset)this;
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyPasswordReset getCopy()
    {
        return (MyPasswordReset)super.getCopy();
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
    public final MyPasswordReset getBasicCopy()
    {
        MyPasswordReset e;
        e = new MyPasswordReset();
        applyEditableFieldsTo(e);
        resetBasicTimestamps();
        return e;
    }

    /**
     * Apply the editable fields TO another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsTo(MyPasswordReset e)
    {
        e.setCreatedUtcTs(getCreatedUtcTs());
        e.setEmail(getEmail());
        e.setExpirationUtcTs(getExpirationUtcTs());
        e.setToken(getToken());
        e.setUpdatedUtcTs(getUpdatedUtcTs());
    }

    /**
     * Apply the editable fields FROM another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsFrom(MyPasswordReset e)
    {
        setCreatedUtcTs(e.getCreatedUtcTs());
        setEmail(e.getEmail());
        setExpirationUtcTs(e.getExpirationUtcTs());
        setToken(e.getToken());
        setUpdatedUtcTs(e.getUpdatedUtcTs());
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyPasswordResetBase) )
            return false;

        MyPasswordResetBase e = (MyPasswordResetBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyPasswordReset e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyPasswordReset e)
    {
        if ( !Kmu.isEqual(getAuditLogTitle(), e.getAuditLogTitle()) ) return false;
        if ( !Kmu.isEqual(getCreatedUtcTs(), e.getCreatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getDomainSubtitle(), e.getDomainSubtitle()) ) return false;
        if ( !Kmu.isEqual(getDomainTitle(), e.getDomainTitle()) ) return false;
        if ( !Kmu.isEqual(getEmail(), e.getEmail()) ) return false;
        if ( !Kmu.isEqual(getExpirationUtcTs(), e.getExpirationUtcTs()) ) return false;
        if ( !Kmu.isEqual(getToken(), e.getToken()) ) return false;
        if ( !Kmu.isEqual(getUpdatedUtcTs(), e.getUpdatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTs(), e.getCreatedLocalTs()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTsMessage(), e.getCreatedLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalDate(), e.getCreatedLocalDate()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTime(), e.getCreatedLocalTime()) ) return false;
        if ( !Kmu.isEqual(getExpirationLocalTs(), e.getExpirationLocalTs()) ) return false;
        if ( !Kmu.isEqual(getExpirationLocalTsMessage(), e.getExpirationLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getExpirationLocalDate(), e.getExpirationLocalDate()) ) return false;
        if ( !Kmu.isEqual(getExpirationLocalTime(), e.getExpirationLocalTime()) ) return false;
        if ( !Kmu.isEqual(getUpdatedLocalTs(), e.getUpdatedLocalTs()) ) return false;
        if ( !Kmu.isEqual(getUpdatedLocalTsMessage(), e.getUpdatedLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getUpdatedLocalDate(), e.getUpdatedLocalDate()) ) return false;
        if ( !Kmu.isEqual(getUpdatedLocalTime(), e.getUpdatedLocalTime()) ) return false;
        return true;
    }

    public boolean isDifferent(MyPasswordReset e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyPasswordReset e)
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
        out.append("MyPasswordReset");
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
        System.out.println("    ExpirationUtcTs = " + expirationUtcTs);
        System.out.println("    Token = " + token);
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
