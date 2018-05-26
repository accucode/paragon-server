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

public abstract class MyFieldTestDaoBase
    extends MyAbstractDao<MyFieldTest,String>
    implements MyFieldTestDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyFieldTestDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyFieldTest> getPersistentClass()
    {
        return MyFieldTest.class;
    }

    @Override
    protected String getTableName()
    {
        return "fieldTest";
    }

    @Override
    public MyFieldTestCriteria createCriteria()
    {
        return new MyFieldTestCriteria(_createCriteria());
    }

    @Override
    public MyFieldTestCriteria createDetachedCriteria(String alias)
    {
        return new MyFieldTestCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaFieldTest getMeta()
    {
        return MyFieldTest.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyFieldTest findUid(String e)
    {
        return getKey(e);
    }

    /**
     * Find the keys.
     * The resulting list may have a DIFFERENT size and sequence.
     */
    public KmList<MyFieldTest> findUids(KmList<String> uids)
    {
        return findUids(uids, false);
    }

    /**
     * Find the keys.
     * The resulting list will have the SAME size and sequence.
     */
    public KmList<MyFieldTest> findOrderedUids(KmList<String> uids)
    {
        return findUids(uids, true);
    }

    public KmList<MyFieldTest> findUids(KmList<String> uids, boolean ordered)
    {
        MyFieldTestCriteria c;
        c = createCriteria();
        c.whereUid().isIn(uids);
        KmList<MyFieldTest> v = c.findAll();

        return ordered
            ? v.toOrderedList(uids, e -> e.getUid())
            : v;
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyFieldTest m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }
}
