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

public abstract class MyShipmentDaoBase
    extends KmAbstractDao<MyShipment,String>
    implements MyShipmentDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyShipmentDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyShipment> getPersistentClass()
    {
        return MyShipment.class;
    }

    @Override
    protected String getTableName()
    {
        return "shipment";
    }

    @Override
    public MyShipmentCriteria createCriteria()
    {
        return new MyShipmentCriteria(_createCriteria());
    }

    @Override
    public MyShipmentCriteria createDetachedCriteria(String alias)
    {
        return new MyShipmentCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaShipment getMeta()
    {
        return MyShipment.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyShipment findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyShipment m = findUid(e);

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
