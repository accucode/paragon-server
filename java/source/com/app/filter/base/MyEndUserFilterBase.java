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

public abstract class MyEndUserFilterBase
    extends MyBasicFilter<MyEndUser>
    implements MyEndUserDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyEndUser> c)
    {
        applyConditionsTo((MyEndUserCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyEndUser> c)
    {
        applySortsTo((MyEndUserCriteria)c);
    }

    protected abstract void applyConditionsTo(MyEndUserCriteria c);

    protected abstract void applySortsTo(MyEndUserCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaEndUser getMeta()
    {
        return MyEndUser.Meta;
    }

    @Override
    protected MyEndUserDao getDao()
    {
        return getAccess().getEndUserDao();
    }

    @Override
    protected MyEndUserCriteria createCriteria()
    {
        return new MyEndUserCriteria(_createCriteria());
    }
}
