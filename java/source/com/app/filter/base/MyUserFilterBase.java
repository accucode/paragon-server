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
