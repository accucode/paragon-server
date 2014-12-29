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
        return new MyProductCriteria(createGenericCriteria());
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
            fatal("Cannot delete; key not found(%s).", e);
        delete(m);
    }

}
