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

import com.app.criteria.core.*;
import com.app.dao.*;
import com.app.dao.base.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.meta.*;

public class MyFieldTestCriteria
    extends MyAbstractCriteria<MyFieldTest>
    implements MyFieldTestDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyFieldTestCriteria(KmhCriteria parent)
    {
        super(parent);
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
    //# sorts
    //##################################################

    public void sortOnUid()
    {
        parent().sortAscending(UID);
    }

    public void sortOnUidDescending()
    {
        parent().sortDescending(UID);
    }

    public void sortOnUid(boolean asc)
    {
        if ( asc )
            sortOnUid();
        else
            sortOnUidDescending();
    }

    public void sortOnNameValue()
    {
        parent().sortAscending(NAME_VALUE);
    }

    public void sortOnNameValueDescending()
    {
        parent().sortDescending(NAME_VALUE);
    }

    public void sortOnNameValue(boolean asc)
    {
        if ( asc )
            sortOnNameValue();
        else
            sortOnNameValueDescending();
    }

    public void sortOnIntegerValue()
    {
        parent().sortAscending(INTEGER_VALUE);
    }

    public void sortOnIntegerValueDescending()
    {
        parent().sortDescending(INTEGER_VALUE);
    }

    public void sortOnIntegerValue(boolean asc)
    {
        if ( asc )
            sortOnIntegerValue();
        else
            sortOnIntegerValueDescending();
    }

    public void sortOnLongTest()
    {
        parent().sortAscending(LONG_TEST);
    }

    public void sortOnLongTestDescending()
    {
        parent().sortDescending(LONG_TEST);
    }

    public void sortOnLongTest(boolean asc)
    {
        if ( asc )
            sortOnLongTest();
        else
            sortOnLongTestDescending();
    }

    public void sortOnDoubleTest()
    {
        parent().sortAscending(DOUBLE_TEST);
    }

    public void sortOnDoubleTestDescending()
    {
        parent().sortDescending(DOUBLE_TEST);
    }

    public void sortOnDoubleTest(boolean asc)
    {
        if ( asc )
            sortOnDoubleTest();
        else
            sortOnDoubleTestDescending();
    }

    public void sortOnMoneyTest()
    {
        parent().sortAscending(MONEY_TEST);
    }

    public void sortOnMoneyTestDescending()
    {
        parent().sortDescending(MONEY_TEST);
    }

    public void sortOnMoneyTest(boolean asc)
    {
        if ( asc )
            sortOnMoneyTest();
        else
            sortOnMoneyTestDescending();
    }

    public void sortOnBooleanTest()
    {
        parent().sortAscending(BOOLEAN_TEST);
    }

    public void sortOnBooleanTestDescending()
    {
        parent().sortDescending(BOOLEAN_TEST);
    }

    public void sortOnBooleanTest(boolean asc)
    {
        if ( asc )
            sortOnBooleanTest();
        else
            sortOnBooleanTestDescending();
    }

    public void sortOnDateTest()
    {
        parent().sortAscending(DATE_TEST);
    }

    public void sortOnDateTestDescending()
    {
        parent().sortDescending(DATE_TEST);
    }

    public void sortOnDateTest(boolean asc)
    {
        if ( asc )
            sortOnDateTest();
        else
            sortOnDateTestDescending();
    }

    public void sortOnTimestampTest()
    {
        parent().sortAscending(TIMESTAMP_TEST);
    }

    public void sortOnTimestampTestDescending()
    {
        parent().sortDescending(TIMESTAMP_TEST);
    }

    public void sortOnTimestampTest(boolean asc)
    {
        if ( asc )
            sortOnTimestampTest();
        else
            sortOnTimestampTestDescending();
    }

    public void sortOnPinNumber1()
    {
        parent().sortAscending(PIN_NUMBER_1);
    }

    public void sortOnPinNumber1Descending()
    {
        parent().sortDescending(PIN_NUMBER_1);
    }

    public void sortOnPinNumber1(boolean asc)
    {
        if ( asc )
            sortOnPinNumber1();
        else
            sortOnPinNumber1Descending();
    }

    public void sortOnPinNumber2()
    {
        parent().sortAscending(PIN_NUMBER_2);
    }

    public void sortOnPinNumber2Descending()
    {
        parent().sortDescending(PIN_NUMBER_2);
    }

    public void sortOnPinNumber2(boolean asc)
    {
        if ( asc )
            sortOnPinNumber2();
        else
            sortOnPinNumber2Descending();
    }

    public void sortOnLockVersion()
    {
        parent().sortAscending(LOCK_VERSION);
    }

    public void sortOnLockVersionDescending()
    {
        parent().sortDescending(LOCK_VERSION);
    }

    public void sortOnLockVersion(boolean asc)
    {
        if ( asc )
            sortOnLockVersion();
        else
            sortOnLockVersionDescending();
    }

    //##################################################
    //# projections (uid)
    //##################################################

    public void selectUid()
    {
        select(UID);
    }

    public void selectDistinctUid()
    {
        selectDistinct(UID);
    }

    public void selectCountDistinctUid()
    {
        selectCountDistinct(UID);
    }

    public void selectMinimumUid()
    {
        selectMinimum(UID);
    }

    public void selectMaximumUid()
    {
        selectMaximum(UID);
    }

    public void selectAverageUid()
    {
        selectAverage(UID);
    }

    public void selectSumUid()
    {
        selectSum(UID);
    }

    public void groupByUid()
    {
        groupBy(UID);
    }

    //##################################################
    //# projections (nameValue)
    //##################################################

    public void selectNameValue()
    {
        select(NAME_VALUE);
    }

    public void selectDistinctNameValue()
    {
        selectDistinct(NAME_VALUE);
    }

    public void selectCountDistinctNameValue()
    {
        selectCountDistinct(NAME_VALUE);
    }

    public void selectMinimumNameValue()
    {
        selectMinimum(NAME_VALUE);
    }

    public void selectMaximumNameValue()
    {
        selectMaximum(NAME_VALUE);
    }

    public void selectAverageNameValue()
    {
        selectAverage(NAME_VALUE);
    }

    public void selectSumNameValue()
    {
        selectSum(NAME_VALUE);
    }

    public void groupByNameValue()
    {
        groupBy(NAME_VALUE);
    }

    //##################################################
    //# projections (integerValue)
    //##################################################

    public void selectIntegerValue()
    {
        select(INTEGER_VALUE);
    }

    public void selectDistinctIntegerValue()
    {
        selectDistinct(INTEGER_VALUE);
    }

    public void selectCountDistinctIntegerValue()
    {
        selectCountDistinct(INTEGER_VALUE);
    }

    public void selectMinimumIntegerValue()
    {
        selectMinimum(INTEGER_VALUE);
    }

    public void selectMaximumIntegerValue()
    {
        selectMaximum(INTEGER_VALUE);
    }

    public void selectAverageIntegerValue()
    {
        selectAverage(INTEGER_VALUE);
    }

    public void selectSumIntegerValue()
    {
        selectSum(INTEGER_VALUE);
    }

    public void groupByIntegerValue()
    {
        groupBy(INTEGER_VALUE);
    }

    //##################################################
    //# projections (longTest)
    //##################################################

    public void selectLongTest()
    {
        select(LONG_TEST);
    }

    public void selectDistinctLongTest()
    {
        selectDistinct(LONG_TEST);
    }

    public void selectCountDistinctLongTest()
    {
        selectCountDistinct(LONG_TEST);
    }

    public void selectMinimumLongTest()
    {
        selectMinimum(LONG_TEST);
    }

    public void selectMaximumLongTest()
    {
        selectMaximum(LONG_TEST);
    }

    public void selectAverageLongTest()
    {
        selectAverage(LONG_TEST);
    }

    public void selectSumLongTest()
    {
        selectSum(LONG_TEST);
    }

    public void groupByLongTest()
    {
        groupBy(LONG_TEST);
    }

    //##################################################
    //# projections (doubleTest)
    //##################################################

    public void selectDoubleTest()
    {
        select(DOUBLE_TEST);
    }

    public void selectDistinctDoubleTest()
    {
        selectDistinct(DOUBLE_TEST);
    }

    public void selectCountDistinctDoubleTest()
    {
        selectCountDistinct(DOUBLE_TEST);
    }

    public void selectMinimumDoubleTest()
    {
        selectMinimum(DOUBLE_TEST);
    }

    public void selectMaximumDoubleTest()
    {
        selectMaximum(DOUBLE_TEST);
    }

    public void selectAverageDoubleTest()
    {
        selectAverage(DOUBLE_TEST);
    }

    public void selectSumDoubleTest()
    {
        selectSum(DOUBLE_TEST);
    }

    public void groupByDoubleTest()
    {
        groupBy(DOUBLE_TEST);
    }

    //##################################################
    //# projections (moneyTest)
    //##################################################

    public void selectMoneyTest()
    {
        select(MONEY_TEST);
    }

    public void selectDistinctMoneyTest()
    {
        selectDistinct(MONEY_TEST);
    }

    public void selectCountDistinctMoneyTest()
    {
        selectCountDistinct(MONEY_TEST);
    }

    public void selectMinimumMoneyTest()
    {
        selectMinimum(MONEY_TEST);
    }

    public void selectMaximumMoneyTest()
    {
        selectMaximum(MONEY_TEST);
    }

    public void selectAverageMoneyTest()
    {
        selectAverage(MONEY_TEST);
    }

    public void selectSumMoneyTest()
    {
        selectSum(MONEY_TEST);
    }

    public void groupByMoneyTest()
    {
        groupBy(MONEY_TEST);
    }

    //##################################################
    //# projections (booleanTest)
    //##################################################

    public void selectBooleanTest()
    {
        select(BOOLEAN_TEST);
    }

    public void selectDistinctBooleanTest()
    {
        selectDistinct(BOOLEAN_TEST);
    }

    public void selectCountDistinctBooleanTest()
    {
        selectCountDistinct(BOOLEAN_TEST);
    }

    public void selectMinimumBooleanTest()
    {
        selectMinimum(BOOLEAN_TEST);
    }

    public void selectMaximumBooleanTest()
    {
        selectMaximum(BOOLEAN_TEST);
    }

    public void selectAverageBooleanTest()
    {
        selectAverage(BOOLEAN_TEST);
    }

    public void selectSumBooleanTest()
    {
        selectSum(BOOLEAN_TEST);
    }

    public void groupByBooleanTest()
    {
        groupBy(BOOLEAN_TEST);
    }

    //##################################################
    //# projections (dateTest)
    //##################################################

    public void selectDateTest()
    {
        select(DATE_TEST);
    }

    public void selectDistinctDateTest()
    {
        selectDistinct(DATE_TEST);
    }

    public void selectCountDistinctDateTest()
    {
        selectCountDistinct(DATE_TEST);
    }

    public void selectMinimumDateTest()
    {
        selectMinimum(DATE_TEST);
    }

    public void selectMaximumDateTest()
    {
        selectMaximum(DATE_TEST);
    }

    public void selectAverageDateTest()
    {
        selectAverage(DATE_TEST);
    }

    public void selectSumDateTest()
    {
        selectSum(DATE_TEST);
    }

    public void groupByDateTest()
    {
        groupBy(DATE_TEST);
    }

    //##################################################
    //# projections (timestampTest)
    //##################################################

    public void selectTimestampTest()
    {
        select(TIMESTAMP_TEST);
    }

    public void selectDistinctTimestampTest()
    {
        selectDistinct(TIMESTAMP_TEST);
    }

    public void selectCountDistinctTimestampTest()
    {
        selectCountDistinct(TIMESTAMP_TEST);
    }

    public void selectMinimumTimestampTest()
    {
        selectMinimum(TIMESTAMP_TEST);
    }

    public void selectMaximumTimestampTest()
    {
        selectMaximum(TIMESTAMP_TEST);
    }

    public void selectAverageTimestampTest()
    {
        selectAverage(TIMESTAMP_TEST);
    }

    public void selectSumTimestampTest()
    {
        selectSum(TIMESTAMP_TEST);
    }

    public void groupByTimestampTest()
    {
        groupBy(TIMESTAMP_TEST);
    }

    //##################################################
    //# projections (pinNumber1)
    //##################################################

    public void selectPinNumber1()
    {
        select(PIN_NUMBER_1);
    }

    public void selectDistinctPinNumber1()
    {
        selectDistinct(PIN_NUMBER_1);
    }

    public void selectCountDistinctPinNumber1()
    {
        selectCountDistinct(PIN_NUMBER_1);
    }

    public void selectMinimumPinNumber1()
    {
        selectMinimum(PIN_NUMBER_1);
    }

    public void selectMaximumPinNumber1()
    {
        selectMaximum(PIN_NUMBER_1);
    }

    public void selectAveragePinNumber1()
    {
        selectAverage(PIN_NUMBER_1);
    }

    public void selectSumPinNumber1()
    {
        selectSum(PIN_NUMBER_1);
    }

    public void groupByPinNumber1()
    {
        groupBy(PIN_NUMBER_1);
    }

    //##################################################
    //# projections (pinNumber2)
    //##################################################

    public void selectPinNumber2()
    {
        select(PIN_NUMBER_2);
    }

    public void selectDistinctPinNumber2()
    {
        selectDistinct(PIN_NUMBER_2);
    }

    public void selectCountDistinctPinNumber2()
    {
        selectCountDistinct(PIN_NUMBER_2);
    }

    public void selectMinimumPinNumber2()
    {
        selectMinimum(PIN_NUMBER_2);
    }

    public void selectMaximumPinNumber2()
    {
        selectMaximum(PIN_NUMBER_2);
    }

    public void selectAveragePinNumber2()
    {
        selectAverage(PIN_NUMBER_2);
    }

    public void selectSumPinNumber2()
    {
        selectSum(PIN_NUMBER_2);
    }

    public void groupByPinNumber2()
    {
        groupBy(PIN_NUMBER_2);
    }

    //##################################################
    //# projections (lockVersion)
    //##################################################

    public void selectLockVersion()
    {
        select(LOCK_VERSION);
    }

    public void selectDistinctLockVersion()
    {
        selectDistinct(LOCK_VERSION);
    }

    public void selectCountDistinctLockVersion()
    {
        selectCountDistinct(LOCK_VERSION);
    }

    public void selectMinimumLockVersion()
    {
        selectMinimum(LOCK_VERSION);
    }

    public void selectMaximumLockVersion()
    {
        selectMaximum(LOCK_VERSION);
    }

    public void selectAverageLockVersion()
    {
        selectAverage(LOCK_VERSION);
    }

    public void selectSumLockVersion()
    {
        selectSum(LOCK_VERSION);
    }

    public void groupByLockVersion()
    {
        groupBy(LOCK_VERSION);
    }

    //##################################################
    //# association (UserTest)
    //##################################################

    public void selectUserTestUid()
    {
        select(USER_TEST_UID);
    }

    public void selectMinimumUserTestUid()
    {
        selectMinimum(USER_TEST_UID);
    }

    public void selectMaximumUserTestUid()
    {
        selectMaximum(USER_TEST_UID);
    }

    public void groupByUserTestUid()
    {
        groupBy(USER_TEST);
    }

    public MyUserCriteria joinToUserTest()
    {
        return new MyUserCriteria(joinTo(USER_TEST));
    }

    public MyUserCriteria leftJoinToUserTest()
    {
        return new MyUserCriteria(leftJoinTo(USER_TEST));
    }

    public KmhStringCondition whereUserTestUid()
    {
        return new KmhStringCondition(parent(), fullName(USER_TEST_UID));
    }

    public void whereUserTestIs(MyUser e)
    {
        if ( e == null )
            whereUserTestUid().isNull();
        else
            whereUserTestUid().is(e.getUid());
    }

    //##################################################
    //# junction
    //##################################################

    public MyFieldTestJunction addAnd()
    {
        return new MyFieldTestJunction(parent().addAnd());
    }

    public MyFieldTestJunction addOr()
    {
        return new MyFieldTestJunction(parent().addOr());
    }
}
