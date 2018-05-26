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

public abstract class MyAutoLoginDaoBase
    extends MyAbstractDao<MyAutoLogin,String>
    implements MyAutoLoginDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyAutoLoginDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyAutoLogin> getPersistentClass()
    {
        return MyAutoLogin.class;
    }

    @Override
    protected String getTableName()
    {
        return "autoLogin";
    }

    @Override
    public MyAutoLoginCriteria createCriteria()
    {
        return new MyAutoLoginCriteria(_createCriteria());
    }

    @Override
    public MyAutoLoginCriteria createDetachedCriteria(String alias)
    {
        return new MyAutoLoginCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaAutoLogin getMeta()
    {
        return MyAutoLogin.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyAutoLogin findUid(String e)
    {
        return getKey(e);
    }

    /**
     * Find the keys.
     * The resulting list may have a DIFFERENT size and sequence.
     */
    public KmList<MyAutoLogin> findUids(KmList<String> uids)
    {
        return findUids(uids, false);
    }

    /**
     * Find the keys.
     * The resulting list will have the SAME size and sequence.
     */
    public KmList<MyAutoLogin> findOrderedUids(KmList<String> uids)
    {
        return findUids(uids, true);
    }

    public KmList<MyAutoLogin> findUids(KmList<String> uids, boolean ordered)
    {
        MyAutoLoginCriteria c;
        c = createCriteria();
        c.whereUid().isIn(uids);
        KmList<MyAutoLogin> v = c.findAll();

        return ordered
            ? v.toOrderedList(uids, e -> e.getUid())
            : v;
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyAutoLogin m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }
}
