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

public abstract class MyPriorityDaoBase
    extends MyAbstractDao<MyPriority,String>
    implements MyPriorityDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyPriorityDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyPriority> getPersistentClass()
    {
        return MyPriority.class;
    }

    @Override
    protected String getTableName()
    {
        return "priority";
    }

    @Override
    public MyPriorityCriteria createCriteria()
    {
        return new MyPriorityCriteria(_createCriteria());
    }

    @Override
    public MyPriorityCriteria createDetachedCriteria(String alias)
    {
        return new MyPriorityCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaPriority getMeta()
    {
        return MyPriority.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyPriority findUid(String e)
    {
        return getKey(e);
    }

    /**
     * Find the keys.
     * The resulting list may have a DIFFERENT size and sequence.
     */
    public KmList<MyPriority> findUids(KmList<String> uids)
    {
        return findUids(uids, false);
    }

    /**
     * Find the keys.
     * The resulting list will have the SAME size and sequence.
     */
    public KmList<MyPriority> findOrderedUids(KmList<String> uids)
    {
        return findUids(uids, true);
    }

    public KmList<MyPriority> findUids(KmList<String> uids, boolean ordered)
    {
        MyPriorityCriteria c;
        c = createCriteria();
        c.whereUid().isIn(uids);
        KmList<MyPriority> v = c.findAll();

        return ordered
            ? v.toOrderedList(uids, e -> e.getUid())
            : v;
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyPriority m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }
}
