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

public abstract class MyMasterProductFilterBase
    extends MyBasicFilter<MyMasterProduct>
    implements MyMasterProductDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyMasterProduct> c)
    {
        applyConditionsTo((MyMasterProductCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyMasterProduct> c)
    {
        applySortsTo((MyMasterProductCriteria)c);
    }

    protected abstract void applyConditionsTo(MyMasterProductCriteria c);

    protected abstract void applySortsTo(MyMasterProductCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaMasterProduct getMeta()
    {
        return MyMasterProduct.Meta;
    }

    @Override
    protected MyMasterProductDao getDao()
    {
        return getAccess().getMasterProductDao();
    }

    @Override
    protected MyMasterProductCriteria createCriteria()
    {
        return new MyMasterProductCriteria(_createCriteria());
    }
}
