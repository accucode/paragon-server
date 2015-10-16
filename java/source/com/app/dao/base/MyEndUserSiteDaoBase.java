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

public abstract class MyEndUserSiteDaoBase
    extends KmAbstractDao<MyEndUserSite,String>
    implements MyEndUserSiteDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyEndUserSiteDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyEndUserSite> getPersistentClass()
    {
        return MyEndUserSite.class;
    }

    @Override
    protected String getTableName()
    {
        return "endUserSite";
    }

    @Override
    public MyEndUserSiteCriteria createCriteria()
    {
        return new MyEndUserSiteCriteria(_createCriteria());
    }

    @Override
    public MyEndUserSiteCriteria createDetachedCriteria(String alias)
    {
        return new MyEndUserSiteCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaEndUserSite getMeta()
    {
        return MyEndUserSite.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyEndUserSite findUid(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteUid(String e)
    {
        MyEndUserSite m = findUid(e);

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
