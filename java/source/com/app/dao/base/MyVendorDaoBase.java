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

public abstract class MyVendorDaoBase
    extends MyAbstractDao<MyVendor,String>
    implements MyVendorDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyVendorDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyVendor> getPersistentClass()
    {
        return MyVendor.class;
    }

    @Override
    protected String getTableName()
    {
        return "vendor";
    }

    @Override
    public MyVendorCriteria createCriteria()
    {
        return new MyVendorCriteria(_createCriteria());
    }

    @Override
    public MyVendorCriteria createDetachedCriteria(String alias)
    {
        return new MyVendorCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaVendor getMeta()
    {
        return MyVendor.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyVendor findUid(String e)
    {
        return getKey(e);
    }

    /**
     * Find the keys.
     * The resulting list may have a DIFFERENT size and sequence.
     */
    public KmList<MyVendor> findUids(KmList<String> uids)
    {
        return findUids(uids, false);
    }

    /**
     * Find the keys.
     * The resulting list will have the SAME size and sequence.
     */
    public KmList<MyVendor> findOrderedUids(KmList<String> uids)
    {
        return findUids(uids, true);
    }

    public KmList<MyVendor> findUids(KmList<String> uids, boolean ordered)
    {
        MyVendorCriteria c;
        c = createCriteria();
        c.whereUid().isIn(uids);
        KmList<MyVendor> v = c.findAll();

        return ordered
            ? v.toOrderedList(uids, e -> e.getUid())
            : v;
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyVendor m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }
}
