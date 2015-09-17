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

public abstract class MyPasswordResetBase
    extends MyAbstractDomain
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaPasswordReset Meta = MyMetaPasswordReset.instance;
    public static final MyPasswordResetTools Tools = MyPasswordResetTools.instance;
    public static final MyPasswordResetValidator Validator = MyPasswordResetValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private String email;
    private String token;
    private KmTimestamp createdUtcTs;
    private KmTimestamp expirationUtcTs;
    private Integer lockVersion;

    //##################################################
    //# constructor
    //##################################################

    public MyPasswordResetBase()
    {
        super();
        setUid(newUid());
        setToken(newUid());
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
    //# field (email)
    //##################################################

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String e)
    {
        checkReadOnly();
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
    //# field (token)
    //##################################################

    public String getToken()
    {
        return token;
    }

    public void setToken(String e)
    {
        checkReadOnly();
        e = Validator.getTokenValidator().convertOnly(e);
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
    //# field (expirationUtcTs)
    //##################################################

    public KmTimestamp getExpirationUtcTs()
    {
        return expirationUtcTs;
    }

    public void setExpirationUtcTs(KmTimestamp e)
    {
        checkReadOnly();
        e = Validator.getExpirationUtcTsValidator().convertOnly(e);
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
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyPasswordReset)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyPasswordReset)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyPasswordReset)this);
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
        uid = null;
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
        if ( !Kmu.isEqual(getEmail(), e.getEmail()) ) return false;
        if ( !Kmu.isEqual(getToken(), e.getToken()) ) return false;
        if ( !Kmu.isEqual(getCreatedUtcTs(), e.getCreatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getExpirationUtcTs(), e.getExpirationUtcTs()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTs(), e.getCreatedLocalTs()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTsMessage(), e.getCreatedLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalDate(), e.getCreatedLocalDate()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTime(), e.getCreatedLocalTime()) ) return false;
        if ( !Kmu.isEqual(getExpirationLocalTs(), e.getExpirationLocalTs()) ) return false;
        if ( !Kmu.isEqual(getExpirationLocalTsMessage(), e.getExpirationLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getExpirationLocalDate(), e.getExpirationLocalDate()) ) return false;
        if ( !Kmu.isEqual(getExpirationLocalTime(), e.getExpirationLocalTime()) ) return false;
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
        StringBuilder sb = new StringBuilder();
        sb.append("MyPasswordReset");
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
        System.out.println("    Email = " + email);
        System.out.println("    Token = " + token);
        System.out.println("    CreatedUtcTs = " + createdUtcTs);
        System.out.println("    ExpirationUtcTs = " + expirationUtcTs);
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
