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

public abstract class MyProductCategoryFilterBase
    extends MyBasicFilter<MyProductCategory>
    implements MyProductCategoryDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyProductCategory> c)
    {
        applyConditionsTo((MyProductCategoryCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyProductCategory> c)
    {
        applySortsTo((MyProductCategoryCriteria)c);
    }

    protected abstract void applyConditionsTo(MyProductCategoryCriteria c);

    protected abstract void applySortsTo(MyProductCategoryCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaProductCategory getMeta()
    {
        return MyProductCategory.Meta;
    }

    @Override
    protected MyProductCategoryDao getDao()
    {
        return getAccess().getProductCategoryDao();
    }

    @Override
    protected MyProductCategoryCriteria createCriteria()
    {
        return new MyProductCategoryCriteria(_createCriteria());
    }
}
