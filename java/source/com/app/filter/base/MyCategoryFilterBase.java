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

public abstract class MyCategoryFilterBase
    extends MyBasicFilter<MyCategory>
    implements MyCategoryDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyCategory> c)
    {
        applyConditionsTo((MyCategoryCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyCategory> c)
    {
        applySortsTo((MyCategoryCriteria)c);
    }

    protected abstract void applyConditionsTo(MyCategoryCriteria c);

    protected abstract void applySortsTo(MyCategoryCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaCategory getMeta()
    {
        return MyCategory.Meta;
    }

    @Override
    protected MyCategoryDao getDao()
    {
        return getAccess().getCategoryDao();
    }

    @Override
    protected MyCategoryCriteria createCriteria()
    {
        return new MyCategoryCriteria(_createCriteria());
    }
}
