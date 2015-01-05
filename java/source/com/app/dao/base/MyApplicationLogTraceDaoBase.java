//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.dao.base;

import com.kodemore.dao.KmAbstractDao;
import com.kodemore.utility.Kmu;

import com.app.criteria.MyApplicationLogTraceCriteria;
import com.app.model.MyApplicationLogTrace;
import com.app.model.meta.MyMetaApplicationLogTrace;

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
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }

}
