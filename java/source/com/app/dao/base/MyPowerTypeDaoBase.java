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

public abstract class MyPowerTypeDaoBase
    extends KmAbstractDao<MyPowerType,String>
    implements MyPowerTypeDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyPowerTypeDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyPowerType> getPersistentClass()
    {
        return MyPowerType.class;
    }

    @Override
    protected String getTableName()
    {
        return "powerType";
    }

    @Override
    public MyPowerTypeCriteria createCriteria()
    {
        return new MyPowerTypeCriteria(createGenericCriteria());
    }

    protected MyMetaPowerType getMeta()
    {
        return MyPowerType.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyPowerType findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyPowerType m = findUid(e);
        
        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);
            
        delete(m);
    }

}
