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
