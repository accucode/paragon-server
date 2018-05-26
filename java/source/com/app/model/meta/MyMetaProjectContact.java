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

public class MyMetaProjectContact
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaProjectContact instance = new MyMetaProjectContact();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaProjectContact()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "projectContact";
    }

    public MyProjectContactValidator getValidator()
    {
        return MyProjectContactValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "The contacts associated with a particular project.  These contacts are primarily used to keep management informed and/or to cc all outbound email to a shared account.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaProjectContact_AuditLogTitle AuditLogTitle = new MyMetaProjectContact_AuditLogTitle();
    public final MyMetaProjectContact_CreatedUtcTs CreatedUtcTs = new MyMetaProjectContact_CreatedUtcTs();
    public final MyMetaProjectContact_DomainSubtitle DomainSubtitle = new MyMetaProjectContact_DomainSubtitle();
    public final MyMetaProjectContact_DomainTitle DomainTitle = new MyMetaProjectContact_DomainTitle();
    public final MyMetaProjectContact_Email Email = new MyMetaProjectContact_Email();
    public final MyMetaProjectContact_FirstName FirstName = new MyMetaProjectContact_FirstName();
    public final MyMetaProjectContact_FormalName FormalName = new MyMetaProjectContact_FormalName();
    public final MyMetaProjectContact_FullName FullName = new MyMetaProjectContact_FullName();
    public final MyMetaProjectContact_LastName LastName = new MyMetaProjectContact_LastName();
    public final MyMetaProjectContact_LongName LongName = new MyMetaProjectContact_LongName();
    public final MyMetaProjectContact_Nickname Nickname = new MyMetaProjectContact_Nickname();
    public final MyMetaProjectContact_Phone Phone = new MyMetaProjectContact_Phone();
    public final MyMetaProjectContact_ShortName ShortName = new MyMetaProjectContact_ShortName();
    public final MyMetaProjectContact_Title Title = new MyMetaProjectContact_Title();
    public final MyMetaProjectContact_Uid Uid = new MyMetaProjectContact_Uid();
    public final MyMetaProjectContact_UpdatedUtcTs UpdatedUtcTs = new MyMetaProjectContact_UpdatedUtcTs();
    public final MyMetaProjectContact_LockVersion LockVersion = new MyMetaProjectContact_LockVersion();
    public final MyMetaProjectContact_CreatedLocalTs CreatedLocalTs = new MyMetaProjectContact_CreatedLocalTs();
    public final MyMetaProjectContact_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaProjectContact_CreatedLocalTsMessage();
    public final MyMetaProjectContact_CreatedLocalDate CreatedLocalDate = new MyMetaProjectContact_CreatedLocalDate();
    public final MyMetaProjectContact_CreatedLocalTime CreatedLocalTime = new MyMetaProjectContact_CreatedLocalTime();
    public final MyMetaProjectContact_UpdatedLocalTs UpdatedLocalTs = new MyMetaProjectContact_UpdatedLocalTs();
    public final MyMetaProjectContact_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaProjectContact_UpdatedLocalTsMessage();
    public final MyMetaProjectContact_UpdatedLocalDate UpdatedLocalDate = new MyMetaProjectContact_UpdatedLocalDate();
    public final MyMetaProjectContact_UpdatedLocalTime UpdatedLocalTime = new MyMetaProjectContact_UpdatedLocalTime();
    public final MyMetaProjectContact_CreatedByFullName CreatedByFullName = new MyMetaProjectContact_CreatedByFullName();
    public final MyMetaProjectContact_UpdatedByFullName UpdatedByFullName = new MyMetaProjectContact_UpdatedByFullName();

    //##################################################
    //# associations
    //##################################################

    public final MyMetaProjectContact_CreatedBy CreatedBy = new MyMetaProjectContact_CreatedBy();
    public final MyMetaProjectContact_Project Project = new MyMetaProjectContact_Project();
    public final MyMetaProjectContact_UpdatedBy UpdatedBy = new MyMetaProjectContact_UpdatedBy();

    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaProjectContact_AuditLogTitle
        extends KmMetaStringProperty<MyProjectContact>
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
        public String getValueFor(MyProjectContact model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyProjectContact model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaProjectContact_CreatedUtcTs
        extends KmMetaTimestampProperty<MyProjectContact>
        implements KmMetaDaoPropertyIF<MyProjectContact,KmTimestamp>
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
            return MyProjectContactValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MyProjectContactDao getDao()
        {
            return getAccess().getProjectContactDao();
        }

        @Override
        public KmTimestamp getValueFor(MyProjectContact model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MyProjectContact model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyProjectContact model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaProjectContact_DomainSubtitle
        extends KmMetaStringProperty<MyProjectContact>
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
        public String getValueFor(MyProjectContact model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyProjectContact model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaProjectContact_DomainTitle
        extends KmMetaStringProperty<MyProjectContact>
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
        public String getValueFor(MyProjectContact model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyProjectContact model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# Email
    //##################################################

    public class MyMetaProjectContact_Email
        extends KmMetaStringProperty<MyProjectContact>
        implements KmMetaDaoPropertyIF<MyProjectContact,String>
    {
        @Override
        public String getName()
        {
            return "email";
        }

        @Override
        public String getLabel()
        {
            return "Email";
        }

        @Override
        public String getHelp()
        {
            return "The person's email address.  E.g.: john.doe@example.net.";
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
            return MyProjectContactValidator.instance.getEmailValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "email";
        }

        @Override
        public MyProjectContactDao getDao()
        {
            return getAccess().getProjectContactDao();
        }

        @Override
        public String getValueFor(MyProjectContact model)
        {
            return model.getEmail();
        }

        @Override
        public void setValueFor(MyProjectContact model, String value)
        {
            model.setEmail(value);
        }

        @Override
        public boolean hasValueFor(MyProjectContact model, String value)
        {
            return model.hasEmail(value);
        }
    }

    //##################################################
    //# FirstName
    //##################################################

    public class MyMetaProjectContact_FirstName
        extends KmMetaStringProperty<MyProjectContact>
        implements KmMetaDaoPropertyIF<MyProjectContact,String>
    {
        @Override
        public String getName()
        {
            return "firstName";
        }

        @Override
        public String getLabel()
        {
            return "First Name";
        }

        @Override
        public String getHelp()
        {
            return "The user's first name; e.g.: John, Jane. This may be blank.";
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
            return MyProjectContactValidator.instance.getFirstNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "firstName";
        }

        @Override
        public MyProjectContactDao getDao()
        {
            return getAccess().getProjectContactDao();
        }

        @Override
        public String getValueFor(MyProjectContact model)
        {
            return model.getFirstName();
        }

        @Override
        public void setValueFor(MyProjectContact model, String value)
        {
            model.setFirstName(value);
        }

        @Override
        public boolean hasValueFor(MyProjectContact model, String value)
        {
            return model.hasFirstName(value);
        }
    }

    //##################################################
    //# FormalName
    //##################################################

    public class MyMetaProjectContact_FormalName
        extends KmMetaStringProperty<MyProjectContact>
    {
        @Override
        public String getName()
        {
            return "formalName";
        }

        @Override
        public String getLabel()
        {
            return "Name";
        }

        @Override
        public String getHelp()
        {
            return "The first and last name together; e.g.: Smith, John. Use the nickname if the first and last names are both empty. This should never be blank.";
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
        public String getValueFor(MyProjectContact model)
        {
            return model.getFormalName();
        }

        @Override
        public boolean hasValueFor(MyProjectContact model, String value)
        {
            return model.hasFormalName(value);
        }
    }

    //##################################################
    //# FullName
    //##################################################

    public class MyMetaProjectContact_FullName
        extends KmMetaStringProperty<MyProjectContact>
        implements KmMetaDaoPropertyIF<MyProjectContact,String>
    {
        @Override
        public String getName()
        {
            return "fullName";
        }

        @Override
        public String getLabel()
        {
            return "Name";
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
        public KmStringValidator getValidator()
        {
            return MyProjectContactValidator.instance.getFullNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "fullName";
        }

        @Override
        public MyProjectContactDao getDao()
        {
            return getAccess().getProjectContactDao();
        }

        @Override
        public String getValueFor(MyProjectContact model)
        {
            return model.getFullName();
        }

        @Override
        public void setValueFor(MyProjectContact model, String value)
        {
            model.setFullName(value);
        }

        @Override
        public boolean hasValueFor(MyProjectContact model, String value)
        {
            return model.hasFullName(value);
        }
    }

    //##################################################
    //# LastName
    //##################################################

    public class MyMetaProjectContact_LastName
        extends KmMetaStringProperty<MyProjectContact>
        implements KmMetaDaoPropertyIF<MyProjectContact,String>
    {
        @Override
        public String getName()
        {
            return "lastName";
        }

        @Override
        public String getLabel()
        {
            return "Last Name";
        }

        @Override
        public String getHelp()
        {
            return "The user's last name; e.g.: Smith, Jones. This may be blank.";
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
            return MyProjectContactValidator.instance.getLastNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lastName";
        }

        @Override
        public MyProjectContactDao getDao()
        {
            return getAccess().getProjectContactDao();
        }

        @Override
        public String getValueFor(MyProjectContact model)
        {
            return model.getLastName();
        }

        @Override
        public void setValueFor(MyProjectContact model, String value)
        {
            model.setLastName(value);
        }

        @Override
        public boolean hasValueFor(MyProjectContact model, String value)
        {
            return model.hasLastName(value);
        }
    }

    //##################################################
    //# LongName
    //##################################################

    public class MyMetaProjectContact_LongName
        extends KmMetaStringProperty<MyProjectContact>
    {
        @Override
        public String getName()
        {
            return "longName";
        }

        @Override
        public String getLabel()
        {
            return "Name";
        }

        @Override
        public String getHelp()
        {
            return "Return the first name, last name, and nick name, formatted for display on screen. This should never be blank.";
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
        public String getValueFor(MyProjectContact model)
        {
            return model.getLongName();
        }

        @Override
        public boolean hasValueFor(MyProjectContact model, String value)
        {
            return model.hasLongName(value);
        }
    }

    //##################################################
    //# Nickname
    //##################################################

    public class MyMetaProjectContact_Nickname
        extends KmMetaStringProperty<MyProjectContact>
        implements KmMetaDaoPropertyIF<MyProjectContact,String>
    {
        @Override
        public String getName()
        {
            return "nickname";
        }

        @Override
        public String getLabel()
        {
            return "Nickname";
        }

        @Override
        public String getHelp()
        {
            return "The user's short nickname, for informal use. This may be blank.";
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
            return MyProjectContactValidator.instance.getNicknameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "nickname";
        }

        @Override
        public MyProjectContactDao getDao()
        {
            return getAccess().getProjectContactDao();
        }

        @Override
        public String getValueFor(MyProjectContact model)
        {
            return model.getNickname();
        }

        @Override
        public void setValueFor(MyProjectContact model, String value)
        {
            model.setNickname(value);
        }

        @Override
        public boolean hasValueFor(MyProjectContact model, String value)
        {
            return model.hasNickname(value);
        }
    }

    //##################################################
    //# Phone
    //##################################################

    public class MyMetaProjectContact_Phone
        extends KmMetaStringProperty<MyProjectContact>
        implements KmMetaDaoPropertyIF<MyProjectContact,String>
    {
        @Override
        public String getName()
        {
            return "phone";
        }

        @Override
        public String getLabel()
        {
            return "Phone";
        }

        @Override
        public String getHelp()
        {
            return "The person's phone number.  E.g.: 303.555.1234.";
        }

        @Override
        public int getColumnWidth()
        {
            return 12;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyProjectContactValidator.instance.getPhoneValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "phone";
        }

        @Override
        public MyProjectContactDao getDao()
        {
            return getAccess().getProjectContactDao();
        }

        @Override
        public String getValueFor(MyProjectContact model)
        {
            return model.getPhone();
        }

        @Override
        public void setValueFor(MyProjectContact model, String value)
        {
            model.setPhone(value);
        }

        @Override
        public boolean hasValueFor(MyProjectContact model, String value)
        {
            return model.hasPhone(value);
        }
    }

    //##################################################
    //# ShortName
    //##################################################

    public class MyMetaProjectContact_ShortName
        extends KmMetaStringProperty<MyProjectContact>
    {
        @Override
        public String getName()
        {
            return "shortName";
        }

        @Override
        public String getLabel()
        {
            return "Name";
        }

        @Override
        public String getHelp()
        {
            return "Return a single name, preferably the nickname or first name. This should never be blank.";
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
        public String getValueFor(MyProjectContact model)
        {
            return model.getShortName();
        }

        @Override
        public boolean hasValueFor(MyProjectContact model, String value)
        {
            return model.hasShortName(value);
        }
    }

    //##################################################
    //# Title
    //##################################################

    public class MyMetaProjectContact_Title
        extends KmMetaStringProperty<MyProjectContact>
        implements KmMetaDaoPropertyIF<MyProjectContact,String>
    {
        @Override
        public String getName()
        {
            return "title";
        }

        @Override
        public String getLabel()
        {
            return "Title";
        }

        @Override
        public String getHelp()
        {
            return "The person's business title.  E.g.: Director of Sales.";
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
            return MyProjectContactValidator.instance.getTitleValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "title";
        }

        @Override
        public MyProjectContactDao getDao()
        {
            return getAccess().getProjectContactDao();
        }

        @Override
        public String getValueFor(MyProjectContact model)
        {
            return model.getTitle();
        }

        @Override
        public void setValueFor(MyProjectContact model, String value)
        {
            model.setTitle(value);
        }

        @Override
        public boolean hasValueFor(MyProjectContact model, String value)
        {
            return model.hasTitle(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaProjectContact_Uid
        extends KmMetaStringProperty<MyProjectContact>
        implements KmMetaDaoPropertyIF<MyProjectContact,String>
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
            return MyProjectContactValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyProjectContactDao getDao()
        {
            return getAccess().getProjectContactDao();
        }

        public KmDaoStringKeyCursor<MyProjectContact> createCursor()
        {
            KmDaoStringKeyCursor<MyProjectContact> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyProjectContact model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyProjectContact model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyProjectContact model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# UpdatedUtcTs
    //##################################################

    public class MyMetaProjectContact_UpdatedUtcTs
        extends KmMetaTimestampProperty<MyProjectContact>
        implements KmMetaDaoPropertyIF<MyProjectContact,KmTimestamp>
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
            return MyProjectContactValidator.instance.getUpdatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "updatedUtcTs";
        }

        @Override
        public MyProjectContactDao getDao()
        {
            return getAccess().getProjectContactDao();
        }

        @Override
        public KmTimestamp getValueFor(MyProjectContact model)
        {
            return model.getUpdatedUtcTs();
        }

        @Override
        public void setValueFor(MyProjectContact model, KmTimestamp value)
        {
            model.setUpdatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyProjectContact model, KmTimestamp value)
        {
            return model.hasUpdatedUtcTs(value);
        }
    }

    //##################################################
    //# LockVersion
    //##################################################

    public class MyMetaProjectContact_LockVersion
        extends KmMetaIntegerProperty<MyProjectContact>
        implements KmMetaDaoPropertyIF<MyProjectContact,Integer>
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
            return MyProjectContactValidator.instance.getLockVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lockVersion";
        }

        @Override
        public MyProjectContactDao getDao()
        {
            return getAccess().getProjectContactDao();
        }

        @Override
        public Integer getValueFor(MyProjectContact model)
        {
            return model.getLockVersion();
        }

        @Override
        public void setValueFor(MyProjectContact model, Integer value)
        {
            model.setLockVersion(value);
        }

        @Override
        public boolean hasValueFor(MyProjectContact model, Integer value)
        {
            return model.hasLockVersion(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaProjectContact_CreatedLocalTs
        extends KmMetaTimestampProperty<MyProjectContact>
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
        public KmTimestamp getValueFor(MyProjectContact model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyProjectContact model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaProjectContact_CreatedLocalTsMessage
        extends KmMetaStringProperty<MyProjectContact>
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
        public String getValueFor(MyProjectContact model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyProjectContact model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaProjectContact_CreatedLocalDate
        extends KmMetaDateProperty<MyProjectContact>
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
        public KmDate getValueFor(MyProjectContact model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyProjectContact model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaProjectContact_CreatedLocalTime
        extends KmMetaTimeProperty<MyProjectContact>
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
        public KmTime getValueFor(MyProjectContact model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyProjectContact model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }

    //##################################################
    //# UpdatedLocalTs
    //##################################################

    public class MyMetaProjectContact_UpdatedLocalTs
        extends KmMetaTimestampProperty<MyProjectContact>
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
        public KmTimestamp getValueFor(MyProjectContact model)
        {
            return model.getUpdatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyProjectContact model, KmTimestamp value)
        {
            return model.hasUpdatedLocalTs(value);
        }
    }

    //##################################################
    //# UpdatedLocalTsMessage
    //##################################################

    public class MyMetaProjectContact_UpdatedLocalTsMessage
        extends KmMetaStringProperty<MyProjectContact>
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
        public String getValueFor(MyProjectContact model)
        {
            return model.getUpdatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyProjectContact model, String value)
        {
            return model.hasUpdatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# UpdatedLocalDate
    //##################################################

    public class MyMetaProjectContact_UpdatedLocalDate
        extends KmMetaDateProperty<MyProjectContact>
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
        public KmDate getValueFor(MyProjectContact model)
        {
            return model.getUpdatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyProjectContact model, KmDate value)
        {
            return model.hasUpdatedLocalDate(value);
        }
    }

    //##################################################
    //# UpdatedLocalTime
    //##################################################

    public class MyMetaProjectContact_UpdatedLocalTime
        extends KmMetaTimeProperty<MyProjectContact>
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
        public KmTime getValueFor(MyProjectContact model)
        {
            return model.getUpdatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyProjectContact model, KmTime value)
        {
            return model.hasUpdatedLocalTime(value);
        }
    }

    //##################################################
    //# CreatedByFullName
    //##################################################

    public class MyMetaProjectContact_CreatedByFullName
        extends KmMetaStringProperty<MyProjectContact>
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
        public String getValueFor(MyProjectContact model)
        {
            return model.getCreatedByFullName();
        }

        @Override
        public void setValueFor(MyProjectContact model, String value)
        {
            model.setCreatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyProjectContact model, String value)
        {
            return model.hasCreatedByFullName(value);
        }
    }

    //##################################################
    //# UpdatedByFullName
    //##################################################

    public class MyMetaProjectContact_UpdatedByFullName
        extends KmMetaStringProperty<MyProjectContact>
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
        public String getValueFor(MyProjectContact model)
        {
            return model.getUpdatedByFullName();
        }

        @Override
        public void setValueFor(MyProjectContact model, String value)
        {
            model.setUpdatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyProjectContact model, String value)
        {
            return model.hasUpdatedByFullName(value);
        }
    }


    //##################################################
    //# CreatedBy
    //##################################################

    public class MyMetaProjectContact_CreatedBy
        extends KmMetaDaoAssociation<MyProjectContact,MyUser>
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
        public MyUser getValueFor(MyProjectContact model)
        {
            return model.getCreatedBy();
        }

        @Override
        public void setValueFor(MyProjectContact model, MyUser value)
        {
            model.setCreatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyProjectContact model, MyUser value)
        {
            return model.hasCreatedBy(value);
        }
    }

    //##################################################
    //# Project
    //##################################################

    public class MyMetaProjectContact_Project
        extends KmMetaDaoAssociation<MyProjectContact,MyProject>
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
            return "The project to which this contact belongs.";
        }

        @Override
        public boolean isRequired()
        {
            return true;
        }

        @Override
        public MyProject getValueFor(MyProjectContact model)
        {
            return model.getProject();
        }

        @Override
        public void setValueFor(MyProjectContact model, MyProject value)
        {
            model.setProject(value);
        }

        @Override
        public boolean hasValueFor(MyProjectContact model, MyProject value)
        {
            return model.hasProject(value);
        }
    }

    //##################################################
    //# UpdatedBy
    //##################################################

    public class MyMetaProjectContact_UpdatedBy
        extends KmMetaDaoAssociation<MyProjectContact,MyUser>
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
        public MyUser getValueFor(MyProjectContact model)
        {
            return model.getUpdatedBy();
        }

        @Override
        public void setValueFor(MyProjectContact model, MyUser value)
        {
            model.setUpdatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyProjectContact model, MyUser value)
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
