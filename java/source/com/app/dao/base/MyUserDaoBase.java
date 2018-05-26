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

public abstract class MyUserDaoBase
    extends MyAbstractDao<MyUser,String>
    implements MyUserDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyUserDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyUser> getPersistentClass()
    {
        return MyUser.class;
    }

    @Override
    protected String getTableName()
    {
        return "user";
    }

    @Override
    public MyUserCriteria createCriteria()
    {
        return new MyUserCriteria(_createCriteria());
    }

    @Override
    public MyUserCriteria createDetachedCriteria(String alias)
    {
        return new MyUserCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaUser getMeta()
    {
        return MyUser.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyUser findUid(String e)
    {
        return getKey(e);
    }

    /**
     * Find the keys.
     * The resulting list may have a DIFFERENT size and sequence.
     */
    public KmList<MyUser> findUids(KmList<String> uids)
    {
        return findUids(uids, false);
    }

    /**
     * Find the keys.
     * The resulting list will have the SAME size and sequence.
     */
    public KmList<MyUser> findOrderedUids(KmList<String> uids)
    {
        return findUids(uids, true);
    }

    public KmList<MyUser> findUids(KmList<String> uids, boolean ordered)
    {
        MyUserCriteria c;
        c = createCriteria();
        c.whereUid().isIn(uids);
        KmList<MyUser> v = c.findAll();

        return ordered
            ? v.toOrderedList(uids, e -> e.getUid())
            : v;
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyUser m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }
}
