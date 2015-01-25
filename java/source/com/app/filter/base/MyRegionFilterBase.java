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

public abstract class MyRegionFilterBase
    extends MyBasicFilter<MyRegion>
    implements MyRegionDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MyRegion> c)
    {
        applyConditionsTo((MyRegionCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MyRegion> c)
    {
        applySortsTo((MyRegionCriteria)c);
    }

    protected abstract void applyConditionsTo(MyRegionCriteria c);

    protected abstract void applySortsTo(MyRegionCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaRegion getMeta()
    {
        return MyRegion.Meta;
    }

    @Override
    protected MyRegionDao getDao()
    {
        return getAccess().getRegionDao();
    }

    @Override
    protected MyRegionCriteria createCriteria()
    {
        return new MyRegionCriteria(createGenericCriteria());
    }
}
