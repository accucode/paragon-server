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

public abstract class MyAutoSignInFilterBase
    extends MyBasicFilter<MyAutoSignIn>
    implements MyAutoSignInDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MyAutoSignIn> c)
    {
        applyConditionsTo((MyAutoSignInCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MyAutoSignIn> c)
    {
        applySortsTo((MyAutoSignInCriteria)c);
    }

    protected abstract void applyConditionsTo(MyAutoSignInCriteria c);

    protected abstract void applySortsTo(MyAutoSignInCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaAutoSignIn getMeta()
    {
        return MyAutoSignIn.Meta;
    }

    @Override
    protected MyAutoSignInDao getDao()
    {
        return getAccess().getAutoSignInDao();
    }

    @Override
    protected MyAutoSignInCriteria createCriteria()
    {
        return new MyAutoSignInCriteria(createGenericCriteria());
    }
}
