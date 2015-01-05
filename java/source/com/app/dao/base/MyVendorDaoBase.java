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

import com.app.criteria.MyVendorCriteria;
import com.app.model.MyVendor;
import com.app.model.meta.MyMetaVendor;

public abstract class MyVendorDaoBase
    extends KmAbstractDao<MyVendor,String>
    implements MyVendorDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyVendorDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyVendor> getPersistentClass()
    {
        return MyVendor.class;
    }

    @Override
    protected String getTableName()
    {
        return "vendor";
    }

    @Override
    public MyVendorCriteria createCriteria()
    {
        return new MyVendorCriteria(createGenericCriteria());
    }

    protected MyMetaVendor getMeta()
    {
        return MyVendor.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyVendor findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyVendor m = findUid(e);
        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);
        delete(m);
    }

}
