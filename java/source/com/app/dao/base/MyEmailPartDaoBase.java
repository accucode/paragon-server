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

public abstract class MyEmailPartDaoBase
    extends MyAbstractDao<MyEmailPart,String>
    implements MyEmailPartDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyEmailPartDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyEmailPart> getPersistentClass()
    {
        return MyEmailPart.class;
    }

    @Override
    protected String getTableName()
    {
        return "emailPart";
    }

    @Override
    public MyEmailPartCriteria createCriteria()
    {
        return new MyEmailPartCriteria(_createCriteria());
    }

    @Override
    public MyEmailPartCriteria createDetachedCriteria(String alias)
    {
        return new MyEmailPartCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaEmailPart getMeta()
    {
        return MyEmailPart.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyEmailPart findUid(String e)
    {
        return getKey(e);
    }

    /**
     * Find the keys.
     * The resulting list may have a DIFFERENT size and sequence.
     */
    public KmList<MyEmailPart> findUids(KmList<String> uids)
    {
        return findUids(uids, false);
    }

    /**
     * Find the keys.
     * The resulting list will have the SAME size and sequence.
     */
    public KmList<MyEmailPart> findOrderedUids(KmList<String> uids)
    {
        return findUids(uids, true);
    }

    public KmList<MyEmailPart> findUids(KmList<String> uids, boolean ordered)
    {
        MyEmailPartCriteria c;
        c = createCriteria();
        c.whereUid().isIn(uids);
        KmList<MyEmailPart> v = c.findAll();

        return ordered
            ? v.toOrderedList(uids, e -> e.getUid())
            : v;
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyEmailPart m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }
}
