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

public abstract class MyUserActivationFilterBase
    extends MyBasicFilter<MyUserActivation>
    implements MyUserActivationDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MyUserActivation> c)
    {
        applyConditionsTo((MyUserActivationCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MyUserActivation> c)
    {
        applySortsTo((MyUserActivationCriteria)c);
    }

    protected abstract void applyConditionsTo(MyUserActivationCriteria c);

    protected abstract void applySortsTo(MyUserActivationCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaUserActivation getMeta()
    {
        return MyUserActivation.Meta;
    }

    @Override
    protected MyUserActivationDao getDao()
    {
        return getAccess().getUserActivationDao();
    }

    @Override
    protected MyUserActivationCriteria createCriteria()
    {
        return new MyUserActivationCriteria(createGenericCriteria());
    }
}
