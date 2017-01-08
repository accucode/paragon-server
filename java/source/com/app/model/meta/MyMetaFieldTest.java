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
import com.kodemore.exception.*;
import com.kodemore.meta.*;
import com.kodemore.servlet.encoder.*;
import com.kodemore.servlet.field.*;
import com.kodemore.time.*;
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.model.*;
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

    public static final MyMetaFieldTest_Uid Uid = new MyMetaFieldTest_Uid();
    public static final MyMetaFieldTest_CreatedUtcTs CreatedUtcTs = new MyMetaFieldTest_CreatedUtcTs();
    public static final MyMetaFieldTest_UpdatedUtcTs UpdatedUtcTs = new MyMetaFieldTest_UpdatedUtcTs();
    public static final MyMetaFieldTest_NameValue NameValue = new MyMetaFieldTest_NameValue();
    public static final MyMetaFieldTest_IntegerValue IntegerValue = new MyMetaFieldTest_IntegerValue();
    public static final MyMetaFieldTest_LongTest LongTest = new MyMetaFieldTest_LongTest();
    public static final MyMetaFieldTest_DoubleTest DoubleTest = new MyMetaFieldTest_DoubleTest();
    public static final MyMetaFieldTest_MoneyTest MoneyTest = new MyMetaFieldTest_MoneyTest();
    public static final MyMetaFieldTest_BooleanTest BooleanTest = new MyMetaFieldTest_BooleanTest();
    public static final MyMetaFieldTest_DateTest DateTest = new MyMetaFieldTest_DateTest();
    public static final MyMetaFieldTest_TimestampTest TimestampTest = new MyMetaFieldTest_TimestampTest();
    public static final MyMetaFieldTest_PinNumber1 PinNumber1 = new MyMetaFieldTest_PinNumber1();
    public static final MyMetaFieldTest_PinNumber2 PinNumber2 = new MyMetaFieldTest_PinNumber2();
    public static final MyMetaFieldTest_Duration Duration = new MyMetaFieldTest_Duration();
    public static final MyMetaFieldTest_DayFrequency DayFrequency = new MyMetaFieldTest_DayFrequency();
    public static final MyMetaFieldTest_LockVersion LockVersion = new MyMetaFieldTest_LockVersion();
    public static final MyMetaFieldTest_DisplayString DisplayString = new MyMetaFieldTest_DisplayString();
    public static final MyMetaFieldTest_CreatedLocalTs CreatedLocalTs = new MyMetaFieldTest_CreatedLocalTs();
    public static final MyMetaFieldTest_CreatedLocalTsMessage CreatedLocalTsMessage = new MyMetaFieldTest_CreatedLocalTsMessage();
    public static final MyMetaFieldTest_CreatedLocalDate CreatedLocalDate = new MyMetaFieldTest_CreatedLocalDate();
    public static final MyMetaFieldTest_CreatedLocalTime CreatedLocalTime = new MyMetaFieldTest_CreatedLocalTime();
    public static final MyMetaFieldTest_UpdatedLocalTs UpdatedLocalTs = new MyMetaFieldTest_UpdatedLocalTs();
    public static final MyMetaFieldTest_UpdatedLocalTsMessage UpdatedLocalTsMessage = new MyMetaFieldTest_UpdatedLocalTsMessage();
    public static final MyMetaFieldTest_UpdatedLocalDate UpdatedLocalDate = new MyMetaFieldTest_UpdatedLocalDate();
    public static final MyMetaFieldTest_UpdatedLocalTime UpdatedLocalTime = new MyMetaFieldTest_UpdatedLocalTime();
    public static final MyMetaFieldTest_CreatedByFullName CreatedByFullName = new MyMetaFieldTest_CreatedByFullName();
    public static final MyMetaFieldTest_UpdatedByFullName UpdatedByFullName = new MyMetaFieldTest_UpdatedByFullName();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaFieldTest_CreatedBy CreatedBy = new MyMetaFieldTest_CreatedBy();
    public static final MyMetaFieldTest_UpdatedBy UpdatedBy = new MyMetaFieldTest_UpdatedBy();
    public static final MyMetaFieldTest_UserTest UserTest = new MyMetaFieldTest_UserTest();
}
