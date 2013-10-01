//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.filter.base;

import com.app.criteria.MyEmailRecipientCriteria;
import com.app.dao.MyEmailRecipientDao;
import com.app.dao.base.MyEmailRecipientDaoConstantsIF;
import com.app.filter.core.MyBasicFilter;
import com.app.model.MyEmailRecipient;
import com.app.model.meta.MyMetaEmailRecipient;

import com.kodemore.hibernate.criteria.KmModelCriteria;

public abstract class MyEmailRecipientFilterBase
    extends MyBasicFilter<MyEmailRecipient>
    implements MyEmailRecipientDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MyEmailRecipient> c)
    {
        applyConditionsTo((MyEmailRecipientCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MyEmailRecipient> c)
    {
        applySortsTo((MyEmailRecipientCriteria)c);
    }

    protected abstract void applyConditionsTo(MyEmailRecipientCriteria c);

    protected abstract void applySortsTo(MyEmailRecipientCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaEmailRecipient getMeta()
    {
        return MyEmailRecipient.Meta;
    }

    @Override
    protected MyEmailRecipientDao getDao()
    {
        return getAccess().getEmailRecipientDao();
    }

    @Override
    protected MyEmailRecipientCriteria createCriteria()
    {
        return new MyEmailRecipientCriteria(createGenericCriteria());
    }
}
