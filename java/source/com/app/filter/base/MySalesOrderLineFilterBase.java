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

public abstract class MySalesOrderLineFilterBase
    extends MyBasicFilter<MySalesOrderLine>
    implements MySalesOrderLineDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MySalesOrderLine> c)
    {
        applyConditionsTo((MySalesOrderLineCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MySalesOrderLine> c)
    {
        applySortsTo((MySalesOrderLineCriteria)c);
    }

    protected abstract void applyConditionsTo(MySalesOrderLineCriteria c);

    protected abstract void applySortsTo(MySalesOrderLineCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaSalesOrderLine getMeta()
    {
        return MySalesOrderLine.Meta;
    }

    @Override
    protected MySalesOrderLineDao getDao()
    {
        return getAccess().getSalesOrderLineDao();
    }

    @Override
    protected MySalesOrderLineCriteria createCriteria()
    {
        return new MySalesOrderLineCriteria(_createCriteria());
    }
}
