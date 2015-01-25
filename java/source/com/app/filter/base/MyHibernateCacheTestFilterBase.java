//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################


package com.app.filter.base;

import com.kodemore.collection.*;
import com.kodemore.hibernate.criteria.*;

import com.app.command.base.*;
import com.app.criteria.*;
import com.app.dao.*;
import com.app.dao.base.*;
import com.app.filter.*;
import com.app.filter.core.*;
import com.app.model.*;
import com.app.model.meta.*;

public abstract class MyHibernateCacheTestFilterBase
    extends MyBasicFilter<MyHibernateCacheTest>
    implements MyHibernateCacheTestDaoConstantsIF
{
    //##################################################
    //# apply
    //##################################################

    @Override
    protected void applyConditionsTo(KmModelCriteria<MyHibernateCacheTest> c)
    {
        applyConditionsTo((MyHibernateCacheTestCriteria)c);
    }

    @Override
    protected void applySortsTo(KmModelCriteria<MyHibernateCacheTest> c)
    {
        applySortsTo((MyHibernateCacheTestCriteria)c);
    }

    protected abstract void applyConditionsTo(MyHibernateCacheTestCriteria c);

    protected abstract void applySortsTo(MyHibernateCacheTestCriteria c);

    //##################################################
    //# support
    //##################################################

    protected MyMetaHibernateCacheTest getMeta()
    {
        return MyHibernateCacheTest.Meta;
    }

    @Override
    protected MyHibernateCacheTestDao getDao()
    {
        return getAccess().getHibernateCacheTestDao();
    }

    @Override
    protected MyHibernateCacheTestCriteria createCriteria()
    {
        return new MyHibernateCacheTestCriteria(createGenericCriteria());
    }
}
