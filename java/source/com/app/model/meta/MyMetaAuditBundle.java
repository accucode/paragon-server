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

public class MyMetaAuditBundle
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaAuditBundle instance = new MyMetaAuditBundle();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaAuditBundle()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "auditBundle";
    }

    public MyAuditBundleValidator getValidator()
    {
        return MyAuditBundleValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "Each bundle identifies a group of related audit logs for a particular domain model. In some cases, there may be multiple domain bundles for the same domain object within a given transaction.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaAuditBundle_AuditLogTitle AuditLogTitle = new MyMetaAuditBundle_AuditLogTitle();
    public final MyMetaAuditBundle_ChangeTypeCode ChangeTypeCode = new MyMetaAuditBundle_ChangeTypeCode();
    public final MyMetaAuditBundle_CreatedUtcTs CreatedUtcTs = new MyMetaAuditBundle_CreatedUtcTs();
    public final MyMetaAuditBundle_DomainName DomainName = new MyMetaAuditBundle_DomainName();
    public final MyMetaAuditBundle_DomainSubtitle DomainSubtitle = new MyMetaAuditBundle_DomainSubtitle();
    public final MyMetaAuditBundle_DomainTitle DomainTitle = new MyMetaAuditBundle_DomainTitle();
    public final MyMetaAuditBundle_DomainType DomainType = new MyMetaAuditBundle_DomainType();
    public final MyMetaAuditBundle_DomainTypeLabel DomainTypeLabel = new MyMetaAuditBundle_DomainTypeLabel();
    public final MyMetaAuditBundle_DomainUid DomainUid = new MyMetaAuditBundle_DomainUid();
    public final MyMetaAuditBundle_TransactionUid TransactionUid = new MyMetaAuditBundle_TransactionUid();
    public final MyMetaAuditBundle_Uid Uid = new MyMetaAuditBundle_Uid();
    public final MyMetaAuditBundle_UserName UserName = new MyMetaAuditBundle_UserName();
    public final MyMetaAuditBundle_ChangeTypeName ChangeTypeName = new MyMetaAuditBundle_ChangeTypeName();
    public final MyMetaAuditBundle_CreatedLocalTs CreatedLocalTs = new MyMetaAuditBundle_CreatedLocalTs();
    public final MyMetaAuditBundle_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaAuditBundle_CreatedLocalTsMessage();
    public final MyMetaAuditBundle_CreatedLocalDate CreatedLocalDate = new MyMetaAuditBundle_CreatedLocalDate();
    public final MyMetaAuditBundle_CreatedLocalTime CreatedLocalTime = new MyMetaAuditBundle_CreatedLocalTime();

    //##################################################
    //# associations
    //##################################################

    public final MyMetaAuditBundle_User User = new MyMetaAuditBundle_User();

    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaAuditBundle_AuditLogTitle
        extends KmMetaStringProperty<MyAuditBundle>
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
        public String getValueFor(MyAuditBundle model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyAuditBundle model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# ChangeTypeCode
    //##################################################

    public class MyMetaAuditBundle_ChangeTypeCode
        extends KmMetaStringProperty<MyAuditBundle>
        implements KmMetaDaoPropertyIF<MyAuditBundle,String>
    {
        @Override
        public String getName()
        {
            return "changeTypeCode";
        }

        @Override
        public String getLabel()
        {
            return "Change";
        }

        @Override
        public String getHelp()
        {
            return "The type of change.";
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
            return MyAuditBundleValidator.instance.getChangeTypeCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "changeTypeCode";
        }

        @Override
        public MyAuditBundleDao getDao()
        {
            return getAccess().getAuditBundleDao();
        }

        public ScDynamicEnumDropdownField newDropdown()
        {
            ScDynamicEnumDropdownField e;
            e = new ScDynamicEnumDropdownField();
            e.setMeta(this);
            e.setEnumArraySupplier(MyAuditBundleChangeType::values);
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
        public String getValueFor(MyAuditBundle model)
        {
            return model.getChangeTypeCode();
        }

        @Override
        public void setValueFor(MyAuditBundle model, String value)
        {
            model.setChangeTypeCode(value);
        }

        @Override
        public boolean hasValueFor(MyAuditBundle model, String value)
        {
            return model.hasChangeTypeCode(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaAuditBundle_CreatedUtcTs
        extends KmMetaTimestampProperty<MyAuditBundle>
        implements KmMetaDaoPropertyIF<MyAuditBundle,KmTimestamp>
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
            return "The time this change was made.";
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
            return MyAuditBundleValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MyAuditBundleDao getDao()
        {
            return getAccess().getAuditBundleDao();
        }

        @Override
        public KmTimestamp getValueFor(MyAuditBundle model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MyAuditBundle model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyAuditBundle model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# DomainName
    //##################################################

    public class MyMetaAuditBundle_DomainName
        extends KmMetaStringProperty<MyAuditBundle>
        implements KmMetaDaoPropertyIF<MyAuditBundle,String>
    {
        @Override
        public String getName()
        {
            return "domainName";
        }

        @Override
        public String getLabel()
        {
            return "Domain Name";
        }

        @Override
        public String getHelp()
        {
            return "The common, but non-unique name of the domain. Models generally rely on long UIDs as their unique identifier so we also store a domain's display string as a 'name'. Although this name is not guaranteed to be unique, it is generally human-readable and is usually sufficient to identify which domain was affected.";
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
            return MyAuditBundleValidator.instance.getDomainNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "domainName";
        }

        @Override
        public MyAuditBundleDao getDao()
        {
            return getAccess().getAuditBundleDao();
        }

        @Override
        public String getValueFor(MyAuditBundle model)
        {
            return model.getDomainName();
        }

        @Override
        public void setValueFor(MyAuditBundle model, String value)
        {
            model.setDomainName(value);
        }

        @Override
        public boolean hasValueFor(MyAuditBundle model, String value)
        {
            return model.hasDomainName(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaAuditBundle_DomainSubtitle
        extends KmMetaStringProperty<MyAuditBundle>
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
        public String getValueFor(MyAuditBundle model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyAuditBundle model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaAuditBundle_DomainTitle
        extends KmMetaStringProperty<MyAuditBundle>
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
        public String getValueFor(MyAuditBundle model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyAuditBundle model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# DomainType
    //##################################################

    public class MyMetaAuditBundle_DomainType
        extends KmMetaStringProperty<MyAuditBundle>
        implements KmMetaDaoPropertyIF<MyAuditBundle,String>
    {
        @Override
        public String getName()
        {
            return "domainType";
        }

        @Override
        public String getLabel()
        {
            return "Domain Type";
        }

        @Override
        public String getHelp()
        {
            return "The type of domain; e.g.: project, job, depot, etc.";
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
            return MyAuditBundleValidator.instance.getDomainTypeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "domainType";
        }

        @Override
        public MyAuditBundleDao getDao()
        {
            return getAccess().getAuditBundleDao();
        }

        @Override
        public String getValueFor(MyAuditBundle model)
        {
            return model.getDomainType();
        }

        @Override
        public void setValueFor(MyAuditBundle model, String value)
        {
            model.setDomainType(value);
        }

        @Override
        public boolean hasValueFor(MyAuditBundle model, String value)
        {
            return model.hasDomainType(value);
        }
    }

    //##################################################
    //# DomainTypeLabel
    //##################################################

    public class MyMetaAuditBundle_DomainTypeLabel
        extends KmMetaStringProperty<MyAuditBundle>
    {
        @Override
        public String getName()
        {
            return "domainTypeLabel";
        }

        @Override
        public String getLabel()
        {
            return "Domain Type";
        }

        @Override
        public String getHelp()
        {
            return "A more friendly format of the domain type. E.g.: project => Project; jobLine => Job Line; etc.";
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
        public String getValueFor(MyAuditBundle model)
        {
            return model.getDomainTypeLabel();
        }

        @Override
        public boolean hasValueFor(MyAuditBundle model, String value)
        {
            return model.hasDomainTypeLabel(value);
        }
    }

    //##################################################
    //# DomainUid
    //##################################################

    public class MyMetaAuditBundle_DomainUid
        extends KmMetaStringProperty<MyAuditBundle>
        implements KmMetaDaoPropertyIF<MyAuditBundle,String>
    {
        @Override
        public String getName()
        {
            return "domainUid";
        }

        @Override
        public String getLabel()
        {
            return "Domain Uid";
        }

        @Override
        public String getHelp()
        {
            return "The unique id of the domain model.";
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
            return MyAuditBundleValidator.instance.getDomainUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "domainUid";
        }

        @Override
        public MyAuditBundleDao getDao()
        {
            return getAccess().getAuditBundleDao();
        }

        @Override
        public String getValueFor(MyAuditBundle model)
        {
            return model.getDomainUid();
        }

        @Override
        public void setValueFor(MyAuditBundle model, String value)
        {
            model.setDomainUid(value);
        }

        @Override
        public boolean hasValueFor(MyAuditBundle model, String value)
        {
            return model.hasDomainUid(value);
        }
    }

    //##################################################
    //# TransactionUid
    //##################################################

    public class MyMetaAuditBundle_TransactionUid
        extends KmMetaStringProperty<MyAuditBundle>
        implements KmMetaDaoPropertyIF<MyAuditBundle,String>
    {
        @Override
        public String getName()
        {
            return "transactionUid";
        }

        @Override
        public String getLabel()
        {
            return "Transaction Uid";
        }

        @Override
        public String getHelp()
        {
            return "This is used to identify all bundles within a given transaction.";
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
            return MyAuditBundleValidator.instance.getTransactionUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "transactionUid";
        }

        @Override
        public MyAuditBundleDao getDao()
        {
            return getAccess().getAuditBundleDao();
        }

        @Override
        public String getValueFor(MyAuditBundle model)
        {
            return model.getTransactionUid();
        }

        @Override
        public void setValueFor(MyAuditBundle model, String value)
        {
            model.setTransactionUid(value);
        }

        @Override
        public boolean hasValueFor(MyAuditBundle model, String value)
        {
            return model.hasTransactionUid(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaAuditBundle_Uid
        extends KmMetaStringProperty<MyAuditBundle>
        implements KmMetaDaoPropertyIF<MyAuditBundle,String>
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
            return MyAuditBundleValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyAuditBundleDao getDao()
        {
            return getAccess().getAuditBundleDao();
        }

        public KmDaoStringKeyCursor<MyAuditBundle> createCursor()
        {
            KmDaoStringKeyCursor<MyAuditBundle> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyAuditBundle model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyAuditBundle model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyAuditBundle model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# UserName
    //##################################################

    public class MyMetaAuditBundle_UserName
        extends KmMetaStringProperty<MyAuditBundle>
        implements KmMetaDaoPropertyIF<MyAuditBundle,String>
    {
        @Override
        public String getName()
        {
            return "userName";
        }

        @Override
        public String getLabel()
        {
            return "User Name";
        }

        @Override
        public String getHelp()
        {
            return "The user's name (denormalized).";
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
            return MyAuditBundleValidator.instance.getUserNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "userName";
        }

        @Override
        public MyAuditBundleDao getDao()
        {
            return getAccess().getAuditBundleDao();
        }

        @Override
        public String getValueFor(MyAuditBundle model)
        {
            return model.getUserName();
        }

        @Override
        public void setValueFor(MyAuditBundle model, String value)
        {
            model.setUserName(value);
        }

        @Override
        public boolean hasValueFor(MyAuditBundle model, String value)
        {
            return model.hasUserName(value);
        }
    }

    //##################################################
    //# ChangeTypeName
    //##################################################

    public class MyMetaAuditBundle_ChangeTypeName
        extends KmMetaStringProperty<MyAuditBundle>
    {
        @Override
        public String getName()
        {
            return "changeTypeName";
        }

        @Override
        public String getLabel()
        {
            return "Change";
        }

        @Override
        public String getHelp()
        {
            return "The type of change.";
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
        public String getValueFor(MyAuditBundle model)
        {
            return model.getChangeTypeName();
        }

        @Override
        public boolean hasValueFor(MyAuditBundle model, String value)
        {
            return model.hasChangeTypeName(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaAuditBundle_CreatedLocalTs
        extends KmMetaTimestampProperty<MyAuditBundle>
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
        public KmTimestamp getValueFor(MyAuditBundle model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyAuditBundle model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaAuditBundle_CreatedLocalTsMessage
        extends KmMetaStringProperty<MyAuditBundle>
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
        public String getValueFor(MyAuditBundle model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyAuditBundle model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaAuditBundle_CreatedLocalDate
        extends KmMetaDateProperty<MyAuditBundle>
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
        public KmDate getValueFor(MyAuditBundle model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyAuditBundle model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaAuditBundle_CreatedLocalTime
        extends KmMetaTimeProperty<MyAuditBundle>
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
        public KmTime getValueFor(MyAuditBundle model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyAuditBundle model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }


    //##################################################
    //# User
    //##################################################

    public class MyMetaAuditBundle_User
        extends KmMetaDaoAssociation<MyAuditBundle,MyUser>
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
            return "The user that made this change.  May be null for automated updates.";
        }

        @Override
        public boolean isRequired()
        {
            return false;
        }

        @Override
        public MyUser getValueFor(MyAuditBundle model)
        {
            return model.getUser();
        }

        @Override
        public void setValueFor(MyAuditBundle model, MyUser value)
        {
            model.setUser(value);
        }

        @Override
        public boolean hasValueFor(MyAuditBundle model, MyUser value)
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
