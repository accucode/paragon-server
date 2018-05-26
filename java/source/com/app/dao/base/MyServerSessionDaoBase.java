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

public abstract class MyServerSessionDaoBase
    extends MyAbstractDao<MyServerSession,String>
    implements MyServerSessionDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyServerSessionDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyServerSession> getPersistentClass()
    {
        return MyServerSession.class;
    }

    @Override
    protected String getTableName()
    {
        return "serverSession";
    }

    @Override
    public MyServerSessionCriteria createCriteria()
    {
        return new MyServerSessionCriteria(_createCriteria());
    }

    @Override
    public MyServerSessionCriteria createDetachedCriteria(String alias)
    {
        return new MyServerSessionCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaServerSession getMeta()
    {
        return MyServerSession.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyServerSession findUid(String e)
    {
        return getKey(e);
    }

    /**
     * Find the keys.
     * The resulting list may have a DIFFERENT size and sequence.
     */
    public KmList<MyServerSession> findUids(KmList<String> uids)
    {
        return findUids(uids, false);
    }

    /**
     * Find the keys.
     * The resulting list will have the SAME size and sequence.
     */
    public KmList<MyServerSession> findOrderedUids(KmList<String> uids)
    {
        return findUids(uids, true);
    }

    public KmList<MyServerSession> findUids(KmList<String> uids, boolean ordered)
    {
        MyServerSessionCriteria c;
        c = createCriteria();
        c.whereUid().isIn(uids);
        KmList<MyServerSession> v = c.findAll();

        return ordered
            ? v.toOrderedList(uids, e -> e.getUid())
            : v;
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyServerSession m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }
}
