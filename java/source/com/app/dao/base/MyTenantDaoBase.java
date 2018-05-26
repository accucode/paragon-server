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

public abstract class MyTenantDaoBase
    extends MyAbstractDao<MyTenant,String>
    implements MyTenantDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyTenantDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyTenant> getPersistentClass()
    {
        return MyTenant.class;
    }

    @Override
    protected String getTableName()
    {
        return "tenant";
    }

    @Override
    public MyTenantCriteria createCriteria()
    {
        return new MyTenantCriteria(_createCriteria());
    }

    @Override
    public MyTenantCriteria createDetachedCriteria(String alias)
    {
        return new MyTenantCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaTenant getMeta()
    {
        return MyTenant.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyTenant findUid(String e)
    {
        return getKey(e);
    }

    /**
     * Find the keys.
     * The resulting list may have a DIFFERENT size and sequence.
     */
    public KmList<MyTenant> findUids(KmList<String> uids)
    {
        return findUids(uids, false);
    }

    /**
     * Find the keys.
     * The resulting list will have the SAME size and sequence.
     */
    public KmList<MyTenant> findOrderedUids(KmList<String> uids)
    {
        return findUids(uids, true);
    }

    public KmList<MyTenant> findUids(KmList<String> uids, boolean ordered)
    {
        MyTenantCriteria c;
        c = createCriteria();
        c.whereUid().isIn(uids);
        KmList<MyTenant> v = c.findAll();

        return ordered
            ? v.toOrderedList(uids, e -> e.getUid())
            : v;
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyTenant m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }
}
