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
public abstract class MyEmailTemplateBase
    extends MyAbstractDaoDomain<MyEmailTemplate>
    implements KmUidDomainIF
    ,MyBasicTimestampsIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaEmailTemplate Meta = MyMetaEmailTemplate.instance;
    public static final MyEmailTemplateTools Tools = MyEmailTemplateTools.instance;
    public static final MyEmailTemplateValidator Validator = MyEmailTemplateValidator.instance;
    public static final MyEmailTemplateFinder Finder = MyEmailTemplateFinder.instance;

    //##################################################
    //# variables
    //##################################################

    private String bodyHtml;
    private String contextTypeCode;
    private KmTimestamp createdUtcTs;
    private Boolean enabled;
    private String name;
    private String subjectText;
    private String uid;
    private KmTimestamp updatedUtcTs;
    private Integer lockVersion;
    private MyUser createdBy;
    private MyProject project;
    private MyUser updatedBy;
    private List<MyDefaultRecipient> defaultRecipients;

    //##################################################
    //# constructor
    //##################################################

    public MyEmailTemplateBase()
    {
        super();
        setCreatedUtcTs(nowUtc());
        setEnabled(true);
        setUid(newUid());
        setUpdatedUtcTs(nowUtc());
        setLockVersion(0);
        setCreatedBy(MyGlobals.getCurrentUser());
        setUpdatedBy(MyGlobals.getCurrentUser());
        defaultRecipients = new ArrayList<>();
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
    //# field (bodyHtml)
    //##################################################

    public String getBodyHtml()
    {
        return bodyHtml;
    }

    public void setBodyHtml(String e)
    {
        e = Validator.getBodyHtmlValidator().convert(e);
        bodyHtml = e;
    }

    public void clearBodyHtml()
    {
        setBodyHtml(null);
    }

    public boolean hasBodyHtml()
    {
        return Kmu.hasValue(getBodyHtml());
    }

    public boolean hasBodyHtml(String e)
    {
        return Kmu.isEqualIgnoreCase(getBodyHtml(), e);
    }

    public void truncateBodyHtml()
    {
        truncateBodyHtml(false);
    }

    public void truncateBodyHtml(boolean ellipses)
    {
        bodyHtml = Kmu.truncate(bodyHtml, 50000, ellipses);
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

    public MyEmailTemplateContextType getContextType()
    {
        return MyEmailTemplateContextType.findCode(getContextTypeCode());
    }

    public void setContextType(MyEmailTemplateContextType e)
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

    public boolean hasContextType(MyEmailTemplateContextType e)
    {
        return getContextType() == e;
    }

    public void setContextTypeProject()
    {
        setContextType(MyEmailTemplateContextType.Project);
    }

    public boolean isContextTypeProject()
    {
        return hasContextType(MyEmailTemplateContextType.Project);
    }

    public void setContextTypeSite()
    {
        setContextType(MyEmailTemplateContextType.Site);
    }

    public boolean isContextTypeSite()
    {
        return hasContextType(MyEmailTemplateContextType.Site);
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
    //# field (enabled)
    //##################################################

    public Boolean getEnabled()
    {
        return enabled;
    }

    public void setEnabled(Boolean e)
    {
        e = Validator.getEnabledValidator().convert(e);
        enabled = e;
    }

    public void clearEnabled()
    {
        setEnabled(null);
    }

    public boolean hasEnabled()
    {
        return getEnabled() != null;
    }

    public boolean hasEnabled(Boolean e)
    {
        return Kmu.isEqual(getEnabled(), e);
    }

    public boolean isEnabled()
    {
        if ( getEnabled() == null )
            return false;
        return getEnabled();
    }

    public boolean isEnabled(Boolean b)
    {
        return Kmu.isEqual(getEnabled(), b);
    }

    public void toggleEnabled()
    {
        setEnabled(!getEnabled());
    }

    //##################################################
    //# field (enabledStatus)
    //##################################################

    public abstract String getEnabledStatus();

    public boolean hasEnabledStatus()
    {
        return Kmu.hasValue(getEnabledStatus());
    }

    public boolean hasEnabledStatus(String e)
    {
        return Kmu.isEqualIgnoreCase(getEnabledStatus(), e);
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
    //# field (sampleBodyHtml)
    //##################################################

    public abstract String getSampleBodyHtml();

    public boolean hasSampleBodyHtml()
    {
        return Kmu.hasValue(getSampleBodyHtml());
    }

    public boolean hasSampleBodyHtml(String e)
    {
        return Kmu.isEqualIgnoreCase(getSampleBodyHtml(), e);
    }

    //##################################################
    //# field (sampleSubjectText)
    //##################################################

    public abstract String getSampleSubjectText();

    public boolean hasSampleSubjectText()
    {
        return Kmu.hasValue(getSampleSubjectText());
    }

    public boolean hasSampleSubjectText(String e)
    {
        return Kmu.isEqualIgnoreCase(getSampleSubjectText(), e);
    }

    //##################################################
    //# field (subjectText)
    //##################################################

    public String getSubjectText()
    {
        return subjectText;
    }

    public void setSubjectText(String e)
    {
        e = Validator.getSubjectTextValidator().convert(e);
        subjectText = e;
    }

    public void clearSubjectText()
    {
        setSubjectText(null);
    }

    public boolean hasSubjectText()
    {
        return Kmu.hasValue(getSubjectText());
    }

    public boolean hasSubjectText(String e)
    {
        return Kmu.isEqualIgnoreCase(getSubjectText(), e);
    }

    public void truncateSubjectText()
    {
        truncateSubjectText(false);
    }

    public void truncateSubjectText(boolean ellipses)
    {
        subjectText = Kmu.truncate(subjectText, 200, ellipses);
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
    //# DefaultRecipients (collection)
    //##################################################

    public KmCollection<MyDefaultRecipient> getDefaultRecipients()
    {
        return new KmHibernateCollection<>(
            getBaseDefaultRecipients(),
            (MyEmailTemplate)this,
            MyDefaultRecipient.Meta.EmailTemplate);
    }

    public boolean hasDefaultRecipients()
    {
        return !getBaseDefaultRecipients().isEmpty();
    }

    public int getDefaultRecipientCount()
    {
        return getBaseDefaultRecipients().size();
    }

    public List<MyDefaultRecipient> getBaseDefaultRecipients()
    {
        return defaultRecipients;
    }

    public MyDefaultRecipient addDefaultRecipient()
    {
        MyDefaultRecipient e;
        e = new MyDefaultRecipient();
        getDefaultRecipients().add(e);
        return e;
    }

    public void addDefaultRecipient(MyDefaultRecipient e)
    {
        getDefaultRecipients().add(e);
    }

    public boolean removeDefaultRecipient(MyDefaultRecipient e)
    {
        return getDefaultRecipients().remove(e);
    }

    public boolean removeDefaultRecipientUid(String myUid)
    {
        MyDefaultRecipient e = findDefaultRecipientUid(myUid);
        if ( e == null )
            return false;

        return removeDefaultRecipient(e);
    }

    public MyDefaultRecipient findDefaultRecipientUid(String myUid)
    {
        for ( MyDefaultRecipient e : getBaseDefaultRecipients() )
            if ( e.hasUid(myUid) )
                return e;
        return null;
    }

    public void clearDefaultRecipients()
    {
        getDefaultRecipients().clear();
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    protected final MyEmailTemplateValidator getValidator()
    {
        return Validator;
    }

    @Override
    protected final MyEmailTemplate asSubclass()
    {
        return (MyEmailTemplate)this;
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyEmailTemplate getCopy()
    {
        return (MyEmailTemplate)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = newUid();
        project = null;

        List<MyDefaultRecipient> old_defaultRecipients = defaultRecipients;
        defaultRecipients = new ArrayList<>();
        for ( MyDefaultRecipient e : old_defaultRecipients )
            addDefaultRecipient(copy(e));
    }

    /**
     * Get a copy of this model without any associations or collections.
     * The primary key and lock version are not copied.
     * The basic timestamps are reset.
     */
    public final MyEmailTemplate getBasicCopy()
    {
        MyEmailTemplate e;
        e = new MyEmailTemplate();
        applyEditableFieldsTo(e);
        resetBasicTimestamps();
        return e;
    }

    /**
     * Apply the editable fields TO another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsTo(MyEmailTemplate e)
    {
        e.setBodyHtml(getBodyHtml());
        e.setContextTypeCode(getContextTypeCode());
        e.setCreatedUtcTs(getCreatedUtcTs());
        e.setEnabled(getEnabled());
        e.setName(getName());
        e.setSubjectText(getSubjectText());
        e.setUpdatedUtcTs(getUpdatedUtcTs());
    }

    /**
     * Apply the editable fields FROM another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsFrom(MyEmailTemplate e)
    {
        setBodyHtml(e.getBodyHtml());
        setContextTypeCode(e.getContextTypeCode());
        setCreatedUtcTs(e.getCreatedUtcTs());
        setEnabled(e.getEnabled());
        setName(e.getName());
        setSubjectText(e.getSubjectText());
        setUpdatedUtcTs(e.getUpdatedUtcTs());
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyEmailTemplateBase) )
            return false;

        MyEmailTemplateBase e = (MyEmailTemplateBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyEmailTemplate e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyEmailTemplate e)
    {
        if ( !Kmu.isEqual(getAuditLogTitle(), e.getAuditLogTitle()) ) return false;
        if ( !Kmu.isEqual(getBodyHtml(), e.getBodyHtml()) ) return false;
        if ( !Kmu.isEqual(getContextTypeCode(), e.getContextTypeCode()) ) return false;
        if ( !Kmu.isEqual(getCreatedUtcTs(), e.getCreatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getDomainSubtitle(), e.getDomainSubtitle()) ) return false;
        if ( !Kmu.isEqual(getDomainTitle(), e.getDomainTitle()) ) return false;
        if ( !Kmu.isEqual(getEnabled(), e.getEnabled()) ) return false;
        if ( !Kmu.isEqual(getEnabledStatus(), e.getEnabledStatus()) ) return false;
        if ( !Kmu.isEqual(getName(), e.getName()) ) return false;
        if ( !Kmu.isEqual(getSampleBodyHtml(), e.getSampleBodyHtml()) ) return false;
        if ( !Kmu.isEqual(getSampleSubjectText(), e.getSampleSubjectText()) ) return false;
        if ( !Kmu.isEqual(getSubjectText(), e.getSubjectText()) ) return false;
        if ( !Kmu.isEqual(getUpdatedUtcTs(), e.getUpdatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( !Kmu.isEqual(getContextTypeName(), e.getContextTypeName()) ) return false;
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

    public boolean isDifferent(MyEmailTemplate e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyEmailTemplate e)
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
        out.append("MyEmailTemplate");
        out.append("(");
        out.append("Uid=");
        out.append(uid);
        out.append(")");
        return out.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    BodyHtml = " + bodyHtml);
        System.out.println("    ContextTypeCode = " + contextTypeCode);
        System.out.println("    CreatedUtcTs = " + createdUtcTs);
        System.out.println("    Enabled = " + enabled);
        System.out.println("    Name = " + name);
        System.out.println("    SubjectText = " + subjectText);
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
