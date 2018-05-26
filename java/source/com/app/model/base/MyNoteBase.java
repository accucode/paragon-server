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
public abstract class MyNoteBase
    extends MyAbstractDaoDomain<MyNote>
    implements KmUidDomainIF
    ,MyBasicTimestampsIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaNote Meta = MyMetaNote.instance;
    public static final MyNoteTools Tools = MyNoteTools.instance;
    public static final MyNoteValidator Validator = MyNoteValidator.instance;
    public static final MyNoteFinder Finder = MyNoteFinder.instance;

    //##################################################
    //# variables
    //##################################################

    private KmTimestamp createdUtcTs;
    private String message;
    private String ownerTypeCode;
    private String sourceTypeCode;
    private String uid;
    private KmTimestamp updatedUtcTs;
    private Integer lockVersion;
    private MyUser createdBy;
    private MyCustomer customer;
    private MyProject project;
    private MySite site;
    private MyTenant tenant;
    private MyUser updatedBy;

    //##################################################
    //# constructor
    //##################################################

    public MyNoteBase()
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
    //# field (message)
    //##################################################

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String e)
    {
        e = Validator.getMessageValidator().convert(e);
        message = e;
    }

    public void clearMessage()
    {
        setMessage(null);
    }

    public boolean hasMessage()
    {
        return Kmu.hasValue(getMessage());
    }

    public boolean hasMessage(String e)
    {
        return Kmu.isEqualIgnoreCase(getMessage(), e);
    }

    public void truncateMessage()
    {
        truncateMessage(false);
    }

    public void truncateMessage(boolean ellipses)
    {
        message = Kmu.truncate(message, 1000, ellipses);
    }

    //##################################################
    //# field (ownerTitle)
    //##################################################

    public abstract String getOwnerTitle();

    public boolean hasOwnerTitle()
    {
        return Kmu.hasValue(getOwnerTitle());
    }

    public boolean hasOwnerTitle(String e)
    {
        return Kmu.isEqualIgnoreCase(getOwnerTitle(), e);
    }

    //##################################################
    //# field (ownerTypeCode)
    //##################################################

    public String getOwnerTypeCode()
    {
        return ownerTypeCode;
    }

    public void setOwnerTypeCode(String e)
    {
        e = Validator.getOwnerTypeCodeValidator().convert(e);
        ownerTypeCode = e;
    }

    public void clearOwnerTypeCode()
    {
        setOwnerTypeCode(null);
    }

    public boolean hasOwnerTypeCode()
    {
        return Kmu.hasValue(getOwnerTypeCode());
    }

    public boolean hasOwnerTypeCode(String e)
    {
        return Kmu.isEqualIgnoreCase(getOwnerTypeCode(), e);
    }

    public void truncateOwnerTypeCode()
    {
        truncateOwnerTypeCode(false);
    }

    public void truncateOwnerTypeCode(boolean ellipses)
    {
        ownerTypeCode = Kmu.truncate(ownerTypeCode, 30, ellipses);
    }

    public MyNoteOwnerType getOwnerType()
    {
        return MyNoteOwnerType.findCode(getOwnerTypeCode());
    }

    public void setOwnerType(MyNoteOwnerType e)
    {
        if ( e == null )
            setOwnerTypeCode(null);
        else
            setOwnerTypeCode(e.getCode());
    }

    public boolean hasOwnerType()
    {
        return getOwnerType() != null;
    }

    public boolean hasOwnerType(MyNoteOwnerType e)
    {
        return getOwnerType() == e;
    }

    public void setOwnerTypeProject()
    {
        setOwnerType(MyNoteOwnerType.Project);
    }

    public boolean isOwnerTypeProject()
    {
        return hasOwnerType(MyNoteOwnerType.Project);
    }

    public void setOwnerTypeCustomer()
    {
        setOwnerType(MyNoteOwnerType.Customer);
    }

    public boolean isOwnerTypeCustomer()
    {
        return hasOwnerType(MyNoteOwnerType.Customer);
    }

    public void setOwnerTypeSite()
    {
        setOwnerType(MyNoteOwnerType.Site);
    }

    public boolean isOwnerTypeSite()
    {
        return hasOwnerType(MyNoteOwnerType.Site);
    }

    //##################################################
    //# field (sourceTypeCode)
    //##################################################

    public String getSourceTypeCode()
    {
        return sourceTypeCode;
    }

    public void setSourceTypeCode(String e)
    {
        e = Validator.getSourceTypeCodeValidator().convert(e);
        sourceTypeCode = e;
    }

    public void clearSourceTypeCode()
    {
        setSourceTypeCode(null);
    }

    public boolean hasSourceTypeCode()
    {
        return Kmu.hasValue(getSourceTypeCode());
    }

    public boolean hasSourceTypeCode(String e)
    {
        return Kmu.isEqualIgnoreCase(getSourceTypeCode(), e);
    }

    public void truncateSourceTypeCode()
    {
        truncateSourceTypeCode(false);
    }

    public void truncateSourceTypeCode(boolean ellipses)
    {
        sourceTypeCode = Kmu.truncate(sourceTypeCode, 30, ellipses);
    }

    public MyNoteSourceType getSourceType()
    {
        return MyNoteSourceType.findCode(getSourceTypeCode());
    }

    public void setSourceType(MyNoteSourceType e)
    {
        if ( e == null )
            setSourceTypeCode(null);
        else
            setSourceTypeCode(e.getCode());
    }

    public boolean hasSourceType()
    {
        return getSourceType() != null;
    }

    public boolean hasSourceType(MyNoteSourceType e)
    {
        return getSourceType() == e;
    }

    public void setSourceTypeUser()
    {
        setSourceType(MyNoteSourceType.User);
    }

    public boolean isSourceTypeUser()
    {
        return hasSourceType(MyNoteSourceType.User);
    }

    public void setSourceTypeSystem()
    {
        setSourceType(MyNoteSourceType.System);
    }

    public boolean isSourceTypeSystem()
    {
        return hasSourceType(MyNoteSourceType.System);
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
    //# field (ownerTypeName)
    //##################################################

    public final String getOwnerTypeName()
    {
        return KmEnumIF.getLabelFor(getOwnerType());
    }

    public boolean hasOwnerTypeName()
    {
        return Kmu.hasValue(getOwnerTypeName());
    }

    public boolean hasOwnerTypeName(String e)
    {
        return Kmu.isEqualIgnoreCase(getOwnerTypeName(), e);
    }

    //##################################################
    //# field (sourceTypeName)
    //##################################################

    public final String getSourceTypeName()
    {
        return KmEnumIF.getLabelFor(getSourceType());
    }

    public boolean hasSourceTypeName()
    {
        return Kmu.hasValue(getSourceTypeName());
    }

    public boolean hasSourceTypeName(String e)
    {
        return Kmu.isEqualIgnoreCase(getSourceTypeName(), e);
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
    //# customer
    //##################################################

    public MyCustomer getCustomer()
    {
        return customer;
    }

    public void setCustomer(MyCustomer e)
    {
        customer = e;
    }

    public void _setCustomer(MyCustomer e)
    {
        customer = e;
    }

    public void clearCustomer()
    {
        setCustomer(null);
    }

    public boolean hasCustomer()
    {
        return getCustomer() != null;
    }

    public boolean hasCustomer(MyCustomer e)
    {
        return Kmu.isEqual(getCustomer(), e);
    }

    //##################################################
    //# project
    //##################################################

    public MyProject getProject()
    {
        return project;
    }

    public void setProject(MyProject e)
    {
        project = e;
    }

    public void _setProject(MyProject e)
    {
        project = e;
    }

    public void clearProject()
    {
        setProject(null);
    }

    public boolean hasProject()
    {
        return getProject() != null;
    }

    public boolean hasProject(MyProject e)
    {
        return Kmu.isEqual(getProject(), e);
    }

    //##################################################
    //# site
    //##################################################

    public MySite getSite()
    {
        return site;
    }

    public void setSite(MySite e)
    {
        site = e;
    }

    public void _setSite(MySite e)
    {
        site = e;
    }

    public void clearSite()
    {
        setSite(null);
    }

    public boolean hasSite()
    {
        return getSite() != null;
    }

    public boolean hasSite(MySite e)
    {
        return Kmu.isEqual(getSite(), e);
    }

    //##################################################
    //# tenant
    //##################################################

    public MyTenant getTenant()
    {
        return tenant;
    }

    public void setTenant(MyTenant e)
    {
        tenant = e;
    }

    public void _setTenant(MyTenant e)
    {
        tenant = e;
    }

    public void clearTenant()
    {
        setTenant(null);
    }

    public boolean hasTenant()
    {
        return getTenant() != null;
    }

    public boolean hasTenant(MyTenant e)
    {
        return Kmu.isEqual(getTenant(), e);
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
    protected final MyNoteValidator getValidator()
    {
        return Validator;
    }

    @Override
    protected final MyNote asSubclass()
    {
        return (MyNote)this;
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyNote getCopy()
    {
        return (MyNote)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = newUid();
    }

    /**
     * Get a copy of this model without any associations or collections.
     * The primary key and lock version are not copied.
     * The basic timestamps are reset.
     */
    public final MyNote getBasicCopy()
    {
        MyNote e;
        e = new MyNote();
        applyEditableFieldsTo(e);
        resetBasicTimestamps();
        return e;
    }

    /**
     * Apply the editable fields TO another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsTo(MyNote e)
    {
        e.setCreatedUtcTs(getCreatedUtcTs());
        e.setMessage(getMessage());
        e.setOwnerTypeCode(getOwnerTypeCode());
        e.setSourceTypeCode(getSourceTypeCode());
        e.setUpdatedUtcTs(getUpdatedUtcTs());
    }

    /**
     * Apply the editable fields FROM another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsFrom(MyNote e)
    {
        setCreatedUtcTs(e.getCreatedUtcTs());
        setMessage(e.getMessage());
        setOwnerTypeCode(e.getOwnerTypeCode());
        setSourceTypeCode(e.getSourceTypeCode());
        setUpdatedUtcTs(e.getUpdatedUtcTs());
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyNoteBase) )
            return false;

        MyNoteBase e = (MyNoteBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyNote e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyNote e)
    {
        if ( !Kmu.isEqual(getAuditLogTitle(), e.getAuditLogTitle()) ) return false;
        if ( !Kmu.isEqual(getCreatedUtcTs(), e.getCreatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getDomainSubtitle(), e.getDomainSubtitle()) ) return false;
        if ( !Kmu.isEqual(getDomainTitle(), e.getDomainTitle()) ) return false;
        if ( !Kmu.isEqual(getMessage(), e.getMessage()) ) return false;
        if ( !Kmu.isEqual(getOwnerTitle(), e.getOwnerTitle()) ) return false;
        if ( !Kmu.isEqual(getOwnerTypeCode(), e.getOwnerTypeCode()) ) return false;
        if ( !Kmu.isEqual(getSourceTypeCode(), e.getSourceTypeCode()) ) return false;
        if ( !Kmu.isEqual(getUpdatedUtcTs(), e.getUpdatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( !Kmu.isEqual(getOwnerTypeName(), e.getOwnerTypeName()) ) return false;
        if ( !Kmu.isEqual(getSourceTypeName(), e.getSourceTypeName()) ) return false;
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

    public boolean isDifferent(MyNote e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyNote e)
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
        out.append("MyNote");
        out.append("(");
        out.append("Uid=");
        out.append(uid);
        out.append(")");
        return out.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    CreatedUtcTs = " + createdUtcTs);
        System.out.println("    Message = " + message);
        System.out.println("    OwnerTypeCode = " + ownerTypeCode);
        System.out.println("    SourceTypeCode = " + sourceTypeCode);
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
