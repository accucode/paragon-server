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

public class MyMetaDownload
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaDownload instance = new MyMetaDownload();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaDownload()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "download";
    }

    public MyDownloadValidator getValidator()
    {
        return MyDownloadValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "I am used to manage file downloads to the client browser. When the client requests a download, the server first prepares and saves the requested download. The client is then shown a dialog and prompted to download the file.\n The mechanism for downloading files through the browser is not directly compatible with our AJAX approach to a single page application, but this two part approach lets us manage it fairly cleanly.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaDownload_AuditLogTitle AuditLogTitle = new MyMetaDownload_AuditLogTitle();
    public final MyMetaDownload_Bytes Bytes = new MyMetaDownload_Bytes();
    public final MyMetaDownload_CreatedUtcTs CreatedUtcTs = new MyMetaDownload_CreatedUtcTs();
    public final MyMetaDownload_DomainSubtitle DomainSubtitle = new MyMetaDownload_DomainSubtitle();
    public final MyMetaDownload_DomainTitle DomainTitle = new MyMetaDownload_DomainTitle();
    public final MyMetaDownload_FileName FileName = new MyMetaDownload_FileName();
    public final MyMetaDownload_Name Name = new MyMetaDownload_Name();
    public final MyMetaDownload_TypeCode TypeCode = new MyMetaDownload_TypeCode();
    public final MyMetaDownload_Uid Uid = new MyMetaDownload_Uid();
    public final MyMetaDownload_LockVersion LockVersion = new MyMetaDownload_LockVersion();
    public final MyMetaDownload_TypeName TypeName = new MyMetaDownload_TypeName();
    public final MyMetaDownload_CreatedLocalTs CreatedLocalTs = new MyMetaDownload_CreatedLocalTs();
    public final MyMetaDownload_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaDownload_CreatedLocalTsMessage();
    public final MyMetaDownload_CreatedLocalDate CreatedLocalDate = new MyMetaDownload_CreatedLocalDate();
    public final MyMetaDownload_CreatedLocalTime CreatedLocalTime = new MyMetaDownload_CreatedLocalTime();

    //##################################################
    //# associations
    //##################################################

    public final MyMetaDownload_Attachment Attachment = new MyMetaDownload_Attachment();
    public final MyMetaDownload_User User = new MyMetaDownload_User();

    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaDownload_AuditLogTitle
        extends KmMetaStringProperty<MyDownload>
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
        public String getValueFor(MyDownload model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyDownload model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# Bytes
    //##################################################

    public class MyMetaDownload_Bytes
        extends KmMetaBlobProperty<MyDownload>
        implements KmMetaDaoPropertyIF<MyDownload,KmBlob>
    {
        @Override
        public String getName()
        {
            return "bytes";
        }

        @Override
        public String getLabel()
        {
            return "Bytes";
        }

        @Override
        public String getHelp()
        {
            return "The binary content stored directly in the database. Long-term this should be switched to Amazon s3.";
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
        public KmBlobValidator getValidator()
        {
            return MyDownloadValidator.instance.getBytesValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "bytes";
        }

        @Override
        public MyDownloadDao getDao()
        {
            return getAccess().getDownloadDao();
        }

        @Override
        public KmBlob getValueFor(MyDownload model)
        {
            return model.getBytes();
        }

        @Override
        public void setValueFor(MyDownload model, KmBlob value)
        {
            model.setBytes(value);
        }

        @Override
        public boolean hasValueFor(MyDownload model, KmBlob value)
        {
            return model.hasBytes(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaDownload_CreatedUtcTs
        extends KmMetaTimestampProperty<MyDownload>
        implements KmMetaDaoPropertyIF<MyDownload,KmTimestamp>
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
            return MyDownloadValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MyDownloadDao getDao()
        {
            return getAccess().getDownloadDao();
        }

        @Override
        public KmTimestamp getValueFor(MyDownload model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MyDownload model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyDownload model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaDownload_DomainSubtitle
        extends KmMetaStringProperty<MyDownload>
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
        public String getValueFor(MyDownload model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyDownload model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaDownload_DomainTitle
        extends KmMetaStringProperty<MyDownload>
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
        public String getValueFor(MyDownload model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyDownload model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# FileName
    //##################################################

    public class MyMetaDownload_FileName
        extends KmMetaStringProperty<MyDownload>
        implements KmMetaDaoPropertyIF<MyDownload,String>
    {
        @Override
        public String getName()
        {
            return "fileName";
        }

        @Override
        public String getLabel()
        {
            return "File Name";
        }

        @Override
        public String getHelp()
        {
            return "The name of the file to be downloaded. This is only used if the type is File.";
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
            return MyDownloadValidator.instance.getFileNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "fileName";
        }

        @Override
        public MyDownloadDao getDao()
        {
            return getAccess().getDownloadDao();
        }

        @Override
        public String getValueFor(MyDownload model)
        {
            return model.getFileName();
        }

        @Override
        public void setValueFor(MyDownload model, String value)
        {
            model.setFileName(value);
        }

        @Override
        public boolean hasValueFor(MyDownload model, String value)
        {
            return model.hasFileName(value);
        }
    }

    //##################################################
    //# Name
    //##################################################

    public class MyMetaDownload_Name
        extends KmMetaStringProperty<MyDownload>
        implements KmMetaDaoPropertyIF<MyDownload,String>
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
            return "The display name of this download. This is used for all types of download. In particular, note that the Name may not match the name of the file and/or attachment.";
        }

        @Override
        public int getColumnWidth()
        {
            return 25;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyDownloadValidator.instance.getNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "name";
        }

        @Override
        public MyDownloadDao getDao()
        {
            return getAccess().getDownloadDao();
        }

        @Override
        public String getValueFor(MyDownload model)
        {
            return model.getName();
        }

        @Override
        public void setValueFor(MyDownload model, String value)
        {
            model.setName(value);
        }

        @Override
        public boolean hasValueFor(MyDownload model, String value)
        {
            return model.hasName(value);
        }
    }

    //##################################################
    //# TypeCode
    //##################################################

    public class MyMetaDownload_TypeCode
        extends KmMetaStringProperty<MyDownload>
        implements KmMetaDaoPropertyIF<MyDownload,String>
    {
        @Override
        public String getName()
        {
            return "typeCode";
        }

        @Override
        public String getLabel()
        {
            return "Type";
        }

        @Override
        public String getHelp()
        {
            return "The type of download.\n\n File, use the local file system.\n\n Attachment, use the specified attachment.\n\n Bytes, use the byte data stored dirctly in this record.";
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
            return MyDownloadValidator.instance.getTypeCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "typeCode";
        }

        @Override
        public MyDownloadDao getDao()
        {
            return getAccess().getDownloadDao();
        }

        public ScDynamicEnumDropdownField newDropdown()
        {
            ScDynamicEnumDropdownField e;
            e = new ScDynamicEnumDropdownField();
            e.setMeta(this);
            e.setEnumArraySupplier(MyDownloadType::values);
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
        public String getValueFor(MyDownload model)
        {
            return model.getTypeCode();
        }

        @Override
        public void setValueFor(MyDownload model, String value)
        {
            model.setTypeCode(value);
        }

        @Override
        public boolean hasValueFor(MyDownload model, String value)
        {
            return model.hasTypeCode(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaDownload_Uid
        extends KmMetaStringProperty<MyDownload>
        implements KmMetaDaoPropertyIF<MyDownload,String>
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
            return MyDownloadValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyDownloadDao getDao()
        {
            return getAccess().getDownloadDao();
        }

        public KmDaoStringKeyCursor<MyDownload> createCursor()
        {
            KmDaoStringKeyCursor<MyDownload> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyDownload model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyDownload model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyDownload model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# LockVersion
    //##################################################

    public class MyMetaDownload_LockVersion
        extends KmMetaIntegerProperty<MyDownload>
        implements KmMetaDaoPropertyIF<MyDownload,Integer>
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
            return MyDownloadValidator.instance.getLockVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lockVersion";
        }

        @Override
        public MyDownloadDao getDao()
        {
            return getAccess().getDownloadDao();
        }

        @Override
        public Integer getValueFor(MyDownload model)
        {
            return model.getLockVersion();
        }

        @Override
        public void setValueFor(MyDownload model, Integer value)
        {
            model.setLockVersion(value);
        }

        @Override
        public boolean hasValueFor(MyDownload model, Integer value)
        {
            return model.hasLockVersion(value);
        }
    }

    //##################################################
    //# TypeName
    //##################################################

    public class MyMetaDownload_TypeName
        extends KmMetaStringProperty<MyDownload>
    {
        @Override
        public String getName()
        {
            return "typeName";
        }

        @Override
        public String getLabel()
        {
            return "Type";
        }

        @Override
        public String getHelp()
        {
            return "The type of download.\n\n File, use the local file system.\n\n Attachment, use the specified attachment.\n\n Bytes, use the byte data stored dirctly in this record.";
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
        public String getValueFor(MyDownload model)
        {
            return model.getTypeName();
        }

        @Override
        public boolean hasValueFor(MyDownload model, String value)
        {
            return model.hasTypeName(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaDownload_CreatedLocalTs
        extends KmMetaTimestampProperty<MyDownload>
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
        public KmTimestamp getValueFor(MyDownload model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyDownload model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaDownload_CreatedLocalTsMessage
        extends KmMetaStringProperty<MyDownload>
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
        public String getValueFor(MyDownload model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyDownload model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaDownload_CreatedLocalDate
        extends KmMetaDateProperty<MyDownload>
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
        public KmDate getValueFor(MyDownload model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyDownload model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaDownload_CreatedLocalTime
        extends KmMetaTimeProperty<MyDownload>
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
        public KmTime getValueFor(MyDownload model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyDownload model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }


    //##################################################
    //# Attachment
    //##################################################

    public class MyMetaDownload_Attachment
        extends KmMetaDaoAssociation<MyDownload,MyAttachment>
    {
        @Override
        public String getName()
        {
            return "attachment";
        }

        @Override
        public String getLabel()
        {
            return "Attachment";
        }

        @Override
        public String getHelp()
        {
            return "The attachment to be downloaded. This is only used if the type is attachment. The binary content is provided by the attachment record.";
        }

        @Override
        public boolean isRequired()
        {
            return false;
        }

        @Override
        public MyAttachment getValueFor(MyDownload model)
        {
            return model.getAttachment();
        }

        @Override
        public void setValueFor(MyDownload model, MyAttachment value)
        {
            model.setAttachment(value);
        }

        @Override
        public boolean hasValueFor(MyDownload model, MyAttachment value)
        {
            return model.hasAttachment(value);
        }
    }

    //##################################################
    //# User
    //##################################################

    public class MyMetaDownload_User
        extends KmMetaDaoAssociation<MyDownload,MyUser>
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
            return "The specific user allowed to download this file.";
        }

        @Override
        public boolean isRequired()
        {
            return true;
        }

        @Override
        public MyUser getValueFor(MyDownload model)
        {
            return model.getUser();
        }

        @Override
        public void setValueFor(MyDownload model, MyUser value)
        {
            model.setUser(value);
        }

        @Override
        public boolean hasValueFor(MyDownload model, MyUser value)
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
