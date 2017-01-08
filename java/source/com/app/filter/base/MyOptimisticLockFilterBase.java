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

public abstract class MyOptimisticLockFilterBase
    extends MyBasicFilter<MyOptimisticLock>
    implements MyOptimisticLockDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyOptimisticLock> c)
    {
        applyConditionsTo((MyOptimisticLockCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyOptimisticLock> c)
    {
        applySortsTo((MyOptimisticLockCriteria)c);
    }

    protected abstract void applyConditionsTo(MyOptimisticLockCriteria c);

    protected abstract void applySortsTo(MyOptimisticLockCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaOptimisticLock getMeta()
    {
        return MyOptimisticLock.Meta;
    }

    @Override
    protected MyOptimisticLockDao getDao()
    {
        return getAccess().getOptimisticLockDao();
    }

    @Override
    protected MyOptimisticLockCriteria createCriteria()
    {
        return new MyOptimisticLockCriteria(_createCriteria());
    }
}
