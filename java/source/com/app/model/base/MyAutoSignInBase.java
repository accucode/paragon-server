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
    private KmTimestamp lastUtcTs;
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
        setLastUtcTs(getNowUtc());
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
        return Kmu.isEqual(getUid(), e);
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
    //# field (lastUtcTs)
    //##################################################

    public KmTimestamp getLastUtcTs()
    {
        return lastUtcTs;
    }

    public void setLastUtcTs(KmTimestamp e)
    {
        checkReadOnly();
        e = Validator.getLastUtcTsValidator().convertOnly(e);
        lastUtcTs = e;
    }

    public void clearLastUtcTs()
    {
        setLastUtcTs(null);
    }

    public boolean hasLastUtcTs()
    {
        return getLastUtcTs() != null;
    }

    public boolean hasLastUtcTs(KmTimestamp e)
    {
        return Kmu.isEqual(getLastUtcTs(), e);
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
        return Kmu.isEqual(getCreatedLocalTsMessage(), e);
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
    //# field (lastLocalTs)
    //##################################################

    public final KmTimestamp getLastLocalTs()
    {
        return KmTimestampUtility.toLocal(getLastUtcTs());
    }

    public boolean hasLastLocalTs()
    {
        return getLastLocalTs() != null;
    }

    public boolean hasLastLocalTs(KmTimestamp e)
    {
        return Kmu.isEqual(getLastLocalTs(), e);
    }

    //##################################################
    //# field (lastLocalTsMessage)
    //##################################################

    public final String getLastLocalTsMessage()
    {
        return KmTimestampUtility.formatLocalMessage(getLastUtcTs());
    }

    public boolean hasLastLocalTsMessage()
    {
        return Kmu.hasValue(getLastLocalTsMessage());
    }

    public boolean hasLastLocalTsMessage(String e)
    {
        return Kmu.isEqual(getLastLocalTsMessage(), e);
    }

    //##################################################
    //# field (lastLocalDate)
    //##################################################

    public final KmDate getLastLocalDate()
    {
        return KmTimestampUtility.getDate(getLastLocalTs());
    }

    public boolean hasLastLocalDate()
    {
        return getLastLocalDate() != null;
    }

    public boolean hasLastLocalDate(KmDate e)
    {
        return Kmu.isEqual(getLastLocalDate(), e);
    }

    //##################################################
    //# field (lastLocalTime)
    //##################################################

    public final KmTime getLastLocalTime()
    {
        return KmTimestampUtility.getTime(getLastLocalTs());
    }

    public boolean hasLastLocalTime()
    {
        return getLastLocalTime() != null;
    }

    public boolean hasLastLocalTime(KmTime e)
    {
        return Kmu.isEqual(getLastLocalTime(), e);
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

        MyAutoSignInBase e = (MyAutoSignInBase) o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyAutoSignIn e)
    {
        if ( ! Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyAutoSignIn e)
    {
        if ( ! Kmu.isEqual(getCreatedUtcTs(), e.getCreatedUtcTs()) ) return false;
        if ( ! Kmu.isEqual(getLastUtcTs(), e.getLastUtcTs()) ) return false;
        if ( ! Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( ! Kmu.isEqual(getCreatedLocalTs(), e.getCreatedLocalTs()) ) return false;
        if ( ! Kmu.isEqual(getCreatedLocalTsMessage(), e.getCreatedLocalTsMessage()) ) return false;
        if ( ! Kmu.isEqual(getCreatedLocalDate(), e.getCreatedLocalDate()) ) return false;
        if ( ! Kmu.isEqual(getCreatedLocalTime(), e.getCreatedLocalTime()) ) return false;
        if ( ! Kmu.isEqual(getLastLocalTs(), e.getLastLocalTs()) ) return false;
        if ( ! Kmu.isEqual(getLastLocalTsMessage(), e.getLastLocalTsMessage()) ) return false;
        if ( ! Kmu.isEqual(getLastLocalDate(), e.getLastLocalDate()) ) return false;
        if ( ! Kmu.isEqual(getLastLocalTime(), e.getLastLocalTime()) ) return false;
        return true;
    }

    public boolean isDifferent(MyAutoSignIn e)
    {
        return ! isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyAutoSignIn e)
    {
        return ! isSameIgnoringKey(e);
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

        if ( p.hasKey("lockVersion") )
            setLockVersion(p.getInteger("lockVersion"));
    }

    public KmMap<String,String> exportPropertyMap()
    {
        KmProperties p;
        p = new KmProperties();

        if ( hasUid() )
            p.setString("uid", getUid());

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
        System.out.println("    LastUtcTs = " + lastUtcTs);
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
