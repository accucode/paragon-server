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

public abstract class MyCustomerSiteFilterBase
    extends MyBasicFilter<MyCustomerSite>
    implements MyCustomerSiteDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyCustomerSite> c)
    {
        applyConditionsTo((MyCustomerSiteCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyCustomerSite> c)
    {
        applySortsTo((MyCustomerSiteCriteria)c);
    }

    protected abstract void applyConditionsTo(MyCustomerSiteCriteria c);

    protected abstract void applySortsTo(MyCustomerSiteCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaCustomerSite getMeta()
    {
        return MyCustomerSite.Meta;
    }

    @Override
    protected MyCustomerSiteDao getDao()
    {
        return getAccess().getCustomerSiteDao();
    }

    @Override
    protected MyCustomerSiteCriteria createCriteria()
    {
        return new MyCustomerSiteCriteria(_createCriteria());
    }
}
