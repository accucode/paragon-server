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

import com.app.criteria.MyPowerTypeCriteria;
import com.app.model.MyPowerType;
import com.app.model.meta.MyMetaPowerType;

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
