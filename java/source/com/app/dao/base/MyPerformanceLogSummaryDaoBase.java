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

public abstract class MyPerformanceLogSummaryDaoBase
    extends MyAbstractDao<MyPerformanceLogSummary,String>
    implements MyPerformanceLogSummaryDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyPerformanceLogSummaryDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyPerformanceLogSummary> getPersistentClass()
    {
        return MyPerformanceLogSummary.class;
    }

    @Override
    protected String getTableName()
    {
        return "performanceLogSummary";
    }

    @Override
    public MyPerformanceLogSummaryCriteria createCriteria()
    {
        return new MyPerformanceLogSummaryCriteria(_createCriteria());
    }

    @Override
    public MyPerformanceLogSummaryCriteria createDetachedCriteria(String alias)
    {
        return new MyPerformanceLogSummaryCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaPerformanceLogSummary getMeta()
    {
        return MyPerformanceLogSummary.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyPerformanceLogSummary findUid(String e)
    {
        return getKey(e);
    }

    /**
     * Find the keys.
     * The resulting list may have a DIFFERENT size and sequence.
     */
    public KmList<MyPerformanceLogSummary> findUids(KmList<String> uids)
    {
        return findUids(uids, false);
    }

    /**
     * Find the keys.
     * The resulting list will have the SAME size and sequence.
     */
    public KmList<MyPerformanceLogSummary> findOrderedUids(KmList<String> uids)
    {
        return findUids(uids, true);
    }

    public KmList<MyPerformanceLogSummary> findUids(KmList<String> uids, boolean ordered)
    {
        MyPerformanceLogSummaryCriteria c;
        c = createCriteria();
        c.whereUid().isIn(uids);
        KmList<MyPerformanceLogSummary> v = c.findAll();

        return ordered
            ? v.toOrderedList(uids, e -> e.getUid())
            : v;
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyPerformanceLogSummary m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }
}
