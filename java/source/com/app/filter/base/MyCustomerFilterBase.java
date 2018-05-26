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

public abstract class MyCustomerFilterBase
    extends MyBasicFilter<MyCustomer>
    implements MyCustomerDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyCustomer> c)
    {
        applyConditionsTo((MyCustomerCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyCustomer> c)
    {
        applySortsTo((MyCustomerCriteria)c);
    }

    protected abstract void applyConditionsTo(MyCustomerCriteria c);

    protected abstract void applySortsTo(MyCustomerCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaCustomer getMeta()
    {
        return MyCustomer.Meta;
    }

    @Override
    protected MyCustomerDao getDao()
    {
        return getAccess().getCustomerDao();
    }

    @Override
    protected MyCustomerCriteria createCriteria()
    {
        return new MyCustomerCriteria(_createCriteria());
    }
}
