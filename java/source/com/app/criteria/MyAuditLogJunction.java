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

    public KmhStringCondition whereUid()
    {
        return new KmhStringCondition(context(), fullName(UID));
    }

    public KmhStringCondition whereTransactionUid()
    {
        return new KmhStringCondition(context(), fullName(TRANSACTION_UID));
    }

    public KmhStringCondition whereUserName()
    {
        return new KmhStringCondition(context(), fullName(USER_NAME));
    }

    public KmhStringCondition whereTypeCode()
    {
        return new KmhStringCondition(context(), fullName(TYPE_CODE));
    }

    public KmhTimestampCondition whereUtcTs()
    {
        return new KmhTimestampCondition(context(), fullName(UTC_TS));
    }

    public KmhStringCondition whereModelName()
    {
        return new KmhStringCondition(context(), fullName(MODEL_NAME));
    }

    public KmhStringCondition whereModelUid()
    {
        return new KmhStringCondition(context(), fullName(MODEL_UID));
    }

    public KmhStringCondition whereFieldName()
    {
        return new KmhStringCondition(context(), fullName(FIELD_NAME));
    }

    public KmhStringCondition whereNewValue()
    {
        return new KmhStringCondition(context(), fullName(NEW_VALUE));
    }

    public KmhStringCondition whereOldValue()
    {
        return new KmhStringCondition(context(), fullName(OLD_VALUE));
    }

    public KmhStringCondition whereStringValue()
    {
        return new KmhStringCondition(context(), fullName(STRING_VALUE));
    }

    public KmhIntegerCondition whereIntegerValue()
    {
        return new KmhIntegerCondition(context(), fullName(INTEGER_VALUE));
    }

    public KmhPropertyCondition<Long> whereLongValue()
    {
        return new KmhPropertyCondition<>(context(), fullName(LONG_VALUE));
    }

    public KmhPropertyCondition<Double> whereDoubleValue()
    {
        return new KmhPropertyCondition<>(context(), fullName(DOUBLE_VALUE));
    }

    public KmhPropertyCondition<KmMoney> whereMoneyValue()
    {
        return new KmhPropertyCondition<>(context(), fullName(MONEY_VALUE));
    }

    public KmhBooleanCondition whereBooleanValue()
    {
        return new KmhBooleanCondition(context(), fullName(BOOLEAN_VALUE));
    }

    public KmhDateCondition whereDateValue()
    {
        return new KmhDateCondition(context(), fullName(DATE_VALUE));
    }

    public KmhTimestampCondition whereTimestampValue()
    {
        return new KmhTimestampCondition(context(), fullName(TIMESTAMP_VALUE));
    }

    public KmhStringCondition whereUidValue()
    {
        return new KmhStringCondition(context(), fullName(UID_VALUE));
    }

    //##################################################
    //# associations
    //##################################################

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
