//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.criteria;

import com.kodemore.hibernate.criteria.KmAbstractCriteria;
import com.kodemore.hibernate.criteria.KmCriteria;
import com.kodemore.hibernate.criteria.KmIntegerCriteria;
import com.kodemore.hibernate.criteria.KmModelJunction;
import com.kodemore.hibernate.criteria.KmPropertyCriteria;
import com.kodemore.hibernate.criteria.KmStringCriteria;
import com.kodemore.time.KmTimestamp;

import com.app.criteria.core.MyAbstractCriteria;
import com.app.dao.base.MyInvitationDaoConstantsIF;
import com.app.model.MyAccount;
import com.app.model.MyInvitation;
import com.app.model.MyInvitationStatus;
import com.app.model.MyInvitationType;
import com.app.model.MyUser;

public class MyInvitationCriteria
    extends MyAbstractCriteria<MyInvitation>
    implements MyInvitationDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyInvitationCriteria(KmCriteria parent)
    {
        super(parent);
    }

    public MyInvitationCriteria(KmCriteria parent, KmAbstractCriteria context)
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

    public KmStringCriteria whereStatusCode()
    {
        return new KmStringCriteria(context(), fullName(STATUS_CODE));
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

    public void whereStatusIsNew()
    {
        whereStatusIs(MyInvitationStatus.New);
    }

    public void whereStatusIsNotNew()
    {
        whereStatusIsNot(MyInvitationStatus.New);
    }

    public void whereStatusIsNew(boolean e)
    {
        if ( e )
            whereStatusIsNew();
        else
            whereStatusIsNotNew();
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

    public KmStringCriteria whereTypeCode()
    {
        return new KmStringCriteria(context(), fullName(TYPE_CODE));
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

    public void whereTypeIsUser()
    {
        whereTypeIs(MyInvitationType.User);
    }

    public void whereTypeIsNotUser()
    {
        whereTypeIsNot(MyInvitationType.User);
    }

    public void whereTypeIsUser(boolean e)
    {
        if ( e )
            whereTypeIsUser();
        else
            whereTypeIsNotUser();
    }

    public void whereTypeIsTransfer()
    {
        whereTypeIs(MyInvitationType.Transfer);
    }

    public void whereTypeIsNotTransfer()
    {
        whereTypeIsNot(MyInvitationType.Transfer);
    }

    public void whereTypeIsTransfer(boolean e)
    {
        if ( e )
            whereTypeIsTransfer();
        else
            whereTypeIsNotTransfer();
    }

    public void whereTypeIsJoin()
    {
        whereTypeIs(MyInvitationType.Join);
    }

    public void whereTypeIsNotJoin()
    {
        whereTypeIsNot(MyInvitationType.Join);
    }

    public void whereTypeIsJoin(boolean e)
    {
        if ( e )
            whereTypeIsJoin();
        else
            whereTypeIsNotJoin();
    }

    public KmStringCriteria whereAccessKey()
    {
        return new KmStringCriteria(context(), fullName(ACCESS_KEY));
    }

    public KmPropertyCriteria<KmTimestamp> whereCreatedUtcTs()
    {
        return new KmPropertyCriteria<KmTimestamp>(context(), fullName(CREATED_UTC_TS));
    }

    public KmPropertyCriteria<KmTimestamp> whereClosedUtcTs()
    {
        return new KmPropertyCriteria<KmTimestamp>(context(), fullName(CLOSED_UTC_TS));
    }

    public KmStringCriteria whereEmail()
    {
        return new KmStringCriteria(context(), fullName(EMAIL));
    }

    public KmStringCriteria whereRoleCode()
    {
        return new KmStringCriteria(context(), fullName(ROLE_CODE));
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

    public void sortOnAccessKey()
    {
        parent().sortAscending(ACCESS_KEY);
    }

    public void sortOnAccessKeyDescending()
    {
        parent().sortDescending(ACCESS_KEY);
    }

    public void sortOnAccessKey(boolean asc)
    {
        if ( asc )
            sortOnAccessKey();
        else
            sortOnAccessKeyDescending();
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

    public void sortOnEmail()
    {
        parent().sortAscending(EMAIL);
    }

    public void sortOnEmailDescending()
    {
        parent().sortDescending(EMAIL);
    }

    public void sortOnEmail(boolean asc)
    {
        if ( asc )
            sortOnEmail();
        else
            sortOnEmailDescending();
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
    //# projections (accessKey)
    //##################################################

    public void selectAccessKey()
    {
        select(ACCESS_KEY);
    }

    public void selectDistinctAccessKey()
    {
        selectDistinct(ACCESS_KEY);
    }

    public void selectCountDistinctAccessKey()
    {
        selectCountDistinct(ACCESS_KEY);
    }

    public void selectMinimumAccessKey()
    {
        selectMinimum(ACCESS_KEY);
    }

    public void selectMaximumAccessKey()
    {
        selectMaximum(ACCESS_KEY);
    }

    public void selectAverageAccessKey()
    {
        selectAverage(ACCESS_KEY);
    }

    public void selectSumAccessKey()
    {
        selectSum(ACCESS_KEY);
    }

    public void groupByAccessKey()
    {
        groupBy(ACCESS_KEY);
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
    //# projections (email)
    //##################################################

    public void selectEmail()
    {
        select(EMAIL);
    }

    public void selectDistinctEmail()
    {
        selectDistinct(EMAIL);
    }

    public void selectCountDistinctEmail()
    {
        selectCountDistinct(EMAIL);
    }

    public void selectMinimumEmail()
    {
        selectMinimum(EMAIL);
    }

    public void selectMaximumEmail()
    {
        selectMaximum(EMAIL);
    }

    public void selectAverageEmail()
    {
        selectAverage(EMAIL);
    }

    public void selectSumEmail()
    {
        selectSum(EMAIL);
    }

    public void groupByEmail()
    {
        groupBy(EMAIL);
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
    //# association (Account)
    //##################################################

    public void selectAccountUid()
    {
        select(ACCOUNT_UID);
    }

    public void selectMinimumAccountUid()
    {
        selectMinimum(ACCOUNT_UID);
    }

    public void selectMaximumAccountUid()
    {
        selectMaximum(ACCOUNT_UID);
    }

    public void groupByAccountUid()
    {
        groupBy(ACCOUNT);
    }

    public MyAccountCriteria joinToAccount()
    {
        return new MyAccountCriteria(joinTo(ACCOUNT));
    }

    public MyAccountCriteria leftJoinToAccount()
    {
        return new MyAccountCriteria(leftJoinTo(ACCOUNT));
    }

    public KmStringCriteria whereAccountUid()
    {
        return new KmStringCriteria(parent(), fullName(ACCOUNT_UID));
    }

    public void whereAccountIs(MyAccount e)
    {
        if ( e == null )
            whereAccountUid().isNull();
        else
            whereAccountUid().is(e.getUid());
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

    //##################################################
    //# support
    //##################################################

    @Override
    @SuppressWarnings("rawtypes")
    public MyInvitationCriteria createOn(KmModelJunction junction)
    {
        return new MyInvitationCriteria(parent(), junction.context());
    }

}
