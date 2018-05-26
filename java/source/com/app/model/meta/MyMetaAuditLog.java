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

public class MyMetaAuditLog
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaAuditLog instance = new MyMetaAuditLog();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaAuditLog()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "auditLog";
    }

    public MyAuditLogValidator getValidator()
    {
        return MyAuditLogValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "I maintain a log of changes made to the domain. Each record identify a single attribute that has been modified on a given model. For example, a single record may record that the user John Doe changed the Widget's price to $13.00 on Jan 1, 2015.\n This is intended to be a historical archive that can be easily exported to a third-party reporting.  All records must be immutable; records can be added, but not modified.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaAuditLog_AuditLogTitle AuditLogTitle = new MyMetaAuditLog_AuditLogTitle();
    public final MyMetaAuditLog_BooleanValue BooleanValue = new MyMetaAuditLog_BooleanValue();
    public final MyMetaAuditLog_CreatedUtcTs CreatedUtcTs = new MyMetaAuditLog_CreatedUtcTs();
    public final MyMetaAuditLog_DateValue DateValue = new MyMetaAuditLog_DateValue();
    public final MyMetaAuditLog_DomainName DomainName = new MyMetaAuditLog_DomainName();
    public final MyMetaAuditLog_DomainSubtitle DomainSubtitle = new MyMetaAuditLog_DomainSubtitle();
    public final MyMetaAuditLog_DomainTitle DomainTitle = new MyMetaAuditLog_DomainTitle();
    public final MyMetaAuditLog_DomainType DomainType = new MyMetaAuditLog_DomainType();
    public final MyMetaAuditLog_DomainTypeLabel DomainTypeLabel = new MyMetaAuditLog_DomainTypeLabel();
    public final MyMetaAuditLog_DomainUid DomainUid = new MyMetaAuditLog_DomainUid();
    public final MyMetaAuditLog_DoubleValue DoubleValue = new MyMetaAuditLog_DoubleValue();
    public final MyMetaAuditLog_FieldName FieldName = new MyMetaAuditLog_FieldName();
    public final MyMetaAuditLog_FieldNameLabel FieldNameLabel = new MyMetaAuditLog_FieldNameLabel();
    public final MyMetaAuditLog_IntegerValue IntegerValue = new MyMetaAuditLog_IntegerValue();
    public final MyMetaAuditLog_LongValue LongValue = new MyMetaAuditLog_LongValue();
    public final MyMetaAuditLog_MoneyValue MoneyValue = new MyMetaAuditLog_MoneyValue();
    public final MyMetaAuditLog_NewValue NewValue = new MyMetaAuditLog_NewValue();
    public final MyMetaAuditLog_OldValue OldValue = new MyMetaAuditLog_OldValue();
    public final MyMetaAuditLog_StringValue StringValue = new MyMetaAuditLog_StringValue();
    public final MyMetaAuditLog_TimestampValue TimestampValue = new MyMetaAuditLog_TimestampValue();
    public final MyMetaAuditLog_TransactionUid TransactionUid = new MyMetaAuditLog_TransactionUid();
    public final MyMetaAuditLog_TypeCode TypeCode = new MyMetaAuditLog_TypeCode();
    public final MyMetaAuditLog_Uid Uid = new MyMetaAuditLog_Uid();
    public final MyMetaAuditLog_UidValue UidValue = new MyMetaAuditLog_UidValue();
    public final MyMetaAuditLog_UserName UserName = new MyMetaAuditLog_UserName();
    public final MyMetaAuditLog_TypeName TypeName = new MyMetaAuditLog_TypeName();
    public final MyMetaAuditLog_CreatedLocalTs CreatedLocalTs = new MyMetaAuditLog_CreatedLocalTs();
    public final MyMetaAuditLog_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaAuditLog_CreatedLocalTsMessage();
    public final MyMetaAuditLog_CreatedLocalDate CreatedLocalDate = new MyMetaAuditLog_CreatedLocalDate();
    public final MyMetaAuditLog_CreatedLocalTime CreatedLocalTime = new MyMetaAuditLog_CreatedLocalTime();

    //##################################################
    //# associations
    //##################################################

    public final MyMetaAuditLog_Bundle Bundle = new MyMetaAuditLog_Bundle();
    public final MyMetaAuditLog_User User = new MyMetaAuditLog_User();

    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaAuditLog_AuditLogTitle
        extends KmMetaStringProperty<MyAuditLog>
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
        public String getValueFor(MyAuditLog model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyAuditLog model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# BooleanValue
    //##################################################

    public class MyMetaAuditLog_BooleanValue
        extends KmMetaBooleanProperty<MyAuditLog>
        implements KmMetaDaoPropertyIF<MyAuditLog,Boolean>
    {
        @Override
        public String getName()
        {
            return "booleanValue";
        }

        @Override
        public String getLabel()
        {
            return "Boolean Value";
        }

        @Override
        public String getHelp()
        {
            return "The boolean value, if applicable.";
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
            return MyAuditLogValidator.instance.getBooleanValueValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "booleanValue";
        }

        @Override
        public MyAuditLogDao getDao()
        {
            return getAccess().getAuditLogDao();
        }

        @Override
        public Boolean getValueFor(MyAuditLog model)
        {
            return model.getBooleanValue();
        }

        @Override
        public void setValueFor(MyAuditLog model, Boolean value)
        {
            model.setBooleanValue(value);
        }

        @Override
        public boolean hasValueFor(MyAuditLog model, Boolean value)
        {
            return model.hasBooleanValue(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaAuditLog_CreatedUtcTs
        extends KmMetaTimestampProperty<MyAuditLog>
        implements KmMetaDaoPropertyIF<MyAuditLog,KmTimestamp>
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
            return MyAuditLogValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MyAuditLogDao getDao()
        {
            return getAccess().getAuditLogDao();
        }

        @Override
        public KmTimestamp getValueFor(MyAuditLog model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MyAuditLog model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyAuditLog model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# DateValue
    //##################################################

    public class MyMetaAuditLog_DateValue
        extends KmMetaDateProperty<MyAuditLog>
        implements KmMetaDaoPropertyIF<MyAuditLog,KmDate>
    {
        @Override
        public String getName()
        {
            return "dateValue";
        }

        @Override
        public String getLabel()
        {
            return "Date Value";
        }

        @Override
        public String getHelp()
        {
            return "The date value, if applicable.";
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
        public KmDateValidator getValidator()
        {
            return MyAuditLogValidator.instance.getDateValueValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "dateValue";
        }

        @Override
        public MyAuditLogDao getDao()
        {
            return getAccess().getAuditLogDao();
        }

        @Override
        public KmDate getValueFor(MyAuditLog model)
        {
            return model.getDateValue();
        }

        @Override
        public void setValueFor(MyAuditLog model, KmDate value)
        {
            model.setDateValue(value);
        }

        @Override
        public boolean hasValueFor(MyAuditLog model, KmDate value)
        {
            return model.hasDateValue(value);
        }
    }

    //##################################################
    //# DomainName
    //##################################################

    public class MyMetaAuditLog_DomainName
        extends KmMetaStringProperty<MyAuditLog>
        implements KmMetaDaoPropertyIF<MyAuditLog,String>
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
            return "The common, but non-unique name of the domain. Models generally rely on long UIDs as their unique identifier so we also store a domain's display string as a 'name'.  Although this name is not guaranteed to be unique, it is generally human-readable and is usually sufficient to identify which domain was affected.";
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
            return MyAuditLogValidator.instance.getDomainNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "domainName";
        }

        @Override
        public MyAuditLogDao getDao()
        {
            return getAccess().getAuditLogDao();
        }

        @Override
        public String getValueFor(MyAuditLog model)
        {
            return model.getDomainName();
        }

        @Override
        public void setValueFor(MyAuditLog model, String value)
        {
            model.setDomainName(value);
        }

        @Override
        public boolean hasValueFor(MyAuditLog model, String value)
        {
            return model.hasDomainName(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaAuditLog_DomainSubtitle
        extends KmMetaStringProperty<MyAuditLog>
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
        public String getValueFor(MyAuditLog model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyAuditLog model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaAuditLog_DomainTitle
        extends KmMetaStringProperty<MyAuditLog>
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
        public String getValueFor(MyAuditLog model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyAuditLog model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# DomainType
    //##################################################

    public class MyMetaAuditLog_DomainType
        extends KmMetaStringProperty<MyAuditLog>
        implements KmMetaDaoPropertyIF<MyAuditLog,String>
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
            return "The type of domain; e.g.: project, depot, jobLine, etc.";
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
            return MyAuditLogValidator.instance.getDomainTypeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "domainType";
        }

        @Override
        public MyAuditLogDao getDao()
        {
            return getAccess().getAuditLogDao();
        }

        @Override
        public String getValueFor(MyAuditLog model)
        {
            return model.getDomainType();
        }

        @Override
        public void setValueFor(MyAuditLog model, String value)
        {
            model.setDomainType(value);
        }

        @Override
        public boolean hasValueFor(MyAuditLog model, String value)
        {
            return model.hasDomainType(value);
        }
    }

    //##################################################
    //# DomainTypeLabel
    //##################################################

    public class MyMetaAuditLog_DomainTypeLabel
        extends KmMetaStringProperty<MyAuditLog>
    {
        @Override
        public String getName()
        {
            return "domainTypeLabel";
        }

        @Override
        public String getLabel()
        {
            return "Domain Type Label";
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
        public String getValueFor(MyAuditLog model)
        {
            return model.getDomainTypeLabel();
        }

        @Override
        public boolean hasValueFor(MyAuditLog model, String value)
        {
            return model.hasDomainTypeLabel(value);
        }
    }

    //##################################################
    //# DomainUid
    //##################################################

    public class MyMetaAuditLog_DomainUid
        extends KmMetaStringProperty<MyAuditLog>
        implements KmMetaDaoPropertyIF<MyAuditLog,String>
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
            return MyAuditLogValidator.instance.getDomainUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "domainUid";
        }

        @Override
        public MyAuditLogDao getDao()
        {
            return getAccess().getAuditLogDao();
        }

        @Override
        public String getValueFor(MyAuditLog model)
        {
            return model.getDomainUid();
        }

        @Override
        public void setValueFor(MyAuditLog model, String value)
        {
            model.setDomainUid(value);
        }

        @Override
        public boolean hasValueFor(MyAuditLog model, String value)
        {
            return model.hasDomainUid(value);
        }
    }

    //##################################################
    //# DoubleValue
    //##################################################

    public class MyMetaAuditLog_DoubleValue
        extends KmMetaDoubleProperty<MyAuditLog>
        implements KmMetaDaoPropertyIF<MyAuditLog,Double>
    {
        @Override
        public String getName()
        {
            return "doubleValue";
        }

        @Override
        public String getLabel()
        {
            return "Double Value";
        }

        @Override
        public String getHelp()
        {
            return "The double value, if applicable.";
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
        public KmDoubleValidator getValidator()
        {
            return MyAuditLogValidator.instance.getDoubleValueValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "doubleValue";
        }

        @Override
        public MyAuditLogDao getDao()
        {
            return getAccess().getAuditLogDao();
        }

        @Override
        public Double getValueFor(MyAuditLog model)
        {
            return model.getDoubleValue();
        }

        @Override
        public void setValueFor(MyAuditLog model, Double value)
        {
            model.setDoubleValue(value);
        }

        @Override
        public boolean hasValueFor(MyAuditLog model, Double value)
        {
            return model.hasDoubleValue(value);
        }
    }

    //##################################################
    //# FieldName
    //##################################################

    public class MyMetaAuditLog_FieldName
        extends KmMetaStringProperty<MyAuditLog>
        implements KmMetaDaoPropertyIF<MyAuditLog,String>
    {
        @Override
        public String getName()
        {
            return "fieldName";
        }

        @Override
        public String getLabel()
        {
            return "Field Name";
        }

        @Override
        public String getHelp()
        {
            return "The name of the field that was modified. This is effectively the java/database name. For example: count, phone, primaryShippingAddress.";
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
            return MyAuditLogValidator.instance.getFieldNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "fieldName";
        }

        @Override
        public MyAuditLogDao getDao()
        {
            return getAccess().getAuditLogDao();
        }

        @Override
        public String getValueFor(MyAuditLog model)
        {
            return model.getFieldName();
        }

        @Override
        public void setValueFor(MyAuditLog model, String value)
        {
            model.setFieldName(value);
        }

        @Override
        public boolean hasValueFor(MyAuditLog model, String value)
        {
            return model.hasFieldName(value);
        }
    }

    //##################################################
    //# FieldNameLabel
    //##################################################

    public class MyMetaAuditLog_FieldNameLabel
        extends KmMetaStringProperty<MyAuditLog>
    {
        @Override
        public String getName()
        {
            return "fieldNameLabel";
        }

        @Override
        public String getLabel()
        {
            return "Field Name Label";
        }

        @Override
        public String getHelp()
        {
            return "A more friendly format of the field name. E.g.: count => Count; primaryShippingAddress => Primary Shipping Address; etc.";
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
        public String getValueFor(MyAuditLog model)
        {
            return model.getFieldNameLabel();
        }

        @Override
        public boolean hasValueFor(MyAuditLog model, String value)
        {
            return model.hasFieldNameLabel(value);
        }
    }

    //##################################################
    //# IntegerValue
    //##################################################

    public class MyMetaAuditLog_IntegerValue
        extends KmMetaIntegerProperty<MyAuditLog>
        implements KmMetaDaoPropertyIF<MyAuditLog,Integer>
    {
        @Override
        public String getName()
        {
            return "integerValue";
        }

        @Override
        public String getLabel()
        {
            return "Integer Value";
        }

        @Override
        public String getHelp()
        {
            return "The integer value, if applicable.";
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
            return MyAuditLogValidator.instance.getIntegerValueValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "integerValue";
        }

        @Override
        public MyAuditLogDao getDao()
        {
            return getAccess().getAuditLogDao();
        }

        @Override
        public Integer getValueFor(MyAuditLog model)
        {
            return model.getIntegerValue();
        }

        @Override
        public void setValueFor(MyAuditLog model, Integer value)
        {
            model.setIntegerValue(value);
        }

        @Override
        public boolean hasValueFor(MyAuditLog model, Integer value)
        {
            return model.hasIntegerValue(value);
        }
    }

    //##################################################
    //# LongValue
    //##################################################

    public class MyMetaAuditLog_LongValue
        extends KmMetaLongProperty<MyAuditLog>
        implements KmMetaDaoPropertyIF<MyAuditLog,Long>
    {
        @Override
        public String getName()
        {
            return "longValue";
        }

        @Override
        public String getLabel()
        {
            return "Long Value";
        }

        @Override
        public String getHelp()
        {
            return "The long value, if applicable.";
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
        public KmLongValidator getValidator()
        {
            return MyAuditLogValidator.instance.getLongValueValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "longValue";
        }

        @Override
        public MyAuditLogDao getDao()
        {
            return getAccess().getAuditLogDao();
        }

        @Override
        public Long getValueFor(MyAuditLog model)
        {
            return model.getLongValue();
        }

        @Override
        public void setValueFor(MyAuditLog model, Long value)
        {
            model.setLongValue(value);
        }

        @Override
        public boolean hasValueFor(MyAuditLog model, Long value)
        {
            return model.hasLongValue(value);
        }
    }

    //##################################################
    //# MoneyValue
    //##################################################

    public class MyMetaAuditLog_MoneyValue
        extends KmMetaMoneyProperty<MyAuditLog>
        implements KmMetaDaoPropertyIF<MyAuditLog,KmMoney>
    {
        @Override
        public String getName()
        {
            return "moneyValue";
        }

        @Override
        public String getLabel()
        {
            return "Money Value";
        }

        @Override
        public String getHelp()
        {
            return "The money value, if applicable.";
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
        public KmMoneyValidator getValidator()
        {
            return MyAuditLogValidator.instance.getMoneyValueValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "moneyValue";
        }

        @Override
        public MyAuditLogDao getDao()
        {
            return getAccess().getAuditLogDao();
        }

        @Override
        public KmMoney getValueFor(MyAuditLog model)
        {
            return model.getMoneyValue();
        }

        @Override
        public void setValueFor(MyAuditLog model, KmMoney value)
        {
            model.setMoneyValue(value);
        }

        @Override
        public boolean hasValueFor(MyAuditLog model, KmMoney value)
        {
            return model.hasMoneyValue(value);
        }
    }

    //##################################################
    //# NewValue
    //##################################################

    public class MyMetaAuditLog_NewValue
        extends KmMetaStringProperty<MyAuditLog>
        implements KmMetaDaoPropertyIF<MyAuditLog,String>
    {
        @Override
        public String getName()
        {
            return "newValue";
        }

        @Override
        public String getLabel()
        {
            return "New Value";
        }

        @Override
        public String getHelp()
        {
            return "A human readable summary of the new/current value.";
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
            return MyAuditLogValidator.instance.getNewValueValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "newValue";
        }

        @Override
        public MyAuditLogDao getDao()
        {
            return getAccess().getAuditLogDao();
        }

        @Override
        public String getValueFor(MyAuditLog model)
        {
            return model.getNewValue();
        }

        @Override
        public void setValueFor(MyAuditLog model, String value)
        {
            model.setNewValue(value);
        }

        @Override
        public boolean hasValueFor(MyAuditLog model, String value)
        {
            return model.hasNewValue(value);
        }
    }

    //##################################################
    //# OldValue
    //##################################################

    public class MyMetaAuditLog_OldValue
        extends KmMetaStringProperty<MyAuditLog>
        implements KmMetaDaoPropertyIF<MyAuditLog,String>
    {
        @Override
        public String getName()
        {
            return "oldValue";
        }

        @Override
        public String getLabel()
        {
            return "Old Value";
        }

        @Override
        public String getHelp()
        {
            return "A human readable summary of the old/previous value.";
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
            return MyAuditLogValidator.instance.getOldValueValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "oldValue";
        }

        @Override
        public MyAuditLogDao getDao()
        {
            return getAccess().getAuditLogDao();
        }

        @Override
        public String getValueFor(MyAuditLog model)
        {
            return model.getOldValue();
        }

        @Override
        public void setValueFor(MyAuditLog model, String value)
        {
            model.setOldValue(value);
        }

        @Override
        public boolean hasValueFor(MyAuditLog model, String value)
        {
            return model.hasOldValue(value);
        }
    }

    //##################################################
    //# StringValue
    //##################################################

    public class MyMetaAuditLog_StringValue
        extends KmMetaStringProperty<MyAuditLog>
        implements KmMetaDaoPropertyIF<MyAuditLog,String>
    {
        @Override
        public String getName()
        {
            return "stringValue";
        }

        @Override
        public String getLabel()
        {
            return "String Value";
        }

        @Override
        public String getHelp()
        {
            return "The truncated string value, if applicable.";
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
            return MyAuditLogValidator.instance.getStringValueValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "stringValue";
        }

        @Override
        public MyAuditLogDao getDao()
        {
            return getAccess().getAuditLogDao();
        }

        @Override
        public String getValueFor(MyAuditLog model)
        {
            return model.getStringValue();
        }

        @Override
        public void setValueFor(MyAuditLog model, String value)
        {
            model.setStringValue(value);
        }

        @Override
        public boolean hasValueFor(MyAuditLog model, String value)
        {
            return model.hasStringValue(value);
        }
    }

    //##################################################
    //# TimestampValue
    //##################################################

    public class MyMetaAuditLog_TimestampValue
        extends KmMetaTimestampProperty<MyAuditLog>
        implements KmMetaDaoPropertyIF<MyAuditLog,KmTimestamp>
    {
        @Override
        public String getName()
        {
            return "timestampValue";
        }

        @Override
        public String getLabel()
        {
            return "Timestamp Value";
        }

        @Override
        public String getHelp()
        {
            return "The timestamp value, if applicable.";
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
            return MyAuditLogValidator.instance.getTimestampValueValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "timestampValue";
        }

        @Override
        public MyAuditLogDao getDao()
        {
            return getAccess().getAuditLogDao();
        }

        @Override
        public KmTimestamp getValueFor(MyAuditLog model)
        {
            return model.getTimestampValue();
        }

        @Override
        public void setValueFor(MyAuditLog model, KmTimestamp value)
        {
            model.setTimestampValue(value);
        }

        @Override
        public boolean hasValueFor(MyAuditLog model, KmTimestamp value)
        {
            return model.hasTimestampValue(value);
        }
    }

    //##################################################
    //# TransactionUid
    //##################################################

    public class MyMetaAuditLog_TransactionUid
        extends KmMetaStringProperty<MyAuditLog>
        implements KmMetaDaoPropertyIF<MyAuditLog,String>
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
            return "A unique identifier of the database transaction.";
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
            return MyAuditLogValidator.instance.getTransactionUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "transactionUid";
        }

        @Override
        public MyAuditLogDao getDao()
        {
            return getAccess().getAuditLogDao();
        }

        @Override
        public String getValueFor(MyAuditLog model)
        {
            return model.getTransactionUid();
        }

        @Override
        public void setValueFor(MyAuditLog model, String value)
        {
            model.setTransactionUid(value);
        }

        @Override
        public boolean hasValueFor(MyAuditLog model, String value)
        {
            return model.hasTransactionUid(value);
        }
    }

    //##################################################
    //# TypeCode
    //##################################################

    public class MyMetaAuditLog_TypeCode
        extends KmMetaStringProperty<MyAuditLog>
        implements KmMetaDaoPropertyIF<MyAuditLog,String>
    {
        @Override
        public String getName()
        {
            return "typeCode";
        }

        @Override
        public String getLabel()
        {
            return "Type Code";
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
            return MyAuditLogValidator.instance.getTypeCodeValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "typeCode";
        }

        @Override
        public MyAuditLogDao getDao()
        {
            return getAccess().getAuditLogDao();
        }

        public ScDynamicEnumDropdownField newDropdown()
        {
            ScDynamicEnumDropdownField e;
            e = new ScDynamicEnumDropdownField();
            e.setMeta(this);
            e.setEnumArraySupplier(MyAuditLogType::values);
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
        public String getValueFor(MyAuditLog model)
        {
            return model.getTypeCode();
        }

        @Override
        public void setValueFor(MyAuditLog model, String value)
        {
            model.setTypeCode(value);
        }

        @Override
        public boolean hasValueFor(MyAuditLog model, String value)
        {
            return model.hasTypeCode(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaAuditLog_Uid
        extends KmMetaStringProperty<MyAuditLog>
        implements KmMetaDaoPropertyIF<MyAuditLog,String>
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
            return MyAuditLogValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyAuditLogDao getDao()
        {
            return getAccess().getAuditLogDao();
        }

        public KmDaoStringKeyCursor<MyAuditLog> createCursor()
        {
            KmDaoStringKeyCursor<MyAuditLog> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyAuditLog model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyAuditLog model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyAuditLog model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# UidValue
    //##################################################

    public class MyMetaAuditLog_UidValue
        extends KmMetaStringProperty<MyAuditLog>
        implements KmMetaDaoPropertyIF<MyAuditLog,String>
    {
        @Override
        public String getName()
        {
            return "uidValue";
        }

        @Override
        public String getLabel()
        {
            return "Uid Value";
        }

        @Override
        public String getHelp()
        {
            return "The foreign key reference uid, if applicable.";
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
            return MyAuditLogValidator.instance.getUidValueValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uidValue";
        }

        @Override
        public MyAuditLogDao getDao()
        {
            return getAccess().getAuditLogDao();
        }

        @Override
        public String getValueFor(MyAuditLog model)
        {
            return model.getUidValue();
        }

        @Override
        public void setValueFor(MyAuditLog model, String value)
        {
            model.setUidValue(value);
        }

        @Override
        public boolean hasValueFor(MyAuditLog model, String value)
        {
            return model.hasUidValue(value);
        }
    }

    //##################################################
    //# UserName
    //##################################################

    public class MyMetaAuditLog_UserName
        extends KmMetaStringProperty<MyAuditLog>
        implements KmMetaDaoPropertyIF<MyAuditLog,String>
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
            return MyAuditLogValidator.instance.getUserNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "userName";
        }

        @Override
        public MyAuditLogDao getDao()
        {
            return getAccess().getAuditLogDao();
        }

        @Override
        public String getValueFor(MyAuditLog model)
        {
            return model.getUserName();
        }

        @Override
        public void setValueFor(MyAuditLog model, String value)
        {
            model.setUserName(value);
        }

        @Override
        public boolean hasValueFor(MyAuditLog model, String value)
        {
            return model.hasUserName(value);
        }
    }

    //##################################################
    //# TypeName
    //##################################################

    public class MyMetaAuditLog_TypeName
        extends KmMetaStringProperty<MyAuditLog>
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
        public String getValueFor(MyAuditLog model)
        {
            return model.getTypeName();
        }

        @Override
        public boolean hasValueFor(MyAuditLog model, String value)
        {
            return model.hasTypeName(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaAuditLog_CreatedLocalTs
        extends KmMetaTimestampProperty<MyAuditLog>
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
        public KmTimestamp getValueFor(MyAuditLog model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyAuditLog model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaAuditLog_CreatedLocalTsMessage
        extends KmMetaStringProperty<MyAuditLog>
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
        public String getValueFor(MyAuditLog model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyAuditLog model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaAuditLog_CreatedLocalDate
        extends KmMetaDateProperty<MyAuditLog>
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
        public KmDate getValueFor(MyAuditLog model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyAuditLog model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaAuditLog_CreatedLocalTime
        extends KmMetaTimeProperty<MyAuditLog>
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
        public KmTime getValueFor(MyAuditLog model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyAuditLog model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }


    //##################################################
    //# Bundle
    //##################################################

    public class MyMetaAuditLog_Bundle
        extends KmMetaDaoAssociation<MyAuditLog,MyAuditBundle>
    {
        @Override
        public String getName()
        {
            return "bundle";
        }

        @Override
        public String getLabel()
        {
            return "Bundle";
        }

        @Override
        public String getHelp()
        {
            return "The bundle that contains this log.";
        }

        @Override
        public boolean isRequired()
        {
            return true;
        }

        @Override
        public MyAuditBundle getValueFor(MyAuditLog model)
        {
            return model.getBundle();
        }

        @Override
        public void setValueFor(MyAuditLog model, MyAuditBundle value)
        {
            model.setBundle(value);
        }

        @Override
        public boolean hasValueFor(MyAuditLog model, MyAuditBundle value)
        {
            return model.hasBundle(value);
        }
    }

    //##################################################
    //# User
    //##################################################

    public class MyMetaAuditLog_User
        extends KmMetaDaoAssociation<MyAuditLog,MyUser>
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
        public MyUser getValueFor(MyAuditLog model)
        {
            return model.getUser();
        }

        @Override
        public void setValueFor(MyAuditLog model, MyUser value)
        {
            model.setUser(value);
        }

        @Override
        public boolean hasValueFor(MyAuditLog model, MyUser value)
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
