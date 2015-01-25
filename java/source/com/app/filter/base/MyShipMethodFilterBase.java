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

public abstract class MyShipMethodFilterBase
    extends MyBasicFilter<MyShipMethod>
    implements MyShipMethodDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MyShipMethod> c)
    {
        applyConditionsTo((MyShipMethodCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MyShipMethod> c)
    {
        applySortsTo((MyShipMethodCriteria)c);
    }

    protected abstract void applyConditionsTo(MyShipMethodCriteria c);

    protected abstract void applySortsTo(MyShipMethodCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaShipMethod getMeta()
    {
        return MyShipMethod.Meta;
    }

    @Override
    protected MyShipMethodDao getDao()
    {
        return getAccess().getShipMethodDao();
    }

    @Override
    protected MyShipMethodCriteria createCriteria()
    {
        return new MyShipMethodCriteria(createGenericCriteria());
    }
}
