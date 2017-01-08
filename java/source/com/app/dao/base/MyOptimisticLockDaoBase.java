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

public abstract class MyOptimisticLockDaoBase
    extends KmAbstractDao<MyOptimisticLock,String>
    implements MyOptimisticLockDaoConstantsIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyOptimisticLockDaoBase()
    {
        super();
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected Class<MyOptimisticLock> getPersistentClass()
    {
        return MyOptimisticLock.class;
    }

    @Override
    protected String getTableName()
    {
        return "optimisticLock";
    }

    @Override
    public MyOptimisticLockCriteria createCriteria()
    {
        return new MyOptimisticLockCriteria(_createCriteria());
    }

    @Override
    public MyOptimisticLockCriteria createDetachedCriteria(String alias)
    {
        return new MyOptimisticLockCriteria(_createDetachedCriteria(alias));
    }

    protected MyMetaOptimisticLock getMeta()
    {
        return MyOptimisticLock.Meta;
    }

    //##################################################
    //# find
    //##################################################

    public MyOptimisticLock findName(String e)
    {
        return getKey(e);
    }

    //##################################################
    //# delete
    //##################################################

    public void deleteName(String e)
    {
        MyOptimisticLock m = findName(e);

        if ( m == null )
            throw Kmu.newFatal("Cannot delete; key not found(%s).", e);

        delete(m);
    }

    //##################################################
    //# convenience
    //##################################################

    protected MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }
}
