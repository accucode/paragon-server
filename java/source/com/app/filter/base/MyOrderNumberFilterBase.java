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

public abstract class MyOrderNumberFilterBase
    extends MyBasicFilter<MyOrderNumber>
    implements MyOrderNumberDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyOrderNumber> c)
    {
        applyConditionsTo((MyOrderNumberCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyOrderNumber> c)
    {
        applySortsTo((MyOrderNumberCriteria)c);
    }

    protected abstract void applyConditionsTo(MyOrderNumberCriteria c);

    protected abstract void applySortsTo(MyOrderNumberCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaOrderNumber getMeta()
    {
        return MyOrderNumber.Meta;
    }

    @Override
    protected MyOrderNumberDao getDao()
    {
        return getAccess().getOrderNumberDao();
    }

    @Override
    protected MyOrderNumberCriteria createCriteria()
    {
        return new MyOrderNumberCriteria(_createCriteria());
    }
}
