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
public abstract class MyEmailBase
    extends MyAbstractDomain
    implements MyUidDomainIF
    ,MyBasicTimestampsIF
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
    private KmTimestamp updatedUtcTs;
    private KmTimestamp sentUtcTs;
    private String subject;
    private String fromAddress;
    private String statusCode;
    private String errorNotes;
    private Integer lockVersion;
    private MyUser createdBy;
    private MyUser updatedBy;
    private List<MyEmailRecipient> recipients;
    private List<MyEmailPart> parts;

    //##################################################
    //# constructor
    //##################################################

    public MyEmailBase()
    {
        super();
        setUid(newUid());
        setCreatedUtcTs(nowUtc());
        setUpdatedUtcTs(nowUtc());
        setLockVersion(0);
        setCreatedBy(MyGlobals.getCurrentUser());
        setUpdatedBy(MyGlobals.getCurrentUser());
        recipients = new ArrayList<>();
        parts = new ArrayList<>();
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
    //# field (updatedUtcTs)
    //##################################################

    public KmTimestamp getUpdatedUtcTs()
    {
        return updatedUtcTs;
    }

    public void setUpdatedUtcTs(KmTimestamp e)
    {
        e = Validator.getUpdatedUtcTsValidator().convertOnly(e);
        updatedUtcTs = e;
    }

    public void clearUpdatedUtcTs()
    {
        setUpdatedUtcTs(null);
    }

    public boolean hasUpdatedUtcTs()
    {
        return getUpdatedUtcTs() != null;
    }

    public boolean hasUpdatedUtcTs(KmTimestamp e)
    {
        return Kmu.isEqual(getUpdatedUtcTs(), e);
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
        subject = Kmu.truncate(subject, 200, ellipses);
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
        statusCode = Kmu.truncate(statusCode, 30, ellipses);
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
    //# field (statusName)
    //##################################################

    public final String getStatusName()
    {
        return KmEnumIF.getLabelFor(getStatus());
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
    //# field (updatedLocalTs)
    //##################################################

    public final KmTimestamp getUpdatedLocalTs()
    {
        return KmTimestampUtility.toLocal(getUpdatedUtcTs());
    }

    public boolean hasUpdatedLocalTs()
    {
        return getUpdatedLocalTs() != null;
    }

    public boolean hasUpdatedLocalTs(KmTimestamp e)
    {
        return Kmu.isEqual(getUpdatedLocalTs(), e);
    }

    //##################################################
    //# field (updatedLocalTsMessage)
    //##################################################

    public final String getUpdatedLocalTsMessage()
    {
        return KmTimestampUtility.formatLocalMessage(getUpdatedUtcTs());
    }

    public boolean hasUpdatedLocalTsMessage()
    {
        return Kmu.hasValue(getUpdatedLocalTsMessage());
    }

    public boolean hasUpdatedLocalTsMessage(String e)
    {
        return Kmu.isEqualIgnoreCase(getUpdatedLocalTsMessage(), e);
    }

    //##################################################
    //# field (updatedLocalDate)
    //##################################################

    public final KmDate getUpdatedLocalDate()
    {
        return KmTimestampUtility.getDate(getUpdatedLocalTs());
    }

    public boolean hasUpdatedLocalDate()
    {
        return getUpdatedLocalDate() != null;
    }

    public boolean hasUpdatedLocalDate(KmDate e)
    {
        return Kmu.isEqual(getUpdatedLocalDate(), e);
    }

    //##################################################
    //# field (updatedLocalTime)
    //##################################################

    public final KmTime getUpdatedLocalTime()
    {
        return KmTimestampUtility.getTime(getUpdatedLocalTs());
    }

    public boolean hasUpdatedLocalTime()
    {
        return getUpdatedLocalTime() != null;
    }

    public boolean hasUpdatedLocalTime(KmTime e)
    {
        return Kmu.isEqual(getUpdatedLocalTime(), e);
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
    //# createdBy
    //##################################################

    public MyUser getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy(MyUser e)
    {
        createdBy = e;
    }

    public void _setCreatedBy(MyUser e)
    {
        createdBy = e;
    }

    public void clearCreatedBy()
    {
        setCreatedBy(null);
    }

    public boolean hasCreatedBy()
    {
        return getCreatedBy() != null;
    }

    public boolean hasCreatedBy(MyUser e)
    {
        return Kmu.isEqual(getCreatedBy(), e);
    }

    public String getCreatedByFullName()
    {
        if ( hasCreatedBy() )
            return getCreatedBy().getFullName();
        return null;
    }

    public boolean hasCreatedByFullName()
    {
        return hasCreatedBy() && getCreatedBy().hasFullName();
    }

    public boolean hasCreatedByFullName(String e)
    {
        return hasCreatedBy() && getCreatedBy().hasFullName(e);
    }

    //##################################################
    //# updatedBy
    //##################################################

    public MyUser getUpdatedBy()
    {
        return updatedBy;
    }

    public void setUpdatedBy(MyUser e)
    {
        updatedBy = e;
    }

    public void _setUpdatedBy(MyUser e)
    {
        updatedBy = e;
    }

    public void clearUpdatedBy()
    {
        setUpdatedBy(null);
    }

    public boolean hasUpdatedBy()
    {
        return getUpdatedBy() != null;
    }

    public boolean hasUpdatedBy(MyUser e)
    {
        return Kmu.isEqual(getUpdatedBy(), e);
    }

    public String getUpdatedByFullName()
    {
        if ( hasUpdatedBy() )
            return getUpdatedBy().getFullName();
        return null;
    }

    public boolean hasUpdatedByFullName()
    {
        return hasUpdatedBy() && getUpdatedBy().hasFullName();
    }

    public boolean hasUpdatedByFullName(String e)
    {
        return hasUpdatedBy() && getUpdatedBy().hasFullName(e);
    }


    //##################################################
    //# Recipients (collection)
    //##################################################

    public KmCollection<MyEmailRecipient> getRecipients()
    {
        return new KmHibernateCollection<>(
            getBaseRecipients(),
            (MyEmail)this,
            MyEmailRecipient.Meta.Email);
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
        return new KmHibernateCollection<>(
            getBaseParts(),
            (MyEmail)this,
            MyEmailPart.Meta.Email);
    }

    public KmList<MyEmailPart> getSortedParts()
    {
        KmList<MyEmailPart> v;
        v = getParts().toList();
        v.sortOn(MyEmailPart::getSequence);
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
        e.setSequence(getParts().getNextSequence());
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
        uid = newUid();

        List<MyEmailRecipient> old_recipients = recipients;
        recipients = new ArrayList<>();
        for ( MyEmailRecipient e : old_recipients )
            addRecipient(copy(e));

        List<MyEmailPart> old_parts = getSortedParts();
        parts = new ArrayList<>();
        for ( MyEmailPart e : old_parts )
            addPart(copy(e));
    }

    /**
     * Get a copy of this model without any associations or collections.
     * The primary key and lock version are not copied.
     * The basic timestamps are reset.
     */
    public final MyEmail getBasicCopy()
    {
        MyEmail e;
        e = new MyEmail();
        e.setCreatedUtcTs(getCreatedUtcTs());
        e.setUpdatedUtcTs(getUpdatedUtcTs());
        e.setSentUtcTs(getSentUtcTs());
        e.setSubject(getSubject());
        e.setFromAddress(getFromAddress());
        e.setStatusCode(getStatusCode());
        e.setErrorNotes(getErrorNotes());
        resetBasicTimestamps();
        return e;
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
        if ( !Kmu.isEqual(getUpdatedUtcTs(), e.getUpdatedUtcTs()) ) return false;
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
        if ( !Kmu.isEqual(getDisplayString(), e.getDisplayString()) ) return false;
        if ( !Kmu.isEqual(getStatusName(), e.getStatusName()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTs(), e.getCreatedLocalTs()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTsMessage(), e.getCreatedLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalDate(), e.getCreatedLocalDate()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTime(), e.getCreatedLocalTime()) ) return false;
        if ( !Kmu.isEqual(getUpdatedLocalTs(), e.getUpdatedLocalTs()) ) return false;
        if ( !Kmu.isEqual(getUpdatedLocalTsMessage(), e.getUpdatedLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getUpdatedLocalDate(), e.getUpdatedLocalDate()) ) return false;
        if ( !Kmu.isEqual(getUpdatedLocalTime(), e.getUpdatedLocalTime()) ) return false;
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
    //# display
    //##################################################

    @Override
    public String toString()
    {
        StringBuilder out;
        out = new StringBuilder();
        out.append("MyEmail");
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
        System.out.println("    UpdatedUtcTs = " + updatedUtcTs);
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
