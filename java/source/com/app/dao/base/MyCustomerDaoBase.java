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

public abstract class MyCustomerDaoBase
    extends MyAbstractDao<MyCustomer,String>
    implements MyCustomerDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyCustomerDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyCustomer> getPersistentClass()
    {
        return MyCustomer.class;
    }

    @Override
    protected String getTableName()
    {
        return "customer";
    }

    @Override
    public MyCustomerCriteria createCriteria()
    {
        return new MyCustomerCriteria(_createCriteria());
    }

    @Override
    public MyCustomerCriteria createDetachedCriteria(String alias)
    {
        return new MyCustomerCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaCustomer getMeta()
    {
        return MyCustomer.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyCustomer findUid(String e)
    {
        return getKey(e);
    }

    /**
     * Find the keys.
     * The resulting list may have a DIFFERENT size and sequence.
     */
    public KmList<MyCustomer> findUids(KmList<String> uids)
    {
        return findUids(uids, false);
    }

    /**
     * Find the keys.
     * The resulting list will have the SAME size and sequence.
     */
    public KmList<MyCustomer> findOrderedUids(KmList<String> uids)
    {
        return findUids(uids, true);
    }

    public KmList<MyCustomer> findUids(KmList<String> uids, boolean ordered)
    {
        MyCustomerCriteria c;
        c = createCriteria();
        c.whereUid().isIn(uids);
        KmList<MyCustomer> v = c.findAll();

        return ordered
            ? v.toOrderedList(uids, e -> e.getUid())
            : v;
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyCustomer m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }
}
