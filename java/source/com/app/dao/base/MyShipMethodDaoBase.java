//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.dao.base;

import com.kodemore.dao.KmAbstractDao;
import com.kodemore.utility.Kmu;

import com.app.criteria.MyShipMethodCriteria;
import com.app.model.MyShipMethod;
import com.app.model.meta.MyMetaShipMethod;

public abstract class MyShipMethodDaoBase
    extends KmAbstractDao<MyShipMethod,String>
    implements MyShipMethodDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyShipMethodDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyShipMethod> getPersistentClass()
    {
        return MyShipMethod.class;
    }

    @Override
    protected String getTableName()
    {
        return "shipMethod";
    }

    @Override
    public MyShipMethodCriteria createCriteria()
    {
        return new MyShipMethodCriteria(createGenericCriteria());
    }

    protected MyMetaShipMethod getMeta()
    {
        return MyShipMethod.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyShipMethod findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyShipMethod m = findUid(e);
        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);
        delete(m);
    }

}
