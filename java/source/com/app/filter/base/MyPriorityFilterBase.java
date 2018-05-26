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

public abstract class MyPriorityFilterBase
    extends MyBasicFilter<MyPriority>
    implements MyPriorityDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyPriority> c)
    {
        applyConditionsTo((MyPriorityCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyPriority> c)
    {
        applySortsTo((MyPriorityCriteria)c);
    }

    protected abstract void applyConditionsTo(MyPriorityCriteria c);

    protected abstract void applySortsTo(MyPriorityCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaPriority getMeta()
    {
        return MyPriority.Meta;
    }

    @Override
    protected MyPriorityDao getDao()
    {
        return getAccess().getPriorityDao();
    }

    @Override
    protected MyPriorityCriteria createCriteria()
    {
        return new MyPriorityCriteria(_createCriteria());
    }
}
