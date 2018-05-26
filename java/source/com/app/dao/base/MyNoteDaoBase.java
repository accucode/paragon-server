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

public abstract class MyNoteDaoBase
    extends MyAbstractDao<MyNote,String>
    implements MyNoteDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyNoteDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyNote> getPersistentClass()
    {
        return MyNote.class;
    }

    @Override
    protected String getTableName()
    {
        return "note";
    }

    @Override
    public MyNoteCriteria createCriteria()
    {
        return new MyNoteCriteria(_createCriteria());
    }

    @Override
    public MyNoteCriteria createDetachedCriteria(String alias)
    {
        return new MyNoteCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaNote getMeta()
    {
        return MyNote.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyNote findUid(String e)
    {
        return getKey(e);
    }

    /**
     * Find the keys.
     * The resulting list may have a DIFFERENT size and sequence.
     */
    public KmList<MyNote> findUids(KmList<String> uids)
    {
        return findUids(uids, false);
    }

    /**
     * Find the keys.
     * The resulting list will have the SAME size and sequence.
     */
    public KmList<MyNote> findOrderedUids(KmList<String> uids)
    {
        return findUids(uids, true);
    }

    public KmList<MyNote> findUids(KmList<String> uids, boolean ordered)
    {
        MyNoteCriteria c;
        c = createCriteria();
        c.whereUid().isIn(uids);
        KmList<MyNote> v = c.findAll();

        return ordered
            ? v.toOrderedList(uids, e -> e.getUid())
            : v;
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyNote m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }
}
