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

public abstract class MyApplicationLogDaoBase
    extends KmAbstractDao<MyApplicationLog,Integer>
    implements MyApplicationLogDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyApplicationLogDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyApplicationLog> getPersistentClass()
    {
        return MyApplicationLog.class;
    }

    @Override
    protected String getTableName()
    {
        return "applicationLog";
    }

    @Override
    public MyApplicationLogCriteria createCriteria()
    {
        return new MyApplicationLogCriteria(createGenericCriteria());
    }

    protected MyMetaApplicationLog getMeta()
    {
        return MyApplicationLog.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyApplicationLog findId(Integer e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteId(Integer e)
    {
        MyApplicationLog m = findId(e);
        
        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);
            
        delete(m);
    }

}
