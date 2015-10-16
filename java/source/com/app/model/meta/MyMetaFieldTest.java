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

    public static MyFieldTestValidator getValidator()
    {
        return MyFieldTestValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "This is NOT used by the application. Rather it is used solely to test frameworks during development.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaFieldTest_Uid Uid = new MyMetaFieldTest_Uid();
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
    public static final MyMetaFieldTest_LockVersion LockVersion = new MyMetaFieldTest_LockVersion();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaFieldTest_UserTest UserTest = new MyMetaFieldTest_UserTest();
}
