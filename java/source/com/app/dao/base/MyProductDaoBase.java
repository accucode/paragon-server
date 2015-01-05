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

import com.app.criteria.MyProductCriteria;
import com.app.model.MyProduct;
import com.app.model.meta.MyMetaProduct;

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
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);
        delete(m);
    }

}
