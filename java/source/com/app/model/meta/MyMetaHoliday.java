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

public class MyMetaHoliday
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaHoliday instance = new MyMetaHoliday();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaHoliday()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "holiday";
    }

    public MyHolidayValidator getValidator()
    {
        return MyHolidayValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "Project specific holidays.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaHoliday_AuditLogTitle AuditLogTitle = new MyMetaHoliday_AuditLogTitle();
    public final MyMetaHoliday_CreatedUtcTs CreatedUtcTs = new MyMetaHoliday_CreatedUtcTs();
    public final MyMetaHoliday_Day Day = new MyMetaHoliday_Day();
    public final MyMetaHoliday_DomainSubtitle DomainSubtitle = new MyMetaHoliday_DomainSubtitle();
    public final MyMetaHoliday_DomainTitle DomainTitle = new MyMetaHoliday_DomainTitle();
    public final MyMetaHoliday_Name Name = new MyMetaHoliday_Name();
    public final MyMetaHoliday_Uid Uid = new MyMetaHoliday_Uid();
    public final MyMetaHoliday_UpdatedUtcTs UpdatedUtcTs = new MyMetaHoliday_UpdatedUtcTs();
    public final MyMetaHoliday_LockVersion LockVersion = new MyMetaHoliday_LockVersion();
    public final MyMetaHoliday_CreatedLocalTs CreatedLocalTs = new MyMetaHoliday_CreatedLocalTs();
    public final MyMetaHoliday_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaHoliday_CreatedLocalTsMessage();
    public final MyMetaHoliday_CreatedLocalDate CreatedLocalDate = new MyMetaHoliday_CreatedLocalDate();
    public final MyMetaHoliday_CreatedLocalTime CreatedLocalTime = new MyMetaHoliday_CreatedLocalTime();
    public final MyMetaHoliday_UpdatedLocalTs UpdatedLocalTs = new MyMetaHoliday_UpdatedLocalTs();
    public final MyMetaHoliday_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaHoliday_UpdatedLocalTsMessage();
    public final MyMetaHoliday_UpdatedLocalDate UpdatedLocalDate = new MyMetaHoliday_UpdatedLocalDate();
    public final MyMetaHoliday_UpdatedLocalTime UpdatedLocalTime = new MyMetaHoliday_UpdatedLocalTime();
    public final MyMetaHoliday_CreatedByFullName CreatedByFullName = new MyMetaHoliday_CreatedByFullName();
    public final MyMetaHoliday_UpdatedByFullName UpdatedByFullName = new MyMetaHoliday_UpdatedByFullName();

    //##################################################
    //# associations
    //##################################################

    public final MyMetaHoliday_CreatedBy CreatedBy = new MyMetaHoliday_CreatedBy();
    public final MyMetaHoliday_Project Project = new MyMetaHoliday_Project();
    public final MyMetaHoliday_UpdatedBy UpdatedBy = new MyMetaHoliday_UpdatedBy();

    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaHoliday_AuditLogTitle
        extends KmMetaStringProperty<MyHoliday>
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
        public String getValueFor(MyHoliday model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyHoliday model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaHoliday_CreatedUtcTs
        extends KmMetaTimestampProperty<MyHoliday>
        implements KmMetaDaoPropertyIF<MyHoliday,KmTimestamp>
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
            return MyHolidayValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MyHolidayDao getDao()
        {
            return getAccess().getHolidayDao();
        }

        @Override
        public KmTimestamp getValueFor(MyHoliday model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MyHoliday model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyHoliday model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# Day
    //##################################################

    public class MyMetaHoliday_Day
        extends KmMetaDateProperty<MyHoliday>
        implements KmMetaDaoPropertyIF<MyHoliday,KmDate>
    {
        @Override
        public String getName()
        {
            return "day";
        }

        @Override
        public String getLabel()
        {
            return "Day";
        }

        @Override
        public String getHelp()
        {
            return "The date of the holiday.";
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
            return MyHolidayValidator.instance.getDayValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "day";
        }

        @Override
        public MyHolidayDao getDao()
        {
            return getAccess().getHolidayDao();
        }

        @Override
        public KmDate getValueFor(MyHoliday model)
        {
            return model.getDay();
        }

        @Override
        public void setValueFor(MyHoliday model, KmDate value)
        {
            model.setDay(value);
        }

        @Override
        public boolean hasValueFor(MyHoliday model, KmDate value)
        {
            return model.hasDay(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaHoliday_DomainSubtitle
        extends KmMetaStringProperty<MyHoliday>
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
        public String getValueFor(MyHoliday model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyHoliday model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaHoliday_DomainTitle
        extends KmMetaStringProperty<MyHoliday>
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
        public String getValueFor(MyHoliday model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyHoliday model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# Name
    //##################################################

    public class MyMetaHoliday_Name
        extends KmMetaStringProperty<MyHoliday>
        implements KmMetaDaoPropertyIF<MyHoliday,String>
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
            return "The display name. This should be unique within a project.";
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
            return MyHolidayValidator.instance.getNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "name";
        }

        @Override
        public MyHolidayDao getDao()
        {
            return getAccess().getHolidayDao();
        }

        @Override
        public String getValueFor(MyHoliday model)
        {
            return model.getName();
        }

        @Override
        public void setValueFor(MyHoliday model, String value)
        {
            model.setName(value);
        }

        @Override
        public boolean hasValueFor(MyHoliday model, String value)
        {
            return model.hasName(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaHoliday_Uid
        extends KmMetaStringProperty<MyHoliday>
        implements KmMetaDaoPropertyIF<MyHoliday,String>
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
            return MyHolidayValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyHolidayDao getDao()
        {
            return getAccess().getHolidayDao();
        }

        public KmDaoStringKeyCursor<MyHoliday> createCursor()
        {
            KmDaoStringKeyCursor<MyHoliday> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyHoliday model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyHoliday model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyHoliday model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# UpdatedUtcTs
    //##################################################

    public class MyMetaHoliday_UpdatedUtcTs
        extends KmMetaTimestampProperty<MyHoliday>
        implements KmMetaDaoPropertyIF<MyHoliday,KmTimestamp>
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
            return MyHolidayValidator.instance.getUpdatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "updatedUtcTs";
        }

        @Override
        public MyHolidayDao getDao()
        {
            return getAccess().getHolidayDao();
        }

        @Override
        public KmTimestamp getValueFor(MyHoliday model)
        {
            return model.getUpdatedUtcTs();
        }

        @Override
        public void setValueFor(MyHoliday model, KmTimestamp value)
        {
            model.setUpdatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyHoliday model, KmTimestamp value)
        {
            return model.hasUpdatedUtcTs(value);
        }
    }

    //##################################################
    //# LockVersion
    //##################################################

    public class MyMetaHoliday_LockVersion
        extends KmMetaIntegerProperty<MyHoliday>
        implements KmMetaDaoPropertyIF<MyHoliday,Integer>
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
            return MyHolidayValidator.instance.getLockVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lockVersion";
        }

        @Override
        public MyHolidayDao getDao()
        {
            return getAccess().getHolidayDao();
        }

        @Override
        public Integer getValueFor(MyHoliday model)
        {
            return model.getLockVersion();
        }

        @Override
        public void setValueFor(MyHoliday model, Integer value)
        {
            model.setLockVersion(value);
        }

        @Override
        public boolean hasValueFor(MyHoliday model, Integer value)
        {
            return model.hasLockVersion(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaHoliday_CreatedLocalTs
        extends KmMetaTimestampProperty<MyHoliday>
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
        public KmTimestamp getValueFor(MyHoliday model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyHoliday model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaHoliday_CreatedLocalTsMessage
        extends KmMetaStringProperty<MyHoliday>
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
        public String getValueFor(MyHoliday model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyHoliday model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaHoliday_CreatedLocalDate
        extends KmMetaDateProperty<MyHoliday>
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
        public KmDate getValueFor(MyHoliday model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyHoliday model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaHoliday_CreatedLocalTime
        extends KmMetaTimeProperty<MyHoliday>
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
        public KmTime getValueFor(MyHoliday model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyHoliday model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }

    //##################################################
    //# UpdatedLocalTs
    //##################################################

    public class MyMetaHoliday_UpdatedLocalTs
        extends KmMetaTimestampProperty<MyHoliday>
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
        public KmTimestamp getValueFor(MyHoliday model)
        {
            return model.getUpdatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyHoliday model, KmTimestamp value)
        {
            return model.hasUpdatedLocalTs(value);
        }
    }

    //##################################################
    //# UpdatedLocalTsMessage
    //##################################################

    public class MyMetaHoliday_UpdatedLocalTsMessage
        extends KmMetaStringProperty<MyHoliday>
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
        public String getValueFor(MyHoliday model)
        {
            return model.getUpdatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyHoliday model, String value)
        {
            return model.hasUpdatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# UpdatedLocalDate
    //##################################################

    public class MyMetaHoliday_UpdatedLocalDate
        extends KmMetaDateProperty<MyHoliday>
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
        public KmDate getValueFor(MyHoliday model)
        {
            return model.getUpdatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyHoliday model, KmDate value)
        {
            return model.hasUpdatedLocalDate(value);
        }
    }

    //##################################################
    //# UpdatedLocalTime
    //##################################################

    public class MyMetaHoliday_UpdatedLocalTime
        extends KmMetaTimeProperty<MyHoliday>
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
        public KmTime getValueFor(MyHoliday model)
        {
            return model.getUpdatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyHoliday model, KmTime value)
        {
            return model.hasUpdatedLocalTime(value);
        }
    }

    //##################################################
    //# CreatedByFullName
    //##################################################

    public class MyMetaHoliday_CreatedByFullName
        extends KmMetaStringProperty<MyHoliday>
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
        public String getValueFor(MyHoliday model)
        {
            return model.getCreatedByFullName();
        }

        @Override
        public void setValueFor(MyHoliday model, String value)
        {
            model.setCreatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyHoliday model, String value)
        {
            return model.hasCreatedByFullName(value);
        }
    }

    //##################################################
    //# UpdatedByFullName
    //##################################################

    public class MyMetaHoliday_UpdatedByFullName
        extends KmMetaStringProperty<MyHoliday>
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
        public String getValueFor(MyHoliday model)
        {
            return model.getUpdatedByFullName();
        }

        @Override
        public void setValueFor(MyHoliday model, String value)
        {
            model.setUpdatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyHoliday model, String value)
        {
            return model.hasUpdatedByFullName(value);
        }
    }


    //##################################################
    //# CreatedBy
    //##################################################

    public class MyMetaHoliday_CreatedBy
        extends KmMetaDaoAssociation<MyHoliday,MyUser>
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
        public MyUser getValueFor(MyHoliday model)
        {
            return model.getCreatedBy();
        }

        @Override
        public void setValueFor(MyHoliday model, MyUser value)
        {
            model.setCreatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyHoliday model, MyUser value)
        {
            return model.hasCreatedBy(value);
        }
    }

    //##################################################
    //# Project
    //##################################################

    public class MyMetaHoliday_Project
        extends KmMetaDaoAssociation<MyHoliday,MyProject>
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
            return "The project that defines this holiday.";
        }

        @Override
        public boolean isRequired()
        {
            return true;
        }

        @Override
        public MyProject getValueFor(MyHoliday model)
        {
            return model.getProject();
        }

        @Override
        public void setValueFor(MyHoliday model, MyProject value)
        {
            model.setProject(value);
        }

        @Override
        public boolean hasValueFor(MyHoliday model, MyProject value)
        {
            return model.hasProject(value);
        }
    }

    //##################################################
    //# UpdatedBy
    //##################################################

    public class MyMetaHoliday_UpdatedBy
        extends KmMetaDaoAssociation<MyHoliday,MyUser>
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
        public MyUser getValueFor(MyHoliday model)
        {
            return model.getUpdatedBy();
        }

        @Override
        public void setValueFor(MyHoliday model, MyUser value)
        {
            model.setUpdatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyHoliday model, MyUser value)
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
