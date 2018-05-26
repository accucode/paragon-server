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

public abstract class MySiteContactDaoBase
    extends MyAbstractDao<MySiteContact,String>
    implements MySiteContactDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MySiteContactDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MySiteContact> getPersistentClass()
    {
        return MySiteContact.class;
    }

    @Override
    protected String getTableName()
    {
        return "siteContact";
    }

    @Override
    public MySiteContactCriteria createCriteria()
    {
        return new MySiteContactCriteria(_createCriteria());
    }

    @Override
    public MySiteContactCriteria createDetachedCriteria(String alias)
    {
        return new MySiteContactCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaSiteContact getMeta()
    {
        return MySiteContact.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MySiteContact findUid(String e)
    {
        return getKey(e);
    }

    /**
     * Find the keys.
     * The resulting list may have a DIFFERENT size and sequence.
     */
    public KmList<MySiteContact> findUids(KmList<String> uids)
    {
        return findUids(uids, false);
    }

    /**
     * Find the keys.
     * The resulting list will have the SAME size and sequence.
     */
    public KmList<MySiteContact> findOrderedUids(KmList<String> uids)
    {
        return findUids(uids, true);
    }

    public KmList<MySiteContact> findUids(KmList<String> uids, boolean ordered)
    {
        MySiteContactCriteria c;
        c = createCriteria();
        c.whereUid().isIn(uids);
        KmList<MySiteContact> v = c.findAll();

        return ordered
            ? v.toOrderedList(uids, e -> e.getUid())
            : v;
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MySiteContact m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }
}
