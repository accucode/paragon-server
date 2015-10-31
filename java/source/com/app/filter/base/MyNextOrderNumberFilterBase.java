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

public abstract class MyNextOrderNumberFilterBase
    extends MyBasicFilter<MyNextOrderNumber>
    implements MyNextOrderNumberDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyNextOrderNumber> c)
    {
        applyConditionsTo((MyNextOrderNumberCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyNextOrderNumber> c)
    {
        applySortsTo((MyNextOrderNumberCriteria)c);
    }

    protected abstract void applyConditionsTo(MyNextOrderNumberCriteria c);

    protected abstract void applySortsTo(MyNextOrderNumberCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaNextOrderNumber getMeta()
    {
        return MyNextOrderNumber.Meta;
    }

    @Override
    protected MyNextOrderNumberDao getDao()
    {
        return getAccess().getNextOrderNumberDao();
    }

    @Override
    protected MyNextOrderNumberCriteria createCriteria()
    {
        return new MyNextOrderNumberCriteria(_createCriteria());
    }
}
