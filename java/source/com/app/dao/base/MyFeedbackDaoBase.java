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

public abstract class MyFeedbackDaoBase
    extends MyAbstractDao<MyFeedback,String>
    implements MyFeedbackDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyFeedbackDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyFeedback> getPersistentClass()
    {
        return MyFeedback.class;
    }

    @Override
    protected String getTableName()
    {
        return "feedback";
    }

    @Override
    public MyFeedbackCriteria createCriteria()
    {
        return new MyFeedbackCriteria(_createCriteria());
    }

    @Override
    public MyFeedbackCriteria createDetachedCriteria(String alias)
    {
        return new MyFeedbackCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaFeedback getMeta()
    {
        return MyFeedback.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyFeedback findUid(String e)
    {
        return getKey(e);
    }

    /**
     * Find the keys.
     * The resulting list may have a DIFFERENT size and sequence.
     */
    public KmList<MyFeedback> findUids(KmList<String> uids)
    {
        return findUids(uids, false);
    }

    /**
     * Find the keys.
     * The resulting list will have the SAME size and sequence.
     */
    public KmList<MyFeedback> findOrderedUids(KmList<String> uids)
    {
        return findUids(uids, true);
    }

    public KmList<MyFeedback> findUids(KmList<String> uids, boolean ordered)
    {
        MyFeedbackCriteria c;
        c = createCriteria();
        c.whereUid().isIn(uids);
        KmList<MyFeedback> v = c.findAll();

        return ordered
            ? v.toOrderedList(uids, e -> e.getUid())
            : v;
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyFeedback m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }
}
