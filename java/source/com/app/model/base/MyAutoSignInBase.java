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

public abstract class MyAutoSignInBase
    extends MyAbstractDomain
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaAutoSignIn Meta = MyMetaAutoSignIn.instance;
    public static final MyAutoSignInTools Tools = MyAutoSignInTools.instance;
    public static final MyAutoSignInValidator Validator = MyAutoSignInValidator.instance;

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

    public MyAutoSignInBase()
    {
        super();
        setUid(newUid());
        setCreatedUtcTs(getNowUtc());
        setLastTouchedUtcTs(getNowUtc());
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
    //# field (lastTouchedUtcTs)
    //##################################################

    public KmTimestamp getLastTouchedUtcTs()
    {
        return lastTouchedUtcTs;
    }

    public void setLastTouchedUtcTs(KmTimestamp e)
    {
        checkReadOnly();
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
        checkReadOnly();
        user = e;
    }

    public void _setUser(MyUser e)
    {
        checkReadOnly();
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
    public void validate()
    {
        Validator.validate((MyAutoSignIn)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyAutoSignIn)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyAutoSignIn)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyAutoSignIn getCopy()
    {
        return (MyAutoSignIn)super.getCopy();
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
        if ( !(o instanceof MyAutoSignInBase) )
            return false;

        MyAutoSignInBase e = (MyAutoSignInBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyAutoSignIn e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyAutoSignIn e)
    {
        if ( !Kmu.isEqual(getCreatedUtcTs(), e.getCreatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getLastTouchedUtcTs(), e.getLastTouchedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
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

    public boolean isDifferent(MyAutoSignIn e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyAutoSignIn e)
    {
        return !isSameIgnoringKey(e);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MyAutoSignIn");
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
        System.out.println("    CreatedUtcTs = " + createdUtcTs);
        System.out.println("    LastTouchedUtcTs = " + lastTouchedUtcTs);
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
