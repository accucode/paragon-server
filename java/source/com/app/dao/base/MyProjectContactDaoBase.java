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

public abstract class MyProjectContactDaoBase
    extends MyAbstractDao<MyProjectContact,String>
    implements MyProjectContactDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyProjectContactDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyProjectContact> getPersistentClass()
    {
        return MyProjectContact.class;
    }

    @Override
    protected String getTableName()
    {
        return "projectContact";
    }

    @Override
    public MyProjectContactCriteria createCriteria()
    {
        return new MyProjectContactCriteria(_createCriteria());
    }

    @Override
    public MyProjectContactCriteria createDetachedCriteria(String alias)
    {
        return new MyProjectContactCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaProjectContact getMeta()
    {
        return MyProjectContact.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyProjectContact findUid(String e)
    {
        return getKey(e);
    }

    /**
     * Find the keys.
     * The resulting list may have a DIFFERENT size and sequence.
     */
    public KmList<MyProjectContact> findUids(KmList<String> uids)
    {
        return findUids(uids, false);
    }

    /**
     * Find the keys.
     * The resulting list will have the SAME size and sequence.
     */
    public KmList<MyProjectContact> findOrderedUids(KmList<String> uids)
    {
        return findUids(uids, true);
    }

    public KmList<MyProjectContact> findUids(KmList<String> uids, boolean ordered)
    {
        MyProjectContactCriteria c;
        c = createCriteria();
        c.whereUid().isIn(uids);
        KmList<MyProjectContact> v = c.findAll();

        return ordered
            ? v.toOrderedList(uids, e -> e.getUid())
            : v;
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyProjectContact m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }
}
