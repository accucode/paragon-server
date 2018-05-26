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

public abstract class MyAuditBundleDaoBase
    extends MyAbstractDao<MyAuditBundle,String>
    implements MyAuditBundleDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyAuditBundleDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyAuditBundle> getPersistentClass()
    {
        return MyAuditBundle.class;
    }

    @Override
    protected String getTableName()
    {
        return "auditBundle";
    }

    @Override
    public MyAuditBundleCriteria createCriteria()
    {
        return new MyAuditBundleCriteria(_createCriteria());
    }

    @Override
    public MyAuditBundleCriteria createDetachedCriteria(String alias)
    {
        return new MyAuditBundleCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaAuditBundle getMeta()
    {
        return MyAuditBundle.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyAuditBundle findUid(String e)
    {
        return getKey(e);
    }

    /**
     * Find the keys.
     * The resulting list may have a DIFFERENT size and sequence.
     */
    public KmList<MyAuditBundle> findUids(KmList<String> uids)
    {
        return findUids(uids, false);
    }

    /**
     * Find the keys.
     * The resulting list will have the SAME size and sequence.
     */
    public KmList<MyAuditBundle> findOrderedUids(KmList<String> uids)
    {
        return findUids(uids, true);
    }

    public KmList<MyAuditBundle> findUids(KmList<String> uids, boolean ordered)
    {
        MyAuditBundleCriteria c;
        c = createCriteria();
        c.whereUid().isIn(uids);
        KmList<MyAuditBundle> v = c.findAll();

        return ordered
            ? v.toOrderedList(uids, e -> e.getUid())
            : v;
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyAuditBundle m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }
}
