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
import com.kodemore.utility.*;

import com.app.criteria.*;
import com.app.dao.core.*;
import com.app.filter.*;
import com.app.model.*;
import com.app.model.meta.*;

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
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);
            
        delete(m);
    }

}
