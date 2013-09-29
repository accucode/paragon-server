//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.filter.base;

import com.app.criteria.MyEmailPartCriteria;
import com.app.dao.MyEmailPartDao;
import com.app.dao.base.MyEmailPartDaoConstantsIF;
import com.app.filter.core.MyBasicFilter;
import com.app.model.MyEmailPart;
import com.app.model.meta.MyMetaEmailPart;

import com.kodemore.hibernate.criteria.KmModelCriteria;

public abstract class MyEmailPartFilterBase
    extends MyBasicFilter<MyEmailPart>
    implements MyEmailPartDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MyEmailPart> c)
    {
        applyConditionsTo((MyEmailPartCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MyEmailPart> c)
    {
        applySortsTo((MyEmailPartCriteria)c);
    }

    protected abstract void applyConditionsTo(MyEmailPartCriteria c);

    protected abstract void applySortsTo(MyEmailPartCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaEmailPart getMeta()
    {
        return MyEmailPart.Meta;
    }

    @Override
    protected MyEmailPartDao getDao()
    {
        return getAccess().getEmailPartDao();
    }

    @Override
    protected MyEmailPartCriteria createCriteria()
    {
        return new MyEmailPartCriteria(createGenericCriteria());
    }
}
