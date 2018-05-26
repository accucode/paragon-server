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

public abstract class MyChoiceDaoBase
    extends MyAbstractDao<MyChoice,String>
    implements MyChoiceDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyChoiceDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyChoice> getPersistentClass()
    {
        return MyChoice.class;
    }

    @Override
    protected String getTableName()
    {
        return "choice";
    }

    @Override
    public MyChoiceCriteria createCriteria()
    {
        return new MyChoiceCriteria(_createCriteria());
    }

    @Override
    public MyChoiceCriteria createDetachedCriteria(String alias)
    {
        return new MyChoiceCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaChoice getMeta()
    {
        return MyChoice.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyChoice findUid(String e)
    {
        return getKey(e);
    }

    /**
     * Find the keys.
     * The resulting list may have a DIFFERENT size and sequence.
     */
    public KmList<MyChoice> findUids(KmList<String> uids)
    {
        return findUids(uids, false);
    }

    /**
     * Find the keys.
     * The resulting list will have the SAME size and sequence.
     */
    public KmList<MyChoice> findOrderedUids(KmList<String> uids)
    {
        return findUids(uids, true);
    }

    public KmList<MyChoice> findUids(KmList<String> uids, boolean ordered)
    {
        MyChoiceCriteria c;
        c = createCriteria();
        c.whereUid().isIn(uids);
        KmList<MyChoice> v = c.findAll();

        return ordered
            ? v.toOrderedList(uids, e -> e.getUid())
            : v;
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyChoice m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }
}
