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

public abstract class MyPasswordResetFilterBase
    extends MyBasicFilter<MyPasswordReset>
    implements MyPasswordResetDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyPasswordReset> c)
    {
        applyConditionsTo((MyPasswordResetCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyPasswordReset> c)
    {
        applySortsTo((MyPasswordResetCriteria)c);
    }

    protected abstract void applyConditionsTo(MyPasswordResetCriteria c);

    protected abstract void applySortsTo(MyPasswordResetCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaPasswordReset getMeta()
    {
        return MyPasswordReset.Meta;
    }

    @Override
    protected MyPasswordResetDao getDao()
    {
        return getAccess().getPasswordResetDao();
    }

    @Override
    protected MyPasswordResetCriteria createCriteria()
    {
        return new MyPasswordResetCriteria(_createCriteria());
    }
}
