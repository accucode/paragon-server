//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import java.util.*;

import com.kodemore.collection.*;
import com.kodemore.exception.*;
import com.kodemore.servlet.encoder.*;
import com.kodemore.servlet.utility.*;
import com.kodemore.time.*;
import com.kodemore.types.*;
import com.kodemore.utility.*;

import com.app.model.*;
import com.app.model.core.*;
import com.app.model.meta.*;
import com.app.model.support.*;
import com.app.ui.dashboard.core.*;
import com.app.utility.*;

@SuppressWarnings("all")
public abstract class MyFieldTestBase
    extends MyAbstractDaoDomain
    implements MyUidDomainIF
    ,MyBasicTimestampsIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaFieldTest Meta = MyMetaFieldTest.instance;
    public static final MyFieldTestTools Tools = MyFieldTestTools.instance;
    public static final MyFieldTestValidator Validator = MyFieldTestValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private KmTimestamp createdUtcTs;
    private KmTimestamp updatedUtcTs;
    private String nameValue;
    private Integer integerValue;
    private Long longTest;
    private Double doubleTest;
    private KmMoney moneyTest;
    private Boolean booleanTest;
    private KmDate dateTest;
    private KmTimestamp timestampTest;
    private String pinNumber1;
    private String pinNumber2;
    private KmDuration duration;
    private KmDayFrequency dayFrequency;
    private Integer lockVersion;
    private MyUser createdBy;
    private MyUser updatedBy;
    private MyUser userTest;

    //##################################################
    //# constructor
    //##################################################

    public MyFieldTestBase()
    {
        super();
        setUid(newUid());
        setCreatedUtcTs(nowUtc());
        setUpdatedUtcTs(nowUtc());
        setLockVersion(0);
        setCreatedBy(MyGlobals.getCurrentUser());
        setUpdatedBy(MyGlobals.getCurrentUser());
    }

    //##################################################
    //# field (uid)
    //##################################################

    public String getUid()
    {
        return uid;
    }

    public void setUid(String e)
    {
        e = Validator.getUidValidator().convertOnly(e);
        uid = e;
    }

    public void clearUid()
    {
        setUid(null);
    }

    public boolean hasUid()
    {
        return Kmu.hasValue(getUid());
    }

    public boolean hasUid(String e)
    {
        return Kmu.isEqualIgnoreCase(getUid(), e);
    }

    public void truncateUid()
    {
        truncateUid(false);
    }

    public void truncateUid(boolean ellipses)
    {
        uid = Kmu.truncate(uid, 30, ellipses);
    }

    //##################################################
    //# field (createdUtcTs)
    //##################################################

    public KmTimestamp getCreatedUtcTs()
    {
        return createdUtcTs;
    }

    public void setCreatedUtcTs(KmTimestamp e)
    {
        e = Validator.getCreatedUtcTsValidator().convertOnly(e);
        createdUtcTs = e;
    }

    public void clearCreatedUtcTs()
    {
        setCreatedUtcTs(null);
    }

    public boolean hasCreatedUtcTs()
    {
        return getCreatedUtcTs() != null;
    }

    public boolean hasCreatedUtcTs(KmTimestamp e)
    {
        return Kmu.isEqual(getCreatedUtcTs(), e);
    }

    //##################################################
    //# field (updatedUtcTs)
    //##################################################

    public KmTimestamp getUpdatedUtcTs()
    {
        return updatedUtcTs;
    }

    public void setUpdatedUtcTs(KmTimestamp e)
    {
        e = Validator.getUpdatedUtcTsValidator().convertOnly(e);
        updatedUtcTs = e;
    }

    public void clearUpdatedUtcTs()
    {
        setUpdatedUtcTs(null);
    }

    public boolean hasUpdatedUtcTs()
    {
        return getUpdatedUtcTs() != null;
    }

    public boolean hasUpdatedUtcTs(KmTimestamp e)
    {
        return Kmu.isEqual(getUpdatedUtcTs(), e);
    }

    //##################################################
    //# field (nameValue)
    //##################################################

    public String getNameValue()
    {
        return nameValue;
    }

    public void setNameValue(String e)
    {
        e = Validator.getNameValueValidator().convertOnly(e);
        nameValue = e;
    }

    public void clearNameValue()
    {
        setNameValue(null);
    }

    public boolean hasNameValue()
    {
        return Kmu.hasValue(getNameValue());
    }

    public boolean hasNameValue(String e)
    {
        return Kmu.isEqualIgnoreCase(getNameValue(), e);
    }

    public void truncateNameValue()
    {
        truncateNameValue(false);
    }

    public void truncateNameValue(boolean ellipses)
    {
        nameValue = Kmu.truncate(nameValue, 50, ellipses);
    }

    //##################################################
    //# field (integerValue)
    //##################################################

    public Integer getIntegerValue()
    {
        return integerValue;
    }

    public void setIntegerValue(Integer e)
    {
        e = Validator.getIntegerValueValidator().convertOnly(e);
        integerValue = e;
    }

    public void clearIntegerValue()
    {
        setIntegerValue(null);
    }

    public boolean hasIntegerValue()
    {
        return getIntegerValue() != null;
    }

    public boolean hasIntegerValue(Integer e)
    {
        return Kmu.isEqual(getIntegerValue(), e);
    }

    //##################################################
    //# field (longTest)
    //##################################################

    public Long getLongTest()
    {
        return longTest;
    }

    public void setLongTest(Long e)
    {
        e = Validator.getLongTestValidator().convertOnly(e);
        longTest = e;
    }

    public void clearLongTest()
    {
        setLongTest(null);
    }

    public boolean hasLongTest()
    {
        return getLongTest() != null;
    }

    public boolean hasLongTest(Long e)
    {
        return Kmu.isEqual(getLongTest(), e);
    }

    //##################################################
    //# field (doubleTest)
    //##################################################

    public Double getDoubleTest()
    {
        return doubleTest;
    }

    public void setDoubleTest(Double e)
    {
        e = Validator.getDoubleTestValidator().convertOnly(e);
        doubleTest = e;
    }

    public void clearDoubleTest()
    {
        setDoubleTest(null);
    }

    public boolean hasDoubleTest()
    {
        return getDoubleTest() != null;
    }

    public boolean hasDoubleTest(Double e)
    {
        return Kmu.isEqual(getDoubleTest(), e);
    }

    //##################################################
    //# field (moneyTest)
    //##################################################

    public KmMoney getMoneyTest()
    {
        return moneyTest;
    }

    public void setMoneyTest(KmMoney e)
    {
        e = Validator.getMoneyTestValidator().convertOnly(e);
        moneyTest = e;
    }

    public void clearMoneyTest()
    {
        setMoneyTest(null);
    }

    public boolean hasMoneyTest()
    {
        return getMoneyTest() != null;
    }

    public boolean hasMoneyTest(KmMoney e)
    {
        return Kmu.isEqual(getMoneyTest(), e);
    }

    //##################################################
    //# field (booleanTest)
    //##################################################

    public Boolean getBooleanTest()
    {
        return booleanTest;
    }

    public void setBooleanTest(Boolean e)
    {
        e = Validator.getBooleanTestValidator().convertOnly(e);
        booleanTest = e;
    }

    public void clearBooleanTest()
    {
        setBooleanTest(null);
    }

    public boolean hasBooleanTest()
    {
        return getBooleanTest() != null;
    }

    public boolean hasBooleanTest(Boolean e)
    {
        return Kmu.isEqual(getBooleanTest(), e);
    }

    public boolean isBooleanTest()
    {
        if ( getBooleanTest() == null )
            return false;
        return getBooleanTest();
    }

    public boolean isNotBooleanTest()
    {
        return !isBooleanTest();
    }

    public boolean isBooleanTest(Boolean b)
    {
        return Kmu.isEqual(getBooleanTest(), b);
    }

    public void toggleBooleanTest()
    {
        setBooleanTest(!getBooleanTest());
    }

    //##################################################
    //# field (dateTest)
    //##################################################

    public KmDate getDateTest()
    {
        return dateTest;
    }

    public void setDateTest(KmDate e)
    {
        e = Validator.getDateTestValidator().convertOnly(e);
        dateTest = e;
    }

    public void clearDateTest()
    {
        setDateTest(null);
    }

    public boolean hasDateTest()
    {
        return getDateTest() != null;
    }

    public boolean hasDateTest(KmDate e)
    {
        return Kmu.isEqual(getDateTest(), e);
    }

    //##################################################
    //# field (timestampTest)
    //##################################################

    public KmTimestamp getTimestampTest()
    {
        return timestampTest;
    }

    public void setTimestampTest(KmTimestamp e)
    {
        e = Validator.getTimestampTestValidator().convertOnly(e);
        timestampTest = e;
    }

    public void clearTimestampTest()
    {
        setTimestampTest(null);
    }

    public boolean hasTimestampTest()
    {
        return getTimestampTest() != null;
    }

    public boolean hasTimestampTest(KmTimestamp e)
    {
        return Kmu.isEqual(getTimestampTest(), e);
    }

    //##################################################
    //# field (pinNumber1)
    //##################################################

    public String getPinNumber1()
    {
        return pinNumber1;
    }

    public void setPinNumber1(String e)
    {
        e = Validator.getPinNumber1Validator().convertOnly(e);
        pinNumber1 = e;
    }

    public void clearPinNumber1()
    {
        setPinNumber1(null);
    }

    public boolean hasPinNumber1()
    {
        return Kmu.hasValue(getPinNumber1());
    }

    public boolean hasPinNumber1(String e)
    {
        return Kmu.isEqualIgnoreCase(getPinNumber1(), e);
    }

    public void truncatePinNumber1()
    {
        truncatePinNumber1(false);
    }

    public void truncatePinNumber1(boolean ellipses)
    {
        pinNumber1 = Kmu.truncate(pinNumber1, 5, ellipses);
    }

    //##################################################
    //# field (pinNumber2)
    //##################################################

    public String getPinNumber2()
    {
        return pinNumber2;
    }

    public void setPinNumber2(String e)
    {
        e = Validator.getPinNumber2Validator().convertOnly(e);
        pinNumber2 = e;
    }

    public void clearPinNumber2()
    {
        setPinNumber2(null);
    }

    public boolean hasPinNumber2()
    {
        return Kmu.hasValue(getPinNumber2());
    }

    public boolean hasPinNumber2(String e)
    {
        return Kmu.isEqualIgnoreCase(getPinNumber2(), e);
    }

    public void truncatePinNumber2()
    {
        truncatePinNumber2(false);
    }

    public void truncatePinNumber2(boolean ellipses)
    {
        pinNumber2 = Kmu.truncate(pinNumber2, 5, ellipses);
    }

    //##################################################
    //# field (duration)
    //##################################################

    public KmDuration getDuration()
    {
        return duration;
    }

    public void setDuration(KmDuration e)
    {
        e = Validator.getDurationValidator().convertOnly(e);
        duration = e;
    }

    public void clearDuration()
    {
        setDuration(null);
    }

    public boolean hasDuration()
    {
        return getDuration() != null;
    }

    public boolean hasDuration(KmDuration e)
    {
        return Kmu.isEqual(getDuration(), e);
    }

    //##################################################
    //# field (dayFrequency)
    //##################################################

    public KmDayFrequency getDayFrequency()
    {
        return dayFrequency;
    }

    public void setDayFrequency(KmDayFrequency e)
    {
        e = Validator.getDayFrequencyValidator().convertOnly(e);
        dayFrequency = e;
    }

    public void clearDayFrequency()
    {
        setDayFrequency(null);
    }

    public boolean hasDayFrequency()
    {
        return getDayFrequency() != null;
    }

    public boolean hasDayFrequency(KmDayFrequency e)
    {
        return Kmu.isEqual(getDayFrequency(), e);
    }

    //##################################################
    //# field (lockVersion)
    //##################################################

    public Integer getLockVersion()
    {
        return lockVersion;
    }

    public void setLockVersion(Integer e)
    {
        e = Validator.getLockVersionValidator().convertOnly(e);
        lockVersion = e;
    }

    public void clearLockVersion()
    {
        setLockVersion(null);
    }

    public boolean hasLockVersion()
    {
        return getLockVersion() != null;
    }

    public boolean hasLockVersion(Integer e)
    {
        return Kmu.isEqual(getLockVersion(), e);
    }

    //##################################################
    //# field (displayString)
    //##################################################

    public abstract String getDisplayString();

    public boolean hasDisplayString()
    {
        return Kmu.hasValue(getDisplayString());
    }

    public boolean hasDisplayString(String e)
    {
        return Kmu.isEqualIgnoreCase(getDisplayString(), e);
    }

    //##################################################
    //# field (createdLocalTs)
    //##################################################

    public final KmTimestamp getCreatedLocalTs()
    {
        return KmTimestampUtility.toLocal(getCreatedUtcTs());
    }

    public boolean hasCreatedLocalTs()
    {
        return getCreatedLocalTs() != null;
    }

    public boolean hasCreatedLocalTs(KmTimestamp e)
    {
        return Kmu.isEqual(getCreatedLocalTs(), e);
    }

    //##################################################
    //# field (createdLocalTsMessage)
    //##################################################

    public final String getCreatedLocalTsMessage()
    {
        return KmTimestampUtility.formatLocalMessage(getCreatedUtcTs());
    }

    public boolean hasCreatedLocalTsMessage()
    {
        return Kmu.hasValue(getCreatedLocalTsMessage());
    }

    public boolean hasCreatedLocalTsMessage(String e)
    {
        return Kmu.isEqualIgnoreCase(getCreatedLocalTsMessage(), e);
    }

    //##################################################
    //# field (createdLocalDate)
    //##################################################

    public final KmDate getCreatedLocalDate()
    {
        return KmTimestampUtility.getDate(getCreatedLocalTs());
    }

    public boolean hasCreatedLocalDate()
    {
        return getCreatedLocalDate() != null;
    }

    public boolean hasCreatedLocalDate(KmDate e)
    {
        return Kmu.isEqual(getCreatedLocalDate(), e);
    }

    //##################################################
    //# field (createdLocalTime)
    //##################################################

    public final KmTime getCreatedLocalTime()
    {
        return KmTimestampUtility.getTime(getCreatedLocalTs());
    }

    public boolean hasCreatedLocalTime()
    {
        return getCreatedLocalTime() != null;
    }

    public boolean hasCreatedLocalTime(KmTime e)
    {
        return Kmu.isEqual(getCreatedLocalTime(), e);
    }

    //##################################################
    //# field (updatedLocalTs)
    //##################################################

    public final KmTimestamp getUpdatedLocalTs()
    {
        return KmTimestampUtility.toLocal(getUpdatedUtcTs());
    }

    public boolean hasUpdatedLocalTs()
    {
        return getUpdatedLocalTs() != null;
    }

    public boolean hasUpdatedLocalTs(KmTimestamp e)
    {
        return Kmu.isEqual(getUpdatedLocalTs(), e);
    }

    //##################################################
    //# field (updatedLocalTsMessage)
    //##################################################

    public final String getUpdatedLocalTsMessage()
    {
        return KmTimestampUtility.formatLocalMessage(getUpdatedUtcTs());
    }

    public boolean hasUpdatedLocalTsMessage()
    {
        return Kmu.hasValue(getUpdatedLocalTsMessage());
    }

    public boolean hasUpdatedLocalTsMessage(String e)
    {
        return Kmu.isEqualIgnoreCase(getUpdatedLocalTsMessage(), e);
    }

    //##################################################
    //# field (updatedLocalDate)
    //##################################################

    public final KmDate getUpdatedLocalDate()
    {
        return KmTimestampUtility.getDate(getUpdatedLocalTs());
    }

    public boolean hasUpdatedLocalDate()
    {
        return getUpdatedLocalDate() != null;
    }

    public boolean hasUpdatedLocalDate(KmDate e)
    {
        return Kmu.isEqual(getUpdatedLocalDate(), e);
    }

    //##################################################
    //# field (updatedLocalTime)
    //##################################################

    public final KmTime getUpdatedLocalTime()
    {
        return KmTimestampUtility.getTime(getUpdatedLocalTs());
    }

    public boolean hasUpdatedLocalTime()
    {
        return getUpdatedLocalTime() != null;
    }

    public boolean hasUpdatedLocalTime(KmTime e)
    {
        return Kmu.isEqual(getUpdatedLocalTime(), e);
    }

    //##################################################
    //# createdBy
    //##################################################

    public MyUser getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy(MyUser e)
    {
        createdBy = e;
    }

    public void _setCreatedBy(MyUser e)
    {
        createdBy = e;
    }

    public void clearCreatedBy()
    {
        setCreatedBy(null);
    }

    public boolean hasCreatedBy()
    {
        return getCreatedBy() != null;
    }

    public boolean hasCreatedBy(MyUser e)
    {
        return Kmu.isEqual(getCreatedBy(), e);
    }

    public String getCreatedByFullName()
    {
        if ( hasCreatedBy() )
            return getCreatedBy().getFullName();
        return null;
    }

    public boolean hasCreatedByFullName()
    {
        return hasCreatedBy() && getCreatedBy().hasFullName();
    }

    public boolean hasCreatedByFullName(String e)
    {
        return hasCreatedBy() && getCreatedBy().hasFullName(e);
    }

    //##################################################
    //# updatedBy
    //##################################################

    public MyUser getUpdatedBy()
    {
        return updatedBy;
    }

    public void setUpdatedBy(MyUser e)
    {
        updatedBy = e;
    }

    public void _setUpdatedBy(MyUser e)
    {
        updatedBy = e;
    }

    public void clearUpdatedBy()
    {
        setUpdatedBy(null);
    }

    public boolean hasUpdatedBy()
    {
        return getUpdatedBy() != null;
    }

    public boolean hasUpdatedBy(MyUser e)
    {
        return Kmu.isEqual(getUpdatedBy(), e);
    }

    public String getUpdatedByFullName()
    {
        if ( hasUpdatedBy() )
            return getUpdatedBy().getFullName();
        return null;
    }

    public boolean hasUpdatedByFullName()
    {
        return hasUpdatedBy() && getUpdatedBy().hasFullName();
    }

    public boolean hasUpdatedByFullName(String e)
    {
        return hasUpdatedBy() && getUpdatedBy().hasFullName(e);
    }

    //##################################################
    //# userTest
    //##################################################

    public MyUser getUserTest()
    {
        return userTest;
    }

    public void setUserTest(MyUser e)
    {
        userTest = e;
    }

    public void _setUserTest(MyUser e)
    {
        userTest = e;
    }

    public void clearUserTest()
    {
        setUserTest(null);
    }

    public boolean hasUserTest()
    {
        return getUserTest() != null;
    }

    public boolean hasUserTest(MyUser e)
    {
        return Kmu.isEqual(getUserTest(), e);
    }


    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        Validator.validate((MyFieldTest)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyFieldTest)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyFieldTest)this);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyFieldTest getCopy()
    {
        return (MyFieldTest)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = newUid();
    }

    /**
     * Get a copy of this model without any associations or collections.
     * The primary key and lock version are not copied.
     * The basic timestamps are reset.
     */
    public final MyFieldTest getBasicCopy()
    {
        MyFieldTest e;
        e = new MyFieldTest();
        e.setCreatedUtcTs(getCreatedUtcTs());
        e.setUpdatedUtcTs(getUpdatedUtcTs());
        e.setNameValue(getNameValue());
        e.setIntegerValue(getIntegerValue());
        e.setLongTest(getLongTest());
        e.setDoubleTest(getDoubleTest());
        e.setMoneyTest(getMoneyTest());
        e.setBooleanTest(getBooleanTest());
        e.setDateTest(getDateTest());
        e.setTimestampTest(getTimestampTest());
        e.setPinNumber1(getPinNumber1());
        e.setPinNumber2(getPinNumber2());
        e.setDuration(getDuration());
        e.setDayFrequency(getDayFrequency());
        resetBasicTimestamps();
        return e;
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyFieldTestBase) )
            return false;

        MyFieldTestBase e = (MyFieldTestBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyFieldTest e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyFieldTest e)
    {
        if ( !Kmu.isEqual(getCreatedUtcTs(), e.getCreatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getUpdatedUtcTs(), e.getUpdatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getNameValue(), e.getNameValue()) ) return false;
        if ( !Kmu.isEqual(getIntegerValue(), e.getIntegerValue()) ) return false;
        if ( !Kmu.isEqual(getLongTest(), e.getLongTest()) ) return false;
        if ( !Kmu.isEqual(getDoubleTest(), e.getDoubleTest()) ) return false;
        if ( !Kmu.isEqual(getMoneyTest(), e.getMoneyTest()) ) return false;
        if ( !Kmu.isEqual(getBooleanTest(), e.getBooleanTest()) ) return false;
        if ( !Kmu.isEqual(getDateTest(), e.getDateTest()) ) return false;
        if ( !Kmu.isEqual(getTimestampTest(), e.getTimestampTest()) ) return false;
        if ( !Kmu.isEqual(getPinNumber1(), e.getPinNumber1()) ) return false;
        if ( !Kmu.isEqual(getPinNumber2(), e.getPinNumber2()) ) return false;
        if ( !Kmu.isEqual(getDuration(), e.getDuration()) ) return false;
        if ( !Kmu.isEqual(getDayFrequency(), e.getDayFrequency()) ) return false;
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
        if ( !Kmu.isEqual(getDisplayString(), e.getDisplayString()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTs(), e.getCreatedLocalTs()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTsMessage(), e.getCreatedLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalDate(), e.getCreatedLocalDate()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTime(), e.getCreatedLocalTime()) ) return false;
        if ( !Kmu.isEqual(getUpdatedLocalTs(), e.getUpdatedLocalTs()) ) return false;
        if ( !Kmu.isEqual(getUpdatedLocalTsMessage(), e.getUpdatedLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getUpdatedLocalDate(), e.getUpdatedLocalDate()) ) return false;
        if ( !Kmu.isEqual(getUpdatedLocalTime(), e.getUpdatedLocalTime()) ) return false;
        return true;
    }

    public boolean isDifferent(MyFieldTest e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyFieldTest e)
    {
        return !isSameIgnoringKey(e);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        StringBuilder out;
        out = new StringBuilder();
        out.append("MyFieldTest");
        out.append("(");
        out.append("Uid=");
        out.append(uid);
        out.append(")");
        return out.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    Uid = " + uid);
        System.out.println("    CreatedUtcTs = " + createdUtcTs);
        System.out.println("    UpdatedUtcTs = " + updatedUtcTs);
        System.out.println("    NameValue = " + nameValue);
        System.out.println("    IntegerValue = " + integerValue);
        System.out.println("    LongTest = " + longTest);
        System.out.println("    DoubleTest = " + doubleTest);
        System.out.println("    MoneyTest = " + moneyTest);
        System.out.println("    BooleanTest = " + booleanTest);
        System.out.println("    DateTest = " + dateTest);
        System.out.println("    TimestampTest = " + timestampTest);
        System.out.println("    PinNumber1 = " + pinNumber1);
        System.out.println("    PinNumber2 = " + pinNumber2);
        System.out.println("    Duration = " + duration);
        System.out.println("    DayFrequency = " + dayFrequency);
        System.out.println("    LockVersion = " + lockVersion);
    }

    /**
     * Format the primary key fields in a comma separated list.  The format
     * is intended to be suitable for display to users.
     */
    @Override
    public String formatPrimaryKey()
    {
        return uid;
    }


    //##################################################
    //# convenience
    //##################################################

    @Override
    public String getMetaName()
    {
        return Meta.getName();
    }

    public void daoTouch()
    {
        setLockVersion(getLockVersion() + 1);
    }

}
