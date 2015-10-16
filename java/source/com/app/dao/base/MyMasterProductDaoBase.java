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

public abstract class MyMasterProductDaoBase
    extends KmAbstractDao<MyMasterProduct,String>
    implements MyMasterProductDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyMasterProductDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyMasterProduct> getPersistentClass()
    {
        return MyMasterProduct.class;
    }

    @Override
    protected String getTableName()
    {
        return "masterProduct";
    }

    @Override
    public MyMasterProductCriteria createCriteria()
    {
        return new MyMasterProductCriteria(_createCriteria());
    }

    @Override
    public MyMasterProductCriteria createDetachedCriteria(String alias)
    {
        return new MyMasterProductCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaMasterProduct getMeta()
    {
        return MyMasterProduct.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyMasterProduct findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyMasterProduct m = findUid(e);

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
