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

public abstract class MyPowerTypeFilterBase
    extends MyBasicFilter<MyPowerType>
    implements MyPowerTypeDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyPowerType> c)
    {
        applyConditionsTo((MyPowerTypeCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyPowerType> c)
    {
        applySortsTo((MyPowerTypeCriteria)c);
    }

    protected abstract void applyConditionsTo(MyPowerTypeCriteria c);

    protected abstract void applySortsTo(MyPowerTypeCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaPowerType getMeta()
    {
        return MyPowerType.Meta;
    }

    @Override
    protected MyPowerTypeDao getDao()
    {
        return getAccess().getPowerTypeDao();
    }

    @Override
    protected MyPowerTypeCriteria createCriteria()
    {
        return new MyPowerTypeCriteria(_createCriteria());
    }
}
