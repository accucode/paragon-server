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

public class MyMetaVendor
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaVendor instance = new MyMetaVendor();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaVendor()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "vendor";
    }

    public MyVendorValidator getValidator()
    {
        return MyVendorValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "Vendors are used to help organized products and services.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaVendor_AuditLogTitle AuditLogTitle = new MyMetaVendor_AuditLogTitle();
    public final MyMetaVendor_CreatedUtcTs CreatedUtcTs = new MyMetaVendor_CreatedUtcTs();
    public final MyMetaVendor_DomainSubtitle DomainSubtitle = new MyMetaVendor_DomainSubtitle();
    public final MyMetaVendor_DomainTitle DomainTitle = new MyMetaVendor_DomainTitle();
    public final MyMetaVendor_Enabled Enabled = new MyMetaVendor_Enabled();
    public final MyMetaVendor_EnabledStatus EnabledStatus = new MyMetaVendor_EnabledStatus();
    public final MyMetaVendor_Name Name = new MyMetaVendor_Name();
    public final MyMetaVendor_Uid Uid = new MyMetaVendor_Uid();
    public final MyMetaVendor_UpdatedUtcTs UpdatedUtcTs = new MyMetaVendor_UpdatedUtcTs();
    public final MyMetaVendor_LockVersion LockVersion = new MyMetaVendor_LockVersion();
    public final MyMetaVendor_CreatedLocalTs CreatedLocalTs = new MyMetaVendor_CreatedLocalTs();
    public final MyMetaVendor_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaVendor_CreatedLocalTsMessage();
    public final MyMetaVendor_CreatedLocalDate CreatedLocalDate = new MyMetaVendor_CreatedLocalDate();
    public final MyMetaVendor_CreatedLocalTime CreatedLocalTime = new MyMetaVendor_CreatedLocalTime();
    public final MyMetaVendor_UpdatedLocalTs UpdatedLocalTs = new MyMetaVendor_UpdatedLocalTs();
    public final MyMetaVendor_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaVendor_UpdatedLocalTsMessage();
    public final MyMetaVendor_UpdatedLocalDate UpdatedLocalDate = new MyMetaVendor_UpdatedLocalDate();
    public final MyMetaVendor_UpdatedLocalTime UpdatedLocalTime = new MyMetaVendor_UpdatedLocalTime();
    public final MyMetaVendor_CreatedByFullName CreatedByFullName = new MyMetaVendor_CreatedByFullName();
    public final MyMetaVendor_UpdatedByFullName UpdatedByFullName = new MyMetaVendor_UpdatedByFullName();

    //##################################################
    //# associations
    //##################################################

    public final MyMetaVendor_CreatedBy CreatedBy = new MyMetaVendor_CreatedBy();
    public final MyMetaVendor_Project Project = new MyMetaVendor_Project();
    public final MyMetaVendor_UpdatedBy UpdatedBy = new MyMetaVendor_UpdatedBy();

    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaVendor_AuditLogTitle
        extends KmMetaStringProperty<MyVendor>
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
        public String getValueFor(MyVendor model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyVendor model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaVendor_CreatedUtcTs
        extends KmMetaTimestampProperty<MyVendor>
        implements KmMetaDaoPropertyIF<MyVendor,KmTimestamp>
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
            return MyVendorValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MyVendorDao getDao()
        {
            return getAccess().getVendorDao();
        }

        @Override
        public KmTimestamp getValueFor(MyVendor model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MyVendor model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyVendor model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaVendor_DomainSubtitle
        extends KmMetaStringProperty<MyVendor>
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
        public String getValueFor(MyVendor model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyVendor model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaVendor_DomainTitle
        extends KmMetaStringProperty<MyVendor>
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
        public String getValueFor(MyVendor model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyVendor model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# Enabled
    //##################################################

    public class MyMetaVendor_Enabled
        extends KmMetaBooleanProperty<MyVendor>
        implements KmMetaDaoPropertyIF<MyVendor,Boolean>
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
            return MyVendorValidator.instance.getEnabledValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "enabled";
        }

        @Override
        public MyVendorDao getDao()
        {
            return getAccess().getVendorDao();
        }

        @Override
        public Boolean getValueFor(MyVendor model)
        {
            return model.getEnabled();
        }

        @Override
        public void setValueFor(MyVendor model, Boolean value)
        {
            model.setEnabled(value);
        }

        @Override
        public boolean hasValueFor(MyVendor model, Boolean value)
        {
            return model.hasEnabled(value);
        }
    }

    //##################################################
    //# EnabledStatus
    //##################################################

    public class MyMetaVendor_EnabledStatus
        extends KmMetaStringProperty<MyVendor>
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
        public String getValueFor(MyVendor model)
        {
            return model.getEnabledStatus();
        }

        @Override
        public boolean hasValueFor(MyVendor model, String value)
        {
            return model.hasEnabledStatus(value);
        }
    }

    //##################################################
    //# Name
    //##################################################

    public class MyMetaVendor_Name
        extends KmMetaStringProperty<MyVendor>
        implements KmMetaDaoPropertyIF<MyVendor,String>
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
            return "The vendor's name.";
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
            return MyVendorValidator.instance.getNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "name";
        }

        @Override
        public MyVendorDao getDao()
        {
            return getAccess().getVendorDao();
        }

        @Override
        public String getValueFor(MyVendor model)
        {
            return model.getName();
        }

        @Override
        public void setValueFor(MyVendor model, String value)
        {
            model.setName(value);
        }

        @Override
        public boolean hasValueFor(MyVendor model, String value)
        {
            return model.hasName(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaVendor_Uid
        extends KmMetaStringProperty<MyVendor>
        implements KmMetaDaoPropertyIF<MyVendor,String>
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
            return MyVendorValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyVendorDao getDao()
        {
            return getAccess().getVendorDao();
        }

        public KmDaoStringKeyCursor<MyVendor> createCursor()
        {
            KmDaoStringKeyCursor<MyVendor> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyVendor model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyVendor model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyVendor model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# UpdatedUtcTs
    //##################################################

    public class MyMetaVendor_UpdatedUtcTs
        extends KmMetaTimestampProperty<MyVendor>
        implements KmMetaDaoPropertyIF<MyVendor,KmTimestamp>
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
            return MyVendorValidator.instance.getUpdatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "updatedUtcTs";
        }

        @Override
        public MyVendorDao getDao()
        {
            return getAccess().getVendorDao();
        }

        @Override
        public KmTimestamp getValueFor(MyVendor model)
        {
            return model.getUpdatedUtcTs();
        }

        @Override
        public void setValueFor(MyVendor model, KmTimestamp value)
        {
            model.setUpdatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyVendor model, KmTimestamp value)
        {
            return model.hasUpdatedUtcTs(value);
        }
    }

    //##################################################
    //# LockVersion
    //##################################################

    public class MyMetaVendor_LockVersion
        extends KmMetaIntegerProperty<MyVendor>
        implements KmMetaDaoPropertyIF<MyVendor,Integer>
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
            return MyVendorValidator.instance.getLockVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lockVersion";
        }

        @Override
        public MyVendorDao getDao()
        {
            return getAccess().getVendorDao();
        }

        @Override
        public Integer getValueFor(MyVendor model)
        {
            return model.getLockVersion();
        }

        @Override
        public void setValueFor(MyVendor model, Integer value)
        {
            model.setLockVersion(value);
        }

        @Override
        public boolean hasValueFor(MyVendor model, Integer value)
        {
            return model.hasLockVersion(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaVendor_CreatedLocalTs
        extends KmMetaTimestampProperty<MyVendor>
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
        public KmTimestamp getValueFor(MyVendor model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyVendor model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaVendor_CreatedLocalTsMessage
        extends KmMetaStringProperty<MyVendor>
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
        public String getValueFor(MyVendor model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyVendor model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaVendor_CreatedLocalDate
        extends KmMetaDateProperty<MyVendor>
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
        public KmDate getValueFor(MyVendor model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyVendor model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaVendor_CreatedLocalTime
        extends KmMetaTimeProperty<MyVendor>
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
        public KmTime getValueFor(MyVendor model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyVendor model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }

    //##################################################
    //# UpdatedLocalTs
    //##################################################

    public class MyMetaVendor_UpdatedLocalTs
        extends KmMetaTimestampProperty<MyVendor>
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
        public KmTimestamp getValueFor(MyVendor model)
        {
            return model.getUpdatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyVendor model, KmTimestamp value)
        {
            return model.hasUpdatedLocalTs(value);
        }
    }

    //##################################################
    //# UpdatedLocalTsMessage
    //##################################################

    public class MyMetaVendor_UpdatedLocalTsMessage
        extends KmMetaStringProperty<MyVendor>
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
        public String getValueFor(MyVendor model)
        {
            return model.getUpdatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyVendor model, String value)
        {
            return model.hasUpdatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# UpdatedLocalDate
    //##################################################

    public class MyMetaVendor_UpdatedLocalDate
        extends KmMetaDateProperty<MyVendor>
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
        public KmDate getValueFor(MyVendor model)
        {
            return model.getUpdatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyVendor model, KmDate value)
        {
            return model.hasUpdatedLocalDate(value);
        }
    }

    //##################################################
    //# UpdatedLocalTime
    //##################################################

    public class MyMetaVendor_UpdatedLocalTime
        extends KmMetaTimeProperty<MyVendor>
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
        public KmTime getValueFor(MyVendor model)
        {
            return model.getUpdatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyVendor model, KmTime value)
        {
            return model.hasUpdatedLocalTime(value);
        }
    }

    //##################################################
    //# CreatedByFullName
    //##################################################

    public class MyMetaVendor_CreatedByFullName
        extends KmMetaStringProperty<MyVendor>
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
        public String getValueFor(MyVendor model)
        {
            return model.getCreatedByFullName();
        }

        @Override
        public void setValueFor(MyVendor model, String value)
        {
            model.setCreatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyVendor model, String value)
        {
            return model.hasCreatedByFullName(value);
        }
    }

    //##################################################
    //# UpdatedByFullName
    //##################################################

    public class MyMetaVendor_UpdatedByFullName
        extends KmMetaStringProperty<MyVendor>
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
        public String getValueFor(MyVendor model)
        {
            return model.getUpdatedByFullName();
        }

        @Override
        public void setValueFor(MyVendor model, String value)
        {
            model.setUpdatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyVendor model, String value)
        {
            return model.hasUpdatedByFullName(value);
        }
    }


    //##################################################
    //# CreatedBy
    //##################################################

    public class MyMetaVendor_CreatedBy
        extends KmMetaDaoAssociation<MyVendor,MyUser>
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
        public MyUser getValueFor(MyVendor model)
        {
            return model.getCreatedBy();
        }

        @Override
        public void setValueFor(MyVendor model, MyUser value)
        {
            model.setCreatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyVendor model, MyUser value)
        {
            return model.hasCreatedBy(value);
        }
    }

    //##################################################
    //# Project
    //##################################################

    public class MyMetaVendor_Project
        extends KmMetaDaoAssociation<MyVendor,MyProject>
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
            return "The project to which this vendor belongs.";
        }

        @Override
        public boolean isRequired()
        {
            return true;
        }

        @Override
        public MyProject getValueFor(MyVendor model)
        {
            return model.getProject();
        }

        @Override
        public void setValueFor(MyVendor model, MyProject value)
        {
            model.setProject(value);
        }

        @Override
        public boolean hasValueFor(MyVendor model, MyProject value)
        {
            return model.hasProject(value);
        }
    }

    //##################################################
    //# UpdatedBy
    //##################################################

    public class MyMetaVendor_UpdatedBy
        extends KmMetaDaoAssociation<MyVendor,MyUser>
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
        public MyUser getValueFor(MyVendor model)
        {
            return model.getUpdatedBy();
        }

        @Override
        public void setValueFor(MyVendor model, MyUser value)
        {
            model.setUpdatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyVendor model, MyUser value)
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
