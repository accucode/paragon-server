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

public class MyMemberSkillCriteria
    extends MyAbstractCriteria<MyMemberSkill>
    implements MyMemberSkillDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyMemberSkillCriteria(KmCriteria parent)
    {
        super(parent);
    }

    public MyMemberSkillCriteria(KmCriteria parent, KmAbstractCriteria context)
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

    public KmIntegerCriteria whereSequence()
    {
        return new KmIntegerCriteria(context(), fullName(SEQUENCE));
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

    public void sortOnSequence()
    {
        parent().sortAscending(SEQUENCE);
    }

    public void sortOnSequenceDescending()
    {
        parent().sortDescending(SEQUENCE);
    }

    public void sortOnSequence(boolean asc)
    {
        if ( asc )
            sortOnSequence();
        else
            sortOnSequenceDescending();
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
    //# projections (sequence)
    //##################################################

    public void selectSequence()
    {
        select(SEQUENCE);
    }

    public void selectDistinctSequence()
    {
        selectDistinct(SEQUENCE);
    }

    public void selectCountDistinctSequence()
    {
        selectCountDistinct(SEQUENCE);
    }

    public void selectMinimumSequence()
    {
        selectMinimum(SEQUENCE);
    }

    public void selectMaximumSequence()
    {
        selectMaximum(SEQUENCE);
    }

    public void selectAverageSequence()
    {
        selectAverage(SEQUENCE);
    }

    public void selectSumSequence()
    {
        selectSum(SEQUENCE);
    }

    public void groupBySequence()
    {
        groupBy(SEQUENCE);
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
    //# association (Member)
    //##################################################

    public void selectMemberUid()
    {
        select(MEMBER_UID);
    }

    public void selectMinimumMemberUid()
    {
        selectMinimum(MEMBER_UID);
    }

    public void selectMaximumMemberUid()
    {
        selectMaximum(MEMBER_UID);
    }

    public void groupByMemberUid()
    {
        groupBy(MEMBER);
    }

    public MyMemberCriteria joinToMember()
    {
        return new MyMemberCriteria(joinTo(MEMBER));
    }

    public MyMemberCriteria leftJoinToMember()
    {
        return new MyMemberCriteria(leftJoinTo(MEMBER));
    }

    public KmStringCriteria whereMemberUid()
    {
        return new KmStringCriteria(parent(), fullName(MEMBER_UID));
    }

    public void whereMemberIs(MyMember e)
    {
        if ( e == null )
            whereMemberUid().isNull();
        else
            whereMemberUid().is(e.getUid());
    }

    //##################################################
    //# association (Skill)
    //##################################################

    public void selectSkillUid()
    {
        select(SKILL_UID);
    }

    public void selectMinimumSkillUid()
    {
        selectMinimum(SKILL_UID);
    }

    public void selectMaximumSkillUid()
    {
        selectMaximum(SKILL_UID);
    }

    public void groupBySkillUid()
    {
        groupBy(SKILL);
    }

    public MySkillCriteria joinToSkill()
    {
        return new MySkillCriteria(joinTo(SKILL));
    }

    public MySkillCriteria leftJoinToSkill()
    {
        return new MySkillCriteria(leftJoinTo(SKILL));
    }

    public KmStringCriteria whereSkillUid()
    {
        return new KmStringCriteria(parent(), fullName(SKILL_UID));
    }

    public void whereSkillIs(MySkill e)
    {
        if ( e == null )
            whereSkillUid().isNull();
        else
            whereSkillUid().is(e.getUid());
    }

    //##################################################
    //# junction
    //##################################################

    public MyMemberSkillJunction addAnd()
    {
        return new MyMemberSkillJunction(parent().addAnd());
    }

    public MyMemberSkillJunction addOr()
    {
        return new MyMemberSkillJunction(parent().addOr());
    }

    //##################################################
    //# support
    //##################################################

    @Override
    public MyMemberSkillCriteria createOn(KmModelJunction junction)
    {
        return new MyMemberSkillCriteria(parent(), junction.context());
    }

}
