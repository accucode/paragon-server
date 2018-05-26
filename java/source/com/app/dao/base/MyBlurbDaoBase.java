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

public abstract class MyBlurbDaoBase
    extends MyAbstractDao<MyBlurb,String>
    implements MyBlurbDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyBlurbDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyBlurb> getPersistentClass()
    {
        return MyBlurb.class;
    }

    @Override
    protected String getTableName()
    {
        return "blurb";
    }

    @Override
    public MyBlurbCriteria createCriteria()
    {
        return new MyBlurbCriteria(_createCriteria());
    }

    @Override
    public MyBlurbCriteria createDetachedCriteria(String alias)
    {
        return new MyBlurbCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaBlurb getMeta()
    {
        return MyBlurb.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyBlurb findUid(String e)
    {
        return getKey(e);
    }

    /**
     * Find the keys.
     * The resulting list may have a DIFFERENT size and sequence.
     */
    public KmList<MyBlurb> findUids(KmList<String> uids)
    {
        return findUids(uids, false);
    }

    /**
     * Find the keys.
     * The resulting list will have the SAME size and sequence.
     */
    public KmList<MyBlurb> findOrderedUids(KmList<String> uids)
    {
        return findUids(uids, true);
    }

    public KmList<MyBlurb> findUids(KmList<String> uids, boolean ordered)
    {
        MyBlurbCriteria c;
        c = createCriteria();
        c.whereUid().isIn(uids);
        KmList<MyBlurb> v = c.findAll();

        return ordered
            ? v.toOrderedList(uids, e -> e.getUid())
            : v;
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyBlurb m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }
}
