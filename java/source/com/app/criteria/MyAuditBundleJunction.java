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

public class MyAuditBundleJunction
    extends KmhModelJunction
    implements MyAuditBundleDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyAuditBundleJunction(KmhJunction context)
    {
        super(context);
    }

    //##################################################
    //# properties
    //##################################################

    public KmhStringCondition whereChangeTypeCode()
    {
        return new KmhStringCondition(context(), alias(), CHANGE_TYPE_CODE);
    }

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), CREATED_UTC_TS);
    }

    public KmhStringCondition whereDomainName()
    {
        return new KmhStringCondition(context(), alias(), DOMAIN_NAME);
    }

    public KmhStringCondition whereDomainType()
    {
        return new KmhStringCondition(context(), alias(), DOMAIN_TYPE);
    }

    public KmhStringCondition whereDomainUid()
    {
        return new KmhStringCondition(context(), alias(), DOMAIN_UID);
    }

    public KmhStringCondition whereTransactionUid()
    {
        return new KmhStringCondition(context(), alias(), TRANSACTION_UID);
    }

    public KmhStringCondition whereUid()
    {
        return new KmhStringCondition(context(), alias(), UID);
    }

    public KmhStringCondition whereUserName()
    {
        return new KmhStringCondition(context(), alias(), USER_NAME);
    }

    //##################################################
    //# associations
    //##################################################
    //##################################################
    //# association (User)
    //##################################################

//    public MyUserCriteria joinToUser()
//    {
//        return new MyUserCriteria(joinTo(USER));
//    }
//
//    public MyUserCriteria leftJoinToUser()
//    {
//        return new MyUserCriteria(leftJoinTo(USER));
//    }

    public KmhStringCondition whereUserUid()
    {
        return new KmhStringCondition(context(), alias(), USER_UID);
    }

    public void whereUserIs(MyUser e)
    {
        if ( e == null )
            whereUserUid().isNull();
        else
            whereUserUid().is(e.getUid());
    }

    public void whereUserIsNot(MyUser e)
    {
        if ( e == null )
            whereUserUid().isNotNull();
        else
            whereUserUid().isNot(e.getUid());
    }


    //##################################################
    //# junction
    //##################################################

    public MyAuditBundleJunction addAnd()
    {
        return new MyAuditBundleJunction(context().addAnd());
    }

    public MyAuditBundleJunction addOr()
    {
        return new MyAuditBundleJunction(context().addOr());
    }

}
