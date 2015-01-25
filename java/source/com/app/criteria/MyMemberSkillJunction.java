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

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.meta.*;

public class MyMemberSkillJunction
    extends KmModelJunction
    implements MyMemberSkillDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyMemberSkillJunction(KmJunction context)
    {
        super(context);
    }

    public MyMemberSkillJunction(KmJunction context, KmAbstractCriteria parent)
    {
        super(context, parent);
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
    //# associations
    //##################################################

    public MyMemberCriteria joinToMember()
    {
        return join(new MyMemberCriteria(root().joinTo(MEMBER)));
    }

    public MyMemberCriteria leftJoinToMember()
    {
        return join(new MyMemberCriteria(root().leftJoinTo(MEMBER)));
    }

    public KmStringCriteria whereMemberUid()
    {
        return new KmStringCriteria(context(), fullName(MEMBER_UID));
    }

    public MySkillCriteria joinToSkill()
    {
        return join(new MySkillCriteria(root().joinTo(SKILL)));
    }

    public MySkillCriteria leftJoinToSkill()
    {
        return join(new MySkillCriteria(root().leftJoinTo(SKILL)));
    }

    public KmStringCriteria whereSkillUid()
    {
        return new KmStringCriteria(context(), fullName(SKILL_UID));
    }

    //##################################################
    //# junction
    //##################################################

    public MyMemberSkillJunction addAnd()
    {
        return new MyMemberSkillJunction(context().addAnd(), parent());
    }

    public MyMemberSkillJunction addOr()
    {
        return new MyMemberSkillJunction(context().addOr(), parent());
    }

}
