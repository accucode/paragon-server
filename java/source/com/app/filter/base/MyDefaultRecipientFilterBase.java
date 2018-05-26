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

public abstract class MyDefaultRecipientFilterBase
    extends MyBasicFilter<MyDefaultRecipient>
    implements MyDefaultRecipientDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyDefaultRecipient> c)
    {
        applyConditionsTo((MyDefaultRecipientCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyDefaultRecipient> c)
    {
        applySortsTo((MyDefaultRecipientCriteria)c);
    }

    protected abstract void applyConditionsTo(MyDefaultRecipientCriteria c);

    protected abstract void applySortsTo(MyDefaultRecipientCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaDefaultRecipient getMeta()
    {
        return MyDefaultRecipient.Meta;
    }

    @Override
    protected MyDefaultRecipientDao getDao()
    {
        return getAccess().getDefaultRecipientDao();
    }

    @Override
    protected MyDefaultRecipientCriteria createCriteria()
    {
        return new MyDefaultRecipientCriteria(_createCriteria());
    }
}
