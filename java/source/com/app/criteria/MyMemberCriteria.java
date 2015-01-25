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

public class MyMemberCriteria
    extends MyAbstractCriteria<MyMember>
    implements MyMemberDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyMemberCriteria(KmCriteria parent)
    {
        super(parent);
    }

    public MyMemberCriteria(KmCriteria parent, KmAbstractCriteria context)
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

    public void whereRoleIs(MyMemberRole e)
    {
        if ( e == null )
            whereRoleCode().isNull();
        else
            whereRoleCode().is(e.getCode());
    }

    public void whereRoleIsNot(MyMemberRole e)
    {
        if ( e == null )
            whereRoleCode().isNull();
        else
            whereRoleCode().isNot(e.getCode());
    }

    public void whereRoleIsManager()
    {
        whereRoleIs(MyMemberRole.Manager);
    }

    public void whereRoleIsNotManager()
    {
        whereRoleIsNot(MyMemberRole.Manager);
    }

    public void whereRoleIsManager(boolean e)
    {
        if ( e )
            whereRoleIsManager();
        else
            whereRoleIsNotManager();
    }

    public void whereRoleIsWorker()
    {
        whereRoleIs(MyMemberRole.Worker);
    }

    public void whereRoleIsNotWorker()
    {
        whereRoleIsNot(MyMemberRole.Worker);
    }

    public void whereRoleIsWorker(boolean e)
    {
        if ( e )
            whereRoleIsWorker();
        else
            whereRoleIsNotWorker();
    }

    public void whereRoleIsCustomer()
    {
        whereRoleIs(MyMemberRole.Customer);
    }

    public void whereRoleIsNotCustomer()
    {
        whereRoleIsNot(MyMemberRole.Customer);
    }

    public void whereRoleIsCustomer(boolean e)
    {
        if ( e )
            whereRoleIsCustomer();
        else
            whereRoleIsNotCustomer();
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

    public KmStringCriteria whereProjectUid()
    {
        return new KmStringCriteria(parent(), fullName(PROJECT_UID));
    }

    public void whereProjectIs(MyProject e)
    {
        if ( e == null )
            whereProjectUid().isNull();
        else
            whereProjectUid().is(e.getUid());
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
    //# collection (MemberSkills)
    //##################################################

    public MyMemberSkillCriteria joinToMemberSkills()
    {
        return new MyMemberSkillCriteria(joinTo(MEMBER_SKILLS));
    }

    public MyMemberSkillCriteria leftJoinToMemberSkills()
    {
        return new MyMemberSkillCriteria(leftJoinTo(MEMBER_SKILLS));
    }

    //##################################################
    //# junction
    //##################################################

    public MyMemberJunction addAnd()
    {
        return new MyMemberJunction(parent().addAnd());
    }

    public MyMemberJunction addOr()
    {
        return new MyMemberJunction(parent().addOr());
    }

    //##################################################
    //# support
    //##################################################

    @Override
    public MyMemberCriteria createOn(KmModelJunction junction)
    {
        return new MyMemberCriteria(parent(), junction.context());
    }

}
