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

public abstract class MyFilterTemplateDaoBase
    extends MyAbstractDao<MyFilterTemplate,String>
    implements MyFilterTemplateDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyFilterTemplateDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyFilterTemplate> getPersistentClass()
    {
        return MyFilterTemplate.class;
    }

    @Override
    protected String getTableName()
    {
        return "filterTemplate";
    }

    @Override
    public MyFilterTemplateCriteria createCriteria()
    {
        return new MyFilterTemplateCriteria(_createCriteria());
    }

    @Override
    public MyFilterTemplateCriteria createDetachedCriteria(String alias)
    {
        return new MyFilterTemplateCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaFilterTemplate getMeta()
    {
        return MyFilterTemplate.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyFilterTemplate findUid(String e)
    {
        return getKey(e);
    }

    /**
     * Find the keys.
     * The resulting list may have a DIFFERENT size and sequence.
     */
    public KmList<MyFilterTemplate> findUids(KmList<String> uids)
    {
        return findUids(uids, false);
    }

    /**
     * Find the keys.
     * The resulting list will have the SAME size and sequence.
     */
    public KmList<MyFilterTemplate> findOrderedUids(KmList<String> uids)
    {
        return findUids(uids, true);
    }

    public KmList<MyFilterTemplate> findUids(KmList<String> uids, boolean ordered)
    {
        MyFilterTemplateCriteria c;
        c = createCriteria();
        c.whereUid().isIn(uids);
        KmList<MyFilterTemplate> v = c.findAll();

        return ordered
            ? v.toOrderedList(uids, e -> e.getUid())
            : v;
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyFilterTemplate m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }
}
