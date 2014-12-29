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
            fatal("Cannot delete; key not found(%s).", e);
        delete(m);
    }

}
