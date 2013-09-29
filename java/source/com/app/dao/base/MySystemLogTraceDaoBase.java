//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.dao.base;

import com.app.criteria.MySystemLogTraceCriteria;
import com.app.model.MySystemLogTrace;
import com.app.model.meta.MyMetaSystemLogTrace;

import com.kodemore.dao.KmAbstractDao;

public abstract class MySystemLogTraceDaoBase
    extends KmAbstractDao<MySystemLogTrace,Integer>
    implements MySystemLogTraceDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MySystemLogTraceDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MySystemLogTrace> getPersistentClass()
    {
        return MySystemLogTrace.class;
    }

    @Override
    protected String getTableName()
    {
        return "systemLogTrace";
    }

    @Override
    public MySystemLogTraceCriteria createCriteria()
    {
        return new MySystemLogTraceCriteria(createGenericCriteria());
    }

    protected MyMetaSystemLogTrace getMeta()
    {
        return MySystemLogTrace.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MySystemLogTrace findId(Integer e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteId(Integer e)
    {
        MySystemLogTrace m = findId(e);
        if ( m == null )
            fatal("Cannot delete; key not found(%s).", e);
        delete(m);
    }

}
