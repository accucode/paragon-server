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

public abstract class MyFieldTestFilterBase
    extends MyBasicFilter<MyFieldTest>
    implements MyFieldTestDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmhModelCriteria<MyFieldTest> c)
    {
        applyConditionsTo((MyFieldTestCriteria)c);
    }

    @Override
    protected void applySortsTo(KmhModelCriteria<MyFieldTest> c)
    {
        applySortsTo((MyFieldTestCriteria)c);
    }

    protected abstract void applyConditionsTo(MyFieldTestCriteria c);

    protected abstract void applySortsTo(MyFieldTestCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaFieldTest getMeta()
    {
        return MyFieldTest.Meta;
    }

    @Override
    protected MyFieldTestDao getDao()
    {
        return getAccess().getFieldTestDao();
    }

    @Override
    protected MyFieldTestCriteria createCriteria()
    {
        return new MyFieldTestCriteria(_createCriteria());
    }
}
