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

public abstract class MySalesOrderContactFilterBase
    extends MyBasicFilter<MySalesOrderContact>
    implements MySalesOrderContactDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MySalesOrderContact> c)
    {
        applyConditionsTo((MySalesOrderContactCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MySalesOrderContact> c)
    {
        applySortsTo((MySalesOrderContactCriteria)c);
    }

    protected abstract void applyConditionsTo(MySalesOrderContactCriteria c);

    protected abstract void applySortsTo(MySalesOrderContactCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaSalesOrderContact getMeta()
    {
        return MySalesOrderContact.Meta;
    }

    @Override
    protected MySalesOrderContactDao getDao()
    {
        return getAccess().getSalesOrderContactDao();
    }

    @Override
    protected MySalesOrderContactCriteria createCriteria()
    {
        return new MySalesOrderContactCriteria(_createCriteria());
    }
}
