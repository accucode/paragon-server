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

public class MyMetaCustomerContact
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaCustomerContact instance = new MyMetaCustomerContact();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaCustomerContact()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "customerContact";
    }

    public MyCustomerContactValidator getValidator()
    {
        return MyCustomerContactValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "The contacts associated with a particular customer.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaCustomerContact_ApprovalContact ApprovalContact = new MyMetaCustomerContact_ApprovalContact();
    public final MyMetaCustomerContact_AuditLogTitle AuditLogTitle = new MyMetaCustomerContact_AuditLogTitle();
    public final MyMetaCustomerContact_BillingContact BillingContact = new MyMetaCustomerContact_BillingContact();
    public final MyMetaCustomerContact_CreatedUtcTs CreatedUtcTs = new MyMetaCustomerContact_CreatedUtcTs();
    public final MyMetaCustomerContact_DomainSubtitle DomainSubtitle = new MyMetaCustomerContact_DomainSubtitle();
    public final MyMetaCustomerContact_DomainTitle DomainTitle = new MyMetaCustomerContact_DomainTitle();
    public final MyMetaCustomerContact_Email Email = new MyMetaCustomerContact_Email();
    public final MyMetaCustomerContact_FirstName FirstName = new MyMetaCustomerContact_FirstName();
    public final MyMetaCustomerContact_FormalName FormalName = new MyMetaCustomerContact_FormalName();
    public final MyMetaCustomerContact_FullName FullName = new MyMetaCustomerContact_FullName();
    public final MyMetaCustomerContact_LastName LastName = new MyMetaCustomerContact_LastName();
    public final MyMetaCustomerContact_LongName LongName = new MyMetaCustomerContact_LongName();
    public final MyMetaCustomerContact_Nickname Nickname = new MyMetaCustomerContact_Nickname();
    public final MyMetaCustomerContact_Phone Phone = new MyMetaCustomerContact_Phone();
    public final MyMetaCustomerContact_ShortName ShortName = new MyMetaCustomerContact_ShortName();
    public final MyMetaCustomerContact_SummaryMultiline SummaryMultiline = new MyMetaCustomerContact_SummaryMultiline();
    public final MyMetaCustomerContact_Title Title = new MyMetaCustomerContact_Title();
    public final MyMetaCustomerContact_Uid Uid = new MyMetaCustomerContact_Uid();
    public final MyMetaCustomerContact_UpdatedUtcTs UpdatedUtcTs = new MyMetaCustomerContact_UpdatedUtcTs();
    public final MyMetaCustomerContact_LockVersion LockVersion = new MyMetaCustomerContact_LockVersion();
    public final MyMetaCustomerContact_CreatedLocalTs CreatedLocalTs = new MyMetaCustomerContact_CreatedLocalTs();
    public final MyMetaCustomerContact_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaCustomerContact_CreatedLocalTsMessage();
    public final MyMetaCustomerContact_CreatedLocalDate CreatedLocalDate = new MyMetaCustomerContact_CreatedLocalDate();
    public final MyMetaCustomerContact_CreatedLocalTime CreatedLocalTime = new MyMetaCustomerContact_CreatedLocalTime();
    public final MyMetaCustomerContact_UpdatedLocalTs UpdatedLocalTs = new MyMetaCustomerContact_UpdatedLocalTs();
    public final MyMetaCustomerContact_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaCustomerContact_UpdatedLocalTsMessage();
    public final MyMetaCustomerContact_UpdatedLocalDate UpdatedLocalDate = new MyMetaCustomerContact_UpdatedLocalDate();
    public final MyMetaCustomerContact_UpdatedLocalTime UpdatedLocalTime = new MyMetaCustomerContact_UpdatedLocalTime();
    public final MyMetaCustomerContact_CreatedByFullName CreatedByFullName = new MyMetaCustomerContact_CreatedByFullName();
    public final MyMetaCustomerContact_UpdatedByFullName UpdatedByFullName = new MyMetaCustomerContact_UpdatedByFullName();

    //##################################################
    //# associations
    //##################################################

    public final MyMetaCustomerContact_CreatedBy CreatedBy = new MyMetaCustomerContact_CreatedBy();
    public final MyMetaCustomerContact_Customer Customer = new MyMetaCustomerContact_Customer();
    public final MyMetaCustomerContact_UpdatedBy UpdatedBy = new MyMetaCustomerContact_UpdatedBy();

    //##################################################
    //# ApprovalContact
    //##################################################

    public class MyMetaCustomerContact_ApprovalContact
        extends KmMetaBooleanProperty<MyCustomerContact>
    {
        @Override
        public String getName()
        {
            return "approvalContact";
        }

        @Override
        public String getLabel()
        {
            return "Approval Contact";
        }

        @Override
        public String getHelp()
        {
            return "Indicates if this is the customer's approval contact.";
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
        public Boolean getValueFor(MyCustomerContact model)
        {
            return model.getApprovalContact();
        }

        @Override
        public boolean hasValueFor(MyCustomerContact model, Boolean value)
        {
            return model.hasApprovalContact(value);
        }
    }

    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaCustomerContact_AuditLogTitle
        extends KmMetaStringProperty<MyCustomerContact>
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
        public String getValueFor(MyCustomerContact model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyCustomerContact model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# BillingContact
    //##################################################

    public class MyMetaCustomerContact_BillingContact
        extends KmMetaBooleanProperty<MyCustomerContact>
    {
        @Override
        public String getName()
        {
            return "billingContact";
        }

        @Override
        public String getLabel()
        {
            return "Billing Contact";
        }

        @Override
        public String getHelp()
        {
            return "Indicates if this is the customer's billing contact.";
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
        public Boolean getValueFor(MyCustomerContact model)
        {
            return model.getBillingContact();
        }

        @Override
        public boolean hasValueFor(MyCustomerContact model, Boolean value)
        {
            return model.hasBillingContact(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaCustomerContact_CreatedUtcTs
        extends KmMetaTimestampProperty<MyCustomerContact>
        implements KmMetaDaoPropertyIF<MyCustomerContact,KmTimestamp>
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
            return MyCustomerContactValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MyCustomerContactDao getDao()
        {
            return getAccess().getCustomerContactDao();
        }

        @Override
        public KmTimestamp getValueFor(MyCustomerContact model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MyCustomerContact model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyCustomerContact model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaCustomerContact_DomainSubtitle
        extends KmMetaStringProperty<MyCustomerContact>
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
        public String getValueFor(MyCustomerContact model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyCustomerContact model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaCustomerContact_DomainTitle
        extends KmMetaStringProperty<MyCustomerContact>
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
        public String getValueFor(MyCustomerContact model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyCustomerContact model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# Email
    //##################################################

    public class MyMetaCustomerContact_Email
        extends KmMetaStringProperty<MyCustomerContact>
        implements KmMetaDaoPropertyIF<MyCustomerContact,String>
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
            return MyCustomerContactValidator.instance.getEmailValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "email";
        }

        @Override
        public MyCustomerContactDao getDao()
        {
            return getAccess().getCustomerContactDao();
        }

        @Override
        public String getValueFor(MyCustomerContact model)
        {
            return model.getEmail();
        }

        @Override
        public void setValueFor(MyCustomerContact model, String value)
        {
            model.setEmail(value);
        }

        @Override
        public boolean hasValueFor(MyCustomerContact model, String value)
        {
            return model.hasEmail(value);
        }
    }

    //##################################################
    //# FirstName
    //##################################################

    public class MyMetaCustomerContact_FirstName
        extends KmMetaStringProperty<MyCustomerContact>
        implements KmMetaDaoPropertyIF<MyCustomerContact,String>
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
            return MyCustomerContactValidator.instance.getFirstNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "firstName";
        }

        @Override
        public MyCustomerContactDao getDao()
        {
            return getAccess().getCustomerContactDao();
        }

        @Override
        public String getValueFor(MyCustomerContact model)
        {
            return model.getFirstName();
        }

        @Override
        public void setValueFor(MyCustomerContact model, String value)
        {
            model.setFirstName(value);
        }

        @Override
        public boolean hasValueFor(MyCustomerContact model, String value)
        {
            return model.hasFirstName(value);
        }
    }

    //##################################################
    //# FormalName
    //##################################################

    public class MyMetaCustomerContact_FormalName
        extends KmMetaStringProperty<MyCustomerContact>
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
        public String getValueFor(MyCustomerContact model)
        {
            return model.getFormalName();
        }

        @Override
        public boolean hasValueFor(MyCustomerContact model, String value)
        {
            return model.hasFormalName(value);
        }
    }

    //##################################################
    //# FullName
    //##################################################

    public class MyMetaCustomerContact_FullName
        extends KmMetaStringProperty<MyCustomerContact>
        implements KmMetaDaoPropertyIF<MyCustomerContact,String>
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
            return MyCustomerContactValidator.instance.getFullNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "fullName";
        }

        @Override
        public MyCustomerContactDao getDao()
        {
            return getAccess().getCustomerContactDao();
        }

        @Override
        public String getValueFor(MyCustomerContact model)
        {
            return model.getFullName();
        }

        @Override
        public void setValueFor(MyCustomerContact model, String value)
        {
            model.setFullName(value);
        }

        @Override
        public boolean hasValueFor(MyCustomerContact model, String value)
        {
            return model.hasFullName(value);
        }
    }

    //##################################################
    //# LastName
    //##################################################

    public class MyMetaCustomerContact_LastName
        extends KmMetaStringProperty<MyCustomerContact>
        implements KmMetaDaoPropertyIF<MyCustomerContact,String>
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
            return MyCustomerContactValidator.instance.getLastNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lastName";
        }

        @Override
        public MyCustomerContactDao getDao()
        {
            return getAccess().getCustomerContactDao();
        }

        @Override
        public String getValueFor(MyCustomerContact model)
        {
            return model.getLastName();
        }

        @Override
        public void setValueFor(MyCustomerContact model, String value)
        {
            model.setLastName(value);
        }

        @Override
        public boolean hasValueFor(MyCustomerContact model, String value)
        {
            return model.hasLastName(value);
        }
    }

    //##################################################
    //# LongName
    //##################################################

    public class MyMetaCustomerContact_LongName
        extends KmMetaStringProperty<MyCustomerContact>
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
        public String getValueFor(MyCustomerContact model)
        {
            return model.getLongName();
        }

        @Override
        public boolean hasValueFor(MyCustomerContact model, String value)
        {
            return model.hasLongName(value);
        }
    }

    //##################################################
    //# Nickname
    //##################################################

    public class MyMetaCustomerContact_Nickname
        extends KmMetaStringProperty<MyCustomerContact>
        implements KmMetaDaoPropertyIF<MyCustomerContact,String>
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
            return MyCustomerContactValidator.instance.getNicknameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "nickname";
        }

        @Override
        public MyCustomerContactDao getDao()
        {
            return getAccess().getCustomerContactDao();
        }

        @Override
        public String getValueFor(MyCustomerContact model)
        {
            return model.getNickname();
        }

        @Override
        public void setValueFor(MyCustomerContact model, String value)
        {
            model.setNickname(value);
        }

        @Override
        public boolean hasValueFor(MyCustomerContact model, String value)
        {
            return model.hasNickname(value);
        }
    }

    //##################################################
    //# Phone
    //##################################################

    public class MyMetaCustomerContact_Phone
        extends KmMetaStringProperty<MyCustomerContact>
        implements KmMetaDaoPropertyIF<MyCustomerContact,String>
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
            return MyCustomerContactValidator.instance.getPhoneValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "phone";
        }

        @Override
        public MyCustomerContactDao getDao()
        {
            return getAccess().getCustomerContactDao();
        }

        @Override
        public String getValueFor(MyCustomerContact model)
        {
            return model.getPhone();
        }

        @Override
        public void setValueFor(MyCustomerContact model, String value)
        {
            model.setPhone(value);
        }

        @Override
        public boolean hasValueFor(MyCustomerContact model, String value)
        {
            return model.hasPhone(value);
        }
    }

    //##################################################
    //# ShortName
    //##################################################

    public class MyMetaCustomerContact_ShortName
        extends KmMetaStringProperty<MyCustomerContact>
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
        public String getValueFor(MyCustomerContact model)
        {
            return model.getShortName();
        }

        @Override
        public boolean hasValueFor(MyCustomerContact model, String value)
        {
            return model.hasShortName(value);
        }
    }

    //##################################################
    //# SummaryMultiline
    //##################################################

    public class MyMetaCustomerContact_SummaryMultiline
        extends KmMetaStringProperty<MyCustomerContact>
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
        public String getValueFor(MyCustomerContact model)
        {
            return model.getSummaryMultiline();
        }

        @Override
        public boolean hasValueFor(MyCustomerContact model, String value)
        {
            return model.hasSummaryMultiline(value);
        }
    }

    //##################################################
    //# Title
    //##################################################

    public class MyMetaCustomerContact_Title
        extends KmMetaStringProperty<MyCustomerContact>
        implements KmMetaDaoPropertyIF<MyCustomerContact,String>
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
            return MyCustomerContactValidator.instance.getTitleValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "title";
        }

        @Override
        public MyCustomerContactDao getDao()
        {
            return getAccess().getCustomerContactDao();
        }

        @Override
        public String getValueFor(MyCustomerContact model)
        {
            return model.getTitle();
        }

        @Override
        public void setValueFor(MyCustomerContact model, String value)
        {
            model.setTitle(value);
        }

        @Override
        public boolean hasValueFor(MyCustomerContact model, String value)
        {
            return model.hasTitle(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaCustomerContact_Uid
        extends KmMetaStringProperty<MyCustomerContact>
        implements KmMetaDaoPropertyIF<MyCustomerContact,String>
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
            return MyCustomerContactValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyCustomerContactDao getDao()
        {
            return getAccess().getCustomerContactDao();
        }

        public KmDaoStringKeyCursor<MyCustomerContact> createCursor()
        {
            KmDaoStringKeyCursor<MyCustomerContact> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyCustomerContact model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyCustomerContact model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyCustomerContact model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# UpdatedUtcTs
    //##################################################

    public class MyMetaCustomerContact_UpdatedUtcTs
        extends KmMetaTimestampProperty<MyCustomerContact>
        implements KmMetaDaoPropertyIF<MyCustomerContact,KmTimestamp>
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
            return MyCustomerContactValidator.instance.getUpdatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "updatedUtcTs";
        }

        @Override
        public MyCustomerContactDao getDao()
        {
            return getAccess().getCustomerContactDao();
        }

        @Override
        public KmTimestamp getValueFor(MyCustomerContact model)
        {
            return model.getUpdatedUtcTs();
        }

        @Override
        public void setValueFor(MyCustomerContact model, KmTimestamp value)
        {
            model.setUpdatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyCustomerContact model, KmTimestamp value)
        {
            return model.hasUpdatedUtcTs(value);
        }
    }

    //##################################################
    //# LockVersion
    //##################################################

    public class MyMetaCustomerContact_LockVersion
        extends KmMetaIntegerProperty<MyCustomerContact>
        implements KmMetaDaoPropertyIF<MyCustomerContact,Integer>
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
            return MyCustomerContactValidator.instance.getLockVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lockVersion";
        }

        @Override
        public MyCustomerContactDao getDao()
        {
            return getAccess().getCustomerContactDao();
        }

        @Override
        public Integer getValueFor(MyCustomerContact model)
        {
            return model.getLockVersion();
        }

        @Override
        public void setValueFor(MyCustomerContact model, Integer value)
        {
            model.setLockVersion(value);
        }

        @Override
        public boolean hasValueFor(MyCustomerContact model, Integer value)
        {
            return model.hasLockVersion(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaCustomerContact_CreatedLocalTs
        extends KmMetaTimestampProperty<MyCustomerContact>
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
        public KmTimestamp getValueFor(MyCustomerContact model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyCustomerContact model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaCustomerContact_CreatedLocalTsMessage
        extends KmMetaStringProperty<MyCustomerContact>
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
        public String getValueFor(MyCustomerContact model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyCustomerContact model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaCustomerContact_CreatedLocalDate
        extends KmMetaDateProperty<MyCustomerContact>
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
        public KmDate getValueFor(MyCustomerContact model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyCustomerContact model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaCustomerContact_CreatedLocalTime
        extends KmMetaTimeProperty<MyCustomerContact>
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
        public KmTime getValueFor(MyCustomerContact model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyCustomerContact model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }

    //##################################################
    //# UpdatedLocalTs
    //##################################################

    public class MyMetaCustomerContact_UpdatedLocalTs
        extends KmMetaTimestampProperty<MyCustomerContact>
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
        public KmTimestamp getValueFor(MyCustomerContact model)
        {
            return model.getUpdatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyCustomerContact model, KmTimestamp value)
        {
            return model.hasUpdatedLocalTs(value);
        }
    }

    //##################################################
    //# UpdatedLocalTsMessage
    //##################################################

    public class MyMetaCustomerContact_UpdatedLocalTsMessage
        extends KmMetaStringProperty<MyCustomerContact>
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
        public String getValueFor(MyCustomerContact model)
        {
            return model.getUpdatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyCustomerContact model, String value)
        {
            return model.hasUpdatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# UpdatedLocalDate
    //##################################################

    public class MyMetaCustomerContact_UpdatedLocalDate
        extends KmMetaDateProperty<MyCustomerContact>
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
        public KmDate getValueFor(MyCustomerContact model)
        {
            return model.getUpdatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyCustomerContact model, KmDate value)
        {
            return model.hasUpdatedLocalDate(value);
        }
    }

    //##################################################
    //# UpdatedLocalTime
    //##################################################

    public class MyMetaCustomerContact_UpdatedLocalTime
        extends KmMetaTimeProperty<MyCustomerContact>
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
        public KmTime getValueFor(MyCustomerContact model)
        {
            return model.getUpdatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyCustomerContact model, KmTime value)
        {
            return model.hasUpdatedLocalTime(value);
        }
    }

    //##################################################
    //# CreatedByFullName
    //##################################################

    public class MyMetaCustomerContact_CreatedByFullName
        extends KmMetaStringProperty<MyCustomerContact>
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
        public String getValueFor(MyCustomerContact model)
        {
            return model.getCreatedByFullName();
        }

        @Override
        public void setValueFor(MyCustomerContact model, String value)
        {
            model.setCreatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyCustomerContact model, String value)
        {
            return model.hasCreatedByFullName(value);
        }
    }

    //##################################################
    //# UpdatedByFullName
    //##################################################

    public class MyMetaCustomerContact_UpdatedByFullName
        extends KmMetaStringProperty<MyCustomerContact>
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
        public String getValueFor(MyCustomerContact model)
        {
            return model.getUpdatedByFullName();
        }

        @Override
        public void setValueFor(MyCustomerContact model, String value)
        {
            model.setUpdatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyCustomerContact model, String value)
        {
            return model.hasUpdatedByFullName(value);
        }
    }


    //##################################################
    //# CreatedBy
    //##################################################

    public class MyMetaCustomerContact_CreatedBy
        extends KmMetaDaoAssociation<MyCustomerContact,MyUser>
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
        public MyUser getValueFor(MyCustomerContact model)
        {
            return model.getCreatedBy();
        }

        @Override
        public void setValueFor(MyCustomerContact model, MyUser value)
        {
            model.setCreatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyCustomerContact model, MyUser value)
        {
            return model.hasCreatedBy(value);
        }
    }

    //##################################################
    //# Customer
    //##################################################

    public class MyMetaCustomerContact_Customer
        extends KmMetaDaoAssociation<MyCustomerContact,MyCustomer>
    {
        @Override
        public String getName()
        {
            return "customer";
        }

        @Override
        public String getLabel()
        {
            return "Customer";
        }

        @Override
        public String getHelp()
        {
            return "The customer to which this contact belongs.";
        }

        @Override
        public boolean isRequired()
        {
            return true;
        }

        @Override
        public MyCustomer getValueFor(MyCustomerContact model)
        {
            return model.getCustomer();
        }

        @Override
        public void setValueFor(MyCustomerContact model, MyCustomer value)
        {
            model.setCustomer(value);
        }

        @Override
        public boolean hasValueFor(MyCustomerContact model, MyCustomer value)
        {
            return model.hasCustomer(value);
        }
    }

    //##################################################
    //# UpdatedBy
    //##################################################

    public class MyMetaCustomerContact_UpdatedBy
        extends KmMetaDaoAssociation<MyCustomerContact,MyUser>
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
        public MyUser getValueFor(MyCustomerContact model)
        {
            return model.getUpdatedBy();
        }

        @Override
        public void setValueFor(MyCustomerContact model, MyUser value)
        {
            model.setUpdatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyCustomerContact model, MyUser value)
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
