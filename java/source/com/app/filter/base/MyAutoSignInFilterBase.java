//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.filter.base;

import com.app.criteria.MyAutoSignInCriteria;
import com.app.dao.MyAutoSignInDao;
import com.app.dao.base.MyAutoSignInDaoConstantsIF;
import com.app.filter.core.MyBasicFilter;
import com.app.model.MyAutoSignIn;
import com.app.model.meta.MyMetaAutoSignIn;

import com.kodemore.hibernate.criteria.KmModelCriteria;

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
