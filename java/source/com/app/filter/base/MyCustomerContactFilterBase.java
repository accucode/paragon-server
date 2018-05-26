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

public abstract class MyCustomerContactFilterBase
    extends MyBasicFilter<MyCustomerContact>
    implements MyCustomerContactDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyCustomerContact> c)
    {
        applyConditionsTo((MyCustomerContactCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyCustomerContact> c)
    {
        applySortsTo((MyCustomerContactCriteria)c);
    }

    protected abstract void applyConditionsTo(MyCustomerContactCriteria c);

    protected abstract void applySortsTo(MyCustomerContactCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaCustomerContact getMeta()
    {
        return MyCustomerContact.Meta;
    }

    @Override
    protected MyCustomerContactDao getDao()
    {
        return getAccess().getCustomerContactDao();
    }

    @Override
    protected MyCustomerContactCriteria createCriteria()
    {
        return new MyCustomerContactCriteria(_createCriteria());
    }
}
