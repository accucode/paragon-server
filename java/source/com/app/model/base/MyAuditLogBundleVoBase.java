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
public abstract class MyAuditLogBundleVoBase
    extends MyAbstractDomain
    implements MyDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaAuditLogBundleVo Meta = MyMetaAuditLogBundleVo.instance;
    public static final MyAuditLogBundleVoTools Tools = MyAuditLogBundleVoTools.instance;
    public static final MyAuditLogBundleVoValidator Validator = MyAuditLogBundleVoValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String transactionUid;
    private String userName;
    private String typeCode;
    private KmTimestamp logUtcTs;
    private String domainType;
    private String domainName;
    private String domainUid;
    private String domainBundleUid;
    private MyUser user;

    //##################################################
    //# constructor
    //##################################################

    public MyAuditLogBundleVoBase()
    {
        super();
        setLogUtcTs(nowUtc());
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
        e = Validator.getTransactionUidValidator().convertOnly(e);
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
    //# field (userName)
    //##################################################

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String e)
    {
        e = Validator.getUserNameValidator().convertOnly(e);
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
    //# field (typeCode)
    //##################################################

    public String getTypeCode()
    {
        return typeCode;
    }

    public void setTypeCode(String e)
    {
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
        typeCode = Kmu.truncate(typeCode, 30, ellipses);
    }

    public MyAuditLogBundleVoType getType()
    {
        return MyAuditLogBundleVoType.findCode(getTypeCode());
    }

    public void setType(MyAuditLogBundleVoType e)
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

    public boolean hasType(MyAuditLogBundleVoType e)
    {
        return getType() == e;
    }

    public void setTypeAdd()
    {
        setType(MyAuditLogBundleVoType.Add);
    }

    public boolean isTypeAdd()
    {
        return hasType(MyAuditLogBundleVoType.Add);
    }

    public boolean isNotTypeAdd()
    {
        return !isTypeAdd();
    }

    public void setTypeUpdate()
    {
        setType(MyAuditLogBundleVoType.Update);
    }

    public boolean isTypeUpdate()
    {
        return hasType(MyAuditLogBundleVoType.Update);
    }

    public boolean isNotTypeUpdate()
    {
        return !isTypeUpdate();
    }

    public void setTypeDelete()
    {
        setType(MyAuditLogBundleVoType.Delete);
    }

    public boolean isTypeDelete()
    {
        return hasType(MyAuditLogBundleVoType.Delete);
    }

    public boolean isNotTypeDelete()
    {
        return !isTypeDelete();
    }

    //##################################################
    //# field (logUtcTs)
    //##################################################

    public KmTimestamp getLogUtcTs()
    {
        return logUtcTs;
    }

    public void setLogUtcTs(KmTimestamp e)
    {
        e = Validator.getLogUtcTsValidator().convertOnly(e);
        logUtcTs = e;
    }

    public void clearLogUtcTs()
    {
        setLogUtcTs(null);
    }

    public boolean hasLogUtcTs()
    {
        return getLogUtcTs() != null;
    }

    public boolean hasLogUtcTs(KmTimestamp e)
    {
        return Kmu.isEqual(getLogUtcTs(), e);
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
        e = Validator.getDomainTypeValidator().convertOnly(e);
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
    //# field (domainName)
    //##################################################

    public String getDomainName()
    {
        return domainName;
    }

    public void setDomainName(String e)
    {
        e = Validator.getDomainNameValidator().convertOnly(e);
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
    //# field (domainUid)
    //##################################################

    public String getDomainUid()
    {
        return domainUid;
    }

    public void setDomainUid(String e)
    {
        e = Validator.getDomainUidValidator().convertOnly(e);
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
    //# field (domainBundleUid)
    //##################################################

    public String getDomainBundleUid()
    {
        return domainBundleUid;
    }

    public void setDomainBundleUid(String e)
    {
        e = Validator.getDomainBundleUidValidator().convertOnly(e);
        domainBundleUid = e;
    }

    public void clearDomainBundleUid()
    {
        setDomainBundleUid(null);
    }

    public boolean hasDomainBundleUid()
    {
        return Kmu.hasValue(getDomainBundleUid());
    }

    public boolean hasDomainBundleUid(String e)
    {
        return Kmu.isEqualIgnoreCase(getDomainBundleUid(), e);
    }

    public void truncateDomainBundleUid()
    {
        truncateDomainBundleUid(false);
    }

    public void truncateDomainBundleUid(boolean ellipses)
    {
        domainBundleUid = Kmu.truncate(domainBundleUid, 30, ellipses);
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
    //# field (displayUserName)
    //##################################################

    public abstract String getDisplayUserName();

    public boolean hasDisplayUserName()
    {
        return Kmu.hasValue(getDisplayUserName());
    }

    public boolean hasDisplayUserName(String e)
    {
        return Kmu.isEqualIgnoreCase(getDisplayUserName(), e);
    }

    //##################################################
    //# field (displaySummary)
    //##################################################

    public abstract String getDisplaySummary();

    public boolean hasDisplaySummary()
    {
        return Kmu.hasValue(getDisplaySummary());
    }

    public boolean hasDisplaySummary(String e)
    {
        return Kmu.isEqualIgnoreCase(getDisplaySummary(), e);
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
    //# field (typeName)
    //##################################################

    public final String getTypeName()
    {
        return KmEnumIF.getLabelFor(getType());
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
    //# field (logLocalTs)
    //##################################################

    public final KmTimestamp getLogLocalTs()
    {
        return KmTimestampUtility.toLocal(getLogUtcTs());
    }

    public boolean hasLogLocalTs()
    {
        return getLogLocalTs() != null;
    }

    public boolean hasLogLocalTs(KmTimestamp e)
    {
        return Kmu.isEqual(getLogLocalTs(), e);
    }

    //##################################################
    //# field (logLocalTsMessage)
    //##################################################

    public final String getLogLocalTsMessage()
    {
        return KmTimestampUtility.formatLocalMessage(getLogUtcTs());
    }

    public boolean hasLogLocalTsMessage()
    {
        return Kmu.hasValue(getLogLocalTsMessage());
    }

    public boolean hasLogLocalTsMessage(String e)
    {
        return Kmu.isEqualIgnoreCase(getLogLocalTsMessage(), e);
    }

    //##################################################
    //# field (logLocalDate)
    //##################################################

    public final KmDate getLogLocalDate()
    {
        return KmTimestampUtility.getDate(getLogLocalTs());
    }

    public boolean hasLogLocalDate()
    {
        return getLogLocalDate() != null;
    }

    public boolean hasLogLocalDate(KmDate e)
    {
        return Kmu.isEqual(getLogLocalDate(), e);
    }

    //##################################################
    //# field (logLocalTime)
    //##################################################

    public final KmTime getLogLocalTime()
    {
        return KmTimestampUtility.getTime(getLogLocalTs());
    }

    public boolean hasLogLocalTime()
    {
        return getLogLocalTime() != null;
    }

    public boolean hasLogLocalTime(KmTime e)
    {
        return Kmu.isEqual(getLogLocalTime(), e);
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
    public void validate()
    {
        Validator.validate((MyAuditLogBundleVo)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyAuditLogBundleVo)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyAuditLogBundleVo)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyAuditLogBundleVo getCopy()
    {
        return (MyAuditLogBundleVo)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
    }

    /**
     * Get a copy of this model without any associations or collections.
     * The primary key and lock version are not copied.
     * The basic timestamps are reset.
     */
    public final MyAuditLogBundleVo getBasicCopy()
    {
        MyAuditLogBundleVo e;
        e = new MyAuditLogBundleVo();
        e.setTransactionUid(getTransactionUid());
        e.setUserName(getUserName());
        e.setTypeCode(getTypeCode());
        e.setLogUtcTs(getLogUtcTs());
        e.setDomainType(getDomainType());
        e.setDomainName(getDomainName());
        e.setDomainUid(getDomainUid());
        e.setDomainBundleUid(getDomainBundleUid());
        return e;
    }

    //##################################################
    //# compare
    //##################################################

    public boolean isSame(MyAuditLogBundleVo e)
    {
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyAuditLogBundleVo e)
    {
        if ( !Kmu.isEqual(getTransactionUid(), e.getTransactionUid()) ) return false;
        if ( !Kmu.isEqual(getUserName(), e.getUserName()) ) return false;
        if ( !Kmu.isEqual(getTypeCode(), e.getTypeCode()) ) return false;
        if ( !Kmu.isEqual(getLogUtcTs(), e.getLogUtcTs()) ) return false;
        if ( !Kmu.isEqual(getDomainType(), e.getDomainType()) ) return false;
        if ( !Kmu.isEqual(getDomainName(), e.getDomainName()) ) return false;
        if ( !Kmu.isEqual(getDomainUid(), e.getDomainUid()) ) return false;
        if ( !Kmu.isEqual(getDomainBundleUid(), e.getDomainBundleUid()) ) return false;
        if ( !Kmu.isEqual(getDomainTypeLabel(), e.getDomainTypeLabel()) ) return false;
        if ( !Kmu.isEqual(getDisplayUserName(), e.getDisplayUserName()) ) return false;
        if ( !Kmu.isEqual(getDisplaySummary(), e.getDisplaySummary()) ) return false;
        if ( !Kmu.isEqual(getDisplayString(), e.getDisplayString()) ) return false;
        if ( !Kmu.isEqual(getTypeName(), e.getTypeName()) ) return false;
        if ( !Kmu.isEqual(getLogLocalTs(), e.getLogLocalTs()) ) return false;
        if ( !Kmu.isEqual(getLogLocalTsMessage(), e.getLogLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getLogLocalDate(), e.getLogLocalDate()) ) return false;
        if ( !Kmu.isEqual(getLogLocalTime(), e.getLogLocalTime()) ) return false;
        return true;
    }

    public boolean isDifferent(MyAuditLogBundleVo e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyAuditLogBundleVo e)
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
        out.append("MyAuditLogBundleVo");
        out.append("(");
        out.append(")");
        return out.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    TransactionUid = " + transactionUid);
        System.out.println("    UserName = " + userName);
        System.out.println("    TypeCode = " + typeCode);
        System.out.println("    LogUtcTs = " + logUtcTs);
        System.out.println("    DomainType = " + domainType);
        System.out.println("    DomainName = " + domainName);
        System.out.println("    DomainUid = " + domainUid);
        System.out.println("    DomainBundleUid = " + domainBundleUid);
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
