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
public abstract class MyFeedbackBase
    extends MyAbstractDaoDomain<MyFeedback>
    implements KmUidDomainIF
    ,MyBasicTimestampsIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaFeedback Meta = MyMetaFeedback.instance;
    public static final MyFeedbackTools Tools = MyFeedbackTools.instance;
    public static final MyFeedbackValidator Validator = MyFeedbackValidator.instance;
    public static final MyFeedbackFinder Finder = MyFeedbackFinder.instance;

    //##################################################
    //# variables
    //##################################################

    private KmDate closedDate;
    private KmTimestamp createdUtcTs;
    private String description;
    private String notes;
    private Boolean open;
    private String pageKey;
    private String queryString;
    private String requestUrl;
    private String statusCode;
    private String typeCode;
    private String uid;
    private KmTimestamp updatedUtcTs;
    private String windowLocation;
    private MyUser closedBy;
    private MyUser createdBy;
    private MyProject project;
    private MyTenant tenant;
    private MyUser updatedBy;

    //##################################################
    //# constructor
    //##################################################

    public MyFeedbackBase()
    {
        super();
        setCreatedUtcTs(nowUtc());
        setOpen(true);
        setStatusCode(MyFeedbackStatus.Pending.getCode());
        setUid(newUid());
        setUpdatedUtcTs(nowUtc());
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
    //# field (closedDate)
    //##################################################

    public KmDate getClosedDate()
    {
        return closedDate;
    }

    public void setClosedDate(KmDate e)
    {
        e = Validator.getClosedDateValidator().convert(e);
        closedDate = e;
    }

    public void clearClosedDate()
    {
        setClosedDate(null);
    }

    public boolean hasClosedDate()
    {
        return getClosedDate() != null;
    }

    public boolean hasClosedDate(KmDate e)
    {
        return Kmu.isEqual(getClosedDate(), e);
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
    //# field (description)
    //##################################################

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String e)
    {
        e = Validator.getDescriptionValidator().convert(e);
        description = e;
    }

    public void clearDescription()
    {
        setDescription(null);
    }

    public boolean hasDescription()
    {
        return Kmu.hasValue(getDescription());
    }

    public boolean hasDescription(String e)
    {
        return Kmu.isEqualIgnoreCase(getDescription(), e);
    }

    public void truncateDescription()
    {
        truncateDescription(false);
    }

    public void truncateDescription(boolean ellipses)
    {
        description = Kmu.truncate(description, 1000, ellipses);
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
    //# field (notes)
    //##################################################

    public String getNotes()
    {
        return notes;
    }

    public void setNotes(String e)
    {
        e = Validator.getNotesValidator().convert(e);
        notes = e;
    }

    public void clearNotes()
    {
        setNotes(null);
    }

    public boolean hasNotes()
    {
        return Kmu.hasValue(getNotes());
    }

    public boolean hasNotes(String e)
    {
        return Kmu.isEqualIgnoreCase(getNotes(), e);
    }

    public void truncateNotes()
    {
        truncateNotes(false);
    }

    public void truncateNotes(boolean ellipses)
    {
        notes = Kmu.truncate(notes, 1000, ellipses);
    }

    //##################################################
    //# field (open)
    //##################################################

    public Boolean getOpen()
    {
        return open;
    }

    public void setOpen(Boolean e)
    {
        e = Validator.getOpenValidator().convert(e);
        open = e;
    }

    public void clearOpen()
    {
        setOpen(null);
    }

    public boolean hasOpen()
    {
        return getOpen() != null;
    }

    public boolean hasOpen(Boolean e)
    {
        return Kmu.isEqual(getOpen(), e);
    }

    public boolean isOpen()
    {
        if ( getOpen() == null )
            return false;
        return getOpen();
    }

    public boolean isOpen(Boolean b)
    {
        return Kmu.isEqual(getOpen(), b);
    }

    public void toggleOpen()
    {
        setOpen(!getOpen());
    }

    //##################################################
    //# field (openDays)
    //##################################################

    public abstract String getOpenDays();

    public boolean hasOpenDays()
    {
        return Kmu.hasValue(getOpenDays());
    }

    public boolean hasOpenDays(String e)
    {
        return Kmu.isEqualIgnoreCase(getOpenDays(), e);
    }

    //##################################################
    //# field (pageKey)
    //##################################################

    public String getPageKey()
    {
        return pageKey;
    }

    public void setPageKey(String e)
    {
        e = Validator.getPageKeyValidator().convert(e);
        pageKey = e;
    }

    public void clearPageKey()
    {
        setPageKey(null);
    }

    public boolean hasPageKey()
    {
        return Kmu.hasValue(getPageKey());
    }

    public boolean hasPageKey(String e)
    {
        return Kmu.isEqualIgnoreCase(getPageKey(), e);
    }

    public void truncatePageKey()
    {
        truncatePageKey(false);
    }

    public void truncatePageKey(boolean ellipses)
    {
        pageKey = Kmu.truncate(pageKey, 50, ellipses);
    }

    //##################################################
    //# field (pageName)
    //##################################################

    public abstract String getPageName();

    public boolean hasPageName()
    {
        return Kmu.hasValue(getPageName());
    }

    public boolean hasPageName(String e)
    {
        return Kmu.isEqualIgnoreCase(getPageName(), e);
    }

    //##################################################
    //# field (queryString)
    //##################################################

    public String getQueryString()
    {
        return queryString;
    }

    public void setQueryString(String e)
    {
        e = Validator.getQueryStringValidator().convert(e);
        queryString = e;
    }

    public void clearQueryString()
    {
        setQueryString(null);
    }

    public boolean hasQueryString()
    {
        return Kmu.hasValue(getQueryString());
    }

    public boolean hasQueryString(String e)
    {
        return Kmu.isEqualIgnoreCase(getQueryString(), e);
    }

    public void truncateQueryString()
    {
        truncateQueryString(false);
    }

    public void truncateQueryString(boolean ellipses)
    {
        queryString = Kmu.truncate(queryString, 1000, ellipses);
    }

    //##################################################
    //# field (requestUrl)
    //##################################################

    public String getRequestUrl()
    {
        return requestUrl;
    }

    public void setRequestUrl(String e)
    {
        e = Validator.getRequestUrlValidator().convert(e);
        requestUrl = e;
    }

    public void clearRequestUrl()
    {
        setRequestUrl(null);
    }

    public boolean hasRequestUrl()
    {
        return Kmu.hasValue(getRequestUrl());
    }

    public boolean hasRequestUrl(String e)
    {
        return Kmu.isEqualIgnoreCase(getRequestUrl(), e);
    }

    public void truncateRequestUrl()
    {
        truncateRequestUrl(false);
    }

    public void truncateRequestUrl(boolean ellipses)
    {
        requestUrl = Kmu.truncate(requestUrl, 1000, ellipses);
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
        e = Validator.getStatusCodeValidator().convert(e);
        String oldValue = statusCode;
        statusCode = e;
        if ( Kmu.isNotEqual(e, oldValue) )
        {
            updateOpen();
        }
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

    public MyFeedbackStatus getStatus()
    {
        return MyFeedbackStatus.findCode(getStatusCode());
    }

    public void setStatus(MyFeedbackStatus e)
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

    public boolean hasStatus(MyFeedbackStatus e)
    {
        return getStatus() == e;
    }

    public void setStatusPending()
    {
        setStatus(MyFeedbackStatus.Pending);
    }

    public boolean isStatusPending()
    {
        return hasStatus(MyFeedbackStatus.Pending);
    }

    public void setStatusResolved()
    {
        setStatus(MyFeedbackStatus.Resolved);
    }

    public boolean isStatusResolved()
    {
        return hasStatus(MyFeedbackStatus.Resolved);
    }

    public void setStatusDropped()
    {
        setStatus(MyFeedbackStatus.Dropped);
    }

    public boolean isStatusDropped()
    {
        return hasStatus(MyFeedbackStatus.Dropped);
    }

    //##################################################
    //# field (truncatedDescription)
    //##################################################

    public abstract String getTruncatedDescription();

    public boolean hasTruncatedDescription()
    {
        return Kmu.hasValue(getTruncatedDescription());
    }

    public boolean hasTruncatedDescription(String e)
    {
        return Kmu.isEqualIgnoreCase(getTruncatedDescription(), e);
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

    public MyFeedbackType getType()
    {
        return MyFeedbackType.findCode(getTypeCode());
    }

    public void setType(MyFeedbackType e)
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

    public boolean hasType(MyFeedbackType e)
    {
        return getType() == e;
    }

    public void setTypeBug()
    {
        setType(MyFeedbackType.Bug);
    }

    public boolean isTypeBug()
    {
        return hasType(MyFeedbackType.Bug);
    }

    public void setTypeCosmetic()
    {
        setType(MyFeedbackType.Cosmetic);
    }

    public boolean isTypeCosmetic()
    {
        return hasType(MyFeedbackType.Cosmetic);
    }

    public void setTypeEnhancement()
    {
        setType(MyFeedbackType.Enhancement);
    }

    public boolean isTypeEnhancement()
    {
        return hasType(MyFeedbackType.Enhancement);
    }

    public void setTypeDuplicate()
    {
        setType(MyFeedbackType.Duplicate);
    }

    public boolean isTypeDuplicate()
    {
        return hasType(MyFeedbackType.Duplicate);
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
    //# field (windowLocation)
    //##################################################

    public String getWindowLocation()
    {
        return windowLocation;
    }

    public void setWindowLocation(String e)
    {
        e = Validator.getWindowLocationValidator().convert(e);
        windowLocation = e;
    }

    public void clearWindowLocation()
    {
        setWindowLocation(null);
    }

    public boolean hasWindowLocation()
    {
        return Kmu.hasValue(getWindowLocation());
    }

    public boolean hasWindowLocation(String e)
    {
        return Kmu.isEqualIgnoreCase(getWindowLocation(), e);
    }

    public void truncateWindowLocation()
    {
        truncateWindowLocation(false);
    }

    public void truncateWindowLocation(boolean ellipses)
    {
        windowLocation = Kmu.truncate(windowLocation, 1000, ellipses);
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
    //# closedBy
    //##################################################

    public MyUser getClosedBy()
    {
        return closedBy;
    }

    public void setClosedBy(MyUser e)
    {
        closedBy = e;
    }

    public void _setClosedBy(MyUser e)
    {
        closedBy = e;
    }

    public void clearClosedBy()
    {
        setClosedBy(null);
    }

    public boolean hasClosedBy()
    {
        return getClosedBy() != null;
    }

    public boolean hasClosedBy(MyUser e)
    {
        return Kmu.isEqual(getClosedBy(), e);
    }

    public String getClosedByFullName()
    {
        if ( hasClosedBy() )
            return getClosedBy().getFullName();
        return null;
    }

    public void setClosedByFullName(String e)
    {
        getClosedBy().setFullName(e);
    }

    public boolean hasClosedByFullName()
    {
        return hasClosedBy() && getClosedBy().hasFullName();
    }

    public boolean hasClosedByFullName(String e)
    {
        return hasClosedBy() && getClosedBy().hasFullName(e);
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

    public String getTenantName()
    {
        if ( hasTenant() )
            return getTenant().getName();
        return null;
    }

    public void setTenantName(String e)
    {
        getTenant().setName(e);
    }

    public boolean hasTenantName()
    {
        return hasTenant() && getTenant().hasName();
    }

    public boolean hasTenantName(String e)
    {
        return hasTenant() && getTenant().hasName(e);
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
    //# on change
    //##################################################

    protected abstract void updateOpen();

    //##################################################
    //# validate
    //##################################################

    @Override
    protected final MyFeedbackValidator getValidator()
    {
        return Validator;
    }

    @Override
    protected final MyFeedback asSubclass()
    {
        return (MyFeedback)this;
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyFeedback getCopy()
    {
        return (MyFeedback)super.getCopy();
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
    public final MyFeedback getBasicCopy()
    {
        MyFeedback e;
        e = new MyFeedback();
        applyEditableFieldsTo(e);
        resetBasicTimestamps();
        return e;
    }

    /**
     * Apply the editable fields TO another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsTo(MyFeedback e)
    {
        e.setClosedDate(getClosedDate());
        e.setCreatedUtcTs(getCreatedUtcTs());
        e.setDescription(getDescription());
        e.setNotes(getNotes());
        e.setOpen(getOpen());
        e.setPageKey(getPageKey());
        e.setQueryString(getQueryString());
        e.setRequestUrl(getRequestUrl());
        e.setStatusCode(getStatusCode());
        e.setTypeCode(getTypeCode());
        e.setUpdatedUtcTs(getUpdatedUtcTs());
        e.setWindowLocation(getWindowLocation());
    }

    /**
     * Apply the editable fields FROM another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsFrom(MyFeedback e)
    {
        setClosedDate(e.getClosedDate());
        setCreatedUtcTs(e.getCreatedUtcTs());
        setDescription(e.getDescription());
        setNotes(e.getNotes());
        setOpen(e.getOpen());
        setPageKey(e.getPageKey());
        setQueryString(e.getQueryString());
        setRequestUrl(e.getRequestUrl());
        setStatusCode(e.getStatusCode());
        setTypeCode(e.getTypeCode());
        setUpdatedUtcTs(e.getUpdatedUtcTs());
        setWindowLocation(e.getWindowLocation());
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyFeedbackBase) )
            return false;

        MyFeedbackBase e = (MyFeedbackBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyFeedback e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyFeedback e)
    {
        if ( !Kmu.isEqual(getAuditLogTitle(), e.getAuditLogTitle()) ) return false;
        if ( !Kmu.isEqual(getClosedDate(), e.getClosedDate()) ) return false;
        if ( !Kmu.isEqual(getCreatedUtcTs(), e.getCreatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getDescription(), e.getDescription()) ) return false;
        if ( !Kmu.isEqual(getDomainSubtitle(), e.getDomainSubtitle()) ) return false;
        if ( !Kmu.isEqual(getDomainTitle(), e.getDomainTitle()) ) return false;
        if ( !Kmu.isEqual(getNotes(), e.getNotes()) ) return false;
        if ( !Kmu.isEqual(getOpen(), e.getOpen()) ) return false;
        if ( !Kmu.isEqual(getOpenDays(), e.getOpenDays()) ) return false;
        if ( !Kmu.isEqual(getPageKey(), e.getPageKey()) ) return false;
        if ( !Kmu.isEqual(getPageName(), e.getPageName()) ) return false;
        if ( !Kmu.isEqual(getQueryString(), e.getQueryString()) ) return false;
        if ( !Kmu.isEqual(getRequestUrl(), e.getRequestUrl()) ) return false;
        if ( !Kmu.isEqual(getStatusCode(), e.getStatusCode()) ) return false;
        if ( !Kmu.isEqual(getTruncatedDescription(), e.getTruncatedDescription()) ) return false;
        if ( !Kmu.isEqual(getTypeCode(), e.getTypeCode()) ) return false;
        if ( !Kmu.isEqual(getUpdatedUtcTs(), e.getUpdatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getWindowLocation(), e.getWindowLocation()) ) return false;
        if ( !Kmu.isEqual(getStatusName(), e.getStatusName()) ) return false;
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

    public boolean isDifferent(MyFeedback e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyFeedback e)
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
        out.append("MyFeedback");
        out.append("(");
        out.append("Uid=");
        out.append(uid);
        out.append(")");
        return out.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    ClosedDate = " + closedDate);
        System.out.println("    CreatedUtcTs = " + createdUtcTs);
        System.out.println("    Description = " + description);
        System.out.println("    Notes = " + notes);
        System.out.println("    Open = " + open);
        System.out.println("    PageKey = " + pageKey);
        System.out.println("    QueryString = " + queryString);
        System.out.println("    RequestUrl = " + requestUrl);
        System.out.println("    StatusCode = " + statusCode);
        System.out.println("    TypeCode = " + typeCode);
        System.out.println("    Uid = " + uid);
        System.out.println("    UpdatedUtcTs = " + updatedUtcTs);
        System.out.println("    WindowLocation = " + windowLocation);
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
