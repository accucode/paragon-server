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

public abstract class MyProjectDaoBase
    extends MyAbstractDao<MyProject,String>
    implements MyProjectDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyProjectDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyProject> getPersistentClass()
    {
        return MyProject.class;
    }

    @Override
    protected String getTableName()
    {
        return "project";
    }

    @Override
    public MyProjectCriteria createCriteria()
    {
        return new MyProjectCriteria(_createCriteria());
    }

    @Override
    public MyProjectCriteria createDetachedCriteria(String alias)
    {
        return new MyProjectCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaProject getMeta()
    {
        return MyProject.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyProject findUid(String e)
    {
        return getKey(e);
    }

    /**
     * Find the keys.
     * The resulting list may have a DIFFERENT size and sequence.
     */
    public KmList<MyProject> findUids(KmList<String> uids)
    {
        return findUids(uids, false);
    }

    /**
     * Find the keys.
     * The resulting list will have the SAME size and sequence.
     */
    public KmList<MyProject> findOrderedUids(KmList<String> uids)
    {
        return findUids(uids, true);
    }

    public KmList<MyProject> findUids(KmList<String> uids, boolean ordered)
    {
        MyProjectCriteria c;
        c = createCriteria();
        c.whereUid().isIn(uids);
        KmList<MyProject> v = c.findAll();

        return ordered
            ? v.toOrderedList(uids, e -> e.getUid())
            : v;
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyProject m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }
}
