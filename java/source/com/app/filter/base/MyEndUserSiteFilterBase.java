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

public abstract class MyEndUserSiteFilterBase
    extends MyBasicFilter<MyEndUserSite>
    implements MyEndUserSiteDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyEndUserSite> c)
    {
        applyConditionsTo((MyEndUserSiteCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyEndUserSite> c)
    {
        applySortsTo((MyEndUserSiteCriteria)c);
    }

    protected abstract void applyConditionsTo(MyEndUserSiteCriteria c);

    protected abstract void applySortsTo(MyEndUserSiteCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaEndUserSite getMeta()
    {
        return MyEndUserSite.Meta;
    }

    @Override
    protected MyEndUserSiteDao getDao()
    {
        return getAccess().getEndUserSiteDao();
    }

    @Override
    protected MyEndUserSiteCriteria createCriteria()
    {
        return new MyEndUserSiteCriteria(_createCriteria());
    }
}
