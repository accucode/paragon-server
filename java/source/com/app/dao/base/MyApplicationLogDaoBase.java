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

public abstract class MyApplicationLogDaoBase
    extends MyAbstractDao<MyApplicationLog,String>
    implements MyApplicationLogDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyApplicationLogDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyApplicationLog> getPersistentClass()
    {
        return MyApplicationLog.class;
    }

    @Override
    protected String getTableName()
    {
        return "applicationLog";
    }

    @Override
    public MyApplicationLogCriteria createCriteria()
    {
        return new MyApplicationLogCriteria(_createCriteria());
    }

    @Override
    public MyApplicationLogCriteria createDetachedCriteria(String alias)
    {
        return new MyApplicationLogCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaApplicationLog getMeta()
    {
        return MyApplicationLog.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyApplicationLog findUid(String e)
    {
        return getKey(e);
    }

    /**
     * Find the keys.
     * The resulting list may have a DIFFERENT size and sequence.
     */
    public KmList<MyApplicationLog> findUids(KmList<String> uids)
    {
        return findUids(uids, false);
    }

    /**
     * Find the keys.
     * The resulting list will have the SAME size and sequence.
     */
    public KmList<MyApplicationLog> findOrderedUids(KmList<String> uids)
    {
        return findUids(uids, true);
    }

    public KmList<MyApplicationLog> findUids(KmList<String> uids, boolean ordered)
    {
        MyApplicationLogCriteria c;
        c = createCriteria();
        c.whereUid().isIn(uids);
        KmList<MyApplicationLog> v = c.findAll();

        return ordered
            ? v.toOrderedList(uids, e -> e.getUid())
            : v;
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyApplicationLog m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }
}
