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

public abstract class MyProductFilterBase
    extends MyBasicFilter<MyProduct>
    implements MyProductDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyProduct> c)
    {
        applyConditionsTo((MyProductCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyProduct> c)
    {
        applySortsTo((MyProductCriteria)c);
    }

    protected abstract void applyConditionsTo(MyProductCriteria c);

    protected abstract void applySortsTo(MyProductCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaProduct getMeta()
    {
        return MyProduct.Meta;
    }

    @Override
    protected MyProductDao getDao()
    {
        return getAccess().getProductDao();
    }

    @Override
    protected MyProductCriteria createCriteria()
    {
        return new MyProductCriteria(_createCriteria());
    }
}
