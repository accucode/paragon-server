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

public abstract class MyFilterTemplateItemDaoBase
    extends MyAbstractDao<MyFilterTemplateItem,String>
    implements MyFilterTemplateItemDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyFilterTemplateItemDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyFilterTemplateItem> getPersistentClass()
    {
        return MyFilterTemplateItem.class;
    }

    @Override
    protected String getTableName()
    {
        return "filterTemplateItem";
    }

    @Override
    public MyFilterTemplateItemCriteria createCriteria()
    {
        return new MyFilterTemplateItemCriteria(_createCriteria());
    }

    @Override
    public MyFilterTemplateItemCriteria createDetachedCriteria(String alias)
    {
        return new MyFilterTemplateItemCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaFilterTemplateItem getMeta()
    {
        return MyFilterTemplateItem.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyFilterTemplateItem findUid(String e)
    {
        return getKey(e);
    }

    /**
     * Find the keys.
     * The resulting list may have a DIFFERENT size and sequence.
     */
    public KmList<MyFilterTemplateItem> findUids(KmList<String> uids)
    {
        return findUids(uids, false);
    }

    /**
     * Find the keys.
     * The resulting list will have the SAME size and sequence.
     */
    public KmList<MyFilterTemplateItem> findOrderedUids(KmList<String> uids)
    {
        return findUids(uids, true);
    }

    public KmList<MyFilterTemplateItem> findUids(KmList<String> uids, boolean ordered)
    {
        MyFilterTemplateItemCriteria c;
        c = createCriteria();
        c.whereUid().isIn(uids);
        KmList<MyFilterTemplateItem> v = c.findAll();

        return ordered
            ? v.toOrderedList(uids, e -> e.getUid())
            : v;
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyFilterTemplateItem m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }
}
