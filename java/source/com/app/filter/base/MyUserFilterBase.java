//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.filter.base;

import com.app.criteria.MyUserCriteria;
import com.app.dao.MyUserDao;
import com.app.dao.base.MyUserDaoConstantsIF;
import com.app.filter.core.MyBasicFilter;
import com.app.model.MyUser;
import com.app.model.meta.MyMetaUser;

import com.kodemore.hibernate.criteria.KmModelCriteria;

public abstract class MyUserFilterBase
    extends MyBasicFilter<MyUser>
    implements MyUserDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MyUser> c)
    {
        applyConditionsTo((MyUserCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MyUser> c)
    {
        applySortsTo((MyUserCriteria)c);
    }

    protected abstract void applyConditionsTo(MyUserCriteria c);

    protected abstract void applySortsTo(MyUserCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaUser getMeta()
    {
        return MyUser.Meta;
    }

    @Override
    protected MyUserDao getDao()
    {
        return getAccess().getUserDao();
    }

    @Override
    protected MyUserCriteria createCriteria()
    {
        return new MyUserCriteria(createGenericCriteria());
    }
}
