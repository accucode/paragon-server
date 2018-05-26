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

public abstract class MyPasswordResetDaoBase
    extends MyAbstractDao<MyPasswordReset,String>
    implements MyPasswordResetDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyPasswordResetDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyPasswordReset> getPersistentClass()
    {
        return MyPasswordReset.class;
    }

    @Override
    protected String getTableName()
    {
        return "passwordReset";
    }

    @Override
    public MyPasswordResetCriteria createCriteria()
    {
        return new MyPasswordResetCriteria(_createCriteria());
    }

    @Override
    public MyPasswordResetCriteria createDetachedCriteria(String alias)
    {
        return new MyPasswordResetCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaPasswordReset getMeta()
    {
        return MyPasswordReset.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyPasswordReset findUid(String e)
    {
        return getKey(e);
    }

    /**
     * Find the keys.
     * The resulting list may have a DIFFERENT size and sequence.
     */
    public KmList<MyPasswordReset> findUids(KmList<String> uids)
    {
        return findUids(uids, false);
    }

    /**
     * Find the keys.
     * The resulting list will have the SAME size and sequence.
     */
    public KmList<MyPasswordReset> findOrderedUids(KmList<String> uids)
    {
        return findUids(uids, true);
    }

    public KmList<MyPasswordReset> findUids(KmList<String> uids, boolean ordered)
    {
        MyPasswordResetCriteria c;
        c = createCriteria();
        c.whereUid().isIn(uids);
        KmList<MyPasswordReset> v = c.findAll();

        return ordered
            ? v.toOrderedList(uids, e -> e.getUid())
            : v;
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyPasswordReset m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }
}
