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

public class MyMetaUser
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaUser instance = new MyMetaUser();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaUser()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "user";
    }

    public MyUserValidator getValidator()
    {
        return MyUserValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "Users define the people that can log in to a particular tenant. Most users are configured as Other and then given project specific roles. A few users may be configured as Admin users so that they can create new projects.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaUser_AuditLogTitle AuditLogTitle = new MyMetaUser_AuditLogTitle();
    public final MyMetaUser_CreatedUtcTs CreatedUtcTs = new MyMetaUser_CreatedUtcTs();
    public final MyMetaUser_DomainSubtitle DomainSubtitle = new MyMetaUser_DomainSubtitle();
    public final MyMetaUser_DomainTitle DomainTitle = new MyMetaUser_DomainTitle();
    public final MyMetaUser_Email Email = new MyMetaUser_Email();
    public final MyMetaUser_Enabled Enabled = new MyMetaUser_Enabled();
    public final MyMetaUser_EnabledStatus EnabledStatus = new MyMetaUser_EnabledStatus();
    public final MyMetaUser_FirstName FirstName = new MyMetaUser_FirstName();
    public final MyMetaUser_FormalName FormalName = new MyMetaUser_FormalName();
    public final MyMetaUser_FullName FullName = new MyMetaUser_FullName();
    public final MyMetaUser_LastName LastName = new MyMetaUser_LastName();
    public final MyMetaUser_LongName LongName = new MyMetaUser_LongName();
    public final MyMetaUser_Memo Memo = new MyMetaUser_Memo();
    public final MyMetaUser_Nickname Nickname = new MyMetaUser_Nickname();
    public final MyMetaUser_PasswordHash PasswordHash = new MyMetaUser_PasswordHash();
    public final MyMetaUser_PasswordSalt PasswordSalt = new MyMetaUser_PasswordSalt();
    public final MyMetaUser_Phone Phone = new MyMetaUser_Phone();
    public final MyMetaUser_RoleCode RoleCode = new MyMetaUser_RoleCode();
    public final MyMetaUser_ShortName ShortName = new MyMetaUser_ShortName();
    public final MyMetaUser_TimeZoneCode TimeZoneCode = new MyMetaUser_TimeZoneCode();
    public final MyMetaUser_Uid Uid = new MyMetaUser_Uid();
    public final MyMetaUser_UpdatedUtcTs UpdatedUtcTs = new MyMetaUser_UpdatedUtcTs();
    public final MyMetaUser_LockVersion LockVersion = new MyMetaUser_LockVersion();
    public final MyMetaUser_RoleName RoleName = new MyMetaUser_RoleName();
    public final MyMetaUser_CreatedLocalTs CreatedLocalTs = new MyMetaUser_CreatedLocalTs();
    public final MyMetaUser_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaUser_CreatedLocalTsMessage();
    public final MyMetaUser_CreatedLocalDate CreatedLocalDate = new MyMetaUser_CreatedLocalDate();
    public final MyMetaUser_CreatedLocalTime CreatedLocalTime = new MyMetaUser_CreatedLocalTime();
    public final MyMetaUser_UpdatedLocalTs UpdatedLocalTs = new MyMetaUser_UpdatedLocalTs();
    public final MyMetaUser_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaUser_UpdatedLocalTsMessage();
    public final MyMetaUser_UpdatedLocalDate UpdatedLocalDate = new MyMetaUser_UpdatedLocalDate();
    public final MyMetaUser_UpdatedLocalTime UpdatedLocalTime = new MyMetaUser_UpdatedLocalTime();
    public final MyMetaUser_CreatedByFullName CreatedByFullName = new MyMetaUser_CreatedByFullName();
    public final MyMetaUser_TenantName TenantName = new MyMetaUser_TenantName();
    public final MyMetaUser_UpdatedByFullName UpdatedByFullName = new MyMetaUser_UpdatedByFullName();

    //##################################################
    //# associations
    //##################################################

    public final MyMetaUser_CreatedBy CreatedBy = new MyMetaUser_CreatedBy();
    public final MyMetaUser_LastProject LastProject = new MyMetaUser_LastProject();
    public final MyMetaUser_Tenant Tenant = new MyMetaUser_Tenant();
    public final MyMetaUser_UpdatedBy UpdatedBy = new MyMetaUser_UpdatedBy();

    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaUser_AuditLogTitle
        extends KmMetaStringProperty<MyUser>
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
        public String getValueFor(MyUser model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyUser model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaUser_CreatedUtcTs
        extends KmMetaTimestampProperty<MyUser>
        implements KmMetaDaoPropertyIF<MyUser,KmTimestamp>
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
            return MyUserValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MyUserDao getDao()
        {
            return getAccess().getUserDao();
        }

        @Override
        public KmTimestamp getValueFor(MyUser model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MyUser model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyUser model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaUser_DomainSubtitle
        extends KmMetaStringProperty<MyUser>
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
        public String getValueFor(MyUser model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyUser model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaUser_DomainTitle
        extends KmMetaStringProperty<MyUser>
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
        public String getValueFor(MyUser model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyUser model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# Email
    //##################################################

    public class MyMetaUser_Email
        extends KmMetaStringProperty<MyUser>
        implements KmMetaDaoPropertyIF<MyUser,String>
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
            return "Used both to sign in, and to send emails to this user.";
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
            return MyUserValidator.instance.getEmailValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "email";
        }

        @Override
        public MyUserDao getDao()
        {
            return getAccess().getUserDao();
        }

        @Override
        public String getValueFor(MyUser model)
        {
            return model.getEmail();
        }

        @Override
        public void setValueFor(MyUser model, String value)
        {
            model.setEmail(value);
        }

        @Override
        public boolean hasValueFor(MyUser model, String value)
        {
            return model.hasEmail(value);
        }
    }

    //##################################################
    //# Enabled
    //##################################################

    public class MyMetaUser_Enabled
        extends KmMetaBooleanProperty<MyUser>
        implements KmMetaDaoPropertyIF<MyUser,Boolean>
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
            return MyUserValidator.instance.getEnabledValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "enabled";
        }

        @Override
        public MyUserDao getDao()
        {
            return getAccess().getUserDao();
        }

        @Override
        public Boolean getValueFor(MyUser model)
        {
            return model.getEnabled();
        }

        @Override
        public void setValueFor(MyUser model, Boolean value)
        {
            model.setEnabled(value);
        }

        @Override
        public boolean hasValueFor(MyUser model, Boolean value)
        {
            return model.hasEnabled(value);
        }
    }

    //##################################################
    //# EnabledStatus
    //##################################################

    public class MyMetaUser_EnabledStatus
        extends KmMetaStringProperty<MyUser>
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
        public String getValueFor(MyUser model)
        {
            return model.getEnabledStatus();
        }

        @Override
        public boolean hasValueFor(MyUser model, String value)
        {
            return model.hasEnabledStatus(value);
        }
    }

    //##################################################
    //# FirstName
    //##################################################

    public class MyMetaUser_FirstName
        extends KmMetaStringProperty<MyUser>
        implements KmMetaDaoPropertyIF<MyUser,String>
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
            return MyUserValidator.instance.getFirstNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "firstName";
        }

        @Override
        public MyUserDao getDao()
        {
            return getAccess().getUserDao();
        }

        @Override
        public String getValueFor(MyUser model)
        {
            return model.getFirstName();
        }

        @Override
        public void setValueFor(MyUser model, String value)
        {
            model.setFirstName(value);
        }

        @Override
        public boolean hasValueFor(MyUser model, String value)
        {
            return model.hasFirstName(value);
        }
    }

    //##################################################
    //# FormalName
    //##################################################

    public class MyMetaUser_FormalName
        extends KmMetaStringProperty<MyUser>
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
        public String getValueFor(MyUser model)
        {
            return model.getFormalName();
        }

        @Override
        public boolean hasValueFor(MyUser model, String value)
        {
            return model.hasFormalName(value);
        }
    }

    //##################################################
    //# FullName
    //##################################################

    public class MyMetaUser_FullName
        extends KmMetaStringProperty<MyUser>
        implements KmMetaDaoPropertyIF<MyUser,String>
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
            return MyUserValidator.instance.getFullNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "fullName";
        }

        @Override
        public MyUserDao getDao()
        {
            return getAccess().getUserDao();
        }

        @Override
        public String getValueFor(MyUser model)
        {
            return model.getFullName();
        }

        @Override
        public void setValueFor(MyUser model, String value)
        {
            model.setFullName(value);
        }

        @Override
        public boolean hasValueFor(MyUser model, String value)
        {
            return model.hasFullName(value);
        }
    }

    //##################################################
    //# LastName
    //##################################################

    public class MyMetaUser_LastName
        extends KmMetaStringProperty<MyUser>
        implements KmMetaDaoPropertyIF<MyUser,String>
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
            return MyUserValidator.instance.getLastNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lastName";
        }

        @Override
        public MyUserDao getDao()
        {
            return getAccess().getUserDao();
        }

        @Override
        public String getValueFor(MyUser model)
        {
            return model.getLastName();
        }

        @Override
        public void setValueFor(MyUser model, String value)
        {
            model.setLastName(value);
        }

        @Override
        public boolean hasValueFor(MyUser model, String value)
        {
            return model.hasLastName(value);
        }
    }

    //##################################################
    //# LongName
    //##################################################

    public class MyMetaUser_LongName
        extends KmMetaStringProperty<MyUser>
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
        public String getValueFor(MyUser model)
        {
            return model.getLongName();
        }

        @Override
        public boolean hasValueFor(MyUser model, String value)
        {
            return model.hasLongName(value);
        }
    }

    //##################################################
    //# Memo
    //##################################################

    public class MyMetaUser_Memo
        extends KmMetaStringProperty<MyUser>
        implements KmMetaDaoPropertyIF<MyUser,String>
    {
        @Override
        public String getName()
        {
            return "memo";
        }

        @Override
        public String getLabel()
        {
            return "Memo";
        }

        @Override
        public String getHelp()
        {
            return "A free form memo.";
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
            return MyUserValidator.instance.getMemoValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "memo";
        }

        @Override
        public MyUserDao getDao()
        {
            return getAccess().getUserDao();
        }

        @Override
        public String getValueFor(MyUser model)
        {
            return model.getMemo();
        }

        @Override
        public void setValueFor(MyUser model, String value)
        {
            model.setMemo(value);
        }

        @Override
        public boolean hasValueFor(MyUser model, String value)
        {
            return model.hasMemo(value);
        }
    }

    //##################################################
    //# Nickname
    //##################################################

    public class MyMetaUser_Nickname
        extends KmMetaStringProperty<MyUser>
        implements KmMetaDaoPropertyIF<MyUser,String>
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
            return MyUserValidator.instance.getNicknameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "nickname";
        }

        @Override
        public MyUserDao getDao()
        {
            return getAccess().getUserDao();
        }

        @Override
        public String getValueFor(MyUser model)
        {
            return model.getNickname();
        }

        @Override
        public void setValueFor(MyUser model, String value)
        {
            model.setNickname(value);
        }

        @Override
        public boolean hasValueFor(MyUser model, String value)
        {
            return model.hasNickname(value);
        }
    }

    //##################################################
    //# PasswordHash
    //##################################################

    public class MyMetaUser_PasswordHash
        extends KmMetaStringProperty<MyUser>
        implements KmMetaDaoPropertyIF<MyUser,String>
    {
        @Override
        public String getName()
        {
            return "passwordHash";
        }

        @Override
        public String getLabel()
        {
            return "Password Hash";
        }

        @Override
        public String getHelp()
        {
            return "The password sha hash used to authenticate the user. The actual password is not stored. If the user has no password the hash is set to empty string.";
        }

        @Override
        public int getColumnWidth()
        {
            return 40;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyUserValidator.instance.getPasswordHashValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "passwordHash";
        }

        @Override
        public MyUserDao getDao()
        {
            return getAccess().getUserDao();
        }

        @Override
        public String getValueFor(MyUser model)
        {
            return model.getPasswordHash();
        }

        @Override
        public void setValueFor(MyUser model, String value)
        {
            model.setPasswordHash(value);
        }

        @Override
        public boolean hasValueFor(MyUser model, String value)
        {
            return model.hasPasswordHash(value);
        }
    }

    //##################################################
    //# PasswordSalt
    //##################################################

    public class MyMetaUser_PasswordSalt
        extends KmMetaStringProperty<MyUser>
        implements KmMetaDaoPropertyIF<MyUser,String>
    {
        @Override
        public String getName()
        {
            return "passwordSalt";
        }

        @Override
        public String getLabel()
        {
            return "Password Salt";
        }

        @Override
        public String getHelp()
        {
            return "The salt used for this user. Each user has a different salt. The salt is set to a random value when the user is created. Once set the salt should never be changed, changing it will invalidate the password.";
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
            return MyUserValidator.instance.getPasswordSaltValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "passwordSalt";
        }

        @Override
        public MyUserDao getDao()
        {
            return getAccess().getUserDao();
        }

        @Override
        public String getValueFor(MyUser model)
        {
            return model.getPasswordSalt();
        }

        @Override
        public void setValueFor(MyUser model, String value)
        {
            model.setPasswordSalt(value);
        }

        @Override
        public boolean hasValueFor(MyUser model, String value)
        {
            return model.hasPasswordSalt(value);
        }
    }

    //##################################################
    //# Phone
    //##################################################

    public class MyMetaUser_Phone
        extends KmMetaStringProperty<MyUser>
        implements KmMetaDaoPropertyIF<MyUser,String>
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
            return "The number that may be used to contact this user.";
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
            return MyUserValidator.instance.getPhoneValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "phone";
        }

        @Override
        public MyUserDao getDao()
        {
            return getAccess().getUserDao();
        }

        @Override
        public String getValueFor(MyUser model)
        {
            return model.getPhone();
        }

        @Override
        public void setValueFor(MyUser model, String value)
        {
            model.setPhone(value);
        }

        @Override
        public boolean hasValueFor(MyUser model, String value)
        {
            return model.hasPhone(value);
        }
    }

    //##################################################
    //# RoleCode
    //##################################################

    public class MyMetaUser_RoleCode
        extends KmMetaStringProperty<MyUser>
        implements KmMetaDaoPropertyIF<MyUser,String>
    {
        @Override
        public String getName()
        {
            return "roleCode";
        }

        @Override
        public String getLabel()
        {
            return "Role";
        }

        @Override
        public String getHelp()
        {
            return "The user's global access role.\n\n Developer, has full access to all data and functions in the app.\n\n Tenant Admin, the user has access to administration functions that affect the entire tenant. The user can add new users and projects.\n\n Project Member, the user is limited to specific projects. Project-specific permissions are determined by the project's manager via the member setup.";
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
            return MyUserValidator.instance.getRoleCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "roleCode";
        }

        @Override
        public MyUserDao getDao()
        {
            return getAccess().getUserDao();
        }

        public ScDynamicEnumDropdownField newDropdown()
        {
            ScDynamicEnumDropdownField e;
            e = new ScDynamicEnumDropdownField();
            e.setMeta(this);
            e.setEnumArraySupplier(MyUserRole::values);
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
        public String getValueFor(MyUser model)
        {
            return model.getRoleCode();
        }

        @Override
        public void setValueFor(MyUser model, String value)
        {
            model.setRoleCode(value);
        }

        @Override
        public boolean hasValueFor(MyUser model, String value)
        {
            return model.hasRoleCode(value);
        }
    }

    //##################################################
    //# ShortName
    //##################################################

    public class MyMetaUser_ShortName
        extends KmMetaStringProperty<MyUser>
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
        public String getValueFor(MyUser model)
        {
            return model.getShortName();
        }

        @Override
        public boolean hasValueFor(MyUser model, String value)
        {
            return model.hasShortName(value);
        }
    }

    //##################################################
    //# TimeZoneCode
    //##################################################

    public class MyMetaUser_TimeZoneCode
        extends KmMetaStringProperty<MyUser>
        implements KmMetaDaoPropertyIF<MyUser,String>
    {
        @Override
        public String getName()
        {
            return "timeZoneCode";
        }

        @Override
        public String getLabel()
        {
            return "Time Zone";
        }

        @Override
        public String getHelp()
        {
            return "The user's preferred time zone.";
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
            return MyUserValidator.instance.getTimeZoneCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "timeZoneCode";
        }

        @Override
        public MyUserDao getDao()
        {
            return getAccess().getUserDao();
        }

        @Override
        public String getValueFor(MyUser model)
        {
            return model.getTimeZoneCode();
        }

        @Override
        public void setValueFor(MyUser model, String value)
        {
            model.setTimeZoneCode(value);
        }

        @Override
        public boolean hasValueFor(MyUser model, String value)
        {
            return model.hasTimeZoneCode(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaUser_Uid
        extends KmMetaStringProperty<MyUser>
        implements KmMetaDaoPropertyIF<MyUser,String>
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
            return MyUserValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyUserDao getDao()
        {
            return getAccess().getUserDao();
        }

        public KmDaoStringKeyCursor<MyUser> createCursor()
        {
            KmDaoStringKeyCursor<MyUser> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyUser model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyUser model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyUser model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# UpdatedUtcTs
    //##################################################

    public class MyMetaUser_UpdatedUtcTs
        extends KmMetaTimestampProperty<MyUser>
        implements KmMetaDaoPropertyIF<MyUser,KmTimestamp>
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
            return MyUserValidator.instance.getUpdatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "updatedUtcTs";
        }

        @Override
        public MyUserDao getDao()
        {
            return getAccess().getUserDao();
        }

        @Override
        public KmTimestamp getValueFor(MyUser model)
        {
            return model.getUpdatedUtcTs();
        }

        @Override
        public void setValueFor(MyUser model, KmTimestamp value)
        {
            model.setUpdatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyUser model, KmTimestamp value)
        {
            return model.hasUpdatedUtcTs(value);
        }
    }

    //##################################################
    //# LockVersion
    //##################################################

    public class MyMetaUser_LockVersion
        extends KmMetaIntegerProperty<MyUser>
        implements KmMetaDaoPropertyIF<MyUser,Integer>
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
            return MyUserValidator.instance.getLockVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lockVersion";
        }

        @Override
        public MyUserDao getDao()
        {
            return getAccess().getUserDao();
        }

        @Override
        public Integer getValueFor(MyUser model)
        {
            return model.getLockVersion();
        }

        @Override
        public void setValueFor(MyUser model, Integer value)
        {
            model.setLockVersion(value);
        }

        @Override
        public boolean hasValueFor(MyUser model, Integer value)
        {
            return model.hasLockVersion(value);
        }
    }

    //##################################################
    //# RoleName
    //##################################################

    public class MyMetaUser_RoleName
        extends KmMetaStringProperty<MyUser>
    {
        @Override
        public String getName()
        {
            return "roleName";
        }

        @Override
        public String getLabel()
        {
            return "Role";
        }

        @Override
        public String getHelp()
        {
            return "The user's global access role.\n\n Developer, has full access to all data and functions in the app.\n\n Tenant Admin, the user has access to administration functions that affect the entire tenant. The user can add new users and projects.\n\n Project Member, the user is limited to specific projects. Project-specific permissions are determined by the project's manager via the member setup.";
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
        public String getValueFor(MyUser model)
        {
            return model.getRoleName();
        }

        @Override
        public boolean hasValueFor(MyUser model, String value)
        {
            return model.hasRoleName(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaUser_CreatedLocalTs
        extends KmMetaTimestampProperty<MyUser>
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
        public KmTimestamp getValueFor(MyUser model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyUser model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaUser_CreatedLocalTsMessage
        extends KmMetaStringProperty<MyUser>
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
        public String getValueFor(MyUser model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyUser model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaUser_CreatedLocalDate
        extends KmMetaDateProperty<MyUser>
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
        public KmDate getValueFor(MyUser model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyUser model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaUser_CreatedLocalTime
        extends KmMetaTimeProperty<MyUser>
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
        public KmTime getValueFor(MyUser model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyUser model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }

    //##################################################
    //# UpdatedLocalTs
    //##################################################

    public class MyMetaUser_UpdatedLocalTs
        extends KmMetaTimestampProperty<MyUser>
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
        public KmTimestamp getValueFor(MyUser model)
        {
            return model.getUpdatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyUser model, KmTimestamp value)
        {
            return model.hasUpdatedLocalTs(value);
        }
    }

    //##################################################
    //# UpdatedLocalTsMessage
    //##################################################

    public class MyMetaUser_UpdatedLocalTsMessage
        extends KmMetaStringProperty<MyUser>
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
        public String getValueFor(MyUser model)
        {
            return model.getUpdatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyUser model, String value)
        {
            return model.hasUpdatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# UpdatedLocalDate
    //##################################################

    public class MyMetaUser_UpdatedLocalDate
        extends KmMetaDateProperty<MyUser>
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
        public KmDate getValueFor(MyUser model)
        {
            return model.getUpdatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyUser model, KmDate value)
        {
            return model.hasUpdatedLocalDate(value);
        }
    }

    //##################################################
    //# UpdatedLocalTime
    //##################################################

    public class MyMetaUser_UpdatedLocalTime
        extends KmMetaTimeProperty<MyUser>
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
        public KmTime getValueFor(MyUser model)
        {
            return model.getUpdatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyUser model, KmTime value)
        {
            return model.hasUpdatedLocalTime(value);
        }
    }

    //##################################################
    //# CreatedByFullName
    //##################################################

    public class MyMetaUser_CreatedByFullName
        extends KmMetaStringProperty<MyUser>
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
        public String getValueFor(MyUser model)
        {
            return model.getCreatedByFullName();
        }

        @Override
        public void setValueFor(MyUser model, String value)
        {
            model.setCreatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyUser model, String value)
        {
            return model.hasCreatedByFullName(value);
        }
    }

    //##################################################
    //# TenantName
    //##################################################

    public class MyMetaUser_TenantName
        extends KmMetaStringProperty<MyUser>
    {
        @Override
        public String getName()
        {
            return "tenantName";
        }

        @Override
        public String getLabel()
        {
            return "Tenant Name";
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
        public String getValueFor(MyUser model)
        {
            return model.getTenantName();
        }

        @Override
        public void setValueFor(MyUser model, String value)
        {
            model.setTenantName(value);
        }

        @Override
        public boolean hasValueFor(MyUser model, String value)
        {
            return model.hasTenantName(value);
        }
    }

    //##################################################
    //# UpdatedByFullName
    //##################################################

    public class MyMetaUser_UpdatedByFullName
        extends KmMetaStringProperty<MyUser>
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
        public String getValueFor(MyUser model)
        {
            return model.getUpdatedByFullName();
        }

        @Override
        public void setValueFor(MyUser model, String value)
        {
            model.setUpdatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyUser model, String value)
        {
            return model.hasUpdatedByFullName(value);
        }
    }


    //##################################################
    //# CreatedBy
    //##################################################

    public class MyMetaUser_CreatedBy
        extends KmMetaDaoAssociation<MyUser,MyUser>
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
        public MyUser getValueFor(MyUser model)
        {
            return model.getCreatedBy();
        }

        @Override
        public void setValueFor(MyUser model, MyUser value)
        {
            model.setCreatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyUser model, MyUser value)
        {
            return model.hasCreatedBy(value);
        }
    }

    //##################################################
    //# LastProject
    //##################################################

    public class MyMetaUser_LastProject
        extends KmMetaAssociation<MyUser,MyProject>
    {
        @Override
        public String getName()
        {
            return "lastProject";
        }

        @Override
        public String getLabel()
        {
            return "Last Project";
        }

        @Override
        public String getHelp()
        {
            return "The last project this user was working on.";
        }

        @Override
        public boolean isRequired()
        {
            return false;
        }

        @Override
        public MyProject getValueFor(MyUser model)
        {
            return model.getLastProject();
        }

        @Override
        public void setValueFor(MyUser model, MyProject value)
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasValueFor(MyUser model, MyProject value)
        {
            return model.hasLastProject(value);
        }
    }

    //##################################################
    //# Tenant
    //##################################################

    public class MyMetaUser_Tenant
        extends KmMetaDaoAssociation<MyUser,MyTenant>
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
            return "The tenant.";
        }

        @Override
        public boolean isRequired()
        {
            return true;
        }

        @Override
        public MyTenant getValueFor(MyUser model)
        {
            return model.getTenant();
        }

        @Override
        public void setValueFor(MyUser model, MyTenant value)
        {
            model.setTenant(value);
        }

        @Override
        public boolean hasValueFor(MyUser model, MyTenant value)
        {
            return model.hasTenant(value);
        }
    }

    //##################################################
    //# UpdatedBy
    //##################################################

    public class MyMetaUser_UpdatedBy
        extends KmMetaDaoAssociation<MyUser,MyUser>
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
        public MyUser getValueFor(MyUser model)
        {
            return model.getUpdatedBy();
        }

        @Override
        public void setValueFor(MyUser model, MyUser value)
        {
            model.setUpdatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyUser model, MyUser value)
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
