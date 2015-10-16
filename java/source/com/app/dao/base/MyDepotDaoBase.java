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
        return new MyDepotCriteria(_createCriteria());
    }

    @Override
    public MyDepotCriteria createDetachedCriteria(String alias)
    {
        return new MyDepotCriteria(_createDetachedCriteria(alias));
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

    //##################################################
    //# convenience
    //##################################################

    protected MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
}
