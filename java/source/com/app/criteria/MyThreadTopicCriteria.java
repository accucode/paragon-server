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

public class MyThreadTopicCriteria
    extends MyAbstractCriteria<MyThreadTopic>
    implements MyThreadTopicDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyThreadTopicCriteria(KmhCriteria parent)
    {
        super(parent);
    }

    //##################################################
    //# primary key
    //##################################################

    public void whereCodeIs(MyThreadTopic e)
    {
        whereCode().is(e.getCode());
    }

    public void whereCodeIsNot(MyThreadTopic e)
    {
        whereCode().isNot(e.getCode());
    }

    //##################################################
    //# properties
    //##################################################

    public KmhStringCondition whereCode()
    {
        return new KmhStringCondition(context(), alias(), CODE);
    }

    public KmhStringCondition whereHostAddress()
    {
        return new KmhStringCondition(context(), alias(), HOST_ADDRESS);
    }

    public KmhStringCondition whereHostName()
    {
        return new KmhStringCondition(context(), alias(), HOST_NAME);
    }

    public KmhTimestampCondition whereLastEndUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), LAST_END_UTC_TS);
    }

    public KmhTimestampCondition whereLastStartUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), LAST_START_UTC_TS);
    }

    public KmhTimestampCondition whereLastTouchUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), LAST_TOUCH_UTC_TS);
    }

    public KmhStringCondition whereOwnerUid()
    {
        return new KmhStringCondition(context(), alias(), OWNER_UID);
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

    public void sortOnHostAddress()
    {
        parent().sortAscending(HOST_ADDRESS);
    }

    public void sortOnHostAddressDescending()
    {
        parent().sortDescending(HOST_ADDRESS);
    }

    public void sortOnHostAddress(boolean asc)
    {
        if ( asc )
            sortOnHostAddress();
        else
            sortOnHostAddressDescending();
    }

    public void sortOnHostName()
    {
        parent().sortAscending(HOST_NAME);
    }

    public void sortOnHostNameDescending()
    {
        parent().sortDescending(HOST_NAME);
    }

    public void sortOnHostName(boolean asc)
    {
        if ( asc )
            sortOnHostName();
        else
            sortOnHostNameDescending();
    }

    public void sortOnLastEndUtcTs()
    {
        parent().sortAscending(LAST_END_UTC_TS);
    }

    public void sortOnLastEndUtcTsDescending()
    {
        parent().sortDescending(LAST_END_UTC_TS);
    }

    public void sortOnLastEndUtcTs(boolean asc)
    {
        if ( asc )
            sortOnLastEndUtcTs();
        else
            sortOnLastEndUtcTsDescending();
    }

    public void sortOnLastStartUtcTs()
    {
        parent().sortAscending(LAST_START_UTC_TS);
    }

    public void sortOnLastStartUtcTsDescending()
    {
        parent().sortDescending(LAST_START_UTC_TS);
    }

    public void sortOnLastStartUtcTs(boolean asc)
    {
        if ( asc )
            sortOnLastStartUtcTs();
        else
            sortOnLastStartUtcTsDescending();
    }

    public void sortOnLastTouchUtcTs()
    {
        parent().sortAscending(LAST_TOUCH_UTC_TS);
    }

    public void sortOnLastTouchUtcTsDescending()
    {
        parent().sortDescending(LAST_TOUCH_UTC_TS);
    }

    public void sortOnLastTouchUtcTs(boolean asc)
    {
        if ( asc )
            sortOnLastTouchUtcTs();
        else
            sortOnLastTouchUtcTsDescending();
    }

    public void sortOnOwnerUid()
    {
        parent().sortAscending(OWNER_UID);
    }

    public void sortOnOwnerUidDescending()
    {
        parent().sortDescending(OWNER_UID);
    }

    public void sortOnOwnerUid(boolean asc)
    {
        if ( asc )
            sortOnOwnerUid();
        else
            sortOnOwnerUidDescending();
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
    //# projections (hostAddress)
    //##################################################

    public void selectHostAddress()
    {
        select(HOST_ADDRESS);
    }

    public void selectDistinctHostAddress()
    {
        selectDistinct(HOST_ADDRESS);
    }

    public void selectCountDistinctHostAddress()
    {
        selectCountDistinct(HOST_ADDRESS);
    }

    public void selectMinimumHostAddress()
    {
        selectMinimum(HOST_ADDRESS);
    }

    public void selectMaximumHostAddress()
    {
        selectMaximum(HOST_ADDRESS);
    }

    public void selectAverageHostAddress()
    {
        selectAverage(HOST_ADDRESS);
    }

    public void selectSumHostAddress()
    {
        selectSum(HOST_ADDRESS);
    }

    public void groupByHostAddress()
    {
        groupBy(HOST_ADDRESS);
    }

    //##################################################
    //# projections (hostName)
    //##################################################

    public void selectHostName()
    {
        select(HOST_NAME);
    }

    public void selectDistinctHostName()
    {
        selectDistinct(HOST_NAME);
    }

    public void selectCountDistinctHostName()
    {
        selectCountDistinct(HOST_NAME);
    }

    public void selectMinimumHostName()
    {
        selectMinimum(HOST_NAME);
    }

    public void selectMaximumHostName()
    {
        selectMaximum(HOST_NAME);
    }

    public void selectAverageHostName()
    {
        selectAverage(HOST_NAME);
    }

    public void selectSumHostName()
    {
        selectSum(HOST_NAME);
    }

    public void groupByHostName()
    {
        groupBy(HOST_NAME);
    }

    //##################################################
    //# projections (lastEndUtcTs)
    //##################################################

    public void selectLastEndUtcTs()
    {
        select(LAST_END_UTC_TS);
    }

    public void selectDistinctLastEndUtcTs()
    {
        selectDistinct(LAST_END_UTC_TS);
    }

    public void selectCountDistinctLastEndUtcTs()
    {
        selectCountDistinct(LAST_END_UTC_TS);
    }

    public void selectMinimumLastEndUtcTs()
    {
        selectMinimum(LAST_END_UTC_TS);
    }

    public void selectMaximumLastEndUtcTs()
    {
        selectMaximum(LAST_END_UTC_TS);
    }

    public void selectAverageLastEndUtcTs()
    {
        selectAverage(LAST_END_UTC_TS);
    }

    public void selectSumLastEndUtcTs()
    {
        selectSum(LAST_END_UTC_TS);
    }

    public void groupByLastEndUtcTs()
    {
        groupBy(LAST_END_UTC_TS);
    }

    //##################################################
    //# projections (lastStartUtcTs)
    //##################################################

    public void selectLastStartUtcTs()
    {
        select(LAST_START_UTC_TS);
    }

    public void selectDistinctLastStartUtcTs()
    {
        selectDistinct(LAST_START_UTC_TS);
    }

    public void selectCountDistinctLastStartUtcTs()
    {
        selectCountDistinct(LAST_START_UTC_TS);
    }

    public void selectMinimumLastStartUtcTs()
    {
        selectMinimum(LAST_START_UTC_TS);
    }

    public void selectMaximumLastStartUtcTs()
    {
        selectMaximum(LAST_START_UTC_TS);
    }

    public void selectAverageLastStartUtcTs()
    {
        selectAverage(LAST_START_UTC_TS);
    }

    public void selectSumLastStartUtcTs()
    {
        selectSum(LAST_START_UTC_TS);
    }

    public void groupByLastStartUtcTs()
    {
        groupBy(LAST_START_UTC_TS);
    }

    //##################################################
    //# projections (lastTouchUtcTs)
    //##################################################

    public void selectLastTouchUtcTs()
    {
        select(LAST_TOUCH_UTC_TS);
    }

    public void selectDistinctLastTouchUtcTs()
    {
        selectDistinct(LAST_TOUCH_UTC_TS);
    }

    public void selectCountDistinctLastTouchUtcTs()
    {
        selectCountDistinct(LAST_TOUCH_UTC_TS);
    }

    public void selectMinimumLastTouchUtcTs()
    {
        selectMinimum(LAST_TOUCH_UTC_TS);
    }

    public void selectMaximumLastTouchUtcTs()
    {
        selectMaximum(LAST_TOUCH_UTC_TS);
    }

    public void selectAverageLastTouchUtcTs()
    {
        selectAverage(LAST_TOUCH_UTC_TS);
    }

    public void selectSumLastTouchUtcTs()
    {
        selectSum(LAST_TOUCH_UTC_TS);
    }

    public void groupByLastTouchUtcTs()
    {
        groupBy(LAST_TOUCH_UTC_TS);
    }

    //##################################################
    //# projections (ownerUid)
    //##################################################

    public void selectOwnerUid()
    {
        select(OWNER_UID);
    }

    public void selectDistinctOwnerUid()
    {
        selectDistinct(OWNER_UID);
    }

    public void selectCountDistinctOwnerUid()
    {
        selectCountDistinct(OWNER_UID);
    }

    public void selectMinimumOwnerUid()
    {
        selectMinimum(OWNER_UID);
    }

    public void selectMaximumOwnerUid()
    {
        selectMaximum(OWNER_UID);
    }

    public void selectAverageOwnerUid()
    {
        selectAverage(OWNER_UID);
    }

    public void selectSumOwnerUid()
    {
        selectSum(OWNER_UID);
    }

    public void groupByOwnerUid()
    {
        groupBy(OWNER_UID);
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

    public MyThreadTopicJunction all()
    {
        return addAnd();
    }

    public MyThreadTopicJunction any()
    {
        return addOr();
    }

    public MyThreadTopicJunction none()
    {
        return addNotOr();
    }

    //##################################################
    //# junction :: basic
    //##################################################

    public MyThreadTopicJunction addNotAnd()
    {
        return new MyThreadTopicJunction(parent().addNotAnd());
    }

    public MyThreadTopicJunction addNotOr()
    {
        return new MyThreadTopicJunction(parent().addNotOr());
    }

    public MyThreadTopicJunction addAnd()
    {
        return new MyThreadTopicJunction(parent().addAnd());
    }

    public MyThreadTopicJunction addOr()
    {
        return new MyThreadTopicJunction(parent().addOr());
    }
}
