//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.dao.base;

import com.kodemore.collection.*;
import com.kodemore.dao.*;
import com.kodemore.utility.*;

import com.app.criteria.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.meta.*;

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
        return new MyHibernateCacheTestCriteria(_createCriteria());
    }

    @Override
    public MyHibernateCacheTestCriteria createDetachedCriteria(String alias)
    {
        return new MyHibernateCacheTestCriteria(_createDetachedCriteria(alias));
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
