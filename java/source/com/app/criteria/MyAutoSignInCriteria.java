//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.criteria;

import com.app.criteria.core.MyAbstractCriteria;
import com.app.dao.base.MyAutoSignInDaoConstantsIF;
import com.app.model.MyAutoSignIn;
import com.app.model.MyUser;

import com.kodemore.hibernate.criteria.KmAbstractCriteria;
import com.kodemore.hibernate.criteria.KmCriteria;
import com.kodemore.hibernate.criteria.KmIntegerCriteria;
import com.kodemore.hibernate.criteria.KmModelJunction;
import com.kodemore.hibernate.criteria.KmPropertyCriteria;
import com.kodemore.hibernate.criteria.KmStringCriteria;
import com.kodemore.time.KmTimestamp;

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
        return new KmPropertyCriteria<KmTimestamp>(context(), fullName(CREATED_UTC_TS));
    }

    public KmPropertyCriteria<KmTimestamp> whereLastUtcTs()
    {
        return new KmPropertyCriteria<KmTimestamp>(context(), fullName(LAST_UTC_TS));
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

    public void sortOnLastUtcTs()
    {
        parent().sortAscending(LAST_UTC_TS);
    }

    public void sortOnLastUtcTsDescending()
    {
        parent().sortDescending(LAST_UTC_TS);
    }

    public void sortOnLastUtcTs(boolean asc)
    {
        if ( asc )
            sortOnLastUtcTs();
        else
            sortOnLastUtcTsDescending();
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
    //# projections (lastUtcTs)
    //##################################################

    public void selectLastUtcTs()
    {
        select(LAST_UTC_TS);
    }

    public void selectDistinctLastUtcTs()
    {
        selectDistinct(LAST_UTC_TS);
    }

    public void selectCountDistinctLastUtcTs()
    {
        selectCountDistinct(LAST_UTC_TS);
    }

    public void selectMinimumLastUtcTs()
    {
        selectMinimum(LAST_UTC_TS);
    }

    public void selectMaximumLastUtcTs()
    {
        selectMaximum(LAST_UTC_TS);
    }

    public void selectAverageLastUtcTs()
    {
        selectAverage(LAST_UTC_TS);
    }

    public void selectSumLastUtcTs()
    {
        selectSum(LAST_UTC_TS);
    }

    public void groupByLastUtcTs()
    {
        groupBy(LAST_UTC_TS);
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
    @SuppressWarnings("rawtypes")
    public MyAutoSignInCriteria createOn(KmModelJunction junction)
    {
        return new MyAutoSignInCriteria(parent(), junction.context());
    }

}
