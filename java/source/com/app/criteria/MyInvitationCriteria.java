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

public class MyInvitationCriteria
    extends MyAbstractCriteria<MyInvitation>
    implements MyInvitationDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyInvitationCriteria(KmhCriteria parent)
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

    public KmhStringCondition whereTypeCode()
    {
        return new KmhStringCondition(context(), fullName(TYPE_CODE));
    }

    public void whereTypeIs(MyInvitationType e)
    {
        if ( e == null )
            whereTypeCode().isNull();
        else
            whereTypeCode().is(e.getCode());
    }

    public void whereTypeIsNot(MyInvitationType e)
    {
        if ( e == null )
            whereTypeCode().isNull();
        else
            whereTypeCode().isNot(e.getCode());
    }

    public void whereTypeIsJoinAccount()
    {
        whereTypeIs(MyInvitationType.JoinAccount);
    }

    public void whereTypeIsNotJoinAccount()
    {
        whereTypeIsNot(MyInvitationType.JoinAccount);
    }

    public void whereTypeIsJoinAccount(boolean e)
    {
        if ( e )
            whereTypeIsJoinAccount();
        else
            whereTypeIsNotJoinAccount();
    }

    public KmhStringCondition whereStatusCode()
    {
        return new KmhStringCondition(context(), fullName(STATUS_CODE));
    }

    public void whereStatusIs(MyInvitationStatus e)
    {
        if ( e == null )
            whereStatusCode().isNull();
        else
            whereStatusCode().is(e.getCode());
    }

    public void whereStatusIsNot(MyInvitationStatus e)
    {
        if ( e == null )
            whereStatusCode().isNull();
        else
            whereStatusCode().isNot(e.getCode());
    }

    public void whereStatusIsPending()
    {
        whereStatusIs(MyInvitationStatus.Pending);
    }

    public void whereStatusIsNotPending()
    {
        whereStatusIsNot(MyInvitationStatus.Pending);
    }

    public void whereStatusIsPending(boolean e)
    {
        if ( e )
            whereStatusIsPending();
        else
            whereStatusIsNotPending();
    }

    public void whereStatusIsAccepted()
    {
        whereStatusIs(MyInvitationStatus.Accepted);
    }

    public void whereStatusIsNotAccepted()
    {
        whereStatusIsNot(MyInvitationStatus.Accepted);
    }

    public void whereStatusIsAccepted(boolean e)
    {
        if ( e )
            whereStatusIsAccepted();
        else
            whereStatusIsNotAccepted();
    }

    public void whereStatusIsRejected()
    {
        whereStatusIs(MyInvitationStatus.Rejected);
    }

    public void whereStatusIsNotRejected()
    {
        whereStatusIsNot(MyInvitationStatus.Rejected);
    }

    public void whereStatusIsRejected(boolean e)
    {
        if ( e )
            whereStatusIsRejected();
        else
            whereStatusIsNotRejected();
    }

    public void whereStatusIsExpired()
    {
        whereStatusIs(MyInvitationStatus.Expired);
    }

    public void whereStatusIsNotExpired()
    {
        whereStatusIsNot(MyInvitationStatus.Expired);
    }

    public void whereStatusIsExpired(boolean e)
    {
        if ( e )
            whereStatusIsExpired();
        else
            whereStatusIsNotExpired();
    }

    public void whereStatusIsCancelled()
    {
        whereStatusIs(MyInvitationStatus.Cancelled);
    }

    public void whereStatusIsNotCancelled()
    {
        whereStatusIsNot(MyInvitationStatus.Cancelled);
    }

    public void whereStatusIsCancelled(boolean e)
    {
        if ( e )
            whereStatusIsCancelled();
        else
            whereStatusIsNotCancelled();
    }

    public KmhPropertyCondition<KmTimestamp> whereCreatedUtcTs()
    {
        return new KmhPropertyCondition<>(context(), fullName(CREATED_UTC_TS));
    }

    public KmhPropertyCondition<KmTimestamp> whereClosedUtcTs()
    {
        return new KmhPropertyCondition<>(context(), fullName(CLOSED_UTC_TS));
    }

    public KmhStringCondition whereToEmail()
    {
        return new KmhStringCondition(context(), fullName(TO_EMAIL));
    }

    public KmhStringCondition whereRoleCode()
    {
        return new KmhStringCondition(context(), fullName(ROLE_CODE));
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

    public void sortOnTypeCode()
    {
        parent().sortAscending(TYPE_CODE);
    }

    public void sortOnTypeCodeDescending()
    {
        parent().sortDescending(TYPE_CODE);
    }

    public void sortOnTypeCode(boolean asc)
    {
        if ( asc )
            sortOnTypeCode();
        else
            sortOnTypeCodeDescending();
    }

    public void sortOnStatusCode()
    {
        parent().sortAscending(STATUS_CODE);
    }

    public void sortOnStatusCodeDescending()
    {
        parent().sortDescending(STATUS_CODE);
    }

    public void sortOnStatusCode(boolean asc)
    {
        if ( asc )
            sortOnStatusCode();
        else
            sortOnStatusCodeDescending();
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

    public void sortOnToEmail()
    {
        parent().sortAscending(TO_EMAIL);
    }

    public void sortOnToEmailDescending()
    {
        parent().sortDescending(TO_EMAIL);
    }

    public void sortOnToEmail(boolean asc)
    {
        if ( asc )
            sortOnToEmail();
        else
            sortOnToEmailDescending();
    }

    public void sortOnRoleCode()
    {
        parent().sortAscending(ROLE_CODE);
    }

    public void sortOnRoleCodeDescending()
    {
        parent().sortDescending(ROLE_CODE);
    }

    public void sortOnRoleCode(boolean asc)
    {
        if ( asc )
            sortOnRoleCode();
        else
            sortOnRoleCodeDescending();
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
    //# projections (typeCode)
    //##################################################

    public void selectTypeCode()
    {
        select(TYPE_CODE);
    }

    public void selectDistinctTypeCode()
    {
        selectDistinct(TYPE_CODE);
    }

    public void selectCountDistinctTypeCode()
    {
        selectCountDistinct(TYPE_CODE);
    }

    public void selectMinimumTypeCode()
    {
        selectMinimum(TYPE_CODE);
    }

    public void selectMaximumTypeCode()
    {
        selectMaximum(TYPE_CODE);
    }

    public void selectAverageTypeCode()
    {
        selectAverage(TYPE_CODE);
    }

    public void selectSumTypeCode()
    {
        selectSum(TYPE_CODE);
    }

    public void groupByTypeCode()
    {
        groupBy(TYPE_CODE);
    }

    //##################################################
    //# projections (statusCode)
    //##################################################

    public void selectStatusCode()
    {
        select(STATUS_CODE);
    }

    public void selectDistinctStatusCode()
    {
        selectDistinct(STATUS_CODE);
    }

    public void selectCountDistinctStatusCode()
    {
        selectCountDistinct(STATUS_CODE);
    }

    public void selectMinimumStatusCode()
    {
        selectMinimum(STATUS_CODE);
    }

    public void selectMaximumStatusCode()
    {
        selectMaximum(STATUS_CODE);
    }

    public void selectAverageStatusCode()
    {
        selectAverage(STATUS_CODE);
    }

    public void selectSumStatusCode()
    {
        selectSum(STATUS_CODE);
    }

    public void groupByStatusCode()
    {
        groupBy(STATUS_CODE);
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
    //# projections (toEmail)
    //##################################################

    public void selectToEmail()
    {
        select(TO_EMAIL);
    }

    public void selectDistinctToEmail()
    {
        selectDistinct(TO_EMAIL);
    }

    public void selectCountDistinctToEmail()
    {
        selectCountDistinct(TO_EMAIL);
    }

    public void selectMinimumToEmail()
    {
        selectMinimum(TO_EMAIL);
    }

    public void selectMaximumToEmail()
    {
        selectMaximum(TO_EMAIL);
    }

    public void selectAverageToEmail()
    {
        selectAverage(TO_EMAIL);
    }

    public void selectSumToEmail()
    {
        selectSum(TO_EMAIL);
    }

    public void groupByToEmail()
    {
        groupBy(TO_EMAIL);
    }

    //##################################################
    //# projections (roleCode)
    //##################################################

    public void selectRoleCode()
    {
        select(ROLE_CODE);
    }

    public void selectDistinctRoleCode()
    {
        selectDistinct(ROLE_CODE);
    }

    public void selectCountDistinctRoleCode()
    {
        selectCountDistinct(ROLE_CODE);
    }

    public void selectMinimumRoleCode()
    {
        selectMinimum(ROLE_CODE);
    }

    public void selectMaximumRoleCode()
    {
        selectMaximum(ROLE_CODE);
    }

    public void selectAverageRoleCode()
    {
        selectAverage(ROLE_CODE);
    }

    public void selectSumRoleCode()
    {
        selectSum(ROLE_CODE);
    }

    public void groupByRoleCode()
    {
        groupBy(ROLE_CODE);
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
    //# association (FromUser)
    //##################################################

    public void selectFromUserUid()
    {
        select(FROM_USER_UID);
    }

    public void selectMinimumFromUserUid()
    {
        selectMinimum(FROM_USER_UID);
    }

    public void selectMaximumFromUserUid()
    {
        selectMaximum(FROM_USER_UID);
    }

    public void groupByFromUserUid()
    {
        groupBy(FROM_USER);
    }

    public MyUserCriteria joinToFromUser()
    {
        return new MyUserCriteria(joinTo(FROM_USER));
    }

    public MyUserCriteria leftJoinToFromUser()
    {
        return new MyUserCriteria(leftJoinTo(FROM_USER));
    }

    public KmhStringCondition whereFromUserUid()
    {
        return new KmhStringCondition(parent(), fullName(FROM_USER_UID));
    }

    public void whereFromUserIs(MyUser e)
    {
        if ( e == null )
            whereFromUserUid().isNull();
        else
            whereFromUserUid().is(e.getUid());
    }

    //##################################################
    //# association (Project)
    //##################################################

    public void selectProjectUid()
    {
        select(PROJECT_UID);
    }

    public void selectMinimumProjectUid()
    {
        selectMinimum(PROJECT_UID);
    }

    public void selectMaximumProjectUid()
    {
        selectMaximum(PROJECT_UID);
    }

    public void groupByProjectUid()
    {
        groupBy(PROJECT);
    }

    public MyProjectCriteria joinToProject()
    {
        return new MyProjectCriteria(joinTo(PROJECT));
    }

    public MyProjectCriteria leftJoinToProject()
    {
        return new MyProjectCriteria(leftJoinTo(PROJECT));
    }

    public KmhStringCondition whereProjectUid()
    {
        return new KmhStringCondition(parent(), fullName(PROJECT_UID));
    }

    public void whereProjectIs(MyProject e)
    {
        if ( e == null )
            whereProjectUid().isNull();
        else
            whereProjectUid().is(e.getUid());
    }

    //##################################################
    //# junction
    //##################################################

    public MyInvitationJunction addAnd()
    {
        return new MyInvitationJunction(parent().addAnd());
    }

    public MyInvitationJunction addOr()
    {
        return new MyInvitationJunction(parent().addOr());
    }
}
