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

public class MyUserAccountCriteria
    extends MyAbstractCriteria<MyUserAccount>
    implements MyUserAccountDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyUserAccountCriteria(KmCriteria parent)
    {
        super(parent);
    }

    public MyUserAccountCriteria(KmCriteria parent, KmAbstractCriteria context)
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

    public void whereRoleIs(MyUserAccountRole e)
    {
        if ( e == null )
            whereRoleCode().isNull();
        else
            whereRoleCode().is(e.getCode());
    }

    public void whereRoleIsNot(MyUserAccountRole e)
    {
        if ( e == null )
            whereRoleCode().isNull();
        else
            whereRoleCode().isNot(e.getCode());
    }

    public void whereRoleIsOwner()
    {
        whereRoleIs(MyUserAccountRole.Owner);
    }

    public void whereRoleIsNotOwner()
    {
        whereRoleIsNot(MyUserAccountRole.Owner);
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
        whereRoleIs(MyUserAccountRole.Manager);
    }

    public void whereRoleIsNotManager()
    {
        whereRoleIsNot(MyUserAccountRole.Manager);
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
        whereRoleIs(MyUserAccountRole.User);
    }

    public void whereRoleIsNotUser()
    {
        whereRoleIsNot(MyUserAccountRole.User);
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

    public MyUserAccountJunction addAnd()
    {
        return new MyUserAccountJunction(parent().addAnd());
    }

    public MyUserAccountJunction addOr()
    {
        return new MyUserAccountJunction(parent().addOr());
    }

    //##################################################
    //# support
    //##################################################

    @Override
    @SuppressWarnings("rawtypes")
    public MyUserAccountCriteria createOn(KmModelJunction junction)
    {
        return new MyUserAccountCriteria(parent(), junction.context());
    }

}
