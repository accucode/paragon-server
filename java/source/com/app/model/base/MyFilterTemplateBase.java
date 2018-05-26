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
public abstract class MyFilterTemplateBase
    extends MyAbstractDaoDomain<MyFilterTemplate>
    implements KmUidDomainIF
    ,MyBasicTimestampsIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaFilterTemplate Meta = MyMetaFilterTemplate.instance;
    public static final MyFilterTemplateTools Tools = MyFilterTemplateTools.instance;
    public static final MyFilterTemplateValidator Validator = MyFilterTemplateValidator.instance;
    public static final MyFilterTemplateFinder Finder = MyFilterTemplateFinder.instance;

    //##################################################
    //# variables
    //##################################################

    private String contextTypeCode;
    private KmTimestamp createdUtcTs;
    private Boolean deleted;
    private Boolean modified;
    private String name;
    private Boolean preferred;
    private String typeCode;
    private String uid;
    private KmTimestamp updatedUtcTs;
    private Integer lockVersion;
    private MyUser createdBy;
    private MyProject project;
    private MyUser updatedBy;
    private List<MyFilterTemplateItem> items;

    //##################################################
    //# constructor
    //##################################################

    public MyFilterTemplateBase()
    {
        super();
        setCreatedUtcTs(nowUtc());
        setDeleted(false);
        setPreferred(false);
        setUid(newUid());
        setUpdatedUtcTs(nowUtc());
        setLockVersion(0);
        setCreatedBy(MyGlobals.getCurrentUser());
        setUpdatedBy(MyGlobals.getCurrentUser());
        items = new ArrayList<>();
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
    //# field (contextTypeCode)
    //##################################################

    public String getContextTypeCode()
    {
        return contextTypeCode;
    }

    public void setContextTypeCode(String e)
    {
        e = Validator.getContextTypeCodeValidator().convert(e);
        contextTypeCode = e;
    }

    public void clearContextTypeCode()
    {
        setContextTypeCode(null);
    }

    public boolean hasContextTypeCode()
    {
        return Kmu.hasValue(getContextTypeCode());
    }

    public boolean hasContextTypeCode(String e)
    {
        return Kmu.isEqualIgnoreCase(getContextTypeCode(), e);
    }

    public void truncateContextTypeCode()
    {
        truncateContextTypeCode(false);
    }

    public void truncateContextTypeCode(boolean ellipses)
    {
        contextTypeCode = Kmu.truncate(contextTypeCode, 30, ellipses);
    }

    public MyFilterTemplateContextType getContextType()
    {
        return MyFilterTemplateContextType.findCode(getContextTypeCode());
    }

    public void setContextType(MyFilterTemplateContextType e)
    {
        if ( e == null )
            setContextTypeCode(null);
        else
            setContextTypeCode(e.getCode());
    }

    public boolean hasContextType()
    {
        return getContextType() != null;
    }

    public boolean hasContextType(MyFilterTemplateContextType e)
    {
        return getContextType() == e;
    }

    public void setContextTypeSite()
    {
        setContextType(MyFilterTemplateContextType.Site);
    }

    public boolean isContextTypeSite()
    {
        return hasContextType(MyFilterTemplateContextType.Site);
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
    //# field (deleted)
    //##################################################

    public Boolean getDeleted()
    {
        return deleted;
    }

    public void setDeleted(Boolean e)
    {
        e = Validator.getDeletedValidator().convert(e);
        deleted = e;
    }

    public void clearDeleted()
    {
        setDeleted(null);
    }

    public boolean hasDeleted()
    {
        return getDeleted() != null;
    }

    public boolean hasDeleted(Boolean e)
    {
        return Kmu.isEqual(getDeleted(), e);
    }

    public boolean isDeleted()
    {
        if ( getDeleted() == null )
            return false;
        return getDeleted();
    }

    public boolean isDeleted(Boolean b)
    {
        return Kmu.isEqual(getDeleted(), b);
    }

    public void toggleDeleted()
    {
        setDeleted(!getDeleted());
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
    //# field (modified)
    //##################################################

    public Boolean getModified()
    {
        return modified;
    }

    public void setModified(Boolean e)
    {
        e = Validator.getModifiedValidator().convert(e);
        modified = e;
    }

    public void clearModified()
    {
        setModified(null);
    }

    public boolean hasModified()
    {
        return getModified() != null;
    }

    public boolean hasModified(Boolean e)
    {
        return Kmu.isEqual(getModified(), e);
    }

    public boolean isModified()
    {
        if ( getModified() == null )
            return false;
        return getModified();
    }

    public boolean isModified(Boolean b)
    {
        return Kmu.isEqual(getModified(), b);
    }

    public void toggleModified()
    {
        setModified(!getModified());
    }

    //##################################################
    //# field (name)
    //##################################################

    public String getName()
    {
        return name;
    }

    public void setName(String e)
    {
        e = Validator.getNameValidator().convert(e);
        name = e;
    }

    public void clearName()
    {
        setName(null);
    }

    public boolean hasName()
    {
        return Kmu.hasValue(getName());
    }

    public boolean hasName(String e)
    {
        return Kmu.isEqualIgnoreCase(getName(), e);
    }

    public void truncateName()
    {
        truncateName(false);
    }

    public void truncateName(boolean ellipses)
    {
        name = Kmu.truncate(name, 50, ellipses);
    }

    //##################################################
    //# field (preferred)
    //##################################################

    public Boolean getPreferred()
    {
        return preferred;
    }

    public void setPreferred(Boolean e)
    {
        e = Validator.getPreferredValidator().convert(e);
        preferred = e;
    }

    public void clearPreferred()
    {
        setPreferred(null);
    }

    public boolean hasPreferred()
    {
        return getPreferred() != null;
    }

    public boolean hasPreferred(Boolean e)
    {
        return Kmu.isEqual(getPreferred(), e);
    }

    public boolean isPreferred()
    {
        if ( getPreferred() == null )
            return false;
        return getPreferred();
    }

    public boolean isPreferred(Boolean b)
    {
        return Kmu.isEqual(getPreferred(), b);
    }

    public void togglePreferred()
    {
        setPreferred(!getPreferred());
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

    public MyFilterTemplateType getType()
    {
        return MyFilterTemplateType.findCode(getTypeCode());
    }

    public void setType(MyFilterTemplateType e)
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

    public boolean hasType(MyFilterTemplateType e)
    {
        return getType() == e;
    }

    public void setTypePredefined()
    {
        setType(MyFilterTemplateType.Predefined);
    }

    public boolean isTypePredefined()
    {
        return hasType(MyFilterTemplateType.Predefined);
    }

    public void setTypeShared()
    {
        setType(MyFilterTemplateType.Shared);
    }

    public boolean isTypeShared()
    {
        return hasType(MyFilterTemplateType.Shared);
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
    //# field (contextTypeName)
    //##################################################

    public final String getContextTypeName()
    {
        return KmEnumIF.getLabelFor(getContextType());
    }

    public boolean hasContextTypeName()
    {
        return Kmu.hasValue(getContextTypeName());
    }

    public boolean hasContextTypeName(String e)
    {
        return Kmu.isEqualIgnoreCase(getContextTypeName(), e);
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

    public String getProjectName()
    {
        if ( hasProject() )
            return getProject().getName();
        return null;
    }

    public void setProjectName(String e)
    {
        getProject().setName(e);
    }

    public boolean hasProjectName()
    {
        return hasProject() && getProject().hasName();
    }

    public boolean hasProjectName(String e)
    {
        return hasProject() && getProject().hasName(e);
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
    //# Items (collection)
    //##################################################

    public KmCollection<MyFilterTemplateItem> getItems()
    {
        return new KmHibernateCollection<>(
            getBaseItems(),
            (MyFilterTemplate)this,
            MyFilterTemplateItem.Meta.Template);
    }

    public boolean hasItems()
    {
        return !getBaseItems().isEmpty();
    }

    public int getItemCount()
    {
        return getBaseItems().size();
    }

    public List<MyFilterTemplateItem> getBaseItems()
    {
        return items;
    }

    public MyFilterTemplateItem addItem()
    {
        MyFilterTemplateItem e;
        e = new MyFilterTemplateItem();
        getItems().add(e);
        return e;
    }

    public void addItem(MyFilterTemplateItem e)
    {
        getItems().add(e);
    }

    public boolean removeItem(MyFilterTemplateItem e)
    {
        return getItems().remove(e);
    }

    public boolean removeItemUid(String myUid)
    {
        MyFilterTemplateItem e = findItemUid(myUid);
        if ( e == null )
            return false;

        return removeItem(e);
    }

    public MyFilterTemplateItem findItemUid(String myUid)
    {
        for ( MyFilterTemplateItem e : getBaseItems() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearItems()
    {
        getItems().clear();
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    protected final MyFilterTemplateValidator getValidator()
    {
        return Validator;
    }

    @Override
    protected final MyFilterTemplate asSubclass()
    {
        return (MyFilterTemplate)this;
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyFilterTemplate getCopy()
    {
        return (MyFilterTemplate)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = newUid();

        List<MyFilterTemplateItem> old_items = items;
        items = new ArrayList<>();
        for ( MyFilterTemplateItem e : old_items )
            addItem(copy(e));
    }

    /**
     * Get a copy of this model without any associations or collections.
     * The primary key and lock version are not copied.
     * The basic timestamps are reset.
     */
    public final MyFilterTemplate getBasicCopy()
    {
        MyFilterTemplate e;
        e = new MyFilterTemplate();
        applyEditableFieldsTo(e);
        resetBasicTimestamps();
        return e;
    }

    /**
     * Apply the editable fields TO another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsTo(MyFilterTemplate e)
    {
        e.setContextTypeCode(getContextTypeCode());
        e.setCreatedUtcTs(getCreatedUtcTs());
        e.setDeleted(getDeleted());
        e.setModified(getModified());
        e.setName(getName());
        e.setPreferred(getPreferred());
        e.setTypeCode(getTypeCode());
        e.setUpdatedUtcTs(getUpdatedUtcTs());
    }

    /**
     * Apply the editable fields FROM another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsFrom(MyFilterTemplate e)
    {
        setContextTypeCode(e.getContextTypeCode());
        setCreatedUtcTs(e.getCreatedUtcTs());
        setDeleted(e.getDeleted());
        setModified(e.getModified());
        setName(e.getName());
        setPreferred(e.getPreferred());
        setTypeCode(e.getTypeCode());
        setUpdatedUtcTs(e.getUpdatedUtcTs());
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyFilterTemplateBase) )
            return false;

        MyFilterTemplateBase e = (MyFilterTemplateBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyFilterTemplate e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyFilterTemplate e)
    {
        if ( !Kmu.isEqual(getAuditLogTitle(), e.getAuditLogTitle()) ) return false;
        if ( !Kmu.isEqual(getContextTypeCode(), e.getContextTypeCode()) ) return false;
        if ( !Kmu.isEqual(getCreatedUtcTs(), e.getCreatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getDeleted(), e.getDeleted()) ) return false;
        if ( !Kmu.isEqual(getDomainSubtitle(), e.getDomainSubtitle()) ) return false;
        if ( !Kmu.isEqual(getDomainTitle(), e.getDomainTitle()) ) return false;
        if ( !Kmu.isEqual(getModified(), e.getModified()) ) return false;
        if ( !Kmu.isEqual(getName(), e.getName()) ) return false;
        if ( !Kmu.isEqual(getPreferred(), e.getPreferred()) ) return false;
        if ( !Kmu.isEqual(getTypeCode(), e.getTypeCode()) ) return false;
        if ( !Kmu.isEqual(getUpdatedUtcTs(), e.getUpdatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( !Kmu.isEqual(getContextTypeName(), e.getContextTypeName()) ) return false;
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

    public boolean isDifferent(MyFilterTemplate e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyFilterTemplate e)
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
        out.append("MyFilterTemplate");
        out.append("(");
        out.append("Uid=");
        out.append(uid);
        out.append(")");
        return out.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    ContextTypeCode = " + contextTypeCode);
        System.out.println("    CreatedUtcTs = " + createdUtcTs);
        System.out.println("    Deleted = " + deleted);
        System.out.println("    Modified = " + modified);
        System.out.println("    Name = " + name);
        System.out.println("    Preferred = " + preferred);
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
