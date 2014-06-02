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

public abstract class MyEmailBase
    extends MyAbstractDomain
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaEmail Meta = MyMetaEmail.instance;
    public static final MyEmailTools Tools = MyEmailTools.instance;
    public static final MyEmailValidator Validator = MyEmailValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private KmTimestamp createdUtcTs;
    private KmTimestamp sentUtcTs;
    private String subject;
    private String fromAddress;
    private String statusCode;
    private String errorNotes;
    private Integer lockVersion;
    private List<MyEmailRecipient> recipients;
    private List<MyEmailPart> parts;

    //##################################################
    //# constructor
    //##################################################

    public MyEmailBase()
    {
        super();
        setUid(newUid());
        setCreatedUtcTs(getNowUtc());
        recipients = new ArrayList<MyEmailRecipient>();
        parts = new ArrayList<MyEmailPart>();
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
    //# field (sentUtcTs)
    //##################################################

    public KmTimestamp getSentUtcTs()
    {
        return sentUtcTs;
    }

    public void setSentUtcTs(KmTimestamp e)
    {
        checkReadOnly();
        e = Validator.getSentUtcTsValidator().convertOnly(e);
        sentUtcTs = e;
    }

    public void clearSentUtcTs()
    {
        setSentUtcTs(null);
    }

    public boolean hasSentUtcTs()
    {
        return getSentUtcTs() != null;
    }

    public boolean hasSentUtcTs(KmTimestamp e)
    {
        return Kmu.isEqual(getSentUtcTs(), e);
    }

    //##################################################
    //# field (subject)
    //##################################################

    public String getSubject()
    {
        return subject;
    }

    public void setSubject(String e)
    {
        checkReadOnly();
        e = Validator.getSubjectValidator().convertOnly(e);
        subject = e;
    }

    public void clearSubject()
    {
        setSubject(null);
    }

    public boolean hasSubject()
    {
        return Kmu.hasValue(getSubject());
    }

    public boolean hasSubject(String e)
    {
        return Kmu.isEqualIgnoreCase(getSubject(), e);
    }

    public void truncateSubject()
    {
        truncateSubject(false);
    }

    public void truncateSubject(boolean ellipses)
    {
        subject = Kmu.truncate(subject, 100, ellipses);
    }

    //##################################################
    //# field (fromAddress)
    //##################################################

    public String getFromAddress()
    {
        return fromAddress;
    }

    public void setFromAddress(String e)
    {
        checkReadOnly();
        e = Validator.getFromAddressValidator().convertOnly(e);
        fromAddress = e;
    }

    public void clearFromAddress()
    {
        setFromAddress(null);
    }

    public boolean hasFromAddress()
    {
        return Kmu.hasValue(getFromAddress());
    }

    public boolean hasFromAddress(String e)
    {
        return Kmu.isEqualIgnoreCase(getFromAddress(), e);
    }

    public void truncateFromAddress()
    {
        truncateFromAddress(false);
    }

    public void truncateFromAddress(boolean ellipses)
    {
        fromAddress = Kmu.truncate(fromAddress, 50, ellipses);
    }

    //##################################################
    //# field (statusCode)
    //##################################################

    public String getStatusCode()
    {
        return statusCode;
    }

    public void setStatusCode(String e)
    {
        checkReadOnly();
        e = Validator.getStatusCodeValidator().convertOnly(e);
        statusCode = e;
    }

    public void clearStatusCode()
    {
        setStatusCode(null);
    }

    public boolean hasStatusCode()
    {
        return Kmu.hasValue(getStatusCode());
    }

    public boolean hasStatusCode(String e)
    {
        return Kmu.isEqualIgnoreCase(getStatusCode(), e);
    }

    public void truncateStatusCode()
    {
        truncateStatusCode(false);
    }

    public void truncateStatusCode(boolean ellipses)
    {
        statusCode = Kmu.truncate(statusCode, 1, ellipses);
    }

    public MyEmailStatus getStatus()
    {
        return MyEmailStatus.findCode(getStatusCode());
    }

    public void setStatus(MyEmailStatus e)
    {
        if ( e == null )
            setStatusCode(null);
        else
            setStatusCode(e.getCode());
    }

    public boolean hasStatus()
    {
        return getStatus() != null;
    }

    public boolean hasStatus(MyEmailStatus e)
    {
        return getStatus() == e;
    }

    public void setStatusDraft()
    {
        setStatus(MyEmailStatus.Draft);
    }

    public boolean isStatusDraft()
    {
        return hasStatus(MyEmailStatus.Draft);
    }

    public boolean isNotStatusDraft()
    {
        return !isStatusDraft();
    }

    public void setStatusReady()
    {
        setStatus(MyEmailStatus.Ready);
    }

    public boolean isStatusReady()
    {
        return hasStatus(MyEmailStatus.Ready);
    }

    public boolean isNotStatusReady()
    {
        return !isStatusReady();
    }

    public void setStatusPending()
    {
        setStatus(MyEmailStatus.Pending);
    }

    public boolean isStatusPending()
    {
        return hasStatus(MyEmailStatus.Pending);
    }

    public boolean isNotStatusPending()
    {
        return !isStatusPending();
    }

    public void setStatusSent()
    {
        setStatus(MyEmailStatus.Sent);
    }

    public boolean isStatusSent()
    {
        return hasStatus(MyEmailStatus.Sent);
    }

    public boolean isNotStatusSent()
    {
        return !isStatusSent();
    }

    public void setStatusError()
    {
        setStatus(MyEmailStatus.Error);
    }

    public boolean isStatusError()
    {
        return hasStatus(MyEmailStatus.Error);
    }

    public boolean isNotStatusError()
    {
        return !isStatusError();
    }

    public void setStatusIgnored()
    {
        setStatus(MyEmailStatus.Ignored);
    }

    public boolean isStatusIgnored()
    {
        return hasStatus(MyEmailStatus.Ignored);
    }

    public boolean isNotStatusIgnored()
    {
        return !isStatusIgnored();
    }

    //##################################################
    //# field (errorNotes)
    //##################################################

    public String getErrorNotes()
    {
        return errorNotes;
    }

    public void setErrorNotes(String e)
    {
        checkReadOnly();
        e = Validator.getErrorNotesValidator().convertOnly(e);
        errorNotes = e;
    }

    public void clearErrorNotes()
    {
        setErrorNotes(null);
    }

    public boolean hasErrorNotes()
    {
        return Kmu.hasValue(getErrorNotes());
    }

    public boolean hasErrorNotes(String e)
    {
        return Kmu.isEqualIgnoreCase(getErrorNotes(), e);
    }

    public void truncateErrorNotes()
    {
        truncateErrorNotes(false);
    }

    public void truncateErrorNotes(boolean ellipses)
    {
        errorNotes = Kmu.truncate(errorNotes, 100, ellipses);
    }

    //##################################################
    //# field (recipientSummary)
    //##################################################

    public abstract String getRecipientSummary();

    public boolean hasRecipientSummary()
    {
        return Kmu.hasValue(getRecipientSummary());
    }

    public boolean hasRecipientSummary(String e)
    {
        return Kmu.isEqualIgnoreCase(getRecipientSummary(), e);
    }

    //##################################################
    //# field (toAddressesLabel)
    //##################################################

    public abstract String getToAddressesLabel();

    public boolean hasToAddressesLabel()
    {
        return Kmu.hasValue(getToAddressesLabel());
    }

    public boolean hasToAddressesLabel(String e)
    {
        return Kmu.isEqualIgnoreCase(getToAddressesLabel(), e);
    }

    //##################################################
    //# field (ccAddressesLabel)
    //##################################################

    public abstract String getCcAddressesLabel();

    public boolean hasCcAddressesLabel()
    {
        return Kmu.hasValue(getCcAddressesLabel());
    }

    public boolean hasCcAddressesLabel(String e)
    {
        return Kmu.isEqualIgnoreCase(getCcAddressesLabel(), e);
    }

    //##################################################
    //# field (partsAsHtml)
    //##################################################

    public abstract String getPartsAsHtml();

    public boolean hasPartsAsHtml()
    {
        return Kmu.hasValue(getPartsAsHtml());
    }

    public boolean hasPartsAsHtml(String e)
    {
        return Kmu.isEqualIgnoreCase(getPartsAsHtml(), e);
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
    //# field (statusName)
    //##################################################

    public final String getStatusName()
    {
        return Kmu.getName(getStatus());
    }

    public boolean hasStatusName()
    {
        return Kmu.hasValue(getStatusName());
    }

    public boolean hasStatusName(String e)
    {
        return Kmu.isEqualIgnoreCase(getStatusName(), e);
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
    //# field (sentLocalTs)
    //##################################################

    public final KmTimestamp getSentLocalTs()
    {
        return KmTimestampUtility.toLocal(getSentUtcTs());
    }

    public boolean hasSentLocalTs()
    {
        return getSentLocalTs() != null;
    }

    public boolean hasSentLocalTs(KmTimestamp e)
    {
        return Kmu.isEqual(getSentLocalTs(), e);
    }

    //##################################################
    //# field (sentLocalTsMessage)
    //##################################################

    public final String getSentLocalTsMessage()
    {
        return KmTimestampUtility.formatLocalMessage(getSentUtcTs());
    }

    public boolean hasSentLocalTsMessage()
    {
        return Kmu.hasValue(getSentLocalTsMessage());
    }

    public boolean hasSentLocalTsMessage(String e)
    {
        return Kmu.isEqualIgnoreCase(getSentLocalTsMessage(), e);
    }

    //##################################################
    //# field (sentLocalDate)
    //##################################################

    public final KmDate getSentLocalDate()
    {
        return KmTimestampUtility.getDate(getSentLocalTs());
    }

    public boolean hasSentLocalDate()
    {
        return getSentLocalDate() != null;
    }

    public boolean hasSentLocalDate(KmDate e)
    {
        return Kmu.isEqual(getSentLocalDate(), e);
    }

    //##################################################
    //# field (sentLocalTime)
    //##################################################

    public final KmTime getSentLocalTime()
    {
        return KmTimestampUtility.getTime(getSentLocalTs());
    }

    public boolean hasSentLocalTime()
    {
        return getSentLocalTime() != null;
    }

    public boolean hasSentLocalTime(KmTime e)
    {
        return Kmu.isEqual(getSentLocalTime(), e);
    }


    //##################################################
    //# Recipients (collection)
    //##################################################

    public KmCollection<MyEmailRecipient> getRecipients()
    {
        return new KmHibernateCollection<MyEmailRecipient,MyEmail>(
            getBaseRecipients(),
            (MyEmail)this,
            MyEmailRecipient.Meta.Email.getAdaptor());
    }

    public boolean hasRecipients()
    {
        return !getBaseRecipients().isEmpty();
    }

    public int getRecipientCount()
    {
        return getBaseRecipients().size();
    }

    public List<MyEmailRecipient> getBaseRecipients()
    {
        return recipients;
    }

    public MyEmailRecipient addRecipient()
    {
        MyEmailRecipient e;
        e = new MyEmailRecipient();
        getRecipients().add(e);
        return e;
    }

    public void addRecipient(MyEmailRecipient e)
    {
        getRecipients().add(e);
    }

    public boolean removeRecipient(MyEmailRecipient e)
    {
        return getRecipients().remove(e);
    }

    public boolean removeRecipientUid(String myUid)
    {
        MyEmailRecipient e = findRecipientUid(myUid);
        if ( e == null )
            return false;

        return removeRecipient(e);
    }

    public MyEmailRecipient findRecipientUid(String myUid)
    {
        for ( MyEmailRecipient e : getBaseRecipients() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearRecipients()
    {
        getRecipients().clear();
    }

    //##################################################
    //# Parts (collection)
    //##################################################

    public KmCollection<MyEmailPart> getParts()
    {
        return new KmHibernateCollection<MyEmailPart,MyEmail>(
            getBaseParts(),
            (MyEmail)this,
            MyEmailPart.Meta.Email.getAdaptor());
    }

    public KmList<MyEmailPart> getSortedParts()
    {
        KmList<MyEmailPart> v;
        v = getParts().toList();
        v.sortOn(MyEmailPart.Meta.Sequence);
        return v;
    }

    public boolean hasParts()
    {
        return !getBaseParts().isEmpty();
    }

    public int getPartCount()
    {
        return getBaseParts().size();
    }

    public List<MyEmailPart> getBaseParts()
    {
        return parts;
    }

    public MyEmailPart addPart()
    {
        MyEmailPart e;
        e = new MyEmailPart();
        e.setSequence(getParts().getNextSequence());
        getParts().add(e);
        return e;
    }

    public void addPart(MyEmailPart e)
    {
        getParts().add(e);
    }

    public boolean removePart(MyEmailPart e)
    {
        return getParts().remove(e);
    }

    public boolean removePartUid(String myUid)
    {
        MyEmailPart e = findPartUid(myUid);
        if ( e == null )
            return false;

        return removePart(e);
    }

    public MyEmailPart findPartUid(String myUid)
    {
        for ( MyEmailPart e : getBaseParts() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearParts()
    {
        getParts().clear();
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyEmail)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyEmail)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyEmail)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyEmail getCopy()
    {
        return (MyEmail)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = null;

        List<MyEmailRecipient> old_recipients = recipients;
        recipients = new ArrayList<MyEmailRecipient>();
        for ( MyEmailRecipient e : old_recipients )
            addRecipient(copy(e));

        List<MyEmailPart> old_parts = parts;
        parts = new ArrayList<MyEmailPart>();
        for ( MyEmailPart e : old_parts )
            addPart(copy(e));
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyEmailBase) )
            return false;

        MyEmailBase e = (MyEmailBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyEmail e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyEmail e)
    {
        if ( !Kmu.isEqual(getCreatedUtcTs(), e.getCreatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getSentUtcTs(), e.getSentUtcTs()) ) return false;
        if ( !Kmu.isEqual(getSubject(), e.getSubject()) ) return false;
        if ( !Kmu.isEqual(getFromAddress(), e.getFromAddress()) ) return false;
        if ( !Kmu.isEqual(getStatusCode(), e.getStatusCode()) ) return false;
        if ( !Kmu.isEqual(getErrorNotes(), e.getErrorNotes()) ) return false;
        if ( !Kmu.isEqual(getRecipientSummary(), e.getRecipientSummary()) ) return false;
        if ( !Kmu.isEqual(getToAddressesLabel(), e.getToAddressesLabel()) ) return false;
        if ( !Kmu.isEqual(getCcAddressesLabel(), e.getCcAddressesLabel()) ) return false;
        if ( !Kmu.isEqual(getPartsAsHtml(), e.getPartsAsHtml()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( !Kmu.isEqual(getStatusName(), e.getStatusName()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTs(), e.getCreatedLocalTs()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTsMessage(), e.getCreatedLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalDate(), e.getCreatedLocalDate()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTime(), e.getCreatedLocalTime()) ) return false;
        if ( !Kmu.isEqual(getSentLocalTs(), e.getSentLocalTs()) ) return false;
        if ( !Kmu.isEqual(getSentLocalTsMessage(), e.getSentLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getSentLocalDate(), e.getSentLocalDate()) ) return false;
        if ( !Kmu.isEqual(getSentLocalTime(), e.getSentLocalTime()) ) return false;
        return true;
    }

    public boolean isDifferent(MyEmail e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyEmail e)
    {
        return !isSameIgnoringKey(e);
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

        if ( p.hasKey("subject") )
            setSubject(p.getString("subject"));

        if ( p.hasKey("fromAddress") )
            setFromAddress(p.getString("fromAddress"));

        if ( p.hasKey("statusCode") )
            setStatusCode(p.getString("statusCode"));

        if ( p.hasKey("errorNotes") )
            setErrorNotes(p.getString("errorNotes"));

        if ( p.hasKey("lockVersion") )
            setLockVersion(p.getInteger("lockVersion"));
    }

    public KmMap<String,String> exportPropertyMap()
    {
        KmProperties p;
        p = new KmProperties();

        if ( hasUid() )
            p.setString("uid", getUid());

        if ( hasSubject() )
            p.setString("subject", getSubject());

        if ( hasFromAddress() )
            p.setString("fromAddress", getFromAddress());

        if ( hasStatusCode() )
            p.setString("statusCode", getStatusCode());

        if ( hasErrorNotes() )
            p.setString("errorNotes", getErrorNotes());

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
        sb.append("MyEmail");
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
        System.out.println("    SentUtcTs = " + sentUtcTs);
        System.out.println("    Subject = " + subject);
        System.out.println("    FromAddress = " + fromAddress);
        System.out.println("    StatusCode = " + statusCode);
        System.out.println("    ErrorNotes = " + errorNotes);
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
