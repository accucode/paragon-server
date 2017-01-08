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

public abstract class MyTenantFilterBase
    extends MyBasicFilter<MyTenant>
    implements MyTenantDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyTenant> c)
    {
        applyConditionsTo((MyTenantCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyTenant> c)
    {
        applySortsTo((MyTenantCriteria)c);
    }

    protected abstract void applyConditionsTo(MyTenantCriteria c);

    protected abstract void applySortsTo(MyTenantCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaTenant getMeta()
    {
        return MyTenant.Meta;
    }

    @Override
    protected MyTenantDao getDao()
    {
        return getAccess().getTenantDao();
    }

    @Override
    protected MyTenantCriteria createCriteria()
    {
        return new MyTenantCriteria(_createCriteria());
    }
}
