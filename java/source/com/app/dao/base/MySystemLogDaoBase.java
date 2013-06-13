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

public abstract class MySystemLogDaoBase
    extends KmAbstractDao<MySystemLog,Integer>
    implements MySystemLogDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MySystemLogDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MySystemLog> getPersistentClass()
    {
        return MySystemLog.class;
    }

    @Override
    protected String getTableName()
    {
        return "systemLog";
    }

    @Override
    public MySystemLogCriteria createCriteria()
    {
        return new MySystemLogCriteria(createGenericCriteria());
    }

    protected MyMetaSystemLog getMeta()
    {
        return MySystemLog.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MySystemLog findId(Integer e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteId(Integer e)
    {
        MySystemLog m = findId(e);
        if ( m == null )
            fatal("Cannot delete; key not found(%s).", e);
        delete(m);
    }

}
