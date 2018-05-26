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
import com.app.model.base.*;
import com.app.model.meta.*;

public class MySettingsCriteria
    extends MyAbstractCriteria<MySettings>
    implements MySettingsDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MySettingsCriteria(KmhCriteria parent)
    {
        super(parent);
    }

    //##################################################
    //# primary key
    //##################################################

    public void whereCodeIs(MySettings e)
    {
        whereCode().is(e.getCode());
    }

    public void whereCodeIsNot(MySettings e)
    {
        whereCode().isNot(e.getCode());
    }

    //##################################################
    //# properties
    //##################################################

    public KmhIntegerCondition whereCode()
    {
        return new KmhIntegerCondition(context(), alias(), CODE);
    }

    public KmhStringCondition whereSomeMessage()
    {
        return new KmhStringCondition(context(), alias(), SOME_MESSAGE);
    }

    public KmhIntegerCondition whereLockVersion()
    {
        return new KmhIntegerCondition(context(), alias(), LOCK_VERSION);
    }

    //##################################################
    //# sorts
    //##################################################

    public void sortOnCode()
    {
        parent().sortAscending(CODE);
    }

    public void sortOnCodeDescending()
    {
        parent().sortDescending(CODE);
    }

    public void sortOnCode(boolean asc)
    {
        if ( asc )
            sortOnCode();
        else
            sortOnCodeDescending();
    }

    public void sortOnSomeMessage()
    {
        parent().sortAscending(SOME_MESSAGE);
    }

    public void sortOnSomeMessageDescending()
    {
        parent().sortDescending(SOME_MESSAGE);
    }

    public void sortOnSomeMessage(boolean asc)
    {
        if ( asc )
            sortOnSomeMessage();
        else
            sortOnSomeMessageDescending();
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
    //# projections (code)
    //##################################################

    public void selectCode()
    {
        select(CODE);
    }

    public void selectDistinctCode()
    {
        selectDistinct(CODE);
    }

    public void selectCountDistinctCode()
    {
        selectCountDistinct(CODE);
    }

    public void selectMinimumCode()
    {
        selectMinimum(CODE);
    }

    public void selectMaximumCode()
    {
        selectMaximum(CODE);
    }

    public void selectAverageCode()
    {
        selectAverage(CODE);
    }

    public void selectSumCode()
    {
        selectSum(CODE);
    }

    public void groupByCode()
    {
        groupBy(CODE);
    }

    //##################################################
    //# projections (someMessage)
    //##################################################

    public void selectSomeMessage()
    {
        select(SOME_MESSAGE);
    }

    public void selectDistinctSomeMessage()
    {
        selectDistinct(SOME_MESSAGE);
    }

    public void selectCountDistinctSomeMessage()
    {
        selectCountDistinct(SOME_MESSAGE);
    }

    public void selectMinimumSomeMessage()
    {
        selectMinimum(SOME_MESSAGE);
    }

    public void selectMaximumSomeMessage()
    {
        selectMaximum(SOME_MESSAGE);
    }

    public void selectAverageSomeMessage()
    {
        selectAverage(SOME_MESSAGE);
    }

    public void selectSumSomeMessage()
    {
        selectSum(SOME_MESSAGE);
    }

    public void groupBySomeMessage()
    {
        groupBy(SOME_MESSAGE);
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
    //# junction :: alias
    //##################################################

    public MySettingsJunction all()
    {
        return addAnd();
    }

    public MySettingsJunction any()
    {
        return addOr();
    }

    public MySettingsJunction none()
    {
        return addNotOr();
    }

    //##################################################
    //# junction :: basic
    //##################################################

    public MySettingsJunction addNotAnd()
    {
        return new MySettingsJunction(parent().addNotAnd());
    }

    public MySettingsJunction addNotOr()
    {
        return new MySettingsJunction(parent().addNotOr());
    }

    public MySettingsJunction addAnd()
    {
        return new MySettingsJunction(parent().addAnd());
    }

    public MySettingsJunction addOr()
    {
        return new MySettingsJunction(parent().addOr());
    }
}
