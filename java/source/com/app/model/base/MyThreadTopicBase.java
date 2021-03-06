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
public abstract class MyThreadTopicBase
    extends MyAbstractDaoDomain<MyThreadTopic>
    implements KmDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaThreadTopic Meta = MyMetaThreadTopic.instance;
    public static final MyThreadTopicTools Tools = MyThreadTopicTools.instance;
    public static final MyThreadTopicValidator Validator = MyThreadTopicValidator.instance;
    public static final MyThreadTopicFinder Finder = MyThreadTopicFinder.instance;

    //##################################################
    //# variables
    //##################################################

    private String code;
    private String hostAddress;
    private String hostName;
    private KmTimestamp lastEndUtcTs;
    private KmTimestamp lastStartUtcTs;
    private KmTimestamp lastTouchUtcTs;
    private String ownerUid;
    private Integer lockVersion;

    //##################################################
    //# constructor
    //##################################################

    public MyThreadTopicBase()
    {
        super();
        setLockVersion(0);
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
    //# field (code)
    //##################################################

    public String getCode()
    {
        return code;
    }

    public void setCode(String e)
    {
        e = Validator.getCodeValidator().convert(e);
        code = e;
    }

    public void clearCode()
    {
        setCode(null);
    }

    public boolean hasCode()
    {
        return Kmu.hasValue(getCode());
    }

    public boolean hasCode(String e)
    {
        return Kmu.isEqualIgnoreCase(getCode(), e);
    }

    public void truncateCode()
    {
        truncateCode(false);
    }

    public void truncateCode(boolean ellipses)
    {
        code = Kmu.truncate(code, 50, ellipses);
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
    //# field (hostAddress)
    //##################################################

    public String getHostAddress()
    {
        return hostAddress;
    }

    public void setHostAddress(String e)
    {
        e = Validator.getHostAddressValidator().convert(e);
        hostAddress = e;
    }

    public void clearHostAddress()
    {
        setHostAddress(null);
    }

    public boolean hasHostAddress()
    {
        return Kmu.hasValue(getHostAddress());
    }

    public boolean hasHostAddress(String e)
    {
        return Kmu.isEqualIgnoreCase(getHostAddress(), e);
    }

    public void truncateHostAddress()
    {
        truncateHostAddress(false);
    }

    public void truncateHostAddress(boolean ellipses)
    {
        hostAddress = Kmu.truncate(hostAddress, 50, ellipses);
    }

    //##################################################
    //# field (hostName)
    //##################################################

    public String getHostName()
    {
        return hostName;
    }

    public void setHostName(String e)
    {
        e = Validator.getHostNameValidator().convert(e);
        hostName = e;
    }

    public void clearHostName()
    {
        setHostName(null);
    }

    public boolean hasHostName()
    {
        return Kmu.hasValue(getHostName());
    }

    public boolean hasHostName(String e)
    {
        return Kmu.isEqualIgnoreCase(getHostName(), e);
    }

    public void truncateHostName()
    {
        truncateHostName(false);
    }

    public void truncateHostName(boolean ellipses)
    {
        hostName = Kmu.truncate(hostName, 50, ellipses);
    }

    //##################################################
    //# field (lastEndUtcTs)
    //##################################################

    public KmTimestamp getLastEndUtcTs()
    {
        return lastEndUtcTs;
    }

    public void setLastEndUtcTs(KmTimestamp e)
    {
        e = Validator.getLastEndUtcTsValidator().convert(e);
        lastEndUtcTs = e;
    }

    public void clearLastEndUtcTs()
    {
        setLastEndUtcTs(null);
    }

    public boolean hasLastEndUtcTs()
    {
        return getLastEndUtcTs() != null;
    }

    public boolean hasLastEndUtcTs(KmTimestamp e)
    {
        return Kmu.isEqual(getLastEndUtcTs(), e);
    }

    //##################################################
    //# field (lastStartUtcTs)
    //##################################################

    public KmTimestamp getLastStartUtcTs()
    {
        return lastStartUtcTs;
    }

    public void setLastStartUtcTs(KmTimestamp e)
    {
        e = Validator.getLastStartUtcTsValidator().convert(e);
        lastStartUtcTs = e;
    }

    public void clearLastStartUtcTs()
    {
        setLastStartUtcTs(null);
    }

    public boolean hasLastStartUtcTs()
    {
        return getLastStartUtcTs() != null;
    }

    public boolean hasLastStartUtcTs(KmTimestamp e)
    {
        return Kmu.isEqual(getLastStartUtcTs(), e);
    }

    //##################################################
    //# field (lastTouchUtcTs)
    //##################################################

    public KmTimestamp getLastTouchUtcTs()
    {
        return lastTouchUtcTs;
    }

    public void setLastTouchUtcTs(KmTimestamp e)
    {
        e = Validator.getLastTouchUtcTsValidator().convert(e);
        lastTouchUtcTs = e;
    }

    public void clearLastTouchUtcTs()
    {
        setLastTouchUtcTs(null);
    }

    public boolean hasLastTouchUtcTs()
    {
        return getLastTouchUtcTs() != null;
    }

    public boolean hasLastTouchUtcTs(KmTimestamp e)
    {
        return Kmu.isEqual(getLastTouchUtcTs(), e);
    }

    //##################################################
    //# field (ownerUid)
    //##################################################

    public String getOwnerUid()
    {
        return ownerUid;
    }

    public void setOwnerUid(String e)
    {
        e = Validator.getOwnerUidValidator().convert(e);
        ownerUid = e;
    }

    public void clearOwnerUid()
    {
        setOwnerUid(null);
    }

    public boolean hasOwnerUid()
    {
        return Kmu.hasValue(getOwnerUid());
    }

    public boolean hasOwnerUid(String e)
    {
        return Kmu.isEqualIgnoreCase(getOwnerUid(), e);
    }

    public void truncateOwnerUid()
    {
        truncateOwnerUid(false);
    }

    public void truncateOwnerUid(boolean ellipses)
    {
        ownerUid = Kmu.truncate(ownerUid, 30, ellipses);
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
    //# field (lastEndLocalTs)
    //##################################################

    public final KmTimestamp getLastEndLocalTs()
    {
        return KmTimestampUtility.toLocal(getLastEndUtcTs());
    }

    public boolean hasLastEndLocalTs()
    {
        return getLastEndLocalTs() != null;
    }

    public boolean hasLastEndLocalTs(KmTimestamp e)
    {
        return Kmu.isEqual(getLastEndLocalTs(), e);
    }

    //##################################################
    //# field (lastEndLocalTsMessage)
    //##################################################

    public final String getLastEndLocalTsMessage()
    {
        return KmTimestampUtility.formatLocalMessage(getLastEndUtcTs());
    }

    public boolean hasLastEndLocalTsMessage()
    {
        return Kmu.hasValue(getLastEndLocalTsMessage());
    }

    public boolean hasLastEndLocalTsMessage(String e)
    {
        return Kmu.isEqualIgnoreCase(getLastEndLocalTsMessage(), e);
    }

    //##################################################
    //# field (lastEndLocalDate)
    //##################################################

    public final KmDate getLastEndLocalDate()
    {
        return KmTimestampUtility.getDate(getLastEndLocalTs());
    }

    public boolean hasLastEndLocalDate()
    {
        return getLastEndLocalDate() != null;
    }

    public boolean hasLastEndLocalDate(KmDate e)
    {
        return Kmu.isEqual(getLastEndLocalDate(), e);
    }

    //##################################################
    //# field (lastEndLocalTime)
    //##################################################

    public final KmTime getLastEndLocalTime()
    {
        return KmTimestampUtility.getTime(getLastEndLocalTs());
    }

    public boolean hasLastEndLocalTime()
    {
        return getLastEndLocalTime() != null;
    }

    public boolean hasLastEndLocalTime(KmTime e)
    {
        return Kmu.isEqual(getLastEndLocalTime(), e);
    }

    //##################################################
    //# field (lastStartLocalTs)
    //##################################################

    public final KmTimestamp getLastStartLocalTs()
    {
        return KmTimestampUtility.toLocal(getLastStartUtcTs());
    }

    public boolean hasLastStartLocalTs()
    {
        return getLastStartLocalTs() != null;
    }

    public boolean hasLastStartLocalTs(KmTimestamp e)
    {
        return Kmu.isEqual(getLastStartLocalTs(), e);
    }

    //##################################################
    //# field (lastStartLocalTsMessage)
    //##################################################

    public final String getLastStartLocalTsMessage()
    {
        return KmTimestampUtility.formatLocalMessage(getLastStartUtcTs());
    }

    public boolean hasLastStartLocalTsMessage()
    {
        return Kmu.hasValue(getLastStartLocalTsMessage());
    }

    public boolean hasLastStartLocalTsMessage(String e)
    {
        return Kmu.isEqualIgnoreCase(getLastStartLocalTsMessage(), e);
    }

    //##################################################
    //# field (lastStartLocalDate)
    //##################################################

    public final KmDate getLastStartLocalDate()
    {
        return KmTimestampUtility.getDate(getLastStartLocalTs());
    }

    public boolean hasLastStartLocalDate()
    {
        return getLastStartLocalDate() != null;
    }

    public boolean hasLastStartLocalDate(KmDate e)
    {
        return Kmu.isEqual(getLastStartLocalDate(), e);
    }

    //##################################################
    //# field (lastStartLocalTime)
    //##################################################

    public final KmTime getLastStartLocalTime()
    {
        return KmTimestampUtility.getTime(getLastStartLocalTs());
    }

    public boolean hasLastStartLocalTime()
    {
        return getLastStartLocalTime() != null;
    }

    public boolean hasLastStartLocalTime(KmTime e)
    {
        return Kmu.isEqual(getLastStartLocalTime(), e);
    }

    //##################################################
    //# field (lastTouchLocalTs)
    //##################################################

    public final KmTimestamp getLastTouchLocalTs()
    {
        return KmTimestampUtility.toLocal(getLastTouchUtcTs());
    }

    public boolean hasLastTouchLocalTs()
    {
        return getLastTouchLocalTs() != null;
    }

    public boolean hasLastTouchLocalTs(KmTimestamp e)
    {
        return Kmu.isEqual(getLastTouchLocalTs(), e);
    }

    //##################################################
    //# field (lastTouchLocalTsMessage)
    //##################################################

    public final String getLastTouchLocalTsMessage()
    {
        return KmTimestampUtility.formatLocalMessage(getLastTouchUtcTs());
    }

    public boolean hasLastTouchLocalTsMessage()
    {
        return Kmu.hasValue(getLastTouchLocalTsMessage());
    }

    public boolean hasLastTouchLocalTsMessage(String e)
    {
        return Kmu.isEqualIgnoreCase(getLastTouchLocalTsMessage(), e);
    }

    //##################################################
    //# field (lastTouchLocalDate)
    //##################################################

    public final KmDate getLastTouchLocalDate()
    {
        return KmTimestampUtility.getDate(getLastTouchLocalTs());
    }

    public boolean hasLastTouchLocalDate()
    {
        return getLastTouchLocalDate() != null;
    }

    public boolean hasLastTouchLocalDate(KmDate e)
    {
        return Kmu.isEqual(getLastTouchLocalDate(), e);
    }

    //##################################################
    //# field (lastTouchLocalTime)
    //##################################################

    public final KmTime getLastTouchLocalTime()
    {
        return KmTimestampUtility.getTime(getLastTouchLocalTs());
    }

    public boolean hasLastTouchLocalTime()
    {
        return getLastTouchLocalTime() != null;
    }

    public boolean hasLastTouchLocalTime(KmTime e)
    {
        return Kmu.isEqual(getLastTouchLocalTime(), e);
    }


    //##################################################
    //# validate
    //##################################################

    @Override
    protected final MyThreadTopicValidator getValidator()
    {
        return Validator;
    }

    @Override
    protected final MyThreadTopic asSubclass()
    {
        return (MyThreadTopic)this;
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyThreadTopic getCopy()
    {
        return (MyThreadTopic)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        code = null;
    }

    /**
     * Get a copy of this model without any associations or collections.
     * The primary key and lock version are not copied.
     * The basic timestamps are reset.
     */
    public final MyThreadTopic getBasicCopy()
    {
        MyThreadTopic e;
        e = new MyThreadTopic();
        applyEditableFieldsTo(e);
        return e;
    }

    /**
     * Apply the editable fields TO another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsTo(MyThreadTopic e)
    {
        e.setHostAddress(getHostAddress());
        e.setHostName(getHostName());
        e.setLastEndUtcTs(getLastEndUtcTs());
        e.setLastStartUtcTs(getLastStartUtcTs());
        e.setLastTouchUtcTs(getLastTouchUtcTs());
        e.setOwnerUid(getOwnerUid());
    }

    /**
     * Apply the editable fields FROM another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsFrom(MyThreadTopic e)
    {
        setHostAddress(e.getHostAddress());
        setHostName(e.getHostName());
        setLastEndUtcTs(e.getLastEndUtcTs());
        setLastStartUtcTs(e.getLastStartUtcTs());
        setLastTouchUtcTs(e.getLastTouchUtcTs());
        setOwnerUid(e.getOwnerUid());
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyThreadTopicBase) )
            return false;

        MyThreadTopicBase e = (MyThreadTopicBase)o;
        return Kmu.isEqual(getCode(), e.getCode());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getCode());
    }

    public boolean isSame(MyThreadTopic e)
    {
        if ( !Kmu.isEqual(getCode(), e.getCode()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyThreadTopic e)
    {
        if ( !Kmu.isEqual(getAuditLogTitle(), e.getAuditLogTitle()) ) return false;
        if ( !Kmu.isEqual(getDomainSubtitle(), e.getDomainSubtitle()) ) return false;
        if ( !Kmu.isEqual(getDomainTitle(), e.getDomainTitle()) ) return false;
        if ( !Kmu.isEqual(getHostAddress(), e.getHostAddress()) ) return false;
        if ( !Kmu.isEqual(getHostName(), e.getHostName()) ) return false;
        if ( !Kmu.isEqual(getLastEndUtcTs(), e.getLastEndUtcTs()) ) return false;
        if ( !Kmu.isEqual(getLastStartUtcTs(), e.getLastStartUtcTs()) ) return false;
        if ( !Kmu.isEqual(getLastTouchUtcTs(), e.getLastTouchUtcTs()) ) return false;
        if ( !Kmu.isEqual(getOwnerUid(), e.getOwnerUid()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( !Kmu.isEqual(getLastEndLocalTs(), e.getLastEndLocalTs()) ) return false;
        if ( !Kmu.isEqual(getLastEndLocalTsMessage(), e.getLastEndLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getLastEndLocalDate(), e.getLastEndLocalDate()) ) return false;
        if ( !Kmu.isEqual(getLastEndLocalTime(), e.getLastEndLocalTime()) ) return false;
        if ( !Kmu.isEqual(getLastStartLocalTs(), e.getLastStartLocalTs()) ) return false;
        if ( !Kmu.isEqual(getLastStartLocalTsMessage(), e.getLastStartLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getLastStartLocalDate(), e.getLastStartLocalDate()) ) return false;
        if ( !Kmu.isEqual(getLastStartLocalTime(), e.getLastStartLocalTime()) ) return false;
        if ( !Kmu.isEqual(getLastTouchLocalTs(), e.getLastTouchLocalTs()) ) return false;
        if ( !Kmu.isEqual(getLastTouchLocalTsMessage(), e.getLastTouchLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getLastTouchLocalDate(), e.getLastTouchLocalDate()) ) return false;
        if ( !Kmu.isEqual(getLastTouchLocalTime(), e.getLastTouchLocalTime()) ) return false;
        return true;
    }

    public boolean isDifferent(MyThreadTopic e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyThreadTopic e)
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
        out.append("MyThreadTopic");
        out.append("(");
        out.append("Code=");
        out.append(code);
        out.append(")");
        return out.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    Code = " + code);
        System.out.println("    HostAddress = " + hostAddress);
        System.out.println("    HostName = " + hostName);
        System.out.println("    LastEndUtcTs = " + lastEndUtcTs);
        System.out.println("    LastStartUtcTs = " + lastStartUtcTs);
        System.out.println("    LastTouchUtcTs = " + lastTouchUtcTs);
        System.out.println("    OwnerUid = " + ownerUid);
        System.out.println("    LockVersion = " + lockVersion);
    }

    /**
     * Format the primary key fields in a comma separated list.  The format
     * is intended to be suitable for display to users.
     */
    @Override
    public String formatPrimaryKey()
    {
        return code;
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
