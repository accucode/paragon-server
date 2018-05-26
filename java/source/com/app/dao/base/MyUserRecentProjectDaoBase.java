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

public abstract class MyUserRecentProjectDaoBase
    extends MyAbstractDao<MyUserRecentProject,String>
    implements MyUserRecentProjectDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyUserRecentProjectDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyUserRecentProject> getPersistentClass()
    {
        return MyUserRecentProject.class;
    }

    @Override
    protected String getTableName()
    {
        return "userRecentProject";
    }

    @Override
    public MyUserRecentProjectCriteria createCriteria()
    {
        return new MyUserRecentProjectCriteria(_createCriteria());
    }

    @Override
    public MyUserRecentProjectCriteria createDetachedCriteria(String alias)
    {
        return new MyUserRecentProjectCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaUserRecentProject getMeta()
    {
        return MyUserRecentProject.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyUserRecentProject findUid(String e)
    {
        return getKey(e);
    }

    /**
     * Find the keys.
     * The resulting list may have a DIFFERENT size and sequence.
     */
    public KmList<MyUserRecentProject> findUids(KmList<String> uids)
    {
        return findUids(uids, false);
    }

    /**
     * Find the keys.
     * The resulting list will have the SAME size and sequence.
     */
    public KmList<MyUserRecentProject> findOrderedUids(KmList<String> uids)
    {
        return findUids(uids, true);
    }

    public KmList<MyUserRecentProject> findUids(KmList<String> uids, boolean ordered)
    {
        MyUserRecentProjectCriteria c;
        c = createCriteria();
        c.whereUid().isIn(uids);
        KmList<MyUserRecentProject> v = c.findAll();

        return ordered
            ? v.toOrderedList(uids, e -> e.getUid())
            : v;
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyUserRecentProject m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }
}
