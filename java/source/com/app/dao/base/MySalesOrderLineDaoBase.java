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

public abstract class MySalesOrderLineDaoBase
    extends KmAbstractDao<MySalesOrderLine,String>
    implements MySalesOrderLineDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MySalesOrderLineDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MySalesOrderLine> getPersistentClass()
    {
        return MySalesOrderLine.class;
    }

    @Override
    protected String getTableName()
    {
        return "salesOrderLine";
    }

    @Override
    public MySalesOrderLineCriteria createCriteria()
    {
        return new MySalesOrderLineCriteria(_createCriteria());
    }

    @Override
    public MySalesOrderLineCriteria createDetachedCriteria(String alias)
    {
        return new MySalesOrderLineCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaSalesOrderLine getMeta()
    {
        return MySalesOrderLine.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MySalesOrderLine findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MySalesOrderLine m = findUid(e);

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
