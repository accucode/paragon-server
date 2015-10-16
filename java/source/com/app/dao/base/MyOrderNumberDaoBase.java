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

public abstract class MyOrderNumberDaoBase
    extends KmAbstractDao<MyOrderNumber,String>
    implements MyOrderNumberDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyOrderNumberDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyOrderNumber> getPersistentClass()
    {
        return MyOrderNumber.class;
    }

    @Override
    protected String getTableName()
    {
        return "orderNumber";
    }

    @Override
    public MyOrderNumberCriteria createCriteria()
    {
        return new MyOrderNumberCriteria(_createCriteria());
    }

    @Override
    public MyOrderNumberCriteria createDetachedCriteria(String alias)
    {
        return new MyOrderNumberCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaOrderNumber getMeta()
    {
        return MyOrderNumber.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyOrderNumber findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyOrderNumber m = findUid(e);

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
