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

public abstract class MyProductCategoryDaoBase
    extends KmAbstractDao<MyProductCategory,String>
    implements MyProductCategoryDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyProductCategoryDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyProductCategory> getPersistentClass()
    {
        return MyProductCategory.class;
    }

    @Override
    protected String getTableName()
    {
        return "productCategory";
    }

    @Override
    public MyProductCategoryCriteria createCriteria()
    {
        return new MyProductCategoryCriteria(_createCriteria());
    }

    @Override
    public MyProductCategoryCriteria createDetachedCriteria(String alias)
    {
        return new MyProductCategoryCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaProductCategory getMeta()
    {
        return MyProductCategory.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyProductCategory findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyProductCategory m = findUid(e);

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
