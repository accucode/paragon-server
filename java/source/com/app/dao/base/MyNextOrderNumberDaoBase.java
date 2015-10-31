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

public abstract class MyNextOrderNumberDaoBase
    extends KmAbstractDao<MyNextOrderNumber,String>
    implements MyNextOrderNumberDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyNextOrderNumberDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyNextOrderNumber> getPersistentClass()
    {
        return MyNextOrderNumber.class;
    }

    @Override
    protected String getTableName()
    {
        return "nextOrderNumber";
    }

    @Override
    public MyNextOrderNumberCriteria createCriteria()
    {
        return new MyNextOrderNumberCriteria(_createCriteria());
    }

    @Override
    public MyNextOrderNumberCriteria createDetachedCriteria(String alias)
    {
        return new MyNextOrderNumberCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaNextOrderNumber getMeta()
    {
        return MyNextOrderNumber.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyNextOrderNumber findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyNextOrderNumber m = findUid(e);

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
