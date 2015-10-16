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

public abstract class MySalesOrderDaoBase
    extends KmAbstractDao<MySalesOrder,String>
    implements MySalesOrderDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MySalesOrderDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MySalesOrder> getPersistentClass()
    {
        return MySalesOrder.class;
    }

    @Override
    protected String getTableName()
    {
        return "salesOrder";
    }

    @Override
    public MySalesOrderCriteria createCriteria()
    {
        return new MySalesOrderCriteria(_createCriteria());
    }

    @Override
    public MySalesOrderCriteria createDetachedCriteria(String alias)
    {
        return new MySalesOrderCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaSalesOrder getMeta()
    {
        return MySalesOrder.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MySalesOrder findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MySalesOrder m = findUid(e);

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
