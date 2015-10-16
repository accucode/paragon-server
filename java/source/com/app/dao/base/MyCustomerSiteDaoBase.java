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

public abstract class MyCustomerSiteDaoBase
    extends KmAbstractDao<MyCustomerSite,String>
    implements MyCustomerSiteDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyCustomerSiteDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyCustomerSite> getPersistentClass()
    {
        return MyCustomerSite.class;
    }

    @Override
    protected String getTableName()
    {
        return "customerSite";
    }

    @Override
    public MyCustomerSiteCriteria createCriteria()
    {
        return new MyCustomerSiteCriteria(_createCriteria());
    }

    @Override
    public MyCustomerSiteCriteria createDetachedCriteria(String alias)
    {
        return new MyCustomerSiteCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaCustomerSite getMeta()
    {
        return MyCustomerSite.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyCustomerSite findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyCustomerSite m = findUid(e);

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
