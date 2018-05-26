//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import java.util.*;

import com.kodemore.collection.*;
import com.kodemore.dao.*;
import com.kodemore.exception.*;
import com.kodemore.meta.*;
import com.kodemore.servlet.encoder.*;
import com.kodemore.servlet.field.*;
import com.kodemore.time.*;
import com.kodemore.types.*;
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.finder.*;
import com.app.model.*;
import com.app.model.base.*;
import com.app.model.core.*;
import com.app.utility.*;

public class MyMetaFeedback
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaFeedback instance = new MyMetaFeedback();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaFeedback()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "feedback";
    }

    public MyFeedbackValidator getValidator()
    {
        return MyFeedbackValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "User submitted bug reports and feature requests.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaFeedback_AuditLogTitle AuditLogTitle = new MyMetaFeedback_AuditLogTitle();
    public final MyMetaFeedback_ClosedDate ClosedDate = new MyMetaFeedback_ClosedDate();
    public final MyMetaFeedback_CreatedUtcTs CreatedUtcTs = new MyMetaFeedback_CreatedUtcTs();
    public final MyMetaFeedback_Description Description = new MyMetaFeedback_Description();
    public final MyMetaFeedback_DomainSubtitle DomainSubtitle = new MyMetaFeedback_DomainSubtitle();
    public final MyMetaFeedback_DomainTitle DomainTitle = new MyMetaFeedback_DomainTitle();
    public final MyMetaFeedback_Notes Notes = new MyMetaFeedback_Notes();
    public final MyMetaFeedback_Open Open = new MyMetaFeedback_Open();
    public final MyMetaFeedback_OpenDays OpenDays = new MyMetaFeedback_OpenDays();
    public final MyMetaFeedback_PageKey PageKey = new MyMetaFeedback_PageKey();
    public final MyMetaFeedback_PageName PageName = new MyMetaFeedback_PageName();
    public final MyMetaFeedback_QueryString QueryString = new MyMetaFeedback_QueryString();
    public final MyMetaFeedback_RequestUrl RequestUrl = new MyMetaFeedback_RequestUrl();
    public final MyMetaFeedback_StatusCode StatusCode = new MyMetaFeedback_StatusCode();
    public final MyMetaFeedback_TruncatedDescription TruncatedDescription = new MyMetaFeedback_TruncatedDescription();
    public final MyMetaFeedback_TypeCode TypeCode = new MyMetaFeedback_TypeCode();
    public final MyMetaFeedback_Uid Uid = new MyMetaFeedback_Uid();
    public final MyMetaFeedback_UpdatedUtcTs UpdatedUtcTs = new MyMetaFeedback_UpdatedUtcTs();
    public final MyMetaFeedback_WindowLocation WindowLocation = new MyMetaFeedback_WindowLocation();
    public final MyMetaFeedback_StatusName StatusName = new MyMetaFeedback_StatusName();
    public final MyMetaFeedback_TypeName TypeName = new MyMetaFeedback_TypeName();
    public final MyMetaFeedback_CreatedLocalTs CreatedLocalTs = new MyMetaFeedback_CreatedLocalTs();
    public final MyMetaFeedback_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaFeedback_CreatedLocalTsMessage();
    public final MyMetaFeedback_CreatedLocalDate CreatedLocalDate = new MyMetaFeedback_CreatedLocalDate();
    public final MyMetaFeedback_CreatedLocalTime CreatedLocalTime = new MyMetaFeedback_CreatedLocalTime();
    public final MyMetaFeedback_UpdatedLocalTs UpdatedLocalTs = new MyMetaFeedback_UpdatedLocalTs();
    public final MyMetaFeedback_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaFeedback_UpdatedLocalTsMessage();
    public final MyMetaFeedback_UpdatedLocalDate UpdatedLocalDate = new MyMetaFeedback_UpdatedLocalDate();
    public final MyMetaFeedback_UpdatedLocalTime UpdatedLocalTime = new MyMetaFeedback_UpdatedLocalTime();
    public final MyMetaFeedback_ClosedByFullName ClosedByFullName = new MyMetaFeedback_ClosedByFullName();
    public final MyMetaFeedback_CreatedByFullName CreatedByFullName = new MyMetaFeedback_CreatedByFullName();
    public final MyMetaFeedback_ProjectName ProjectName = new MyMetaFeedback_ProjectName();
    public final MyMetaFeedback_TenantName TenantName = new MyMetaFeedback_TenantName();
    public final MyMetaFeedback_UpdatedByFullName UpdatedByFullName = new MyMetaFeedback_UpdatedByFullName();

    //##################################################
    //# associations
    //##################################################

    public final MyMetaFeedback_ClosedBy ClosedBy = new MyMetaFeedback_ClosedBy();
    public final MyMetaFeedback_CreatedBy CreatedBy = new MyMetaFeedback_CreatedBy();
    public final MyMetaFeedback_Project Project = new MyMetaFeedback_Project();
    public final MyMetaFeedback_Tenant Tenant = new MyMetaFeedback_Tenant();
    public final MyMetaFeedback_UpdatedBy UpdatedBy = new MyMetaFeedback_UpdatedBy();

    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaFeedback_AuditLogTitle
        extends KmMetaStringProperty<MyFeedback>
    {
        @Override
        public String getName()
        {
            return "auditLogTitle";
        }

        @Override
        public String getLabel()
        {
            return "Audit Log Title";
        }

        @Override
        public String getHelp()
        {
            return "This is used a the title in auditLogs. This should NEVER be null.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public String getValueFor(MyFeedback model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyFeedback model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# ClosedDate
    //##################################################

    public class MyMetaFeedback_ClosedDate
        extends KmMetaDateProperty<MyFeedback>
        implements KmMetaDaoPropertyIF<MyFeedback,KmDate>
    {
        @Override
        public String getName()
        {
            return "closedDate";
        }

        @Override
        public String getLabel()
        {
            return "Closed On";
        }

        @Override
        public String getHelp()
        {
            return "The date the feedback was closed.";
        }

        @Override
        public int getColumnWidth()
        {
            return 10;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmDateValidator getValidator()
        {
            return MyFeedbackValidator.instance.getClosedDateValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "closedDate";
        }

        @Override
        public MyFeedbackDao getDao()
        {
            return getAccess().getFeedbackDao();
        }

        @Override
        public KmDate getValueFor(MyFeedback model)
        {
            return model.getClosedDate();
        }

        @Override
        public void setValueFor(MyFeedback model, KmDate value)
        {
            model.setClosedDate(value);
        }

        @Override
        public boolean hasValueFor(MyFeedback model, KmDate value)
        {
            return model.hasClosedDate(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaFeedback_CreatedUtcTs
        extends KmMetaTimestampProperty<MyFeedback>
        implements KmMetaDaoPropertyIF<MyFeedback,KmTimestamp>
    {
        @Override
        public String getName()
        {
            return "createdUtcTs";
        }

        @Override
        public String getLabel()
        {
            return "Created Utc Ts";
        }

        @Override
        public String getHelp()
        {
            return "The time this record was originally created.";
        }

        @Override
        public int getColumnWidth()
        {
            return 16;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmTimestampValidator getValidator()
        {
            return MyFeedbackValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MyFeedbackDao getDao()
        {
            return getAccess().getFeedbackDao();
        }

        @Override
        public KmTimestamp getValueFor(MyFeedback model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MyFeedback model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyFeedback model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# Description
    //##################################################

    public class MyMetaFeedback_Description
        extends KmMetaStringProperty<MyFeedback>
        implements KmMetaDaoPropertyIF<MyFeedback,String>
    {
        @Override
        public String getName()
        {
            return "description";
        }

        @Override
        public String getLabel()
        {
            return "Description";
        }

        @Override
        public String getHelp()
        {
            return "The multiline note describing the issue or request.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyFeedbackValidator.instance.getDescriptionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "description";
        }

        @Override
        public MyFeedbackDao getDao()
        {
            return getAccess().getFeedbackDao();
        }

        @Override
        public String getValueFor(MyFeedback model)
        {
            return model.getDescription();
        }

        @Override
        public void setValueFor(MyFeedback model, String value)
        {
            model.setDescription(value);
        }

        @Override
        public boolean hasValueFor(MyFeedback model, String value)
        {
            return model.hasDescription(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaFeedback_DomainSubtitle
        extends KmMetaStringProperty<MyFeedback>
    {
        @Override
        public String getName()
        {
            return "domainSubtitle";
        }

        @Override
        public String getLabel()
        {
            return "Domain Subtitle";
        }

        @Override
        public String getHelp()
        {
            return "The subtitle commonly used for rows in a list. This MAY be null, if there is not subtitle.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public String getValueFor(MyFeedback model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyFeedback model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaFeedback_DomainTitle
        extends KmMetaStringProperty<MyFeedback>
    {
        @Override
        public String getName()
        {
            return "domainTitle";
        }

        @Override
        public String getLabel()
        {
            return "Domain Title";
        }

        @Override
        public String getHelp()
        {
            return "The title commonly used for rows in a list or dropdown field. This should NEVER be null.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public String getValueFor(MyFeedback model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyFeedback model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# Notes
    //##################################################

    public class MyMetaFeedback_Notes
        extends KmMetaStringProperty<MyFeedback>
        implements KmMetaDaoPropertyIF<MyFeedback,String>
    {
        @Override
        public String getName()
        {
            return "notes";
        }

        @Override
        public String getLabel()
        {
            return "Notes";
        }

        @Override
        public String getHelp()
        {
            return "Dev notes.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyFeedbackValidator.instance.getNotesValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "notes";
        }

        @Override
        public MyFeedbackDao getDao()
        {
            return getAccess().getFeedbackDao();
        }

        @Override
        public String getValueFor(MyFeedback model)
        {
            return model.getNotes();
        }

        @Override
        public void setValueFor(MyFeedback model, String value)
        {
            model.setNotes(value);
        }

        @Override
        public boolean hasValueFor(MyFeedback model, String value)
        {
            return model.hasNotes(value);
        }
    }

    //##################################################
    //# Open
    //##################################################

    public class MyMetaFeedback_Open
        extends KmMetaBooleanProperty<MyFeedback>
        implements KmMetaDaoPropertyIF<MyFeedback,Boolean>
    {
        @Override
        public String getName()
        {
            return "open";
        }

        @Override
        public String getLabel()
        {
            return "Open";
        }

        @Override
        public String getHelp()
        {
            return "Indicates if the feedback is open and needs to be addressed.";
        }

        @Override
        public int getColumnWidth()
        {
            return 10;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmBooleanValidator getValidator()
        {
            return MyFeedbackValidator.instance.getOpenValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "open";
        }

        @Override
        public MyFeedbackDao getDao()
        {
            return getAccess().getFeedbackDao();
        }

        @Override
        public Boolean getValueFor(MyFeedback model)
        {
            return model.getOpen();
        }

        @Override
        public void setValueFor(MyFeedback model, Boolean value)
        {
            model.setOpen(value);
        }

        @Override
        public boolean hasValueFor(MyFeedback model, Boolean value)
        {
            return model.hasOpen(value);
        }
    }

    //##################################################
    //# OpenDays
    //##################################################

    public class MyMetaFeedback_OpenDays
        extends KmMetaStringProperty<MyFeedback>
    {
        @Override
        public String getName()
        {
            return "openDays";
        }

        @Override
        public String getLabel()
        {
            return "Days open";
        }

        @Override
        public String getHelp()
        {
            return "The number of days this feedback was open.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public String getValueFor(MyFeedback model)
        {
            return model.getOpenDays();
        }

        @Override
        public boolean hasValueFor(MyFeedback model, String value)
        {
            return model.hasOpenDays(value);
        }
    }

    //##################################################
    //# PageKey
    //##################################################

    public class MyMetaFeedback_PageKey
        extends KmMetaStringProperty<MyFeedback>
        implements KmMetaDaoPropertyIF<MyFeedback,String>
    {
        @Override
        public String getName()
        {
            return "pageKey";
        }

        @Override
        public String getLabel()
        {
            return "Page Key";
        }

        @Override
        public String getHelp()
        {
            return "The key of the current page.";
        }

        @Override
        public int getColumnWidth()
        {
            return 15;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyFeedbackValidator.instance.getPageKeyValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "pageKey";
        }

        @Override
        public MyFeedbackDao getDao()
        {
            return getAccess().getFeedbackDao();
        }

        @Override
        public String getValueFor(MyFeedback model)
        {
            return model.getPageKey();
        }

        @Override
        public void setValueFor(MyFeedback model, String value)
        {
            model.setPageKey(value);
        }

        @Override
        public boolean hasValueFor(MyFeedback model, String value)
        {
            return model.hasPageKey(value);
        }
    }

    //##################################################
    //# PageName
    //##################################################

    public class MyMetaFeedback_PageName
        extends KmMetaStringProperty<MyFeedback>
    {
        @Override
        public String getName()
        {
            return "pageName";
        }

        @Override
        public String getLabel()
        {
            return "Page";
        }

        @Override
        public String getHelp()
        {
            return "The user readable page key.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public String getValueFor(MyFeedback model)
        {
            return model.getPageName();
        }

        @Override
        public boolean hasValueFor(MyFeedback model, String value)
        {
            return model.hasPageName(value);
        }
    }

    //##################################################
    //# QueryString
    //##################################################

    public class MyMetaFeedback_QueryString
        extends KmMetaStringProperty<MyFeedback>
        implements KmMetaDaoPropertyIF<MyFeedback,String>
    {
        @Override
        public String getName()
        {
            return "queryString";
        }

        @Override
        public String getLabel()
        {
            return "Query String";
        }

        @Override
        public String getHelp()
        {
            return "The query string for the page.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyFeedbackValidator.instance.getQueryStringValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "queryString";
        }

        @Override
        public MyFeedbackDao getDao()
        {
            return getAccess().getFeedbackDao();
        }

        @Override
        public String getValueFor(MyFeedback model)
        {
            return model.getQueryString();
        }

        @Override
        public void setValueFor(MyFeedback model, String value)
        {
            model.setQueryString(value);
        }

        @Override
        public boolean hasValueFor(MyFeedback model, String value)
        {
            return model.hasQueryString(value);
        }
    }

    //##################################################
    //# RequestUrl
    //##################################################

    public class MyMetaFeedback_RequestUrl
        extends KmMetaStringProperty<MyFeedback>
        implements KmMetaDaoPropertyIF<MyFeedback,String>
    {
        @Override
        public String getName()
        {
            return "requestUrl";
        }

        @Override
        public String getLabel()
        {
            return "Request Url";
        }

        @Override
        public String getHelp()
        {
            return "The request url.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyFeedbackValidator.instance.getRequestUrlValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "requestUrl";
        }

        @Override
        public MyFeedbackDao getDao()
        {
            return getAccess().getFeedbackDao();
        }

        @Override
        public String getValueFor(MyFeedback model)
        {
            return model.getRequestUrl();
        }

        @Override
        public void setValueFor(MyFeedback model, String value)
        {
            model.setRequestUrl(value);
        }

        @Override
        public boolean hasValueFor(MyFeedback model, String value)
        {
            return model.hasRequestUrl(value);
        }
    }

    //##################################################
    //# StatusCode
    //##################################################

    public class MyMetaFeedback_StatusCode
        extends KmMetaStringProperty<MyFeedback>
        implements KmMetaDaoPropertyIF<MyFeedback,String>
    {
        @Override
        public String getName()
        {
            return "statusCode";
        }

        @Override
        public String getLabel()
        {
            return "Status";
        }

        @Override
        public String getHelp()
        {
            return "The status.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyFeedbackValidator.instance.getStatusCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "statusCode";
        }

        @Override
        public MyFeedbackDao getDao()
        {
            return getAccess().getFeedbackDao();
        }

        public ScDynamicEnumDropdownField newDropdown()
        {
            ScDynamicEnumDropdownField e;
            e = new ScDynamicEnumDropdownField();
            e.setMeta(this);
            e.setEnumArraySupplier(MyFeedbackStatus::values);
            return e;
        }

        public ScDynamicEnumDropdownField newDropdown(String label)
        {
            ScDynamicEnumDropdownField e;
            e = newDropdown();
            e.setLabel(label);
            return e;
        }

        @Override
        public String getValueFor(MyFeedback model)
        {
            return model.getStatusCode();
        }

        @Override
        public void setValueFor(MyFeedback model, String value)
        {
            model.setStatusCode(value);
        }

        @Override
        public boolean hasValueFor(MyFeedback model, String value)
        {
            return model.hasStatusCode(value);
        }
    }

    //##################################################
    //# TruncatedDescription
    //##################################################

    public class MyMetaFeedback_TruncatedDescription
        extends KmMetaStringProperty<MyFeedback>
    {
        @Override
        public String getName()
        {
            return "truncatedDescription";
        }

        @Override
        public String getLabel()
        {
            return "Description";
        }

        @Override
        public String getHelp()
        {
            return "The description truncated to 100 characters for display in grids.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public String getValueFor(MyFeedback model)
        {
            return model.getTruncatedDescription();
        }

        @Override
        public boolean hasValueFor(MyFeedback model, String value)
        {
            return model.hasTruncatedDescription(value);
        }
    }

    //##################################################
    //# TypeCode
    //##################################################

    public class MyMetaFeedback_TypeCode
        extends KmMetaStringProperty<MyFeedback>
        implements KmMetaDaoPropertyIF<MyFeedback,String>
    {
        @Override
        public String getName()
        {
            return "typeCode";
        }

        @Override
        public String getLabel()
        {
            return "Type";
        }

        @Override
        public String getHelp()
        {
            return "The type of feedback.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyFeedbackValidator.instance.getTypeCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "typeCode";
        }

        @Override
        public MyFeedbackDao getDao()
        {
            return getAccess().getFeedbackDao();
        }

        public ScDynamicEnumDropdownField newDropdown()
        {
            ScDynamicEnumDropdownField e;
            e = new ScDynamicEnumDropdownField();
            e.setMeta(this);
            e.setEnumArraySupplier(MyFeedbackType::values);
            return e;
        }

        public ScDynamicEnumDropdownField newDropdown(String label)
        {
            ScDynamicEnumDropdownField e;
            e = newDropdown();
            e.setLabel(label);
            return e;
        }

        @Override
        public String getValueFor(MyFeedback model)
        {
            return model.getTypeCode();
        }

        @Override
        public void setValueFor(MyFeedback model, String value)
        {
            model.setTypeCode(value);
        }

        @Override
        public boolean hasValueFor(MyFeedback model, String value)
        {
            return model.hasTypeCode(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaFeedback_Uid
        extends KmMetaStringProperty<MyFeedback>
        implements KmMetaDaoPropertyIF<MyFeedback,String>
    {
        @Override
        public String getName()
        {
            return "uid";
        }

        @Override
        public String getLabel()
        {
            return "Uid";
        }

        @Override
        public String getHelp()
        {
            return "The global unique key.  This is a large hex-encoded number, and is usually not displayed to users.  This is currently NOT a standard format, but is instead a format that we use internally.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyFeedbackValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyFeedbackDao getDao()
        {
            return getAccess().getFeedbackDao();
        }

        public KmDaoStringKeyCursor<MyFeedback> createCursor()
        {
            KmDaoStringKeyCursor<MyFeedback> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyFeedback model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyFeedback model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyFeedback model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# UpdatedUtcTs
    //##################################################

    public class MyMetaFeedback_UpdatedUtcTs
        extends KmMetaTimestampProperty<MyFeedback>
        implements KmMetaDaoPropertyIF<MyFeedback,KmTimestamp>
    {
        @Override
        public String getName()
        {
            return "updatedUtcTs";
        }

        @Override
        public String getLabel()
        {
            return "Updated Utc Ts";
        }

        @Override
        public String getHelp()
        {
            return "The time this record was last updated.";
        }

        @Override
        public int getColumnWidth()
        {
            return 16;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmTimestampValidator getValidator()
        {
            return MyFeedbackValidator.instance.getUpdatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "updatedUtcTs";
        }

        @Override
        public MyFeedbackDao getDao()
        {
            return getAccess().getFeedbackDao();
        }

        @Override
        public KmTimestamp getValueFor(MyFeedback model)
        {
            return model.getUpdatedUtcTs();
        }

        @Override
        public void setValueFor(MyFeedback model, KmTimestamp value)
        {
            model.setUpdatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyFeedback model, KmTimestamp value)
        {
            return model.hasUpdatedUtcTs(value);
        }
    }

    //##################################################
    //# WindowLocation
    //##################################################

    public class MyMetaFeedback_WindowLocation
        extends KmMetaStringProperty<MyFeedback>
        implements KmMetaDaoPropertyIF<MyFeedback,String>
    {
        @Override
        public String getName()
        {
            return "windowLocation";
        }

        @Override
        public String getLabel()
        {
            return "Window Location";
        }

        @Override
        public String getHelp()
        {
            return "The window location.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyFeedbackValidator.instance.getWindowLocationValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "windowLocation";
        }

        @Override
        public MyFeedbackDao getDao()
        {
            return getAccess().getFeedbackDao();
        }

        @Override
        public String getValueFor(MyFeedback model)
        {
            return model.getWindowLocation();
        }

        @Override
        public void setValueFor(MyFeedback model, String value)
        {
            model.setWindowLocation(value);
        }

        @Override
        public boolean hasValueFor(MyFeedback model, String value)
        {
            return model.hasWindowLocation(value);
        }
    }

    //##################################################
    //# StatusName
    //##################################################

    public class MyMetaFeedback_StatusName
        extends KmMetaStringProperty<MyFeedback>
    {
        @Override
        public String getName()
        {
            return "statusName";
        }

        @Override
        public String getLabel()
        {
            return "Status";
        }

        @Override
        public String getHelp()
        {
            return "The status.";
        }

        @Override
        public int getColumnWidth()
        {
            return 15;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public String getValueFor(MyFeedback model)
        {
            return model.getStatusName();
        }

        @Override
        public boolean hasValueFor(MyFeedback model, String value)
        {
            return model.hasStatusName(value);
        }
    }

    //##################################################
    //# TypeName
    //##################################################

    public class MyMetaFeedback_TypeName
        extends KmMetaStringProperty<MyFeedback>
    {
        @Override
        public String getName()
        {
            return "typeName";
        }

        @Override
        public String getLabel()
        {
            return "Type";
        }

        @Override
        public String getHelp()
        {
            return "The type of feedback.";
        }

        @Override
        public int getColumnWidth()
        {
            return 15;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public String getValueFor(MyFeedback model)
        {
            return model.getTypeName();
        }

        @Override
        public boolean hasValueFor(MyFeedback model, String value)
        {
            return model.hasTypeName(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaFeedback_CreatedLocalTs
        extends KmMetaTimestampProperty<MyFeedback>
    {
        @Override
        public String getName()
        {
            return "createdLocalTs";
        }

        @Override
        public String getLabel()
        {
            return "Created";
        }

        @Override
        public String getHelp()
        {
            return "The created timestamp converted to the user's local timezone.";
        }

        @Override
        public int getColumnWidth()
        {
            return 16;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public KmTimestamp getValueFor(MyFeedback model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyFeedback model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaFeedback_CreatedLocalTsMessage
        extends KmMetaStringProperty<MyFeedback>
    {
        @Override
        public String getName()
        {
            return "createdLocalTsMessage";
        }

        @Override
        public String getLabel()
        {
            return "Created";
        }

        @Override
        public String getHelp()
        {
            return "The created timestamp converted to the user's local timezone, and formatted as a string that includes the timezone code.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public String getValueFor(MyFeedback model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyFeedback model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaFeedback_CreatedLocalDate
        extends KmMetaDateProperty<MyFeedback>
    {
        @Override
        public String getName()
        {
            return "createdLocalDate";
        }

        @Override
        public String getLabel()
        {
            return "Created";
        }

        @Override
        public String getHelp()
        {
            return "The created date based on the user's local timezone.";
        }

        @Override
        public int getColumnWidth()
        {
            return 10;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public KmDate getValueFor(MyFeedback model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyFeedback model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaFeedback_CreatedLocalTime
        extends KmMetaTimeProperty<MyFeedback>
    {
        @Override
        public String getName()
        {
            return "createdLocalTime";
        }

        @Override
        public String getLabel()
        {
            return "Created";
        }

        @Override
        public String getHelp()
        {
            return "The created time of day based on the user's local timezone.";
        }

        @Override
        public int getColumnWidth()
        {
            return 10;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public KmTime getValueFor(MyFeedback model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyFeedback model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }

    //##################################################
    //# UpdatedLocalTs
    //##################################################

    public class MyMetaFeedback_UpdatedLocalTs
        extends KmMetaTimestampProperty<MyFeedback>
    {
        @Override
        public String getName()
        {
            return "updatedLocalTs";
        }

        @Override
        public String getLabel()
        {
            return "Updated";
        }

        @Override
        public String getHelp()
        {
            return "The updated timestamp converted to the user's local timezone.";
        }

        @Override
        public int getColumnWidth()
        {
            return 16;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public KmTimestamp getValueFor(MyFeedback model)
        {
            return model.getUpdatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyFeedback model, KmTimestamp value)
        {
            return model.hasUpdatedLocalTs(value);
        }
    }

    //##################################################
    //# UpdatedLocalTsMessage
    //##################################################

    public class MyMetaFeedback_UpdatedLocalTsMessage
        extends KmMetaStringProperty<MyFeedback>
    {
        @Override
        public String getName()
        {
            return "updatedLocalTsMessage";
        }

        @Override
        public String getLabel()
        {
            return "Updated";
        }

        @Override
        public String getHelp()
        {
            return "The updated timestamp converted to the user's local timezone, and formatted as a string that includes the timezone code.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public String getValueFor(MyFeedback model)
        {
            return model.getUpdatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyFeedback model, String value)
        {
            return model.hasUpdatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# UpdatedLocalDate
    //##################################################

    public class MyMetaFeedback_UpdatedLocalDate
        extends KmMetaDateProperty<MyFeedback>
    {
        @Override
        public String getName()
        {
            return "updatedLocalDate";
        }

        @Override
        public String getLabel()
        {
            return "Updated";
        }

        @Override
        public String getHelp()
        {
            return "The updated date based on the user's local timezone.";
        }

        @Override
        public int getColumnWidth()
        {
            return 10;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public KmDate getValueFor(MyFeedback model)
        {
            return model.getUpdatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyFeedback model, KmDate value)
        {
            return model.hasUpdatedLocalDate(value);
        }
    }

    //##################################################
    //# UpdatedLocalTime
    //##################################################

    public class MyMetaFeedback_UpdatedLocalTime
        extends KmMetaTimeProperty<MyFeedback>
    {
        @Override
        public String getName()
        {
            return "updatedLocalTime";
        }

        @Override
        public String getLabel()
        {
            return "Updated";
        }

        @Override
        public String getHelp()
        {
            return "The updated time of day based on the user's local timezone.";
        }

        @Override
        public int getColumnWidth()
        {
            return 10;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public KmTime getValueFor(MyFeedback model)
        {
            return model.getUpdatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyFeedback model, KmTime value)
        {
            return model.hasUpdatedLocalTime(value);
        }
    }

    //##################################################
    //# ClosedByFullName
    //##################################################

    public class MyMetaFeedback_ClosedByFullName
        extends KmMetaStringProperty<MyFeedback>
    {
        @Override
        public String getName()
        {
            return "closedByFullName";
        }

        @Override
        public String getLabel()
        {
            return "Closed By";
        }

        @Override
        public String getHelp()
        {
            return "The first and last name together; e.g.: John Smith. Use the nickname if the first and last names are both empty. This should never be blank.";
        }

        @Override
        public int getColumnWidth()
        {
            return 15;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public String getValueFor(MyFeedback model)
        {
            return model.getClosedByFullName();
        }

        @Override
        public void setValueFor(MyFeedback model, String value)
        {
            model.setClosedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyFeedback model, String value)
        {
            return model.hasClosedByFullName(value);
        }
    }

    //##################################################
    //# CreatedByFullName
    //##################################################

    public class MyMetaFeedback_CreatedByFullName
        extends KmMetaStringProperty<MyFeedback>
    {
        @Override
        public String getName()
        {
            return "createdByFullName";
        }

        @Override
        public String getLabel()
        {
            return "Created By";
        }

        @Override
        public String getHelp()
        {
            return "The first and last name together; e.g.: John Smith. Use the nickname if the first and last names are both empty. This should never be blank.";
        }

        @Override
        public int getColumnWidth()
        {
            return 15;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public String getValueFor(MyFeedback model)
        {
            return model.getCreatedByFullName();
        }

        @Override
        public void setValueFor(MyFeedback model, String value)
        {
            model.setCreatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyFeedback model, String value)
        {
            return model.hasCreatedByFullName(value);
        }
    }

    //##################################################
    //# ProjectName
    //##################################################

    public class MyMetaFeedback_ProjectName
        extends KmMetaStringProperty<MyFeedback>
    {
        @Override
        public String getName()
        {
            return "projectName";
        }

        @Override
        public String getLabel()
        {
            return "Project";
        }

        @Override
        public String getHelp()
        {
            return "The display name.";
        }

        @Override
        public int getColumnWidth()
        {
            return 15;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public String getValueFor(MyFeedback model)
        {
            return model.getProjectName();
        }

        @Override
        public void setValueFor(MyFeedback model, String value)
        {
            model.setProjectName(value);
        }

        @Override
        public boolean hasValueFor(MyFeedback model, String value)
        {
            return model.hasProjectName(value);
        }
    }

    //##################################################
    //# TenantName
    //##################################################

    public class MyMetaFeedback_TenantName
        extends KmMetaStringProperty<MyFeedback>
    {
        @Override
        public String getName()
        {
            return "tenantName";
        }

        @Override
        public String getLabel()
        {
            return "Tenant";
        }

        @Override
        public String getHelp()
        {
            return "The short display name of this tenant.";
        }

        @Override
        public int getColumnWidth()
        {
            return 15;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public String getValueFor(MyFeedback model)
        {
            return model.getTenantName();
        }

        @Override
        public void setValueFor(MyFeedback model, String value)
        {
            model.setTenantName(value);
        }

        @Override
        public boolean hasValueFor(MyFeedback model, String value)
        {
            return model.hasTenantName(value);
        }
    }

    //##################################################
    //# UpdatedByFullName
    //##################################################

    public class MyMetaFeedback_UpdatedByFullName
        extends KmMetaStringProperty<MyFeedback>
    {
        @Override
        public String getName()
        {
            return "updatedByFullName";
        }

        @Override
        public String getLabel()
        {
            return "Updated By";
        }

        @Override
        public String getHelp()
        {
            return "The first and last name together; e.g.: John Smith. Use the nickname if the first and last names are both empty. This should never be blank.";
        }

        @Override
        public int getColumnWidth()
        {
            return 15;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public String getValueFor(MyFeedback model)
        {
            return model.getUpdatedByFullName();
        }

        @Override
        public void setValueFor(MyFeedback model, String value)
        {
            model.setUpdatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyFeedback model, String value)
        {
            return model.hasUpdatedByFullName(value);
        }
    }


    //##################################################
    //# ClosedBy
    //##################################################

    public class MyMetaFeedback_ClosedBy
        extends KmMetaDaoAssociation<MyFeedback,MyUser>
    {
        @Override
        public String getName()
        {
            return "closedBy";
        }

        @Override
        public String getLabel()
        {
            return "Closed By";
        }

        @Override
        public String getHelp()
        {
            return "The user that closed this feedback.";
        }

        @Override
        public boolean isRequired()
        {
            return false;
        }

        @Override
        public MyUser getValueFor(MyFeedback model)
        {
            return model.getClosedBy();
        }

        @Override
        public void setValueFor(MyFeedback model, MyUser value)
        {
            model.setClosedBy(value);
        }

        @Override
        public boolean hasValueFor(MyFeedback model, MyUser value)
        {
            return model.hasClosedBy(value);
        }
    }

    //##################################################
    //# CreatedBy
    //##################################################

    public class MyMetaFeedback_CreatedBy
        extends KmMetaDaoAssociation<MyFeedback,MyUser>
    {
        @Override
        public String getName()
        {
            return "createdBy";
        }

        @Override
        public String getLabel()
        {
            return "Created By";
        }

        @Override
        public String getHelp()
        {
            return "The user that originally created this record, if known.";
        }

        @Override
        public boolean isRequired()
        {
            return false;
        }

        @Override
        public MyUser getValueFor(MyFeedback model)
        {
            return model.getCreatedBy();
        }

        @Override
        public void setValueFor(MyFeedback model, MyUser value)
        {
            model.setCreatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyFeedback model, MyUser value)
        {
            return model.hasCreatedBy(value);
        }
    }

    //##################################################
    //# Project
    //##################################################

    public class MyMetaFeedback_Project
        extends KmMetaDaoAssociation<MyFeedback,MyProject>
    {
        @Override
        public String getName()
        {
            return "project";
        }

        @Override
        public String getLabel()
        {
            return "Project";
        }

        @Override
        public String getHelp()
        {
            return "The project.";
        }

        @Override
        public boolean isRequired()
        {
            return false;
        }

        @Override
        public MyProject getValueFor(MyFeedback model)
        {
            return model.getProject();
        }

        @Override
        public void setValueFor(MyFeedback model, MyProject value)
        {
            model.setProject(value);
        }

        @Override
        public boolean hasValueFor(MyFeedback model, MyProject value)
        {
            return model.hasProject(value);
        }
    }

    //##################################################
    //# Tenant
    //##################################################

    public class MyMetaFeedback_Tenant
        extends KmMetaDaoAssociation<MyFeedback,MyTenant>
    {
        @Override
        public String getName()
        {
            return "tenant";
        }

        @Override
        public String getLabel()
        {
            return "Tenant";
        }

        @Override
        public String getHelp()
        {
            return "The current tenant.";
        }

        @Override
        public boolean isRequired()
        {
            return true;
        }

        @Override
        public MyTenant getValueFor(MyFeedback model)
        {
            return model.getTenant();
        }

        @Override
        public void setValueFor(MyFeedback model, MyTenant value)
        {
            model.setTenant(value);
        }

        @Override
        public boolean hasValueFor(MyFeedback model, MyTenant value)
        {
            return model.hasTenant(value);
        }
    }

    //##################################################
    //# UpdatedBy
    //##################################################

    public class MyMetaFeedback_UpdatedBy
        extends KmMetaDaoAssociation<MyFeedback,MyUser>
    {
        @Override
        public String getName()
        {
            return "updatedBy";
        }

        @Override
        public String getLabel()
        {
            return "Updated By";
        }

        @Override
        public String getHelp()
        {
            return "The user that last updated this record, if known.";
        }

        @Override
        public boolean isRequired()
        {
            return false;
        }

        @Override
        public MyUser getValueFor(MyFeedback model)
        {
            return model.getUpdatedBy();
        }

        @Override
        public void setValueFor(MyFeedback model, MyUser value)
        {
            model.setUpdatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyFeedback model, MyUser value)
        {
            return model.hasUpdatedBy(value);
        }
    }

    //##################################################
    //# support
    //##################################################

    protected MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

}
