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

public abstract class MyEmailTemplateDaoBase
    extends MyAbstractDao<MyEmailTemplate,String>
    implements MyEmailTemplateDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyEmailTemplateDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyEmailTemplate> getPersistentClass()
    {
        return MyEmailTemplate.class;
    }

    @Override
    protected String getTableName()
    {
        return "emailTemplate";
    }

    @Override
    public MyEmailTemplateCriteria createCriteria()
    {
        return new MyEmailTemplateCriteria(_createCriteria());
    }

    @Override
    public MyEmailTemplateCriteria createDetachedCriteria(String alias)
    {
        return new MyEmailTemplateCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaEmailTemplate getMeta()
    {
        return MyEmailTemplate.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyEmailTemplate findUid(String e)
    {
        return getKey(e);
    }

    /**
     * Find the keys.
     * The resulting list may have a DIFFERENT size and sequence.
     */
    public KmList<MyEmailTemplate> findUids(KmList<String> uids)
    {
        return findUids(uids, false);
    }

    /**
     * Find the keys.
     * The resulting list will have the SAME size and sequence.
     */
    public KmList<MyEmailTemplate> findOrderedUids(KmList<String> uids)
    {
        return findUids(uids, true);
    }

    public KmList<MyEmailTemplate> findUids(KmList<String> uids, boolean ordered)
    {
        MyEmailTemplateCriteria c;
        c = createCriteria();
        c.whereUid().isIn(uids);
        KmList<MyEmailTemplate> v = c.findAll();

        return ordered
            ? v.toOrderedList(uids, e -> e.getUid())
            : v;
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyEmailTemplate m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }
}
