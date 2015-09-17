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

public abstract class MyEmailRecipientFilterBase
    extends MyBasicFilter<MyEmailRecipient>
    implements MyEmailRecipientDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyEmailRecipient> c)
    {
        applyConditionsTo((MyEmailRecipientCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyEmailRecipient> c)
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
        return new MyEmailRecipientCriteria(_createCriteria());
    }
}
