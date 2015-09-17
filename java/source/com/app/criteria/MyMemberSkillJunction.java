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

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.meta.*;

public class MyMemberSkillJunction
    extends KmhModelJunction
    implements MyMemberSkillDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyMemberSkillJunction(KmhJunction context)
    {
        super(context);
    }

    //##################################################
    //# properties
    //##################################################

    public KmhStringCondition whereUid()
    {
        return new KmhStringCondition(context(), fullName(UID));
    }

    public KmhIntegerCondition whereSequence()
    {
        return new KmhIntegerCondition(context(), fullName(SEQUENCE));
    }

    public KmhIntegerCondition whereLockVersion()
    {
        return new KmhIntegerCondition(context(), fullName(LOCK_VERSION));
    }

    //##################################################
    //# associations
    //##################################################

    //##################################################
    //# junction
    //##################################################

    public MyMemberSkillJunction addAnd()
    {
        return new MyMemberSkillJunction(context().addAnd());
    }

    public MyMemberSkillJunction addOr()
    {
        return new MyMemberSkillJunction(context().addOr());
    }

}
