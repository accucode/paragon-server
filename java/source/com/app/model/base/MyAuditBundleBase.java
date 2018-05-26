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
public abstract class MyAuditBundleBase
    extends MyAbstractDaoDomain<MyAuditBundle>
    implements KmUidDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaAuditBundle Meta = MyMetaAuditBundle.instance;
    public static final MyAuditBundleTools Tools = MyAuditBundleTools.instance;
    public static final MyAuditBundleValidator Validator = MyAuditBundleValidator.instance;
    public static final MyAuditBundleFinder Finder = MyAuditBundleFinder.instance;

    //##################################################
    //# variables
    //##################################################

    private String changeTypeCode;
    private KmTimestamp createdUtcTs;
    private String domainName;
    private String domainType;
    private String domainUid;
    private String transactionUid;
    private String uid;
    private String userName;
    private MyUser user;
    private List<MyAuditLog> logs;

    //##################################################
    //# constructor
    //##################################################

    public MyAuditBundleBase()
    {
        super();
        setCreatedUtcTs(nowUtc());
        setUid(newUid());
        logs = new ArrayList<>();
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
    //# field (changeTypeCode)
    //##################################################

    public String getChangeTypeCode()
    {
        return changeTypeCode;
    }

    public void setChangeTypeCode(String e)
    {
        e = Validator.getChangeTypeCodeValidator().convert(e);
        changeTypeCode = e;
    }

    public void clearChangeTypeCode()
    {
        setChangeTypeCode(null);
    }

    public boolean hasChangeTypeCode()
    {
        return Kmu.hasValue(getChangeTypeCode());
    }

    public boolean hasChangeTypeCode(String e)
    {
        return Kmu.isEqualIgnoreCase(getChangeTypeCode(), e);
    }

    public void truncateChangeTypeCode()
    {
        truncateChangeTypeCode(false);
    }

    public void truncateChangeTypeCode(boolean ellipses)
    {
        changeTypeCode = Kmu.truncate(changeTypeCode, 30, ellipses);
    }

    public MyAuditBundleChangeType getChangeType()
    {
        return MyAuditBundleChangeType.findCode(getChangeTypeCode());
    }

    public void setChangeType(MyAuditBundleChangeType e)
    {
        if ( e == null )
            setChangeTypeCode(null);
        else
            setChangeTypeCode(e.getCode());
    }

    public boolean hasChangeType()
    {
        return getChangeType() != null;
    }

    public boolean hasChangeType(MyAuditBundleChangeType e)
    {
        return getChangeType() == e;
    }

    public void setChangeTypeAdd()
    {
        setChangeType(MyAuditBundleChangeType.Add);
    }

    public boolean isChangeTypeAdd()
    {
        return hasChangeType(MyAuditBundleChangeType.Add);
    }

    public void setChangeTypeUpdate()
    {
        setChangeType(MyAuditBundleChangeType.Update);
    }

    public boolean isChangeTypeUpdate()
    {
        return hasChangeType(MyAuditBundleChangeType.Update);
    }

    public void setChangeTypeDelete()
    {
        setChangeType(MyAuditBundleChangeType.Delete);
    }

    public boolean isChangeTypeDelete()
    {
        return hasChangeType(MyAuditBundleChangeType.Delete);
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
    //# field (domainName)
    //##################################################

    public String getDomainName()
    {
        return domainName;
    }

    public void setDomainName(String e)
    {
        e = Validator.getDomainNameValidator().convert(e);
        domainName = e;
    }

    public void clearDomainName()
    {
        setDomainName(null);
    }

    public boolean hasDomainName()
    {
        return Kmu.hasValue(getDomainName());
    }

    public boolean hasDomainName(String e)
    {
        return Kmu.isEqualIgnoreCase(getDomainName(), e);
    }

    public void truncateDomainName()
    {
        truncateDomainName(false);
    }

    public void truncateDomainName(boolean ellipses)
    {
        domainName = Kmu.truncate(domainName, 50, ellipses);
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
    //# field (domainType)
    //##################################################

    public String getDomainType()
    {
        return domainType;
    }

    public void setDomainType(String e)
    {
        e = Validator.getDomainTypeValidator().convert(e);
        domainType = e;
    }

    public void clearDomainType()
    {
        setDomainType(null);
    }

    public boolean hasDomainType()
    {
        return Kmu.hasValue(getDomainType());
    }

    public boolean hasDomainType(String e)
    {
        return Kmu.isEqualIgnoreCase(getDomainType(), e);
    }

    public void truncateDomainType()
    {
        truncateDomainType(false);
    }

    public void truncateDomainType(boolean ellipses)
    {
        domainType = Kmu.truncate(domainType, 50, ellipses);
    }

    //##################################################
    //# field (domainTypeLabel)
    //##################################################

    public abstract String getDomainTypeLabel();

    public boolean hasDomainTypeLabel()
    {
        return Kmu.hasValue(getDomainTypeLabel());
    }

    public boolean hasDomainTypeLabel(String e)
    {
        return Kmu.isEqualIgnoreCase(getDomainTypeLabel(), e);
    }

    //##################################################
    //# field (domainUid)
    //##################################################

    public String getDomainUid()
    {
        return domainUid;
    }

    public void setDomainUid(String e)
    {
        e = Validator.getDomainUidValidator().convert(e);
        domainUid = e;
    }

    public void clearDomainUid()
    {
        setDomainUid(null);
    }

    public boolean hasDomainUid()
    {
        return Kmu.hasValue(getDomainUid());
    }

    public boolean hasDomainUid(String e)
    {
        return Kmu.isEqualIgnoreCase(getDomainUid(), e);
    }

    public void truncateDomainUid()
    {
        truncateDomainUid(false);
    }

    public void truncateDomainUid(boolean ellipses)
    {
        domainUid = Kmu.truncate(domainUid, 30, ellipses);
    }

    //##################################################
    //# field (transactionUid)
    //##################################################

    public String getTransactionUid()
    {
        return transactionUid;
    }

    public void setTransactionUid(String e)
    {
        e = Validator.getTransactionUidValidator().convert(e);
        transactionUid = e;
    }

    public void clearTransactionUid()
    {
        setTransactionUid(null);
    }

    public boolean hasTransactionUid()
    {
        return Kmu.hasValue(getTransactionUid());
    }

    public boolean hasTransactionUid(String e)
    {
        return Kmu.isEqualIgnoreCase(getTransactionUid(), e);
    }

    public void truncateTransactionUid()
    {
        truncateTransactionUid(false);
    }

    public void truncateTransactionUid(boolean ellipses)
    {
        transactionUid = Kmu.truncate(transactionUid, 30, ellipses);
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
    //# field (userName)
    //##################################################

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String e)
    {
        e = Validator.getUserNameValidator().convert(e);
        userName = e;
    }

    public void clearUserName()
    {
        setUserName(null);
    }

    public boolean hasUserName()
    {
        return Kmu.hasValue(getUserName());
    }

    public boolean hasUserName(String e)
    {
        return Kmu.isEqualIgnoreCase(getUserName(), e);
    }

    public void truncateUserName()
    {
        truncateUserName(false);
    }

    public void truncateUserName(boolean ellipses)
    {
        userName = Kmu.truncate(userName, 50, ellipses);
    }

    //##################################################
    //# field (changeTypeName)
    //##################################################

    public final String getChangeTypeName()
    {
        return KmEnumIF.getLabelFor(getChangeType());
    }

    public boolean hasChangeTypeName()
    {
        return Kmu.hasValue(getChangeTypeName());
    }

    public boolean hasChangeTypeName(String e)
    {
        return Kmu.isEqualIgnoreCase(getChangeTypeName(), e);
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
    //# user
    //##################################################

    public MyUser getUser()
    {
        return user;
    }

    public void setUser(MyUser e)
    {
        user = e;
        updateUserName();
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
    //# Logs (collection)
    //##################################################

    public KmCollection<MyAuditLog> getLogs()
    {
        return new KmHibernateCollection<>(
            getBaseLogs(),
            (MyAuditBundle)this,
            MyAuditLog.Meta.Bundle);
    }

    public boolean hasLogs()
    {
        return !getBaseLogs().isEmpty();
    }

    public int getLogCount()
    {
        return getBaseLogs().size();
    }

    public List<MyAuditLog> getBaseLogs()
    {
        return logs;
    }

    public MyAuditLog addLog()
    {
        MyAuditLog e;
        e = new MyAuditLog();
        getLogs().add(e);
        return e;
    }

    public void addLog(MyAuditLog e)
    {
        getLogs().add(e);
    }

    public boolean removeLog(MyAuditLog e)
    {
        return getLogs().remove(e);
    }

    public boolean removeLogUid(String myUid)
    {
        MyAuditLog e = findLogUid(myUid);
        if ( e == null )
            return false;

        return removeLog(e);
    }

    public MyAuditLog findLogUid(String myUid)
    {
        for ( MyAuditLog e : getBaseLogs() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearLogs()
    {
        getLogs().clear();
    }

    //##################################################
    //# on change
    //##################################################

    protected abstract void updateUserName();

    //##################################################
    //# validate
    //##################################################

    @Override
    protected final MyAuditBundleValidator getValidator()
    {
        return Validator;
    }

    @Override
    protected final MyAuditBundle asSubclass()
    {
        return (MyAuditBundle)this;
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyAuditBundle getCopy()
    {
        return (MyAuditBundle)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = newUid();

        List<MyAuditLog> old_logs = logs;
        logs = new ArrayList<>();
        for ( MyAuditLog e : old_logs )
            addLog(copy(e));
    }

    /**
     * Get a copy of this model without any associations or collections.
     * The primary key and lock version are not copied.
     * The basic timestamps are reset.
     */
    public final MyAuditBundle getBasicCopy()
    {
        MyAuditBundle e;
        e = new MyAuditBundle();
        applyEditableFieldsTo(e);
        return e;
    }

    /**
     * Apply the editable fields TO another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsTo(MyAuditBundle e)
    {
        e.setChangeTypeCode(getChangeTypeCode());
        e.setCreatedUtcTs(getCreatedUtcTs());
        e.setDomainName(getDomainName());
        e.setDomainType(getDomainType());
        e.setDomainUid(getDomainUid());
        e.setTransactionUid(getTransactionUid());
        e.setUserName(getUserName());
    }

    /**
     * Apply the editable fields FROM another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsFrom(MyAuditBundle e)
    {
        setChangeTypeCode(e.getChangeTypeCode());
        setCreatedUtcTs(e.getCreatedUtcTs());
        setDomainName(e.getDomainName());
        setDomainType(e.getDomainType());
        setDomainUid(e.getDomainUid());
        setTransactionUid(e.getTransactionUid());
        setUserName(e.getUserName());
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyAuditBundleBase) )
            return false;

        MyAuditBundleBase e = (MyAuditBundleBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyAuditBundle e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyAuditBundle e)
    {
        if ( !Kmu.isEqual(getAuditLogTitle(), e.getAuditLogTitle()) ) return false;
        if ( !Kmu.isEqual(getChangeTypeCode(), e.getChangeTypeCode()) ) return false;
        if ( !Kmu.isEqual(getCreatedUtcTs(), e.getCreatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getDomainName(), e.getDomainName()) ) return false;
        if ( !Kmu.isEqual(getDomainSubtitle(), e.getDomainSubtitle()) ) return false;
        if ( !Kmu.isEqual(getDomainTitle(), e.getDomainTitle()) ) return false;
        if ( !Kmu.isEqual(getDomainType(), e.getDomainType()) ) return false;
        if ( !Kmu.isEqual(getDomainTypeLabel(), e.getDomainTypeLabel()) ) return false;
        if ( !Kmu.isEqual(getDomainUid(), e.getDomainUid()) ) return false;
        if ( !Kmu.isEqual(getTransactionUid(), e.getTransactionUid()) ) return false;
        if ( !Kmu.isEqual(getUserName(), e.getUserName()) ) return false;
        if ( !Kmu.isEqual(getChangeTypeName(), e.getChangeTypeName()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTs(), e.getCreatedLocalTs()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTsMessage(), e.getCreatedLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalDate(), e.getCreatedLocalDate()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTime(), e.getCreatedLocalTime()) ) return false;
        return true;
    }

    public boolean isDifferent(MyAuditBundle e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyAuditBundle e)
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
        out.append("MyAuditBundle");
        out.append("(");
        out.append("Uid=");
        out.append(uid);
        out.append(")");
        return out.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    ChangeTypeCode = " + changeTypeCode);
        System.out.println("    CreatedUtcTs = " + createdUtcTs);
        System.out.println("    DomainName = " + domainName);
        System.out.println("    DomainType = " + domainType);
        System.out.println("    DomainUid = " + domainUid);
        System.out.println("    TransactionUid = " + transactionUid);
        System.out.println("    Uid = " + uid);
        System.out.println("    UserName = " + userName);
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

}
