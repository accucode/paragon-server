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

import com.app.criteria.MyDepotCriteria;
import com.app.model.MyDepot;
import com.app.model.meta.MyMetaDepot;

public abstract class MyDepotDaoBase
    extends KmAbstractDao<MyDepot,String>
    implements MyDepotDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyDepotDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyDepot> getPersistentClass()
    {
        return MyDepot.class;
    }

    @Override
    protected String getTableName()
    {
        return "depot";
    }

    @Override
    public MyDepotCriteria createCriteria()
    {
        return new MyDepotCriteria(createGenericCriteria());
    }

    protected MyMetaDepot getMeta()
    {
        return MyDepot.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyDepot findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyDepot m = findUid(e);
        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);
        delete(m);
    }

}
