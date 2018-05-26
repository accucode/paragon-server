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

public abstract class MyDownloadDaoBase
    extends MyAbstractDao<MyDownload,String>
    implements MyDownloadDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyDownloadDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyDownload> getPersistentClass()
    {
        return MyDownload.class;
    }

    @Override
    protected String getTableName()
    {
        return "download";
    }

    @Override
    public MyDownloadCriteria createCriteria()
    {
        return new MyDownloadCriteria(_createCriteria());
    }

    @Override
    public MyDownloadCriteria createDetachedCriteria(String alias)
    {
        return new MyDownloadCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaDownload getMeta()
    {
        return MyDownload.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyDownload findUid(String e)
    {
        return getKey(e);
    }

    /**
     * Find the keys.
     * The resulting list may have a DIFFERENT size and sequence.
     */
    public KmList<MyDownload> findUids(KmList<String> uids)
    {
        return findUids(uids, false);
    }

    /**
     * Find the keys.
     * The resulting list will have the SAME size and sequence.
     */
    public KmList<MyDownload> findOrderedUids(KmList<String> uids)
    {
        return findUids(uids, true);
    }

    public KmList<MyDownload> findUids(KmList<String> uids, boolean ordered)
    {
        MyDownloadCriteria c;
        c = createCriteria();
        c.whereUid().isIn(uids);
        KmList<MyDownload> v = c.findAll();

        return ordered
            ? v.toOrderedList(uids, e -> e.getUid())
            : v;
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyDownload m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }
}
