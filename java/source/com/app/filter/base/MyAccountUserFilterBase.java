//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.filter.base;

import com.kodemore.hibernate.criteria.KmModelCriteria;

import com.app.criteria.MyAccountUserCriteria;
import com.app.dao.MyAccountUserDao;
import com.app.dao.base.MyAccountUserDaoConstantsIF;
import com.app.filter.core.MyBasicFilter;
import com.app.model.MyAccountUser;
import com.app.model.meta.MyMetaAccountUser;

public abstract class MyAccountUserFilterBase
    extends MyBasicFilter<MyAccountUser>
    implements MyAccountUserDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MyAccountUser> c)
    {
        applyConditionsTo((MyAccountUserCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MyAccountUser> c)
    {
        applySortsTo((MyAccountUserCriteria)c);
    }

    protected abstract void applyConditionsTo(MyAccountUserCriteria c);

    protected abstract void applySortsTo(MyAccountUserCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaAccountUser getMeta()
    {
        return MyAccountUser.Meta;
    }

    @Override
    protected MyAccountUserDao getDao()
    {
        return getAccess().getAccountUserDao();
    }

    @Override
    protected MyAccountUserCriteria createCriteria()
    {
        return new MyAccountUserCriteria(createGenericCriteria());
    }
}
