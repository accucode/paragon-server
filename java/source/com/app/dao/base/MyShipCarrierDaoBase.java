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
        return new MyShipCarrierCriteria(createGenericCriteria());
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

}
