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

public abstract class MyServerSessionBase
    extends MyAbstractDomain
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaServerSession Meta = MyMetaServerSession.instance;
    public static final MyServerSessionTools Tools = MyServerSessionTools.instance;
    public static final MyServerSessionValidator Validator = MyServerSessionValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private Boolean active;
    private KmTimestamp createdUtcTs;
    private KmTimestamp closedUtcTs;
    private KmTimestamp lastTouchedUtcTs;
    private String version;
    private Integer lockVersion;
    private MyUser user;
    private MyAutoSignIn autoSignIn;
    private MyAccount account;

    //##################################################
    //# constructor
    //##################################################

    public MyServerSessionBase()
    {
        super();
        setUid(newUid());
        setActive(true);
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
    //# field (active)
    //##################################################

    public Boolean getActive()
    {
        return active;
    }

    public void setActive(Boolean e)
    {
        checkReadOnly();
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
    //# field (version)
    //##################################################

    public String getVersion()
    {
        return version;
    }

    public void setVersion(String e)
    {
        checkReadOnly();
        e = Validator.getVersionValidator().convertOnly(e);
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
        return Kmu.isEqual(getVersion(), e);
    }

    public void truncateVersion()
    {
        truncateVersion(false);
    }

    public void truncateVersion(boolean ellipses)
    {
        version = Kmu.truncate(version, 30, ellipses);
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
        return Kmu.isEqual(getClosedLocalTsMessage(), e);
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
        return Kmu.isEqual(getLastTouchedLocalTsMessage(), e);
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
    //# autoSignIn
    //##################################################

    public MyAutoSignIn getAutoSignIn()
    {
        return autoSignIn;
    }

    public void setAutoSignIn(MyAutoSignIn e)
    {
        checkReadOnly();
        autoSignIn = e;
    }

    public void _setAutoSignIn(MyAutoSignIn e)
    {
        checkReadOnly();
        autoSignIn = e;
    }

    public void clearAutoSignIn()
    {
        setAutoSignIn(null);
    }

    public boolean hasAutoSignIn()
    {
        return getAutoSignIn() != null;
    }

    public boolean hasAutoSignIn(MyAutoSignIn e)
    {
        return Kmu.isEqual(getAutoSignIn(), e);
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


    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyServerSession)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyServerSession)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyServerSession)this);
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
        uid = null;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyServerSessionBase) )
            return false;

        MyServerSessionBase e = (MyServerSessionBase) o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyServerSession e)
    {
        if ( ! Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyServerSession e)
    {
        if ( ! Kmu.isEqual(getActive(), e.getActive()) ) return false;
        if ( ! Kmu.isEqual(getCreatedUtcTs(), e.getCreatedUtcTs()) ) return false;
        if ( ! Kmu.isEqual(getClosedUtcTs(), e.getClosedUtcTs()) ) return false;
        if ( ! Kmu.isEqual(getLastTouchedUtcTs(), e.getLastTouchedUtcTs()) ) return false;
        if ( ! Kmu.isEqual(getVersion(), e.getVersion()) ) return false;
        if ( ! Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( ! Kmu.isEqual(getCreatedLocalTs(), e.getCreatedLocalTs()) ) return false;
        if ( ! Kmu.isEqual(getCreatedLocalTsMessage(), e.getCreatedLocalTsMessage()) ) return false;
        if ( ! Kmu.isEqual(getCreatedLocalDate(), e.getCreatedLocalDate()) ) return false;
        if ( ! Kmu.isEqual(getCreatedLocalTime(), e.getCreatedLocalTime()) ) return false;
        if ( ! Kmu.isEqual(getClosedLocalTs(), e.getClosedLocalTs()) ) return false;
        if ( ! Kmu.isEqual(getClosedLocalTsMessage(), e.getClosedLocalTsMessage()) ) return false;
        if ( ! Kmu.isEqual(getClosedLocalDate(), e.getClosedLocalDate()) ) return false;
        if ( ! Kmu.isEqual(getClosedLocalTime(), e.getClosedLocalTime()) ) return false;
        if ( ! Kmu.isEqual(getLastTouchedLocalTs(), e.getLastTouchedLocalTs()) ) return false;
        if ( ! Kmu.isEqual(getLastTouchedLocalTsMessage(), e.getLastTouchedLocalTsMessage()) ) return false;
        if ( ! Kmu.isEqual(getLastTouchedLocalDate(), e.getLastTouchedLocalDate()) ) return false;
        if ( ! Kmu.isEqual(getLastTouchedLocalTime(), e.getLastTouchedLocalTime()) ) return false;
        return true;
    }

    public boolean isDifferent(MyServerSession e)
    {
        return ! isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyServerSession e)
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

        if ( p.hasKey("active") )
            setActive(p.getBoolean("active"));

        if ( p.hasKey("version") )
            setVersion(p.getString("version"));

        if ( p.hasKey("lockVersion") )
            setLockVersion(p.getInteger("lockVersion"));
    }

    public KmMap<String,String> exportPropertyMap()
    {
        KmProperties p;
        p = new KmProperties();

        if ( hasUid() )
            p.setString("uid", getUid());

        if ( hasActive() )
            p.setBoolean("active", getActive());

        if ( hasVersion() )
            p.setString("version", getVersion());

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
        sb.append("MyServerSession");
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
        System.out.println("    Active = " + active);
        System.out.println("    CreatedUtcTs = " + createdUtcTs);
        System.out.println("    ClosedUtcTs = " + closedUtcTs);
        System.out.println("    LastTouchedUtcTs = " + lastTouchedUtcTs);
        System.out.println("    Version = " + version);
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
