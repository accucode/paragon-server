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
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.meta.*;
import com.app.utility.*;

public abstract class MyThreadTopicDaoBase
    extends KmAbstractDao<MyThreadTopic,String>
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

    //##################################################
    //# convenience
    //##################################################

    protected MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }
}
