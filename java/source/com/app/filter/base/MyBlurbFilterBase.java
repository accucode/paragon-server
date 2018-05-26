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

public abstract class MyBlurbFilterBase
    extends MyBasicFilter<MyBlurb>
    implements MyBlurbDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyBlurb> c)
    {
        applyConditionsTo((MyBlurbCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyBlurb> c)
    {
        applySortsTo((MyBlurbCriteria)c);
    }

    protected abstract void applyConditionsTo(MyBlurbCriteria c);

    protected abstract void applySortsTo(MyBlurbCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaBlurb getMeta()
    {
        return MyBlurb.Meta;
    }

    @Override
    protected MyBlurbDao getDao()
    {
        return getAccess().getBlurbDao();
    }

    @Override
    protected MyBlurbCriteria createCriteria()
    {
        return new MyBlurbCriteria(_createCriteria());
    }
}
