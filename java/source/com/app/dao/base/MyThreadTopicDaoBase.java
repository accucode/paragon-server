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

public abstract class MyThreadTopicDaoBase
    extends MyAbstractDao<MyThreadTopic,String>
    implements MyThreadTopicDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyThreadTopicDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyThreadTopic> getPersistentClass()
    {
        return MyThreadTopic.class;
    }

    @Override
    protected String getTableName()
    {
        return "threadTopic";
    }

    @Override
    public MyThreadTopicCriteria createCriteria()
    {
        return new MyThreadTopicCriteria(_createCriteria());
    }

    @Override
    public MyThreadTopicCriteria createDetachedCriteria(String alias)
    {
        return new MyThreadTopicCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaThreadTopic getMeta()
    {
        return MyThreadTopic.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyThreadTopic findCode(String e)
    {
        return getKey(e);
    }

    /**
     * Find the keys.
     * The resulting list may have a DIFFERENT size and sequence.
     */
    public KmList<MyThreadTopic> findCodes(KmList<String> codes)
    {
        return findCodes(codes, false);
    }

    /**
     * Find the keys.
     * The resulting list will have the SAME size and sequence.
     */
    public KmList<MyThreadTopic> findOrderedCodes(KmList<String> codes)
    {
        return findCodes(codes, true);
    }

    public KmList<MyThreadTopic> findCodes(KmList<String> codes, boolean ordered)
    {
        MyThreadTopicCriteria c;
        c = createCriteria();
        c.whereCode().isIn(codes);
        KmList<MyThreadTopic> v = c.findAll();

        return ordered
            ? v.toOrderedList(codes, e -> e.getCode())
            : v;
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteCode(String e)
    {
        MyThreadTopic m = findCode(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }
}
