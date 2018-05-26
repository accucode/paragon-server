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

public abstract class MyCustomerContactDaoBase
    extends MyAbstractDao<MyCustomerContact,String>
    implements MyCustomerContactDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyCustomerContactDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyCustomerContact> getPersistentClass()
    {
        return MyCustomerContact.class;
    }

    @Override
    protected String getTableName()
    {
        return "customerContact";
    }

    @Override
    public MyCustomerContactCriteria createCriteria()
    {
        return new MyCustomerContactCriteria(_createCriteria());
    }

    @Override
    public MyCustomerContactCriteria createDetachedCriteria(String alias)
    {
        return new MyCustomerContactCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaCustomerContact getMeta()
    {
        return MyCustomerContact.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyCustomerContact findUid(String e)
    {
        return getKey(e);
    }

    /**
     * Find the keys.
     * The resulting list may have a DIFFERENT size and sequence.
     */
    public KmList<MyCustomerContact> findUids(KmList<String> uids)
    {
        return findUids(uids, false);
    }

    /**
     * Find the keys.
     * The resulting list will have the SAME size and sequence.
     */
    public KmList<MyCustomerContact> findOrderedUids(KmList<String> uids)
    {
        return findUids(uids, true);
    }

    public KmList<MyCustomerContact> findUids(KmList<String> uids, boolean ordered)
    {
        MyCustomerContactCriteria c;
        c = createCriteria();
        c.whereUid().isIn(uids);
        KmList<MyCustomerContact> v = c.findAll();

        return ordered
            ? v.toOrderedList(uids, e -> e.getUid())
            : v;
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyCustomerContact m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }
}
