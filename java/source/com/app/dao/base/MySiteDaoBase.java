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

public abstract class MySiteDaoBase
    extends MyAbstractDao<MySite,String>
    implements MySiteDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MySiteDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MySite> getPersistentClass()
    {
        return MySite.class;
    }

    @Override
    protected String getTableName()
    {
        return "site";
    }

    @Override
    public MySiteCriteria createCriteria()
    {
        return new MySiteCriteria(_createCriteria());
    }

    @Override
    public MySiteCriteria createDetachedCriteria(String alias)
    {
        return new MySiteCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaSite getMeta()
    {
        return MySite.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MySite findUid(String e)
    {
        return getKey(e);
    }

    /**
     * Find the keys.
     * The resulting list may have a DIFFERENT size and sequence.
     */
    public KmList<MySite> findUids(KmList<String> uids)
    {
        return findUids(uids, false);
    }

    /**
     * Find the keys.
     * The resulting list will have the SAME size and sequence.
     */
    public KmList<MySite> findOrderedUids(KmList<String> uids)
    {
        return findUids(uids, true);
    }

    public KmList<MySite> findUids(KmList<String> uids, boolean ordered)
    {
        MySiteCriteria c;
        c = createCriteria();
        c.whereUid().isIn(uids);
        KmList<MySite> v = c.findAll();

        return ordered
            ? v.toOrderedList(uids, e -> e.getUid())
            : v;
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MySite m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }
}
