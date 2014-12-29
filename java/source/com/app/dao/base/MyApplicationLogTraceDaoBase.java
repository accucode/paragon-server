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
import com.kodemore.hibernate.*;
import com.kodemore.hibernate.criteria.*;

import com.app.criteria.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.meta.*;

public abstract class MyApplicationLogTraceDaoBase
    extends KmAbstractDao<MyApplicationLogTrace,Integer>
    implements MyApplicationLogTraceDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyApplicationLogTraceDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyApplicationLogTrace> getPersistentClass()
    {
        return MyApplicationLogTrace.class;
    }

    @Override
    protected String getTableName()
    {
        return "applicationLogTrace";
    }

    @Override
    public MyApplicationLogTraceCriteria createCriteria()
    {
        return new MyApplicationLogTraceCriteria(createGenericCriteria());
    }

    protected MyMetaApplicationLogTrace getMeta()
    {
        return MyApplicationLogTrace.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyApplicationLogTrace findId(Integer e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteId(Integer e)
    {
        MyApplicationLogTrace m = findId(e);
        if ( m == null )
            fatal("Cannot delete; key not found(%s).", e);
        delete(m);
    }

}
