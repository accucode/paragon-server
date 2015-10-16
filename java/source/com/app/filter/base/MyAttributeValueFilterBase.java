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

public abstract class MyAttributeValueFilterBase
    extends MyBasicFilter<MyAttributeValue>
    implements MyAttributeValueDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyAttributeValue> c)
    {
        applyConditionsTo((MyAttributeValueCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyAttributeValue> c)
    {
        applySortsTo((MyAttributeValueCriteria)c);
    }

    protected abstract void applyConditionsTo(MyAttributeValueCriteria c);

    protected abstract void applySortsTo(MyAttributeValueCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaAttributeValue getMeta()
    {
        return MyAttributeValue.Meta;
    }

    @Override
    protected MyAttributeValueDao getDao()
    {
        return getAccess().getAttributeValueDao();
    }

    @Override
    protected MyAttributeValueCriteria createCriteria()
    {
        return new MyAttributeValueCriteria(_createCriteria());
    }
}
