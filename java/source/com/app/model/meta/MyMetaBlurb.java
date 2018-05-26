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

public class MyMetaBlurb
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaBlurb instance = new MyMetaBlurb();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaBlurb()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "blurb";
    }

    public MyBlurbValidator getValidator()
    {
        return MyBlurbValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "Blurbs are used to compose messages for display on screen. These can be used for a variety of information, e.g.: phone scripts, cancellation policies, promotional material, etc.\n Blurbs support basic formattings (e.g.: bold, italics) and allow for a number of predefined variables which are automatically substituted when the real message is displayed.\n Blurbs can be defined for different domain contexts such as Job, Site, or Visit; and the specific variables that are available vary depending on the context.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaBlurb_AuditLogTitle AuditLogTitle = new MyMetaBlurb_AuditLogTitle();
    public final MyMetaBlurb_CreatedUtcTs CreatedUtcTs = new MyMetaBlurb_CreatedUtcTs();
    public final MyMetaBlurb_DomainSubtitle DomainSubtitle = new MyMetaBlurb_DomainSubtitle();
    public final MyMetaBlurb_DomainTitle DomainTitle = new MyMetaBlurb_DomainTitle();
    public final MyMetaBlurb_Enabled Enabled = new MyMetaBlurb_Enabled();
    public final MyMetaBlurb_EnabledStatus EnabledStatus = new MyMetaBlurb_EnabledStatus();
    public final MyMetaBlurb_MessageHtml MessageHtml = new MyMetaBlurb_MessageHtml();
    public final MyMetaBlurb_Name Name = new MyMetaBlurb_Name();
    public final MyMetaBlurb_OwnerTypeCode OwnerTypeCode = new MyMetaBlurb_OwnerTypeCode();
    public final MyMetaBlurb_SampleMessageHtml SampleMessageHtml = new MyMetaBlurb_SampleMessageHtml();
    public final MyMetaBlurb_Uid Uid = new MyMetaBlurb_Uid();
    public final MyMetaBlurb_UpdatedUtcTs UpdatedUtcTs = new MyMetaBlurb_UpdatedUtcTs();
    public final MyMetaBlurb_LockVersion LockVersion = new MyMetaBlurb_LockVersion();
    public final MyMetaBlurb_OwnerTypeName OwnerTypeName = new MyMetaBlurb_OwnerTypeName();
    public final MyMetaBlurb_CreatedLocalTs CreatedLocalTs = new MyMetaBlurb_CreatedLocalTs();
    public final MyMetaBlurb_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaBlurb_CreatedLocalTsMessage();
    public final MyMetaBlurb_CreatedLocalDate CreatedLocalDate = new MyMetaBlurb_CreatedLocalDate();
    public final MyMetaBlurb_CreatedLocalTime CreatedLocalTime = new MyMetaBlurb_CreatedLocalTime();
    public final MyMetaBlurb_UpdatedLocalTs UpdatedLocalTs = new MyMetaBlurb_UpdatedLocalTs();
    public final MyMetaBlurb_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaBlurb_UpdatedLocalTsMessage();
    public final MyMetaBlurb_UpdatedLocalDate UpdatedLocalDate = new MyMetaBlurb_UpdatedLocalDate();
    public final MyMetaBlurb_UpdatedLocalTime UpdatedLocalTime = new MyMetaBlurb_UpdatedLocalTime();
    public final MyMetaBlurb_CreatedByFullName CreatedByFullName = new MyMetaBlurb_CreatedByFullName();
    public final MyMetaBlurb_UpdatedByFullName UpdatedByFullName = new MyMetaBlurb_UpdatedByFullName();

    //##################################################
    //# associations
    //##################################################

    public final MyMetaBlurb_CreatedBy CreatedBy = new MyMetaBlurb_CreatedBy();
    public final MyMetaBlurb_Project Project = new MyMetaBlurb_Project();
    public final MyMetaBlurb_UpdatedBy UpdatedBy = new MyMetaBlurb_UpdatedBy();

    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaBlurb_AuditLogTitle
        extends KmMetaStringProperty<MyBlurb>
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
        public String getValueFor(MyBlurb model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyBlurb model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaBlurb_CreatedUtcTs
        extends KmMetaTimestampProperty<MyBlurb>
        implements KmMetaDaoPropertyIF<MyBlurb,KmTimestamp>
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
            return MyBlurbValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MyBlurbDao getDao()
        {
            return getAccess().getBlurbDao();
        }

        @Override
        public KmTimestamp getValueFor(MyBlurb model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MyBlurb model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyBlurb model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaBlurb_DomainSubtitle
        extends KmMetaStringProperty<MyBlurb>
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
        public String getValueFor(MyBlurb model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyBlurb model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaBlurb_DomainTitle
        extends KmMetaStringProperty<MyBlurb>
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
        public String getValueFor(MyBlurb model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyBlurb model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# Enabled
    //##################################################

    public class MyMetaBlurb_Enabled
        extends KmMetaBooleanProperty<MyBlurb>
        implements KmMetaDaoPropertyIF<MyBlurb,Boolean>
    {
        @Override
        public String getName()
        {
            return "enabled";
        }

        @Override
        public String getLabel()
        {
            return "Enabled";
        }

        @Override
        public String getHelp()
        {
            return "Disable to hide this on various screens.";
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
            return MyBlurbValidator.instance.getEnabledValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "enabled";
        }

        @Override
        public MyBlurbDao getDao()
        {
            return getAccess().getBlurbDao();
        }

        @Override
        public Boolean getValueFor(MyBlurb model)
        {
            return model.getEnabled();
        }

        @Override
        public void setValueFor(MyBlurb model, Boolean value)
        {
            model.setEnabled(value);
        }

        @Override
        public boolean hasValueFor(MyBlurb model, Boolean value)
        {
            return model.hasEnabled(value);
        }
    }

    //##################################################
    //# EnabledStatus
    //##################################################

    public class MyMetaBlurb_EnabledStatus
        extends KmMetaStringProperty<MyBlurb>
    {
        @Override
        public String getName()
        {
            return "enabledStatus";
        }

        @Override
        public String getLabel()
        {
            return "Enabled";
        }

        @Override
        public String getHelp()
        {
            return "Disable to hide this on various screens.";
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
        public String getValueFor(MyBlurb model)
        {
            return model.getEnabledStatus();
        }

        @Override
        public boolean hasValueFor(MyBlurb model, String value)
        {
            return model.hasEnabledStatus(value);
        }
    }

    //##################################################
    //# MessageHtml
    //##################################################

    public class MyMetaBlurb_MessageHtml
        extends KmMetaStringProperty<MyBlurb>
        implements KmMetaDaoPropertyIF<MyBlurb,String>
    {
        @Override
        public String getName()
        {
            return "messageHtml";
        }

        @Override
        public String getLabel()
        {
            return "Message";
        }

        @Override
        public String getHelp()
        {
            return "The html template for the message.  This supports basic html formatting such as bold and italics; and also supports a number of variable substitutions.";
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
            return MyBlurbValidator.instance.getMessageHtmlValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "messageHtml";
        }

        @Override
        public MyBlurbDao getDao()
        {
            return getAccess().getBlurbDao();
        }

        @Override
        public String getValueFor(MyBlurb model)
        {
            return model.getMessageHtml();
        }

        @Override
        public void setValueFor(MyBlurb model, String value)
        {
            model.setMessageHtml(value);
        }

        @Override
        public boolean hasValueFor(MyBlurb model, String value)
        {
            return model.hasMessageHtml(value);
        }
    }

    //##################################################
    //# Name
    //##################################################

    public class MyMetaBlurb_Name
        extends KmMetaStringProperty<MyBlurb>
        implements KmMetaDaoPropertyIF<MyBlurb,String>
    {
        @Override
        public String getName()
        {
            return "name";
        }

        @Override
        public String getLabel()
        {
            return "Name";
        }

        @Override
        public String getHelp()
        {
            return "The display name used to identify this template within a project.";
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
            return MyBlurbValidator.instance.getNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "name";
        }

        @Override
        public MyBlurbDao getDao()
        {
            return getAccess().getBlurbDao();
        }

        @Override
        public String getValueFor(MyBlurb model)
        {
            return model.getName();
        }

        @Override
        public void setValueFor(MyBlurb model, String value)
        {
            model.setName(value);
        }

        @Override
        public boolean hasValueFor(MyBlurb model, String value)
        {
            return model.hasName(value);
        }
    }

    //##################################################
    //# OwnerTypeCode
    //##################################################

    public class MyMetaBlurb_OwnerTypeCode
        extends KmMetaStringProperty<MyBlurb>
        implements KmMetaDaoPropertyIF<MyBlurb,String>
    {
        @Override
        public String getName()
        {
            return "ownerTypeCode";
        }

        @Override
        public String getLabel()
        {
            return "Owner Type Code";
        }

        @Override
        public String getHelp()
        {
            return "The type of element that owns this note.";
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
            return MyBlurbValidator.instance.getOwnerTypeCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "ownerTypeCode";
        }

        @Override
        public MyBlurbDao getDao()
        {
            return getAccess().getBlurbDao();
        }

        public ScDynamicEnumDropdownField newDropdown()
        {
            ScDynamicEnumDropdownField e;
            e = new ScDynamicEnumDropdownField();
            e.setMeta(this);
            e.setEnumArraySupplier(MyBlurbOwnerType::values);
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
        public String getValueFor(MyBlurb model)
        {
            return model.getOwnerTypeCode();
        }

        @Override
        public void setValueFor(MyBlurb model, String value)
        {
            model.setOwnerTypeCode(value);
        }

        @Override
        public boolean hasValueFor(MyBlurb model, String value)
        {
            return model.hasOwnerTypeCode(value);
        }
    }

    //##################################################
    //# SampleMessageHtml
    //##################################################

    public class MyMetaBlurb_SampleMessageHtml
        extends KmMetaStringProperty<MyBlurb>
    {
        @Override
        public String getName()
        {
            return "sampleMessageHtml";
        }

        @Override
        public String getLabel()
        {
            return "Sample Message";
        }

        @Override
        public String getHelp()
        {
            return "An example of the body html using default sample data.";
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
        public String getValueFor(MyBlurb model)
        {
            return model.getSampleMessageHtml();
        }

        @Override
        public boolean hasValueFor(MyBlurb model, String value)
        {
            return model.hasSampleMessageHtml(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaBlurb_Uid
        extends KmMetaStringProperty<MyBlurb>
        implements KmMetaDaoPropertyIF<MyBlurb,String>
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
            return MyBlurbValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyBlurbDao getDao()
        {
            return getAccess().getBlurbDao();
        }

        public KmDaoStringKeyCursor<MyBlurb> createCursor()
        {
            KmDaoStringKeyCursor<MyBlurb> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyBlurb model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyBlurb model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyBlurb model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# UpdatedUtcTs
    //##################################################

    public class MyMetaBlurb_UpdatedUtcTs
        extends KmMetaTimestampProperty<MyBlurb>
        implements KmMetaDaoPropertyIF<MyBlurb,KmTimestamp>
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
            return MyBlurbValidator.instance.getUpdatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "updatedUtcTs";
        }

        @Override
        public MyBlurbDao getDao()
        {
            return getAccess().getBlurbDao();
        }

        @Override
        public KmTimestamp getValueFor(MyBlurb model)
        {
            return model.getUpdatedUtcTs();
        }

        @Override
        public void setValueFor(MyBlurb model, KmTimestamp value)
        {
            model.setUpdatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyBlurb model, KmTimestamp value)
        {
            return model.hasUpdatedUtcTs(value);
        }
    }

    //##################################################
    //# LockVersion
    //##################################################

    public class MyMetaBlurb_LockVersion
        extends KmMetaIntegerProperty<MyBlurb>
        implements KmMetaDaoPropertyIF<MyBlurb,Integer>
    {
        @Override
        public String getName()
        {
            return "lockVersion";
        }

        @Override
        public String getLabel()
        {
            return "Lock Version";
        }

        @Override
        public String getHelp()
        {
            return "This is used to coordinate optimistic locking in the database. This is usually not displayed.";
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
        public KmIntegerValidator getValidator()
        {
            return MyBlurbValidator.instance.getLockVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lockVersion";
        }

        @Override
        public MyBlurbDao getDao()
        {
            return getAccess().getBlurbDao();
        }

        @Override
        public Integer getValueFor(MyBlurb model)
        {
            return model.getLockVersion();
        }

        @Override
        public void setValueFor(MyBlurb model, Integer value)
        {
            model.setLockVersion(value);
        }

        @Override
        public boolean hasValueFor(MyBlurb model, Integer value)
        {
            return model.hasLockVersion(value);
        }
    }

    //##################################################
    //# OwnerTypeName
    //##################################################

    public class MyMetaBlurb_OwnerTypeName
        extends KmMetaStringProperty<MyBlurb>
    {
        @Override
        public String getName()
        {
            return "ownerTypeName";
        }

        @Override
        public String getLabel()
        {
            return "Owner Type";
        }

        @Override
        public String getHelp()
        {
            return "The type of element that owns this note.";
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
        public String getValueFor(MyBlurb model)
        {
            return model.getOwnerTypeName();
        }

        @Override
        public boolean hasValueFor(MyBlurb model, String value)
        {
            return model.hasOwnerTypeName(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaBlurb_CreatedLocalTs
        extends KmMetaTimestampProperty<MyBlurb>
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
        public KmTimestamp getValueFor(MyBlurb model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyBlurb model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaBlurb_CreatedLocalTsMessage
        extends KmMetaStringProperty<MyBlurb>
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
        public String getValueFor(MyBlurb model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyBlurb model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaBlurb_CreatedLocalDate
        extends KmMetaDateProperty<MyBlurb>
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
        public KmDate getValueFor(MyBlurb model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyBlurb model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaBlurb_CreatedLocalTime
        extends KmMetaTimeProperty<MyBlurb>
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
        public KmTime getValueFor(MyBlurb model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyBlurb model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }

    //##################################################
    //# UpdatedLocalTs
    //##################################################

    public class MyMetaBlurb_UpdatedLocalTs
        extends KmMetaTimestampProperty<MyBlurb>
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
        public KmTimestamp getValueFor(MyBlurb model)
        {
            return model.getUpdatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyBlurb model, KmTimestamp value)
        {
            return model.hasUpdatedLocalTs(value);
        }
    }

    //##################################################
    //# UpdatedLocalTsMessage
    //##################################################

    public class MyMetaBlurb_UpdatedLocalTsMessage
        extends KmMetaStringProperty<MyBlurb>
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
        public String getValueFor(MyBlurb model)
        {
            return model.getUpdatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyBlurb model, String value)
        {
            return model.hasUpdatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# UpdatedLocalDate
    //##################################################

    public class MyMetaBlurb_UpdatedLocalDate
        extends KmMetaDateProperty<MyBlurb>
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
        public KmDate getValueFor(MyBlurb model)
        {
            return model.getUpdatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyBlurb model, KmDate value)
        {
            return model.hasUpdatedLocalDate(value);
        }
    }

    //##################################################
    //# UpdatedLocalTime
    //##################################################

    public class MyMetaBlurb_UpdatedLocalTime
        extends KmMetaTimeProperty<MyBlurb>
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
        public KmTime getValueFor(MyBlurb model)
        {
            return model.getUpdatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyBlurb model, KmTime value)
        {
            return model.hasUpdatedLocalTime(value);
        }
    }

    //##################################################
    //# CreatedByFullName
    //##################################################

    public class MyMetaBlurb_CreatedByFullName
        extends KmMetaStringProperty<MyBlurb>
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
        public String getValueFor(MyBlurb model)
        {
            return model.getCreatedByFullName();
        }

        @Override
        public void setValueFor(MyBlurb model, String value)
        {
            model.setCreatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyBlurb model, String value)
        {
            return model.hasCreatedByFullName(value);
        }
    }

    //##################################################
    //# UpdatedByFullName
    //##################################################

    public class MyMetaBlurb_UpdatedByFullName
        extends KmMetaStringProperty<MyBlurb>
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
        public String getValueFor(MyBlurb model)
        {
            return model.getUpdatedByFullName();
        }

        @Override
        public void setValueFor(MyBlurb model, String value)
        {
            model.setUpdatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyBlurb model, String value)
        {
            return model.hasUpdatedByFullName(value);
        }
    }


    //##################################################
    //# CreatedBy
    //##################################################

    public class MyMetaBlurb_CreatedBy
        extends KmMetaDaoAssociation<MyBlurb,MyUser>
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
        public MyUser getValueFor(MyBlurb model)
        {
            return model.getCreatedBy();
        }

        @Override
        public void setValueFor(MyBlurb model, MyUser value)
        {
            model.setCreatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyBlurb model, MyUser value)
        {
            return model.hasCreatedBy(value);
        }
    }

    //##################################################
    //# Project
    //##################################################

    public class MyMetaBlurb_Project
        extends KmMetaDaoAssociation<MyBlurb,MyProject>
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
            return "The project that contains this template.";
        }

        @Override
        public boolean isRequired()
        {
            return true;
        }

        @Override
        public MyProject getValueFor(MyBlurb model)
        {
            return model.getProject();
        }

        @Override
        public void setValueFor(MyBlurb model, MyProject value)
        {
            model.setProject(value);
        }

        @Override
        public boolean hasValueFor(MyBlurb model, MyProject value)
        {
            return model.hasProject(value);
        }
    }

    //##################################################
    //# UpdatedBy
    //##################################################

    public class MyMetaBlurb_UpdatedBy
        extends KmMetaDaoAssociation<MyBlurb,MyUser>
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
        public MyUser getValueFor(MyBlurb model)
        {
            return model.getUpdatedBy();
        }

        @Override
        public void setValueFor(MyBlurb model, MyUser value)
        {
            model.setUpdatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyBlurb model, MyUser value)
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
