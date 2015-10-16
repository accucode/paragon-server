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

public abstract class MyAttributeFieldFilterBase
    extends MyBasicFilter<MyAttributeField>
    implements MyAttributeFieldDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyAttributeField> c)
    {
        applyConditionsTo((MyAttributeFieldCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyAttributeField> c)
    {
        applySortsTo((MyAttributeFieldCriteria)c);
    }

    protected abstract void applyConditionsTo(MyAttributeFieldCriteria c);

    protected abstract void applySortsTo(MyAttributeFieldCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaAttributeField getMeta()
    {
        return MyAttributeField.Meta;
    }

    @Override
    protected MyAttributeFieldDao getDao()
    {
        return getAccess().getAttributeFieldDao();
    }

    @Override
    protected MyAttributeFieldCriteria createCriteria()
    {
        return new MyAttributeFieldCriteria(_createCriteria());
    }
}
