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

public abstract class MySalesOrderContactDaoBase
    extends KmAbstractDao<MySalesOrderContact,String>
    implements MySalesOrderContactDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MySalesOrderContactDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MySalesOrderContact> getPersistentClass()
    {
        return MySalesOrderContact.class;
    }

    @Override
    protected String getTableName()
    {
        return "salesOrderContact";
    }

    @Override
    public MySalesOrderContactCriteria createCriteria()
    {
        return new MySalesOrderContactCriteria(_createCriteria());
    }

    @Override
    public MySalesOrderContactCriteria createDetachedCriteria(String alias)
    {
        return new MySalesOrderContactCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaSalesOrderContact getMeta()
    {
        return MySalesOrderContact.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MySalesOrderContact findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MySalesOrderContact m = findUid(e);

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
