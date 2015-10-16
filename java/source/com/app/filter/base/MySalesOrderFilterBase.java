//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.filter.base;

import com.kodemore.collection.*;
import com.kodemore.hibernate.*;

import com.app.command.base.*;
import com.app.criteria.*;
import com.app.dao.*;
import com.app.dao.base.*;
import com.app.filter.*;
import com.app.filter.core.*;
import com.app.model.*;
import com.app.model.meta.*;

public abstract class MySalesOrderFilterBase
    extends MyBasicFilter<MySalesOrder>
    implements MySalesOrderDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MySalesOrder> c)
    {
        applyConditionsTo((MySalesOrderCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MySalesOrder> c)
    {
        applySortsTo((MySalesOrderCriteria)c);
    }

    protected abstract void applyConditionsTo(MySalesOrderCriteria c);

    protected abstract void applySortsTo(MySalesOrderCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaSalesOrder getMeta()
    {
        return MySalesOrder.Meta;
    }

    @Override
    protected MySalesOrderDao getDao()
    {
        return getAccess().getSalesOrderDao();
    }

    @Override
    protected MySalesOrderCriteria createCriteria()
    {
        return new MySalesOrderCriteria(_createCriteria());
    }
}
