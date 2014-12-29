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
import com.kodemore.hibernate.criteria.*;
import com.kodemore.time.*;
import com.kodemore.types.*;

import com.app.criteria.core.*;
import com.app.dao.*;
import com.app.dao.base.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.meta.*;

public class MyAutoSignInCriteria
    extends MyAbstractCriteria<MyAutoSignIn>
    implements MyAutoSignInDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyAutoSignInCriteria(KmCriteria parent)
    {
        super(parent);
    }

    public MyAutoSignInCriteria(KmCriteria parent, KmAbstractCriteria context)
    {
        super(parent, context);
    }

    //##################################################
    //# properties
    //##################################################

    public KmStringCriteria whereUid()
    {
        return new KmStringCriteria(context(), fullName(UID));
    }

    public KmPropertyCriteria<KmTimestamp> whereCreatedUtcTs()
    {
        return new KmPropertyCriteria<>(context(), fullName(CREATED_UTC_TS));
    }

    public KmPropertyCriteria<KmTimestamp> whereLastTouchedUtcTs()
    {
        return new KmPropertyCriteria<>(context(), fullName(LAST_TOUCHED_UTC_TS));
    }

    public KmIntegerCriteria whereLockVersion()
    {
        return new KmIntegerCriteria(context(), fullName(LOCK_VERSION));
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
        groupBy(USER);
    }

    public MyUserCriteria joinToUser()
    {
        return new MyUserCriteria(joinTo(USER));
    }

    public MyUserCriteria leftJoinToUser()
    {
        return new MyUserCriteria(leftJoinTo(USER));
    }

    public KmStringCriteria whereUserUid()
    {
        return new KmStringCriteria(parent(), fullName(USER_UID));
    }

    public void whereUserIs(MyUser e)
    {
        if ( e == null )
            whereUserUid().isNull();
        else
            whereUserUid().is(e.getUid());
    }

    //##################################################
    //# junction
    //##################################################

    public MyAutoSignInJunction addAnd()
    {
        return new MyAutoSignInJunction(parent().addAnd());
    }

    public MyAutoSignInJunction addOr()
    {
        return new MyAutoSignInJunction(parent().addOr());
    }

    //##################################################
    //# support
    //##################################################

    @Override
    public MyAutoSignInCriteria createOn(KmModelJunction junction)
    {
        return new MyAutoSignInCriteria(parent(), junction.context());
    }

}
