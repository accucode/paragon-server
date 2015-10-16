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

public abstract class MyShipCarrierDaoBase
    extends KmAbstractDao<MyShipCarrier,String>
    implements MyShipCarrierDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyShipCarrierDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyShipCarrier> getPersistentClass()
    {
        return MyShipCarrier.class;
    }

    @Override
    protected String getTableName()
    {
        return "shipCarrier";
    }

    @Override
    public MyShipCarrierCriteria createCriteria()
    {
        return new MyShipCarrierCriteria(_createCriteria());
    }

    @Override
    public MyShipCarrierCriteria createDetachedCriteria(String alias)
    {
        return new MyShipCarrierCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaShipCarrier getMeta()
    {
        return MyShipCarrier.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyShipCarrier findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyShipCarrier m = findUid(e);

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
