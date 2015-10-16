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

public abstract class MyAuditLogDaoBase
    extends KmAbstractDao<MyAuditLog,String>
    implements MyAuditLogDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyAuditLogDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyAuditLog> getPersistentClass()
    {
        return MyAuditLog.class;
    }

    @Override
    protected String getTableName()
    {
        return "auditLog";
    }

    @Override
    public MyAuditLogCriteria createCriteria()
    {
        return new MyAuditLogCriteria(_createCriteria());
    }

    @Override
    public MyAuditLogCriteria createDetachedCriteria(String alias)
    {
        return new MyAuditLogCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaAuditLog getMeta()
    {
        return MyAuditLog.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyAuditLog findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyAuditLog m = findUid(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }

    //##################################################
    //# convenience
    //##################################################

    protected MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
}
