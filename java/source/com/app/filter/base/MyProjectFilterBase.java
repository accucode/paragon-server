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

public abstract class MyProjectFilterBase
    extends MyBasicFilter<MyProject>
    implements MyProjectDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MyProject> c)
    {
        applyConditionsTo((MyProjectCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MyProject> c)
    {
        applySortsTo((MyProjectCriteria)c);
    }

    protected abstract void applyConditionsTo(MyProjectCriteria c);

    protected abstract void applySortsTo(MyProjectCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaProject getMeta()
    {
        return MyProject.Meta;
    }

    @Override
    protected MyProjectDao getDao()
    {
        return getAccess().getProjectDao();
    }

    @Override
    protected MyProjectCriteria createCriteria()
    {
        return new MyProjectCriteria(createGenericCriteria());
    }
}
