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

public abstract class MyShipmentFilterBase
    extends MyBasicFilter<MyShipment>
    implements MyShipmentDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyShipment> c)
    {
        applyConditionsTo((MyShipmentCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyShipment> c)
    {
        applySortsTo((MyShipmentCriteria)c);
    }

    protected abstract void applyConditionsTo(MyShipmentCriteria c);

    protected abstract void applySortsTo(MyShipmentCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaShipment getMeta()
    {
        return MyShipment.Meta;
    }

    @Override
    protected MyShipmentDao getDao()
    {
        return getAccess().getShipmentDao();
    }

    @Override
    protected MyShipmentCriteria createCriteria()
    {
        return new MyShipmentCriteria(_createCriteria());
    }
}
