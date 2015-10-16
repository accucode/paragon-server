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
import com.app.utility.*;

public abstract class MyFieldTestBase
    extends MyAbstractDomain
    implements MyDomainIF
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
    private Integer lockVersion;
    private MyUser userTest;

    //##################################################
    //# constructor
    //##################################################

    public MyFieldTestBase()
    {
        super();
        setUid(newUid());
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
        checkReadOnly();
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
    //# field (nameValue)
    //##################################################

    public String getNameValue()
    {
        return nameValue;
    }

    public void setNameValue(String e)
    {
        checkReadOnly();
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
        checkReadOnly();
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
        checkReadOnly();
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
        checkReadOnly();
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
        checkReadOnly();
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
        checkReadOnly();
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
        checkReadOnly();
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
        checkReadOnly();
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
        checkReadOnly();
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
        checkReadOnly();
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
    //# field (lockVersion)
    //##################################################

    public Integer getLockVersion()
    {
        return lockVersion;
    }

    public void setLockVersion(Integer e)
    {
        checkReadOnly();
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
    //# userTest
    //##################################################

    public MyUser getUserTest()
    {
        return userTest;
    }

    public void setUserTest(MyUser e)
    {
        checkReadOnly();
        userTest = e;
    }

    public void _setUserTest(MyUser e)
    {
        checkReadOnly();
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
        uid = null;
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
        if ( !Kmu.isEqual(getLockVersion(), e.getLockVersion()) ) return false;
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
}
