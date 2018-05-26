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

public class MyMetaEmail
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaEmail instance = new MyMetaEmail();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaEmail()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "email";
    }

    public MyEmailValidator getValidator()
    {
        return MyEmailValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "I am used to manage emails. This allows the application to easily create an email as part of a database transaction, and to subsequently send (and re-send) the email as needed. This also provides a convenient log of emails that were previously sent.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaEmail_AuditLogTitle AuditLogTitle = new MyMetaEmail_AuditLogTitle();
    public final MyMetaEmail_CcAddressesLabel CcAddressesLabel = new MyMetaEmail_CcAddressesLabel();
    public final MyMetaEmail_CreatedUtcTs CreatedUtcTs = new MyMetaEmail_CreatedUtcTs();
    public final MyMetaEmail_DomainSubtitle DomainSubtitle = new MyMetaEmail_DomainSubtitle();
    public final MyMetaEmail_DomainTitle DomainTitle = new MyMetaEmail_DomainTitle();
    public final MyMetaEmail_ErrorNotes ErrorNotes = new MyMetaEmail_ErrorNotes();
    public final MyMetaEmail_FromAddress FromAddress = new MyMetaEmail_FromAddress();
    public final MyMetaEmail_PartsAsHtml PartsAsHtml = new MyMetaEmail_PartsAsHtml();
    public final MyMetaEmail_RecipientSummary RecipientSummary = new MyMetaEmail_RecipientSummary();
    public final MyMetaEmail_SentUtcTs SentUtcTs = new MyMetaEmail_SentUtcTs();
    public final MyMetaEmail_StatusCode StatusCode = new MyMetaEmail_StatusCode();
    public final MyMetaEmail_Subject Subject = new MyMetaEmail_Subject();
    public final MyMetaEmail_ToAddressesLabel ToAddressesLabel = new MyMetaEmail_ToAddressesLabel();
    public final MyMetaEmail_Uid Uid = new MyMetaEmail_Uid();
    public final MyMetaEmail_UpdatedUtcTs UpdatedUtcTs = new MyMetaEmail_UpdatedUtcTs();
    public final MyMetaEmail_LockVersion LockVersion = new MyMetaEmail_LockVersion();
    public final MyMetaEmail_StatusName StatusName = new MyMetaEmail_StatusName();
    public final MyMetaEmail_CreatedLocalTs CreatedLocalTs = new MyMetaEmail_CreatedLocalTs();
    public final MyMetaEmail_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaEmail_CreatedLocalTsMessage();
    public final MyMetaEmail_CreatedLocalDate CreatedLocalDate = new MyMetaEmail_CreatedLocalDate();
    public final MyMetaEmail_CreatedLocalTime CreatedLocalTime = new MyMetaEmail_CreatedLocalTime();
    public final MyMetaEmail_SentLocalTs SentLocalTs = new MyMetaEmail_SentLocalTs();
    public final MyMetaEmail_SentLocalTsMessage SentLocalTsMessage = new MyMetaEmail_SentLocalTsMessage();
    public final MyMetaEmail_SentLocalDate SentLocalDate = new MyMetaEmail_SentLocalDate();
    public final MyMetaEmail_SentLocalTime SentLocalTime = new MyMetaEmail_SentLocalTime();
    public final MyMetaEmail_UpdatedLocalTs UpdatedLocalTs = new MyMetaEmail_UpdatedLocalTs();
    public final MyMetaEmail_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaEmail_UpdatedLocalTsMessage();
    public final MyMetaEmail_UpdatedLocalDate UpdatedLocalDate = new MyMetaEmail_UpdatedLocalDate();
    public final MyMetaEmail_UpdatedLocalTime UpdatedLocalTime = new MyMetaEmail_UpdatedLocalTime();
    public final MyMetaEmail_CreatedByFullName CreatedByFullName = new MyMetaEmail_CreatedByFullName();
    public final MyMetaEmail_UpdatedByFullName UpdatedByFullName = new MyMetaEmail_UpdatedByFullName();

    //##################################################
    //# associations
    //##################################################

    public final MyMetaEmail_CreatedBy CreatedBy = new MyMetaEmail_CreatedBy();
    public final MyMetaEmail_UpdatedBy UpdatedBy = new MyMetaEmail_UpdatedBy();

    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaEmail_AuditLogTitle
        extends KmMetaStringProperty<MyEmail>
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
        public String getValueFor(MyEmail model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyEmail model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# CcAddressesLabel
    //##################################################

    public class MyMetaEmail_CcAddressesLabel
        extends KmMetaStringProperty<MyEmail>
    {
        @Override
        public String getName()
        {
            return "ccAddressesLabel";
        }

        @Override
        public String getLabel()
        {
            return "Cc";
        }

        @Override
        public String getHelp()
        {
            return "A summary of the to addresses.";
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
        public String getValueFor(MyEmail model)
        {
            return model.getCcAddressesLabel();
        }

        @Override
        public boolean hasValueFor(MyEmail model, String value)
        {
            return model.hasCcAddressesLabel(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaEmail_CreatedUtcTs
        extends KmMetaTimestampProperty<MyEmail>
        implements KmMetaDaoPropertyIF<MyEmail,KmTimestamp>
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
            return MyEmailValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MyEmailDao getDao()
        {
            return getAccess().getEmailDao();
        }

        @Override
        public KmTimestamp getValueFor(MyEmail model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MyEmail model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyEmail model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaEmail_DomainSubtitle
        extends KmMetaStringProperty<MyEmail>
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
        public String getValueFor(MyEmail model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyEmail model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaEmail_DomainTitle
        extends KmMetaStringProperty<MyEmail>
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
        public String getValueFor(MyEmail model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyEmail model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# ErrorNotes
    //##################################################

    public class MyMetaEmail_ErrorNotes
        extends KmMetaStringProperty<MyEmail>
        implements KmMetaDaoPropertyIF<MyEmail,String>
    {
        @Override
        public String getName()
        {
            return "errorNotes";
        }

        @Override
        public String getLabel()
        {
            return "Error Notes";
        }

        @Override
        public String getHelp()
        {
            return "Any notes about the error condition.";
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
            return MyEmailValidator.instance.getErrorNotesValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "errorNotes";
        }

        @Override
        public MyEmailDao getDao()
        {
            return getAccess().getEmailDao();
        }

        @Override
        public String getValueFor(MyEmail model)
        {
            return model.getErrorNotes();
        }

        @Override
        public void setValueFor(MyEmail model, String value)
        {
            model.setErrorNotes(value);
        }

        @Override
        public boolean hasValueFor(MyEmail model, String value)
        {
            return model.hasErrorNotes(value);
        }
    }

    //##################################################
    //# FromAddress
    //##################################################

    public class MyMetaEmail_FromAddress
        extends KmMetaStringProperty<MyEmail>
        implements KmMetaDaoPropertyIF<MyEmail,String>
    {
        @Override
        public String getName()
        {
            return "fromAddress";
        }

        @Override
        public String getLabel()
        {
            return "From";
        }

        @Override
        public String getHelp()
        {
            return "The from address.";
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
            return MyEmailValidator.instance.getFromAddressValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "fromAddress";
        }

        @Override
        public MyEmailDao getDao()
        {
            return getAccess().getEmailDao();
        }

        @Override
        public String getValueFor(MyEmail model)
        {
            return model.getFromAddress();
        }

        @Override
        public void setValueFor(MyEmail model, String value)
        {
            model.setFromAddress(value);
        }

        @Override
        public boolean hasValueFor(MyEmail model, String value)
        {
            return model.hasFromAddress(value);
        }
    }

    //##################################################
    //# PartsAsHtml
    //##################################################

    public class MyMetaEmail_PartsAsHtml
        extends KmMetaStringProperty<MyEmail>
    {
        @Override
        public String getName()
        {
            return "partsAsHtml";
        }

        @Override
        public String getLabel()
        {
            return "parts";
        }

        @Override
        public String getHelp()
        {
            return "A summary of the parts, suitable for html literals.";
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
        public String getValueFor(MyEmail model)
        {
            return model.getPartsAsHtml();
        }

        @Override
        public boolean hasValueFor(MyEmail model, String value)
        {
            return model.hasPartsAsHtml(value);
        }
    }

    //##################################################
    //# RecipientSummary
    //##################################################

    public class MyMetaEmail_RecipientSummary
        extends KmMetaStringProperty<MyEmail>
    {
        @Override
        public String getName()
        {
            return "recipientSummary";
        }

        @Override
        public String getLabel()
        {
            return "Recipient Summary";
        }

        @Override
        public String getHelp()
        {
            return "A summary of the recipients.";
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
        public String getValueFor(MyEmail model)
        {
            return model.getRecipientSummary();
        }

        @Override
        public boolean hasValueFor(MyEmail model, String value)
        {
            return model.hasRecipientSummary(value);
        }
    }

    //##################################################
    //# SentUtcTs
    //##################################################

    public class MyMetaEmail_SentUtcTs
        extends KmMetaTimestampProperty<MyEmail>
        implements KmMetaDaoPropertyIF<MyEmail,KmTimestamp>
    {
        @Override
        public String getName()
        {
            return "sentUtcTs";
        }

        @Override
        public String getLabel()
        {
            return "Sent Utc Ts";
        }

        @Override
        public String getHelp()
        {
            return "The date and time when the email was last sent.";
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
            return MyEmailValidator.instance.getSentUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "sentUtcTs";
        }

        @Override
        public MyEmailDao getDao()
        {
            return getAccess().getEmailDao();
        }

        @Override
        public KmTimestamp getValueFor(MyEmail model)
        {
            return model.getSentUtcTs();
        }

        @Override
        public void setValueFor(MyEmail model, KmTimestamp value)
        {
            model.setSentUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyEmail model, KmTimestamp value)
        {
            return model.hasSentUtcTs(value);
        }
    }

    //##################################################
    //# StatusCode
    //##################################################

    public class MyMetaEmail_StatusCode
        extends KmMetaStringProperty<MyEmail>
        implements KmMetaDaoPropertyIF<MyEmail,String>
    {
        @Override
        public String getName()
        {
            return "statusCode";
        }

        @Override
        public String getLabel()
        {
            return "Status Code";
        }

        @Override
        public String getHelp()
        {
            return "The status: draft, ready, pending, sent, error, ignored.";
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
            return MyEmailValidator.instance.getStatusCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "statusCode";
        }

        @Override
        public MyEmailDao getDao()
        {
            return getAccess().getEmailDao();
        }

        public ScDynamicEnumDropdownField newDropdown()
        {
            ScDynamicEnumDropdownField e;
            e = new ScDynamicEnumDropdownField();
            e.setMeta(this);
            e.setEnumArraySupplier(MyEmailStatus::values);
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
        public String getValueFor(MyEmail model)
        {
            return model.getStatusCode();
        }

        @Override
        public void setValueFor(MyEmail model, String value)
        {
            model.setStatusCode(value);
        }

        @Override
        public boolean hasValueFor(MyEmail model, String value)
        {
            return model.hasStatusCode(value);
        }
    }

    //##################################################
    //# Subject
    //##################################################

    public class MyMetaEmail_Subject
        extends KmMetaStringProperty<MyEmail>
        implements KmMetaDaoPropertyIF<MyEmail,String>
    {
        @Override
        public String getName()
        {
            return "subject";
        }

        @Override
        public String getLabel()
        {
            return "Subject";
        }

        @Override
        public String getHelp()
        {
            return "The subject line.";
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
            return MyEmailValidator.instance.getSubjectValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "subject";
        }

        @Override
        public MyEmailDao getDao()
        {
            return getAccess().getEmailDao();
        }

        @Override
        public String getValueFor(MyEmail model)
        {
            return model.getSubject();
        }

        @Override
        public void setValueFor(MyEmail model, String value)
        {
            model.setSubject(value);
        }

        @Override
        public boolean hasValueFor(MyEmail model, String value)
        {
            return model.hasSubject(value);
        }
    }

    //##################################################
    //# ToAddressesLabel
    //##################################################

    public class MyMetaEmail_ToAddressesLabel
        extends KmMetaStringProperty<MyEmail>
    {
        @Override
        public String getName()
        {
            return "toAddressesLabel";
        }

        @Override
        public String getLabel()
        {
            return "To";
        }

        @Override
        public String getHelp()
        {
            return "A summary of the to addresses.";
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
        public String getValueFor(MyEmail model)
        {
            return model.getToAddressesLabel();
        }

        @Override
        public boolean hasValueFor(MyEmail model, String value)
        {
            return model.hasToAddressesLabel(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaEmail_Uid
        extends KmMetaStringProperty<MyEmail>
        implements KmMetaDaoPropertyIF<MyEmail,String>
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
            return MyEmailValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyEmailDao getDao()
        {
            return getAccess().getEmailDao();
        }

        public KmDaoStringKeyCursor<MyEmail> createCursor()
        {
            KmDaoStringKeyCursor<MyEmail> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyEmail model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyEmail model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyEmail model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# UpdatedUtcTs
    //##################################################

    public class MyMetaEmail_UpdatedUtcTs
        extends KmMetaTimestampProperty<MyEmail>
        implements KmMetaDaoPropertyIF<MyEmail,KmTimestamp>
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
            return MyEmailValidator.instance.getUpdatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "updatedUtcTs";
        }

        @Override
        public MyEmailDao getDao()
        {
            return getAccess().getEmailDao();
        }

        @Override
        public KmTimestamp getValueFor(MyEmail model)
        {
            return model.getUpdatedUtcTs();
        }

        @Override
        public void setValueFor(MyEmail model, KmTimestamp value)
        {
            model.setUpdatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyEmail model, KmTimestamp value)
        {
            return model.hasUpdatedUtcTs(value);
        }
    }

    //##################################################
    //# LockVersion
    //##################################################

    public class MyMetaEmail_LockVersion
        extends KmMetaIntegerProperty<MyEmail>
        implements KmMetaDaoPropertyIF<MyEmail,Integer>
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
            return MyEmailValidator.instance.getLockVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lockVersion";
        }

        @Override
        public MyEmailDao getDao()
        {
            return getAccess().getEmailDao();
        }

        @Override
        public Integer getValueFor(MyEmail model)
        {
            return model.getLockVersion();
        }

        @Override
        public void setValueFor(MyEmail model, Integer value)
        {
            model.setLockVersion(value);
        }

        @Override
        public boolean hasValueFor(MyEmail model, Integer value)
        {
            return model.hasLockVersion(value);
        }
    }

    //##################################################
    //# StatusName
    //##################################################

    public class MyMetaEmail_StatusName
        extends KmMetaStringProperty<MyEmail>
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
            return "The status: draft, ready, pending, sent, error, ignored.";
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
        public String getValueFor(MyEmail model)
        {
            return model.getStatusName();
        }

        @Override
        public boolean hasValueFor(MyEmail model, String value)
        {
            return model.hasStatusName(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaEmail_CreatedLocalTs
        extends KmMetaTimestampProperty<MyEmail>
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
        public KmTimestamp getValueFor(MyEmail model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyEmail model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaEmail_CreatedLocalTsMessage
        extends KmMetaStringProperty<MyEmail>
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
        public String getValueFor(MyEmail model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyEmail model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaEmail_CreatedLocalDate
        extends KmMetaDateProperty<MyEmail>
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
        public KmDate getValueFor(MyEmail model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyEmail model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaEmail_CreatedLocalTime
        extends KmMetaTimeProperty<MyEmail>
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
        public KmTime getValueFor(MyEmail model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyEmail model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }

    //##################################################
    //# SentLocalTs
    //##################################################

    public class MyMetaEmail_SentLocalTs
        extends KmMetaTimestampProperty<MyEmail>
    {
        @Override
        public String getName()
        {
            return "sentLocalTs";
        }

        @Override
        public String getLabel()
        {
            return "Sent";
        }

        @Override
        public String getHelp()
        {
            return "The sent timestamp converted to the user's local timezone.";
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
        public KmTimestamp getValueFor(MyEmail model)
        {
            return model.getSentLocalTs();
        }

        @Override
        public boolean hasValueFor(MyEmail model, KmTimestamp value)
        {
            return model.hasSentLocalTs(value);
        }
    }

    //##################################################
    //# SentLocalTsMessage
    //##################################################

    public class MyMetaEmail_SentLocalTsMessage
        extends KmMetaStringProperty<MyEmail>
    {
        @Override
        public String getName()
        {
            return "sentLocalTsMessage";
        }

        @Override
        public String getLabel()
        {
            return "Sent";
        }

        @Override
        public String getHelp()
        {
            return "The sent timestamp converted to the user's local timezone, and formatted as a string that includes the timezone code.";
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
        public String getValueFor(MyEmail model)
        {
            return model.getSentLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyEmail model, String value)
        {
            return model.hasSentLocalTsMessage(value);
        }
    }

    //##################################################
    //# SentLocalDate
    //##################################################

    public class MyMetaEmail_SentLocalDate
        extends KmMetaDateProperty<MyEmail>
    {
        @Override
        public String getName()
        {
            return "sentLocalDate";
        }

        @Override
        public String getLabel()
        {
            return "Sent";
        }

        @Override
        public String getHelp()
        {
            return "The sent date based on the user's local timezone.";
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
        public KmDate getValueFor(MyEmail model)
        {
            return model.getSentLocalDate();
        }

        @Override
        public boolean hasValueFor(MyEmail model, KmDate value)
        {
            return model.hasSentLocalDate(value);
        }
    }

    //##################################################
    //# SentLocalTime
    //##################################################

    public class MyMetaEmail_SentLocalTime
        extends KmMetaTimeProperty<MyEmail>
    {
        @Override
        public String getName()
        {
            return "sentLocalTime";
        }

        @Override
        public String getLabel()
        {
            return "Sent";
        }

        @Override
        public String getHelp()
        {
            return "The sent time of day based on the user's local timezone.";
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
        public KmTime getValueFor(MyEmail model)
        {
            return model.getSentLocalTime();
        }

        @Override
        public boolean hasValueFor(MyEmail model, KmTime value)
        {
            return model.hasSentLocalTime(value);
        }
    }

    //##################################################
    //# UpdatedLocalTs
    //##################################################

    public class MyMetaEmail_UpdatedLocalTs
        extends KmMetaTimestampProperty<MyEmail>
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
        public KmTimestamp getValueFor(MyEmail model)
        {
            return model.getUpdatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyEmail model, KmTimestamp value)
        {
            return model.hasUpdatedLocalTs(value);
        }
    }

    //##################################################
    //# UpdatedLocalTsMessage
    //##################################################

    public class MyMetaEmail_UpdatedLocalTsMessage
        extends KmMetaStringProperty<MyEmail>
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
        public String getValueFor(MyEmail model)
        {
            return model.getUpdatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyEmail model, String value)
        {
            return model.hasUpdatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# UpdatedLocalDate
    //##################################################

    public class MyMetaEmail_UpdatedLocalDate
        extends KmMetaDateProperty<MyEmail>
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
        public KmDate getValueFor(MyEmail model)
        {
            return model.getUpdatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyEmail model, KmDate value)
        {
            return model.hasUpdatedLocalDate(value);
        }
    }

    //##################################################
    //# UpdatedLocalTime
    //##################################################

    public class MyMetaEmail_UpdatedLocalTime
        extends KmMetaTimeProperty<MyEmail>
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
        public KmTime getValueFor(MyEmail model)
        {
            return model.getUpdatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyEmail model, KmTime value)
        {
            return model.hasUpdatedLocalTime(value);
        }
    }

    //##################################################
    //# CreatedByFullName
    //##################################################

    public class MyMetaEmail_CreatedByFullName
        extends KmMetaStringProperty<MyEmail>
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
        public String getValueFor(MyEmail model)
        {
            return model.getCreatedByFullName();
        }

        @Override
        public void setValueFor(MyEmail model, String value)
        {
            model.setCreatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyEmail model, String value)
        {
            return model.hasCreatedByFullName(value);
        }
    }

    //##################################################
    //# UpdatedByFullName
    //##################################################

    public class MyMetaEmail_UpdatedByFullName
        extends KmMetaStringProperty<MyEmail>
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
        public String getValueFor(MyEmail model)
        {
            return model.getUpdatedByFullName();
        }

        @Override
        public void setValueFor(MyEmail model, String value)
        {
            model.setUpdatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyEmail model, String value)
        {
            return model.hasUpdatedByFullName(value);
        }
    }


    //##################################################
    //# CreatedBy
    //##################################################

    public class MyMetaEmail_CreatedBy
        extends KmMetaDaoAssociation<MyEmail,MyUser>
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
        public MyUser getValueFor(MyEmail model)
        {
            return model.getCreatedBy();
        }

        @Override
        public void setValueFor(MyEmail model, MyUser value)
        {
            model.setCreatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyEmail model, MyUser value)
        {
            return model.hasCreatedBy(value);
        }
    }

    //##################################################
    //# UpdatedBy
    //##################################################

    public class MyMetaEmail_UpdatedBy
        extends KmMetaDaoAssociation<MyEmail,MyUser>
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
        public MyUser getValueFor(MyEmail model)
        {
            return model.getUpdatedBy();
        }

        @Override
        public void setValueFor(MyEmail model, MyUser value)
        {
            model.setUpdatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyEmail model, MyUser value)
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
