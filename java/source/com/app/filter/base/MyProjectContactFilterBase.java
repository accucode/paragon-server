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

public abstract class MyProjectContactFilterBase
    extends MyBasicFilter<MyProjectContact>
    implements MyProjectContactDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyProjectContact> c)
    {
        applyConditionsTo((MyProjectContactCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyProjectContact> c)
    {
        applySortsTo((MyProjectContactCriteria)c);
    }

    protected abstract void applyConditionsTo(MyProjectContactCriteria c);

    protected abstract void applySortsTo(MyProjectContactCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaProjectContact getMeta()
    {
        return MyProjectContact.Meta;
    }

    @Override
    protected MyProjectContactDao getDao()
    {
        return getAccess().getProjectContactDao();
    }

    @Override
    protected MyProjectContactCriteria createCriteria()
    {
        return new MyProjectContactCriteria(_createCriteria());
    }
}
