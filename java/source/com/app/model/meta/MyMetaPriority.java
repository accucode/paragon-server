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

public class MyMetaPriority
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaPriority instance = new MyMetaPriority();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaPriority()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "priority";
    }

    public MyPriorityValidator getValidator()
    {
        return MyPriorityValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "Priorities are used to identify the relative importance of various things.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaPriority_AuditLogTitle AuditLogTitle = new MyMetaPriority_AuditLogTitle();
    public final MyMetaPriority_CategoryCode CategoryCode = new MyMetaPriority_CategoryCode();
    public final MyMetaPriority_CreatedUtcTs CreatedUtcTs = new MyMetaPriority_CreatedUtcTs();
    public final MyMetaPriority_DomainSubtitle DomainSubtitle = new MyMetaPriority_DomainSubtitle();
    public final MyMetaPriority_DomainTitle DomainTitle = new MyMetaPriority_DomainTitle();
    public final MyMetaPriority_Name Name = new MyMetaPriority_Name();
    public final MyMetaPriority_SequenceCode SequenceCode = new MyMetaPriority_SequenceCode();
    public final MyMetaPriority_SequenceName SequenceName = new MyMetaPriority_SequenceName();
    public final MyMetaPriority_Uid Uid = new MyMetaPriority_Uid();
    public final MyMetaPriority_UpdatedUtcTs UpdatedUtcTs = new MyMetaPriority_UpdatedUtcTs();
    public final MyMetaPriority_CategoryName CategoryName = new MyMetaPriority_CategoryName();
    public final MyMetaPriority_CreatedLocalTs CreatedLocalTs = new MyMetaPriority_CreatedLocalTs();
    public final MyMetaPriority_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaPriority_CreatedLocalTsMessage();
    public final MyMetaPriority_CreatedLocalDate CreatedLocalDate = new MyMetaPriority_CreatedLocalDate();
    public final MyMetaPriority_CreatedLocalTime CreatedLocalTime = new MyMetaPriority_CreatedLocalTime();
    public final MyMetaPriority_UpdatedLocalTs UpdatedLocalTs = new MyMetaPriority_UpdatedLocalTs();
    public final MyMetaPriority_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaPriority_UpdatedLocalTsMessage();
    public final MyMetaPriority_UpdatedLocalDate UpdatedLocalDate = new MyMetaPriority_UpdatedLocalDate();
    public final MyMetaPriority_UpdatedLocalTime UpdatedLocalTime = new MyMetaPriority_UpdatedLocalTime();
    public final MyMetaPriority_CreatedByFullName CreatedByFullName = new MyMetaPriority_CreatedByFullName();
    public final MyMetaPriority_UpdatedByFullName UpdatedByFullName = new MyMetaPriority_UpdatedByFullName();

    //##################################################
    //# associations
    //##################################################

    public final MyMetaPriority_CreatedBy CreatedBy = new MyMetaPriority_CreatedBy();
    public final MyMetaPriority_Project Project = new MyMetaPriority_Project();
    public final MyMetaPriority_UpdatedBy UpdatedBy = new MyMetaPriority_UpdatedBy();

    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaPriority_AuditLogTitle
        extends KmMetaStringProperty<MyPriority>
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
        public String getValueFor(MyPriority model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyPriority model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# CategoryCode
    //##################################################

    public class MyMetaPriority_CategoryCode
        extends KmMetaStringProperty<MyPriority>
        implements KmMetaDaoPropertyIF<MyPriority,String>
    {
        @Override
        public String getName()
        {
            return "categoryCode";
        }

        @Override
        public String getLabel()
        {
            return "Category";
        }

        @Override
        public String getHelp()
        {
            return "The category: low, normal, high.";
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
            return MyPriorityValidator.instance.getCategoryCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "categoryCode";
        }

        @Override
        public MyPriorityDao getDao()
        {
            return getAccess().getPriorityDao();
        }

        public ScDynamicEnumDropdownField newDropdown()
        {
            ScDynamicEnumDropdownField e;
            e = new ScDynamicEnumDropdownField();
            e.setMeta(this);
            e.setEnumArraySupplier(MyPriorityCategory::values);
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
        public String getValueFor(MyPriority model)
        {
            return model.getCategoryCode();
        }

        @Override
        public void setValueFor(MyPriority model, String value)
        {
            model.setCategoryCode(value);
        }

        @Override
        public boolean hasValueFor(MyPriority model, String value)
        {
            return model.hasCategoryCode(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaPriority_CreatedUtcTs
        extends KmMetaTimestampProperty<MyPriority>
        implements KmMetaDaoPropertyIF<MyPriority,KmTimestamp>
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
            return MyPriorityValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MyPriorityDao getDao()
        {
            return getAccess().getPriorityDao();
        }

        @Override
        public KmTimestamp getValueFor(MyPriority model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MyPriority model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyPriority model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaPriority_DomainSubtitle
        extends KmMetaStringProperty<MyPriority>
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
        public String getValueFor(MyPriority model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyPriority model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaPriority_DomainTitle
        extends KmMetaStringProperty<MyPriority>
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
        public String getValueFor(MyPriority model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyPriority model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# Name
    //##################################################

    public class MyMetaPriority_Name
        extends KmMetaStringProperty<MyPriority>
        implements KmMetaDaoPropertyIF<MyPriority,String>
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
            return "The name";
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
            return MyPriorityValidator.instance.getNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "name";
        }

        @Override
        public MyPriorityDao getDao()
        {
            return getAccess().getPriorityDao();
        }

        @Override
        public String getValueFor(MyPriority model)
        {
            return model.getName();
        }

        @Override
        public void setValueFor(MyPriority model, String value)
        {
            model.setName(value);
        }

        @Override
        public boolean hasValueFor(MyPriority model, String value)
        {
            return model.hasName(value);
        }
    }

    //##################################################
    //# SequenceCode
    //##################################################

    public class MyMetaPriority_SequenceCode
        extends KmMetaStringProperty<MyPriority>
        implements KmMetaDaoPropertyIF<MyPriority,String>
    {
        @Override
        public String getName()
        {
            return "sequenceCode";
        }

        @Override
        public String getLabel()
        {
            return "Sequence Code";
        }

        @Override
        public String getHelp()
        {
            return "The sequence is used to determine the order of priorities.";
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
            return MyPriorityValidator.instance.getSequenceCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "sequenceCode";
        }

        @Override
        public MyPriorityDao getDao()
        {
            return getAccess().getPriorityDao();
        }

        @Override
        public String getValueFor(MyPriority model)
        {
            return model.getSequenceCode();
        }

        @Override
        public void setValueFor(MyPriority model, String value)
        {
            model.setSequenceCode(value);
        }

        @Override
        public boolean hasValueFor(MyPriority model, String value)
        {
            return model.hasSequenceCode(value);
        }
    }

    //##################################################
    //# SequenceName
    //##################################################

    public class MyMetaPriority_SequenceName
        extends KmMetaStringProperty<MyPriority>
    {
        @Override
        public String getName()
        {
            return "sequenceName";
        }

        @Override
        public String getLabel()
        {
            return "Sequence Name";
        }

        @Override
        public String getHelp()
        {
            return "The sequence is used to determine the order of priorities.";
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
        public String getValueFor(MyPriority model)
        {
            return model.getSequenceName();
        }

        @Override
        public boolean hasValueFor(MyPriority model, String value)
        {
            return model.hasSequenceName(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaPriority_Uid
        extends KmMetaStringProperty<MyPriority>
        implements KmMetaDaoPropertyIF<MyPriority,String>
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
            return MyPriorityValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyPriorityDao getDao()
        {
            return getAccess().getPriorityDao();
        }

        public KmDaoStringKeyCursor<MyPriority> createCursor()
        {
            KmDaoStringKeyCursor<MyPriority> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyPriority model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyPriority model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyPriority model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# UpdatedUtcTs
    //##################################################

    public class MyMetaPriority_UpdatedUtcTs
        extends KmMetaTimestampProperty<MyPriority>
        implements KmMetaDaoPropertyIF<MyPriority,KmTimestamp>
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
            return MyPriorityValidator.instance.getUpdatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "updatedUtcTs";
        }

        @Override
        public MyPriorityDao getDao()
        {
            return getAccess().getPriorityDao();
        }

        @Override
        public KmTimestamp getValueFor(MyPriority model)
        {
            return model.getUpdatedUtcTs();
        }

        @Override
        public void setValueFor(MyPriority model, KmTimestamp value)
        {
            model.setUpdatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyPriority model, KmTimestamp value)
        {
            return model.hasUpdatedUtcTs(value);
        }
    }

    //##################################################
    //# CategoryName
    //##################################################

    public class MyMetaPriority_CategoryName
        extends KmMetaStringProperty<MyPriority>
    {
        @Override
        public String getName()
        {
            return "categoryName";
        }

        @Override
        public String getLabel()
        {
            return "Category";
        }

        @Override
        public String getHelp()
        {
            return "The category: low, normal, high.";
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
        public String getValueFor(MyPriority model)
        {
            return model.getCategoryName();
        }

        @Override
        public boolean hasValueFor(MyPriority model, String value)
        {
            return model.hasCategoryName(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaPriority_CreatedLocalTs
        extends KmMetaTimestampProperty<MyPriority>
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
        public KmTimestamp getValueFor(MyPriority model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyPriority model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaPriority_CreatedLocalTsMessage
        extends KmMetaStringProperty<MyPriority>
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
        public String getValueFor(MyPriority model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyPriority model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaPriority_CreatedLocalDate
        extends KmMetaDateProperty<MyPriority>
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
        public KmDate getValueFor(MyPriority model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyPriority model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaPriority_CreatedLocalTime
        extends KmMetaTimeProperty<MyPriority>
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
        public KmTime getValueFor(MyPriority model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyPriority model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }

    //##################################################
    //# UpdatedLocalTs
    //##################################################

    public class MyMetaPriority_UpdatedLocalTs
        extends KmMetaTimestampProperty<MyPriority>
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
        public KmTimestamp getValueFor(MyPriority model)
        {
            return model.getUpdatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyPriority model, KmTimestamp value)
        {
            return model.hasUpdatedLocalTs(value);
        }
    }

    //##################################################
    //# UpdatedLocalTsMessage
    //##################################################

    public class MyMetaPriority_UpdatedLocalTsMessage
        extends KmMetaStringProperty<MyPriority>
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
        public String getValueFor(MyPriority model)
        {
            return model.getUpdatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyPriority model, String value)
        {
            return model.hasUpdatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# UpdatedLocalDate
    //##################################################

    public class MyMetaPriority_UpdatedLocalDate
        extends KmMetaDateProperty<MyPriority>
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
        public KmDate getValueFor(MyPriority model)
        {
            return model.getUpdatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyPriority model, KmDate value)
        {
            return model.hasUpdatedLocalDate(value);
        }
    }

    //##################################################
    //# UpdatedLocalTime
    //##################################################

    public class MyMetaPriority_UpdatedLocalTime
        extends KmMetaTimeProperty<MyPriority>
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
        public KmTime getValueFor(MyPriority model)
        {
            return model.getUpdatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyPriority model, KmTime value)
        {
            return model.hasUpdatedLocalTime(value);
        }
    }

    //##################################################
    //# CreatedByFullName
    //##################################################

    public class MyMetaPriority_CreatedByFullName
        extends KmMetaStringProperty<MyPriority>
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
        public String getValueFor(MyPriority model)
        {
            return model.getCreatedByFullName();
        }

        @Override
        public void setValueFor(MyPriority model, String value)
        {
            model.setCreatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyPriority model, String value)
        {
            return model.hasCreatedByFullName(value);
        }
    }

    //##################################################
    //# UpdatedByFullName
    //##################################################

    public class MyMetaPriority_UpdatedByFullName
        extends KmMetaStringProperty<MyPriority>
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
        public String getValueFor(MyPriority model)
        {
            return model.getUpdatedByFullName();
        }

        @Override
        public void setValueFor(MyPriority model, String value)
        {
            model.setUpdatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyPriority model, String value)
        {
            return model.hasUpdatedByFullName(value);
        }
    }


    //##################################################
    //# CreatedBy
    //##################################################

    public class MyMetaPriority_CreatedBy
        extends KmMetaDaoAssociation<MyPriority,MyUser>
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
        public MyUser getValueFor(MyPriority model)
        {
            return model.getCreatedBy();
        }

        @Override
        public void setValueFor(MyPriority model, MyUser value)
        {
            model.setCreatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyPriority model, MyUser value)
        {
            return model.hasCreatedBy(value);
        }
    }

    //##################################################
    //# Project
    //##################################################

    public class MyMetaPriority_Project
        extends KmMetaDaoAssociation<MyPriority,MyProject>
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
            return "The project this priority belongs to.";
        }

        @Override
        public boolean isRequired()
        {
            return true;
        }

        @Override
        public MyProject getValueFor(MyPriority model)
        {
            return model.getProject();
        }

        @Override
        public void setValueFor(MyPriority model, MyProject value)
        {
            model.setProject(value);
        }

        @Override
        public boolean hasValueFor(MyPriority model, MyProject value)
        {
            return model.hasProject(value);
        }
    }

    //##################################################
    //# UpdatedBy
    //##################################################

    public class MyMetaPriority_UpdatedBy
        extends KmMetaDaoAssociation<MyPriority,MyUser>
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
        public MyUser getValueFor(MyPriority model)
        {
            return model.getUpdatedBy();
        }

        @Override
        public void setValueFor(MyPriority model, MyUser value)
        {
            model.setUpdatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyPriority model, MyUser value)
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
