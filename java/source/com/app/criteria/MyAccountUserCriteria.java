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
import com.kodemore.hibernate.criteria.KmStringCriteria;

import com.app.criteria.core.MyAbstractCriteria;
import com.app.dao.base.MyAccountUserDaoConstantsIF;
import com.app.model.MyAccount;
import com.app.model.MyAccountUser;
import com.app.model.MyAccountUserRole;
import com.app.model.MyUser;

public class MyAccountUserCriteria
    extends MyAbstractCriteria<MyAccountUser>
    implements MyAccountUserDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyAccountUserCriteria(KmCriteria parent)
    {
        super(parent);
    }

    public MyAccountUserCriteria(KmCriteria parent, KmAbstractCriteria context)
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

    public KmStringCriteria whereRoleCode()
    {
        return new KmStringCriteria(context(), fullName(ROLE_CODE));
    }

    public void whereRoleIs(MyAccountUserRole e)
    {
        if ( e == null )
            whereRoleCode().isNull();
        else
            whereRoleCode().is(e.getCode());
    }

    public void whereRoleIsNot(MyAccountUserRole e)
    {
        if ( e == null )
            whereRoleCode().isNull();
        else
            whereRoleCode().isNot(e.getCode());
    }

    public void whereRoleIsOwner()
    {
        whereRoleIs(MyAccountUserRole.Owner);
    }

    public void whereRoleIsNotOwner()
    {
        whereRoleIsNot(MyAccountUserRole.Owner);
    }

    public void whereRoleIsOwner(boolean e)
    {
        if ( e )
            whereRoleIsOwner();
        else
            whereRoleIsNotOwner();
    }

    public void whereRoleIsManager()
    {
        whereRoleIs(MyAccountUserRole.Manager);
    }

    public void whereRoleIsNotManager()
    {
        whereRoleIsNot(MyAccountUserRole.Manager);
    }

    public void whereRoleIsManager(boolean e)
    {
        if ( e )
            whereRoleIsManager();
        else
            whereRoleIsNotManager();
    }

    public void whereRoleIsUser()
    {
        whereRoleIs(MyAccountUserRole.User);
    }

    public void whereRoleIsNotUser()
    {
        whereRoleIsNot(MyAccountUserRole.User);
    }

    public void whereRoleIsUser(boolean e)
    {
        if ( e )
            whereRoleIsUser();
        else
            whereRoleIsNotUser();
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

    public MyAccountUserJunction addAnd()
    {
        return new MyAccountUserJunction(parent().addAnd());
    }

    public MyAccountUserJunction addOr()
    {
        return new MyAccountUserJunction(parent().addOr());
    }

    //##################################################
    //# support
    //##################################################

    @Override
    @SuppressWarnings("rawtypes")
    public MyAccountUserCriteria createOn(KmModelJunction junction)
    {
        return new MyAccountUserCriteria(parent(), junction.context());
    }

}
