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

public abstract class MyAuditBundleFilterBase
    extends MyBasicFilter<MyAuditBundle>
    implements MyAuditBundleDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyAuditBundle> c)
    {
        applyConditionsTo((MyAuditBundleCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyAuditBundle> c)
    {
        applySortsTo((MyAuditBundleCriteria)c);
    }

    protected abstract void applyConditionsTo(MyAuditBundleCriteria c);

    protected abstract void applySortsTo(MyAuditBundleCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaAuditBundle getMeta()
    {
        return MyAuditBundle.Meta;
    }

    @Override
    protected MyAuditBundleDao getDao()
    {
        return getAccess().getAuditBundleDao();
    }

    @Override
    protected MyAuditBundleCriteria createCriteria()
    {
        return new MyAuditBundleCriteria(_createCriteria());
    }
}
