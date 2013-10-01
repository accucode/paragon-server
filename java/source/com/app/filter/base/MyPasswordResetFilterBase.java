//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.filter.base;

import com.app.criteria.MyPasswordResetCriteria;
import com.app.dao.MyPasswordResetDao;
import com.app.dao.base.MyPasswordResetDaoConstantsIF;
import com.app.filter.core.MyBasicFilter;
import com.app.model.MyPasswordReset;
import com.app.model.meta.MyMetaPasswordReset;

import com.kodemore.hibernate.criteria.KmModelCriteria;

public abstract class MyPasswordResetFilterBase
    extends MyBasicFilter<MyPasswordReset>
    implements MyPasswordResetDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MyPasswordReset> c)
    {
        applyConditionsTo((MyPasswordResetCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MyPasswordReset> c)
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
        return new MyPasswordResetCriteria(createGenericCriteria());
    }
}
