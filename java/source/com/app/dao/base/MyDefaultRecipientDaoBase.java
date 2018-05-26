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

public abstract class MyDefaultRecipientDaoBase
    extends MyAbstractDao<MyDefaultRecipient,String>
    implements MyDefaultRecipientDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyDefaultRecipientDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyDefaultRecipient> getPersistentClass()
    {
        return MyDefaultRecipient.class;
    }

    @Override
    protected String getTableName()
    {
        return "defaultRecipient";
    }

    @Override
    public MyDefaultRecipientCriteria createCriteria()
    {
        return new MyDefaultRecipientCriteria(_createCriteria());
    }

    @Override
    public MyDefaultRecipientCriteria createDetachedCriteria(String alias)
    {
        return new MyDefaultRecipientCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaDefaultRecipient getMeta()
    {
        return MyDefaultRecipient.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyDefaultRecipient findUid(String e)
    {
        return getKey(e);
    }

    /**
     * Find the keys.
     * The resulting list may have a DIFFERENT size and sequence.
     */
    public KmList<MyDefaultRecipient> findUids(KmList<String> uids)
    {
        return findUids(uids, false);
    }

    /**
     * Find the keys.
     * The resulting list will have the SAME size and sequence.
     */
    public KmList<MyDefaultRecipient> findOrderedUids(KmList<String> uids)
    {
        return findUids(uids, true);
    }

    public KmList<MyDefaultRecipient> findUids(KmList<String> uids, boolean ordered)
    {
        MyDefaultRecipientCriteria c;
        c = createCriteria();
        c.whereUid().isIn(uids);
        KmList<MyDefaultRecipient> v = c.findAll();

        return ordered
            ? v.toOrderedList(uids, e -> e.getUid())
            : v;
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyDefaultRecipient m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }
}
