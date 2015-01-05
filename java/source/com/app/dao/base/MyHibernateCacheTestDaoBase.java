//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.dao.base;

import com.kodemore.dao.KmAbstractDao;
import com.kodemore.utility.Kmu;

import com.app.criteria.MyHibernateCacheTestCriteria;
import com.app.model.MyHibernateCacheTest;
import com.app.model.meta.MyMetaHibernateCacheTest;

public abstract class MyHibernateCacheTestDaoBase
    extends KmAbstractDao<MyHibernateCacheTest,String>
    implements MyHibernateCacheTestDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyHibernateCacheTestDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyHibernateCacheTest> getPersistentClass()
    {
        return MyHibernateCacheTest.class;
    }

    @Override
    protected String getTableName()
    {
        return "hibernateCacheTest";
    }

    @Override
    public MyHibernateCacheTestCriteria createCriteria()
    {
        return new MyHibernateCacheTestCriteria(createGenericCriteria());
    }

    protected MyMetaHibernateCacheTest getMeta()
    {
        return MyHibernateCacheTest.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyHibernateCacheTest findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyHibernateCacheTest m = findUid(e);
        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);
        delete(m);
    }

}
