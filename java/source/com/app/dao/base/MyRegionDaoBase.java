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
        return new MyRegionCriteria(_createCriteria());
    }

    @Override
    public MyRegionCriteria createDetachedCriteria(String alias)
    {
        return new MyRegionCriteria(_createDetachedCriteria(alias));
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
