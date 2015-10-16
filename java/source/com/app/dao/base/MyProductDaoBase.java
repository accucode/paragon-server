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

public abstract class MyProductDaoBase
    extends KmAbstractDao<MyProduct,String>
    implements MyProductDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyProductDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyProduct> getPersistentClass()
    {
        return MyProduct.class;
    }

    @Override
    protected String getTableName()
    {
        return "product";
    }

    @Override
    public MyProductCriteria createCriteria()
    {
        return new MyProductCriteria(_createCriteria());
    }

    @Override
    public MyProductCriteria createDetachedCriteria(String alias)
    {
        return new MyProductCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaProduct getMeta()
    {
        return MyProduct.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyProduct findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyProduct m = findUid(e);

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
