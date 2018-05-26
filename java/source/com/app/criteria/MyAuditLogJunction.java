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

public class MyAuditLogJunction
    extends KmhModelJunction
    implements MyAuditLogDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyAuditLogJunction(KmhJunction context)
    {
        super(context);
    }

    //##################################################
    //# properties
    //##################################################

    public KmhBooleanCondition whereBooleanValue()
    {
        return new KmhBooleanCondition(context(), alias(), BOOLEAN_VALUE);
    }

    public KmhTimestampCondition whereCreatedUtcTs()
    {
        return new KmhTimestampCondition(context(), alias(), CREATED_UTC_TS);
    }

    public KmhDateCondition whereDateValue()
    {
        return new KmhDateCondition(context(), alias(), DATE_VALUE);
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

    public KmhPropertyCondition<Double> whereDoubleValue()
    {
        return new KmhPropertyCondition<>(context(), alias(), DOUBLE_VALUE);
    }

    public KmhStringCondition whereFieldName()
    {
        return new KmhStringCondition(context(), alias(), FIELD_NAME);
    }

    public KmhIntegerCondition whereIntegerValue()
    {
        return new KmhIntegerCondition(context(), alias(), INTEGER_VALUE);
    }

    public KmhPropertyCondition<Long> whereLongValue()
    {
        return new KmhPropertyCondition<>(context(), alias(), LONG_VALUE);
    }

    public KmhPropertyCondition<KmMoney> whereMoneyValue()
    {
        return new KmhPropertyCondition<>(context(), alias(), MONEY_VALUE);
    }

    public KmhStringCondition whereNewValue()
    {
        return new KmhStringCondition(context(), alias(), NEW_VALUE);
    }

    public KmhStringCondition whereOldValue()
    {
        return new KmhStringCondition(context(), alias(), OLD_VALUE);
    }

    public KmhStringCondition whereStringValue()
    {
        return new KmhStringCondition(context(), alias(), STRING_VALUE);
    }

    public KmhTimestampCondition whereTimestampValue()
    {
        return new KmhTimestampCondition(context(), alias(), TIMESTAMP_VALUE);
    }

    public KmhStringCondition whereTransactionUid()
    {
        return new KmhStringCondition(context(), alias(), TRANSACTION_UID);
    }

    public KmhStringCondition whereTypeCode()
    {
        return new KmhStringCondition(context(), alias(), TYPE_CODE);
    }

    public KmhStringCondition whereUid()
    {
        return new KmhStringCondition(context(), alias(), UID);
    }

    public KmhStringCondition whereUidValue()
    {
        return new KmhStringCondition(context(), alias(), UID_VALUE);
    }

    public KmhStringCondition whereUserName()
    {
        return new KmhStringCondition(context(), alias(), USER_NAME);
    }

    //##################################################
    //# associations
    //##################################################
    //##################################################
    //# association (Bundle)
    //##################################################

//    public MyAuditBundleCriteria joinToBundle()
//    {
//        return new MyAuditBundleCriteria(joinTo(BUNDLE));
//    }
//
//    public MyAuditBundleCriteria leftJoinToBundle()
//    {
//        return new MyAuditBundleCriteria(leftJoinTo(BUNDLE));
//    }

    public KmhStringCondition whereBundleUid()
    {
        return new KmhStringCondition(context(), alias(), BUNDLE_UID);
    }

    public void whereBundleIs(MyAuditBundle e)
    {
        if ( e == null )
            whereBundleUid().isNull();
        else
            whereBundleUid().is(e.getUid());
    }

    public void whereBundleIsNot(MyAuditBundle e)
    {
        if ( e == null )
            whereBundleUid().isNotNull();
        else
            whereBundleUid().isNot(e.getUid());
    }

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

    public MyAuditLogJunction addAnd()
    {
        return new MyAuditLogJunction(context().addAnd());
    }

    public MyAuditLogJunction addOr()
    {
        return new MyAuditLogJunction(context().addOr());
    }

}
