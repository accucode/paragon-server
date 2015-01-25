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

public abstract class MyVisitTypeFilterBase
    extends MyBasicFilter<MyVisitType>
    implements MyVisitTypeDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MyVisitType> c)
    {
        applyConditionsTo((MyVisitTypeCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MyVisitType> c)
    {
        applySortsTo((MyVisitTypeCriteria)c);
    }

    protected abstract void applyConditionsTo(MyVisitTypeCriteria c);

    protected abstract void applySortsTo(MyVisitTypeCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaVisitType getMeta()
    {
        return MyVisitType.Meta;
    }

    @Override
    protected MyVisitTypeDao getDao()
    {
        return getAccess().getVisitTypeDao();
    }

    @Override
    protected MyVisitTypeCriteria createCriteria()
    {
        return new MyVisitTypeCriteria(createGenericCriteria());
    }
}
