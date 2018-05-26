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

public class MyMetaFieldTest
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaFieldTest instance = new MyMetaFieldTest();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaFieldTest()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "fieldTest";
    }

    public MyFieldTestValidator getValidator()
    {
        return MyFieldTestValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "This is NOT used by the application. Rather it is used solely to test frameworks during development.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaFieldTest_AuditLogTitle AuditLogTitle = new MyMetaFieldTest_AuditLogTitle();
    public final MyMetaFieldTest_BooleanTest BooleanTest = new MyMetaFieldTest_BooleanTest();
    public final MyMetaFieldTest_CreatedUtcTs CreatedUtcTs = new MyMetaFieldTest_CreatedUtcTs();
    public final MyMetaFieldTest_DateTest DateTest = new MyMetaFieldTest_DateTest();
    public final MyMetaFieldTest_DayFrequency DayFrequency = new MyMetaFieldTest_DayFrequency();
    public final MyMetaFieldTest_DomainSubtitle DomainSubtitle = new MyMetaFieldTest_DomainSubtitle();
    public final MyMetaFieldTest_DomainTitle DomainTitle = new MyMetaFieldTest_DomainTitle();
    public final MyMetaFieldTest_DoubleTest DoubleTest = new MyMetaFieldTest_DoubleTest();
    public final MyMetaFieldTest_Duration Duration = new MyMetaFieldTest_Duration();
    public final MyMetaFieldTest_IntegerValue IntegerValue = new MyMetaFieldTest_IntegerValue();
    public final MyMetaFieldTest_LongTest LongTest = new MyMetaFieldTest_LongTest();
    public final MyMetaFieldTest_MoneyTest MoneyTest = new MyMetaFieldTest_MoneyTest();
    public final MyMetaFieldTest_NameValue NameValue = new MyMetaFieldTest_NameValue();
    public final MyMetaFieldTest_PinNumber1 PinNumber1 = new MyMetaFieldTest_PinNumber1();
    public final MyMetaFieldTest_PinNumber2 PinNumber2 = new MyMetaFieldTest_PinNumber2();
    public final MyMetaFieldTest_TimestampTest TimestampTest = new MyMetaFieldTest_TimestampTest();
    public final MyMetaFieldTest_Uid Uid = new MyMetaFieldTest_Uid();
    public final MyMetaFieldTest_UpdatedUtcTs UpdatedUtcTs = new MyMetaFieldTest_UpdatedUtcTs();
    public final MyMetaFieldTest_LockVersion LockVersion = new MyMetaFieldTest_LockVersion();
    public final MyMetaFieldTest_CreatedLocalTs CreatedLocalTs = new MyMetaFieldTest_CreatedLocalTs();
    public final MyMetaFieldTest_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaFieldTest_CreatedLocalTsMessage();
    public final MyMetaFieldTest_CreatedLocalDate CreatedLocalDate = new MyMetaFieldTest_CreatedLocalDate();
    public final MyMetaFieldTest_CreatedLocalTime CreatedLocalTime = new MyMetaFieldTest_CreatedLocalTime();
    public final MyMetaFieldTest_UpdatedLocalTs UpdatedLocalTs = new MyMetaFieldTest_UpdatedLocalTs();
    public final MyMetaFieldTest_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaFieldTest_UpdatedLocalTsMessage();
    public final MyMetaFieldTest_UpdatedLocalDate UpdatedLocalDate = new MyMetaFieldTest_UpdatedLocalDate();
    public final MyMetaFieldTest_UpdatedLocalTime UpdatedLocalTime = new MyMetaFieldTest_UpdatedLocalTime();
    public final MyMetaFieldTest_CreatedByFullName CreatedByFullName = new MyMetaFieldTest_CreatedByFullName();
    public final MyMetaFieldTest_UpdatedByFullName UpdatedByFullName = new MyMetaFieldTest_UpdatedByFullName();

    //##################################################
    //# associations
    //##################################################

    public final MyMetaFieldTest_CreatedBy CreatedBy = new MyMetaFieldTest_CreatedBy();
    public final MyMetaFieldTest_UpdatedBy UpdatedBy = new MyMetaFieldTest_UpdatedBy();
    public final MyMetaFieldTest_UserTest UserTest = new MyMetaFieldTest_UserTest();

    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaFieldTest_AuditLogTitle
        extends KmMetaStringProperty<MyFieldTest>
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
        public String getValueFor(MyFieldTest model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyFieldTest model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# BooleanTest
    //##################################################

    public class MyMetaFieldTest_BooleanTest
        extends KmMetaBooleanProperty<MyFieldTest>
        implements KmMetaDaoPropertyIF<MyFieldTest,Boolean>
    {
        @Override
        public String getName()
        {
            return "booleanTest";
        }

        @Override
        public String getLabel()
        {
            return "Boolean Test";
        }

        @Override
        public String getHelp()
        {
            return null;
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
            return MyFieldTestValidator.instance.getBooleanTestValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "booleanTest";
        }

        @Override
        public MyFieldTestDao getDao()
        {
            return getAccess().getFieldTestDao();
        }

        @Override
        public Boolean getValueFor(MyFieldTest model)
        {
            return model.getBooleanTest();
        }

        @Override
        public void setValueFor(MyFieldTest model, Boolean value)
        {
            model.setBooleanTest(value);
        }

        @Override
        public boolean hasValueFor(MyFieldTest model, Boolean value)
        {
            return model.hasBooleanTest(value);
        }
    }

    //##################################################
    //# CreatedUtcTs
    //##################################################

    public class MyMetaFieldTest_CreatedUtcTs
        extends KmMetaTimestampProperty<MyFieldTest>
        implements KmMetaDaoPropertyIF<MyFieldTest,KmTimestamp>
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
            return MyFieldTestValidator.instance.getCreatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "createdUtcTs";
        }

        @Override
        public MyFieldTestDao getDao()
        {
            return getAccess().getFieldTestDao();
        }

        @Override
        public KmTimestamp getValueFor(MyFieldTest model)
        {
            return model.getCreatedUtcTs();
        }

        @Override
        public void setValueFor(MyFieldTest model, KmTimestamp value)
        {
            model.setCreatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyFieldTest model, KmTimestamp value)
        {
            return model.hasCreatedUtcTs(value);
        }
    }

    //##################################################
    //# DateTest
    //##################################################

    public class MyMetaFieldTest_DateTest
        extends KmMetaDateProperty<MyFieldTest>
        implements KmMetaDaoPropertyIF<MyFieldTest,KmDate>
    {
        @Override
        public String getName()
        {
            return "dateTest";
        }

        @Override
        public String getLabel()
        {
            return "Date Test";
        }

        @Override
        public String getHelp()
        {
            return null;
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
            return MyFieldTestValidator.instance.getDateTestValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "dateTest";
        }

        @Override
        public MyFieldTestDao getDao()
        {
            return getAccess().getFieldTestDao();
        }

        @Override
        public KmDate getValueFor(MyFieldTest model)
        {
            return model.getDateTest();
        }

        @Override
        public void setValueFor(MyFieldTest model, KmDate value)
        {
            model.setDateTest(value);
        }

        @Override
        public boolean hasValueFor(MyFieldTest model, KmDate value)
        {
            return model.hasDateTest(value);
        }
    }

    //##################################################
    //# DayFrequency
    //##################################################

    public class MyMetaFieldTest_DayFrequency
        extends KmMetaDayFrequencyProperty<MyFieldTest>
        implements KmMetaDaoPropertyIF<MyFieldTest,KmDayFrequency>
    {
        @Override
        public String getName()
        {
            return "dayFrequency";
        }

        @Override
        public String getLabel()
        {
            return "Day Frequency";
        }

        @Override
        public String getHelp()
        {
            return "Day frequency (mon, tue, wed, etc)";
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
        public KmDayFrequencyValidator getValidator()
        {
            return MyFieldTestValidator.instance.getDayFrequencyValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "dayFrequency";
        }

        @Override
        public MyFieldTestDao getDao()
        {
            return getAccess().getFieldTestDao();
        }

        @Override
        public KmDayFrequency getValueFor(MyFieldTest model)
        {
            return model.getDayFrequency();
        }

        @Override
        public void setValueFor(MyFieldTest model, KmDayFrequency value)
        {
            model.setDayFrequency(value);
        }

        @Override
        public boolean hasValueFor(MyFieldTest model, KmDayFrequency value)
        {
            return model.hasDayFrequency(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaFieldTest_DomainSubtitle
        extends KmMetaStringProperty<MyFieldTest>
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
        public String getValueFor(MyFieldTest model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyFieldTest model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaFieldTest_DomainTitle
        extends KmMetaStringProperty<MyFieldTest>
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
        public String getValueFor(MyFieldTest model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyFieldTest model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# DoubleTest
    //##################################################

    public class MyMetaFieldTest_DoubleTest
        extends KmMetaDoubleProperty<MyFieldTest>
        implements KmMetaDaoPropertyIF<MyFieldTest,Double>
    {
        @Override
        public String getName()
        {
            return "doubleTest";
        }

        @Override
        public String getLabel()
        {
            return "Double Test";
        }

        @Override
        public String getHelp()
        {
            return null;
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
            return MyFieldTestValidator.instance.getDoubleTestValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "doubleTest";
        }

        @Override
        public MyFieldTestDao getDao()
        {
            return getAccess().getFieldTestDao();
        }

        @Override
        public Double getValueFor(MyFieldTest model)
        {
            return model.getDoubleTest();
        }

        @Override
        public void setValueFor(MyFieldTest model, Double value)
        {
            model.setDoubleTest(value);
        }

        @Override
        public boolean hasValueFor(MyFieldTest model, Double value)
        {
            return model.hasDoubleTest(value);
        }
    }

    //##################################################
    //# Duration
    //##################################################

    public class MyMetaFieldTest_Duration
        extends KmMetaDurationProperty<MyFieldTest>
        implements KmMetaDaoPropertyIF<MyFieldTest,KmDuration>
    {
        @Override
        public String getName()
        {
            return "duration";
        }

        @Override
        public String getLabel()
        {
            return "Duration";
        }

        @Override
        public String getHelp()
        {
            return "Duration in seconds.";
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
        public KmDurationValidator getValidator()
        {
            return MyFieldTestValidator.instance.getDurationValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "duration";
        }

        @Override
        public MyFieldTestDao getDao()
        {
            return getAccess().getFieldTestDao();
        }

        @Override
        public KmDuration getValueFor(MyFieldTest model)
        {
            return model.getDuration();
        }

        @Override
        public void setValueFor(MyFieldTest model, KmDuration value)
        {
            model.setDuration(value);
        }

        @Override
        public boolean hasValueFor(MyFieldTest model, KmDuration value)
        {
            return model.hasDuration(value);
        }
    }

    //##################################################
    //# IntegerValue
    //##################################################

    public class MyMetaFieldTest_IntegerValue
        extends KmMetaIntegerProperty<MyFieldTest>
        implements KmMetaDaoPropertyIF<MyFieldTest,Integer>
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
            return null;
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
            return MyFieldTestValidator.instance.getIntegerValueValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "integerValue";
        }

        @Override
        public MyFieldTestDao getDao()
        {
            return getAccess().getFieldTestDao();
        }

        @Override
        public Integer getValueFor(MyFieldTest model)
        {
            return model.getIntegerValue();
        }

        @Override
        public void setValueFor(MyFieldTest model, Integer value)
        {
            model.setIntegerValue(value);
        }

        @Override
        public boolean hasValueFor(MyFieldTest model, Integer value)
        {
            return model.hasIntegerValue(value);
        }
    }

    //##################################################
    //# LongTest
    //##################################################

    public class MyMetaFieldTest_LongTest
        extends KmMetaLongProperty<MyFieldTest>
        implements KmMetaDaoPropertyIF<MyFieldTest,Long>
    {
        @Override
        public String getName()
        {
            return "longTest";
        }

        @Override
        public String getLabel()
        {
            return "Long Test";
        }

        @Override
        public String getHelp()
        {
            return null;
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
            return MyFieldTestValidator.instance.getLongTestValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "longTest";
        }

        @Override
        public MyFieldTestDao getDao()
        {
            return getAccess().getFieldTestDao();
        }

        @Override
        public Long getValueFor(MyFieldTest model)
        {
            return model.getLongTest();
        }

        @Override
        public void setValueFor(MyFieldTest model, Long value)
        {
            model.setLongTest(value);
        }

        @Override
        public boolean hasValueFor(MyFieldTest model, Long value)
        {
            return model.hasLongTest(value);
        }
    }

    //##################################################
    //# MoneyTest
    //##################################################

    public class MyMetaFieldTest_MoneyTest
        extends KmMetaMoneyProperty<MyFieldTest>
        implements KmMetaDaoPropertyIF<MyFieldTest,KmMoney>
    {
        @Override
        public String getName()
        {
            return "moneyTest";
        }

        @Override
        public String getLabel()
        {
            return "Money Test";
        }

        @Override
        public String getHelp()
        {
            return null;
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
            return MyFieldTestValidator.instance.getMoneyTestValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "moneyTest";
        }

        @Override
        public MyFieldTestDao getDao()
        {
            return getAccess().getFieldTestDao();
        }

        @Override
        public KmMoney getValueFor(MyFieldTest model)
        {
            return model.getMoneyTest();
        }

        @Override
        public void setValueFor(MyFieldTest model, KmMoney value)
        {
            model.setMoneyTest(value);
        }

        @Override
        public boolean hasValueFor(MyFieldTest model, KmMoney value)
        {
            return model.hasMoneyTest(value);
        }
    }

    //##################################################
    //# NameValue
    //##################################################

    public class MyMetaFieldTest_NameValue
        extends KmMetaStringProperty<MyFieldTest>
        implements KmMetaDaoPropertyIF<MyFieldTest,String>
    {
        @Override
        public String getName()
        {
            return "nameValue";
        }

        @Override
        public String getLabel()
        {
            return "Name Value";
        }

        @Override
        public String getHelp()
        {
            return "A sample name.";
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
            return MyFieldTestValidator.instance.getNameValueValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "nameValue";
        }

        @Override
        public MyFieldTestDao getDao()
        {
            return getAccess().getFieldTestDao();
        }

        @Override
        public String getValueFor(MyFieldTest model)
        {
            return model.getNameValue();
        }

        @Override
        public void setValueFor(MyFieldTest model, String value)
        {
            model.setNameValue(value);
        }

        @Override
        public boolean hasValueFor(MyFieldTest model, String value)
        {
            return model.hasNameValue(value);
        }
    }

    //##################################################
    //# PinNumber1
    //##################################################

    public class MyMetaFieldTest_PinNumber1
        extends KmMetaStringProperty<MyFieldTest>
        implements KmMetaDaoPropertyIF<MyFieldTest,String>
    {
        @Override
        public String getName()
        {
            return "pinNumber1";
        }

        @Override
        public String getLabel()
        {
            return "Pin Number1";
        }

        @Override
        public String getHelp()
        {
            return "Included in the auditLog, but masked.";
        }

        @Override
        public int getColumnWidth()
        {
            return 5;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyFieldTestValidator.instance.getPinNumber1Validator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "pinNumber1";
        }

        @Override
        public MyFieldTestDao getDao()
        {
            return getAccess().getFieldTestDao();
        }

        @Override
        public String getValueFor(MyFieldTest model)
        {
            return model.getPinNumber1();
        }

        @Override
        public void setValueFor(MyFieldTest model, String value)
        {
            model.setPinNumber1(value);
        }

        @Override
        public boolean hasValueFor(MyFieldTest model, String value)
        {
            return model.hasPinNumber1(value);
        }
    }

    //##################################################
    //# PinNumber2
    //##################################################

    public class MyMetaFieldTest_PinNumber2
        extends KmMetaStringProperty<MyFieldTest>
        implements KmMetaDaoPropertyIF<MyFieldTest,String>
    {
        @Override
        public String getName()
        {
            return "pinNumber2";
        }

        @Override
        public String getLabel()
        {
            return "Pin Number2";
        }

        @Override
        public String getHelp()
        {
            return "Excluded from the auditLog.";
        }

        @Override
        public int getColumnWidth()
        {
            return 5;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyFieldTestValidator.instance.getPinNumber2Validator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "pinNumber2";
        }

        @Override
        public MyFieldTestDao getDao()
        {
            return getAccess().getFieldTestDao();
        }

        @Override
        public String getValueFor(MyFieldTest model)
        {
            return model.getPinNumber2();
        }

        @Override
        public void setValueFor(MyFieldTest model, String value)
        {
            model.setPinNumber2(value);
        }

        @Override
        public boolean hasValueFor(MyFieldTest model, String value)
        {
            return model.hasPinNumber2(value);
        }
    }

    //##################################################
    //# TimestampTest
    //##################################################

    public class MyMetaFieldTest_TimestampTest
        extends KmMetaTimestampProperty<MyFieldTest>
        implements KmMetaDaoPropertyIF<MyFieldTest,KmTimestamp>
    {
        @Override
        public String getName()
        {
            return "timestampTest";
        }

        @Override
        public String getLabel()
        {
            return "Timestamp Test";
        }

        @Override
        public String getHelp()
        {
            return null;
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
            return MyFieldTestValidator.instance.getTimestampTestValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "timestampTest";
        }

        @Override
        public MyFieldTestDao getDao()
        {
            return getAccess().getFieldTestDao();
        }

        @Override
        public KmTimestamp getValueFor(MyFieldTest model)
        {
            return model.getTimestampTest();
        }

        @Override
        public void setValueFor(MyFieldTest model, KmTimestamp value)
        {
            model.setTimestampTest(value);
        }

        @Override
        public boolean hasValueFor(MyFieldTest model, KmTimestamp value)
        {
            return model.hasTimestampTest(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaFieldTest_Uid
        extends KmMetaStringProperty<MyFieldTest>
        implements KmMetaDaoPropertyIF<MyFieldTest,String>
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
            return MyFieldTestValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyFieldTestDao getDao()
        {
            return getAccess().getFieldTestDao();
        }

        public KmDaoStringKeyCursor<MyFieldTest> createCursor()
        {
            KmDaoStringKeyCursor<MyFieldTest> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyFieldTest model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyFieldTest model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyFieldTest model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# UpdatedUtcTs
    //##################################################

    public class MyMetaFieldTest_UpdatedUtcTs
        extends KmMetaTimestampProperty<MyFieldTest>
        implements KmMetaDaoPropertyIF<MyFieldTest,KmTimestamp>
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
            return MyFieldTestValidator.instance.getUpdatedUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "updatedUtcTs";
        }

        @Override
        public MyFieldTestDao getDao()
        {
            return getAccess().getFieldTestDao();
        }

        @Override
        public KmTimestamp getValueFor(MyFieldTest model)
        {
            return model.getUpdatedUtcTs();
        }

        @Override
        public void setValueFor(MyFieldTest model, KmTimestamp value)
        {
            model.setUpdatedUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyFieldTest model, KmTimestamp value)
        {
            return model.hasUpdatedUtcTs(value);
        }
    }

    //##################################################
    //# LockVersion
    //##################################################

    public class MyMetaFieldTest_LockVersion
        extends KmMetaIntegerProperty<MyFieldTest>
        implements KmMetaDaoPropertyIF<MyFieldTest,Integer>
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
            return MyFieldTestValidator.instance.getLockVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lockVersion";
        }

        @Override
        public MyFieldTestDao getDao()
        {
            return getAccess().getFieldTestDao();
        }

        @Override
        public Integer getValueFor(MyFieldTest model)
        {
            return model.getLockVersion();
        }

        @Override
        public void setValueFor(MyFieldTest model, Integer value)
        {
            model.setLockVersion(value);
        }

        @Override
        public boolean hasValueFor(MyFieldTest model, Integer value)
        {
            return model.hasLockVersion(value);
        }
    }

    //##################################################
    //# CreatedLocalTs
    //##################################################

    public class MyMetaFieldTest_CreatedLocalTs
        extends KmMetaTimestampProperty<MyFieldTest>
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
        public KmTimestamp getValueFor(MyFieldTest model)
        {
            return model.getCreatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyFieldTest model, KmTimestamp value)
        {
            return model.hasCreatedLocalTs(value);
        }
    }

    //##################################################
    //# CreatedLocalTsMessage
    //##################################################

    public class MyMetaFieldTest_CreatedLocalTsMessage
        extends KmMetaStringProperty<MyFieldTest>
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
        public String getValueFor(MyFieldTest model)
        {
            return model.getCreatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyFieldTest model, String value)
        {
            return model.hasCreatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# CreatedLocalDate
    //##################################################

    public class MyMetaFieldTest_CreatedLocalDate
        extends KmMetaDateProperty<MyFieldTest>
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
        public KmDate getValueFor(MyFieldTest model)
        {
            return model.getCreatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyFieldTest model, KmDate value)
        {
            return model.hasCreatedLocalDate(value);
        }
    }

    //##################################################
    //# CreatedLocalTime
    //##################################################

    public class MyMetaFieldTest_CreatedLocalTime
        extends KmMetaTimeProperty<MyFieldTest>
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
        public KmTime getValueFor(MyFieldTest model)
        {
            return model.getCreatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyFieldTest model, KmTime value)
        {
            return model.hasCreatedLocalTime(value);
        }
    }

    //##################################################
    //# UpdatedLocalTs
    //##################################################

    public class MyMetaFieldTest_UpdatedLocalTs
        extends KmMetaTimestampProperty<MyFieldTest>
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
        public KmTimestamp getValueFor(MyFieldTest model)
        {
            return model.getUpdatedLocalTs();
        }

        @Override
        public boolean hasValueFor(MyFieldTest model, KmTimestamp value)
        {
            return model.hasUpdatedLocalTs(value);
        }
    }

    //##################################################
    //# UpdatedLocalTsMessage
    //##################################################

    public class MyMetaFieldTest_UpdatedLocalTsMessage
        extends KmMetaStringProperty<MyFieldTest>
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
        public String getValueFor(MyFieldTest model)
        {
            return model.getUpdatedLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyFieldTest model, String value)
        {
            return model.hasUpdatedLocalTsMessage(value);
        }
    }

    //##################################################
    //# UpdatedLocalDate
    //##################################################

    public class MyMetaFieldTest_UpdatedLocalDate
        extends KmMetaDateProperty<MyFieldTest>
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
        public KmDate getValueFor(MyFieldTest model)
        {
            return model.getUpdatedLocalDate();
        }

        @Override
        public boolean hasValueFor(MyFieldTest model, KmDate value)
        {
            return model.hasUpdatedLocalDate(value);
        }
    }

    //##################################################
    //# UpdatedLocalTime
    //##################################################

    public class MyMetaFieldTest_UpdatedLocalTime
        extends KmMetaTimeProperty<MyFieldTest>
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
        public KmTime getValueFor(MyFieldTest model)
        {
            return model.getUpdatedLocalTime();
        }

        @Override
        public boolean hasValueFor(MyFieldTest model, KmTime value)
        {
            return model.hasUpdatedLocalTime(value);
        }
    }

    //##################################################
    //# CreatedByFullName
    //##################################################

    public class MyMetaFieldTest_CreatedByFullName
        extends KmMetaStringProperty<MyFieldTest>
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
        public String getValueFor(MyFieldTest model)
        {
            return model.getCreatedByFullName();
        }

        @Override
        public void setValueFor(MyFieldTest model, String value)
        {
            model.setCreatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyFieldTest model, String value)
        {
            return model.hasCreatedByFullName(value);
        }
    }

    //##################################################
    //# UpdatedByFullName
    //##################################################

    public class MyMetaFieldTest_UpdatedByFullName
        extends KmMetaStringProperty<MyFieldTest>
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
        public String getValueFor(MyFieldTest model)
        {
            return model.getUpdatedByFullName();
        }

        @Override
        public void setValueFor(MyFieldTest model, String value)
        {
            model.setUpdatedByFullName(value);
        }

        @Override
        public boolean hasValueFor(MyFieldTest model, String value)
        {
            return model.hasUpdatedByFullName(value);
        }
    }


    //##################################################
    //# CreatedBy
    //##################################################

    public class MyMetaFieldTest_CreatedBy
        extends KmMetaDaoAssociation<MyFieldTest,MyUser>
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
        public MyUser getValueFor(MyFieldTest model)
        {
            return model.getCreatedBy();
        }

        @Override
        public void setValueFor(MyFieldTest model, MyUser value)
        {
            model.setCreatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyFieldTest model, MyUser value)
        {
            return model.hasCreatedBy(value);
        }
    }

    //##################################################
    //# UpdatedBy
    //##################################################

    public class MyMetaFieldTest_UpdatedBy
        extends KmMetaDaoAssociation<MyFieldTest,MyUser>
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
        public MyUser getValueFor(MyFieldTest model)
        {
            return model.getUpdatedBy();
        }

        @Override
        public void setValueFor(MyFieldTest model, MyUser value)
        {
            model.setUpdatedBy(value);
        }

        @Override
        public boolean hasValueFor(MyFieldTest model, MyUser value)
        {
            return model.hasUpdatedBy(value);
        }
    }

    //##################################################
    //# UserTest
    //##################################################

    public class MyMetaFieldTest_UserTest
        extends KmMetaDaoAssociation<MyFieldTest,MyUser>
    {
        @Override
        public String getName()
        {
            return "userTest";
        }

        @Override
        public String getLabel()
        {
            return "User Test";
        }

        @Override
        public String getHelp()
        {
            return "An optional associated to the user.";
        }

        @Override
        public boolean isRequired()
        {
            return false;
        }

        @Override
        public MyUser getValueFor(MyFieldTest model)
        {
            return model.getUserTest();
        }

        @Override
        public void setValueFor(MyFieldTest model, MyUser value)
        {
            model.setUserTest(value);
        }

        @Override
        public boolean hasValueFor(MyFieldTest model, MyUser value)
        {
            return model.hasUserTest(value);
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
