//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.criteria;

import com.kodemore.collection.*;
import com.kodemore.hibernate.*;
import com.kodemore.hibernate.basic.*;
import com.kodemore.time.*;
import com.kodemore.types.*;

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.meta.*;

public class MyFieldTestJunction
    extends KmhModelJunction
    implements MyFieldTestDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyFieldTestJunction(KmhJunction context)
    {
        super(context);
    }

    //##################################################
    //# properties
    //##################################################

    public KmhStringCondition whereUid()
    {
        return new KmhStringCondition(context(), fullName(UID));
    }

    public KmhStringCondition whereNameValue()
    {
        return new KmhStringCondition(context(), fullName(NAME_VALUE));
    }

    public KmhIntegerCondition whereIntegerValue()
    {
        return new KmhIntegerCondition(context(), fullName(INTEGER_VALUE));
    }

    public KmhPropertyCondition<Long> whereLongTest()
    {
        return new KmhPropertyCondition<>(context(), fullName(LONG_TEST));
    }

    public KmhPropertyCondition<Double> whereDoubleTest()
    {
        return new KmhPropertyCondition<>(context(), fullName(DOUBLE_TEST));
    }

    public KmhPropertyCondition<KmMoney> whereMoneyTest()
    {
        return new KmhPropertyCondition<>(context(), fullName(MONEY_TEST));
    }

    public KmhBooleanCondition whereBooleanTest()
    {
        return new KmhBooleanCondition(context(), fullName(BOOLEAN_TEST));
    }

    public KmhDateCondition whereDateTest()
    {
        return new KmhDateCondition(context(), fullName(DATE_TEST));
    }

    public KmhTimestampCondition whereTimestampTest()
    {
        return new KmhTimestampCondition(context(), fullName(TIMESTAMP_TEST));
    }

    public KmhStringCondition wherePinNumber1()
    {
        return new KmhStringCondition(context(), fullName(PIN_NUMBER_1));
    }

    public KmhStringCondition wherePinNumber2()
    {
        return new KmhStringCondition(context(), fullName(PIN_NUMBER_2));
    }

    public KmhIntegerCondition whereLockVersion()
    {
        return new KmhIntegerCondition(context(), fullName(LOCK_VERSION));
    }

    //##################################################
    //# associations
    //##################################################

    //##################################################
    //# junction
    //##################################################

    public MyFieldTestJunction addAnd()
    {
        return new MyFieldTestJunction(context().addAnd());
    }

    public MyFieldTestJunction addOr()
    {
        return new MyFieldTestJunction(context().addOr());
    }

}
