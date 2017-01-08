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

public abstract class MyAutoLoginFilterBase
    extends MyBasicFilter<MyAutoLogin>
    implements MyAutoLoginDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyAutoLogin> c)
    {
        applyConditionsTo((MyAutoLoginCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyAutoLogin> c)
    {
        applySortsTo((MyAutoLoginCriteria)c);
    }

    protected abstract void applyConditionsTo(MyAutoLoginCriteria c);

    protected abstract void applySortsTo(MyAutoLoginCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaAutoLogin getMeta()
    {
        return MyAutoLogin.Meta;
    }

    @Override
    protected MyAutoLoginDao getDao()
    {
        return getAccess().getAutoLoginDao();
    }

    @Override
    protected MyAutoLoginCriteria createCriteria()
    {
        return new MyAutoLoginCriteria(_createCriteria());
    }
}
