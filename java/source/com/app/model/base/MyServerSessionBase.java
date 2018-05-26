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
public abstract class MyServerSessionBase
    extends MyAbstractDaoDomain<MyServerSession>
    implements KmUidDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaServerSession Meta = MyMetaServerSession.instance;
    public static final MyServerSessionTools Tools = MyServerSessionTools.instance;
    public static final MyServerSessionValidator Validator = MyServerSessionValidator.instance;
    public static final MyServerSessionFinder Finder = MyServerSessionFinder.instance;

    //##################################################
    //# variables
    //##################################################

    private Boolean active;
    private KmTimestamp closedUtcTs;
    private KmTimestamp createdUtcTs;
    private KmTimestamp lastTouchedUtcTs;
    private String uid;
    private String version;
    private Integer lockVersion;
    private MyAutoLogin autoLogin;
    private MyTenant tenant;
    private MyUser user;

    //##################################################
    //# constructor
    //##################################################

    public MyServerSessionBase()
    {
        super();
        setActive(true);
        setCreatedUtcTs(nowUtc());
        setLastTouchedUtcTs(nowUtc());
        setUid(newUid());
        setLockVersion(0);
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
        e = Validator.getActiveValidator().convert(e);
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

    public boolean isActive(Boolean b)
    {
        return Kmu.isEqual(getActive(), b);
    }

    public void toggleActive()
    {
        setActive(!getActive());
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
    //# field (closedUtcTs)
    //##################################################

    public KmTimestamp getClosedUtcTs()
    {
        return closedUtcTs;
    }

    public void setClosedUtcTs(KmTimestamp e)
    {
        e = Validator.getClosedUtcTsValidator().convert(e);
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
    //# field (lastTouchedUtcTs)
    //##################################################

    public KmTimestamp getLastTouchedUtcTs()
    {
        return lastTouchedUtcTs;
    }

    public void setLastTouchedUtcTs(KmTimestamp e)
    {
        e = Validator.getLastTouchedUtcTsValidator().convert(e);
        lastTouchedUtcTs = e;
    }

    public void clearLastTouchedUtcTs()
    {
        setLastTouchedUtcTs(null);
    }

    public boolean hasLastTouchedUtcTs()
    {
        return getLastTouchedUtcTs() != null;
    }

    public boolean hasLastTouchedUtcTs(KmTimestamp e)
    {
        return Kmu.isEqual(getLastTouchedUtcTs(), e);
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
    //# field (version)
    //##################################################

    public String getVersion()
    {
        return version;
    }

    public void setVersion(String e)
    {
        e = Validator.getVersionValidator().convert(e);
        version = e;
    }

    public void clearVersion()
    {
        setVersion(null);
    }

    public boolean hasVersion()
    {
        return Kmu.hasValue(getVersion());
    }

    public boolean hasVersion(String e)
    {
        return Kmu.isEqualIgnoreCase(getVersion(), e);
    }

    public void truncateVersion()
    {
        truncateVersion(false);
    }

    public void truncateVersion(boolean ellipses)
    {
        version = Kmu.truncate(version, 50, ellipses);
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
    //# field (lastTouchedLocalTs)
    //##################################################

    public final KmTimestamp getLastTouchedLocalTs()
    {
        return KmTimestampUtility.toLocal(getLastTouchedUtcTs());
    }

    public boolean hasLastTouchedLocalTs()
    {
        return getLastTouchedLocalTs() != null;
    }

    public boolean hasLastTouchedLocalTs(KmTimestamp e)
    {
        return Kmu.isEqual(getLastTouchedLocalTs(), e);
    }

    //##################################################
    //# field (lastTouchedLocalTsMessage)
    //##################################################

    public final String getLastTouchedLocalTsMessage()
    {
        return KmTimestampUtility.formatLocalMessage(getLastTouchedUtcTs());
    }

    public boolean hasLastTouchedLocalTsMessage()
    {
        return Kmu.hasValue(getLastTouchedLocalTsMessage());
    }

    public boolean hasLastTouchedLocalTsMessage(String e)
    {
        return Kmu.isEqualIgnoreCase(getLastTouchedLocalTsMessage(), e);
    }

    //##################################################
    //# field (lastTouchedLocalDate)
    //##################################################

    public final KmDate getLastTouchedLocalDate()
    {
        return KmTimestampUtility.getDate(getLastTouchedLocalTs());
    }

    public boolean hasLastTouchedLocalDate()
    {
        return getLastTouchedLocalDate() != null;
    }

    public boolean hasLastTouchedLocalDate(KmDate e)
    {
        return Kmu.isEqual(getLastTouchedLocalDate(), e);
    }

    //##################################################
    //# field (lastTouchedLocalTime)
    //##################################################

    public final KmTime getLastTouchedLocalTime()
    {
        return KmTimestampUtility.getTime(getLastTouchedLocalTs());
    }

    public boolean hasLastTouchedLocalTime()
    {
        return getLastTouchedLocalTime() != null;
    }

    public boolean hasLastTouchedLocalTime(KmTime e)
    {
        return Kmu.isEqual(getLastTouchedLocalTime(), e);
    }

    //##################################################
    //# autoLogin
    //##################################################

    public MyAutoLogin getAutoLogin()
    {
        return autoLogin;
    }

    public void setAutoLogin(MyAutoLogin e)
    {
        autoLogin = e;
    }

    public void _setAutoLogin(MyAutoLogin e)
    {
        autoLogin = e;
    }

    public void clearAutoLogin()
    {
        setAutoLogin(null);
    }

    public boolean hasAutoLogin()
    {
        return getAutoLogin() != null;
    }

    public boolean hasAutoLogin(MyAutoLogin e)
    {
        return Kmu.isEqual(getAutoLogin(), e);
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


    //##################################################
    //# validate
    //##################################################

    @Override
    protected final MyServerSessionValidator getValidator()
    {
        return Validator;
    }

    @Override
    protected final MyServerSession asSubclass()
    {
        return (MyServerSession)this;
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyServerSession getCopy()
    {
        return (MyServerSession)super.getCopy();
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
    public final MyServerSession getBasicCopy()
    {
        MyServerSession e;
        e = new MyServerSession();
        applyEditableFieldsTo(e);
        return e;
    }

    /**
     * Apply the editable fields TO another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsTo(MyServerSession e)
    {
        e.setActive(getActive());
        e.setClosedUtcTs(getClosedUtcTs());
        e.setCreatedUtcTs(getCreatedUtcTs());
        e.setLastTouchedUtcTs(getLastTouchedUtcTs());
        e.setVersion(getVersion());
    }

    /**
     * Apply the editable fields FROM another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsFrom(MyServerSession e)
    {
        setActive(e.getActive());
        setClosedUtcTs(e.getClosedUtcTs());
        setCreatedUtcTs(e.getCreatedUtcTs());
        setLastTouchedUtcTs(e.getLastTouchedUtcTs());
        setVersion(e.getVersion());
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyServerSessionBase) )
            return false;

        MyServerSessionBase e = (MyServerSessionBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyServerSession e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyServerSession e)
    {
        if ( !Kmu.isEqual(getActive(), e.getActive()) ) return false;
        if ( !Kmu.isEqual(getAuditLogTitle(), e.getAuditLogTitle()) ) return false;
        if ( !Kmu.isEqual(getClosedUtcTs(), e.getClosedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getCreatedUtcTs(), e.getCreatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getDomainSubtitle(), e.getDomainSubtitle()) ) return false;
        if ( !Kmu.isEqual(getDomainTitle(), e.getDomainTitle()) ) return false;
        if ( !Kmu.isEqual(getLastTouchedUtcTs(), e.getLastTouchedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getVersion(), e.getVersion()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( !Kmu.isEqual(getClosedLocalTs(), e.getClosedLocalTs()) ) return false;
        if ( !Kmu.isEqual(getClosedLocalTsMessage(), e.getClosedLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getClosedLocalDate(), e.getClosedLocalDate()) ) return false;
        if ( !Kmu.isEqual(getClosedLocalTime(), e.getClosedLocalTime()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTs(), e.getCreatedLocalTs()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTsMessage(), e.getCreatedLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalDate(), e.getCreatedLocalDate()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTime(), e.getCreatedLocalTime()) ) return false;
        if ( !Kmu.isEqual(getLastTouchedLocalTs(), e.getLastTouchedLocalTs()) ) return false;
        if ( !Kmu.isEqual(getLastTouchedLocalTsMessage(), e.getLastTouchedLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getLastTouchedLocalDate(), e.getLastTouchedLocalDate()) ) return false;
        if ( !Kmu.isEqual(getLastTouchedLocalTime(), e.getLastTouchedLocalTime()) ) return false;
        return true;
    }

    public boolean isDifferent(MyServerSession e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyServerSession e)
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
        out.append("MyServerSession");
        out.append("(");
        out.append("Uid=");
        out.append(uid);
        out.append(")");
        return out.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    Active = " + active);
        System.out.println("    ClosedUtcTs = " + closedUtcTs);
        System.out.println("    CreatedUtcTs = " + createdUtcTs);
        System.out.println("    LastTouchedUtcTs = " + lastTouchedUtcTs);
        System.out.println("    Uid = " + uid);
        System.out.println("    Version = " + version);
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
