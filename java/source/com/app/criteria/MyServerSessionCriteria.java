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

public class MyServerSessionCriteria
    extends MyAbstractCriteria<MyServerSession>
    implements MyServerSessionDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyServerSessionCriteria(KmhCriteria parent)
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

    public KmhBooleanCondition whereActive()
    {
        return new KmhBooleanCondition(context(), fullName(ACTIVE));
    }

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), fullName(CREATED_UTC_TS));
    }

    public KmhTimestampCondition whereClosedUtcTs()
    {
        return new KmhTimestampCondition(context(), fullName(CLOSED_UTC_TS));
    }

    public KmhTimestampCondition whereLastTouchedUtcTs()
    {
        return new KmhTimestampCondition(context(), fullName(LAST_TOUCHED_UTC_TS));
    }

    public KmhStringCondition whereVersion()
    {
        return new KmhStringCondition(context(), fullName(VERSION));
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

    public void sortOnActive()
    {
        parent().sortAscending(ACTIVE);
    }

    public void sortOnActiveDescending()
    {
        parent().sortDescending(ACTIVE);
    }

    public void sortOnActive(boolean asc)
    {
        if ( asc )
            sortOnActive();
        else
            sortOnActiveDescending();
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

    public void sortOnClosedUtcTs()
    {
        parent().sortAscending(CLOSED_UTC_TS);
    }

    public void sortOnClosedUtcTsDescending()
    {
        parent().sortDescending(CLOSED_UTC_TS);
    }

    public void sortOnClosedUtcTs(boolean asc)
    {
        if ( asc )
            sortOnClosedUtcTs();
        else
            sortOnClosedUtcTsDescending();
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

    public void sortOnVersion()
    {
        parent().sortAscending(VERSION);
    }

    public void sortOnVersionDescending()
    {
        parent().sortDescending(VERSION);
    }

    public void sortOnVersion(boolean asc)
    {
        if ( asc )
            sortOnVersion();
        else
            sortOnVersionDescending();
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
    //# projections (active)
    //##################################################

    public void selectActive()
    {
        select(ACTIVE);
    }

    public void selectDistinctActive()
    {
        selectDistinct(ACTIVE);
    }

    public void selectCountDistinctActive()
    {
        selectCountDistinct(ACTIVE);
    }

    public void selectMinimumActive()
    {
        selectMinimum(ACTIVE);
    }

    public void selectMaximumActive()
    {
        selectMaximum(ACTIVE);
    }

    public void selectAverageActive()
    {
        selectAverage(ACTIVE);
    }

    public void selectSumActive()
    {
        selectSum(ACTIVE);
    }

    public void groupByActive()
    {
        groupBy(ACTIVE);
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
    //# projections (closedUtcTs)
    //##################################################

    public void selectClosedUtcTs()
    {
        select(CLOSED_UTC_TS);
    }

    public void selectDistinctClosedUtcTs()
    {
        selectDistinct(CLOSED_UTC_TS);
    }

    public void selectCountDistinctClosedUtcTs()
    {
        selectCountDistinct(CLOSED_UTC_TS);
    }

    public void selectMinimumClosedUtcTs()
    {
        selectMinimum(CLOSED_UTC_TS);
    }

    public void selectMaximumClosedUtcTs()
    {
        selectMaximum(CLOSED_UTC_TS);
    }

    public void selectAverageClosedUtcTs()
    {
        selectAverage(CLOSED_UTC_TS);
    }

    public void selectSumClosedUtcTs()
    {
        selectSum(CLOSED_UTC_TS);
    }

    public void groupByClosedUtcTs()
    {
        groupBy(CLOSED_UTC_TS);
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
    //# projections (version)
    //##################################################

    public void selectVersion()
    {
        select(VERSION);
    }

    public void selectDistinctVersion()
    {
        selectDistinct(VERSION);
    }

    public void selectCountDistinctVersion()
    {
        selectCountDistinct(VERSION);
    }

    public void selectMinimumVersion()
    {
        selectMinimum(VERSION);
    }

    public void selectMaximumVersion()
    {
        selectMaximum(VERSION);
    }

    public void selectAverageVersion()
    {
        selectAverage(VERSION);
    }

    public void selectSumVersion()
    {
        selectSum(VERSION);
    }

    public void groupByVersion()
    {
        groupBy(VERSION);
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

    public KmhStringCondition whereUserUid()
    {
        return new KmhStringCondition(parent(), fullName(USER_UID));
    }

    public void whereUserIs(MyUser e)
    {
        if ( e == null )
            whereUserUid().isNull();
        else
            whereUserUid().is(e.getUid());
    }

    //##################################################
    //# association (AutoSignIn)
    //##################################################

    public void selectAutoSignInUid()
    {
        select(AUTO_SIGN_IN_UID);
    }

    public void selectMinimumAutoSignInUid()
    {
        selectMinimum(AUTO_SIGN_IN_UID);
    }

    public void selectMaximumAutoSignInUid()
    {
        selectMaximum(AUTO_SIGN_IN_UID);
    }

    public void groupByAutoSignInUid()
    {
        groupBy(AUTO_SIGN_IN);
    }

    public MyAutoSignInCriteria joinToAutoSignIn()
    {
        return new MyAutoSignInCriteria(joinTo(AUTO_SIGN_IN));
    }

    public MyAutoSignInCriteria leftJoinToAutoSignIn()
    {
        return new MyAutoSignInCriteria(leftJoinTo(AUTO_SIGN_IN));
    }

    public KmhStringCondition whereAutoSignInUid()
    {
        return new KmhStringCondition(parent(), fullName(AUTO_SIGN_IN_UID));
    }

    public void whereAutoSignInIs(MyAutoSignIn e)
    {
        if ( e == null )
            whereAutoSignInUid().isNull();
        else
            whereAutoSignInUid().is(e.getUid());
    }

    //##################################################
    //# association (CurrentProject)
    //##################################################

    public void selectCurrentProjectUid()
    {
        select(CURRENT_PROJECT_UID);
    }

    public void selectMinimumCurrentProjectUid()
    {
        selectMinimum(CURRENT_PROJECT_UID);
    }

    public void selectMaximumCurrentProjectUid()
    {
        selectMaximum(CURRENT_PROJECT_UID);
    }

    public void groupByCurrentProjectUid()
    {
        groupBy(CURRENT_PROJECT);
    }

    public MyProjectCriteria joinToCurrentProject()
    {
        return new MyProjectCriteria(joinTo(CURRENT_PROJECT));
    }

    public MyProjectCriteria leftJoinToCurrentProject()
    {
        return new MyProjectCriteria(leftJoinTo(CURRENT_PROJECT));
    }

    public KmhStringCondition whereCurrentProjectUid()
    {
        return new KmhStringCondition(parent(), fullName(CURRENT_PROJECT_UID));
    }

    public void whereCurrentProjectIs(MyProject e)
    {
        if ( e == null )
            whereCurrentProjectUid().isNull();
        else
            whereCurrentProjectUid().is(e.getUid());
    }

    //##################################################
    //# junction
    //##################################################

    public MyServerSessionJunction addAnd()
    {
        return new MyServerSessionJunction(parent().addAnd());
    }

    public MyServerSessionJunction addOr()
    {
        return new MyServerSessionJunction(parent().addOr());
    }
}
