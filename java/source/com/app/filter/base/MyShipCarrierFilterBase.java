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

public abstract class MyShipCarrierFilterBase
    extends MyBasicFilter<MyShipCarrier>
    implements MyShipCarrierDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MyShipCarrier> c)
    {
        applyConditionsTo((MyShipCarrierCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MyShipCarrier> c)
    {
        applySortsTo((MyShipCarrierCriteria)c);
    }

    protected abstract void applyConditionsTo(MyShipCarrierCriteria c);

    protected abstract void applySortsTo(MyShipCarrierCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaShipCarrier getMeta()
    {
        return MyShipCarrier.Meta;
    }

    @Override
    protected MyShipCarrierDao getDao()
    {
        return getAccess().getShipCarrierDao();
    }

    @Override
    protected MyShipCarrierCriteria createCriteria()
    {
        return new MyShipCarrierCriteria(createGenericCriteria());
    }
}
