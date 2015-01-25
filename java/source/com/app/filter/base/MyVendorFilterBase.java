//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################


package com.app.filter.base;

import com.kodemore.collection.*;
import com.kodemore.hibernate.criteria.*;

import com.app.command.base.*;
import com.app.criteria.*;
import com.app.dao.*;
import com.app.dao.base.*;
import com.app.filter.*;
import com.app.filter.core.*;
import com.app.model.*;
import com.app.model.meta.*;

public abstract class MyVendorFilterBase
    extends MyBasicFilter<MyVendor>
    implements MyVendorDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MyVendor> c)
    {
        applyConditionsTo((MyVendorCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MyVendor> c)
    {
        applySortsTo((MyVendorCriteria)c);
    }

    protected abstract void applyConditionsTo(MyVendorCriteria c);

    protected abstract void applySortsTo(MyVendorCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaVendor getMeta()
    {
        return MyVendor.Meta;
    }

    @Override
    protected MyVendorDao getDao()
    {
        return getAccess().getVendorDao();
    }

    @Override
    protected MyVendorCriteria createCriteria()
    {
        return new MyVendorCriteria(createGenericCriteria());
    }
}
