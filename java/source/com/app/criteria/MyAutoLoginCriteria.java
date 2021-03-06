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

public class MyAutoLoginCriteria
    extends MyAbstractCriteria<MyAutoLogin>
    implements MyAutoLoginDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyAutoLoginCriteria(KmhCriteria parent)
    {
        super(parent);
    }

    //##################################################
    //# primary key
    //##################################################

    public void whereUidIs(MyAutoLogin e)
    {
        whereUid().is(e.getUid());
    }

    public void whereUidIsNot(MyAutoLogin e)
    {
        whereUid().isNot(e.getUid());
    }

    //##################################################
    //# properties
    //##################################################

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), CREATED_UTC_TS);
    }

    public KmhTimestampCondition whereLastTouchedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), LAST_TOUCHED_UTC_TS);
    }

    public KmhStringCondition whereUid()
    {
        return new KmhStringCondition(context(), alias(), UID);
    }

    public KmhIntegerCondition whereLockVersion()
    {
        return new KmhIntegerCondition(context(), alias(), LOCK_VERSION);
    }

    //##################################################
    //# sorts
    //##################################################

    public void sortOnCreatedUtcTs()
    {
        parent().sortAscending(CREATED_UTC_TS);
    }

    public void sortOnCreatedUtcTsDescending()
    {
        parent().sortDescending(CREATED_UTC_TS);
    }

    public void sortOnCreatedUtcTs(boolean asc)
    {
        if ( asc )
            sortOnCreatedUtcTs();
        else
            sortOnCreatedUtcTsDescending();
    }

    public void sortOnLastTouchedUtcTs()
    {
        parent().sortAscending(LAST_TOUCHED_UTC_TS);
    }

    public void sortOnLastTouchedUtcTsDescending()
    {
        parent().sortDescending(LAST_TOUCHED_UTC_TS);
    }

    public void sortOnLastTouchedUtcTs(boolean asc)
    {
        if ( asc )
            sortOnLastTouchedUtcTs();
        else
            sortOnLastTouchedUtcTsDescending();
    }

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
    //# projections (createdUtcTs)
    //##################################################

    public void selectCreatedUtcTs()
    {
        select(CREATED_UTC_TS);
    }

    public void selectDistinctCreatedUtcTs()
    {
        selectDistinct(CREATED_UTC_TS);
    }

    public void selectCountDistinctCreatedUtcTs()
    {
        selectCountDistinct(CREATED_UTC_TS);
    }

    public void selectMinimumCreatedUtcTs()
    {
        selectMinimum(CREATED_UTC_TS);
    }

    public void selectMaximumCreatedUtcTs()
    {
        selectMaximum(CREATED_UTC_TS);
    }

    public void selectAverageCreatedUtcTs()
    {
        selectAverage(CREATED_UTC_TS);
    }

    public void selectSumCreatedUtcTs()
    {
        selectSum(CREATED_UTC_TS);
    }

    public void groupByCreatedUtcTs()
    {
        groupBy(CREATED_UTC_TS);
    }

    //##################################################
    //# projections (lastTouchedUtcTs)
    //##################################################

    public void selectLastTouchedUtcTs()
    {
        select(LAST_TOUCHED_UTC_TS);
    }

    public void selectDistinctLastTouchedUtcTs()
    {
        selectDistinct(LAST_TOUCHED_UTC_TS);
    }

    public void selectCountDistinctLastTouchedUtcTs()
    {
        selectCountDistinct(LAST_TOUCHED_UTC_TS);
    }

    public void selectMinimumLastTouchedUtcTs()
    {
        selectMinimum(LAST_TOUCHED_UTC_TS);
    }

    public void selectMaximumLastTouchedUtcTs()
    {
        selectMaximum(LAST_TOUCHED_UTC_TS);
    }

    public void selectAverageLastTouchedUtcTs()
    {
        selectAverage(LAST_TOUCHED_UTC_TS);
    }

    public void selectSumLastTouchedUtcTs()
    {
        selectSum(LAST_TOUCHED_UTC_TS);
    }

    public void groupByLastTouchedUtcTs()
    {
        groupBy(LAST_TOUCHED_UTC_TS);
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
    //# association (User)
    //##################################################

    public void selectUserUid()
    {
        select(USER_UID);
    }

    public void selectCountDistinctUserUid()
    {
        selectCountDistinct(USER_UID);
    }
    
    public void selectDistinctUserUid()
    {
        selectDistinct(USER_UID);
    }

    public void selectMinimumUserUid()
    {
        selectMinimum(USER_UID);
    }

    public void selectMaximumUserUid()
    {
        selectMaximum(USER_UID);
    }

    public void groupByUserUid()
    {
        groupBy(USER_UID);
    }

    public MyUserCriteria joinToUser()
    {
        return new MyUserCriteria(joinTo(USER));
    }

    public MyUserCriteria leftJoinToUser()
    {
        return new MyUserCriteria(leftJoinTo(USER));
    }

    public KmhStringCondition whereUserUid()
    {
        return new KmhStringCondition(parent(), alias(), USER_UID);
    }

    public void whereUserIs(MyUser e)
    {
        if ( e == null )
            whereUserUid().isNull();
        else
            whereUserUid().is(e.getUid());
    }

    public void whereUserIsNot(MyUser e)
    {
        if ( e == null )
            whereUserUid().isNotNull();
        else
            whereUserUid().isNot(e.getUid());
    }

    //##################################################
    //# junction :: alias
    //##################################################

    public MyAutoLoginJunction all()
    {
        return addAnd();
    }

    public MyAutoLoginJunction any()
    {
        return addOr();
    }

    public MyAutoLoginJunction none()
    {
        return addNotOr();
    }

    //##################################################
    //# junction :: basic
    //##################################################

    public MyAutoLoginJunction addNotAnd()
    {
        return new MyAutoLoginJunction(parent().addNotAnd());
    }

    public MyAutoLoginJunction addNotOr()
    {
        return new MyAutoLoginJunction(parent().addNotOr());
    }

    public MyAutoLoginJunction addAnd()
    {
        return new MyAutoLoginJunction(parent().addAnd());
    }

    public MyAutoLoginJunction addOr()
    {
        return new MyAutoLoginJunction(parent().addOr());
    }
}
