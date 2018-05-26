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

public class MyMetaSiteContact
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaSiteContact instance = new MyMetaSiteContact();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaSiteContact()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "siteContact";
    }

    public MySiteContactValidator getValidator()
    {
        return MySiteContactValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "The contacts associated with a particular site. These contacts are primarily used for notifications related to a site.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaSiteContact_AuditLogTitle AuditLogTitle = new MyMetaSiteContact_AuditLogTitle();
    public final MyMetaSiteContact_CreatedUtcTs CreatedUtcTs = new MyMetaSiteContact_CreatedUtcTs();
    public final MyMetaSiteContact_DomainSubtitle DomainSubtitle = new MyMetaSiteContact_DomainSubtitle();
    public final MyMetaSiteContact_DomainTitle DomainTitle = new MyMetaSiteContact_DomainTitle();
    public final MyMetaSiteContact_EffectiveInstallContact EffectiveInstallContact = new MyMetaSiteContact_EffectiveInstallContact();
    public final MyMetaSiteContact_EffectiveRequesterContact EffectiveRequesterContact = new MyMetaSiteContact_EffectiveRequesterContact();
    public final MyMetaSiteContact_EffectiveSalesContact EffectiveSalesContact = new MyMetaSiteContact_EffectiveSalesContact();
    public final MyMetaSiteContact_EffectiveSchedulingContact EffectiveSchedulingContact = new MyMetaSiteContact_EffectiveSchedulingContact();
    public final MyMetaSiteContact_EffectiveTechnicalContact EffectiveTechnicalContact = new MyMetaSiteContact_EffectiveTechnicalContact();
    public final MyMetaSiteContact_Email Email = new MyMetaSiteContact_Email();
    public final MyMetaSiteContact_Enabled Enabled = new MyMetaSiteContact_Enabled();
    public final MyMetaSiteContact_EnabledStatus EnabledStatus = new MyMetaSiteContact_EnabledStatus();
    public final MyMetaSiteContact_FirstName FirstName = new MyMetaSiteContact_FirstName();
    public final MyMetaSiteContact_FormalName FormalName = new MyMetaSiteContact_FormalName();
    public final MyMetaSiteContact_FullName FullName = new MyMetaSiteContact_FullName();
    public final MyMetaSiteContact_InstallContact InstallContact = new MyMetaSiteContact_InstallContact();
    public final MyMetaSiteContact_LastName LastName = new MyMetaSiteContact_LastName();
    public final MyMetaSiteContact_LongName LongName = new MyMetaSiteContact_LongName();
    public final MyMetaSiteContact_MainContact MainContact = new MyMetaSiteContact_MainContact();
    public final MyMetaSiteContact_Nickname Nickname = new MyMetaSiteContact_Nickname();
    public final MyMetaSiteContact_Phone Phone = new MyMetaSiteContact_Phone();
    public final MyMetaSiteContact_RequesterContact RequesterContact = new MyMetaSiteContact_RequesterContact();
    public final MyMetaSiteContact_SalesContact SalesContact = new MyMetaSiteContact_SalesContact();
    public final MyMetaSiteContact_SchedulingContact SchedulingContact = new MyMetaSiteContact_SchedulingContact();
    public final MyMetaSiteContact_ShortName ShortName = new MyMetaSiteContact_ShortName();
    public final MyMetaSiteContact_SummaryMultiline SummaryMultiline = new MyMetaSiteContact_SummaryMultiline();
    public final MyMetaSiteContact_TechnicalContact TechnicalContact = new MyMetaSiteContact_TechnicalContact();
    public final MyMetaSiteContact_Title Title = new MyMetaSiteContact_Title();
    public final MyMetaSiteContact_Uid Uid = new MyMetaSiteContact_Uid();
    public final MyMetaSiteContact_UpdatedUtcTs UpdatedUtcTs = new MyMetaSiteContact_UpdatedUtcTs();
    public final MyMetaSiteContact_LockVersion LockVersion = new MyMetaSiteContact_LockVersion();
    public final MyMetaSiteContact_CreatedLocalTs CreatedLocalTs = new MyMetaSiteContact_CreatedLocalTs();
    public final MyMetaSiteContact_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaSiteContact_CreatedLocalTsMessage();
    public final MyMetaSiteContact_CreatedLocalDate CreatedLocalDate = new MyMetaSiteContact_CreatedLocalDate();
    public final MyMetaSiteContact_CreatedLocalTime CreatedLocalTime = new MyMetaSiteContact_CreatedLocalTime();
    public final MyMetaSiteContact_UpdatedLocalTs UpdatedLocalTs = new MyMetaSiteContact_UpdatedLocalTs();
    public final MyMetaSiteContact_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaSiteContact_UpdatedLocalTsMessage();
    public final MyMetaSiteContact_UpdatedLocalDate UpdatedLocalDate = new MyMetaSiteContact_UpdatedLocalDate();
    public final MyMetaSiteContact_UpdatedLocalTime UpdatedLocalTime = new MyMetaSiteContact_UpdatedLocalTime();
    public final MyMetaSiteContact_CreatedByFullName CreatedByFullName = new MyMetaSiteContact_CreatedByFullName();
    public final MyMetaSiteContact_UpdatedByFullName UpdatedByFullName = new MyMetaSiteContact_UpdatedByFullName();

    //##################################################
    //# associations
    //##################################################

    public final MyMetaSiteContact_CreatedBy CreatedBy = new MyMetaSiteContact_CreatedBy();
    public final MyMetaSiteContact_Site Site = new MyMetaSiteContact_Site();
    public final MyMetaSiteContact_UpdatedBy UpdatedBy = new MyMetaSiteContact_UpdatedBy();

    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaSiteContact_AuditLogTitle
        extends KmMetaStringProperty<MySiteContact>
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
        public String getValueFor(MySiteContact model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MySiteContact model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaSiteContact_CreatedUtcTs
        extends KmMetaTimestampProperty<MySiteContact>
        implements KmMetaDaoPropertyIF<MySiteContact,KmTimestamp>
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
            return MySiteContactValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MySiteContactDao getDao()
        {
            return getAccess().getSiteContactDao();
        }

        @Override
        public KmTimestamp getValueFor(MySiteContact model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MySiteContact model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MySiteContact model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaSiteContact_DomainSubtitle
        extends KmMetaStringProperty<MySiteContact>
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
        public String getValueFor(MySiteContact model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MySiteContact model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaSiteContact_DomainTitle
        extends KmMetaStringProperty<MySiteContact>
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
        public String getValueFor(MySiteContact model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MySiteContact model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# EffectiveInstallContact
    //##################################################

    public class MyMetaSiteContact_EffectiveInstallContact
        extends KmMetaBooleanProperty<MySiteContact>
    {
        @Override
        public String getName()
        {
            return "effectiveInstallContact";
        }

        @Override
        public String getLabel()
        {
            return "Effective Install Contact";
        }

        @Override
        public String getHelp()
        {
            return "Indicates if this is the site's effective install contact.";
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
        public Boolean getValueFor(MySiteContact model)
        {
            return model.getEffectiveInstallContact();
        }

        @Override
        public boolean hasValueFor(MySiteContact model, Boolean value)
        {
            return model.hasEffectiveInstallContact(value);
        }
    }

    //##################################################
    //# EffectiveRequesterContact
    //##################################################

    public class MyMetaSiteContact_EffectiveRequesterContact
        extends KmMetaBooleanProperty<MySiteContact>
    {
        @Override
        public String getName()
        {
            return "effectiveRequesterContact";
        }

        @Override
        public String getLabel()
        {
            return "Effective Requester Contact";
        }

        @Override
        public String getHelp()
        {
            return "Indicates if this is the site's effective requester contact.";
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
        public Boolean getValueFor(MySiteContact model)
        {
            return model.getEffectiveRequesterContact();
        }

        @Override
        public boolean hasValueFor(MySiteContact model, Boolean value)
        {
            return model.hasEffectiveRequesterContact(value);
        }
    }

    //##################################################
    //# EffectiveSalesContact
    //##################################################

    public class MyMetaSiteContact_EffectiveSalesContact
        extends KmMetaBooleanProperty<MySiteContact>
    {
        @Override
        public String getName()
        {
            return "effectiveSalesContact";
        }

        @Override
        public String getLabel()
        {
            return "Effective Sales Contact";
        }

        @Override
        public String getHelp()
        {
            return "Indicates if this is the site's effective sales contact.";
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
        public Boolean getValueFor(MySiteContact model)
        {
            return model.getEffectiveSalesContact();
        }

        @Override
        public boolean hasValueFor(MySiteContact model, Boolean value)
        {
            return model.hasEffectiveSalesContact(value);
        }
    }

    //##################################################
    //# EffectiveSchedulingContact
    //##################################################

    public class MyMetaSiteContact_EffectiveSchedulingContact
        extends KmMetaBooleanProperty<MySiteContact>
    {
        @Override
        public String getName()
        {
            return "effectiveSchedulingContact";
        }

        @Override
        public String getLabel()
        {
            return "Effective Scheduling Contact";
        }

        @Override
        public String getHelp()
        {
            return "Indicates if this is the site's effective scheduling contact.";
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
        public Boolean getValueFor(MySiteContact model)
        {
            return model.getEffectiveSchedulingContact();
        }

        @Override
        public boolean hasValueFor(MySiteContact model, Boolean value)
        {
            return model.hasEffectiveSchedulingContact(value);
        }
    }

    //##################################################
    //# EffectiveTechnicalContact
    //##################################################

    public class MyMetaSiteContact_EffectiveTechnicalContact
        extends KmMetaBooleanProperty<MySiteContact>
    {
        @Override
        public String getName()
        {
            return "effectiveTechnicalContact";
        }

        @Override
        public String getLabel()
        {
            return "Effective Technical Contact";
        }

        @Override
        public String getHelp()
        {
            return "Indicates if this is the site's effective technical contact.";
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
        public Boolean getValueFor(MySiteContact model)
        {
            return model.getEffectiveTechnicalContact();
        }

        @Override
        public boolean hasValueFor(MySiteContact model, Boolean value)
        {
            return model.hasEffectiveTechnicalContact(value);
        }
    }

    //##################################################
    //# Email
    //##################################################

    public class MyMetaSiteContact_Email
        extends KmMetaStringProperty<MySiteContact>
        implements KmMetaDaoPropertyIF<MySiteContact,String>
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
            return MySiteContactValidator.instance.getEmailValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "email";
        }

        @Override
        public MySiteContactDao getDao()
        {
            return getAccess().getSiteContactDao();
        }

        @Override
        public String getValueFor(MySiteContact model)
        {
            return model.getEmail();
        }

        @Override
        public void setValueFor(MySiteContact model, String value)
        {
            model.setEmail(value);
        }

        @Override
        public boolean hasValueFor(MySiteContact model, String value)
        {
            return model.hasEmail(value);
        }
    }

    //##################################################
    //# Enabled
    //##################################################

    public class MyMetaSiteContact_Enabled
        extends KmMetaBooleanProperty<MySiteContact>
        implements KmMetaDaoPropertyIF<MySiteContact,Boolean>
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
            return MySiteContactValidator.instance.getEnabledValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "enabled";
        }

        @Override
        public MySiteContactDao getDao()
        {
            return getAccess().getSiteContactDao();
        }

        @Override
        public Boolean getValueFor(MySiteContact model)
        {
            return model.getEnabled();
        }

        @Override
        public void setValueFor(MySiteContact model, Boolean value)
        {
            model.setEnabled(value);
        }

        @Override
        public boolean hasValueFor(MySiteContact model, Boolean value)
        {
            return model.hasEnabled(value);
        }
    }

    //##################################################
    //# EnabledStatus
    //##################################################

    public class MyMetaSiteContact_EnabledStatus
        extends KmMetaStringProperty<MySiteContact>
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
        public String getValueFor(MySiteContact model)
        {
            return model.getEnabledStatus();
        }

        @Override
        public boolean hasValueFor(MySiteContact model, String value)
        {
            return model.hasEnabledStatus(value);
        }
    }

    //##################################################
    //# FirstName
    //##################################################

    public class MyMetaSiteContact_FirstName
        extends KmMetaStringProperty<MySiteContact>
        implements KmMetaDaoPropertyIF<MySiteContact,String>
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
            return MySiteContactValidator.instance.getFirstNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "firstName";
        }

        @Override
        public MySiteContactDao getDao()
        {
            return getAccess().getSiteContactDao();
        }

        @Override
        public String getValueFor(MySiteContact model)
        {
            return model.getFirstName();
        }

        @Override
        public void setValueFor(MySiteContact model, String value)
        {
            model.setFirstName(value);
        }

        @Override
        public boolean hasValueFor(MySiteContact model, String value)
        {
            return model.hasFirstName(value);
        }
    }

    //##################################################
    //# FormalName
    //##################################################

    public class MyMetaSiteContact_FormalName
        extends KmMetaStringProperty<MySiteContact>
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
        public String getValueFor(MySiteContact model)
        {
            return model.getFormalName();
        }

        @Override
        public boolean hasValueFor(MySiteContact model, String value)
        {
            return model.hasFormalName(value);
        }
    }

    //##################################################
    //# FullName
    //##################################################

    public class MyMetaSiteContact_FullName
        extends KmMetaStringProperty<MySiteContact>
        implements KmMetaDaoPropertyIF<MySiteContact,String>
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
            return MySiteContactValidator.instance.getFullNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "fullName";
        }

        @Override
        public MySiteContactDao getDao()
        {
            return getAccess().getSiteContactDao();
        }

        @Override
        public String getValueFor(MySiteContact model)
        {
            return model.getFullName();
        }

        @Override
        public void setValueFor(MySiteContact model, String value)
        {
            model.setFullName(value);
        }

        @Override
        public boolean hasValueFor(MySiteContact model, String value)
        {
            return model.hasFullName(value);
        }
    }

    //##################################################
    //# InstallContact
    //##################################################

    public class MyMetaSiteContact_InstallContact
        extends KmMetaBooleanProperty<MySiteContact>
    {
        @Override
        public String getName()
        {
            return "installContact";
        }

        @Override
        public String getLabel()
        {
            return "Install Contact";
        }

        @Override
        public String getHelp()
        {
            return "Indicates if this is the site's install contact.";
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
        public Boolean getValueFor(MySiteContact model)
        {
            return model.getInstallContact();
        }

        @Override
        public boolean hasValueFor(MySiteContact model, Boolean value)
        {
            return model.hasInstallContact(value);
        }
    }

    //##################################################
    //# LastName
    //##################################################

    public class MyMetaSiteContact_LastName
        extends KmMetaStringProperty<MySiteContact>
        implements KmMetaDaoPropertyIF<MySiteContact,String>
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
            return MySiteContactValidator.instance.getLastNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lastName";
        }

        @Override
        public MySiteContactDao getDao()
        {
            return getAccess().getSiteContactDao();
        }

        @Override
        public String getValueFor(MySiteContact model)
        {
            return model.getLastName();
        }

        @Override
        public void setValueFor(MySiteContact model, String value)
        {
            model.setLastName(value);
        }

        @Override
        public boolean hasValueFor(MySiteContact model, String value)
        {
            return model.hasLastName(value);
        }
    }

    //##################################################
    //# LongName
    //##################################################

    public class MyMetaSiteContact_LongName
        extends KmMetaStringProperty<MySiteContact>
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
        public String getValueFor(MySiteContact model)
        {
            return model.getLongName();
        }

        @Override
        public boolean hasValueFor(MySiteContact model, String value)
        {
            return model.hasLongName(value);
        }
    }

    //##################################################
    //# MainContact
    //##################################################

    public class MyMetaSiteContact_MainContact
        extends KmMetaBooleanProperty<MySiteContact>
    {
        @Override
        public String getName()
        {
            return "mainContact";
        }

        @Override
        public String getLabel()
        {
            return "Main Contact";
        }

        @Override
        public String getHelp()
        {
            return "Indicates if this is the site's main contact.";
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
        public Boolean getValueFor(MySiteContact model)
        {
            return model.getMainContact();
        }

        @Override
        public boolean hasValueFor(MySiteContact model, Boolean value)
        {
            return model.hasMainContact(value);
        }
    }

    //##################################################
    //# Nickname
    //##################################################

    public class MyMetaSiteContact_Nickname
        extends KmMetaStringProperty<MySiteContact>
        implements KmMetaDaoPropertyIF<MySiteContact,String>
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
            return MySiteContactValidator.instance.getNicknameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "nickname";
        }

        @Override
        public MySiteContactDao getDao()
        {
            return getAccess().getSiteContactDao();
        }

        @Override
        public String getValueFor(MySiteContact model)
        {
            return model.getNickname();
        }

        @Override
        public void setValueFor(MySiteContact model, String value)
        {
            model.setNickname(value);
        }

        @Override
        public boolean hasValueFor(MySiteContact model, String value)
        {
            return model.hasNickname(value);
        }
    }

    //##################################################
    //# Phone
    //##################################################

    public class MyMetaSiteContact_Phone
        extends KmMetaStringProperty<MySiteContact>
        implements KmMetaDaoPropertyIF<MySiteContact,String>
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
            return MySiteContactValidator.instance.getPhoneValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "phone";
        }

        @Override
        public MySiteContactDao getDao()
        {
            return getAccess().getSiteContactDao();
        }

        @Override
        public String getValueFor(MySiteContact model)
        {
            return model.getPhone();
        }

        @Override
        public void setValueFor(MySiteContact model, String value)
        {
            model.setPhone(value);
        }

        @Override
        public boolean hasValueFor(MySiteContact model, String value)
        {
            return model.hasPhone(value);
        }
    }

    //##################################################
    //# RequesterContact
    //##################################################

    public class MyMetaSiteContact_RequesterContact
        extends KmMetaBooleanProperty<MySiteContact>
    {
        @Override
        public String getName()
        {
            return "requesterContact";
        }

        @Override
        public String getLabel()
        {
            return "Requester Contact";
        }

        @Override
        public String getHelp()
        {
            return "Indicates if this is the site's requester contact.";
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
        public Boolean getValueFor(MySiteContact model)
        {
            return model.getRequesterContact();
        }

        @Override
        public boolean hasValueFor(MySiteContact model, Boolean value)
        {
            return model.hasRequesterContact(value);
        }
    }

    //##################################################
    //# SalesContact
    //##################################################

    public class MyMetaSiteContact_SalesContact
        extends KmMetaBooleanProperty<MySiteContact>
    {
        @Override
        public String getName()
        {
            return "salesContact";
        }

        @Override
        public String getLabel()
        {
            return "Sales Contact";
        }

        @Override
        public String getHelp()
        {
            return "Indicates if this is the site's sales contact.";
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
        public Boolean getValueFor(MySiteContact model)
        {
            return model.getSalesContact();
        }

        @Override
        public boolean hasValueFor(MySiteContact model, Boolean value)
        {
            return model.hasSalesContact(value);
        }
    }

    //##################################################
    //# SchedulingContact
    //##################################################

    public class MyMetaSiteContact_SchedulingContact
        extends KmMetaBooleanProperty<MySiteContact>
    {
        @Override
        public String getName()
        {
            return "schedulingContact";
        }

        @Override
        public String getLabel()
        {
            return "Scheduling Contact";
        }

        @Override
        public String getHelp()
        {
            return "Indicates if this is the site's scheduling contact.";
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
        public Boolean getValueFor(MySiteContact model)
        {
            return model.getSchedulingContact();
        }

        @Override
        public boolean hasValueFor(MySiteContact model, Boolean value)
        {
            return model.hasSchedulingContact(value);
        }
    }

    //##################################################
    //# ShortName
    //##################################################

    public class MyMetaSiteContact_ShortName
        extends KmMetaStringProperty<MySiteContact>
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
        public String getValueFor(MySiteContact model)
        {
            return model.getShortName();
        }

        @Override
        public boolean hasValueFor(MySiteContact model, String value)
        {
            return model.hasShortName(value);
        }
    }

    //##################################################
    //# SummaryMultiline
    //##################################################

    public class MyMetaSiteContact_SummaryMultiline
        extends KmMetaStringProperty<MySiteContact>
    {
        @Override
        public String getName()
        {
            return "summaryMultiline";
        }

        @Override
        public String getLabel()
        {
            return "Summary Multiline";
        }

        @Override
        public String getHelp()
        {
            return "The contact's name, phone, and email formatted into a multiline summary.";
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
        public String getValueFor(MySiteContact model)
        {
            return model.getSummaryMultiline();
        }

        @Override
        public boolean hasValueFor(MySiteContact model, String value)
        {
            return model.hasSummaryMultiline(value);
        }
    }

    //##################################################
    //# TechnicalContact
    //##################################################

    public class MyMetaSiteContact_TechnicalContact
        extends KmMetaBooleanProperty<MySiteContact>
    {
        @Override
        public String getName()
        {
            return "technicalContact";
        }

        @Override
        public String getLabel()
        {
            return "Technical Contact";
        }

        @Override
        public String getHelp()
        {
            return "Indicates if this is the site's technical contact.";
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
        public Boolean getValueFor(MySiteContact model)
        {
            return model.getTechnicalContact();
        }

        @Override
        public boolean hasValueFor(MySiteContact model, Boolean value)
        {
            return model.hasTechnicalContact(value);
        }
    }

    //##################################################
    //# Title
    //##################################################

    public class MyMetaSiteContact_Title
        extends KmMetaStringProperty<MySiteContact>
        implements KmMetaDaoPropertyIF<MySiteContact,String>
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
            return MySiteContactValidator.instance.getTitleValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "title";
        }

        @Override
        public MySiteContactDao getDao()
        {
            return getAccess().getSiteContactDao();
        }

        @Override
        public String getValueFor(MySiteContact model)
        {
            return model.getTitle();
        }

        @Override
        public void setValueFor(MySiteContact model, String value)
        {
            model.setTitle(value);
        }

        @Override
        public boolean hasValueFor(MySiteContact model, String value)
        {
            return model.hasTitle(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaSiteContact_Uid
        extends KmMetaStringProperty<MySiteContact>
        implements KmMetaDaoPropertyIF<MySiteContact,String>
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
            return MySiteContactValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MySiteContactDao getDao()
        {
            return getAccess().getSiteContactDao();
        }

        public KmDaoStringKeyCursor<MySiteContact> createCursor()
        {
            KmDaoStringKeyCursor<MySiteContact> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MySiteContact model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MySiteContact model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MySiteContact model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# UpdatedUtcTs
    //##################################################

    public class MyMetaSiteContact_UpdatedUtcTs
        extends KmMetaTimestampProperty<MySiteContact>
        implements KmMetaDaoPropertyIF<MySiteContact,KmTimestamp>
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
            return MySiteContactValidator.instance.getUpdatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "updatedUtcTs";
        }

        @Override
        public MySiteContactDao getDao()
        {
            return getAccess().getSiteContactDao();
        }

        @Override
        public KmTimestamp getValueFor(MySiteContact model)
        {
            return model.getUpdatedUtcTs();
        }

        @Override
        public void setValueFor(MySiteContact model, KmTimestamp value)
        {
            model.setUpdatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MySiteContact model, KmTimestamp value)
        {
            return model.hasUpdatedUtcTs(value);
        }
    }

    //##################################################
    //# LockVersion
    //##################################################

    public class MyMetaSiteContact_LockVersion
        extends KmMetaIntegerProperty<MySiteContact>
        implements KmMetaDaoPropertyIF<MySiteContact,Integer>
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
            return MySiteContactValidator.instance.getLockVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lockVersion";
        }

        @Override
        public MySiteContactDao getDao()
        {
            return getAccess().getSiteContactDao();
        }

        @Override
        public Integer getValueFor(MySiteContact model)
        {
            return model.getLockVersion();
        }

        @Override
        public void setValueFor(MySiteContact model, Integer value)
        {
            model.setLockVersion(value);
        }

        @Override
        public boolean hasValueFor(MySiteContact model, Integer value)
        {
            return model.hasLockVersion(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaSiteContact_CreatedLocalTs
        extends KmMetaTimestampProperty<MySiteContact>
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
        public KmTimestamp getValueFor(MySiteContact model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MySiteContact model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaSiteContact_CreatedLocalTsMessage
        extends KmMetaStringProperty<MySiteContact>
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
        public String getValueFor(MySiteContact model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MySiteContact model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaSiteContact_CreatedLocalDate
        extends KmMetaDateProperty<MySiteContact>
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
        public KmDate getValueFor(MySiteContact model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MySiteContact model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaSiteContact_CreatedLocalTime
        extends KmMetaTimeProperty<MySiteContact>
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
        public KmTime getValueFor(MySiteContact model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MySiteContact model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }

    //##################################################
    //# UpdatedLocalTs
    //##################################################

    public class MyMetaSiteContact_UpdatedLocalTs
        extends KmMetaTimestampProperty<MySiteContact>
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
        public KmTimestamp getValueFor(MySiteContact model)
        {
            return model.getUpdatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MySiteContact model, KmTimestamp value)
        {
            return model.hasUpdatedLocalTs(value);
        }
    }

    //##################################################
    //# UpdatedLocalTsMessage
    //##################################################

    public class MyMetaSiteContact_UpdatedLocalTsMessage
        extends KmMetaStringProperty<MySiteContact>
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
        public String getValueFor(MySiteContact model)
        {
            return model.getUpdatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MySiteContact model, String value)
        {
            return model.hasUpdatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# UpdatedLocalDate
    //##################################################

    public class MyMetaSiteContact_UpdatedLocalDate
        extends KmMetaDateProperty<MySiteContact>
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
        public KmDate getValueFor(MySiteContact model)
        {
            return model.getUpdatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MySiteContact model, KmDate value)
        {
            return model.hasUpdatedLocalDate(value);
        }
    }

    //##################################################
    //# UpdatedLocalTime
    //##################################################

    public class MyMetaSiteContact_UpdatedLocalTime
        extends KmMetaTimeProperty<MySiteContact>
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
        public KmTime getValueFor(MySiteContact model)
        {
            return model.getUpdatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MySiteContact model, KmTime value)
        {
            return model.hasUpdatedLocalTime(value);
        }
    }

    //##################################################
    //# CreatedByFullName
    //##################################################

    public class MyMetaSiteContact_CreatedByFullName
        extends KmMetaStringProperty<MySiteContact>
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
        public String getValueFor(MySiteContact model)
        {
            return model.getCreatedByFullName();
        }

        @Override
        public void setValueFor(MySiteContact model, String value)
        {
            model.setCreatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MySiteContact model, String value)
        {
            return model.hasCreatedByFullName(value);
        }
    }

    //##################################################
    //# UpdatedByFullName
    //##################################################

    public class MyMetaSiteContact_UpdatedByFullName
        extends KmMetaStringProperty<MySiteContact>
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
        public String getValueFor(MySiteContact model)
        {
            return model.getUpdatedByFullName();
        }

        @Override
        public void setValueFor(MySiteContact model, String value)
        {
            model.setUpdatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MySiteContact model, String value)
        {
            return model.hasUpdatedByFullName(value);
        }
    }


    //##################################################
    //# CreatedBy
    //##################################################

    public class MyMetaSiteContact_CreatedBy
        extends KmMetaDaoAssociation<MySiteContact,MyUser>
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
        public MyUser getValueFor(MySiteContact model)
        {
            return model.getCreatedBy();
        }

        @Override
        public void setValueFor(MySiteContact model, MyUser value)
        {
            model.setCreatedBy(value);
        }

        @Override
        public boolean hasValueFor(MySiteContact model, MyUser value)
        {
            return model.hasCreatedBy(value);
        }
    }

    //##################################################
    //# Site
    //##################################################

    public class MyMetaSiteContact_Site
        extends KmMetaDaoAssociation<MySiteContact,MySite>
    {
        @Override
        public String getName()
        {
            return "site";
        }

        @Override
        public String getLabel()
        {
            return "Site";
        }

        @Override
        public String getHelp()
        {
            return "The job to which this contact belongs.";
        }

        @Override
        public boolean isRequired()
        {
            return true;
        }

        @Override
        public MySite getValueFor(MySiteContact model)
        {
            return model.getSite();
        }

        @Override
        public void setValueFor(MySiteContact model, MySite value)
        {
            model.setSite(value);
        }

        @Override
        public boolean hasValueFor(MySiteContact model, MySite value)
        {
            return model.hasSite(value);
        }
    }

    //##################################################
    //# UpdatedBy
    //##################################################

    public class MyMetaSiteContact_UpdatedBy
        extends KmMetaDaoAssociation<MySiteContact,MyUser>
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
        public MyUser getValueFor(MySiteContact model)
        {
            return model.getUpdatedBy();
        }

        @Override
        public void setValueFor(MySiteContact model, MyUser value)
        {
            model.setUpdatedBy(value);
        }

        @Override
        public boolean hasValueFor(MySiteContact model, MyUser value)
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
