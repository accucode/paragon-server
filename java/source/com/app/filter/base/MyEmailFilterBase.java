//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.filter.base;

import com.kodemore.hibernate.criteria.KmModelCriteria;

import com.app.criteria.MyEmailCriteria;
import com.app.dao.MyEmailDao;
import com.app.dao.base.MyEmailDaoConstantsIF;
import com.app.filter.core.MyBasicFilter;
import com.app.model.MyEmail;
import com.app.model.meta.MyMetaEmail;

public abstract class MyEmailFilterBase
    extends MyBasicFilter<MyEmail>
    implements MyEmailDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MyEmail> c)
    {
        applyConditionsTo((MyEmailCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MyEmail> c)
    {
        applySortsTo((MyEmailCriteria)c);
    }

    protected abstract void applyConditionsTo(MyEmailCriteria c);

    protected abstract void applySortsTo(MyEmailCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaEmail getMeta()
    {
        return MyEmail.Meta;
    }

    @Override
    protected MyEmailDao getDao()
    {
        return getAccess().getEmailDao();
    }

    @Override
    protected MyEmailCriteria createCriteria()
    {
        return new MyEmailCriteria(createGenericCriteria());
    }
}
