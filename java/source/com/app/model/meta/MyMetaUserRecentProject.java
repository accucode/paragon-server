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

public class MyMetaUserRecentProject
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaUserRecentProject instance = new MyMetaUserRecentProject();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaUserRecentProject()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "userRecentProject";
    }

    public MyUserRecentProjectValidator getValidator()
    {
        return MyUserRecentProjectValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "A record of projects recently used by a given user.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaUserRecentProject_AuditLogTitle AuditLogTitle = new MyMetaUserRecentProject_AuditLogTitle();
    public final MyMetaUserRecentProject_CreatedUtcTs CreatedUtcTs = new MyMetaUserRecentProject_CreatedUtcTs();
    public final MyMetaUserRecentProject_DomainSubtitle DomainSubtitle = new MyMetaUserRecentProject_DomainSubtitle();
    public final MyMetaUserRecentProject_DomainTitle DomainTitle = new MyMetaUserRecentProject_DomainTitle();
    public final MyMetaUserRecentProject_Uid Uid = new MyMetaUserRecentProject_Uid();
    public final MyMetaUserRecentProject_UpdatedUtcTs UpdatedUtcTs = new MyMetaUserRecentProject_UpdatedUtcTs();
    public final MyMetaUserRecentProject_LockVersion LockVersion = new MyMetaUserRecentProject_LockVersion();
    public final MyMetaUserRecentProject_CreatedLocalTs CreatedLocalTs = new MyMetaUserRecentProject_CreatedLocalTs();
    public final MyMetaUserRecentProject_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaUserRecentProject_CreatedLocalTsMessage();
    public final MyMetaUserRecentProject_CreatedLocalDate CreatedLocalDate = new MyMetaUserRecentProject_CreatedLocalDate();
    public final MyMetaUserRecentProject_CreatedLocalTime CreatedLocalTime = new MyMetaUserRecentProject_CreatedLocalTime();
    public final MyMetaUserRecentProject_UpdatedLocalTs UpdatedLocalTs = new MyMetaUserRecentProject_UpdatedLocalTs();
    public final MyMetaUserRecentProject_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaUserRecentProject_UpdatedLocalTsMessage();
    public final MyMetaUserRecentProject_UpdatedLocalDate UpdatedLocalDate = new MyMetaUserRecentProject_UpdatedLocalDate();
    public final MyMetaUserRecentProject_UpdatedLocalTime UpdatedLocalTime = new MyMetaUserRecentProject_UpdatedLocalTime();
    public final MyMetaUserRecentProject_CreatedByFullName CreatedByFullName = new MyMetaUserRecentProject_CreatedByFullName();
    public final MyMetaUserRecentProject_UpdatedByFullName UpdatedByFullName = new MyMetaUserRecentProject_UpdatedByFullName();

    //##################################################
    //# associations
    //##################################################

    public final MyMetaUserRecentProject_CreatedBy CreatedBy = new MyMetaUserRecentProject_CreatedBy();
    public final MyMetaUserRecentProject_Project Project = new MyMetaUserRecentProject_Project();
    public final MyMetaUserRecentProject_UpdatedBy UpdatedBy = new MyMetaUserRecentProject_UpdatedBy();
    public final MyMetaUserRecentProject_User User = new MyMetaUserRecentProject_User();

    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaUserRecentProject_AuditLogTitle
        extends KmMetaStringProperty<MyUserRecentProject>
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
        public String getValueFor(MyUserRecentProject model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyUserRecentProject model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaUserRecentProject_CreatedUtcTs
        extends KmMetaTimestampProperty<MyUserRecentProject>
        implements KmMetaDaoPropertyIF<MyUserRecentProject,KmTimestamp>
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
            return MyUserRecentProjectValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MyUserRecentProjectDao getDao()
        {
            return getAccess().getUserRecentProjectDao();
        }

        @Override
        public KmTimestamp getValueFor(MyUserRecentProject model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MyUserRecentProject model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyUserRecentProject model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaUserRecentProject_DomainSubtitle
        extends KmMetaStringProperty<MyUserRecentProject>
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
        public String getValueFor(MyUserRecentProject model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyUserRecentProject model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaUserRecentProject_DomainTitle
        extends KmMetaStringProperty<MyUserRecentProject>
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
        public String getValueFor(MyUserRecentProject model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyUserRecentProject model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaUserRecentProject_Uid
        extends KmMetaStringProperty<MyUserRecentProject>
        implements KmMetaDaoPropertyIF<MyUserRecentProject,String>
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
            return MyUserRecentProjectValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyUserRecentProjectDao getDao()
        {
            return getAccess().getUserRecentProjectDao();
        }

        public KmDaoStringKeyCursor<MyUserRecentProject> createCursor()
        {
            KmDaoStringKeyCursor<MyUserRecentProject> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyUserRecentProject model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyUserRecentProject model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyUserRecentProject model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# UpdatedUtcTs
    //##################################################

    public class MyMetaUserRecentProject_UpdatedUtcTs
        extends KmMetaTimestampProperty<MyUserRecentProject>
        implements KmMetaDaoPropertyIF<MyUserRecentProject,KmTimestamp>
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
            return MyUserRecentProjectValidator.instance.getUpdatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "updatedUtcTs";
        }

        @Override
        public MyUserRecentProjectDao getDao()
        {
            return getAccess().getUserRecentProjectDao();
        }

        @Override
        public KmTimestamp getValueFor(MyUserRecentProject model)
        {
            return model.getUpdatedUtcTs();
        }

        @Override
        public void setValueFor(MyUserRecentProject model, KmTimestamp value)
        {
            model.setUpdatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyUserRecentProject model, KmTimestamp value)
        {
            return model.hasUpdatedUtcTs(value);
        }
    }

    //##################################################
    //# LockVersion
    //##################################################

    public class MyMetaUserRecentProject_LockVersion
        extends KmMetaIntegerProperty<MyUserRecentProject>
        implements KmMetaDaoPropertyIF<MyUserRecentProject,Integer>
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
            return MyUserRecentProjectValidator.instance.getLockVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lockVersion";
        }

        @Override
        public MyUserRecentProjectDao getDao()
        {
            return getAccess().getUserRecentProjectDao();
        }

        @Override
        public Integer getValueFor(MyUserRecentProject model)
        {
            return model.getLockVersion();
        }

        @Override
        public void setValueFor(MyUserRecentProject model, Integer value)
        {
            model.setLockVersion(value);
        }

        @Override
        public boolean hasValueFor(MyUserRecentProject model, Integer value)
        {
            return model.hasLockVersion(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaUserRecentProject_CreatedLocalTs
        extends KmMetaTimestampProperty<MyUserRecentProject>
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
        public KmTimestamp getValueFor(MyUserRecentProject model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyUserRecentProject model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaUserRecentProject_CreatedLocalTsMessage
        extends KmMetaStringProperty<MyUserRecentProject>
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
        public String getValueFor(MyUserRecentProject model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyUserRecentProject model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaUserRecentProject_CreatedLocalDate
        extends KmMetaDateProperty<MyUserRecentProject>
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
        public KmDate getValueFor(MyUserRecentProject model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyUserRecentProject model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaUserRecentProject_CreatedLocalTime
        extends KmMetaTimeProperty<MyUserRecentProject>
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
        public KmTime getValueFor(MyUserRecentProject model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyUserRecentProject model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }

    //##################################################
    //# UpdatedLocalTs
    //##################################################

    public class MyMetaUserRecentProject_UpdatedLocalTs
        extends KmMetaTimestampProperty<MyUserRecentProject>
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
        public KmTimestamp getValueFor(MyUserRecentProject model)
        {
            return model.getUpdatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyUserRecentProject model, KmTimestamp value)
        {
            return model.hasUpdatedLocalTs(value);
        }
    }

    //##################################################
    //# UpdatedLocalTsMessage
    //##################################################

    public class MyMetaUserRecentProject_UpdatedLocalTsMessage
        extends KmMetaStringProperty<MyUserRecentProject>
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
        public String getValueFor(MyUserRecentProject model)
        {
            return model.getUpdatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyUserRecentProject model, String value)
        {
            return model.hasUpdatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# UpdatedLocalDate
    //##################################################

    public class MyMetaUserRecentProject_UpdatedLocalDate
        extends KmMetaDateProperty<MyUserRecentProject>
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
        public KmDate getValueFor(MyUserRecentProject model)
        {
            return model.getUpdatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyUserRecentProject model, KmDate value)
        {
            return model.hasUpdatedLocalDate(value);
        }
    }

    //##################################################
    //# UpdatedLocalTime
    //##################################################

    public class MyMetaUserRecentProject_UpdatedLocalTime
        extends KmMetaTimeProperty<MyUserRecentProject>
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
        public KmTime getValueFor(MyUserRecentProject model)
        {
            return model.getUpdatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyUserRecentProject model, KmTime value)
        {
            return model.hasUpdatedLocalTime(value);
        }
    }

    //##################################################
    //# CreatedByFullName
    //##################################################

    public class MyMetaUserRecentProject_CreatedByFullName
        extends KmMetaStringProperty<MyUserRecentProject>
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
        public String getValueFor(MyUserRecentProject model)
        {
            return model.getCreatedByFullName();
        }

        @Override
        public void setValueFor(MyUserRecentProject model, String value)
        {
            model.setCreatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyUserRecentProject model, String value)
        {
            return model.hasCreatedByFullName(value);
        }
    }

    //##################################################
    //# UpdatedByFullName
    //##################################################

    public class MyMetaUserRecentProject_UpdatedByFullName
        extends KmMetaStringProperty<MyUserRecentProject>
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
        public String getValueFor(MyUserRecentProject model)
        {
            return model.getUpdatedByFullName();
        }

        @Override
        public void setValueFor(MyUserRecentProject model, String value)
        {
            model.setUpdatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyUserRecentProject model, String value)
        {
            return model.hasUpdatedByFullName(value);
        }
    }


    //##################################################
    //# CreatedBy
    //##################################################

    public class MyMetaUserRecentProject_CreatedBy
        extends KmMetaDaoAssociation<MyUserRecentProject,MyUser>
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
        public MyUser getValueFor(MyUserRecentProject model)
        {
            return model.getCreatedBy();
        }

        @Override
        public void setValueFor(MyUserRecentProject model, MyUser value)
        {
            model.setCreatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyUserRecentProject model, MyUser value)
        {
            return model.hasCreatedBy(value);
        }
    }

    //##################################################
    //# Project
    //##################################################

    public class MyMetaUserRecentProject_Project
        extends KmMetaDaoAssociation<MyUserRecentProject,MyProject>
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
            return "The project to which this member belongs.";
        }

        @Override
        public boolean isRequired()
        {
            return true;
        }

        @Override
        public MyProject getValueFor(MyUserRecentProject model)
        {
            return model.getProject();
        }

        @Override
        public void setValueFor(MyUserRecentProject model, MyProject value)
        {
            model.setProject(value);
        }

        @Override
        public boolean hasValueFor(MyUserRecentProject model, MyProject value)
        {
            return model.hasProject(value);
        }
    }

    //##################################################
    //# UpdatedBy
    //##################################################

    public class MyMetaUserRecentProject_UpdatedBy
        extends KmMetaDaoAssociation<MyUserRecentProject,MyUser>
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
        public MyUser getValueFor(MyUserRecentProject model)
        {
            return model.getUpdatedBy();
        }

        @Override
        public void setValueFor(MyUserRecentProject model, MyUser value)
        {
            model.setUpdatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyUserRecentProject model, MyUser value)
        {
            return model.hasUpdatedBy(value);
        }
    }

    //##################################################
    //# User
    //##################################################

    public class MyMetaUserRecentProject_User
        extends KmMetaDaoAssociation<MyUserRecentProject,MyUser>
    {
        @Override
        public String getName()
        {
            return "user";
        }

        @Override
        public String getLabel()
        {
            return "User";
        }

        @Override
        public String getHelp()
        {
            return "The user being granted access.";
        }

        @Override
        public boolean isRequired()
        {
            return true;
        }

        @Override
        public MyUser getValueFor(MyUserRecentProject model)
        {
            return model.getUser();
        }

        @Override
        public void setValueFor(MyUserRecentProject model, MyUser value)
        {
            model.setUser(value);
        }

        @Override
        public boolean hasValueFor(MyUserRecentProject model, MyUser value)
        {
            return model.hasUser(value);
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
