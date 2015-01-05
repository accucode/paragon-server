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

import com.app.criteria.MyRegionCriteria;
import com.app.model.MyRegion;
import com.app.model.meta.MyMetaRegion;

public abstract class MyRegionDaoBase
    extends KmAbstractDao<MyRegion,String>
    implements MyRegionDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyRegionDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyRegion> getPersistentClass()
    {
        return MyRegion.class;
    }

    @Override
    protected String getTableName()
    {
        return "region";
    }

    @Override
    public MyRegionCriteria createCriteria()
    {
        return new MyRegionCriteria(createGenericCriteria());
    }

    protected MyMetaRegion getMeta()
    {
        return MyRegion.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyRegion findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyRegion m = findUid(e);
        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);
        delete(m);
    }

}
