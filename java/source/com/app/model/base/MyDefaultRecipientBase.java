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
public abstract class MyDefaultRecipientBase
    extends MyAbstractDaoDomain<MyDefaultRecipient>
    implements KmUidDomainIF
    ,MyBasicTimestampsIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaDefaultRecipient Meta = MyMetaDefaultRecipient.instance;
    public static final MyDefaultRecipientTools Tools = MyDefaultRecipientTools.instance;
    public static final MyDefaultRecipientValidator Validator = MyDefaultRecipientValidator.instance;
    public static final MyDefaultRecipientFinder Finder = MyDefaultRecipientFinder.instance;

    //##################################################
    //# variables
    //##################################################

    private String contactTypeCode;
    private KmTimestamp createdUtcTs;
    private String customEmail;
    private String typeCode;
    private String uid;
    private KmTimestamp updatedUtcTs;
    private Integer lockVersion;
    private MyUser createdBy;
    private MyEmailTemplate emailTemplate;
    private MyUser updatedBy;

    //##################################################
    //# constructor
    //##################################################

    public MyDefaultRecipientBase()
    {
        super();
        setCreatedUtcTs(nowUtc());
        setUid(newUid());
        setUpdatedUtcTs(nowUtc());
        setLockVersion(0);
        setCreatedBy(MyGlobals.getCurrentUser());
        setUpdatedBy(MyGlobals.getCurrentUser());
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
    //# field (contactTypeCode)
    //##################################################

    public String getContactTypeCode()
    {
        return contactTypeCode;
    }

    public void setContactTypeCode(String e)
    {
        e = Validator.getContactTypeCodeValidator().convert(e);
        contactTypeCode = e;
    }

    public void clearContactTypeCode()
    {
        setContactTypeCode(null);
    }

    public boolean hasContactTypeCode()
    {
        return Kmu.hasValue(getContactTypeCode());
    }

    public boolean hasContactTypeCode(String e)
    {
        return Kmu.isEqualIgnoreCase(getContactTypeCode(), e);
    }

    public void truncateContactTypeCode()
    {
        truncateContactTypeCode(false);
    }

    public void truncateContactTypeCode(boolean ellipses)
    {
        contactTypeCode = Kmu.truncate(contactTypeCode, 30, ellipses);
    }

    public MyDefaultRecipientContactType getContactType()
    {
        return MyDefaultRecipientContactType.findCode(getContactTypeCode());
    }

    public void setContactType(MyDefaultRecipientContactType e)
    {
        if ( e == null )
            setContactTypeCode(null);
        else
            setContactTypeCode(e.getCode());
    }

    public boolean hasContactType()
    {
        return getContactType() != null;
    }

    public boolean hasContactType(MyDefaultRecipientContactType e)
    {
        return getContactType() == e;
    }

    public void setContactTypeProjectSupport()
    {
        setContactType(MyDefaultRecipientContactType.ProjectSupport);
    }

    public boolean isContactTypeProjectSupport()
    {
        return hasContactType(MyDefaultRecipientContactType.ProjectSupport);
    }

    public void setContactTypeMain()
    {
        setContactType(MyDefaultRecipientContactType.Main);
    }

    public boolean isContactTypeMain()
    {
        return hasContactType(MyDefaultRecipientContactType.Main);
    }

    public void setContactTypeInstall()
    {
        setContactType(MyDefaultRecipientContactType.Install);
    }

    public boolean isContactTypeInstall()
    {
        return hasContactType(MyDefaultRecipientContactType.Install);
    }

    public void setContactTypeTechnical()
    {
        setContactType(MyDefaultRecipientContactType.Technical);
    }

    public boolean isContactTypeTechnical()
    {
        return hasContactType(MyDefaultRecipientContactType.Technical);
    }

    public void setContactTypeScheduling()
    {
        setContactType(MyDefaultRecipientContactType.Scheduling);
    }

    public boolean isContactTypeScheduling()
    {
        return hasContactType(MyDefaultRecipientContactType.Scheduling);
    }

    public void setContactTypeSales()
    {
        setContactType(MyDefaultRecipientContactType.Sales);
    }

    public boolean isContactTypeSales()
    {
        return hasContactType(MyDefaultRecipientContactType.Sales);
    }

    public void setContactTypeRequester()
    {
        setContactType(MyDefaultRecipientContactType.Requester);
    }

    public boolean isContactTypeRequester()
    {
        return hasContactType(MyDefaultRecipientContactType.Requester);
    }

    public void setContactTypeCustomerApproval()
    {
        setContactType(MyDefaultRecipientContactType.CustomerApproval);
    }

    public boolean isContactTypeCustomerApproval()
    {
        return hasContactType(MyDefaultRecipientContactType.CustomerApproval);
    }

    public void setContactTypeCustomerBilling()
    {
        setContactType(MyDefaultRecipientContactType.CustomerBilling);
    }

    public boolean isContactTypeCustomerBilling()
    {
        return hasContactType(MyDefaultRecipientContactType.CustomerBilling);
    }

    public void setContactTypeProjectNotifications()
    {
        setContactType(MyDefaultRecipientContactType.ProjectNotifications);
    }

    public boolean isContactTypeProjectNotifications()
    {
        return hasContactType(MyDefaultRecipientContactType.ProjectNotifications);
    }

    public void setContactTypeJobNotifications()
    {
        setContactType(MyDefaultRecipientContactType.JobNotifications);
    }

    public boolean isContactTypeJobNotifications()
    {
        return hasContactType(MyDefaultRecipientContactType.JobNotifications);
    }

    public void setContactTypeCustomerNotifications()
    {
        setContactType(MyDefaultRecipientContactType.CustomerNotifications);
    }

    public boolean isContactTypeCustomerNotifications()
    {
        return hasContactType(MyDefaultRecipientContactType.CustomerNotifications);
    }

    public void setContactTypeCustom()
    {
        setContactType(MyDefaultRecipientContactType.Custom);
    }

    public boolean isContactTypeCustom()
    {
        return hasContactType(MyDefaultRecipientContactType.Custom);
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
    //# field (customEmail)
    //##################################################

    public String getCustomEmail()
    {
        return customEmail;
    }

    public void setCustomEmail(String e)
    {
        e = Validator.getCustomEmailValidator().convert(e);
        customEmail = e;
    }

    public void clearCustomEmail()
    {
        setCustomEmail(null);
    }

    public boolean hasCustomEmail()
    {
        return Kmu.hasValue(getCustomEmail());
    }

    public boolean hasCustomEmail(String e)
    {
        return Kmu.isEqualIgnoreCase(getCustomEmail(), e);
    }

    public void truncateCustomEmail()
    {
        truncateCustomEmail(false);
    }

    public void truncateCustomEmail(boolean ellipses)
    {
        customEmail = Kmu.truncate(customEmail, 1000, ellipses);
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
    //# field (typeCode)
    //##################################################

    public String getTypeCode()
    {
        return typeCode;
    }

    public void setTypeCode(String e)
    {
        e = Validator.getTypeCodeValidator().convert(e);
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

    public MyDefaultRecipientType getType()
    {
        return MyDefaultRecipientType.findCode(getTypeCode());
    }

    public void setType(MyDefaultRecipientType e)
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

    public boolean hasType(MyDefaultRecipientType e)
    {
        return getType() == e;
    }

    public void setTypeTo()
    {
        setType(MyDefaultRecipientType.To);
    }

    public boolean isTypeTo()
    {
        return hasType(MyDefaultRecipientType.To);
    }

    public void setTypeCc()
    {
        setType(MyDefaultRecipientType.Cc);
    }

    public boolean isTypeCc()
    {
        return hasType(MyDefaultRecipientType.Cc);
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
    //# field (updatedUtcTs)
    //##################################################

    public KmTimestamp getUpdatedUtcTs()
    {
        return updatedUtcTs;
    }

    public void setUpdatedUtcTs(KmTimestamp e)
    {
        e = Validator.getUpdatedUtcTsValidator().convert(e);
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
    //# field (contactTypeName)
    //##################################################

    public final String getContactTypeName()
    {
        return KmEnumIF.getLabelFor(getContactType());
    }

    public boolean hasContactTypeName()
    {
        return Kmu.hasValue(getContactTypeName());
    }

    public boolean hasContactTypeName(String e)
    {
        return Kmu.isEqualIgnoreCase(getContactTypeName(), e);
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

    public void setCreatedByFullName(String e)
    {
        getCreatedBy().setFullName(e);
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
    //# emailTemplate
    //##################################################

    public MyEmailTemplate getEmailTemplate()
    {
        return emailTemplate;
    }

    public void setEmailTemplate(MyEmailTemplate e)
    {
        emailTemplate = e;
    }

    public void _setEmailTemplate(MyEmailTemplate e)
    {
        emailTemplate = e;
    }

    public void clearEmailTemplate()
    {
        setEmailTemplate(null);
    }

    public boolean hasEmailTemplate()
    {
        return getEmailTemplate() != null;
    }

    public boolean hasEmailTemplate(MyEmailTemplate e)
    {
        return Kmu.isEqual(getEmailTemplate(), e);
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

    public void setUpdatedByFullName(String e)
    {
        getUpdatedBy().setFullName(e);
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
    //# validate
    //##################################################

    @Override
    protected final MyDefaultRecipientValidator getValidator()
    {
        return Validator;
    }

    @Override
    protected final MyDefaultRecipient asSubclass()
    {
        return (MyDefaultRecipient)this;
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyDefaultRecipient getCopy()
    {
        return (MyDefaultRecipient)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = newUid();
        emailTemplate = null;
    }

    /**
     * Get a copy of this model without any associations or collections.
     * The primary key and lock version are not copied.
     * The basic timestamps are reset.
     */
    public final MyDefaultRecipient getBasicCopy()
    {
        MyDefaultRecipient e;
        e = new MyDefaultRecipient();
        applyEditableFieldsTo(e);
        resetBasicTimestamps();
        return e;
    }

    /**
     * Apply the editable fields TO another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsTo(MyDefaultRecipient e)
    {
        e.setContactTypeCode(getContactTypeCode());
        e.setCreatedUtcTs(getCreatedUtcTs());
        e.setCustomEmail(getCustomEmail());
        e.setTypeCode(getTypeCode());
        e.setUpdatedUtcTs(getUpdatedUtcTs());
    }

    /**
     * Apply the editable fields FROM another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsFrom(MyDefaultRecipient e)
    {
        setContactTypeCode(e.getContactTypeCode());
        setCreatedUtcTs(e.getCreatedUtcTs());
        setCustomEmail(e.getCustomEmail());
        setTypeCode(e.getTypeCode());
        setUpdatedUtcTs(e.getUpdatedUtcTs());
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyDefaultRecipientBase) )
            return false;

        MyDefaultRecipientBase e = (MyDefaultRecipientBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyDefaultRecipient e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyDefaultRecipient e)
    {
        if ( !Kmu.isEqual(getAuditLogTitle(), e.getAuditLogTitle()) ) return false;
        if ( !Kmu.isEqual(getContactTypeCode(), e.getContactTypeCode()) ) return false;
        if ( !Kmu.isEqual(getCreatedUtcTs(), e.getCreatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getCustomEmail(), e.getCustomEmail()) ) return false;
        if ( !Kmu.isEqual(getDomainSubtitle(), e.getDomainSubtitle()) ) return false;
        if ( !Kmu.isEqual(getDomainTitle(), e.getDomainTitle()) ) return false;
        if ( !Kmu.isEqual(getTypeCode(), e.getTypeCode()) ) return false;
        if ( !Kmu.isEqual(getUpdatedUtcTs(), e.getUpdatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( !Kmu.isEqual(getContactTypeName(), e.getContactTypeName()) ) return false;
        if ( !Kmu.isEqual(getTypeName(), e.getTypeName()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTs(), e.getCreatedLocalTs()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTsMessage(), e.getCreatedLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalDate(), e.getCreatedLocalDate()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTime(), e.getCreatedLocalTime()) ) return false;
        if ( !Kmu.isEqual(getUpdatedLocalTs(), e.getUpdatedLocalTs()) ) return false;
        if ( !Kmu.isEqual(getUpdatedLocalTsMessage(), e.getUpdatedLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getUpdatedLocalDate(), e.getUpdatedLocalDate()) ) return false;
        if ( !Kmu.isEqual(getUpdatedLocalTime(), e.getUpdatedLocalTime()) ) return false;
        return true;
    }

    public boolean isDifferent(MyDefaultRecipient e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyDefaultRecipient e)
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
        out.append("MyDefaultRecipient");
        out.append("(");
        out.append("Uid=");
        out.append(uid);
        out.append(")");
        return out.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    ContactTypeCode = " + contactTypeCode);
        System.out.println("    CreatedUtcTs = " + createdUtcTs);
        System.out.println("    CustomEmail = " + customEmail);
        System.out.println("    TypeCode = " + typeCode);
        System.out.println("    Uid = " + uid);
        System.out.println("    UpdatedUtcTs = " + updatedUtcTs);
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
