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
import com.app.dao.base.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.meta.*;
import com.app.utility.*;

public abstract class MyHibernateCacheTestDaoBase
    extends MyAbstractDao<MyHibernateCacheTest,String>
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

    /**
     * Find the keys.
     * The resulting list may have a DIFFERENT size and sequence.
     */
    public KmList<MyHibernateCacheTest> findUids(KmList<String> uids)
    {
        return findUids(uids, false);
    }

    /**
     * Find the keys.
     * The resulting list will have the SAME size and sequence.
     */
    public KmList<MyHibernateCacheTest> findOrderedUids(KmList<String> uids)
    {
        return findUids(uids, true);
    }

    public KmList<MyHibernateCacheTest> findUids(KmList<String> uids, boolean ordered)
    {
        MyHibernateCacheTestCriteria c;
        c = createCriteria();
        c.whereUid().isIn(uids);
        KmList<MyHibernateCacheTest> v = c.findAll();

        return ordered
            ? v.toOrderedList(uids, e -> e.getUid())
            : v;
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
