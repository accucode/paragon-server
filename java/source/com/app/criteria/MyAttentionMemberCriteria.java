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

public class MyAttentionMemberCriteria
    extends MyAbstractCriteria<MyAttentionMember>
    implements MyAttentionMemberDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyAttentionMemberCriteria(KmhCriteria parent)
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
    //# association (Group)
    //##################################################

    public void selectGroupUid()
    {
        select(GROUP_UID);
    }

    public void selectMinimumGroupUid()
    {
        selectMinimum(GROUP_UID);
    }

    public void selectMaximumGroupUid()
    {
        selectMaximum(GROUP_UID);
    }

    public void groupByGroupUid()
    {
        groupBy(GROUP);
    }

    public MyAttentionGroupCriteria joinToGroup()
    {
        return new MyAttentionGroupCriteria(joinTo(GROUP));
    }

    public MyAttentionGroupCriteria leftJoinToGroup()
    {
        return new MyAttentionGroupCriteria(leftJoinTo(GROUP));
    }

    public KmhStringCondition whereGroupUid()
    {
        return new KmhStringCondition(parent(), fullName(GROUP_UID));
    }

    public void whereGroupIs(MyAttentionGroup e)
    {
        if ( e == null )
            whereGroupUid().isNull();
        else
            whereGroupUid().is(e.getUid());
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

    public KmhStringCondition whereMemberUid()
    {
        return new KmhStringCondition(parent(), fullName(MEMBER_UID));
    }

    public void whereMemberIs(MyMember e)
    {
        if ( e == null )
            whereMemberUid().isNull();
        else
            whereMemberUid().is(e.getUid());
    }

    //##################################################
    //# junction
    //##################################################

    public MyAttentionMemberJunction addAnd()
    {
        return new MyAttentionMemberJunction(parent().addAnd());
    }

    public MyAttentionMemberJunction addOr()
    {
        return new MyAttentionMemberJunction(parent().addOr());
    }
}
