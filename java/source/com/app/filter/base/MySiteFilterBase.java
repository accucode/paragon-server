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

public abstract class MySiteFilterBase
    extends MyLoadableFilter<MySite>
    implements MySiteDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MySite> c)
    {
        applyConditionsTo((MySiteCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MySite> c)
    {
        applySortsTo((MySiteCriteria)c);
    }

    protected abstract void applyConditionsTo(MySiteCriteria c);

    protected abstract void applySortsTo(MySiteCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaSite getMeta()
    {
        return MySite.Meta;
    }

    @Override
    protected MySiteDao getDao()
    {
        return getAccess().getSiteDao();
    }

    @Override
    protected MySiteCriteria createCriteria()
    {
        return new MySiteCriteria(_createCriteria());
    }
}
