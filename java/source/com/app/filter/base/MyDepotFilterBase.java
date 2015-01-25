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

public abstract class MyDepotFilterBase
    extends MyBasicFilter<MyDepot>
    implements MyDepotDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MyDepot> c)
    {
        applyConditionsTo((MyDepotCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MyDepot> c)
    {
        applySortsTo((MyDepotCriteria)c);
    }

    protected abstract void applyConditionsTo(MyDepotCriteria c);

    protected abstract void applySortsTo(MyDepotCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaDepot getMeta()
    {
        return MyDepot.Meta;
    }

    @Override
    protected MyDepotDao getDao()
    {
        return getAccess().getDepotDao();
    }

    @Override
    protected MyDepotCriteria createCriteria()
    {
        return new MyDepotCriteria(createGenericCriteria());
    }
}
