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

    public KmhBooleanCondition whereBooleanTest()
    {
        return new KmhBooleanCondition(context(), alias(), BOOLEAN_TEST);
    }

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), CREATED_UTC_TS);
    }

    public KmhDateCondition whereDateTest()
    {
        return new KmhDateCondition(context(), alias(), DATE_TEST);
    }

    public KmhPropertyCondition<KmDayFrequency> whereDayFrequency()
    {
        return new KmhPropertyCondition<>(context(), alias(), DAY_FREQUENCY);
    }

    public KmhPropertyCondition<Double> whereDoubleTest()
    {
        return new KmhPropertyCondition<>(context(), alias(), DOUBLE_TEST);
    }

    public KmhDurationCondition whereDuration()
    {
        return new KmhDurationCondition(context(), alias(), DURATION);
    }

    public KmhIntegerCondition whereIntegerValue()
    {
        return new KmhIntegerCondition(context(), alias(), INTEGER_VALUE);
    }

    public KmhPropertyCondition<Long> whereLongTest()
    {
        return new KmhPropertyCondition<>(context(), alias(), LONG_TEST);
    }

    public KmhPropertyCondition<KmMoney> whereMoneyTest()
    {
        return new KmhPropertyCondition<>(context(), alias(), MONEY_TEST);
    }

    public KmhStringCondition whereNameValue()
    {
        return new KmhStringCondition(context(), alias(), NAME_VALUE);
    }

    public KmhStringCondition wherePinNumber1()
    {
        return new KmhStringCondition(context(), alias(), PIN_NUMBER_1);
    }

    public KmhStringCondition wherePinNumber2()
    {
        return new KmhStringCondition(context(), alias(), PIN_NUMBER_2);
    }

    public KmhTimestampCondition whereTimestampTest()
    {
        return new KmhTimestampCondition(context(), alias(), TIMESTAMP_TEST);
    }

    public KmhStringCondition whereUid()
    {
        return new KmhStringCondition(context(), alias(), UID);
    }

    public KmhTimestampCondition whereUpdatedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), UPDATED_UTC_TS);
    }

    public KmhIntegerCondition whereLockVersion()
    {
        return new KmhIntegerCondition(context(), alias(), LOCK_VERSION);
    }

    //##################################################
    //# associations
    //##################################################
    //##################################################
    //# association (CreatedBy)
    //##################################################

//    public MyUserCriteria joinToCreatedBy()
//    {
//        return new MyUserCriteria(joinTo(CREATED_BY));
//    }
//
//    public MyUserCriteria leftJoinToCreatedBy()
//    {
//        return new MyUserCriteria(leftJoinTo(CREATED_BY));
//    }

    public KmhStringCondition whereCreatedByUid()
    {
        return new KmhStringCondition(context(), alias(), CREATED_BY_UID);
    }

    public void whereCreatedByIs(MyUser e)
    {
        if ( e == null )
            whereCreatedByUid().isNull();
        else
            whereCreatedByUid().is(e.getUid());
    }

    public void whereCreatedByIsNot(MyUser e)
    {
        if ( e == null )
            whereCreatedByUid().isNotNull();
        else
            whereCreatedByUid().isNot(e.getUid());
    }

    //##################################################
    //# association (UpdatedBy)
    //##################################################

//    public MyUserCriteria joinToUpdatedBy()
//    {
//        return new MyUserCriteria(joinTo(UPDATED_BY));
//    }
//
//    public MyUserCriteria leftJoinToUpdatedBy()
//    {
//        return new MyUserCriteria(leftJoinTo(UPDATED_BY));
//    }

    public KmhStringCondition whereUpdatedByUid()
    {
        return new KmhStringCondition(context(), alias(), UPDATED_BY_UID);
    }

    public void whereUpdatedByIs(MyUser e)
    {
        if ( e == null )
            whereUpdatedByUid().isNull();
        else
            whereUpdatedByUid().is(e.getUid());
    }

    public void whereUpdatedByIsNot(MyUser e)
    {
        if ( e == null )
            whereUpdatedByUid().isNotNull();
        else
            whereUpdatedByUid().isNot(e.getUid());
    }

    //##################################################
    //# association (UserTest)
    //##################################################

//    public MyUserCriteria joinToUserTest()
//    {
//        return new MyUserCriteria(joinTo(USER_TEST));
//    }
//
//    public MyUserCriteria leftJoinToUserTest()
//    {
//        return new MyUserCriteria(leftJoinTo(USER_TEST));
//    }

    public KmhStringCondition whereUserTestUid()
    {
        return new KmhStringCondition(context(), alias(), USER_TEST_UID);
    }

    public void whereUserTestIs(MyUser e)
    {
        if ( e == null )
            whereUserTestUid().isNull();
        else
            whereUserTestUid().is(e.getUid());
    }

    public void whereUserTestIsNot(MyUser e)
    {
        if ( e == null )
            whereUserTestUid().isNotNull();
        else
            whereUserTestUid().isNot(e.getUid());
    }


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
