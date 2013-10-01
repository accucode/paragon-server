//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.dao.base;

import com.app.criteria.MyPerformanceLogCriteria;
import com.app.model.MyPerformanceLog;
import com.app.model.meta.MyMetaPerformanceLog;

import com.kodemore.dao.KmAbstractDao;

public abstract class MyPerformanceLogDaoBase
    extends KmAbstractDao<MyPerformanceLog,Integer>
    implements MyPerformanceLogDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyPerformanceLogDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyPerformanceLog> getPersistentClass()
    {
        return MyPerformanceLog.class;
    }

    @Override
    protected String getTableName()
    {
        return "performanceLog";
    }

    @Override
    public MyPerformanceLogCriteria createCriteria()
    {
        return new MyPerformanceLogCriteria(createGenericCriteria());
    }

    protected MyMetaPerformanceLog getMeta()
    {
        return MyPerformanceLog.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyPerformanceLog findId(Integer e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteId(Integer e)
    {
        MyPerformanceLog m = findId(e);
        if ( m == null )
            fatal("Cannot delete; key not found(%s).", e);
        delete(m);
    }

}
