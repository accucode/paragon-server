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

public abstract class MyEmailDaoBase
    extends MyAbstractDao<MyEmail,String>
    implements MyEmailDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyEmailDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyEmail> getPersistentClass()
    {
        return MyEmail.class;
    }

    @Override
    protected String getTableName()
    {
        return "email";
    }

    @Override
    public MyEmailCriteria createCriteria()
    {
        return new MyEmailCriteria(_createCriteria());
    }

    @Override
    public MyEmailCriteria createDetachedCriteria(String alias)
    {
        return new MyEmailCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaEmail getMeta()
    {
        return MyEmail.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyEmail findUid(String e)
    {
        return getKey(e);
    }

    /**
     * Find the keys.
     * The resulting list may have a DIFFERENT size and sequence.
     */
    public KmList<MyEmail> findUids(KmList<String> uids)
    {
        return findUids(uids, false);
    }

    /**
     * Find the keys.
     * The resulting list will have the SAME size and sequence.
     */
    public KmList<MyEmail> findOrderedUids(KmList<String> uids)
    {
        return findUids(uids, true);
    }

    public KmList<MyEmail> findUids(KmList<String> uids, boolean ordered)
    {
        MyEmailCriteria c;
        c = createCriteria();
        c.whereUid().isIn(uids);
        KmList<MyEmail> v = c.findAll();

        return ordered
            ? v.toOrderedList(uids, e -> e.getUid())
            : v;
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyEmail m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }
}
