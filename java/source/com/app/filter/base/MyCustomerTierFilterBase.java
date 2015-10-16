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

public abstract class MyCustomerTierFilterBase
    extends MyBasicFilter<MyCustomerTier>
    implements MyCustomerTierDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyCustomerTier> c)
    {
        applyConditionsTo((MyCustomerTierCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyCustomerTier> c)
    {
        applySortsTo((MyCustomerTierCriteria)c);
    }

    protected abstract void applyConditionsTo(MyCustomerTierCriteria c);

    protected abstract void applySortsTo(MyCustomerTierCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaCustomerTier getMeta()
    {
        return MyCustomerTier.Meta;
    }

    @Override
    protected MyCustomerTierDao getDao()
    {
        return getAccess().getCustomerTierDao();
    }

    @Override
    protected MyCustomerTierCriteria createCriteria()
    {
        return new MyCustomerTierCriteria(_createCriteria());
    }
}
