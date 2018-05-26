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

public class MyMetaNote
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaNote instance = new MyMetaNote();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaNote()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "note";
    }

    public MyNoteValidator getValidator()
    {
        return MyNoteValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "Users can record ad hoc notes that relate back to various contexts. Notes for projects, customers, etc.\n Notes are handled as historical logs. Once entered, they cannot be modified or removed.\n Notes may be created manually by a user, or automatically by the system. System notes may often entered on behalf of the current user, but are clearly marked to indicate they were auto-generated.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaNote_AuditLogTitle AuditLogTitle = new MyMetaNote_AuditLogTitle();
    public final MyMetaNote_CreatedUtcTs CreatedUtcTs = new MyMetaNote_CreatedUtcTs();
    public final MyMetaNote_DomainSubtitle DomainSubtitle = new MyMetaNote_DomainSubtitle();
    public final MyMetaNote_DomainTitle DomainTitle = new MyMetaNote_DomainTitle();
    public final MyMetaNote_Message Message = new MyMetaNote_Message();
    public final MyMetaNote_OwnerTitle OwnerTitle = new MyMetaNote_OwnerTitle();
    public final MyMetaNote_OwnerTypeCode OwnerTypeCode = new MyMetaNote_OwnerTypeCode();
    public final MyMetaNote_SourceTypeCode SourceTypeCode = new MyMetaNote_SourceTypeCode();
    public final MyMetaNote_Uid Uid = new MyMetaNote_Uid();
    public final MyMetaNote_UpdatedUtcTs UpdatedUtcTs = new MyMetaNote_UpdatedUtcTs();
    public final MyMetaNote_LockVersion LockVersion = new MyMetaNote_LockVersion();
    public final MyMetaNote_OwnerTypeName OwnerTypeName = new MyMetaNote_OwnerTypeName();
    public final MyMetaNote_SourceTypeName SourceTypeName = new MyMetaNote_SourceTypeName();
    public final MyMetaNote_CreatedLocalTs CreatedLocalTs = new MyMetaNote_CreatedLocalTs();
    public final MyMetaNote_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaNote_CreatedLocalTsMessage();
    public final MyMetaNote_CreatedLocalDate CreatedLocalDate = new MyMetaNote_CreatedLocalDate();
    public final MyMetaNote_CreatedLocalTime CreatedLocalTime = new MyMetaNote_CreatedLocalTime();
    public final MyMetaNote_UpdatedLocalTs UpdatedLocalTs = new MyMetaNote_UpdatedLocalTs();
    public final MyMetaNote_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaNote_UpdatedLocalTsMessage();
    public final MyMetaNote_UpdatedLocalDate UpdatedLocalDate = new MyMetaNote_UpdatedLocalDate();
    public final MyMetaNote_UpdatedLocalTime UpdatedLocalTime = new MyMetaNote_UpdatedLocalTime();
    public final MyMetaNote_CreatedByFullName CreatedByFullName = new MyMetaNote_CreatedByFullName();
    public final MyMetaNote_UpdatedByFullName UpdatedByFullName = new MyMetaNote_UpdatedByFullName();

    //##################################################
    //# associations
    //##################################################

    public final MyMetaNote_CreatedBy CreatedBy = new MyMetaNote_CreatedBy();
    public final MyMetaNote_Customer Customer = new MyMetaNote_Customer();
    public final MyMetaNote_Project Project = new MyMetaNote_Project();
    public final MyMetaNote_Site Site = new MyMetaNote_Site();
    public final MyMetaNote_Tenant Tenant = new MyMetaNote_Tenant();
    public final MyMetaNote_UpdatedBy UpdatedBy = new MyMetaNote_UpdatedBy();

    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaNote_AuditLogTitle
        extends KmMetaStringProperty<MyNote>
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
        public String getValueFor(MyNote model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyNote model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaNote_CreatedUtcTs
        extends KmMetaTimestampProperty<MyNote>
        implements KmMetaDaoPropertyIF<MyNote,KmTimestamp>
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
            return MyNoteValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MyNoteDao getDao()
        {
            return getAccess().getNoteDao();
        }

        @Override
        public KmTimestamp getValueFor(MyNote model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MyNote model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyNote model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaNote_DomainSubtitle
        extends KmMetaStringProperty<MyNote>
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
        public String getValueFor(MyNote model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyNote model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaNote_DomainTitle
        extends KmMetaStringProperty<MyNote>
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
        public String getValueFor(MyNote model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyNote model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# Message
    //##################################################

    public class MyMetaNote_Message
        extends KmMetaStringProperty<MyNote>
        implements KmMetaDaoPropertyIF<MyNote,String>
    {
        @Override
        public String getName()
        {
            return "message";
        }

        @Override
        public String getLabel()
        {
            return "Message";
        }

        @Override
        public String getHelp()
        {
            return "The multiline message.";
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
            return MyNoteValidator.instance.getMessageValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "message";
        }

        @Override
        public MyNoteDao getDao()
        {
            return getAccess().getNoteDao();
        }

        @Override
        public String getValueFor(MyNote model)
        {
            return model.getMessage();
        }

        @Override
        public void setValueFor(MyNote model, String value)
        {
            model.setMessage(value);
        }

        @Override
        public boolean hasValueFor(MyNote model, String value)
        {
            return model.hasMessage(value);
        }
    }

    //##################################################
    //# OwnerTitle
    //##################################################

    public class MyMetaNote_OwnerTitle
        extends KmMetaStringProperty<MyNote>
    {
        @Override
        public String getName()
        {
            return "ownerTitle";
        }

        @Override
        public String getLabel()
        {
            return "Owner";
        }

        @Override
        public String getHelp()
        {
            return "A summary of the note's owner.";
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
        public String getValueFor(MyNote model)
        {
            return model.getOwnerTitle();
        }

        @Override
        public boolean hasValueFor(MyNote model, String value)
        {
            return model.hasOwnerTitle(value);
        }
    }

    //##################################################
    //# OwnerTypeCode
    //##################################################

    public class MyMetaNote_OwnerTypeCode
        extends KmMetaStringProperty<MyNote>
        implements KmMetaDaoPropertyIF<MyNote,String>
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
            return MyNoteValidator.instance.getOwnerTypeCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "ownerTypeCode";
        }

        @Override
        public MyNoteDao getDao()
        {
            return getAccess().getNoteDao();
        }

        public ScDynamicEnumDropdownField newDropdown()
        {
            ScDynamicEnumDropdownField e;
            e = new ScDynamicEnumDropdownField();
            e.setMeta(this);
            e.setEnumArraySupplier(MyNoteOwnerType::values);
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
        public String getValueFor(MyNote model)
        {
            return model.getOwnerTypeCode();
        }

        @Override
        public void setValueFor(MyNote model, String value)
        {
            model.setOwnerTypeCode(value);
        }

        @Override
        public boolean hasValueFor(MyNote model, String value)
        {
            return model.hasOwnerTypeCode(value);
        }
    }

    //##################################################
    //# SourceTypeCode
    //##################################################

    public class MyMetaNote_SourceTypeCode
        extends KmMetaStringProperty<MyNote>
        implements KmMetaDaoPropertyIF<MyNote,String>
    {
        @Override
        public String getName()
        {
            return "sourceTypeCode";
        }

        @Override
        public String getLabel()
        {
            return "Source";
        }

        @Override
        public String getHelp()
        {
            return "The source of note, e.g.: User or System.";
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
            return MyNoteValidator.instance.getSourceTypeCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "sourceTypeCode";
        }

        @Override
        public MyNoteDao getDao()
        {
            return getAccess().getNoteDao();
        }

        public ScDynamicEnumDropdownField newDropdown()
        {
            ScDynamicEnumDropdownField e;
            e = new ScDynamicEnumDropdownField();
            e.setMeta(this);
            e.setEnumArraySupplier(MyNoteSourceType::values);
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
        public String getValueFor(MyNote model)
        {
            return model.getSourceTypeCode();
        }

        @Override
        public void setValueFor(MyNote model, String value)
        {
            model.setSourceTypeCode(value);
        }

        @Override
        public boolean hasValueFor(MyNote model, String value)
        {
            return model.hasSourceTypeCode(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaNote_Uid
        extends KmMetaStringProperty<MyNote>
        implements KmMetaDaoPropertyIF<MyNote,String>
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
            return MyNoteValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyNoteDao getDao()
        {
            return getAccess().getNoteDao();
        }

        public KmDaoStringKeyCursor<MyNote> createCursor()
        {
            KmDaoStringKeyCursor<MyNote> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyNote model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyNote model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyNote model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# UpdatedUtcTs
    //##################################################

    public class MyMetaNote_UpdatedUtcTs
        extends KmMetaTimestampProperty<MyNote>
        implements KmMetaDaoPropertyIF<MyNote,KmTimestamp>
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
            return MyNoteValidator.instance.getUpdatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "updatedUtcTs";
        }

        @Override
        public MyNoteDao getDao()
        {
            return getAccess().getNoteDao();
        }

        @Override
        public KmTimestamp getValueFor(MyNote model)
        {
            return model.getUpdatedUtcTs();
        }

        @Override
        public void setValueFor(MyNote model, KmTimestamp value)
        {
            model.setUpdatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyNote model, KmTimestamp value)
        {
            return model.hasUpdatedUtcTs(value);
        }
    }

    //##################################################
    //# LockVersion
    //##################################################

    public class MyMetaNote_LockVersion
        extends KmMetaIntegerProperty<MyNote>
        implements KmMetaDaoPropertyIF<MyNote,Integer>
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
            return MyNoteValidator.instance.getLockVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lockVersion";
        }

        @Override
        public MyNoteDao getDao()
        {
            return getAccess().getNoteDao();
        }

        @Override
        public Integer getValueFor(MyNote model)
        {
            return model.getLockVersion();
        }

        @Override
        public void setValueFor(MyNote model, Integer value)
        {
            model.setLockVersion(value);
        }

        @Override
        public boolean hasValueFor(MyNote model, Integer value)
        {
            return model.hasLockVersion(value);
        }
    }

    //##################################################
    //# OwnerTypeName
    //##################################################

    public class MyMetaNote_OwnerTypeName
        extends KmMetaStringProperty<MyNote>
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
        public String getValueFor(MyNote model)
        {
            return model.getOwnerTypeName();
        }

        @Override
        public boolean hasValueFor(MyNote model, String value)
        {
            return model.hasOwnerTypeName(value);
        }
    }

    //##################################################
    //# SourceTypeName
    //##################################################

    public class MyMetaNote_SourceTypeName
        extends KmMetaStringProperty<MyNote>
    {
        @Override
        public String getName()
        {
            return "sourceTypeName";
        }

        @Override
        public String getLabel()
        {
            return "Source";
        }

        @Override
        public String getHelp()
        {
            return "The source of note, e.g.: User or System.";
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
        public String getValueFor(MyNote model)
        {
            return model.getSourceTypeName();
        }

        @Override
        public boolean hasValueFor(MyNote model, String value)
        {
            return model.hasSourceTypeName(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaNote_CreatedLocalTs
        extends KmMetaTimestampProperty<MyNote>
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
        public KmTimestamp getValueFor(MyNote model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyNote model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaNote_CreatedLocalTsMessage
        extends KmMetaStringProperty<MyNote>
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
        public String getValueFor(MyNote model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyNote model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaNote_CreatedLocalDate
        extends KmMetaDateProperty<MyNote>
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
        public KmDate getValueFor(MyNote model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyNote model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaNote_CreatedLocalTime
        extends KmMetaTimeProperty<MyNote>
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
        public KmTime getValueFor(MyNote model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyNote model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }

    //##################################################
    //# UpdatedLocalTs
    //##################################################

    public class MyMetaNote_UpdatedLocalTs
        extends KmMetaTimestampProperty<MyNote>
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
        public KmTimestamp getValueFor(MyNote model)
        {
            return model.getUpdatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyNote model, KmTimestamp value)
        {
            return model.hasUpdatedLocalTs(value);
        }
    }

    //##################################################
    //# UpdatedLocalTsMessage
    //##################################################

    public class MyMetaNote_UpdatedLocalTsMessage
        extends KmMetaStringProperty<MyNote>
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
        public String getValueFor(MyNote model)
        {
            return model.getUpdatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyNote model, String value)
        {
            return model.hasUpdatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# UpdatedLocalDate
    //##################################################

    public class MyMetaNote_UpdatedLocalDate
        extends KmMetaDateProperty<MyNote>
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
        public KmDate getValueFor(MyNote model)
        {
            return model.getUpdatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyNote model, KmDate value)
        {
            return model.hasUpdatedLocalDate(value);
        }
    }

    //##################################################
    //# UpdatedLocalTime
    //##################################################

    public class MyMetaNote_UpdatedLocalTime
        extends KmMetaTimeProperty<MyNote>
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
        public KmTime getValueFor(MyNote model)
        {
            return model.getUpdatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyNote model, KmTime value)
        {
            return model.hasUpdatedLocalTime(value);
        }
    }

    //##################################################
    //# CreatedByFullName
    //##################################################

    public class MyMetaNote_CreatedByFullName
        extends KmMetaStringProperty<MyNote>
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
        public String getValueFor(MyNote model)
        {
            return model.getCreatedByFullName();
        }

        @Override
        public void setValueFor(MyNote model, String value)
        {
            model.setCreatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyNote model, String value)
        {
            return model.hasCreatedByFullName(value);
        }
    }

    //##################################################
    //# UpdatedByFullName
    //##################################################

    public class MyMetaNote_UpdatedByFullName
        extends KmMetaStringProperty<MyNote>
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
        public String getValueFor(MyNote model)
        {
            return model.getUpdatedByFullName();
        }

        @Override
        public void setValueFor(MyNote model, String value)
        {
            model.setUpdatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyNote model, String value)
        {
            return model.hasUpdatedByFullName(value);
        }
    }


    //##################################################
    //# CreatedBy
    //##################################################

    public class MyMetaNote_CreatedBy
        extends KmMetaDaoAssociation<MyNote,MyUser>
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
        public MyUser getValueFor(MyNote model)
        {
            return model.getCreatedBy();
        }

        @Override
        public void setValueFor(MyNote model, MyUser value)
        {
            model.setCreatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyNote model, MyUser value)
        {
            return model.hasCreatedBy(value);
        }
    }

    //##################################################
    //# Customer
    //##################################################

    public class MyMetaNote_Customer
        extends KmMetaDaoAssociation<MyNote,MyCustomer>
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
            return "The customer that owns this note.";
        }

        @Override
        public boolean isRequired()
        {
            return false;
        }

        @Override
        public MyCustomer getValueFor(MyNote model)
        {
            return model.getCustomer();
        }

        @Override
        public void setValueFor(MyNote model, MyCustomer value)
        {
            model.setCustomer(value);
        }

        @Override
        public boolean hasValueFor(MyNote model, MyCustomer value)
        {
            return model.hasCustomer(value);
        }
    }

    //##################################################
    //# Project
    //##################################################

    public class MyMetaNote_Project
        extends KmMetaDaoAssociation<MyNote,MyProject>
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
            return "The project that contains this note.";
        }

        @Override
        public boolean isRequired()
        {
            return true;
        }

        @Override
        public MyProject getValueFor(MyNote model)
        {
            return model.getProject();
        }

        @Override
        public void setValueFor(MyNote model, MyProject value)
        {
            model.setProject(value);
        }

        @Override
        public boolean hasValueFor(MyNote model, MyProject value)
        {
            return model.hasProject(value);
        }
    }

    //##################################################
    //# Site
    //##################################################

    public class MyMetaNote_Site
        extends KmMetaDaoAssociation<MyNote,MySite>
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
            return "The site that owns this note.";
        }

        @Override
        public boolean isRequired()
        {
            return false;
        }

        @Override
        public MySite getValueFor(MyNote model)
        {
            return model.getSite();
        }

        @Override
        public void setValueFor(MyNote model, MySite value)
        {
            model.setSite(value);
        }

        @Override
        public boolean hasValueFor(MyNote model, MySite value)
        {
            return model.hasSite(value);
        }
    }

    //##################################################
    //# Tenant
    //##################################################

    public class MyMetaNote_Tenant
        extends KmMetaDaoAssociation<MyNote,MyTenant>
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
            return "The tenant that contains this note.";
        }

        @Override
        public boolean isRequired()
        {
            return true;
        }

        @Override
        public MyTenant getValueFor(MyNote model)
        {
            return model.getTenant();
        }

        @Override
        public void setValueFor(MyNote model, MyTenant value)
        {
            model.setTenant(value);
        }

        @Override
        public boolean hasValueFor(MyNote model, MyTenant value)
        {
            return model.hasTenant(value);
        }
    }

    //##################################################
    //# UpdatedBy
    //##################################################

    public class MyMetaNote_UpdatedBy
        extends KmMetaDaoAssociation<MyNote,MyUser>
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
        public MyUser getValueFor(MyNote model)
        {
            return model.getUpdatedBy();
        }

        @Override
        public void setValueFor(MyNote model, MyUser value)
        {
            model.setUpdatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyNote model, MyUser value)
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
