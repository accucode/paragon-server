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
public abstract class MyAutoLoginBase
    extends MyAbstractDomain
    implements MyUidDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaAutoLogin Meta = MyMetaAutoLogin.instance;
    public static final MyAutoLoginTools Tools = MyAutoLoginTools.instance;
    public static final MyAutoLoginValidator Validator = MyAutoLoginValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private KmTimestamp createdUtcTs;
    private KmTimestamp lastTouchedUtcTs;
    private Integer lockVersion;
    private MyUser user;

    //##################################################
    //# constructor
    //##################################################

    public MyAutoLoginBase()
    {
        super();
        setUid(newUid());
        setCreatedUtcTs(nowUtc());
        setLastTouchedUtcTs(nowUtc());
        setLockVersion(0);
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
    //# field (lastTouchedUtcTs)
    //##################################################

    public KmTimestamp getLastTouchedUtcTs()
    {
        return lastTouchedUtcTs;
    }

    public void setLastTouchedUtcTs(KmTimestamp e)
    {
        e = Validator.getLastTouchedUtcTsValidator().convertOnly(e);
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

    public boolean hasUserFullName()
    {
        return hasUser() && getUser().hasFullName();
    }

    public boolean hasUserFullName(String e)
    {
        return hasUser() && getUser().hasFullName(e);
    }

    public String getTenantName()
    {
        if ( hasUser() )
            return getUser().getTenantName();
        return null;
    }

    public void setTenantName(String e)
    {
        getUser().setTenantName(e);
    }

    public boolean hasTenantName()
    {
        return hasUser() && getUser().hasTenantName();
    }

    public boolean hasTenantName(String e)
    {
        return hasUser() && getUser().hasTenantName(e);
    }


    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyAutoLogin)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyAutoLogin)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyAutoLogin)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyAutoLogin getCopy()
    {
        return (MyAutoLogin)super.getCopy();
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
    public final MyAutoLogin getBasicCopy()
    {
        MyAutoLogin e;
        e = new MyAutoLogin();
        e.setCreatedUtcTs(getCreatedUtcTs());
        e.setLastTouchedUtcTs(getLastTouchedUtcTs());
        return e;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyAutoLoginBase) )
            return false;

        MyAutoLoginBase e = (MyAutoLoginBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyAutoLogin e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyAutoLogin e)
    {
        if ( !Kmu.isEqual(getCreatedUtcTs(), e.getCreatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getLastTouchedUtcTs(), e.getLastTouchedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( !Kmu.isEqual(getDisplayString(), e.getDisplayString()) ) return false;
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

    public boolean isDifferent(MyAutoLogin e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyAutoLogin e)
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
        out.append("MyAutoLogin");
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
        System.out.println("    LastTouchedUtcTs = " + lastTouchedUtcTs);
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
